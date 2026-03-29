package com.bytedance.adsdk.lottie;

import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class bq {
    private boolean b;
    private final n fx;
    private final LottieAnimationView nr;
    private final Map<String, String> u;

    public bq() {
        this.u = new HashMap();
        this.b = true;
        this.nr = null;
        this.fx = null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final String fx(String str, String str2) {
        if (this.b && this.u.containsKey(str2)) {
            return this.u.get(str2);
        }
        String strU = u(str, str2);
        if (this.b) {
            this.u.put(str2, strU);
        }
        return strU;
    }

    public void nr(String str, String str2) {
        this.u.put(str, str2);
        u();
    }

    public String u(String str) {
        return str;
    }

    public String u(String str, String str2) {
        return u(str2);
    }

    private void u() {
        LottieAnimationView lottieAnimationView = this.nr;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        n nVar = this.fx;
        if (nVar != null) {
            nVar.invalidateSelf();
        }
    }

    public bq(LottieAnimationView lottieAnimationView) {
        this.u = new HashMap();
        this.b = true;
        this.nr = lottieAnimationView;
        this.fx = null;
    }
}
