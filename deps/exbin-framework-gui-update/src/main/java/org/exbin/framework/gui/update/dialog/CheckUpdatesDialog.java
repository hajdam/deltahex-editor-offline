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
package org.exbin.framework.gui.update.dialog;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import org.exbin.framework.api.XBApplication;
import org.exbin.framework.gui.update.GuiUpdateModule;
import org.exbin.framework.gui.update.VersionNumbers;
import org.exbin.framework.gui.utils.BareBonesBrowserLaunch;
import org.exbin.framework.gui.utils.LanguageUtils;
import org.exbin.framework.gui.utils.WindowUtils;

/**
 * Check updates dialog.
 *
 * @version 0.2.0 2016/07/14
 * @author ExBin Project (http://exbin.org)
 */
public class CheckUpdatesDialog extends javax.swing.JDialog implements HyperlinkListener {

    private final XBApplication application;
    private ResourceBundle appBundle;
    private final ResourceBundle resourceBundle = LanguageUtils.getResourceBundleByClass(CheckUpdatesDialog.class);
    private String updateWebsite;
    private VersionNumbers versionNumbers;
    private CheckUpdatesHandler checkUpdatesHandler = null;
    private Thread checkingThread = null;
    private URL downloadUrl;

    public CheckUpdatesDialog(java.awt.Frame parent, boolean modal, XBApplication application) {
        super(parent, modal);

        this.application = application;
        if (application != null) {
            appBundle = application.getAppBundle();
        } else {
            appBundle = resourceBundle;
        }

        init();
    }

    private void init() {
        initComponents();

        WindowUtils.initWindow(this);
        WindowUtils.addHeaderPanel(this, resourceBundle.getString("header.title"), resourceBundle.getString("header.description"), resourceBundle.getString("header.icon"));
        WindowUtils.assignGlobalKeyListener(this, closeButton);
    }

