package com.opos.exoplayer.core.video;

import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.Format;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface f {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final Handler f8421a;

        @Nullable
        private final f b;

        /* JADX INFO: renamed from: com.opos.exoplayer.core.video.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC0707a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.opos.exoplayer.core.decoder.d f8422a;

            public RunnableC0707a(com.opos.exoplayer.core.decoder.d dVar) {
                this.f8422a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f8422a);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f8423a;
            final /* synthetic */ long b;
            final /* synthetic */ long c;

            public b(String str, long j, long j2) {
                this.f8423a = str;
                this.b = j;
                this.c = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f8423a, this.b, this.c);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Format f8424a;

            public c(Format format) {
                this.f8424a = format;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f8424a);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f8425a;
            final /* synthetic */ long b;

            public d(int i, long j) {
                this.f8425a = i;
                this.b = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f8425a, this.b);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f8426a;
            final /* synthetic */ int b;
            final /* synthetic */ int c;
            final /* synthetic */ float d;

            public e(int i, int i2, int i3, float f) {
                this.f8426a = i;
                this.b = i2;
                this.c = i3;
                this.d = f;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f8426a, this.b, this.c, this.d);
            }
        }

        /* JADX INFO: renamed from: com.opos.exoplayer.core.video.f$a$f, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC0708f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Surface f8427a;

            public RunnableC0708f(Surface surface) {
                this.f8427a = surface;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f8427a);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class g implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.opos.exoplayer.core.decoder.d f8428a;

            public g(com.opos.exoplayer.core.decoder.d dVar) {
                this.f8428a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f8428a.a();
                a.this.b.b(this.f8428a);
            }
        }

        public a(@Nullable Handler handler, @Nullable f fVar) {
            this.f8421a = fVar != null ? (Handler) com.opos.exoplayer.core.util.a.a(handler) : null;
            this.b = fVar;
        }

        public void b(com.opos.exoplayer.core.decoder.d dVar) {
            if (this.b != null) {
                this.f8421a.post(new g(dVar));
            }
        }

        public void a(int i, int i2, int i3, float f) {
            if (this.b != null) {
                this.f8421a.post(new e(i, i2, i3, f));
            }
        }

        public void a(int i, long j) {
            if (this.b != null) {
                this.f8421a.post(new d(i, j));
            }
        }

        public void a(Surface surface) {
            if (this.b != null) {
                this.f8421a.post(new RunnableC0708f(surface));
            }
        }

        public void a(Format format) {
            if (this.b != null) {
                this.f8421a.post(new c(format));
            }
        }

        public void a(com.opos.exoplayer.core.decoder.d dVar) {
            if (this.b != null) {
                this.f8421a.post(new RunnableC0707a(dVar));
            }
        }

        public void a(String str, long j, long j2) {
            if (this.b != null) {
                this.f8421a.post(new b(str, j, j2));
            }
        }
    }

    void a(int i, int i2, int i3, float f);

    void a(int i, long j);

    void a(Surface surface);

    void a(Format format);

    void a(com.opos.exoplayer.core.decoder.d dVar);

    void a(String str, long j, long j2);

    void b(com.opos.exoplayer.core.decoder.d dVar);
}
