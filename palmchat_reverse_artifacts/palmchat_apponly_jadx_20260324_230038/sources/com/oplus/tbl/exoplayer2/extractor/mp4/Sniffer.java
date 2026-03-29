package com.oplus.tbl.exoplayer2.extractor.mp4;

import com.oplus.tbl.exoplayer2.extractor.ExtractorInput;
import com.oplus.tbl.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class Sniffer {
    public static final int BRAND_HEIC = 1751476579;
    public static final int BRAND_QUICKTIME = 1903435808;
    private static final int[] COMPATIBLE_BRANDS = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};
    private static final int SEARCH_LENGTH = 4096;

    private Sniffer() {
    }

    private static boolean isCompatibleBrand(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579 && z) {
            return true;
        }
        for (int i2 : COMPATIBLE_BRANDS) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean sniffFragmented(ExtractorInput extractorInput) throws IOException {
        return sniffInternal(extractorInput, true, false);
    }

    private static boolean sniffInternal(ExtractorInput extractorInput, boolean z, boolean z2) throws IOException {
        boolean z3;
        boolean z4;
        int i;
        int i2;
        boolean z5;
        long length = extractorInput.getLength();
        long j = 4096;
        long j2 = -1;
        int i3 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        if (i3 != 0 && length <= 4096) {
            j = length;
        }
        int i4 = (int) j;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        boolean z6 = false;
        int i5 = 0;
        boolean z7 = false;
        while (i5 < i4) {
            parsableByteArray.reset(8);
            if (!extractorInput.peekFully(parsableByteArray.getData(), z6 ? 1 : 0, 8, true)) {
                break;
            }
            long unsignedInt = parsableByteArray.readUnsignedInt();
            int i6 = parsableByteArray.readInt();
            if (unsignedInt == 1) {
                extractorInput.peekFully(parsableByteArray.getData(), 8, 8);
                parsableByteArray.setLimit(16);
                unsignedInt = parsableByteArray.readLong();
                i = 16;
            } else {
                if (unsignedInt == 0) {
                    long length2 = extractorInput.getLength();
                    if (length2 != j2) {
                        unsignedInt = (length2 - extractorInput.getPeekPosition()) + ((long) 8);
                    }
                }
                i = 8;
            }
            long j3 = i;
            if (unsignedInt < j3) {
                return z6;
            }
            i5 += i;
            if (i6 == 1836019574) {
                i4 += (int) unsignedInt;
                if (i3 != 0 && i4 > length) {
                    i4 = (int) length;
                }
                j2 = -1;
            } else {
                if (i6 == 1836019558 || i6 == 1836475768) {
                    z3 = true;
                    z4 = true;
                    break;
                }
                if (i6 == 1835295092) {
                    i2 = i3;
                    z7 = true;
                } else {
                    i2 = i3;
                }
                if ((((long) i5) + unsignedInt) - j3 >= i4) {
                    z4 = false;
                    z3 = true;
                    break;
                }
                int i7 = (int) (unsignedInt - j3);
                i5 += i7;
                if (i6 == 1718909296) {
                    if (i7 < 8) {
                        return false;
                    }
                    parsableByteArray.reset(i7);
                    extractorInput.peekFully(parsableByteArray.getData(), 0, i7);
                    int i8 = i7 / 4;
                    int i9 = 0;
                    while (true) {
                        if (i9 >= i8) {
                            z5 = z7;
                            break;
                        }
                        if (i9 == 1) {
                            parsableByteArray.skipBytes(4);
                        } else if (isCompatibleBrand(parsableByteArray.readInt(), z2)) {
                            z5 = true;
                            break;
                        }
                        i9++;
                    }
                    if (!z5) {
                        return false;
                    }
                    z7 = z5;
                } else if (i7 != 0) {
                    extractorInput.advancePeekPosition(i7);
                }
                i3 = i2;
                j2 = -1;
                z6 = false;
            }
        }
        z3 = true;
        z4 = false;
        if (z7 && z == z4) {
            return z3;
        }
        return false;
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput) throws IOException {
        return sniffInternal(extractorInput, false, false);
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput, boolean z) throws IOException {
        return sniffInternal(extractorInput, false, z);
    }
}
