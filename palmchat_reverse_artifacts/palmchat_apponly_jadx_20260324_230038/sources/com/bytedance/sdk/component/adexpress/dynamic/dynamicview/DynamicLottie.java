package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.fx.iz;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;
import com.bytedance.sdk.component.adexpress.widget.DynamicLottieView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DynamicLottie extends DynamicBaseWidgetImp {
    n nr;
    String u;

    public DynamicLottie(Context context, DynamicRootView dynamicRootView, n nVar, String str) {
        super(context, dynamicRootView, nVar);
        this.u = str;
        this.nr = nVar;
        DynamicLottieView lottieView = getLottieView();
        if (lottieView != null) {
            addView(lottieView, getWidgetLayoutParams());
        }
    }

    private DynamicLottieView getLottieView() {
        n nVar = this.mv;
        if (nVar == null || nVar.jk() == null || this.t == null || TextUtils.isEmpty(this.u)) {
            return null;
        }
        iz izVarPn = this.mv.jk().pn();
        String strF = izVarPn != null ? izVarPn.f() : "";
        if (TextUtils.isEmpty(strF)) {
            return null;
        }
        String str = this.u + "static/lotties/" + strF + ".json";
        DynamicLottieView dynamicLottieView = new DynamicLottieView(this.t);
        dynamicLottieView.setImageLottieTosPath(str);
        dynamicLottieView.a();
        return dynamicLottieView;
    }
}
