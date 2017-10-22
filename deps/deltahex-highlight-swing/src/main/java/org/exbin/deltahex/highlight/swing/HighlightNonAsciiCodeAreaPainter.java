/*
 * Copyright (C) ExBin Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.exbin.deltahex.highlight.swing;

import java.awt.Color;
import org.exbin.deltahex.Section;
import org.exbin.deltahex.swing.CodeArea;
import org.exbin.deltahex.swing.ColorsGroup;

/**
 * Experimental support for highlighting of non-ascii characters.
 *
 * @version 0.1.3 2017/03/22
 * @author ExBin Project (http://exbin.org)
 */
public class HighlightNonAsciiCodeAreaPainter extends HighlightCodeAreaPainter {

    private Color controlCodes;
    private Color aboveCodes;
    private boolean nonAsciiHighlightingEnabled = true;

    public HighlightNonAsciiCodeAreaPainter(CodeArea codeArea) {
        super(codeArea);

        Color textColor = codeArea.getMainColors().getTextColor();
        int controlCodesRed = textColor.getRed();
        int controlCodesRedDif = 0;
        if (controlCodesRed > 128) {
            if (controlCodesRed > 192) {
                controlCodesRedDif = controlCodesRed - 192;
            }
            controlCodesRed = 255;
        } else {
            controlCodesRed += 127;
        }

        int controlCodesBlue = textColor.getBlue();
        int controlCodesBlueDif = 0;
        if (controlCodesBlue > 128) {
            if (controlCodesBlue > 192) {
                controlCodesBlueDif = controlCodesBlue - 192;
            }
            controlCodesBlue = 255;
        } else {
            controlCodesBlue += 127;
        }

        controlCodes = new Color(
                controlCodesRed,
                downShift(textColor.getGreen(), controlCodesBlueDif + controlCodesRedDif),
                controlCodesBlue);

        int aboveCodesGreen = textColor.getGreen();
        int aboveCodesGreenDif = 0;
        if (aboveCodesGreen > 128) {
            if (aboveCodesGreen > 192) {
                aboveCodesGreenDif = aboveCodesGreen - 192;
            }

            aboveCodesGreen = 255;
        } else {
            aboveCodesGreen += 127;
        }
        
        int aboveCodesBlue = textColor.getBlue();
        int aboveCodesBlueDif = 0;
        if (aboveCodesBlue > 128) {
            if (aboveCodesBlue > 192) {
                aboveCodesBlueDif = aboveCodesBlue - 192;
            }

            aboveCodesBlue = 255;
        } else {
            aboveCodesBlue += 127;
        }
        
        aboveCodes = new Color(
                downShift(textColor.getRed(), aboveCodesGreenDif + aboveCodesBlueDif),
                aboveCodesGreen, aboveCodesBlue);
    }

    private int downShift(int color, int diff) {
        if (color < diff) {
            return 0;
        }

        return color - diff;
    }

    @Override
    public Color getPositionColor(int byteOnLine, int charOnLine, Section section, ColorsGroup.ColorType colorType, PaintData paintData) {
        Color color = super.getPositionColor(byteOnLine, charOnLine, section, colorType, paintData);
        if (nonAsciiHighlightingEnabled && section == Section.CODE_MATRIX && colorType == ColorsGroup.ColorType.TEXT) {
            if (color.equals(paintData.getMainColors().getTextColor())) {
                long dataPosition = paintData.getLineDataPosition() + byteOnLine;
                if (dataPosition < codeArea.getDataSize()) {
                    byte value = codeArea.getData().getByte(dataPosition);
                    if (value < 0) {
                        color = aboveCodes;
                    } else if (value < 0x20) {
                        color = controlCodes;
                    }
                }
            }
        }

        return color;
    }

    public Color getControlCodes() {
        return controlCodes;
    }

    public void setControlCodes(Color controlCodes) {
        this.controlCodes = controlCodes;
    }

    public Color getAboveCodes() {
        return aboveCodes;
    }

    public void setAboveCodes(Color aboveCodes) {
        this.aboveCodes = aboveCodes;
    }

    public boolean isNonAsciiHighlightingEnabled() {
        return nonAsciiHighlightingEnabled;
    }

    public void setNonAsciiHighlightingEnabled(boolean nonAsciiHighlightingEnabled) {
        this.nonAsciiHighlightingEnabled = nonAsciiHighlightingEnabled;
    }
}
