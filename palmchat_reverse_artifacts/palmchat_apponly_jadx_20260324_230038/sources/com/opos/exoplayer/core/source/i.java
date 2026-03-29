package com.opos.exoplayer.core.source;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.C;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.upstream.DataSpec;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface i {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final Handler f8293a;

        @Nullable
        private final i b;
        private final long c;

        /* JADX INFO: renamed from: com.opos.exoplayer.core.source.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC0697a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DataSpec f8294a;
            final /* synthetic */ int b;
            final /* synthetic */ int c;
            final /* synthetic */ Format d;
            final /* synthetic */ int e;
            final /* synthetic */ Object f;
            final /* synthetic */ long g;
            final /* synthetic */ long h;
            final /* synthetic */ long i;

            public RunnableC0697a(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3) {
                this.f8294a = dataSpec;
                this.b = i;
                this.c = i2;
                this.d = format;
                this.e = i3;
                this.f = obj;
                this.g = j;
                this.h = j2;
                this.i = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f8294a, this.b, this.c, this.d, this.e, this.f, a.this.a(this.g), a.this.a(this.h), this.i);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DataSpec f8295a;
            final /* synthetic */ int b;
            final /* synthetic */ int c;
            final /* synthetic */ Format d;
            final /* synthetic */ int e;
            final /* synthetic */ Object f;
            final /* synthetic */ long g;
            final /* synthetic */ long h;
            final /* synthetic */ long i;
            final /* synthetic */ long j;
            final /* synthetic */ long k;

            public b(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
                this.f8295a = dataSpec;
                this.b = i;
                this.c = i2;
                this.d = format;
                this.e = i3;
                this.f = obj;
                this.g = j;
                this.h = j2;
                this.i = j3;
                this.j = j4;
                this.k = j5;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f8295a, this.b, this.c, this.d, this.e, this.f, a.this.a(this.g), a.this.a(this.h), this.i, this.j, this.k);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DataSpec f8296a;
            final /* synthetic */ int b;
            final /* synthetic */ int c;
            final /* synthetic */ Format d;
            final /* synthetic */ int e;
            final /* synthetic */ Object f;
            final /* synthetic */ long g;
            final /* synthetic */ long h;
            final /* synthetic */ long i;
            final /* synthetic */ long j;
            final /* synthetic */ long k;

            public c(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
                this.f8296a = dataSpec;
                this.b = i;
                this.c = i2;
                this.d = format;
                this.e = i3;
                this.f = obj;
                this.g = j;
                this.h = j2;
                this.i = j3;
                this.j = j4;
                this.k = j5;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.b(this.f8296a, this.b, this.c, this.d, this.e, this.f, a.this.a(this.g), a.this.a(this.h), this.i, this.j, this.k);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DataSpec f8297a;
            final /* synthetic */ int b;
            final /* synthetic */ int c;
            final /* synthetic */ Format d;
            final /* synthetic */ int e;
            final /* synthetic */ Object f;
            final /* synthetic */ long g;
            final /* synthetic */ long h;
            final /* synthetic */ long i;
            final /* synthetic */ long j;
            final /* synthetic */ long k;
            final /* synthetic */ IOException l;
            final /* synthetic */ boolean m;

            public d(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
                this.f8297a = dataSpec;
                this.b = i;
                this.c = i2;
                this.d = format;
                this.e = i3;
                this.f = obj;
                this.g = j;
                this.h = j2;
                this.i = j3;
                this.j = j4;
                this.k = j5;
                this.l = iOException;
                this.m = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f8297a, this.b, this.c, this.d, this.e, this.f, a.this.a(this.g), a.this.a(this.h), this.i, this.j, this.k, this.l, this.m);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f8298a;
            final /* synthetic */ Format b;
            final /* synthetic */ int c;
            final /* synthetic */ Object d;
            final /* synthetic */ long e;

            public e(int i, Format format, int i2, Object obj, long j) {
                this.f8298a = i;
                this.b = format;
                this.c = i2;
                this.d = obj;
                this.e = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f8298a, this.b, this.c, this.d, a.this.a(this.e));
            }
        }

        public a(@Nullable Handler handler, @Nullable i iVar) {
            this(handler, iVar, 0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long a(long j) {
            long jA = C.a(j);
            if (jA == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.c + jA;
        }

        public void b(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            Handler handler;
            if (this.b == null || (handler = this.f8293a) == null) {
                return;
            }
            handler.post(new c(dataSpec, i, i2, format, i3, obj, j, j2, j3, j4, j5));
        }

        public a(@Nullable Handler handler, @Nullable i iVar, long j) {
            this.f8293a = iVar != null ? (Handler) com.opos.exoplayer.core.util.a.a(handler) : null;
            this.b = iVar;
            this.c = j;
        }

        public void a(int i, Format format, int i2, Object obj, long j) {
            Handler handler;
            if (this.b == null || (handler = this.f8293a) == null) {
                return;
            }
            handler.post(new e(i, format, i2, obj, j));
        }

        public void a(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3) {
            Handler handler;
            if (this.b == null || (handler = this.f8293a) == null) {
                return;
            }
            handler.post(new RunnableC0697a(dataSpec, i, i2, format, i3, obj, j, j2, j3));
        }

        public void a(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            Handler handler;
            if (this.b == null || (handler = this.f8293a) == null) {
                return;
            }
            handler.post(new b(dataSpec, i, i2, format, i3, obj, j, j2, j3, j4, j5));
        }

        public void a(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
            Handler handler;
            if (this.b == null || (handler = this.f8293a) == null) {
                return;
            }
            handler.post(new d(dataSpec, i, i2, format, i3, obj, j, j2, j3, j4, j5, iOException, z));
        }
    }

    void a(int i, Format format, int i2, Object obj, long j);

    void a(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3);

    void a(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5);

    void a(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z);

    void b(DataSpec dataSpec, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5);
}
