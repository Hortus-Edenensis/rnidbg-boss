package com.opos.exoplayer.core.upstream;

import android.text.TextUtils;
import com.opos.exoplayer.core.upstream.g;
import com.opos.exoplayer.core.util.y;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface HttpDataSource extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.opos.exoplayer.core.util.r<String> f8367a = new f();

    /* JADX INFO: compiled from: SearchBox */
    public static class HttpDataSourceException extends com.opos.exoplayer.core.util.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8368a;
        public final DataSpec b;

        /* JADX INFO: compiled from: SearchBox */
        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }

        public HttpDataSourceException(IOException iOException, DataSpec dataSpec, int i) {
            super(iOException);
            this.b = dataSpec;
            this.f8368a = i;
        }

        @Override // com.opos.exoplayer.core.util.c
        public String a() {
            return "HttpDataSourceException";
        }

        public HttpDataSourceException(String str, DataSpec dataSpec, int i) {
            super(str);
            this.b = dataSpec;
            this.f8368a = i;
        }

        public HttpDataSourceException(String str, IOException iOException, DataSpec dataSpec, int i) {
            super(str, iOException);
            this.b = dataSpec;
            this.f8368a = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f8369a = new e();

        @Override // com.opos.exoplayer.core.upstream.g.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HttpDataSource a() {
            return b(this.f8369a);
        }

        public abstract HttpDataSource b(e eVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b extends g.a {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c extends HttpDataSourceException {
        public final String c;

        public c(String str, DataSpec dataSpec) {
            super("Invalid content type: " + str, dataSpec, 1);
            this.c = str;
        }

        @Override // com.opos.exoplayer.core.upstream.HttpDataSource.HttpDataSourceException, com.opos.exoplayer.core.util.c
        public String a() {
            return "InvalidContentTypeException";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d extends HttpDataSourceException {
        public final int c;
        public final Map<String, List<String>> d;

        public d(int i, Map<String, List<String>> map, DataSpec dataSpec) {
            super("Response code: " + i, dataSpec, 1);
            this.c = i;
            this.d = map;
        }

        @Override // com.opos.exoplayer.core.upstream.HttpDataSource.HttpDataSourceException, com.opos.exoplayer.core.util.c
        public String a() {
            return "InvalidResponseCodeException";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, String> f8370a = new HashMap();
        private Map<String, String> b;

        public synchronized Map<String, String> a() {
            if (this.b == null) {
                this.b = Collections.unmodifiableMap(new HashMap(this.f8370a));
            }
            return this.b;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f implements com.opos.exoplayer.core.util.r<String> {
        @Override // com.opos.exoplayer.core.util.r
        public boolean a(String str) {
            String strD = y.d(str);
            return (TextUtils.isEmpty(strD) || (strD.contains("text") && !strD.contains("text/vtt")) || strD.contains("html") || strD.contains("xml")) ? false : true;
        }
    }
}
