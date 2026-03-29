package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.http.HttpAuthenticator;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpTransport;
import com.squareup.okhttp.internal.http.RawHeaders;
import com.squareup.okhttp.internal.http.SpdyTransport;
import com.squareup.okhttp.internal.spdy.SpdyConnection;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Arrays;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class Connection implements Closeable {
    private boolean connected = false;
    private int httpMinorVersion = 1;
    private long idleStartTimeNs;
    private InputStream in;
    private OutputStream out;
    private final Route route;
    private Socket socket;
    private SpdyConnection spdyConnection;
    private static final byte[] NPN_PROTOCOLS = {6, 115, 112, 100, 121, 47, 51, 8, 104, 116, 116, 112, 47, 49, 46, 49};
    private static final byte[] SPDY3 = {115, 112, 100, 121, 47, 51};
    private static final byte[] HTTP_11 = {104, 116, 116, 112, 47, 49, 46, 49};

    public Connection(Route route) {
        this.route = route;
    }

    private void makeTunnel(TunnelRequest tunnelRequest) throws IOException {
        RawHeaders requestHeaders = tunnelRequest.getRequestHeaders();
        while (true) {
            this.out.write(requestHeaders.toBytes());
            RawHeaders rawHeadersFromBytes = RawHeaders.fromBytes(this.in);
            int responseCode = rawHeadersFromBytes.getResponseCode();
            if (responseCode == 200) {
                return;
            }
            if (responseCode != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + rawHeadersFromBytes.getResponseCode());
            }
            RawHeaders rawHeaders = new RawHeaders(requestHeaders);
            URL url = new URL(BaseConstants.SCHEME_HTTPS, tunnelRequest.host, tunnelRequest.port, "/");
            Route route = this.route;
            if (!HttpAuthenticator.processAuthHeader(route.address.authenticator, 407, rawHeadersFromBytes, rawHeaders, route.proxy, url)) {
                throw new IOException("Failed to authenticate with proxy");
            }
            requestHeaders = rawHeaders;
        }
    }

    private void streamWrapper() throws IOException {
        this.in = new BufferedInputStream(this.in, 4096);
        this.out = new BufferedOutputStream(this.out, 256);
    }

    private void upgradeToTls(TunnelRequest tunnelRequest) throws IOException {
        byte[] npnSelectedProtocol;
        Platform platform = Platform.get();
        if (requiresTunnel()) {
            makeTunnel(tunnelRequest);
        }
        Address address = this.route.address;
        Socket socketCreateSocket = address.sslSocketFactory.createSocket(this.socket, address.uriHost, address.uriPort, true);
        this.socket = socketCreateSocket;
        SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
        Route route = this.route;
        if (route.modernTls) {
            platform.enableTlsExtensions(sSLSocket, route.address.uriHost);
        } else {
            platform.supportTlsIntolerantServer(sSLSocket);
        }
        Route route2 = this.route;
        boolean z = route2.modernTls && route2.address.transports.contains("spdy/3");
        if (z) {
            platform.setNpnProtocols(sSLSocket, NPN_PROTOCOLS);
        }
        sSLSocket.startHandshake();
        Address address2 = this.route.address;
        if (!address2.hostnameVerifier.verify(address2.uriHost, sSLSocket.getSession())) {
            throw new IOException("Hostname '" + this.route.address.uriHost + "' was not verified");
        }
        this.out = sSLSocket.getOutputStream();
        this.in = sSLSocket.getInputStream();
        streamWrapper();
        if (!z || (npnSelectedProtocol = platform.getNpnSelectedProtocol(sSLSocket)) == null) {
            return;
        }
        if (Arrays.equals(npnSelectedProtocol, SPDY3)) {
            sSLSocket.setSoTimeout(0);
            SpdyConnection spdyConnectionBuild = new SpdyConnection.Builder(this.route.address.getUriHost(), true, this.in, this.out).build();
            this.spdyConnection = spdyConnectionBuild;
            spdyConnectionBuild.sendConnectionHeader();
            return;
        }
        if (Arrays.equals(npnSelectedProtocol, HTTP_11)) {
            return;
        }
        throw new IOException("Unexpected NPN transport " + new String(npnSelectedProtocol, "ISO-8859-1"));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.socket.close();
    }

    public void connect(int i, int i2, TunnelRequest tunnelRequest) throws IOException {
        if (this.connected) {
            throw new IllegalStateException("already connected");
        }
        this.socket = this.route.proxy.type() != Proxy.Type.HTTP ? new Socket(this.route.proxy) : new Socket();
        Platform.get().connectSocket(this.socket, this.route.inetSocketAddress, i);
        this.socket.setSoTimeout(i2);
        this.in = this.socket.getInputStream();
        this.out = this.socket.getOutputStream();
        if (this.route.address.sslSocketFactory != null) {
            upgradeToTls(tunnelRequest);
        } else {
            streamWrapper();
        }
        this.connected = true;
    }

    public int getHttpMinorVersion() {
        return this.httpMinorVersion;
    }

    public long getIdleStartTimeNs() {
        SpdyConnection spdyConnection = this.spdyConnection;
        return spdyConnection == null ? this.idleStartTimeNs : spdyConnection.getIdleStartTimeNs();
    }

    public Route getRoute() {
        return this.route;
    }

    public Socket getSocket() {
        return this.socket;
    }

    public SpdyConnection getSpdyConnection() {
        return this.spdyConnection;
    }

    public boolean isAlive() {
        return (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) ? false : true;
    }

    public boolean isConnected() {
        return this.connected;
    }

    public boolean isExpired(long j) {
        return getIdleStartTimeNs() < System.nanoTime() - j;
    }

    public boolean isIdle() {
        SpdyConnection spdyConnection = this.spdyConnection;
        return spdyConnection == null || spdyConnection.isIdle();
    }

    public boolean isReadable() {
        if (!(this.in instanceof BufferedInputStream) || isSpdy()) {
            return true;
        }
        BufferedInputStream bufferedInputStream = (BufferedInputStream) this.in;
        try {
            int soTimeout = this.socket.getSoTimeout();
            try {
                this.socket.setSoTimeout(1);
                bufferedInputStream.mark(1);
                if (bufferedInputStream.read() == -1) {
                    return false;
                }
                bufferedInputStream.reset();
                return true;
            } finally {
                this.socket.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public boolean isSpdy() {
        return this.spdyConnection != null;
    }

    public Object newTransport(HttpEngine httpEngine) throws IOException {
        SpdyConnection spdyConnection = this.spdyConnection;
        return spdyConnection != null ? new SpdyTransport(httpEngine, spdyConnection) : new HttpTransport(httpEngine, this.out, this.in);
    }

    public boolean requiresTunnel() {
        Route route = this.route;
        return route.address.sslSocketFactory != null && route.proxy.type() == Proxy.Type.HTTP;
    }

    public void resetIdleStartTime() {
        if (this.spdyConnection != null) {
            throw new IllegalStateException("spdyConnection != null");
        }
        this.idleStartTimeNs = System.nanoTime();
    }

    public void setHttpMinorVersion(int i) {
        this.httpMinorVersion = i;
    }

    public void updateReadTimeout(int i) throws IOException {
        if (!this.connected) {
            throw new IllegalStateException("updateReadTimeout - not connected");
        }
        this.socket.setSoTimeout(i);
    }
}
