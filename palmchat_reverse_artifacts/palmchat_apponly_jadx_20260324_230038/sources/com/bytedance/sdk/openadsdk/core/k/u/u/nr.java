package com.bytedance.sdk.openadsdk.core.k.u.u;

import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.k.u.fx;
import com.qq.gdt.action.ActionUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends com.bytedance.sdk.openadsdk.core.k.u.u {
    private Window u;
    private final String nr = "xgc_prop_bright";
    private final float fx = 255.0f;
    private final int b = -1;

    public nr(Window window) {
        this.u = window;
        if (fx.u().pn() == -2.0f) {
            fx.u().u(x() / 255.0f);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.k.u.u
    public boolean fx() {
        if (this.u == null) {
            return true;
        }
        double dPn = fx.u().pn();
        return dPn >= 0.95d || dPn <= 0.05d;
    }

    @Override // com.bytedance.sdk.openadsdk.core.k.u.u
    public JSONObject iz() {
        return dw.nr().i();
    }

    @Override // com.bytedance.sdk.openadsdk.core.k.u.u
    public void nr(int i) {
        nr(-1.0d);
    }

    public void u(double d) {
        nr(d);
    }

    public int x() {
        return Settings.System.getInt(dw.getContext().getContentResolver(), "screen_brightness", 0);
    }

    private void nr(double d) {
        WindowManager.LayoutParams attributes = this.u.getAttributes();
        if (attributes != null) {
            if (d != -1.0d) {
                d = Math.max(0.0d, Math.min(d, 1.0d));
                if (d == 0.0d) {
                    d = -1.0d;
                }
            }
            attributes.screenBrightness = (float) d;
            this.u.setAttributes(attributes);
        }
    }

    public float u(Window window) {
        return window.getAttributes().screenBrightness;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001c A[PHI: r7
      0x001c: PHI (r7v3 double) = (r7v1 double), (r7v2 double) binds: [B:8:0x001a, B:11:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.bytedance.sdk.openadsdk.core.k.u.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean u(int i) {
        double dNr;
        JSONObject jSONObjectIz = iz();
        if (jSONObjectIz == null) {
            return false;
        }
        fx.u();
        if (i == 1) {
            dNr = jSONObjectIz.optDouble(ActionUtils.PAYMENT_AMOUNT, 0.0d);
            double d = 1.0d;
            if (dNr >= 1.0d) {
                dNr = d;
            } else {
                d = -1.0d;
                if (dNr <= -1.0d) {
                }
            }
        } else {
            if (i != 2) {
                return false;
            }
            dNr = fx.u().nr();
            if (dNr == -2.0d) {
                return false;
            }
        }
        if (dNr == 0.0d) {
            return false;
        }
        if (u(this.u) == -1.0f) {
            u(((double) (x() / 255.0f)) + dNr);
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.k.u.u
    public boolean nr() {
        return fx.u().fx();
    }
}
