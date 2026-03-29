package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.inner.data.JsbCallBackData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.i;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ah implements ae {
    private static final byte[] B = new byte[0];
    private static WeakReference<Activity> C = null;
    private static final String Z = "JsbBaseCommand";
    protected String Code;
    protected String I;
    protected String V;

    public ah() {
    }

    public ah(String str) {
        this.Code = str;
    }

    public Integer B(String str) {
        try {
            int iOptInt = new JSONObject(str).optInt(com.huawei.openalliance.ad.constant.az.at, -111111);
            if (iOptInt != -111111) {
                return Integer.valueOf(iOptInt);
            }
            return null;
        } catch (Throwable unused) {
            fh.Code(Z, "getDownloadSource error");
            return null;
        }
    }

    public MaterialClickInfo C(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Integer numValueOf = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.be.al, -111111));
            Integer numValueOf2 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.be.am, -111111));
            String strOptString = jSONObject.optString(com.huawei.openalliance.ad.constant.be.an, "");
            Float fCode = com.huawei.openalliance.ad.utils.bc.Code(jSONObject.optString(com.huawei.openalliance.ad.constant.be.ar, "-111111"), Float.valueOf(-111111.0f));
            Integer numValueOf3 = Integer.valueOf(jSONObject.optInt("upX", -111111));
            Integer numValueOf4 = Integer.valueOf(jSONObject.optInt("upY", -111111));
            Integer numValueOf5 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.be.ao, -111111));
            Long lValueOf = Long.valueOf(jSONObject.optLong(com.huawei.openalliance.ad.constant.be.aR));
            Long lValueOf2 = Long.valueOf(jSONObject.optLong(com.huawei.openalliance.ad.constant.be.aS));
            String strOptString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.be.aT, "");
            if (numValueOf.intValue() == -111111) {
                numValueOf = null;
            }
            if (numValueOf2.intValue() == -111111) {
                numValueOf2 = null;
            }
            if (!com.huawei.openalliance.ad.utils.bc.L(strOptString)) {
                strOptString = null;
            }
            if (fCode.floatValue() == -111111.0f) {
                fCode = null;
            }
            if (numValueOf3.intValue() == -111111) {
                numValueOf3 = null;
            }
            if (numValueOf4.intValue() == -111111) {
                numValueOf4 = null;
            }
            if (numValueOf5.intValue() == -111111) {
                numValueOf5 = null;
            }
            if (lValueOf.longValue() == 0) {
                lValueOf = null;
            }
            if (lValueOf2.longValue() == 0) {
                lValueOf2 = null;
            }
            if (com.huawei.openalliance.ad.utils.bc.Code(strOptString2)) {
                strOptString2 = null;
            }
            return new MaterialClickInfo.a().Code(numValueOf).V(numValueOf2).V(strOptString).I(numValueOf5).Code(fCode).Z(numValueOf3).B(numValueOf4).V(lValueOf).Code(lValueOf2).Z(strOptString2).Code(jSONObject.optString(com.huawei.openalliance.ad.constant.az.aW)).Code();
        } catch (Throwable unused) {
            fh.Code(Z, "getClickInfo error");
            return null;
        }
    }

    @Override // com.huawei.hms.ads.ae
    public Context Code(Context context) {
        synchronized (B) {
            WeakReference<Activity> weakReference = C;
            if (weakReference == null || weakReference.get() == null) {
                return context;
            }
            return C.get();
        }
    }

    public boolean F(String str) {
        return !com.huawei.openalliance.ad.utils.bc.Code(str) && com.huawei.openalliance.ad.utils.bc.Code(str.trim(), -111111) >= 10000301;
    }

    public boolean S(String str) {
        try {
            if (!com.huawei.openalliance.ad.utils.bc.Code(str)) {
                if (Integer.parseInt(str.trim()) >= 10000300) {
                    return true;
                }
            }
        } catch (Throwable th) {
            fh.Z("H5Ad", "isSupportImpCtrl() exception: %s", th.getClass().getSimpleName());
        }
        return false;
    }

    public void V(RemoteCallResultCallback<String> remoteCallResultCallback, boolean z) {
        Code(remoteCallResultCallback, this.Code, 1000, com.igexin.push.core.b.B, z);
    }

    @Override // com.huawei.hms.ads.ae
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        fh.I(Z, "async execute is not implemented!");
        throw new IllegalStateException("async execute is not implemented!");
    }

    @Override // com.huawei.hms.ads.ae
    public i.a Code() {
        return i.a.IO;
    }

    @Override // com.huawei.hms.ads.ae
    public void V(String str) {
        this.I = str;
    }

    @Override // com.huawei.hms.ads.ae
    public Object Code(Context context, String str) {
        fh.I(Z, "direct call is not implemented!");
        throw new IllegalStateException("direct call is not implemented!");
    }

    @Override // com.huawei.hms.ads.ae
    public void Code(Activity activity) {
        synchronized (B) {
            WeakReference<Activity> weakReference = C;
            if (weakReference == null || weakReference.get() == null) {
                C = new WeakReference<>(activity);
            }
        }
    }

    public void Code(Context context, String str, ad adVar) {
        Code(context, str, false, adVar);
    }

    public void Code(Context context, final String str, boolean z, final ad adVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            jSONObject.put("content_id", jSONObject2.optString("contentId"));
            fh.V(Z, "queryAdContentData, uniqueId: %s", jSONObject2.optString("adId"));
            jSONObject.put("unique_id", jSONObject2.optString("adId"));
            jSONObject.put(com.huawei.openalliance.ad.constant.az.I, z);
            jSONObject.put(com.huawei.openalliance.ad.constant.az.Z, this.V);
            if (!TextUtils.isEmpty(jSONObject2.optString("apiVer"))) {
                jSONObject.put("apiVer", jSONObject2.optString("apiVer"));
            }
            if (!TextUtils.isEmpty(jSONObject2.optString("templateId"))) {
                jSONObject.put("templateId", jSONObject2.optString("templateId"));
            }
            if (!TextUtils.isEmpty(jSONObject2.optString("slotid"))) {
                jSONObject.put("slotid", jSONObject2.optString("slotid"));
            }
            com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.s.s, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.ah.1
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str2, CallResult<String> callResult) {
                    if (callResult.getCode() != 200) {
                        fh.I(ah.Z, "request ad content, retCode: %s", Integer.valueOf(callResult.getCode()));
                        adVar.Code(null);
                        return;
                    }
                    AdContentData adContentData = (AdContentData) com.huawei.openalliance.ad.utils.ad.V(callResult.getData(), AdContentData.class, new Class[0]);
                    ah.this.Code(adContentData, str);
                    if (adContentData == null) {
                        fh.I(ah.Z, "request ad content is null");
                    }
                    adVar.Code(adContentData);
                }
            }, String.class);
        } catch (Throwable unused) {
            fh.I(Z, "request ad content error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(AdContentData adContentData, String str) {
        if (adContentData != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String strOptString = TextUtils.isEmpty(jSONObject.optString(com.huawei.openalliance.ad.constant.az.C)) ? "" : jSONObject.optString(com.huawei.openalliance.ad.constant.az.C);
                if (!TextUtils.isEmpty(strOptString)) {
                    adContentData.I(strOptString);
                }
                if (!TextUtils.isEmpty(jSONObject.optString("requestId"))) {
                    adContentData.D(jSONObject.optString("requestId"));
                }
                String strOptString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.az.u);
                String strOptString3 = jSONObject.optString("userId");
                fh.V(Z, "updateContentFormJs, uniqueId: %s", jSONObject.optString("adId"));
                String strOptString4 = jSONObject.optString("adId");
                if (!TextUtils.isEmpty(strOptString2)) {
                    adContentData.q(strOptString2);
                }
                if (!TextUtils.isEmpty(strOptString3)) {
                    adContentData.r(strOptString3);
                }
                if (!TextUtils.isEmpty(strOptString4)) {
                    adContentData.S(strOptString4);
                }
                Long lValueOf = Long.valueOf(jSONObject.optLong(com.huawei.openalliance.ad.constant.az.aX));
                if (lValueOf.longValue() == 0) {
                    lValueOf = Long.valueOf(com.huawei.openalliance.ad.utils.bc.Code(strOptString, 0L));
                }
                if (lValueOf.longValue() != 0) {
                    adContentData.Z(lValueOf.longValue());
                }
            } catch (Throwable unused) {
                fh.I(Z, "update content failed");
            }
        }
    }

    public static void Code(RemoteCallResultCallback<String> remoteCallResultCallback, String str, int i, JsbCallBackData jsbCallBackData) {
        if (remoteCallResultCallback != null) {
            CallResult<String> callResult = new CallResult<>();
            callResult.setCode(i);
            try {
                callResult.setData(com.huawei.openalliance.ad.utils.ad.V(jsbCallBackData));
            } catch (Throwable th) {
                fh.I(Z, "onCallResult " + th.getClass().getSimpleName());
            }
            remoteCallResultCallback.onRemoteCallResult(str, callResult);
        }
    }

    public static <T> void Code(RemoteCallResultCallback<String> remoteCallResultCallback, String str, int i, T t, boolean z) {
        Code(remoteCallResultCallback, str, i, new JsbCallBackData(t, z, null));
    }

    public void Code(RemoteCallResultCallback<String> remoteCallResultCallback, boolean z) {
        Code(remoteCallResultCallback, this.Code, 1011, "", z);
    }

    @Override // com.huawei.hms.ads.ae
    public void Code(String str) {
        this.V = str;
    }

    public boolean Code(AdContentData adContentData) {
        return adContentData != null && adContentData.aw() && jg.Z(adContentData.v());
    }
}
