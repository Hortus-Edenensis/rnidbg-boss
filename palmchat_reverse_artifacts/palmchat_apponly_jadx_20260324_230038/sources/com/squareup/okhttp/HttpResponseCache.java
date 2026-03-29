package com.squareup.okhttp;

import com.baidu.mapapi.http.wrapper.HttpManager;
import com.squareup.okhttp.internal.Base64;
import com.squareup.okhttp.internal.DiskLruCache;
import com.squareup.okhttp.internal.StrictLineReader;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpURLConnectionImpl;
import com.squareup.okhttp.internal.http.HttpsEngine;
import com.squareup.okhttp.internal.http.HttpsURLConnectionImpl;
import com.squareup.okhttp.internal.http.RawHeaders;
import com.squareup.okhttp.internal.http.ResponseHeaders;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.HttpURLConnection;
import java.net.ResponseCache;
import java.net.SecureCacheResponse;
import java.net.URI;
import java.net.URLConnection;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class HttpResponseCache extends ResponseCache {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    final OkResponseCache okResponseCache = new OkResponseCache() { // from class: com.squareup.okhttp.HttpResponseCache.1
        @Override // com.squareup.okhttp.OkResponseCache
        public CacheResponse get(URI uri, String str, Map<String, List<String>> map) throws IOException {
            return HttpResponseCache.this.get(uri, str, map);
        }

        @Override // com.squareup.okhttp.OkResponseCache
        public void maybeRemove(String str, URI uri) throws IOException {
            HttpResponseCache.this.maybeRemove(str, uri);
        }

        @Override // com.squareup.okhttp.OkResponseCache
        public CacheRequest put(URI uri, URLConnection uRLConnection) throws IOException {
            return HttpResponseCache.this.put(uri, uRLConnection);
        }

        @Override // com.squareup.okhttp.OkResponseCache
        public void trackConditionalCacheHit() {
            HttpResponseCache.this.trackConditionalCacheHit();
        }

        @Override // com.squareup.okhttp.OkResponseCache
        public void trackResponse(ResponseSource responseSource) {
            HttpResponseCache.this.trackResponse(responseSource);
        }

        @Override // com.squareup.okhttp.OkResponseCache
        public void update(CacheResponse cacheResponse, HttpURLConnection httpURLConnection) throws IOException {
            HttpResponseCache.this.update(cacheResponse, httpURLConnection);
        }
    };
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    /* JADX INFO: renamed from: com.squareup.okhttp.HttpResponseCache$3, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$okhttp$ResponseSource;

        static {
            int[] iArr = new int[ResponseSource.values().length];
            $SwitchMap$com$squareup$okhttp$ResponseSource = iArr;
            try {
                iArr[ResponseSource.CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$squareup$okhttp$ResponseSource[ResponseSource.CONDITIONAL_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$squareup$okhttp$ResponseSource[ResponseSource.NETWORK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class CacheRequestImpl extends CacheRequest {
        private OutputStream body;
        private OutputStream cacheOut;
        private boolean done;
        private final DiskLruCache.Editor editor;

        public CacheRequestImpl(final DiskLruCache.Editor editor) throws IOException {
            this.editor = editor;
            this.cacheOut = editor.newOutputStream(1);
            this.body = new FilterOutputStream(this.cacheOut) { // from class: com.squareup.okhttp.HttpResponseCache.CacheRequestImpl.1
                @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    synchronized (HttpResponseCache.this) {
                        if (CacheRequestImpl.this.done) {
                            return;
                        }
                        CacheRequestImpl.this.done = true;
                        HttpResponseCache.this.writeSuccessCount++;
                        super.close();
                        editor.commit();
                    }
                }

                @Override // java.io.FilterOutputStream, java.io.OutputStream
                public void write(byte[] bArr, int i, int i2) throws IOException {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                }
            };
        }

        @Override // java.net.CacheRequest
        public void abort() {
            synchronized (HttpResponseCache.this) {
                if (this.done) {
                    return;
                }
                this.done = true;
                HttpResponseCache.this.writeAbortCount++;
                Util.closeQuietly(this.cacheOut);
                try {
                    this.editor.abort();
                } catch (IOException unused) {
                }
            }
        }

        @Override // java.net.CacheRequest
        public OutputStream getBody() throws IOException {
            return this.body;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class EntryCacheResponse extends CacheResponse {
        private final Entry entry;
        private final InputStream in;
        private final DiskLruCache.Snapshot snapshot;

        public EntryCacheResponse(Entry entry, DiskLruCache.Snapshot snapshot) {
            this.entry = entry;
            this.snapshot = snapshot;
            this.in = HttpResponseCache.newBodyInputStream(snapshot);
        }

        @Override // java.net.CacheResponse
        public InputStream getBody() {
            return this.in;
        }

        @Override // java.net.CacheResponse
        public Map<String, List<String>> getHeaders() {
            return this.entry.responseHeaders.toMultimap(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class EntrySecureCacheResponse extends SecureCacheResponse {
        private final Entry entry;
        private final InputStream in;
        private final DiskLruCache.Snapshot snapshot;

        public EntrySecureCacheResponse(Entry entry, DiskLruCache.Snapshot snapshot) {
            this.entry = entry;
            this.snapshot = snapshot;
            this.in = HttpResponseCache.newBodyInputStream(snapshot);
        }

        @Override // java.net.CacheResponse
        public InputStream getBody() {
            return this.in;
        }

        @Override // java.net.SecureCacheResponse
        public String getCipherSuite() {
            return this.entry.cipherSuite;
        }

        @Override // java.net.CacheResponse
        public Map<String, List<String>> getHeaders() {
            return this.entry.responseHeaders.toMultimap(true);
        }

        @Override // java.net.SecureCacheResponse
        public List<Certificate> getLocalCertificateChain() {
            if (this.entry.localCertificates == null || this.entry.localCertificates.length == 0) {
                return null;
            }
            return Arrays.asList((Certificate[]) this.entry.localCertificates.clone());
        }

        @Override // java.net.SecureCacheResponse
        public Principal getLocalPrincipal() {
            if (this.entry.localCertificates == null || this.entry.localCertificates.length == 0) {
                return null;
            }
            return ((X509Certificate) this.entry.localCertificates[0]).getSubjectX500Principal();
        }

        @Override // java.net.SecureCacheResponse
        public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
            if (this.entry.peerCertificates == null || this.entry.peerCertificates.length == 0) {
                throw new SSLPeerUnverifiedException(null);
            }
            return ((X509Certificate) this.entry.peerCertificates[0]).getSubjectX500Principal();
        }

        @Override // java.net.SecureCacheResponse
        public List<Certificate> getServerCertificateChain() throws SSLPeerUnverifiedException {
            if (this.entry.peerCertificates == null || this.entry.peerCertificates.length == 0) {
                throw new SSLPeerUnverifiedException(null);
            }
            return Arrays.asList((Certificate[]) this.entry.peerCertificates.clone());
        }
    }

    public HttpResponseCache(File file, long j) throws IOException {
        this.cache = DiskLruCache.open(file, VERSION, 2, j);
    }

    private void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    private HttpEngine getHttpEngine(URLConnection uRLConnection) {
        if (uRLConnection instanceof HttpURLConnectionImpl) {
            return ((HttpURLConnectionImpl) uRLConnection).getHttpEngine();
        }
        if (uRLConnection instanceof HttpsURLConnectionImpl) {
            return ((HttpsURLConnectionImpl) uRLConnection).getHttpEngine();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean maybeRemove(String str, URI uri) {
        if (!str.equals("POST") && !str.equals("PUT") && !str.equals(HttpManager.HTTP_DELETE)) {
            return false;
        }
        try {
            this.cache.remove(uriToKey(uri));
            return true;
        } catch (IOException unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputStream newBodyInputStream(final DiskLruCache.Snapshot snapshot) {
        return new FilterInputStream(snapshot.getInputStream(1)) { // from class: com.squareup.okhttp.HttpResponseCache.2
            @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                snapshot.close();
                super.close();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void trackConditionalCacheHit() {
        this.hitCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void trackResponse(ResponseSource responseSource) {
        this.requestCount++;
        int i = AnonymousClass3.$SwitchMap$com$squareup$okhttp$ResponseSource[responseSource.ordinal()];
        if (i == 1) {
            this.hitCount++;
        } else if (i == 2 || i == 3) {
            this.networkCount++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update(CacheResponse cacheResponse, HttpURLConnection httpURLConnection) throws IOException {
        DiskLruCache.Editor editorEdit;
        HttpEngine httpEngine = getHttpEngine(httpURLConnection);
        Entry entry = new Entry(httpEngine.getUri(), httpEngine.getRequestHeaders().getHeaders().getAll(httpEngine.getResponseHeaders().getVaryFields()), httpURLConnection);
        try {
            editorEdit = (cacheResponse instanceof EntryCacheResponse ? ((EntryCacheResponse) cacheResponse).snapshot : ((EntrySecureCacheResponse) cacheResponse).snapshot).edit();
            if (editorEdit != null) {
                try {
                    entry.writeTo(editorEdit);
                    editorEdit.commit();
                } catch (IOException unused) {
                    abortQuietly(editorEdit);
                }
            }
        } catch (IOException unused2) {
            editorEdit = null;
        }
    }

    private String uriToKey(URI uri) {
        return Util.hash(uri.toString());
    }

    public void close() throws IOException {
        this.cache.close();
    }

    public void delete() throws IOException {
        this.cache.delete();
    }

    public void flush() throws IOException {
        this.cache.flush();
    }

    @Override // java.net.ResponseCache
    public CacheResponse get(URI uri, String str, Map<String, List<String>> map) {
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(uriToKey(uri));
            if (snapshot == null) {
                return null;
            }
            Entry entry = new Entry(snapshot.getInputStream(0));
            if (entry.matches(uri, str, map)) {
                return entry.isHttps() ? new EntrySecureCacheResponse(entry, snapshot) : new EntryCacheResponse(entry, snapshot);
            }
            snapshot.close();
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    public File getDirectory() {
        return this.cache.getDirectory();
    }

    public synchronized int getHitCount() {
        return this.hitCount;
    }

    public long getMaxSize() {
        return this.cache.getMaxSize();
    }

    public synchronized int getNetworkCount() {
        return this.networkCount;
    }

    public synchronized int getRequestCount() {
        return this.requestCount;
    }

    public long getSize() {
        return this.cache.size();
    }

    public synchronized int getWriteAbortCount() {
        return this.writeAbortCount;
    }

    public synchronized int getWriteSuccessCount() {
        return this.writeSuccessCount;
    }

    public boolean isClosed() {
        return this.cache.isClosed();
    }

    @Override // java.net.ResponseCache
    public CacheRequest put(URI uri, URLConnection uRLConnection) throws IOException {
        HttpEngine httpEngine;
        DiskLruCache.Editor editorEdit;
        if (!(uRLConnection instanceof HttpURLConnection)) {
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
        String requestMethod = httpURLConnection.getRequestMethod();
        if (maybeRemove(requestMethod, uri) || !requestMethod.equals("GET") || (httpEngine = getHttpEngine(httpURLConnection)) == null) {
            return null;
        }
        ResponseHeaders responseHeaders = httpEngine.getResponseHeaders();
        if (responseHeaders.hasVaryAll()) {
            return null;
        }
        Entry entry = new Entry(uri, httpEngine.getRequestHeaders().getHeaders().getAll(responseHeaders.getVaryFields()), httpURLConnection);
        try {
            editorEdit = this.cache.edit(uriToKey(uri));
            if (editorEdit == null) {
                return null;
            }
            try {
                entry.writeTo(editorEdit);
                return new CacheRequestImpl(editorEdit);
            } catch (IOException unused) {
                abortQuietly(editorEdit);
                return null;
            }
        } catch (IOException unused2) {
            editorEdit = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class Entry {
        private final String cipherSuite;
        private final Certificate[] localCertificates;
        private final Certificate[] peerCertificates;
        private final String requestMethod;
        private final RawHeaders responseHeaders;
        private final String uri;
        private final RawHeaders varyHeaders;

        public Entry(InputStream inputStream) throws IOException {
            try {
                StrictLineReader strictLineReader = new StrictLineReader(inputStream, Util.US_ASCII);
                this.uri = strictLineReader.readLine();
                this.requestMethod = strictLineReader.readLine();
                this.varyHeaders = new RawHeaders();
                int i = strictLineReader.readInt();
                for (int i2 = 0; i2 < i; i2++) {
                    this.varyHeaders.addLine(strictLineReader.readLine());
                }
                RawHeaders rawHeaders = new RawHeaders();
                this.responseHeaders = rawHeaders;
                rawHeaders.setStatusLine(strictLineReader.readLine());
                int i3 = strictLineReader.readInt();
                for (int i4 = 0; i4 < i3; i4++) {
                    this.responseHeaders.addLine(strictLineReader.readLine());
                }
                if (isHttps()) {
                    String line = strictLineReader.readLine();
                    if (line.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + line + "\"");
                    }
                    this.cipherSuite = strictLineReader.readLine();
                    this.peerCertificates = readCertArray(strictLineReader);
                    this.localCertificates = readCertArray(strictLineReader);
                } else {
                    this.cipherSuite = null;
                    this.peerCertificates = null;
                    this.localCertificates = null;
                }
            } finally {
                inputStream.close();
            }
        }

        private SSLSocket getSslSocket(HttpURLConnection httpURLConnection) {
            HttpEngine httpEngine = httpURLConnection instanceof HttpsURLConnectionImpl ? ((HttpsURLConnectionImpl) httpURLConnection).getHttpEngine() : ((HttpURLConnectionImpl) httpURLConnection).getHttpEngine();
            if (httpEngine instanceof HttpsEngine) {
                return ((HttpsEngine) httpEngine).getSslSocket();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isHttps() {
            return this.uri.startsWith("https://");
        }

        private Certificate[] readCertArray(StrictLineReader strictLineReader) throws IOException {
            int i = strictLineReader.readInt();
            if (i == -1) {
                return null;
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                Certificate[] certificateArr = new Certificate[i];
                for (int i2 = 0; i2 < i; i2++) {
                    certificateArr[i2] = certificateFactory.generateCertificate(new ByteArrayInputStream(Base64.decode(strictLineReader.readLine().getBytes("US-ASCII"))));
                }
                return certificateArr;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private void writeCertArray(Writer writer, Certificate[] certificateArr) throws IOException {
            if (certificateArr == null) {
                writer.write("-1\n");
                return;
            }
            try {
                writer.write(Integer.toString(certificateArr.length) + '\n');
                for (Certificate certificate : certificateArr) {
                    writer.write(Base64.encode(certificate.getEncoded()) + '\n');
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public boolean matches(URI uri, String str, Map<String, List<String>> map) {
            return this.uri.equals(uri.toString()) && this.requestMethod.equals(str) && new ResponseHeaders(uri, this.responseHeaders).varyMatches(this.varyHeaders.toMultimap(false), map);
        }

        public void writeTo(DiskLruCache.Editor editor) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(editor.newOutputStream(0), Util.UTF_8));
            bufferedWriter.write(this.uri + '\n');
            bufferedWriter.write(this.requestMethod + '\n');
            bufferedWriter.write(Integer.toString(this.varyHeaders.length()) + '\n');
            for (int i = 0; i < this.varyHeaders.length(); i++) {
                bufferedWriter.write(this.varyHeaders.getFieldName(i) + ": " + this.varyHeaders.getValue(i) + '\n');
            }
            bufferedWriter.write(this.responseHeaders.getStatusLine() + '\n');
            bufferedWriter.write(Integer.toString(this.responseHeaders.length()) + '\n');
            for (int i2 = 0; i2 < this.responseHeaders.length(); i2++) {
                bufferedWriter.write(this.responseHeaders.getFieldName(i2) + ": " + this.responseHeaders.getValue(i2) + '\n');
            }
            if (isHttps()) {
                bufferedWriter.write(10);
                bufferedWriter.write(this.cipherSuite + '\n');
                writeCertArray(bufferedWriter, this.peerCertificates);
                writeCertArray(bufferedWriter, this.localCertificates);
            }
            bufferedWriter.close();
        }

        public Entry(URI uri, RawHeaders rawHeaders, HttpURLConnection httpURLConnection) throws IOException {
            this.uri = uri.toString();
            this.varyHeaders = rawHeaders;
            this.requestMethod = httpURLConnection.getRequestMethod();
            this.responseHeaders = RawHeaders.fromMultimap(httpURLConnection.getHeaderFields(), true);
            SSLSocket sslSocket = getSslSocket(httpURLConnection);
            Certificate[] peerCertificates = null;
            if (sslSocket != null) {
                this.cipherSuite = sslSocket.getSession().getCipherSuite();
                try {
                    peerCertificates = sslSocket.getSession().getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                }
                this.peerCertificates = peerCertificates;
                this.localCertificates = sslSocket.getSession().getLocalCertificates();
                return;
            }
            this.cipherSuite = null;
            this.peerCertificates = null;
            this.localCertificates = null;
        }
    }
}
