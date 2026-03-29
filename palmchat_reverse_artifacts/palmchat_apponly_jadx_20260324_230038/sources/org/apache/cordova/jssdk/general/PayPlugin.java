package org.apache.cordova.jssdk.general;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.location.LocationConst;
import com.cdo.oaps.ad.OapsWrapper;
import com.lantern.auth.server.WkParams;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.framework.bridge.voicomatch.ContinueMatchEvent;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchType;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.an1;
import defpackage.av4;
import defpackage.az2;
import defpackage.ba3;
import defpackage.bg6;
import defpackage.ds0;
import defpackage.lh6;
import defpackage.pm5;
import defpackage.qp3;
import defpackage.rt2;
import defpackage.so6;
import defpackage.v8;
import defpackage.v93;
import defpackage.xn5;
import defpackage.y84;
import defpackage.za3;
import defpackage.zn6;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class PayPlugin extends SubPlugin {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "PayPlugin";
    public ba3 cordova;
    private v93 mWxProgramCallback;

    private void doCashOut(final v93 v93Var) {
        so6.a().f(new so6.a() { // from class: org.apache.cordova.jssdk.general.PayPlugin.2
            @Override // so6.a
            public void onCodeBack(String str) {
                if (v93Var != null) {
                    try {
                        JSONObject jSONObjectMakeDefaultSucMsg = PayPlugin.this.makeDefaultSucMsg();
                        jSONObjectMakeDefaultSucMsg.put("user_code", str);
                        v93Var.a(jSONObjectMakeDefaultSucMsg);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // so6.a
            public void onError(String str) {
            }
        });
    }

    private void getPayVer(v93 v93Var) {
        JSONObject jSONObjectMakeDefaultSucMsg = makeDefaultSucMsg();
        try {
            jSONObjectMakeDefaultSucMsg.put("ver", "v5");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        v93Var.a(jSONObjectMakeDefaultSucMsg);
    }

    private void notifyEvent(String str, v93 v93Var) {
        String strR2;
        try {
            LogUtil.i(TAG, "notifyEvent " + str);
            v93Var.a(makeDefaultSucMsg());
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                String strOptString = jSONObject.optString("type");
                int iOptInt = jSONObject.optInt(LocationConst.HDYawConst.KEY_HD_YAW_STATE);
                if ("superExposePay".equals(strOptString) && iOptInt == 0) {
                    xn5 xn5Var = new xn5(0);
                    xn5Var.b = 1;
                    ds0.a().b(xn5Var);
                } else if ("cancelVipBuy".equals(strOptString)) {
                    ds0.a().b(new bg6(iOptInt));
                } else if ("payBack".equals(strOptString)) {
                    Activity activity = this.mCordovaInterface.getActivity();
                    if ((activity instanceof CordovaWebActivity) && (strR2 = ((CordovaWebActivity) activity).r2()) != null) {
                        qp3.a().b(strR2, Pair.create(Integer.valueOf(iOptInt), ""));
                    }
                } else if ("openSuperShowCard".equals(strOptString)) {
                    an1.c().l(new y84(jSONObject.optString(BaseConstants.EVENT_LABEL_EXTRA)));
                } else if ("playRedEnvelope".equals(strOptString)) {
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(BaseConstants.EVENT_LABEL_EXTRA);
                    if (jSONObjectOptJSONObject != null) {
                        av4.m(this.mCordovaInterface.getActivity(), jSONObjectOptJSONObject);
                    }
                } else if ("voiceDating".equals(strOptString)) {
                    JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(BaseConstants.EVENT_LABEL_EXTRA);
                    if (jSONObjectOptJSONObject2 != null) {
                        lh6.V().n0(VoiceMatchType.buildFromType(jSONObjectOptJSONObject2.optInt("cardType")));
                    }
                } else if ("continueVoiceMatching".equals(strOptString)) {
                    JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject(BaseConstants.EVENT_LABEL_EXTRA);
                    if (jSONObjectOptJSONObject3 != null) {
                        ds0.a().b(new ContinueMatchEvent(jSONObjectOptJSONObject3.optInt("from"), jSONObjectOptJSONObject3.optInt("subPage")));
                    }
                } else if ("activateGuardian".equals(strOptString)) {
                    JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject(BaseConstants.EVENT_LABEL_EXTRA);
                    LogUtil.d(TAG, "SkuWeb activateGuardian extra " + jSONObjectOptJSONObject4);
                    if (jSONObjectOptJSONObject4 != null) {
                        try {
                            v8.g(this.mCordovaInterface.getActivity(), Long.parseLong(jSONObjectOptJSONObject4.optString("fuid")), jSONObjectOptJSONObject4.optString("fNickName"), Integer.parseInt(jSONObjectOptJSONObject4.optString("from")));
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void payByWxMiniProgram(JSONObject jSONObject, v93 v93Var) {
        if (jSONObject == null) {
            v93Var.a(makeErrorArgsMsg());
            return;
        }
        String strOptString = jSONObject.optString("wx_ID");
        String strOptString2 = jSONObject.optString(OapsWrapper.KEY_PATH);
        HashMap map = new HashMap();
        if (jSONObject.keys() != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.opt(next));
            }
        } else {
            map.put("Empty", "Empty");
        }
        zn6.j("open_wx_mini_program", null, map);
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
            v93Var.a(makeErrorArgsMsg());
            return;
        }
        this.mWxProgramCallback = v93Var;
        try {
            an1.c().p(this);
        } catch (Exception unused) {
        }
        so6.a().d(strOptString, strOptString2);
    }

    private void unionPay(JSONObject jSONObject, final v93 v93Var) {
        final rt2 rt2Var = new rt2();
        rt2Var.b(jSONObject, new za3() { // from class: org.apache.cordova.jssdk.general.PayPlugin.1
            @Override // defpackage.za3
            public void onPayBack(int i, String str, Object obj) {
                JSONObject jSONObjectMakeDefaultSucMsg = PayPlugin.this.makeDefaultSucMsg();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    if (obj instanceof Map) {
                        jSONObject2.put(BaseConstants.EVENT_LABEL_EXTRA, new JSONObject((Map) obj));
                    }
                    jSONObject2.put("retCode", i);
                    jSONObject2.put(WkParams.RETMSG, str);
                    jSONObjectMakeDefaultSucMsg.put("payResult", jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                rt2Var.c();
                v93Var.a(jSONObjectMakeDefaultSucMsg);
            }
        }, this.mCordovaInterface.getActivity());
    }

    @Override // defpackage.ib3
    public void exec(String str, JSONObject jSONObject, v93 v93Var) {
        str.hashCode();
        switch (str) {
            case "getPayVersion":
                getPayVer(v93Var);
                break;
            case "notifyEvent":
                notifyEvent(jSONObject.toString(), v93Var);
                break;
            case "unionPay":
                unionPay(jSONObject, v93Var);
                break;
            case "cashOut":
                doCashOut(v93Var);
                break;
            case "openWxMiniProgram":
                payByWxMiniProgram(jSONObject, v93Var);
                break;
            default:
                super.exec(str, jSONObject, v93Var);
                break;
        }
    }

    @Override // defpackage.ib3
    public void initialize(ba3 ba3Var) {
        super.initialize(ba3Var);
        this.cordova = ba3Var;
    }

    @Override // defpackage.ib3
    public void onDestroy() {
        super.onDestroy();
        try {
            an1.c().r(this);
        } catch (Exception unused) {
        }
    }

    @pm5(threadMode = ThreadMode.MAIN)
    public void onPayBack(WXLaunchMiniProgram.Resp resp) {
        try {
            an1.c().r(this);
        } catch (Exception unused) {
        }
        if (this.mWxProgramCallback != null) {
            JSONObject jSONObjectMakeDefaultSucMsg = makeDefaultSucMsg();
            try {
                jSONObjectMakeDefaultSucMsg.put("wxResp", az2.c(resp));
            } catch (JSONException unused2) {
            }
            this.mWxProgramCallback.a(jSONObjectMakeDefaultSucMsg);
        }
        this.mWxProgramCallback = null;
    }
}
