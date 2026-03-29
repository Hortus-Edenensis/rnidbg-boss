package com.bytedance.sdk.openadsdk.core;

import android.util.SparseArray;
import com.kuaishou.weapon.p0.g;
import j$.util.function.Function$CC;
import java.io.Serializable;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class z extends com.bytedance.sdk.openadsdk.my.fx.fx.b implements Serializable, Function<SparseArray<Object>, Object> {
    com.bytedance.sdk.openadsdk.my.fx.fx.b u;

    public z(com.bytedance.sdk.openadsdk.my.fx.fx.b bVar) {
        super(null);
        this.u = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
    public com.bytedance.sdk.openadsdk.my.fx.fx.fx a() {
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVar = this.u;
        return bVar == null ? super.a() : bVar.a();
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
    public boolean b() {
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVar = this.u;
        return bVar == null ? super.b() : bVar.b() && com.bytedance.sdk.openadsdk.core.h.pn.u().u(dw.getContext(), g.d);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
    public boolean fx() {
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVar = this.u;
        return bVar == null ? super.fx() : bVar.fx() && com.bytedance.sdk.openadsdk.core.h.pn.u().u(dw.getContext(), g.c);
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
    public boolean iz() {
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVar = this.u;
        return bVar == null ? super.iz() : bVar.iz();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
    public String jk() {
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVar = this.u;
        return bVar == null ? super.jk() : bVar.jk();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
    public Map<String, Object> k() {
        if (d.fx < 6408) {
            return null;
        }
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVar = this.u;
        return bVar == null ? super.k() : bVar.k();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
    public String l() {
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVar = this.u;
        return bVar == null ? super.l() : bVar.l();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
    public boolean n() {
        if (d.fx < 7000) {
            return true;
        }
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVar = this.u;
        return bVar == null ? super.n() : bVar.n();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
    public boolean nr() {
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVar = this.u;
        return bVar == null ? super.nr() : bVar.nr();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
    public boolean pn() {
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVar = this.u;
        return bVar == null ? super.pn() : bVar.pn() && com.bytedance.sdk.openadsdk.core.h.pn.u().u(dw.getContext(), g.j);
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
    public String s() {
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVar = this.u;
        return bVar == null ? super.s() : bVar.s();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
    public String t() {
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVar = this.u;
        return bVar == null ? super.t() : bVar.t();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
    public boolean u() {
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVar = this.u;
        if (bVar == null) {
            if (super.u() && com.bytedance.sdk.openadsdk.core.h.pn.u().u(dw.getContext(), g.h) && com.bytedance.sdk.openadsdk.core.h.pn.u().u(dw.getContext(), g.g)) {
                return true;
            }
        } else if (bVar.u() && com.bytedance.sdk.openadsdk.core.h.pn.u().u(dw.getContext(), g.h) && com.bytedance.sdk.openadsdk.core.h.pn.u().u(dw.getContext(), g.g)) {
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.fx.b
    public boolean x() {
        return false;
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1093)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1118)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public java.lang.Object apply(android.util.SparseArray<java.lang.Object> r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L4
            return r0
        L4:
            r1 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            java.lang.Object r6 = r6.get(r1)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            switch(r6) {
                case 262101: goto L9a;
                case 262102: goto L70;
                case 262103: goto L67;
                case 262104: goto L5e;
                case 262105: goto L59;
                case 262106: goto L50;
                case 262107: goto L4b;
                case 262108: goto L42;
                case 262109: goto L3d;
                case 262110: goto L34;
                case 262111: goto L2b;
                case 262112: goto L26;
                default: goto L14;
            }
        L14:
            switch(r6) {
                case 262119: goto L21;
                case 262120: goto L18;
                default: goto L17;
            }
        L17:
            return r0
        L18:
            boolean r6 = r5.n()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            return r6
        L21:
            java.util.Map r6 = r5.k()
            return r6
        L26:
            java.lang.String r6 = r5.s()
            return r6
        L2b:
            boolean r6 = r5.x()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            return r6
        L34:
            boolean r6 = r5.iz()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            return r6
        L3d:
            java.lang.String r6 = r5.l()
            return r6
        L42:
            boolean r6 = r5.pn()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            return r6
        L4b:
            java.lang.String r6 = r5.t()
            return r6
        L50:
            boolean r6 = r5.b()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            return r6
        L59:
            java.lang.String r6 = r5.jk()
            return r6
        L5e:
            boolean r6 = r5.fx()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            return r6
        L67:
            boolean r6 = r5.nr()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            return r6
        L70:
            com.bytedance.sdk.openadsdk.my.fx.fx.fx r6 = r5.a()
            if (r6 == 0) goto L99
            double r0 = r6.u()
            double r2 = r6.nr()
            ll7 r6 = defpackage.ll7.b()
            r4 = 262001(0x3ff71, float:3.67142E-40)
            ll7 r6 = r6.d(r4, r0)
            r0 = 262002(0x3ff72, float:3.67143E-40)
            ll7 r6 = r6.d(r0, r2)
            com.bykv.vk.openvk.api.proto.PluginValueSet r6 = r6.a()
            android.util.SparseArray r6 = r6.sparseArray()
            return r6
        L99:
            return r0
        L9a:
            boolean r6 = r5.u()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.z.apply(android.util.SparseArray):java.lang.Object");
    }
}
