package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.CreativeType;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public enum hj implements hn {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    VIDEO("video"),
    AUDIO("audio");

    private static boolean C;
    private final String S;

    /* JADX INFO: renamed from: com.huawei.hms.ads.hj$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[hj.values().length];
            Code = iArr;
            try {
                iArr[hj.DEFINED_BY_JAVASCRIPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[hj.HTML_DISPLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[hj.NATIVE_DISPLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[hj.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Code[hj.AUDIO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        C = false;
        C = hc.Code(hc.k);
    }

    hj(String str) {
        this.S = str;
    }

    public static CreativeType Code(hj hjVar) {
        if (!C) {
            return null;
        }
        int i = AnonymousClass1.Code[hjVar.ordinal()];
        if (i == 1) {
            return CreativeType.DEFINED_BY_JAVASCRIPT;
        }
        if (i == 2) {
            return CreativeType.HTML_DISPLAY;
        }
        if (i == 3) {
            return CreativeType.NATIVE_DISPLAY;
        }
        if (i == 4) {
            return CreativeType.VIDEO;
        }
        if (i != 5) {
            return null;
        }
        return CreativeType.AUDIO;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.S;
    }

    public static boolean Code() {
        return C;
    }
}
