package org.apache.cordova.jssdk.general;

import android.content.Context;
import android.os.Build;
import com.huawei.openalliance.ad.constant.az;
import com.lantern.auth.server.WkParams;
import com.umeng.analytics.pro.bd;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import defpackage.ac1;
import defpackage.dn0;
import defpackage.v4;
import defpackage.v93;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class PlatformInfoPlugin extends SubPlugin {
    @Override // defpackage.ib3
    public void exec(String str, JSONObject jSONObject, v93 v93Var) {
        Context applicationContext = this.mCordovaInterface.getActivity().getApplicationContext();
        String strE = v4.e(applicationContext);
        ContactInfoItem contactInfoItemA = dn0.a(strE);
        if (Action.ACTION_GET_USERINFO.equals(str)) {
            Object objC = v4.c(applicationContext);
            Object objD = v4.d();
            JSONObject jSONObjectMakeDefaultSucMsg = makeDefaultSucMsg();
            try {
                jSONObjectMakeDefaultSucMsg.put(DeviceInfoUtil.UID_TAG, strE);
                jSONObjectMakeDefaultSucMsg.put(WkParams.SESSIONID, objC);
                jSONObjectMakeDefaultSucMsg.put("token", objD);
                jSONObjectMakeDefaultSucMsg.put("name", contactInfoItemA != null ? contactInfoItemA.getNickName() : "");
                jSONObjectMakeDefaultSucMsg.put("headimgurl", contactInfoItemA != null ? contactInfoItemA.getIconURL() : "");
                jSONObjectMakeDefaultSucMsg.put("gender", contactInfoItemA != null ? contactInfoItemA.getGender() : 0);
                jSONObjectMakeDefaultSucMsg.put("age", contactInfoItemA != null ? contactInfoItemA.getAge() : 0);
                jSONObjectMakeDefaultSucMsg.put(bd.h, contactInfoItemA.getExid());
                jSONObjectMakeDefaultSucMsg.put("aiSleepAuth", false);
                v93Var.a(jSONObjectMakeDefaultSucMsg);
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                v93Var.a(makeErrorArgsMsg());
                return;
            }
        }
        if (Action.CANCELACCOUNT.equals(str)) {
            v93Var.a(makeDefaultSucMsg());
            AppContext.getContext().logout();
            return;
        }
        if (!Action.ACTION_GET_PLATFORM_INFO.equals(str)) {
            if (!Action.ACTION_ISTEENAGERMODE.equals(str)) {
                super.exec(str, jSONObject, v93Var);
                return;
            }
            JSONObject jSONObjectMakeDefaultSucMsg2 = makeDefaultSucMsg();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(Action.ACTION_ISTEENAGERMODE, TeenagersModeManager.a().d());
                jSONObjectMakeDefaultSucMsg2.put("data", jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            v93Var.a(jSONObjectMakeDefaultSucMsg2);
            return;
        }
        JSONObject jSONObjectMakeDefaultSucMsg3 = makeDefaultSucMsg();
        try {
            jSONObjectMakeDefaultSucMsg3.put("deviceId", ac1.h);
            jSONObjectMakeDefaultSucMsg3.put(az.aW, ac1.f);
            jSONObjectMakeDefaultSucMsg3.put("deviceName", ac1.b);
            jSONObjectMakeDefaultSucMsg3.put("platform", ac1.c);
            jSONObjectMakeDefaultSucMsg3.put("osVersion", ac1.e);
            jSONObjectMakeDefaultSucMsg3.put("channelId", ac1.m);
            jSONObjectMakeDefaultSucMsg3.put("versionName", ac1.g);
            jSONObjectMakeDefaultSucMsg3.put("manufacturer", Build.MANUFACTURER);
            jSONObjectMakeDefaultSucMsg3.put("brand", Build.BRAND);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        v93Var.a(jSONObjectMakeDefaultSucMsg3);
    }
}
