package defpackage;

import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class nw implements Comparable<nw> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19628a;
    public final long b;
    public final long c;
    public final boolean d;

    @Nullable
    public final File e;
    public final long f;

    public nw(String str, long j, long j2, long j3, @Nullable File file) {
        this.f19628a = str;
        this.b = j;
        this.c = j2;
        this.d = file != null;
        this.e = file;
        this.f = j3;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(nw nwVar) {
        if (!this.f19628a.equals(nwVar.f19628a)) {
            return this.f19628a.compareTo(nwVar.f19628a);
        }
        long j = this.b - nwVar.b;
        if (j == 0) {
            return 0;
        }
        return j < 0 ? -1 : 1;
    }

    public boolean b() {
        return !this.d;
    }

    public boolean c() {
        return this.c == -1;
    }

    public String toString() {
        return "[" + this.b + ", " + this.c + "]";
    }
}
