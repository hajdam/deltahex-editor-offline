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
package org.exbin.xbup.plugin;

import javax.annotation.Nullable;

/**
 * XBUP Line Editor Plugin Base Abstract Class.
 *
 * @version 0.2.1 2017/05/28
 * @author ExBin Project (http://exbin.org)
 */
public abstract class XBAbstractLineEditor implements XBLineEditor {

    @Nullable
    private ChangeListener changeListener = null;

    public void fireValueChange() {
        if (changeListener != null) {
            changeListener.valueChanged();
        }
    }

    @Override
    public void attachChangeListener(@Nullable ChangeListener listener) {
        changeListener = listener;
    }
}
