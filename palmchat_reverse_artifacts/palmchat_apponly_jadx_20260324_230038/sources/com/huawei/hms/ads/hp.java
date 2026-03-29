package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.Owner;
import com.zenmen.palmchat.maintab.config.TurnInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public enum hp implements hn {
    NATIVE(TurnInfo.TYPE_NATIVE),
    JAVASCRIPT("javascript"),
    NONE("none");

    private static boolean Z;
    private final String B;

    /* JADX INFO: renamed from: com.huawei.hms.ads.hp$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[hp.values().length];
            Code = iArr;
            try {
                iArr[hp.NATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[hp.JAVASCRIPT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[hp.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        Z = false;
        Z = hc.Code(hc.o);
    }

    hp(String str) {
        this.B = str;
    }

    public static Owner Code(hp hpVar) {
        if (!Z) {
            return null;
        }
        int i = AnonymousClass1.Code[hpVar.ordinal()];
        if (i == 1) {
            return Owner.NATIVE;
        }
        if (i == 2) {
            return Owner.JAVASCRIPT;
        }
        if (i != 3) {
            return null;
        }
        return Owner.NONE;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.B;
    }

    public static boolean Code() {
        return Z;
    }
}
