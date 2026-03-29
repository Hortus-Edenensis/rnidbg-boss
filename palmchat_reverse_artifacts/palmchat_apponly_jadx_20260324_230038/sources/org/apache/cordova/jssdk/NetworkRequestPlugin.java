package org.apache.cordova.jssdk;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ContactRequestArgs;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bo0;
import defpackage.dt2;
import defpackage.ih;
import defpackage.rx4;
import defpackage.sd3;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class NetworkRequestPlugin extends CordovaPlugin {
    private static String TAG = "NetworkRequestPlugin";

    /* JADX INFO: Access modifiers changed from: private */
    public void addFriendAlert(final String str, final String str2, final String str3) {
        View viewInflate = LayoutInflater.from(this.cordova.getOwnerActivity2()).inflate(R.layout.layout_dialog_add_friend_content, (ViewGroup) null);
        final TextView textView = (TextView) viewInflate.findViewById(R.id.count);
        final EditText editText = (EditText) viewInflate.findViewById(R.id.edit_text);
        ContactInfoItem contactInfoItemL = bo0.r().l(AccountUtils.p(AppContext.getContext()));
        editText.setText(contactInfoItemL != null ? this.cordova.getOwnerActivity2().getResources().getString(R.string.new_friend_request_message, contactInfoItemL.getNickName()) : this.cordova.getOwnerActivity2().getResources().getString(R.string.new_friend_request_message, AccountUtils.l(AppContext.getContext())));
        editText.addTextChangedListener(new TextWatcher() { // from class: org.apache.cordova.jssdk.NetworkRequestPlugin.2
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                dt2.e(editText, charSequence, 60, textView, true);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        new sd3(this.cordova.getOwnerActivity2()).p(viewInflate, false).T(R.string.string_add_friend_title).K(R.string.alert_dialog_cancel).O(R.string.alert_dialog_ok).f(new MaterialDialog.e() { // from class: org.apache.cordova.jssdk.NetworkRequestPlugin.3
            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                NetworkRequestPlugin.this.applyFriendImp(str, editText.getText().toString(), str2, str3);
            }
        }).e().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyFriendImp(String str, String str2, String str3, String str4) {
        Response.ErrorListener errorListener = new Response.ErrorListener() { // from class: org.apache.cordova.jssdk.NetworkRequestPlugin.4
            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                LogUtil.i(NetworkRequestPlugin.TAG, volleyError.toString());
            }
        };
        Response.Listener<JSONObject> listener = new Response.Listener<JSONObject>() { // from class: org.apache.cordova.jssdk.NetworkRequestPlugin.5
            @Override // com.android.volley.Response.Listener
            public void onResponse(JSONObject jSONObject) {
                LogUtil.i(NetworkRequestPlugin.TAG, jSONObject.toString());
                rx4.b(NetworkRequestPlugin.this.cordova.getOwnerActivity2(), jSONObject);
            }
        };
        ContactInfoItem contactInfoItemL = bo0.r().l(str);
        if (contactInfoItemL != null && !contactInfoItemL.getIsStranger()) {
            str3 = String.valueOf(contactInfoItemL.getSourceType());
        }
        if (contactInfoItemL == null) {
            contactInfoItemL = new ContactInfoItem();
            contactInfoItemL.setUid(str);
        }
        ContactRequestArgs contactRequestArgsA = new ContactRequestArgs.Builder().e(ContactRequestArgs.c(contactInfoItemL)).i(String.valueOf(str3)).j(str4).a();
        ih ihVar = new ih(listener, errorListener);
        try {
            ihVar.r(contactRequestArgsA);
            ihVar.v(true);
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, final JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        Log.i(TAG, str + "-" + jSONArray.toString());
        if (!"addFriendAlert".equals(str)) {
            return false;
        }
        this.cordova.getOwnerActivity2().runOnUiThread(new Runnable() { // from class: org.apache.cordova.jssdk.NetworkRequestPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                NetworkRequestPlugin.this.addFriendAlert(jSONArray.optString(0), jSONArray.optString(1), jSONArray.optString(2));
            }
        });
        return true;
    }
}
