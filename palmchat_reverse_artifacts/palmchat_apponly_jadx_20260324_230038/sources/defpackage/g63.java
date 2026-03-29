package defpackage;

import com.zenmen.palmchat.utils.HttpsHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.jivesoftware.smack.util.GZipUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class g63 implements pn2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17670a;
    public File b;
    public HttpEntity c;
    public int d;

    public static byte[] c(byte[] bArr) {
        return k86.f(bArr);
    }

    public static byte[] f(File file) throws Throwable {
        BufferedInputStream bufferedInputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) file.length());
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = bufferedInputStream.read(bArr, 0, 1024);
                if (-1 == i) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                bufferedInputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            throw e;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            try {
                bufferedInputStream2.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            byteArrayOutputStream.close();
            throw th;
        }
    }

    @Override // defpackage.pn2
    public HttpURLConnection a(String str, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(30000);
        MultipartEntityBuilder multipartEntityBuilderCreate = MultipartEntityBuilder.create();
        multipartEntityBuilderCreate.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        multipartEntityBuilderCreate.addTextBody("logType", String.valueOf(this.d));
        boolean zB = b63.a().b().b(this.d);
        multipartEntityBuilderCreate.addTextBody("isGzip", zB ? "1" : "0");
        String str2 = this.f17670a;
        if (str2 != null) {
            multipartEntityBuilderCreate.addBinaryBody("file", zB ? c(GZipUtil.compress(str2.getBytes("utf-8"))) : c(str2.getBytes("utf-8")));
        } else {
            multipartEntityBuilderCreate.addBinaryBody("file", zB ? c(GZipUtil.compress(d(this.b, false))) : d(this.b, true));
        }
        multipartEntityBuilderCreate.addTextBody("decrypted", "1");
        HttpEntity httpEntityBuild = multipartEntityBuilderCreate.build();
        this.c = httpEntityBuild;
        httpURLConnection.setRequestProperty("Content-Type", httpEntityBuild.getContentType().getValue());
        if (map != null) {
            for (String str3 : map.keySet()) {
                httpURLConnection.addRequestProperty(str3, map.get(str3));
            }
        }
        b13.a(httpURLConnection);
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            HttpsHelper.getmInstance();
            httpsURLConnection.setSSLSocketFactory(HttpsHelper.getmSSLSocketFactory());
            httpsURLConnection.setHostnameVerifier(HttpsHelper.DO_NOT_VERIFY);
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }

    public final JSONObject b(String str, int i, String str2, File file, Map<String, String> map) throws Exception {
        this.f17670a = str2;
        this.b = file;
        this.d = i;
        LogUtil.i("DnsHelper", "doPostBinaryDataImp");
        HttpURLConnection httpURLConnectionA = oe1.a(this, str, map, false, true);
        JSONObject jSONObject = null;
        if (httpURLConnectionA == null) {
            return null;
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnectionA.getOutputStream());
        try {
            this.c.writeTo(dataOutputStream);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        dataOutputStream.flush();
        dataOutputStream.close();
        if (httpURLConnectionA.getResponseCode() == 200) {
            InputStream inputStream = httpURLConnectionA.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = inputStream.read(bArr, 0, 1024);
                if (i2 <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
            inputStream.close();
            byteArrayOutputStream.close();
            jSONObject = new JSONObject(new String(byteArrayOutputStream.toByteArray()));
        }
        httpURLConnectionA.disconnect();
        return jSONObject;
    }

    public byte[] d(File file, boolean z) {
        try {
            byte[] bArrF = f(file);
            return z ? c(bArrF) : bArrF;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public JSONObject e(String str, int i, String str2, File file) {
        try {
            if (ap3.a().i()) {
                return b(str, i, str2, file, null);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
