package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.media.InteractionType;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public enum hs implements hn {
    CLICK("click"),
    INVITATION_ACCEPTED("invitationAccept");

    private static boolean Z;
    String I;

    /* JADX INFO: renamed from: com.huawei.hms.ads.hs$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[hs.values().length];
            Code = iArr;
            try {
                iArr[hs.CLICK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[hs.INVITATION_ACCEPTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        Z = false;
        Z = hc.Code("com.iab.omid.library.huawei.adsession.media.InteractionType");
    }

    hs(String str) {
        this.I = str;
    }

    public static InteractionType Code(hs hsVar) {
        if (!Z) {
            return null;
        }
        int i = AnonymousClass1.Code[hsVar.ordinal()];
        if (i == 1) {
            return InteractionType.CLICK;
        }
        if (i != 2) {
            return null;
        }
        return InteractionType.INVITATION_ACCEPTED;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.I;
    }

    public static boolean Code() {
        return Z;
    }
}
