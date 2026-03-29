package com.bytedance.sdk.component.adexpress.dynamic.animation.u;

import android.animation.ObjectAnimator;
import android.view.View;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class s extends b {
    public s(View view, com.bytedance.sdk.component.adexpress.dynamic.fx.u uVar) {
        super(view, uVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.u.b
    public List<ObjectAnimator> u() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.fx, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, this.nr.pn(), 0.0f, this.nr.pn(), 0.0f).setDuration((int) (this.nr.jk() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(u(duration));
        return arrayList;
    }
}
