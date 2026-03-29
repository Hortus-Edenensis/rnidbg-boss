package org.apache.cordova.jssdk.general;

import android.app.Activity;
import android.content.Intent;
import android.util.Pair;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.ss.android.download.api.constant.BaseConstants;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ContactRequestArgs;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.f7;
import defpackage.ih;
import defpackage.iq5;
import defpackage.rk4;
import defpackage.rx4;
import defpackage.sy5;
import defpackage.v93;
import org.apache.cordova.PluginResult;
import org.apache.cordova.jssdk.CordovaUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class ContactPlugin extends SubPlugin {
    public static final int REQUEST_CODE = 1000;
    public static final String TAG = "ContactPlugin";
    private v93 mCallback;

    /* JADX INFO: compiled from: SearchBox */
    public static class AddFriendProcessor {
        private Activity activity;
        private AddFriendCallback callback;
        private boolean canToast = false;
        private int subType;
        private int type;
        private String uid;

        /* JADX INFO: compiled from: SearchBox */
        public interface AddFriendCallback {
            void onFinish(int i);
        }

        public AddFriendProcessor(Activity activity, String str, int i, int i2, AddFriendCallback addFriendCallback) {
            this.activity = activity;
            this.uid = str;
            this.type = i;
            this.subType = i2;
            this.callback = addFriendCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void applyFriend() {
            ContactRequestArgs contactRequestArgsA = new ContactRequestArgs.Builder().e(new Pair<>(this.uid, null)).i(String.valueOf(this.type)).j(String.valueOf(this.subType)).a();
            ih ihVar = new ih(new Response.Listener<JSONObject>() { // from class: org.apache.cordova.jssdk.general.ContactPlugin.AddFriendProcessor.2
                @Override // com.android.volley.Response.Listener
                public void onResponse(JSONObject jSONObject) {
                    int iOptInt = jSONObject.optInt("resultCode");
                    if (iOptInt == 0) {
                        AddFriendProcessor.this.callback.onFinish(1);
                    } else if (iOptInt == 1) {
                        AddFriendProcessor.this.callback.onFinish(2);
                    } else {
                        AddFriendProcessor.this.callback.onFinish(0);
                    }
                }
            }, new Response.ErrorListener() { // from class: org.apache.cordova.jssdk.general.ContactPlugin.AddFriendProcessor.1
                @Override // com.android.volley.Response.ErrorListener
                public void onErrorResponse(VolleyError volleyError) {
                    AddFriendProcessor.this.callback.onFinish(0);
                }
            });
            try {
                ihVar.r(contactRequestArgsA);
                ihVar.v(this.canToast);
            } catch (DaoException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        public void addFriend() {
            ContactRequestArgs contactRequestArgsA = new ContactRequestArgs.Builder().e(new Pair<>(this.uid, null)).i(String.valueOf(this.type)).j(String.valueOf(this.subType)).a();
            Response.Listener<JSONObject> listener = new Response.Listener<JSONObject>() { // from class: org.apache.cordova.jssdk.general.ContactPlugin.AddFriendProcessor.3
                @Override // com.android.volley.Response.Listener
                public void onResponse(JSONObject jSONObject) {
                    int iOptInt = jSONObject.optInt("resultCode");
                    if (iOptInt == 0) {
                        iq5.j(false, new String[0]);
                        AddFriendProcessor.this.callback.onFinish(1);
                        return;
                    }
                    if (iOptInt == 1) {
                        AddFriendProcessor.this.applyFriend();
                        return;
                    }
                    if (iOptInt == 1318) {
                        AddFriendProcessor.this.callback.onFinish(0);
                        if (AddFriendProcessor.this.canToast) {
                            sy5.e(AppContext.getContext(), R.string.send_refuse, 1).g();
                            return;
                        }
                        return;
                    }
                    if (iOptInt == 1320 || iOptInt == 1321) {
                        AddFriendProcessor.this.callback.onFinish(0);
                        if (AddFriendProcessor.this.canToast) {
                            rx4.b(AddFriendProcessor.this.activity, jSONObject);
                            return;
                        }
                        return;
                    }
                    AddFriendProcessor.this.callback.onFinish(0);
                    if (AddFriendProcessor.this.canToast) {
                        sy5.f(AppContext.getContext(), rx4.a(jSONObject), 0).g();
                    }
                }
            };
            Response.ErrorListener errorListener = new Response.ErrorListener() { // from class: org.apache.cordova.jssdk.general.ContactPlugin.AddFriendProcessor.4
                @Override // com.android.volley.Response.ErrorListener
                public void onErrorResponse(VolleyError volleyError) {
                    AddFriendProcessor.this.callback.onFinish(0);
                    if (AddFriendProcessor.this.canToast) {
                        sy5.e(AppContext.getContext(), R.string.send_failed, 0).g();
                    }
                }
            };
            f7 f7Var = new f7();
            f7Var.p(listener, errorListener);
            try {
                f7Var.n(contactRequestArgsA);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void addFriend(String str, int i, int i2, final v93 v93Var) {
        if (str != null) {
            new AddFriendProcessor(this.mCordovaInterface.getActivity(), str, i, i2, new AddFriendProcessor.AddFriendCallback() { // from class: org.apache.cordova.jssdk.general.ContactPlugin.1
                @Override // org.apache.cordova.jssdk.general.ContactPlugin.AddFriendProcessor.AddFriendCallback
                public void onFinish(int i3) {
                    JSONObject jSONObjectMakeDefaultSucMsg = ContactPlugin.this.makeDefaultSucMsg();
                    try {
                        jSONObjectMakeDefaultSucMsg.put("isFriend", i3);
                        LogUtil.i(ContactPlugin.TAG, "result=" + jSONObjectMakeDefaultSucMsg.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    v93Var.a(jSONObjectMakeDefaultSucMsg);
                }
            }).addFriend();
        }
    }

    private void getRecentChat() {
        Intent intent = new Intent();
        intent.setClassName(this.mCordovaInterface.getActivity().getPackageName(), "com.zenmen.palmchat.conversations.threadsnew.threadselect.ThreadSelectActivity");
        this.mCordovaInterface.startActivityForResult(this, intent, 1000);
    }

    @Override // defpackage.ib3
    public void exec(String str, JSONObject jSONObject, v93 v93Var) {
        this.mCallback = v93Var;
        if (Action.ACTION_OPENRECENTCHATCONTACTS.equals(str)) {
            getRecentChat();
        } else if (Action.ACTION_ADD_FRIEND.equals(str)) {
            addFriend(jSONObject.optString(DeviceInfoUtil.UID_TAG), jSONObject.optInt("type"), jSONObject.optInt("subtype"), v93Var);
        }
    }

    @Override // defpackage.ib3
    public void onActivityResult(int i, int i2, Intent intent) {
        LogUtil.i("ContactSelectPlugin", "onActivityResult = " + i);
        super.onActivityResult(i, i2, intent);
        v93 v93Var = this.mCallback;
        if (v93Var != null) {
            if (i != 1000 || i2 != -1 || intent == null) {
                if (i == 1000 && i2 == 0) {
                    v93Var.a(CordovaUtils.makeNormalJsResult(PluginResult.Status.USER_CANCELLATION));
                    return;
                }
                return;
            }
            ContactInfoItem contactInfoItem = (ContactInfoItem) intent.getParcelableExtra("KEY");
            if (contactInfoItem != null) {
                JSONObject jSONObjectMakeNormalJsResult = CordovaUtils.makeNormalJsResult(PluginResult.Status.OK);
                try {
                    jSONObjectMakeNormalJsResult.put(BaseConstants.EVENT_LABEL_EXTRA, rk4.a(contactInfoItem));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtil.i("ContactSelectPlugin", "result = " + jSONObjectMakeNormalJsResult);
                this.mCallback.a(jSONObjectMakeNormalJsResult);
            }
        }
    }
}
