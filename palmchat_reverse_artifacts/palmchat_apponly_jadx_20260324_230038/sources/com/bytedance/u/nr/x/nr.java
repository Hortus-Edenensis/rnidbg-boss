package com.bytedance.u.nr.x;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.efs.sdk.base.Constants;
import com.huawei.hms.framework.common.ContainerUtils;
import defpackage.bf7;
import defpackage.hj7;
import defpackage.mf7;
import defpackage.nl7;
import defpackage.uh7;
import defpackage.xe7;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.HttpHeaders;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f5442a = false;

    /* JADX INFO: renamed from: com.bytedance.u.nr.x.nr$nr, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public enum EnumC0320nr {
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5);

        final int x;

        EnumC0320nr(int i) {
            this.x = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum u {
        NONE(0),
        GZIP(1),
        DEFLATER(2);

        final int b;

        u(int i) {
            this.b = i;
        }
    }

    public static bf7 a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new bf7(203);
        }
        String str = new String(bArr, Charset.forName("utf-8"));
        try {
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.length() > 0 ? new bf7(0, jSONObject) : new bf7(204, str);
        } catch (JSONException unused) {
            return new bf7(204, str);
        }
    }

    public static String b(Map map) {
        return uh7.h().c();
    }

    public static boolean c() {
        return true;
    }

    public static byte[] d(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                mf7.a(th);
                gZIPOutputStream.close();
                return null;
            } catch (Throwable th2) {
                gZIPOutputStream.close();
                throw th2;
            }
        }
    }

    public static bf7 e(long j, String str, byte[] bArr, u uVar, String str2, boolean z) throws IOException {
        String str3;
        if (str == null) {
            return new bf7(201);
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        if (u.GZIP == uVar && length > 128) {
            bArr = d(bArr);
            str3 = Constants.CP_GZIP;
        } else if (u.DEFLATER != uVar || length <= 128) {
            str3 = null;
        } else {
            bArr = m(bArr);
            str3 = "deflate";
        }
        String str4 = str3;
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            return new bf7(202);
        }
        if (!z) {
            return h(str, bArr2, str2, str4, "POST", true, false);
        }
        byte[] bArrA = TTEncryptUtils.a(bArr2, bArr2.length);
        if (bArrA != null) {
            if (TextUtils.isEmpty(new URL(str).getQuery())) {
                if (!str.endsWith(com.oplus.tblplayer.Constants.STRING_VALUE_UNSET)) {
                    str = str + com.oplus.tblplayer.Constants.STRING_VALUE_UNSET;
                }
            } else if (!str.endsWith(ContainerUtils.FIELD_DELIMITER)) {
                str = str + ContainerUtils.FIELD_DELIMITER;
            }
            str = str + "encrypt=true";
            str2 = "application/octet-stream;tt-data=a";
            bArr2 = bArrA;
        }
        return h(str, bArr2, str2, str4, "POST", true, true);
    }

    public static bf7 f(String str, String str2) {
        return g(str, str2, k());
    }

    public static bf7 g(String str, String str2, boolean z) {
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                return e(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, str, str2.getBytes(), u.GZIP, "application/json; charset=utf-8", z);
            }
            return new bf7(201);
        } catch (Throwable th) {
            mf7.a(th);
            return new bf7(207, th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004e A[Catch: all -> 0x0045, TryCatch #4 {all -> 0x0045, blocks: (B:9:0x0021, B:11:0x0027, B:12:0x002b, B:14:0x0031, B:16:0x0039, B:20:0x004e, B:23:0x0059, B:25:0x0060, B:26:0x0065, B:28:0x006c, B:30:0x0071, B:34:0x0083, B:39:0x008b, B:40:0x008e, B:41:0x008f, B:43:0x0097, B:61:0x00cd, B:65:0x00e9, B:66:0x00f0, B:21:0x0053), top: B:91:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0053 A[Catch: all -> 0x0045, TryCatch #4 {all -> 0x0045, blocks: (B:9:0x0021, B:11:0x0027, B:12:0x002b, B:14:0x0031, B:16:0x0039, B:20:0x004e, B:23:0x0059, B:25:0x0060, B:26:0x0065, B:28:0x006c, B:30:0x0071, B:34:0x0083, B:39:0x008b, B:40:0x008e, B:41:0x008f, B:43:0x0097, B:61:0x00cd, B:65:0x00e9, B:66:0x00f0, B:21:0x0053), top: B:91:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0059 A[Catch: all -> 0x0045, TryCatch #4 {all -> 0x0045, blocks: (B:9:0x0021, B:11:0x0027, B:12:0x002b, B:14:0x0031, B:16:0x0039, B:20:0x004e, B:23:0x0059, B:25:0x0060, B:26:0x0065, B:28:0x006c, B:30:0x0071, B:34:0x0083, B:39:0x008b, B:40:0x008e, B:41:0x008f, B:43:0x0097, B:61:0x00cd, B:65:0x00e9, B:66:0x00f0, B:21:0x0053), top: B:91:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0060 A[Catch: all -> 0x0045, TryCatch #4 {all -> 0x0045, blocks: (B:9:0x0021, B:11:0x0027, B:12:0x002b, B:14:0x0031, B:16:0x0039, B:20:0x004e, B:23:0x0059, B:25:0x0060, B:26:0x0065, B:28:0x006c, B:30:0x0071, B:34:0x0083, B:39:0x008b, B:40:0x008e, B:41:0x008f, B:43:0x0097, B:61:0x00cd, B:65:0x00e9, B:66:0x00f0, B:21:0x0053), top: B:91:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c A[Catch: all -> 0x0045, TryCatch #4 {all -> 0x0045, blocks: (B:9:0x0021, B:11:0x0027, B:12:0x002b, B:14:0x0031, B:16:0x0039, B:20:0x004e, B:23:0x0059, B:25:0x0060, B:26:0x0065, B:28:0x006c, B:30:0x0071, B:34:0x0083, B:39:0x008b, B:40:0x008e, B:41:0x008f, B:43:0x0097, B:61:0x00cd, B:65:0x00e9, B:66:0x00f0, B:21:0x0053), top: B:91:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e9 A[Catch: all -> 0x0045, TRY_ENTER, TryCatch #4 {all -> 0x0045, blocks: (B:9:0x0021, B:11:0x0027, B:12:0x002b, B:14:0x0031, B:16:0x0039, B:20:0x004e, B:23:0x0059, B:25:0x0060, B:26:0x0065, B:28:0x006c, B:30:0x0071, B:34:0x0083, B:39:0x008b, B:40:0x008e, B:41:0x008f, B:43:0x0097, B:61:0x00cd, B:65:0x00e9, B:66:0x00f0, B:21:0x0053), top: B:91:0x0021 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static bf7 h(String str, byte[] bArr, String str2, String str3, String str4, boolean z, boolean z2) {
        InputStream inputStream;
        byte[] bArrL;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection = null;
        GZIPInputStream gZIPInputStream = null;
        try {
            LinkedList<Pair> linkedList = new LinkedList();
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) (z2 ? new URL(nl7.a(str, linkedList)) : new URL(str)).openConnection();
            if (z2) {
                try {
                    if (!linkedList.isEmpty()) {
                        for (Pair pair : linkedList) {
                            if (pair != null) {
                                httpURLConnection2.setRequestProperty((String) pair.first, (String) pair.second);
                            }
                        }
                    }
                    if (z) {
                        httpURLConnection2.setDoOutput(false);
                    } else {
                        httpURLConnection2.setDoOutput(true);
                    }
                    if (str2 != null) {
                        httpURLConnection2.setRequestProperty("Content-Type", str2);
                    }
                    if (str3 != null) {
                        httpURLConnection2.setRequestProperty("Content-Encoding", str3);
                    }
                    httpURLConnection2.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, Constants.CP_GZIP);
                    if (str4 != null) {
                        throw new IllegalArgumentException("request method is not null");
                    }
                    httpURLConnection2.setRequestMethod(str4);
                    if (bArr != null && bArr.length > 0) {
                        try {
                            dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                            try {
                                dataOutputStream.write(bArr);
                                dataOutputStream.flush();
                                xe7.a(dataOutputStream);
                            } catch (Throwable th) {
                                th = th;
                                xe7.a(dataOutputStream);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            dataOutputStream = null;
                        }
                    }
                    int responseCode = httpURLConnection2.getResponseCode();
                    if (responseCode != 200) {
                        bf7 bf7Var = new bf7(206, "http response code " + responseCode);
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Exception unused) {
                        }
                        xe7.a(null);
                        return bf7Var;
                    }
                    inputStream = httpURLConnection2.getInputStream();
                    try {
                        if (Constants.CP_GZIP.equalsIgnoreCase(httpURLConnection2.getContentEncoding())) {
                            try {
                                GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream);
                                try {
                                    bArrL = l(gZIPInputStream2);
                                    xe7.a(gZIPInputStream2);
                                } catch (Throwable th3) {
                                    th = th3;
                                    gZIPInputStream = gZIPInputStream2;
                                    xe7.a(gZIPInputStream);
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } else {
                            bArrL = l(inputStream);
                        }
                        bf7 bf7VarA = a(bArrL);
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Exception unused2) {
                        }
                        xe7.a(inputStream);
                        return bf7VarA;
                    } catch (Throwable th5) {
                        httpURLConnection = httpURLConnection2;
                        th = th5;
                    }
                } catch (Throwable th6) {
                    httpURLConnection = httpURLConnection2;
                    th = th6;
                    inputStream = null;
                }
            } else {
                if (z) {
                }
                if (str2 != null) {
                }
                if (str3 != null) {
                }
                httpURLConnection2.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, Constants.CP_GZIP);
                if (str4 != null) {
                }
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
        }
        try {
            mf7.a(th);
            return new bf7(207, th);
        } finally {
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused3) {
                }
            }
            xe7.a(inputStream);
        }
    }

    public static bf7 i(hj7 hj7Var) {
        if (hj7Var == null) {
            return new bf7(201);
        }
        try {
            return e(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, hj7Var.e(), hj7Var.a(), u.GZIP, "application/json; charset=utf-8", hj7Var.c());
        } catch (Throwable th) {
            mf7.a(th);
            return new bf7(207, th);
        }
    }

    public static String j(Map map) {
        return uh7.h().e();
    }

    public static boolean k() {
        return true;
    }

    public static byte[] l(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 == i) {
                inputStream.close();
                try {
                    return byteArrayOutputStream.toByteArray();
                } finally {
                    xe7.a(byteArrayOutputStream);
                }
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public static byte[] m(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }
}
