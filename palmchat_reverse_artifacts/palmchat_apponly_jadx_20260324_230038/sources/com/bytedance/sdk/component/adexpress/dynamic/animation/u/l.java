package com.bytedance.sdk.component.adexpress.dynamic.animation.u;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class l extends b {
    public l(View view, com.bytedance.sdk.component.adexpress.dynamic.fx.u uVar) {
        super(view, uVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.u.b
    @SuppressLint({"ObjectAnimatorBinding"})
    public List<ObjectAnimator> u() {
        int i;
        int i2;
        this.fx.setTag(2097610711, Integer.valueOf(this.nr.b()));
        View view = this.fx;
        if (view == null || !com.bytedance.sdk.component.adexpress.b.fx.u(view.getContext())) {
            i = 0;
            i2 = 1;
        } else {
            i = 1;
            i2 = 0;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.fx, "shineValue", i, i2).setDuration((int) (this.nr.jk() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(u(duration));
        return arrayList;
    }
}
