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
package org.exbin.xbup.core.catalog.base;

/**
 * Interface for catalog plugin panel editor entity.
 *
 * @version 0.1.21 2012/05/01
 * @author ExBin Project (http://exbin.org)
 */
public interface XBCXPlugPane extends XBCBase {

    /**
     * Gets attached plugin.
     *
     * @return plugin
     */
    public XBCXPlugin getPlugin();

    /**
     * Gets index of the panel editor.
     *
     * @return panel editor index
     */
    public Long getPaneIndex();
}
