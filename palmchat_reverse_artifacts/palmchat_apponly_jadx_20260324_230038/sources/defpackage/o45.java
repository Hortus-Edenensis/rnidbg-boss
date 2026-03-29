package defpackage;

import android.content.Context;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public class o45 extends SSLSocketFactory {

    @Deprecated
    public static final X509HostnameVerifier i = new BrowserCompatHostnameVerifier();

    @Deprecated
    public static final X509HostnameVerifier j = new StrictHostnameVerifier();
    public static final String k = o45.class.getSimpleName();
    public static volatile o45 l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SSLContext f19693a = null;
    public SSLSocket b = null;
    public Context c;
    public String[] d;
    public X509TrustManager e;
    public String[] f;
    public String[] g;
    public String[] h;

    public o45(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException {
        if (context == null) {
            ga7.d(k, "SecureSSLSocketFactory: context is null");
            return;
        }
        c(context);
        d(o05.f());
        r45 r45VarA = q45.a(context);
        this.e = r45VarA;
        this.f19693a.init(null, new X509TrustManager[]{r45VarA}, secureRandom);
    }

    @Deprecated
    public static o45 b(Context context) throws IllegalAccessException, NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        wp0.b(context);
        if (l == null) {
            synchronized (o45.class) {
                if (l == null) {
                    l = new o45(context, null);
                }
            }
        }
        if (l.c == null && context != null) {
            l.c(context);
        }
        ga7.b(k, "getInstance: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        return l;
    }

    public final void a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (tv6.a(this.h)) {
            z = false;
        } else {
            ga7.e(k, "set protocols");
            o05.e((SSLSocket) socket, this.h);
            z = true;
        }
        if (tv6.a(this.g) && tv6.a(this.f)) {
            z2 = false;
        } else {
            ga7.e(k, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            o05.d(sSLSocket);
            if (tv6.a(this.g)) {
                o05.b(sSLSocket, this.f);
            } else {
                o05.h(sSLSocket, this.g);
            }
        }
        if (!z) {
            ga7.e(k, "set default protocols");
            o05.d((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        ga7.e(k, "set default cipher suites");
        o05.c((SSLSocket) socket);
    }

    public void c(Context context) {
        this.c = context.getApplicationContext();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException {
        ga7.e(k, "createSocket: host , port");
        Socket socketCreateSocket = this.f19693a.getSocketFactory().createSocket(str, i2);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.b = sSLSocket;
            this.d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public void d(SSLContext sSLContext) {
        this.f19693a = sSLContext;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.d;
        return strArr != null ? strArr : new String[0];
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException {
        return createSocket(str, i2);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        ga7.e(k, "createSocket s host port autoClose");
        Socket socketCreateSocket = this.f19693a.getSocketFactory().createSocket(socket, str, i2, z);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.b = sSLSocket;
            this.d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }
}
