package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class SpdyStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int WINDOW_UPDATE_THRESHOLD = 32768;
    private final SpdyConnection connection;
    private ErrorCode errorCode;
    private final int id;
    private final SpdyDataInputStream in;
    private final SpdyDataOutputStream out;
    private final int priority;
    private long readTimeoutMillis = 0;
    private final List<String> requestHeaders;
    private List<String> responseHeaders;
    private int writeWindowSize;

    /* JADX INFO: compiled from: SearchBox */
    public final class SpdyDataInputStream extends InputStream {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final byte[] buffer;
        private boolean closed;
        private boolean finished;
        private int limit;
        private int pos;
        private int unacknowledgedBytes;

        private void checkNotClosed() throws IOException {
            if (this.closed) {
                throw new IOException("stream closed");
            }
            if (SpdyStream.this.errorCode == null) {
                return;
            }
            throw new IOException("stream was reset: " + SpdyStream.this.errorCode);
        }

        private void waitUntilReadable() throws IOException {
            long jNanoTime;
            long jNanoTime2;
            if (SpdyStream.this.readTimeoutMillis != 0) {
                jNanoTime = System.nanoTime() / 1000000;
                jNanoTime2 = SpdyStream.this.readTimeoutMillis;
            } else {
                jNanoTime = 0;
                jNanoTime2 = 0;
            }
            while (this.pos == -1 && !this.finished && !this.closed && SpdyStream.this.errorCode == null) {
                try {
                    if (SpdyStream.this.readTimeoutMillis == 0) {
                        SpdyStream.this.wait();
                    } else {
                        if (jNanoTime2 <= 0) {
                            throw new SocketTimeoutException();
                        }
                        SpdyStream.this.wait(jNanoTime2);
                        jNanoTime2 = (SpdyStream.this.readTimeoutMillis + jNanoTime) - (System.nanoTime() / 1000000);
                    }
                } catch (InterruptedException unused) {
                    throw new InterruptedIOException();
                }
            }
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            synchronized (SpdyStream.this) {
                checkNotClosed();
                int i = this.pos;
                if (i == -1) {
                    return 0;
                }
                int i2 = this.limit;
                if (i2 > i) {
                    return i2 - i;
                }
                return i2 + (this.buffer.length - i);
            }
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (SpdyStream.this) {
                this.closed = true;
                SpdyStream.this.notifyAll();
            }
            SpdyStream.this.cancelStreamIfNecessary();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            return Util.readSingleByte(this);
        }

        public void receive(InputStream inputStream, int i) throws IOException {
            boolean z;
            int i2;
            int i3;
            int i4;
            boolean z2;
            if (i == 0) {
                return;
            }
            synchronized (SpdyStream.this) {
                z = this.finished;
                i2 = this.pos;
                i3 = this.limit;
                i4 = 0;
                z2 = i > this.buffer.length - available();
            }
            if (z2) {
                Util.skipByReading(inputStream, i);
                SpdyStream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                return;
            }
            if (z) {
                Util.skipByReading(inputStream, i);
                return;
            }
            if (i2 < i3) {
                int iMin = Math.min(i, this.buffer.length - i3);
                Util.readFully(inputStream, this.buffer, i3, iMin);
                int i5 = i3 + iMin;
                i -= iMin;
                if (i5 != this.buffer.length) {
                    i4 = i5;
                }
            } else {
                i4 = i3;
            }
            if (i > 0) {
                Util.readFully(inputStream, this.buffer, i4, i);
                i4 += i;
            }
            synchronized (SpdyStream.this) {
                this.limit = i4;
                if (this.pos == -1) {
                    this.pos = i3;
                    SpdyStream.this.notifyAll();
                }
            }
        }

        private SpdyDataInputStream() {
            this.buffer = new byte[65536];
            this.pos = -1;
            this.unacknowledgedBytes = 0;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3;
            synchronized (SpdyStream.this) {
                Util.checkOffsetAndCount(bArr.length, i, i2);
                waitUntilReadable();
                checkNotClosed();
                int i4 = this.pos;
                if (i4 == -1) {
                    return -1;
                }
                if (this.limit <= i4) {
                    int iMin = Math.min(i2, this.buffer.length - i4);
                    System.arraycopy(this.buffer, this.pos, bArr, i, iMin);
                    int i5 = this.pos + iMin;
                    this.pos = i5;
                    i3 = iMin + 0;
                    if (i5 == this.buffer.length) {
                        this.pos = 0;
                    }
                } else {
                    i3 = 0;
                }
                if (i3 < i2) {
                    int iMin2 = Math.min(this.limit - this.pos, i2 - i3);
                    System.arraycopy(this.buffer, this.pos, bArr, i + i3, iMin2);
                    this.pos += iMin2;
                    i3 += iMin2;
                }
                int i6 = this.unacknowledgedBytes + i3;
                this.unacknowledgedBytes = i6;
                if (i6 >= 32768) {
                    SpdyStream.this.connection.writeWindowUpdateLater(SpdyStream.this.id, this.unacknowledgedBytes);
                    this.unacknowledgedBytes = 0;
                }
                if (this.pos == this.limit) {
                    this.pos = -1;
                    this.limit = 0;
                }
                return i3;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class SpdyDataOutputStream extends OutputStream {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final byte[] buffer;
        private boolean closed;
        private boolean finished;
        private int pos;
        private int unacknowledgedBytes;

        private void checkNotClosed() throws IOException {
            synchronized (SpdyStream.this) {
                if (this.closed) {
                    throw new IOException("stream closed");
                }
                if (this.finished) {
                    throw new IOException("stream finished");
                }
                if (SpdyStream.this.errorCode != null) {
                    throw new IOException("stream was reset: " + SpdyStream.this.errorCode);
                }
            }
        }

        private void waitUntilWritable(int i, boolean z) throws IOException {
            while (this.unacknowledgedBytes + i >= SpdyStream.this.writeWindowSize) {
                try {
                    SpdyStream.this.wait();
                    if (!z && this.closed) {
                        throw new IOException("stream closed");
                    }
                    if (this.finished) {
                        throw new IOException("stream finished");
                    }
                    if (SpdyStream.this.errorCode != null) {
                        throw new IOException("stream was reset: " + SpdyStream.this.errorCode);
                    }
                } catch (InterruptedException unused) {
                    throw new InterruptedIOException();
                }
            }
        }

        private void writeFrame(boolean z) throws IOException {
            int i = this.pos;
            synchronized (SpdyStream.this) {
                waitUntilWritable(i, z);
                this.unacknowledgedBytes += i;
            }
            SpdyStream.this.connection.writeData(SpdyStream.this.id, z, this.buffer, 0, this.pos);
            this.pos = 0;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (SpdyStream.this) {
                if (this.closed) {
                    return;
                }
                this.closed = true;
                if (!SpdyStream.this.out.finished) {
                    writeFrame(true);
                }
                SpdyStream.this.connection.flush();
                SpdyStream.this.cancelStreamIfNecessary();
            }
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            checkNotClosed();
            if (this.pos > 0) {
                writeFrame(false);
                SpdyStream.this.connection.flush();
            }
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            Util.writeSingleByte(this, i);
        }

        private SpdyDataOutputStream() {
            this.buffer = new byte[8192];
            this.pos = 0;
            this.unacknowledgedBytes = 0;
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            Util.checkOffsetAndCount(bArr.length, i, i2);
            checkNotClosed();
            while (i2 > 0) {
                if (this.pos == this.buffer.length) {
                    writeFrame(false);
                }
                int iMin = Math.min(i2, this.buffer.length - this.pos);
                System.arraycopy(bArr, i, this.buffer, this.pos, iMin);
                this.pos += iMin;
                i += iMin;
                i2 -= iMin;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SpdyStream(int i, SpdyConnection spdyConnection, boolean z, boolean z2, int i2, List<String> list, Settings settings) {
        SpdyDataInputStream spdyDataInputStream = new SpdyDataInputStream();
        this.in = spdyDataInputStream;
        SpdyDataOutputStream spdyDataOutputStream = new SpdyDataOutputStream();
        this.out = spdyDataOutputStream;
        this.errorCode = null;
        if (spdyConnection == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.id = i;
        this.connection = spdyConnection;
        spdyDataInputStream.finished = z2;
        spdyDataOutputStream.finished = z;
        this.priority = i2;
        this.requestHeaders = list;
        setSettings(settings);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelStreamIfNecessary() throws IOException {
        boolean z;
        boolean zIsOpen;
        synchronized (this) {
            z = !this.in.finished && this.in.closed && (this.out.finished || this.out.closed);
            zIsOpen = isOpen();
        }
        if (z) {
            close(ErrorCode.CANCEL);
        } else {
            if (zIsOpen) {
                return;
            }
            this.connection.removeStream(this.id);
        }
    }

    private boolean closeInternal(ErrorCode errorCode) {
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.in.finished && this.out.finished) {
                return false;
            }
            this.errorCode = errorCode;
            notifyAll();
            this.connection.removeStream(this.id);
            return true;
        }
    }

    private void setSettings(Settings settings) {
        this.writeWindowSize = settings != null ? settings.getInitialWindowSize(65536) : 65536;
    }

    public void close(ErrorCode errorCode) throws IOException {
        if (closeInternal(errorCode)) {
            this.connection.writeSynReset(this.id, errorCode);
        }
    }

    public void closeLater(ErrorCode errorCode) {
        if (closeInternal(errorCode)) {
            this.connection.writeSynResetLater(this.id, errorCode);
        }
    }

    public SpdyConnection getConnection() {
        return this.connection;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public InputStream getInputStream() {
        return this.in;
    }

    public OutputStream getOutputStream() {
        synchronized (this) {
            if (this.responseHeaders == null && !isLocallyInitiated()) {
                throw new IllegalStateException("reply before requesting the output stream");
            }
        }
        return this.out;
    }

    public int getPriority() {
        return this.priority;
    }

    public long getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public List<String> getRequestHeaders() {
        return this.requestHeaders;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
    
        if (r8 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
    
        throw new java.io.IOException("stream was reset: " + r11.errorCode);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized List<String> getResponseHeaders() throws IOException {
        long jNanoTime;
        long jNanoTime2;
        List<String> list;
        if (this.readTimeoutMillis != 0) {
            jNanoTime = System.nanoTime() / 1000000;
            jNanoTime2 = this.readTimeoutMillis;
        } else {
            jNanoTime = 0;
            jNanoTime2 = 0;
        }
        while (true) {
            try {
                list = this.responseHeaders;
                if (list != null || this.errorCode != null) {
                    break;
                }
                if (this.readTimeoutMillis == 0) {
                    wait();
                } else {
                    if (jNanoTime2 <= 0) {
                        throw new SocketTimeoutException("Read response header timeout. readTimeoutMillis: " + this.readTimeoutMillis);
                    }
                    wait(jNanoTime2);
                    jNanoTime2 = (this.readTimeoutMillis + jNanoTime) - (System.nanoTime() / 1000000);
                }
            } catch (InterruptedException e) {
                InterruptedIOException interruptedIOException = new InterruptedIOException();
                interruptedIOException.initCause(e);
                throw interruptedIOException;
            }
        }
        return list;
    }

    public boolean isLocallyInitiated() {
        return this.connection.client == (this.id % 2 == 1);
    }

    public synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        if ((this.in.finished || this.in.closed) && (this.out.finished || this.out.closed)) {
            if (this.responseHeaders != null) {
                return false;
            }
        }
        return true;
    }

    public void receiveData(InputStream inputStream, int i) throws IOException {
        this.in.receive(inputStream, i);
    }

    public void receiveFin() {
        boolean zIsOpen;
        synchronized (this) {
            this.in.finished = true;
            zIsOpen = isOpen();
            notifyAll();
        }
        if (zIsOpen) {
            return;
        }
        this.connection.removeStream(this.id);
    }

    public void receiveHeaders(List<String> list, HeadersMode headersMode) {
        ErrorCode errorCode;
        boolean zIsOpen;
        synchronized (this) {
            errorCode = null;
            zIsOpen = true;
            if (this.responseHeaders == null) {
                if (headersMode.failIfHeadersAbsent()) {
                    errorCode = ErrorCode.PROTOCOL_ERROR;
                } else {
                    this.responseHeaders = list;
                    zIsOpen = isOpen();
                    notifyAll();
                }
            } else if (headersMode.failIfHeadersPresent()) {
                errorCode = ErrorCode.STREAM_IN_USE;
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.responseHeaders);
                arrayList.addAll(list);
                this.responseHeaders = arrayList;
            }
        }
        if (errorCode != null) {
            closeLater(errorCode);
        } else {
            if (zIsOpen) {
                return;
            }
            this.connection.removeStream(this.id);
        }
    }

    public synchronized void receiveRstStream(ErrorCode errorCode) {
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    public void receiveSettings(Settings settings) {
        setSettings(settings);
        notifyAll();
    }

    public synchronized void receiveWindowUpdate(int i) {
        this.out.unacknowledgedBytes -= i;
        notifyAll();
    }

    public void reply(List<String> list, boolean z) throws IOException {
        boolean z2;
        synchronized (this) {
            try {
                if (list == null) {
                    throw new NullPointerException("responseHeaders == null");
                }
                if (isLocallyInitiated()) {
                    throw new IllegalStateException("cannot reply to a locally initiated stream");
                }
                if (this.responseHeaders != null) {
                    throw new IllegalStateException("reply already sent");
                }
                this.responseHeaders = list;
                if (z) {
                    z2 = false;
                } else {
                    z2 = true;
                    this.out.finished = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.connection.writeSynReply(this.id, z2, list);
    }

    public void setReadTimeout(long j) {
        this.readTimeoutMillis = j;
    }
}
