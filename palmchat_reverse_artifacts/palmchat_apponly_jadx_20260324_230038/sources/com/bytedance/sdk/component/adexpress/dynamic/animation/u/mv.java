package com.bytedance.sdk.component.adexpress.dynamic.animation.u;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class mv extends b {
    public mv(View view, com.bytedance.sdk.component.adexpress.dynamic.fx.u uVar) {
        super(view, uVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.u.b
    public List<ObjectAnimator> u() {
        View view = this.fx;
        if ((view instanceof ImageView) && (view.getParent() instanceof DynamicImageView)) {
            View view2 = (View) this.fx.getParent();
            this.fx = view2;
            ((ViewGroup) view2).setClipChildren(true);
            ((ViewGroup) this.fx.getParent()).setClipChildren(true);
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.fx, "stretchValue", 0.0f, 1.0f).setDuration((int) (this.nr.jk() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(u(duration));
        return arrayList;
    }
}
