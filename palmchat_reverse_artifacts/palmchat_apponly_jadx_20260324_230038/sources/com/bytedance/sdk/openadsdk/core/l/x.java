package com.bytedance.sdk.openadsdk.core.l;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.l.b.k;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.qq.gdt.action.ActionUtils;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x implements b {
    private fx u;

    public x(fx fxVar) {
        this.u = fxVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.b
    public boolean nr(com.bytedance.sdk.openadsdk.core.l.fx.nr.u uVar) {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.b
    public boolean u(final com.bytedance.sdk.openadsdk.core.l.fx.nr.u uVar) {
        if (!this.u.fx()) {
            return false;
        }
        long jB = this.u.b();
        final TTAdInteractionListener tTAdInteractionListenerU = k.u();
        if (tTAdInteractionListenerU == null || !u(1440L, this.u.x())) {
            return false;
        }
        jk.u().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.l.x.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put("app_name", uVar.u());
                map.put("app_icon_url", uVar.nr());
                map.put("event_id", Integer.valueOf(uVar.b()));
                map.put("package_name", uVar.fx());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt(ActionUtils.PAYMENT_AMOUNT, uVar.n());
                    jSONObject.putOpt("log_extra", uVar.pn());
                    jSONObject.putOpt("tag", uVar.x());
                    jSONObject.putOpt(WfConstant.EXTRA_KEY_DOWNLOAD_URL, uVar.jk());
                    jSONObject.putOpt("save_path", uVar.a());
                } catch (Exception unused) {
                }
                boolean zFx = jp.fx(dw.getContext(), uVar.fx());
                map.put("event_token", com.bytedance.sdk.component.utils.u.nr(jSONObject.toString()));
                tTAdInteractionListenerU.onAdEvent(zFx ? 102 : 101, map);
            }
        }, jB * 1000);
        return true;
    }

    public boolean u(long j, int i) {
        try {
            Long lValueOf = -1L;
            try {
                lValueOf = Long.valueOf(j * 60 * 1000);
            } catch (Exception e) {
                e.getMessage();
                i = -1;
            }
            if (lValueOf.longValue() >= 0 && i >= 0 && lValueOf.longValue() != 0 && i != 0) {
                String strU = u();
                StringBuilder sb = new StringBuilder();
                long jCurrentTimeMillis = System.currentTimeMillis();
                boolean z = true;
                if (TextUtils.isEmpty(strU)) {
                    sb.append(jCurrentTimeMillis);
                    u(sb.toString());
                    return true;
                }
                String[] strArrSplit = strU.split("_");
                int length = strArrSplit.length;
                if (length < i) {
                    Long.parseLong(strArrSplit[length - 1]);
                    for (String str : strArrSplit) {
                        sb.append(str);
                        sb.append("_");
                    }
                    sb.append(jCurrentTimeMillis);
                    u(sb.toString());
                    return true;
                }
                int i2 = length - i;
                if (jCurrentTimeMillis - Long.valueOf(Long.parseLong(strArrSplit[i2])).longValue() <= lValueOf.longValue()) {
                    z = false;
                }
                for (int i3 = i2; i3 < length; i3++) {
                    String str2 = strArrSplit[i3];
                    if (i3 != i2 && !TextUtils.isEmpty(str2)) {
                        sb.append(str2);
                        sb.append("_");
                    }
                }
                sb.append(jCurrentTimeMillis);
                u(sb.toString());
                return z;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String u() {
        return com.bytedance.sdk.openadsdk.core.nr.u().get("notification_b", "");
    }

    public static void u(String str) {
        com.bytedance.sdk.openadsdk.core.nr.u().put("notification_b", str);
    }
}
