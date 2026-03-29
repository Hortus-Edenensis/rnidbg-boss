package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.media.Position;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public enum hu implements hn {
    PREROLL("preroll"),
    MIDROLL("midroll"),
    POSTROLL("postroll"),
    STANDALONE("standalone");

    private static boolean B;
    private final String C;

    /* JADX INFO: renamed from: com.huawei.hms.ads.hu$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[hu.values().length];
            Code = iArr;
            try {
                iArr[hu.PREROLL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[hu.MIDROLL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[hu.POSTROLL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[hu.STANDALONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        B = false;
        B = hc.Code("com.iab.omid.library.huawei.adsession.media.Position");
    }

    hu(String str) {
        this.C = str;
    }

    public static Position Code(hu huVar) {
        if (!B) {
            return null;
        }
        int i = AnonymousClass1.Code[huVar.ordinal()];
        if (i == 1 || i == 2) {
            return Position.PREROLL;
        }
        if (i == 3) {
            return Position.POSTROLL;
        }
        if (i != 4) {
            return null;
        }
        return Position.STANDALONE;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.C;
    }

    public static boolean Code() {
        return B;
    }
}
