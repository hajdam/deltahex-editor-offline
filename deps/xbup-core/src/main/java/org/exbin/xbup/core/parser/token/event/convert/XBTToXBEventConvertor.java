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
package org.exbin.xbup.core.parser.token.event.convert;

import java.io.IOException;
import javax.annotation.Nonnull;
import org.exbin.xbup.core.block.XBFBlockType;
import org.exbin.xbup.core.parser.XBProcessingException;
import org.exbin.xbup.core.parser.XBProcessingExceptionType;
import org.exbin.xbup.core.parser.token.XBAttributeToken;
import org.exbin.xbup.core.parser.token.XBBeginToken;
import org.exbin.xbup.core.parser.token.XBDataToken;
import org.exbin.xbup.core.parser.token.XBEndToken;
import org.exbin.xbup.core.parser.token.XBTAttributeToken;
import org.exbin.xbup.core.parser.token.XBTBeginToken;
import org.exbin.xbup.core.parser.token.XBTDataToken;
import org.exbin.xbup.core.parser.token.XBTToken;
import org.exbin.xbup.core.parser.token.XBTTypeToken;
import org.exbin.xbup.core.parser.token.event.XBEventListener;
import org.exbin.xbup.core.parser.token.event.XBEventProducer;
import org.exbin.xbup.core.parser.token.event.XBTEventListener;

/**
 * XBUP level 1 to level 0 event convertor.
 *
 * @version 0.2.1 2017/06/05
 * @author ExBin Project (http://exbin.org)
 */
public class XBTToXBEventConvertor implements XBTEventListener, XBEventProducer {

    @Nonnull
    private XBEventListener eventListener;

    public XBTToXBEventConvertor(@Nonnull XBEventListener eventListener) {
        this.eventListener = eventListener;
    }

    @Override
    public void attachXBEventListener(@Nonnull XBEventListener eventListener) {
        this.eventListener = eventListener;
    }

    @Override
    public void putXBTToken(@Nonnull XBTToken token) throws XBProcessingException, IOException {
        switch (token.getTokenType()) {
            case BEGIN: {
                eventListener.putXBToken(XBBeginToken.create(((XBTBeginToken) token).getTerminationMode()));
                break;
            }

            case TYPE: {
                if (((XBTTypeToken) token).getBlockType() instanceof XBFBlockType) {
                    eventListener.putXBToken(XBAttributeToken.create(((XBFBlockType) ((XBTTypeToken) token).getBlockType()).getGroupID()));
                    eventListener.putXBToken(XBAttributeToken.create(((XBFBlockType) ((XBTTypeToken) token).getBlockType()).getBlockID()));
                    break;
                } else {
                    throw new XBProcessingException("Unexpected block type", XBProcessingExceptionType.BLOCK_TYPE_MISMATCH);
                }
            }

            case ATTRIBUTE: {
                eventListener.putXBToken(XBAttributeToken.create(((XBTAttributeToken) token).getAttribute()));
                break;
            }

            case DATA: {
                eventListener.putXBToken(XBDataToken.create(((XBTDataToken) token).getData()));
                break;
            }

            case END: {
                eventListener.putXBToken(XBEndToken.create());
                break;
            }

            default:
                throw new IllegalStateException("Unexpected token type " + token.getTokenType().toString());
        }
    }
}
