package defpackage;

import android.annotation.SuppressLint;
import androidx.media3.exoplayer.RendererCapabilities;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class sv4 {
    public static int c(int i) {
        return e(i, 0, 0, 0);
    }

    public static int d(int i, int i2, int i3) {
        return g(i, i2, i3, 0, 128, 0);
    }

    public static int e(int i, int i2, int i3, int i4) {
        return g(i, i2, i3, 0, 128, i4);
    }

    public static int f(int i, int i2, int i3, int i4, int i5) {
        return g(i, i2, i3, i4, i5, 0);
    }

    @SuppressLint({"WrongConstant"})
    public static int g(int i, int i2, int i3, int i4, int i5, int i6) {
        return i | i2 | i3 | i4 | i5 | i6;
    }

    @SuppressLint({"WrongConstant"})
    public static int h(int i) {
        return i & 24;
    }

    @SuppressLint({"WrongConstant"})
    public static int i(int i) {
        return i & RendererCapabilities.AUDIO_OFFLOAD_SUPPORT_MASK;
    }

    @SuppressLint({"WrongConstant"})
    public static int j(int i) {
        return i & 384;
    }

    @SuppressLint({"WrongConstant"})
    public static int k(int i) {
        return i & 7;
    }

    @SuppressLint({"WrongConstant"})
    public static int l(int i) {
        return i & 64;
    }

    @SuppressLint({"WrongConstant"})
    public static int m(int i) {
        return i & 32;
    }

    public static boolean n(int i, boolean z) {
        int iK = k(i);
        return iK == 4 || (z && iK == 3);
    }

    public static void a(RendererCapabilities rendererCapabilities) {
    }

    public static void b(RendererCapabilities rendererCapabilities, RendererCapabilities.Listener listener) {
    }
}
