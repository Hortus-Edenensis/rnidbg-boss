package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.idc.DomainException;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bw;
import java.util.Map;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class l<R extends f, T extends BaseResultData> extends a<R> {
    public static String HTTP_CODE_ERROR_MSG = "网络错误";
    private static final String TAG = "Networking";

    @Nullable
    private g<R, T> mListener = null;
    private final com.kwad.sdk.core.network.b.b mMonitorRecorder = com.kwad.sdk.core.network.b.c.JO();

    private void checkAndSetHasData(BaseResultData baseResultData) {
        if (baseResultData.hasData()) {
            this.mMonitorRecorder.dQ(1);
        }
    }

    private void checkIpDirect(c cVar) {
        com.kwad.sdk.service.a.f fVar;
        if (cVar == null || cVar.Jr() || (fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) == null || !ao.isNetworkConnected(fVar.getContext())) {
            return;
        }
        com.kwad.sdk.ip.direct.a.Oy();
    }

    private String getHostTypeByUrl(@NonNull String str) {
        return str.contains("/rest/zt/emoticon/package/list") ? "zt" : "api";
    }

    private void notifyOnErrorListener(@NonNull R r, c cVar, String str) {
        String url = r.getUrl();
        DomainException domainException = new DomainException(cVar.aIU, cVar.aIV);
        com.kwad.sdk.core.network.idc.a.Jz().a(url, getHostTypeByUrl(url), domainException);
        notifyOnErrorListener(r, cVar.code, str);
    }

    private void notifyOnStartRequest(@NonNull R r) {
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onStartRequest(r);
    }

    private void notifyOnSuccess(@NonNull R r, T t) {
        if (com.kwad.sdk.core.network.idc.a.Jz().JB()) {
            String hostTypeByUrl = getHostTypeByUrl(r.getUrl());
            if ("api".equals(hostTypeByUrl)) {
                com.kwad.sdk.core.network.idc.a.Jz().ep(hostTypeByUrl);
            }
        }
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onSuccess(r, t);
        this.mMonitorRecorder.JN();
    }

    private void onRequest(@NonNull g<R, T> gVar) {
        this.mMonitorRecorder.JH();
        this.mListener = gVar;
    }

    private void parseCommonData(String str, String str2) {
        try {
            q.Jv().V(str, new JSONObject(str2).optString("requestSessionData"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void reportSdkCaughtException(Throwable th) {
        if (enableCrashReport()) {
            ServiceProvider.reportSdkCaughtException(th);
        } else {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    private void setMonitorRequestId(@NonNull f fVar) {
        Map<String, String> header = fVar.getHeader();
        if (header != null) {
            String str = header.get(d.TRACK_ID_KEY);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mMonitorRecorder.ez(str);
        }
    }

    @Override // com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
        this.mListener = null;
    }

    public boolean enableCrashReport() {
        return true;
    }

    public boolean enableMonitorReport() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.a
    @WorkerThread
    public void fetchImpl() {
        R rCreateRequest;
        Throwable th;
        c cVarDoPost = null;
        try {
            this.mMonitorRecorder.JL();
            rCreateRequest = createRequest();
            try {
                notifyOnStartRequest(rCreateRequest);
                this.mMonitorRecorder.ev(rCreateRequest.getUrl()).ew(rCreateRequest.getUrl());
                setMonitorRequestId(rCreateRequest);
                if (ao.isNetworkConnected(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())) {
                    try {
                        String url = rCreateRequest.getUrl();
                        AdHttpProxy adHttpProxyCm = com.kwad.sdk.g.Cm();
                        if (adHttpProxyCm instanceof com.kwad.sdk.core.network.c.b) {
                            this.mMonitorRecorder.ey("ok_http").JK();
                        } else {
                            this.mMonitorRecorder.ey(HttpHost.DEFAULT_SCHEME_NAME).JK();
                        }
                        cVarDoPost = isPostByJson() ? adHttpProxyCm.doPost(url, rCreateRequest.getHeader(), rCreateRequest.getBody()) : adHttpProxyCm.doPost(url, rCreateRequest.getHeader(), rCreateRequest.getBodyMap());
                        com.kwad.sdk.core.d.c.i(TAG, "url: " + url + ", response: " + cVarDoPost);
                    } catch (Exception e) {
                        notifyOnErrorListener(rCreateRequest, e.aJh.errorCode, bw.r(e));
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                        this.mMonitorRecorder.ex("requestError:" + e.getMessage());
                    }
                    this.mMonitorRecorder.JI().JJ().dS(com.kwad.sdk.ip.direct.a.getType());
                    try {
                        onResponse(rCreateRequest, cVarDoPost);
                    } catch (Exception e2) {
                        notifyOnErrorListener(rCreateRequest, e.aJh.errorCode, bw.r(e2));
                        this.mMonitorRecorder.ex("onResponseError:" + e2.getMessage());
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e2);
                    }
                } else {
                    e eVar = e.aJa;
                    notifyOnErrorListener(rCreateRequest, eVar.errorCode, eVar.msg);
                    this.mMonitorRecorder.dP(e.aJa.errorCode).ex(e.aJa.msg);
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    try {
                        this.mMonitorRecorder.ex("requestError:" + th.getMessage());
                    } catch (Exception unused) {
                    }
                    notifyOnErrorListener(rCreateRequest, e.aJh.errorCode, bw.r(th));
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                    try {
                        if (enableMonitorReport()) {
                            this.mMonitorRecorder.report();
                        }
                    } catch (Exception unused2) {
                    }
                } finally {
                    try {
                        if (enableMonitorReport()) {
                            this.mMonitorRecorder.report();
                        }
                    } catch (Exception unused3) {
                    }
                }
            }
        } catch (Throwable th3) {
            rCreateRequest = null;
            th = th3;
        }
    }

    public boolean isPostByJson() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.a
    public void onResponse(R r, c cVar) {
        if (cVar == null) {
            e eVar = e.aJa;
            notifyOnErrorListener(r, eVar.errorCode, eVar.msg);
            this.mMonitorRecorder.ex("responseBase is null");
            com.kwad.sdk.core.d.c.e(TAG, "request responseBase is null");
            return;
        }
        this.mMonitorRecorder.dP(cVar.code);
        checkIpDirect(cVar);
        if (TextUtils.isEmpty(cVar.aIW) || !cVar.Jr()) {
            notifyOnErrorListener(r, cVar, HTTP_CODE_ERROR_MSG);
            this.mMonitorRecorder.ex("httpCodeError:" + cVar.code + ":" + cVar.aIW);
            StringBuilder sb = new StringBuilder("request responseBase httpCodeError:");
            sb.append(cVar.code);
            com.kwad.sdk.core.d.c.w(TAG, sb.toString());
            return;
        }
        try {
            parseCommonData(r.getUrl(), cVar.aIW);
            BaseResultData data = parseData(cVar.aIW);
            afterParseData(data);
            if (cVar.aIW != null) {
                this.mMonitorRecorder.az(r7.length()).JM().dR(data.result);
            }
            if (!data.isResultOk()) {
                this.mMonitorRecorder.ex("serverCodeError:" + data.result + ":" + data.errorMsg);
                if (data.notifyFailOnResultError()) {
                    notifyOnErrorListener(r, data.result, data.errorMsg);
                    return;
                }
            }
            if (data.isDataEmpty()) {
                notifyOnErrorListener(r, e.aJc.errorCode, !TextUtils.isEmpty(data.testErrorMsg) ? data.testErrorMsg : e.aJc.msg);
            } else {
                checkAndSetHasData(data);
                notifyOnSuccess(r, data);
            }
        } catch (Exception e) {
            e eVar2 = e.aJb;
            notifyOnErrorListener(r, eVar2.errorCode, eVar2.msg);
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            this.mMonitorRecorder.ex("parseDataError:" + e.getMessage());
        }
    }

    @NonNull
    public abstract T parseData(String str);

    public void request(@NonNull g<R, T> gVar) {
        try {
            onRequest(gVar);
            fetch();
        } catch (Throwable th) {
            notifyOnErrorListener((f) null, e.aJh.errorCode, bw.r(th));
            reportSdkCaughtException(th);
        }
    }

    private void notifyOnErrorListener(@NonNull R r, int i, String str) {
        try {
            h.Js().b(r, i);
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onError(r, i, str);
        this.mMonitorRecorder.JN();
    }

    public void afterParseData(T t) {
    }
}
