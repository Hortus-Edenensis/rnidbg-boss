package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.BM3DModel;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmRichView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class Bm3DModel extends BmDrawItem {
    private a i;
    private ArrayList<BmRichView> j;
    private String k;
    private BM3DModel l;

    public Bm3DModel() {
        super(20, nativeCreate());
        this.j = new ArrayList<>();
        this.k = "";
        this.i = new a();
    }

    private static native boolean nativeAddRichView(long j, long j2);

    private static native boolean nativeClearRichViews(long j);

    private static native long nativeCreate();

    private static native boolean nativeLoad(long j, String str, int i);

    private static native boolean nativeLoadByPath(long j, String str, String str2, int i);

    private static native boolean nativeRemoveRichView(long j, long j2);

    private static native boolean nativeSetAlwaysShowFront(long j, boolean z);

    private static native boolean nativeSetAnimationIndex(long j, int i);

    private static native boolean nativeSetAnimationIsEnable(long j, boolean z);

    private static native boolean nativeSetAnimationRepeatCount(long j, int i);

    private static native boolean nativeSetAnimationSpeed(long j, float f);

    private static native boolean nativeSetBuildingId(long j, String str);

    private static native boolean nativeSetCollisionBehavior(long j, int i);

    private static native boolean nativeSetCollisionPriority(long j, int i);

    private static native boolean nativeSetFloorId(long j, String str);

    private static native boolean nativeSetOffset(long j, double d, double d2, double d3);

    private static native boolean nativeSetPosition(long j, double d, double d2, double d3);

    private static native boolean nativeSetRotation(long j, float f, float f2, float f3);

    private static native boolean nativeSetScale(long j, float f);

    private static native boolean nativeSetScaleByLevel(long j, boolean z);

    public void a(BM3DModel bM3DModel) {
        this.l = bM3DModel;
    }

    public boolean b(float f) {
        return nativeSetAnimationSpeed(this.nativeInstance, f);
    }

    public boolean c(float f) {
        this.i.a(f);
        return nativeSetScale(this.nativeInstance, f);
    }

    public boolean d(boolean z) {
        return nativeSetAnimationIsEnable(this.nativeInstance, z);
    }

    public boolean e(boolean z) {
        return nativeSetScaleByLevel(this.nativeInstance, z);
    }

    public boolean f(int i) {
        return nativeSetAnimationRepeatCount(this.nativeInstance, i);
    }

    public boolean a(String str, String str2, int i) {
        return nativeLoadByPath(this.nativeInstance, str, str2, i);
    }

    public BmBaseUI b(long j) {
        if (j == 0) {
            return null;
        }
        Iterator<BmRichView> it = this.j.iterator();
        while (it.hasNext()) {
            BmBaseUI bmBaseUIA = it.next().a(j);
            if (bmBaseUIA != null) {
                return bmBaseUIA;
            }
        }
        return null;
    }

    public boolean e(int i) {
        return nativeSetAnimationIndex(this.nativeInstance, i);
    }

    public boolean a(b bVar) {
        this.i.a(bVar);
        return nativeSetPosition(this.nativeInstance, bVar.f4118a, bVar.b, bVar.c);
    }

    public boolean c(boolean z) {
        return nativeSetAlwaysShowFront(this.nativeInstance, z);
    }

    public boolean a(double d, double d2, double d3) {
        return nativeSetOffset(this.nativeInstance, d, d2, d3);
    }

    public boolean a(float f, float f2, float f3) {
        this.i.a(f, f2, f3);
        return nativeSetRotation(this.nativeInstance, f, f2, f3);
    }
}
