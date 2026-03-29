package org.apache.webplatform.jssdk;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bu5;
import defpackage.dn0;
import defpackage.fk2;
import defpackage.fo0;
import defpackage.go0;
import defpackage.k86;
import defpackage.n5;
import defpackage.v4;
import org.apache.cordovaNew.CallbackContext;
import org.apache.cordovaNew.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class ContactPlugin extends CordovaPlugin {
    public static final String EXTRA_KEY_FROM = "upload_contact_from";
    public static final String EXTRA_KEY_FROM_H5 = "upload_contact_from_h5";
    private static final int FROM_GROUP_CHAT = 6;

    private void doAcceptFriendRequest(String str, String str2, String str3, int i, int i2, final CallbackContext callbackContext) {
        try {
            if (TextUtils.isEmpty(str)) {
                callbackContext.error("");
            } else {
                go0.a(str, str2, str3, i, i2, new fo0() { // from class: org.apache.webplatform.jssdk.ContactPlugin.3
                    @Override // defpackage.fo0
                    public void onResponse(int i3, String str4) {
                        callbackContext.success(str4);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            callbackContext.error("");
        }
    }

    private void doAddFriendRequest(JSONObject jSONObject, int i, boolean z, String str, String str2, final CallbackContext callbackContext) {
        String strOptString;
        try {
            strOptString = jSONObject.optString("fromUid");
        } catch (Exception e) {
            e = e;
        }
        try {
            if (TextUtils.isEmpty(strOptString)) {
                callbackContext.error("");
            } else {
                go0.b(strOptString, "", str, str2, z, jSONObject.optInt("requestType"), jSONObject.optInt("sourceType"), i, new fo0() { // from class: org.apache.webplatform.jssdk.ContactPlugin.4
                    @Override // defpackage.fo0
                    public void onResponse(int i2, String str3) {
                        callbackContext.success(str3);
                    }
                });
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            callbackContext.error("");
        }
    }

    private void doApplyFriendRequest(JSONObject jSONObject, int i, boolean z, String str, String str2, final CallbackContext callbackContext) {
        String strOptString;
        try {
            strOptString = jSONObject.optString("fromUid");
        } catch (Exception e) {
            e = e;
        }
        try {
            if (TextUtils.isEmpty(strOptString)) {
                callbackContext.error("");
            } else {
                go0.c(strOptString, "", str, str2, z, jSONObject.optInt("requestType"), jSONObject.optInt("sourceType"), i, new fo0() { // from class: org.apache.webplatform.jssdk.ContactPlugin.5
                    @Override // defpackage.fo0
                    public void onResponse(int i2, String str3) {
                        callbackContext.success(str3);
                    }
                });
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            callbackContext.error("");
        }
    }

    private void doGetAlbumInfo(String str, final CallbackContext callbackContext) {
        try {
            if (TextUtils.isEmpty(str)) {
                callbackContext.error("");
            } else {
                go0.g(str, new fo0() { // from class: org.apache.webplatform.jssdk.ContactPlugin.2
                    @Override // defpackage.fo0
                    public void onResponse(int i, String str2) {
                        if (i == 0) {
                            callbackContext.success(str2);
                        } else {
                            callbackContext.error("");
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doGetContactInfo(String str, String str2, final CallbackContext callbackContext) {
        try {
            if (TextUtils.isEmpty(str)) {
                callbackContext.error("");
            } else {
                go0.h(str, str2, new fo0() { // from class: org.apache.webplatform.jssdk.ContactPlugin.1
                    @Override // defpackage.fo0
                    public void onResponse(int i, String str3) {
                        if (i == 0) {
                            callbackContext.success(str3);
                        } else {
                            callbackContext.error("");
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doOnChatter(String str, CallbackContext callbackContext) {
        try {
            ContactInfoItem contactInfoItemA = dn0.a(str);
            if (contactInfoItemA != null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.zenmen.palmchat", "com.zenmen.palmchat.chat.ChatterActivity"));
                intent.putExtra("chat_item", contactInfoItemA);
                intent.putExtra("chat_need_back_to_main", true);
                intent.putExtra("chat_back_to_greet", false);
                k86.X(intent);
                doStartActivity(intent, callbackContext, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doOnGroupChat(String str, CallbackContext callbackContext) {
        LogUtil.uploadInfoImmediate("qhb802", null);
        n5.e(this.cordova.getContext(), str);
        callbackContext.success();
    }

    private void doStartActivity(Intent intent, CallbackContext callbackContext, boolean z) {
        try {
            this.cordova.getActivity().startActivity(intent);
            callbackContext.success();
            if (z) {
                this.cordova.getActivity().finish();
            }
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            callbackContext.error(e.toString());
        }
    }

    private void enhancedContactOnIgnore(CallbackContext callbackContext) {
        try {
            go0.d();
            this.cordova.getActivity().finish();
            go0.f();
            if (!SPUtil.f14322a.a(SPUtil.SCENE.CONTACT, k86.a("key_contact_enhanced_has_feedback"), false)) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.zenmen.palmchat", "com.zenmen.palmchat.contacts.EnhancedRecommendFeedbackActivity"));
                doStartActivity(intent, callbackContext, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        callbackContext.success();
    }

    private void enterEnhancedLandingPage(CallbackContext callbackContext) {
        try {
            go0.e();
        } catch (Exception e) {
            e.printStackTrace();
        }
        callbackContext.success();
    }

    private void exitEnhancedLandingPage(CallbackContext callbackContext) {
        try {
            go0.f();
        } catch (Exception e) {
            e.printStackTrace();
        }
        callbackContext.success();
    }

    private void getEnhancedContactList(final CallbackContext callbackContext) {
        try {
            LogUtil.uploadInfoImmediate(v4.e(c.b()), "3c2_h5_data", "1", null, null);
            go0.i(new fo0() { // from class: org.apache.webplatform.jssdk.ContactPlugin.6
                @Override // defpackage.fo0
                public void onResponse(int i, String str) {
                    if (i == 0) {
                        callbackContext.success(str);
                    } else {
                        callbackContext.error(str);
                    }
                    ContactPlugin.this.uploadEnhancedContactListResultEvent(i == 0);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            callbackContext.error("");
            uploadEnhancedContactListResultEvent(false);
        }
    }

    private void gotoContactRequestSend(JSONObject jSONObject, int i, CallbackContext callbackContext) {
        try {
            if (TextUtils.isEmpty(jSONObject.optString("fromUid"))) {
                callbackContext.error("");
            } else {
                go0.j(this.cordova.getActivity(), jSONObject, i);
                callbackContext.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
            callbackContext.error("");
        }
    }

    private void gotoPeopleNearby(int i, CallbackContext callbackContext) {
        try {
            if (bu5.b()) {
                bu5.c();
            } else {
                fk2.a aVar = new fk2.a();
                Bundle bundle = new Bundle();
                bundle.putInt("fromType", i);
                aVar.b(bundle);
                this.cordova.getActivity().startActivity(n5.c(this.cordova.getActivity(), aVar));
            }
            callbackContext.success();
        } catch (Exception e) {
            e.printStackTrace();
            callbackContext.error("");
        }
    }

    private void jumpToPhoneContactActivity(CallbackContext callbackContext) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_KEY_FROM, EXTRA_KEY_FROM_H5);
        intent.setComponent(new ComponentName("com.zenmen.palmchat", "com.zenmen.palmchat.contacts.recommend.RecommendFriendsActivity"));
        doStartActivity(intent, callbackContext, false);
    }

    private void showContactDetails(JSONObject jSONObject, CallbackContext callbackContext) {
        if (jSONObject != null) {
            fk2.a aVar = new fk2.a();
            Bundle bundle = new Bundle();
            bundle.putString("json_data", jSONObject.toString());
            bundle.putInt("from", 6);
            aVar.b(bundle);
            this.cordova.getContext().startActivity(n5.a(this.cordova.getContext(), aVar));
        }
        callbackContext.success();
    }

    private void showContactDetailsExt(JSONObject jSONObject, int i, int i2, CallbackContext callbackContext) {
        if (jSONObject != null) {
            try {
                jSONObject.put("sourceType", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            fk2.a aVar = new fk2.a();
            Bundle bundle = new Bundle();
            bundle.putString("json_data", jSONObject.toString());
            bundle.putInt("from", i2);
            aVar.b(bundle);
            this.cordova.getContext().startActivity(n5.a(this.cordova.getContext(), aVar));
        }
        callbackContext.success();
    }

    private void showPrivacy(CallbackContext callbackContext, String str) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.zenmen.palmchat", "com.zenmen.palmchat.activity.webview.CordovaWebActivity"));
        intent.setData(Uri.parse(str));
        doStartActivity(intent, callbackContext, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadEnhancedContactListResultEvent(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", z ? 1 : 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.uploadInfoImmediate(v4.e(c.b()), "3c2_h5_databack", "1", null, jSONObject.toString());
    }

    public void doOnMoment(String str, String str2, CallbackContext callbackContext) {
        try {
            ContactInfoItem contactInfoItemA = dn0.a(str);
            if (contactInfoItemA != null) {
                fk2.a aVar = new fk2.a();
                Bundle bundle = new Bundle();
                bundle.putString(DeviceInfoUtil.UID_TAG, str);
                bundle.putParcelable("user_item_info", contactInfoItemA);
                aVar.b(bundle);
                doStartActivity(n5.a(this.cordova.getActivity(), aVar), callbackContext, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        if (str.equals("jumpToPhoneContactActivity")) {
            jumpToPhoneContactActivity(callbackContext);
            return true;
        }
        if (str.equals("showPrivacy")) {
            showPrivacy(callbackContext, jSONArray.optString(0));
            return true;
        }
        if (str.equals("onMoment")) {
            doOnMoment(jSONArray.optString(0), jSONArray.optString(1), callbackContext);
            return true;
        }
        if (str.equals("onChatter")) {
            doOnChatter(jSONArray.optString(0), callbackContext);
            return true;
        }
        if (str.equals("onChatterExt")) {
            doOnChatter(jSONArray.optString(0), jSONArray.optString(1), callbackContext);
            return true;
        }
        if (str.equals("getContactInfo")) {
            doGetContactInfo(jSONArray.optString(0), jSONArray.optString(1), callbackContext);
            return true;
        }
        if (str.equals("getAlbumInfo")) {
            doGetAlbumInfo(jSONArray.optString(0), callbackContext);
            return true;
        }
        if (str.equals("acceptFriendRequest")) {
            doAcceptFriendRequest(jSONArray.optString(0), jSONArray.optString(1), jSONArray.optString(2), jSONArray.optInt(3), jSONArray.optInt(4), callbackContext);
            return true;
        }
        if (str.equals("showContactDetails")) {
            showContactDetails(jSONArray.optJSONObject(0), callbackContext);
            return true;
        }
        if (str.equals("onGroupChat")) {
            doOnGroupChat(jSONArray.optString(0), callbackContext);
            return true;
        }
        if (str.equals("showContactDetailsExt")) {
            showContactDetailsExt(jSONArray.optJSONObject(0), jSONArray.optInt(1), jSONArray.optInt(2), callbackContext);
            return true;
        }
        if (str.equals("gotoPeopleNearby")) {
            gotoPeopleNearby(jSONArray.optInt(0), callbackContext);
            return true;
        }
        if (str.equals("doAddFriendRequest")) {
            doAddFriendRequest(jSONArray.optJSONObject(0), jSONArray.optInt(1), jSONArray.optBoolean(2), jSONArray.optString(3), jSONArray.optString(4), callbackContext);
            return true;
        }
        if (str.equals("doApplyFriendRequest")) {
            doApplyFriendRequest(jSONArray.optJSONObject(0), jSONArray.optInt(1), jSONArray.optBoolean(2), jSONArray.optString(3), jSONArray.optString(4), callbackContext);
            return true;
        }
        if (str.equals("gotoContactRequestSend")) {
            gotoContactRequestSend(jSONArray.optJSONObject(0), jSONArray.optInt(1), callbackContext);
            return true;
        }
        if (str.equals("getEnhancedContactList")) {
            getEnhancedContactList(callbackContext);
            return true;
        }
        if (str.equals("enterEnhancedLandingPage")) {
            enterEnhancedLandingPage(callbackContext);
            return true;
        }
        if (str.equals("exitEnhancedLandingPage")) {
            exitEnhancedLandingPage(callbackContext);
            return true;
        }
        if (!str.equals("enhancedContactOnIgnore")) {
            return super.execute(str, jSONArray, callbackContext);
        }
        enhancedContactOnIgnore(callbackContext);
        return true;
    }

    private void doOnChatter(String str, String str2, CallbackContext callbackContext) {
        try {
            ContactInfoItem contactInfoItemA = dn0.a(str);
            if (contactInfoItemA != null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.zenmen.palmchat", "com.zenmen.palmchat.chat.ChatterActivity"));
                intent.putExtra("chat_item", contactInfoItemA);
                intent.putExtra("chat_need_back_to_main", true);
                intent.putExtra("chat_back_to_greet", false);
                intent.putExtra("greet_message", str2);
                k86.X(intent);
                doStartActivity(intent, callbackContext, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
