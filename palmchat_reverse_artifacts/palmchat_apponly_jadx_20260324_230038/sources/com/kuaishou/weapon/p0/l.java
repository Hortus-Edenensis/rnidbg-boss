package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7485a = "gzip";
    private static final int b = 1024;
    private static volatile l d;
    private static Context e;
    private boolean c = false;

    private l(Context context) {
        e = context;
    }

    public static l a(Context context) {
        if (d == null) {
            synchronized (l.class) {
                if (d == null) {
                    d = new l(context);
                }
            }
        }
        return d;
    }

    public void b(m mVar, j jVar) throws Throwable {
        a(mVar, jVar, "POST");
    }

    public void a(m mVar, j jVar) throws Throwable {
        a(mVar, jVar, "GET");
    }

    public HttpURLConnection a(String str, String str2) {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(str);
            if (BaseConstants.SCHEME_HTTPS.equals(url.getProtocol())) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                a(httpsURLConnection);
                httpURLConnection = httpsURLConnection;
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            try {
                httpURLConnection.setRequestMethod(str2);
                httpURLConnection.setAllowUserInteraction(true);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setChunkedStreamingMode(0);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                if (!str2.equalsIgnoreCase("post")) {
                    return httpURLConnection;
                }
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                return httpURLConnection;
            } catch (Exception unused) {
                return httpURLConnection;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    private synchronized void a(HttpsURLConnection httpsURLConnection) {
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00f5 A[Catch: Exception -> 0x00fd, TryCatch #4 {Exception -> 0x00fd, blocks: (B:54:0x00f0, B:56:0x00f5, B:58:0x00fa), top: B:77:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00fa A[Catch: Exception -> 0x00fd, TRY_LEAVE, TryCatch #4 {Exception -> 0x00fd, blocks: (B:54:0x00f0, B:56:0x00f5, B:58:0x00fa), top: B:77:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(m mVar, j jVar, String str) throws Throwable {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        String string;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            HttpURLConnection httpURLConnectionA = a(mVar.f7486a, str);
            String strB = mVar.b();
            if (!TextUtils.isEmpty(strB) && httpURLConnectionA != null) {
                httpURLConnectionA.setRequestProperty("Cookie", strB);
            }
            String strC = mVar.c();
            if (!TextUtils.isEmpty(strC) && httpURLConnectionA != null) {
                httpURLConnectionA.setRequestProperty(com.umeng.analytics.pro.bd.f10871a, strC);
            }
            if (str.equalsIgnoreCase("post")) {
                byte[] bytes = mVar.a() != null ? mVar.a().toString().getBytes() : null;
                if (bytes != null && bytes.length > 0) {
                    httpURLConnectionA.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                    OutputStream outputStream = httpURLConnectionA.getOutputStream();
                    outputStream.write(bytes);
                    outputStream.flush();
                    outputStream.close();
                }
            }
            boolean z = false;
            if (httpURLConnectionA.getResponseCode() == 200) {
                inputStream2 = httpURLConnectionA.getInputStream();
                try {
                    try {
                        new h(e).b(df.d, httpURLConnectionA.getDate() - System.currentTimeMillis());
                        e.c("WeaponHttpTask --   date " + httpURLConnectionA.getDate() + " " + System.currentTimeMillis());
                    } catch (Exception unused) {
                    }
                    try {
                        byteArrayOutputStream2 = new ByteArrayOutputStream();
                    } catch (Exception unused2) {
                        byteArrayOutputStream2 = null;
                    }
                } catch (Throwable th) {
                    byteArrayOutputStream = null;
                    inputStream = inputStream2;
                    th = th;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused3) {
                            throw th;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (jVar != null) {
                        jVar.b(null);
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStream2.read(bArr);
                        if (i == -1) {
                            break;
                        } else {
                            byteArrayOutputStream2.write(bArr, 0, i);
                        }
                    }
                    z = true;
                    byteArrayOutputStream3 = byteArrayOutputStream2;
                    string = byteArrayOutputStream2.toString();
                } catch (Exception unused4) {
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception unused5) {
                            return;
                        }
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (jVar != null) {
                        jVar.b(null);
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    inputStream = inputStream2;
                    th = th2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (jVar != null) {
                    }
                    throw th;
                }
            } else {
                inputStream2 = null;
                string = null;
            }
            if (byteArrayOutputStream3 != null) {
                try {
                    byteArrayOutputStream3.close();
                } catch (Exception unused6) {
                    return;
                }
            }
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (z) {
                if (jVar != null) {
                    jVar.a(string);
                }
            } else if (jVar != null) {
                jVar.b(string);
            }
        } catch (Exception unused7) {
            inputStream2 = null;
            byteArrayOutputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            byteArrayOutputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e0 A[Catch: Exception -> 0x00e3, TRY_LEAVE, TryCatch #8 {Exception -> 0x00e3, blocks: (B:47:0x00db, B:49:0x00e0), top: B:72:0x00db }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(m mVar) throws Throwable {
        InputStream inputStream;
        InputStream inputStream2;
        ByteArrayOutputStream byteArrayOutputStream;
        String string;
        HttpURLConnection httpURLConnectionA;
        ByteArrayOutputStream byteArrayOutputStream2;
        byte[] bArr;
        boolean z = false;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            httpURLConnectionA = a(mVar.f7486a, "POST");
            String strB = mVar.b();
            if (!TextUtils.isEmpty(strB) && httpURLConnectionA != null) {
                httpURLConnectionA.setRequestProperty("Cookie", strB);
            }
            String strC = mVar.c();
            if (!TextUtils.isEmpty(strC) && httpURLConnectionA != null) {
                httpURLConnectionA.setRequestProperty(com.umeng.analytics.pro.bd.f10871a, strC);
            }
            byte[] bytes = mVar.a() != null ? mVar.a().toString().getBytes() : null;
            if (bytes != null && bytes.length > 0) {
                httpURLConnectionA.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                OutputStream outputStream = httpURLConnectionA.getOutputStream();
                outputStream.write(bytes);
                outputStream.flush();
                outputStream.close();
            }
        } catch (Exception unused) {
            inputStream2 = null;
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        if (httpURLConnectionA.getResponseCode() == 200) {
            inputStream2 = httpURLConnectionA.getInputStream();
            try {
                try {
                    new h(e).b(df.d, httpURLConnectionA.getDate() - System.currentTimeMillis());
                    e.c("WeaponHttpTask --   date " + httpURLConnectionA.getDate() + " " + System.currentTimeMillis());
                } catch (Exception unused2) {
                }
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception unused3) {
                    byteArrayOutputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                Throwable th3 = th;
                inputStream = inputStream2;
                th = th3;
                if (byteArrayOutputStream3 != null) {
                    try {
                        byteArrayOutputStream3.close();
                    } catch (Exception unused4) {
                        throw th;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
            try {
                bArr = new byte[1024];
            } catch (Exception unused5) {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused6) {
                        string = null;
                        if (z) {
                        }
                    }
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                string = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream3 = byteArrayOutputStream;
                Throwable th32 = th;
                inputStream = inputStream2;
                th = th32;
                if (byteArrayOutputStream3 != null) {
                }
                if (inputStream != null) {
                }
                throw th;
            }
            while (true) {
                int i = inputStream2.read(bArr);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
                if (z) {
                    return string;
                }
                return null;
            }
            byteArrayOutputStream2 = byteArrayOutputStream;
            string = byteArrayOutputStream.toString();
            z = true;
        } else {
            inputStream2 = null;
            string = null;
            byteArrayOutputStream2 = null;
        }
        if (byteArrayOutputStream2 != null) {
            try {
                byteArrayOutputStream2.close();
            } catch (Exception unused7) {
            }
        }
        if (inputStream2 != null) {
            inputStream2.close();
        }
        if (z) {
        }
    }

    public boolean a(String str, File file) {
        HttpURLConnection httpURLConnectionA;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        InputStream inputStreamA = null;
        try {
            httpURLConnectionA = a(str, "GET");
        } catch (Throwable unused) {
            httpURLConnectionA = null;
        }
        try {
            inputStreamA = a(httpURLConnectionA);
            boolean zA = a(inputStreamA, file);
            if (inputStreamA != null) {
                try {
                    inputStreamA.close();
                } catch (Throwable unused2) {
                    return false;
                }
            }
            if (httpURLConnectionA != null) {
                httpURLConnectionA.disconnect();
            }
            return zA;
        } catch (Throwable unused3) {
            if (inputStreamA != null) {
                try {
                    inputStreamA.close();
                } catch (Throwable unused4) {
                    return false;
                }
            }
            if (httpURLConnectionA != null) {
                httpURLConnectionA.disconnect();
            }
            return false;
        }
    }

    private InputStream a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return null;
        }
        try {
            if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                this.c = true;
            } else {
                this.c = false;
            }
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return null;
        }
    }

    private boolean a(InputStream inputStream, File file) {
        BufferedOutputStream bufferedOutputStream;
        if (this.c) {
            try {
                inputStream = new GZIPInputStream(inputStream);
            } catch (IOException unused) {
            }
        }
        if (inputStream == null) {
            return false;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i != -1) {
                        bufferedOutputStream.write(bArr, 0, i);
                        bufferedOutputStream.flush();
                    } else {
                        try {
                            bufferedOutputStream.close();
                            return true;
                        } catch (IOException unused2) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused3) {
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return false;
            }
        } catch (Throwable unused5) {
            bufferedOutputStream = null;
        }
    }

    public String a(Map<String, String> map) {
        String str = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str = str + ContainerUtils.FIELD_DELIMITER + entry.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + entry.getValue();
        }
        return str.substring(1);
    }
}
