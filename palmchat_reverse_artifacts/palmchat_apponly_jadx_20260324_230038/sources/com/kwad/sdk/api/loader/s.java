package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.api.loader.a;
import com.kwad.sdk.api.loader.h;
import j$.util.Objects;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class s {

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a<T> implements c<T> {
        c<T> ayQ;

        public a(c<T> cVar) {
            this.ayQ = cVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements f<a.C0594a> {
        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<a.C0594a> cVar) {
            try {
                new com.kwad.sdk.api.loader.h(abVar).a(new h.a() { // from class: com.kwad.sdk.api.loader.s.b.1
                    @Override // com.kwad.sdk.api.loader.h.a
                    @WorkerThread
                    public final void a(a.b bVar) {
                        Objects.toString(bVar);
                        if (bVar.isLegal()) {
                            cVar.k(bVar.axR);
                        } else {
                            new RuntimeException("UpdateData is illegal");
                        }
                        try {
                            com.kwad.sdk.api.loader.f.bf(abVar.getContext()).cancel();
                        } catch (Throwable unused) {
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c<T> {
        void k(T t);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d implements f<a.C0594a> {
        f<a.C0594a> ayU;

        public d(f<a.C0594a> fVar) {
            this.ayU = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<a.C0594a> cVar) {
            this.ayU.a(abVar, new a<a.C0594a>(cVar) { // from class: com.kwad.sdk.api.loader.s.d.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                @WorkerThread
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void k(@NonNull a.C0594a c0594a) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    File fileU = null;
                    try {
                        l.a(c0594a);
                        fileU = j.u(abVar.getContext(), c0594a.sdkVersion);
                        k.c(c0594a.axP, fileU);
                        l.a(c0594a, System.currentTimeMillis() - jCurrentTimeMillis);
                        c0594a.axQ = fileU;
                        cVar.k(c0594a);
                    } catch (Throwable th) {
                        l.a(c0594a, System.currentTimeMillis() - jCurrentTimeMillis, Log.getStackTraceString(th));
                        j.j(fileU);
                    }
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e implements f<Boolean> {
        f<a.C0594a> ayU;

        public e(f<a.C0594a> fVar) {
            this.ayU = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<Boolean> cVar) {
            this.ayU.a(abVar, new c<a.C0594a>() { // from class: com.kwad.sdk.api.loader.s.e.1
                private void a(a.C0594a c0594a, int i, Throwable th) {
                    j.j(c0594a.axQ);
                    l.b(c0594a, i, Log.getStackTraceString(th));
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void k(@NonNull a.C0594a c0594a) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        l.b(c0594a);
                        if (!com.kwad.sdk.api.loader.d.a(abVar.getContext(), AnonymousClass1.class.getClassLoader(), c0594a.axQ.getPath(), c0594a.sdkVersion)) {
                            a(c0594a, 1, new RuntimeException("Apk pre install fail"));
                            return;
                        }
                        i.s(abVar.getContext(), c0594a.sdkVersion);
                        j.j(c0594a.axQ);
                        l.b(c0594a, System.currentTimeMillis() - jCurrentTimeMillis);
                        cVar.k(Boolean.TRUE);
                    } catch (Throwable th) {
                        a(c0594a, 2, th);
                    }
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f<T> {
        void a(ab abVar, c<T> cVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g implements f<a.C0594a> {
        f<a.C0594a> ayU;

        public g(f<a.C0594a> fVar) {
            this.ayU = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(ab abVar, final c<a.C0594a> cVar) {
            this.ayU.a(abVar, new a<a.C0594a>(cVar) { // from class: com.kwad.sdk.api.loader.s.g.1
                private void a(a.C0594a c0594a, int i, Throwable th) {
                    j.j(c0594a.axQ);
                    l.a(c0594a, i, th.getMessage());
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void k(@NonNull a.C0594a c0594a) {
                    try {
                        File file = c0594a.axQ;
                        if (!x.k(file)) {
                            a(c0594a, 1, new RuntimeException("Security checkFileValid fail"));
                        } else if (x.a(file, c0594a.md5)) {
                            cVar.k(c0594a);
                        } else {
                            a(c0594a, 2, new RuntimeException("Security checkMd5 fail"));
                        }
                    } catch (Throwable th) {
                        a(c0594a, 3, th);
                    }
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class h implements f<a.C0594a> {
        f<a.C0594a> ayU;

        public h(f<a.C0594a> fVar) {
            this.ayU = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<a.C0594a> cVar) {
            this.ayU.a(abVar, new c<a.C0594a>() { // from class: com.kwad.sdk.api.loader.s.h.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void k(a.C0594a c0594a) {
                    String strBg = i.bg(abVar.getContext());
                    if (TextUtils.isEmpty(strBg)) {
                        strBg = com.kwad.sdk.api.c.EP().getSDKVersion();
                    }
                    String str = c0594a.sdkVersion;
                    com.kwad.sdk.api.loader.b.a(abVar.getContext(), "interval", c0594a.interval);
                    com.kwad.sdk.api.loader.b.a(abVar.getContext(), "lastUpdateTime", System.currentTimeMillis());
                    if (c0594a.EV()) {
                        aa.bn(abVar.getContext());
                        new RuntimeException("DynamicType == -1, curVersion: " + strBg);
                        return;
                    }
                    if (i.L(c0594a.sdkVersion, strBg) && c0594a.EU()) {
                        cVar.k(c0594a);
                        return;
                    }
                    new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0594a.sdkVersion + " currentDynamicVersion:" + strBg + " dynamicType:" + c0594a.axO);
                }
            });
        }
    }

    public static f<Boolean> Fe() {
        return new e(new g(new d(new h(new b()))));
    }
}
