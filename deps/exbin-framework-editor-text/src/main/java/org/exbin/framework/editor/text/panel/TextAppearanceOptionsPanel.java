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

import java.util.List;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import org.exbin.framework.gui.options.api.OptionsPanel;
import org.exbin.framework.gui.options.api.OptionsPanel.ModifiedOptionListener;
import org.exbin.framework.gui.utils.ActionUtils;
import org.exbin.framework.gui.utils.LanguageUtils;

/**
 * XBTEditor Text Encoding Options panel.
 *
 * @version 0.2.0 2016/04/03
 * @author ExBin Project (http://exbin.org)
 */
public class TextAppearanceOptionsPanel extends javax.swing.JPanel implements OptionsPanel {
    public static final String PREFERENCES_TEXT_WORD_WRAPPING = "textAppearance.wordWrap";

    private ModifiedOptionListener modifiedOptionListener;
    private ResourceBundle resourceBundle = LanguageUtils.getResourceBundleByClass(TextAppearanceOptionsPanel.class);
    private TextAppearanceOptionsPanelApi frame;

    public TextAppearanceOptionsPanel(TextAppearanceOptionsPanelApi frame) {
        this.frame = frame;

        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wordWrapCheckBox = new javax.swing.JCheckBox();

        setName("Form"); // NOI18N

        wordWrapCheckBox.setSelected(true);
        wordWrapCheckBox.setText(resourceBundle.getString("TextAppearanceOptionsPanel.wordWrapCheckBox.text")); // NOI18N
        wordWrapCheckBox.setName("wordWrapCheckBox"); // NOI18N
        wordWrapCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                wordWrapCheckBoxjCheckBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wordWrapCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wordWrapCheckBox))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void wordWrapCheckBoxjCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_wordWrapCheckBoxjCheckBoxItemStateChanged
        setModified(true);
    }//GEN-LAST:event_wordWrapCheckBoxjCheckBoxItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox wordWrapCheckBox;
    // End of variables declaration//GEN-END:variables

    @Override
    public List<OptionsPanel.PathItem> getPath() {
        return null;
    }

    @Override
    public void loadFromPreferences(Preferences preferences) {
        wordWrapCheckBox.setSelected(Boolean.parseBoolean(preferences.get(PREFERENCES_TEXT_WORD_WRAPPING, Boolean.FALSE.toString())));
    }

    @Override
    public void saveToPreferences(Preferences preferences) {
        preferences.put(PREFERENCES_TEXT_WORD_WRAPPING, Boolean.toString(wordWrapCheckBox.isSelected()));
    }

    @Override
    public void applyPreferencesChanges() {
        frame.setWordWrapMode(wordWrapCheckBox.isSelected());
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
}
