package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.media.PlayerState;
import com.zenmen.palmchat.peoplematch.bean.PeopleMatchCardBean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public enum ht implements hn {
    MINIMIZED("minimized"),
    COLLAPSED("collapsed"),
    NORMAL(PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL),
    EXPANDED("expanded"),
    FULLSCREEN("fullscreen");

    private static boolean C;
    private final String S;

    /* JADX INFO: renamed from: com.huawei.hms.ads.ht$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[ht.values().length];
            Code = iArr;
            try {
                iArr[ht.MINIMIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[ht.COLLAPSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[ht.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[ht.EXPANDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Code[ht.FULLSCREEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        C = false;
        C = hc.Code("com.iab.omid.library.huawei.adsession.media.PlayerState");
    }

    ht(String str) {
        this.S = str;
    }

    public static PlayerState Code(ht htVar) {
        if (!C) {
            return null;
        }
        int i = AnonymousClass1.Code[htVar.ordinal()];
        if (i == 1) {
            return PlayerState.MINIMIZED;
        }
        if (i == 2) {
            return PlayerState.COLLAPSED;
        }
        if (i == 3) {
            return PlayerState.NORMAL;
        }
        if (i == 4) {
            return PlayerState.EXPANDED;
        }
        if (i != 5) {
            return null;
        }
        return PlayerState.FULLSCREEN;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.S;
    }

    public static boolean Code() {
        return C;
    }
}
