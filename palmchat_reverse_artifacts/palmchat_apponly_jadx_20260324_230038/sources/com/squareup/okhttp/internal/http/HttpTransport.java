package com.squareup.okhttp.internal.http;

import com.huawei.openalliance.ad.constant.x;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.internal.AbstractOutputStream;
import com.squareup.okhttp.internal.Util;
import com.umeng.analytics.pro.dn;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.ProtocolException;
import java.net.Socket;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class HttpTransport implements Transport {
    public static final int DEFAULT_CHUNK_LENGTH = 1024;
    private static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;
    private final HttpEngine httpEngine;
    private OutputStream requestOut;
    private final InputStream socketIn;
    private final OutputStream socketOut;

    /* JADX INFO: compiled from: SearchBox */
    public static class ChunkedInputStream extends AbstractHttpInputStream {
        private static final int NO_CHUNK_YET = -1;
        private int bytesRemainingInChunk;
        private boolean hasMoreChunks;
        private final HttpTransport transport;

        public ChunkedInputStream(InputStream inputStream, CacheRequest cacheRequest, HttpTransport httpTransport) throws IOException {
            super(inputStream, httpTransport.httpEngine, cacheRequest);
            this.bytesRemainingInChunk = -1;
            this.hasMoreChunks = true;
            this.transport = httpTransport;
        }

        private void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk != -1) {
                Util.readAsciiLine(this.in);
            }
            String asciiLine = Util.readAsciiLine(this.in);
            int iIndexOf = asciiLine.indexOf(x.aQ);
            if (iIndexOf != -1) {
                asciiLine = asciiLine.substring(0, iIndexOf);
            }
            try {
                int i = Integer.parseInt(asciiLine.trim(), 16);
                this.bytesRemainingInChunk = i;
                if (i == 0) {
                    this.hasMoreChunks = false;
                    RawHeaders headers = this.httpEngine.responseHeaders.getHeaders();
                    RawHeaders.readHeaders(this.transport.socketIn, headers);
                    this.httpEngine.receiveHeaders(headers);
                    endOfInput();
                }
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Expected a hex chunk size but was " + asciiLine);
            }
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            checkNotClosed();
            if (!this.hasMoreChunks || this.bytesRemainingInChunk == -1) {
                return 0;
            }
            return Math.min(this.in.available(), this.bytesRemainingInChunk);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (this.hasMoreChunks && !HttpTransport.discardStream(this.httpEngine, this)) {
                unexpectedEndOfInput();
            }
            this.closed = true;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            Util.checkOffsetAndCount(bArr.length, i, i2);
            checkNotClosed();
            if (!this.hasMoreChunks) {
                return -1;
            }
            int i3 = this.bytesRemainingInChunk;
            if (i3 == 0 || i3 == -1) {
                readChunkSize();
                if (!this.hasMoreChunks) {
                    return -1;
                }
            }
            int i4 = this.in.read(bArr, i, Math.min(i2, this.bytesRemainingInChunk));
            if (i4 == -1) {
                unexpectedEndOfInput();
                throw new IOException("unexpected end of stream");
            }
            this.bytesRemainingInChunk -= i4;
            cacheWrite(bArr, i, i4);
            return i4;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class ChunkedOutputStream extends AbstractOutputStream {
        private final ByteArrayOutputStream bufferedChunk;
        private final byte[] hex;
        private final int maxChunkLength;
        private final OutputStream socketOut;
        private static final byte[] CRLF = {dn.k, 10};
        private static final byte[] HEX_DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
        private static final byte[] FINAL_CHUNK = {48, dn.k, 10, dn.k, 10};

        private int dataLength(int i) {
            int i2 = 4;
            for (int i3 = i - 4; i3 > 0; i3 >>= 4) {
                i2++;
            }
            return i - i2;
        }

        private void writeBufferedChunkToSocket() throws IOException {
            int size = this.bufferedChunk.size();
            if (size <= 0) {
                return;
            }
            writeHex(size);
            this.bufferedChunk.writeTo(this.socketOut);
            this.bufferedChunk.reset();
            this.socketOut.write(CRLF);
        }

        private void writeHex(int i) throws IOException {
            byte[] bArr;
            int i2 = 8;
            do {
                bArr = this.hex;
                i2--;
                bArr[i2] = HEX_DIGITS[i & 15];
                i >>>= 4;
            } while (i != 0);
            this.socketOut.write(bArr, i2, bArr.length - i2);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            writeBufferedChunkToSocket();
            this.socketOut.write(FINAL_CHUNK);
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.closed) {
                return;
            }
            writeBufferedChunkToSocket();
            this.socketOut.flush();
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
            int iMin;
            checkNotClosed();
            Util.checkOffsetAndCount(bArr.length, i, i2);
            while (i2 > 0) {
                if (this.bufferedChunk.size() > 0 || i2 < (iMin = this.maxChunkLength)) {
                    iMin = Math.min(i2, this.maxChunkLength - this.bufferedChunk.size());
                    this.bufferedChunk.write(bArr, i, iMin);
                    if (this.bufferedChunk.size() == this.maxChunkLength) {
                        writeBufferedChunkToSocket();
                    }
                } else {
                    writeHex(iMin);
                    this.socketOut.write(bArr, i, iMin);
                    this.socketOut.write(CRLF);
                }
                i += iMin;
                i2 -= iMin;
            }
        }

        private ChunkedOutputStream(OutputStream outputStream, int i) {
            this.hex = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, dn.k, 10};
            this.socketOut = outputStream;
            this.maxChunkLength = Math.max(1, dataLength(i));
            this.bufferedChunk = new ByteArrayOutputStream(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class FixedLengthInputStream extends AbstractHttpInputStream {
        private long bytesRemaining;

        public FixedLengthInputStream(InputStream inputStream, CacheRequest cacheRequest, HttpEngine httpEngine, long j) throws IOException {
            super(inputStream, httpEngine, cacheRequest);
            this.bytesRemaining = j;
            if (j == 0) {
                endOfInput();
            }
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            checkNotClosed();
            if (this.bytesRemaining == 0) {
                return 0;
            }
            return (int) Math.min(this.in.available(), this.bytesRemaining);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (this.bytesRemaining != 0 && !HttpTransport.discardStream(this.httpEngine, this)) {
                unexpectedEndOfInput();
            }
            this.closed = true;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            Util.checkOffsetAndCount(bArr.length, i, i2);
            checkNotClosed();
            long j = this.bytesRemaining;
            if (j == 0) {
                return -1;
            }
            int i3 = this.in.read(bArr, i, (int) Math.min(i2, j));
            if (i3 == -1) {
                unexpectedEndOfInput();
                throw new ProtocolException("unexpected end of stream");
            }
            this.bytesRemaining -= (long) i3;
            cacheWrite(bArr, i, i3);
            if (this.bytesRemaining == 0) {
                endOfInput();
            }
            return i3;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class FixedLengthOutputStream extends AbstractOutputStream {
        private long bytesRemaining;
        private final OutputStream socketOut;

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.bytesRemaining > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            if (this.closed) {
                return;
            }
            this.socketOut.flush();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            checkNotClosed();
            Util.checkOffsetAndCount(bArr.length, i, i2);
            long j = i2;
            if (j <= this.bytesRemaining) {
                this.socketOut.write(bArr, i, i2);
                this.bytesRemaining -= j;
                return;
            }
            throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + i2);
        }

        private FixedLengthOutputStream(OutputStream outputStream, long j) {
            this.socketOut = outputStream;
            this.bytesRemaining = j;
        }
    }

    public HttpTransport(HttpEngine httpEngine, OutputStream outputStream, InputStream inputStream) {
        this.httpEngine = httpEngine;
        this.socketOut = outputStream;
        this.requestOut = outputStream;
        this.socketIn = inputStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean discardStream(HttpEngine httpEngine, InputStream inputStream) {
        Socket socket;
        Connection connection = httpEngine.connection;
        if (connection == null || (socket = connection.getSocket()) == null) {
            return false;
        }
        try {
            int soTimeout = socket.getSoTimeout();
            socket.setSoTimeout(100);
            try {
                Util.skipAll(inputStream);
                socket.setSoTimeout(soTimeout);
                return true;
            } catch (Throwable th) {
                socket.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.okhttp.internal.http.Transport
    public OutputStream createRequestBody() throws IOException {
        boolean zIsChunked = this.httpEngine.requestHeaders.isChunked();
        if (!zIsChunked && this.httpEngine.policy.getChunkLength() > 0 && this.httpEngine.connection.getHttpMinorVersion() != 0) {
            this.httpEngine.requestHeaders.setChunked();
            zIsChunked = true;
        }
        Object[] objArr = 0;
        if (zIsChunked) {
            int chunkLength = this.httpEngine.policy.getChunkLength();
            if (chunkLength == -1) {
                chunkLength = 1024;
            }
            writeRequestHeaders();
            return new ChunkedOutputStream(this.requestOut, chunkLength);
        }
        long fixedContentLength = this.httpEngine.policy.getFixedContentLength();
        if (fixedContentLength != -1) {
            this.httpEngine.requestHeaders.setContentLength(fixedContentLength);
            writeRequestHeaders();
            return new FixedLengthOutputStream(this.requestOut, fixedContentLength);
        }
        long contentLength = this.httpEngine.requestHeaders.getContentLength();
        if (contentLength > 2147483647L) {
            throw new IllegalArgumentException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
        }
        if (contentLength == -1) {
            return new RetryableOutputStream();
        }
        writeRequestHeaders();
        return new RetryableOutputStream((int) contentLength);
    }

    @Override // com.squareup.okhttp.internal.http.Transport
    public void flushRequest() throws IOException {
        this.requestOut.flush();
        this.requestOut = this.socketOut;
    }

    @Override // com.squareup.okhttp.internal.http.Transport
    public InputStream getTransferStream(CacheRequest cacheRequest) throws IOException {
        if (!this.httpEngine.hasResponseBody()) {
            return new FixedLengthInputStream(this.socketIn, cacheRequest, this.httpEngine, 0L);
        }
        if (this.httpEngine.responseHeaders.isChunked()) {
            return new ChunkedInputStream(this.socketIn, cacheRequest, this);
        }
        if (this.httpEngine.responseHeaders.getContentLength() == -1) {
            return new UnknownLengthHttpInputStream(this.socketIn, cacheRequest, this.httpEngine);
        }
        InputStream inputStream = this.socketIn;
        HttpEngine httpEngine = this.httpEngine;
        return new FixedLengthInputStream(inputStream, cacheRequest, httpEngine, httpEngine.responseHeaders.getContentLength());
    }

    @Override // com.squareup.okhttp.internal.http.Transport
    public boolean makeReusable(boolean z, OutputStream outputStream, InputStream inputStream) {
        if (z) {
            return false;
        }
        if ((outputStream != null && !((AbstractOutputStream) outputStream).isClosed()) || this.httpEngine.requestHeaders.hasConnectionClose()) {
            return false;
        }
        ResponseHeaders responseHeaders = this.httpEngine.responseHeaders;
        if ((responseHeaders != null && responseHeaders.hasConnectionClose()) || (inputStream instanceof UnknownLengthHttpInputStream)) {
            return false;
        }
        if (inputStream != null) {
            return discardStream(this.httpEngine, inputStream);
        }
        return true;
    }

    @Override // com.squareup.okhttp.internal.http.Transport
    public ResponseHeaders readResponseHeaders() throws IOException {
        RawHeaders rawHeadersFromBytes = RawHeaders.fromBytes(this.socketIn);
        this.httpEngine.connection.setHttpMinorVersion(rawHeadersFromBytes.getHttpMinorVersion());
        this.httpEngine.receiveHeaders(rawHeadersFromBytes);
        ResponseHeaders responseHeaders = new ResponseHeaders(this.httpEngine.uri, rawHeadersFromBytes);
        responseHeaders.setTransport("http/1.1");
        return responseHeaders;
    }

    @Override // com.squareup.okhttp.internal.http.Transport
    public void writeRequestBody(RetryableOutputStream retryableOutputStream) throws IOException {
        retryableOutputStream.writeToSocket(this.requestOut);
    }

    @Override // com.squareup.okhttp.internal.http.Transport
    public void writeRequestHeaders() throws IOException {
        this.httpEngine.writingRequestHeaders();
        this.requestOut.write(this.httpEngine.requestHeaders.getHeaders().toBytes());
    }
}
