package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import com.tencent.turingfd.sdk.ams.ad.CanisMinor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.http.HttpHeaders;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.synchronized, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Csynchronized {

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.synchronized$do, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class Cdo implements CanisMinor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[] f10775a;
        public volatile int b = 0;

        public Cdo(String[] strArr) {
            this.f10775a = strArr;
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public CanisMinor.Cdo a(byte[] bArr) {
            Context context;
            HttpURLConnection httpURLConnection;
            int i;
            int responseCode;
            InputStream inputStream;
            ByteArrayOutputStream byteArrayOutputStream;
            NetworkInfo activeNetworkInfo;
            String strA;
            String str = this.f10775a[this.b];
            synchronized (Ccase.class) {
                context = Ccase.f10751a;
            }
            boolean z = true;
            try {
                activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Throwable th) {
                String message = th.getMessage();
                if (message != null && message.contains("ACCESS_NETWORK_STATE")) {
                }
            }
            char c = (activeNetworkInfo == null || !(activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING || activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED)) ? (char) 4 : activeNetworkInfo.getType() == 1 ? (char) 1 : (activeNetworkInfo.getType() != 0 || (strA = Csynchronized.a(context)) == null || strA.length() <= 0 || Csynchronized.b(context) <= 0) ? (char) 3 : (char) 2;
            byte[] byteArray = null;
            if (c == 4) {
                i = -1052;
                httpURLConnection = null;
            } else {
                try {
                    URL url = new URL(str);
                    HttpURLConnection httpURLConnection2 = c == 2 ? (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(Csynchronized.a(Ccase.a()), Csynchronized.b(Ccase.a())))) : (HttpURLConnection) url.openConnection();
                    try {
                        httpURLConnection2.setReadTimeout(15000);
                        httpURLConnection2.setConnectTimeout(15000);
                        httpURLConnection = httpURLConnection2;
                        i = 0;
                    } catch (SecurityException e) {
                        httpURLConnection = httpURLConnection2;
                        e = e;
                        e.printStackTrace();
                        i = -1058;
                    } catch (MalformedURLException e2) {
                        httpURLConnection = httpURLConnection2;
                        e = e2;
                        e.printStackTrace();
                        i = -1053;
                    } catch (IOException e3) {
                        httpURLConnection = httpURLConnection2;
                        e = e3;
                        e.printStackTrace();
                        i = -1056;
                    } catch (IllegalArgumentException e4) {
                        httpURLConnection = httpURLConnection2;
                        e = e4;
                        e.printStackTrace();
                        i = -1057;
                    } catch (UnsupportedOperationException e5) {
                        httpURLConnection = httpURLConnection2;
                        e = e5;
                        e.printStackTrace();
                        i = -1059;
                    } catch (Throwable th2) {
                        httpURLConnection = httpURLConnection2;
                        th = th2;
                        th.printStackTrace();
                        i = -1000;
                    }
                } catch (IOException e6) {
                    e = e6;
                    httpURLConnection = null;
                } catch (IllegalArgumentException e7) {
                    e = e7;
                    httpURLConnection = null;
                } catch (SecurityException e8) {
                    e = e8;
                    httpURLConnection = null;
                } catch (UnsupportedOperationException e9) {
                    e = e9;
                    httpURLConnection = null;
                } catch (MalformedURLException e10) {
                    e = e10;
                    httpURLConnection = null;
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = null;
                }
            }
            if (i != 0) {
                z = false;
            } else {
                i = -2000;
                try {
                    try {
                        int length = bArr.length;
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setRequestProperty(HttpHeaders.PRAGMA, "no-cache");
                        httpURLConnection.setRequestProperty(HttpHeaders.CACHE_CONTROL, "no-cache");
                        httpURLConnection.setInstanceFollowRedirects(false);
                        httpURLConnection.setRequestProperty("User-Agent", "Turing");
                        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "*/*");
                        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_CHARSET, "utf-8");
                        httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                        httpURLConnection.setRequestProperty("Content-length", "" + length);
                        try {
                            if (Build.VERSION.SDK != null) {
                                httpURLConnection.setRequestProperty("Connection", "close");
                            }
                        } catch (Exception unused) {
                        }
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(bArr);
                        outputStream.flush();
                        outputStream.close();
                        responseCode = httpURLConnection.getResponseCode();
                    } catch (IllegalAccessError e11) {
                        StringBuilder sbA = Banana.a("illegal access error:");
                        sbA.append(e11.getMessage());
                        Log.e("TuringHttpUtil", sbA.toString());
                        e11.printStackTrace();
                        i = -2060;
                    } catch (Throwable th4) {
                        Log.w("TuringHttpUtil", th4);
                        th4.printStackTrace();
                    }
                } catch (IllegalStateException e12) {
                    StringBuilder sbA2 = Banana.a("illegal state error:");
                    sbA2.append(e12.getMessage());
                    Log.e("TuringHttpUtil", sbA2.toString());
                    e12.printStackTrace();
                    i = -2061;
                } catch (ProtocolException e13) {
                    StringBuilder sbA3 = Banana.a("protocol error:");
                    sbA3.append(e13.getMessage());
                    Log.e("TuringHttpUtil", sbA3.toString());
                    e13.printStackTrace();
                    i = -2051;
                } catch (IOException e14) {
                    StringBuilder sbA4 = Banana.a("post io error:");
                    sbA4.append(e14.getMessage());
                    Log.e("TuringHttpUtil", sbA4.toString());
                    e14.printStackTrace();
                    i = -2056;
                }
                if (responseCode == 200) {
                    i = 0;
                } else {
                    if (responseCode != -1) {
                        i = (-2000) - responseCode;
                    }
                    z = false;
                }
            }
            if (i != 0) {
                return new CanisMinor.Cdo(i, new byte[0]);
            }
            AtomicReference atomicReference = new AtomicReference();
            int i2 = -4000;
            if (httpURLConnection != null && z) {
                try {
                    inputStream = httpURLConnection.getInputStream();
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (IOException e15) {
                    e15.printStackTrace();
                    i2 = -4056;
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                while (true) {
                    int i3 = inputStream.read();
                    if (i3 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(i3);
                    atomicReference.set(byteArray);
                    httpURLConnection.disconnect();
                }
                byteArray = byteArrayOutputStream.toByteArray();
                i2 = 0;
                atomicReference.set(byteArray);
                httpURLConnection.disconnect();
            }
            return i2 != 0 ? new CanisMinor.Cdo(i2, new byte[0]) : new CanisMinor.Cdo(i2, (byte[]) atomicReference.get());
        }
    }

    public static String a(Context context) {
        return System.getProperty("http.proxyHost");
    }

    public static int b(Context context) {
        try {
            return Integer.parseInt(System.getProperty("http.proxyPort"));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
