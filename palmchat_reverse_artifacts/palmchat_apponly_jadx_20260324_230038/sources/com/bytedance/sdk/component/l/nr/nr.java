package com.bytedance.sdk.component.l.nr;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.SeekCompletionListener;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.player.TTPlayerClient;
import com.bykv.vk.component.ttvideo.playerwrapper.MediaPlayerWrapper;
import com.bykv.vk.component.ttvideo.utils.Error;
import com.bykv.vk.openvk.component.video.api.fx.iz;
import com.bykv.vk.openvk.component.video.api.u;
import com.bytedance.sdk.component.utils.rh;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements com.bykv.vk.openvk.component.video.api.u, rh.u {
    public static volatile boolean u = false;
    private int bg;
    private int bq;
    private SurfaceHolder c;
    private SurfaceTexture dw;
    private long jk;
    private TTVideoEngine nr;
    private volatile rh qq;
    private boolean rh;
    private boolean fx = false;
    private boolean b = false;
    private boolean pn = false;
    private boolean iz = false;
    private boolean x = false;
    private boolean n = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5151a = false;
    private long t = 0;
    private long l = 0;
    private long mv = 0;
    private int s = 0;
    private int k = 0;
    private boolean my = false;
    private AtomicBoolean o = new AtomicBoolean(false);
    private AtomicBoolean sx = new AtomicBoolean(false);
    private final List<WeakReference<u.InterfaceC0156u>> q = Collections.synchronizedList(new ArrayList());
    private volatile boolean kj = false;
    private volatile int z = 200;
    private long gi = 0;
    private Runnable d = new Runnable() { // from class: com.bytedance.sdk.component.l.nr.nr.1
        @Override // java.lang.Runnable
        public void run() {
            long jBg = nr.this.bg();
            if (nr.this.sx() > 0) {
                if (nr.this.gi != jBg) {
                    if (com.bykv.vk.openvk.component.video.api.fx.b()) {
                        long unused = nr.this.gi;
                    }
                    nr nrVar = nr.this;
                    nrVar.u(jBg, nrVar.sx());
                }
                nr.this.gi = jBg;
            }
            if (nr.this.iz) {
                nr nrVar2 = nr.this;
                nrVar2.u(nrVar2.sx(), nr.this.sx());
            } else if (nr.this.qq != null) {
                nr.this.qq.postDelayed(this, nr.this.z);
            }
        }
    };
    private final ArrayList<Runnable> h = new ArrayList<>();

    public nr(Context context, String str) {
        u(context, "vd_".concat(String.valueOf(str)), (Looper) null);
    }

    public static boolean bq() {
        return u;
    }

    private void c() {
        if (this.rh) {
            return;
        }
        this.rh = true;
        Iterator it = new ArrayList(this.h).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.h.clear();
        this.rh = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dw() {
        this.n = true;
        this.b = true;
        if (this.qq != null) {
            this.qq.sendEmptyMessage(100);
        }
    }

    private void kj() {
        this.nr.setVideoEngineSimpleCallback(new VideoEngineSimpleCallback() { // from class: com.bytedance.sdk.component.l.nr.nr.2
            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferEnd(int i) {
                if (nr.this.s == i) {
                    nr.this.l += System.currentTimeMillis() - nr.this.mv;
                }
                for (WeakReference weakReference : nr.this.q) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((u.InterfaceC0156u) weakReference.get()).u((com.bykv.vk.openvk.component.video.api.u) nr.this, i);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferStart(int i, int i2, int i3) {
                nr.this.s = i;
                nr.this.k++;
                nr.this.mv = System.currentTimeMillis();
                for (WeakReference weakReference : nr.this.q) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((u.InterfaceC0156u) weakReference.get()).u(nr.this, i, i2, i3);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferingUpdate(TTVideoEngine tTVideoEngine, int i) {
                for (WeakReference weakReference : nr.this.q) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((u.InterfaceC0156u) weakReference.get()).nr(nr.this, i);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onCompletion(TTVideoEngine tTVideoEngine) {
                nr.this.iz = true;
                if (nr.this.qq != null) {
                    nr.this.qq.removeCallbacks(nr.this.d);
                }
                for (WeakReference weakReference : nr.this.q) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((u.InterfaceC0156u) weakReference.get()).u(nr.this);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onError(Error error) {
                com.bykv.vk.openvk.component.video.api.fx.fx fxVar = new com.bykv.vk.openvk.component.video.api.fx.fx(error.getCode(), error.getInternalCode());
                for (WeakReference weakReference : nr.this.q) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((u.InterfaceC0156u) weakReference.get()).u(nr.this, fxVar);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPrepared(TTVideoEngine tTVideoEngine) {
                nr.this.x = true;
                for (WeakReference weakReference : nr.this.q) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((u.InterfaceC0156u) weakReference.get()).nr(nr.this);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRenderStart(TTVideoEngine tTVideoEngine) {
                nr.this.t = System.currentTimeMillis() - nr.this.jk;
                for (WeakReference weakReference : nr.this.q) {
                    if (weakReference != null && weakReference.get() != null) {
                        u.InterfaceC0156u interfaceC0156u = (u.InterfaceC0156u) weakReference.get();
                        nr nrVar = nr.this;
                        interfaceC0156u.u(nrVar, nrVar.t);
                    }
                }
                nr.this.my = true;
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onVideoSizeChanged(TTVideoEngine tTVideoEngine, int i, int i2) {
                nr.this.bg = i;
                nr.this.bq = i2;
                for (WeakReference weakReference : nr.this.q) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((u.InterfaceC0156u) weakReference.get()).u((com.bykv.vk.openvk.component.video.api.u) nr.this, i, i2);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onUseMDLCacheEnd() {
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPrepare(TTVideoEngine tTVideoEngine) {
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRenderSeekComplete(int i) {
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRetry(int i) {
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onLoadStateChanged(TTVideoEngine tTVideoEngine, int i) {
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onMDLHitCache(String str, long j) {
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPlaybackStateChanged(TTVideoEngine tTVideoEngine, int i) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        ArrayList<Runnable> arrayList = this.h;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        c();
    }

    private void qq() {
        ArrayList<Runnable> arrayList = this.h;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.h.clear();
    }

    private void z() {
        this.fx = false;
        this.b = false;
        this.iz = false;
        this.x = false;
        this.n = false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public long bg() {
        try {
            return this.nr.getCurrentPlaybackTime();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.iz.fx.u(th.getMessage());
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public int o() {
        return this.k;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public long sx() {
        return this.nr.getDuration();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(float f) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean a() {
        return this.iz;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean iz() {
        return this.my;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean jk() {
        return this.n;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean k() {
        return this.pn;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public int l() {
        return this.bq;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean mv() {
        return this.nr.getPlaybackState() == 1;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public long my() {
        if (this.k == 0) {
            return 0L;
        }
        if (this.l == 0 && this.mv != 0) {
            this.l = System.currentTimeMillis() - this.mv;
        }
        return this.l;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public SurfaceTexture n() {
        return this.dw;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void pn() {
        qq();
        rh rhVar = this.qq;
        if (rhVar != null) {
            rhVar.removeCallbacksAndMessages(null);
            rhVar.sendEmptyMessage(103);
            if (rhVar.getLooper() != null) {
                rhVar.post(new Runnable() { // from class: com.bytedance.sdk.component.l.nr.nr.10
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!nr.this.kj) {
                                com.bytedance.sdk.component.jk.nr.u.u().u(nr.this.qq);
                            }
                            nr.this.qq = null;
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean s() {
        return this.nr.getPlaybackState() == 2;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public int t() {
        return this.bg;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public SurfaceHolder x() {
        return this.c;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void b() {
        if (this.qq != null) {
            this.qq.sendEmptyMessage(105);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void fx() {
        rh rhVar = this.qq;
        if (rhVar != null) {
            rhVar.removeMessages(100);
            rhVar.sendEmptyMessage(101);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void nr() {
        rh rhVar = this.qq;
        if (rhVar != null) {
            rhVar.postDelayed(this.d, this.z);
            rhVar.post(new Runnable() { // from class: com.bytedance.sdk.component.l.nr.nr.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (nr.this.nr != null) {
                            nr.this.nr.play();
                            for (WeakReference weakReference : nr.this.q) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get();
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private void nr(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!this.pn) {
            runnable.run();
        } else {
            u(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(long j, long j2) {
        for (WeakReference<u.InterfaceC0156u> weakReference : this.q) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().u(this, j, j2);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void fx(boolean z) {
        this.nr.setLooping(z);
    }

    private void u(Context context, String str, Looper looper) {
        this.nr = u.u(context);
        if (looper != null) {
            this.qq = new rh(looper, this);
            this.kj = true;
        } else if (this.qq == null) {
            this.qq = com.bytedance.sdk.component.jk.nr.u.u().u(this, "csj_".concat(String.valueOf(str)));
        }
        kj();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void nr(boolean z) {
        this.f5151a = z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(final SurfaceHolder surfaceHolder) {
        nr(true);
        this.c = surfaceHolder;
        nr(new Runnable() { // from class: com.bytedance.sdk.component.l.nr.nr.4
            @Override // java.lang.Runnable
            public void run() {
                if (nr.this.qq != null) {
                    nr.this.qq.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(final SurfaceTexture surfaceTexture) {
        nr(true);
        this.dw = surfaceTexture;
        nr(new Runnable() { // from class: com.bytedance.sdk.component.l.nr.nr.5
            @Override // java.lang.Runnable
            public void run() {
                if (nr.this.qq != null) {
                    nr.this.qq.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(iz izVar) {
        this.nr.setDirectUrlUseDataLoader(izVar.my(), izVar.o(), (String) null, izVar.pn());
        this.fx = true;
        this.k = 0;
        izVar.my();
        izVar.s();
        izVar.iz();
        izVar.pn();
        izVar.o();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u() {
        TTVideoEngine tTVideoEngine = this.nr;
        boolean zIsMute = tTVideoEngine != null ? tTVideoEngine.isMute() : false;
        this.k = 0;
        this.l = 0L;
        this.mv = 0L;
        this.iz = false;
        u(true, 0L, zIsMute);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(boolean z, long j, boolean z2) {
        if (this.qq != null) {
            this.qq.postDelayed(this.d, this.z);
        }
        this.jk = System.currentTimeMillis();
        this.nr.setStartTime((int) j);
        this.nr.setIsMute(z2);
        if (this.sx.get() && this.fx) {
            dw();
        } else {
            u(new Runnable() { // from class: com.bytedance.sdk.component.l.nr.nr.6
                @Override // java.lang.Runnable
                public void run() {
                    nr.this.dw();
                }
            });
        }
        this.o.set(true);
        if (!this.sx.get() || this.qq == null) {
            return;
        }
        this.qq.post(new Runnable() { // from class: com.bytedance.sdk.component.l.nr.nr.7
            @Override // java.lang.Runnable
            public void run() {
                nr.this.q();
            }
        });
    }

    private synchronized void u(Runnable runnable) {
        this.h.add(runnable);
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        int i = message.what;
        try {
            if (i == 105) {
                TTVideoEngine tTVideoEngine = this.nr;
                if (tTVideoEngine != null) {
                    tTVideoEngine.stop();
                    return;
                }
                return;
            }
            if (i == 110) {
                TTVideoEngine tTVideoEngine2 = this.nr;
                if (tTVideoEngine2 != null) {
                    tTVideoEngine2.setSurfaceHolder((SurfaceHolder) message.obj);
                    this.sx.set(true);
                    if (this.o.get()) {
                        q();
                        return;
                    }
                    return;
                }
                return;
            }
            if (i != 111) {
                switch (i) {
                    case 100:
                        TTVideoEngine tTVideoEngine3 = this.nr;
                        if (tTVideoEngine3 != null) {
                            tTVideoEngine3.play();
                        }
                        break;
                    case 101:
                        if (this.nr != null && this.qq != null) {
                            this.nr.pause();
                            for (WeakReference<u.InterfaceC0156u> weakReference : this.q) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get();
                                }
                            }
                            this.qq.removeCallbacks(this.d);
                        }
                        break;
                    case 102:
                        z();
                        break;
                    case 103:
                        TTVideoEngine tTVideoEngine4 = this.nr;
                        if (tTVideoEngine4 != null) {
                            tTVideoEngine4.release();
                        }
                        this.pn = true;
                        for (WeakReference<u.InterfaceC0156u> weakReference2 : this.q) {
                            if (weakReference2 != null && weakReference2.get() != null) {
                                weakReference2.get().fx(this);
                            }
                        }
                        break;
                }
                return;
            }
            TTVideoEngine tTVideoEngine5 = this.nr;
            if (tTVideoEngine5 != null) {
                tTVideoEngine5.setSurface(new Surface((SurfaceTexture) message.obj));
                this.sx.set(true);
                if (this.o.get()) {
                    q();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(long j) {
        if (this.b) {
            this.nr.seekTo((int) j, new SeekCompletionListener() { // from class: com.bytedance.sdk.component.l.nr.nr.9
                @Override // com.bykv.vk.component.ttvideo.SeekCompletionListener
                public void onCompletion(boolean z) {
                    for (WeakReference weakReference : nr.this.q) {
                        if (weakReference != null && weakReference.get() != null) {
                            ((u.InterfaceC0156u) weakReference.get()).u(nr.this, z);
                        }
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(u.InterfaceC0156u interfaceC0156u) {
        if (interfaceC0156u == null) {
            return;
        }
        for (WeakReference<u.InterfaceC0156u> weakReference : this.q) {
            if (weakReference != null && weakReference.get() == interfaceC0156u) {
                return;
            }
        }
        this.q.add(new WeakReference<>(interfaceC0156u));
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(int i) {
        this.z = i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(boolean z) {
        this.nr.setIsMute(z);
    }

    public static void u(Context context, String str, int i, String[] strArr, long[] jArr, boolean z, final fx fxVar) {
        boolean z2;
        try {
            TTPlayerClient.create(new MediaPlayerWrapper(), com.bykv.vk.openvk.component.video.api.fx.getContext()).release();
            u.u(context, str, i, strArr, jArr, new VideoEventEngineUploader() { // from class: com.bytedance.sdk.component.l.nr.nr.3
                @Override // com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader
                public void onEvent(String str2, JSONObject jSONObject) {
                    fxVar.u(str2, jSONObject);
                }
            });
            u.u(z);
            z2 = true;
        } catch (Throwable unused) {
            z2 = false;
        }
        u = z2;
    }
}
