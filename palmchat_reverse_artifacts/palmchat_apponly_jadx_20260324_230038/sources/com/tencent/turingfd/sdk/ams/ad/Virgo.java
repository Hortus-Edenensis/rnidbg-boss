package com.tencent.turingfd.sdk.ams.ad;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Virgo {

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.Virgo$do, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class Cdo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10748a;
        public int b;
        public int c;
        public String d;
        public int e;

        public Cdo(int i, int i2, String str, int i3, String str2, int i4) {
            this.f10748a = i;
            this.b = i2;
            this.d = str;
            this.c = i3;
            this.e = i4;
        }

        public String toString() {
            return "" + String.format("% 6d", Integer.valueOf(this.f10748a)) + "    " + String.format("% 6d", Integer.valueOf(this.b)) + "    " + String.format("% 6d", Integer.valueOf(this.c)) + "    " + this.d;
        }
    }

    public static String a(int i) {
        byte[] bArrA;
        try {
            byte[] bArrA2 = Cstrictfp.a(String.format(Locale.SIMPLIFIED_CHINESE, "/proc/%d/cmdline", Integer.valueOf(i)), 100);
            String str = bArrA2 != null ? new String(bArrA2, 0, a(bArrA2, 0, (char) 0)) : "";
            if (!TextUtils.isEmpty(str) || (bArrA = Cstrictfp.a(String.format(Locale.SIMPLIFIED_CHINESE, "/proc/%d/status", Integer.valueOf(i)), 150)) == null) {
                return str;
            }
            int iA = a(bArrA, 7, '\n');
            return iA == 0 ? "" : new String(bArrA, 6, iA - 6);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Cdo b(int i) {
        String strA;
        int i2;
        int i3;
        String str;
        int i4;
        int i5;
        int i6;
        try {
            strA = a(i);
            try {
                String str2 = i != -1 ? new String(Cstrictfp.a(String.format(Locale.SIMPLIFIED_CHINESE, "/proc/%d/status", Integer.valueOf(i)))) : new String(Cstrictfp.a(String.format(Locale.SIMPLIFIED_CHINESE, "/proc/self/status", new Object[0])));
                HashMap map = new HashMap();
                for (String str3 : str2.split("\n")) {
                    String[] strArrSplit = str3.split(":");
                    if (strArrSplit.length >= 2) {
                        map.put(strArrSplit[0].trim(), strArrSplit[1].trim());
                    }
                }
                i2 = Integer.parseInt((String) map.get("PPid"));
                try {
                    i3 = Integer.parseInt(((String) map.get("Uid")).split("\\s+")[0]);
                    try {
                        str = strA;
                        i4 = i2;
                        i5 = i3;
                        i6 = Integer.parseInt((String) map.get("TracerPid"));
                    } catch (Throwable unused) {
                        str = strA;
                        i4 = i2;
                        i5 = i3;
                        i6 = -1;
                    }
                } catch (Throwable unused2) {
                    i3 = -1;
                    str = strA;
                    i4 = i2;
                    i5 = i3;
                    i6 = -1;
                    return str == null ? null : null;
                }
            } catch (Throwable unused3) {
                i2 = -1;
                i3 = -1;
                str = strA;
                i4 = i2;
                i5 = i3;
                i6 = -1;
                if (str == null) {
                }
            }
        } catch (Throwable unused4) {
            strA = null;
        }
        if (str == null || i4 == -1 || i5 == -1) {
            return null;
        }
        return new Cdo(i, i4, str, i5, null, i6);
    }

    public static int a(byte[] bArr, int i, char c) {
        int i2;
        int i3 = i - 1;
        while (true) {
            i2 = i3 + 1;
            if (i3 >= bArr.length) {
                return 0;
            }
            if (i2 == bArr.length || bArr[i2] == c) {
                break;
            }
            i3 = i2;
        }
        return i2;
    }
}
