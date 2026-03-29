package com.opos.exoplayer.core;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.opos.exoplayer.core.Player;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.o;
import com.opos.exoplayer.core.text.Cue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@TargetApi(16)
public class v implements Player.c, Player.d, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final q[] f8409a;
    private final g b;
    private final b c;
    private final CopyOnWriteArraySet<com.opos.exoplayer.core.video.e> d;
    private final CopyOnWriteArraySet<com.opos.exoplayer.core.text.h> e;
    private final CopyOnWriteArraySet<com.opos.exoplayer.core.metadata.e> f;
    private final CopyOnWriteArraySet<com.opos.exoplayer.core.video.f> g;
    private final CopyOnWriteArraySet<com.opos.exoplayer.core.a.e> h;
    private Format i;
    private Format j;
    private Surface k;
    private boolean l;
    private int m;
    private SurfaceHolder n;
    private TextureView o;
    private com.opos.exoplayer.core.decoder.d p;
    private com.opos.exoplayer.core.decoder.d q;
    private int r;
    private com.opos.exoplayer.core.a.b s;
    private float t;

    /* JADX INFO: compiled from: SearchBox */
    public final class b implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, com.opos.exoplayer.core.a.e, com.opos.exoplayer.core.metadata.e, com.opos.exoplayer.core.text.h, com.opos.exoplayer.core.video.f {
        private b() {
        }

        @Override // com.opos.exoplayer.core.a.e
        public void a(int i) {
            v.this.r = i;
            Iterator it = v.this.h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).a(i);
            }
        }

        @Override // com.opos.exoplayer.core.a.e
        public void b(Format format) {
            v.this.j = format;
            Iterator it = v.this.h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).b(format);
            }
        }

        @Override // com.opos.exoplayer.core.a.e
        public void c(com.opos.exoplayer.core.decoder.d dVar) {
            v.this.q = dVar;
            Iterator it = v.this.h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).c(dVar);
            }
        }

        @Override // com.opos.exoplayer.core.a.e
        public void d(com.opos.exoplayer.core.decoder.d dVar) {
            Iterator it = v.this.h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).d(dVar);
            }
            v.this.j = null;
            v.this.q = null;
            v.this.r = 0;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            v.this.a(new Surface(surfaceTexture), true);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            v.this.a((Surface) null, true);
            return true;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            v.this.a(surfaceHolder.getSurface(), false);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            v.this.a((Surface) null, false);
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(int i, int i2, int i3, float f) {
            Iterator it = v.this.d.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.e) it.next()).a(i, i2, i3, f);
            }
            Iterator it2 = v.this.g.iterator();
            while (it2.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it2.next()).a(i, i2, i3, f);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void b(com.opos.exoplayer.core.decoder.d dVar) {
            Iterator it = v.this.g.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it.next()).b(dVar);
            }
            v.this.i = null;
            v.this.p = null;
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(int i, long j) {
            Iterator it = v.this.g.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it.next()).a(i, j);
            }
        }

        @Override // com.opos.exoplayer.core.a.e
        public void b(String str, long j, long j2) {
            Iterator it = v.this.h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).b(str, j, j2);
            }
        }

        @Override // com.opos.exoplayer.core.a.e
        public void a(int i, long j, long j2) {
            Iterator it = v.this.h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).a(i, j, j2);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(Surface surface) {
            if (v.this.k == surface) {
                Iterator it = v.this.d.iterator();
                while (it.hasNext()) {
                    ((com.opos.exoplayer.core.video.e) it.next()).a();
                }
            }
            Iterator it2 = v.this.g.iterator();
            while (it2.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it2.next()).a(surface);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(Format format) {
            v.this.i = format;
            Iterator it = v.this.g.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it.next()).a(format);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(com.opos.exoplayer.core.decoder.d dVar) {
            v.this.p = dVar;
            Iterator it = v.this.g.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it.next()).a(dVar);
            }
        }

        @Override // com.opos.exoplayer.core.metadata.e
        public void a(Metadata metadata) {
            Iterator it = v.this.f.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.metadata.e) it.next()).a(metadata);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(String str, long j, long j2) {
            Iterator it = v.this.g.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it.next()).a(str, j, j2);
            }
        }

        @Override // com.opos.exoplayer.core.text.h
        public void a(List<Cue> list) {
            Iterator it = v.this.e.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.text.h) it.next()).a(list);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }
    }

    public v(t tVar, com.opos.exoplayer.core.c.h hVar, l lVar) {
        this(tVar, hVar, lVar, com.opos.exoplayer.core.util.e.f8390a);
    }

    private void q() {
        TextureView textureView = this.o;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.c) {
                com.opos.cmn.an.f.a.c("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.o.setSurfaceTextureListener(null);
            }
            this.o = null;
        }
        SurfaceHolder surfaceHolder = this.n;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.c);
            this.n = null;
        }
    }

    @Override // com.opos.exoplayer.core.Player
    public int b(int i) {
        return this.b.b(i);
    }

    @Override // com.opos.exoplayer.core.Player
    public int c() {
        return this.b.c();
    }

    @Override // com.opos.exoplayer.core.Player
    public n e() {
        return this.b.e();
    }

    @Override // com.opos.exoplayer.core.Player
    public com.opos.exoplayer.core.c.g g() {
        return this.b.g();
    }

    @Override // com.opos.exoplayer.core.Player
    public w h() {
        return this.b.h();
    }

    @Override // com.opos.exoplayer.core.Player
    public int i() {
        return this.b.i();
    }

    @Override // com.opos.exoplayer.core.Player
    public int j() {
        return this.b.j();
    }

    @Override // com.opos.exoplayer.core.Player
    public int k() {
        return this.b.k();
    }

    @Override // com.opos.exoplayer.core.Player
    public long l() {
        return this.b.l();
    }

    @Override // com.opos.exoplayer.core.Player
    public long m() {
        return this.b.m();
    }

    @Override // com.opos.exoplayer.core.Player
    public long n() {
        return this.b.n();
    }

    @Override // com.opos.exoplayer.core.Player
    public boolean o() {
        return this.b.o();
    }

    @Override // com.opos.exoplayer.core.Player
    public long p() {
        return this.b.p();
    }

    public v(t tVar, com.opos.exoplayer.core.c.h hVar, l lVar, com.opos.exoplayer.core.util.e eVar) {
        b bVar = new b();
        this.c = bVar;
        this.d = new CopyOnWriteArraySet<>();
        this.e = new CopyOnWriteArraySet<>();
        this.f = new CopyOnWriteArraySet<>();
        this.g = new CopyOnWriteArraySet<>();
        this.h = new CopyOnWriteArraySet<>();
        q[] qVarArrA = tVar.a(new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()), bVar, bVar, bVar, bVar);
        this.f8409a = qVarArrA;
        this.t = 1.0f;
        this.r = 0;
        this.s = com.opos.exoplayer.core.a.b.f8087a;
        this.m = 1;
        this.b = a(qVarArrA, hVar, lVar, eVar);
    }

    @Override // com.opos.exoplayer.core.Player
    public boolean d() {
        return this.b.d();
    }

    @Override // com.opos.exoplayer.core.Player
    public void f() {
        this.b.f();
        q();
        Surface surface = this.k;
        if (surface != null) {
            if (this.l) {
                surface.release();
            }
            this.k = null;
        }
        CopyOnWriteArraySet<com.opos.exoplayer.core.video.e> copyOnWriteArraySet = this.d;
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.clear();
        }
    }

    @Override // com.opos.exoplayer.core.Player
    public Player.d a() {
        return this;
    }

    @Override // com.opos.exoplayer.core.Player
    public Player.c b() {
        return this;
    }

    public g a(q[] qVarArr, com.opos.exoplayer.core.c.h hVar, l lVar, com.opos.exoplayer.core.util.e eVar) {
        return new x(qVarArr, hVar, lVar, eVar);
    }

    @Override // com.opos.exoplayer.core.g
    public o a(o.b bVar) {
        return this.b.a(bVar);
    }

    public void b(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null || surfaceHolder != this.n) {
            return;
        }
        a((SurfaceHolder) null);
    }

    @Override // com.opos.exoplayer.core.Player.d
    public void b(SurfaceView surfaceView) {
        b(surfaceView == null ? null : surfaceView.getHolder());
    }

    public void a(float f) {
        this.t = f;
        for (q qVar : this.f8409a) {
            if (qVar.a() == 1) {
                this.b.a(qVar).a(2).a(Float.valueOf(f)).i();
            }
        }
    }

    @Override // com.opos.exoplayer.core.Player.d
    public void b(TextureView textureView) {
        if (textureView == null || textureView != this.o) {
            return;
        }
        a((TextureView) null);
    }

    @Override // com.opos.exoplayer.core.Player
    public void a(int i) {
        this.b.a(i);
    }

    @Override // com.opos.exoplayer.core.Player
    public void b(Player.b bVar) {
        this.b.b(bVar);
    }

    @Override // com.opos.exoplayer.core.Player
    public void a(int i, long j) {
        this.b.a(i, j);
    }

    @Override // com.opos.exoplayer.core.Player.c
    public void b(com.opos.exoplayer.core.text.h hVar) {
        this.e.remove(hVar);
    }

    @Override // com.opos.exoplayer.core.Player
    public void a(long j) {
        this.b.a(j);
    }

    @Override // com.opos.exoplayer.core.Player.d
    public void b(com.opos.exoplayer.core.video.e eVar) {
        this.d.remove(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Surface surface, boolean z) {
        Surface surface2;
        ArrayList arrayList = new ArrayList();
        for (q qVar : this.f8409a) {
            if (qVar.a() == 2) {
                arrayList.add(this.b.a(qVar).a(1).a(surface).i());
            }
        }
        Surface surface3 = this.k;
        if (surface3 != null && surface3 != surface) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((o) it.next()).j();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            try {
                if (this.l && (surface2 = this.k) != null) {
                    surface2.release();
                }
            } catch (Exception unused2) {
            }
        }
        this.k = surface;
        this.l = z;
    }

    public void a(SurfaceHolder surfaceHolder) {
        q();
        this.n = surfaceHolder;
        Surface surface = null;
        if (surfaceHolder != null) {
            surfaceHolder.addCallback(this.c);
            Surface surface2 = surfaceHolder.getSurface();
            if (surface2 != null && surface2.isValid()) {
                surface = surface2;
            }
        }
        a(surface, false);
    }

    @Override // com.opos.exoplayer.core.Player.d
    public void a(SurfaceView surfaceView) {
        a(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.opos.exoplayer.core.Player.d
    public void a(TextureView textureView) {
        q();
        this.o = textureView;
        Surface surface = null;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != null) {
                com.opos.cmn.an.f.a.c("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
            }
            textureView.setSurfaceTextureListener(this.c);
            SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
            if (surfaceTexture != null) {
                surface = new Surface(surfaceTexture);
            }
        }
        a(surface, true);
    }

    @Override // com.opos.exoplayer.core.Player
    public void a(Player.b bVar) {
        this.b.a(bVar);
    }

    @Override // com.opos.exoplayer.core.g
    public void a(com.opos.exoplayer.core.source.h hVar) {
        this.b.a(hVar);
    }

    @Override // com.opos.exoplayer.core.Player.c
    public void a(com.opos.exoplayer.core.text.h hVar) {
        this.e.add(hVar);
    }

    @Override // com.opos.exoplayer.core.Player.d
    public void a(com.opos.exoplayer.core.video.e eVar) {
        this.d.add(eVar);
    }

    @Override // com.opos.exoplayer.core.Player
    public void a(boolean z) {
        this.b.a(z);
    }
}
