package com.bytedance.sdk.component.adexpress.dynamic.animation.u;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends b {
    public u(View view, com.bytedance.sdk.component.adexpress.dynamic.fx.u uVar) {
        super(view, uVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.u.b
    public List<ObjectAnimator> u() {
        float fSx = this.nr.sx() / 100.0f;
        float fBg = this.nr.bg() / 100.0f;
        if ("reverse".equals(this.nr.my()) && this.nr.s() <= 0.0d) {
            fBg = fSx;
            fSx = fBg;
        }
        this.fx.setAlpha(fSx);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.fx, "alpha", fSx, fBg).setDuration((int) (this.nr.jk() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(u(duration));
        return arrayList;
    }
}
