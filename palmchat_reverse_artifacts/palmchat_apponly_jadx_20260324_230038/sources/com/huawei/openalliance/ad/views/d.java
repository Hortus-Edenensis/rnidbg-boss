package com.huawei.openalliance.ad.views;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.huawei.hms.ads.dz;
import com.huawei.hms.ads.ed;
import com.huawei.hms.ads.md;
import com.huawei.openalliance.ad.media.MediaPlayerAgent;
import com.huawei.openalliance.ad.utils.w;
import java.lang.ref.WeakReference;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class d {
    private ed B;
    private SurfaceTexture C;
    private final Set<WeakReference<md>> D;
    private Surface F;
    private dz I;
    private SurfaceTexture.OnFrameAvailableListener L;
    private int S;
    private final w V;
    private MediaPlayerAgent Z;

    public synchronized SurfaceTexture B() {
        return this.C;
    }

    public synchronized ed C() {
        return this.B;
    }

    public synchronized void Code() {
        try {
            if (this.B != null) {
                return;
            }
            ed edVar = new ed();
            this.B = edVar;
            this.S = edVar.V();
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.S);
            this.C = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this.L);
            Surface surface = new Surface(this.C);
            this.F = surface;
            this.Z.Code(surface);
        } finally {
        }
    }

    public void D() {
        ed edVar = this.B;
        if (edVar != null) {
            edVar.Code();
            this.B = null;
        }
        dz dzVar = this.I;
        if (dzVar != null) {
            dzVar.V();
            this.I.Code();
            this.I = null;
        }
        SurfaceTexture surfaceTexture = this.C;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    public synchronized Surface I() {
        return this.F;
    }

    public synchronized dz S() {
        return this.I;
    }

    public synchronized void V() {
        if (this.I != null) {
            return;
        }
        this.I = new dz();
    }

    public synchronized int Z() {
        return this.S;
    }

    public void finalize() throws Throwable {
        super.finalize();
        this.V.V();
    }

    public void Code(Runnable runnable) {
        this.V.Code(runnable);
    }

    public void V(md mdVar) {
        WeakReference<md> weakReference = null;
        for (WeakReference<md> weakReference2 : this.D) {
            if (weakReference2.get() == mdVar) {
                weakReference = weakReference2;
            }
        }
        if (weakReference != null) {
            this.D.remove(weakReference);
        }
    }
}
