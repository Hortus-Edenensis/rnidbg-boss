package com.amap.api.col.p0002sl;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.p0002sl.fs;
import com.amap.api.col.p0002sl.hx;
import com.amap.api.col.p0002sl.id;
import com.amap.api.maps2d.AMapException;
import com.huawei.hms.framework.common.ContainerUtils;
import com.igexin.push.g.o;
import com.oplus.tblplayer.Constants;
import defpackage.w;
import j$.util.Objects;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.lang.ref.SoftReference;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSession;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ia {
    private static SoftReference<SSLContext> k;
    private static SoftReference<ib> t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2890a;
    private SSLContext b;
    private Proxy c;
    private String g;
    private hx.a h;
    private d i;
    private boolean l;
    private String m;
    private String n;
    private volatile boolean d = false;
    private long e = -1;
    private long f = 0;
    private String j = "";
    private boolean o = false;
    private boolean p = false;
    private String q = "";
    private String r = "";
    private String s = "";
    private f u = new f();

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Cloneable, Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2891a;
        public String b;
        public String c;
        public String d;
        public String e;
        public int f;
        public int g;
        public int h;
        public long i;
        public volatile AtomicInteger j = new AtomicInteger(1);

        public a(c cVar) {
            this.b = cVar.c;
            this.c = cVar.e;
            this.e = cVar.d;
            this.f = cVar.m;
            this.g = cVar.n;
            this.h = cVar.b.a();
            this.d = cVar.f2893a;
            this.i = cVar.f;
            if (this.f == 10) {
                this.f2891a = 0;
            }
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a clone() {
            try {
                return (a) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        public final String b() {
            String str;
            String str2;
            String str3;
            String str4;
            try {
                String str5 = this.f + "#";
                if (TextUtils.isEmpty(this.e)) {
                    str = str5 + "-#";
                } else {
                    str = str5 + this.e + "#";
                }
                String str6 = (str + this.h + "#") + this.j + "#";
                if (TextUtils.isEmpty(this.b)) {
                    str2 = str6 + "-#";
                } else {
                    str2 = str6 + this.b + "#";
                }
                if (this.f == 1) {
                    str3 = str2 + this.d + "#";
                } else {
                    str3 = str2 + "-#";
                }
                if (this.f == 1) {
                    str4 = str3 + this.i + "#";
                } else {
                    str4 = str3 + "-#";
                }
                String strB = fw.b(ht.a(((str4 + this.c + "#") + this.g).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                ia.a();
                return strB;
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return this.f2891a - ((a) obj).f2891a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HttpURLConnection f2892a;
        public int b = this.b;
        public int b = this.b;

        public b(HttpURLConnection httpURLConnection) {
            this.f2892a = httpURLConnection;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements Cloneable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2893a = "";
        public id.b b = id.b.FIRST_NONDEGRADE;
        public String c = "";
        public String d = "";
        public String e = "";
        public long f = 0;
        public long g = 0;
        public long h = 0;
        public long i = 0;
        public long j = 0;
        public String k = "-";
        public String l = "-";
        public int m = 0;
        public int n = 0;

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c clone() {
            try {
                return (c) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        public final String b() {
            String str;
            String str2;
            if (TextUtils.isEmpty(this.c)) {
                str = "-#";
            } else {
                str = this.c + "#";
            }
            if (TextUtils.isEmpty(this.d)) {
                str2 = str + "-#";
            } else {
                str2 = str + this.d + "#";
            }
            String strB = fw.b(ht.a(((((str2 + this.b.a() + "#") + this.h + "#") + this.j + "#") + this.f).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
            ia.a();
            return strB;
        }

        public final String toString() {
            return "RequestInfo{csid='" + this.f2893a + "', degradeType=" + this.b + ", serverIp='" + this.c + "', path='" + this.d + "', hostname='" + this.e + "', totalTime=" + this.f + ", DNSTime=" + this.g + ", connectionTime=" + this.h + ", writeTime=" + this.i + ", readTime=" + this.j + ", serverTime='" + this.k + "', datasize='" + this.l + "', errorcode=" + this.m + ", errorcodeSub=" + this.n + '}';
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f2896a = 0;
        long b = 0;
        c c = new c();
        a d;
        c e;
        String f;
        URL g;

        public f() {
        }

        public final void a(id idVar, URL url) {
            this.g = url;
            this.c.d = url.getPath();
            this.c.e = url.getHost();
            if (!TextUtils.isEmpty(ia.this.n) && idVar.w().b()) {
                c cVar = this.c;
                cVar.c = cVar.e.replace("[", "").replace("]", "");
                this.c.e = ia.this.n;
            }
            if (idVar.w().b()) {
                idVar.d(this.c.e);
            }
            if (idVar.w().d()) {
                this.f = idVar.z();
            }
        }

        public final void b() {
            this.c.i = SystemClock.elapsedRealtime() - this.b;
        }

        public final void c() {
            this.c.j = SystemClock.elapsedRealtime() - this.b;
        }

        public final void d() {
            c cVarClone = this.c.clone();
            if (this.c.f > fs.e) {
                cVarClone.m = 1;
            }
            fs.a(cVarClone);
        }

        public final void b(int i) {
            this.c.n = i;
        }

        public final void a() {
            this.c.h = SystemClock.elapsedRealtime() - this.b;
        }

        public final void a(ie ieVar) {
            c cVarClone;
            try {
                this.c.f = SystemClock.elapsedRealtime() - this.f2896a;
                if (ieVar != null) {
                    ieVar.f = this.c.b.c();
                }
                if (this.c.b.b()) {
                    c cVar = this.c;
                    if (cVar.f > 10000) {
                        fs.a(false, cVar.e);
                    }
                }
                if (this.c.b.d()) {
                    fs.a(false, this.f);
                }
                boolean zB = ia.this.b(this.c.e);
                if (zB) {
                    fs.c(this.c);
                    fs.a(true, this.d);
                    c cVar2 = this.c;
                    if (cVar2.f > fs.e && (cVarClone = cVar2.clone()) != null) {
                        cVarClone.m = 1;
                        fs.b(cVarClone);
                        cVarClone.toString();
                        ia.a();
                    }
                }
                fs.a(this.g.toString(), this.c.b.c(), false, zB);
                this.c.toString();
                ia.a();
            } catch (Throwable unused) {
            }
        }

        public final void a(int i) {
            "----errorcode-----".concat(String.valueOf(i));
            ia.a();
            try {
                this.c.f = SystemClock.elapsedRealtime() - this.f2896a;
                c cVar = this.c;
                cVar.m = i;
                if (cVar.b.e()) {
                    fs.a(false, this.c.e);
                }
                boolean zB = ia.this.b(this.c.e);
                if (zB) {
                    if (ia.this.p && !TextUtils.isEmpty(ia.this.n) && this.c.b.b()) {
                        fs.d();
                    }
                    if (this.c.b.c()) {
                        fs.a(this.c.b.c(), this.c.e);
                    }
                    fs.c(this.e);
                    fs.a(false, this.d);
                    fs.b(this.c);
                }
                fs.a(this.g.toString(), this.c.b.c(), true, zB);
                this.c.toString();
                ia.a();
            } catch (Throwable unused) {
            }
        }

        public final void a(long j) {
            this.c.l = new DecimalFormat("0.00").format(j / 1024.0f);
        }
    }

    public ia() {
        fs.e();
        try {
            this.g = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            ha.a(th, "ht", "ic");
        }
    }

    public static void a() {
    }

    private void c(id idVar) throws fq {
        this.i = new d((byte) 0);
        this.p = idVar.A();
        this.c = idVar.q();
        this.h = idVar.v();
        this.l = idVar.s();
        this.j = idVar.B();
        this.f2890a = fx.a().b(idVar.u());
        String strO = idVar.w().b() ? idVar.o() : idVar.n();
        this.m = strO;
        String strA = a(strO);
        this.m = strA;
        String strA2 = hz.a(strA, this.j);
        this.m = strA2;
        "restrictionURLTest: ".concat(String.valueOf(strA2));
        if (Cif.a().a(strA2)) {
            "restriction hit: ".concat(String.valueOf(strA2));
            throw new fq("限制访问的接口");
        }
        this.n = idVar.j();
        if ("loc".equals(this.j)) {
            String strN = idVar.n();
            String strO2 = idVar.o();
            if (!TextUtils.isEmpty(strN)) {
                try {
                    this.r = new URL(strN).getHost();
                } catch (Exception unused) {
                }
            }
            if (TextUtils.isEmpty(strO2)) {
                return;
            }
            try {
                if (TextUtils.isEmpty(this.n)) {
                    this.q = new URL(strO2).getHost();
                } else {
                    this.q = this.n;
                }
            } catch (Exception unused2) {
            }
        }
    }

    public final ie b(id idVar) throws fq {
        DataOutputStream dataOutputStream;
        Throwable th;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                c(idVar);
                ie ieVarB = hz.b(this.m, this.j);
                if (ieVarB != null) {
                    this.u.d();
                    return ieVarB;
                }
                b bVarA = a(idVar, true);
                HttpURLConnection httpURLConnection2 = bVarA.f2892a;
                try {
                    this.u.b = SystemClock.elapsedRealtime();
                    httpURLConnection2.connect();
                    this.u.a();
                    byte[] bArrH = idVar.h();
                    if (bArrH == null || bArrH.length == 0) {
                        Map<String, String> mapE = idVar.e();
                        HashMap<String, String> map = hx.e;
                        if (map != null) {
                            if (mapE != null) {
                                mapE.putAll(map);
                            } else {
                                mapE = map;
                            }
                        }
                        String strA = a(mapE);
                        if (!TextUtils.isEmpty(strA)) {
                            bArrH = ge.a(strA);
                        }
                    }
                    if (bArrH != null && bArrH.length > 0) {
                        try {
                            this.u.b = SystemClock.elapsedRealtime();
                            outputStream = httpURLConnection2.getOutputStream();
                            try {
                                dataOutputStream = new DataOutputStream(outputStream);
                                try {
                                    dataOutputStream.write(bArrH);
                                    dataOutputStream.close();
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    this.u.b();
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (dataOutputStream != null) {
                                        dataOutputStream.close();
                                    }
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    this.u.b();
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                dataOutputStream = null;
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            dataOutputStream = null;
                            th = th4;
                            outputStream = null;
                        }
                    }
                    ie ieVarA = a(bVarA);
                    this.u.a(ieVarA);
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Throwable th5) {
                        ha.a(th5, "ht", "mPt");
                    }
                    this.u.d();
                    return ieVarA;
                } catch (fq e2) {
                    e = e2;
                } catch (InterruptedIOException unused) {
                    this.u.b(7101);
                    this.u.a(7);
                    throw new fq(AMapException.ERROR_UNKNOWN);
                } catch (ConnectException e3) {
                    e = e3;
                    e.printStackTrace();
                    this.u.b(a(e));
                    this.u.a(6);
                    throw new fq(AMapException.ERROR_CONNECTION);
                } catch (MalformedURLException e4) {
                    e = e4;
                    e.printStackTrace();
                    this.u.a(8);
                    throw new fq("url异常 - MalformedURLException");
                } catch (SocketException e5) {
                    e = e5;
                    e.printStackTrace();
                    this.u.b(a(e));
                    this.u.a(6);
                    throw new fq(AMapException.ERROR_SOCKET);
                } catch (SocketTimeoutException e6) {
                    e = e6;
                    e.printStackTrace();
                    this.u.b(a(e));
                    this.u.a(2);
                    throw new fq("socket 连接超时 - SocketTimeoutException");
                } catch (UnknownHostException e7) {
                    e = e7;
                    e.printStackTrace();
                    this.u.a(5);
                    throw new fq("未知主机 - UnKnowHostException");
                } catch (SSLException e8) {
                    e = e8;
                    e.printStackTrace();
                    this.u.b(a(e));
                    this.u.a(4);
                    throw new fq("IO 操作异常 - IOException");
                } catch (ConnectTimeoutException e9) {
                    e = e9;
                    e.printStackTrace();
                    this.u.b(a(e));
                    this.u.a(2);
                    throw new fq("IO 操作异常 - IOException");
                } catch (IOException e10) {
                    e = e10;
                    e.printStackTrace();
                    this.u.a(7);
                    throw new fq("IO 操作异常 - IOException");
                } catch (Throwable th6) {
                    th = th6;
                    ha.a(th, "ht", "mPt");
                    this.u.a(9);
                    throw new fq(AMapException.ERROR_UNKNOWN);
                }
            } catch (Throwable th7) {
                if (0 != 0) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th8) {
                        ha.a(th8, "ht", "mPt");
                    }
                }
                this.u.d();
                throw th7;
            }
        } catch (fq e11) {
            e = e11;
        } catch (InterruptedIOException unused2) {
        } catch (ConnectException e12) {
            e = e12;
        } catch (MalformedURLException e13) {
            e = e13;
        } catch (SocketException e14) {
            e = e14;
        } catch (SocketTimeoutException e15) {
            e = e15;
        } catch (UnknownHostException e16) {
            e = e16;
        } catch (SSLException e17) {
            e = e17;
        } catch (ConnectTimeoutException e18) {
            e = e18;
        } catch (IOException e19) {
            e = e19;
        } catch (Throwable th9) {
            th = th9;
        }
        if (!e.i() && e.g() != 10) {
            this.u.a(e.g());
        }
        ha.a(e, "ht", "mPt");
        throw e;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Vector<e> f2894a;
        private volatile e b;

        private d() {
            this.f2894a = new Vector<>();
            this.b = new e((byte) 0);
        }

        public final e a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.b;
            }
            byte b = 0;
            for (int i = 0; i < this.f2894a.size(); i++) {
                e eVar = this.f2894a.get(i);
                if (eVar != null && eVar.a().equals(str)) {
                    return eVar;
                }
            }
            e eVar2 = new e(b);
            eVar2.b(str);
            this.f2894a.add(eVar2);
            return eVar2;
        }

        public /* synthetic */ d(byte b) {
            this();
        }
    }

    private static String a(String str) {
        w.b();
        return str;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e implements HostnameVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f2895a;
        private String b;

        private e() {
        }

        public /* synthetic */ e(byte b) {
            this();
        }

        public final void a(String str) {
            String[] strArrSplit;
            if (TextUtils.isEmpty(this.f2895a) || !str.contains(":") || (strArrSplit = str.split(":")) == null || strArrSplit.length <= 0) {
                this.f2895a = str;
            } else {
                this.f2895a = strArrSplit[0];
            }
        }

        public final void b(String str) {
            this.b = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            return !TextUtils.isEmpty(this.f2895a) ? this.f2895a.equals(str) : !TextUtils.isEmpty(this.b) ? defaultHostnameVerifier.verify(this.b, sSLSession) : defaultHostnameVerifier.verify(str, sSLSession);
        }

        public final String a() {
            return this.b;
        }
    }

    private static String a(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap<String, String> map2 = hx.e;
        if (map2 != null) {
            if (map != null) {
                map.putAll(map2);
            } else {
                map = map2;
            }
        }
        if (map == null || map.size() <= 0) {
            return str;
        }
        int iIndexOf = str.indexOf(Constants.STRING_VALUE_UNSET);
        if (iIndexOf >= 0) {
            HashMap map3 = new HashMap();
            String strSubstring = str.substring(iIndexOf);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                if (!strSubstring.matches(".*[\\?\\&]" + URLEncoder.encode(key) + "=.*")) {
                    map3.put(key, value);
                }
            }
            map = map3;
        }
        if (map.size() == 0) {
            return str;
        }
        String strA = a(map);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (iIndexOf >= 0) {
            if (!str.endsWith(Constants.STRING_VALUE_UNSET) && !str.endsWith(ContainerUtils.FIELD_DELIMITER)) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
        } else {
            stringBuffer.append(Constants.STRING_VALUE_UNSET);
        }
        if (strA != null) {
            stringBuffer.append(strA);
        }
        return stringBuffer.toString();
    }

    private static boolean c(String str) {
        return str.contains("rest") || str.contains("apilocate");
    }

    public final ie a(id idVar) throws fq {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        try {
                                            c(idVar);
                                            String strA = a(this.m, idVar.e());
                                            this.m = strA;
                                            ie ieVarB = hz.b(strA, this.j);
                                            if (ieVarB != null) {
                                                this.u.d();
                                                return ieVarB;
                                            }
                                            b bVarA = a(idVar, false);
                                            httpURLConnection = bVarA.f2892a;
                                            this.u.b = SystemClock.elapsedRealtime();
                                            httpURLConnection.connect();
                                            this.u.a();
                                            ie ieVarA = a(bVarA);
                                            this.u.a(ieVarA);
                                            try {
                                                httpURLConnection.disconnect();
                                            } catch (Throwable th) {
                                                ha.a(th, "ht", "mgr");
                                            }
                                            this.u.d();
                                            return ieVarA;
                                        } catch (SocketException e2) {
                                            this.u.b(a(e2));
                                            this.u.a(6);
                                            throw new fq(AMapException.ERROR_SOCKET);
                                        }
                                    } catch (fq e3) {
                                        if (!e3.i() && e3.g() != 10) {
                                            this.u.a(e3.f());
                                        }
                                        throw e3;
                                    }
                                } catch (MalformedURLException unused) {
                                    this.u.a(8);
                                    throw new fq("url异常 - MalformedURLException");
                                }
                            } catch (IOException unused2) {
                                this.u.a(7);
                                throw new fq("IO 操作异常 - IOException");
                            }
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            this.u.a(9);
                            throw new fq(AMapException.ERROR_UNKNOWN);
                        }
                    } catch (SocketTimeoutException e4) {
                        this.u.b(a(e4));
                        this.u.a(2);
                        throw new fq("socket 连接超时 - SocketTimeoutException");
                    } catch (ConnectTimeoutException e5) {
                        e5.printStackTrace();
                        this.u.b(a(e5));
                        this.u.a(2);
                        throw new fq("IO 操作异常 - IOException");
                    }
                } catch (ConnectException e6) {
                    this.u.b(a(e6));
                    this.u.a(6);
                    throw new fq(AMapException.ERROR_CONNECTION);
                } catch (UnknownHostException unused3) {
                    this.u.a(9);
                    throw new fq("未知主机 - UnKnowHostException");
                }
            } catch (InterruptedIOException unused4) {
                this.u.b(7101);
                this.u.a(7);
                throw new fq(AMapException.ERROR_UNKNOWN);
            } catch (SSLException e7) {
                e7.printStackTrace();
                this.u.b(a(e7));
                this.u.a(4);
                throw new fq("IO 操作异常 - IOException");
            }
        } catch (Throwable th3) {
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th4) {
                    ha.a(th4, "ht", "mgr");
                }
            }
            this.u.d();
            throw th3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0140 A[Catch: all -> 0x01ae, TryCatch #2 {all -> 0x01ae, blocks: (B:44:0x00cb, B:47:0x00e3, B:49:0x00e6, B:51:0x00ea, B:53:0x00f0, B:57:0x00f9, B:60:0x0105, B:62:0x0108, B:64:0x010e, B:74:0x013a, B:76:0x0140, B:78:0x014a, B:80:0x015b, B:82:0x0183, B:84:0x01a4, B:85:0x01a7, B:65:0x0124, B:67:0x0128, B:69:0x012b, B:71:0x0131, B:72:0x0136), top: B:141:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private b a(id idVar, boolean z) throws fq, IOException {
        String str;
        boolean z2;
        URL url;
        URLConnection uRLConnectionA;
        ib ibVarB;
        SoftReference<SSLContext> softReference;
        HttpURLConnection httpURLConnection;
        id.b bVarW;
        String str2;
        String hostAddress;
        f fVar = this.u;
        id.b bVarW2 = idVar.w();
        c cVar = fVar.c;
        cVar.f2893a = ia.this.g;
        cVar.b = bVarW2;
        fVar.f2896a = SystemClock.elapsedRealtime();
        Map<String, String> mapD = idVar.d();
        if (mapD == null) {
            mapD = new HashMap<>();
        }
        e eVarA = this.i.a(this.n);
        int i = hx.f2880a;
        String string = this.m;
        Uri uri = Uri.parse(string);
        String host = uri.getHost();
        if (i == 1) {
            str = hx.b;
        } else {
            if (i == 2) {
                HashMap<String, String> map = hx.c;
                str = map != null ? map.get(host) : "";
                z2 = false;
                if (!TextUtils.isEmpty(str)) {
                    idVar.y();
                    string = uri.buildUpon().encodedAuthority(str).build().toString();
                    if (z2) {
                        mapD.put("targetHost", host);
                        this.s = host;
                    }
                    if (z2 && this.f2890a) {
                        eVarA.a(str);
                    }
                }
                this.m = string;
                url = new URL(this.m);
                this.u.a(idVar, url);
                if (c(url.getHost()) && idVar.c_()) {
                    bVarW = idVar.w();
                    str2 = this.u.c.e;
                    if (!b(str2) && ((bVarW.b() && fs.g) || (bVarW.c() && fs.h(str2)))) {
                        try {
                            this.u.b = SystemClock.elapsedRealtime();
                            InetAddress[] allByName = InetAddress.getAllByName(this.u.c.e);
                            if (allByName == null || allByName.length <= 0 || allByName[0] == null) {
                                hostAddress = "";
                            } else {
                                boolean z3 = fs.a() && fs.c();
                                "---canUseIpv6---".concat(String.valueOf(z3));
                                if (z3) {
                                    for (int i2 = 0; i2 < allByName.length; i2++) {
                                        if (allByName[i2] instanceof Inet6Address) {
                                            hostAddress = "[" + allByName[i2].getHostAddress() + "]";
                                            break;
                                        }
                                    }
                                    hostAddress = "";
                                    if (TextUtils.isEmpty(hostAddress)) {
                                        InetAddress inetAddress = allByName[0];
                                        hostAddress = inetAddress.getHostAddress();
                                        if (inetAddress instanceof Inet6Address) {
                                            hostAddress = "[" + hostAddress + "]";
                                        }
                                    }
                                } else {
                                    for (InetAddress inetAddress2 : allByName) {
                                        if (inetAddress2 instanceof Inet4Address) {
                                            hostAddress = inetAddress2.getHostAddress();
                                            break;
                                        }
                                    }
                                    hostAddress = "";
                                    if (TextUtils.isEmpty(hostAddress)) {
                                    }
                                }
                            }
                            f fVar2 = this.u;
                            "---onDNSEnd---ip=".concat(String.valueOf(hostAddress));
                            fVar2.c.c = hostAddress.replace("[", "").replace("]", "");
                            fVar2.c.g = SystemClock.elapsedRealtime() - fVar2.b;
                            if (!TextUtils.isEmpty(hostAddress)) {
                                Uri uri2 = Uri.parse(this.m);
                                String host2 = uri2.getHost();
                                Uri uriBuild = uri2.buildUpon().encodedAuthority(hostAddress).build();
                                this.n = host2;
                                mapD.put("host", host2);
                                if (this.f2890a) {
                                    eVarA.b(host2);
                                }
                                this.m = uriBuild.toString();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
                if (this.f2890a) {
                    this.m = fx.a(this.m);
                }
                Objects.toString(idVar.w());
                URL url2 = new URL(this.m);
                hx.a aVar = this.h;
                uRLConnectionA = aVar == null ? aVar.a() : null;
                if (uRLConnectionA == null) {
                    Proxy proxy = this.c;
                    if (proxy != null) {
                        uRLConnectionA = url2.openConnection(proxy);
                    } else {
                        uRLConnectionA = url2.openConnection();
                    }
                }
                if (!this.f2890a) {
                    try {
                        SoftReference<SSLContext> softReference2 = k;
                        if (softReference2 == null || softReference2.get() == null) {
                            k = new SoftReference<>(SSLContext.getInstance("TLS"));
                        }
                        softReference = k;
                    } catch (Throwable unused2) {
                    }
                    SSLContext sSLContext = softReference != null ? softReference.get() : null;
                    if (sSLContext == null) {
                        try {
                            sSLContext = SSLContext.getInstance("TLS");
                        } catch (Throwable th) {
                            ha.a(th, "ht", "ne");
                        }
                    }
                    sSLContext.init(null, null, null);
                    this.b = sSLContext;
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionA;
                    if (fs.f.f2798a && (ibVarB = b()) != null) {
                        httpsURLConnection.setSSLSocketFactory(ibVarB);
                        ibVarB.a();
                    } else {
                        httpsURLConnection.setSSLSocketFactory(this.b.getSocketFactory());
                    }
                    httpsURLConnection.setHostnameVerifier(eVarA);
                    httpURLConnection = httpsURLConnection;
                } else {
                    httpURLConnection = (HttpURLConnection) uRLConnectionA;
                }
                if (Build.VERSION.SDK != null) {
                    httpURLConnection.setRequestProperty("Connection", "close");
                }
                int iX = (int) (((long) idVar.x()) - (this.u.c.g / 1000));
                a(mapD, httpURLConnection);
                httpURLConnection.setConnectTimeout(iX);
                httpURLConnection.setReadTimeout(iX);
                if (!z) {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                } else {
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setDoInput(true);
                }
                return new b(httpURLConnection);
            }
            str = "";
        }
        z2 = true;
        if (!TextUtils.isEmpty(str)) {
        }
        this.m = string;
        url = new URL(this.m);
        this.u.a(idVar, url);
        if (c(url.getHost())) {
            bVarW = idVar.w();
            str2 = this.u.c.e;
            if (b(str2)) {
                if (!b(str2) && ((bVarW.b() && fs.g) || (bVarW.c() && fs.h(str2)))) {
                }
            }
        }
        if (this.f2890a) {
        }
        Objects.toString(idVar.w());
        URL url22 = new URL(this.m);
        hx.a aVar2 = this.h;
        if (aVar2 == null) {
        }
        if (uRLConnectionA == null) {
        }
        if (!this.f2890a) {
        }
        if (Build.VERSION.SDK != null) {
        }
        int iX2 = (int) (((long) idVar.x()) - (this.u.c.g / 1000));
        a(mapD, httpURLConnection);
        httpURLConnection.setConnectTimeout(iX2);
        httpURLConnection.setReadTimeout(iX2);
        if (!z) {
        }
        return new b(httpURLConnection);
    }

    private ib b() {
        try {
            SoftReference<ib> softReference = t;
            if (softReference == null || softReference.get() == null) {
                t = new SoftReference<>(new ib(fs.c, this.b));
            }
            ib ibVar = k != null ? t.get() : null;
            return ibVar == null ? new ib(fs.c, this.b) : ibVar;
        } catch (Throwable th) {
            hd.c(th, "ht", "gsf");
            return null;
        }
    }

    private static String b(Map<String, List<String>> map) {
        try {
            List<String> list = map.get(o.e);
            if (list == null || list.size() <= 0) {
                return "";
            }
            String str = list.get(0);
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (str.contains("#")) {
                String[] strArrSplit = str.split("#");
                if (strArrSplit.length <= 1) {
                    return "";
                }
                str = strArrSplit[0];
            }
            return str;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        if (this.l) {
            return true;
        }
        return (!TextUtils.isEmpty(this.n) && (this.n.contains("rest") || this.n.contains("apilocate"))) || c(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x016e A[Catch: all -> 0x01bb, IOException -> 0x01c0, SocketTimeoutException -> 0x01ee, ConnectTimeoutException -> 0x01f3, TRY_ENTER, TryCatch #18 {SocketTimeoutException -> 0x01ee, ConnectTimeoutException -> 0x01f3, IOException -> 0x01c0, all -> 0x01bb, blocks: (B:3:0x0007, B:5:0x0019, B:7:0x0023, B:9:0x0029, B:10:0x0030, B:45:0x00a5, B:105:0x016e, B:106:0x01ba), top: B:158:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0206 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0210 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x021a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a0 A[PHI: r2
      0x00a0: PHI (r2v11 java.lang.String) = (r2v0 java.lang.String), (r2v19 java.lang.String), (r2v19 java.lang.String) binds: [B:4:0x0017, B:41:0x009f, B:12:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a5 A[Catch: all -> 0x01bb, IOException -> 0x01c0, SocketTimeoutException -> 0x01ee, ConnectTimeoutException -> 0x01f3, TRY_ENTER, TRY_LEAVE, TryCatch #18 {SocketTimeoutException -> 0x01ee, ConnectTimeoutException -> 0x01f3, IOException -> 0x01c0, all -> 0x01bb, blocks: (B:3:0x0007, B:5:0x0019, B:7:0x0023, B:9:0x0029, B:10:0x0030, B:45:0x00a5, B:105:0x016e, B:106:0x01ba), top: B:158:0x0007 }] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ie a(b bVar) throws Throwable {
        ?? r4;
        InputStream inputStream;
        PushbackInputStream pushbackInputStream;
        boolean zA;
        InputStream inputStream2;
        char c2;
        String str = "";
        ByteArrayOutputStream byteArrayOutputStream = null;
        gZIPInputStream = null;
        gZIPInputStream = null;
        gZIPInputStream = null;
        InputStream gZIPInputStream = null;
        byteArrayOutputStream = null;
        byteArrayOutputStream = null;
        try {
            try {
                hz.a();
                HttpURLConnection httpURLConnection = bVar.f2892a;
                Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                int responseCode = httpURLConnection.getResponseCode();
                if (headerFields == null) {
                    zA = false;
                    if (responseCode != 200) {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            this.u.b = SystemClock.elapsedRealtime();
                            inputStream = httpURLConnection.getInputStream();
                            try {
                                pushbackInputStream = new PushbackInputStream(inputStream, 2);
                                try {
                                    byte[] bArr = new byte[2];
                                    pushbackInputStream.read(bArr);
                                    pushbackInputStream.unread(bArr);
                                    gZIPInputStream = (bArr[0] == 31 && bArr[1] == -117) ? new GZIPInputStream(pushbackInputStream) : pushbackInputStream;
                                    byte[] bArr2 = new byte[1024];
                                    while (true) {
                                        int i = gZIPInputStream.read(bArr2);
                                        if (i == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream2.write(bArr2, 0, i);
                                    }
                                    this.u.c();
                                    hd.c();
                                    ie ieVar = new ie();
                                    ieVar.f2902a = byteArrayOutputStream2.toByteArray();
                                    ieVar.b = headerFields;
                                    ieVar.c = this.g;
                                    ieVar.d = str;
                                    ieVar.e = zA;
                                    hz.a(httpURLConnection.getURL(), ieVar);
                                    this.u.a(ieVar.f2902a.length);
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (Throwable th) {
                                        ha.a(th, "ht", "par");
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable th2) {
                                            ha.a(th2, "ht", "par");
                                        }
                                    }
                                    try {
                                        pushbackInputStream.close();
                                    } catch (Throwable th3) {
                                        ha.a(th3, "ht", "par");
                                    }
                                    try {
                                        gZIPInputStream.close();
                                    } catch (Throwable th4) {
                                        ha.a(th4, "ht", "par");
                                    }
                                    return ieVar;
                                } catch (SocketTimeoutException e2) {
                                    e = e2;
                                    throw e;
                                } catch (ConnectTimeoutException e3) {
                                    e = e3;
                                    throw e;
                                } catch (IOException e4) {
                                    e = e4;
                                    inputStream2 = gZIPInputStream;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    r4 = inputStream2;
                                    try {
                                        if (e instanceof InterruptedIOException) {
                                            fq fqVar = new fq("IO 操作异常 - IOException", str, this.g);
                                            if (!TextUtils.isEmpty(e.getMessage()) && e.getMessage().equals("thread interrupted")) {
                                                fqVar.j();
                                                throw fqVar;
                                            }
                                            throw fqVar;
                                        }
                                        throw e;
                                    } catch (Throwable th5) {
                                        th = th5;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    r4 = gZIPInputStream;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    if (byteArrayOutputStream != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (pushbackInputStream != null) {
                                    }
                                    if (r4 == 0) {
                                    }
                                }
                            } catch (SocketTimeoutException e5) {
                                e = e5;
                            } catch (ConnectTimeoutException e6) {
                                e = e6;
                            } catch (IOException e7) {
                                e = e7;
                                inputStream2 = null;
                                pushbackInputStream = null;
                            } catch (Throwable th7) {
                                th = th7;
                                r4 = 0;
                                pushbackInputStream = null;
                            }
                        } catch (SocketTimeoutException e8) {
                            e = e8;
                        } catch (ConnectTimeoutException e9) {
                            e = e9;
                        } catch (IOException e10) {
                            e = e10;
                            inputStream2 = null;
                            inputStream = null;
                            pushbackInputStream = null;
                        } catch (Throwable th8) {
                            th = th8;
                            r4 = 0;
                            inputStream = null;
                            pushbackInputStream = null;
                        }
                    } else {
                        fq fqVar2 = new fq("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode + "  " + str + " " + this.g, str, this.g);
                        fqVar2.a(httpURLConnection.getResponseMessage());
                        fqVar2.a(headerFields);
                        this.u.b(responseCode);
                        this.u.a(10);
                        fqVar2.h();
                        throw fqVar2;
                    }
                } else {
                    List<String> list = headerFields.get("gsid");
                    if (list != null && list.size() > 0) {
                        str = list.get(0);
                    }
                    this.u.c.k = b(headerFields);
                    try {
                        if (!TextUtils.isEmpty(this.j)) {
                            if (this.o) {
                                if (headerFields.containsKey(o.e)) {
                                    zA = a(headerFields, false);
                                    c2 = 1;
                                } else {
                                    fs.e(this.j);
                                    zA = false;
                                    c2 = 0;
                                }
                            } else {
                                zA = a(headerFields, true);
                                c2 = 2;
                            }
                            try {
                                if (zA) {
                                    if (this.j.equals("loc")) {
                                        String host = this.s;
                                        if (TextUtils.isEmpty(host)) {
                                            host = httpURLConnection.getURL().getHost();
                                        }
                                        fs.a(this.j, c2 == 2, host, host, this.n);
                                    } else {
                                        fs.b(this.j, c2 == 2);
                                    }
                                } else if (c2 == 1) {
                                    hz.a(false, this.j);
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                    if (responseCode != 200) {
                    }
                }
            } catch (Throwable th9) {
                th = th9;
                r4 = "";
            }
        } catch (SocketTimeoutException e11) {
            throw e11;
        } catch (ConnectTimeoutException e12) {
            throw e12;
        } catch (IOException e13) {
            e = e13;
            r4 = 0;
            inputStream = null;
            pushbackInputStream = null;
        } catch (Throwable th10) {
            th = th10;
            r4 = 0;
            inputStream = null;
            pushbackInputStream = null;
        }
        if (byteArrayOutputStream != null) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th11) {
                ha.a(th11, "ht", "par");
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Throwable th12) {
                ha.a(th12, "ht", "par");
            }
        }
        if (pushbackInputStream != null) {
            try {
                pushbackInputStream.close();
            } catch (Throwable th13) {
                ha.a(th13, "ht", "par");
            }
        }
        if (r4 == 0) {
            try {
                r4.close();
                throw th;
            } catch (Throwable th14) {
                ha.a(th14, "ht", "par");
                throw th;
            }
        }
        throw th;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(Map<String, List<String>> map, boolean z) {
        boolean z2;
        List<String> list;
        try {
            List<String> list2 = map.get(o.e);
            if (list2 == null || list2.size() <= 0) {
                z2 = false;
            } else {
                String str = list2.get(0);
                if (!TextUtils.isEmpty(str)) {
                    if (str.contains("#")) {
                        String[] strArrSplit = str.split("#");
                        if (strArrSplit.length > 1 && "1".equals(strArrSplit[1])) {
                        }
                        z2 = false;
                    }
                    z2 = true;
                }
            }
            if (!z2) {
                return false;
            }
            if (!z) {
                return true;
            }
            if (!map.containsKey("lct") || (list = map.get("lct")) == null || list.size() <= 0) {
                return false;
            }
            return fs.a(this.j, fs.a(list));
        } catch (Throwable unused) {
            return false;
        }
    }

    private void a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        c cVarG;
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    httpURLConnection.addRequestProperty(str, map.get(str));
                }
            } catch (Throwable th) {
                ha.a(th, "ht", "adh");
                return;
            }
        }
        HashMap<String, String> map2 = hx.d;
        if (map2 != null) {
            for (String str2 : map2.keySet()) {
                httpURLConnection.addRequestProperty(str2, hx.d.get(str2));
            }
        }
        String strB = "";
        if (!this.m.contains("/v3/iasdkauth") && !TextUtils.isEmpty(this.j) && fs.d(this.j)) {
            this.o = true;
            fs.g gVarF = fs.f(this.j);
            httpURLConnection.addRequestProperty("lct", String.valueOf(gVarF.f2799a));
            httpURLConnection.addRequestProperty("lct-info", gVarF.b);
            httpURLConnection.addRequestProperty("aks", fs.c(fs.a(this.j)));
            httpURLConnection.addRequestProperty("lct-args", a(fs.b(this.j) != null ? fs.b(this.j).b() : "", this.j));
        }
        httpURLConnection.addRequestProperty("csid", this.g);
        if (b(this.u.c.e)) {
            f fVar = this.u;
            if (!TextUtils.isEmpty(fVar.c.c)) {
                strB = fw.b(ht.a(fVar.c.c.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                String str3 = fVar.c.c;
            }
            if (!TextUtils.isEmpty(strB)) {
                httpURLConnection.addRequestProperty("sip", strB);
            }
            if (fs.j && (cVarG = fs.g()) != null) {
                httpURLConnection.addRequestProperty("nls", cVarG.b());
                this.u.e = cVarG;
            }
            a aVarF = fs.f();
            if (aVarF != null) {
                httpURLConnection.addRequestProperty("nlf", aVarF.b());
                this.u.d = aVarF;
            }
        }
    }

    public static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            if (sb.length() > 0) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.append(URLEncoder.encode(key));
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(URLEncoder.encode(value));
        }
        return sb.toString();
    }

    private static int a(Exception exc) {
        if (exc instanceof SSLHandshakeException) {
            return 4101;
        }
        if (exc instanceof SSLKeyException) {
            return 4102;
        }
        if (exc instanceof SSLProtocolException) {
            return 4103;
        }
        if (exc instanceof SSLPeerUnverifiedException) {
            return 4104;
        }
        if (exc instanceof ConnectException) {
            return 6101;
        }
        if (exc instanceof SocketException) {
            return 6102;
        }
        return exc instanceof ConnectTimeoutException ? com.amap.api.services.core.AMapException.CODE_AMAP_NEARBY_KEY_NOT_BIND : exc instanceof SocketTimeoutException ? 2102 : 0;
    }

    private static String a(String str, String str2) {
        String str3 = Build.MANUFACTURER;
        Context context = fs.c;
        return String.format("platform=Android&sdkversion=%s&product=%s&manufacture=%s&abitype=%s", str, str2, str3, context != null ? ge.a(context) : "");
    }
}
