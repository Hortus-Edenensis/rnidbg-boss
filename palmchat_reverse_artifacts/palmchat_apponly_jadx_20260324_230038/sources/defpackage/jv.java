package defpackage;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import defpackage.c06;
import defpackage.z50;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class jv implements qs1, z50 {
    public static final z50.a j = new z50.a() { // from class: iv
        @Override // z50.a
        public final z50 a(int i, m mVar, boolean z, List list, c06 c06Var, bk4 bk4Var) {
            return jv.e(i, mVar, z, list, c06Var, bk4Var);
        }
    };
    public static final vk4 k = new vk4();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final os1 f18511a;
    public final int b;
    public final m c;
    public final SparseArray<a> d = new SparseArray<>();
    public boolean e;

    @Nullable
    public z50.b f;
    public long g;
    public v45 h;
    public m[] i;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a implements c06 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18512a;
        public final int b;

        @Nullable
        public final m c;
        public final pi1 d = new pi1();
        public m e;
        public c06 f;
        public long g;

        public a(int i, int i2, @Nullable m mVar) {
            this.f18512a = i;
            this.b = i2;
            this.c = mVar;
        }

        @Override // defpackage.c06
        public void a(gc4 gc4Var, int i, int i2) {
            ((c06) g86.j(this.f)).d(gc4Var, i);
        }

        @Override // defpackage.c06
        public void b(m mVar) {
            m mVar2 = this.c;
            if (mVar2 != null) {
                mVar = mVar.k(mVar2);
            }
            this.e = mVar;
            ((c06) g86.j(this.f)).b(this.e);
        }

        @Override // defpackage.c06
        public /* synthetic */ int c(ru0 ru0Var, int i, boolean z) {
            return zz5.a(this, ru0Var, i, z);
        }

        @Override // defpackage.c06
        public /* synthetic */ void d(gc4 gc4Var, int i) {
            zz5.b(this, gc4Var, i);
        }

        @Override // defpackage.c06
        public void e(long j, int i, int i2, int i3, @Nullable c06.a aVar) {
            long j2 = this.g;
            if (j2 != -9223372036854775807L && j >= j2) {
                this.f = this.d;
            }
            ((c06) g86.j(this.f)).e(j, i, i2, i3, aVar);
        }

        @Override // defpackage.c06
        public int f(ru0 ru0Var, int i, boolean z, int i2) throws IOException {
            return ((c06) g86.j(this.f)).c(ru0Var, i, z);
        }

        public void g(@Nullable z50.b bVar, long j) {
            if (bVar == null) {
                this.f = this.d;
                return;
            }
            this.g = j;
            c06 c06VarTrack = bVar.track(this.f18512a, this.b);
            this.f = c06VarTrack;
            m mVar = this.e;
            if (mVar != null) {
                c06VarTrack.b(mVar);
            }
        }
    }

    public jv(os1 os1Var, int i, m mVar) {
        this.f18511a = os1Var;
        this.b = i;
        this.c = mVar;
    }

    public static /* synthetic */ z50 e(int i, m mVar, boolean z, List list, c06 c06Var, bk4 bk4Var) {
        os1 b32Var;
        String str = mVar.k;
        if (fp3.r(str)) {
            return null;
        }
        if (fp3.q(str)) {
            b32Var = new he3(1);
        } else {
            b32Var = new b32(z ? 4 : 0, null, null, list, c06Var);
        }
        return new jv(b32Var, i, mVar);
    }

    @Override // defpackage.z50
    public boolean a(ps1 ps1Var) throws IOException {
        int iC = this.f18511a.c(ps1Var, k);
        vh.g(iC != 1);
        return iC == 0;
    }

    @Override // defpackage.z50
    public void b(@Nullable z50.b bVar, long j2, long j3) {
        this.f = bVar;
        this.g = j3;
        if (!this.e) {
            this.f18511a.b(this);
            if (j2 != -9223372036854775807L) {
                this.f18511a.seek(0L, j2);
            }
            this.e = true;
            return;
        }
        os1 os1Var = this.f18511a;
        if (j2 == -9223372036854775807L) {
            j2 = 0;
        }
        os1Var.seek(0L, j2);
        for (int i = 0; i < this.d.size(); i++) {
            this.d.valueAt(i).g(bVar, j3);
        }
    }

    @Override // defpackage.qs1
    public void d(v45 v45Var) {
        this.h = v45Var;
    }

    @Override // defpackage.qs1
    public void endTracks() {
        m[] mVarArr = new m[this.d.size()];
        for (int i = 0; i < this.d.size(); i++) {
            mVarArr[i] = (m) vh.i(this.d.valueAt(i).e);
        }
        this.i = mVarArr;
    }

    @Override // defpackage.z50
    @Nullable
    public b60 getChunkIndex() {
        v45 v45Var = this.h;
        if (v45Var instanceof b60) {
            return (b60) v45Var;
        }
        return null;
    }

    @Override // defpackage.z50
    @Nullable
    public m[] getSampleFormats() {
        return this.i;
    }

    @Override // defpackage.z50
    public void release() {
        this.f18511a.release();
    }

    @Override // defpackage.qs1
    public c06 track(int i, int i2) {
        a aVar = this.d.get(i);
        if (aVar == null) {
            vh.g(this.i == null);
            aVar = new a(i, i2, i2 == this.b ? this.c : null);
            aVar.g(this.f, this.g);
            this.d.put(i, aVar);
        }
        return aVar;
    }
}
