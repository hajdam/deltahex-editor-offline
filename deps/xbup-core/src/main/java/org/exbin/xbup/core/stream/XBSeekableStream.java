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
package org.exbin.xbup.core.stream;

import java.io.IOException;

/**
 * Interface for stream with seekable tokens.
 *
 * @version 0.2.1 2017/05/17
 * @author ExBin Project (http://exbin.org)
 */
public interface XBSeekableStream {

    /**
     * Moves position in stream to given position from the start of the stream.
     *
     * @param position target position
     * @throws IOException if input/output error
     */
    void seekXB(long position) throws IOException;

    /**
     * Returns current position in stream.
     *
     * @return current position in stream, -1 if unable to determine
     */
    long getPositionXB();

    /**
     * Returns length of stream.
     *
     * @return length of stream in bytes, -1 if unable to determine
     */
    long getStreamSizeXB();
}
