package org.apache.cordova.jssdk;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.zenmen.media.SquareCameraActivity;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.onekeyfriend.RecommendResultActivity;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.SendMessageActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.k86;
import defpackage.mj5;
import defpackage.n86;
import defpackage.st2;
import defpackage.sy5;
import defpackage.zt5;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.http.protocol.HTTP;
import org.apache.webplatform.jssdk.ContactPlugin;
import org.apache.webplatform.jssdk.WebPlatformPlugin;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class StartActivityPlugin extends CordovaPlugin {
    private void doStartActivity(Intent intent, CallbackContext callbackContext, boolean z) {
        try {
            this.cordova.getOwnerActivity2().startActivity(intent);
            callbackContext.success();
            if (z) {
                this.cordova.getOwnerActivity2().finish();
            }
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            callbackContext.error(e.toString());
        }
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        int i = 0;
        z = false;
        z = false;
        boolean z = false;
        if (str.equals("startActivityByComponent")) {
            String strOptString = jSONArray.optString(0);
            String strOptString2 = jSONArray.optString(1);
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(2);
            if (strOptString2 != null && strOptString2.equals("com.zenmen.palmchat.contacts.PhoneContactActivity")) {
                strOptString2 = "com.zenmen.palmchat.contacts.recommend.RecommendFriendsActivity";
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(strOptString, strOptString2));
            Bundle bundleJsonToBundle = CordovaUtils.jsonToBundle(jSONObjectOptJSONObject);
            if (bundleJsonToBundle.containsKey("data")) {
                intent.setData(Uri.parse(bundleJsonToBundle.getString("data")));
                bundleJsonToBundle.remove("data");
            }
            intent.putExtras(bundleJsonToBundle);
            try {
                String string = bundleJsonToBundle.getString(ContactPlugin.EXTRA_KEY_FROM);
                if (!TextUtils.isEmpty(string)) {
                    if (string.equals(ContactPlugin.EXTRA_KEY_FROM_H5)) {
                        z = true;
                    }
                }
            } catch (Exception unused) {
            }
            doStartActivity(intent, callbackContext, z);
            return true;
        }
        if (str.equals("startActivityByAction")) {
            String strOptString3 = jSONArray.optString(0);
            JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(1);
            Intent intent2 = new Intent(strOptString3);
            Bundle bundleJsonToBundle2 = CordovaUtils.jsonToBundle(jSONObjectOptJSONObject2);
            if (bundleJsonToBundle2.containsKey("data")) {
                intent2.setData(Uri.parse(bundleJsonToBundle2.getString("data")));
                bundleJsonToBundle2.remove("data");
            }
            intent2.putExtras(bundleJsonToBundle2);
            doStartActivity(intent2, callbackContext, false);
            return true;
        }
        if (str.equals("startBootGuideActivity")) {
            n86.d(AppContext.getContext());
            callbackContext.success();
            return true;
        }
        if (str.equals("jumpToNearbyPeople")) {
            if (TeenagersModeManager.a().d()) {
                zt5.c();
                try {
                    this.cordova.getOwnerActivity2().finish();
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                Intent intentC = st2.c();
                intentC.putExtra("intent_key_from", "value_intent_from_secretary");
                intentC.putExtra("fromType", 1);
                LogUtil.onClickEvent("93322", null, null);
                doStartActivity(intentC, callbackContext, true);
                Intent intent3 = new Intent(RecommendResultActivity.u);
                intent3.putExtra(RecommendResultActivity.v, true);
                sendLocalBroadcast(intent3);
            }
            return true;
        }
        if (str.equals("jumpToNearbyPeopleNew")) {
            if (TeenagersModeManager.a().d()) {
                zt5.c();
                try {
                    this.cordova.getOwnerActivity2().finish();
                } catch (ActivityNotFoundException e2) {
                    e2.printStackTrace();
                }
            } else {
                Intent intentC2 = st2.c();
                intentC2.putExtra("intent_key_from", "value_intent_from_secretary");
                if (jSONArray.optString(0).equals("10")) {
                    intentC2.putExtra("fromType", 10);
                } else {
                    intentC2.putExtra("fromType", 11);
                }
                LogUtil.onClickEvent("93322", null, null);
                doStartActivity(intentC2, callbackContext, true);
                Intent intent4 = new Intent(RecommendResultActivity.u);
                intent4.putExtra(RecommendResultActivity.v, true);
                sendLocalBroadcast(intent4);
            }
            return true;
        }
        if (str.equals("jumpToSquarePublish")) {
            if (mj5.r().t()) {
                sy5.e(this.cordova.getOwnerActivity2(), R.string.square_publish_uploading_now, 1).g();
            } else {
                Intent intent5 = new Intent(this.cordova.getOwnerActivity2(), (Class<?>) SquareCameraActivity.class);
                intent5.putExtra("key_from", jSONArray.optInt(0, 0));
                doStartActivity(intent5, callbackContext, false);
            }
            return true;
        }
        if (str.equals("jumpToChat")) {
            String strOptString4 = jSONArray.optString(0);
            Intent intent6 = new Intent(this.cordova.getOwnerActivity2(), (Class<?>) ChatterActivity.class);
            ContactInfoItem contactInfoItem = new ContactInfoItem();
            contactInfoItem.setUid(strOptString4);
            intent6.putExtra("chat_item", contactInfoItem);
            intent6.putExtra("chat_need_back_to_main", true);
            k86.X(intent6);
            doStartActivity(intent6, callbackContext, false);
        } else {
            if (str.equals(WebPlatformPlugin.ACTION_JUMPTOCORDOVA)) {
                String strOptString5 = jSONArray.optString(0);
                Intent intent7 = new Intent();
                intent7.setClass(this.cordova.getOwnerActivity2(), CordovaWebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("web_url", strOptString5);
                bundle.putInt("BackgroundColor", -1);
                intent7.putExtras(bundle);
                doStartActivity(intent7, callbackContext, false);
                return true;
            }
            if (str.equals("startApp")) {
                try {
                    Intent launchIntentForPackage = this.cordova.getOwnerActivity2().getPackageManager().getLaunchIntentForPackage(jSONArray.optString(0));
                    launchIntentForPackage.addFlags(268435456);
                    this.cordova.getOwnerActivity2().startActivity(launchIntentForPackage);
                    i = 1;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                callbackContext.success(i);
                return true;
            }
            if (str.equals("shareLink")) {
                String strOptString6 = jSONArray.optString(0);
                String strOptString7 = jSONArray.optString(1);
                String strOptString8 = jSONArray.optString(2);
                String strOptString9 = jSONArray.optString(3);
                Intent intent8 = new Intent(this.cordova.getOwnerActivity2(), (Class<?>) SendMessageActivity.class);
                intent8.setAction("android.intent.action.SEND");
                intent8.setType(HTTP.PLAIN_TEXT_TYPE);
                intent8.putExtra("android.intent.extra.SUBJECT", strOptString6);
                intent8.putExtra("android.intent.extra.TEXT", strOptString7);
                intent8.putExtra("android.intent.extra.shortcut.ICON", strOptString9);
                intent8.putExtra("extra_url", strOptString8);
                intent8.putExtra("extra_share_mode", 2);
                this.cordova.getOwnerActivity2().startActivity(intent8);
                callbackContext.success();
                return true;
            }
            if (str.equals("jumpToGuide")) {
                return true;
            }
        }
        return false;
    }

    public void registerLocalReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        LocalBroadcastManager.getInstance(this.cordova.getOwnerActivity2()).registerReceiver(broadcastReceiver, intentFilter);
    }

    public void sendLocalBroadcast(Intent intent) {
        LocalBroadcastManager.getInstance(this.cordova.getOwnerActivity2()).sendBroadcast(intent);
    }

    public void unregisterLocalReceiver(BroadcastReceiver broadcastReceiver) {
        LocalBroadcastManager.getInstance(this.cordova.getOwnerActivity2()).unregisterReceiver(broadcastReceiver);
    }
}
