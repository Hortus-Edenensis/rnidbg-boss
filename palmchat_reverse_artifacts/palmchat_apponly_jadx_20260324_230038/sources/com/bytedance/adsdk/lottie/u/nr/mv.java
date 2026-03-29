package com.bytedance.adsdk.lottie.u.nr;

import android.graphics.Path;
import com.bytedance.adsdk.lottie.u.u.bg;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class mv extends u<com.bytedance.adsdk.lottie.model.nr.s, Path> {
    private final com.bytedance.adsdk.lottie.model.nr.s b;
    private List<bg> iz;
    private final Path pn;

    public mv(List<com.bytedance.adsdk.lottie.iz.u<com.bytedance.adsdk.lottie.model.nr.s>> list) {
        super(list);
        this.b = new com.bytedance.adsdk.lottie.model.nr.s();
        this.pn = new Path();
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u
    /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
    public Path u(com.bytedance.adsdk.lottie.iz.u<com.bytedance.adsdk.lottie.model.nr.s> uVar, float f) {
        this.b.u(uVar.u, uVar.nr, f);
        com.bytedance.adsdk.lottie.model.nr.s sVarU = this.b;
        List<bg> list = this.iz;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                sVarU = this.iz.get(size).u(sVarU);
            }
        }
        com.bytedance.adsdk.lottie.pn.n.u(sVarU, this.pn);
        return this.pn;
    }

    public void u(List<bg> list) {
        this.iz = list;
    }
}
