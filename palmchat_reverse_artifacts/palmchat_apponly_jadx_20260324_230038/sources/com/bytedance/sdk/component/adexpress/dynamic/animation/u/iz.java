package com.bytedance.sdk.component.adexpress.dynamic.animation.u;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz extends b {
    public iz(View view, com.bytedance.sdk.component.adexpress.dynamic.fx.u uVar) {
        super(view, uVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.u.b
    public List<ObjectAnimator> u() {
        float f = this.fx.getLayoutParams().width;
        this.fx.setTranslationX(f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.fx, "translationX", f, 0.0f).setDuration((int) (this.nr.jk() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.fx, "alpha", 0.0f, 1.0f).setDuration((int) (this.nr.jk() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(u(duration));
        arrayList.add(u(duration2));
        return arrayList;
    }
}
