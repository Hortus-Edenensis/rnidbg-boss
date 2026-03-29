package org.apache.cordova.jssdk.general;

import android.text.TextUtils;
import android.webkit.WebView;
import com.qq.gdt.action.ActionUtils;
import com.zenmen.find.ConditionHelper;
import com.zenmen.find.bean.FindFriendCondition;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import defpackage.ma3;
import defpackage.v4;
import defpackage.v93;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class StoragePlugin extends SubPlugin {
    private JSONObject getValueFromLocal(JSONObject jSONObject) {
        String strN;
        try {
            String string = jSONObject.getString("key");
            if (TextUtils.isEmpty(string)) {
                throw new JSONException("can not find key!");
            }
            if ("key_find_friend_condition_recommend".equals(string)) {
                strN = ConditionHelper.getInstance().getRecommendCond().toString();
            } else if ("key_find_friend_condition_nearby".equals(string)) {
                strN = ConditionHelper.getInstance().getNearByCond().toString();
            } else {
                string = string + v4.e(AppContext.getContext());
                strN = SPUtil.f14322a.n(SPUtil.SCENE.JSAPI, string, "");
            }
            JSONObject jSONObjectMakeDefaultSucMsg = makeDefaultSucMsg();
            ma3.a("JSAPI getValueFromLocal " + string + " " + strN, new Object[0]);
            jSONObjectMakeDefaultSucMsg.put(ActionUtils.PAYMENT_AMOUNT, strN);
            return jSONObjectMakeDefaultSucMsg;
        } catch (JSONException e) {
            e.printStackTrace();
            return makeInvalidArgsMsg();
        }
    }

    private JSONObject saveValueToLocal(JSONObject jSONObject, WebView webView) {
        try {
            ma3.a("JSAPI saveValueToLocal " + jSONObject, new Object[0]);
            String string = jSONObject.getString("key");
            String strOptString = jSONObject.optString(ActionUtils.PAYMENT_AMOUNT, "{}");
            if (TextUtils.isEmpty(string)) {
                throw new JSONException("can not find key!");
            }
            if (string.equals("key_find_friend_condition_recommend")) {
                final FindFriendCondition findFriendCondition = new FindFriendCondition(strOptString);
                webView.post(new Runnable() { // from class: org.apache.cordova.jssdk.general.StoragePlugin.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ConditionHelper.getInstance().setRecommendCond(findFriendCondition);
                    }
                });
            } else if (string.equals("key_find_friend_condition_nearby")) {
                final FindFriendCondition findFriendCondition2 = new FindFriendCondition(strOptString);
                webView.post(new Runnable() { // from class: org.apache.cordova.jssdk.general.StoragePlugin.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ConditionHelper.getInstance().setNearByCond(findFriendCondition2);
                    }
                });
            } else {
                SPUtil.f14322a.t(SPUtil.SCENE.JSAPI, string + v4.e(AppContext.getContext()), strOptString);
            }
            return makeDefaultSucMsg();
        } catch (Exception e) {
            e.printStackTrace();
            return makeInvalidArgsMsg();
        }
    }

    @Override // defpackage.ib3
    public void exec(String str, JSONObject jSONObject, v93 v93Var) {
        if (Action.ACTION_GET_LOCAL_VALUE.equals(str)) {
            v93Var.a(getValueFromLocal(jSONObject));
        } else if (Action.ACTION_SAVE_LOCAL_VALUE.equals(str)) {
            v93Var.a(saveValueToLocal(jSONObject, this.mCordovaInterface.getWebView()));
        }
    }
}
