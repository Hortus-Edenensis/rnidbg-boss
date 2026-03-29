package com.huawei.openalliance.ad.inter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.ads.cj;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.uiengine.IGlobalUtil;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.constant.ce;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.be;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.z;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class e extends IGlobalUtil.b {
    private static final String D = "GlobalUtil";
    private static final byte[] L = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6945a = "onActivityStartFinish";
    private static e b;
    private List<IPPSUiEngineCallback> c = new ArrayList();
    private Context d;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements RemoteCallResultCallback<String> {
        private Context Code;
        private String I;
        private final IPPSUiEngineCallback V;

        public a(Context context, IPPSUiEngineCallback iPPSUiEngineCallback, String str) {
            this.Code = context;
            this.V = iPPSUiEngineCallback;
            this.I = str;
        }

        private String Code() {
            if (!com.huawei.openalliance.ad.utils.h.Code(com.huawei.openalliance.ad.ipc.g.V(this.Code).Z())) {
                try {
                    if (TextUtils.isEmpty(this.I)) {
                        return null;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("url", this.I);
                        CallResult callResultCode = com.huawei.openalliance.ad.ipc.b.Code(this.Code).Code(s.z, jSONObject.toString(), String.class, true);
                        if (callResultCode != null && 200 == callResultCode.getCode()) {
                            fh.V(e.D, "getFilePathFromKit success");
                            String strOptString = new JSONObject((String) callResultCode.getData()).optString("filePath");
                            fh.V(e.D, "filepath from kit : %s", strOptString);
                            return strOptString;
                        }
                    } catch (Throwable th) {
                        fh.I(e.D, "getFilePathFromKit err: %s", th.getClass().getSimpleName());
                    }
                } catch (Throwable th2) {
                    fh.V(e.D, "get path err: %s", th2.getClass().getSimpleName());
                }
            }
            return null;
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            try {
                if (!bc.Code(callResult.getData()) && callResult.getData().startsWith(ce.CONTENT.toString())) {
                    Code(callResult.getData());
                    return;
                }
                String strCode = Code();
                if (TextUtils.isEmpty(strCode)) {
                    this.V.onCallResult(bq.d.V, null);
                } else {
                    Code(strCode);
                }
            } catch (Throwable th) {
                fh.V(e.D, "getFilePath err: %s", th.getClass().getSimpleName());
            }
        }

        private void Code(String str) {
            Bundle bundle = new Bundle();
            bundle.putString("filePath", str);
            this.V.onCallResult(bq.d.V, bundle);
        }
    }

    private e(Context context) {
        this.d = context;
    }

    private static e V(Context context) {
        e eVar;
        synchronized (L) {
            if (b == null) {
                b = new e(context);
            }
            eVar = b;
        }
        return eVar;
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public Bundle callMethod(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
        return null;
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public void getFilePath(String str, IPPSUiEngineCallback iPPSUiEngineCallback) {
        com.huawei.openalliance.ad.ipc.g.V(this.d).Code(s.x, str, new a(this.d, iPPSUiEngineCallback, str), String.class);
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public String getFilePathDirect(final String str) {
        String str2;
        try {
            str2 = (String) be.Code(new Callable<String>() { // from class: com.huawei.openalliance.ad.inter.e.1
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
                public String call() {
                    return (String) com.huawei.openalliance.ad.ipc.b.Code(e.this.d).Code(s.x, str, String.class).getData();
                }
            }, null);
            fh.Code(D, "filePath = %s", str2);
        } catch (Throwable th) {
            fh.V(D, "getFilePath err: %s", th.getClass().getSimpleName());
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2;
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public String getFilePathDirectByCacheType(final String str, final int i) {
        String str2;
        try {
            str2 = (String) be.Code(new Callable<String>() { // from class: com.huawei.openalliance.ad.inter.e.2
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
                public String call() {
                    CallResult callResultCode;
                    if (z.L(e.this.d)) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("url", str);
                            jSONObject.put("apiVer", i);
                        } catch (Throwable th) {
                            fh.V(e.D, "make param err: %s", th.getClass().getSimpleName());
                        }
                        callResultCode = com.huawei.openalliance.ad.ipc.b.Code(e.this.d).Code(s.x, jSONObject.toString(), String.class);
                    } else {
                        callResultCode = com.huawei.openalliance.ad.ipc.b.Code(e.this.d).Code(s.x, str, String.class);
                    }
                    return (String) callResultCode.getData();
                }
            }, null);
            fh.Code(D, "filePath = %s", str2);
        } catch (Throwable th) {
            fh.V(D, "getFilePath err: %s", th.getClass().getSimpleName());
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2;
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public com.huawei.hms.ads.uiengine.b getMultiMediaPlayingManager() {
        cj.Code(this.d).Code(HiAd.Code(this.d).I());
        return cj.Code(this.d);
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public boolean isFreedomWindowMode(IObjectWrapper iObjectWrapper) {
        try {
            View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
            if (view == null) {
                fh.I(D, "remote view is null.");
                return false;
            }
            Activity activityG = bg.g(view.getContext());
            if (activityG != null) {
                return bg.Code(activityG);
            }
            fh.I(D, "activity is null.");
            return false;
        } catch (Throwable th) {
            fh.I(D, "is freedom window ex: %s", th.getClass().getSimpleName());
            return false;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public void registerActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
        fh.V(D, "registerActivityStartCallBack");
        if (iPPSUiEngineCallback != null) {
            this.c.add(iPPSUiEngineCallback);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public void unregisterActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
        fh.V(D, "unregisterActivityStartCallBack");
        if (iPPSUiEngineCallback != null) {
            this.c.remove(iPPSUiEngineCallback);
        }
    }

    public static e Code(Context context) {
        return V(context);
    }

    public void V() {
        for (IPPSUiEngineCallback iPPSUiEngineCallback : this.c) {
            if (iPPSUiEngineCallback != null) {
                try {
                    iPPSUiEngineCallback.onCallResult(f6945a, null);
                } catch (Throwable th) {
                    fh.V(D, "onCallResult err: %s", th.getClass().getSimpleName());
                }
            }
        }
    }
}
