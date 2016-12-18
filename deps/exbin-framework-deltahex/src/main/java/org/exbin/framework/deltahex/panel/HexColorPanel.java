/*
 * Copyright (C) ExBin Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.exbin.framework.deltahex.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import org.exbin.deltahex.SelectionRange;
import org.exbin.deltahex.swing.CodeArea;
import org.exbin.framework.gui.options.api.OptionsPanel;
import org.exbin.framework.gui.options.api.OptionsPanel.ModifiedOptionListener;
import org.exbin.framework.gui.options.api.OptionsPanel.PathItem;
import org.exbin.framework.gui.utils.LanguageUtils;
import org.exbin.utils.binary_data.ByteArrayEditableData;

/**
 * Hexadecimal code editor color selection panel.
 *
 * @version 0.1.0 2016/06/23
 * @author ExBin Project (http://exbin.org)
 */
public class HexColorPanel extends javax.swing.JPanel implements OptionsPanel {

    private ModifiedOptionListener modifiedOptionListener;
    private final ResourceBundle resourceBundle = LanguageUtils.getResourceBundleByClass(HexColorPanel.class);
    private final HexColorPanelApi frame;

    private final CodeArea previewCodeArea = new CodeArea();
    private final Map<HexColorType, SelectableColor> selectableColors = new HashMap<>();

    public HexColorPanel(HexColorPanelApi frame) {
        this.frame = frame;
        initComponents();
        init();
    }

