package com.oplus.tbl.exoplayer2.video;

import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.ParserException;
import com.oplus.tbl.exoplayer2.util.CodecSpecificDataUtil;
import com.oplus.tbl.exoplayer2.util.NalUnitUtil;
import com.oplus.tbl.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class HevcConfig {
    private static final int SPS_NAL_UNIT_TYPE = 33;

    @Nullable
    public final String codecs;
    public final int colorRange;
    public final int colorSpace;
    public final int colorTransfer;
    public final int height;

    @Nullable
    public final List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthHeightRatio;
    public final int width;

    private HevcConfig(@Nullable List<byte[]> list, int i, int i2, int i3, int i4, int i5, int i6, float f, @Nullable String str) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i;
        this.width = i2;
        this.height = i3;
        this.colorSpace = i4;
        this.colorRange = i5;
        this.colorTransfer = i6;
        this.pixelWidthHeightRatio = f;
        this.codecs = str;
    }

    public static HevcConfig parse(ParsableByteArray parsableByteArray) throws ParserException {
        int i;
        int i2;
        try {
            parsableByteArray.skipBytes(21);
            int unsignedByte = parsableByteArray.readUnsignedByte() & 3;
            int unsignedByte2 = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition();
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < unsignedByte2; i5++) {
                parsableByteArray.skipBytes(1);
                int unsignedShort = parsableByteArray.readUnsignedShort();
                for (int i6 = 0; i6 < unsignedShort; i6++) {
                    int unsignedShort2 = parsableByteArray.readUnsignedShort();
                    i4 += unsignedShort2 + 4;
                    parsableByteArray.skipBytes(unsignedShort2);
                }
            }
            parsableByteArray.setPosition(position);
            byte[] bArr = new byte[i4];
            String strBuildHevcCodecString = null;
            int i7 = 0;
            int i8 = 0;
            int i9 = -1;
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            float f = 1.0f;
            while (i7 < unsignedByte2) {
                int unsignedByte3 = parsableByteArray.readUnsignedByte() & 127;
                int unsignedShort3 = parsableByteArray.readUnsignedShort();
                int i14 = 0;
                while (i14 < unsignedShort3) {
                    int unsignedShort4 = parsableByteArray.readUnsignedShort();
                    byte[] bArr2 = NalUnitUtil.NAL_START_CODE;
                    int i15 = unsignedByte2;
                    System.arraycopy(bArr2, i3, bArr, i8, bArr2.length);
                    int length = i8 + bArr2.length;
                    System.arraycopy(parsableByteArray.getData(), parsableByteArray.getPosition(), bArr, length, unsignedShort4);
                    if (unsignedByte3 == 33 && i14 == 0) {
                        NalUnitUtil.H265SpsData h265SpsNalUnit = NalUnitUtil.parseH265SpsNalUnit(bArr, length, length + unsignedShort4);
                        int i16 = h265SpsNalUnit.width;
                        i10 = h265SpsNalUnit.height;
                        i11 = h265SpsNalUnit.colorSpace;
                        int i17 = h265SpsNalUnit.colorRange;
                        int i18 = h265SpsNalUnit.colorTransfer;
                        float f2 = h265SpsNalUnit.pixelWidthHeightRatio;
                        i = unsignedByte3;
                        i2 = unsignedShort3;
                        i9 = i16;
                        strBuildHevcCodecString = CodecSpecificDataUtil.buildHevcCodecString(h265SpsNalUnit.generalProfileSpace, h265SpsNalUnit.generalTierFlag, h265SpsNalUnit.generalProfileIdc, h265SpsNalUnit.generalProfileCompatibilityFlags, h265SpsNalUnit.constraintBytes, h265SpsNalUnit.generalLevelIdc);
                        i13 = i18;
                        i12 = i17;
                        f = f2;
                    } else {
                        i = unsignedByte3;
                        i2 = unsignedShort3;
                    }
                    i8 = length + unsignedShort4;
                    parsableByteArray.skipBytes(unsignedShort4);
                    i14++;
                    unsignedByte2 = i15;
                    unsignedByte3 = i;
                    unsignedShort3 = i2;
                    i3 = 0;
                }
                i7++;
                i3 = 0;
            }
            return new HevcConfig(i4 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), unsignedByte + 1, i9, i10, i11, i12, i13, f, strBuildHevcCodecString);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ParserException("Error parsing HEVC config", e);
        }
    }
}
