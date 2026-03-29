package com.bytedance.sdk.component.l.u;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.ILiveListener;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.ILiveSettingBundle;
import com.bykv.vk.component.ttvideo.INetworkClient;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.VideoLiveManager;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.bykv.vk.openvk.component.video.api.fx;
import com.bykv.vk.openvk.component.video.api.fx.iz;
import com.bykv.vk.openvk.component.video.api.u;
import com.bytedance.sdk.component.nr.u.l;
import com.bytedance.sdk.component.nr.u.my;
import com.bytedance.sdk.component.nr.u.s;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.openadsdk.api.plugin.nr;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements com.bykv.vk.openvk.component.video.api.u, rh.u {
    private int b;
    private final Context fx;
    private SurfaceTexture gi;
    private volatile iz h;
    private rh iz;
    private long o;
    private boolean pb;
    private int pn;
    private long q;
    private ILivePlayer u;
    private JSONObject wq;
    private volatile boolean x;
    private boolean xg;
    private SurfaceHolder z;
    private final List<WeakReference<u.InterfaceC0156u>> nr = Collections.synchronizedList(new ArrayList());
    private AtomicBoolean n = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f5153a = new AtomicBoolean(false);
    private volatile boolean jk = false;
    private volatile boolean t = false;
    private volatile boolean l = false;
    private volatile boolean mv = false;
    private volatile boolean s = false;
    private volatile boolean k = false;
    private volatile boolean my = true;
    private long sx = 0;
    private long bg = 0;
    private final int bq = 0;
    private int dw = 0;
    private long c = 0;
    private long qq = 0;
    private volatile boolean kj = false;
    private volatile int d = 200;
    private long rh = 0;
    private final ArrayList<Runnable> ja = new ArrayList<>();
    private final Runnable bf = new Runnable() { // from class: com.bytedance.sdk.component.l.u.u.1
        @Override // java.lang.Runnable
        public void run() {
            long jBg = u.this.bg();
            u.this.qq += (long) u.this.d;
            if (u.this.sx() > 0 && u.this.rh != jBg) {
                fx.b();
                u uVar = u.this;
                uVar.u(jBg, uVar.sx());
            }
            u.this.rh = jBg;
            if (u.this.bg() >= u.this.q) {
                u.this.mv = true;
                u.this.pn();
                for (WeakReference weakReference : u.this.nr) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((u.InterfaceC0156u) weakReference.get()).u(u.this);
                    }
                }
            }
            if (u.this.mv) {
                u uVar2 = u.this;
                uVar2.u(uVar2.sx(), u.this.sx());
            } else if (u.this.iz != null) {
                u.this.iz.postDelayed(this, u.this.d);
            }
        }
    };
    private final ILiveListener m = new ILiveListener() { // from class: com.bytedance.sdk.component.l.u.u.7
        private boolean nr = false;

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onCompletion() {
            if (u.this.iz == null) {
                return;
            }
            u.this.iz.removeCallbacks(u.this.bf);
            for (WeakReference weakReference : u.this.nr) {
                if (weakReference != null && weakReference.get() != null) {
                    ((u.InterfaceC0156u) weakReference.get()).u(u.this, -1, -1, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onError(LiveError liveError) {
            if (liveError != null) {
                if (this.nr) {
                    return;
                }
                this.nr = true;
                com.bykv.vk.openvk.component.video.api.fx.fx fxVar = new com.bykv.vk.openvk.component.video.api.fx.fx(liveError.code, 0, liveError.getInfoJSON());
                for (WeakReference weakReference : u.this.nr) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((u.InterfaceC0156u) weakReference.get()).u(u.this, fxVar);
                    }
                }
            }
            u.this.my = true;
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onFirstFrame(boolean z) {
            if (u.this.iz == null) {
                return;
            }
            u.this.kj = true;
            u.this.iz.removeCallbacks(u.this.bf);
            if (u.this.q > 0) {
                u.this.iz.postDelayed(u.this.bf, u.this.d);
            }
            u.this.my = false;
            if (!z) {
                for (WeakReference weakReference : u.this.nr) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((u.InterfaceC0156u) weakReference.get()).u((com.bykv.vk.openvk.component.video.api.u) u.this, -1);
                    }
                }
                return;
            }
            u.this.sx = System.currentTimeMillis() - u.this.o;
            for (WeakReference weakReference2 : u.this.nr) {
                if (weakReference2 != null && weakReference2.get() != null) {
                    u.InterfaceC0156u interfaceC0156u = (u.InterfaceC0156u) weakReference2.get();
                    u uVar = u.this;
                    interfaceC0156u.u(uVar, uVar.sx);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onMonitorLog(JSONObject jSONObject, String str) {
            for (WeakReference weakReference : u.this.nr) {
                if (weakReference != null && weakReference.get() != null) {
                    ((u.InterfaceC0156u) weakReference.get()).u(u.this, jSONObject, str);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onPrepared() {
            u.this.s = true;
            for (WeakReference weakReference : u.this.nr) {
                if (weakReference != null && weakReference.get() != null) {
                    ((u.InterfaceC0156u) weakReference.get()).nr(u.this);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onStallEnd() {
            if (u.this.iz == null) {
                return;
            }
            if (u.this.q > 0) {
                u.this.iz.postDelayed(u.this.bf, u.this.d);
            }
            u.this.bg += System.currentTimeMillis() - u.this.c;
            for (WeakReference weakReference : u.this.nr) {
                if (weakReference != null && weakReference.get() != null) {
                    ((u.InterfaceC0156u) weakReference.get()).u((com.bykv.vk.openvk.component.video.api.u) u.this, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onStallStart() {
            if (u.this.iz == null) {
                return;
            }
            u.o(u.this);
            u.this.c = System.currentTimeMillis();
            u.this.iz.removeCallbacks(u.this.bf);
            for (WeakReference weakReference : u.this.nr) {
                if (weakReference != null && weakReference.get() != null) {
                    ((u.InterfaceC0156u) weakReference.get()).u(u.this, -1, -1, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onVideoSizeChanged(int i, int i2) {
            u.this.b = i;
            u.this.pn = i2;
            for (WeakReference weakReference : u.this.nr) {
                if (weakReference != null && weakReference.get() != null) {
                    ((u.InterfaceC0156u) weakReference.get()).u((com.bykv.vk.openvk.component.video.api.u) u.this, i, i2);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onCacheFileCompletion() {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onAbrSwitch(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onAudioRenderStall(int i) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onResolutionDegrade(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onSeiUpdate(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onVideoRenderStall(int i) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onReportALog(int i, String str) {
        }
    };

    /* JADX INFO: renamed from: com.bytedance.sdk.component.l.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0223u implements INetworkClient {
        private final l u;

        public C0223u() {
            l.u uVarNr = fx.fx().nr();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.u = uVarNr.u(10L, timeUnit).nr(10L, timeUnit).fx(10L, timeUnit).u();
        }

        @Override // com.bykv.vk.component.ttvideo.INetworkClient
        public INetworkClient.Result doPost(String str, String str2) {
            return null;
        }

        @Override // com.bykv.vk.component.ttvideo.INetworkClient
        public INetworkClient.Result doRequest(String str, String str2) {
            String str3;
            String strNr;
            String str4 = null;
            String string = null;
            JSONObject jSONObject = null;
            try {
                try {
                    my myVarNr = this.u.u(new s.u().u(str).nr("host", str2).nr()).nr();
                    if (myVarNr.b()) {
                        strNr = myVarNr.iz().nr();
                        try {
                            string = myVarNr.x().toString();
                            jSONObject = new JSONObject(strNr);
                        } catch (JSONException e) {
                            e = e;
                            String str5 = string;
                            str4 = strNr;
                            str3 = str5;
                            return INetworkClient.Result.newBuilder().setBody(str4).setHeader(str3).setException(e).build();
                        }
                    } else {
                        strNr = null;
                    }
                    return INetworkClient.Result.newBuilder().setResponse(jSONObject).setBody(strNr).build();
                } catch (JSONException e2) {
                    e = e2;
                    str3 = null;
                }
            } catch (IOException e3) {
                return INetworkClient.Result.newBuilder().setException(e3).build();
            } catch (Exception e4) {
                return INetworkClient.Result.newBuilder().setException(e4).build();
            }
        }
    }

    public u(Context context, boolean z, long j, JSONObject jSONObject, Looper looper) {
        this.iz = null;
        this.x = false;
        this.q = 0L;
        this.fx = context;
        this.wq = jSONObject;
        this.q = j > 0 ? j * 1000 : -1L;
        if (looper != null) {
            this.iz = new rh(looper, this);
            this.x = true;
        } else if (this.iz == null) {
            this.iz = com.bytedance.sdk.component.jk.nr.u.u().u(this, "tt-live-video-player");
        }
        b(z);
    }

    private synchronized void c() {
        if (this.pb) {
            return;
        }
        this.pb = true;
        Iterator it = new ArrayList(this.ja).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.ja.clear();
        this.pb = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dw() {
        ArrayList<Runnable> arrayList = this.ja;
        if (arrayList != null && !arrayList.isEmpty()) {
            c();
        }
    }

    public static /* synthetic */ int o(u uVar) {
        int i = uVar.dw;
        uVar.dw = i + 1;
        return i;
    }

    private void q() {
        rh rhVar = this.iz;
        if (rhVar == null || rhVar.getLooper() == null) {
            return;
        }
        this.iz.post(new Runnable() { // from class: com.bytedance.sdk.component.l.u.u.6
            @Override // java.lang.Runnable
            public void run() {
                if (u.this.iz == null || u.this.iz.getLooper() == null) {
                    return;
                }
                try {
                    u.this.gi = null;
                    u.this.z = null;
                    if (u.this.x) {
                        u.this.iz.removeCallbacksAndMessages(null);
                    } else {
                        com.bytedance.sdk.component.jk.nr.u.u().u(u.this.iz);
                    }
                    u.this.iz = null;
                } catch (Throwable unused) {
                }
            }
        });
    }

    public String bq() {
        return "";
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void fx(boolean z) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(float f) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean a() {
        return this.mv;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public long bg() {
        return this.qq;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean jk() {
        return this.k;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean k() {
        return this.t;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public int l() {
        return this.pn;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean mv() {
        ILivePlayer iLivePlayer = this.u;
        if (iLivePlayer == null) {
            return false;
        }
        try {
            return iLivePlayer.isPlaying();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public long my() {
        return this.bg;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public SurfaceTexture n() {
        return this.gi;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public int o() {
        return this.dw;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean s() {
        return this.my;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public long sx() {
        return this.q;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public int t() {
        return this.b;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(long j) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public SurfaceHolder x() {
        return this.z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean iz() {
        return this.kj;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void pn() {
        rh rhVar = this.iz;
        if (rhVar != null) {
            rhVar.removeCallbacks(this.bf);
            rhVar.sendEmptyMessage(103);
            q();
        }
    }

    private void b(final boolean z) {
        rh rhVar = this.iz;
        if (rhVar != null) {
            rhVar.post(new Runnable() { // from class: com.bytedance.sdk.component.l.u.u.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ILiveSettingBundle iLiveSettingBundle = new ILiveSettingBundle() { // from class: com.bytedance.sdk.component.l.u.u.2.1
                            /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
                            /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
                            @Override // com.bykv.vk.component.ttvideo.ILiveSettingBundle
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public <T> T getSettingsValueForKey(String str, T t) {
                                Object objValueOf;
                                str.hashCode();
                                if (str.equals("live_enable_close_play_retry")) {
                                    if (t.getClass() == Integer.class) {
                                        objValueOf = Integer.valueOf("1");
                                    }
                                    return t.getClass() != Boolean.class ? (T) Boolean.TRUE : (T) objValueOf;
                                }
                                if (!str.equals("live_sdk_cancel_sdk_dns_fail_retry")) {
                                    return t;
                                }
                                objValueOf = t;
                                if (t.getClass() != Boolean.class) {
                                }
                            }
                        };
                        u uVar = u.this;
                        uVar.u = VideoLiveManager.newBuilder(uVar.fx).setProjectKey("pangle_ad_live").setNetworkClient(new C0223u()).setForceHttpDns(false).setForceTTNetHttpDns(false).setSettingsBundle(iLiveSettingBundle).setPlayerType(1).setListener(u.this.m).build();
                        u.this.u.setIntOption(69, z ? 1 : 0);
                        u.this.u.setStringOption(72, nr.u(u.this.fx, null).getAbsolutePath() + "/pangle_live/");
                    } catch (Exception e) {
                        com.bykv.vk.openvk.component.video.api.iz.fx.u("TTLiveVideoPlayer", e.getMessage());
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void fx() {
        bg();
        rh rhVar = this.iz;
        if (rhVar != null) {
            rhVar.removeCallbacks(this.bf);
            rhVar.sendEmptyMessage(101);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void nr() {
        rh rhVar = this.iz;
        if (rhVar != null) {
            rhVar.post(new Runnable() { // from class: com.bytedance.sdk.component.l.u.u.5
                @Override // java.lang.Runnable
                public void run() {
                    if (u.this.u == null || u.this.mv()) {
                        return;
                    }
                    try {
                        u.this.u.play();
                        u uVar = u.this;
                        uVar.u(uVar.xg);
                        for (WeakReference weakReference : u.this.nr) {
                            if (weakReference != null && weakReference.get() != null) {
                                weakReference.get();
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    u.this.my = false;
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void b() {
        bg();
        rh rhVar = this.iz;
        if (rhVar != null) {
            rhVar.removeCallbacks(this.bf);
            rhVar.sendEmptyMessage(105);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void nr(boolean z) {
        this.l = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(long j, long j2) {
        for (WeakReference<u.InterfaceC0156u> weakReference : this.nr) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().u(this, j, j2);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(iz izVar) {
        if (izVar == null) {
            return;
        }
        this.h = izVar;
        izVar.my();
        rh rhVar = this.iz;
        if (rhVar != null) {
            rhVar.sendEmptyMessage(107);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u() {
        this.dw = 0;
        this.bg = 0L;
        this.c = 0L;
        u(true, 0L, false);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(boolean z, final long j, final boolean z2) {
        rh rhVar;
        if (this.f5153a.get() && this.jk && this.u != null) {
            this.qq = j;
            this.o = System.currentTimeMillis();
            u(z2);
            rh rhVar2 = this.iz;
            if (rhVar2 != null) {
                rhVar2.sendEmptyMessage(100);
            }
        } else {
            u(new Runnable() { // from class: com.bytedance.sdk.component.l.u.u.3
                @Override // java.lang.Runnable
                public void run() {
                    u.this.qq = j;
                    u.this.o = System.currentTimeMillis();
                    u.this.u(z2);
                    if (u.this.iz != null) {
                        u.this.iz.sendEmptyMessage(100);
                    }
                }
            });
        }
        this.n.set(true);
        if (!this.f5153a.get() || (rhVar = this.iz) == null) {
            return;
        }
        rhVar.post(new Runnable() { // from class: com.bytedance.sdk.component.l.u.u.4
            @Override // java.lang.Runnable
            public void run() {
                u.this.dw();
            }
        });
    }

    private synchronized void u(Runnable runnable) {
        this.ja.add(runnable);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(boolean z) {
        this.xg = z;
        ILivePlayer iLivePlayer = this.u;
        if (iLivePlayer != null) {
            try {
                iLivePlayer.setMute(Boolean.valueOf(z));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(SurfaceHolder surfaceHolder) {
        this.z = surfaceHolder;
        rh rhVar = this.iz;
        if (rhVar != null) {
            rhVar.obtainMessage(110, surfaceHolder).sendToTarget();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(SurfaceTexture surfaceTexture) {
        this.gi = surfaceTexture;
        rh rhVar = this.iz;
        if (rhVar != null) {
            rhVar.obtainMessage(111, surfaceTexture).sendToTarget();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(u.InterfaceC0156u interfaceC0156u) {
        if (interfaceC0156u == null) {
            return;
        }
        for (WeakReference<u.InterfaceC0156u> weakReference : this.nr) {
            if (weakReference != null && weakReference.get() == interfaceC0156u) {
                return;
            }
        }
        this.nr.add(new WeakReference<>(interfaceC0156u));
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(int i) {
        this.d = i;
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        try {
            switch (message.what) {
                case 100:
                    nr();
                    this.k = true;
                    break;
                case 101:
                    ILivePlayer iLivePlayer = this.u;
                    if (iLivePlayer != null) {
                        try {
                            iLivePlayer.stop();
                            for (WeakReference<u.InterfaceC0156u> weakReference : this.nr) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get();
                                }
                                break;
                            }
                        } catch (Throwable unused) {
                        }
                        this.my = true;
                    }
                    break;
                case 102:
                    ILivePlayer iLivePlayer2 = this.u;
                    if (iLivePlayer2 != null) {
                        try {
                            iLivePlayer2.reset();
                            break;
                        } catch (Throwable unused2) {
                        }
                        this.my = true;
                    }
                    break;
                case 103:
                    ILivePlayer iLivePlayer3 = this.u;
                    if (iLivePlayer3 != null) {
                        try {
                            iLivePlayer3.release();
                            break;
                        } catch (Throwable unused3) {
                        }
                        this.t = true;
                        this.my = true;
                    }
                    break;
                case 105:
                    ILivePlayer iLivePlayer4 = this.u;
                    if (iLivePlayer4 != null) {
                        try {
                            iLivePlayer4.stop();
                            break;
                        } catch (Throwable unused4) {
                        }
                        this.my = true;
                    }
                    break;
                case 107:
                    if (this.u != null && this.h != null) {
                        String strMy = this.h.my();
                        u(strMy);
                        this.u.setStreamInfo(strMy);
                        this.jk = true;
                        this.dw = 0;
                        break;
                    }
                    break;
                case 110:
                    ILivePlayer iLivePlayer5 = this.u;
                    if (iLivePlayer5 != null) {
                        SurfaceHolder surfaceHolder = (SurfaceHolder) message.obj;
                        iLivePlayer5.setSurfaceHolder(surfaceHolder);
                        this.u.setSurface(surfaceHolder.getSurface());
                        this.f5153a.set(true);
                        if (this.n.get()) {
                            dw();
                        }
                    }
                    break;
                case 111:
                    ILivePlayer iLivePlayer6 = this.u;
                    if (iLivePlayer6 != null) {
                        iLivePlayer6.setSurface(new Surface(this.gi));
                        this.f5153a.set(true);
                        if (this.n.get()) {
                            dw();
                        }
                    }
                    break;
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void u(String str) {
        String str2 = LiveConfigKey.LOW;
        try {
            JSONObject jSONObject = this.wq;
            if (jSONObject == null) {
                return;
            }
            int iOptInt = jSONObject.optInt("enable");
            String strOptString = jSONObject.optString("appids");
            if (iOptInt == 1 && !TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObject2 = new JSONObject(str);
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("common");
                JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("data");
                if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject2 == null || !strOptString.contains(jSONObjectOptJSONObject.optString("app_id"))) {
                    return;
                }
                if (jSONObjectOptJSONObject2.optJSONObject(LiveConfigKey.UHD) != null) {
                    str2 = LiveConfigKey.UHD;
                } else if (jSONObjectOptJSONObject2.optJSONObject(LiveConfigKey.HIGH) != null) {
                    str2 = LiveConfigKey.HIGH;
                } else if (jSONObjectOptJSONObject2.optJSONObject(LiveConfigKey.STANDARD) != null) {
                    str2 = LiveConfigKey.STANDARD;
                } else if (jSONObjectOptJSONObject2.optJSONObject(LiveConfigKey.LOW) == null) {
                    str2 = null;
                }
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.u.setStringOption(43, str2);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
