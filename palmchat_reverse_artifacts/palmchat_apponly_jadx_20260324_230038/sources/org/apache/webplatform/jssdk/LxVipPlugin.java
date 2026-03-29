package org.apache.webplatform.jssdk;

import android.content.Context;
import android.os.Bundle;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import defpackage.ap3;
import defpackage.ds0;
import defpackage.fk2;
import defpackage.lb3;
import defpackage.n5;
import defpackage.qm5;
import defpackage.v4;
import java.util.ArrayList;
import java.util.List;
import org.apache.cordova.jssdk.general.Action;
import org.apache.cordovaNew.CallbackContext;
import org.apache.cordovaNew.CordovaInterface;
import org.apache.cordovaNew.CordovaPlugin;
import org.apache.cordovaNew.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LxVipPlugin extends CordovaPlugin {
    public static final String TAG = "LxVipPlugin";
    private List<CallbackContext> callbackContextList;

    @Override // org.apache.cordovaNew.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        if ("showPaymentPage".equals(str)) {
            this.callbackContextList.add(callbackContext);
            ap3.w(this.cordova.getContext(), jSONArray.optString(0));
            return true;
        }
        if ("jumpToVIPIntroducePage".equals(str)) {
            this.callbackContextList.add(callbackContext);
            ap3.p(this.cordova.getContext(), jSONArray.optString(0));
            return true;
        }
        if ("jumpToUserProfilePage".equals(str)) {
            String strOptString = jSONArray.optString(0, "");
            int iOptInt = jSONArray.optInt(1, 0);
            if (goUserDetail(this.cordova.getContext(), strOptString, jSONArray.optInt(2, -1), iOptInt)) {
                callbackContext.success("");
            } else {
                callbackContext.error("");
            }
            return true;
        }
        if (!Action.ACTION_SQUARE_OPEN_FEED_DETAIL.equals(str)) {
            return super.execute(str, jSONArray, callbackContext);
        }
        if (ap3.o(this.cordova.getContext(), jSONArray.optString(0), jSONArray.optLong(1), jSONArray.optInt(3))) {
            callbackContext.success("");
        } else {
            callbackContext.error("");
        }
        return true;
    }

    public boolean goUserDetail(Context context, String str, int i, int i2) {
        try {
            fk2.a aVar = new fk2.a();
            Bundle bundle = new Bundle();
            int i3 = 64;
            int i4 = 44;
            if (i2 == 11) {
                i2 = 37;
            } else if (i2 != 12) {
                i3 = 66;
                i4 = 45;
                if (i2 == 45) {
                    i2 = 45;
                } else if (i2 != 46) {
                    i4 = -1;
                    i3 = 0;
                } else {
                    i2 = 46;
                }
            } else {
                i2 = 38;
            }
            ContactInfoItem contactInfoItem = new ContactInfoItem();
            if (str.equals(v4.b(context))) {
                contactInfoItem.setUid(v4.e(context));
            } else {
                contactInfoItem.setUid("");
            }
            contactInfoItem.setExid(str);
            contactInfoItem.setGender(i);
            contactInfoItem.setSourceType(i4);
            contactInfoItem.setBizType(i3);
            bundle.putParcelable("user_item_info", contactInfoItem);
            bundle.putInt("from", i2);
            aVar.b(bundle);
            context.startActivity(n5.a(context, aVar));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public void initialize(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
        super.initialize(cordovaInterface, cordovaWebView);
        this.callbackContextList = new ArrayList();
        ds0.a().c(this);
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public void onDestroy() {
        super.onDestroy();
        ds0.a().d(this);
    }

    @qm5
    public void receivedVipCheckEvent(lb3 lb3Var) {
        List<CallbackContext> list;
        if (lb3Var == null || (list = this.callbackContextList) == null || list.isEmpty()) {
            return;
        }
        for (CallbackContext callbackContext : this.callbackContextList) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("payStatus", lb3Var.b());
                callbackContext.success(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        this.callbackContextList.clear();
    }
}
