package org.apache.cordova.jssdk.general;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.gdt.action.ActionUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.route.share.ExternalShareActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.go2;
import defpackage.nl0;
import defpackage.rs3;
import defpackage.sw4;
import defpackage.v4;
import defpackage.v93;
import defpackage.yw4;
import defpackage.yy2;
import defpackage.zw4;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.cordova.FileSelectHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LocalApiPlugin extends SubPlugin {
    public static final String TAG = "LocalApiPlugin";

    private void requestLocalApi(JSONObject jSONObject, final v93 v93Var) {
        final String strOptString = jSONObject.optString("url");
        final int iOptInt = jSONObject.optInt(ActionUtils.METHOD, 0);
        final JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("body");
        final boolean zOptBoolean = jSONObject.optBoolean("encrypt", true);
        final boolean zOptBoolean2 = jSONObject.optBoolean("formData", false);
        zw4.e(new go2<LXBaseNetBean>() { // from class: org.apache.cordova.jssdk.general.LocalApiPlugin.6
            @Override // defpackage.ho2
            public sw4 getRequestArgs() {
                sw4 sw4VarC = sw4.c(iOptInt, nl0.b + strOptString, jSONObjectOptJSONObject);
                sw4VarC.h = zOptBoolean;
                sw4VarC.i = zOptBoolean2;
                return sw4VarC;
            }

            /* JADX WARN: Removed duplicated region for block: B:21:0x0040  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
            @Override // defpackage.io2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onResult(boolean z, LXBaseNetBean lXBaseNetBean, Exception exc) {
                JSONObject jSONObject2;
                int i;
                JSONObject jSONObjectMakeDefaultSucMsg = LocalApiPlugin.this.makeDefaultSucMsg();
                if (z && lXBaseNetBean != null) {
                    jSONObject2 = lXBaseNetBean.originData;
                } else if (exc != null) {
                    HashMap map = new HashMap();
                    String string = "";
                    if (exc instanceof VolleyError) {
                        VolleyError volleyError = (VolleyError) exc;
                        NetworkResponse networkResponse = volleyError.networkResponse;
                        if (networkResponse != null) {
                            i = networkResponse.statusCode;
                            try {
                                string = new String(networkResponse.data);
                            } catch (Exception unused) {
                            }
                        } else if (volleyError instanceof NetworkError) {
                            i = -1009;
                            string = "似乎已断开与互联网的连接。";
                        } else if (volleyError instanceof TimeoutError) {
                            i = -1001;
                            string = "请求超时。";
                        }
                        if (i == 0) {
                        }
                        if (TextUtils.isEmpty(string)) {
                        }
                        map.put("resultCode", Integer.valueOf(i));
                        map.put(MediationConstant.KEY_ERROR_MSG, string);
                        jSONObject2 = new JSONObject(map);
                    } else {
                        i = 0;
                        if (i == 0) {
                            i = -123456;
                        }
                        if (TextUtils.isEmpty(string)) {
                            string = exc.toString();
                        }
                        map.put("resultCode", Integer.valueOf(i));
                        map.put(MediationConstant.KEY_ERROR_MSG, string);
                        jSONObject2 = new JSONObject(map);
                    }
                } else {
                    jSONObject2 = null;
                }
                try {
                    jSONObjectMakeDefaultSucMsg.put("data", jSONObject2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                LogUtil.i(LocalApiPlugin.TAG, "onResult=" + jSONObjectMakeDefaultSucMsg);
                v93Var.a(jSONObjectMakeDefaultSucMsg);
            }
        });
    }

    private void uploadFileOnFileSelected(JSONObject jSONObject, final v93 v93Var) {
        LogUtil.i(TAG, "uploadFileOnFileSelected start" + jSONObject);
        String strOptString = jSONObject.optString("url");
        String strOptString2 = jSONObject.optString("filePartName", "file");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("body");
        Uri[] currentFilePath = FileSelectHelper.getCurrentFilePath();
        String path = null;
        if (currentFilePath != null && currentFilePath.length > 0) {
            LogUtil.i(TAG, "uri=" + currentFilePath[0].toString());
            try {
                File fileI1 = ExternalShareActivity.I1(currentFilePath[0]);
                if (fileI1 != null) {
                    path = fileI1.getPath();
                    LogUtil.i(TAG, "currentFilePath=" + path);
                }
            } catch (Exception e) {
                LogUtil.i(TAG, "uri=" + currentFilePath[0].toString(), e);
            }
        }
        LogUtil.i(TAG, "uploadFileOnFileSelected currentFilePath = " + path);
        if (path == null) {
            v93Var.a(makeErrorArgsMsg());
            return;
        }
        HashMap map = new HashMap();
        try {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObjectOptJSONObject.getString(next));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
        rs3 rs3Var = new rs3(nl0.b + strOptString, new Response.ErrorListener() { // from class: org.apache.cordova.jssdk.general.LocalApiPlugin.4
            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                LogUtil.i(LocalApiPlugin.TAG, "uploadFileOnFileSelected error = " + volleyError);
                v93Var.a(LocalApiPlugin.this.makeErrorArgsMsg());
            }
        }, new Response.Listener<String>() { // from class: org.apache.cordova.jssdk.general.LocalApiPlugin.5
            @Override // com.android.volley.Response.Listener
            public void onResponse(String str) {
                LogUtil.i(LocalApiPlugin.TAG, "uploadFileOnFileSelected onResponse = " + str);
                JSONObject jSONObjectMakeDefaultSucMsg = LocalApiPlugin.this.makeDefaultSucMsg();
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    if (jSONObject2.optInt("resultCode", -1) == 0) {
                        jSONObjectMakeDefaultSucMsg.put("data", jSONObject2);
                        v93Var.a(jSONObjectMakeDefaultSucMsg);
                        return;
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                v93Var.a(LocalApiPlugin.this.makeErrorArgsMsg());
            }
        }, new File(path), strOptString2, map);
        rs3Var.setRetryPolicy(new DefaultRetryPolicy(30000, 0, 1.0f));
        normalRequestQueue.add(rs3Var);
    }

    @Override // defpackage.ib3
    public void exec(String str, JSONObject jSONObject, final v93 v93Var) {
        Log.i(TAG, str + "-" + jSONObject);
        if (str.equals(Action.ACTION_LOCAL_API)) {
            zw4.f(jSONObject.optString("url"), jSONObject.optInt(ActionUtils.METHOD), jSONObject.optJSONObject("params"), new yw4() { // from class: org.apache.cordova.jssdk.general.LocalApiPlugin.1
                /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
                @Override // defpackage.yw4
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onFail(Exception exc) {
                    int i;
                    Log.i(LocalApiPlugin.TAG, exc.toString());
                    JSONObject jSONObjectMakeErrorArgsMsg = LocalApiPlugin.this.makeErrorArgsMsg();
                    HashMap map = new HashMap();
                    Log.i(LocalApiPlugin.TAG, exc.toString());
                    String string = "";
                    if (exc instanceof VolleyError) {
                        VolleyError volleyError = (VolleyError) exc;
                        NetworkResponse networkResponse = volleyError.networkResponse;
                        if (networkResponse != null) {
                            i = networkResponse.statusCode;
                            try {
                                string = new String(networkResponse.data);
                            } catch (Exception unused) {
                            }
                        } else if (volleyError instanceof NetworkError) {
                            i = -1009;
                            string = "似乎已断开与互联网的连接。";
                        } else if (volleyError instanceof TimeoutError) {
                            i = -1001;
                            string = "请求超时。";
                        }
                    } else {
                        i = 0;
                    }
                    if (i == 0) {
                        i = -123456;
                    }
                    if (TextUtils.isEmpty(string)) {
                        string = exc.toString();
                    }
                    map.put("resultCode", Integer.valueOf(i));
                    map.put(MediationConstant.KEY_ERROR_MSG, string);
                    try {
                        jSONObjectMakeErrorArgsMsg.put("response", new JSONObject(map));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    v93Var.a(jSONObjectMakeErrorArgsMsg);
                }

                @Override // defpackage.yw4
                public void onSuccess(JSONObject jSONObject2, yy2 yy2Var) {
                    Log.i(LocalApiPlugin.TAG, jSONObject2.toString());
                    JSONObject jSONObjectMakeDefaultSucMsg = LocalApiPlugin.this.makeDefaultSucMsg();
                    try {
                        jSONObjectMakeDefaultSucMsg.put("response", jSONObject2);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    v93Var.a(jSONObjectMakeDefaultSucMsg);
                }
            });
            return;
        }
        if (str.equals(Action.ACTION_LOCAL_API_LXSERVER)) {
            String str2 = nl0.b + jSONObject.optString("url");
            int iOptInt = jSONObject.optInt(ActionUtils.METHOD);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            zw4.f(str2, iOptInt, jSONObjectOptJSONObject, new yw4() { // from class: org.apache.cordova.jssdk.general.LocalApiPlugin.2
                /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
                @Override // defpackage.yw4
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onFail(Exception exc) {
                    int i;
                    Log.i(LocalApiPlugin.TAG, exc.toString());
                    JSONObject jSONObjectMakeErrorArgsMsg = LocalApiPlugin.this.makeErrorArgsMsg();
                    HashMap map = new HashMap();
                    Log.i(LocalApiPlugin.TAG, exc.toString());
                    String string = "";
                    if (exc instanceof VolleyError) {
                        VolleyError volleyError = (VolleyError) exc;
                        NetworkResponse networkResponse = volleyError.networkResponse;
                        if (networkResponse != null) {
                            i = networkResponse.statusCode;
                            try {
                                string = new String(networkResponse.data);
                            } catch (Exception unused) {
                            }
                        } else if (volleyError instanceof NetworkError) {
                            i = -1009;
                            string = "似乎已断开与互联网的连接。";
                        } else if (volleyError instanceof TimeoutError) {
                            i = -1001;
                            string = "请求超时。";
                        }
                    } else {
                        i = 0;
                    }
                    if (i == 0) {
                        i = -123456;
                    }
                    if (TextUtils.isEmpty(string)) {
                        string = exc.toString();
                    }
                    map.put("resultCode", Integer.valueOf(i));
                    map.put(MediationConstant.KEY_ERROR_MSG, string);
                    try {
                        jSONObjectMakeErrorArgsMsg.put("response", new JSONObject(map));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    v93Var.a(jSONObjectMakeErrorArgsMsg);
                }

                @Override // defpackage.yw4
                public void onSuccess(JSONObject jSONObject2, yy2 yy2Var) {
                    Log.i(LocalApiPlugin.TAG, jSONObject2.toString());
                    JSONObject jSONObjectMakeDefaultSucMsg = LocalApiPlugin.this.makeDefaultSucMsg();
                    try {
                        jSONObjectMakeDefaultSucMsg.put("response", jSONObject2);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    v93Var.a(jSONObjectMakeDefaultSucMsg);
                }
            });
            return;
        }
        if (str.equals(Action.ACTION_LOCAL_API_BEFORE_LOGIN)) {
            zw4.h(nl0.b + jSONObject.optString("url"), v4.e(AppContext.getContext()), v4.c(AppContext.getContext()), jSONObject.optInt(ActionUtils.METHOD), jSONObject.optJSONObject("params"), new yw4() { // from class: org.apache.cordova.jssdk.general.LocalApiPlugin.3
                @Override // defpackage.yw4
                public void onFail(Exception exc) {
                    Log.i(LocalApiPlugin.TAG, exc.toString());
                    JSONObject jSONObjectMakeErrorArgsMsg = LocalApiPlugin.this.makeErrorArgsMsg();
                    try {
                        jSONObjectMakeErrorArgsMsg.put("response", exc);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    v93Var.a(jSONObjectMakeErrorArgsMsg);
                }

                @Override // defpackage.yw4
                public void onSuccess(JSONObject jSONObject2, yy2 yy2Var) {
                    Log.i(LocalApiPlugin.TAG, jSONObject2.toString());
                    JSONObject jSONObjectMakeDefaultSucMsg = LocalApiPlugin.this.makeDefaultSucMsg();
                    try {
                        jSONObjectMakeDefaultSucMsg.put("response", jSONObject2);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    v93Var.a(jSONObjectMakeDefaultSucMsg);
                }
            });
            return;
        }
        if (Action.ACTION_REQUESTLOCALAPIWITHLXSERVERNEW.equals(str)) {
            requestLocalApi(jSONObject, v93Var);
        } else if (Action.UPLOADFILEONFILESELECTED.equals(str)) {
            uploadFileOnFileSelected(jSONObject, v93Var);
        }
    }
}
