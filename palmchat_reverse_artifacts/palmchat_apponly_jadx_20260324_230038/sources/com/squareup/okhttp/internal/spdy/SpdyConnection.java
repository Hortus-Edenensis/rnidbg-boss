package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.spdy.FrameReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class SpdyConnection implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ExecutorService executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.daemonThreadFactory("OkHttp SpdyConnection"));
    final boolean client;
    private final FrameReader frameReader;
    private final FrameWriter frameWriter;
    private final IncomingStreamHandler handler;
    private final String hostName;
    private long idleStartTimeNs;
    private int lastGoodStreamId;
    private int nextPingId;
    private int nextStreamId;
    private Map<Integer, Ping> pings;
    Settings settings;
    private boolean shutdown;
    private final Map<Integer, SpdyStream> streams;
    final Variant variant;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private boolean client;
        private IncomingStreamHandler handler;
        private String hostName;
        private InputStream in;
        private OutputStream out;
        private Variant variant;

        public Builder(boolean z, Socket socket) throws IOException {
            this("", z, socket.getInputStream(), socket.getOutputStream());
        }

        public SpdyConnection build() {
            return new SpdyConnection(this);
        }

        public Builder handler(IncomingStreamHandler incomingStreamHandler) {
            this.handler = incomingStreamHandler;
            return this;
        }

        public Builder http20Draft06() {
            this.variant = Variant.HTTP_20_DRAFT_06;
            return this;
        }

        public Builder spdy3() {
            this.variant = Variant.SPDY3;
            return this;
        }

        public Builder(boolean z, InputStream inputStream, OutputStream outputStream) {
            this("", z, inputStream, outputStream);
        }

        public Builder(String str, boolean z, Socket socket) throws IOException {
            this(str, z, socket.getInputStream(), socket.getOutputStream());
        }

        public Builder(String str, boolean z, InputStream inputStream, OutputStream outputStream) {
            this.handler = IncomingStreamHandler.REFUSE_INCOMING_STREAMS;
            this.variant = Variant.SPDY3;
            this.hostName = str;
            this.client = z;
            this.in = inputStream;
            this.out = outputStream;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class Reader implements Runnable, FrameReader.Handler {
        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void data(boolean z, int i, InputStream inputStream, int i2) throws IOException {
            SpdyStream stream = SpdyConnection.this.getStream(i);
            if (stream == null) {
                SpdyConnection.this.writeSynResetLater(i, ErrorCode.INVALID_STREAM);
                Util.skipByReading(inputStream, i2);
            } else {
                stream.receiveData(inputStream, i2);
                if (z) {
                    stream.receiveFin();
                }
            }
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void goAway(int i, ErrorCode errorCode) {
            synchronized (SpdyConnection.this) {
                SpdyConnection.this.shutdown = true;
                Iterator it = SpdyConnection.this.streams.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (((Integer) entry.getKey()).intValue() > i && ((SpdyStream) entry.getValue()).isLocallyInitiated()) {
                        ((SpdyStream) entry.getValue()).receiveRstStream(ErrorCode.REFUSED_STREAM);
                        it.remove();
                    }
                }
            }
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void headers(boolean z, boolean z2, int i, int i2, int i3, List<String> list, HeadersMode headersMode) {
            synchronized (SpdyConnection.this) {
                if (SpdyConnection.this.shutdown) {
                    return;
                }
                SpdyStream stream = SpdyConnection.this.getStream(i);
                if (stream != null) {
                    if (headersMode.failIfStreamPresent()) {
                        stream.closeLater(ErrorCode.PROTOCOL_ERROR);
                        SpdyConnection.this.removeStream(i);
                        return;
                    } else {
                        stream.receiveHeaders(list, headersMode);
                        if (z2) {
                            stream.receiveFin();
                            return;
                        }
                        return;
                    }
                }
                if (headersMode.failIfStreamAbsent()) {
                    SpdyConnection.this.writeSynResetLater(i, ErrorCode.INVALID_STREAM);
                    return;
                }
                if (i <= SpdyConnection.this.lastGoodStreamId) {
                    return;
                }
                if (i % 2 == SpdyConnection.this.nextStreamId % 2) {
                    return;
                }
                SpdyConnection spdyConnection = SpdyConnection.this;
                final SpdyStream spdyStream = new SpdyStream(i, spdyConnection, z, z2, i3, list, spdyConnection.settings);
                SpdyConnection.this.lastGoodStreamId = i;
                SpdyConnection.this.streams.put(Integer.valueOf(i), spdyStream);
                SpdyConnection.executor.submit(new NamedRunnable("OkHttp Callback %s stream %d", new Object[]{SpdyConnection.this.hostName, Integer.valueOf(i)}) { // from class: com.squareup.okhttp.internal.spdy.SpdyConnection.Reader.1
                    @Override // com.squareup.okhttp.internal.NamedRunnable
                    public void execute() {
                        try {
                            SpdyConnection.this.handler.receive(spdyStream);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void ping(boolean z, int i, int i2) {
            if (!z) {
                SpdyConnection.this.writePingLater(true, i, i2, null);
                return;
            }
            Ping pingRemovePing = SpdyConnection.this.removePing(i);
            if (pingRemovePing != null) {
                pingRemovePing.receive();
            }
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void rstStream(int i, ErrorCode errorCode) {
            SpdyStream spdyStreamRemoveStream = SpdyConnection.this.removeStream(i);
            if (spdyStreamRemoveStream != null) {
                spdyStreamRemoveStream.receiveRstStream(errorCode);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v9, types: [boolean] */
        @Override // java.lang.Runnable
        public void run() throws Throwable {
            ErrorCode errorCodeNextFrame;
            ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
            do {
                try {
                    try {
                        try {
                            errorCodeNextFrame = SpdyConnection.this.frameReader.nextFrame(this);
                        } catch (Throwable th) {
                            th = th;
                            try {
                                SpdyConnection.this.close(errorCodeNextFrame, errorCode);
                            } catch (IOException unused) {
                            }
                            throw th;
                        }
                    } catch (IOException unused2) {
                        return;
                    }
                } catch (IOException unused3) {
                } catch (Throwable th2) {
                    th = th2;
                    errorCodeNextFrame = errorCode;
                    SpdyConnection.this.close(errorCodeNextFrame, errorCode);
                    throw th;
                }
            } while (errorCodeNextFrame != 0);
            ErrorCode errorCode2 = ErrorCode.NO_ERROR;
            try {
                errorCode = ErrorCode.CANCEL;
                SpdyConnection.this.close(errorCode2, errorCode);
                errorCodeNextFrame = errorCode2;
            } catch (IOException unused4) {
                errorCode = ErrorCode.PROTOCOL_ERROR;
                SpdyConnection spdyConnection = SpdyConnection.this;
                spdyConnection.close(errorCode, errorCode);
                errorCodeNextFrame = spdyConnection;
            }
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void settings(boolean z, Settings settings) {
            SpdyStream[] spdyStreamArr;
            synchronized (SpdyConnection.this) {
                SpdyConnection spdyConnection = SpdyConnection.this;
                Settings settings2 = spdyConnection.settings;
                if (settings2 == null || z) {
                    spdyConnection.settings = settings;
                } else {
                    settings2.merge(settings);
                }
                spdyStreamArr = !SpdyConnection.this.streams.isEmpty() ? (SpdyStream[]) SpdyConnection.this.streams.values().toArray(new SpdyStream[SpdyConnection.this.streams.size()]) : null;
            }
            if (spdyStreamArr != null) {
                for (SpdyStream spdyStream : spdyStreamArr) {
                    synchronized (spdyStream) {
                        synchronized (SpdyConnection.this) {
                            spdyStream.receiveSettings(SpdyConnection.this.settings);
                        }
                    }
                }
            }
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void windowUpdate(int i, int i2, boolean z) {
            SpdyStream stream;
            if (i == 0 || (stream = SpdyConnection.this.getStream(i)) == null) {
                return;
            }
            stream.receiveWindowUpdate(i2);
        }

        private Reader() {
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void noop() {
        }

        @Override // com.squareup.okhttp.internal.spdy.FrameReader.Handler
        public void priority(int i, int i2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized SpdyStream getStream(int i) {
        return this.streams.get(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Ping removePing(int i) {
        Map<Integer, Ping> map;
        map = this.pings;
        return map != null ? map.remove(Integer.valueOf(i)) : null;
    }

    private synchronized void setIdle(boolean z) {
        long jNanoTime;
        if (z) {
            try {
                jNanoTime = System.nanoTime();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            jNanoTime = Long.MAX_VALUE;
        }
        this.idleStartTimeNs = jNanoTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writePing(boolean z, int i, int i2, Ping ping) throws IOException {
        synchronized (this.frameWriter) {
            if (ping != null) {
                ping.send();
                this.frameWriter.ping(z, i, i2);
            } else {
                this.frameWriter.ping(z, i, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writePingLater(final boolean z, final int i, final int i2, final Ping ping) {
        executor.submit(new NamedRunnable("OkHttp SPDY Writer %s ping %08x%08x", new Object[]{this.hostName, Integer.valueOf(i), Integer.valueOf(i2)}) { // from class: com.squareup.okhttp.internal.spdy.SpdyConnection.3
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                try {
                    SpdyConnection.this.writePing(z, i, i2, ping);
                } catch (IOException unused) {
                }
            }
        });
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public void flush() throws IOException {
        this.frameWriter.flush();
    }

    public synchronized long getIdleStartTimeNs() {
        return this.idleStartTimeNs;
    }

    public synchronized boolean isIdle() {
        return this.idleStartTimeNs != Long.MAX_VALUE;
    }

    public SpdyStream newStream(List<String> list, boolean z, boolean z2) throws IOException {
        int i;
        SpdyStream spdyStream;
        SpdyStream spdyStream2;
        boolean z3 = !z;
        boolean z4 = !z2;
        synchronized (this.frameWriter) {
            synchronized (this) {
                if (this.shutdown) {
                    throw new IOException("shutdown");
                }
                i = this.nextStreamId;
                this.nextStreamId = i + 2;
                SpdyStream spdyStream3 = new SpdyStream(i, this, z3, z4, 0, list, this.settings);
                if (spdyStream3.isOpen()) {
                    spdyStream = spdyStream3;
                    this.streams.put(Integer.valueOf(i), spdyStream);
                    setIdle(false);
                } else {
                    spdyStream = spdyStream3;
                }
            }
            spdyStream2 = spdyStream;
            this.frameWriter.synStream(z3, z4, i, 0, 0, 0, list);
        }
        return spdyStream2;
    }

    public void noop() throws IOException {
        this.frameWriter.noop();
    }

    public synchronized int openStreamCount() {
        return this.streams.size();
    }

    public Ping ping() throws IOException {
        int i;
        Ping ping = new Ping();
        synchronized (this) {
            if (this.shutdown) {
                throw new IOException("shutdown");
            }
            i = this.nextPingId;
            this.nextPingId = i + 2;
            if (this.pings == null) {
                this.pings = new HashMap();
            }
            this.pings.put(Integer.valueOf(i), ping);
        }
        writePing(false, i, 1330343787, ping);
        return ping;
    }

    public void readConnectionHeader() throws IOException {
        this.frameReader.readConnectionHeader();
    }

    public synchronized SpdyStream removeStream(int i) {
        SpdyStream spdyStreamRemove;
        spdyStreamRemove = this.streams.remove(Integer.valueOf(i));
        if (spdyStreamRemove != null && this.streams.isEmpty()) {
            setIdle(true);
        }
        return spdyStreamRemove;
    }

    public void sendConnectionHeader() throws IOException {
        this.frameWriter.connectionHeader();
        this.frameWriter.settings(new Settings());
    }

    public void shutdown(ErrorCode errorCode) throws IOException {
        synchronized (this.frameWriter) {
            synchronized (this) {
                if (this.shutdown) {
                    return;
                }
                this.shutdown = true;
                this.frameWriter.goAway(this.lastGoodStreamId, errorCode);
            }
        }
    }

    public void writeData(int i, boolean z, byte[] bArr, int i2, int i3) throws IOException {
        this.frameWriter.data(z, i, bArr, i2, i3);
    }

    public void writeSynReply(int i, boolean z, List<String> list) throws IOException {
        this.frameWriter.synReply(z, i, list);
    }

    public void writeSynReset(int i, ErrorCode errorCode) throws IOException {
        this.frameWriter.rstStream(i, errorCode);
    }

    public void writeSynResetLater(final int i, final ErrorCode errorCode) {
        executor.submit(new NamedRunnable("OkHttp SPDY Writer %s stream %d", new Object[]{this.hostName, Integer.valueOf(i)}) { // from class: com.squareup.okhttp.internal.spdy.SpdyConnection.1
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                try {
                    SpdyConnection.this.writeSynReset(i, errorCode);
                } catch (IOException unused) {
                }
            }
        });
    }

    public void writeWindowUpdate(int i, int i2) throws IOException {
        this.frameWriter.windowUpdate(i, i2);
    }

    public void writeWindowUpdateLater(final int i, final int i2) {
        executor.submit(new NamedRunnable("OkHttp SPDY Writer %s stream %d", new Object[]{this.hostName, Integer.valueOf(i)}) { // from class: com.squareup.okhttp.internal.spdy.SpdyConnection.2
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void execute() {
                try {
                    SpdyConnection.this.writeWindowUpdate(i, i2);
                } catch (IOException unused) {
                }
            }
        });
    }

    private SpdyConnection(Builder builder) {
        this.streams = new HashMap();
        this.idleStartTimeNs = System.nanoTime();
        Variant variant = builder.variant;
        this.variant = variant;
        boolean z = builder.client;
        this.client = z;
        this.handler = builder.handler;
        this.frameReader = variant.newReader(builder.in, z);
        this.frameWriter = variant.newWriter(builder.out, z);
        this.nextStreamId = builder.client ? 1 : 2;
        this.nextPingId = builder.client ? 1 : 2;
        String str = builder.hostName;
        this.hostName = str;
        new Thread(new Reader(), "Spdy Reader " + str).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        int i;
        SpdyStream[] spdyStreamArr;
        Ping[] pingArr = null;
        try {
            shutdown(errorCode);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (this.streams.isEmpty()) {
                spdyStreamArr = null;
            } else {
                spdyStreamArr = (SpdyStream[]) this.streams.values().toArray(new SpdyStream[this.streams.size()]);
                this.streams.clear();
                setIdle(false);
            }
            Map<Integer, Ping> map = this.pings;
            if (map != null) {
                Ping[] pingArr2 = (Ping[]) map.values().toArray(new Ping[this.pings.size()]);
                this.pings = null;
                pingArr = pingArr2;
            }
        }
        if (spdyStreamArr != null) {
            for (SpdyStream spdyStream : spdyStreamArr) {
                try {
                    spdyStream.close(errorCode2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        if (pingArr != null) {
            for (Ping ping : pingArr) {
                ping.cancel();
            }
        }
        try {
            this.frameReader.close();
        } catch (IOException e3) {
            e = e3;
        }
        try {
            this.frameWriter.close();
        } catch (IOException e4) {
            if (e == null) {
                e = e4;
            }
        }
        if (e != null) {
            throw e;
        }
    }
}
