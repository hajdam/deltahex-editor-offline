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
package org.exbin.framework.editor.text.panel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import org.exbin.framework.gui.options.api.OptionsPanel;
import org.exbin.framework.gui.options.api.OptionsPanel.ModifiedOptionListener;
import org.exbin.framework.gui.options.api.OptionsPanel.PathItem;
import org.exbin.framework.gui.utils.LanguageUtils;

/**
 * Text color selection panel.
 *
 * @version 0.2.0 2017/01/04
 * @author ExBin Project (http://exbin.org)
 */
public class TextColorPanel extends javax.swing.JPanel implements OptionsPanel {

    public static final String PREFERENCES_TEXT_COLOR_TEXT = "textColor.text";
    public static final String PREFERENCES_TEXT_COLOR_BACKGROUND = "textColor.background";
    public static final String PREFERENCES_TEXT_COLOR_SELECTION = "textColor.selection";
    public static final String PREFERENCES_TEXT_COLOR_SELECTION_BACKGROUND = "textColor.selectionBackground";
    public static final String PREFERENCES_TEXT_COLOR_FOUND = "textColor.found";

    private ModifiedOptionListener modifiedOptionListener;
    private final ResourceBundle resourceBundle = LanguageUtils.getResourceBundleByClass(TextColorPanel.class);
    private final TextColorPanelApi handler;

    public TextColorPanel(TextColorPanelApi handler) {
        this.handler = handler;
        initComponents();
    }

    public Color getTextColor() {
        return textColorPanel.getBackground();
    }

    public Color getTextBackgroundColor() {
        return textBackgroundColorPanel.getBackground();
    }

    public Color getSelectionTextColor() {
        return selectionTextColorPanel.getBackground();
    }

    public Color getSelectionBackgroundColor() {
        return selectionBackgroundColorPanel.getBackground();
    }

    public Color getFoundBackgroundColor() {
        return foundBackgroundColorPanel.getBackground();
    }

    public void setTextColor(Color color) {
        textColorPanel.setBackground(color);
        normalTextLabel.setForeground(color);
        foundTextLabel.setForeground(color);
    }

    public void setTextBackgroundColor(Color color) {
        textBackgroundColorPanel.setBackground(color);
        normalTextLabel.setBackground(color);
    }

    public void setSelectionTextColor(Color color) {
        selectionTextColorPanel.setBackground(color);
        selectedTextLabel.setForeground(color);
    }

    public void setSelectionBackgroundColor(Color color) {
        selectionBackgroundColorPanel.setBackground(color);
        selectedTextLabel.setBackground(color);
    }

    public void setFoundBackgroundColor(Color color) {
        foundBackgroundColorPanel.setBackground(color);
        foundTextLabel.setBackground(color);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        normalTextLabel.setEnabled(enabled);
        selectedTextLabel.setEnabled(enabled);
        foundTextLabel.setEnabled(enabled);
        selectTextBackgroundColorButton.setEnabled(enabled);
        selectSelectionTextColorButton.setEnabled(enabled);
        selectSelectionBackgroundColorButton.setEnabled(enabled);
        selectTextColorButton.setEnabled(enabled);
        selectFoundBackgroundColorButton.setEnabled(enabled);
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

        jColorChooser1 = new javax.swing.JColorChooser();
        textColorPanel = new javax.swing.JPanel();
        selectTextColorButton = new javax.swing.JButton();
        textBackgroundColorPanel = new javax.swing.JPanel();
        selectTextBackgroundColorButton = new javax.swing.JButton();
        selectionTextColorPanel = new javax.swing.JPanel();
        selectSelectionTextColorButton = new javax.swing.JButton();
        selectionBackgroundColorPanel = new javax.swing.JPanel();
        selectSelectionBackgroundColorButton = new javax.swing.JButton();
        foundBackgroundColorPanel = new javax.swing.JPanel();
        selectFoundBackgroundColorButton = new javax.swing.JButton();
        textColorLabel = new javax.swing.JLabel();
        textBackgroundColorLabel = new javax.swing.JLabel();
        selectionTextColorLabel = new javax.swing.JLabel();
        selectionBackgroundColorLabel = new javax.swing.JLabel();
        foundBackgroundColorLabel = new javax.swing.JLabel();
        textColorsPreviewPanel = new javax.swing.JPanel();
        normalTextLabel = new javax.swing.JLabel();
        selectedTextLabel = new javax.swing.JLabel();
        foundTextLabel = new javax.swing.JLabel();
        controlButtonsPanel = new javax.swing.JPanel();
        fillCurrentButton = new javax.swing.JButton();
        fillDefaultButton = new javax.swing.JButton();

        jColorChooser1.setName("jColorChooser1"); // NOI18N

        setName("Form"); // NOI18N

        textColorPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        textColorPanel.setName("textColorPanel"); // NOI18N

        javax.swing.GroupLayout textColorPanelLayout = new javax.swing.GroupLayout(textColorPanel);
        textColorPanel.setLayout(textColorPanelLayout);
        textColorPanelLayout.setHorizontalGroup(
            textColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        textColorPanelLayout.setVerticalGroup(
            textColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        selectTextColorButton.setText(resourceBundle.getString("TextColorPanel.selectButton.text")); // NOI18N
        selectTextColorButton.setName("selectTextColorButton"); // NOI18N
        selectTextColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectTextColorButtonActionPerformed(evt);
            }
        });

        textBackgroundColorPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        textBackgroundColorPanel.setName("textBackgroundColorPanel"); // NOI18N

        javax.swing.GroupLayout textBackgroundColorPanelLayout = new javax.swing.GroupLayout(textBackgroundColorPanel);
        textBackgroundColorPanel.setLayout(textBackgroundColorPanelLayout);
        textBackgroundColorPanelLayout.setHorizontalGroup(
            textBackgroundColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        textBackgroundColorPanelLayout.setVerticalGroup(
            textBackgroundColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        selectTextBackgroundColorButton.setText(resourceBundle.getString("TextColorPanel.selectButton.text")); // NOI18N
        selectTextBackgroundColorButton.setName("selectTextBackgroundColorButton"); // NOI18N
        selectTextBackgroundColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectTextBackgroundColorButtonActionPerformed(evt);
            }
        });

        selectionTextColorPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        selectionTextColorPanel.setName("selectionTextColorPanel"); // NOI18N

        javax.swing.GroupLayout selectionTextColorPanelLayout = new javax.swing.GroupLayout(selectionTextColorPanel);
        selectionTextColorPanel.setLayout(selectionTextColorPanelLayout);
        selectionTextColorPanelLayout.setHorizontalGroup(
            selectionTextColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        selectionTextColorPanelLayout.setVerticalGroup(
            selectionTextColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        selectSelectionTextColorButton.setText(resourceBundle.getString("TextColorPanel.selectButton.text")); // NOI18N
        selectSelectionTextColorButton.setName("selectSelectionTextColorButton"); // NOI18N
        selectSelectionTextColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectSelectionTextColorButtonActionPerformed(evt);
            }
        });

        selectionBackgroundColorPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        selectionBackgroundColorPanel.setName("selectionBackgroundColorPanel"); // NOI18N

        javax.swing.GroupLayout selectionBackgroundColorPanelLayout = new javax.swing.GroupLayout(selectionBackgroundColorPanel);
        selectionBackgroundColorPanel.setLayout(selectionBackgroundColorPanelLayout);
        selectionBackgroundColorPanelLayout.setHorizontalGroup(
            selectionBackgroundColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        selectionBackgroundColorPanelLayout.setVerticalGroup(
            selectionBackgroundColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        selectSelectionBackgroundColorButton.setText(resourceBundle.getString("TextColorPanel.selectButton.text")); // NOI18N
        selectSelectionBackgroundColorButton.setName("selectSelectionBackgroundColorButton"); // NOI18N
        selectSelectionBackgroundColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectSelectionBackgroundColorButtonActionPerformed(evt);
            }
        });

        foundBackgroundColorPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        foundBackgroundColorPanel.setName("foundBackgroundColorPanel"); // NOI18N

        javax.swing.GroupLayout foundBackgroundColorPanelLayout = new javax.swing.GroupLayout(foundBackgroundColorPanel);
        foundBackgroundColorPanel.setLayout(foundBackgroundColorPanelLayout);
        foundBackgroundColorPanelLayout.setHorizontalGroup(
            foundBackgroundColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        foundBackgroundColorPanelLayout.setVerticalGroup(
            foundBackgroundColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        selectFoundBackgroundColorButton.setText(resourceBundle.getString("TextColorPanel.selectButton.text")); // NOI18N
        selectFoundBackgroundColorButton.setName("selectFoundBackgroundColorButton"); // NOI18N
        selectFoundBackgroundColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFoundBackgroundColorButtonActionPerformed(evt);
            }
        });

        textColorLabel.setText(resourceBundle.getString("TextColorPanel.textColorLabel.text")); // NOI18N
        textColorLabel.setName("textColorLabel"); // NOI18N

        textBackgroundColorLabel.setText(resourceBundle.getString("TextColorPanel.textBackgroundColorLabel.text")); // NOI18N
        textBackgroundColorLabel.setName("textBackgroundColorLabel"); // NOI18N

        selectionTextColorLabel.setText(resourceBundle.getString("TextColorPanel.selectionTextColorLabel.text")); // NOI18N
        selectionTextColorLabel.setName("selectionTextColorLabel"); // NOI18N

        selectionBackgroundColorLabel.setText(resourceBundle.getString("TextColorPanel.selectionBackgroundColorLabel.text")); // NOI18N
        selectionBackgroundColorLabel.setName("selectionBackgroundColorLabel"); // NOI18N

        foundBackgroundColorLabel.setText(resourceBundle.getString("TextColorPanel.foundBackgroundColorLabel.text")); // NOI18N
        foundBackgroundColorLabel.setName("foundBackgroundColorLabel"); // NOI18N

        textColorsPreviewPanel.setName("textColorsPreviewPanel"); // NOI18N
        textColorsPreviewPanel.setLayout(new java.awt.GridLayout(1, 3));

        normalTextLabel.setBackground(new java.awt.Color(255, 255, 255));
        normalTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        normalTextLabel.setText(resourceBundle.getString("TextColorPanel.normalTextLabel.text")); // NOI18N
        normalTextLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        normalTextLabel.setName("normalTextLabel"); // NOI18N
        normalTextLabel.setOpaque(true);
        textColorsPreviewPanel.add(normalTextLabel);

        selectedTextLabel.setBackground(new java.awt.Color(255, 255, 255));
        selectedTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectedTextLabel.setText(resourceBundle.getString("TextColorPanel.selectedTextLabel.text")); // NOI18N
        selectedTextLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        selectedTextLabel.setName("selectedTextLabel"); // NOI18N
        selectedTextLabel.setOpaque(true);
        textColorsPreviewPanel.add(selectedTextLabel);

        foundTextLabel.setBackground(new java.awt.Color(255, 255, 255));
        foundTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foundTextLabel.setText(resourceBundle.getString("TextColorPanel.foundTextLabel.text")); // NOI18N
        foundTextLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        foundTextLabel.setName("foundTextLabel"); // NOI18N
        foundTextLabel.setOpaque(true);
        textColorsPreviewPanel.add(foundTextLabel);

        controlButtonsPanel.setName("controlButtonsPanel"); // NOI18N

        fillCurrentButton.setText(resourceBundle.getString("TextColorPanel.fillCurrentButton.text")); // NOI18N
        fillCurrentButton.setName("fillCurrentButton"); // NOI18N
        fillCurrentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillCurrentButtonActionPerformed(evt);
            }
        });

        fillDefaultButton.setText(resourceBundle.getString("TextColorPanel.fillDefaultButton.text")); // NOI18N
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textColorsPreviewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textBackgroundColorPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(selectionBackgroundColorLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(selectionBackgroundColorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectionTextColorPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(foundBackgroundColorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textColorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectFoundBackgroundColorButton)
                            .addComponent(selectSelectionBackgroundColorButton)
                            .addComponent(selectSelectionTextColorButton)
                            .addComponent(selectTextBackgroundColorButton)
                            .addComponent(selectTextColorButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(foundBackgroundColorLabel)
                            .addComponent(selectionTextColorLabel)
                            .addComponent(textBackgroundColorLabel)
                            .addComponent(textColorLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(controlButtonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textColorsPreviewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textColorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(selectTextColorButton)
                    .addComponent(textColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textBackgroundColorLabel)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textBackgroundColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectTextBackgroundColorButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectionTextColorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectSelectionTextColorButton)
                    .addComponent(selectionTextColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectionBackgroundColorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectionBackgroundColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(selectSelectionBackgroundColorButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(foundBackgroundColorLabel)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectFoundBackgroundColorButton)
                    .addComponent(foundBackgroundColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(controlButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selectTextColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectTextColorButtonActionPerformed
        jColorChooser1.setColor(textColorPanel.getBackground());
        JDialog dialog = JColorChooser.createDialog(this, resourceBundle.getString("JColorChooser.title"), true, jColorChooser1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTextColor(jColorChooser1.getColor());
            }
        }, null);
        dialog.setVisible(true);
    }//GEN-LAST:event_selectTextColorButtonActionPerformed

    private void selectTextBackgroundColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectTextBackgroundColorButtonActionPerformed
        jColorChooser1.setColor(textBackgroundColorPanel.getBackground());
        JDialog dialog = JColorChooser.createDialog(this, resourceBundle.getString("JColorChooser.title"), true, jColorChooser1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTextBackgroundColor(jColorChooser1.getColor());
            }
        }, null);
        dialog.setVisible(true);
    }//GEN-LAST:event_selectTextBackgroundColorButtonActionPerformed

    private void selectSelectionTextColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectSelectionTextColorButtonActionPerformed
        jColorChooser1.setColor(selectionTextColorPanel.getBackground());
        JDialog dialog = JColorChooser.createDialog(this, resourceBundle.getString("JColorChooser.title"), true, jColorChooser1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setSelectionTextColor(jColorChooser1.getColor());
            }
        }, null);
        dialog.setVisible(true);
    }//GEN-LAST:event_selectSelectionTextColorButtonActionPerformed

    private void selectSelectionBackgroundColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectSelectionBackgroundColorButtonActionPerformed
        jColorChooser1.setColor(selectionBackgroundColorPanel.getBackground());
        JDialog dialog = JColorChooser.createDialog(this, resourceBundle.getString("JColorChooser.title"), true, jColorChooser1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setSelectionBackgroundColor(jColorChooser1.getColor());
            }
        }, null);
        dialog.setVisible(true);
    }//GEN-LAST:event_selectSelectionBackgroundColorButtonActionPerformed

    private void selectFoundBackgroundColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFoundBackgroundColorButtonActionPerformed
        jColorChooser1.setColor(foundBackgroundColorPanel.getBackground());
        JDialog dialog = JColorChooser.createDialog(this, resourceBundle.getString("JColorChooser.title"), true, jColorChooser1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFoundBackgroundColor(jColorChooser1.getColor());
            }
        }, null);
        dialog.setVisible(true);
    }//GEN-LAST:event_selectFoundBackgroundColorButtonActionPerformed

    private void fillCurrentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillCurrentButtonActionPerformed
        Color[] currentColors = handler.getCurrentTextColors();
        setColorsFromArray(currentColors);
        setModified(true);
    }//GEN-LAST:event_fillCurrentButtonActionPerformed

    private void fillDefaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillDefaultButtonActionPerformed
        Color[] defaultColors = handler.getDefaultTextColors();
        setColorsFromArray(defaultColors);
        setModified(true);
    }//GEN-LAST:event_fillDefaultButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel controlButtonsPanel;
    private javax.swing.JButton fillCurrentButton;
    private javax.swing.JButton fillDefaultButton;
    private javax.swing.JLabel foundBackgroundColorLabel;
    private javax.swing.JPanel foundBackgroundColorPanel;
    private javax.swing.JLabel foundTextLabel;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel normalTextLabel;
    private javax.swing.JButton selectFoundBackgroundColorButton;
    private javax.swing.JButton selectSelectionBackgroundColorButton;
    private javax.swing.JButton selectSelectionTextColorButton;
    private javax.swing.JButton selectTextBackgroundColorButton;
    private javax.swing.JButton selectTextColorButton;
    private javax.swing.JLabel selectedTextLabel;
    private javax.swing.JLabel selectionBackgroundColorLabel;
    private javax.swing.JPanel selectionBackgroundColorPanel;
    private javax.swing.JLabel selectionTextColorLabel;
    private javax.swing.JPanel selectionTextColorPanel;
    private javax.swing.JLabel textBackgroundColorLabel;
    private javax.swing.JPanel textBackgroundColorPanel;
    private javax.swing.JLabel textColorLabel;
    private javax.swing.JPanel textColorPanel;
    private javax.swing.JPanel textColorsPreviewPanel;
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
        setColorsFromArray(handler.getDefaultTextColors());
        Integer rgb;
        try {
            rgb = Integer.valueOf(preferences.get(PREFERENCES_TEXT_COLOR_TEXT, null));
            if (rgb != null) {
                setTextColor(new Color(rgb));
            }
        } catch (NumberFormatException e) {
        }
        try {
            rgb = Integer.valueOf(preferences.get(PREFERENCES_TEXT_COLOR_BACKGROUND, null));
            if (rgb != null) {
                setTextBackgroundColor(new Color(rgb));
            }
        } catch (NumberFormatException e) {
        }
        try {
            rgb = Integer.valueOf(preferences.get(PREFERENCES_TEXT_COLOR_SELECTION, null));
            if (rgb != null) {
                setSelectionTextColor(new Color(rgb));
            }
        } catch (NumberFormatException e) {
        }
        try {
            rgb = Integer.valueOf(preferences.get(PREFERENCES_TEXT_COLOR_SELECTION_BACKGROUND, null));
            if (rgb != null) {
                setSelectionBackgroundColor(new Color(rgb));
            }
        } catch (NumberFormatException e) {
        }
        try {
            rgb = Integer.valueOf(preferences.get(PREFERENCES_TEXT_COLOR_FOUND, null));
            if (rgb != null) {
                setFoundBackgroundColor(new Color(rgb));
            }
        } catch (NumberFormatException e) {
        }
    }

    @Override
    public void saveToPreferences(Preferences preferences) {
        preferences.put(PREFERENCES_TEXT_COLOR_TEXT, Integer.toString(getTextColor().getRGB()));
        preferences.put(PREFERENCES_TEXT_COLOR_BACKGROUND, Integer.toString(getTextBackgroundColor().getRGB()));
        preferences.put(PREFERENCES_TEXT_COLOR_SELECTION, Integer.toString(getSelectionTextColor().getRGB()));
        preferences.put(PREFERENCES_TEXT_COLOR_SELECTION_BACKGROUND, Integer.toString(getSelectionBackgroundColor().getRGB()));
        preferences.put(PREFERENCES_TEXT_COLOR_FOUND, Integer.toString(getFoundBackgroundColor().getRGB()));
    }

    @Override
    public void applyPreferencesChanges() {
        handler.setCurrentTextColors(getArrayFromColors());
    }

    public void setColorsFromArray(Color[] colors) {
        setTextColor(colors[0]);
        setTextBackgroundColor(colors[1]);
        setSelectionTextColor(colors[2]);
        setSelectionBackgroundColor(colors[3]);
        setFoundBackgroundColor(colors[4]);
    }

    public Color[] getArrayFromColors() {
        Color[] colors = new Color[5];
        colors[0] = getTextColor();
        colors[1] = getTextBackgroundColor();
        colors[2] = getSelectionTextColor();
        colors[3] = getSelectionBackgroundColor();
        colors[4] = getFoundBackgroundColor();
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

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }
}
