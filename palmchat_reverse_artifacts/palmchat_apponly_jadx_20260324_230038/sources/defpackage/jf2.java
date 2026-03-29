package defpackage;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.m;
import com.ss.android.ttvecamera.TELogUtils;
import defpackage.j26;
import java.util.Arrays;
import java.util.Collections;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class jf2 implements gl1 {
    public static final double[] q = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18396a;
    public c06 b;

    @Nullable
    public final f66 c;

    @Nullable
    public final gc4 d;

    @Nullable
    public final nt3 e;
    public final boolean[] f;
    public final a g;
    public long h;
    public boolean i;
    public boolean j;
    public long k;
    public long l;
    public long m;
    public long n;
    public boolean o;
    public boolean p;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {
        public static final byte[] e = {0, 0, 1};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f18397a;
        public int b;
        public int c;
        public byte[] d;

        public a(int i) {
            this.d = new byte[i];
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.f18397a) {
                int i3 = i2 - i;
                byte[] bArr2 = this.d;
                int length = bArr2.length;
                int i4 = this.b;
                if (length < i4 + i3) {
                    this.d = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.d, this.b, i3);
                this.b += i3;
            }
        }

        public boolean b(int i, int i2) {
            if (this.f18397a) {
                int i3 = this.b - i2;
                this.b = i3;
                if (this.c != 0 || i != 181) {
                    this.f18397a = false;
                    return true;
                }
                this.c = i3;
            } else if (i == 179) {
                this.f18397a = true;
            }
            byte[] bArr = e;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f18397a = false;
            this.b = 0;
            this.c = 0;
        }
    }

    public jf2() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<m, Long> c(a aVar, String str) {
        float f;
        int i;
        float f2;
        int i2;
        long j;
        byte[] bArrCopyOf = Arrays.copyOf(aVar.d, aVar.b);
        int i3 = bArrCopyOf[4] & UByte.MAX_VALUE;
        int i4 = bArrCopyOf[5] & UByte.MAX_VALUE;
        int i5 = (i3 << 4) | (i4 >> 4);
        int i6 = ((i4 & 15) << 8) | (bArrCopyOf[6] & UByte.MAX_VALUE);
        int i7 = (bArrCopyOf[7] & 240) >> 4;
        if (i7 == 2) {
            f = i6 * 4;
            i = i5 * 3;
        } else if (i7 == 3) {
            f = i6 * 16;
            i = i5 * 9;
        } else {
            if (i7 != 4) {
                f2 = 1.0f;
                m mVarG = new m.b().U(str).g0("video/mpeg2").n0(i5).S(i6).c0(f2).V(Collections.singletonList(bArrCopyOf)).G();
                i2 = (bArrCopyOf[7] & 15) - 1;
                if (i2 < 0) {
                    double[] dArr = q;
                    if (i2 < dArr.length) {
                        double d = dArr[i2];
                        byte b = bArrCopyOf[aVar.c + 9];
                        int i8 = (b & 96) >> 5;
                        int i9 = b & TELogUtils.DEBUG_LEVEL_V;
                        if (i8 != i9) {
                            d *= (((double) i8) + 1.0d) / ((double) (i9 + 1));
                        }
                        j = (long) (1000000.0d / d);
                    } else {
                        j = 0;
                    }
                }
                return Pair.create(mVarG, Long.valueOf(j));
            }
            f = i6 * 121;
            i = i5 * 100;
        }
        f2 = f / i;
        m mVarG2 = new m.b().U(str).g0("video/mpeg2").n0(i5).S(i6).c0(f2).V(Collections.singletonList(bArrCopyOf)).G();
        i2 = (bArrCopyOf[7] & 15) - 1;
        if (i2 < 0) {
        }
        return Pair.create(mVarG2, Long.valueOf(j));
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0142  */
    @Override // defpackage.gl1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(gc4 gc4Var) {
        int i;
        long j;
        int i2;
        vh.i(this.b);
        int iF = gc4Var.f();
        int iG = gc4Var.g();
        byte[] bArrE = gc4Var.e();
        this.h += (long) gc4Var.a();
        this.b.d(gc4Var, gc4Var.a());
        while (true) {
            int iC = ot3.c(bArrE, iF, iG, this.f);
            if (iC == iG) {
                break;
            }
            int i3 = iC + 3;
            int i4 = gc4Var.e()[i3] & UByte.MAX_VALUE;
            int i5 = iC - iF;
            if (!this.j) {
                if (i5 > 0) {
                    this.g.a(bArrE, iF, iC);
                }
                if (this.g.b(i4, i5 < 0 ? -i5 : 0)) {
                    Pair<m, Long> pairC = c(this.g, (String) vh.e(this.f18396a));
                    this.b.b((m) pairC.first);
                    this.k = ((Long) pairC.second).longValue();
                    this.j = true;
                }
            }
            nt3 nt3Var = this.e;
            if (nt3Var != null) {
                if (i5 > 0) {
                    nt3Var.a(bArrE, iF, iC);
                    i2 = 0;
                } else {
                    i2 = -i5;
                }
                if (this.e.b(i2)) {
                    nt3 nt3Var2 = this.e;
                    ((gc4) g86.j(this.d)).S(this.e.d, ot3.q(nt3Var2.d, nt3Var2.e));
                    ((f66) g86.j(this.c)).a(this.n, this.d);
                }
                if (i4 == 178 && gc4Var.e()[iC + 2] == 1) {
                    this.e.e(i4);
                }
            }
            if (i4 == 0 || i4 == 179) {
                int i6 = iG - iC;
                if (this.p && this.j) {
                    long j2 = this.n;
                    if (j2 != -9223372036854775807L) {
                        i = i4;
                        this.b.e(j2, this.o ? 1 : 0, ((int) (this.h - this.m)) - i6, i6, null);
                    }
                    if (this.i) {
                        this.m = this.h - ((long) i6);
                        j = this.l;
                        if (j == -9223372036854775807L) {
                        }
                        this.n = j;
                        this.o = false;
                        this.l = -9223372036854775807L;
                        this.i = true;
                        this.p = i == 0;
                    }
                } else {
                    i = i4;
                    if (this.i || this.p) {
                        this.m = this.h - ((long) i6);
                        j = this.l;
                        if (j == -9223372036854775807L) {
                            long j3 = this.n;
                            j = j3 != -9223372036854775807L ? j3 + this.k : -9223372036854775807L;
                        }
                        this.n = j;
                        this.o = false;
                        this.l = -9223372036854775807L;
                        this.i = true;
                    }
                    this.p = i == 0;
                }
            } else if (i4 == 184) {
                this.o = true;
            }
            iF = i3;
        }
        if (!this.j) {
            this.g.a(bArrE, iF, iG);
        }
        nt3 nt3Var3 = this.e;
        if (nt3Var3 != null) {
            nt3Var3.a(bArrE, iF, iG);
        }
    }

    @Override // defpackage.gl1
    public void b(qs1 qs1Var, j26.d dVar) {
        dVar.a();
        this.f18396a = dVar.b();
        this.b = qs1Var.track(dVar.c(), 2);
        f66 f66Var = this.c;
        if (f66Var != null) {
            f66Var.b(qs1Var, dVar);
        }
    }

    @Override // defpackage.gl1
    public void packetStarted(long j, int i) {
        this.l = j;
    }

    @Override // defpackage.gl1
    public void seek() {
        ot3.a(this.f);
        this.g.c();
        nt3 nt3Var = this.e;
        if (nt3Var != null) {
            nt3Var.d();
        }
        this.h = 0L;
        this.i = false;
        this.l = -9223372036854775807L;
        this.n = -9223372036854775807L;
    }

    public jf2(@Nullable f66 f66Var) {
        this.c = f66Var;
        this.f = new boolean[4];
        this.g = new a(128);
        if (f66Var != null) {
            this.e = new nt3(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD, 128);
            this.d = new gc4();
        } else {
            this.e = null;
            this.d = null;
        }
        this.l = -9223372036854775807L;
        this.n = -9223372036854775807L;
    }

    @Override // defpackage.gl1
    public void packetFinished() {
    }
}
