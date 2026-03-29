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
public final class ys2 extends x50 {
    public final z50 j;
    public z50.b k;
    public long l;
    public volatile boolean m;

    public ys2(a aVar, b bVar, m mVar, int i, @Nullable Object obj, z50 z50Var) {
        super(aVar, bVar, 2, mVar, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.j = z50Var;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void cancelLoad() {
        this.m = true;
    }

    public void e(z50.b bVar) {
        this.k = bVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void load() throws IOException {
        if (this.l == 0) {
            this.j.b(this.k, -9223372036854775807L, -9223372036854775807L);
        }
        try {
            b bVarE = this.b.e(this.l);
            rk5 rk5Var = this.i;
            e51 e51Var = new e51(rk5Var, bVarE.g, rk5Var.a(bVarE));
            while (!this.m && this.j.a(e51Var)) {
                try {
                } finally {
                    this.l = e51Var.getPosition() - this.b.g;
                }
            }
        } finally {
            cv0.a(this.i);
        }
    }
}
