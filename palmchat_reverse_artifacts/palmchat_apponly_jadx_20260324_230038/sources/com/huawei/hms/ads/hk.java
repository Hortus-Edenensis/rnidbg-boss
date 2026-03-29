package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.ErrorType;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public enum hk implements hn {
    GENERIC("generic"),
    VIDEO("video");

    private static final boolean I = hc.Code(hc.l);
    private final String Z;

    /* JADX INFO: renamed from: com.huawei.hms.ads.hk$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[hk.values().length];
            Code = iArr;
            try {
                iArr[hk.GENERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[hk.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    hk(String str) {
        this.Z = str;
    }

    public static ErrorType Code(hk hkVar) {
        if (!I) {
            return null;
        }
        int i = AnonymousClass1.Code[hkVar.ordinal()];
        if (i == 1) {
            return ErrorType.GENERIC;
        }
        if (i != 2) {
            return null;
        }
        return ErrorType.VIDEO;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.Z;
    }

    public static boolean Code() {
        return I;
    }
}
