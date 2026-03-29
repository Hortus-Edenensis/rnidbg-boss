package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import defpackage.th;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class HttpDataSource$HttpDataSourceException extends DataSourceException {
    public static final int TYPE_CLOSE = 3;
    public static final int TYPE_OPEN = 1;
    public static final int TYPE_READ = 2;
    public final b dataSpec;
    public final int type;

    @Deprecated
    public HttpDataSource$HttpDataSourceException(b bVar, int i) {
        this(bVar, 2000, i);
    }

    private static int assignErrorCode(int i, int i2) {
        if (i == 2000 && i2 == 1) {
            return 2001;
        }
        return i;
    }

    public static HttpDataSource$HttpDataSourceException createForIOException(final IOException iOException, final b bVar, int i) {
        String message = iOException.getMessage();
        int i2 = iOException instanceof SocketTimeoutException ? 2002 : iOException instanceof InterruptedIOException ? 1004 : (message == null || !th.e(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
        return i2 == 2007 ? new HttpDataSource$HttpDataSourceException(iOException, bVar) { // from class: com.google.android.exoplayer2.upstream.HttpDataSource$CleartextNotPermittedException
        } : new HttpDataSource$HttpDataSourceException(iOException, bVar, i2, i);
    }

    public HttpDataSource$HttpDataSourceException(b bVar, int i, int i2) {
        super(assignErrorCode(i, i2));
        this.dataSpec = bVar;
        this.type = i2;
    }

    @Deprecated
    public HttpDataSource$HttpDataSourceException(String str, b bVar, int i) {
        this(str, bVar, 2000, i);
    }

    public HttpDataSource$HttpDataSourceException(String str, b bVar, int i, int i2) {
        super(str, assignErrorCode(i, i2));
        this.dataSpec = bVar;
        this.type = i2;
    }

    @Deprecated
    public HttpDataSource$HttpDataSourceException(IOException iOException, b bVar, int i) {
        this(iOException, bVar, 2000, i);
    }

    public HttpDataSource$HttpDataSourceException(IOException iOException, b bVar, int i, int i2) {
        super(iOException, assignErrorCode(i, i2));
        this.dataSpec = bVar;
        this.type = i2;
    }

    @Deprecated
    public HttpDataSource$HttpDataSourceException(String str, IOException iOException, b bVar, int i) {
        this(str, iOException, bVar, 2000, i);
    }

    public HttpDataSource$HttpDataSourceException(String str, @Nullable IOException iOException, b bVar, int i, int i2) {
        super(str, iOException, assignErrorCode(i, i2));
        this.dataSpec = bVar;
        this.type = i2;
    }
}
