package com.baidu.lbsapi.auth;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f3374a;
    private String e;
    private String g;
    private String h;
    private String b = null;
    private HashMap c = null;
    private String d = null;
    private int f = -1;

    public i(Context context) {
        this.f3374a = context;
    }

    private String a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if (networkCapabilities != null) {
                    return networkCapabilities.hasTransport(1) ? "WIFI" : networkCapabilities.hasTransport(0) ? "CELLULAR" : networkCapabilities.hasTransport(3) ? "ETHERNET" : networkCapabilities.hasTransport(6) ? "LoWPAN" : networkCapabilities.hasTransport(4) ? "VPN" : networkCapabilities.hasTransport(5) ? "WifiAware" : "wifi";
                }
                return "wifi";
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                String extraInfo = activeNetworkInfo.getExtraInfo();
                return (extraInfo == null || !(extraInfo.trim().toLowerCase().equals("cmwap") || extraInfo.trim().toLowerCase().equals("uniwap") || extraInfo.trim().toLowerCase().equals("3gwap") || extraInfo.trim().toLowerCase().equals("ctwap"))) ? "wifi" : extraInfo.trim().toLowerCase().equals("ctwap") ? "ctwap" : "cmwap";
            }
            return null;
        } catch (Exception e) {
            if (b.f3368a) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private HashMap b(HashMap map) {
        HashMap map2 = new HashMap();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            String string = ((String) it.next()).toString();
            map2.put(string, map.get(string));
        }
        return map2;
    }

    private static String a(HashMap map) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry entry : map.entrySet()) {
            if (z) {
                z = false;
            } else {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.append(URLEncoder.encode((String) entry.getKey(), "UTF-8"));
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(URLEncoder.encode((String) entry.getValue(), "UTF-8"));
        }
        return sb.toString();
    }

    private HttpsURLConnection b() {
        String str;
        URLConnection uRLConnectionOpenConnection;
        try {
            URL url = new URL(this.b);
            b.a("https URL: " + this.b);
            String strA = a(this.f3374a);
            if (strA != null && !strA.equals("")) {
                if (TextUtils.isEmpty(this.e) || this.f == -1) {
                    b.a("checkNetwork = " + strA);
                    uRLConnectionOpenConnection = url.openConnection();
                } else {
                    b.a("Proxy mProxyHost: = " + this.e + " mProxyPort: " + this.f);
                    Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(this.e, this.f));
                    Authenticator.setDefault(new j(this));
                    uRLConnectionOpenConnection = url.openConnection(proxy);
                }
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
                httpsURLConnection.setHostnameVerifier(new k(this));
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setConnectTimeout(50000);
                httpsURLConnection.setReadTimeout(50000);
                return httpsURLConnection;
            }
            b.c("Current network is not available.");
            this.d = ErrorMessage.a(-10, "Current network is not available.");
            return null;
        } catch (MalformedURLException e) {
            if (b.f3368a) {
                e.printStackTrace();
                b.a(e.getMessage());
            }
            str = "Auth server could not be parsed as a URL.";
            this.d = ErrorMessage.a(-11, str);
            return null;
        } catch (Exception e2) {
            if (b.f3368a) {
                e2.printStackTrace();
                b.a(e2.getMessage());
            }
            str = "Init httpsurlconnection failed.";
            this.d = ErrorMessage.a(-11, str);
            return null;
        }
    }

    public String a(HashMap map, String str, int i, String str2, String str3) throws Throwable {
        HashMap mapB = b(map);
        this.c = mapB;
        this.b = (String) mapB.get("url");
        this.e = str;
        this.f = i;
        this.g = str2;
        this.h = str3;
        HttpsURLConnection httpsURLConnectionB = b();
        if (httpsURLConnectionB == null) {
            b.c("syncConnect failed,httpsURLConnection is null");
        } else {
            a(httpsURLConnectionB);
        }
        return this.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0193 A[Catch: all -> 0x012b, TryCatch #10 {all -> 0x012b, blocks: (B:7:0x002e, B:83:0x0130, B:85:0x0134, B:86:0x0137, B:96:0x0160, B:98:0x0164, B:99:0x0167, B:109:0x018f, B:111:0x0193, B:112:0x0196), top: B:144:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01c0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0154 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0182 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b3 A[Catch: all -> 0x0105, TryCatch #7 {all -> 0x0105, blocks: (B:44:0x00af, B:46:0x00b3, B:47:0x00ce), top: B:142:0x00af }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0100 A[PHI: r5 r9 r13
      0x0100: PHI (r5v1 boolean) = (r5v0 boolean), (r5v0 boolean), (r5v0 boolean), (r5v3 boolean) binds: [B:92:0x015b, B:105:0x0189, B:118:0x01ba, B:57:0x00fe] A[DONT_GENERATE, DONT_INLINE]
      0x0100: PHI (r9v6 int) = (r9v0 int), (r9v1 int), (r9v2 int), (r9v16 int) binds: [B:92:0x015b, B:105:0x0189, B:118:0x01ba, B:57:0x00fe] A[DONT_GENERATE, DONT_INLINE]
      0x0100: PHI (r13v24 'e' java.io.IOException) = 
      (r13v12 'e' java.io.IOException)
      (r13v17 'e' java.io.IOException)
      (r13v22 'e' java.io.IOException)
      (r13v43 'e' java.io.IOException)
     binds: [B:92:0x015b, B:105:0x0189, B:118:0x01ba, B:57:0x00fe] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0108 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0134 A[Catch: all -> 0x012b, TryCatch #10 {all -> 0x012b, blocks: (B:7:0x002e, B:83:0x0130, B:85:0x0134, B:86:0x0137, B:96:0x0160, B:98:0x0164, B:99:0x0167, B:109:0x018f, B:111:0x0193, B:112:0x0196), top: B:144:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0164 A[Catch: all -> 0x012b, TryCatch #10 {all -> 0x012b, blocks: (B:7:0x002e, B:83:0x0130, B:85:0x0134, B:86:0x0137, B:96:0x0160, B:98:0x0164, B:99:0x0167, B:109:0x018f, B:111:0x0193, B:112:0x0196), top: B:144:0x002e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(HttpsURLConnection httpsURLConnection) throws Throwable {
        int responseCode;
        OutputStream outputStream;
        BufferedReader bufferedReader;
        InputStream inputStream;
        StringBuffer stringBuffer;
        b.a("https Post start,url:" + this.b);
        if (this.c == null) {
            this.d = ErrorMessage.a("httpsPost request paramters is null.");
            return;
        }
        OutputStream outputStream2 = null;
        BufferedReader bufferedReader2 = null;
        inputStream = null;
        InputStream inputStream2 = null;
        OutputStream outputStream3 = null;
        OutputStream outputStream4 = null;
        OutputStream outputStream5 = null;
        boolean z = false;
        try {
            try {
                outputStream = httpsURLConnection.getOutputStream();
            } catch (Throwable th) {
                th = th;
            }
        } catch (MalformedURLException e) {
            e = e;
        } catch (IOException e2) {
            e = e2;
        } catch (Exception e3) {
            e = e3;
        }
        try {
            try {
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    bufferedWriter.write(a(this.c));
                    b.a(a(this.c));
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    httpsURLConnection.connect();
                    try {
                        inputStream = httpsURLConnection.getInputStream();
                        try {
                            responseCode = httpsURLConnection.getResponseCode();
                        } catch (IOException e4) {
                            e = e4;
                            bufferedReader = null;
                            inputStream2 = inputStream;
                            responseCode = -1;
                            try {
                                if (b.f3368a) {
                                    e.printStackTrace();
                                    b.a("httpsPost parse failed;" + e.getMessage());
                                }
                                this.d = ErrorMessage.a(-11, "httpsPost failed,IOException:" + e.getMessage());
                                if (inputStream2 != null && bufferedReader != null) {
                                    bufferedReader.close();
                                    inputStream2.close();
                                }
                                httpsURLConnection.disconnect();
                                if (outputStream != null) {
                                }
                                if (z) {
                                }
                                if (this.d != null) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (inputStream2 != null && bufferedReader != null) {
                                    bufferedReader.close();
                                    inputStream2.close();
                                }
                                httpsURLConnection.disconnect();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = null;
                            inputStream2 = inputStream;
                            if (inputStream2 != null) {
                                bufferedReader.close();
                                inputStream2.close();
                            }
                            httpsURLConnection.disconnect();
                            throw th;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        bufferedReader = null;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedReader = null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    outputStream3 = outputStream;
                    if (outputStream3 != null) {
                        try {
                            outputStream3.close();
                        } catch (IOException e6) {
                            if (b.f3368a) {
                                e6.printStackTrace();
                            }
                        }
                    }
                    throw th;
                }
            } catch (MalformedURLException e7) {
                e = e7;
                outputStream4 = outputStream;
                if (b.f3368a) {
                    e.printStackTrace();
                }
                this.d = ErrorMessage.a(-11, "httpsPost failed,MalformedURLException:" + e.getMessage());
                if (outputStream4 != null) {
                    try {
                        outputStream4.close();
                    } catch (IOException e8) {
                        e = e8;
                        if (b.f3368a) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (IOException e9) {
                e = e9;
                outputStream5 = outputStream;
                if (b.f3368a) {
                    e.printStackTrace();
                }
                this.d = ErrorMessage.a(-11, "httpsPost failed,IOException:" + e.getMessage());
                if (outputStream5 != null) {
                    try {
                        outputStream5.close();
                    } catch (IOException e10) {
                        e = e10;
                        if (b.f3368a) {
                        }
                    }
                }
            } catch (Exception e11) {
                e = e11;
                outputStream2 = outputStream;
                if (b.f3368a) {
                    e.printStackTrace();
                }
                this.d = ErrorMessage.a(-11, "httpsPost failed,Exception:" + e.getMessage());
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e12) {
                        e = e12;
                        if (b.f3368a) {
                        }
                    }
                }
            }
        } catch (MalformedURLException e13) {
            e = e13;
            outputStream4 = outputStream;
            responseCode = -1;
            if (b.f3368a) {
            }
            this.d = ErrorMessage.a(-11, "httpsPost failed,MalformedURLException:" + e.getMessage());
            if (outputStream4 != null) {
            }
            if (z) {
            }
            if (this.d != null) {
            }
        } catch (IOException e14) {
            e = e14;
            outputStream5 = outputStream;
            responseCode = -1;
            if (b.f3368a) {
            }
            this.d = ErrorMessage.a(-11, "httpsPost failed,IOException:" + e.getMessage());
            if (outputStream5 != null) {
            }
            if (z) {
            }
            if (this.d != null) {
            }
        } catch (Exception e15) {
            e = e15;
            outputStream2 = outputStream;
            responseCode = -1;
            if (b.f3368a) {
            }
            this.d = ErrorMessage.a(-11, "httpsPost failed,Exception:" + e.getMessage());
            if (outputStream2 != null) {
            }
            if (z) {
            }
            if (this.d != null) {
            }
        }
        if (200 == responseCode) {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                try {
                    stringBuffer = new StringBuffer();
                } catch (IOException e16) {
                    e = e16;
                    inputStream2 = inputStream;
                    if (b.f3368a) {
                    }
                    this.d = ErrorMessage.a(-11, "httpsPost failed,IOException:" + e.getMessage());
                    if (inputStream2 != null) {
                        bufferedReader.close();
                        inputStream2.close();
                    }
                    httpsURLConnection.disconnect();
                } catch (Throwable th6) {
                    th = th6;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                    }
                    httpsURLConnection.disconnect();
                    throw th;
                }
            } catch (IOException e17) {
                e = e17;
                bufferedReader = null;
            } catch (Throwable th7) {
                th = th7;
                bufferedReader = null;
            }
            while (true) {
                int i = bufferedReader.read();
                if (i == -1) {
                    break;
                } else {
                    stringBuffer.append((char) i);
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e18) {
                        e = e18;
                        if (b.f3368a) {
                        }
                    }
                }
                if (z || 200 == responseCode) {
                    if (this.d != null) {
                        b.a("httpsPost failed,mResult is null");
                        this.d = ErrorMessage.a(-1, "httpsPost failed,internal error");
                        return;
                    } else {
                        b.a("httpsPost success end,parse result = " + this.d);
                        return;
                    }
                }
                b.a("httpsPost failed,statusCode:" + responseCode);
                this.d = ErrorMessage.a(-11, "httpsPost failed,statusCode:" + responseCode);
                return;
            }
            this.d = stringBuffer.toString();
            bufferedReader2 = bufferedReader;
        }
        if (inputStream != null && bufferedReader2 != null) {
            bufferedReader2.close();
            inputStream.close();
        }
        httpsURLConnection.disconnect();
        z = true;
        if (outputStream != null) {
        }
        if (z) {
        }
        if (this.d != null) {
        }
    }

    public boolean a() {
        b.a("checkNetwork start");
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f3374a.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                return networkCapabilities != null && networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16);
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return false;
            }
            b.a("checkNetwork end");
            return true;
        } catch (Exception e) {
            if (b.f3368a) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
