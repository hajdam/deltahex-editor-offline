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
package org.exbin.xbup.operation;

import javax.annotation.Nonnull;
import org.exbin.xbup.core.block.XBTEditableDocument;
import org.exbin.xbup.operation.basic.XBBasicCommandType;

/**
 * Abstract class for operation using XBUP level 1 document.
 *
 * @version 0.2.1 2017/06/06
 * @author ExBin Project (http://exbin.org)
 */
public abstract class XBTDocCommand extends AbstractCommand {

    @Nonnull
    protected final XBTEditableDocument document;

    public XBTDocCommand(@Nonnull XBTEditableDocument document) {
        this.document = document;
    }

    /**
     * Returns type of the command.
     *
     * @return command type
     */
    @Nonnull
    public abstract XBBasicCommandType getBasicType();

    @Nonnull
    public XBTEditableDocument getDocument() {
        return document;
    }

    /**
     * Default dispose is empty.
     *
     * @throws Exception exception
     */
    @Override
    public void dispose() throws Exception {
    }

    @Override
    @Nonnull
    public String getCaption() {
        return getBasicType().getCaption();
    }
}
