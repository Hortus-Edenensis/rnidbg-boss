package com.oplus.tblplayer.wrapper;

import com.oplus.tblplayer.utils.ReflectUtil;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImplFactory;
import java.nio.channels.SocketChannel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class SocketWrapper extends Socket {
    private final Socket realSocket;

    public SocketWrapper(Socket socket) {
        this.realSocket = socket;
    }

    public static synchronized void setSocketImplFactory(SocketImplFactory socketImplFactory) throws IOException {
        synchronized (SocketWrapper.class) {
            throw new RuntimeException("Stub!");
        }
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

    @Override // java.net.Socket
    public SocketChannel getChannel() {
        return this.realSocket.getChannel();
    }

    public FileDescriptor getFileDescriptor$() {
        return (FileDescriptor) ReflectUtil.invokeNoException(this.realSocket.getClass(), this.realSocket, "getFileDescriptor$", (Class<?>[]) null, new Object[0]);
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

    @Override // java.net.Socket
    public synchronized int getSendBufferSize() throws SocketException {
        return this.realSocket.getSendBufferSize();
    }

    @Override // java.net.Socket
    public int getSoLinger() throws SocketException {
        return this.realSocket.getSoLinger();
    }

    @Override // java.net.Socket
    public synchronized int getSoTimeout() throws SocketException {
        return this.realSocket.getSoTimeout();
    }

    @Override // java.net.Socket
    public boolean getTcpNoDelay() throws SocketException {
        return this.realSocket.getTcpNoDelay();
    }

    @Override // java.net.Socket
    public int getTrafficClass() throws SocketException {
        return this.realSocket.getTrafficClass();
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

    @Override // java.net.Socket
    public void sendUrgentData(int i) throws IOException {
        this.realSocket.sendUrgentData(i);
    }

    @Override // java.net.Socket
    public void setKeepAlive(boolean z) throws SocketException {
        this.realSocket.setKeepAlive(z);
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

    @Override // java.net.Socket
    public void shutdownInput() throws IOException {
        this.realSocket.shutdownInput();
    }

    @Override // java.net.Socket
    public void shutdownOutput() throws IOException {
        this.realSocket.shutdownOutput();
    }

    @Override // java.net.Socket
    public String toString() {
        return this.realSocket.toString();
    }

    @Override // java.net.Socket
    public void connect(SocketAddress socketAddress, int i) throws IOException {
        this.realSocket.connect(socketAddress, i);
    }
}
