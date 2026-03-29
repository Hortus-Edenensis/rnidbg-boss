package com.bytedance.sdk.openadsdk.core.l.fx;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bq;
import com.bytedance.sdk.openadsdk.core.kj.my;
import com.bytedance.sdk.openadsdk.core.l.b.fx;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.wq;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile com.bytedance.sdk.openadsdk.core.l.fx.fx.fx f5330a;
    private String b;
    private WeakReference<Context> fx;
    private String iz;
    private volatile boolean jk;
    private final bc pn;
    private int n = 0;
    private boolean t = false;
    private Function<SparseArray<Object>, Object> x = com.bytedance.sdk.openadsdk.core.n.o().y();

    public a(Context context, String str, bc bcVar, String str2, boolean z) {
        this.fx = new WeakReference<>(context);
        this.pn = bcVar;
        this.iz = str2;
        this.b = str;
        u(z);
    }

    private synchronized void a() {
        if (this.x == null) {
            return;
        }
        if (d.fx >= 6400 && !d.x()) {
            com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u((com.bytedance.sdk.openadsdk.core.l.u.b) null, x());
        }
        if (t()) {
            this.x.apply(com.bytedance.sdk.openadsdk.my.b.u().u(2).u(Boolean.class).u(0, new wq().u("hashCode", Integer.valueOf(x()))).nr());
        } else {
            this.x.apply(com.bytedance.sdk.openadsdk.my.b.u().u(4).u(Void.class).u(0, new wq().u("hashCode", Integer.valueOf(x()))).nr());
        }
    }

    private Map<String, Object> bg() {
        long jLongValue = Double.valueOf(this.pn.lk()).longValue();
        return t() ? new wq().u("userAgent", null).u("isDisableDialog", Boolean.TRUE).u("downloadStatusChangeListener", null).u("action_type_button", 2).u("id", Long.valueOf(jLongValue)).u("hashCode", Integer.valueOf(x())) : new wq().u("downloadUrl", this.b).u("hashCode", Integer.valueOf(x())).u("id", Long.valueOf(jLongValue)).u("action_type_button", 2);
    }

    private void bq() {
        if (d.fx >= 5400 && fx() && !this.jk) {
            com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(false, (com.bytedance.sdk.openadsdk.core.l.u.b) null, x());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    private synchronized void jk() {
        if (this.x == null) {
            return;
        }
        if (!t()) {
            this.x.apply(com.bytedance.sdk.openadsdk.my.b.u().u(5).u(Void.class).u(0, new wq().u("hashCode", Integer.valueOf(x()))).nr());
            return;
        }
        wq wqVar = new wq();
        wqVar.u("hashCode", Integer.valueOf(x()));
        Object objApply = this.x.apply(com.bytedance.sdk.openadsdk.my.b.u().u(19).u(Boolean.class).u(0, wqVar).nr());
        if (objApply != null && ((Boolean) objApply).booleanValue()) {
            this.x.apply(com.bytedance.sdk.openadsdk.my.b.u().u(14).u(Boolean.class).u(0, new wq().u("hashCode", Integer.valueOf(x()))).nr());
        }
    }

    private boolean k() {
        bc bcVar = this.pn;
        if (bcVar == null || bcVar.kv() == null) {
            return false;
        }
        String strNr = this.pn.kv().nr();
        if (TextUtils.isEmpty(strNr)) {
            return false;
        }
        my.u((String) null);
        Uri uri = Uri.parse(strNr);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        if (!jp.u(getContext(), intent)) {
            return false;
        }
        if (!(getContext() instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            getContext().startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l() {
        int i = this.n;
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.l.fx.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.kj.b bVarU = dw.u().u(a.this.pn, a.this.b);
                    if (bVarU == null || !bVarU.pn()) {
                        jk.u(dw.getContext());
                        return;
                    }
                    String strIz = bVarU.iz();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject = new JSONObject(strIz);
                    } catch (JSONException unused) {
                    }
                    com.bytedance.sdk.openadsdk.core.kj.iz izVarPn = com.bytedance.sdk.openadsdk.core.u.pn(jSONObject);
                    com.bytedance.sdk.openadsdk.core.kj.iz izVarHm = a.this.pn.hm();
                    if (izVarHm == null) {
                        a.this.pn.u(izVarPn);
                    } else {
                        izVarHm.jk(izVarPn.s());
                        izVarHm.nr(izVarPn.pn());
                        izVarHm.b(izVarPn.x());
                        izVarHm.nr(izVarPn.l());
                        izVarHm.pn(izVarPn.n());
                        izVarHm.a(izVarPn.mv());
                        izVarHm.fx(izVarPn.iz());
                        izVarHm.iz(izVarPn.a());
                        izVarHm.x(izVarPn.jk());
                        izVarHm.n(izVarPn.t());
                        izVarPn = izVarHm;
                    }
                    if (a.this.mv()) {
                        return;
                    }
                    a.this.u(izVarPn.iz(), izVarPn.s(), izVarPn.mv());
                    a.this.u(bVarU);
                }
            });
            return true;
        }
        if (mv()) {
            return true;
        }
        jk.u(dw.getContext());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean mv() {
        return k() || s();
    }

    private boolean my() {
        if (this.x == null || bq.bg(this.pn) == 1) {
            return true;
        }
        if (dw.nr().je()) {
            return u("正在下载，可在通知栏暂停或取消", true);
        }
        if (bq.jk(this.pn)) {
            return true;
        }
        return u("应用正在下载...", false);
    }

    private boolean o() {
        if (this.x == null) {
            return false;
        }
        Object objApply = this.x.apply(com.bytedance.sdk.openadsdk.my.b.u().u(6).u(Boolean.class).u(0, new wq().u("downloadUrl", this.b).u("hashCode", Integer.valueOf(x()))).nr());
        return objApply != null && ((Boolean) objApply).booleanValue();
    }

    private boolean s() {
        bc bcVar = this.pn;
        com.bytedance.sdk.openadsdk.core.kj.iz izVarHm = bcVar != null ? bcVar.hm() : null;
        String strMv = izVarHm != null ? izVarHm.mv() : "";
        Intent intentNr = TextUtils.isEmpty(strMv) ? null : jp.nr(getContext(), strMv);
        if (intentNr != null && jp.fx(getContext(), strMv)) {
            try {
                getContext().startActivity(intentNr);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sx() {
        final Map<String, Object> mapBg = bg();
        if (!fx()) {
            u(16, mapBg);
        } else {
            com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(mapBg, new com.bytedance.sdk.openadsdk.core.l.u.nr() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.a.4
                @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
                public void handleMarketFailedComplianceDialog() {
                    if (mapBg == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(0, a.this.x());
                    a.this.iz().u(a.this.n());
                    mapBg.remove("downloadButtonClickListener");
                    if (a.this.l()) {
                        return;
                    }
                    a.this.u((com.bytedance.sdk.openadsdk.core.kj.b) null);
                }

                @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
                public void handleComplianceDialog(boolean z) {
                }
            });
            u(mapBg);
        }
    }

    private boolean t() {
        bc bcVar = this.pn;
        if (bcVar != null) {
            return bq.u(bcVar);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void u(int i, fx.u uVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.l.fx.fx.u n() {
        return fx() ? new com.bytedance.sdk.openadsdk.core.l.fx.fx.pn() : new com.bytedance.sdk.openadsdk.core.l.fx.fx.b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void b(boolean z) {
        this.t = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public boolean fx() {
        Function<SparseArray<Object>, Object> function = this.x;
        return function != null && com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(function, x()) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.fx.n
    public com.bytedance.sdk.openadsdk.core.l.fx.fx.fx iz() {
        if (this.f5330a == null) {
            synchronized (this) {
                if (this.f5330a == null) {
                    this.f5330a = new com.bytedance.sdk.openadsdk.core.l.fx.fx.fx(getContext(), this.pn);
                }
            }
        }
        return this.f5330a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void nr() {
        a();
        WeakReference<Context> weakReference = this.fx;
        if (weakReference != null) {
            weakReference.clear();
            this.fx = null;
        }
        this.f5330a = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public Map<String, Object> pn() {
        return new HashMap();
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void u(Activity activity) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void b() {
        Function<SparseArray<Object>, Object> function = this.x;
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.my.b.u().u(8).u(Void.class).u(0, new wq().u("force", Boolean.TRUE).u("hashCode", Integer.valueOf(x()))).nr());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void u(bc bcVar, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void fx(boolean z) {
        if (d.fx >= 5400 && z) {
            this.jk = z;
            if (fx()) {
                com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(true, com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(this.pn, this.t), x());
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void u(com.bytedance.sdk.openadsdk.core.l.nr.u uVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void u(com.bytedance.sdk.openadsdk.core.l.nr.u uVar, boolean z) {
    }

    private boolean nr(com.bytedance.sdk.openadsdk.core.kj.b bVar) {
        com.bytedance.sdk.openadsdk.core.l.fx.fx.fx fxVarIz = iz();
        if (!fxVarIz.b(false) || o()) {
            return false;
        }
        if (u(getContext(), this.pn, this.iz)) {
            return true;
        }
        fxVarIz.u(bVar, this.iz, this.b, new com.bytedance.sdk.openadsdk.core.l.fx.u.nr() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.a.2
            @Override // com.bytedance.sdk.openadsdk.core.l.fx.u.nr
            public void u() {
                a.this.sx();
                a.this.fx(true);
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void u(boolean z) {
        com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(this.b, this.iz, this.pn, (JSONObject) null, x());
        com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(this.pn, x(), z);
        com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(this.iz, x());
        jk();
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void u() {
        jk();
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void u(JSONObject jSONObject, boolean z) {
        iz().u(n());
        if (my()) {
            if (fx() || !l()) {
                u((com.bytedance.sdk.openadsdk.core.kj.b) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, String str2, String str3) {
        if (this.x == null) {
            return;
        }
        this.x.apply(com.bytedance.sdk.openadsdk.my.b.u().u(24).u(Boolean.class).u(0, new wq().u("appIcon", str).u(WfConstant.EVENT_KEY_APP_NAME, str2).u("hashCode", Integer.valueOf(x())).u("packageName", str3)).nr());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.openadsdk.core.kj.b bVar) {
        bq();
        if (nr(bVar)) {
            return;
        }
        sx();
    }

    private boolean u(final String str, final boolean z) {
        if (!o()) {
            return true;
        }
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    h.nr(a.this.getContext(), str, 0, 17, 0, 0);
                } else {
                    h.u(a.this.getContext(), str, 0);
                }
            }
        });
        return false;
    }

    private void u(final Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.l.a.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.a.5
            @Override // java.lang.Runnable
            public void run() {
                a.this.u(17, (Map<String, Object>) map);
            }
        }, this.pn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final int i, final Map<String, Object> map) {
        try {
            if (this.x == null) {
                return;
            }
            if (t()) {
                this.x.apply(com.bytedance.sdk.openadsdk.my.b.u().u(13).u(Void.class).u(0, map).nr());
                this.jk = false;
            } else {
                map.put("itemClickListener", com.bytedance.sdk.openadsdk.my.fx.b.u(new com.bytedance.sdk.openadsdk.core.l.u.pn() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.a.6
                    @Override // com.bytedance.sdk.openadsdk.core.l.u.pn
                    public void onItemClick() {
                        com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.nr(1, a.this.x());
                        map.remove("itemClickListener");
                        a.this.x.apply(com.bytedance.sdk.openadsdk.my.b.u().u(i).u(Void.class).u(0, map).nr());
                    }
                }));
                this.x.apply(com.bytedance.sdk.openadsdk.my.b.u().u(i).u(Void.class).u(0, map).nr());
                this.jk = false;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void u(int i) {
        this.n = i;
    }
}
