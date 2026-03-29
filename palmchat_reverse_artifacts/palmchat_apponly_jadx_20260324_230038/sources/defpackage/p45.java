package defpackage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class p45 extends SSLSocketFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SSLContext f19937a;
    public SSLSocket b = null;
    public String[] c;
    public X509TrustManager d;
    public String[] e;
    public String[] f;
    public String[] g;

    @Deprecated
    public p45(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f19937a = null;
        this.f19937a = o05.f();
        b(x509TrustManager);
        this.f19937a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public final void a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (tv6.a(this.g)) {
            z = false;
        } else {
            ga7.e("SSLFNew", "set protocols");
            o05.e((SSLSocket) socket, this.g);
            z = true;
        }
        if (tv6.a(this.f) && tv6.a(this.e)) {
            z2 = false;
        } else {
            ga7.e("SSLFNew", "set cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            o05.d(sSLSocket);
            if (tv6.a(this.f)) {
                o05.b(sSLSocket, this.e);
            } else {
                o05.h(sSLSocket, this.f);
            }
        }
        if (!z) {
            ga7.e("SSLFNew", "set default protocols");
            o05.d((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        ga7.e("SSLFNew", "set default cipher");
        o05.c((SSLSocket) socket);
    }

    public void b(X509TrustManager x509TrustManager) {
        this.d = x509TrustManager;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        ga7.e("SSLFNew", "createSocket: host , port");
        Socket socketCreateSocket = this.f19937a.getSocketFactory().createSocket(str, i);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.b = sSLSocket;
            this.c = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.c;
        return strArr != null ? strArr : new String[0];
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return createSocket(str, i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        ga7.e("SSLFNew", "createSocket");
        Socket socketCreateSocket = this.f19937a.getSocketFactory().createSocket(socket, str, i, z);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.b = sSLSocket;
            this.c = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }
}
