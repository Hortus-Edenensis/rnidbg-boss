package com.wifi.ad.core.monitor;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ss.android.download.api.constant.BaseConstants;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.NestSdkVersion;
import com.wifi.ad.core.constants.WifiNestConst;
import com.wifi.ad.core.monitor.WkAdConfigRequest;
import com.wifi.ad.core.monitor.WkAdConfigResponse;
import com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigManager;
import com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigRequest;
import com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class WkConfigHttp {
    private static final int API_VERSION = 1001;
    private static String dpostUrl;
    private static String dpostWhiteUrl;
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
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v8 */
    private static HttpURLConnection createConnection(String str, byte[] bArr, String str2) throws Throwable {
        Object obj;
        ?? r0 = 0;
        r0 = 0;
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
                            obj = "Charset";
                            str2.setRequestProperty("Charset", "UTF-8");
                            str2.connect();
                        } catch (Exception unused2) {
                        }
                        try {
                            if (bArr != null) {
                                DataOutputStream dataOutputStream = new DataOutputStream(str2.getOutputStream());
                                dataOutputStream.write(bArr);
                                dataOutputStream.flush();
                                obj = dataOutputStream;
                            } else {
                                DataOutputStream dataOutputStream2 = new DataOutputStream(str2.getOutputStream());
                                dataOutputStream2.writeBytes("");
                                dataOutputStream2.flush();
                                obj = dataOutputStream2;
                            }
                            r02 = obj;
                        } catch (Exception unused3) {
                            r0 = obj;
                            if (r0 != 0) {
                                r0.close();
                                str2 = str2;
                            }
                            return str2;
                        } catch (Throwable th) {
                            r03 = obj;
                            th = th;
                            if (r03 != 0) {
                                try {
                                    r03.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception unused4) {
                str2 = 0;
            }
            if (r02 != 0) {
                r02.close();
                str2 = str2;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return str2;
    }

    private static byte[] createRequestByte(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        try {
            WkAdConfigRequest.SdkRequest.Builder builderNewBuilder = WkAdConfigRequest.SdkRequest.newBuilder();
            WkAdConfigRequest.SdkRequest.App.Builder builderNewBuilder2 = WkAdConfigRequest.SdkRequest.App.newBuilder();
            builderNewBuilder2.setPkgname(context.getPackageName());
            if (str5 == null) {
                str5 = "";
            }
            builderNewBuilder2.setAppid(str5);
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
            if (str == null) {
                str = "";
            }
            if (str3 == null) {
                str3 = "";
            }
            builderNewBuilder.setScene(i);
            builderNewBuilder.setApp(builderNewBuilder2.build());
            builderNewBuilder.setRequestid(str);
            builderNewBuilder.setTaichi(str2);
            builderNewBuilder.setDid(str3);
            builderNewBuilder.setApiversion(1001);
            builderNewBuilder.setRegtime(str4);
            WkAdConfigRequest.SdkRequest sdkRequestBuild = builderNewBuilder.build();
            try {
                sdkRequestBuild.toString();
            } catch (Exception unused) {
            }
            return sdkRequestBuild.toByteArray();
        } catch (Exception unused2) {
            return null;
        }
    }

    private static byte[] createWhiteRequestByte(Context context, String str, int i, String str2, String str3, String str4) {
        try {
            WkWhiteAdConfigRequest.SdkWhiteRequest.Builder builderNewBuilder = WkWhiteAdConfigRequest.SdkWhiteRequest.newBuilder();
            WkWhiteAdConfigRequest.SdkWhiteRequest.App.Builder builderNewBuilder2 = WkWhiteAdConfigRequest.SdkWhiteRequest.App.newBuilder();
            builderNewBuilder2.setPkgname(context.getPackageName());
            NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
            if (!TextUtils.isEmpty(nestInfoTaker.getChannel())) {
                builderNewBuilder2.setMarket(nestInfoTaker.getChannel());
            }
            if (!TextUtils.isEmpty(nestInfoTaker.getAppVer())) {
                builderNewBuilder2.setVersion(nestInfoTaker.getAppVer());
            }
            if (str == null) {
                str = "";
            }
            if (str3 == null) {
                str3 = "";
            }
            builderNewBuilder.setApp(builderNewBuilder2.build());
            builderNewBuilder.setRequestid(str);
            builderNewBuilder.setTaichi(str2);
            builderNewBuilder.setDid(str3);
            builderNewBuilder.setScene(i);
            builderNewBuilder.setVersion(str4);
            builderNewBuilder.setApiversion(1001);
            WkWhiteAdConfigRequest.SdkWhiteRequest sdkWhiteRequestBuild = builderNewBuilder.build();
            try {
                sdkWhiteRequestBuild.toString();
            } catch (Exception unused) {
            }
            return sdkWhiteRequestBuild.toByteArray();
        } catch (Exception unused2) {
            return null;
        }
    }

    public static String doGet(String str) {
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
        return Boolean.valueOf(wifiNestAd.isDebugUrl()).booleanValue() ? "https://t1.lianxinapp.com/sdkconfig/blockinfo" : wifiNestAd.getNewRequestUrl() ? "https://short.lianxinapp.com/sdkconfig/blockinfo" : "https://di.wkangg.com/sdkconfig/blockinfo";
    }

    public static String getWhiteServerUrl() {
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        return Boolean.valueOf(wifiNestAd.isDebugUrl()).booleanValue() ? "https://t1.lianxinapp.com/sdkconfig/whitelist" : wifiNestAd.getNewRequestUrl() ? "https://short.lianxinapp.com/sdkconfig/whitelist" : "https://di.wkangg.com/sdkconfig/whitelist";
    }

    public static void postResponseData(Context context, String str, int i, String str2, String str3, IWkConfigCallBack iWkConfigCallBack, String str4, String str5) {
        byte[] bArrCreateRequestByte = createRequestByte(context, str, i, str2, str3, str4, str5);
        if (dpostUrl == null) {
            dpostUrl = getServerUrl();
        }
        postServerUrl(dpostUrl, bArrCreateRequestByte, i, str5, context, iWkConfigCallBack);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [com.wifi.ad.core.monitor.whitelist.WkWhiteAdConfigResponse$SdkWhiteResponse] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void postServerUrl(String str, byte[] bArr, int i, String str2, Context context, IWkConfigCallBack iWkConfigCallBack) throws Throwable {
        HttpURLConnection httpURLConnectionCreateConnection;
        ?? from;
        WkAdConfigResponse.SdkResponse from2;
        int responseCode;
        String str3;
        ?? r1 = 0;
        str = null;
        str = null;
        String str4 = null;
        try {
            try {
                httpURLConnectionCreateConnection = createConnection(context.getPackageName(), bArr, str);
            } catch (Throwable th) {
                th = th;
                r1 = str;
                if (r1 != 0) {
                    r1.disconnect();
                }
                throw th;
            }
        } catch (Exception e) {
            e = e;
            httpURLConnectionCreateConnection = null;
        } catch (Throwable th2) {
            th = th2;
            if (r1 != 0) {
            }
            throw th;
        }
        if (httpURLConnectionCreateConnection != null) {
            try {
                responseCode = httpURLConnectionCreateConnection.getResponseCode();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                String str5 = "Exception " + e.toString();
                if (httpURLConnectionCreateConnection != null) {
                    httpURLConnectionCreateConnection.disconnect();
                }
                from = 0;
                str4 = str5;
                from2 = null;
            }
            if (200 == responseCode) {
                InputStream inputStream = httpURLConnectionCreateConnection.getInputStream();
                if (iWkConfigCallBack instanceof WkAdConfigManager) {
                    from2 = WkAdConfigResponse.SdkResponse.parseFrom(inputStream);
                    from = 0;
                } else {
                    if (iWkConfigCallBack instanceof WkWhiteAdConfigManager) {
                        try {
                            from = WkWhiteAdConfigResponse.SdkWhiteResponse.parseFrom(inputStream);
                            from2 = null;
                        } catch (IOException e3) {
                            String str6 = "Exception " + e3.toString();
                            e3.printStackTrace();
                            WifiNestAd.reporter.onEvent(WifiNestConst.EventKey.NEST_SDK_AD_PARSE_WHITELIST_FAIL, new EventParams.Builder().build(), new HashMap());
                            from2 = null;
                            str4 = str6;
                            from = from2;
                        }
                    } else {
                        from2 = null;
                    }
                    from = from2;
                }
                if (httpURLConnectionCreateConnection != null) {
                    httpURLConnectionCreateConnection.disconnect();
                }
                if (iWkConfigCallBack == null) {
                    if (str4 != null) {
                        iWkConfigCallBack.dataError(str4);
                        return;
                    } else {
                        postSuccessListener(i, str2, iWkConfigCallBack, from2, from);
                        return;
                    }
                }
                return;
            }
            str3 = "resultCode is not ok " + responseCode;
        } else {
            str3 = "HttpURLConnection is return null ";
        }
        from = 0;
        str4 = str3;
        from2 = null;
        if (httpURLConnectionCreateConnection != null) {
        }
        if (iWkConfigCallBack == null) {
        }
    }

    private static void postSuccessListener(int i, String str, IWkConfigCallBack iWkConfigCallBack, WkAdConfigResponse.SdkResponse sdkResponse, WkWhiteAdConfigResponse.SdkWhiteResponse sdkWhiteResponse) {
        if (iWkConfigCallBack instanceof WkAdConfigManager) {
            if (sdkResponse != null) {
                iWkConfigCallBack.dataSuccess(sdkResponse, i, str);
            }
        } else {
            if (!(iWkConfigCallBack instanceof WkWhiteAdConfigManager) || sdkWhiteResponse == null) {
                return;
            }
            iWkConfigCallBack.dataSuccess(sdkWhiteResponse, i, str);
        }
    }

    public static void postWhiteResponseData(Context context, String str, int i, String str2, String str3, IWkConfigCallBack iWkConfigCallBack, String str4) {
        byte[] bArrCreateWhiteRequestByte = createWhiteRequestByte(context, str, i, str2, str3, str4);
        if (dpostWhiteUrl == null) {
            dpostWhiteUrl = getWhiteServerUrl();
        }
        postServerUrl(dpostWhiteUrl, bArrCreateWhiteRequestByte, i, null, context, iWkConfigCallBack);
    }
}
