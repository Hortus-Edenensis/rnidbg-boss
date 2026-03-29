package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.uiengine.b;
import com.huawei.openalliance.ad.media.IMultiMediaPlayingManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class cj extends b.AbstractBinderC0441b {
    private static cj D = null;
    private static final String F = "MultiMPlayingManagerPro";
    private static final byte[] L = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6533a;
    private IMultiMediaPlayingManager b;
    private final Map<Long, ci> c = new HashMap();

    private cj(Context context) {
        this.f6533a = context;
    }

    public static cj Code(Context context) {
        return V(context);
    }

    private Long I(com.huawei.hms.ads.uiengine.a aVar) {
        if (aVar == null) {
            return null;
        }
        try {
            return Long.valueOf(aVar.Code());
        } catch (Throwable th) {
            fh.V(F, "get id err: %s", th.getClass().getSimpleName());
            return null;
        }
    }

    private static cj V(Context context) {
        cj cjVar;
        synchronized (L) {
            if (D == null) {
                D = new cj(context);
            }
            cjVar = D;
        }
        return cjVar;
    }

    private ci Z(com.huawei.hms.ads.uiengine.a aVar) {
        ci ciVar;
        try {
            long jCode = aVar.Code();
            if (this.c.containsKey(Long.valueOf(jCode))) {
                ciVar = this.c.get(Long.valueOf(jCode));
            } else {
                ci ciVar2 = new ci(this.f6533a, aVar);
                this.c.put(Long.valueOf(jCode), ciVar2);
                ciVar = ciVar2;
            }
            if (fh.Code()) {
                fh.Code(F, "getProxy = %s, proxy = %s", Long.valueOf(jCode), ciVar);
            }
            return ciVar;
        } catch (Throwable th) {
            fh.V(F, "getProxy err: %s", th.getClass().getSimpleName());
            return null;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.b
    public void Code(com.huawei.hms.ads.uiengine.a aVar) {
        Long lI = I(aVar);
        fh.V(F, "removeAgent %s", lI);
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.b;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.Code(Z(aVar));
        }
        if (lI != null) {
            this.c.remove(lI);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.b
    public void I(String str, com.huawei.hms.ads.uiengine.a aVar) {
        fh.V(F, "stop %s", I(aVar));
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.b;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.I(str, Z(aVar));
        }
    }

    @Override // com.huawei.hms.ads.uiengine.b
    public void V(com.huawei.hms.ads.uiengine.a aVar) {
        fh.V(F, "removeListeners %s", I(aVar));
        ci ciVarZ = Z(aVar);
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.b;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.V(ciVarZ);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.b
    public void Z(String str, com.huawei.hms.ads.uiengine.a aVar) {
        fh.V(F, "pause %s", I(aVar));
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.b;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.Z(str, Z(aVar));
        }
    }

    public void Code(IMultiMediaPlayingManager iMultiMediaPlayingManager) {
        this.b = iMultiMediaPlayingManager;
    }

    @Override // com.huawei.hms.ads.uiengine.b
    public void V(String str, com.huawei.hms.ads.uiengine.a aVar) {
        fh.V(F, "manualPlay %s", I(aVar));
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.b;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.V(str, Z(aVar));
        }
    }

    @Override // com.huawei.hms.ads.uiengine.b
    public void Code(String str, com.huawei.hms.ads.uiengine.a aVar) {
        fh.V(F, "autoPlay %s", I(aVar));
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.b;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.Code(str, Z(aVar));
        }
    }
}
