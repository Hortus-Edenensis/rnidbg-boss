package com.bytedance.sdk.openadsdk.core.ugeno.express.u;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.nr.fx;
import com.bytedance.adsdk.ugeno.pn.iz;
import com.bytedance.sdk.openadsdk.core.bq.u.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.nativeexpress.t;
import com.huawei.openalliance.ad.constant.bq;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    public static final HashSet<String> u = new HashSet<>(Arrays.asList("interactiveFinish", "nextVideoCancel", "haptic", "closeWidget", bq.b.C));

    public static void u(t tVar, nr nrVar, bc bcVar, Context context, String str, iz.u uVar, com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz izVar, fx fxVar) {
        Map<String, String> mapFx;
        int iU;
        if (uVar == null) {
        }
        mapFx = uVar.fx();
        str.hashCode();
        iU = 0;
        switch (str) {
            case "nextVideoCancel":
                if (nrVar != null) {
                    nrVar.u();
                    break;
                }
                break;
            case "haptic":
                if (mapFx != null) {
                    String str2 = mapFx.get("params");
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u.fx.u(new JSONObject(str2), context, bcVar);
                        } catch (JSONException unused) {
                            return;
                        }
                    }
                    break;
                }
                break;
            case "closeWidget":
                if (izVar != null) {
                    izVar.pn();
                    break;
                }
                break;
            case "interactiveFinish":
                if (mapFx != null) {
                    try {
                        iU = dw.u(bcVar, Integer.parseInt(mapFx.get("reduce_duration")));
                    } catch (NumberFormatException unused2) {
                    }
                }
                if (tVar != null) {
                    tVar.nr(iU);
                    break;
                }
                break;
            case "dismiss":
                if (fxVar != null) {
                    fxVar.nr(8);
                    break;
                }
                break;
        }
    }
}
