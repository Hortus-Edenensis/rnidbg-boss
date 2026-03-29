package defpackage;

import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.ArrayDeque;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class b51 implements zj1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f1650a = new byte[8];
    public final ArrayDeque<b> b = new ArrayDeque<>();
    public final j96 c = new j96();
    public yj1 d;
    public int e;
    public int f;
    public long g;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1651a;
        public final long b;

        public b(int i, long j) {
            this.f1651a = i;
            this.b = j;
        }
    }

    public static String f(ps1 ps1Var, int i) throws IOException {
        if (i == 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        ps1Var.readFully(bArr, 0, i);
        while (i > 0 && bArr[i - 1] == 0) {
            i--;
        }
        return new String(bArr, 0, i);
    }

    @Override // defpackage.zj1
    public boolean a(ps1 ps1Var) throws IOException {
        vh.i(this.d);
        while (true) {
            b bVarPeek = this.b.peek();
            if (bVarPeek != null && ps1Var.getPosition() >= bVarPeek.b) {
                this.d.endMasterElement(this.b.pop().f1651a);
                return true;
            }
            if (this.e == 0) {
                long jD = this.c.d(ps1Var, true, false, 4);
                if (jD == -2) {
                    jD = c(ps1Var);
                }
                if (jD == -1) {
                    return false;
                }
                this.f = (int) jD;
                this.e = 1;
            }
            if (this.e == 1) {
                this.g = this.c.d(ps1Var, false, true, 8);
                this.e = 2;
            }
            int elementType = this.d.getElementType(this.f);
            if (elementType != 0) {
                if (elementType == 1) {
                    long position = ps1Var.getPosition();
                    this.b.push(new b(this.f, this.g + position));
                    this.d.startMasterElement(this.f, position, this.g);
                    this.e = 0;
                    return true;
                }
                if (elementType == 2) {
                    long j = this.g;
                    if (j <= 8) {
                        this.d.integerElement(this.f, e(ps1Var, (int) j));
                        this.e = 0;
                        return true;
                    }
                    throw ParserException.createForMalformedContainer("Invalid integer size: " + this.g, null);
                }
                if (elementType == 3) {
                    long j2 = this.g;
                    if (j2 <= 2147483647L) {
                        this.d.stringElement(this.f, f(ps1Var, (int) j2));
                        this.e = 0;
                        return true;
                    }
                    throw ParserException.createForMalformedContainer("String element size: " + this.g, null);
                }
                if (elementType == 4) {
                    this.d.a(this.f, (int) this.g, ps1Var);
                    this.e = 0;
                    return true;
                }
                if (elementType != 5) {
                    throw ParserException.createForMalformedContainer("Invalid element type " + elementType, null);
                }
                long j3 = this.g;
                if (j3 == 4 || j3 == 8) {
                    this.d.floatElement(this.f, d(ps1Var, (int) j3));
                    this.e = 0;
                    return true;
                }
                throw ParserException.createForMalformedContainer("Invalid float size: " + this.g, null);
            }
            ps1Var.skipFully((int) this.g);
            this.e = 0;
        }
    }

    @Override // defpackage.zj1
    public void b(yj1 yj1Var) {
        this.d = yj1Var;
    }

    public final long c(ps1 ps1Var) throws IOException {
        ps1Var.resetPeekPosition();
        while (true) {
            ps1Var.peekFully(this.f1650a, 0, 4);
            int iC = j96.c(this.f1650a[0]);
            if (iC != -1 && iC <= 4) {
                int iA = (int) j96.a(this.f1650a, iC, false);
                if (this.d.isLevel1Element(iA)) {
                    ps1Var.skipFully(iC);
                    return iA;
                }
            }
            ps1Var.skipFully(1);
        }
    }

    public final double d(ps1 ps1Var, int i) throws IOException {
        return i == 4 ? Float.intBitsToFloat((int) r0) : Double.longBitsToDouble(e(ps1Var, i));
    }

    public final long e(ps1 ps1Var, int i) throws IOException {
        ps1Var.readFully(this.f1650a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.f1650a[i2] & UByte.MAX_VALUE));
        }
        return j;
    }

    @Override // defpackage.zj1
    public void reset() {
        this.e = 0;
        this.b.clear();
        this.c.e();
    }
}
