package com.oplus.tblplayer.upstream;

import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.openalliance.ad.constant.az;
import com.oplus.tbl.exoplayer2.upstream.DataSpec;
import com.oplus.tbl.exoplayer2.upstream.HttpDataSource;
import com.oplus.tbl.exoplayer2.upstream.TransferListener;
import com.oplus.tbl.exoplayer2.upstream.cache.Cache;
import com.oplus.tbl.exoplayer2.upstream.cache.ContentMetadataMutations;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.utils.LogUtil;
import com.oplus.tblplayer.utils.ReflectUtil;
import defpackage.em4;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;
import okio.Timeout;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class TBLOkHttpDataSource extends OkHttpDataSource2 {
    private static final long HTTP_SUBRANGE_REQUEST_BYTES = 1048576;
    private static final long MAX_BYTES_TO_DRAIN = 2048;
    private static final String METADATA_NAME_REDIRECTED_URI = "exo_redir";
    private static final String OKHTTP_ABSTRACT_SOURCE_CLASS = "okhttp3.internal.http1.Http1Codec$AbstractSource";
    private static final String OKHTTP_FIXED_LENGTH_SOURCE_CLASS = "okhttp3.internal.http1.Http1Codec$FixedLengthSource";
    private static final String OKHTTP_REAL_CALL_CLASS = "okhttp3.RealCall";
    private static final String TAG = "TBLOkHttpDataSource";
    private Cache cache;
    private long closeAtTimestamp;
    private DataSpec currentSubrangeDataSpec;
    private long firstReadTime;
    private boolean hasFirstRead;
    private long openAtTimestamp;
    private int originalTransferredCount;
    private boolean preferRedirectAddress;
    private boolean preferSubrangeRequest;
    private DataSpec rawDataSpec;
    private Call realCall;
    private int redirectTransferredCount;
    private String redirectedAddress;
    private int redirectingCount;
    private long resourceLength;
    private long subrangeBytesRead;
    private long totalBytesRead;

    /* JADX INFO: compiled from: SearchBox */
    public class InnerCallEventListener extends EventListener {
        private InnerCallEventListener() {
        }

        @Override // okhttp3.EventListener
        public void responseHeadersEnd(Call call, Response response) {
            if (response == null || !response.isRedirect()) {
                return;
            }
            String strHeader = response.header(HttpHeaders.LOCATION);
            HttpUrl httpUrlUrl = response.request().url();
            if (TBLOkHttpDataSource.this.preferRedirectAddress) {
                LogUtil.dfmt(TBLOkHttpDataSource.TAG, "Http response is redirect, from %s to %s", httpUrlUrl.getUrl(), strHeader);
                TBLOkHttpDataSource tBLOkHttpDataSource = TBLOkHttpDataSource.this;
                tBLOkHttpDataSource.progressRedirecting(TBLOkHttpDataSource.access$104(tBLOkHttpDataSource), httpUrlUrl.getUrl(), strHeader);
            }
        }
    }

    public TBLOkHttpDataSource(Call.Factory factory, @Nullable String str, @Nullable em4<String> em4Var) {
        this(factory, str, em4Var, null, null);
    }

    public static /* synthetic */ int access$104(TBLOkHttpDataSource tBLOkHttpDataSource) {
        int i = tBLOkHttpDataSource.redirectingCount + 1;
        tBLOkHttpDataSource.redirectingCount = i;
        return i;
    }

    private long advanceSubrangeDataSpec(@NonNull DataSpec dataSpec, long j) throws HttpDataSource.HttpDataSourceException {
        long jMin = Math.min(this.resourceLength - (dataSpec.position + j), 1048576L);
        if (jMin <= 0) {
            return -1L;
        }
        closeInternal(false);
        DataSpec dataSpecSubrange = dataSpec.subrange(j, jMin);
        this.currentSubrangeDataSpec = dataSpecSubrange;
        return openWithRetry(dataSpecSubrange);
    }

    private void closeInternal(boolean z) throws HttpDataSource.HttpDataSourceException {
        if (this.preferSubrangeRequest && this.currentSubrangeDataSpec != null) {
            LogUtil.d(TAG, "closeInternal: last subrange has read bytes: " + this.subrangeBytesRead);
            this.subrangeBytesRead = 0L;
            this.currentSubrangeDataSpec = null;
        }
        this.closeAtTimestamp = SystemClock.elapsedRealtime();
        if (this.opened) {
            maybeDiscardRemainingBytes(z);
        }
        Response response = this.response;
        super.close();
        StringBuilder sb = new StringBuilder();
        sb.append("OKHttp has closed, http protocol: ");
        sb.append(response != null ? response.protocol() : Constants.STRING_VALUE_UNSET);
        sb.append(", cost time: ");
        sb.append(SystemClock.elapsedRealtime() - this.closeAtTimestamp);
        sb.append(", exist time: ");
        sb.append(SystemClock.elapsedRealtime() - this.openAtTimestamp);
        LogUtil.d(TAG, sb.toString());
    }

    private static Uri getCachedRedirectedUri(Cache cache, String str) {
        String str2;
        if (cache == null || TextUtils.isEmpty(str) || (str2 = cache.getContentMetadata(str).get("exo_redir", (String) null)) == null) {
            return null;
        }
        return Uri.parse(str2);
    }

    private synchronized void maybeCacheRedirectAddress(DataSpec dataSpec) {
        Uri uri;
        Response response = this.response;
        if (response != null) {
            String url = response.request().url().getUrl();
            if (!TextUtils.isEmpty(url) && (uri = dataSpec.uri) != null && !url.equals(uri.toString()) && !Uri.decode(url).equals(dataSpec.uri.toString())) {
                this.redirectedAddress = url;
                LogUtil.d(TAG, "Maybe cache redirect address.");
                setCachedRedirectedUri(this.cache, this.rawDataSpec.key, Uri.parse(url));
            }
        }
    }

    private DataSpec maybeRedirectDataSpec(@NonNull DataSpec dataSpec) {
        Uri cachedRedirectedUri;
        if (!this.preferRedirectAddress) {
            return dataSpec;
        }
        if (this.redirectedAddress == null && (cachedRedirectedUri = getCachedRedirectedUri(this.cache, dataSpec.key)) != null && cachedRedirectedUri.compareTo(this.rawDataSpec.uri) != 0) {
            this.redirectedAddress = cachedRedirectedUri.toString();
        }
        String str = this.redirectedAddress;
        if (str == null || dataSpec.uri.compareTo(Uri.parse(str)) == 0) {
            return dataSpec;
        }
        LogUtil.d(TAG, "Open media source will use redirected address.");
        return dataSpec.withUri(Uri.parse(this.redirectedAddress));
    }

    private void maybeTerminateSource(Source source) {
        try {
            if (ReflectUtil.checkIsType(OKHTTP_FIXED_LENGTH_SOURCE_CLASS, source)) {
                Long l = (Long) ReflectUtil.getField(source, Long.class, "bytesRemaining");
                if (l == null || l.longValue() > 2048) {
                    ReflectUtil.setField(source, Long.class, "bytesRemaining", 0);
                    ReflectUtil.invoke(OKHTTP_ABSTRACT_SOURCE_CLASS, source, "endOfInput", (Class<?>[]) new Class[]{Boolean.TYPE, IOException.class}, Boolean.FALSE, null);
                }
            }
        } catch (Exception unused) {
        }
    }

    private long openInternal(@NonNull DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        int i;
        if (this.preferRedirectAddress) {
            if (this.rawDataSpec.uri.compareTo(dataSpec.uri) != 0) {
                if (this.originalTransferredCount != 0 && (i = this.redirectTransferredCount) == 0) {
                    this.redirectTransferredCount = i + 1;
                }
                int i2 = this.redirectTransferredCount + 1;
                this.redirectTransferredCount = i2;
                redirectTransferred(i2, this.rawDataSpec.uri.toString(), dataSpec.uri.toString());
            } else {
                int i3 = this.originalTransferredCount + 1;
                this.originalTransferredCount = i3;
                originalTransferred(i3, this.rawDataSpec.uri.toString());
            }
        }
        return super.open(dataSpec);
    }

    private long openWithRetry(@NonNull DataSpec dataSpec) throws IOException {
        try {
            return openInternal(dataSpec);
        } catch (IOException e) {
            if (!shouldIgnoreException(e.getCause()) || this.rawDataSpec.uri.compareTo(dataSpec.uri) == 0) {
                throw e;
            }
            setCachedRedirectedUri(this.cache, this.rawDataSpec.key, null);
            this.redirectedAddress = null;
            return openInternal(dataSpec.withUri(this.rawDataSpec.uri));
        }
    }

    private int readInternal(byte[] bArr, int i, int i2) throws HttpDataSource.HttpDataSourceException {
        return super.read(bArr, i, i2);
    }

    private static void setCachedRedirectedUri(Cache cache, String str, Uri uri) {
        if (cache != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
                if (uri != null) {
                    contentMetadataMutations.set("exo_redir", uri.toString());
                } else {
                    contentMetadataMutations.remove("exo_redir");
                }
                cache.applyContentMetadataMutations(str, contentMetadataMutations);
            } catch (IOException e) {
                LogUtil.e(TAG, "Set redirected uri failed. " + e.getMessage());
            }
        }
    }

    private boolean shouldIgnoreException(Throwable th) {
        LogUtil.d(TAG, "shouldIgnoreException: ", th);
        if (th instanceof SocketTimeoutException) {
            return true;
        }
        return !(th instanceof InterruptedIOException);
    }

    private static long skipAll(Source source, int i, TimeUnit timeUnit) throws IOException {
        long jNanoTime = System.nanoTime();
        long jDeadlineNanoTime = source.getTimeout().getHasDeadline() ? source.getTimeout().deadlineNanoTime() - jNanoTime : Long.MAX_VALUE;
        source.getTimeout().deadlineNanoTime(Math.min(jDeadlineNanoTime, timeUnit.toNanos(i)) + jNanoTime);
        long size = 0;
        try {
            try {
                Buffer buffer = new Buffer();
                while (source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                    size += buffer.size();
                    buffer.clear();
                }
                Timeout timeout = source.getTimeout();
                if (jDeadlineNanoTime == Long.MAX_VALUE) {
                    timeout.clearDeadline();
                } else {
                    timeout.deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
                }
                return size;
            } catch (InterruptedIOException e) {
                LogUtil.w(TAG, "Out of time before exhausting the source with " + e.getMessage());
                Timeout timeout2 = source.getTimeout();
                if (jDeadlineNanoTime == Long.MAX_VALUE) {
                    timeout2.clearDeadline();
                } else {
                    timeout2.deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
                }
                return size;
            }
        } catch (Throwable th) {
            Timeout timeout3 = source.getTimeout();
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                timeout3.clearDeadline();
            } else {
                timeout3.deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            throw th;
        }
    }

    public final void bytesDiscarded(long j, boolean z) {
        Integer num = (Integer) ReflectUtil.getField(this, Integer.class, "listenerCount");
        ArrayList arrayList = (ArrayList) ReflectUtil.getField(this, ArrayList.class, "listeners");
        if (num == null || arrayList == null) {
            return;
        }
        for (int i = 0; i < num.intValue(); i++) {
            TransferListener transferListener = (TransferListener) arrayList.get(i);
            if (transferListener instanceof RedirectTransferListener) {
                ((RedirectTransferListener) transferListener).onBytesDiscarded(this, j, z);
            }
        }
    }

    @Override // com.oplus.tblplayer.upstream.OkHttpDataSource2, com.oplus.tbl.exoplayer2.upstream.DataSource, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public void close() throws HttpDataSource.HttpDataSourceException {
        closeInternal(true);
        transferState(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long maybeDiscardRemainingBytes(boolean z) {
        long jSkipAll;
        Source sourceDelegate;
        Response response = this.response;
        if (response == null || response.body() == null) {
            return 0L;
        }
        Source source = (Source) ReflectUtil.getField(this.response.body().getSource(), Source.class, az.at);
        if (this.response.protocol() != Protocol.HTTP_2) {
            try {
                if (source != null) {
                    try {
                    } catch (Exception e) {
                        e = e;
                        jSkipAll = 0;
                    }
                    if (ReflectUtil.checkIsType(OKHTTP_FIXED_LENGTH_SOURCE_CLASS, source)) {
                        Long l = (Long) ReflectUtil.getField(source, Long.class, "bytesRemaining");
                        if (!z || l == null || l.longValue() == 0) {
                            jSkipAll = 0;
                        } else {
                            jSkipAll = skipAll(this.response.body().getSource(), 100, TimeUnit.MILLISECONDS);
                            try {
                                LogUtil.d(TAG, "OKHttp[HTTP/1.1] bytesDiscarded = " + jSkipAll);
                            } catch (Exception e2) {
                                e = e2;
                                LogUtil.w(TAG, "Skip source failed when close. " + e.getMessage());
                            }
                        }
                        if (source != null) {
                        }
                    }
                }
            } finally {
                maybeTerminateSource(source);
            }
        } else if (!(source instanceof ForwardingSource) || (sourceDelegate = ((ForwardingSource) source).delegate()) == null) {
            jSkipAll = 0;
        } else {
            synchronized (sourceDelegate) {
                Buffer buffer = (Buffer) ReflectUtil.getField(sourceDelegate, Buffer.class, "readBuffer");
                if (buffer != null) {
                    jSkipAll = buffer.size();
                    LogUtil.d(TAG, "OKHttp[HTTP/2] bytesDiscarded = " + jSkipAll);
                } else {
                    jSkipAll = 0;
                }
            }
        }
        if (jSkipAll > 0) {
            bytesDiscarded(jSkipAll, true);
        }
        return jSkipAll;
    }

    @Override // com.oplus.tblplayer.upstream.OkHttpDataSource2
    public Call newCall(Request request) {
        Call callNewCall = super.newCall((Request) Assertions.checkNotNull(request));
        this.realCall = callNewCall;
        if (ReflectUtil.checkIsType(OKHTTP_REAL_CALL_CLASS, callNewCall)) {
            ReflectUtil.setField(this.realCall, EventListener.class, "eventListener", new InnerCallEventListener());
        }
        return this.realCall;
    }

    @Override // com.oplus.tblplayer.upstream.OkHttpDataSource2, com.oplus.tbl.exoplayer2.upstream.DataSource, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public long open(@NonNull DataSpec dataSpec) throws IOException {
        this.openAtTimestamp = SystemClock.elapsedRealtime();
        this.rawDataSpec = (DataSpec) Assertions.checkNotNull(dataSpec);
        transferState(false);
        long jOpenWithRetry = dataSpec.length;
        if (!this.preferSubrangeRequest || jOpenWithRetry == -1) {
            dataSpec = maybeRedirectDataSpec(dataSpec);
            jOpenWithRetry = openWithRetry(dataSpec);
            maybeCacheRedirectAddress(dataSpec);
        }
        if (this.preferSubrangeRequest) {
            this.resourceLength = dataSpec.position + jOpenWithRetry;
            advanceSubrangeDataSpec(maybeRedirectDataSpec(dataSpec), 0L);
        }
        LogUtil.d(TAG, "OkHttp data source open cost time is " + (SystemClock.elapsedRealtime() - this.openAtTimestamp) + " ms");
        return jOpenWithRetry;
    }

    public final void originalTransferred(int i, String str) {
        Integer num = (Integer) ReflectUtil.getField(this, Integer.class, "listenerCount");
        ArrayList arrayList = (ArrayList) ReflectUtil.getField(this, ArrayList.class, "listeners");
        if (num == null || arrayList == null) {
            return;
        }
        for (int i2 = 0; i2 < num.intValue(); i2++) {
            TransferListener transferListener = (TransferListener) arrayList.get(i2);
            if (transferListener instanceof RedirectTransferListener) {
                ((RedirectTransferListener) transferListener).onOriginalTransferred(this, i, str);
            }
        }
    }

    public final void progressRedirecting(int i, String... strArr) {
        Integer num = (Integer) ReflectUtil.getField(this, Integer.class, "listenerCount");
        ArrayList arrayList = (ArrayList) ReflectUtil.getField(this, ArrayList.class, "listeners");
        if (num == null || arrayList == null) {
            return;
        }
        for (int i2 = 0; i2 < num.intValue(); i2++) {
            TransferListener transferListener = (TransferListener) arrayList.get(i2);
            if (transferListener instanceof RedirectTransferListener) {
                ((RedirectTransferListener) transferListener).onRedirecting(this, i, strArr);
            }
        }
    }

    @Override // com.oplus.tblplayer.upstream.OkHttpDataSource2, com.oplus.tbl.exoplayer2.upstream.DataReader, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public int read(byte[] bArr, int i, int i2) throws HttpDataSource.HttpDataSourceException {
        DataSpec dataSpec;
        if (this.hasFirstRead) {
            this.firstReadTime = SystemClock.elapsedRealtime();
            this.hasFirstRead = false;
            LogUtil.d(TAG, "first read at " + LogUtil.getDateTimeString(this.firstReadTime));
        }
        try {
            int internal = readInternal(bArr, i, i2);
            if (this.preferSubrangeRequest && internal == -1 && (dataSpec = this.currentSubrangeDataSpec) != null) {
                advanceSubrangeDataSpec(maybeRedirectDataSpec(dataSpec), dataSpec.length);
                internal = readInternal(bArr, i, i2);
            }
            if (internal != -1) {
                long j = internal;
                this.totalBytesRead += j;
                long j2 = this.subrangeBytesRead;
                if (!this.preferSubrangeRequest) {
                    j = 0;
                }
                this.subrangeBytesRead = j2 + j;
            }
            return internal;
        } catch (Throwable th) {
            if (!(th.getCause() instanceof InterruptedIOException)) {
                LogUtil.d(TAG, "read: ", th);
            }
            throw th;
        }
    }

    public final void redirectTransferred(int i, String... strArr) {
        Integer num = (Integer) ReflectUtil.getField(this, Integer.class, "listenerCount");
        ArrayList arrayList = (ArrayList) ReflectUtil.getField(this, ArrayList.class, "listeners");
        if (num == null || arrayList == null) {
            return;
        }
        for (int i2 = 0; i2 < num.intValue(); i2++) {
            TransferListener transferListener = (TransferListener) arrayList.get(i2);
            if (transferListener instanceof RedirectTransferListener) {
                ((RedirectTransferListener) transferListener).onRedirectTransferred(this, i, strArr);
            }
        }
    }

    public final void transferState(boolean z) {
        Integer num = (Integer) ReflectUtil.getField(this, Integer.class, "listenerCount");
        ArrayList arrayList = (ArrayList) ReflectUtil.getField(this, ArrayList.class, "listeners");
        if (num == null || arrayList == null) {
            return;
        }
        for (int i = 0; i < num.intValue(); i++) {
            TransferListener transferListener = (TransferListener) arrayList.get(i);
            if (transferListener instanceof RedirectTransferListener) {
                ((RedirectTransferListener) transferListener).onTransferState(this, z);
            }
        }
    }

    public TBLOkHttpDataSource(Call.Factory factory, @Nullable String str, @Nullable em4<String> em4Var, @Nullable CacheControl cacheControl, @Nullable HttpDataSource.RequestProperties requestProperties) {
        this(factory, str, em4Var, cacheControl, requestProperties, false, false, null);
    }

    public TBLOkHttpDataSource(Call.Factory factory, @Nullable String str, @Nullable em4<String> em4Var, @Nullable CacheControl cacheControl, @Nullable HttpDataSource.RequestProperties requestProperties, boolean z, boolean z2, Cache cache) {
        super(factory, str, cacheControl, requestProperties, em4Var);
        this.openAtTimestamp = 0L;
        this.closeAtTimestamp = 0L;
        this.hasFirstRead = true;
        this.firstReadTime = 0L;
        this.totalBytesRead = 0L;
        this.subrangeBytesRead = 0L;
        this.redirectedAddress = null;
        this.resourceLength = -1L;
        this.rawDataSpec = null;
        this.currentSubrangeDataSpec = null;
        this.preferRedirectAddress = z;
        this.preferSubrangeRequest = z2;
        this.cache = cache;
    }
}
