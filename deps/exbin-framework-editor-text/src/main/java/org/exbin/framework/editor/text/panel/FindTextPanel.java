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

import java.util.ResourceBundle;
import org.exbin.framework.editor.text.handler.FindTextPanelApi;
import org.exbin.framework.gui.utils.LanguageUtils;

/**
 * Find text panel.
 *
 * @version 0.2.0 2016/12/30
 * @author ExBin Project (http://exbin.org)
 */
public class FindTextPanel extends javax.swing.JPanel implements FindTextPanelApi {

    private final java.util.ResourceBundle resourceBundle = LanguageUtils.getResourceBundleByClass(FindTextPanel.class);

    public FindTextPanel() {
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

        findPanel = new javax.swing.JPanel();
        textToFindLabel = new javax.swing.JLabel();
        textToFindjTextField = new javax.swing.JTextField();
        searchFromCursorCheckBox = new javax.swing.JCheckBox();
        matchCaseCheckBox = new javax.swing.JCheckBox();
        replacePanel = new javax.swing.JPanel();
        performReplaceCheckBox = new javax.swing.JCheckBox();
        textToReplaceLabel = new javax.swing.JLabel();
        textToReplaceTextField = new javax.swing.JTextField();
        replaceAllMatchesCheckBox = new javax.swing.JCheckBox();

        setLayout(new java.awt.BorderLayout());

        findPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceBundle.getString("findPanel.border.title"))); // NOI18N

        textToFindLabel.setText(resourceBundle.getString("textToFindLabel.text")); // NOI18N

        searchFromCursorCheckBox.setSelected(true);
        searchFromCursorCheckBox.setText(resourceBundle.getString("searchFromCursorCheckBox.text")); // NOI18N

        matchCaseCheckBox.setText(resourceBundle.getString("matchCaseCheckBox.text")); // NOI18N
        matchCaseCheckBox.setEnabled(false);

        javax.swing.GroupLayout findPanelLayout = new javax.swing.GroupLayout(findPanel);
        findPanel.setLayout(findPanelLayout);
        findPanelLayout.setHorizontalGroup(
            findPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(findPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(findPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(matchCaseCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchFromCursorCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textToFindLabel)
                    .addComponent(textToFindjTextField))
                .addContainerGap())
        );
        findPanelLayout.setVerticalGroup(
            findPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(findPanelLayout.createSequentialGroup()
                .addComponent(textToFindLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textToFindjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchFromCursorCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(matchCaseCheckBox)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        add(findPanel, java.awt.BorderLayout.CENTER);

        replacePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceBundle.getString("replacePanel.border.title"))); // NOI18N

        performReplaceCheckBox.setText(resourceBundle.getString("performReplaceCheckBox.text")); // NOI18N
        performReplaceCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                performReplaceCheckBoxActionPerformed(evt);
            }
        });

        textToReplaceLabel.setText(resourceBundle.getString("textToReplaceLabel.text")); // NOI18N

        textToReplaceTextField.setEnabled(false);

        replaceAllMatchesCheckBox.setText(resourceBundle.getString("replaceAllMatchesCheckBox.text")); // NOI18N
        replaceAllMatchesCheckBox.setEnabled(false);

        javax.swing.GroupLayout replacePanelLayout = new javax.swing.GroupLayout(replacePanel);
        replacePanel.setLayout(replacePanelLayout);
        replacePanelLayout.setHorizontalGroup(
            replacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(replacePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(replacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(performReplaceCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addComponent(textToReplaceLabel)
                    .addComponent(textToReplaceTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addComponent(replaceAllMatchesCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
                .addContainerGap())
        );
        replacePanelLayout.setVerticalGroup(
            replacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(replacePanelLayout.createSequentialGroup()
                .addComponent(performReplaceCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textToReplaceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textToReplaceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(replaceAllMatchesCheckBox)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        add(replacePanel, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void performReplaceCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_performReplaceCheckBoxActionPerformed
        textToReplaceTextField.setEnabled(performReplaceCheckBox.isSelected());
        textToReplaceLabel.setEnabled(performReplaceCheckBox.isSelected());
    }//GEN-LAST:event_performReplaceCheckBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel findPanel;
    private javax.swing.JCheckBox matchCaseCheckBox;
    private javax.swing.JCheckBox performReplaceCheckBox;
    private javax.swing.JCheckBox replaceAllMatchesCheckBox;
    private javax.swing.JPanel replacePanel;
    private javax.swing.JCheckBox searchFromCursorCheckBox;
    private javax.swing.JLabel textToFindLabel;
    private javax.swing.JTextField textToFindjTextField;
    private javax.swing.JLabel textToReplaceLabel;
    private javax.swing.JTextField textToReplaceTextField;
    // End of variables declaration//GEN-END:variables

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    @Override
    public boolean getSearchFromStart() {
        return !searchFromCursorCheckBox.isSelected();
    }

    @Override
    public void setSelected() {
        textToFindjTextField.requestFocusInWindow();
        textToFindjTextField.selectAll();
    }

    @Override
    public String getFindText() {
        return textToFindjTextField.getText();
    }

    @Override
    public boolean getShallReplace() {
        return performReplaceCheckBox.isSelected();
    }

    @Override
    public void setShallReplace(boolean shallReplace) {
        performReplaceCheckBox.setSelected(shallReplace);
        performReplaceCheckBoxActionPerformed(null);
    }

    @Override
    public String getReplaceText() {
        return textToReplaceTextField.getText();
    }
}
