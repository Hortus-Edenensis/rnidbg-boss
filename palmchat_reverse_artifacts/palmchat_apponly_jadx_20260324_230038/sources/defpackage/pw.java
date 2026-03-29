package defpackage;

import androidx.annotation.Nullable;
import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class pw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20116a;
    public final String b;
    public final TreeSet<cd5> c;
    public final ArrayList<a> d;
    public e41 e;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f20117a;
        public final long b;

        public a(long j, long j2) {
            this.f20117a = j;
            this.b = j2;
        }

        public boolean a(long j, long j2) {
            long j3 = this.b;
            if (j3 == -1) {
                return j >= this.f20117a;
            }
            if (j2 == -1) {
                return false;
            }
            long j4 = this.f20117a;
            return j4 <= j && j + j2 <= j4 + j3;
        }

        public boolean b(long j, long j2) {
            long j3 = this.f20117a;
            if (j3 > j) {
                return j2 == -1 || j + j2 > j3;
            }
            long j4 = this.b;
            return j4 == -1 || j3 + j4 > j;
        }
    }

    public pw(int i, String str) {
        this(i, str, e41.c);
    }

    public void a(cd5 cd5Var) {
        this.c.add(cd5Var);
    }

    public boolean b(mp0 mp0Var) {
        this.e = this.e.c(mp0Var);
        return !r2.equals(r0);
    }

    public e41 c() {
        return this.e;
    }

    public cd5 d(long j, long j2) {
        cd5 cd5VarH = cd5.h(this.b, j);
        cd5 cd5VarFloor = this.c.floor(cd5VarH);
        if (cd5VarFloor != null && cd5VarFloor.b + cd5VarFloor.c > j) {
            return cd5VarFloor;
        }
        cd5 cd5VarCeiling = this.c.ceiling(cd5VarH);
        if (cd5VarCeiling != null) {
            long j3 = cd5VarCeiling.b - j;
            j2 = j2 == -1 ? j3 : Math.min(j3, j2);
        }
        return cd5.g(this.b, j, j2);
    }

    public TreeSet<cd5> e() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || pw.class != obj.getClass()) {
            return false;
        }
        pw pwVar = (pw) obj;
        return this.f20116a == pwVar.f20116a && this.b.equals(pwVar.b) && this.c.equals(pwVar.c) && this.e.equals(pwVar.e);
    }

    public boolean f() {
        return this.c.isEmpty();
    }

    public boolean g(long j, long j2) {
        for (int i = 0; i < this.d.size(); i++) {
            if (this.d.get(i).a(j, j2)) {
                return true;
            }
        }
        return false;
    }

    public boolean h() {
        return this.d.isEmpty();
    }

    public int hashCode() {
        return (((this.f20116a * 31) + this.b.hashCode()) * 31) + this.e.hashCode();
    }

    public boolean i(long j, long j2) {
        for (int i = 0; i < this.d.size(); i++) {
            if (this.d.get(i).b(j, j2)) {
                return false;
            }
        }
        this.d.add(new a(j, j2));
        return true;
    }

    public boolean j(nw nwVar) {
        if (!this.c.remove(nwVar)) {
            return false;
        }
        File file = nwVar.e;
        if (file == null) {
            return true;
        }
        file.delete();
        return true;
    }

    public cd5 k(cd5 cd5Var, long j, boolean z) {
        vh.g(this.c.remove(cd5Var));
        File file = (File) vh.e(cd5Var.e);
        if (z) {
            File fileI = cd5.i((File) vh.e(file.getParentFile()), this.f20116a, cd5Var.b, j);
            if (file.renameTo(fileI)) {
                file = fileI;
            } else {
                y53.i("CachedContent", "Failed to rename " + file + " to " + fileI);
            }
        }
        cd5 cd5VarD = cd5Var.d(file, j);
        this.c.add(cd5VarD);
        return cd5VarD;
    }

    public void l(long j) {
        for (int i = 0; i < this.d.size(); i++) {
            if (this.d.get(i).f20117a == j) {
                this.d.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public pw(int i, String str, e41 e41Var) {
        this.f20116a = i;
        this.b = str;
        this.e = e41Var;
        this.c = new TreeSet<>();
        this.d = new ArrayList<>();
    }
}
