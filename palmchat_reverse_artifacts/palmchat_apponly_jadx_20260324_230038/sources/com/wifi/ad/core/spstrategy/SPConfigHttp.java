package com.wifi.ad.core.spstrategy;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ss.android.download.api.constant.BaseConstants;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.NestSdkVersion;
import com.wifi.ad.core.monitor.IWkConfigCallBack;
import com.wifi.ad.core.monitor.WkAdConfigRequest;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import com.wifi.ad.core.spstrategy.WkSPResponse;
import com.wifi.ad.core.utils.WifiLog;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class SPConfigHttp {
    private static final int API_VERSION = 1001;
    private static String dpostUrl;
    private static HostnameVerifier mDefaultHostnameVerifier;
    private static SSLSocketFactory mDefaultSSLSocketFactory;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v8 */
    private static HttpURLConnection createConnection(String str, byte[] bArr, String str2) throws Throwable {
        ?? lxua;
        ?? r0 = 0;
         = 0;
        ?? r02 = 0;
        ?? r03 = 0;
        try {
            try {
                try {
                    URL url = new URL(str2);
                    String protocol = url.getProtocol();
                    if (protocol.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
                        str2 = (HttpURLConnection) url.openConnection();
                    } else if (protocol.equals(BaseConstants.SCHEME_HTTPS)) {
                        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                        try {
                            str2 = httpsURLConnection;
                            if (getDefaultHostnameVerifier() != null) {
                                str2 = httpsURLConnection;
                                if (getDefaultSSLSocketFactory() != null) {
                                    httpsURLConnection.setSSLSocketFactory(getDefaultSSLSocketFactory());
                                    httpsURLConnection.setHostnameVerifier(getDefaultHostnameVerifier());
                                    str2 = httpsURLConnection;
                                }
                            }
                        } catch (Exception unused) {
                            str2 = httpsURLConnection;
                        }
                    } else {
                        str2 = 0;
                    }
                    if (str2 != 0) {
                        try {
                            str2.setDoOutput(true);
                            str2.setDoInput(true);
                            str2.setUseCaches(false);
                            str2.setRequestMethod("POST");
                            str2.setConnectTimeout(6000);
                            str2.setReadTimeout(6000);
                            if (str != null) {
                                str2.setRequestProperty("X-WKSSP-PN", str);
                            }
                            str2.setRequestProperty("Charset", "UTF-8");
                            lxua = NestInfoTaker.INSTANCE.getLXUA();
                            WifiLog.d("SPConfigHttp createConnection User-Agent-ZX " + lxua);
                            if (!TextUtils.isEmpty(lxua)) {
                                str2.setRequestProperty("User-Agent-ZX", lxua);
                            }
                            str2.connect();
                        } catch (Exception unused2) {
                        }
                        try {
                            if (bArr != null) {
                                DataOutputStream dataOutputStream = new DataOutputStream(str2.getOutputStream());
                                dataOutputStream.write(bArr);
                                dataOutputStream.flush();
                                lxua = dataOutputStream;
                            } else {
                                DataOutputStream dataOutputStream2 = new DataOutputStream(str2.getOutputStream());
                                dataOutputStream2.writeBytes("");
                                dataOutputStream2.flush();
                                lxua = dataOutputStream2;
                            }
                            r02 = lxua;
                        } catch (Exception unused3) {
                            r03 = lxua;
                            if (r03 != 0) {
                                r03.close();
                                str2 = str2;
                            }
                            return str2;
                        } catch (Throwable th) {
                            r0 = lxua;
                            th = th;
                            if (r0 != 0) {
                                try {
                                    r0.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (Exception unused4) {
                str2 = 0;
            }
            if (r02 != 0) {
                r02.close();
                str2 = str2;
            }
            return str2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static byte[] createRequestByte(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        try {
            WkAdConfigRequest.SdkRequest.Builder builderNewBuilder = WkAdConfigRequest.SdkRequest.newBuilder();
            WkAdConfigRequest.SdkRequest.App.Builder builderNewBuilder2 = WkAdConfigRequest.SdkRequest.App.newBuilder();
            builderNewBuilder2.setPkgname(context.getPackageName());
            if (str4 == null) {
                str4 = "";
            }
            builderNewBuilder2.setAppid(str4);
            NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
            if (!TextUtils.isEmpty(nestInfoTaker.getChannel())) {
                builderNewBuilder2.setMarket(nestInfoTaker.getChannel());
            }
            if (!TextUtils.isEmpty(nestInfoTaker.getAppVer())) {
                builderNewBuilder2.setVersion(nestInfoTaker.getAppVer());
            }
            NestSdkVersion nestSdkVersion = NestSdkVersion.INSTANCE;
            if (!TextUtils.isEmpty(nestSdkVersion.getVersion(context))) {
                builderNewBuilder2.setSdkVer(nestSdkVersion.getVersion(context));
            }
            String appVerName = nestInfoTaker.getAppVerName();
            if (!TextUtils.isEmpty(appVerName)) {
                WifiLog.d("createRequestByte appVerName:" + appVerName + " scene " + i);
                builderNewBuilder2.setVersionName(appVerName);
            }
            String deviceId = nestInfoTaker.getDeviceId();
            if (!TextUtils.isEmpty(deviceId)) {
                WifiLog.d("createRequestByte deviceId:" + deviceId + " scene " + i);
                builderNewBuilder.setDeviceId(deviceId);
            }
            String uId = nestInfoTaker.getUId();
            if (!TextUtils.isEmpty(uId)) {
                WifiLog.d("createRequestByte uid:" + uId + " scene " + i);
                builderNewBuilder.setUid(uId);
            }
            if (str == null) {
                str = "";
            }
            if (str3 == null) {
                str3 = "";
            }
            if (TextUtils.isEmpty(str2)) {
                WifiLog.d("createRequestByte scene " + i + " TextUtils.isEmpty(taichis)");
                str2 = nestInfoTaker.getConfigTai();
                if (!TextUtils.isEmpty(str2)) {
                    WifiNestAd.INSTANCE.setAdConfigTais(str2);
                }
            }
            WifiLog.d("createRequestByte scene " + i + " taichis " + str2);
            if (str2 == null) {
                str2 = "";
            }
            if (str5 == null) {
                str5 = "";
            }
            builderNewBuilder.setAdUnitId(str5);
            builderNewBuilder.setScene(i);
            builderNewBuilder.setApp(builderNewBuilder2.build());
            builderNewBuilder.setRequestid(str);
            builderNewBuilder.setTaichi(str2);
            builderNewBuilder.setDid(str3);
            builderNewBuilder.setApiversion(1001);
            return builderNewBuilder.build().toByteArray();
        } catch (Exception e) {
            WifiLog.d("H5BannerAd createRequestByte pb e " + e.toString());
            return null;
        }
    }

    public static String doGet(String str) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("please ensure url is not equals  null ");
        }
        BufferedReader bufferedReader = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            int responseCode = httpURLConnection.getResponseCode();
            if (200 != responseCode) {
                Log.d("WkConfigHttp", "resultCode is not ok " + responseCode);
                return "";
            }
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            try {
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        break;
                    }
                    stringBuffer.append(line);
                }
                String string = stringBuffer.toString();
                try {
                    bufferedReader2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return string;
            } catch (Exception unused) {
                bufferedReader = bufferedReader2;
                if (bufferedReader == null) {
                    return "";
                }
                try {
                    bufferedReader.close();
                    return "";
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return "";
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static HostnameVerifier getDefaultHostnameVerifier() {
        if (mDefaultHostnameVerifier == null) {
            mDefaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
        }
        return mDefaultHostnameVerifier;
    }

    public static SSLSocketFactory getDefaultSSLSocketFactory() {
        if (mDefaultSSLSocketFactory == null) {
            mDefaultSSLSocketFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
        }
        return mDefaultSSLSocketFactory;
    }

    public static String getServerUrl() {
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        return Boolean.valueOf(wifiNestAd.isDebugUrl()).booleanValue() ? "https://short1.lx-qa.com/sdkconfig/adstrategy2" : wifiNestAd.getNewRequestUrl() ? "https://short.lianxinapp.com/sdkconfig/adstrategy2" : "https://di.wkangg.com/sdkconfig/adstrategy2";
    }

    public static void postResponseData(Context context, String str, int i, String str2, String str3, IWkConfigCallBack iWkConfigCallBack, String str4, String str5) throws Throwable {
        postServerUrl(createRequestByte(context, str, i, str2, str3, str4, str5), context, i, str4, iWkConfigCallBack);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void postServerUrl(byte[] bArr, Context context, int i, String str, IWkConfigCallBack iWkConfigCallBack) throws Throwable {
        HttpURLConnection httpURLConnection;
        WkSPResponse.Response from;
        HttpURLConnection httpURLConnectionCreateConnection;
        int responseCode;
        String str2;
        HttpURLConnection httpURLConnection2 = null;
        String str3 = null;
        try {
            if (dpostUrl == null) {
                dpostUrl = getServerUrl();
            }
            httpURLConnectionCreateConnection = createConnection(context.getPackageName(), bArr, dpostUrl);
        } catch (Exception e) {
            e = e;
            httpURLConnection = null;
        } catch (Throwable th) {
            th = th;
        }
        if (httpURLConnectionCreateConnection != null) {
            try {
                responseCode = httpURLConnectionCreateConnection.getResponseCode();
            } catch (Exception e2) {
                httpURLConnection = httpURLConnectionCreateConnection;
                e = e2;
                try {
                    e.printStackTrace();
                    String str4 = "Exception " + e.toString();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    from = null;
                    str3 = str4;
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                httpURLConnection2 = httpURLConnectionCreateConnection;
                th = th3;
                if (httpURLConnection2 != null) {
                }
                throw th;
            }
            if (200 == responseCode) {
                from = WkSPResponse.Response.parseFrom(httpURLConnectionCreateConnection.getInputStream());
                if (httpURLConnectionCreateConnection != null) {
                    httpURLConnectionCreateConnection.disconnect();
                }
                if (iWkConfigCallBack == null) {
                    if (str3 != null) {
                        iWkConfigCallBack.dataError(str3);
                        return;
                    }
                    if (from != null) {
                        iWkConfigCallBack.dataSuccess(from, i, str);
                        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
                        if (TextUtils.isEmpty(wifiNestAd.getAdConfigTais())) {
                            String configTai = NestInfoTaker.INSTANCE.getConfigTai();
                            if (TextUtils.isEmpty(configTai)) {
                                return;
                            }
                            wifiNestAd.setAdConfigTais(configTai);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            str2 = "resultCode is not ok " + responseCode;
        } else {
            str2 = "HttpURLConnection is return null ";
        }
        str3 = str2;
        from = null;
        if (httpURLConnectionCreateConnection != null) {
        }
        if (iWkConfigCallBack == null) {
        }
    }
}
