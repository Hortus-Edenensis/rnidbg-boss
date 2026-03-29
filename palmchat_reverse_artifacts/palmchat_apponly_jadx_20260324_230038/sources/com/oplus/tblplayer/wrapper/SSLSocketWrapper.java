package com.oplus.tblplayer.wrapper;

import androidx.annotation.RequiresApi;
import com.oplus.tblplayer.utils.ReflectUtil;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.function.BiFunction;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class SSLSocketWrapper extends SSLSocket {
    private final SSLSocket realSocket;

    public SSLSocketWrapper(Socket socket) {
        this.realSocket = (SSLSocket) socket;
    }

    @Override // javax.net.ssl.SSLSocket
    public void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.realSocket.addHandshakeCompletedListener(handshakeCompletedListener);
    }

    @Override // java.net.Socket
    public void bind(SocketAddress socketAddress) throws IOException {
        this.realSocket.bind(socketAddress);
    }

    @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.realSocket.close();
    }

    @Override // java.net.Socket
    public void connect(SocketAddress socketAddress) throws IOException {
        this.realSocket.connect(socketAddress);
    }

    @Deprecated
    public byte[] getAlpnSelectedProtocol() {
        return (byte[]) ReflectUtil.invokeNoException(this.realSocket.getClass(), this.realSocket, "getAlpnSelectedProtocol", (Class<?>[]) null, new Object[0]);
    }

    @Override // javax.net.ssl.SSLSocket
    @RequiresApi(api = 29)
    public String getApplicationProtocol() {
        return this.realSocket.getApplicationProtocol();
    }

    @Override // java.net.Socket
    public SocketChannel getChannel() {
        return this.realSocket.getChannel();
    }

    @Override // javax.net.ssl.SSLSocket
    public boolean getEnableSessionCreation() {
        return this.realSocket.getEnableSessionCreation();
    }

    @Override // javax.net.ssl.SSLSocket
    public String[] getEnabledCipherSuites() {
        return this.realSocket.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocket
    public String[] getEnabledProtocols() {
        return this.realSocket.getEnabledProtocols();
    }

    public FileDescriptor getFileDescriptor$() {
        return (FileDescriptor) ReflectUtil.invokeNoException(this.realSocket.getClass(), this.realSocket, "getFileDescriptor$", (Class<?>[]) null, new Object[0]);
    }

    @Override // javax.net.ssl.SSLSocket
    @RequiresApi(api = 29)
    public String getHandshakeApplicationProtocol() {
        return this.realSocket.getHandshakeApplicationProtocol();
    }

    @Override // javax.net.ssl.SSLSocket
    @RequiresApi(api = 29)
    public BiFunction<SSLSocket, List<String>, String> getHandshakeApplicationProtocolSelector() {
        return this.realSocket.getHandshakeApplicationProtocolSelector();
    }

    @Override // javax.net.ssl.SSLSocket
    @RequiresApi(24)
    public SSLSession getHandshakeSession() {
        return this.realSocket.getHandshakeSession();
    }

    @Override // java.net.Socket
    public InetAddress getInetAddress() {
        return this.realSocket.getInetAddress();
    }

    @Override // java.net.Socket
    public InputStream getInputStream() throws IOException {
        return this.realSocket.getInputStream();
    }

    @Override // java.net.Socket
    public boolean getKeepAlive() throws SocketException {
        return this.realSocket.getKeepAlive();
    }

    @Override // java.net.Socket
    public InetAddress getLocalAddress() {
        return this.realSocket.getLocalAddress();
    }

    @Override // java.net.Socket
    public int getLocalPort() {
        return this.realSocket.getLocalPort();
    }

    @Override // java.net.Socket
    public SocketAddress getLocalSocketAddress() {
        return this.realSocket.getLocalSocketAddress();
    }

    @Override // javax.net.ssl.SSLSocket
    public boolean getNeedClientAuth() {
        return this.realSocket.getNeedClientAuth();
    }

    @Override // java.net.Socket
    public boolean getOOBInline() throws SocketException {
        return this.realSocket.getOOBInline();
    }

    @Override // java.net.Socket
    public OutputStream getOutputStream() throws IOException {
        return this.realSocket.getOutputStream();
    }

    @Override // java.net.Socket
    public int getPort() {
        return this.realSocket.getPort();
    }

    @Override // java.net.Socket
    public synchronized int getReceiveBufferSize() throws SocketException {
        return this.realSocket.getReceiveBufferSize();
    }

    @Override // java.net.Socket
    public SocketAddress getRemoteSocketAddress() {
        return this.realSocket.getRemoteSocketAddress();
    }

    @Override // java.net.Socket
    public boolean getReuseAddress() throws SocketException {
        return this.realSocket.getReuseAddress();
    }

    @Override // javax.net.ssl.SSLSocket
    public SSLParameters getSSLParameters() {
        return this.realSocket.getSSLParameters();
    }

    @Override // java.net.Socket
    public synchronized int getSendBufferSize() throws SocketException {
        return this.realSocket.getSendBufferSize();
    }

    @Override // javax.net.ssl.SSLSocket
    public SSLSession getSession() {
        return this.realSocket.getSession();
    }

    @Override // java.net.Socket
    public int getSoLinger() throws SocketException {
        return this.realSocket.getSoLinger();
    }

    @Override // java.net.Socket
    public synchronized int getSoTimeout() throws SocketException {
        return this.realSocket.getSoTimeout();
    }

    @Override // javax.net.ssl.SSLSocket
    public String[] getSupportedCipherSuites() {
        return this.realSocket.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocket
    public String[] getSupportedProtocols() {
        return this.realSocket.getSupportedProtocols();
    }

    @Override // java.net.Socket
    public boolean getTcpNoDelay() throws SocketException {
        return this.realSocket.getTcpNoDelay();
    }

    @Override // java.net.Socket
    public int getTrafficClass() throws SocketException {
        return this.realSocket.getTrafficClass();
    }

    @Override // javax.net.ssl.SSLSocket
    public boolean getUseClientMode() {
        return this.realSocket.getUseClientMode();
    }

    @Override // javax.net.ssl.SSLSocket
    public boolean getWantClientAuth() {
        return this.realSocket.getWantClientAuth();
    }

    @Override // java.net.Socket
    public boolean isBound() {
        return this.realSocket.isBound();
    }

    @Override // java.net.Socket
    public boolean isClosed() {
        return this.realSocket.isClosed();
    }

    @Override // java.net.Socket
    public boolean isConnected() {
        return this.realSocket.isConnected();
    }

    @Override // java.net.Socket
    public boolean isInputShutdown() {
        return this.realSocket.isInputShutdown();
    }

    @Override // java.net.Socket
    public boolean isOutputShutdown() {
        return this.realSocket.isOutputShutdown();
    }

    @Override // javax.net.ssl.SSLSocket
    public void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.realSocket.removeHandshakeCompletedListener(handshakeCompletedListener);
    }

    @Override // java.net.Socket
    public void sendUrgentData(int i) throws IOException {
        this.realSocket.sendUrgentData(i);
    }

    @Deprecated
    public void setAlpnProtocols(byte[] bArr) {
        ReflectUtil.invokeNoException(this.realSocket.getClass(), this.realSocket, "setAlpnProtocols", (Class<?>[]) new Class[]{byte[].class}, bArr);
    }

    public void setApplicationProtocols(String[] strArr) {
        ReflectUtil.invokeNoException(this.realSocket.getClass(), this.realSocket, "setApplicationProtocols", (Class<?>[]) new Class[]{String[].class}, strArr);
    }

    @Override // javax.net.ssl.SSLSocket
    public void setEnableSessionCreation(boolean z) {
        this.realSocket.setEnableSessionCreation(z);
    }

    @Override // javax.net.ssl.SSLSocket
    public void setEnabledCipherSuites(String[] strArr) {
        this.realSocket.setEnabledCipherSuites(strArr);
    }

    @Override // javax.net.ssl.SSLSocket
    public void setEnabledProtocols(String[] strArr) {
        this.realSocket.setEnabledProtocols(strArr);
    }

    @Override // javax.net.ssl.SSLSocket
    @RequiresApi(api = 29)
    public void setHandshakeApplicationProtocolSelector(BiFunction<SSLSocket, List<String>, String> biFunction) {
        this.realSocket.setHandshakeApplicationProtocolSelector(biFunction);
    }

    public void setHostname(String str) {
        ReflectUtil.invokeNoException(this.realSocket.getClass(), this.realSocket, "setHostname", (Class<?>[]) new Class[]{String.class}, str);
    }

    @Override // java.net.Socket
    public void setKeepAlive(boolean z) throws SocketException {
        this.realSocket.setKeepAlive(z);
    }

    @Override // javax.net.ssl.SSLSocket
    public void setNeedClientAuth(boolean z) {
        this.realSocket.setNeedClientAuth(z);
    }

    @Override // java.net.Socket
    public void setOOBInline(boolean z) throws SocketException {
        this.realSocket.setOOBInline(z);
    }

    @Override // java.net.Socket
    public void setPerformancePreferences(int i, int i2, int i3) {
        this.realSocket.setPerformancePreferences(i, i2, i3);
    }

    @Override // java.net.Socket
    public synchronized void setReceiveBufferSize(int i) throws SocketException {
        this.realSocket.setReceiveBufferSize(i);
    }

    @Override // java.net.Socket
    public void setReuseAddress(boolean z) throws SocketException {
        this.realSocket.setReuseAddress(z);
    }

    @Override // javax.net.ssl.SSLSocket
    public void setSSLParameters(SSLParameters sSLParameters) {
        this.realSocket.setSSLParameters(sSLParameters);
    }

    @Override // java.net.Socket
    public synchronized void setSendBufferSize(int i) throws SocketException {
        this.realSocket.setSendBufferSize(i);
    }

    @Override // java.net.Socket
    public void setSoLinger(boolean z, int i) throws SocketException {
        this.realSocket.setSoLinger(z, i);
    }

    @Override // java.net.Socket
    public synchronized void setSoTimeout(int i) throws SocketException {
        this.realSocket.setSoTimeout(i);
    }

    @Override // java.net.Socket
    public void setTcpNoDelay(boolean z) throws SocketException {
        this.realSocket.setTcpNoDelay(z);
    }

    @Override // java.net.Socket
    public void setTrafficClass(int i) throws SocketException {
        this.realSocket.setTrafficClass(i);
    }

    @Override // javax.net.ssl.SSLSocket
    public void setUseClientMode(boolean z) {
        this.realSocket.setUseClientMode(z);
    }

    public void setUseSessionTickets(boolean z) {
        ReflectUtil.invokeNoException(this.realSocket.getClass(), this.realSocket, "setUseSessionTickets", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
    }

    @Override // javax.net.ssl.SSLSocket
    public void setWantClientAuth(boolean z) {
        this.realSocket.setWantClientAuth(z);
    }

    @Override // java.net.Socket
    public void shutdownInput() throws IOException {
        this.realSocket.shutdownInput();
    }

    @Override // java.net.Socket
    public void shutdownOutput() throws IOException {
        this.realSocket.shutdownOutput();
    }

    @Override // javax.net.ssl.SSLSocket
    public void startHandshake() throws IOException {
        this.realSocket.startHandshake();
    }

    @Override // javax.net.ssl.SSLSocket, java.net.Socket
    public String toString() {
        return this.realSocket.toString();
    }

    @Override // java.net.Socket
    public void connect(SocketAddress socketAddress, int i) throws IOException {
        this.realSocket.connect(socketAddress, i);
    }

    @Deprecated
    public void setAlpnProtocols(String[] strArr) {
        ReflectUtil.invokeNoException(this.realSocket.getClass(), this.realSocket, "setAlpnProtocols", (Class<?>[]) new Class[]{String[].class}, strArr);
    }
}
