package com.baidu.platform.comapi.pano;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.ss.android.download.api.constant.BaseConstants;
import com.wifi.ad.core.config.DeviceInfoUtil;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    AsyncHttpClient f4221a = new AsyncHttpClient();

    /* JADX INFO: renamed from: com.baidu.platform.comapi.pano.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0107a extends HttpClient.ProtoResultCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f4222a;

        public C0107a(b bVar) {
            this.f4222a = bVar;
        }

        @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
        public void onFailed(HttpClient.HttpStateError httpStateError) {
            this.f4222a.a(httpStateError);
        }

        @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
        public void onSuccess(String str) {
            this.f4222a.a(a.this.a(str));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b<T> {
        void a(HttpClient.HttpStateError httpStateError);

        void a(T t);
    }

    public void a(String str, b<com.baidu.platform.comapi.pano.b> bVar) {
        Uri.Builder builder = new Uri.Builder();
        if (HttpClient.isHttpsEnable) {
            builder.scheme(BaseConstants.SCHEME_HTTPS);
        } else {
            builder.scheme(HttpHost.DEFAULT_SCHEME_NAME);
        }
        builder.encodedAuthority("api.map.baidu.com");
        builder.path("/sdkproxy/lbs_androidsdk/pano/v1/");
        a(builder, "qt", "poi");
        a(builder, DeviceInfoUtil.UID_TAG, str);
        a(builder, "action", "0");
        String authToken = HttpClient.getAuthToken();
        if (authToken == null) {
            bVar.a(new com.baidu.platform.comapi.pano.b(PanoStateError.PANO_NO_TOKEN));
            return;
        }
        a(builder, "token", authToken);
        this.f4221a.get(a(builder), new C0107a(bVar));
    }

    private void a(Uri.Builder builder, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    private String a(Uri.Builder builder) {
        Uri.Builder builderBuildUpon = Uri.parse(builder.build().toString() + HttpClient.getPhoneInfo()).buildUpon();
        builderBuildUpon.appendQueryParameter("sign", AppMD5.getSignMD5String(builderBuildUpon.build().getEncodedQuery()));
        return builderBuildUpon.build().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.platform.comapi.pano.b a(String str) {
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("result");
                if (jSONObjectOptJSONObject == null) {
                    return new com.baidu.platform.comapi.pano.b(PanoStateError.PANO_NOT_FOUND);
                }
                if (jSONObjectOptJSONObject.optInt("error") == 0) {
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("content");
                    if (jSONArrayOptJSONArray == null) {
                        return new com.baidu.platform.comapi.pano.b(PanoStateError.PANO_NOT_FOUND);
                    }
                    com.baidu.platform.comapi.pano.b bVar = null;
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i).optJSONObject("poiinfo");
                        if (jSONObjectOptJSONObject2 != null) {
                            bVar = new com.baidu.platform.comapi.pano.b(PanoStateError.PANO_NO_ERROR);
                            bVar.a(jSONObjectOptJSONObject2.optString("PID"));
                            bVar.a(jSONObjectOptJSONObject2.optInt("hasstreet"));
                        }
                    }
                    return bVar;
                }
                return new com.baidu.platform.comapi.pano.b(PanoStateError.PANO_UID_ERROR);
            } catch (JSONException e) {
                e.printStackTrace();
                return new com.baidu.platform.comapi.pano.b(PanoStateError.PANO_NOT_FOUND);
            }
        }
        return new com.baidu.platform.comapi.pano.b(PanoStateError.PANO_NOT_FOUND);
    }
}
