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
package org.exbin.framework.gui.editor.api;

import java.awt.Component;
import org.exbin.framework.api.XBApplicationModule;
import org.exbin.framework.api.XBModuleRepositoryUtils;

/**
 * XBUP framework editor module api interface.
 *
 * @version 0.2.0 2016/08/16
 * @author ExBin Project (http://exbin.org)
 */
public interface GuiEditorModuleApi extends XBApplicationModule {

    public static String MODULE_ID = XBModuleRepositoryUtils.getModuleIdByApi(GuiEditorModuleApi.class);

    /**
     * Registers new editor.
     *
     * @param pluginId plugin identifier
     * @param editorProvider editor provider
     */
    void registerEditor(String pluginId, EditorProvider editorProvider);

    /**
     * Registers multitab editor.
     *
     * @param pluginId plugin identifier
     * @param editorProvider editor provider
     */
    void registerMultiEditor(String pluginId, final MultiEditorProvider editorProvider);

    /**
     * Returns main component for editors handling.
     *
     * @return panel component
     */
    Component getEditorPanel();

    /**
     * Registers undo handler for undo management to editor.
     */
    void registerUndoHandler();
}
