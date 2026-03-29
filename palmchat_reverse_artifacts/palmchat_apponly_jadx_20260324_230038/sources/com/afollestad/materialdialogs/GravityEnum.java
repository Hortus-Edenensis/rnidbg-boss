package com.afollestad.materialdialogs;

import androidx.core.view.GravityCompat;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public enum GravityEnum {
    START,
    CENTER,
    END;

    private static final boolean HAS_RTL = true;

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2497a;

        static {
            int[] iArr = new int[GravityEnum.values().length];
            f2497a = iArr;
            try {
                iArr[GravityEnum.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2497a[GravityEnum.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2497a[GravityEnum.END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public int getGravityInt() {
        int i = a.f2497a[ordinal()];
        if (i == 1) {
            if (HAS_RTL) {
                return GravityCompat.START;
            }
            return 3;
        }
        if (i == 2) {
            return 1;
        }
        if (i != 3) {
            throw new IllegalStateException("Invalid gravity constant");
        }
        if (HAS_RTL) {
            return GravityCompat.END;
        }
        return 5;
    }

    public int getTextAlignment() {
        int i = a.f2497a[ordinal()];
        if (i != 2) {
            return i != 3 ? 5 : 6;
        }
        return 4;
    }
}
