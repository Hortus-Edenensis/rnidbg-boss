package org.apache.cordova.jssdk;

import android.content.Intent;
import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.circle.app.keep.model.KeepMotionParam;
import com.zenmen.palmchat.circle.app.keep.ui.KeepMotionActivity;
import com.zenmen.palmchat.circle.app.keep.ui.KeepMotionGuideActivity;
import com.zenmen.palmchat.circle.app.keep.ui.KeepMotionListActivity;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import defpackage.az2;
import defpackage.c70;
import defpackage.dv0;
import defpackage.gc0;
import defpackage.ry5;
import java.util.ArrayList;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LxKeepPlugin extends CordovaPlugin {
    private void jumpGroup(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        final String strOptString = jSONObject.optString("roomId");
        if (jSONObject.optInt("type") == 1) {
            c70.R().K(strOptString, new dv0() { // from class: la3
                @Override // defpackage.dv0
                public final void onResponse(Object obj) {
                    this.f18947a.lambda$jumpGroup$0(strOptString, (GroupInfoItem) obj);
                }
            });
        } else {
            gc0.b(this.cordova.getOwnerActivity2(), strOptString, 12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$jumpGroup$0(String str, GroupInfoItem groupInfoItem) {
        if (groupInfoItem == null) {
            gc0.b(this.cordova.getOwnerActivity2(), str, 12);
            return;
        }
        Intent intent = new Intent(this.cordova.getOwnerActivity2(), (Class<?>) ChatterActivity.class);
        intent.putExtra("chat_item", groupInfoItem);
        intent.putExtra("chat_need_back_to_main", false);
        this.cordova.getOwnerActivity2().startActivity(intent);
    }

    private void playKeepVideo(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        int iOptInt = jSONObject.optInt("type");
        String strOptString = jSONObject.optString("data");
        String strOptString2 = jSONObject.optString("appInfo");
        String strOptString3 = jSONObject.optString("shareMessage");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        ArrayList arrayList = (ArrayList) az2.b(strOptString, new TypeToken<ArrayList<KeepMotionParam>>() { // from class: org.apache.cordova.jssdk.LxKeepPlugin.1
        }.getType());
        if (arrayList == null || arrayList.isEmpty()) {
            ry5.a("数据参数空");
            return;
        }
        if (iOptInt == 0) {
            KeepMotionActivity.R1(this.cordova.getOwnerActivity2(), (KeepMotionParam) arrayList.get(0), strOptString2, strOptString3);
        } else if (iOptInt == 1) {
            KeepMotionListActivity.X1(this.cordova.getOwnerActivity2(), arrayList, strOptString2, strOptString3);
        } else if (iOptInt == 2) {
            KeepMotionGuideActivity.M1(this.cordova.getOwnerActivity2(), (KeepMotionParam) arrayList.get(0));
        }
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, String str2, CallbackContext callbackContext) throws JSONException {
        if (TextUtils.equals(str, "lx_keepJumpGroup")) {
            jumpGroup(str2);
        } else if (TextUtils.equals(str, "lx_keepPlayVideo")) {
            playKeepVideo(str2);
        }
        return super.execute(str, str2, callbackContext);
    }
}
