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
package org.exbin.framework.gui.component;

import javax.swing.JPanel;
import org.exbin.framework.api.XBApplication;
import org.exbin.framework.gui.component.api.DialogControlPanelHandler;
import org.exbin.framework.gui.component.api.EditItemActions;
import org.exbin.framework.gui.component.api.EditItemActionsHandler;
import org.exbin.framework.gui.component.api.GuiComponentModuleApi;
import org.exbin.framework.gui.component.api.MoveItemActions;
import org.exbin.framework.gui.component.api.MoveItemActionsHandler;
import org.exbin.framework.gui.component.panel.DialogControlPanel;
import org.exbin.xbup.plugin.XBModuleHandler;

/**
 * Implementation of XBUP framework component module.
 *
 * @version 0.2.0 2016/12/20
 * @author ExBin Project (http://exbin.org)
 */
public class GuiComponentModule implements GuiComponentModuleApi {

    private XBApplication application;

    public GuiComponentModule() {
    }

    @Override
    public void init(XBModuleHandler application) {
        this.application = (XBApplication) application;
    }

    @Override
    public void unregisterModule(String moduleId) {
    }

    @Override
    public JPanel getTableEditPanel() {
        // return new TableEditPanel();
        return null;
    }

    @Override
    public EditItemActions createEditItemActions(EditItemActionsHandler editItemActionsHandler) {
        DefaultEditItemActions editActions = new DefaultEditItemActions();
        editActions.setEditItemActionsHandler(editItemActionsHandler);
        return editActions;
    }

    @Override
    public MoveItemActions createMoveItemActions(MoveItemActionsHandler moveItemActionsHandler) {
        DefaultMoveItemActions moveActions = new DefaultMoveItemActions();
        moveActions.setMoveItemActionsHandler(moveItemActionsHandler);
        return moveActions;
    }

    @Override
    public JPanel createDialogControlPanel(DialogControlPanelHandler handler) {
        return new DialogControlPanel(handler);
    }
}
