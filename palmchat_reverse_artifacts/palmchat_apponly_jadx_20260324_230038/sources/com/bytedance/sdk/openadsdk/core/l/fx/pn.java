package com.bytedance.sdk.openadsdk.core.l.fx;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bq;
import com.bytedance.sdk.openadsdk.core.kj.my;
import com.bytedance.sdk.openadsdk.core.l.b.fx;
import com.bytedance.sdk.openadsdk.core.nr.u.nr.fx;
import com.bytedance.sdk.openadsdk.core.nr.u.nr.pn;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.pb;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.wq;
import com.huawei.openalliance.ad.constant.az;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class pn extends fx implements rh.u {
    protected final com.bytedance.sdk.openadsdk.core.kj.pn b;
    protected volatile Runnable bq;
    protected Function<SparseArray<Object>, Object> c;
    protected WeakReference<Context> fx;
    protected String iz;
    protected final String k;
    protected com.bytedance.sdk.openadsdk.core.l.nr.pn l;
    protected bc pn;
    protected volatile boolean q;
    protected boolean qq;
    protected s sx;
    protected HashSet<Integer> t;
    private volatile com.bytedance.sdk.openadsdk.core.l.fx.fx.fx z;
    protected final AtomicInteger x = new AtomicInteger(1);
    protected final AtomicBoolean n = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f5332a = false;
    protected final AtomicBoolean jk = new AtomicBoolean(false);
    protected final rh mv = new rh(Looper.getMainLooper(), this);
    protected boolean s = true;
    protected boolean my = false;
    protected volatile boolean o = false;
    protected u bg = new u();
    protected int dw = 0;
    private List<o> gi = new CopyOnWriteArrayList();
    protected final com.bytedance.sdk.openadsdk.core.l.u.fx kj = new com.bytedance.sdk.openadsdk.core.l.u.fx() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.pn.1
        @Override // com.bytedance.sdk.openadsdk.core.l.u.fx
        public void onDownloadActive(long j, long j2, String str) {
            pn.this.x.set(3);
            pn.this.n.set(false);
            if (com.bytedance.sdk.openadsdk.core.multipro.nr.fx()) {
                pn pnVar = pn.this;
                pnVar.u("onDownloadActive", j, j2, str, pnVar.b.fx());
                return;
            }
            pn pnVar2 = pn.this;
            com.bytedance.sdk.openadsdk.core.l.nr.pn pnVar3 = pnVar2.l;
            if (pnVar3 != null) {
                pnVar3.u(j, j2, str, pnVar2.b.fx());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.u.fx
        public void onDownloadFailed(long j, long j2, String str) {
            pn.this.x.set(5);
            if (com.bytedance.sdk.openadsdk.core.multipro.nr.fx()) {
                pn pnVar = pn.this;
                pnVar.u("onDownloadFailed", j, j2, str, pnVar.b.fx());
                return;
            }
            pn pnVar2 = pn.this;
            com.bytedance.sdk.openadsdk.core.l.nr.pn pnVar3 = pnVar2.l;
            if (pnVar3 != null) {
                pnVar3.fx(j, j2, str, pnVar2.b.fx());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.u.fx
        public void onDownloadFinished(long j, long j2, String str) {
            pn.this.x.set(6);
            if (com.bytedance.sdk.openadsdk.core.multipro.nr.fx()) {
                pn pnVar = pn.this;
                pnVar.u("onDownloadFinished", j, j2, str, pnVar.b.fx());
                return;
            }
            pn pnVar2 = pn.this;
            com.bytedance.sdk.openadsdk.core.l.nr.pn pnVar3 = pnVar2.l;
            if (pnVar3 != null) {
                pnVar3.u(j, str, pnVar2.b.fx());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.u.fx
        public void onDownloadPaused(long j, long j2, String str) {
            pn.this.x.set(4);
            pn.this.n.set(false);
            if (com.bytedance.sdk.openadsdk.core.multipro.nr.fx()) {
                pn pnVar = pn.this;
                pnVar.u("onDownloadPaused", j, j2, str, pnVar.b.fx());
                return;
            }
            pn pnVar2 = pn.this;
            com.bytedance.sdk.openadsdk.core.l.nr.pn pnVar3 = pnVar2.l;
            if (pnVar3 != null) {
                pnVar3.nr(j, j2, str, pnVar2.b.fx());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.u.fx
        public void onDownloadStart() {
            pn.this.x.set(2);
            if (com.bytedance.sdk.openadsdk.core.multipro.nr.fx()) {
                pn.this.u("onIdle", 0L, 0L, (String) null, (String) null);
                return;
            }
            com.bytedance.sdk.openadsdk.core.l.nr.pn pnVar = pn.this.l;
            if (pnVar != null) {
                pnVar.u();
            }
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
        public void onIdle() {
            pn.this.x.set(1);
            if (com.bytedance.sdk.openadsdk.core.multipro.nr.fx()) {
                pn.this.u("onIdle", 0L, 0L, (String) null, (String) null);
                return;
            }
            com.bytedance.sdk.openadsdk.core.l.nr.pn pnVar = pn.this.l;
            if (pnVar != null) {
                pnVar.u();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.l.u.fx
        public void onInstalled(long j, long j2, String str) {
            pn.this.x.set(7);
            pn.this.n.set(true);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            String str2 = str;
            if (com.bytedance.sdk.openadsdk.core.multipro.nr.fx()) {
                pn pnVar = pn.this;
                pnVar.u("onInstalled", j, j2, str2, pnVar.b.fx());
                return;
            }
            pn pnVar2 = pn.this;
            com.bytedance.sdk.openadsdk.core.l.nr.pn pnVar3 = pnVar2.l;
            if (pnVar3 != null) {
                pnVar3.u(str2, pnVar2.b.fx());
            }
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public class u extends com.bytedance.sdk.component.jk.a {
        String b;
        long fx;
        long nr;
        String pn;
        String u;

        public u() {
            super("DownloadCallbackRunnable");
        }

        public void fx(String str) {
            this.pn = str;
        }

        public void nr(long j) {
            this.fx = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                pn.this.a().u(pn.this.k, this.u, this.nr, this.fx, this.b, this.pn);
            } catch (Throwable unused) {
            }
        }

        public void u(String str) {
            this.u = str;
        }

        public void nr(String str) {
            this.b = str;
        }

        public void u(long j) {
            this.nr = j;
        }

        public u(String str, long j, long j2, String str2, String str3) {
            super("DownloadCallbackRunnable");
            this.u = str;
            this.nr = j;
            this.fx = j2;
            this.b = str2;
            this.pn = str3;
        }
    }

    public pn(Context context, bc bcVar, String str, boolean z) {
        this.fx = new WeakReference<>(context);
        this.pn = bcVar;
        com.bytedance.sdk.openadsdk.core.kj.pn pnVarPu = bcVar.pu();
        this.b = pnVarPu;
        str = TextUtils.isEmpty(str) ? jp.nr(bcVar) : str;
        this.iz = TextUtils.isEmpty(str) ? "embeded_ad" : str;
        this.k = bcVar.hashCode() + bcVar.xx();
        this.c = com.bytedance.sdk.openadsdk.core.n.o().y();
        if (pnVarPu == null) {
            return;
        }
        if (dw.getContext() == null) {
            dw.u(context);
        }
        this.l = new com.bytedance.sdk.openadsdk.core.l.nr.pn();
        u(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (com.bytedance.sdk.openadsdk.core.multipro.nr.fx()) {
            com.bytedance.sdk.component.jk.x.fx().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.pn.4
                @Override // java.lang.Runnable
                public void run() {
                    s sVarU = s.u.u(com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u(dw.getContext()).u(3));
                    try {
                        synchronized (pn.this.gi) {
                            if (sVarU != null) {
                                if (pn.this.gi.size() > 0) {
                                    Iterator it = pn.this.gi.iterator();
                                    while (it.hasNext()) {
                                        sVarU.nr(pn.this.k, (o) it.next());
                                    }
                                    pn.this.gi.clear();
                                }
                            }
                        }
                    } catch (RemoteException unused) {
                    }
                }
            });
        }
    }

    private void sx() {
        if (this.my) {
            return;
        }
        this.my = true;
        u(4, new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.pn.9
            @Override // com.bytedance.sdk.openadsdk.core.l.b.fx.u
            public boolean u(int i, String str, String str2, String str3, Object obj) {
                if (i != 4) {
                    return true;
                }
                if ("market_click_open".equals(str3) || "applink_click".equals(str3)) {
                    com.bytedance.sdk.openadsdk.core.nr.u().put("save_jump_success_time", System.currentTimeMillis());
                    com.bytedance.sdk.openadsdk.core.nr.u().put("save_jump_success_ad_tag", str2);
                    com.bytedance.sdk.openadsdk.core.nr.u().put("save_dpl_success_materialmeta", str);
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(final JSONObject jSONObject, final boolean z) {
        int iU = com.bytedance.sdk.openadsdk.core.live.nr.u().u(this.pn, new com.bytedance.sdk.openadsdk.core.live.u.fx() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.pn.10
            @Override // com.bytedance.sdk.openadsdk.core.live.u.fx
            public void u(int i) {
                pn.this.n(jSONObject, z);
            }
        }, this.iz);
        if (iU == 1 || iU == 2) {
            return;
        }
        n(jSONObject, z);
    }

    public s a() {
        if (this.sx == null) {
            this.sx = s.u.u(com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u(dw.getContext()).u(3));
        }
        return this.sx;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void b(boolean z) {
        this.qq = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public abstract boolean fx();

    public boolean fx(JSONObject jSONObject, boolean z) {
        if (this.x.get() == 1) {
            if (com.bytedance.sdk.component.utils.o.fx(getContext()) == 0) {
                try {
                    h.u(getContext(), q.u(getContext(), "tt_no_network"), 0);
                } catch (Exception unused) {
                }
            } else {
                if (jp.nr(getContext())) {
                    jp.u(this.o, this.pn, this.iz);
                }
                b(jSONObject, z);
            }
            return true;
        }
        if (jp.nr(getContext())) {
            jp.u(this.o, this.pn, this.iz);
        }
        u(jSONObject, z);
        if (this.x.get() == 3 || this.x.get() == 4) {
            this.n.set(false);
            return false;
        }
        if (this.x.get() != 6) {
            return false;
        }
        this.n.set(true);
        return false;
    }

    public Context getContext() {
        try {
            WeakReference<Context> weakReference = this.fx;
            if (weakReference == null) {
                return dw.getContext();
            }
            Context context = weakReference.get();
            return context == null ? dw.getContext() : context;
        } catch (Throwable unused) {
            return dw.getContext();
        }
    }

    public boolean iz() {
        if (this.pn.kv() != null) {
            String strNr = this.pn.kv().nr();
            if (!TextUtils.isEmpty(strNr)) {
                my.u((String) null);
                Uri uri = Uri.parse(strNr);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                jp.nr(intent);
                if (this.o) {
                    com.bytedance.sdk.openadsdk.core.s.b.nr(this.pn, this.iz, "lp_open_dpl", u(strNr));
                }
                if (jp.u(getContext(), intent)) {
                    try {
                        jp.u(this.o, this.pn, this.iz);
                        if (!u(this.iz, "open_url_app", this.pn)) {
                            HashMap map = new HashMap();
                            map.put(az.at, "DMLibManager");
                            com.bytedance.sdk.openadsdk.core.s.b.n(this.pn, this.iz, "open_url_app", map);
                        }
                        com.bytedance.sdk.component.utils.nr.startActivity(getContext(), intent, TextUtils.equals("main", UMModuleRegister.INNER));
                        com.bytedance.sdk.openadsdk.core.s.n.u().u(this.pn, this.iz, this.o);
                        if (this.o) {
                            com.bytedance.sdk.openadsdk.core.s.b.u(this.pn, this.iz, "lp_openurl", (Throwable) null);
                            com.bytedance.sdk.openadsdk.core.s.b.u(this.pn, this.iz, "lp_deeplink_success_realtime", (Throwable) null);
                        } else {
                            com.bytedance.sdk.openadsdk.core.s.b.u(this.pn, this.iz, "deeplink_success_realtime", (Throwable) null);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (!TextUtils.isEmpty(this.pn.jf())) {
                            pb.u(getContext(), this.pn.jf(), this.pn, this.iz);
                        }
                        if (this.o) {
                            com.bytedance.sdk.openadsdk.core.s.b.fx(this.pn, this.iz, "lp_openurl_failed");
                            u(this.pn, this.iz, "lp_deeplink_fail_realtime", th);
                        } else {
                            u(this.pn, this.iz, "deeplink_fail_realtime", th);
                        }
                        return false;
                    }
                }
                if (this.o) {
                    com.bytedance.sdk.openadsdk.core.s.b.fx(this.pn, this.iz, "lp_openurl_failed");
                    u(this.pn, this.iz, "lp_deeplink_fail_realtime", null);
                } else {
                    u(this.pn, this.iz, "deeplink_fail_realtime", null);
                }
            }
            if (this.x.get() != 4 && this.x.get() != 3 && (!this.f5332a || this.n.get())) {
                this.f5332a = true;
                if (!u(this.iz, "open_fallback_url", this.pn)) {
                    com.bytedance.sdk.openadsdk.core.s.b.n(this.pn, this.iz, "open_fallback_url", null);
                }
            }
        }
        return false;
    }

    public void jk() {
        if (this.fx == null) {
            return;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null || !com.bytedance.sdk.openadsdk.core.n.o().u(activity)) {
            o();
        } else {
            nr(activity);
        }
    }

    public boolean k() {
        bc bcVar = this.pn;
        return (bcVar == null || this.b == null || bq.iz(bcVar) != 3 || this.b.u() == null) ? false : true;
    }

    public int l() {
        return this.x.get();
    }

    public boolean mv() {
        if (this.c == null || bq.bg(this.pn) == 1) {
            return true;
        }
        if (dw.nr().je()) {
            String str = "已下载%d%%，可在通知栏暂停或取消";
            try {
                str = String.format("已下载%d%%，可在通知栏暂停或取消", Integer.valueOf(this.kj.getCurrentPercent()));
            } catch (Exception unused) {
            }
            return u(str, true);
        }
        if (bq.jk(this.pn)) {
            return true;
        }
        return u("应用正在下载...", false);
    }

    public abstract void my();

    public com.bytedance.sdk.openadsdk.core.l.fx.fx.fx n() {
        if (this.z == null) {
            synchronized (this) {
                if (this.z == null) {
                    this.z = new com.bytedance.sdk.openadsdk.core.l.fx.fx.fx(getContext(), this.pn);
                }
            }
        }
        return this.z;
    }

    public abstract void n(boolean z);

    public void pn(boolean z) {
        if (z) {
            com.bytedance.sdk.openadsdk.core.s.b.nr(this.pn, this.iz, "quickapp_success");
        } else {
            com.bytedance.sdk.openadsdk.core.s.b.nr(this.pn, this.iz, "quickapp_fail");
        }
    }

    public com.bytedance.sdk.openadsdk.core.l.fx.fx.u s() {
        return fx() ? new com.bytedance.sdk.openadsdk.core.l.fx.fx.pn() : this.o ? new com.bytedance.sdk.openadsdk.core.l.fx.fx.b() : new com.bytedance.sdk.openadsdk.core.l.fx.fx.nr();
    }

    public abstract void t();

    public void b(JSONObject jSONObject, boolean z) {
        iz(jSONObject, z);
        this.n.set(true);
    }

    private void nr(Activity activity) {
        com.bytedance.sdk.openadsdk.core.y.u uVarB = com.bytedance.sdk.openadsdk.core.n.o().b();
        if (uVarB != null && this.bq == null) {
            this.bq = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.pn.3
                @Override // java.lang.Runnable
                public void run() {
                    pn.this.o();
                    pn.this.bq = null;
                }
            };
            uVarB.u(activity, this.bq);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public Map<String, Object> pn() {
        return new HashMap();
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void u(boolean z) {
        n(z);
        my();
    }

    public void pn(JSONObject jSONObject, boolean z) {
        if (iz()) {
            this.n.set(true);
            return;
        }
        if (!this.o && this.pn.pu() == null && this.pn.jf() != null && !this.pn.ar()) {
            pb.u(getContext(), this.pn.jf(), this.pn, this.iz);
        } else if (x(z)) {
            this.n.set(true);
        } else {
            if (this.pn.ar()) {
                return;
            }
            nr(jSONObject, z);
        }
    }

    public boolean x(boolean z) {
        if (this.b == null || !k()) {
            return false;
        }
        boolean zU = u(getContext(), this.b.u(), this.pn, this.iz, this.o);
        if (zU) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 9;
            messageObtain.obj = Boolean.valueOf(z);
            this.mv.sendMessageDelayed(messageObtain, 3000L);
            com.bytedance.sdk.openadsdk.core.nr.u().put("save_jump_success_time", System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.core.nr.u().put("save_jump_success_ad_tag", this.iz);
            com.bytedance.sdk.openadsdk.core.nr.u().put("save_dpl_success_materialmeta", this.pn.et().toString());
        } else {
            pn(false);
        }
        return zU;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void u(com.bytedance.sdk.openadsdk.core.l.nr.u uVar) {
        u(uVar, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void u(com.bytedance.sdk.openadsdk.core.l.nr.u uVar, boolean z) {
        if (uVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.l.nr.pn pnVar = this.l;
        if (pnVar != null) {
            pnVar.u(uVar);
        }
        if (z) {
            nr(uVar);
        }
        my();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final JSONObject jSONObject, final boolean z) {
        com.bytedance.sdk.openadsdk.core.live.nr nrVarU = com.bytedance.sdk.openadsdk.core.live.nr.u();
        HashMap map = new HashMap(1);
        map.put("event_tag", this.iz);
        if ((nrVarU.u(getContext(), this.pn, map) & 255) == 0) {
            com.bytedance.sdk.openadsdk.core.nr.u().put("save_jump_success_time", System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.core.nr.u().put("save_jump_success_ad_tag", this.iz);
            com.bytedance.sdk.openadsdk.core.nr.u().put("save_dpl_success_materialmeta", this.pn.et().toString());
            return;
        }
        n().u(s(), this.pn);
        boolean zU = com.bytedance.sdk.openadsdk.core.nr.u.nr.pn.u();
        if (zU) {
            com.bytedance.sdk.openadsdk.core.nr.u.nr.pn.u(false);
        }
        if (!zU) {
            if (new com.bytedance.sdk.openadsdk.core.nr.u.nr.pn(this.pn, getContext()).u(this.iz).u(jp.nr(this.iz)).nr(this.o).u(new pn.u() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.pn.2
                @Override // com.bytedance.sdk.openadsdk.core.nr.u.nr.pn.u
                public void nr() {
                    pn.this.pn(jSONObject, z);
                }

                @Override // com.bytedance.sdk.openadsdk.core.nr.u.nr.pn.u
                public void u() {
                    com.bytedance.sdk.openadsdk.core.nr.u().put("save_jump_success_time", System.currentTimeMillis());
                    com.bytedance.sdk.openadsdk.core.nr.u().put("save_jump_success_ad_tag", pn.this.iz);
                    com.bytedance.sdk.openadsdk.core.nr.u().put("save_dpl_success_materialmeta", pn.this.pn.et().toString());
                }
            })) {
                return;
            }
            pn(jSONObject, z);
            return;
        }
        pn(jSONObject, z);
    }

    public void nr(final com.bytedance.sdk.openadsdk.core.l.nr.u uVar) {
        if (!com.bytedance.sdk.openadsdk.core.multipro.nr.fx() || uVar == null) {
            return;
        }
        com.bytedance.sdk.component.jk.x.fx().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.pn.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.u uVarU = com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u(dw.getContext());
                com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.iz izVar = new com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.iz(uVar);
                s sVarU = s.u.u(uVarU.u(3));
                if (sVarU != null) {
                    try {
                        sVarU.u(pn.this.k, izVar);
                        synchronized (pn.this.gi) {
                            pn.this.gi.add(izVar);
                        }
                    } catch (RemoteException unused) {
                    }
                }
            }
        });
    }

    public void nr(JSONObject jSONObject, boolean z) {
        com.bytedance.sdk.openadsdk.core.kj.pn pnVar = this.b;
        if (pnVar == null || pnVar.nr() == null) {
            return;
        }
        fx(jSONObject, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void u(int i, fx.u uVar) {
        if (this.t == null) {
            this.t = new HashSet<>();
        }
        this.t.add(Integer.valueOf(i));
        if (this.c != null) {
            Object uVar2 = uVar;
            if (!com.bytedance.sdk.openadsdk.my.fx.b.nr(d.fx)) {
                uVar2 = new com.bytedance.sdk.openadsdk.core.l.u.u(uVar);
            }
            this.c.apply(com.bytedance.sdk.openadsdk.my.b.u().u(9).u(Void.class).u(0, new wq().u("hid", Integer.valueOf(i)).u("id", Integer.valueOf(i)).u("onEventLogHandler", uVar2).u("hashCode", Integer.valueOf(x()))).nr());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void nr() {
        com.bytedance.sdk.openadsdk.core.l.nr.pn pnVar = this.l;
        if (pnVar != null) {
            pnVar.nr();
        }
        t();
        HashSet<Integer> hashSet = this.t;
        if (hashSet != null && hashSet.size() > 0) {
            HashSet hashSet2 = new HashSet();
            hashSet2.addAll(this.t);
            this.t.clear();
            final Iterator it = hashSet2.iterator();
            com.bytedance.sdk.openadsdk.gi.x.u(new com.bytedance.sdk.component.jk.a("remove_log_hanlder") { // from class: com.bytedance.sdk.openadsdk.core.l.fx.pn.6
                @Override // java.lang.Runnable
                public void run() {
                    while (it.hasNext()) {
                        int iIntValue = ((Integer) it.next()).intValue();
                        Function<SparseArray<Object>, Object> function = pn.this.c;
                        if (function != null) {
                            function.apply(com.bytedance.sdk.openadsdk.my.b.u().u(3).u(Void.class).u(0, new wq().u("hid", Integer.valueOf(iIntValue)).u("hashCode", Integer.valueOf(pn.this.x()))).nr());
                        }
                        it.remove();
                    }
                }
            });
        }
        WeakReference<Context> weakReference = this.fx;
        if (weakReference != null) {
            weakReference.clear();
            this.fx = null;
        }
        this.z = null;
    }

    public String u(String str) {
        Uri uri;
        return (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null || TextUtils.isEmpty(uri.getScheme())) ? "" : uri.getScheme().toLowerCase(Locale.US);
    }

    public void u(bc bcVar, String str, String str2, Throwable th) {
        if (fx()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.s.b.u(bcVar, str, str2, th);
    }

    public boolean u(String str, String str2, bc bcVar) {
        if (this.c != null) {
            Object objApply = this.c.apply(com.bytedance.sdk.openadsdk.my.b.u().u(2).u(Boolean.class).u(0, new wq().u("tagIntercept", str).u("label", str2).u("hashCode", Integer.valueOf(x())).u("meta", bcVar.et().toString())).nr());
            if (objApply != null && ((Boolean) objApply).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public void iz(boolean z) {
        this.o = z;
    }

    private void iz(JSONObject jSONObject, boolean z) {
        u(jSONObject, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void u() {
        if (dw.getContext() == null) {
            dw.u(getContext());
        }
        my();
    }

    public void u(Map<String, Object> map) {
        Function<SparseArray<Object>, Object> function = this.c;
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.my.b.u().u(16).u(Void.class).u(0, map).nr());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void u(Activity activity) {
        if (activity == null) {
            return;
        }
        this.fx = new WeakReference<>(activity);
        my();
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        if (message.what != 9) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.n.o() != null && !com.bytedance.sdk.openadsdk.core.n.o().u()) {
            pn(false);
            if (this.s) {
                Object obj = message.obj;
                nr(jp.dw(this.pn), obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false);
                return;
            }
            return;
        }
        pn(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void u(int i) {
        this.dw = i;
    }

    public void u(String str, long j, long j2, String str2, String str3) {
        u uVar = this.bg;
        if (uVar == null) {
            this.bg = new u(str, j, j2, str2, str3);
        } else {
            uVar.u(str);
            this.bg.u(j);
            this.bg.nr(j2);
            this.bg.nr(str2);
            this.bg.fx(str3);
        }
        com.bytedance.sdk.component.jk.x.fx().execute(this.bg);
    }

    private boolean u(final String str, final boolean z) {
        Object objApply = this.c.apply(com.bytedance.sdk.openadsdk.my.b.u().u(6).u(Boolean.class).u(0, new wq().u("downloadUrl", this.b.nr()).u("hashCode", Integer.valueOf(x()))).nr());
        if (objApply == null || !((Boolean) objApply).booleanValue()) {
            return true;
        }
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.pn.7
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    h.nr(pn.this.getContext(), str, 0, 17, 0, 0);
                } else {
                    h.u(pn.this.getContext(), str, 0);
                }
            }
        });
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void u(final bc bcVar, final boolean z) {
        if (getContext() == null) {
            return;
        }
        this.pn = bcVar;
        sx();
        if (com.bytedance.sdk.openadsdk.core.nr.u.nr.fx.u(this.pn, false) && !com.bytedance.sdk.openadsdk.core.ugeno.jk.pn(this.pn) && !com.bytedance.sdk.openadsdk.core.ugeno.jk.b(this.pn)) {
            new com.bytedance.sdk.openadsdk.core.nr.u.nr.fx(this.pn, getContext()).u(this.iz).u(new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.pn.8
                @Override // com.bytedance.sdk.openadsdk.core.nr.u.nr.fx.u
                public void u() {
                    pn.this.x(jp.dw(bcVar), z);
                }
            });
        } else {
            x(jp.dw(bcVar), z);
        }
    }

    public boolean u(Context context, String str, bc bcVar, String str2, boolean z) {
        if (context == null) {
            return false;
        }
        try {
            jp.u(z, bcVar, str2);
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
