package com.oplus.tblplayer.wrapper;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class SSLSocketFactoryWrapper extends SSLSocketFactory {
    private final SSLSocketFactory realSslSocketFactory;

    public SSLSocketFactoryWrapper(SSLSocketFactory sSLSocketFactory) {
        this.realSslSocketFactory = sSLSocketFactory;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        Socket socketCreateSocket = this.realSslSocketFactory.createSocket();
        if (socketCreateSocket != null) {
            return new SSLSocketWrapper(socketCreateSocket);
        }
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.realSslSocketFactory.getDefaultCipherSuites();
    }

    public SSLSocketFactory getRealSslSocketFactory() {
        return this.realSslSocketFactory;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.realSslSocketFactory.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        Socket socketCreateSocket = this.realSslSocketFactory.createSocket(str, i);
        if (socketCreateSocket != null) {
            return new SSLSocketWrapper(socketCreateSocket);
        }
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        Socket socketCreateSocket = this.realSslSocketFactory.createSocket(str, i, inetAddress, i2);
        if (socketCreateSocket != null) {
            return new SSLSocketWrapper(socketCreateSocket);
        }
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Socket socketCreateSocket = this.realSslSocketFactory.createSocket(inetAddress, i);
        if (socketCreateSocket != null) {
            return new SSLSocketWrapper(socketCreateSocket);
        }
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Socket socketCreateSocket = this.realSslSocketFactory.createSocket(inetAddress, i, inetAddress2, i2);
        if (socketCreateSocket != null) {
            return new SSLSocketWrapper(socketCreateSocket);
        }
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket socketCreateSocket = this.realSslSocketFactory.createSocket(socket, str, i, z);
        if (socketCreateSocket != null) {
            return new SSLSocketWrapper(socketCreateSocket);
        }
        return null;
    }
}
