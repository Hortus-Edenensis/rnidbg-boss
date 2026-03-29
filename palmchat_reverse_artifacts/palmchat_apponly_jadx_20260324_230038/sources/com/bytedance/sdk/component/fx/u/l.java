package com.bytedance.sdk.component.fx.u;

import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class l {
    static final Logger u = Logger.getLogger(l.class.getName());

    private l() {
    }

    public static sx fx(File file) throws FileNotFoundException {
        if (file != null) {
            return u(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static sx nr(File file) throws FileNotFoundException {
        if (file != null) {
            return u(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static pn u(bg bgVar) {
        return new s(bgVar);
    }

    public static b u(sx sxVar) {
        return new mv(sxVar);
    }

    private static u fx(final Socket socket) {
        return new u() { // from class: com.bytedance.sdk.component.fx.u.l.4
            @Override // com.bytedance.sdk.component.fx.u.u
            public void e_() {
                try {
                    socket.close();
                } catch (AssertionError e) {
                    if (!l.u(e)) {
                        throw e;
                    }
                    l.u.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
                } catch (Exception e2) {
                    l.u.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
                }
            }

            @Override // com.bytedance.sdk.component.fx.u.u
            public IOException nr(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException(WkAdConfigModel.TAG_TIMEOUT);
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }
        };
    }

    public static bg nr(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getInputStream() != null) {
                u uVarFx = fx(socket);
                return uVarFx.u(u(socket.getInputStream(), uVarFx));
            }
            throw new IOException("socket's input stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static sx u(OutputStream outputStream) {
        return u(outputStream, new bq());
    }

    private static sx u(final OutputStream outputStream, final bq bqVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (bqVar != null) {
            return new sx() { // from class: com.bytedance.sdk.component.fx.u.l.1
                @Override // com.bytedance.sdk.component.fx.u.sx
                public void a_(fx fxVar, long j) throws IOException {
                    try {
                        dw.u(fxVar.nr, 0L, j);
                        while (j > 0) {
                            bqVar.x();
                            k kVar = fxVar.u;
                            int iMin = (int) Math.min(j, kVar.fx - kVar.nr);
                            outputStream.write(kVar.u, kVar.nr, iMin);
                            int i = kVar.nr + iMin;
                            kVar.nr = i;
                            long j2 = iMin;
                            j -= j2;
                            fxVar.nr -= j2;
                            if (i == kVar.fx) {
                                fxVar.u = kVar.nr();
                                my.u(kVar);
                            }
                        }
                    } catch (IOException | Exception unused) {
                    }
                }

                @Override // com.bytedance.sdk.component.fx.u.sx, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    outputStream.close();
                }

                @Override // com.bytedance.sdk.component.fx.u.sx, java.io.Flushable
                public void flush() throws IOException {
                    outputStream.flush();
                }

                public String toString() {
                    return "sink(" + outputStream + ")";
                }

                @Override // com.bytedance.sdk.component.fx.u.sx
                public bq u() {
                    return bqVar;
                }
            };
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static sx u(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                u uVarFx = fx(socket);
                return uVarFx.u(u(socket.getOutputStream(), uVarFx));
            }
            throw new IOException("socket's output stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static bg u(InputStream inputStream) {
        return u(inputStream, new bq());
    }

    private static bg u(final InputStream inputStream, final bq bqVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (bqVar != null) {
            return new bg() { // from class: com.bytedance.sdk.component.fx.u.l.2
                @Override // com.bytedance.sdk.component.fx.u.bg, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    inputStream.close();
                }

                public String toString() {
                    return "source(" + inputStream + ")";
                }

                @Override // com.bytedance.sdk.component.fx.u.bg
                public long u(fx fxVar, long j) throws IOException {
                    if (j < 0) {
                        throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
                    }
                    if (j == 0) {
                        return 0L;
                    }
                    try {
                        bqVar.x();
                        k kVarPn = fxVar.pn(1);
                        int i = inputStream.read(kVarPn.u, kVarPn.fx, (int) Math.min(j, 8192 - kVarPn.fx));
                        if (i == -1) {
                            return -1L;
                        }
                        kVarPn.fx += i;
                        long j2 = i;
                        fxVar.nr += j2;
                        return j2;
                    } catch (AssertionError e) {
                        if (l.u(e)) {
                            throw new IOException(e);
                        }
                        throw e;
                    } catch (Throwable th) {
                        throw new IOException(th.getMessage());
                    }
                }

                @Override // com.bytedance.sdk.component.fx.u.bg
                public bq u() {
                    return bqVar;
                }
            };
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static bg u(File file) throws FileNotFoundException {
        if (file != null) {
            return u(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static sx u() {
        return new sx() { // from class: com.bytedance.sdk.component.fx.u.l.3
            @Override // com.bytedance.sdk.component.fx.u.sx
            public void a_(fx fxVar, long j) throws IOException {
                fxVar.n(j);
            }

            @Override // com.bytedance.sdk.component.fx.u.sx
            public bq u() {
                return bq.fx;
            }

            @Override // com.bytedance.sdk.component.fx.u.sx, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
            }

            @Override // com.bytedance.sdk.component.fx.u.sx, java.io.Flushable
            public void flush() throws IOException {
            }
        };
    }

    public static boolean u(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
