package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.b;
import defpackage.z50;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class jo0 extends fr {
    public final int o;
    public final long p;
    public final z50 q;
    public long r;
    public volatile boolean s;
    public boolean t;

    public jo0(a aVar, b bVar, m mVar, int i, @Nullable Object obj, long j, long j2, long j3, long j4, long j5, int i2, long j6, z50 z50Var) {
        super(aVar, bVar, mVar, i, obj, j, j2, j3, j4, j5);
        this.o = i2;
        this.p = j6;
        this.q = z50Var;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void cancelLoad() {
        this.s = true;
    }

    @Override // defpackage.te3
    public long e() {
        return this.j + ((long) this.o);
    }

    @Override // defpackage.te3
    public boolean f() {
        return this.t;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void load() throws IOException {
        if (this.r == 0) {
            hr hrVarH = h();
            hrVarH.b(this.p);
            z50 z50Var = this.q;
            z50.b bVarJ = j(hrVarH);
            long j = this.k;
            long j2 = j == -9223372036854775807L ? -9223372036854775807L : j - this.p;
            long j3 = this.l;
            z50Var.b(bVarJ, j2, j3 == -9223372036854775807L ? -9223372036854775807L : j3 - this.p);
        }
        try {
            b bVarE = this.b.e(this.r);
            rk5 rk5Var = this.i;
            e51 e51Var = new e51(rk5Var, bVarE.g, rk5Var.a(bVarE));
            do {
                try {
                    if (this.s) {
                        break;
                    }
                } finally {
                    this.r = e51Var.getPosition() - this.b.g;
                }
            } while (this.q.a(e51Var));
            cv0.a(this.i);
            this.t = !this.s;
        } catch (Throwable th) {
            cv0.a(this.i);
            throw th;
        }
    }

    public z50.b j(hr hrVar) {
        return hrVar;
    }
}
