package com.google.android.exoplayer2.source;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.d;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.c;
import com.google.common.collect.ImmutableList;
import defpackage.c06;
import defpackage.fn5;
import defpackage.g86;
import defpackage.hi1;
import defpackage.hn5;
import defpackage.j51;
import defpackage.od0;
import defpackage.os1;
import defpackage.ps1;
import defpackage.qo5;
import defpackage.qs1;
import defpackage.v45;
import defpackage.vh;
import defpackage.vk4;
import defpackage.y53;
import defpackage.ys1;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class d implements i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f5937a;
    public a.InterfaceC0360a b;

    @Nullable
    public i.a c;

    @Nullable
    public com.google.android.exoplayer2.upstream.f d;
    public long e;
    public long f;
    public long g;
    public float h;
    public float i;
    public boolean j;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ys1 f5938a;
        public final Map<Integer, qo5<i.a>> b = new HashMap();
        public final Set<Integer> c = new HashSet();
        public final Map<Integer, i.a> d = new HashMap();
        public a.InterfaceC0360a e;

        @Nullable
        public od0.a f;

        @Nullable
        public hi1 g;

        @Nullable
        public com.google.android.exoplayer2.upstream.f h;

        public a(ys1 ys1Var) {
            this.f5938a = ys1Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ i.a k(a.InterfaceC0360a interfaceC0360a) {
            return new n.b(interfaceC0360a, this.f5938a);
        }

        @Nullable
        public i.a f(int i) {
            i.a aVar = this.d.get(Integer.valueOf(i));
            if (aVar != null) {
                return aVar;
            }
            qo5<i.a> qo5VarL = l(i);
            if (qo5VarL == null) {
                return null;
            }
            i.a aVar2 = qo5VarL.get2();
            od0.a aVar3 = this.f;
            if (aVar3 != null) {
                aVar2.a(aVar3);
            }
            hi1 hi1Var = this.g;
            if (hi1Var != null) {
                aVar2.d(hi1Var);
            }
            com.google.android.exoplayer2.upstream.f fVar = this.h;
            if (fVar != null) {
                aVar2.b(fVar);
            }
            this.d.put(Integer.valueOf(i), aVar2);
            return aVar2;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x007f  */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final qo5<i.a> l(int i) {
            qo5<i.a> qo5Var;
            qo5<i.a> qo5Var2;
            if (this.b.containsKey(Integer.valueOf(i))) {
                return this.b.get(Integer.valueOf(i));
            }
            final a.InterfaceC0360a interfaceC0360a = (a.InterfaceC0360a) vh.e(this.e);
            qo5<i.a> qo5Var3 = null;
            if (i == 0) {
                final Class clsAsSubclass = DashMediaSource.Factory.class.asSubclass(i.a.class);
                qo5Var = new qo5() { // from class: j61
                    @Override // defpackage.qo5
                    /* JADX INFO: renamed from: get */
                    public final Object get2() {
                        return d.g(clsAsSubclass, interfaceC0360a);
                    }
                };
            } else if (i == 1) {
                final Class<? extends U> clsAsSubclass2 = Class.forName("com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory").asSubclass(i.a.class);
                qo5Var = new qo5() { // from class: k61
                    @Override // defpackage.qo5
                    /* JADX INFO: renamed from: get */
                    public final Object get2() {
                        return d.g(clsAsSubclass2, interfaceC0360a);
                    }
                };
            } else {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            qo5Var2 = new qo5() { // from class: n61
                                @Override // defpackage.qo5
                                /* JADX INFO: renamed from: get */
                                public final Object get2() {
                                    return this.f19445a.k(interfaceC0360a);
                                }
                            };
                        }
                        this.b.put(Integer.valueOf(i), qo5Var3);
                        if (qo5Var3 != null) {
                            this.c.add(Integer.valueOf(i));
                        }
                        return qo5Var3;
                    }
                    final Class<? extends U> clsAsSubclass3 = Class.forName("com.google.android.exoplayer2.source.rtsp.RtspMediaSource$Factory").asSubclass(i.a.class);
                    qo5Var2 = new qo5() { // from class: m61
                        @Override // defpackage.qo5
                        /* JADX INFO: renamed from: get */
                        public final Object get2() {
                            return d.f(clsAsSubclass3);
                        }
                    };
                    qo5Var3 = qo5Var2;
                    this.b.put(Integer.valueOf(i), qo5Var3);
                    if (qo5Var3 != null) {
                    }
                    return qo5Var3;
                }
                final Class clsAsSubclass4 = HlsMediaSource.Factory.class.asSubclass(i.a.class);
                qo5Var = new qo5() { // from class: l61
                    @Override // defpackage.qo5
                    /* JADX INFO: renamed from: get */
                    public final Object get2() {
                        return d.g(clsAsSubclass4, interfaceC0360a);
                    }
                };
            }
            qo5Var3 = qo5Var;
            this.b.put(Integer.valueOf(i), qo5Var3);
            if (qo5Var3 != null) {
            }
            return qo5Var3;
        }

        public void m(od0.a aVar) {
            this.f = aVar;
            Iterator<i.a> it = this.d.values().iterator();
            while (it.hasNext()) {
                it.next().a(aVar);
            }
        }

        public void n(a.InterfaceC0360a interfaceC0360a) {
            if (interfaceC0360a != this.e) {
                this.e = interfaceC0360a;
                this.b.clear();
                this.d.clear();
            }
        }

        public void o(hi1 hi1Var) {
            this.g = hi1Var;
            Iterator<i.a> it = this.d.values().iterator();
            while (it.hasNext()) {
                it.next().d(hi1Var);
            }
        }

        public void p(com.google.android.exoplayer2.upstream.f fVar) {
            this.h = fVar;
            Iterator<i.a> it = this.d.values().iterator();
            while (it.hasNext()) {
                it.next().b(fVar);
            }
        }
    }

    public d(Context context) {
        this(new c.a(context));
    }

    public static /* synthetic */ i.a f(Class cls) {
        return k(cls);
    }

    public static /* synthetic */ i.a g(Class cls, a.InterfaceC0360a interfaceC0360a) {
        return l(cls, interfaceC0360a);
    }

    public static /* synthetic */ os1[] h(com.google.android.exoplayer2.m mVar) {
        os1[] os1VarArr = new os1[1];
        fn5 fn5Var = fn5.f17566a;
        os1VarArr[0] = fn5Var.a(mVar) ? new hn5(fn5Var.b(mVar), mVar) : new b(mVar);
        return os1VarArr;
    }

    public static i i(com.google.android.exoplayer2.p pVar, i iVar) {
        p.d dVar = pVar.f;
        if (dVar.f5914a == 0 && dVar.b == Long.MIN_VALUE && !dVar.d) {
            return iVar;
        }
        long jH0 = g86.H0(pVar.f.f5914a);
        long jH02 = g86.H0(pVar.f.b);
        p.d dVar2 = pVar.f;
        return new ClippingMediaSource(iVar, jH0, jH02, !dVar2.e, dVar2.c, dVar2.d);
    }

    public static i.a k(Class<? extends i.a> cls) {
        try {
            return cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static i.a l(Class<? extends i.a> cls, a.InterfaceC0360a interfaceC0360a) {
        try {
            return cls.getConstructor(a.InterfaceC0360a.class).newInstance(interfaceC0360a);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.android.exoplayer2.source.i.a
    public i c(com.google.android.exoplayer2.p pVar) {
        vh.e(pVar.b);
        String scheme = pVar.b.f5920a.getScheme();
        if (scheme != null && scheme.equals(C.SSAI_SCHEME)) {
            return ((i.a) vh.e(this.c)).c(pVar);
        }
        p.h hVar = pVar.b;
        int iU0 = g86.u0(hVar.f5920a, hVar.b);
        i.a aVarF = this.f5937a.f(iU0);
        vh.j(aVarF, "No suitable media source factory found for content type: " + iU0);
        p.g.a aVarB = pVar.d.b();
        if (pVar.d.f5918a == -9223372036854775807L) {
            aVarB.k(this.e);
        }
        if (pVar.d.d == -3.4028235E38f) {
            aVarB.j(this.h);
        }
        if (pVar.d.e == -3.4028235E38f) {
            aVarB.h(this.i);
        }
        if (pVar.d.b == -9223372036854775807L) {
            aVarB.i(this.f);
        }
        if (pVar.d.c == -9223372036854775807L) {
            aVarB.g(this.g);
        }
        p.g gVarF = aVarB.f();
        if (!gVarF.equals(pVar.d)) {
            pVar = pVar.b().c(gVarF).a();
        }
        i iVarC = aVarF.c(pVar);
        ImmutableList<p.k> immutableList = ((p.h) g86.j(pVar.b)).g;
        if (!immutableList.isEmpty()) {
            i[] iVarArr = new i[immutableList.size() + 1];
            iVarArr[0] = iVarC;
            for (int i = 0; i < immutableList.size(); i++) {
                if (this.j) {
                    final com.google.android.exoplayer2.m mVarG = new m.b().g0(immutableList.get(i).b).X(immutableList.get(i).c).i0(immutableList.get(i).d).e0(immutableList.get(i).e).W(immutableList.get(i).f).U(immutableList.get(i).g).G();
                    n.b bVar = new n.b(this.b, new ys1() { // from class: h61
                        @Override // defpackage.ys1
                        public final os1[] createExtractors() {
                            return d.h(mVarG);
                        }

                        @Override // defpackage.ys1
                        public /* synthetic */ os1[] createExtractors(Uri uri, Map map) {
                            return vs1.a(this, uri, map);
                        }
                    });
                    com.google.android.exoplayer2.upstream.f fVar = this.d;
                    if (fVar != null) {
                        bVar.b(fVar);
                    }
                    iVarArr[i + 1] = bVar.c(com.google.android.exoplayer2.p.d(immutableList.get(i).f5923a.toString()));
                } else {
                    s.b bVar2 = new s.b(this.b);
                    com.google.android.exoplayer2.upstream.f fVar2 = this.d;
                    if (fVar2 != null) {
                        bVar2.b(fVar2);
                    }
                    iVarArr[i + 1] = bVar2.a(immutableList.get(i), -9223372036854775807L);
                }
            }
            iVarC = new MergingMediaSource(iVarArr);
        }
        return j(pVar, i(pVar, iVarC));
    }

    public final i j(com.google.android.exoplayer2.p pVar, i iVar) {
        vh.e(pVar.b);
        if (pVar.b.d == null) {
            return iVar;
        }
        y53.i("DMediaSourceFactory", "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
        return iVar;
    }

    @Override // com.google.android.exoplayer2.source.i.a
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public d a(od0.a aVar) {
        this.f5937a.m((od0.a) vh.e(aVar));
        return this;
    }

    @Override // com.google.android.exoplayer2.source.i.a
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public d d(hi1 hi1Var) {
        this.f5937a.o((hi1) vh.f(hi1Var, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior."));
        return this;
    }

    @Override // com.google.android.exoplayer2.source.i.a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public d b(com.google.android.exoplayer2.upstream.f fVar) {
        this.d = (com.google.android.exoplayer2.upstream.f) vh.f(fVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        this.f5937a.p(fVar);
        return this;
    }

    public d(Context context, ys1 ys1Var) {
        this(new c.a(context), ys1Var);
    }

    public d(a.InterfaceC0360a interfaceC0360a) {
        this(interfaceC0360a, new j51());
    }

    public d(a.InterfaceC0360a interfaceC0360a, ys1 ys1Var) {
        this.b = interfaceC0360a;
        a aVar = new a(ys1Var);
        this.f5937a = aVar;
        aVar.n(interfaceC0360a);
        this.e = -9223372036854775807L;
        this.f = -9223372036854775807L;
        this.g = -9223372036854775807L;
        this.h = -3.4028235E38f;
        this.i = -3.4028235E38f;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b implements os1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.m f5939a;

        public b(com.google.android.exoplayer2.m mVar) {
            this.f5939a = mVar;
        }

        @Override // defpackage.os1
        public void b(qs1 qs1Var) {
            c06 c06VarTrack = qs1Var.track(0, 3);
            qs1Var.d(new v45.b(-9223372036854775807L));
            qs1Var.endTracks();
            c06VarTrack.b(this.f5939a.b().g0(MimeTypes.TEXT_UNKNOWN).K(this.f5939a.l).G());
        }

        @Override // defpackage.os1
        public int c(ps1 ps1Var, vk4 vk4Var) throws IOException {
            return ps1Var.skip(Integer.MAX_VALUE) == -1 ? -1 : 0;
        }

        @Override // defpackage.os1
        public boolean d(ps1 ps1Var) {
            return true;
        }

        @Override // defpackage.os1
        public void release() {
        }

        @Override // defpackage.os1
        public void seek(long j, long j2) {
        }
    }
}
