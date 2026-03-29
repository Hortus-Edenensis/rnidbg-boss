package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import cdadata.cdazmm.cdazma;
import cdadata.cdazmm.cdazmc;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class h67 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17880a;
    public Map<String, String> b = new HashMap();
    public int c = 30000;
    public int d = 90000;
    public int e = 1;
    public int f = -1;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17881a;
        public String b;
        public String c;
    }

    public h67(String str) {
        this.f17880a = str;
    }

    public static byte[] b(String str, byte[] bArr) throws cdazma {
        g57.b("CDA_url", str + " 数据大小：" + bArr.length);
        h67 h67Var = new h67(str);
        h67Var.b.put("Content-Type", "application/octet-stream");
        h67Var.b.put("User-Agent", "a");
        if (h67Var.e <= 0) {
            return null;
        }
        try {
            return h67Var.a(h67Var.f17880a, "POST", new ByteArrayInputStream(bArr));
        } catch (IOException e) {
            throw new cdazma(e);
        }
    }

    public final byte[] a(String str, String str2, InputStream inputStream) throws cdazmc, IOException {
        Inet6Address inet6Address;
        a aVar = null;
        if (!TextUtils.isEmpty(str) && URLUtil.isHttpUrl(str)) {
            String host = Uri.parse(str).getHost();
            try {
                InetAddress[] allByName = InetAddress.getAllByName(host);
                if (allByName != null && allByName.length != 0) {
                    int length = allByName.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            inet6Address = null;
                            break;
                        }
                        InetAddress inetAddress = allByName[i];
                        if (inetAddress instanceof Inet6Address) {
                            inet6Address = (Inet6Address) inetAddress;
                            break;
                        }
                        i++;
                    }
                    if (inet6Address != null) {
                        a aVar2 = new a();
                        aVar2.f17881a = host;
                        String hostAddress = inet6Address.getHostAddress();
                        aVar2.b = hostAddress;
                        aVar2.c = str.replace(host, String.format("[%s]", hostAddress));
                        aVar = aVar2;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (aVar != null) {
            str = aVar.c;
        }
        URL url = new URL(str);
        String protocol = url.getProtocol();
        if (protocol == null || protocol.length() == 0) {
            throw new IOException("protocol is null");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        if (httpURLConnection != null && aVar != null) {
            httpURLConnection.setRequestProperty("host", aVar.f17881a);
        }
        if (httpURLConnection == null) {
            throw new IOException("connection is null");
        }
        httpURLConnection.setConnectTimeout(this.c);
        httpURLConnection.setReadTimeout(this.d);
        httpURLConnection.setRequestMethod(str2);
        int i2 = this.f;
        if (i2 != -1) {
            httpURLConnection.setUseCaches(i2 == 1);
        }
        httpURLConnection.setDoInput(true);
        for (String str3 : this.b.keySet()) {
            httpURLConnection.setRequestProperty(str3, this.b.get(str3));
        }
        if ("POST".equals(str2)) {
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            inputStream.available();
            byte[] bArr = new byte[4096];
            while (true) {
                int i3 = inputStream.read(bArr, 0, 4096);
                if (i3 == -1) {
                    break;
                }
                outputStream.write(bArr, 0, i3);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }
        httpURLConnection.connect();
        int responseCode = httpURLConnection.getResponseCode();
        String responseMessage = httpURLConnection.getResponseMessage();
        if (responseCode < 200 || responseCode >= 300) {
            throw new cdazmc(String.format("flush failure with response '%s', the response code is '%d'", responseMessage, Integer.valueOf(responseCode)), responseCode);
        }
        InputStream inputStream2 = httpURLConnection.getInputStream();
        if (inputStream2 == null) {
            inputStream2 = httpURLConnection.getErrorStream();
        }
        httpURLConnection.getContentLength();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[4096];
        while (true) {
            int i4 = inputStream2.read(bArr2);
            if (i4 == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                inputStream2.close();
                byteArrayOutputStream.close();
                httpURLConnection.disconnect();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr2, 0, i4);
        }
    }
}