    private void init() {
        previewCodeArea.setEditable(false);
        ByteArrayEditableData exampleData = new ByteArrayEditableData();
        try {
            exampleData.loadFromStream(getClass().getResourceAsStream("/org/exbin/framework/deltahex/resources/preview/lorem.txt"));
        } catch (IOException ex) {
            Logger.getLogger(HexColorPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        previewCodeArea.setData(exampleData);
        previewCodeArea.setWrapMode(true);
        previewCodeArea.setEnabled(false);
        previewCodeArea.setShowUnprintableCharacters(true);
        previewCodeArea.setSelection(new SelectionRange(200, 300));
        previewPanel.add(previewCodeArea, BorderLayout.CENTER);

        for (final HexColorType colorType : HexColorType.values()) {
            SelectableColor selectableColor = new SelectableColor(colorType.getTitle());
            selectableColors.put(colorType, selectableColor);
            selectableColor.setColorChangedListener(new SelectableColor.ColorChangedListener() {
                @Override
                public void colorChanged(Color color) {
                    setPreviewColor(colorType, color);
                }
            });
            colorsPanel.add(selectableColor);
        }
    }

    public Color getColor(HexColorType colorType) {
        SelectableColor selectableColor = selectableColors.get(colorType);
        if (selectableColor != null) {
            return selectableColor.getColor();
        }

        return null;
    }

    public void setColor(HexColorType colorType, Color color) {
        SelectableColor selectableColor = selectableColors.get(colorType);
        if (selectableColor != null) {
            selectableColor.setColor(color);
        }
    }

    private void setPreviewColor(HexColorType colorType, Color color) {
        colorType.setColorToCodeArea(previewCodeArea, color);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        for (SelectableColor selectableColor : selectableColors.values()) {
            selectableColor.setEnabled(enabled);
        }
        fillCurrentButton.setEnabled(enabled);
        fillDefaultButton.setEnabled(enabled);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitPane = new javax.swing.JSplitPane();
        colorsScrollPane = new javax.swing.JScrollPane();
        colorsPanel = new javax.swing.JPanel();
        previewPanel = new javax.swing.JPanel();
        previewHeaderPanel = new javax.swing.JPanel();
        previewLabel = new javax.swing.JLabel();
        controlButtonsPanel = new javax.swing.JPanel();
        fillCurrentButton = new javax.swing.JButton();
        fillDefaultButton = new javax.swing.JButton();

        setName("Form"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        splitPane.setName("splitPane"); // NOI18N

        colorsScrollPane.setName("colorsScrollPane"); // NOI18N

        colorsPanel.setName("colorsPanel"); // NOI18N
        colorsPanel.setLayout(new java.awt.GridLayout(21, 1));
        colorsScrollPane.setViewportView(colorsPanel);

        splitPane.setLeftComponent(colorsScrollPane);

        previewPanel.setName("previewPanel"); // NOI18N
        previewPanel.setPreferredSize(new java.awt.Dimension(300, 27));
        previewPanel.setLayout(new java.awt.BorderLayout());

        previewHeaderPanel.setName("previewHeaderPanel"); // NOI18N

        previewLabel.setText(resourceBundle.getString("HexColorPanel.previewLabel.text")); // NOI18N
        previewLabel.setName("previewLabel"); // NOI18N

        javax.swing.GroupLayout previewHeaderPanelLayout = new javax.swing.GroupLayout(previewHeaderPanel);
        previewHeaderPanel.setLayout(previewHeaderPanelLayout);
        previewHeaderPanelLayout.setHorizontalGroup(
            previewHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(previewHeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(previewLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addContainerGap())
        );
        previewHeaderPanelLayout.setVerticalGroup(
            previewHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(previewHeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(previewLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        previewPanel.add(previewHeaderPanel, java.awt.BorderLayout.NORTH);

        splitPane.setRightComponent(previewPanel);

        add(splitPane, java.awt.BorderLayout.CENTER);

        controlButtonsPanel.setName("controlButtonsPanel"); // NOI18N

        fillCurrentButton.setText(resourceBundle.getString("HexColorPanel.fillCurrentButton.text")); // NOI18N
        fillCurrentButton.setName("fillCurrentButton"); // NOI18N
        fillCurrentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillCurrentButtonActionPerformed(evt);
            }
        });

        fillDefaultButton.setText(resourceBundle.getString("HexColorPanel.fillDefaultButton.text")); // NOI18N
        fillDefaultButton.setName("fillDefaultButton"); // NOI18N
        fillDefaultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillDefaultButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlButtonsPanelLayout = new javax.swing.GroupLayout(controlButtonsPanel);
        controlButtonsPanel.setLayout(controlButtonsPanelLayout);
        controlButtonsPanelLayout.setHorizontalGroup(
            controlButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlButtonsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fillDefaultButton)
                .addGap(12, 12, 12)
                .addComponent(fillCurrentButton)
                .addContainerGap(459, Short.MAX_VALUE))
        );
        controlButtonsPanelLayout.setVerticalGroup(
            controlButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlButtonsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fillCurrentButton)
                    .addComponent(fillDefaultButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(controlButtonsPanel, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void fillCurrentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillCurrentButtonActionPerformed
        Map<HexColorType, Color> currentColors = frame.getCurrentTextColors();
        setColorsFromMap(currentColors);
        setModified(true);
    }//GEN-LAST:event_fillCurrentButtonActionPerformed

    private void fillDefaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillDefaultButtonActionPerformed
        Map<HexColorType, Color> defaultColors = frame.getDefaultTextColors();
        setColorsFromMap(defaultColors);
        setModified(true);
    }//GEN-LAST:event_fillDefaultButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel colorsPanel;
    private javax.swing.JScrollPane colorsScrollPane;
    private javax.swing.JPanel controlButtonsPanel;
    private javax.swing.JButton fillCurrentButton;
    private javax.swing.JButton fillDefaultButton;
    private javax.swing.JPanel previewHeaderPanel;
    private javax.swing.JLabel previewLabel;
    private javax.swing.JPanel previewPanel;
    private javax.swing.JSplitPane splitPane;
    // End of variables declaration//GEN-END:variables

    @Override
    public List<OptionsPanel.PathItem> getPath() {
        ArrayList<OptionsPanel.PathItem> path = new ArrayList<>();
        path.add(new PathItem("apperance", ""));
        path.add(new PathItem("colors", resourceBundle.getString("options.Path.0"))); //
        return path;
    }

    @Override
    public void loadFromPreferences(Preferences preferences) {
        setColorsFromMap(frame.getDefaultTextColors());
        Integer rgb = null;
        for (HexColorType colorType : HexColorType.values()) {
            try {
                rgb = Integer.valueOf(preferences.get(colorType.getPreferencesString(), null));
            } catch (NumberFormatException ex) {
                // Ignore
            }
            if (rgb != null) {
                setColor(colorType, new Color(rgb));
            }
        }
    }

    @Override
    public void saveToPreferences(Preferences preferences) {
        for (HexColorType colorType : HexColorType.values()) {
            preferences.put(colorType.getPreferencesString(), Integer.toString(getColor(colorType).getRGB()));
        }
    }

    @Override
    public void applyPreferencesChanges() {
        frame.setCurrentTextColors(getMapFromColors());
    }

    public void setColorsFromMap(Map<HexColorType, Color> colors) {
        for (Map.Entry<HexColorType, Color> entry : colors.entrySet()) {
            setColor(entry.getKey(), entry.getValue());
            setPreviewColor(entry.getKey(), entry.getValue());
        }
    }

    public Map<HexColorType, Color> getMapFromColors() {
        Map<HexColorType, Color> colors = new HashMap<>();
        for (Map.Entry<HexColorType, SelectableColor> entry : selectableColors.entrySet()) {
            colors.put(entry.getKey(), entry.getValue().getColor());
        }
        return colors;
    }

    private void setModified(boolean b) {
        if (modifiedOptionListener != null) {
            modifiedOptionListener.wasModified();
        }
    }

    @Override
    public void setModifiedOptionListener(ModifiedOptionListener listener) {
        modifiedOptionListener = listener;
    }

    // TODO: Workaround for issue with divider position, replace color editors
    public void fixLayout() {
        splitPane.setDividerLocation(getWidth() / 2);
    }
}
