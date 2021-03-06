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
package org.exbin.framework.gui.component.api;

/**
 * Interface for clipboard handler for visual component / context menu.
 *
 * @version 0.2.1 2017/02/21
 * @author ExBin Project (http://exbin.org)
 */
public interface EditItemActionsHandler {

    /**
     * Adds new item.
     */
    void performAddItem();

    /**
     * Edits currently selected item.
     */
    void performEditItem();

    /**
     * Deletes currently selected item(s).
     */
    void performDeleteItem();

    /**
     * Returns if selection for clipboard operation is available.
     *
     * @return true if selection is available
     */
    boolean isSelection();

    /**
     * Returns true if it is possible to edit currently selected item.
     *
     * @return true if item is editable
     */
    boolean isEditable();

    /**
     * Set listener for actions related updates.
     *
     * @param updateListener update listener
     */
    void setUpdateListener(EditItemActionsUpdateListener updateListener);
}
