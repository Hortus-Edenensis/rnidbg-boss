package com.bytedance.sdk.openadsdk.core.m.nr;

import android.content.Context;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.jp.u.pn;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.m.b;
import com.bytedance.sdk.openadsdk.core.m.iz;
import com.bytedance.sdk.openadsdk.core.m.n;
import com.bytedance.sdk.openadsdk.core.m.nr;
import com.bytedance.sdk.openadsdk.core.sx;
import com.bytedance.sdk.openadsdk.gi.x;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private int b;
    private Context fx;
    private SSWebView nr;
    bc u;
    private int pn = 1;
    private int iz = -3;
    private int x = -1;

    public u(SSWebView sSWebView, Context context, int i, bc bcVar) {
        this.nr = sSWebView;
        this.fx = context;
        this.b = i;
        this.u = bcVar;
    }

    public static /* synthetic */ int fx(u uVar) {
        int i = uVar.pn;
        uVar.pn = i + 1;
        return i;
    }

    @JavascriptInterface
    public int getNetOperatorType() {
        final int iNr = nr();
        if (iNr == -1 || iNr == -2) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            x.u(new a("getNetOperatorType") { // from class: com.bytedance.sdk.openadsdk.core.m.nr.u.1
                @Override // java.lang.Runnable
                public void run() {
                    u.this.u(-1, System.currentTimeMillis() - jCurrentTimeMillis, false, "获取运行商类型为-1或-2,直接标记取号失败", iNr, u.this.pn);
                }
            });
        }
        return iNr;
    }

    @JavascriptInterface
    public String sendNetworkSwitch(final String str) {
        Context context;
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.b > 0) {
            x.u(new a("send_network_switch") { // from class: com.bytedance.sdk.openadsdk.core.m.nr.u.2
                @Override // java.lang.Runnable
                public void run() {
                    int iNr;
                    try {
                        iNr = new JSONObject(str).optInt("operType");
                    } catch (JSONException unused) {
                        iNr = -3;
                    }
                    if (iNr != 1 && iNr != 2 && iNr != 3) {
                        iNr = u.this.nr();
                    }
                    final int i = iNr;
                    if (i == 3 && u.this.iz == 3) {
                        u.fx(u.this);
                    } else {
                        u.this.pn = 1;
                    }
                    u.this.iz = i;
                    if (u.this.fx != null) {
                        new n(u.this.fx, new nr()).u(str, new b() { // from class: com.bytedance.sdk.openadsdk.core.m.nr.u.2.1
                            @Override // com.bytedance.sdk.openadsdk.core.m.b
                            public void u(boolean z, int i2, int i3, String str2, Map<String, List<String>> map, String str3) {
                                TextUtils.isEmpty(str3);
                                if (z) {
                                    str2 = "取号成功";
                                } else if (TextUtils.isEmpty(str2)) {
                                    str2 = "取号失败";
                                }
                                u uVar = u.this;
                                long jCurrentTimeMillis2 = System.currentTimeMillis();
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                uVar.u(i2, jCurrentTimeMillis2 - jCurrentTimeMillis, z, str2, i, u.this.pn);
                                JSONObject jSONObject = new JSONObject();
                                if (str3 == null) {
                                    str3 = "";
                                }
                                try {
                                    jSONObject.put("data", str3);
                                    jSONObject.put("networkType", i2);
                                } catch (JSONException unused2) {
                                }
                                if (u.this.nr != null) {
                                    s.u(u.this.nr, "javascript:receiveNetworkSwitch(" + jSONObject + ")");
                                }
                            }
                        });
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("data", "取号失败，context is null");
                        jSONObject.put("networkType", 0);
                    } catch (JSONException unused2) {
                    }
                    if (u.this.nr != null) {
                        s.u(u.this.nr, "javascript:receiveNetworkSwitch(" + jSONObject + ")");
                    }
                    u.this.u(-1, System.currentTimeMillis() - jCurrentTimeMillis, false, "context is null", i, u.this.pn);
                }
            });
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        if (this.x == -1 && (context = this.fx) != null) {
            this.x = iz.u(context, iz.u(context));
        }
        try {
            jSONObject.put("data", "没有wifi网络下获取手机号权限");
            jSONObject.put("networkType", this.x);
        } catch (JSONException unused) {
        }
        SSWebView sSWebView = this.nr;
        if (sSWebView != null) {
            s.u(sSWebView, "javascript:receiveNetworkSwitch(" + jSONObject + ")");
        }
        u(-1, System.currentTimeMillis() - jCurrentTimeMillis, false, "没有wifi网络下获取手机号权限", -1, this.pn);
        return "";
    }

    public int nr() {
        int i = this.b;
        if (i <= 0) {
            return -1;
        }
        Context context = this.fx;
        if (context == null || i == 1) {
            return -3;
        }
        int iU = iz.u(context, iz.u(context));
        this.x = iU;
        if (iU == 0 || iU == 2) {
            return -2;
        }
        String strU = pn.u(u());
        strU.hashCode();
        switch (strU) {
            case "1":
                return 1;
            case "2":
                return 3;
            case "3":
                return 2;
            default:
                return -3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final int i, final long j, final boolean z, final String str, final int i2, final int i3) {
        com.bytedance.sdk.openadsdk.core.s.b.u(this.u, "wifi_auth", "click_other", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.m.nr.u.3
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("wifi_auth_referer", "huoshan_JSSDK");
                jSONObject2.putOpt("wifi_auth_network_type", Integer.valueOf(i));
                jSONObject2.putOpt("wifi_auth_duration", Long.valueOf(j));
                jSONObject2.putOpt("wifi_auth_status", z ? "success" : "failure");
                String str2 = str;
                if (str2 == null) {
                    str2 = "";
                }
                jSONObject2.putOpt("wifi_auth_detail_info", str2);
                jSONObject2.putOpt("wifi_auth_carrier", Integer.valueOf(i2));
                jSONObject2.putOpt("wifi_auth_redirect_time", Integer.valueOf(i3));
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
    }

    public static String u() {
        TelephonyManager telephonyManagerU;
        try {
            com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx = com.bytedance.sdk.openadsdk.core.n.o().sx();
            if ((bVarSx == null || bVarSx.fx()) && (telephonyManagerU = sx.u()) != null && Build.VERSION.SDK_INT >= 22) {
                return telephonyManagerU.createForSubscriptionId(SubscriptionManager.getDefaultDataSubscriptionId()).getSimOperator();
            }
        } catch (Exception e) {
            k.nr("transmit_TTWifiObject", " getActiveSimOperator error :" + e.toString());
        }
        return null;
    }
}
