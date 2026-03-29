package defpackage;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.m;
import com.google.common.collect.ImmutableList;
import defpackage.a55;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class ow4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f19889a;
    public final m b;
    public final ImmutableList<cs> c;
    public final long d;
    public final List<ab1> e;
    public final List<ab1> f;
    public final List<ab1> g;
    public final bt4 h;

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends ow4 {
        public final Uri i;
        public final long j;

        @Nullable
        public final String k;

        @Nullable
        public final bt4 l;

        @Nullable
        public final be5 m;

        public c(long j, m mVar, List<cs> list, a55.e eVar, @Nullable List<ab1> list2, List<ab1> list3, List<ab1> list4, @Nullable String str, long j2) {
            super(j, mVar, list, eVar, list2, list3, list4);
            this.i = Uri.parse(list.get(0).f16905a);
            bt4 bt4VarC = eVar.c();
            this.l = bt4VarC;
            this.k = str;
            this.j = j2;
            this.m = bt4VarC != null ? null : new be5(new bt4(null, 0L, j2));
        }

        @Override // defpackage.ow4
        @Nullable
        public String j() {
            return this.k;
        }

        @Override // defpackage.ow4
        @Nullable
        public du0 k() {
            return this.m;
        }

        @Override // defpackage.ow4
        @Nullable
        public bt4 l() {
            return this.l;
        }
    }

    public static ow4 n(long j, m mVar, List<cs> list, a55 a55Var, @Nullable List<ab1> list2, List<ab1> list3, List<ab1> list4, @Nullable String str) {
        if (a55Var instanceof a55.e) {
            return new c(j, mVar, list, (a55.e) a55Var, list2, list3, list4, str, -1L);
        }
        if (a55Var instanceof a55.a) {
            return new b(j, mVar, list, (a55.a) a55Var, list2, list3, list4);
        }
        throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
    }

    @Nullable
    public abstract String j();

    @Nullable
    public abstract du0 k();

    @Nullable
    public abstract bt4 l();

    @Nullable
    public bt4 m() {
        return this.h;
    }

    public ow4(long j, m mVar, List<cs> list, a55 a55Var, @Nullable List<ab1> list2, List<ab1> list3, List<ab1> list4) {
        vh.a(!list.isEmpty());
        this.f19889a = j;
        this.b = mVar;
        this.c = ImmutableList.copyOf((Collection) list);
        this.e = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.f = list3;
        this.g = list4;
        this.h = a55Var.a(this);
        this.d = a55Var.b();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends ow4 implements du0 {

        @VisibleForTesting
        public final a55.a i;

        public b(long j, m mVar, List<cs> list, a55.a aVar, @Nullable List<ab1> list2, List<ab1> list3, List<ab1> list4) {
            super(j, mVar, list, aVar, list2, list3, list4);
            this.i = aVar;
        }

        @Override // defpackage.du0
        public long a(long j, long j2) {
            return this.i.h(j, j2);
        }

        @Override // defpackage.du0
        public long b(long j, long j2) {
            return this.i.d(j, j2);
        }

        @Override // defpackage.du0
        public long c(long j, long j2) {
            return this.i.f(j, j2);
        }

        @Override // defpackage.du0
        public long d(long j, long j2) {
            return this.i.i(j, j2);
        }

        @Override // defpackage.du0
        public long e(long j) {
            return this.i.g(j);
        }

        @Override // defpackage.du0
        public long f() {
            return this.i.e();
        }

        @Override // defpackage.du0
        public bt4 g(long j) {
            return this.i.k(this, j);
        }

        @Override // defpackage.du0
        public long getTimeUs(long j) {
            return this.i.j(j);
        }

        @Override // defpackage.du0
        public boolean h() {
            return this.i.l();
        }

        @Override // defpackage.du0
        public long i(long j, long j2) {
            return this.i.c(j, j2);
        }

        @Override // defpackage.ow4
        @Nullable
        public String j() {
            return null;
        }

        @Override // defpackage.ow4
        @Nullable
        public bt4 l() {
            return null;
        }

        @Override // defpackage.ow4
        public du0 k() {
            return this;
        }
    }
}
