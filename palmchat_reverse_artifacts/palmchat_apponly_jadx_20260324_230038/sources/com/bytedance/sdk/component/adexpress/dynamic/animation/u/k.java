package com.bytedance.sdk.component.adexpress.dynamic.animation.u;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class k extends b {
    public k(View view, com.bytedance.sdk.component.adexpress.dynamic.fx.u uVar) {
        super(view, uVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.u.b
    public List<ObjectAnimator> u() {
        float f;
        float fU = com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.nr.iz());
        float fU2 = com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.nr.x());
        float f2 = 0.0f;
        if ("reverse".equals(this.nr.my())) {
            f2 = fU;
            f = fU2;
            fU = 0.0f;
            fU2 = 0.0f;
        } else {
            f = 0.0f;
        }
        if (com.bytedance.sdk.component.adexpress.b.fx.u(this.fx.getContext())) {
            fU = -fU;
            f2 = -f2;
        }
        this.fx.setTranslationX(fU);
        this.fx.setTranslationY(fU2);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.fx, "translationX", fU, f2).setDuration((int) (this.nr.jk() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.fx, "translationY", fU2, f).setDuration((int) (this.nr.jk() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(u(duration));
        arrayList.add(u(duration2));
        return arrayList;
    }
}
