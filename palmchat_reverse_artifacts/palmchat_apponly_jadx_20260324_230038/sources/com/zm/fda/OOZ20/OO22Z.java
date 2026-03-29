package com.zm.fda.OOZ20;

import android.content.Context;
import com.efs.sdk.base.Constants;
import com.huawei.hms.framework.common.ContainerUtils;
import com.zm.fda.O52OZ.O2O5Z;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OO22Z {
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 3;
    public static final int l = 4;
    public static final String m = "v";
    public static final String n = "m";
    public static final String o = "p";
    public static final int p = 1024;
    public String b;
    public com.zm.fda.OOZ20.Z0225.OO22Z g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f16638a = new HashMap();
    public int c = 30000;
    public int d = 90000;
    public int e = 1;
    public int f = -1;

    public OO22Z(String str, com.zm.fda.OOZ20.Z0225.OO22Z oo22z) {
        this.b = str;
        this.g = oo22z;
    }

    public static byte[] a(String str, byte[] bArr, com.zm.fda.OOZ20.Z0225.OO22Z oo22z) {
        OO22Z oo22z2 = new OO22Z(str, oo22z);
        oo22z2.a("Content-Type", "application/octet-stream");
        oo22z2.a("User-Agent", "a");
        Context contextB = com.zm.fda.ZZ00Z.b();
        if (contextB != null) {
            oo22z2.a("v", O2O5Z.a(Integer.valueOf(com.zm.fda.O52OZ.ZZ00Z.c(contextB))));
            oo22z2.a("p", O2O5Z.a(contextB.getPackageName()));
        }
        oo22z2.a("m", O2O5Z.a(com.zm.fda.O52OZ.ZZ00Z.a()));
        return oo22z2.a(bArr);
    }

    public String b(Map<String, String> map) {
        char c;
        try {
            boolean zA = a();
            byte[] bArrA = a(map);
            if (zA) {
                try {
                    bArrA = com.zm.fda.OOZ20.Z0225.O022Z.b(a(map));
                    c = 0;
                } catch (Exception e) {
                    this.f16638a.remove("Content-Encoding");
                    a(e.getMessage(), -1);
                    c = 4;
                }
            } else {
                c = 0;
            }
            byte[] bArrA2 = null;
            for (int i2 = 0; i2 < this.e; i2++) {
                try {
                    bArrA2 = a(this.b, "POST", new ByteArrayInputStream(bArrA));
                } catch (IOException e2) {
                    a(e2.getMessage(), -1);
                    c = 1;
                } catch (Exception e3) {
                    a(e3.getMessage(), -1);
                    c = 3;
                }
                if (c == 0) {
                    break;
                }
            }
            return new String(bArrA2, "UTF-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static byte[] a(Map<String, String> map) {
        String string = "";
        if (map != null) {
            StringBuffer stringBuffer = new StringBuffer();
            int i2 = 0;
            for (String str : map.keySet()) {
                if (i2 > 0) {
                    stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
                }
                String str2 = map.get(str);
                try {
                    String strEncode = URLEncoder.encode(str, "UTF-8");
                    if (str2 == null) {
                        str2 = "";
                    }
                    String strEncode2 = URLEncoder.encode(str2, "UTF-8");
                    stringBuffer.append(strEncode);
                    stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    stringBuffer.append(strEncode2);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                i2++;
            }
            string = stringBuffer.toString();
        }
        return string.getBytes();
    }

    public void a(boolean z) {
        if (z) {
            this.f = 1;
        } else {
            this.f = 0;
        }
    }

    public void a(int i2) {
        this.e = i2;
    }

    public void a(String str, String str2) {
        this.f16638a.put(str, str2);
    }

    public void a(int i2, int i3) {
        this.c = i2;
        this.d = i3;
    }

    private boolean a() {
        if (this.f16638a.containsKey("Content-Encoding")) {
            return Constants.CP_GZIP.equals(this.f16638a.get("Content-Encoding"));
        }
        return false;
    }

    private void a(OutputStream outputStream, InputStream inputStream) throws IOException {
        inputStream.available();
        byte[] bArr = new byte[4096];
        while (true) {
            int i2 = inputStream.read(bArr, 0, 4096);
            if (i2 != -1) {
                outputStream.write(bArr, 0, i2);
            } else {
                outputStream.flush();
                outputStream.close();
                return;
            }
        }
    }

    private byte[] a(InputStream inputStream, int i2) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int i3 = inputStream.read(bArr);
            if (i3 != -1) {
                byteArrayOutputStream.write(bArr, 0, i3);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                inputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    private byte[] a(String str, String str2, InputStream inputStream) throws IOException {
        URL url = new URL(str);
        String protocol = url.getProtocol();
        if (protocol != null && protocol.length() != 0) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            if (httpURLConnection != null) {
                httpURLConnection.setConnectTimeout(this.c);
                httpURLConnection.setReadTimeout(this.d);
                httpURLConnection.setRequestMethod(str2);
                int i2 = this.f;
                if (i2 != -1) {
                    httpURLConnection.setUseCaches(i2 == 1);
                }
                httpURLConnection.setDoInput(true);
                for (String str3 : this.f16638a.keySet()) {
                    httpURLConnection.setRequestProperty(str3, this.f16638a.get(str3));
                }
                if ("POST".equals(str2)) {
                    httpURLConnection.setDoOutput(true);
                    if (inputStream != null) {
                        a(httpURLConnection.getOutputStream(), inputStream);
                        inputStream.close();
                    }
                }
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                String responseMessage = httpURLConnection.getResponseMessage();
                InputStream inputStream2 = httpURLConnection.getInputStream();
                if (inputStream2 == null) {
                    inputStream2 = httpURLConnection.getErrorStream();
                }
                byte[] bArrA = a(inputStream2, httpURLConnection.getContentLength());
                if (this.g != null && (bArrA == null || bArrA.length == 0)) {
                    a(responseMessage, responseCode);
                }
                httpURLConnection.disconnect();
                return bArrA;
            }
            throw new IOException("connection is null");
        }
        throw new IOException("protocol is null");
    }

    public byte[] a(byte[] bArr) {
        byte[] bArrA = null;
        char c = 0;
        for (int i2 = 0; i2 < this.e; i2++) {
            try {
                bArrA = a(this.b, "POST", new ByteArrayInputStream(bArr));
            } catch (IOException e) {
                a(e.getMessage(), -1);
                c = 1;
            } catch (Exception e2) {
                a(e2.getMessage(), -1);
                c = 3;
            }
            if (c == 0) {
                break;
            }
        }
        return bArrA;
    }

    private void a(String str, int i2) {
        com.zm.fda.OOZ20.Z0225.OO22Z oo22z = this.g;
        if (oo22z != null) {
            oo22z.a(0, str, Integer.valueOf(i2));
        }
    }
}
