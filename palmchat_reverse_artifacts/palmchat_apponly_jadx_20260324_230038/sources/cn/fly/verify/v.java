package cn.fly.verify;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class v extends SSLSocketFactory {
    private static final String[] b = {"TLSv1.2"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected SSLSocketFactory f2443a;
    private String c;

    public v(SSLSocketFactory sSLSocketFactory) {
        HttpsURLConnection.getDefaultSSLSocketFactory();
        this.f2443a = sSLSocketFactory;
    }

    public String a() {
        return this.c;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return a(this.f2443a.createSocket());
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f2443a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f2443a.getSupportedCipherSuites();
    }

    public String toString() {
        return "Tls12SocketFactory";
    }

    private Socket a(Socket socket) {
        this.c = socket.getLocalAddress().getHostAddress();
        return socket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        return a(this.f2443a.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return a(this.f2443a.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return a(this.f2443a.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return a(this.f2443a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return a(this.f2443a.createSocket(socket, str, i, z));
    }
}
