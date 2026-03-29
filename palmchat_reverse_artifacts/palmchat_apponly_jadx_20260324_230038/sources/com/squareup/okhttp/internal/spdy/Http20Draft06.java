package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.spdy.FrameReader;
import com.squareup.okhttp.internal.spdy.Hpack;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class Http20Draft06 implements Variant {
    private static final byte[] CONNECTION_HEADER;
    static final int FLAG_END_FLOW_CONTROL = 1;
    static final int FLAG_END_HEADERS = 4;
    static final int FLAG_END_STREAM = 1;
    static final int FLAG_PONG = 1;
    static final int FLAG_PRIORITY = 8;
    static final int TYPE_CONTINUATION = 10;
    static final int TYPE_DATA = 0;
    static final int TYPE_GOAWAY = 7;
    static final int TYPE_HEADERS = 1;
    static final int TYPE_PING = 6;
    static final int TYPE_PRIORITY = 2;
    static final int TYPE_PUSH_PROMISE = 5;
    static final int TYPE_RST_STREAM = 3;
    static final int TYPE_SETTINGS = 4;
    static final int TYPE_WINDOW_UPDATE = 9;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Writer implements FrameWriter {
        private final boolean client;
        private final ByteArrayOutputStream hpackBuffer;
        private final Hpack.Writer hpackWriter;
        private final DataOutputStream out;

        public Writer(OutputStream outputStream, boolean z) {
            this.out = new DataOutputStream(outputStream);
            this.client = z;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.hpackBuffer = byteArrayOutputStream;
            this.hpackWriter = new Hpack.Writer(byteArrayOutputStream);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.out.close();
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void connectionHeader() throws IOException {
            if (this.client) {
                this.out.write(Http20Draft06.CONNECTION_HEADER);
            }
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public void data(boolean z, int i, byte[] bArr) throws IOException {
            data(z, i, bArr, 0, bArr.length);
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void flush() throws IOException {
            this.out.flush();
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void goAway(int i, ErrorCode errorCode) throws IOException {
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void headers(int i, List<String> list) throws IOException {
            headers(false, i, -1, list);
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void noop() throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void ping(boolean z, int i, int i2) throws IOException {
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void rstStream(int i, ErrorCode errorCode) throws IOException {
            throw new UnsupportedOperationException("TODO");
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void settings(Settings settings) throws IOException {
            this.out.writeInt((((settings.size() * 8) & 65535) << 16) | 1024 | 0);
            this.out.writeInt(0);
            for (int i = 0; i < 10; i++) {
                if (settings.isSet(i)) {
                    this.out.writeInt(16777215 & i);
                    this.out.writeInt(settings.get(i));
                }
            }
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void synReply(boolean z, int i, List<String> list) throws IOException {
            headers(z, i, -1, list);
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void synStream(boolean z, boolean z2, int i, int i2, int i3, int i4, List<String> list) throws IOException {
            if (z2) {
                throw new UnsupportedOperationException();
            }
            headers(z, i, i3, list);
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void windowUpdate(int i, int i2) throws IOException {
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void data(boolean z, int i, byte[] bArr, int i2, int i3) throws IOException {
            this.out.writeInt(((z ? 1 : 0) & 255) | ((65535 & i3) << 16) | 0);
            this.out.writeInt(i & Integer.MAX_VALUE);
            this.out.write(bArr, i2, i3);
        }

        private void headers(boolean z, int i, int i2, List<String> list) throws IOException {
            this.hpackBuffer.reset();
            this.hpackWriter.writeHeaders(list);
            int size = this.hpackBuffer.size();
            int i3 = z ? 5 : 4;
            if (i2 != -1) {
                i3 |= 8;
            }
            this.out.writeInt((i3 & 255) | ((size & 65535) << 16) | 256);
            this.out.writeInt(i & Integer.MAX_VALUE);
            if (i2 != -1) {
                this.out.writeInt(i2 & Integer.MAX_VALUE);
            }
            this.hpackBuffer.writeTo(this.out);
        }
    }

    static {
        try {
            CONNECTION_HEADER = "PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n".getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }

    @Override // com.squareup.okhttp.internal.spdy.Variant
    public FrameReader newReader(InputStream inputStream, boolean z) {
        return new Reader(inputStream, z);
    }

    @Override // com.squareup.okhttp.internal.spdy.Variant
    public FrameWriter newWriter(OutputStream outputStream, boolean z) {
        return new Writer(outputStream, z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class Reader implements FrameReader {
        private final boolean client;
        private final Hpack.Reader hpackReader;
        private final DataInputStream in;

        public Reader(InputStream inputStream, boolean z) {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.in = dataInputStream;
            this.client = z;
            this.hpackReader = new Hpack.Reader(dataInputStream, z);
        }

        private static IOException ioException(String str, Object... objArr) throws IOException {
            throw new IOException(String.format(str, objArr));
        }

        private void readData(FrameReader.Handler handler, int i, int i2, int i3) throws IOException {
            handler.data((i & 1) != 0, i3, this.in, i2);
        }

        private void readGoAway(FrameReader.Handler handler, int i, int i2, int i3) throws IOException {
            if (i2 < 8) {
                throw ioException("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i2));
            }
            int i4 = this.in.readInt();
            int i5 = this.in.readInt();
            int i6 = i2 - 8;
            ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(i5);
            if (errorCodeFromHttp2 == null) {
                throw ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i5));
            }
            long j = i6;
            if (Util.skipByReading(this.in, j) != j) {
                throw new IOException("TYPE_GOAWAY opaque data was truncated");
            }
            handler.goAway(i4, errorCodeFromHttp2);
        }

        private void readHeaders(FrameReader.Handler handler, int i, int i2, int i3) throws IOException {
            if (i3 == 0) {
                throw ioException("TYPE_HEADERS streamId == 0", new Object[0]);
            }
            boolean z = (i & 1) != 0;
            while (true) {
                this.hpackReader.readHeaders(i2);
                if ((i & 4) != 0) {
                    this.hpackReader.emitReferenceSet();
                    handler.headers(false, z, i3, -1, -1, this.hpackReader.getAndReset(), HeadersMode.HTTP_20_HEADERS);
                    return;
                }
                int i4 = this.in.readInt();
                int i5 = this.in.readInt();
                int i6 = ((-65536) & i4) >> 16;
                int i7 = (65280 & i4) >> 8;
                i = i4 & 255;
                z = (i & 1) != 0;
                int i8 = i5 & Integer.MAX_VALUE;
                if (i7 != 10) {
                    throw ioException("TYPE_CONTINUATION didn't have FLAG_END_HEADERS", new Object[0]);
                }
                if (i8 != i3) {
                    throw ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
                }
                i2 = i6;
            }
        }

        private void readPing(FrameReader.Handler handler, int i, int i2, int i3) throws IOException {
            if (i2 != 8) {
                throw ioException("TYPE_PING length != 8: %s", Integer.valueOf(i2));
            }
            if (i3 != 0) {
                throw ioException("TYPE_PING streamId != 0", new Object[0]);
            }
            handler.ping((i & 1) != 0, this.in.readInt(), this.in.readInt());
        }

        private void readPriority(FrameReader.Handler handler, int i, int i2, int i3) throws IOException {
            if (i2 != 4) {
                throw ioException("TYPE_PRIORITY length: %d != 4", Integer.valueOf(i2));
            }
            if (i3 == 0) {
                throw ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
            }
            handler.priority(i3, this.in.readInt() & Integer.MAX_VALUE);
        }

        private void readRstStream(FrameReader.Handler handler, int i, int i2, int i3) throws IOException {
            if (i2 != 4) {
                throw ioException("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i2));
            }
            if (i3 == 0) {
                throw ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
            int i4 = this.in.readInt();
            ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(i4);
            if (errorCodeFromHttp2 == null) {
                throw ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i4));
            }
            handler.rstStream(i3, errorCodeFromHttp2);
        }

        private void readSettings(FrameReader.Handler handler, int i, int i2, int i3) throws IOException {
            if (i2 % 8 != 0) {
                throw ioException("TYPE_SETTINGS length %% 8 != 0: %s", Integer.valueOf(i2));
            }
            if (i3 != 0) {
                throw ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
            }
            Settings settings = new Settings();
            for (int i4 = 0; i4 < i2; i4 += 8) {
                settings.set(this.in.readInt() & 16777215, 0, this.in.readInt());
            }
            handler.settings(false, settings);
        }

        private void readWindowUpdate(FrameReader.Handler handler, int i, int i2, int i3) throws IOException {
            handler.windowUpdate(i3, this.in.readInt() & Integer.MAX_VALUE, (i & 1) != 0);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.in.close();
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader
        public boolean nextFrame(FrameReader.Handler handler) throws IOException {
            try {
                int i = this.in.readInt();
                int i2 = ((-65536) & i) >> 16;
                int i3 = (65280 & i) >> 8;
                int i4 = i & 255;
                int i5 = this.in.readInt() & Integer.MAX_VALUE;
                switch (i3) {
                    case 0:
                        readData(handler, i4, i2, i5);
                        return true;
                    case 1:
                        readHeaders(handler, i4, i2, i5);
                        return true;
                    case 2:
                        readPriority(handler, i4, i2, i5);
                        return true;
                    case 3:
                        readRstStream(handler, i4, i2, i5);
                        return true;
                    case 4:
                        readSettings(handler, i4, i2, i5);
                        return true;
                    case 5:
                        readPushPromise(handler, i4, i2, i5);
                        return true;
                    case 6:
                        readPing(handler, i4, i2, i5);
                        return true;
                    case 7:
                        readGoAway(handler, i4, i2, i5);
                        return true;
                    case 8:
                    default:
                        throw new UnsupportedOperationException("TODO");
                    case 9:
                        readWindowUpdate(handler, i4, i2, i5);
                        return true;
                }
            } catch (IOException unused) {
                return false;
            }
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader
        public void readConnectionHeader() throws IOException {
            if (this.client) {
                return;
            }
            byte[] bArr = new byte[Http20Draft06.CONNECTION_HEADER.length];
            this.in.readFully(bArr);
            if (Arrays.equals(bArr, Http20Draft06.CONNECTION_HEADER)) {
                return;
            }
            throw ioException("Expected a connection header but was " + Arrays.toString(bArr), new Object[0]);
        }

        private void readPushPromise(FrameReader.Handler handler, int i, int i2, int i3) {
        }
    }
}
