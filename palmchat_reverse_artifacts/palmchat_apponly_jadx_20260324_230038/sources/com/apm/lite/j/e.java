package com.apm.lite.j;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.apm.lite.Npth;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.huawei.hms.framework.common.ContainerUtils;
import com.oplus.tblplayer.Constants;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import defpackage.hv6;
import defpackage.kj7;
import defpackage.md7;
import defpackage.qe7;
import defpackage.vf7;
import defpackage.wf7;
import defpackage.x97;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.HttpHeaders;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f3291a = false;

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        NONE(0),
        GZIP(1),
        DEFLATER(2);

        final int d;

        a(int i) {
            this.d = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum b {
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5),
        MOBILE_5G(6),
        WIFI_24GHZ(7),
        WIFI_5GHZ(8),
        MOBILE_3G_H(9),
        MOBILE_3G_HP(10);

        final int l;

        b(int i) {
            this.l = i;
        }
    }

    public static String a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(new URL(str).getQuery())) {
                if (!str.endsWith(Constants.STRING_VALUE_UNSET)) {
                    str = str + Constants.STRING_VALUE_UNSET;
                }
            } else if (!str.endsWith(ContainerUtils.FIELD_DELIMITER)) {
                str = str + ContainerUtils.FIELD_DELIMITER;
            }
            return str + str2;
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String b(String str, Map map) {
        if (TextUtils.isDigitsOnly(str) || map == null || map.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (!str.contains(Constants.STRING_VALUE_UNSET)) {
            sb.append(Constants.STRING_VALUE_UNSET);
        }
        try {
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    if (!sb.toString().endsWith(Constants.STRING_VALUE_UNSET)) {
                        sb.append(ContainerUtils.FIELD_DELIMITER);
                    }
                    sb.append(n(entry.getKey().toString(), "UTF-8"));
                    sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb.append(n(entry.getValue().toString(), "UTF-8"));
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static vf7 c(long j, String str, byte[] bArr, a aVar, String str2, boolean z) {
        return d(j, str, bArr, aVar, str2, z, false);
    }

    public static vf7 d(long j, String str, byte[] bArr, a aVar, String str2, boolean z, boolean z2) throws IOException {
        String str3;
        String str4;
        StringBuilder sb;
        if (Npth.isStopUpload()) {
            return new vf7(201);
        }
        if (str == null) {
            return new vf7(201);
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        if (a.GZIP == aVar && length > 128) {
            bArr = r(bArr);
            str3 = com.efs.sdk.base.Constants.CP_GZIP;
        } else if (a.DEFLATER != aVar || length <= 128) {
            str3 = null;
        } else {
            bArr = m(bArr);
            str3 = "deflate";
        }
        String str5 = str3;
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            return new vf7(202);
        }
        if (!z) {
            return h(str, bArr2, str2, str5, "POST", true, false, z2);
        }
        byte[] bArrA = md7.a(bArr2);
        if (bArrA != null) {
            if (TextUtils.isEmpty(new URL(str).getQuery())) {
                str4 = Constants.STRING_VALUE_UNSET;
                if (!str.endsWith(Constants.STRING_VALUE_UNSET)) {
                    sb = new StringBuilder();
                    sb.append(str);
                    sb.append(str4);
                    str = sb.toString();
                }
                str = str + "tt_data=a";
                str2 = "application/octet-stream;tt-data=a";
                bArr2 = bArrA;
            } else {
                str4 = ContainerUtils.FIELD_DELIMITER;
                if (!str.endsWith(ContainerUtils.FIELD_DELIMITER)) {
                    sb = new StringBuilder();
                    sb.append(str);
                    sb.append(str4);
                    str = sb.toString();
                }
                str = str + "tt_data=a";
                str2 = "application/octet-stream;tt-data=a";
                bArr2 = bArrA;
            }
        }
        return h(str, bArr2, str2, str5, "POST", true, true, z2);
    }

    public static vf7 e(String str, String str2, boolean z) {
        return f(str, str2, i(), z);
    }

    public static vf7 f(String str, String str2, boolean z, boolean z2) {
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                return d(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, str, str2.getBytes(), a.GZIP, "application/json; charset=utf-8", z, z2);
            }
            return new vf7(201);
        } catch (Throwable th) {
            kj7.g(th);
            return new vf7(207, th);
        }
    }

    public static vf7 g(String str, String str2, File... fileArr) {
        return o(str, str2, fileArr);
    }

    public static vf7 h(String str, byte[] bArr, String str2, String str3, String str4, boolean z, boolean z2, boolean z3) {
        return p(str, bArr, str2, str3, str4, z, z2, z3);
    }

    public static boolean i() {
        return TextUtils.equals(com.umeng.ccg.a.x, "app");
    }

    public static boolean j(String str, String str2, String str3, String str4, List<String> list) {
        if (Npth.isStopUpload()) {
            return false;
        }
        try {
            HashMap map = new HashMap();
            map.put("aid", str2);
            String strL = com.apm.lite.b.l(str2);
            if (!TextUtils.isEmpty(strL)) {
                map.put("x-auth-token", strL);
            }
            qe7 qe7Var = new qe7(str, "UTF-8", map, false);
            qe7Var.c("aid", str2);
            qe7Var.c("device_id", str3);
            qe7Var.c("os", AnalyticsConstants.SDK_TYPE);
            qe7Var.c(ContentProviderManager.PLUGIN_PROCESS_NAME, str4);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                File file = new File(it.next());
                if (file.exists()) {
                    HashMap map2 = new HashMap();
                    map2.put("logtype", "alog");
                    map2.put("scene", "crash");
                    qe7Var.b(file.getName(), file, map2);
                }
            }
            return new JSONObject(qe7Var.a()).optInt("errno", -1) == 200;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static byte[] k(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 == i) {
                inputStream.close();
                try {
                    return byteArrayOutputStream.toByteArray();
                } finally {
                    wf7.a(byteArrayOutputStream);
                }
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public static byte[] l(String str, Map<String, String> map, byte[] bArr) {
        try {
            return c(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, b(str, map), bArr, a.GZIP, "application/json; charset=utf-8", false).b();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
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

    public static String n(String str, String str2) {
        if (str2 == null) {
            str2 = "UTF-8";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static vf7 o(String str, String str2, File... fileArr) {
        if (Npth.isStopUpload()) {
            return new vf7(201);
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("have_dump=true");
            sb.append(i() ? "&encrypt=true" : "");
            qe7 qe7Var = new qe7(a(str, sb.toString()), "UTF-8", true);
            qe7Var.d(BodyData.TYPE_JSON, str2, true);
            qe7Var.f("file", fileArr);
            try {
                return new vf7(0, new JSONObject(qe7Var.a()));
            } catch (JSONException e) {
                return new vf7(0, e);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return new vf7(207);
        }
    }

    public static vf7 p(String str, byte[] bArr, String str2, String str3, String str4, boolean z, boolean z2, boolean z3) {
        InputStream inputStream;
        byte[] bArrK;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection = null;
        GZIPInputStream gZIPInputStream = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                hv6.a(httpURLConnection2);
                if (z) {
                    httpURLConnection2.setDoOutput(true);
                } else {
                    httpURLConnection2.setDoOutput(false);
                }
                if (str2 != null) {
                    httpURLConnection2.setRequestProperty("Content-Type", str2);
                }
                if (str3 != null) {
                    httpURLConnection2.setRequestProperty("Content-Encoding", str3);
                }
                httpURLConnection2.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, com.efs.sdk.base.Constants.CP_GZIP);
                if (str4 == null) {
                    throw new IllegalArgumentException("request method is not null");
                }
                if (z3) {
                    String strQ = com.apm.lite.b.q();
                    if (!TextUtils.isEmpty(strQ)) {
                        httpURLConnection2.setRequestProperty("aid", strQ);
                        String strL = com.apm.lite.b.l(strQ);
                        if (!TextUtils.isEmpty(strL)) {
                            httpURLConnection2.setRequestProperty("x-auth-token", strL);
                        }
                    }
                }
                httpURLConnection2.setRequestMethod(str4);
                if (bArr != null && bArr.length > 0) {
                    try {
                        dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                        try {
                            dataOutputStream.write(bArr);
                            dataOutputStream.flush();
                            wf7.a(dataOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            wf7.a(dataOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        dataOutputStream = null;
                    }
                }
                int responseCode = httpURLConnection2.getResponseCode();
                if (responseCode != 200) {
                    vf7 vf7Var = new vf7(206, "http response code " + responseCode);
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception unused) {
                    }
                    wf7.a(null);
                    return vf7Var;
                }
                InputStream inputStream2 = httpURLConnection2.getInputStream();
                try {
                    if (com.efs.sdk.base.Constants.CP_GZIP.equalsIgnoreCase(httpURLConnection2.getContentEncoding())) {
                        try {
                            GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream2);
                            try {
                                bArrK = k(gZIPInputStream2);
                                wf7.a(gZIPInputStream2);
                            } catch (Throwable th3) {
                                th = th3;
                                gZIPInputStream = gZIPInputStream2;
                                wf7.a(gZIPInputStream);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } else {
                        bArrK = k(inputStream2);
                    }
                    vf7 vf7VarT = t(bArrK);
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception unused2) {
                    }
                    wf7.a(inputStream2);
                    return vf7VarT;
                } catch (Throwable th5) {
                    httpURLConnection = httpURLConnection2;
                    inputStream = inputStream2;
                    th = th5;
                    try {
                        kj7.f(th);
                        return new vf7(207, th);
                    } finally {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused3) {
                            }
                        }
                        wf7.a(inputStream);
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                httpURLConnection = httpURLConnection2;
                inputStream = null;
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
        }
    }

    public static boolean q() {
        return TextUtils.equals(com.umeng.ccg.a.x, "app");
    }

    public static byte[] r(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                kj7.g(th);
                gZIPOutputStream.close();
                return null;
            } catch (Throwable th2) {
                gZIPOutputStream.close();
                throw th2;
            }
        }
    }

    public static String s() {
        return x97.o().getJavaCrashUploadUrl();
    }

    public static vf7 t(byte[] bArr) {
        return new vf7(204, bArr);
    }

    public static String u() {
        return x97.o().getAlogUploadUrl();
    }

    public static String v() {
        return x97.o().getLaunchCrashUploadUrl();
    }

    public static String w() {
        return x97.o().getNativeCrashUploadUrl();
    }
}
