package com.bytedance.sdk.openadsdk.core.ugeno.fx;

import android.content.Context;
import com.bytedance.adsdk.ugeno.pn.t;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends com.bytedance.adsdk.ugeno.pn.fx.nr {
    private boolean t;

    public fx(Context context) {
        super(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    @Override // com.bytedance.adsdk.ugeno.pn.fx.nr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean u(Object... objArr) {
        int iIntValue;
        int iIntValue2;
        Map<String, String> map = this.pn;
        if (map == null || map.isEmpty()) {
            return false;
        }
        if (objArr.length > 0) {
            Object obj = objArr[0];
            iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : -1;
        }
        if (objArr.length > 1) {
            Object obj2 = objArr[1];
            iIntValue2 = obj2 instanceof Integer ? ((Integer) obj2).intValue() : -1;
        }
        if (iIntValue <= 0) {
            this.t = false;
        }
        if (this.pn.containsKey("percent")) {
            float fU = com.bytedance.adsdk.ugeno.iz.fx.u(this.pn.get("percent"), -1.0f);
            if (fU >= 0.0f) {
                if (iIntValue >= (fU / 100.0f) * iIntValue2 && !this.t) {
                    this.t = true;
                    t tVar = this.u;
                    if (tVar != null) {
                        tVar.u(this.nr, this.iz, this.fx.nr());
                    }
                }
            }
        } else if (iIntValue >= com.bytedance.adsdk.ugeno.iz.fx.u(this.pn.get("interval"), -1) && !this.t) {
            this.t = true;
            t tVar2 = this.u;
            if (tVar2 != null) {
                tVar2.u(this.nr, this.iz, this.fx.nr());
            }
        }
        return true;
    }
}
