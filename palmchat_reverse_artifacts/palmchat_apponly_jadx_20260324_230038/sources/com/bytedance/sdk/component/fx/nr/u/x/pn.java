package com.bytedance.sdk.component.fx.nr.u.x;

import com.bytedance.sdk.component.fx.nr.q;
import com.bytedance.sdk.component.fx.nr.qq;
import com.bytedance.sdk.component.fx.nr.u.a.iz;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {
    private static final pn u = u();
    private static final Logger nr = Logger.getLogger(q.class.getName());

    public String fx() {
        return "OkHttp";
    }

    public void nr(SSLSocket sSLSocket) {
    }

    public String u(SSLSocket sSLSocket) {
        return null;
    }

    public boolean nr(String str) {
        return true;
    }

    public void u(SSLSocket sSLSocket, String str, List<qq> list) {
    }

    public static pn nr() {
        return u;
    }

    public void u(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public static byte[] nr(List<qq> list) {
        com.bytedance.sdk.component.fx.u.fx fxVar = new com.bytedance.sdk.component.fx.u.fx();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            qq qqVar = list.get(i);
            if (qqVar != qq.HTTP_1_0) {
                fxVar.a(qqVar.toString().length());
                fxVar.nr(qqVar.toString());
            }
        }
        try {
            return fxVar.o();
        } catch (IOException unused) {
            return null;
        }
    }

    public void u(int i, String str, Throwable th) {
        nr.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object u(String str) {
        if (nr.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void u(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        u(5, str, (Throwable) obj);
    }

    public static List<String> u(List<qq> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            qq qqVar = list.get(i);
            if (qqVar != qq.HTTP_1_0) {
                arrayList.add(qqVar.toString());
            }
        }
        return arrayList;
    }

    public iz nr(X509TrustManager x509TrustManager) {
        return new com.bytedance.sdk.component.fx.nr.u.a.nr(x509TrustManager.getAcceptedIssuers());
    }

    public com.bytedance.sdk.component.fx.nr.u.a.fx u(X509TrustManager x509TrustManager) {
        return new com.bytedance.sdk.component.fx.nr.u.a.u(nr(x509TrustManager));
    }

    private static pn u() {
        pn pnVarU = u.u();
        if (pnVarU != null) {
            return pnVarU;
        }
        nr nrVarU = nr.u();
        if (nrVarU != null) {
            return nrVarU;
        }
        pn pnVarU2 = fx.u();
        return pnVarU2 != null ? pnVarU2 : new pn();
    }
}
