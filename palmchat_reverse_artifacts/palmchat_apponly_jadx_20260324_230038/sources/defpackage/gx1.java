package defpackage;

import defpackage.lx1;
import defpackage.ys;
import j$.util.Objects;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class gx1 extends ys {

    /* JADX INFO: compiled from: SearchBox */
    public static final class b implements ys.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final px1 f17829a;
        public final int b;
        public final lx1.a c;

        @Override // ys.f
        public ys.e a(ps1 ps1Var, long j) throws IOException {
            long position = ps1Var.getPosition();
            long jB = b(ps1Var);
            long peekPosition = ps1Var.getPeekPosition();
            ps1Var.advancePeekPosition(Math.max(6, this.f17829a.c));
            long jB2 = b(ps1Var);
            return (jB > j || jB2 <= j) ? jB2 <= j ? ys.e.f(jB2, ps1Var.getPeekPosition()) : ys.e.d(jB, position) : ys.e.e(peekPosition);
        }

        public final long b(ps1 ps1Var) throws IOException {
            while (ps1Var.getPeekPosition() < ps1Var.getLength() - 6 && !lx1.h(ps1Var, this.f17829a, this.b, this.c)) {
                ps1Var.advancePeekPosition(1);
            }
            if (ps1Var.getPeekPosition() < ps1Var.getLength() - 6) {
                return this.c.f19094a;
            }
            ps1Var.advancePeekPosition((int) (ps1Var.getLength() - ps1Var.getPeekPosition()));
            return this.f17829a.j;
        }

        @Override // ys.f
        public /* synthetic */ void onSeekFinished() {
            zs.a(this);
        }

        public b(px1 px1Var, int i) {
            this.f17829a = px1Var;
            this.b = i;
            this.c = new lx1.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gx1(final px1 px1Var, int i, long j, long j2) {
        super(new ys.d() { // from class: dx1
            @Override // ys.d
            public final long timeUsToTargetTime(long j3) {
                return px1Var.i(j3);
            }
        }, new b(px1Var, i), px1Var.f(), 0L, px1Var.j, j, j2, px1Var.d(), Math.max(6, px1Var.c));
        Objects.requireNonNull(px1Var);
    }
}
