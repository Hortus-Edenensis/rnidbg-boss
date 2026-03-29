package com.amap.api.col.p0002sl;

import android.graphics.Canvas;
import android.text.TextUtils;
import com.amap.api.col.p0002sl.bi;
import com.amap.api.interfaces.ITileOverlay;
import com.amap.api.maps2d.model.TileOverlayOptions;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class cc implements at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f2668a;
    private cd b;
    private aw c;
    private boolean d;
    private String e;
    private float f;

    public cc(TileOverlayOptions tileOverlayOptions, cd cdVar, be beVar, bi biVar) {
        this.b = cdVar;
        aw awVar = new aw(beVar);
        this.c = awVar;
        awVar.e = false;
        awVar.g = false;
        awVar.f = tileOverlayOptions.getDiskCacheEnabled();
        this.c.p = new bw<>();
        this.c.k = tileOverlayOptions.getTileProvider();
        aw awVar2 = this.c;
        bi.a aVar = biVar.e;
        awVar2.n = new bj(aVar.e, aVar.f, false, 0L, awVar2);
        String diskCacheDir = tileOverlayOptions.getDiskCacheDir();
        if (TextUtils.isEmpty(diskCacheDir)) {
            this.c.f = false;
        }
        aw awVar3 = this.c;
        awVar3.m = diskCacheDir;
        awVar3.o = new ad(cdVar.getContext(), false, this.c);
        ce ceVar = new ce(biVar, this.c);
        aw awVar4 = this.c;
        awVar4.q = ceVar;
        awVar4.a(true);
        this.d = tileOverlayOptions.isVisible();
        this.e = getId();
        this.f = tileOverlayOptions.getZIndex();
    }

    private static String a(String str) {
        f2668a++;
        return str + f2668a;
    }

    @Override // com.amap.api.col.p0002sl.at
    public final void b() {
        this.c.q.d();
    }

    @Override // com.amap.api.col.p0002sl.at
    public final void c() {
        this.c.q.b();
    }

    @Override // com.amap.api.interfaces.ITileOverlay
    public final void clearTileCache() {
        try {
            this.c.b();
        } catch (Throwable th) {
            ct.a(th, "TileOverlayDelegateImp", "remove");
        }
    }

    @Override // com.amap.api.interfaces.ITileOverlay
    public final boolean equalsRemote(ITileOverlay iTileOverlay) {
        return equals(iTileOverlay) || iTileOverlay.getId().equals(getId());
    }

    @Override // com.amap.api.interfaces.ITileOverlay
    public final String getId() {
        if (this.e == null) {
            this.e = a("TileOverlay");
        }
        return this.e;
    }

    @Override // com.amap.api.interfaces.ITileOverlay
    public final float getZIndex() {
        return this.f;
    }

    @Override // com.amap.api.interfaces.ITileOverlay
    public final int hashCodeRemote() {
        return super.hashCode();
    }

    @Override // com.amap.api.interfaces.ITileOverlay
    public final boolean isVisible() {
        return this.d;
    }

    @Override // com.amap.api.interfaces.ITileOverlay
    public final void remove() {
        try {
            this.b.b(this);
            this.c.b();
            this.c.q.b();
        } catch (Throwable th) {
            ct.a(th, "TileOverlayDelegateImp", "remove");
        }
    }

    @Override // com.amap.api.interfaces.ITileOverlay
    public final void setVisible(boolean z) {
        this.d = z;
        this.c.a(z);
    }

    @Override // com.amap.api.interfaces.ITileOverlay
    public final void setZIndex(float f) {
        this.f = f;
    }

    @Override // com.amap.api.col.p0002sl.at
    public final void a(Canvas canvas) {
        this.c.a(canvas);
    }

    @Override // com.amap.api.col.p0002sl.at
    public final void a() {
        this.c.q.c();
    }
}