    /**
     * Opens hyperlink in external browser.
     *
     * @param event hyperlink event
     */
    @Override
    public void hyperlinkUpdate(HyperlinkEvent event) {
        if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            BareBonesBrowserLaunch.openURL(event.getURL().toExternalForm());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        linkPopupMenu = new javax.swing.JPopupMenu();
        copyLinkMenuItem = new javax.swing.JMenuItem();
        mainPanel = new javax.swing.JPanel();
        statusPanel = new javax.swing.JPanel();
        statusIconLabel = new javax.swing.JLabel();
        statusTextLabel = new javax.swing.JLabel();
        currentVersionLabel = new javax.swing.JLabel();
        currentVersionTextField = new javax.swing.JTextField();
        availableVersionLabel = new javax.swing.JLabel();
        availableVersionTextField = new javax.swing.JTextField();
        recheckButton = new javax.swing.JButton();
        downloadButton = new javax.swing.JButton();
        controlPanel = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();

        linkPopupMenu.setName("linkPopupMenu"); // NOI18N

        copyLinkMenuItem.setText(resourceBundle.getString("copyLinkMenuItem.text")); // NOI18N
        copyLinkMenuItem.setName("copyLinkMenuItem"); // NOI18N
        copyLinkMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyLinkMenuItemActionPerformed(evt);
            }
        });
        linkPopupMenu.add(copyLinkMenuItem);

        setTitle(resourceBundle.getString("checkUpdaBox.title")); // NOI18N
        setLocationByPlatform(true);

        mainPanel.setName("mainPanel"); // NOI18N

        statusPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        statusPanel.setMaximumSize(new java.awt.Dimension(32767, 60));
        statusPanel.setMinimumSize(new java.awt.Dimension(100, 60));
        statusPanel.setName("statusPanel"); // NOI18N

        statusIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/exbin/framework/gui/update/resources/icons/open_icon_library/icons/png/48x48/apps/internet-web-browser-7.png"))); // NOI18N
        statusIconLabel.setName("statusIconLabel"); // NOI18N

        statusTextLabel.setText("Checking for available updates...");
        statusTextLabel.setName("statusTextLabel"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusIconLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusIconLabel)
                    .addComponent(statusTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        currentVersionLabel.setText(resourceBundle.getString("currentVersionLabel.text")); // NOI18N
        currentVersionLabel.setName("currentVersionLabel"); // NOI18N

        currentVersionTextField.setEditable(false);
        currentVersionTextField.setText("unknown");
        currentVersionTextField.setName("currentVersionTextField"); // NOI18N

        availableVersionLabel.setText(resourceBundle.getString("availableVersionLabel.text")); // NOI18N
        availableVersionLabel.setName("availableVersionLabel"); // NOI18N

        availableVersionTextField.setEditable(false);
        availableVersionTextField.setText("unknown");
        availableVersionTextField.setName("availableVersionTextField"); // NOI18N

        recheckButton.setText("Recheck");
        recheckButton.setEnabled(false);
        recheckButton.setName("recheckButton"); // NOI18N
        recheckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recheckButtonActionPerformed(evt);
            }
        });

        downloadButton.setText("Download");
        downloadButton.setEnabled(false);
        downloadButton.setName("downloadButton"); // NOI18N
        downloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(currentVersionTextField)
                    .addComponent(availableVersionTextField)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(currentVersionLabel)
                            .addComponent(availableVersionLabel)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(downloadButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(recheckButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(currentVersionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentVersionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(availableVersionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(availableVersionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recheckButton)
                    .addComponent(downloadButton))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        controlPanel.setName("controlPanel"); // NOI18N

        closeButton.setText(resourceBundle.getString("closeButton.text")); // NOI18N
        closeButton.setName("closeButton"); // NOI18N
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                .addContainerGap(377, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addContainerGap())
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addContainerGap())
        );

        getContentPane().add(controlPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void copyLinkMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyLinkMenuItemActionPerformed
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(updateWebsite), null);
    }//GEN-LAST:event_copyLinkMenuItemActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        WindowUtils.closeWindow(this);
    }//GEN-LAST:event_closeButtonActionPerformed

    private void recheckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recheckButtonActionPerformed
        recheckButton.setEnabled(false);
        statusTextLabel.setText(resourceBundle.getString("status.checking.text"));
        statusIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(resourceBundle.getString("status.checking.icon"))));
        performCheckForUpdates();
    }//GEN-LAST:event_recheckButtonActionPerformed

    private void downloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadButtonActionPerformed
        BareBonesBrowserLaunch.openDesktopURL(downloadUrl);
    }//GEN-LAST:event_downloadButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        WindowUtils.invokeWindow(new CheckUpdatesDialog(new javax.swing.JFrame(), true, WindowUtils.getDefaultAppEditor()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel availableVersionLabel;
    private javax.swing.JTextField availableVersionTextField;
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JMenuItem copyLinkMenuItem;
    private javax.swing.JLabel currentVersionLabel;
    private javax.swing.JTextField currentVersionTextField;
    private javax.swing.JButton downloadButton;
    private javax.swing.JPopupMenu linkPopupMenu;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton recheckButton;
    private javax.swing.JLabel statusIconLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JLabel statusTextLabel;
    // End of variables declaration//GEN-END:variables

    public ResourceBundle getProjectResourceBundle() {
        return appBundle;
    }

    public void setProjectResourceBundle(ResourceBundle projectResourceBundle) {
        this.appBundle = projectResourceBundle;
    }

    public void setVersionNumbers(VersionNumbers versionNumbers) {
        this.versionNumbers = versionNumbers;
        currentVersionTextField.setText(versionNumbers.versionAsString());
    }

    public void setCheckUpdatesHandler(CheckUpdatesHandler checkUpdatesHandler) {
        this.checkUpdatesHandler = checkUpdatesHandler;
        if (checkUpdatesHandler != null) {
            performCheckForUpdates();
        }
    }

    private void performCheckForUpdates() {
        if (checkingThread != null) {
            checkingThread.interrupt();
        }
        checkingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                GuiUpdateModule.CheckUpdatesResult result = checkUpdatesHandler.checkForUpdates();
                VersionNumbers updateVersion = checkUpdatesHandler.getUpdateVersion();
                if (updateVersion == null) {
                    availableVersionTextField.setText(resourceBundle.getString("unknown"));
                } else {
                    availableVersionTextField.setText(updateVersion.versionAsString());
                }
                setCheckUpdatesResult(result);
                recheckButton.setEnabled(true);
            }
        });
        checkingThread.start();
    }

    private void setCheckUpdatesResult(GuiUpdateModule.CheckUpdatesResult result) {
        if (result == null) {

            return;
        }
        switch (result) {
            case UPDATE_URL_NOT_SET: {
                statusTextLabel.setText(resourceBundle.getString("status.updateUrlNotSet.text"));
                statusIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(resourceBundle.getString("status.updateUrlNotSet.icon"))));
                break;
            }
            case NO_CONNECTION: {
                statusTextLabel.setText(resourceBundle.getString("status.noConnection.text"));
                statusIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(resourceBundle.getString("status.noConnection.icon"))));
                break;
            }
            case CONNECTION_ISSUE: {
                statusTextLabel.setText(resourceBundle.getString("status.connectionIssue.text"));
                statusIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(resourceBundle.getString("status.connectionIssue.icon"))));
                break;
            }
            case NOT_FOUND: {
                statusTextLabel.setText(resourceBundle.getString("status.notFound.text"));
                statusIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(resourceBundle.getString("status.notFound.icon"))));
                break;
            }
            case NO_UPDATE_AVAILABLE: {
                statusTextLabel.setText(resourceBundle.getString("status.noUpdateAvailable.text"));
                statusIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(resourceBundle.getString("status.noUpdateAvailable.icon"))));
                break;
            }
            case UPDATE_FOUND: {
                statusTextLabel.setText(resourceBundle.getString("status.updateFound.text"));
                statusIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(resourceBundle.getString("status.updateFound.icon"))));
                break;
            }
            default: {
                statusTextLabel.setText("Unexpected result state " + result.name() + "!");
                statusIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(resourceBundle.getString("status.misc.icon"))));
                break;
            }
        }
    }

    public void setUpdateDownloadUrl(URL downloadUrl) {
        this.downloadUrl = downloadUrl;
        downloadButton.setEnabled(downloadUrl != null);
    }

    /**
     * Handler for updates checking.
     */
    public static interface CheckUpdatesHandler {

        /**
         * Performs check for updates.
         *
         * @return check for updates result
         */
        GuiUpdateModule.CheckUpdatesResult checkForUpdates();

        /**
         * Returns version of update if available.
         *
         * @return version of update
         */
        VersionNumbers getUpdateVersion();
    }
}
