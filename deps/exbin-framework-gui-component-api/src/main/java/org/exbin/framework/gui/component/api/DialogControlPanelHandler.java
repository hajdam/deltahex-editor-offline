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

import javax.swing.JButton;

/**
 * Interface for basic dialog control panel.
 *
 * @version 0.2.0 2016/12/20
 * @author ExBin Project (http://exbin.org)
 */
public interface DialogControlPanelHandler {

    public void cancelAction();

    public void setAction();

    public void saveAction();

    public void okCancelButtons(JButton okButton, JButton cancelButton);
}
