package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.media.Position;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public enum hz implements hn {
    PREROLL("preroll"),
    MIDROLL("midroll"),
    POSTROLL("postroll"),
    STANDALONE("standalone");

    private static boolean B;
    private final String C;

    /* JADX INFO: renamed from: com.huawei.hms.ads.hz$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[hz.values().length];
            Code = iArr;
            try {
                iArr[hz.PREROLL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[hz.MIDROLL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[hz.POSTROLL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[hz.STANDALONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        B = false;
        B = hc.Code("com.iab.omid.library.huawei.adsession.media.Position");
    }

    hz(String str) {
        this.C = str;
    }

    public static Position Code(hz hzVar) {
        if (!B) {
            return null;
        }
        int i = AnonymousClass1.Code[hzVar.ordinal()];
        if (i != 1 && i != 2) {
            if (i == 3) {
                return Position.POSTROLL;
            }
            if (i != 4) {
                return null;
            }
            return Position.STANDALONE;
        }
        return Position.PREROLL;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.C;
    }

    public static boolean Code() {
        return B;
    }
}
