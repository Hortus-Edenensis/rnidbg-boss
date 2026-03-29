package com.oplus.tblplayer.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.ExoPlayerLibraryInfo;
import com.oplus.tbl.exoplayer2.upstream.BaseDataSource;
import com.oplus.tbl.exoplayer2.upstream.DataSourceException;
import com.oplus.tbl.exoplayer2.upstream.DataSpec;
import com.oplus.tbl.exoplayer2.upstream.HttpDataSource;
import com.oplus.tbl.exoplayer2.upstream.TransferListener;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.Util;
import defpackage.em4;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class OkHttpDataSource2 extends BaseDataSource implements HttpDataSource {
    private static final byte[] SKIP_BUFFER;
    private long bytesRead;
    private long bytesSkipped;
    private long bytesToRead;
    private long bytesToSkip;

    @Nullable
    private final CacheControl cacheControl;
    private final Call.Factory callFactory;

    @Nullable
    private em4<String> contentTypePredicate;

    @Nullable
    protected DataSpec dataSpec;

    @Nullable
    private final HttpDataSource.RequestProperties defaultRequestProperties;
    protected boolean opened;
    private final HttpDataSource.RequestProperties requestProperties;

    @Nullable
    protected Response response;

    @Nullable
    protected InputStream responseByteStream;

    @Nullable
    private final String userAgent;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Factory implements HttpDataSource.Factory {

        @Nullable
        private CacheControl cacheControl;
        private final Call.Factory callFactory;

        @Nullable
        private em4<String> contentTypePredicate;
        private final HttpDataSource.RequestProperties defaultRequestProperties = new HttpDataSource.RequestProperties();

        @Nullable
        private TransferListener transferListener;

        @Nullable
        private String userAgent;

        public Factory(Call.Factory factory) {
            this.callFactory = factory;
        }

        @Override // com.oplus.tbl.exoplayer2.upstream.HttpDataSource.Factory
        @Deprecated
        public final HttpDataSource.RequestProperties getDefaultRequestProperties() {
            return this.defaultRequestProperties;
        }

        public Factory setCacheControl(@Nullable CacheControl cacheControl) {
            this.cacheControl = cacheControl;
            return this;
        }

        public Factory setContentTypePredicate(@Nullable em4<String> em4Var) {
            this.contentTypePredicate = em4Var;
            return this;
        }

        @Override // com.oplus.tbl.exoplayer2.upstream.HttpDataSource.Factory
        public /* bridge */ /* synthetic */ HttpDataSource.Factory setDefaultRequestProperties(Map map) {
            return setDefaultRequestProperties((Map<String, String>) map);
        }

        public Factory setTransferListener(@Nullable TransferListener transferListener) {
            this.transferListener = transferListener;
            return this;
        }

        public Factory setUserAgent(@Nullable String str) {
            this.userAgent = str;
            return this;
        }

        @Override // com.oplus.tbl.exoplayer2.upstream.HttpDataSource.Factory
        public final Factory setDefaultRequestProperties(Map<String, String> map) {
            this.defaultRequestProperties.clearAndSet(map);
            return this;
        }

        @Override // com.oplus.tbl.exoplayer2.upstream.HttpDataSource.Factory, com.oplus.tbl.exoplayer2.upstream.DataSource.Factory
        public OkHttpDataSource2 createDataSource() {
            OkHttpDataSource2 okHttpDataSource2 = new OkHttpDataSource2(this.callFactory, this.userAgent, this.cacheControl, this.defaultRequestProperties, this.contentTypePredicate);
            TransferListener transferListener = this.transferListener;
            if (transferListener != null) {
                okHttpDataSource2.addTransferListener(transferListener);
            }
            return okHttpDataSource2;
        }
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.okhttp");
        SKIP_BUFFER = new byte[4096];
    }

    @Deprecated
    public OkHttpDataSource2(Call.Factory factory) {
        this(factory, null);
    }

    private void closeConnectionQuietly() {
        Response response = this.response;
        if (response != null) {
            ((ResponseBody) Assertions.checkNotNull(response.body())).close();
            this.response = null;
        }
        this.responseByteStream = null;
    }

    private Request makeRequest(DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        long j = dataSpec.position;
        long j2 = dataSpec.length;
        HttpUrl httpUrl = HttpUrl.parse(dataSpec.uri.toString());
        if (httpUrl == null) {
            throw new HttpDataSource.HttpDataSourceException("Malformed URL", dataSpec, 1);
        }
        Request.Builder builderUrl = new Request.Builder().url(httpUrl);
        CacheControl cacheControl = this.cacheControl;
        if (cacheControl != null) {
            builderUrl.cacheControl(cacheControl);
        }
        HashMap map = new HashMap();
        HttpDataSource.RequestProperties requestProperties = this.defaultRequestProperties;
        if (requestProperties != null) {
            map.putAll(requestProperties.getSnapshot());
        }
        map.putAll(this.requestProperties.getSnapshot());
        map.putAll(dataSpec.httpRequestHeaders);
        for (Map.Entry entry : map.entrySet()) {
            builderUrl.header((String) entry.getKey(), (String) entry.getValue());
        }
        if (j != 0 || j2 != -1) {
            String str = "bytes=" + j + "-";
            if (j2 != -1) {
                str = str + ((j + j2) - 1);
            }
            builderUrl.addHeader(HttpHeaders.RANGE, str);
        }
        String str2 = this.userAgent;
        if (str2 != null) {
            builderUrl.addHeader("User-Agent", str2);
        }
        if (!dataSpec.isFlagSet(1)) {
            builderUrl.addHeader(HttpHeaders.ACCEPT_ENCODING, HTTP.IDENTITY_CODING);
        }
        byte[] bArr = dataSpec.httpBody;
        RequestBody requestBodyCreate = null;
        if (bArr != null) {
            requestBodyCreate = RequestBody.create((MediaType) null, bArr);
        } else if (dataSpec.httpMethod == 2) {
            requestBodyCreate = RequestBody.create((MediaType) null, Util.EMPTY_BYTE_ARRAY);
        }
        builderUrl.method(dataSpec.getHttpMethodString(), requestBodyCreate);
        return builderUrl.build();
    }

    private int readInternal(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.bytesToRead;
        if (j != -1) {
            long j2 = j - this.bytesRead;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, j2);
        }
        int i3 = ((InputStream) Util.castNonNull(this.responseByteStream)).read(bArr, i, i2);
        if (i3 == -1) {
            if (this.bytesToRead == -1) {
                return -1;
            }
            throw new EOFException();
        }
        this.bytesRead += (long) i3;
        bytesTransferred(i3);
        return i3;
    }

    private void skipInternal() throws IOException {
        if (this.bytesSkipped == this.bytesToSkip) {
            return;
        }
        while (true) {
            long j = this.bytesSkipped;
            long j2 = this.bytesToSkip;
            if (j == j2) {
                return;
            }
            long j3 = j2 - j;
            int i = ((InputStream) Util.castNonNull(this.responseByteStream)).read(SKIP_BUFFER, 0, (int) Math.min(j3, r0.length));
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedIOException();
            }
            if (i == -1) {
                throw new EOFException();
            }
            this.bytesSkipped += (long) i;
            bytesTransferred(i);
        }
    }

    public final long bytesRead() {
        return this.bytesRead;
    }

    public final long bytesRemaining() {
        long j = this.bytesToRead;
        return j == -1 ? j : j - this.bytesRead;
    }

    public final long bytesSkipped() {
        return this.bytesSkipped;
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public void clearAllRequestProperties() {
        this.requestProperties.clear();
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public void clearRequestProperty(String str) {
        Assertions.checkNotNull(str);
        this.requestProperties.remove(str);
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public void close() throws HttpDataSource.HttpDataSourceException {
        if (this.opened) {
            this.opened = false;
            transferEnded();
            closeConnectionQuietly();
        }
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public int getResponseCode() {
        Response response = this.response;
        if (response == null) {
            return -1;
        }
        return response.code();
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.BaseDataSource, com.oplus.tbl.exoplayer2.upstream.DataSource, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public Map<String, List<String>> getResponseHeaders() {
        Response response = this.response;
        return response == null ? Collections.emptyMap() : response.headers().toMultimap();
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        Response response = this.response;
        if (response == null) {
            return null;
        }
        return Uri.parse(response.request().url().getUrl());
    }

    public Call newCall(Request request) {
        return this.callFactory.newCall(request);
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataSource, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public long open(DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        byte[] byteArray;
        this.dataSpec = dataSpec;
        long j = 0;
        this.bytesRead = 0L;
        this.bytesSkipped = 0L;
        transferInitializing(dataSpec);
        try {
            Response responseExecute = newCall(makeRequest(dataSpec)).execute();
            this.response = responseExecute;
            ResponseBody responseBody = (ResponseBody) Assertions.checkNotNull(responseExecute.body());
            this.responseByteStream = responseBody.byteStream();
            int iCode = responseExecute.code();
            if (!responseExecute.isSuccessful()) {
                try {
                    byteArray = Util.toByteArray((InputStream) Assertions.checkNotNull(this.responseByteStream));
                } catch (IOException unused) {
                    byteArray = Util.EMPTY_BYTE_ARRAY;
                }
                Map<String, List<String>> multimap = responseExecute.headers().toMultimap();
                closeConnectionQuietly();
                HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = new HttpDataSource.InvalidResponseCodeException(iCode, responseExecute.message(), multimap, dataSpec, byteArray);
                if (iCode == 416) {
                    invalidResponseCodeException.initCause(new DataSourceException(0));
                }
                throw invalidResponseCodeException;
            }
            MediaType mediaType = responseBody.get$contentType();
            String mediaType2 = mediaType != null ? mediaType.getMediaType() : "";
            em4<String> em4Var = this.contentTypePredicate;
            if (em4Var != null && !em4Var.apply(mediaType2)) {
                closeConnectionQuietly();
                throw new HttpDataSource.InvalidContentTypeException(mediaType2, dataSpec);
            }
            if (iCode == 200) {
                long j2 = dataSpec.position;
                if (j2 != 0) {
                    j = j2;
                }
            }
            this.bytesToSkip = j;
            long j3 = dataSpec.length;
            if (j3 != -1) {
                this.bytesToRead = j3;
            } else {
                long contentLength = responseBody.getContentLength();
                this.bytesToRead = contentLength != -1 ? contentLength - this.bytesToSkip : -1L;
            }
            this.opened = true;
            transferStarted(dataSpec);
            return this.bytesToRead;
        } catch (IOException e) {
            String message = e.getMessage();
            if (message == null || !Util.toLowerInvariant(message).matches("cleartext communication.*not permitted.*")) {
                throw new HttpDataSource.HttpDataSourceException("Unable to connect", e, dataSpec, 1);
            }
            throw new HttpDataSource.CleartextNotPermittedException(e, dataSpec);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.DataReader, com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public int read(byte[] bArr, int i, int i2) throws HttpDataSource.HttpDataSourceException {
        try {
            skipInternal();
            return readInternal(bArr, i, i2);
        } catch (IOException e) {
            throw new HttpDataSource.HttpDataSourceException(e, (DataSpec) Assertions.checkNotNull(this.dataSpec), 2);
        }
    }

    @Deprecated
    public void setContentTypePredicate(@Nullable em4<String> em4Var) {
        this.contentTypePredicate = em4Var;
    }

    @Override // com.oplus.tbl.exoplayer2.upstream.HttpDataSource
    public void setRequestProperty(String str, String str2) {
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(str2);
        this.requestProperties.set(str, str2);
    }

    @Deprecated
    public OkHttpDataSource2(Call.Factory factory, @Nullable String str) {
        this(factory, str, null, null);
    }

    @Deprecated
    public OkHttpDataSource2(Call.Factory factory, @Nullable String str, @Nullable CacheControl cacheControl, @Nullable HttpDataSource.RequestProperties requestProperties) {
        this(factory, str, cacheControl, requestProperties, null);
    }

    public OkHttpDataSource2(Call.Factory factory, @Nullable String str, @Nullable CacheControl cacheControl, @Nullable HttpDataSource.RequestProperties requestProperties, @Nullable em4<String> em4Var) {
        super(true);
        this.callFactory = (Call.Factory) Assertions.checkNotNull(factory);
        this.userAgent = str;
        this.cacheControl = cacheControl;
        this.defaultRequestProperties = requestProperties;
        this.contentTypePredicate = em4Var;
        this.requestProperties = new HttpDataSource.RequestProperties();
    }
}
