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

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import org.exbin.framework.gui.options.api.OptionsPanel;
import org.exbin.framework.gui.options.api.OptionsPanel.ModifiedOptionListener;
import org.exbin.framework.gui.options.api.OptionsPanel.PathItem;
import org.exbin.framework.gui.utils.LanguageUtils;

/**
 * Text encoding options panel.
 *
 * @version 0.2.0 2016/05/19
 * @author ExBin Project (http://exbin.org)
 */
public class TextEncodingOptionsPanel extends javax.swing.JPanel implements OptionsPanel {

    public static final String PREFERENCES_TEXT_ENCODING_DEFAULT = "textEncoding.default";

    private ModifiedOptionListener modifiedOptionListener;
    private final ResourceBundle resourceBundle = LanguageUtils.getResourceBundleByClass(TextEncodingOptionsPanel.class);
    private final TextEncodingPanelApi frame;
    private final TextEncodingPanel encodingPanel;
    private final DefaultEncodingComboBoxModel encodingComboBoxModel = new DefaultEncodingComboBoxModel();

    public TextEncodingOptionsPanel(TextEncodingPanelApi frame) {
        this.frame = frame;

        initComponents();

        encodingPanel = new TextEncodingPanel(frame);
        encodingPanel.setEnabled(false);
        encodingPanel.setModifiedOptionListener(new ModifiedOptionListener() {
            @Override
            public void wasModified() {
                modifiedOptionListener.wasModified();
                updateEncodings();
            }
        });
        super.add(encodingPanel, BorderLayout.CENTER);
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
        defaultEncodingPanel = new javax.swing.JPanel();
        defaultEncodingComboBox = new javax.swing.JComboBox();
        defaultEncodingLabel = new javax.swing.JLabel();
        fillCurrentEncodingButton = new javax.swing.JButton();
        encodingsControlPanel = new javax.swing.JPanel();
        fillCurrentEncodingsButton = new javax.swing.JButton();

        jColorChooser1.setName("jColorChooser1"); // NOI18N

        setName("Form"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        defaultEncodingPanel.setName("defaultEncodingPanel"); // NOI18N

        defaultEncodingComboBox.setModel(encodingComboBoxModel);
        defaultEncodingComboBox.setName("defaultEncodingComboBox"); // NOI18N
        defaultEncodingComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                defaultEncodingComboBoxItemStateChanged(evt);
            }
        });

        defaultEncodingLabel.setText(resourceBundle.getString("TextEncodingOptionsPanel.defaultEncodingLabel.text")); // NOI18N
        defaultEncodingLabel.setName("defaultEncodingLabel"); // NOI18N

        fillCurrentEncodingButton.setText(resourceBundle.getString("TextEncodingOptionsPanel.fillCurrentEncodingButton.text")); // NOI18N
        fillCurrentEncodingButton.setName("fillCurrentEncodingButton"); // NOI18N
        fillCurrentEncodingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillCurrentEncodingButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout defaultEncodingPanelLayout = new javax.swing.GroupLayout(defaultEncodingPanel);
        defaultEncodingPanel.setLayout(defaultEncodingPanelLayout);
        defaultEncodingPanelLayout.setHorizontalGroup(
            defaultEncodingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultEncodingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(defaultEncodingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(defaultEncodingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(defaultEncodingPanelLayout.createSequentialGroup()
                        .addComponent(fillCurrentEncodingButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(defaultEncodingComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        defaultEncodingPanelLayout.setVerticalGroup(
            defaultEncodingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultEncodingPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(defaultEncodingLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(defaultEncodingComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fillCurrentEncodingButton))
        );

        add(defaultEncodingPanel, java.awt.BorderLayout.NORTH);

        encodingsControlPanel.setName("encodingsControlPanel"); // NOI18N

        fillCurrentEncodingsButton.setText(resourceBundle.getString("TextEncodingOptionsPanel.fillCurrentEncodingsButton.text")); // NOI18N
        fillCurrentEncodingsButton.setName("fillCurrentEncodingsButton"); // NOI18N
        fillCurrentEncodingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillCurrentEncodingsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout encodingsControlPanelLayout = new javax.swing.GroupLayout(encodingsControlPanel);
        encodingsControlPanel.setLayout(encodingsControlPanelLayout);
        encodingsControlPanelLayout.setHorizontalGroup(
            encodingsControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(encodingsControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fillCurrentEncodingsButton)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        encodingsControlPanelLayout.setVerticalGroup(
            encodingsControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(encodingsControlPanelLayout.createSequentialGroup()
                .addComponent(fillCurrentEncodingsButton)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        add(encodingsControlPanel, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void fillCurrentEncodingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillCurrentEncodingsButtonActionPerformed
        encodingPanel.setEncodingList(frame.getEncodings());
        encodingPanel.repaint();
        updateEncodings();
        setModified(true);
    }//GEN-LAST:event_fillCurrentEncodingsButtonActionPerformed

    private void fillCurrentEncodingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillCurrentEncodingButtonActionPerformed
        defaultEncodingComboBox.setSelectedItem(frame.getSelectedEncoding());
        defaultEncodingComboBox.repaint();
        setModified(true);
    }//GEN-LAST:event_fillCurrentEncodingButtonActionPerformed

    private void defaultEncodingComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_defaultEncodingComboBoxItemStateChanged
        setModified(true);
    }//GEN-LAST:event_defaultEncodingComboBoxItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox defaultEncodingComboBox;
    private javax.swing.JLabel defaultEncodingLabel;
    private javax.swing.JPanel defaultEncodingPanel;
    private javax.swing.JPanel encodingsControlPanel;
    private javax.swing.JButton fillCurrentEncodingButton;
    private javax.swing.JButton fillCurrentEncodingsButton;
    private javax.swing.JColorChooser jColorChooser1;
    // End of variables declaration//GEN-END:variables

    @Override
    public List<OptionsPanel.PathItem> getPath() {
        ArrayList<OptionsPanel.PathItem> path = new ArrayList<>();
        path.add(new PathItem("apperance", ""));
        path.add(new PathItem("encoding", resourceBundle.getString("options.Path.0")));
        return path;
    }

    @Override
    public void loadFromPreferences(Preferences preferences) {
        encodingPanel.loadFromPreferences(preferences);
        updateEncodings();
        defaultEncodingComboBox.setSelectedItem(preferences.get(PREFERENCES_TEXT_ENCODING_DEFAULT, TextEncodingPanel.ENCODING_UTF8));
    }

    @Override
    public void saveToPreferences(Preferences preferences) {
        preferences.put(PREFERENCES_TEXT_ENCODING_DEFAULT, (String) defaultEncodingComboBox.getSelectedItem());
        encodingPanel.saveToPreferences(preferences);
    }

    @Override
    public void applyPreferencesChanges() {
        frame.setSelectedEncoding((String) defaultEncodingComboBox.getSelectedItem());
        encodingPanel.applyPreferencesChanges();
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

    private void updateEncodings() {
        encodingComboBoxModel.setAvailableEncodings(encodingPanel.getEncodingList());
        defaultEncodingComboBox.repaint();
    }

    public class DefaultEncodingComboBoxModel implements ComboBoxModel<String> {

        private List<String> availableEncodings = new ArrayList<>();
        private String selectedEncoding = null;
        private final List<ListDataListener> dataListeners = new ArrayList<>();

        public DefaultEncodingComboBoxModel() {
        }

        @Override
        public void setSelectedItem(Object anItem) {
            selectedEncoding = (String) anItem;
        }

        @Override
        public Object getSelectedItem() {
            return selectedEncoding;
        }

        @Override
        public int getSize() {
            return availableEncodings.size();
        }

        @Override
        public String getElementAt(int index) {
            return availableEncodings.get(index);
        }

        @Override
        public void addListDataListener(ListDataListener listener) {
            dataListeners.add(listener);
        }

        @Override
        public void removeListDataListener(ListDataListener listener) {
            dataListeners.remove(listener);
        }

        public List<String> getAvailableEncodings() {
            return availableEncodings;
        }

        public void setAvailableEncodings(List<String> encodings) {
            availableEncodings = new ArrayList<>();
            availableEncodings.add(TextEncodingPanel.ENCODING_UTF8);
            availableEncodings.addAll(encodings);
            int position = availableEncodings.indexOf(selectedEncoding);
            selectedEncoding = availableEncodings.get(position > 0 ? position : 0);

            for (int index = 0; index < dataListeners.size(); index++) {
                ListDataListener listDataListener = dataListeners.get(index);
                listDataListener.contentsChanged(new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, availableEncodings.size()));
            }
        }

        public String getSelectedEncoding() {
            return selectedEncoding;
        }

        public void setSelectedEncoding(String selectedEncoding) {
            this.selectedEncoding = selectedEncoding;
        }
    }
}
