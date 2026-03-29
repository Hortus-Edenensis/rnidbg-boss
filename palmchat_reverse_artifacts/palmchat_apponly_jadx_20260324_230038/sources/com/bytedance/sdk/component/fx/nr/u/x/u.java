package com.bytedance.sdk.component.fx.nr.u.x;

import android.net.ssl.SSLSockets;
import android.os.Build;
import android.util.Log;
import com.bytedance.sdk.component.fx.nr.qq;
import com.bytedance.sdk.component.fx.nr.u.a.iz;
import com.zenmen.palmchat.utils.EncryptUtils;
import defpackage.uk7;
import defpackage.wk7;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class u extends pn {
    private final b<Socket> b;
    private final b<Socket> fx;
    private final fx iz = fx.u();
    private final b<Socket> nr;
    private final b<Socket> pn;
    private final Class<?> u;

    /* JADX INFO: compiled from: SearchBox */
    public static final class nr implements iz {
        private final Method nr;
        private final X509TrustManager u;

        public nr(X509TrustManager x509TrustManager, Method method) {
            this.nr = method;
            this.u = x509TrustManager;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof nr)) {
                return false;
            }
            nr nrVar = (nr) obj;
            return this.u.equals(nrVar.u) && this.nr.equals(nrVar.nr);
        }

        public int hashCode() {
            return this.u.hashCode() + (this.nr.hashCode() * 31);
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.a.iz
        public X509Certificate u(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.nr.invoke(this.u, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
            } catch (IllegalAccessException e) {
                throw com.bytedance.sdk.component.fx.nr.u.fx.u("unable to get issues and signature", (Exception) e);
            } catch (InvocationTargetException unused) {
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.fx.nr.u.x.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0217u extends com.bytedance.sdk.component.fx.nr.u.a.fx {
        private final Method nr;
        private final Object u;

        public C0217u(Object obj, Method method) {
            this.u = obj;
            this.nr = method;
        }

        public boolean equals(Object obj) {
            return obj instanceof C0217u;
        }

        public int hashCode() {
            return 0;
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.a.fx
        public List<Certificate> u(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.nr.invoke(this.u, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), EncryptUtils.RSA_ENCRYPT_ALGORITHM, str);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }
    }

    public u(Class<?> cls, b<Socket> bVar, b<Socket> bVar2, b<Socket> bVar3, b<Socket> bVar4) {
        this.u = cls;
        this.nr = bVar;
        this.fx = bVar2;
        this.b = bVar3;
        this.pn = bVar4;
    }

    private static boolean b() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.x.pn
    public boolean nr(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return u(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.nr(str);
        } catch (IllegalAccessException e) {
            e = e;
            throw com.bytedance.sdk.component.fx.nr.u.fx.u("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw com.bytedance.sdk.component.fx.nr.u.fx.u("unable to determine cleartext support", e);
        } catch (NoClassDefFoundError unused2) {
            if (Build.VERSION.SDK_INT < 23) {
                return super.nr(str);
            }
            return false;
        } catch (InvocationTargetException e3) {
            e = e3;
            throw com.bytedance.sdk.component.fx.nr.u.fx.u("unable to determine cleartext support", e);
        }
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.x.pn
    public void u(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (!com.bytedance.sdk.component.fx.nr.u.fx.u(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e2;
            }
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        } catch (SecurityException e3) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e3);
            throw iOException2;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class fx {
        private final Method fx;
        private final Method nr;
        private final Method u;

        public fx(Method method, Method method2, Method method3) {
            this.u = method;
            this.nr = method2;
            this.fx = method3;
        }

        public Object u(String str) {
            Method method = this.u;
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, new Object[0]);
                    this.nr.invoke(objInvoke, str);
                    return objInvoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        public boolean u(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.fx.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public static fx u() {
            Method method;
            Method method2;
            Method method3;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                method = cls.getMethod("get", new Class[0]);
                method3 = cls.getMethod("open", String.class);
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
            } catch (Exception unused) {
                method = null;
                method2 = null;
                method3 = null;
            }
            return new fx(method, method3, method2);
        }
    }

    private boolean nr(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.nr(str);
        }
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.x.pn
    public iz nr(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new nr(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.nr(x509TrustManager);
        }
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.x.pn
    public void u(SSLSocket sSLSocket, String str, List<qq> list) {
        if (str != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                try {
                    SSLSockets.setUseSessionTickets(sSLSocket, true);
                    wk7.a();
                    SNIHostName sNIHostNameA = uk7.a(str);
                    SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                    sSLParameters.setServerNames(Collections.singletonList(sNIHostNameA));
                    sSLSocket.setSSLParameters(sSLParameters);
                } catch (Throwable unused) {
                }
            } else {
                this.nr.nr(sSLSocket, Boolean.TRUE);
                this.fx.nr(sSLSocket, str);
            }
        }
        b<Socket> bVar = this.pn;
        if (bVar == null || !bVar.u(sSLSocket)) {
            return;
        }
        this.pn.b(sSLSocket, pn.nr(list));
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.x.pn
    public String u(SSLSocket sSLSocket) {
        byte[] bArr;
        b<Socket> bVar = this.b;
        if (bVar == null || !bVar.u(sSLSocket) || (bArr = (byte[]) this.b.b(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, com.bytedance.sdk.component.fx.nr.u.fx.pn);
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.x.pn
    public void u(int i, String str, Throwable th) {
        int iMin;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int iIndexOf = str.indexOf(10, i2);
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf, i2 + 4000);
                str.substring(i2, iMin);
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i2 = iMin;
                }
            }
            i2 = iMin + 1;
        }
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.x.pn
    public Object u(String str) {
        return this.iz.u(str);
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.x.pn
    public void u(String str, Object obj) {
        if (this.iz.u(obj)) {
            return;
        }
        u(5, str, (Throwable) null);
    }

    private boolean u(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return nr(str, cls, obj);
        }
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.x.pn
    public com.bytedance.sdk.component.fx.nr.u.a.fx u(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0217u(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.u(x509TrustManager);
        }
    }

    public static pn u() {
        Class<?> cls;
        b bVar;
        b bVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            b bVar3 = new b(null, "setUseSessionTickets", Boolean.TYPE);
            b bVar4 = new b(null, "setHostname", String.class);
            if (b()) {
                b bVar5 = new b(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                bVar2 = new b(null, "setAlpnProtocols", byte[].class);
                bVar = bVar5;
            } else {
                bVar = null;
                bVar2 = null;
            }
            return new u(cls2, bVar3, bVar4, bVar, bVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }
}
