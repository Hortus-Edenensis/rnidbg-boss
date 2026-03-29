package com.bytedance.sdk.openadsdk.core.video.u;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.b.fx;
import com.bykv.vk.openvk.component.video.api.fx.iz;
import com.bykv.vk.openvk.component.video.api.fx.pn;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderTextureView;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.multipro.nr.u;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.nr;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.gi.jk;
import com.bytedance.sdk.openadsdk.gi.t;
import com.bytedance.sdk.openadsdk.iz.fx.o;
import com.bytedance.sdk.openadsdk.iz.nr.b;
import com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u implements fx, rh.u, u.InterfaceC0273u, nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected WeakReference<Context> f5395a;
    protected com.bykv.vk.openvk.component.video.api.u b;
    protected iz c;
    protected SurfaceTexture fx;
    protected bc iz;
    protected com.bykv.vk.openvk.component.video.api.fx.nr kj;
    protected long my;
    protected SurfaceHolder nr;
    protected com.bytedance.sdk.openadsdk.core.video.nativevideo.iz pn;
    protected InterfaceC0303u q;
    protected volatile String qq;
    protected List<Runnable> t;
    protected final rh u = new rh(Looper.getMainLooper(), this);
    protected long x = 0;
    protected long n = 0;
    protected boolean jk = false;
    protected boolean l = true;
    protected long mv = 0;
    protected boolean s = false;
    protected boolean k = false;
    protected boolean o = false;
    protected volatile boolean sx = false;
    protected boolean bg = false;
    protected boolean bq = false;
    public com.bytedance.sdk.openadsdk.iz.nr.u dw = new com.bytedance.sdk.openadsdk.iz.nr.u();
    protected Runnable z = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.u.u.1
        @Override // java.lang.Runnable
        public void run() {
            boolean z = u.this.jk;
            u.this.bf();
        }
    };
    private final AtomicBoolean gi = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.video.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0303u {
        void u(long j, long j2);
    }

    private boolean q() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.iz izVar = this.pn;
        if (izVar == null) {
            return false;
        }
        com.bykv.vk.openvk.component.video.api.renderview.nr nrVarO = izVar.o();
        return (nrVarO instanceof SSRenderTextureView) || (nrVarO instanceof UpieVideoView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qq() {
        Iterator it = new ArrayList(this.t).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.t.clear();
    }

    public void a(boolean z) {
        this.bq = z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public boolean b() {
        return false;
    }

    public void bf() {
        this.u.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.u.u.3
            @Override // java.lang.Runnable
            public void run() {
                u uVar = u.this;
                if (uVar.b != null) {
                    boolean z = uVar.jk;
                    u.this.b.nr();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public boolean bg() {
        return this.o;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public boolean bq() {
        return this.bg;
    }

    public boolean d() {
        return true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void fx(long j) {
        this.mv = j;
    }

    public com.bykv.vk.openvk.component.video.api.fx.nr gi() {
        bc bcVar;
        if (!dw.nr().bg() || (bcVar = this.iz) == null) {
            return null;
        }
        long jNr = jk.u(bcVar.oi()).nr(this.c);
        int iU = b.u(this.iz, this.c, jNr);
        com.bykv.vk.openvk.component.video.api.fx.b bVarKj = this.c.kj();
        return new pn.u().u("video_life").u(jp.jk(this.iz)).b(jp.u(this.iz, "")).fx(this.iz.xx()).nr(this.iz.lk()).nr(this.iz.oi()).fx(iU).u(jNr).u(bVarKj != null ? bVarKj.iz() : -1.0d).u();
    }

    public boolean h() {
        WeakReference<Context> weakReference = this.f5395a;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public void ja() {
        List<Runnable> list = this.t;
        if (list == null || list.isEmpty() || this.sx) {
            return;
        }
        com.bytedance.sdk.component.utils.jk.nr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.u.u.2
            @Override // java.lang.Runnable
            public void run() {
                u.this.qq();
            }
        });
    }

    public void jk(boolean z) {
        o.u uVar = new o.u();
        uVar.nr(true);
        uVar.fx(z);
        iz izVarNr = b.nr(this.pn);
        if (izVarNr != null) {
            izVarNr.u("EXTRA_PLAY_START", y());
        }
        fx(this.pn, uVar);
    }

    public void jp() {
        if (this.c == null) {
            return;
        }
        this.qq = b.u();
        com.bykv.vk.openvk.component.video.api.fx.nr nrVar = this.kj;
        if (nrVar != null) {
            nrVar.nr(this.qq);
        }
        this.dw.fx(1);
        this.c.u("EXTRA_PLAY_START", y());
        b.u(this.iz, (com.bykv.vk.openvk.component.video.api.nr.u) this.pn, this.c, true, this.qq);
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public long l() {
        if (o() == null) {
            return 0L;
        }
        return o().my();
    }

    public void m() {
        o.u uVar = new o.u();
        uVar.u(t());
        uVar.fx(s());
        uVar.nr(l());
        iz izVarNr = b.nr(this.pn);
        if (izVarNr != null) {
            izVarNr.u("EXTRA_PLAY_ACTION", y());
        }
        nr(sx(), uVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.nr.u.InterfaceC0273u
    public boolean m_() {
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public boolean my() {
        return this.k;
    }

    public void n(boolean z) {
        this.sx = z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void nr(long j) {
        this.x = j;
        long j2 = this.n;
        if (j2 > j) {
            j = j2;
        }
        this.n = j;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public com.bykv.vk.openvk.component.video.api.u o() {
        return this.b;
    }

    public boolean pb() {
        return this.l;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public boolean pn() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.nr.u.InterfaceC0273u
    public com.bytedance.sdk.openadsdk.core.multipro.nr.u r_() {
        com.bytedance.sdk.openadsdk.core.multipro.nr.u uVar = new com.bytedance.sdk.openadsdk.core.multipro.nr.u();
        uVar.x = this.x;
        uVar.u = bq();
        uVar.n = bg();
        uVar.b = dw();
        return uVar;
    }

    public boolean rh() {
        if ((!this.pn.mv() || !this.jk) && !t.u(this.iz) && !com.bytedance.sdk.openadsdk.pn.u.nr(this.iz)) {
            u("not exec pending");
            return false;
        }
        n(false);
        ja();
        return true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public long s() {
        com.bykv.vk.openvk.component.video.api.u uVar = this.b;
        if (uVar == null) {
            return 0L;
        }
        return uVar.sx();
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public long t() {
        return this.x;
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    /* JADX INFO: renamed from: wq, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.iz sx() {
        return this.pn;
    }

    public void xg() {
        o.u uVar = new o.u();
        uVar.u(t());
        uVar.fx(s());
        uVar.nr(l());
        uVar.iz(mv());
        iz izVarNr = b.nr(this.pn);
        if (izVarNr != null) {
            izVarNr.u("EXTRA_PLAY_ACTION", y());
        }
        b.b(this.pn, uVar);
    }

    public Map<String, Object> y() {
        return null;
    }

    public void z() {
        if (this.b == null) {
            return;
        }
        if (q()) {
            SurfaceTexture surfaceTexture = this.fx;
            if (surfaceTexture == null || surfaceTexture == this.b.n()) {
                return;
            }
            this.b.u(this.fx);
            return;
        }
        SurfaceHolder surfaceHolder = this.nr;
        if (surfaceHolder == null || surfaceHolder == this.b.x()) {
            return;
        }
        this.b.u(this.nr);
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void b(long j) {
        this.my = j;
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void fx(boolean z) {
        this.bg = z;
    }

    public void fx(Map<String, Object> map) {
        o.u uVar = new o.u();
        uVar.u(t());
        uVar.fx(s());
        uVar.nr(l());
        iz izVarNr = b.nr(this.pn);
        if (izVarNr != null) {
            izVarNr.u("EXTRA_PLAY_ACTION", y());
        }
        if (map != null) {
            uVar.u(map);
        }
        u(this.pn, uVar);
    }

    public void nr(Runnable runnable) {
        if (this.t == null) {
            this.t = new ArrayList();
        }
        this.t.add(runnable);
    }

    public void u(Runnable runnable) {
        if (runnable == null || this.iz == null) {
            return;
        }
        if ((!this.pn.mv() || !this.jk) && !t.u(this.iz) && !com.bytedance.sdk.openadsdk.pn.u.nr(this.iz)) {
            nr(runnable);
        } else {
            runnable.run();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.u
    public void nr(com.bykv.vk.openvk.component.video.api.b.nr nrVar, SurfaceTexture surfaceTexture) {
        this.jk = false;
        com.bykv.vk.openvk.component.video.api.u uVar = this.b;
        if (uVar != null) {
            uVar.nr(false);
        }
        this.fx = null;
        ja();
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.u
    public void u(com.bykv.vk.openvk.component.video.api.b.nr nrVar, SurfaceTexture surfaceTexture) {
        this.jk = true;
        this.fx = surfaceTexture;
        com.bykv.vk.openvk.component.video.api.u uVar = this.b;
        if (uVar != null) {
            uVar.u(surfaceTexture);
            this.b.nr(this.jk);
        }
        ja();
    }

    public void fx(com.bykv.vk.openvk.component.video.api.nr.u uVar, o.u uVar2) {
        this.dw.fx(2);
        b.u(uVar, uVar2);
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void nr(boolean z) {
        this.o = z;
        com.bykv.vk.openvk.component.video.api.u uVar = this.b;
        if (uVar != null) {
            uVar.u(z);
        }
    }

    public void fx(int i) {
        com.bykv.vk.openvk.component.video.api.u uVar = this.b;
        if (uVar != null) {
            uVar.u(i);
        }
    }

    public void nr(int i) {
        if (this.dw.b(1)) {
            if (!this.l) {
                i *= 10;
            }
            u(-900001, i, "only play start", (JSONArray) null);
        }
        JSONArray jSONArray = new JSONArray();
        if (this.dw.u(1)) {
            return;
        }
        String strNr = jp.nr(this.iz);
        JSONObject jSONObjectU = u(4, strNr);
        if (jSONObjectU != null) {
            jSONArray.put(jSONObjectU);
        }
        JSONObject jSONObjectU2 = u(2, strNr);
        if (jSONObjectU2 != null) {
            jSONArray.put(jSONObjectU2);
        }
        JSONObject jSONObjectU3 = u(8, strNr);
        if (jSONObjectU3 != null) {
            jSONArray.put(jSONObjectU3);
        }
        JSONObject jSONObjectU4 = u(32, strNr);
        if (jSONObjectU4 != null) {
            jSONArray.put(jSONObjectU4);
        }
        JSONObject jSONObjectU5 = u(64, strNr);
        if (jSONObjectU5 != null) {
            jSONArray.put(jSONObjectU5);
        }
        JSONObject jSONObjectU6 = u(128, strNr);
        if (jSONObjectU6 != null) {
            jSONArray.put(jSONObjectU6);
        }
        u(-900002, -701, "lack play start", jSONArray);
    }

    @Override // com.bykv.vk.openvk.component.video.api.b.fx
    public void u(boolean z) {
        this.l = z;
        com.bytedance.sdk.openadsdk.core.video.nativevideo.iz izVar = this.pn;
        if (izVar != null) {
            izVar.b(z);
        }
    }

    public void u(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error", str);
        } catch (JSONException unused) {
        }
        s.u().u("video", jSONObject, (Throwable) null);
    }

    public void u(int i, int i2, String str, JSONArray jSONArray) {
        if (this.f5395a == null) {
            return;
        }
        o.u uVar = new o.u();
        uVar.nr(l());
        uVar.fx(s());
        uVar.u(t());
        uVar.u(i);
        uVar.nr(i2);
        uVar.u(jSONArray);
        if (this.dw.u(256)) {
            return;
        }
        this.dw.fx(256);
        b.u(sx(), uVar, str, !this.dw.u(2) ? 1 : 0, this.dw.u(128));
    }

    private JSONObject u(int i, String str) {
        String str2;
        try {
            if (this.dw.u(128)) {
                str2 = "endcard_skip";
            } else if (this.dw.u(8)) {
                str2 = "feed_continue";
            } else if (this.dw.u(4)) {
                str2 = "feed_pause";
            } else if (this.dw.u(2)) {
                str2 = "feed_play";
            } else if (this.dw.u(64)) {
                str2 = "feed_over";
            } else {
                str2 = this.dw.u(32) ? "feed_break" : null;
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("tag", str);
                jSONObject.putOpt("label", str2);
                jSONObject.putOpt("time", this.dw.nr(i));
                return jSONObject;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void nr(com.bykv.vk.openvk.component.video.api.nr.u uVar, o.u uVar2) {
        this.dw.fx(8);
        b.nr(sx(), uVar2);
    }

    public void u(com.bykv.vk.openvk.component.video.api.nr.u uVar, o.u uVar2) {
        this.dw.fx(4);
        b.u(this.pn, uVar2, !this.dw.u(2) ? 1 : 0);
    }

    public void u(InterfaceC0303u interfaceC0303u) {
        this.q = interfaceC0303u;
    }

    public void u(long j, long j2) {
        if (!this.gi.get() && dw.nr().lk() && (j * 1.0d) / j2 > 0.3d) {
            this.gi.set(true);
            com.bytedance.sdk.openadsdk.core.k.fx.pn().u("videoPercent30", this.iz);
        }
    }
}
