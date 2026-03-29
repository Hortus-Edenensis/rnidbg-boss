package cn.fly.verify;

import com.oplus.tblplayer.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import kotlin.text.Typography;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class fl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f2353a = 0;
    public static int b = 0;
    private static boolean d = true;
    protected boolean c = d;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2355a;
        public int b;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Object f2356a;
        private String b;

        private b(String str) {
            try {
                this.b = str;
                Method declaredMethod = Class.forName(dx.a("033*feJb-bb[b;cadb2cdgLdbdfdfHe'dbcibhbedf<gUfaKbcbWcc-d7bhdj>bagBcbbhbi")).getDeclaredMethod(dx.a("011?ccCdgUcg[c5df<gbcad"), String.class);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(null, dx.a("0041edfgdefh"));
                Method method = objInvoke.getClass().getMethod(dx.a("004Qbg*cObg9g"), Class.forName(dx.a("0225feSbPbb(bAdbdfHda)bebhbgUg<bidbgaPd:bich>gAcbbh%d")));
                method.setAccessible(true);
                method.invoke(objInvoke, null);
                Method method2 = objInvoke.getClass().getMethod(dx.a("0165cc9dgTcibhbedfUg^faDbcb0ccTd5bhdf"), new Class[0]);
                method2.setAccessible(true);
                Object[] objArr = (Object[]) method2.invoke(objInvoke, new Object[0]);
                if (objArr == null || objArr.length == 0) {
                    throw new NoSuchAlgorithmException("no trust manager found.");
                }
                this.f2356a = objArr[0];
            } catch (Exception e) {
                en.a().a("failed to initialize the standard trust manager: " + e.getMessage(), new Object[0]);
                this.f2356a = null;
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            if (name.equals(dx.a("018afdaObjei9eRbgSdcgXcibhbedf+gd1ba"))) {
                return null;
            }
            try {
                if (!name.equals(dx.a("018afda%bjch=d3bhbb5dJbhcibhbedf@gdJba"))) {
                    if (name.equals(dx.a("0183ccPdgScjBaadhgdKbacgdfdfbe4d?bhdf"))) {
                        return Array.newInstance(Class.forName(dx.a("034Pfe(b<bbXb4dbdf6da=bebhbg>gEbidbWadZbhLgZdbedfgdefheiMd^bhFgQbgcdbgKabgd")), 0);
                    }
                    if (name.equals(dx.a("008fb<df]fNeicbba2d"))) {
                        return Integer.valueOf(hashCode());
                    }
                    if (name.equals("toString")) {
                        return toString();
                    }
                    return null;
                }
                Object[] objArr2 = (Object[]) objArr[0];
                String str = (String) objArr[1];
                if (objArr2 == null) {
                    throw new IllegalArgumentException("there were no certificates.");
                }
                if (objArr2.length == 1) {
                    Method declaredMethod = objArr2[0].getClass().getDeclaredMethod(dx.a("013afdaDbjehZbeNbgbabg6g2bi"), new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(objArr2[0], new Object[0]);
                    return null;
                }
                if (this.f2356a == null) {
                    throw new CertificateException("there were one more certificates but no trust manager found.");
                }
                Object objNewInstance = Class.forName("android.net.http.X509TrustManagerExtensions").getConstructor(Class.forName(dx.a("030$feOb_bbQb?cadbQcdg>dbdfdfTe=dbedfgdefhcibhbedfZg4faTbcbAccQd-bh"))).newInstance(this.f2356a);
                Method declaredMethod2 = objNewInstance.getClass().getDeclaredMethod(dx.a("018afda!bjchBd6bhbbYdNbhcibhbedf8gdNba"), Array.newInstance(Class.forName(dx.a("034Yfe b:bb;b;dbdf%daJbebhbgDgHbidb3ad-bhYg!dbedfgdefheiKdNbhMg@bgcdbgNabgd")), 0).getClass(), String.class, String.class);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(objNewInstance, objArr2, str, this.b);
                return null;
            } catch (Throwable th) {
                en.a().c(th);
                return null;
            }
        }
    }

    public static Object a(String str) throws Throwable {
        Class<?> cls = Class.forName(dx.a("030<fe[b!bbJbCcadb3cdgCdbdfdfZe)dbedfgdefhcibhbedfZg0faPbcbGccTd!bh"));
        return Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{cls}, new b(str));
    }

    public String b(String str, HashMap<String, Object> map, HashMap<String, String> map2, a aVar) throws Throwable {
        InputStream inputStream;
        OutputStream outputStream;
        Throwable th;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        InputStreamReader inputStreamReader2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        en.a().a("hpt: " + str + "\nhd: " + map2, new Object[0]);
        HttpURLConnection httpURLConnectionA = a(str, aVar);
        httpURLConnectionA.setDoOutput(true);
        a(httpURLConnectionA, map2);
        httpURLConnectionA.setRequestProperty(dx.a("010Ceicb*ccdagTbgcb;c"), HTTP.CONN_KEEP_ALIVE);
        httpURLConnectionA.setRequestProperty("Content-Type", dx.a("033bhhe)bgEabgJbgcbYcj-cafiddddddficdcbbhbdfibebhBedcaOcbba+dUba"));
        fo foVar = new fo();
        if (map != null) {
            foVar.a(a(map));
        }
        httpURLConnectionA.setFixedLengthStreamingMode((int) foVar.b());
        httpURLConnectionA.setInstanceFollowRedirects(this.c);
        httpURLConnectionA.connect();
        try {
            outputStream = httpURLConnectionA.getOutputStream();
            try {
                InputStream inputStreamC = foVar.c();
                try {
                    byte[] bArr = new byte[65536];
                    while (true) {
                        int i = inputStreamC.read(bArr);
                        if (i <= 0) {
                            break;
                        }
                        outputStream.write(bArr, 0, i);
                    }
                    outputStream.flush();
                    int responseCode = httpURLConnectionA.getResponseCode();
                    if (responseCode == 200 || responseCode < 300) {
                        StringBuilder sb = new StringBuilder();
                        try {
                            InputStreamReader inputStreamReader3 = new InputStreamReader(httpURLConnectionA.getInputStream(), Charset.forName("utf-8"));
                            try {
                                BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader3);
                                while (true) {
                                    try {
                                        String line = bufferedReader3.readLine();
                                        if (line == null) {
                                            eg.a(bufferedReader3, inputStreamReader3);
                                            String string = sb.toString();
                                            httpURLConnectionA.disconnect();
                                            eg.a(inputStreamC, outputStream);
                                            en.a().a("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                                            return string;
                                        }
                                        if (sb.length() > 0) {
                                            sb.append('\n');
                                        }
                                        sb.append(line);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        inputStreamReader = inputStreamReader3;
                                        bufferedReader = bufferedReader3;
                                        eg.a(bufferedReader, inputStreamReader);
                                        throw th;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                inputStreamReader = inputStreamReader3;
                                bufferedReader = null;
                                eg.a(bufferedReader, inputStreamReader);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            inputStreamReader = null;
                        }
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        try {
                            inputStreamReader2 = new InputStreamReader(httpURLConnectionA.getErrorStream(), Charset.forName("utf-8"));
                            try {
                                bufferedReader2 = new BufferedReader(inputStreamReader2);
                                while (true) {
                                    try {
                                        String line2 = bufferedReader2.readLine();
                                        if (line2 == null) {
                                            eg.a(bufferedReader2, inputStreamReader2);
                                            HashMap map3 = new HashMap();
                                            map3.put(dx.a("005dUbhbhcbbh"), sb2.toString());
                                            map3.put(dx.a("006GdfEgbg8bedf"), Integer.valueOf(responseCode));
                                            throw new Throwable(fv.a(map3));
                                        }
                                        if (sb2.length() > 0) {
                                            sb2.append('\n');
                                        }
                                        sb2.append(line2);
                                    } catch (Throwable th5) {
                                        th = th5;
                                        eg.a(bufferedReader2, inputStreamReader2);
                                        throw th;
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                bufferedReader2 = null;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            bufferedReader2 = null;
                            inputStreamReader2 = null;
                        }
                    }
                } catch (Throwable th8) {
                    th = th8;
                    inputStream = inputStreamC;
                    httpURLConnectionA.disconnect();
                    eg.a(inputStream, outputStream);
                    en.a().a("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                    throw th;
                }
            } catch (Throwable th9) {
                th = th9;
                inputStream = null;
            }
        } catch (Throwable th10) {
            th = th10;
            inputStream = null;
            outputStream = null;
        }
    }

    public String a(String str, HashMap<String, Object> map, HashMap<String, String> map2) throws Throwable {
        a aVar = new a();
        aVar.f2355a = 30000;
        aVar.b = 10000;
        return a(str, map, map2, aVar);
    }

    public String a(String str, HashMap<String, Object> map, HashMap<String, String> map2, a aVar) throws Throwable {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        en.a().a(String.format("hgt: %s", str) + "\n" + String.format("hd: %s", map2), new Object[0]);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (map != null) {
            String strA = a(map);
            if (strA.length() > 0) {
                str = str + Constants.STRING_VALUE_UNSET + strA;
            }
        }
        HttpURLConnection httpURLConnectionA = a(str, aVar);
        a(httpURLConnectionA, map2);
        httpURLConnectionA.setInstanceFollowRedirects(this.c);
        httpURLConnectionA.connect();
        int responseCode = httpURLConnectionA.getResponseCode();
        BufferedReader bufferedReader = null;
        if (responseCode == 200) {
            StringBuilder sb = new StringBuilder();
            try {
                inputStreamReader2 = new InputStreamReader(httpURLConnectionA.getInputStream(), Charset.forName("utf-8"));
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);
                    while (true) {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                eg.a(bufferedReader2, inputStreamReader2);
                                httpURLConnectionA.disconnect();
                                String string = sb.toString();
                                en.a().a("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                                return string;
                            }
                            if (sb.length() > 0) {
                                sb.append('\n');
                            }
                            sb.append(line);
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            eg.a(bufferedReader, inputStreamReader2);
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader2 = null;
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            try {
                inputStreamReader = new InputStreamReader(httpURLConnectionA.getErrorStream(), Charset.forName("utf-8"));
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            String line2 = bufferedReader3.readLine();
                            if (line2 == null) {
                                eg.a(bufferedReader3, inputStreamReader);
                                httpURLConnectionA.disconnect();
                                HashMap map3 = new HashMap();
                                map3.put(dx.a("005dAbhbhcbbh"), sb2.toString());
                                map3.put(dx.a("006Ldf3gbgJbedf"), Integer.valueOf(responseCode));
                                throw new Throwable(fv.a(map3));
                            }
                            if (sb2.length() > 0) {
                                sb2.append('\n');
                            }
                            sb2.append(line2);
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedReader = bufferedReader3;
                            eg.a(bufferedReader, inputStreamReader);
                            throw th;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Throwable th6) {
                th = th6;
                inputStreamReader = null;
            }
        }
    }

    private String a(HashMap<String, Object> map) throws Throwable {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String strC = fr.c(entry.getKey(), "utf-8");
            String strC2 = entry.getValue() == null ? "" : fr.c(String.valueOf(entry.getValue()), "utf-8");
            if (sb.length() > 0) {
                sb.append(Typography.amp);
            }
            sb.append(strC);
            sb.append('=');
            sb.append(strC2);
        }
        return sb.toString();
    }

    private HttpURLConnection a(String str, a aVar) throws Throwable {
        Object objC;
        boolean z;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        String strA = dx.a("012*bdUdgfPcbbacicbbj[dc>df");
        try {
            objC = fy.a(httpURLConnection, strA);
        } catch (Throwable unused) {
            objC = null;
        }
        if (objC == null) {
            strA = "PERMITTED_USER_METHODS";
            try {
                objC = fy.c("HttpURLConnection", "PERMITTED_USER_METHODS");
            } catch (Throwable unused2) {
            }
            z = true;
        } else {
            z = false;
        }
        if (objC != null) {
            String[] strArr = (String[]) objC;
            String[] strArr2 = new String[strArr.length + 1];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            strArr2[strArr.length] = dx.a("005Cejcjcieidh");
            if (z) {
                fy.a("HttpURLConnection", strA, (Object) strArr2);
            } else {
                fy.b(httpURLConnection, strA, strArr2);
            }
        }
        System.setProperty("http.keepAlive", com.huawei.hms.ads.ex.V);
        if (httpURLConnection instanceof HttpsURLConnection) {
            X509HostnameVerifier x509HostnameVerifier = SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            SSLContext sSLContext = SSLContext.getInstance(dx.a("003Bcidach"));
            TrustManager[] trustManagerArr = new TrustManager[0];
            try {
                trustManagerArr = new TrustManager[]{(TrustManager) a(httpsURLConnection.getURL().getHost())};
            } catch (Throwable th) {
                en.a().c(th);
            }
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(x509HostnameVerifier);
        }
        int i = aVar == null ? f2353a : aVar.b;
        if (i > 0) {
            httpURLConnection.setConnectTimeout(i);
        }
        int i2 = aVar == null ? b : aVar.f2355a;
        if (i2 > 0) {
            httpURLConnection.setReadTimeout(i2);
        }
        return httpURLConnection;
    }

    public void a(String str, fn fnVar, a aVar) throws Throwable {
        a(str, new HashMap<>(), fnVar, aVar);
    }

    public void a(String str, final OutputStream outputStream, a aVar) throws Throwable {
        final byte[] bArr = new byte[1024];
        a(str, new fn() { // from class: cn.fly.verify.fl.1
            @Override // cn.fly.verify.fn
            public void a(InputStream inputStream) throws Throwable {
                int i = inputStream.read(bArr);
                while (i != -1) {
                    outputStream.write(bArr, 0, i);
                    i = inputStream.read(bArr);
                }
            }
        }, aVar);
        outputStream.flush();
    }

    public void a(String str, HashMap<String, String> map, fg fgVar, int i, fj fjVar, a aVar) throws Throwable {
        OutputStream outputStream;
        long jCurrentTimeMillis = System.currentTimeMillis();
        en.a().a("hptr: " + str, new Object[0]);
        HttpURLConnection httpURLConnectionA = a(str, aVar);
        httpURLConnectionA.setDoOutput(true);
        if (i >= 0) {
            httpURLConnectionA.setChunkedStreamingMode(0);
        }
        a(httpURLConnectionA, map);
        httpURLConnectionA.setInstanceFollowRedirects(this.c);
        httpURLConnectionA.connect();
        InputStream inputStreamC = null;
        try {
            outputStream = httpURLConnectionA.getOutputStream();
            try {
                inputStreamC = fgVar.c();
                byte[] bArr = new byte[65536];
                while (true) {
                    int i2 = inputStreamC.read(bArr);
                    if (i2 <= 0) {
                        break;
                    } else {
                        outputStream.write(bArr, 0, i2);
                    }
                }
                outputStream.flush();
                eg.a(inputStreamC, outputStream);
                if (fjVar != null) {
                    try {
                        fjVar.a(new fi(httpURLConnectionA));
                    } finally {
                    }
                }
                httpURLConnectionA.disconnect();
                en.a().a("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
            } catch (Throwable th) {
                th = th;
                eg.a(inputStreamC, outputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
        }
    }

    public void a(String str, HashMap<String, String> map, fn fnVar, a aVar) throws Throwable {
        InputStreamReader inputStreamReader;
        long jCurrentTimeMillis = System.currentTimeMillis();
        en.a().a("rawGet: " + str, new Object[0]);
        HttpURLConnection httpURLConnectionA = a(str, aVar);
        a(httpURLConnectionA, map);
        httpURLConnectionA.setInstanceFollowRedirects(this.c);
        httpURLConnectionA.connect();
        int responseCode = httpURLConnectionA.getResponseCode();
        if (responseCode == 200) {
            if (fnVar != null) {
                InputStream inputStream = httpURLConnectionA.getInputStream();
                try {
                    fnVar.a(inputStream);
                    eg.a(inputStream);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        eg.a(inputStream);
                        httpURLConnectionA.disconnect();
                        throw th2;
                    }
                }
            }
            httpURLConnectionA.disconnect();
            en.a().a("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
            return;
        }
        if (a(httpURLConnectionA)) {
            a(httpURLConnectionA.getHeaderField(dx.a("008Adacb0abgJbgcb0c")), new HashMap<>(), fnVar, aVar);
            return;
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            inputStreamReader = new InputStreamReader(httpURLConnectionA.getErrorStream(), Charset.forName("utf-8"));
            try {
                BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            eg.a(bufferedReader2, inputStreamReader);
                            httpURLConnectionA.disconnect();
                            HashMap map2 = new HashMap();
                            map2.put(dx.a("005dSbhbhcbbh"), sb.toString());
                            map2.put(dx.a("006>dfBgbgWbedf"), Integer.valueOf(responseCode));
                            throw new Throwable(fv.a(map2));
                        }
                        if (sb.length() > 0) {
                            sb.append('\n');
                        }
                        sb.append(line);
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = bufferedReader2;
                        eg.a(bufferedReader, inputStreamReader);
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStreamReader = null;
        }
    }

    /* JADX WARN: Finally extract failed */
    public void a(String str, byte[] bArr, HashMap<String, String> map, int i, fj fjVar, a aVar) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutputStream dataOutputStream;
        byte[] bytes;
        long jCurrentTimeMillis = System.currentTimeMillis();
        en.a().a("hpt: " + str, new Object[0]);
        HttpURLConnection httpURLConnectionA = a(str, aVar);
        httpURLConnectionA.setDoOutput(true);
        if (i >= 0) {
            httpURLConnectionA.setChunkedStreamingMode(0);
        }
        a(httpURLConnectionA, map);
        httpURLConnectionA.setRequestProperty(dx.a("010 eicb3ccdagAbgcbTc"), HTTP.CONN_KEEP_ALIVE);
        httpURLConnectionA.setRequestProperty("Content-Type", "application/octet-stream");
        httpURLConnectionA.setInstanceFollowRedirects(this.c);
        httpURLConnectionA.connect();
        try {
            outputStream = httpURLConnectionA.getOutputStream();
            try {
                String strA = ef.a();
                if (strA == null) {
                    strA = "";
                }
                bytes = strA.getBytes("utf-8");
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th) {
                th = th;
                byteArrayInputStream = null;
                byteArrayOutputStream = null;
                dataOutputStream = null;
                httpURLConnectionA.disconnect();
                eg.a(byteArrayInputStream, outputStream, dataOutputStream, byteArrayOutputStream);
                en.a().a("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayInputStream = null;
            outputStream = null;
        }
        try {
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeInt(bytes.length);
                dataOutputStream.write(bytes);
                dataOutputStream.write(bArr);
                dataOutputStream.flush();
                byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                try {
                    byte[] bArr2 = new byte[65536];
                    for (int i2 = byteArrayInputStream.read(bArr2); i2 > 0; i2 = byteArrayInputStream.read(bArr2)) {
                        outputStream.write(bArr2, 0, i2);
                    }
                    outputStream.flush();
                    if (fjVar != null) {
                        try {
                            fjVar.a(new fi(httpURLConnectionA));
                        } finally {
                        }
                    }
                    httpURLConnectionA.disconnect();
                    httpURLConnectionA.disconnect();
                    eg.a(byteArrayInputStream, outputStream, dataOutputStream, byteArrayOutputStream);
                    en.a().a("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnectionA.disconnect();
                    eg.a(byteArrayInputStream, outputStream, dataOutputStream, byteArrayOutputStream);
                    en.a().a("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                byteArrayInputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            byteArrayInputStream = null;
            dataOutputStream = null;
            httpURLConnectionA.disconnect();
            eg.a(byteArrayInputStream, outputStream, dataOutputStream, byteArrayOutputStream);
            en.a().a("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
            throw th;
        }
    }

    private void a(URLConnection uRLConnection, HashMap<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            uRLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private static boolean a(HttpURLConnection httpURLConnection) {
        try {
            if (httpURLConnection.getResponseCode() != 301 && httpURLConnection.getResponseCode() != 302 && httpURLConnection.getResponseCode() != 304 && httpURLConnection.getResponseCode() != 307) {
                if (httpURLConnection.getResponseCode() != 308) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            en.a().a(th);
            return false;
        }
    }
}
