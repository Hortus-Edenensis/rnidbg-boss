package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import defpackage.dp;
import defpackage.ed0;
import defpackage.g86;
import defpackage.i43;
import defpackage.j51;
import defpackage.kc;
import defpackage.o06;
import defpackage.qo5;
import defpackage.t91;
import defpackage.u42;
import defpackage.u71;
import defpackage.vh;
import defpackage.vv4;
import defpackage.w45;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface j extends v {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void g(boolean z);

        void onExperimentalSleepingForOffloadChanged(boolean z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {
        public boolean A;
        public boolean B;

        @Nullable
        public Looper C;
        public boolean D;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f5880a;
        public ed0 b;
        public long c;
        public qo5<vv4> d;
        public qo5<i.a> e;
        public qo5<o06> f;
        public qo5<i43> g;
        public qo5<dp> h;
        public u42<ed0, kc> i;
        public Looper j;

        @Nullable
        public PriorityTaskManager k;
        public com.google.android.exoplayer2.audio.a l;
        public boolean m;
        public int n;
        public boolean o;
        public boolean p;
        public boolean q;
        public int r;
        public int s;
        public boolean t;
        public w45 u;
        public long v;
        public long w;
        public o x;
        public long y;
        public long z;

        public b(final Context context) {
            this(context, new qo5() { // from class: uo1
                @Override // defpackage.qo5
                public final Object get() {
                    return j.b.g(context);
                }
            }, new qo5() { // from class: jp1
                @Override // defpackage.qo5
                public final Object get() {
                    return j.b.h(context);
                }
            });
        }

        public static /* synthetic */ vv4 g(Context context) {
            return new u71(context);
        }

        public static /* synthetic */ i.a h(Context context) {
            return new com.google.android.exoplayer2.source.d(context, new j51());
        }

        public static /* synthetic */ o06 i(Context context) {
            return new t91(context);
        }

        public j f() {
            vh.g(!this.D);
            this.D = true;
            return new k(this, null);
        }

        public b l(final i.a aVar) {
            vh.g(!this.D);
            vh.e(aVar);
            this.e = new qo5() { // from class: ro1
                @Override // defpackage.qo5
                public final Object get() {
                    return j.b.k(aVar);
                }
            };
            return this;
        }

        public b(final Context context, qo5<vv4> qo5Var, qo5<i.a> qo5Var2) {
            this(context, qo5Var, qo5Var2, new qo5() { // from class: lp1
                @Override // defpackage.qo5
                public final Object get() {
                    return j.b.i(context);
                }
            }, new qo5() { // from class: np1
                @Override // defpackage.qo5
                public final Object get() {
                    return new c61();
                }
            }, new qo5() { // from class: pp1
                @Override // defpackage.qo5
                public final Object get() {
                    return x31.k(context);
                }
            }, new u42() { // from class: rp1
                @Override // defpackage.u42
                public final Object apply(Object obj) {
                    return new b21((ed0) obj);
                }
            });
        }

        public b(Context context, qo5<vv4> qo5Var, qo5<i.a> qo5Var2, qo5<o06> qo5Var3, qo5<i43> qo5Var4, qo5<dp> qo5Var5, u42<ed0, kc> u42Var) {
            this.f5880a = (Context) vh.e(context);
            this.d = qo5Var;
            this.e = qo5Var2;
            this.f = qo5Var3;
            this.g = qo5Var4;
            this.h = qo5Var5;
            this.i = u42Var;
            this.j = g86.P();
            this.l = com.google.android.exoplayer2.audio.a.g;
            this.n = 0;
            this.r = 1;
            this.s = 0;
            this.t = true;
            this.u = w45.g;
            this.v = 5000L;
            this.w = C.DEFAULT_SEEK_FORWARD_INCREMENT_MS;
            this.x = new g.b().a();
            this.b = ed0.f17276a;
            this.y = 500L;
            this.z = 2000L;
            this.B = true;
        }

        public static /* synthetic */ i.a k(i.a aVar) {
            return aVar;
        }
    }
}
