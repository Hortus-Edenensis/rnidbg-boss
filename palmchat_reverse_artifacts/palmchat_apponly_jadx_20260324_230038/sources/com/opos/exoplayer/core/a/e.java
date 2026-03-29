package com.opos.exoplayer.core.a;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.Format;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface e {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final Handler f8091a;

        @Nullable
        private final e b;

        /* JADX INFO: renamed from: com.opos.exoplayer.core.a.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC0679a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.opos.exoplayer.core.decoder.d f8092a;

            public RunnableC0679a(com.opos.exoplayer.core.decoder.d dVar) {
                this.f8092a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.c(this.f8092a);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f8093a;
            final /* synthetic */ long b;
            final /* synthetic */ long c;

            public b(String str, long j, long j2) {
                this.f8093a = str;
                this.b = j;
                this.c = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.b(this.f8093a, this.b, this.c);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Format f8094a;

            public c(Format format) {
                this.f8094a = format;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.b(this.f8094a);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f8095a;
            final /* synthetic */ long b;
            final /* synthetic */ long c;

            public d(int i, long j, long j2) {
                this.f8095a = i;
                this.b = j;
                this.c = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f8095a, this.b, this.c);
            }
        }

        /* JADX INFO: renamed from: com.opos.exoplayer.core.a.e$a$e, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC0680e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.opos.exoplayer.core.decoder.d f8096a;

            public RunnableC0680e(com.opos.exoplayer.core.decoder.d dVar) {
                this.f8096a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f8096a.a();
                a.this.b.d(this.f8096a);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f8097a;

            public f(int i) {
                this.f8097a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f8097a);
            }
        }

        public a(@Nullable Handler handler, @Nullable e eVar) {
            this.f8091a = eVar != null ? (Handler) com.opos.exoplayer.core.util.a.a(handler) : null;
            this.b = eVar;
        }

        public void b(com.opos.exoplayer.core.decoder.d dVar) {
            if (this.b != null) {
                this.f8091a.post(new RunnableC0680e(dVar));
            }
        }

        public void a(int i) {
            if (this.b != null) {
                this.f8091a.post(new f(i));
            }
        }

        public void a(int i, long j, long j2) {
            if (this.b != null) {
                this.f8091a.post(new d(i, j, j2));
            }
        }

        public void a(Format format) {
            if (this.b != null) {
                this.f8091a.post(new c(format));
            }
        }

        public void a(com.opos.exoplayer.core.decoder.d dVar) {
            if (this.b != null) {
                this.f8091a.post(new RunnableC0679a(dVar));
            }
        }

        public void a(String str, long j, long j2) {
            if (this.b != null) {
                this.f8091a.post(new b(str, j, j2));
            }
        }
    }

    void a(int i);

    void a(int i, long j, long j2);

    void b(Format format);

    void b(String str, long j, long j2);

    void c(com.opos.exoplayer.core.decoder.d dVar);

    void d(com.opos.exoplayer.core.decoder.d dVar);
}
