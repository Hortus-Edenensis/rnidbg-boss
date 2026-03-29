package com.opos.exoplayer.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.video.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultRenderersFactory implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8081a;

    @Nullable
    private final com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.e> b;
    private final int c;
    private final long d;

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ExtensionRendererMode {
    }

    public DefaultRenderersFactory(Context context) {
        this(context, null);
    }

    public void a(Context context, Handler handler, int i, ArrayList<q> arrayList) {
    }

    public DefaultRenderersFactory(Context context, @Nullable com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.e> bVar) {
        this(context, bVar, 0);
    }

    public void a(Context context, @Nullable com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.e> bVar, long j, Handler handler, com.opos.exoplayer.core.video.f fVar, int i, ArrayList<q> arrayList) {
        arrayList.add(new c(context, com.opos.exoplayer.core.b.c.f8114a, j, bVar, false, handler, fVar, 50));
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            arrayList.add(size, (q) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Boolean.TYPE, Long.TYPE, Handler.class, com.opos.exoplayer.core.video.f.class, Integer.TYPE).newInstance(Boolean.TRUE, Long.valueOf(j), handler, fVar, 50));
            com.opos.cmn.an.f.a.a("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
        } catch (ClassNotFoundException unused) {
        } catch (Exception e) {
            throw new RuntimeException("Error instantiating VP9 extension", e);
        }
    }

    public DefaultRenderersFactory(Context context, @Nullable com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.e> bVar, int i) {
        this(context, bVar, i, 5000L);
    }

    public void a(Context context, @Nullable com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.e> bVar, com.opos.exoplayer.core.a.d[] dVarArr, Handler handler, com.opos.exoplayer.core.a.e eVar, int i, ArrayList<q> arrayList) {
        int i2;
        int i3;
        arrayList.add(new com.opos.exoplayer.core.a.i(com.opos.exoplayer.core.b.c.f8114a, bVar, true, handler, eVar, com.opos.exoplayer.core.a.c.a(context), dVarArr));
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
            } catch (Exception e) {
                throw new RuntimeException("Error instantiating Opus extension", e);
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            arrayList.add(size, (q) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, com.opos.exoplayer.core.a.e.class, com.opos.exoplayer.core.a.d[].class).newInstance(handler, eVar, dVarArr));
            com.opos.cmn.an.f.a.a("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
        } catch (ClassNotFoundException unused2) {
            size = i2;
            i2 = size;
        }
        try {
            try {
                i3 = i2 + 1;
                try {
                    arrayList.add(i2, (q) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, com.opos.exoplayer.core.a.e.class, com.opos.exoplayer.core.a.d[].class).newInstance(handler, eVar, dVarArr));
                    com.opos.cmn.an.f.a.a("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                } catch (ClassNotFoundException unused3) {
                    i2 = i3;
                    i3 = i2;
                }
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating FLAC extension", e2);
            }
        } catch (ClassNotFoundException unused4) {
        }
        try {
            arrayList.add(i3, (q) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.opos.exoplayer.core.a.e.class, com.opos.exoplayer.core.a.d[].class).newInstance(handler, eVar, dVarArr));
            com.opos.cmn.an.f.a.a("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
        } catch (ClassNotFoundException unused5) {
        } catch (Exception e3) {
            throw new RuntimeException("Error instantiating FFmpeg extension", e3);
        }
    }

    public DefaultRenderersFactory(Context context, @Nullable com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.e> bVar, int i, long j) {
        this.f8081a = context;
        this.b = bVar;
        this.c = i;
        this.d = j;
    }

    public void a(Context context, com.opos.exoplayer.core.metadata.e eVar, Looper looper, int i, ArrayList<q> arrayList) {
        arrayList.add(new com.opos.exoplayer.core.metadata.f(eVar, looper));
    }

    public void a(Context context, com.opos.exoplayer.core.text.h hVar, Looper looper, int i, ArrayList<q> arrayList) {
        arrayList.add(new com.opos.exoplayer.core.text.i(hVar, looper));
    }

    public com.opos.exoplayer.core.a.d[] a() {
        return new com.opos.exoplayer.core.a.d[0];
    }

    @Override // com.opos.exoplayer.core.t
    public q[] a(Handler handler, com.opos.exoplayer.core.video.f fVar, com.opos.exoplayer.core.a.e eVar, com.opos.exoplayer.core.text.h hVar, com.opos.exoplayer.core.metadata.e eVar2) {
        ArrayList<q> arrayList = new ArrayList<>();
        a(this.f8081a, this.b, this.d, handler, fVar, this.c, arrayList);
        a(this.f8081a, this.b, a(), handler, eVar, this.c, arrayList);
        a(this.f8081a, hVar, handler.getLooper(), this.c, arrayList);
        a(this.f8081a, eVar2, handler.getLooper(), this.c, arrayList);
        a(this.f8081a, handler, this.c, arrayList);
        return (q[]) arrayList.toArray(new q[arrayList.size()]);
    }
}
