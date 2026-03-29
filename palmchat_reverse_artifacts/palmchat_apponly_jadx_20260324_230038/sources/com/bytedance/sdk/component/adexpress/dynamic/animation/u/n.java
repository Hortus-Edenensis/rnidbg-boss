package com.bytedance.sdk.component.adexpress.dynamic.animation.u;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n extends b {
    public n(View view, com.bytedance.sdk.component.adexpress.dynamic.fx.u uVar) {
        super(view, uVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.u.b
    @SuppressLint({"ObjectAnimatorBinding"})
    public List<ObjectAnimator> u() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.fx, "rippleValue", 0.0f, 1.0f).setDuration((int) (this.nr.jk() * 1000.0d));
        ((ViewGroup) this.fx.getParent()).setClipChildren(false);
        ((ViewGroup) this.fx.getParent().getParent()).setClipChildren(false);
        ((ViewGroup) this.fx.getParent().getParent().getParent()).setClipChildren(false);
        this.fx.setTag(2097610712, this.nr.n());
        ArrayList arrayList = new ArrayList();
        arrayList.add(u(duration));
        return arrayList;
    }
}
