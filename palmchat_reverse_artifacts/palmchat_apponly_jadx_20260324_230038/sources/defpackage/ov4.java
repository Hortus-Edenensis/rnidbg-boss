package defpackage;

import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.Renderer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ov4 {
    public static long b(Renderer renderer, long j, long j2) {
        return (renderer.getState() == 1 && (renderer.isReady() || renderer.isEnded())) ? 1000000L : 10000L;
    }

    public static void a(Renderer renderer) {
    }

    public static void c(Renderer renderer) {
    }

    public static void d(Renderer renderer, float f, float f2) throws ExoPlaybackException {
    }
}
