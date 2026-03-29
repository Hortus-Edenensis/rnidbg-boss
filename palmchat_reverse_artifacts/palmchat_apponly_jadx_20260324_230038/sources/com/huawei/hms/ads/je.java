package com.huawei.hms.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.metadata.Location;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.beans.server.AppConfigRsp;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.d;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class je {
    public static int Code = 0;
    private static final String V = "AdRequester";

    /* JADX INFO: compiled from: SearchBox */
    public static class a<T> implements RemoteCallResultCallback<T> {
        private RemoteCallResultCallback<T> Code;
        private Context V;

        public a(Context context, RemoteCallResultCallback<T> remoteCallResultCallback) {
            this.Code = remoteCallResultCallback;
            this.V = context.getApplicationContext();
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<T> callResult) {
            if (callResult.getCode() == 201) {
                try {
                    eh.Code(this.V).I(new JSONObject(callResult.getMsg()).optInt(com.huawei.openalliance.ad.constant.be.c, 0));
                    return;
                } catch (JSONException unused) {
                    fh.I(je.V, "parse ad config JSONException");
                    return;
                }
            }
            RemoteCallResultCallback<T> remoteCallResultCallback = this.Code;
            if (remoteCallResultCallback != null) {
                remoteCallResultCallback.onRemoteCallResult(str, callResult);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<String> I() {
        try {
            if (h.V() != null) {
                return h.V().Code((Bundle) null);
            }
        } catch (Throwable th) {
            fh.V(V, "get blackTptIdList err: %s", th.getClass().getSimpleName());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long V(Context context) {
        int i;
        eh ehVarCode = eh.Code(context);
        if (Z(context) && (i = Code) <= 10) {
            Code = i + 1;
            return 0L;
        }
        long jK = ehVarCode.k();
        if (I(context)) {
            jK = ehVarCode.x();
        }
        return jK * 60000;
    }

    private static boolean Z(Context context) {
        return HiAd.Code(context).B();
    }

    private static Boolean Code(Boolean bool, Context context) {
        boolean z = com.huawei.openalliance.ad.utils.f.Code(context) && cn.Code(context).B();
        if (bool != null) {
            return Boolean.valueOf(bool.booleanValue() && z);
        }
        return Boolean.valueOf(z);
    }

    private static boolean I(Context context) {
        return !TextUtils.isEmpty(eh.Code(context).w());
    }

    public static void Code() {
        Code = 0;
    }

    private static void Code(final Context context, final AdSlotParam adSlotParam) {
        com.huawei.openalliance.ad.utils.i.Code(new Runnable() { // from class: com.huawei.hms.ads.je.1
            @Override // java.lang.Runnable
            public void run() {
                List<String> listCode;
                String string;
                AdSlotParam adSlotParam2 = adSlotParam;
                if (adSlotParam2 == null || (listCode = adSlotParam2.Code()) == null || listCode.size() <= 0) {
                    return;
                }
                if (System.currentTimeMillis() - eh.Code(context).l() > je.V(context)) {
                    try {
                        if (com.huawei.openalliance.ad.utils.z.I() || com.huawei.openalliance.ad.utils.z.D(context)) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("slotid", listCode.get(0));
                            jSONObject.put("sdk_type", d.d(context));
                            jSONObject.put(com.huawei.openalliance.ad.constant.be.Code, h.Code());
                            jSONObject.put("sha256", eh.Code(context).an());
                            jSONObject.put(com.huawei.openalliance.ad.constant.be.V, com.huawei.openalliance.ad.utils.ad.V(je.I()));
                            string = jSONObject.toString();
                        } else {
                            string = listCode.get(0);
                        }
                        com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.s.Code, string, new RemoteCallResultCallback<AppConfigRsp>() { // from class: com.huawei.hms.ads.je.1.1
                            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                            public void onRemoteCallResult(String str, CallResult<AppConfigRsp> callResult) {
                                if (callResult.getData() != null) {
                                    AppConfigRsp data = callResult.getData();
                                    if (data.Code() == 206) {
                                        eh.Code(context).Code(System.currentTimeMillis());
                                    } else {
                                        eh.Code(context).Code(data);
                                    }
                                }
                            }
                        }, AppConfigRsp.class);
                    } catch (Throwable th) {
                        fh.I(je.V, "requestConfig err: %s", th.getClass().getSimpleName());
                    }
                }
            }
        });
    }

    public static <T> void Code(Context context, String str, AdSlotParam adSlotParam, String str2, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        Context applicationContext = context.getApplicationContext();
        JSONObject jSONObject = new JSONObject();
        a aVar = new a(applicationContext, remoteCallResultCallback);
        try {
            adSlotParam.Code(eh.Code(applicationContext).t());
            adSlotParam.V(eh.Code(applicationContext).i());
            adSlotParam.D(HiAd.Code(context).Z());
            adSlotParam.a(d.d(context));
            adSlotParam.Z(h.Code());
            RequestOptions requestOptionsB = adSlotParam.B();
            if (requestOptionsB == null) {
                requestOptionsB = new RequestOptions();
                adSlotParam.Code(requestOptionsB);
            }
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
            if (TextUtils.isEmpty(requestOptionsB.getConsent())) {
                requestOptionsB.V(defaultSharedPreferences.getString(com.huawei.openalliance.ad.constant.x.co, ""));
            }
            requestOptionsB.I(defaultSharedPreferences.getString(com.huawei.openalliance.ad.constant.x.cp, ""));
            requestOptionsB.Z(defaultSharedPreferences.getString(com.huawei.openalliance.ad.constant.x.cq, ""));
            Location locationCode = com.huawei.openalliance.ad.utils.ai.Code(applicationContext, requestOptionsB, adSlotParam.Z() != null ? adSlotParam.Z().Code() : null);
            adSlotParam.Code(locationCode);
            com.huawei.openalliance.ad.beans.inner.b bVarS = locationCode.S();
            adSlotParam.C(Integer.valueOf(bVarS.Code()));
            adSlotParam.S(Integer.valueOf(bVarS.V()));
            adSlotParam.F(Integer.valueOf(bVarS.I()));
            fh.Code(V, "request location is %s", Boolean.valueOf(requestOptionsB.isRequestLocation()));
            if (!Code(applicationContext, applicationContext.getPackageName())) {
                adSlotParam.Code((App) null);
            }
            if (cn.Code(context).V()) {
                adSlotParam.I(com.huawei.openalliance.ad.utils.a.Code(context));
            }
            if (eh.Code(context).ag() && !TextUtils.equals(str, com.huawei.openalliance.ad.constant.x.cr)) {
                adSlotParam.B(jf.Code(context).Code());
            }
            requestOptionsB.Code(Code(requestOptionsB.a(), context));
            jSONObject.put(com.huawei.openalliance.ad.constant.be.I, com.huawei.openalliance.ad.utils.ad.V(adSlotParam));
            jSONObject.put("content", str2);
            jSONObject.put(com.huawei.openalliance.ad.constant.be.N, System.currentTimeMillis());
            com.huawei.openalliance.ad.ipc.g.V(applicationContext).Code(str, jSONObject.toString(), aVar, cls);
        } catch (JSONException unused) {
            fh.I(V, "requestAd JSONException");
            CallResult<T> callResult = new CallResult<>();
            callResult.setCode(-1);
            callResult.setMsg("requestAd JSONException");
            aVar.onRemoteCallResult(str, callResult);
        }
        Code(applicationContext, adSlotParam);
    }

    private static boolean Code(Context context, String str) {
        return com.huawei.openalliance.ad.constant.dg.Code(str, com.huawei.openalliance.ad.utils.h.Z(context, str));
    }
}
