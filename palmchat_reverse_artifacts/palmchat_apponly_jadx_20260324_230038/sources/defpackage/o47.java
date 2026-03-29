package defpackage;

import android.net.Uri;
import com.wft.wknet.e;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class o47 implements Runnable {
    public static final AtomicInteger i = new AtomicInteger();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public co6 f19694a;
    public sb7 b;
    public e c;
    public final int d = i.incrementAndGet();
    public String e;
    public String f;
    public List<String> g;
    public int h;

    public o47(co6 co6Var, sb7 sb7Var, e eVar) {
        this.f19694a = co6Var;
        this.b = sb7Var;
        this.c = eVar;
        String strL = co6Var.l();
        this.e = strL;
        this.f = Uri.parse(strL).getHost();
    }

    public static void e(HttpURLConnection httpURLConnection, co6 co6Var) throws Throwable {
        httpURLConnection.setRequestMethod(co6Var.i());
        int iH = co6Var.h();
        if (iH == 1 || iH == 2 || iH == 7) {
            i(httpURLConnection, co6Var);
        }
    }

    public static void i(HttpURLConnection httpURLConnection, co6 co6Var) throws Throwable {
        byte[] bArrE = co6Var.e();
        if (bArrE == null) {
            return;
        }
        httpURLConnection.setDoOutput(true);
        byte[] bArr = new byte[1024];
        DataOutputStream dataOutputStream = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
            DataOutputStream dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
            while (true) {
                try {
                    int i2 = byteArrayInputStream.read(bArr, 0, 1024);
                    if (i2 == -1) {
                        dataOutputStream2.flush();
                        dataOutputStream2.close();
                        return;
                    }
                    dataOutputStream2.write(bArr, 0, i2);
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public bo6 a(co6 co6Var) throws Exception {
        long jCurrentTimeMillis;
        while (true) {
            jCurrentTimeMillis = System.currentTimeMillis();
            try {
                break;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                co6Var.a(String.format("connect-failed [reason=%s]", co6Var.l()));
                throw new RuntimeException("Bad URL " + co6Var.l(), e);
            } catch (SocketTimeoutException e2) {
                e = e2;
            } catch (ConnectTimeoutException e3) {
                e = e3;
            } catch (IOException e4) {
                e = e4;
            } catch (Exception e5) {
                e = e5;
            }
            d(co6Var, e);
        }
        if (!co6Var.d()) {
            throw new IOException("Cancel this request because it can not ensure data");
        }
        HashMap map = new HashMap(co6Var.f());
        HttpURLConnection httpURLConnectionC = c(new URL(co6Var.l()), co6Var);
        for (String str : map.keySet()) {
            httpURLConnectionC.addRequestProperty(str, (String) map.get(str));
        }
        e(httpURLConnectionC, co6Var);
        int responseCode = httpURLConnectionC.getResponseCode();
        if (responseCode < 200 || responseCode > 299) {
            co6Var.a(String.format("connect-failed [reason=%s]", Integer.valueOf(responseCode)));
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        co6Var.a(String.format("connect-success [time=%d]", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
        return new bo6(h(httpURLConnectionC));
    }

    public e b() {
        return this.c;
    }

    public final HttpURLConnection c(URL url, co6 co6Var) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        int iK = co6Var.k();
        httpURLConnection.setConnectTimeout(iK);
        httpURLConnection.setReadTimeout(iK);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    public final void d(co6<?> co6Var, Exception exc) throws Exception {
        id7 id7VarJ = co6Var.j();
        int iK = co6Var.k();
        try {
            id7VarJ.a(exc);
            co6Var.a(String.format("connect-retry [reason=%s] [timeout=%s]", exc.getMessage(), Integer.valueOf(iK)));
            List<String> list = this.g;
            if (list == null || this.h >= list.size()) {
                return;
            }
            co6Var.p(this.e.replace(this.f, this.g.get(this.h)));
            if (this.h < this.g.size()) {
                this.h++;
            }
        } catch (Exception e) {
            co6Var.a(String.format("connect-giveup [reason=%s]", e.getMessage()));
            throw e;
        }
    }

    public void f(List<String> list) {
        this.g = list;
        co6 co6Var = this.f19694a;
        if (co6Var == null || list == null) {
            return;
        }
        id7 id7VarJ = co6Var.j();
        int iB = id7VarJ.b();
        int size = list.size();
        if (size > iB) {
            id7VarJ.a(size);
        }
    }

    public final byte[] g(InputStream inputStream) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            while (true) {
                try {
                    int i2 = inputStream.read(bArr);
                    if (i2 == -1) {
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        inputStream.close();
                        byteArrayOutputStream2.close();
                        return byteArray;
                    }
                    byteArrayOutputStream2.write(bArr, 0, i2);
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final byte[] h(HttpURLConnection httpURLConnection) {
        return g(httpURLConnection.getInputStream());
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.b.a(this.f19694a, this.f19694a.n(a(this.f19694a)));
        } catch (IOException | Exception e) {
            this.b.b(this.f19694a, e);
        }
    }
}
