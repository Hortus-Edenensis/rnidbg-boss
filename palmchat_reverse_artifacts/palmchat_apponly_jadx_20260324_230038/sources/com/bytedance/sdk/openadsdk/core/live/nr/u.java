package com.bytedance.sdk.openadsdk.core.live.nr;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.live.u.x;
import com.bytedance.sdk.openadsdk.core.s.u;
import com.bytedance.sdk.openadsdk.core.y.h;
import com.qq.gdt.action.ActionUtils;
import com.ss.android.download.api.constant.BaseConstants;
import defpackage.ll7;
import j$.util.function.Function$CC;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements Function<SparseArray<Object>, Object> {
    final x u;

    public u(x xVar) {
        this.u = xVar;
    }

    private void b(PluginValueSet pluginValueSet) {
        try {
            this.u.nr((Map<String, String>) pluginValueSet.objectValue(1, Map.class));
        } catch (Exception unused) {
        }
    }

    private void fx(PluginValueSet pluginValueSet) {
        try {
            this.u.fx((Map<String, String>) pluginValueSet.objectValue(1, Map.class));
        } catch (Exception unused) {
        }
    }

    private void iz(PluginValueSet pluginValueSet) {
        Map<String, String> map = (Map) pluginValueSet.objectValue(1, Map.class);
        if (map == null) {
            return;
        }
        this.u.u(map);
    }

    private Integer n(PluginValueSet pluginValueSet) {
        String strX = com.bytedance.sdk.openadsdk.core.live.nr.u().x();
        if (strX == null) {
            return null;
        }
        if (strX.replaceAll(".", "").startsWith("2112")) {
            Object[] objArrArrayValue = pluginValueSet.arrayValue(1, Object[].class);
            if (objArrArrayValue == null || objArrArrayValue.length == 0) {
                return null;
            }
            return (Integer) objArrArrayValue[0];
        }
        Map map = (Map) pluginValueSet.objectValue(1, Map.class);
        if (map == null || map.size() == 0) {
            return null;
        }
        return Integer.valueOf((String) map.get("adType"));
    }

    private void nr(PluginValueSet pluginValueSet) {
        String message;
        int i = -3;
        try {
            String str = (String) ((Map) pluginValueSet.objectValue(1, Map.class)).get("success");
            message = null;
            if (str != null) {
                if (Boolean.parseBoolean(str)) {
                    i = 2;
                } else {
                    message = "fake init failed";
                }
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        this.u.u(i, message, false, true);
    }

    private Object pn(PluginValueSet pluginValueSet) {
        try {
            Integer numN = n(pluginValueSet);
            if (numN == null) {
                return null;
            }
            return dw.u().u(h.u(numN.intValue()));
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Object u(PluginValueSet pluginValueSet) {
        String strStringValue = pluginValueSet.stringValue(0);
        if (TextUtils.isEmpty(strStringValue)) {
            return null;
        }
        strStringValue.hashCode();
        switch (strStringValue) {
            case "sendGoldExchangeCoupon":
                fx(pluginValueSet);
                return null;
            case "getBiddingToken":
                return pn(pluginValueSet);
            case "onTaskFinish":
                b(pluginValueSet);
                return null;
            case "onLiveFakeInitFinish":
                nr(pluginValueSet);
                return null;
            case "getPanglePluginVersion":
                return 7232;
            case "onAuthCallback":
                x(pluginValueSet);
                return null;
            case "getPangleApiVersion":
                return String.valueOf(d.fx);
            case "reportPangleEvent":
                iz(pluginValueSet);
                return null;
            default:
                return null;
        }
    }

    private void x(PluginValueSet pluginValueSet) {
        try {
            boolean z = true;
            Map map = (Map) pluginValueSet.objectValue(1, Map.class);
            String str = (String) map.get("is_auth");
            x xVar = this.u;
            if (Integer.valueOf(str).intValue() == 0) {
                z = false;
            }
            xVar.u(z, (String) map.get("open_uid"));
        } catch (Exception unused) {
        }
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    public void u(boolean z, String str, String str2, Map<String, String> map) {
        final JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (!jSONObject.has(entry.getKey())) {
                            jSONObject.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
            } catch (Exception unused) {
                return;
            }
        }
        new u.C0284u().u(str).nr(str2).fx(BaseConstants.CATEGORY_UMENG).pn(jSONObject.optString(ActionUtils.PAYMENT_AMOUNT)).b(jSONObject.optString("log_extra")).u(new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.live.nr.u.1
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject2) throws JSONException {
                if (!TextUtils.isEmpty(jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA))) {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("is_other_channel"))) {
                    jSONObject2.put("is_other_channel", jSONObject.optString("is_other_channel"));
                }
                if (jSONObject2.has(BaseConstants.EVENT_LABEL_IS_AD_EVENT)) {
                    return;
                }
                jSONObject2.putOpt(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
            }
        });
    }

    private boolean u(PluginValueSet pluginValueSet, int i) {
        try {
            Map map = (Map) pluginValueSet.objectValue(i, Map.class);
            if (map != null && map.containsKey("onlyUpdateState")) {
                if (Boolean.parseBoolean(String.valueOf(map.get("onlyUpdateState")))) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetA = ll7.j(sparseArray).a();
        int iIntValue = pluginValueSetA.intValue(-99999987);
        if (iIntValue == 0) {
            return u(pluginValueSetA);
        }
        if (iIntValue == 1) {
            u(pluginValueSetA.booleanValue(0), pluginValueSetA.stringValue(1), pluginValueSetA.stringValue(2), (Map) pluginValueSetA.objectValue(3, Map.class));
        } else if (iIntValue == 2) {
            this.u.u(pluginValueSetA.intValue(0), pluginValueSetA.stringValue(1), u(pluginValueSetA, 2), false);
        } else if (iIntValue == 3) {
            int iIntValue2 = pluginValueSetA.intValue(0);
            boolean zU = u(pluginValueSetA, 4);
            if (1000 == iIntValue2) {
                this.u.u(5, (String) null, zU, false);
                if (!zU) {
                    this.u.u();
                }
            } else if (1001 == iIntValue2) {
                this.u.u(-2, pluginValueSetA.stringValue(1), zU, false);
            }
        }
        return null;
    }
}
