package com.ss.android.u;

import android.support.v4.media.session.PlaybackStateCompat;
import com.huawei.openalliance.ad.constant.x;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class fx {
    private static final char[] u = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private long b;
        private int fx;
        private int nr;
        private String pn;
        private int u;

        private u() {
        }
    }

    private static String nr(File file, int i, long j) throws Exception {
        return u(new com.ss.android.u.u(file), i, j);
    }

    public static String u(File file) {
        return u(file, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    private static long nr(String str) throws RuntimeException {
        return (Long.parseLong(str, 16) - 31) >> 4;
    }

    public static String u(File file, int i, long j) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return nr(file, i, j);
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static int u(String str, File file) {
        return u(str, file, (nr) null);
    }

    public static int u(String str, File file, nr nrVar) {
        int i;
        long j;
        String strNr;
        if (str == null || str.length() == 0) {
            return 2;
        }
        try {
            if (nrVar != null) {
                if (nrVar.u() <= 0) {
                    try {
                        nrVar.nr();
                    } catch (Throwable unused) {
                    }
                    return 5;
                }
            } else if (file == null || !file.exists()) {
                return 5;
            }
            try {
                u uVarU = u(str);
                if (uVarU == null) {
                    i = -1;
                    j = -1;
                } else {
                    if (uVarU.u > 1) {
                        return 3;
                    }
                    i = uVarU.fx;
                    j = uVarU.b;
                }
                u uVarU2 = null;
                try {
                    if (nrVar != null) {
                        strNr = u(nrVar, i, j);
                    } else {
                        strNr = nr(file, i, j);
                    }
                } catch (Throwable unused2) {
                    strNr = null;
                }
                if (strNr != null && strNr.length() != 0) {
                    if (uVarU != null && (uVarU.u != 1 || uVarU.nr != 1)) {
                        if (uVarU.pn != null) {
                            try {
                                uVarU2 = u(strNr);
                            } catch (Throwable unused3) {
                            }
                            if (uVarU2 != null && uVarU.fx == uVarU2.fx && uVarU.b == uVarU2.b && uVarU.pn.equals(uVarU2.pn)) {
                                return 0;
                            }
                        }
                    } else if (strNr.equals(str)) {
                        return 0;
                    }
                    return 1;
                }
                return 6;
            } catch (Throwable unused4) {
                return 4;
            }
        } catch (Throwable unused5) {
            return 99;
        }
    }

    private static String u(nr nrVar, int i, long j) throws Exception {
        long j2;
        int i2 = i;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        if (messageDigest == null) {
            return "";
        }
        try {
            long jU = nrVar.u();
            long j3 = 0;
            if (i2 <= 0 || j <= 0 || ((long) i2) * j > (8 * jU) / 10) {
                j2 = jU;
                i2 = 1;
            } else {
                j2 = j;
            }
            byte[] bArr = new byte[8192];
            u(nrVar, messageDigest, bArr, 0L, j2);
            if (i2 > 2) {
                int i3 = i2 - 1;
                long j4 = (jU - (((long) i2) * j2)) / ((long) i3);
                int i4 = 1;
                while (i4 < i3) {
                    j3 += j2 + j4;
                    u(nrVar, messageDigest, bArr, j3, j2);
                    i4++;
                    i3 = i3;
                }
            }
            if (i2 > 1) {
                u(nrVar, messageDigest, bArr, jU - j2, j2);
            }
            String strU = u(messageDigest.digest());
            if (i2 == 1 && j2 == jU) {
                return strU;
            }
            String str = u(i2, j2) + x.aQ + strU;
            try {
                nrVar.nr();
            } catch (Throwable unused) {
            }
            return str;
        } finally {
            try {
                nrVar.nr();
            } catch (Throwable unused2) {
            }
        }
    }

    private static void u(nr nrVar, MessageDigest messageDigest, byte[] bArr, long j, long j2) throws IOException {
        nrVar.u(j, j2);
        long j3 = 0;
        while (j3 < j2) {
            int iU = nrVar.u(bArr, 0, (int) Math.min(j2 - j3, bArr.length));
            if (iU > 0) {
                messageDigest.update(bArr, 0, iU);
                j3 += (long) iU;
            } else {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + iU + ", readTotalCount = " + j3 + ", sampleSize = " + j2);
            }
        }
    }

    private static String u(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            int i = length * 2;
            char[] cArr = new char[i];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = bArr[i3 + 0] & UByte.MAX_VALUE;
                int i5 = i2 + 1;
                char[] cArr2 = u;
                cArr[i2] = cArr2[i4 >> 4];
                i2 = i5 + 1;
                cArr[i5] = cArr2[i4 & 15];
            }
            return new String(cArr, 0, i);
        }
        throw new NullPointerException("bytes is null");
    }

    private static String u(int i, long j) {
        return "ttmd5:1:1:" + u(i) + "g" + u(j);
    }

    private static u u(String str) throws Exception {
        if (!str.startsWith("ttmd5:")) {
            return null;
        }
        String[] strArrSplit = str.split(x.aQ);
        String[] strArrSplit2 = strArrSplit[0].split(":");
        u uVar = new u();
        uVar.u = Integer.parseInt(strArrSplit2[1]);
        if (uVar.u > 1) {
            return uVar;
        }
        uVar.nr = Integer.parseInt(strArrSplit2[2]);
        String[] strArrSplit3 = strArrSplit2[3].split("g");
        uVar.fx = (int) nr(strArrSplit3[0]);
        uVar.b = nr(strArrSplit3[1]);
        uVar.pn = strArrSplit[1];
        return uVar;
    }

    private static String u(long j) {
        return Long.toHexString((j << 4) + 31);
    }
}
