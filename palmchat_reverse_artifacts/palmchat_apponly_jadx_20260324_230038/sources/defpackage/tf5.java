package defpackage;

import java.io.IOException;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class tf5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gc4 f20977a = new gc4(8);
    public int b;

    public final long a(ps1 ps1Var) throws IOException {
        int i = 0;
        ps1Var.peekFully(this.f20977a.e(), 0, 1);
        int i2 = this.f20977a.e()[0] & UByte.MAX_VALUE;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (~i3);
        ps1Var.peekFully(this.f20977a.e(), 1, i4);
        while (i < i4) {
            i++;
            i5 = (this.f20977a.e()[i] & UByte.MAX_VALUE) + (i5 << 8);
        }
        this.b += i4 + 1;
        return i5;
    }

    public boolean b(ps1 ps1Var) throws IOException {
        long length = ps1Var.getLength();
        long j = 1024;
        if (length != -1 && length <= 1024) {
            j = length;
        }
        int i = (int) j;
        ps1Var.peekFully(this.f20977a.e(), 0, 4);
        long J = this.f20977a.J();
        this.b = 4;
        while (J != 440786851) {
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 == i) {
                return false;
            }
            ps1Var.peekFully(this.f20977a.e(), 0, 1);
            J = ((J << 8) & (-256)) | ((long) (this.f20977a.e()[0] & UByte.MAX_VALUE));
        }
        long jA = a(ps1Var);
        long j2 = this.b;
        if (jA == Long.MIN_VALUE) {
            return false;
        }
        if (length != -1 && j2 + jA >= length) {
            return false;
        }
        while (true) {
            int i3 = this.b;
            long j3 = j2 + jA;
            if (i3 >= j3) {
                return ((long) i3) == j3;
            }
            if (a(ps1Var) == Long.MIN_VALUE) {
                return false;
            }
            long jA2 = a(ps1Var);
            if (jA2 < 0 || jA2 > 2147483647L) {
                break;
            }
            if (jA2 != 0) {
                int i4 = (int) jA2;
                ps1Var.advancePeekPosition(i4);
                this.b += i4;
            }
        }
        return false;
    }
}
