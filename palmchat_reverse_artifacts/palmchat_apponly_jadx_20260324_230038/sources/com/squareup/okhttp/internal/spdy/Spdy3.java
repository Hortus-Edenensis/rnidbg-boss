package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.spdy.FrameReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.List;
import java.util.zip.Deflater;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class Spdy3 implements Variant {
    static final byte[] DICTIONARY;
    static final int FLAG_FIN = 1;
    static final int FLAG_UNIDIRECTIONAL = 2;
    static final int TYPE_CREDENTIAL = 16;
    static final int TYPE_DATA = 0;
    static final int TYPE_GOAWAY = 7;
    static final int TYPE_HEADERS = 8;
    static final int TYPE_NOOP = 5;
    static final int TYPE_PING = 6;
    static final int TYPE_RST_STREAM = 3;
    static final int TYPE_SETTINGS = 4;
    static final int TYPE_SYN_REPLY = 2;
    static final int TYPE_SYN_STREAM = 1;
    static final int TYPE_WINDOW_UPDATE = 9;
    static final int VERSION = 3;

    static {
        try {
            DICTIONARY = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(Util.UTF_8.name());
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
    public static final class Writer implements FrameWriter {
        private final boolean client;
        private final ByteArrayOutputStream nameValueBlockBuffer;
        private final DataOutputStream nameValueBlockOut;
        private final DataOutputStream out;

        public Writer(OutputStream outputStream, boolean z) {
            this.out = new DataOutputStream(outputStream);
            this.client = z;
            Deflater deflater = new Deflater();
            deflater.setDictionary(Spdy3.DICTIONARY);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.nameValueBlockBuffer = byteArrayOutputStream;
            this.nameValueBlockOut = new DataOutputStream(Platform.get().newDeflaterOutputStream(byteArrayOutputStream, deflater, true));
        }

        private void writeNameValueBlockToBuffer(List<String> list) throws IOException {
            this.nameValueBlockBuffer.reset();
            this.nameValueBlockOut.writeInt(list.size() / 2);
            for (String str : list) {
                this.nameValueBlockOut.writeInt(str.length());
                this.nameValueBlockOut.write(str.getBytes("UTF-8"));
            }
            this.nameValueBlockOut.flush();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Util.closeAll(this.out, this.nameValueBlockOut);
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void connectionHeader() {
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void data(boolean z, int i, byte[] bArr) throws IOException {
            data(z, i, bArr, 0, bArr.length);
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void flush() throws IOException {
            this.out.flush();
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void goAway(int i, ErrorCode errorCode) throws IOException {
            if (errorCode.spdyGoAwayCode == -1) {
                throw new IllegalArgumentException();
            }
            this.out.writeInt(-2147287033);
            this.out.writeInt(8);
            this.out.writeInt(i);
            this.out.writeInt(errorCode.spdyGoAwayCode);
            this.out.flush();
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void headers(int i, List<String> list) throws IOException {
            writeNameValueBlockToBuffer(list);
            int size = this.nameValueBlockBuffer.size() + 4;
            this.out.writeInt(-2147287032);
            this.out.writeInt((size & 16777215) | 0);
            this.out.writeInt(i & Integer.MAX_VALUE);
            this.nameValueBlockBuffer.writeTo(this.out);
            this.out.flush();
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void noop() throws IOException {
            this.out.writeInt(-2147287035);
            this.out.writeInt(0);
            this.out.flush();
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void ping(boolean z, int i, int i2) throws IOException {
            if (z != (this.client != (i % 2 == 1))) {
                throw new IllegalArgumentException("payload != reply");
            }
            this.out.writeInt(-2147287034);
            this.out.writeInt(4);
            this.out.writeInt(i);
            this.out.flush();
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void rstStream(int i, ErrorCode errorCode) throws IOException {
            if (errorCode.spdyRstCode == -1) {
                throw new IllegalArgumentException();
            }
            this.out.writeInt(-2147287037);
            this.out.writeInt(8);
            this.out.writeInt(i & Integer.MAX_VALUE);
            this.out.writeInt(errorCode.spdyRstCode);
            this.out.flush();
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void settings(Settings settings) throws IOException {
            int size = settings.size();
            this.out.writeInt(-2147287036);
            this.out.writeInt((((size * 8) + 4) & 16777215) | 0);
            this.out.writeInt(size);
            for (int i = 0; i <= 10; i++) {
                if (settings.isSet(i)) {
                    this.out.writeInt(((settings.flags(i) & 255) << 24) | (i & 16777215));
                    this.out.writeInt(settings.get(i));
                }
            }
            this.out.flush();
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void synReply(boolean z, int i, List<String> list) throws IOException {
            writeNameValueBlockToBuffer(list);
            int i2 = z ? 1 : 0;
            int size = this.nameValueBlockBuffer.size() + 4;
            this.out.writeInt(-2147287038);
            this.out.writeInt(((i2 & 255) << 24) | (size & 16777215));
            this.out.writeInt(i & Integer.MAX_VALUE);
            this.nameValueBlockBuffer.writeTo(this.out);
            this.out.flush();
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void synStream(boolean z, boolean z2, int i, int i2, int i3, int i4, List<String> list) throws IOException {
            writeNameValueBlockToBuffer(list);
            int size = this.nameValueBlockBuffer.size() + 10;
            int i5 = (z ? 1 : 0) | (z2 ? 2 : 0);
            this.out.writeInt(-2147287039);
            this.out.writeInt(((i5 & 255) << 24) | (size & 16777215));
            this.out.writeInt(i & Integer.MAX_VALUE);
            this.out.writeInt(Integer.MAX_VALUE & i2);
            this.out.writeShort(((i3 & 7) << 13) | 0 | (i4 & 255));
            this.nameValueBlockBuffer.writeTo(this.out);
            this.out.flush();
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void windowUpdate(int i, int i2) throws IOException {
            this.out.writeInt(-2147287031);
            this.out.writeInt(8);
            this.out.writeInt(i);
            this.out.writeInt(i2);
            this.out.flush();
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameWriter
        public synchronized void data(boolean z, int i, byte[] bArr, int i2, int i3) throws IOException {
            int i4 = z ? 1 : 0;
            this.out.writeInt(i & Integer.MAX_VALUE);
            this.out.writeInt(((i4 & 255) << 24) | (16777215 & i3));
            this.out.write(bArr, i2, i3);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class Reader implements FrameReader {
        private final boolean client;
        private final DataInputStream in;
        private final NameValueBlockReader nameValueBlockReader;

        public Reader(InputStream inputStream, boolean z) {
            this.in = new DataInputStream(inputStream);
            this.nameValueBlockReader = new NameValueBlockReader(inputStream);
            this.client = z;
        }

        private static IOException ioException(String str, Object... objArr) throws IOException {
            throw new IOException(String.format(str, objArr));
        }

        private void readGoAway(FrameReader.Handler handler, int i, int i2) throws IOException {
            if (i2 != 8) {
                throw ioException("TYPE_GOAWAY length: %d != 8", Integer.valueOf(i2));
            }
            int i3 = this.in.readInt() & Integer.MAX_VALUE;
            int i4 = this.in.readInt();
            ErrorCode errorCodeFromSpdyGoAway = ErrorCode.fromSpdyGoAway(i4);
            if (errorCodeFromSpdyGoAway == null) {
                throw ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i4));
            }
            handler.goAway(i3, errorCodeFromSpdyGoAway);
        }

        private void readHeaders(FrameReader.Handler handler, int i, int i2) throws IOException {
            handler.headers(false, false, this.in.readInt() & Integer.MAX_VALUE, -1, -1, this.nameValueBlockReader.readNameValueBlock(i2 - 4), HeadersMode.SPDY_HEADERS);
        }

        private void readPing(FrameReader.Handler handler, int i, int i2) throws IOException {
            if (i2 != 4) {
                throw ioException("TYPE_PING length: %d != 4", Integer.valueOf(i2));
            }
            int i3 = this.in.readInt();
            handler.ping(this.client == (i3 % 2 == 1), i3, 0);
        }

        private void readRstStream(FrameReader.Handler handler, int i, int i2) throws IOException {
            if (i2 != 8) {
                throw ioException("TYPE_RST_STREAM length: %d != 8", Integer.valueOf(i2));
            }
            int i3 = this.in.readInt() & Integer.MAX_VALUE;
            int i4 = this.in.readInt();
            ErrorCode errorCodeFromSpdy3Rst = ErrorCode.fromSpdy3Rst(i4);
            if (errorCodeFromSpdy3Rst == null) {
                throw ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i4));
            }
            handler.rstStream(i3, errorCodeFromSpdy3Rst);
        }

        private void readSettings(FrameReader.Handler handler, int i, int i2) throws IOException {
            int i3 = this.in.readInt();
            if (i2 != (i3 * 8) + 4) {
                throw ioException("TYPE_SETTINGS length: %d != 4 + 8 * %d", Integer.valueOf(i2), Integer.valueOf(i3));
            }
            Settings settings = new Settings();
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = this.in.readInt();
                settings.set(i5 & 16777215, ((-16777216) & i5) >>> 24, this.in.readInt());
            }
            handler.settings((i & 1) != 0, settings);
        }

        private void readSynReply(FrameReader.Handler handler, int i, int i2) throws IOException {
            handler.headers(false, (i & 1) != 0, this.in.readInt() & Integer.MAX_VALUE, -1, -1, this.nameValueBlockReader.readNameValueBlock(i2 - 4), HeadersMode.SPDY_REPLY);
        }

        private void readSynStream(FrameReader.Handler handler, int i, int i2) throws IOException {
            handler.headers((i & 2) != 0, (i & 1) != 0, this.in.readInt() & Integer.MAX_VALUE, this.in.readInt() & Integer.MAX_VALUE, (57344 & this.in.readShort()) >>> 13, this.nameValueBlockReader.readNameValueBlock(i2 - 10), HeadersMode.SPDY_SYN_STREAM);
        }

        private void readWindowUpdate(FrameReader.Handler handler, int i, int i2) throws IOException {
            if (i2 != 8) {
                throw ioException("TYPE_WINDOW_UPDATE length: %d != 8", Integer.valueOf(i2));
            }
            handler.windowUpdate(this.in.readInt() & Integer.MAX_VALUE, this.in.readInt() & Integer.MAX_VALUE, false);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Util.closeAll(this.in, this.nameValueBlockReader);
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader
        public boolean nextFrame(FrameReader.Handler handler) throws IOException {
            try {
                int i = this.in.readInt();
                int i2 = this.in.readInt();
                int i3 = ((-16777216) & i2) >>> 24;
                int i4 = i2 & 16777215;
                if (!((Integer.MIN_VALUE & i) != 0)) {
                    handler.data((i3 & 1) != 0, i & Integer.MAX_VALUE, this.in, i4);
                    return true;
                }
                int i5 = (2147418112 & i) >>> 16;
                int i6 = i & 65535;
                if (i5 != 3) {
                    throw new ProtocolException("version != 3: " + i5);
                }
                if (i6 == 16) {
                    Util.skipByReading(this.in, i4);
                    throw new UnsupportedOperationException("TODO");
                }
                switch (i6) {
                    case 1:
                        readSynStream(handler, i3, i4);
                        return true;
                    case 2:
                        readSynReply(handler, i3, i4);
                        return true;
                    case 3:
                        readRstStream(handler, i3, i4);
                        return true;
                    case 4:
                        readSettings(handler, i3, i4);
                        return true;
                    case 5:
                        if (i4 != 0) {
                            throw ioException("TYPE_NOOP length: %d != 0", Integer.valueOf(i4));
                        }
                        handler.noop();
                        return true;
                    case 6:
                        readPing(handler, i3, i4);
                        return true;
                    case 7:
                        readGoAway(handler, i3, i4);
                        return true;
                    case 8:
                        readHeaders(handler, i3, i4);
                        return true;
                    case 9:
                        readWindowUpdate(handler, i3, i4);
                        return true;
                    default:
                        throw new IOException("Unexpected frame");
                }
            } catch (IOException unused) {
                return false;
            }
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader
        public void readConnectionHeader() {
        }
    }
}
