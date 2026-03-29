package com.oplus.tblplayer.wrapper;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.SocketFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class SocketFactoryWrapper extends SocketFactory {
    private final SocketFactory realSocketFactory;

    public SocketFactoryWrapper(SocketFactory socketFactory) {
        this.realSocketFactory = socketFactory;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        Socket socketCreateSocket = this.realSocketFactory.createSocket();
        if (socketCreateSocket != null) {
            return new SocketWrapper(socketCreateSocket);
        }
        return null;
    }

    public SocketFactory getRealSocketFactory() {
        return this.realSocketFactory;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        Socket socketCreateSocket = this.realSocketFactory.createSocket(str, i);
        if (socketCreateSocket != null) {
            return new SocketWrapper(socketCreateSocket);
        }
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        Socket socketCreateSocket = this.realSocketFactory.createSocket(str, i, inetAddress, i2);
        if (socketCreateSocket != null) {
            return new SocketWrapper(socketCreateSocket);
        }
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Socket socketCreateSocket = this.realSocketFactory.createSocket(inetAddress, i);
        if (socketCreateSocket != null) {
            return new SocketWrapper(socketCreateSocket);
        }
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Socket socketCreateSocket = this.realSocketFactory.createSocket(inetAddress, i, inetAddress2, i2);
        if (socketCreateSocket != null) {
            return new SocketWrapper(socketCreateSocket);
        }
        return null;
    }
}
