package com.huawei.hms.ads;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@com.huawei.openalliance.ad.annotations.b
public abstract class jg {
    public static boolean B(String str) {
        Integer numCode = com.huawei.openalliance.ad.utils.bd.Code(str, 14);
        return numCode != null && 1 == numCode.intValue();
    }

    public static int C(String str) {
        Integer numCode = com.huawei.openalliance.ad.utils.bd.Code(str, 15);
        if (numCode != null) {
            return numCode.intValue();
        }
        return 1;
    }

    public static boolean Code(String str) {
        Integer numCode = com.huawei.openalliance.ad.utils.bd.Code(str, 2);
        return (numCode == null || numCode.intValue() == 0) ? false : true;
    }

    public static int D(String str) {
        Integer numCode = com.huawei.openalliance.ad.utils.bd.Code(str, 1, 1);
        if (numCode != null) {
            return numCode.intValue();
        }
        return 0;
    }

    public static boolean F(String str) {
        Integer numCode = com.huawei.openalliance.ad.utils.bd.Code(str, 0, 1);
        return numCode != null && 1 == numCode.intValue();
    }

    @com.huawei.openalliance.ad.annotations.b
    public static boolean I(String str) {
        Integer numCode = com.huawei.openalliance.ad.utils.bd.Code(str, 9);
        return numCode == null || 1 == numCode.intValue();
    }

    public static boolean L(String str) {
        Integer numCode = com.huawei.openalliance.ad.utils.bd.Code(str, 2, 1);
        return numCode != null && numCode.intValue() == 1;
    }

    public static int S(String str) {
        Integer numCode = com.huawei.openalliance.ad.utils.bd.Code(str, 20);
        if (numCode != null) {
            return numCode.intValue();
        }
        return 1;
    }

    public static boolean V(String str) {
        Integer numCode = com.huawei.openalliance.ad.utils.bd.Code(str, 0);
        return numCode == null || 1 == numCode.intValue();
    }

    @com.huawei.openalliance.ad.annotations.b
    public static boolean Z(String str) {
        Integer numCode = com.huawei.openalliance.ad.utils.bd.Code(str, 12);
        return numCode != null && 1 == numCode.intValue();
    }

    public static int a(String str) {
        Integer numCode = com.huawei.openalliance.ad.utils.bd.Code(str, 3, 1);
        if (numCode == null) {
            return 0;
        }
        return numCode.intValue();
    }

    public static boolean b(String str) {
        Integer numCode = com.huawei.openalliance.ad.utils.bd.Code(str, 4, 1);
        return numCode != null && numCode.intValue() == 1;
    }

    public static boolean c(String str) {
        Integer numCode = com.huawei.openalliance.ad.utils.bd.Code(str, 6, 1);
        return numCode != null && numCode.intValue() == 1;
    }

    public static boolean d(String str) {
        Integer numCode = com.huawei.openalliance.ad.utils.bd.Code(str, 7, 1);
        return numCode != null && numCode.intValue() == 1;
    }
}
