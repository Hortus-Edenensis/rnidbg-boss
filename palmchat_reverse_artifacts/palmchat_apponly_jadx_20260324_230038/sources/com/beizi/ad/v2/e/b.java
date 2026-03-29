package com.beizi.ad.v2.e;

import android.text.TextUtils;
import com.beizi.ad.internal.c;
import com.beizi.ad.internal.e.q;
import com.beizi.ad.internal.e.u;
import com.beizi.ad.lance.a.l;
import com.beizi.ad.lance.a.m;
import com.beizi.ad.model.a;
import com.beizi.ad.model.c;
import com.beizi.ad.model.e;
import com.beizi.ad.model.f;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {
    private boolean a(int i) {
        return i == 200;
    }

    private byte[] b(com.beizi.ad.model.b bVar) {
        String strA = a(bVar);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return strA.getBytes();
    }

    public void a(com.beizi.ad.model.b bVar, a aVar) {
        if (bVar == null || aVar == null) {
            return;
        }
        try {
            String strE = c.a().e();
            m.d("lance", "getRequestBaseUrl:" + strE);
            HttpURLConnection httpURLConnectionA = a(new URL(strE));
            byte[] bArrB = b(bVar);
            if (bArrB == null) {
                aVar.a(4);
                return;
            }
            a(httpURLConnectionA, bArrB);
            httpURLConnectionA.connect();
            if (!a(httpURLConnectionA.getResponseCode())) {
                aVar.a(2);
                return;
            }
            InputStream inputStream = httpURLConnectionA.getInputStream();
            String strA = c.o.a(inputStream);
            inputStream.close();
            if (TextUtils.isEmpty(strA)) {
                aVar.a(3);
            } else {
                aVar.a(strA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String a(com.beizi.ad.model.b bVar) {
        com.beizi.ad.internal.c cVarA = com.beizi.ad.internal.c.a();
        com.beizi.ad.internal.e.a aVarA = com.beizi.ad.internal.e.a.a();
        e.a aVarA2 = new e.a.C0130a().a(aVarA.d()).j(aVarA.e()).l(aVarA.w()).m(aVarA.x()).n(aVarA.b()).b("").c(aVarA.r()).a(f.e.PLATFORM_ANDROID).a(aVarA.n()).d(aVarA.s()).e(aVarA.t()).f(aVarA.u()).g(aVarA.g()).h(aVarA.h()).i(aVarA.v()).k(aVarA.f()).o(aVarA.k()).a(aVarA.m()).p(aVarA.p()).q(aVarA.q()).r(aVarA.o()).s(aVarA.i()).t(aVarA.j()).u(aVarA.l()).v(aVarA.c()).a(com.beizi.ad.internal.c.a().h()).w(aVarA.D()).x(aVarA.E()).a();
        q qVarA = q.a();
        qVarA.d();
        e.c.a aVar = new e.c.a();
        aVar.a(qVarA.b());
        aVar.a(qVarA.c());
        if (!TextUtils.isEmpty(qVarA.b) && !TextUtils.isEmpty(qVarA.c)) {
            aVar.a(new e.b.a().b(qVarA.c).a(qVarA.b).c(qVarA.d).a(qVarA.e).a());
        }
        a.b.C0126a c0126aC = new a.b.C0126a().a(aVarA.z()).a(f.i.SRC_APP).a(f.g.REQ_AD).a(com.beizi.ad.lance.a.q.c()).b(cVarA.b()).a(aVarA2).a(aVar.a()).c(aVarA.y()).d(aVarA.C()).b(aVarA.A()).c(aVarA.B());
        a.C0124a.C0125a c0125a = new a.C0124a.C0125a();
        if (bVar != null) {
            c0125a.a(bVar.a());
            c0125a.b(bVar.c());
            if (bVar.b()) {
                c0125a.a(1);
            } else {
                c0125a.a(0);
            }
            c0125a.a(bVar.d());
        }
        c0126aC.a(c0125a.a());
        a.b bVarA = c0126aC.a();
        String strA = com.beizi.ad.lance.a.a.a(l.a(), bVarA.toString());
        m.d("lance", "sdkRequest:" + bVarA.toString());
        return strA;
    }

    private HttpURLConnection a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        return httpURLConnection;
    }

    private void a(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        httpURLConnection.setRequestProperty("User-Agent", com.beizi.ad.internal.c.a().e);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
        String strA = u.a();
        if (!TextUtils.isEmpty(strA)) {
            httpURLConnection.setRequestProperty("Cookie", strA);
        }
        httpURLConnection.setRequestProperty("Connect-Length", Integer.toString(bArr.length));
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(bArr);
        outputStream.flush();
        outputStream.close();
    }

    public String a(String str, boolean z) {
        com.beizi.ad.internal.e.a aVarA = com.beizi.ad.internal.e.a.a();
        e.a aVarA2 = new e.a.C0130a().a(aVarA.d()).j(aVarA.e()).l(aVarA.w()).m(aVarA.x()).n(aVarA.b()).b("").c(aVarA.r()).a(f.e.PLATFORM_ANDROID).a(aVarA.n()).d(aVarA.s()).e(aVarA.t()).f(aVarA.u()).g(aVarA.g()).h(aVarA.h()).i(aVarA.v()).k(aVarA.f()).o(aVarA.k()).a(aVarA.m()).p(aVarA.p()).q(aVarA.q()).r(aVarA.o()).s(aVarA.i()).t(aVarA.j()).u(aVarA.l()).v(aVarA.c()).a(com.beizi.ad.internal.c.a().h()).w(aVarA.D()).x(aVarA.E()).a();
        q qVarA = q.a();
        qVarA.d();
        e.c.a aVar = new e.c.a();
        aVar.a(qVarA.b());
        aVar.a(qVarA.c());
        if (!TextUtils.isEmpty(qVarA.b) && !TextUtils.isEmpty(qVarA.c)) {
            aVar.a(new e.b.a().b(qVarA.c).a(qVarA.b).c(qVarA.d).a(qVarA.e).a());
        }
        a.b.C0126a c0126aC = new a.b.C0126a().a(aVarA.z()).a(f.i.SRC_APP).a(f.g.REQ_AD).a(com.beizi.ad.lance.a.q.c()).a(aVarA2).a(aVar.a()).c(aVarA.y()).d(aVarA.C()).b(aVarA.A()).c(aVarA.B());
        c0126aC.a(new a.C0124a.C0125a().b(str).a(z ? 1 : 0).a());
        a.b bVarA = c0126aC.a();
        String strA = com.beizi.ad.lance.a.a.a(l.a(), bVarA.toString());
        m.d("lance", "sdkRequest:" + bVarA.toString());
        return strA;
    }
}
