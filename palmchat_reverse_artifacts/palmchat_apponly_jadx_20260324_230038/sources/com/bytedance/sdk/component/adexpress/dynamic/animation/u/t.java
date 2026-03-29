package com.bytedance.sdk.component.adexpress.dynamic.animation.u;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class t extends b {
    public t(View view, com.bytedance.sdk.component.adexpress.dynamic.fx.u uVar) {
        super(view, uVar);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 == null || !(viewGroup2 instanceof DynamicBaseWidget)) {
                return;
            }
            viewGroup2.setClipChildren(false);
            viewGroup2.setClipToPadding(false);
            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
            if (viewGroup3 == null || !(viewGroup3 instanceof DynamicBaseWidget)) {
                return;
            }
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.u.b
    public List<ObjectAnimator> u() {
        float f;
        float fT = (float) this.nr.t();
        float fL = (float) this.nr.l();
        String strMy = this.nr.my();
        float f2 = 1.0f;
        if ("reverse".equals(strMy) || "alternate-reverse".equals(strMy)) {
            f = 1.0f;
        } else {
            f2 = fT;
            f = fL;
            fT = 1.0f;
            fL = 1.0f;
        }
        this.fx.setTag(2097610710, this.nr.nr());
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.fx, "scaleX", fT, f2).setDuration((int) (this.nr.jk() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.fx, "scaleY", fL, f).setDuration((int) (this.nr.jk() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(u(duration));
        arrayList.add(u(duration2));
        return arrayList;
    }
}
