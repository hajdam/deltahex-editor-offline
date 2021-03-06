/*
 * Copyright (C) ExBin Project
 *
 * This application or library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * This application or library is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along this application.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.exbin.framework.deltahex;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;
import org.exbin.deltahex.delta.SegmentsRepository;
import org.exbin.deltahex.operation.BinaryDataCommand;
import org.exbin.deltahex.operation.BinaryDataOperationException;
import org.exbin.deltahex.operation.undo.BinaryDataUndoHandler;
import org.exbin.deltahex.operation.undo.BinaryDataUndoUpdateListener;
import org.exbin.framework.deltahex.panel.HexColorType;
import org.exbin.framework.deltahex.panel.HexPanel;
import org.exbin.framework.deltahex.panel.ReplaceParameters;
import org.exbin.framework.deltahex.panel.SearchParameters;
import org.exbin.framework.editor.text.TextEncodingStatusApi;
import org.exbin.framework.gui.docking.api.EditorViewHandling;
import org.exbin.framework.gui.editor.api.EditorProvider;
import org.exbin.framework.gui.editor.api.MultiEditorProvider;
import org.exbin.framework.gui.file.api.FileHandlerApi;
import org.exbin.framework.gui.file.api.FileType;
import org.exbin.framework.gui.menu.api.ClipboardActionsHandler;
import org.exbin.framework.gui.menu.api.ClipboardActionsUpdateListener;

/**
 * Hexadecimal editor provider.
 *
 * @version 0.2.0 2017/01/05
 * @author ExBin Project (http://exbin.org)
 */
public class HexEditorHandler implements HexEditorProvider, MultiEditorProvider, ClipboardActionsHandler {

    private HexPanelInit hexPanelInit = null;
    private final List<HexPanel> panels = new ArrayList<>();
    private EditorViewHandling editorViewHandling = null;
    private SegmentsRepository segmentsRepository;
    private HexPanel activePanel = null;
    private int lastIndex = 0;
    private HexStatusApi hexStatus = null;
    private TextEncodingStatusApi encodingStatus;
    private EditorModificationListener editorModificationListener = null;
    private final EditorModificationListener multiModificationListener;
    private final List<BinaryDataUndoUpdateListener> undoListeners = new ArrayList<>();
    private final BinaryDataUndoUpdateListener multiUndoUpdateListener;
    private ClipboardActionsUpdateListener clipboardUpdateListener = null;
    private final ClipboardActionsUpdateListener multiClipboardUpdateListener;

    public HexEditorHandler() {
        multiModificationListener = new EditorModificationListener() {
            @Override
            public void modified() {
                if (editorModificationListener != null) {
                    editorModificationListener.modified();
                }
                if (editorViewHandling != null) {
                    editorViewHandling.updateEditorView(activePanel);
                }
            }
        };

        multiUndoUpdateListener = new BinaryDataUndoUpdateListener() {
            @Override
            public void undoCommandPositionChanged() {
                notifyUndoChanged();
            }

            @Override
            public void undoCommandAdded(BinaryDataCommand cmnd) {
                for (BinaryDataUndoUpdateListener listener : undoListeners) {
                    listener.undoCommandAdded(cmnd);
                }
            }
        };

        multiClipboardUpdateListener = new ClipboardActionsUpdateListener() {
            @Override
            public void stateChanged() {
                notifyClipboardStateChanged();
            }
        };
    }

    @Override
    public JPanel getPanel() {
        return activePanel.getPanel();
    }

