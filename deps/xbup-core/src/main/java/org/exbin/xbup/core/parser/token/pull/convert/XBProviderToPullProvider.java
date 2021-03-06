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
package org.exbin.xbup.core.parser.token.pull.convert;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.exbin.xbup.core.block.XBBlockTerminationMode;
import org.exbin.xbup.core.parser.XBProcessingException;
import org.exbin.xbup.core.parser.basic.XBProvider;
import org.exbin.xbup.core.parser.basic.XBSListener;
import org.exbin.xbup.core.parser.token.XBAttribute;
import org.exbin.xbup.core.parser.token.XBAttributeToken;
import org.exbin.xbup.core.parser.token.XBBeginToken;
import org.exbin.xbup.core.parser.token.XBDataToken;
import org.exbin.xbup.core.parser.token.XBEndToken;
import org.exbin.xbup.core.parser.token.XBSBeginToken;
import org.exbin.xbup.core.parser.token.XBToken;
import org.exbin.xbup.core.parser.token.pull.XBPullProvider;
import org.exbin.xbup.core.ubnumber.UBNatural;

/**
 * Provider To pull provider convertor for XBUP protocol level 0.
 *
 * @version 0.2.1 2017/06/05
 * @author ExBin Project (http://exbin.org)
 */
public class XBProviderToPullProvider implements XBPullProvider {

    @Nonnull
    private final XBProvider provider;
    @Nullable
    private XBToken token;

    public XBProviderToPullProvider(@Nonnull XBProvider provider) {
        this.provider = provider;
    }

    @Override
    @Nonnull
    public XBToken pullXBToken() throws XBProcessingException, IOException {
        provider.produceXB(new XBSListener() {
            @Override
            public void beginXB(XBBlockTerminationMode terminationMode) throws XBProcessingException, IOException {
                token = XBBeginToken.create(terminationMode);
            }

            @Override
            public void beginXB(XBBlockTerminationMode terminationMode, UBNatural blockSize) throws XBProcessingException, IOException {
                token = XBSBeginToken.create(terminationMode, blockSize);
            }

            @Override
            public void attribXB(XBAttribute value) throws XBProcessingException, IOException {
                token = XBAttributeToken.create(value);
            }

            @Override
            public void dataXB(InputStream data) throws XBProcessingException, IOException {
                token = XBDataToken.create(data);
            }

            @Override
            public void endXB() throws XBProcessingException, IOException {
                token = XBEndToken.create();
            }
        });

        return token;
    }
}
