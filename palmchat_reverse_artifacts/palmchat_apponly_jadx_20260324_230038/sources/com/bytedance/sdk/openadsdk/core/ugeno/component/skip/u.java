package com.bytedance.sdk.openadsdk.core.ugeno.component.skip;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.adsdk.ugeno.nr.fx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends fx<CycleSkipView> {
    public u(@NonNull Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public CycleSkipView u() {
        return new CycleSkipView(this.nr);
    }

    public void nr(int i, int i2) {
        T t = this.pn;
        if (t != 0) {
            ((CycleSkipView) t).u(i, i2);
        }
    }
}
