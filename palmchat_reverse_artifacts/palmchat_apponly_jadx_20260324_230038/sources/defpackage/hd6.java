package defpackage;

import android.view.Surface;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.decoder.DecoderCounters;
import com.oplus.tbl.exoplayer2.decoder.DecoderReuseEvaluation;
import com.oplus.tbl.exoplayer2.video.VideoRendererEventListener;
import com.oplus.tbl.exoplayer2.video.VideoStuckResult;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class hd6 {
    public static void j(VideoRendererEventListener videoRendererEventListener, Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
        videoRendererEventListener.onVideoInputFormatChanged(format);
    }

    public static void b(VideoRendererEventListener videoRendererEventListener, @Nullable Surface surface) {
    }

    public static void c(VideoRendererEventListener videoRendererEventListener, Exception exc) {
    }

    public static void e(VideoRendererEventListener videoRendererEventListener, String str) {
    }

    public static void f(VideoRendererEventListener videoRendererEventListener, DecoderCounters decoderCounters) {
    }

    public static void g(VideoRendererEventListener videoRendererEventListener, DecoderCounters decoderCounters) {
    }

    @Deprecated
    public static void i(VideoRendererEventListener videoRendererEventListener, Format format) {
    }

    public static void l(VideoRendererEventListener videoRendererEventListener, VideoStuckResult videoStuckResult) {
    }

    public static void a(VideoRendererEventListener videoRendererEventListener, int i, long j) {
    }

    public static void h(VideoRendererEventListener videoRendererEventListener, long j, int i) {
    }

    public static void d(VideoRendererEventListener videoRendererEventListener, String str, long j, long j2, boolean z) {
    }

    public static void k(VideoRendererEventListener videoRendererEventListener, int i, int i2, int i3, float f) {
    }
}
