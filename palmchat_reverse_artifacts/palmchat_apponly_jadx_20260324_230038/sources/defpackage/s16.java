package defpackage;

import androidx.annotation.Nullable;
import defpackage.c06;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class s16 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f20653a = new byte[10];
    public boolean b;
    public int c;
    public long d;
    public int e;
    public int f;
    public int g;

    public void a(c06 c06Var, @Nullable c06.a aVar) {
        if (this.c > 0) {
            c06Var.e(this.d, this.e, this.f, this.g, aVar);
            this.c = 0;
        }
    }

    public void b() {
        this.b = false;
        this.c = 0;
    }

    public void c(c06 c06Var, long j, int i, int i2, int i3, @Nullable c06.a aVar) {
        vh.h(this.g <= i2 + i3, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.b) {
            int i4 = this.c;
            int i5 = i4 + 1;
            this.c = i5;
            if (i4 == 0) {
                this.d = j;
                this.e = i;
                this.f = 0;
            }
            this.f += i2;
            this.g = i3;
            if (i5 >= 16) {
                a(c06Var, aVar);
            }
        }
    }

    public void d(ps1 ps1Var) throws IOException {
        if (this.b) {
            return;
        }
        ps1Var.peekFully(this.f20653a, 0, 10);
        ps1Var.resetPeekPosition();
        if (h2.j(this.f20653a) == 0) {
            return;
        }
        this.b = true;
    }
}
