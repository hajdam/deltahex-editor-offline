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
package org.exbin.framework.gui.about;

import java.awt.event.ActionEvent;
import java.util.ResourceBundle;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import org.exbin.framework.api.XBApplication;
import org.exbin.framework.gui.about.api.GuiAboutModuleApi;
import org.exbin.framework.gui.about.panel.AboutPanel;
import org.exbin.framework.gui.frame.api.GuiFrameModuleApi;
import org.exbin.framework.gui.menu.api.GuiMenuModuleApi;
import org.exbin.framework.gui.menu.api.MenuGroup;
import org.exbin.framework.gui.menu.api.MenuPosition;
import org.exbin.framework.gui.menu.api.PositionMode;
import org.exbin.framework.gui.menu.api.SeparationMode;
import org.exbin.framework.gui.utils.ActionUtils;
import org.exbin.framework.gui.utils.LanguageUtils;
import org.exbin.framework.gui.utils.WindowUtils;
import org.exbin.framework.gui.utils.handler.CloseControlHandler;
import org.exbin.framework.gui.utils.panel.CloseControlPanel;
import org.exbin.xbup.plugin.XBModuleHandler;

/**
 * Implementation of XBUP framework about module.
 *
 * @version 0.2.0 2017/01/18
 * @author ExBin Project (http://exbin.org)
 */
public class GuiAboutModule implements GuiAboutModuleApi {

    private XBApplication application;
    private java.util.ResourceBundle resourceBundle = null;
    private Action aboutAction;
    private JComponent sideComponent = null;

    public GuiAboutModule() {
    }

    @Override
    public void init(XBModuleHandler application) {
        this.application = (XBApplication) application;
    }

    @Override
    public void unregisterModule(String moduleId) {
    }

    private ResourceBundle getResourceBundle() {
        if (resourceBundle == null) {
            resourceBundle = LanguageUtils.getResourceBundleByClass(GuiAboutModule.class);
        }

        return resourceBundle;
    }

    @Override
    public Action getAboutAction() {
        if (aboutAction == null) {
            getResourceBundle();
            aboutAction = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GuiFrameModuleApi frameModule = application.getModuleRepository().getModuleByInterface(GuiFrameModuleApi.class);
                    AboutPanel aboutPanel = new AboutPanel();
                    aboutPanel.setApplication(application);
                    aboutPanel.setSideComponent(sideComponent);
                    CloseControlPanel controlPanel = new CloseControlPanel();
                    JPanel dialogPanel = WindowUtils.createDialogPanel(aboutPanel, controlPanel);
                    final JDialog aboutDialog = frameModule.createDialog(dialogPanel);
                    controlPanel.setHandler(new CloseControlHandler() {
                        @Override
                        public void controlActionPerformed() {
                            WindowUtils.closeWindow(aboutDialog);
                        }
                    });
                    WindowUtils.assignGlobalKeyListener(aboutDialog, controlPanel.createOkCancelListener());
                    aboutDialog.setLocationRelativeTo(aboutDialog.getParent());
                    aboutDialog.setVisible(true);
                }
            };
            ActionUtils.setupAction(aboutAction, resourceBundle, "aboutAction");
            aboutAction.putValue(ActionUtils.ACTION_DIALOG_MODE, true);
        }

        return aboutAction;
    }

    @Override
    public void registerDefaultMenuItem() {
        GuiMenuModuleApi menuModule = application.getModuleRepository().getModuleByInterface(GuiMenuModuleApi.class);
        menuModule.registerMenuGroup(GuiFrameModuleApi.HELP_MENU_ID, new MenuGroup(HELP_ABOUT_MENU_GROUP_ID, new MenuPosition(PositionMode.BOTTOM_LAST), SeparationMode.ABOVE));
        menuModule.registerMenuItem(GuiFrameModuleApi.HELP_MENU_ID, MODULE_ID, getAboutAction(), new MenuPosition(HELP_ABOUT_MENU_GROUP_ID));
    }

    @Override
    public void setAboutDialogSideComponent(JComponent sideComponent) {
        this.sideComponent = sideComponent;
    }
}
