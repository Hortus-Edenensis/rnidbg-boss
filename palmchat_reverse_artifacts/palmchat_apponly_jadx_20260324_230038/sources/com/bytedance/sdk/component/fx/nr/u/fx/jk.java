package com.bytedance.sdk.component.fx.nr.u.fx;

import com.bytedance.sdk.component.fx.nr.bg;
import com.bytedance.sdk.component.fx.nr.bq;
import com.bytedance.sdk.component.fx.nr.gi;
import com.bytedance.sdk.component.fx.nr.h;
import com.bytedance.sdk.component.fx.nr.ja;
import com.bytedance.sdk.component.fx.nr.my;
import com.bytedance.sdk.component.fx.nr.q;
import com.bytedance.sdk.component.fx.nr.qq;
import com.bytedance.sdk.component.fx.nr.rh;
import com.bytedance.sdk.component.fx.nr.z;
import com.qiniu.android.http.request.Request;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class jk implements bq {
    private Object b;
    private com.bytedance.sdk.component.fx.nr.u.nr.x fx;
    private final boolean nr;
    private volatile boolean pn;
    private final q u;

    public jk(q qVar, boolean z) {
        this.u = qVar;
        this.nr = z;
    }

    public boolean nr() {
        return this.pn;
    }

    public void u() {
        this.pn = true;
        com.bytedance.sdk.component.fx.nr.u.nr.x xVar = this.fx;
        if (xVar != null) {
            xVar.pn();
        }
    }

    public void u(Object obj) {
        this.b = obj;
    }

    @Override // com.bytedance.sdk.component.fx.nr.bq
    public h u(bq.u uVar) throws Throwable {
        String strU;
        String str;
        int i;
        IOException iOException;
        int i2;
        ArrayList arrayList;
        h hVarU;
        int i3;
        int i4;
        z zVarU = uVar.u();
        x xVar = (x) uVar;
        com.bytedance.sdk.component.fx.nr.pn pnVarCall = xVar.call();
        my myVarN = xVar.n();
        this.fx = new com.bytedance.sdk.component.fx.nr.u.nr.x(this.u.k(), u(zVarU.u()), pnVarCall, myVarN, this.b);
        try {
            int i5 = Integer.parseInt(zVarU.fx().u("csj_client_source_from"));
            strU = zVarU.fx().u("csj_extra_info");
            try {
                zVarU = zVarU.iz().u("csj_client_source_from").u("csj_extra_info").u();
                i = i5;
                str = strU;
            } catch (Exception unused) {
                str = strU;
                i = 0;
            }
        } catch (Exception unused2) {
            strU = "";
        }
        String string = zVarU.u().toString();
        ArrayList arrayList2 = new ArrayList();
        h hVar = null;
        int i6 = 0;
        while (!this.pn) {
            if (this.u.rh != null && zVarU.u() != null) {
                Iterator<String> it = this.u.rh.iterator();
                while (it.hasNext()) {
                    Iterator<String> it2 = it;
                    String[] strArrSplit = it.next().split("@");
                    my myVar = myVarN;
                    if (strArrSplit.length >= 2) {
                        String str2 = strArrSplit[0];
                        try {
                            i4 = Integer.parseInt(strArrSplit[1]);
                        } catch (Exception unused3) {
                            i4 = 0;
                        }
                        if ((i4 & i) != 0 && Pattern.compile(str2).matcher(zVarU.u().toString()).find()) {
                            h.u uVar2 = new h.u();
                            uVar2.u(8848);
                            uVar2.u(zVarU.u().toString());
                            uVar2.u(zVarU);
                            uVar2.u(qq.HTTP_1_1);
                            uVar2.u(com.bytedance.sdk.component.fx.nr.u.fx.fx);
                            if (arrayList2.size() > 0) {
                                arrayList2.add(0, string);
                                return uVar2.u("csj-location-record", arrayList2.toString()).u("csj-source-from", String.valueOf(i)).u("csj-extra-info", String.valueOf(str)).u();
                            }
                            return uVar2.u();
                        }
                    }
                    it = it2;
                    myVarN = myVar;
                }
            }
            my myVar2 = myVarN;
            try {
            } catch (com.bytedance.sdk.component.fx.nr.u.nr.pn e) {
                e = e;
                i2 = i;
                arrayList = arrayList2;
            } catch (IOException e2) {
                e = e2;
                i2 = i;
                arrayList = arrayList2;
                iOException = null;
            } catch (Throwable th) {
                th = th;
                iOException = null;
            }
            try {
                hVarU = xVar.u(zVarU, this.fx, null, null);
                if (hVar != null) {
                    hVarU = hVarU.a().fx(hVar.a().u((rh) null).u()).u();
                }
                zVarU = u(hVarU);
            } catch (com.bytedance.sdk.component.fx.nr.u.nr.pn e3) {
                e = e3;
                i2 = i;
                arrayList = arrayList2;
                if (!u(e.u(), false, zVarU)) {
                    throw e.u();
                }
                i = i2;
            } catch (IOException e4) {
                e = e4;
                i2 = i;
                arrayList = arrayList2;
                iOException = null;
                try {
                    if (!u(e, !(e instanceof com.bytedance.sdk.component.fx.nr.u.pn.u), zVarU)) {
                        throw e;
                    }
                    i = i2;
                } catch (Throwable th2) {
                    th = th2;
                    this.fx.u(iOException);
                    this.fx.fx();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                iOException = null;
                this.fx.u(iOException);
                this.fx.fx();
                throw th;
            }
            if (zVarU == null) {
                if (!this.nr) {
                    this.fx.fx();
                }
                if (arrayList2.size() <= 0) {
                    return hVarU;
                }
                arrayList2.add(0, string);
                return hVarU.a().u("csj-location-record", arrayList2.toString()).u("csj-source-from", String.valueOf(i)).u("csj-extra-info", String.valueOf(str)).u();
            }
            arrayList2.add(zVarU.u().toString());
            com.bytedance.sdk.component.fx.nr.u.fx.u(hVarU.n());
            int i7 = i6 + 1;
            if (i7 <= 20) {
                if (!(zVarU.b() instanceof l)) {
                    if (!u(hVarU, zVarU.u())) {
                        this.fx.fx();
                        i3 = i;
                        arrayList = arrayList2;
                        this.fx = new com.bytedance.sdk.component.fx.nr.u.nr.x(this.u.k(), u(zVarU.u()), pnVarCall, myVar2, this.b);
                    } else {
                        i3 = i;
                        arrayList = arrayList2;
                        if (this.fx.u() != null) {
                            throw new IllegalStateException("Closing the body of " + hVarU + " didn't close its backing stream. Bad interceptor?");
                        }
                    }
                    i = i3;
                    hVar = hVarU;
                    i6 = i7;
                    arrayList2 = arrayList;
                    myVarN = myVar2;
                } else {
                    this.fx.fx();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", hVarU.fx());
                }
            } else {
                this.fx.fx();
                throw new ProtocolException("Too many follow-up requests: ".concat(String.valueOf(i7)));
            }
        }
        this.fx.fx();
        throw new IOException("Canceled");
    }

    private com.bytedance.sdk.component.fx.nr.u u(bg bgVar) {
        SSLSocketFactory sSLSocketFactoryJk;
        HostnameVerifier hostnameVerifierT;
        com.bytedance.sdk.component.fx.nr.x xVarL;
        if (bgVar.b()) {
            sSLSocketFactoryJk = this.u.jk();
            hostnameVerifierT = this.u.t();
            xVarL = this.u.l();
        } else {
            sSLSocketFactoryJk = null;
            hostnameVerifierT = null;
            xVarL = null;
        }
        return new com.bytedance.sdk.component.fx.nr.u(bgVar.x(), bgVar.n(), this.u.n(), this.u.a(), sSLSocketFactoryJk, hostnameVerifierT, xVarL, this.u.s(), this.u.b(), this.u.bq(), this.u.dw(), this.u.pn());
    }

    private boolean u(IOException iOException, boolean z, z zVar) {
        this.fx.u(iOException);
        if (this.u.sx()) {
            return !(z && (zVar.b() instanceof l)) && u(iOException, z) && this.fx.iz();
        }
        return false;
    }

    private boolean u(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private z u(h hVar) throws IOException {
        String strU;
        bg bgVarFx;
        Proxy proxyB;
        if (hVar != null) {
            com.bytedance.sdk.component.fx.nr.u.nr.fx fxVarNr = this.fx.nr();
            ja jaVarU = fxVarNr != null ? fxVarNr.u() : null;
            int iFx = hVar.fx();
            String strNr = hVar.u().nr();
            if (iFx == 307 || iFx == 308) {
                if (!strNr.equals("GET") && !strNr.equals(Request.HttpMethodHEAD)) {
                    return null;
                }
            } else {
                if (iFx == 401) {
                    return this.u.mv().u(jaVarU, hVar);
                }
                if (iFx == 407) {
                    if (jaVarU != null) {
                        proxyB = jaVarU.nr();
                    } else {
                        proxyB = this.u.b();
                    }
                    if (proxyB.type() == Proxy.Type.HTTP) {
                        return this.u.s().u(jaVarU, hVar);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                if (iFx == 408) {
                    if (!this.u.sx() || (hVar.u().b() instanceof l)) {
                        return null;
                    }
                    if (hVar.t() == null || hVar.t().fx() != 408) {
                        return hVar.u();
                    }
                    return null;
                }
                switch (iFx) {
                    case 300:
                    case 301:
                    case 302:
                    case 303:
                        break;
                    default:
                        return null;
                }
            }
            if (!this.u.o() || (strU = hVar.u(HttpHeaders.LOCATION)) == null || (bgVarFx = hVar.u().u().fx(strU)) == null) {
                return null;
            }
            if (!bgVarFx.fx().equals(hVar.u().u().fx()) && !this.u.my()) {
                return null;
            }
            z.u uVarIz = hVar.u().iz();
            if (iz.fx(strNr)) {
                boolean zB = iz.b(strNr);
                if (iz.pn(strNr)) {
                    uVarIz.u("GET", (gi) null);
                } else {
                    uVarIz.u(strNr, zB ? hVar.u().b() : null);
                }
                if (!zB) {
                    uVarIz.u("Transfer-Encoding");
                    uVarIz.u("Content-Length");
                    uVarIz.u("Content-Type");
                }
            }
            if (!u(hVar, bgVarFx)) {
                uVarIz.u(HttpHeaders.AUTHORIZATION);
            }
            return uVarIz.u(bgVarFx).u();
        }
        throw new IllegalStateException();
    }

    private boolean u(h hVar, bg bgVar) {
        bg bgVarU = hVar.u().u();
        return bgVarU.x().equals(bgVar.x()) && bgVarU.n() == bgVar.n() && bgVarU.fx().equals(bgVar.fx());
    }
}
