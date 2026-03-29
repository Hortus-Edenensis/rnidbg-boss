package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.FriendlyObstructionPurpose;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public enum hl implements hn {
    VIDEO_CONTROLS,
    CLOSE_AD,
    NOT_VISIBLE,
    OTHER;

    private static boolean B;

    /* JADX INFO: renamed from: com.huawei.hms.ads.hl$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[hl.values().length];
            Code = iArr;
            try {
                iArr[hl.VIDEO_CONTROLS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[hl.CLOSE_AD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[hl.NOT_VISIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[hl.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        B = false;
        B = hc.Code(hc.m);
    }

    public static FriendlyObstructionPurpose Code(hl hlVar) {
        if (!B) {
            return null;
        }
        int i = AnonymousClass1.Code[hlVar.ordinal()];
        if (i == 1) {
            return FriendlyObstructionPurpose.VIDEO_CONTROLS;
        }
        if (i == 2) {
            return FriendlyObstructionPurpose.CLOSE_AD;
        }
        if (i == 3) {
            return FriendlyObstructionPurpose.NOT_VISIBLE;
        }
        if (i != 4) {
            return null;
        }
        return FriendlyObstructionPurpose.OTHER;
    }

    public static boolean Code() {
        return B;
    }
}
