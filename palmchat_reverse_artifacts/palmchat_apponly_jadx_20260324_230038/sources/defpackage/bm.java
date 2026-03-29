package defpackage;

import android.media.AudioDeviceInfo;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.Format;
import androidx.media3.common.util.Clock;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.AudioOffloadSupport;
import androidx.media3.exoplayer.audio.AudioSink;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bm {
    public static AudioOffloadSupport a(AudioSink audioSink, Format format) {
        return AudioOffloadSupport.DEFAULT_UNSUPPORTED;
    }

    public static void b(AudioSink audioSink) {
    }

    public static void c(AudioSink audioSink, Clock clock) {
    }

    @RequiresApi(29)
    public static void e(AudioSink audioSink, int i) {
    }

    public static void f(AudioSink audioSink, long j) {
    }

    public static void g(AudioSink audioSink, @Nullable PlayerId playerId) {
    }

    @RequiresApi(23)
    public static void h(AudioSink audioSink, @Nullable AudioDeviceInfo audioDeviceInfo) {
    }

    @RequiresApi(29)
    public static void d(AudioSink audioSink, int i, int i2) {
    }
}
