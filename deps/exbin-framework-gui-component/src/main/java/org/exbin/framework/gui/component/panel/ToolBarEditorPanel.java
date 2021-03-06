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
package org.exbin.framework.gui.component.panel;

import java.awt.BorderLayout;
import javax.swing.JToolBar;
import org.exbin.framework.gui.menu.GuiMenuModule;
import org.exbin.framework.gui.menu.api.ClipboardActions;
import org.exbin.framework.gui.menu.api.ClipboardActionsHandler;
import org.exbin.framework.gui.menu.api.ClipboardActionsHandlerEmpty;
import org.exbin.framework.gui.undo.GuiUndoModule;
import org.exbin.framework.gui.undo.api.UndoActions;
import org.exbin.framework.gui.undo.api.UndoActionsHandler;
import org.exbin.framework.gui.undo.api.UndoActionsHandlerEmpty;
import org.exbin.framework.gui.utils.GuiUtilsModule;
import org.exbin.framework.gui.utils.TestApplication;
import org.exbin.framework.gui.utils.WindowUtils;

/**
 * Panel with editation toolbar.
 *
 * @version 0.2.1 2017/02/21
 * @author ExBin Project (http://exbin.org)
 */
public class ToolBarEditorPanel extends javax.swing.JPanel {

    private UndoActionsHandler undoHandler = null;
    private ClipboardActionsHandler clipboardHandler = null;
    private JToolBar toolBar = null;

    public ToolBarEditorPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    /**
     * Test method for this panel.
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        TestApplication testApplication = GuiUtilsModule.getDefaultAppEditor();
        GuiUndoModule guiUndoModule = new GuiUndoModule();
        testApplication.addModule(GuiUndoModule.MODULE_ID, guiUndoModule);
        GuiMenuModule guiMenuModule = new GuiMenuModule();
        testApplication.addModule(GuiMenuModule.MODULE_ID, guiMenuModule);

        ToolBarEditorPanel toolBarEditorPanel = new ToolBarEditorPanel();
        UndoActionsHandler undoActionsHandler = new UndoActionsHandlerEmpty();
        toolBarEditorPanel.setUndoHandler(undoActionsHandler, guiUndoModule.createUndoActions(undoActionsHandler));
        ClipboardActionsHandler clipboardActionsHandler = new ClipboardActionsHandlerEmpty();
        toolBarEditorPanel.setClipboardHandler(clipboardActionsHandler, guiMenuModule.createClipboardActions(clipboardActionsHandler));
        WindowUtils.invokeDialog(toolBarEditorPanel);
    }

    public void setUndoHandler(UndoActionsHandler undoHandler, UndoActions undoActions) {
        this.undoHandler = undoHandler;
        initToolBar();
        toolBar.add(undoActions.getUndoAction());
        toolBar.add(undoActions.getRedoAction());
        undoActions.updateUndoActions();
    }

    public void setClipboardHandler(ClipboardActionsHandler clipboardHandler, ClipboardActions clipboardActions) {
        this.clipboardHandler = clipboardHandler;
        initToolBar();
        if (undoHandler != null) {
            toolBar.addSeparator();
        }
        toolBar.add(clipboardActions.getCutAction());
        toolBar.add(clipboardActions.getCopyAction());
        toolBar.add(clipboardActions.getPasteAction());
        clipboardActions.updateClipboardActions();
    }

    private void initToolBar() {
        if (toolBar == null) {
            toolBar = new JToolBar();
            toolBar.setFloatable(false);
            add(toolBar, BorderLayout.NORTH);
        }
    }
}
