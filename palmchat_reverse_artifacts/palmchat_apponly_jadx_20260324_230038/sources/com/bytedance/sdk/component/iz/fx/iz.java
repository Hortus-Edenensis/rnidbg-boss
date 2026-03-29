package com.bytedance.sdk.component.iz.fx;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.component.iz.bg;
import com.bytedance.sdk.component.iz.d;
import com.bytedance.sdk.component.iz.gi;
import com.bytedance.sdk.component.iz.ja;
import com.bytedance.sdk.component.iz.sx;
import com.bytedance.sdk.component.iz.z;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z f5143a;
    private com.bytedance.sdk.component.iz.pn iz;
    private ExecutorService n;
    private final bg nr;
    private sx x;
    private Map<String, List<fx>> u = new ConcurrentHashMap();
    private Map<String, gi> fx = new HashMap();
    private Map<String, d> b = new HashMap();
    private Map<String, com.bytedance.sdk.component.iz.b> pn = new HashMap();

    public iz(Context context, bg bgVar) {
        this.nr = (bg) n.u(bgVar);
        com.bytedance.sdk.component.iz.fx.u.u.u(context, bgVar.a());
    }

    private com.bytedance.sdk.component.iz.pn a() {
        com.bytedance.sdk.component.iz.pn pnVarB = this.nr.b();
        return pnVarB == null ? com.bytedance.sdk.component.iz.nr.nr.u() : pnVarB;
    }

    private gi b(com.bytedance.sdk.component.iz.nr nrVar) {
        gi giVarPn = this.nr.pn();
        return giVarPn != null ? com.bytedance.sdk.component.iz.fx.u.nr.u.u(giVarPn) : com.bytedance.sdk.component.iz.fx.u.nr.u.u(nrVar.getMemoryCacheSize());
    }

    private com.bytedance.sdk.component.iz.b iz(com.bytedance.sdk.component.iz.nr nrVar) {
        com.bytedance.sdk.component.iz.b bVarX = this.nr.x();
        return bVarX != null ? bVarX : new com.bytedance.sdk.component.iz.fx.u.u.nr(nrVar.getCacheDir(), nrVar.getFileCacheSize(), iz());
    }

    private sx jk() {
        sx sxVarU = this.nr.u();
        return sxVarU != null ? sxVarU : com.bytedance.sdk.component.iz.u.nr.u();
    }

    private z l() {
        z zVarN = this.nr.n();
        return zVarN == null ? new x() : zVarN;
    }

    private d pn(com.bytedance.sdk.component.iz.nr nrVar) {
        d dVarIz = this.nr.iz();
        return dVarIz != null ? dVarIz : com.bytedance.sdk.component.iz.fx.u.nr.pn.u(nrVar.getRawMemoryCacheSize());
    }

    private ExecutorService t() {
        ExecutorService executorServiceNr = this.nr.nr();
        return executorServiceNr != null ? executorServiceNr : com.bytedance.sdk.component.iz.u.fx.u();
    }

    public Collection<com.bytedance.sdk.component.iz.b> fx() {
        return this.pn.values();
    }

    public z n() {
        if (this.f5143a == null) {
            this.f5143a = l();
        }
        return this.f5143a;
    }

    public Collection<d> nr() {
        return this.b.values();
    }

    public Collection<gi> u() {
        return this.fx.values();
    }

    public Map<String, List<fx>> x() {
        return this.u;
    }

    public com.bytedance.sdk.component.iz.b fx(com.bytedance.sdk.component.iz.nr nrVar) {
        if (nrVar == null) {
            nrVar = com.bytedance.sdk.component.iz.fx.u.u.u();
        }
        String string = nrVar.getCacheDir().toString();
        com.bytedance.sdk.component.iz.b bVar = this.pn.get(string);
        if (bVar != null) {
            return bVar;
        }
        com.bytedance.sdk.component.iz.b bVarIz = iz(nrVar);
        this.pn.put(string, bVarIz);
        return bVarIz;
    }

    public d nr(com.bytedance.sdk.component.iz.nr nrVar) {
        if (nrVar == null) {
            nrVar = com.bytedance.sdk.component.iz.fx.u.u.u();
        }
        String string = nrVar.getCacheDir().toString();
        d dVar = this.b.get(string);
        if (dVar != null) {
            return dVar;
        }
        d dVarPn = pn(nrVar);
        this.b.put(string, dVarPn);
        return dVarPn;
    }

    public gi u(com.bytedance.sdk.component.iz.nr nrVar) {
        if (nrVar == null) {
            nrVar = com.bytedance.sdk.component.iz.fx.u.u.u();
        }
        String string = nrVar.getCacheDir().toString();
        gi giVar = this.fx.get(string);
        if (giVar != null) {
            return giVar;
        }
        gi giVarB = b(nrVar);
        this.fx.put(string, giVarB);
        return giVarB;
    }

    public ExecutorService iz() {
        ExecutorService executorServiceU;
        ja jaVarFx = this.nr.fx();
        if (jaVarFx != null && (executorServiceU = jaVarFx.u()) != null) {
            return executorServiceU;
        }
        if (this.n == null) {
            this.n = t();
        }
        return this.n;
    }

    public sx pn() {
        if (this.x == null) {
            this.x = jk();
        }
        return this.x;
    }

    public com.bytedance.sdk.component.iz.pn b() {
        if (this.iz == null) {
            this.iz = a();
        }
        return this.iz;
    }

    public com.bytedance.sdk.component.iz.b u(String str) {
        return fx(com.bytedance.sdk.component.iz.fx.u.u.u(new File(str)));
    }

    public com.bytedance.sdk.component.iz.fx.nr.u u(fx fxVar) {
        ImageView.ScaleType scaleType = fxVar.getScaleType();
        if (scaleType == null) {
            scaleType = com.bytedance.sdk.component.iz.fx.nr.u.u;
        }
        ImageView.ScaleType scaleType2 = scaleType;
        Bitmap.Config configB = fxVar.b();
        if (configB == null) {
            configB = com.bytedance.sdk.component.iz.fx.nr.u.nr;
        }
        return new com.bytedance.sdk.component.iz.fx.nr.u(fxVar.getWidth(), fxVar.getHeight(), scaleType2, configB, fxVar.u(), fxVar.nr());
    }
}
