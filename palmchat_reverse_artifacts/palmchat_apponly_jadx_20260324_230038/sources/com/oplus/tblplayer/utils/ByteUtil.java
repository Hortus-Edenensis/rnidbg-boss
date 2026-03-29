package com.oplus.tblplayer.utils;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ByteUtil {
    private static final String TAG = "ByteUtil";
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] UPPER_CASE_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static String toHexArrayString(byte[] bArr, int i, int i2) {
        if (bArr == null || bArr.length == 0 || i < 0 || i2 <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        int iMin = Math.min(bArr.length, i2 + i) - i;
        while (i < iMin) {
            try {
                sb.append(toHexString(bArr[i], true));
            } catch (Exception e) {
                Log.e(TAG, "toHexArrayString: " + e.getMessage());
            }
            sb.append(i != iMin + (-1) ? " " : "}");
            i++;
        }
        return sb.toString();
    }

    public static String toHexString(byte b, boolean z) {
        char[] cArr = z ? UPPER_CASE_DIGITS : DIGITS;
        return new String(new char[]{cArr[(b >> 4) & 15], cArr[b & 15]}, 0, 2);
    }
}
