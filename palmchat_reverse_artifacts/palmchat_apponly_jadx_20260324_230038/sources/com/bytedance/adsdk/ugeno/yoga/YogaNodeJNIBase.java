package com.bytedance.adsdk.ugeno.yoga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@com.bytedance.adsdk.ugeno.yoga.u.u
public abstract class YogaNodeJNIBase extends jk implements Cloneable {

    @com.bytedance.adsdk.ugeno.yoga.u.u
    private float[] arr;
    private x b;
    private List<YogaNodeJNIBase> fx;
    private Object iz;

    @com.bytedance.adsdk.ugeno.yoga.u.u
    private int mLayoutDirection;
    private YogaNodeJNIBase nr;
    private nr pn;
    protected long u;
    private boolean x;

    private YogaNodeJNIBase(long j) {
        this.arr = null;
        this.mLayoutDirection = 0;
        this.x = true;
        if (j == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
        this.u = j;
    }

    @com.bytedance.adsdk.ugeno.yoga.u.u
    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i) {
        List<YogaNodeJNIBase> list = this.fx;
        if (list == null) {
            throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
        }
        list.remove(i);
        this.fx.add(i, yogaNodeJNIBase);
        yogaNodeJNIBase.nr = this;
        return yogaNodeJNIBase.u;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void a(float f) {
        YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.u, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase nr(int i) {
        List<YogaNodeJNIBase> list = this.fx;
        if (list == null) {
            throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
        }
        YogaNodeJNIBase yogaNodeJNIBaseRemove = list.remove(i);
        yogaNodeJNIBaseRemove.nr = null;
        YogaNative.jni_YGNodeRemoveChildJNI(this.u, yogaNodeJNIBaseRemove.u);
        return yogaNodeJNIBaseRemove;
    }

    @com.bytedance.adsdk.ugeno.yoga.u.u
    public final float baseline(float f, float f2) {
        return this.pn.u(this, f, f2);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    /* JADX INFO: renamed from: fx, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase u(int i) {
        List<YogaNodeJNIBase> list = this.fx;
        if (list != null) {
            return list.get(i);
        }
        throw new IllegalStateException("YogaNode does not have children");
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void iz(float f) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(this.u, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void jk(float f) {
        YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.u, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void l(float f) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.u, f);
    }

    @com.bytedance.adsdk.ugeno.yoga.u.u
    public final long measure(float f, int i, float f2, int i2) {
        if (l()) {
            return this.b.u(this, f, n.u(i), f2, n.u(i2));
        }
        throw new RuntimeException("Measure function isn't defined!");
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void n(float f) {
        YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.u, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void pn(float f) {
        YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.u, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase nr() {
        return this.nr;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void x(float f) {
        YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.u, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public float a() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public float iz() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[3];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public Object jk() {
        return this.iz;
    }

    public boolean l() {
        return this.b != null;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public float n() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void pn() {
        YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.u);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void t(float f) {
        YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.u, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public int u() {
        List<YogaNodeJNIBase> list = this.fx;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public float x() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[4];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void nr(u uVar) {
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.u, uVar.u());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void u(jk jkVar, int i) {
        if (jkVar instanceof YogaNodeJNIBase) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) jkVar;
            if (yogaNodeJNIBase.nr == null) {
                if (this.fx == null) {
                    this.fx = new ArrayList(4);
                }
                this.fx.add(i, yogaNodeJNIBase);
                yogaNodeJNIBase.nr = this;
                YogaNative.jni_YGNodeInsertChildJNI(this.u, yogaNodeJNIBase.u, i);
                return;
            }
            throw new IllegalStateException("Child already has a parent, it must be removed first.");
        }
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void fx(u uVar) {
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.u, uVar.u());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void nr(float f) {
        YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.u, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void fx(float f) {
        YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.u, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void nr(b bVar, float f) {
        YogaNative.jni_YGNodeStyleSetPaddingJNI(this.u, bVar.u(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void b(float f) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(this.u, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void fx() {
        YogaNative.jni_YGNodeStyleSetFlexBasisAutoJNI(this.u);
    }

    public YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void b() {
        YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.u);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void fx(b bVar, float f) {
        YogaNative.jni_YGNodeStyleSetPositionJNI(this.u, bVar.u(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public int u(jk jkVar) {
        List<YogaNodeJNIBase> list = this.fx;
        if (list == null) {
            return -1;
        }
        return list.indexOf(jkVar);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void u(float f, float f2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i = 0; i < arrayList.size(); i++) {
            List<YogaNodeJNIBase> list = ((YogaNodeJNIBase) arrayList.get(i)).fx;
            if (list != null) {
                Iterator<YogaNodeJNIBase> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            }
        }
        YogaNodeJNIBase[] yogaNodeJNIBaseArr = (YogaNodeJNIBase[]) arrayList.toArray(new YogaNodeJNIBase[arrayList.size()]);
        long[] jArr = new long[yogaNodeJNIBaseArr.length];
        for (int i2 = 0; i2 < yogaNodeJNIBaseArr.length; i2++) {
            jArr[i2] = yogaNodeJNIBaseArr[i2].u;
        }
        YogaNative.jni_YGNodeCalculateLayoutJNI(this.u, f, f2, jArr, yogaNodeJNIBaseArr);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void u(fx fxVar) {
        YogaNative.jni_YGNodeStyleSetDirectionJNI(this.u, fxVar.u());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void u(pn pnVar) {
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.u, pnVar.u());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void u(iz izVar) {
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.u, izVar.u());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void u(u uVar) {
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.u, uVar.u());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void u(mv mvVar) {
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.u, mvVar.u());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void u(s sVar) {
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.u, sVar.u());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void u(float f) {
        YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.u, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void u(b bVar, float f) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(this.u, bVar.u(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void u(x xVar) {
        this.b = xVar;
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(this.u, xVar != null);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void u(boolean z) {
        YogaNative.jni_YGNodeSetAlwaysFormsContainingBlockJNI(this.u, z);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.jk
    public void u(Object obj) {
        this.iz = obj;
    }
}
