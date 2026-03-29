package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.b;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class dq implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f17120a;
    public final ArrayList<u06> b = new ArrayList<>(1);
    public int c;

    @Nullable
    public b d;

    public dq(boolean z) {
        this.f17120a = z;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public final void b(u06 u06Var) {
        vh.e(u06Var);
        if (this.b.contains(u06Var)) {
            return;
        }
        this.b.add(u06Var);
        this.c++;
    }

    public final void c(int i) {
        b bVar = (b) g86.j(this.d);
        for (int i2 = 0; i2 < this.c; i2++) {
            this.b.get(i2).b(this, bVar, this.f17120a, i);
        }
    }

    public final void d() {
        b bVar = (b) g86.j(this.d);
        for (int i = 0; i < this.c; i++) {
            this.b.get(i).a(this, bVar, this.f17120a);
        }
        this.d = null;
    }

    public final void e(b bVar) {
        for (int i = 0; i < this.c; i++) {
            this.b.get(i).f(this, bVar, this.f17120a);
        }
    }

    public final void f(b bVar) {
        this.d = bVar;
        for (int i = 0; i < this.c; i++) {
            this.b.get(i).c(this, bVar, this.f17120a);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public /* synthetic */ Map getResponseHeaders() {
        return vu0.a(this);
    }
}
