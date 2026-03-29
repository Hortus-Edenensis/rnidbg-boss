package org.apache.cordova.jssdk;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import defpackage.ap3;
import defpackage.ds0;
import defpackage.fg6;
import defpackage.il5;
import defpackage.jb3;
import defpackage.ju4;
import defpackage.lb3;
import defpackage.ma3;
import defpackage.mb3;
import defpackage.qm5;
import defpackage.sy5;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.List;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LxVipPlugin extends CordovaPlugin {
    public static final int FAILED_BY_ALI_PAY_CALLBACK = 2;
    private static final int FAILED_BY_LX_PAY_CALLBACK = 1;
    private static final int FAILED_BY_NOT_INSTALL_ALI = 4;
    private static final int FAILED_BY_NOT_INSTALL_WX = 3;
    private static final int FAILED_BY_ORDER_INFO_NULL = 6;
    private static final int FAILED_BY_RESOLVING_ORDER_INFO = 5;
    private static final int PAY_FAILED = 3;
    private static final int PAY_SUCCESS_IS_NOT_VIP = 2;
    private static final int PAY_SUCCESS_IS_VIP = 1;
    public static final String TAG = "LxVipPlugin";
    private List<CallbackContext> callbackContextList;
    private String orderInfo;
    private CallbackContext payCallbackContext;
    private String platform;
    private int retryCheckCount = 0;
    private String scene;

    private void aliPay(String str) {
        try {
            String strOptString = new JSONObject(str).optString("agreementUrl");
            if (TextUtils.isEmpty(strOptString)) {
                report("vip_buy_fail", 2, this.platform, str, 6, -1, "", fg6.j(this.cordova.getActivity().getApplicationContext()));
                throw new JSONException("order info is null");
            }
            this.retryCheckCount = 0;
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(strOptString));
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setComponent(null);
                intent.addFlags(268435456);
                this.cordova.getActivity().getApplicationContext().startActivity(intent);
                ds0.a().b(new mb3());
            } catch (Throwable unused) {
                sy5.f(this.cordova.getActivity(), "未安装支付宝", 0).g();
                report("vip_buy_fail", 2, this.platform, str, 4, -1, "", fg6.j(this.cordova.getActivity().getApplicationContext()));
            }
        } catch (Exception e) {
            e.printStackTrace();
            report("vip_buy_fail", 2, this.platform, str, 5, -1, "", fg6.j(this.cordova.getActivity().getApplicationContext()));
        }
    }

    private void checkVipStatus() {
        fg6.k(this.cordova.getActivity().getApplicationContext(), new fg6.b() { // from class: org.apache.cordova.jssdk.LxVipPlugin.1
            @Override // fg6.b
            public void onFail(Exception exc) {
                LxVipPlugin.this.retryCheckVipStatus();
            }

            @Override // fg6.b
            public void onSuccess(int i) {
                if (i < 0) {
                    LxVipPlugin.this.retryCheckVipStatus();
                    return;
                }
                lb3 lb3Var = new lb3(1, LxVipPlugin.this.scene);
                lb3Var.c(i);
                ds0.a().b(lb3Var);
            }
        });
    }

    private void payFailedCallback() {
        ds0.a().b(new lb3(3, this.scene));
    }

    public static void report(String str, int i, String str2, String str3, int i2, int i3, String str4, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("menuType", i);
            jSONObject.put("orderInfo", str3);
            jSONObject.put("errorType", i2);
            jSONObject.put("code", i3);
            jSONObject.put("message", str4);
            jSONObject.put("vip_status", z ? 1 : 0);
            if (i == 1) {
                jSONObject.put("platform", str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        zn6.d(str, null, jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryCheckVipStatus() {
        int i = this.retryCheckCount + 1;
        this.retryCheckCount = i;
        if (i <= 5) {
            checkVipStatus();
        } else {
            ds0.a().b(new lb3(2, this.scene));
        }
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        if ("vipPay".equals(str)) {
            this.payCallbackContext = callbackContext;
            int iOptInt = jSONArray.optInt(0);
            this.scene = jSONArray.optString(1, "empty");
            this.platform = jSONArray.optString(2);
            String strOptString = jSONArray.optString(3);
            this.orderInfo = strOptString;
            if (iOptInt == 2) {
                aliPay(strOptString);
            }
            return true;
        }
        if (!"showPaymentPage".equals(str)) {
            return super.execute(str, jSONArray, callbackContext);
        }
        this.callbackContextList.add(callbackContext);
        ma3.f("showPaymentPage callBack id =" + callbackContext.getCallbackId());
        ap3.w(this.cordova.getActivity(), jSONArray.optString(0));
        return true;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void initialize(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
        super.initialize(cordovaInterface, cordovaWebView);
        this.callbackContextList = new ArrayList();
        ju4.b(cordovaInterface.getActivity().getApplication());
        ds0.a().c(this);
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onDestroy() {
        super.onDestroy();
        ds0.a().d(this);
    }

    @qm5
    public void receivedVipAliPayEvent(jb3 jb3Var) {
        JSONObject jSONObject = new JSONObject();
        if (jb3Var != null) {
            try {
                String strA = jb3Var.a();
                if (il5.l(strA) || !"10000".equals(strA)) {
                    if (this.payCallbackContext != null) {
                        jSONObject.put("code", -1);
                        this.payCallbackContext.success(jSONObject);
                    }
                    payFailedCallback();
                    return;
                }
                if (this.payCallbackContext != null) {
                    jSONObject.put("code", 0);
                    this.payCallbackContext.success(jSONObject);
                }
                checkVipStatus();
            } catch (JSONException e) {
                e.printStackTrace();
                try {
                    if (this.payCallbackContext != null) {
                        jSONObject.put("code", -1);
                        this.payCallbackContext.success(jSONObject);
                    }
                    payFailedCallback();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @qm5
    public void receivedVipCheckEvent(lb3 lb3Var) {
        List<CallbackContext> list;
        if (lb3Var == null || (list = this.callbackContextList) == null || list.isEmpty()) {
            return;
        }
        for (CallbackContext callbackContext : this.callbackContextList) {
            try {
                ma3.f("callbackContext id =" + callbackContext.getCallbackId());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("payStatus", lb3Var.b());
                callbackContext.success(jSONObject);
                ma3.f("callbackContext success =" + jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        this.callbackContextList.clear();
    }
}
