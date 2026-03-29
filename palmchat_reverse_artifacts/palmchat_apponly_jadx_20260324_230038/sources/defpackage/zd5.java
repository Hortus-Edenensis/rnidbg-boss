package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.b;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class zd5 extends fr {
    public final int o;
    public final m p;
    public long q;
    public boolean r;

    public zd5(a aVar, b bVar, m mVar, int i, @Nullable Object obj, long j, long j2, long j3, int i2, m mVar2) {
        super(aVar, bVar, mVar, i, obj, j, j2, -9223372036854775807L, -9223372036854775807L, j3);
        this.o = i2;
        this.p = mVar2;
    }

    @Override // defpackage.te3
    public boolean f() {
        return this.r;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void load() throws IOException {
        hr hrVarH = h();
        hrVarH.b(0L);
        c06 c06VarTrack = hrVarH.track(0, this.o);
        c06VarTrack.b(this.p);
        try {
            long jA = this.i.a(this.b.e(this.q));
            if (jA != -1) {
                jA += this.q;
            }
            e51 e51Var = new e51(this.i, this.q, jA);
            for (int iC = 0; iC != -1; iC = c06VarTrack.c(e51Var, Integer.MAX_VALUE, true)) {
                this.q += (long) iC;
            }
            c06VarTrack.e(this.g, 1, (int) this.q, 0, null);
            cv0.a(this.i);
            this.r = true;
        } catch (Throwable th) {
            cv0.a(this.i);
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void cancelLoad() {
    }
}
