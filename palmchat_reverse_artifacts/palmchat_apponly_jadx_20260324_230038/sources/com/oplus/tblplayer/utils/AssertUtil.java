package com.oplus.tblplayer.utils;

import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tblplayer.config.Globals;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class AssertUtil {
    public static final boolean ASSERTIONS_ENABLED;

    static {
        ASSERTIONS_ENABLED = Globals.DEBUG && Globals.DEBUG_ASSERTIONS_ENABLED;
    }

    private AssertUtil() {
    }

    public static void checkArgument(boolean z) {
        if (ASSERTIONS_ENABLED && !z) {
            throw new IllegalArgumentException();
        }
    }

    public static int checkArgumentInRange(int i, int i2, int i3, @NonNull String str) {
        if (ASSERTIONS_ENABLED) {
            if (i < i2) {
                throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i2), Integer.valueOf(i3)));
            }
            if (i > i3) {
                throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i2), Integer.valueOf(i3)));
            }
        }
        return i;
    }

    @IntRange(from = 0)
    public static long checkArgumentNonnegative(long j) {
        if (!ASSERTIONS_ENABLED || j >= 0) {
            return j;
        }
        throw new IllegalArgumentException();
    }

    public static int checkIndex(int i, int i2, int i3) {
        if (i < i2 || i >= i3) {
            throw new IndexOutOfBoundsException();
        }
        return i;
    }

    public static void checkMainThread() {
        if (ASSERTIONS_ENABLED && Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Not in applications main thread");
        }
    }

    public static String checkNotEmpty(@Nullable String str) {
        if (ASSERTIONS_ENABLED && TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        return str;
    }

    public static <T> T checkNotNull(@Nullable T t) {
        if (ASSERTIONS_ENABLED) {
            t.getClass();
        }
        return t;
    }

    public static boolean checkState(boolean z) {
        if (!ASSERTIONS_ENABLED || z) {
            return z;
        }
        throw new IllegalStateException();
    }

    public static <T> T checkStateNotNull(@Nullable T t) {
        if (ASSERTIONS_ENABLED && t == null) {
            throw new IllegalStateException();
        }
        return t;
    }

    public static void checkArgument(boolean z, Object obj) {
        if (ASSERTIONS_ENABLED && !z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @IntRange(from = 0)
    public static long checkArgumentNonnegative(long j, @Nullable String str) {
        if (!ASSERTIONS_ENABLED || j >= 0) {
            return j;
        }
        throw new IllegalArgumentException(str);
    }

    public static String checkNotEmpty(@Nullable String str, Object obj) {
        if (ASSERTIONS_ENABLED && TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    public static <T> T checkNotNull(@Nullable T t, Object obj) {
        if (ASSERTIONS_ENABLED && t == null) {
            throw new NullPointerException(String.valueOf(obj));
        }
        return t;
    }

    public static boolean checkState(boolean z, Object obj) {
        if (!ASSERTIONS_ENABLED || z) {
            return z;
        }
        throw new IllegalStateException(String.valueOf(obj));
    }

    public static <T> T checkStateNotNull(@Nullable T t, Object obj) {
        if (ASSERTIONS_ENABLED && t == null) {
            throw new IllegalStateException(String.valueOf(obj));
        }
        return t;
    }

    public static boolean checkState(boolean z, String str, Object... objArr) {
        if (!ASSERTIONS_ENABLED || z) {
            return z;
        }
        throw new IllegalStateException(String.format(str, objArr));
    }
}
