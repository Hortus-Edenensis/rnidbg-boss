package com.ss.android.socialbase.downloader.network.u;

import com.ss.android.socialbase.downloader.jk.iz;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u {
    private final Map<String, b> fx;
    private final Map<String, fx> nr;
    protected int u;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.network.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0882u {
        private static final u u = new u();
    }

    public b nr(String str, List<com.ss.android.socialbase.downloader.model.fx> list) {
        b bVarRemove;
        synchronized (this.fx) {
            bVarRemove = this.fx.remove(str);
        }
        if (bVarRemove == null) {
            return null;
        }
        if (iz.u(bVarRemove.iz(), list)) {
            try {
                bVarRemove.pn();
            } catch (InterruptedException unused) {
            }
            if (bVarRemove.n() && bVarRemove.x()) {
                return bVarRemove;
            }
        }
        try {
            bVarRemove.b();
            return null;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public void u(String str, fx fxVar) {
        synchronized (this.nr) {
            this.nr.put(str, fxVar);
        }
    }

    private u() {
        this.nr = new HashMap();
        this.fx = new LinkedHashMap(3);
        this.u = 3;
    }

    public void u(int i) {
        this.u = i;
    }

    public fx u(String str, List<com.ss.android.socialbase.downloader.model.fx> list) {
        fx fxVarRemove;
        synchronized (this.nr) {
            fxVarRemove = this.nr.remove(str);
        }
        if (fxVarRemove == null) {
            return null;
        }
        if (iz.u(fxVarRemove.n(), list)) {
            try {
                fxVarRemove.b();
            } catch (InterruptedException unused) {
            }
            if (fxVarRemove.iz() && fxVarRemove.pn()) {
                return fxVarRemove;
            }
        }
        try {
            fxVarRemove.fx();
            return null;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public boolean u(String str) {
        fx fxVar = this.nr.get(str);
        if (fxVar != null) {
            if (fxVar.x()) {
                return true;
            }
            if (fxVar.iz() && fxVar.pn()) {
                return true;
            }
        }
        return false;
    }

    public static u u() {
        return C0882u.u;
    }
}
