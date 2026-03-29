package org.apache.cordova.jssdk.general;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.heytap.mcssdk.constant.b;
import com.huawei.hms.push.AttributionReporter;
import com.kuaishou.weapon.p0.g;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.maintab.dialog.PopContact;
import com.zenmen.palmchat.maintab.dialog.PopExt;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.model.bean.SquareFeedEvent;
import defpackage.an1;
import defpackage.az2;
import defpackage.b05;
import defpackage.cb3;
import defpackage.ch;
import defpackage.d20;
import defpackage.ds0;
import defpackage.eq3;
import defpackage.gr2;
import defpackage.hx3;
import defpackage.iq5;
import defpackage.jo6;
import defpackage.jr2;
import defpackage.k86;
import defpackage.lo;
import defpackage.pu1;
import defpackage.rl0;
import defpackage.sy5;
import defpackage.t66;
import defpackage.ts0;
import defpackage.u93;
import defpackage.v93;
import defpackage.ve;
import defpackage.wm3;
import defpackage.yg4;
import defpackage.zn6;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class UtilPlugin extends SubPlugin {
    private static final int PERMISSION_REQUEST_SELECT_STORAGE = 100;
    private v93 mCallbackContext;
    private String mImageUrl;

    private JSONObject backLoginPhonePage() {
        b05.a("backLoginPhonePage()");
        ch.s().r().i(new lo());
        this.mCordovaInterface.getActivity().finish();
        return makeDefaultSucMsg();
    }

    private JSONObject checkPermission(JSONObject jSONObject) {
        try {
            boolean zHasPermission = this.mCordovaInterface.hasPermission(jSONObject.getString(AttributionReporter.SYSTEM_PERMISSION));
            JSONObject jSONObjectMakeDefaultSucMsg = makeDefaultSucMsg();
            jSONObjectMakeDefaultSucMsg.put("hasPermission", zHasPermission ? 1 : 0);
            return jSONObjectMakeDefaultSucMsg;
        } catch (JSONException e) {
            e.printStackTrace();
            return makeInvalidArgsMsg();
        }
    }

    private JSONObject closeAndJump(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("urlScheme");
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(strOptString) && ve.d(strOptString)) {
            ve.s(this.mCordovaInterface.getActivity(), strOptString, false);
            this.mCordovaInterface.getActivity().finish();
        }
        return jSONObject2;
    }

    private void closeWindow() {
        try {
            this.mCordovaInterface.getActivity().finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JSONObject doTrace(JSONObject jSONObject) {
        JSONObject jSONObjectMakeDefaultSucMsg = makeDefaultSucMsg();
        try {
            String string = jSONObject.getString(b.k);
            String strOptString = jSONObject.optString("reportType");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ext");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            zn6.f(string, strOptString, jSONObjectOptJSONObject);
            return jSONObjectMakeDefaultSucMsg;
        } catch (JSONException e) {
            e.printStackTrace();
            return makeInvalidArgsMsg();
        }
    }

    private void enableAiMatch(final v93 v93Var) {
        int iB = yg4.b(AppContext.getContext().getTrayPreferences().b(k86.w(), 0), true, 33554432);
        HashMap map = new HashMap();
        map.put("privacyConfig", Integer.valueOf(iB));
        try {
            new eq3(new Response.Listener<JSONObject>() { // from class: org.apache.cordova.jssdk.general.UtilPlugin.1
                @Override // com.android.volley.Response.Listener
                public void onResponse(JSONObject jSONObject) {
                    iq5.j(false, new String[0]);
                    v93Var.a(UtilPlugin.this.makeDefaultSucMsg());
                }
            }, new Response.ErrorListener() { // from class: org.apache.cordova.jssdk.general.UtilPlugin.2
                @Override // com.android.volley.Response.ErrorListener
                public void onErrorResponse(VolleyError volleyError) {
                    v93Var.a(UtilPlugin.this.makeErrorArgsMsg());
                }
            }).n(map);
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private JSONObject getDhidConfig(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("key");
        if (TextUtils.isEmpty(strOptString)) {
            try {
                makeInvalidArgsMsg().put("msg", "please input key");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return makeInvalidArgsMsg();
        }
        JSONObject jSONObjectMakeDefaultSucMsg = makeDefaultSucMsg();
        JSONObject jSONObjectG = ts0.o().g();
        if (jSONObjectG == null) {
            return jSONObjectMakeDefaultSucMsg;
        }
        try {
            jSONObjectMakeDefaultSucMsg.put(strOptString, jSONObjectG.get(strOptString));
            return jSONObjectMakeDefaultSucMsg;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return jSONObjectMakeDefaultSucMsg;
        }
    }

    private JSONObject getDynamicConfig(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("key");
        if (TextUtils.isEmpty(strOptString)) {
            try {
                makeInvalidArgsMsg().put("msg", "please input key");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return makeInvalidArgsMsg();
        }
        JSONObject jSONObjectMakeDefaultSucMsg = makeDefaultSucMsg();
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(strOptString);
        if (dynamicConfig == null) {
            dynamicConfig = new DynamicItem();
        }
        try {
            jSONObjectMakeDefaultSucMsg.put(strOptString, new JSONObject(az2.c(dynamicConfig)));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObjectMakeDefaultSucMsg;
    }

    private JSONObject getNavigationBarHeight(Activity activity) {
        JSONObject jSONObjectMakeDefaultSucMsg = makeDefaultSucMsg();
        try {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            jSONObjectMakeDefaultSucMsg.put("navBarHeight", activity.getWindow().getDecorView().getHeight() - rect.bottom);
        } catch (Exception unused) {
        }
        LogUtil.d("", "SkuWebvalue startAiSkuWeb params " + jSONObjectMakeDefaultSucMsg);
        return jSONObjectMakeDefaultSucMsg;
    }

    private JSONObject getNetworkInfo() {
        int iG = hx3.g();
        JSONObject jSONObjectMakeDefaultSucMsg = makeDefaultSucMsg();
        try {
            jSONObjectMakeDefaultSucMsg.put("networkLevel", iG);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObjectMakeDefaultSucMsg;
    }

    private JSONObject getShuntTest(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("shuntKey");
            if (TextUtils.isEmpty(string)) {
                return makeInvalidArgsMsg();
            }
            JSONObject jSONObjectMakeDefaultSucMsg = makeDefaultSucMsg();
            jSONObjectMakeDefaultSucMsg.put("shuntValue", t66.h().e(string, "A"));
            return jSONObjectMakeDefaultSucMsg;
        } catch (JSONException e) {
            e.printStackTrace();
            return makeInvalidArgsMsg();
        }
    }

    private JSONObject getTaichi(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("taichiKey");
            if (TextUtils.isEmpty(string)) {
                return makeInvalidArgsMsg();
            }
            JSONObject jSONObjectMakeDefaultSucMsg = makeDefaultSucMsg();
            jSONObjectMakeDefaultSucMsg.put("taichiValue", jo6.c(string, "A"));
            return jSONObjectMakeDefaultSucMsg;
        } catch (JSONException e) {
            e.printStackTrace();
            return makeInvalidArgsMsg();
        }
    }

    private JSONObject isAppsInstalled(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("packages");
        JSONObject jSONObject2 = new JSONObject();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                String strOptString = jSONArrayOptJSONArray.optString(i);
                try {
                    jSONObject2.put(strOptString, k86.F(this.mCordovaInterface.getActivity(), strOptString));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONObject2;
    }

    private JSONObject markFeedSuccess(JSONObject jSONObject) {
        try {
            SquareFeed squareFeed = (SquareFeed) az2.a(jSONObject.optJSONObject(MediationConstant.RIT_TYPE_FEED).toString(), SquareFeed.class);
            SquareFeedEvent squareFeedEvent = new SquareFeedEvent();
            squareFeedEvent.eventType = 4;
            squareFeedEvent.feed = squareFeed;
            an1.c().l(squareFeedEvent);
            return makeDefaultSucMsg();
        } catch (Exception unused) {
            return makeInvalidArgsMsg();
        }
    }

    private JSONObject openAppSettings() {
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
            this.mCordovaInterface.getActivity().startActivity(intent);
            return makeDefaultSucMsg();
        } catch (Exception e) {
            e.printStackTrace();
            return makeErrorArgsMsg();
        }
    }

    private JSONObject openWindow(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("routeUrl");
        if (TextUtils.isEmpty(strOptString)) {
            return makeErrorArgsMsg();
        }
        ve.s(this.mCordovaInterface.getActivity(), strOptString, false);
        return makeDefaultSucMsg();
    }

    private void privilegeStatus(JSONObject jSONObject) {
        try {
            LogUtil.d("PeopleMatchPrivilegeManager", "privilegeStatus action params " + jSONObject);
            ds0.a().b(new cb3(jSONObject != null ? jSONObject.optString("from") : ""));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String saveBitmap(Bitmap bitmap) throws Throwable {
        FileOutputStream fileOutputStream;
        File file = new File(pu1.f, System.currentTimeMillis() + ".jpg");
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                    fileOutputStream.flush();
                    pu1.u(fileOutputStream);
                    bitmap.recycle();
                    return file.getAbsolutePath();
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    pu1.u(fileOutputStream);
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream2 = fileOutputStream;
                pu1.u(fileOutputStream2);
                if (bitmap != null) {
                    bitmap.recycle();
                }
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            pu1.u(fileOutputStream2);
            if (bitmap != null) {
            }
            throw th;
        }
    }

    private void saveUrlImage(String str, v93 v93Var) {
        this.mCallbackContext = v93Var;
        try {
            this.mImageUrl = str;
            if (this.mCordovaInterface.hasPermission(g.j)) {
                saveUrlImageImp(str, v93Var);
            } else {
                this.mCordovaInterface.requestPermission(this, 100, g.j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveUrlImageImp(String str, final v93 v93Var) {
        LogUtil.uploadInfoImmediate("H41", null, null, null);
        gr2.j().l(str, new jr2() { // from class: org.apache.cordova.jssdk.general.UtilPlugin.4
            @Override // defpackage.jr2
            public void onLoadingCancelled(String str2, View view) {
                v93Var.a(UtilPlugin.this.makeErrorArgsMsg());
                LogUtil.uploadInfoImmediate("H421", null, null, null);
            }

            @Override // defpackage.jr2
            public void onLoadingComplete(String str2, View view, Bitmap bitmap) throws Throwable {
                try {
                    String strSaveBitmap = UtilPlugin.saveBitmap(bitmap);
                    if (!TextUtils.isEmpty(strSaveBitmap)) {
                        LogUtil.uploadInfoImmediate("H42", null, null, null);
                        wm3.a(strSaveBitmap);
                        v93Var.a(UtilPlugin.this.makeDefaultSucMsg());
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                v93Var.a(UtilPlugin.this.makeErrorArgsMsg());
                LogUtil.uploadInfoImmediate("H421", null, null, null);
            }

            @Override // defpackage.jr2
            public void onLoadingFailed(String str2, View view, FailReason failReason) {
                v93Var.a(UtilPlugin.this.makeErrorArgsMsg());
                LogUtil.uploadInfoImmediate("H421", null, null, null);
            }

            @Override // defpackage.jr2
            public void onLoadingStarted(String str2, View view) {
            }
        });
    }

    private JSONObject sendMsg(JSONObject jSONObject) {
        final PopExt popExt = (PopExt) az2.a(jSONObject.toString(), PopExt.class);
        if (popExt != null) {
            final int iH = !TextUtils.isEmpty(popExt.domain) ? DomainHelper.h(popExt.domain, popExt.bizType) : 0;
            u93.e(new Runnable() { // from class: org.apache.cordova.jssdk.general.UtilPlugin.3
                @Override // java.lang.Runnable
                public void run() {
                    ve.x(PopContact.convert(popExt.contacts), iH, popExt.text);
                }
            });
        }
        return makeDefaultSucMsg();
    }

    private JSONObject showToast(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("content");
        int i = 0;
        int iOptInt = jSONObject.optInt("duration", 0);
        if (iOptInt >= 0) {
            i = 1;
            if (iOptInt <= 1) {
                i = iOptInt;
            }
        }
        sy5.f(this.mCordovaInterface.getActivity(), strOptString, i).g();
        return makeDefaultSucMsg();
    }

    private JSONObject updateChatBubble() {
        d20.m(true);
        return makeDefaultSucMsg();
    }

    @Override // defpackage.ib3
    public void exec(String str, JSONObject jSONObject, v93 v93Var) {
        try {
            if (Action.ACTION_SAVE_IMG.equals(str)) {
                saveUrlImage(jSONObject.getString("imgUrl"), v93Var);
            } else if (Action.ACTION_MARK_FEED_SUC.equals(str)) {
                v93Var.a(markFeedSuccess(jSONObject));
            } else if (Action.ACTION_UPDATE_CHAT_BUBBLE.equals(str)) {
                v93Var.a(updateChatBubble());
            } else if (Action.ACTION_SHOW_TOAST.equals(str)) {
                v93Var.a(showToast(jSONObject));
            } else if (Action.ACTION_CLOSE_WINDOW.equals(str)) {
                closeWindow();
            } else if (Action.ACTION_GET_CONFIG.equals(str)) {
                v93Var.a(getShuntTest(jSONObject));
            } else if (Action.ACTION_GET_TAICHI.equals(str)) {
                v93Var.a(getTaichi(jSONObject));
            } else if (Action.ACTION_PRIVILEGE_STATUS.equals(str)) {
                privilegeStatus(jSONObject);
            } else if (Action.ACTION_GET_NETWORK_INFO.equals(str)) {
                v93Var.a(getNetworkInfo());
            } else if ("trace".equals(str)) {
                v93Var.a(doTrace(jSONObject));
            } else if (Action.ACTION_OPEN_SETTING.equals(str)) {
                v93Var.a(openAppSettings());
            } else if (Action.ACTION_CHECK_PERMISSION.equals(str)) {
                v93Var.a(checkPermission(jSONObject));
            } else if (Action.ACTION_GET_DHID_CONFIG.equals(str)) {
                v93Var.a(getDhidConfig(jSONObject));
            } else if ("isAppInstalled".equals(str)) {
                v93Var.a(isAppsInstalled(jSONObject));
            } else if (Action.ACTION_GET_DYNAMIC_CONFIG.equals(str)) {
                v93Var.a(getDynamicConfig(jSONObject));
            } else if (Action.ACTION_CLOSECURRENTWINDOWANDJUMP.equals(str)) {
                v93Var.a(closeAndJump(jSONObject));
            } else if (Action.ACTION_OPENWINDOW.equals(str)) {
                v93Var.a(openWindow(jSONObject));
            } else if (Action.ACTION_SENDMSG.equals(str)) {
                v93Var.a(sendMsg(jSONObject));
            } else if (Action.ACTION_BACKLOGINPHONEPAGE.equals(str)) {
                v93Var.a(backLoginPhonePage());
            } else if (Action.ACTION_ENABLEAIMATCH.equals(str)) {
                enableAiMatch(v93Var);
            } else if (Action.ACTION_GETNAVIGATIONBARHEIGHT.equals(str)) {
                v93Var.a(getNavigationBarHeight(this.mCordovaInterface.getActivity()));
            }
        } catch (JSONException unused) {
            v93Var.a(makeInvalidArgsMsg());
        }
    }

    @Override // defpackage.ib3
    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) throws JSONException {
        if (i == 100) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                this.mCallbackContext.a(makePermissionDeniedArgsMsg());
            } else {
                saveUrlImageImp(this.mImageUrl, this.mCallbackContext);
            }
        }
    }
}
