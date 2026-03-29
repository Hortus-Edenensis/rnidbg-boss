package com.huawei.openalliance.ad.msgnotify;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.constant.be;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.ipc.g;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.z;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b {
    private static final String Code = "MessageNotifyManager";

    private static Object Code() {
        try {
            return au.Code(null, Class.forName("com.huawei.openalliance.ad.ppskit.msgnotify.PersistentMessageCenter"), "getInstance", null, null);
        } catch (Throwable unused) {
            fh.V(Code, "get inner msg notify");
            return a.Code();
        }
    }

    private static void I(Context context, String str) {
        fh.V(Code, "unregisterAllNotify via aidl");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(be.v, str);
            jSONObject.putOpt(be.x, x.aP);
            g.V(context).Code(s.g, jSONObject.toString(), null, null);
        } catch (JSONException e) {
            fh.I(Code, "unregisterAllNotify " + e.getClass().getSimpleName());
        }
    }

    public static void V(Context context, String str) {
        fh.V(Code, "unregisterAllNotify via hard link");
        Object objCode = Code();
        if (objCode != null) {
            if (objCode instanceof a) {
                ((a) objCode).Code(str);
            } else {
                au.Code(objCode, objCode.getClass(), "unregisterAll", new Class[]{String.class, String.class}, new Object[]{context.getPackageName(), str});
            }
        }
    }

    public static void Code(Context context, String str) {
        I(context, str);
        if (z.B(context)) {
            return;
        }
        V(context, str);
    }

    private static void I(Context context, String str, final NotifyCallback notifyCallback) {
        fh.V(Code, "registerNotifyViaAidl");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(be.v, str);
            jSONObject.putOpt(be.x, x.aO);
            g.V(context).Code(s.g, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.msgnotify.b.1
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str2, CallResult<String> callResult) {
                    Intent intentCode;
                    if (notifyCallback == null || callResult == null || callResult.getCode() != 200 || (intentCode = c.Code(callResult.getData())) == null) {
                        return;
                    }
                    SafeIntent safeIntent = new SafeIntent(intentCode);
                    String stringExtra = safeIntent.getStringExtra(be.v);
                    fh.V(b.Code, "receive msg: " + stringExtra);
                    notifyCallback.onMessageNotify(stringExtra, safeIntent);
                }
            }, String.class);
        } catch (JSONException e) {
            fh.Code(5, Code, "registerNotify ", e);
        }
    }

    public static void V(Context context, String str, NotifyCallback notifyCallback) {
        if (context == null || TextUtils.isEmpty(str) || notifyCallback == null) {
            fh.V(Code, "registerNotifyViaHardLink some param is empty");
            return;
        }
        fh.V(Code, "registerNotifyViaHardLink");
        Object objCode = Code();
        if (objCode != null) {
            if (objCode instanceof a) {
                ((a) objCode).Code(str, notifyCallback);
            } else {
                au.Code(objCode, objCode.getClass(), "registerNotifyCallbackFromSdk", new Class[]{String.class, String.class, Object.class}, new Object[]{context.getPackageName(), str, notifyCallback});
            }
        }
    }

    public static void Code(Context context, String str, Intent intent) {
        fh.V(Code, "notifyMessage via hard link");
        Object objCode = Code();
        if (objCode != null) {
            if (objCode instanceof a) {
                ((a) objCode).Code(str, intent);
            } else {
                au.Code(objCode, objCode.getClass(), "notifyMessage", new Class[]{String.class, String.class, Intent.class}, new Object[]{context.getPackageName(), str, intent});
            }
        }
    }

    public static void Code(Context context, String str, NotifyCallback notifyCallback) {
        I(context, str, notifyCallback);
    }

    public static void Code(Context context, String str, String str2, Intent intent) {
        if (!z.B(context)) {
            Code(context, str2, intent);
            return;
        }
        fh.V(Code, "notifyMessage via aidl");
        String strCode = c.Code(str, str2, intent);
        if (TextUtils.isEmpty(strCode)) {
            return;
        }
        g.V(context).Code(s.h, strCode, null, null);
    }
}
