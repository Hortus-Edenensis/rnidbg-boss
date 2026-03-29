package com.wifi.adsdk.http;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.wifi.adsdk.LxAdManager;
import com.wifi.adsdk.entity.LxAdEventParams;
import com.wifi.adsdk.listener.LxAdListener;
import com.wifi.adsdk.params.LxAdReqParams;
import com.wifi.adsdk.utils.AesEcbUtils;
import com.wifi.adsdk.utils.LxAdConst;
import com.wifi.adsdk.utils.LxAdLog;
import com.wifi.adsdk.utils.LxAdUtil;
import com.wifi.adsdk.utils.OkHttpUtils;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DefaultHttpManager extends AbstractHttp {
    private final InnerHandler innerHandler = new InnerHandler(Looper.getMainLooper());

    /* JADX INFO: compiled from: SearchBox */
    public static class InnerHandler extends Handler {
        public InnerHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    public DefaultHttpManager() {
        Log.d("", "LxAd DefaultHttpManager init");
    }

    private Request buildRequest(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appId", LxAdManager.getAdManager().getConfig().getAppId());
            jSONObject.put("token", LxAdManager.getAdManager().getConfig().getToken());
            jSONObject.put("data", str);
            return new Request.Builder().url(getUrl()).post(RequestBody.create(MediaType.parse("application/json"), jSONObject.toString())).addHeader("Content-type", "application/json").build();
        } catch (Exception unused) {
            return null;
        }
    }

    private String getUrl() {
        return LxAdManager.getAdManager().getConfig().getDebugUrl() ? LxAdUtil.URL_TEST : LxAdUtil.URL_RELEASE;
    }

    @Override // com.wifi.adsdk.http.AbstractHttp
    public void onPost(final LxAdReqParams lxAdReqParams, String str, Context context, final LxAdListener lxAdListener) {
        LxAdLog.d("LxAd DefaultHttpManager post start4444 ");
        Request requestBuildRequest = buildRequest(str);
        if (lxAdListener != null) {
            lxAdListener.onPrepare(lxAdReqParams);
        }
        OkHttpClient okHttpClient = OkHttpUtils.getInstance().getOkHttpClient();
        LxAdManager.getAdManager().getConfig().getReporter().onEvent(LxAdConst.EventKey.LXSDK_AD_REQ, LxAdEventParams.toJson(LxAdEventParams.createEventParams(lxAdReqParams, 0, 0, "", 0, "", "", "")));
        okHttpClient.newCall(requestBuildRequest).enqueue(new Callback() { // from class: com.wifi.adsdk.http.DefaultHttpManager.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, final IOException iOException) {
                LxAdLog.d("LxAd DefaultHttpManager OkHttpUtils onFailure e " + iOException.toString());
                LxAdManager.getAdManager().getConfig().getReporter().onEvent(LxAdConst.EventKey.LXSDK_AD_REQ_FAIL, LxAdEventParams.toJson(LxAdEventParams.createEventParams(lxAdReqParams, 0, 0, "", -1003, iOException.toString(), "", "")));
                DefaultHttpManager.this.innerHandler.post(new Runnable() { // from class: com.wifi.adsdk.http.DefaultHttpManager.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LxAdListener lxAdListener2 = lxAdListener;
                        if (lxAdListener2 != null) {
                            lxAdListener2.onFailed(-1, iOException.toString(), lxAdReqParams);
                        }
                    }
                });
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, final Response response) throws IOException {
                final String strString = response.body().string();
                LxAdLog.d("LxAd DefaultHttpManager OkHttpUtils onResponse result " + strString);
                DefaultHttpManager.this.innerHandler.post(new Runnable() { // from class: com.wifi.adsdk.http.DefaultHttpManager.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (lxAdListener == null || strString == null) {
                            return;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(strString);
                            int iOptInt = jSONObject.optInt("resultCode");
                            String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
                            if (iOptInt == 0) {
                                String strOptString2 = jSONObject.optString("data");
                                if (TextUtils.isEmpty(strOptString2)) {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    lxAdListener.onFailed(-2, "response dataObject null error", lxAdReqParams);
                                } else {
                                    String strDecrypt = AesEcbUtils.decrypt(strOptString2);
                                    LxAdLog.d("LxAd DefaultHttpManager OkHttpUtils onResponse aes end " + strDecrypt);
                                    if (TextUtils.isEmpty(strDecrypt)) {
                                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                        lxAdListener.onFailed(-4, "response dataObject aes error", lxAdReqParams);
                                    } else {
                                        lxAdListener.onSuccess(strDecrypt, response.code(), lxAdReqParams);
                                    }
                                }
                            } else {
                                AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                                lxAdListener.onFailed(iOptInt, strOptString, lxAdReqParams);
                            }
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        });
    }
}
