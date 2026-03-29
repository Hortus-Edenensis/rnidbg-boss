package com.bytedance.sdk.component.adexpress.dynamic.animation.u;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x extends b {
    public x(View view, com.bytedance.sdk.component.adexpress.dynamic.fx.u uVar) {
        super(view, uVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.u.b
    @SuppressLint({"ObjectAnimatorBinding"})
    public List<ObjectAnimator> u() {
        this.fx.setTag(2097610709, Integer.valueOf(this.nr.fx()));
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.fx, "marqueeValue", 0.0f, 1.0f).setDuration((int) (this.nr.jk() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(u(duration));
        return arrayList;
    }
}
