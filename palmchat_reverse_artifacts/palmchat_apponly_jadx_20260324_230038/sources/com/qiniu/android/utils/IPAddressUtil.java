package com.qiniu.android.utils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class IPAddressUtil {
    private static final int INADDR16SZ = 16;
    private static final int INADDR4SZ = 4;
    private static final int INT16SZ = 2;

    public static byte[] convertFromIPv4MappedAddress(byte[] bArr) {
        if (!isIPv4MappedAddress(bArr)) {
            return null;
        }
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 12, bArr2, 0, 4);
        return bArr2;
    }

    public static boolean isIPv4LiteralAddress(String str) {
        return textToNumericFormatV4(str) != null;
    }

    private static boolean isIPv4MappedAddress(byte[] bArr) {
        return bArr.length >= 16 && bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 0 && bArr[4] == 0 && bArr[5] == 0 && bArr[6] == 0 && bArr[7] == 0 && bArr[8] == 0 && bArr[9] == 0 && bArr[10] == -1 && bArr[11] == -1;
    }

    public static boolean isIPv6LiteralAddress(String str) {
        return textToNumericFormatV6(str) != null;
    }

    public static byte[] textToNumericFormatV4(String str) {
        byte[] bArr = new byte[4];
        int length = str.length();
        if (length != 0 && length <= 15) {
            long j = 0;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = str.charAt(i2);
                if (cCharAt != '.') {
                    int iDigit = Character.digit(cCharAt, 10);
                    if (iDigit < 0) {
                        return null;
                    }
                    j = (j * 10) + ((long) iDigit);
                } else {
                    if (j < 0 || j > 255 || i == 3) {
                        return null;
                    }
                    bArr[i] = (byte) (j & 255);
                    j = 0;
                    i++;
                }
            }
            if (j >= 0 && j < (1 << ((4 - i) * 8))) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                            }
                            return bArr;
                        }
                        bArr[3] = (byte) ((j >> 0) & 255);
                        return bArr;
                    }
                    bArr[2] = (byte) ((j >> 8) & 255);
                    bArr[3] = (byte) ((j >> 0) & 255);
                    return bArr;
                }
                bArr[0] = (byte) ((j >> 24) & 255);
                bArr[1] = (byte) ((j >> 16) & 255);
                bArr[2] = (byte) ((j >> 8) & 255);
                bArr[3] = (byte) ((j >> 0) & 255);
                return bArr;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b4, code lost:
    
        if (r13 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b8, code lost:
    
        if ((r14 + 2) <= 16) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ba, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00bb, code lost:
    
        r0 = r14 + 1;
        r4[r14] = (byte) ((r12 >> 8) & 255);
        r14 = r0 + 1;
        r4[r0] = (byte) (r12 & 255);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00cb, code lost:
    
        if (r15 == (-1)) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00cd, code lost:
    
        r0 = r14 - r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00cf, code lost:
    
        if (r14 != 16) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d1, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d2, code lost:
    
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d3, code lost:
    
        if (r10 > r0) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d5, code lost:
    
        r5 = (r15 + r0) - r10;
        r4[16 - r10] = r4[r5];
        r4[r5] = 0;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e4, code lost:
    
        r14 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00e6, code lost:
    
        if (r14 == 16) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00e8, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00e9, code lost:
    
        r0 = convertFromIPv4MappedAddress(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00ed, code lost:
    
        if (r0 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00ef, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00f0, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] textToNumericFormatV6(String str) {
        int i;
        byte[] bArrTextToNumericFormatV4;
        if (str.length() >= 2) {
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[16];
            int length = charArray.length;
            int iIndexOf = str.indexOf("%");
            if (iIndexOf != length - 1) {
                if (iIndexOf != -1) {
                    length = iIndexOf;
                }
                if (charArray[0] != ':') {
                    i = 0;
                } else {
                    if (charArray[1] != ':') {
                        return null;
                    }
                    i = 1;
                }
                int i2 = i;
                int i3 = 0;
                boolean z = false;
                int i4 = 0;
                int i5 = -1;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    int i6 = i + 1;
                    char c = charArray[i];
                    int iDigit = Character.digit(c, 16);
                    if (iDigit != -1) {
                        i3 = (i3 << 4) | iDigit;
                        if (i3 > 65535) {
                            return null;
                        }
                        i = i6;
                        z = true;
                    } else if (c == ':') {
                        if (z) {
                            if (i6 == length || i4 + 2 > 16) {
                                return null;
                            }
                            int i7 = i4 + 1;
                            bArr[i4] = (byte) ((i3 >> 8) & 255);
                            i4 = i7 + 1;
                            bArr[i7] = (byte) (i3 & 255);
                            i = i6;
                            i2 = i;
                            i3 = 0;
                            z = false;
                        } else {
                            if (i5 != -1) {
                                return null;
                            }
                            i = i6;
                            i2 = i;
                            i5 = i4;
                        }
                    } else {
                        if (c != '.' || i4 + 4 > 16) {
                            return null;
                        }
                        String strSubstring = str.substring(i2, length);
                        int i8 = 0;
                        int i9 = 0;
                        while (true) {
                            int iIndexOf2 = strSubstring.indexOf(46, i8);
                            if (iIndexOf2 == -1) {
                                break;
                            }
                            i9++;
                            i8 = iIndexOf2 + 1;
                        }
                        if (i9 != 3 || (bArrTextToNumericFormatV4 = textToNumericFormatV4(strSubstring)) == null) {
                            return null;
                        }
                        int i10 = 0;
                        while (i10 < 4) {
                            bArr[i4] = bArrTextToNumericFormatV4[i10];
                            i10++;
                            i4++;
                        }
                        z = false;
                    }
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
