package org.apache.cordova.jssdk;

import android.content.ContentValues;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.lantern.auth.server.WkParams;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bo0;
import defpackage.ho3;
import defpackage.i65;
import defpackage.iq5;
import defpackage.jw5;
import defpackage.sy5;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.jssdk.general.Action;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class ReportPlugin extends CordovaPlugin {
    private static final int CORDOVA_GET_CHAT_INFO = 4097;
    private static String TAG = "ReportPlugin";
    private ChatItem contactInfoItem;
    private CallbackContext mCallbackContext;
    private i65 mSetContactConfigDao;
    private Response.ErrorListener mSetThreadConfigSendErrorListener = new Response.ErrorListener() { // from class: org.apache.cordova.jssdk.ReportPlugin.1
        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.d(ReportPlugin.TAG, volleyError.toString());
            ReportPlugin.this.mCallbackContext.error(volleyError.toString());
        }
    };
    private Response.Listener<JSONObject> mSetThreadConfigSendListener = new Response.Listener<JSONObject>() { // from class: org.apache.cordova.jssdk.ReportPlugin.2
        @Override // com.android.volley.Response.Listener
        public void onResponse(JSONObject jSONObject) {
            LogUtil.d(ReportPlugin.TAG, jSONObject.toString());
            if (jSONObject.optInt("resultCode") != 0) {
                ReportPlugin.this.mCallbackContext.error(jSONObject.toString());
            } else {
                iq5.j(false, new String[0]);
                ReportPlugin.this.mCallbackContext.success();
            }
        }
    };

    private void changeThreadConfig(String str, int i) {
        i65 i65Var = new i65(this.mSetThreadConfigSendListener, this.mSetThreadConfigSendErrorListener);
        this.mSetContactConfigDao = i65Var;
        try {
            i65Var.n(str, i);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    private void getReport(CallbackContext callbackContext) {
        JSONObject jSONObject = new JSONObject();
        String stringExtra = this.cordova.getActivity().getIntent().getStringExtra("uidTo");
        String stringExtra2 = this.cordova.getActivity().getIntent().getStringExtra("exidTo");
        int intExtra = this.cordova.getActivity().getIntent().getIntExtra("sourceType", -1);
        Object objP = AccountUtils.p(AppContext.getContext());
        Object objGenerateMessageToken = EncryptUtils.generateMessageToken();
        Object objO = AccountUtils.o(AppContext.getContext());
        try {
            if (!TextUtils.isEmpty(stringExtra)) {
                jSONObject.put("uidTo", stringExtra);
            }
            if (!TextUtils.isEmpty(stringExtra2)) {
                jSONObject.put("exidTo", stringExtra2);
            }
            jSONObject.put("uidFrom", objP);
            jSONObject.put("sourceType", intExtra);
            jSONObject.put("token", objGenerateMessageToken);
            jSONObject.put(WkParams.SESSIONID, objO);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "JSON : -" + jSONObject.toString());
        callbackContext.success(jSONObject);
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        Log.i(TAG, str + "-" + jSONArray.toString());
        this.mCallbackContext = callbackContext;
        this.contactInfoItem = (ChatItem) this.cordova.getActivity().getIntent().getParcelableExtra("contactInfoItem");
        if ("getReportInfo".equals(str)) {
            getReport(callbackContext);
            return true;
        }
        if (Action.ACTION_CLOSE_WINDOW.equals(str)) {
            this.cordova.getActivity().finish();
            return true;
        }
        if ("getChatInfo".equals(str)) {
            if (this.contactInfoItem != null) {
                Intent intent = new Intent(this.cordova.getActivity(), (Class<?>) ChatterActivity.class);
                intent.putExtra("chat_item", this.contactInfoItem);
                intent.putExtra("chat_from_report", true);
                intent.putExtra("chat_need_back_to_main", false);
                this.cordova.startActivityForResult(this, intent, 4097);
            } else {
                sy5.h(this.cordova.getActivity(), "暂无聊天记录", 0);
            }
            return true;
        }
        if ("addToBlackList".equals(str)) {
            changeThreadConfig(this.contactInfoItem.getChatId(), jw5.b(this.contactInfoItem.getSessionConfig(), 8));
            return true;
        }
        if ("addToBlackListWithUid".equals(str)) {
            String strOptString = jSONArray.optString(0);
            ContactInfoItem contactInfoItemL = bo0.r().l(strOptString);
            changeThreadConfig(strOptString, jw5.b(contactInfoItemL != null ? contactInfoItemL.getSessionConfig() : 0, 8));
            return true;
        }
        if ("notifyWebViewError".equals(str)) {
            ((CordovaWebActivity) this.cordova.getActivity()).R2();
            int intExtra = this.cordova.getActivity().getIntent().getIntExtra("extra_key_biz_type", -1);
            String stringExtra = this.cordova.getActivity().getIntent().getStringExtra("extra_key_mid");
            if (intExtra != -1 && !TextUtils.isEmpty(stringExtra)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("msg_extend", "message_type_link_illegal");
                AppContext.getContext().getContentResolver().update(DBUriManager.a(ho3.class, intExtra), contentValues, "packet_id=?", new String[]{stringExtra});
            }
        }
        return false;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 4097 && i2 == -1 && intent != null) {
            try {
                this.mCallbackContext.success(new JSONArray(intent.getStringExtra("result")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
