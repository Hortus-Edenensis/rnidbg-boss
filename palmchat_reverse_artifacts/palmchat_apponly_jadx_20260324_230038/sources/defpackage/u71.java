package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.audio.d;
import com.google.android.exoplayer2.audio.i;
import com.google.android.exoplayer2.mediacodec.b;
import com.google.android.exoplayer2.mediacodec.c;
import com.google.android.exoplayer2.mediacodec.e;
import com.google.android.exoplayer2.metadata.a;
import com.google.android.exoplayer2.z;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class u71 implements vv4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21154a;
    public boolean e;
    public boolean g;
    public boolean h;
    public boolean i;
    public final b b = new b();
    public int c = 0;
    public long d = 5000;
    public e f = e.f5903a;

    public u71(Context context) {
        this.f21154a = context;
    }

    @Override // defpackage.vv4
    public z[] a(Handler handler, oe6 oe6Var, d dVar, gv5 gv5Var, to3 to3Var) {
        ArrayList<z> arrayList = new ArrayList<>();
        h(this.f21154a, this.c, this.f, this.e, handler, oe6Var, this.d, arrayList);
        AudioSink audioSinkC = c(this.f21154a, this.g, this.h, this.i);
        if (audioSinkC != null) {
            b(this.f21154a, this.c, this.f, this.e, audioSinkC, handler, dVar, arrayList);
        }
        g(this.f21154a, gv5Var, handler.getLooper(), this.c, arrayList);
        e(this.f21154a, to3Var, handler.getLooper(), this.c, arrayList);
        d(this.f21154a, this.c, arrayList);
        f(this.f21154a, handler, this.c, arrayList);
        return (z[]) arrayList.toArray(new z[0]);
    }

    public void b(Context context, int i, e eVar, boolean z, AudioSink audioSink, Handler handler, d dVar, ArrayList<z> arrayList) {
        int i2;
        int i3;
        int i4;
        arrayList.add(new i(context, i(), eVar, z, handler, dVar, audioSink));
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            try {
                i2 = size + 1;
                try {
                    arrayList.add(size, (z) Class.forName("com.google.android.exoplayer2.decoder.midi.MidiRenderer").getConstructor(new Class[0]).newInstance(new Object[0]));
                    y53.f("DefaultRenderersFactory", "Loaded MidiRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i2;
                    i2 = size;
                }
            } catch (Exception e) {
                throw new RuntimeException("Error instantiating MIDI extension", e);
            }
        } catch (ClassNotFoundException unused2) {
        }
        try {
            try {
                i3 = i2 + 1;
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating Opus extension", e2);
            }
        } catch (ClassNotFoundException unused3) {
        }
        try {
            arrayList.add(i2, (z) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, d.class, AudioSink.class).newInstance(handler, dVar, audioSink));
            y53.f("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
        } catch (ClassNotFoundException unused4) {
            i2 = i3;
            i3 = i2;
        }
        try {
            try {
                i4 = i3 + 1;
                try {
                    arrayList.add(i3, (z) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, d.class, AudioSink.class).newInstance(handler, dVar, audioSink));
                    y53.f("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                } catch (ClassNotFoundException unused5) {
                    i3 = i4;
                    i4 = i3;
                }
            } catch (Exception e3) {
                throw new RuntimeException("Error instantiating FLAC extension", e3);
            }
        } catch (ClassNotFoundException unused6) {
        }
        try {
            arrayList.add(i4, (z) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, d.class, AudioSink.class).newInstance(handler, dVar, audioSink));
            y53.f("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
        } catch (ClassNotFoundException unused7) {
        } catch (Exception e4) {
            throw new RuntimeException("Error instantiating FFmpeg extension", e4);
        }
    }

    @Nullable
    public AudioSink c(Context context, boolean z, boolean z2, boolean z3) {
        return new DefaultAudioSink.f(context).i(z).h(z2).j(z3 ? 1 : 0).g();
    }

    public void d(Context context, int i, ArrayList<z> arrayList) {
        arrayList.add(new sy());
    }

    public void e(Context context, to3 to3Var, Looper looper, int i, ArrayList<z> arrayList) {
        arrayList.add(new a(to3Var, looper));
    }

    public void g(Context context, gv5 gv5Var, Looper looper, int i, ArrayList<z> arrayList) {
        arrayList.add(new hv5(gv5Var, looper));
    }

    public void h(Context context, int i, e eVar, boolean z, Handler handler, oe6 oe6Var, long j, ArrayList<z> arrayList) {
        int i2;
        arrayList.add(new bg3(context, i(), eVar, j, z, handler, oe6Var, 50));
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            try {
                i2 = size + 1;
                try {
                    arrayList.add(size, (z) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Long.TYPE, Handler.class, oe6.class, Integer.TYPE).newInstance(Long.valueOf(j), handler, oe6Var, 50));
                    y53.f("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i2;
                    i2 = size;
                }
            } catch (Exception e) {
                throw new RuntimeException("Error instantiating VP9 extension", e);
            }
        } catch (ClassNotFoundException unused2) {
        }
        try {
            arrayList.add(i2, (z) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, oe6.class, Integer.TYPE).newInstance(Long.valueOf(j), handler, oe6Var, 50));
            y53.f("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
        } catch (ClassNotFoundException unused3) {
        } catch (Exception e2) {
            throw new RuntimeException("Error instantiating AV1 extension", e2);
        }
    }

    public c.b i() {
        return this.b;
    }

    public void f(Context context, Handler handler, int i, ArrayList<z> arrayList) {
    }
}