    @Override
    public void setPropertyChangeListener(final PropertyChangeListener propertyChangeListener) {
        activePanel.setPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                editorViewHandling.addEditorView(activePanel);
                propertyChangeListener.propertyChange(evt);
            }
        });
    }

    @Override
    public String getWindowTitle(String frameTitle) {
        return activePanel.getWindowTitle(frameTitle);
    }

    @Override
    public void loadFromFile(URI fileUri, FileType fileType) {
        HexPanel panel = createNewPanel();
        panel.newFile();
        panel.loadFromFile(fileUri, fileType);
        editorViewHandling.updateEditorView(panel);
        activePanel = panel;
    }

    @Override
    public void saveToFile(URI fileUri, FileType fileType) {
        activePanel.saveToFile(fileUri, fileType);
        editorViewHandling.updateEditorView(activePanel);
    }

    @Override
    public URI getFileUri() {
        return activePanel.getFileUri();
    }

    @Override
    public String getFileName() {
        return activePanel.getName();
    }

    @Override
    public FileType getFileType() {
        return activePanel.getFileType();
    }

    @Override
    public void setFileType(FileType fileType) {
        activePanel.setFileType(fileType);
    }

    @Override
    public void newFile() {
        HexPanel panel = createNewPanel();
        panel.newFile();
        activePanel = panel;
    }

    @Override
    public boolean isModified() {
        return activePanel.isModified();
    }

    @Override
    public void registerHexStatus(HexStatusApi hexStatusApi) {
        this.hexStatus = hexStatusApi;
        if (!panels.isEmpty()) {
            for (HexPanel panel : panels) {
                panel.registerHexStatus(hexStatusApi);
            }
        }
    }

    @Override
    public void registerEncodingStatus(TextEncodingStatusApi encodingStatusApi) {
        this.encodingStatus = encodingStatusApi;
        if (!panels.isEmpty()) {
            for (HexPanel panel : panels) {
                panel.registerEncodingStatus(encodingStatusApi);
            }
        }
    }

    public void setSegmentsRepository(SegmentsRepository segmentsRepository) {
        this.segmentsRepository = segmentsRepository;
    }

    private synchronized HexPanel createNewPanel() {
        HexPanel panel = new HexPanel(lastIndex);
        panel.setSegmentsRepository(segmentsRepository);
        lastIndex++;
        panels.add(panel);
        if (hexPanelInit != null) {
            hexPanelInit.init(panel);
        }
        if (hexStatus != null) {
            panel.registerHexStatus(hexStatus);
            panel.registerEncodingStatus(encodingStatus);
        }
        editorViewHandling.addEditorView(panel);
        panel.setModificationListener(multiModificationListener);
        panel.getHexUndoHandler().addUndoUpdateListener(multiUndoUpdateListener);
        panel.setUpdateListener(multiClipboardUpdateListener);

        return panel;
    }

    public void init() {
        activePanel = createNewPanel();
        activePanel.newFile();
    }

    public HexPanelInit getHexPanelInit() {
        return hexPanelInit;
    }

    public void setHexPanelInit(HexPanelInit hexPanelInit) {
        this.hexPanelInit = hexPanelInit;
    }

    public EditorViewHandling getEditorViewHandling() {
        return editorViewHandling;
    }

    public void setEditorViewHandling(EditorViewHandling editorViewHandling) {
        this.editorViewHandling = editorViewHandling;
        editorViewHandling.setMultiEditorProvider(this);
    }

    @Override
    public Map<HexColorType, Color> getCurrentColors() {
        return activePanel.getCurrentColors();
    }

    @Override
    public Map<HexColorType, Color> getDefaultColors() {
        return activePanel.getDefaultColors();
    }

    @Override
    public void setCurrentColors(Map<HexColorType, Color> colors) {
        activePanel.setCurrentColors(colors);
    }

    @Override
    public boolean isWordWrapMode() {
        return activePanel.getCodeArea().isWrapMode();
    }

    @Override
    public void setWordWrapMode(boolean mode) {
        activePanel.getCodeArea().setWrapMode(mode);
    }

    @Override
    public Charset getCharset() {
        return activePanel.getCharset();
    }

    @Override
    public void setCharset(Charset charset) {
        activePanel.setCharset(charset);
    }

    @Override
    public void performFind(SearchParameters searchParameters) {
        activePanel.performFind(searchParameters);
    }

    @Override
    public void performReplace(SearchParameters searchParameters, ReplaceParameters replaceParameters) {
        activePanel.performReplace(searchParameters, replaceParameters);
    }

    @Override
    public boolean changeShowNonprintables() {
        return activePanel.changeShowNonprintables();
    }

    @Override
    public boolean changeLineWrap() {
        return activePanel.changeLineWrap();
    }

    @Override
    public void showValuesPanel() {
        activePanel.showValuesPanel();
    }

    @Override
    public void hideValuesPanel() {
        activePanel.hideValuesPanel();
    }

    @Override
    public boolean isValuesPanelVisible() {
        return activePanel.isValuesPanelVisible();
    }

    @Override
    public HexPanel getDocument() {
        return activePanel;
    }

    @Override
    public void printFile() {
        activePanel.printFile();
    }

    @Override
    public void setActiveEditor(EditorProvider editorProvider) {
        if (editorProvider instanceof HexPanel) {
            HexPanel hexPanel = (HexPanel) editorProvider;
            activePanel = hexPanel;
            hexPanel.notifyListeners();
            notifyUndoChanged();
            notifyClipboardStateChanged();
        }
    }

    @Override
    public void closeFile() {
        closeFile(activePanel);
    }

    @Override
    public void closeFile(FileHandlerApi panel) {
        panels.remove((HexPanel) panel);
        editorViewHandling.removeEditorView((EditorProvider) panel);
    }

    @Override
    public void setModificationListener(EditorModificationListener editorModificationListener) {
        this.editorModificationListener = editorModificationListener;
    }

    @Override
    public BinaryDataUndoHandler getHexUndoHandler() {
        return new BinaryDataUndoHandler() {
            @Override
            public boolean canRedo() {
                return activePanel.getHexUndoHandler().canRedo();
            }

            @Override
            public boolean canUndo() {
                return activePanel.getHexUndoHandler().canUndo();
            }

            @Override
            public void clear() {
                activePanel.getHexUndoHandler().clear();
            }

            @Override
            public void doSync() throws BinaryDataOperationException {
                activePanel.getHexUndoHandler().doSync();
            }

            @Override
            public void execute(BinaryDataCommand cmnd) throws BinaryDataOperationException {
                activePanel.getHexUndoHandler().execute(cmnd);
            }

            @Override
            public void addCommand(BinaryDataCommand cmnd) {
                activePanel.getHexUndoHandler().addCommand(cmnd);
            }

            @Override
            public List<BinaryDataCommand> getCommandList() {
                return activePanel.getHexUndoHandler().getCommandList();
            }

            @Override
            public long getCommandPosition() {
                return activePanel.getHexUndoHandler().getCommandPosition();
            }

            @Override
            public long getMaximumUndo() {
                return activePanel.getHexUndoHandler().getMaximumUndo();
            }

            @Override
            public long getSyncPoint() {
                return activePanel.getHexUndoHandler().getSyncPoint();
            }

            @Override
            public long getUndoMaximumSize() {
                return activePanel.getHexUndoHandler().getUndoMaximumSize();
            }

            @Override
            public long getUsedSize() {
                return activePanel.getHexUndoHandler().getUsedSize();
            }

            @Override
            public void performRedo() throws BinaryDataOperationException {
                activePanel.getHexUndoHandler().performRedo();
            }

            @Override
            public void performRedo(int i) throws BinaryDataOperationException {
                activePanel.getHexUndoHandler().performRedo(i);
            }

            @Override
            public void performUndo() throws BinaryDataOperationException {
                activePanel.getHexUndoHandler().performUndo();
            }

            @Override
            public void performUndo(int i) throws BinaryDataOperationException {
                activePanel.getHexUndoHandler().performUndo(i);
            }

            @Override
            public void setCommandPosition(long l) throws BinaryDataOperationException {
                activePanel.getHexUndoHandler().setCommandPosition(l);
            }

            @Override
            public void setSyncPoint(long l) {
                activePanel.getHexUndoHandler().setSyncPoint(l);
            }

            @Override
            public void setSyncPoint() {
                activePanel.getHexUndoHandler().setSyncPoint();
            }

            @Override
            public void addUndoUpdateListener(BinaryDataUndoUpdateListener xl) {
                undoListeners.add(xl);
            }

            @Override
            public void removeUndoUpdateListener(BinaryDataUndoUpdateListener xl) {
                undoListeners.remove(xl);
            }
        };
    }

    private void notifyUndoChanged() {
        for (BinaryDataUndoUpdateListener listener : undoListeners) {
            listener.undoCommandPositionChanged();
        }
        if (editorViewHandling != null) {
            editorViewHandling.updateEditorView(activePanel);
        }
    }

    private void notifyClipboardStateChanged() {
        if (clipboardUpdateListener != null) {
            clipboardUpdateListener.stateChanged();
        }
    }

    @Override
    public void performCut() {
        activePanel.performCut();
    }

    @Override
    public void performCopy() {
        activePanel.performCopy();
    }

    @Override
    public void performPaste() {
        activePanel.performPaste();
    }

    @Override
    public void performDelete() {
        activePanel.performDelete();
    }

    @Override
    public void performSelectAll() {
        activePanel.performSelectAll();
    }

    @Override
    public boolean isSelection() {
        return activePanel.isSelection();
    }

    @Override
    public boolean isEditable() {
        return activePanel.isEditable();
    }

    @Override
    public boolean canSelectAll() {
        return activePanel.canSelectAll();
    }

    @Override
    public boolean canPaste() {
        return activePanel.canPaste();
    }

    @Override
    public void setUpdateListener(ClipboardActionsUpdateListener updateListener) {
        this.clipboardUpdateListener = updateListener;
    }

    /**
     * Method for initialization of new hexadecimal panel.
     */
    public static interface HexPanelInit {

        void init(HexPanel panel);
    }
}
