package defpackage;

import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.m;
import defpackage.j26;
import java.util.Arrays;
import java.util.Collections;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class kf2 implements gl1 {
    public static final float[] l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final f66 f18677a;

    @Nullable
    public final gc4 b;

    @Nullable
    public final nt3 e;
    public b f;
    public long g;
    public String h;
    public c06 i;
    public boolean j;
    public final boolean[] c = new boolean[4];
    public final a d = new a(128);
    public long k = -9223372036854775807L;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {
        public static final byte[] f = {0, 0, 1};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f18678a;
        public int b;
        public int c;
        public int d;
        public byte[] e;

        public a(int i) {
            this.e = new byte[i];
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.f18678a) {
                int i3 = i2 - i;
                byte[] bArr2 = this.e;
                int length = bArr2.length;
                int i4 = this.c;
                if (length < i4 + i3) {
                    this.e = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.e, this.c, i3);
                this.c += i3;
            }
        }

        public boolean b(int i, int i2) {
            int i3 = this.b;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                throw new IllegalStateException();
                            }
                            if (i == 179 || i == 181) {
                                this.c -= i2;
                                this.f18678a = false;
                                return true;
                            }
                        } else if ((i & 240) != 32) {
                            y53.i("H263Reader", "Unexpected start code value");
                            c();
                        } else {
                            this.d = this.c;
                            this.b = 4;
                        }
                    } else if (i > 31) {
                        y53.i("H263Reader", "Unexpected start code value");
                        c();
                    } else {
                        this.b = 3;
                    }
                } else if (i != 181) {
                    y53.i("H263Reader", "Unexpected start code value");
                    c();
                } else {
                    this.b = 2;
                }
            } else if (i == 176) {
                this.b = 1;
                this.f18678a = true;
            }
            byte[] bArr = f;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f18678a = false;
            this.c = 0;
            this.b = 0;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c06 f18679a;
        public boolean b;
        public boolean c;
        public boolean d;
        public int e;
        public int f;
        public long g;
        public long h;

        public b(c06 c06Var) {
            this.f18679a = c06Var;
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.c) {
                int i3 = this.f;
                int i4 = (i + 1) - i3;
                if (i4 >= i2) {
                    this.f = i3 + (i2 - i);
                } else {
                    this.d = ((bArr[i4] & 192) >> 6) == 0;
                    this.c = false;
                }
            }
        }

        public void b(long j, int i, boolean z) {
            if (this.e == 182 && z && this.b) {
                long j2 = this.h;
                if (j2 != -9223372036854775807L) {
                    this.f18679a.e(j2, this.d ? 1 : 0, (int) (j - this.g), i, null);
                }
            }
            if (this.e != 179) {
                this.g = j;
            }
        }

        public void c(int i, long j) {
            this.e = i;
            this.d = false;
            this.b = i == 182 || i == 179;
            this.c = i == 182;
            this.f = 0;
            this.h = j;
        }

        public void d() {
            this.b = false;
            this.c = false;
            this.d = false;
            this.e = -1;
        }
    }

    public kf2(@Nullable f66 f66Var) {
        this.f18677a = f66Var;
        if (f66Var != null) {
            this.e = new nt3(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD, 128);
            this.b = new gc4();
        } else {
            this.e = null;
            this.b = null;
        }
    }

    public static m c(a aVar, int i, String str) {
        byte[] bArrCopyOf = Arrays.copyOf(aVar.e, aVar.c);
        fc4 fc4Var = new fc4(bArrCopyOf);
        fc4Var.s(i);
        fc4Var.s(4);
        fc4Var.q();
        fc4Var.r(8);
        if (fc4Var.g()) {
            fc4Var.r(4);
            fc4Var.r(3);
        }
        int iH = fc4Var.h(4);
        float f = 1.0f;
        if (iH == 15) {
            int iH2 = fc4Var.h(8);
            int iH3 = fc4Var.h(8);
            if (iH3 == 0) {
                y53.i("H263Reader", "Invalid aspect ratio");
            } else {
                f = iH2 / iH3;
            }
        } else {
            float[] fArr = l;
            if (iH < fArr.length) {
                f = fArr[iH];
            } else {
                y53.i("H263Reader", "Invalid aspect ratio");
            }
        }
        if (fc4Var.g()) {
            fc4Var.r(2);
            fc4Var.r(1);
            if (fc4Var.g()) {
                fc4Var.r(15);
                fc4Var.q();
                fc4Var.r(15);
                fc4Var.q();
                fc4Var.r(15);
                fc4Var.q();
                fc4Var.r(3);
                fc4Var.r(11);
                fc4Var.q();
                fc4Var.r(15);
                fc4Var.q();
            }
        }
        if (fc4Var.h(2) != 0) {
            y53.i("H263Reader", "Unhandled video object layer shape");
        }
        fc4Var.q();
        int iH4 = fc4Var.h(16);
        fc4Var.q();
        if (fc4Var.g()) {
            if (iH4 == 0) {
                y53.i("H263Reader", "Invalid vop_increment_time_resolution");
            } else {
                int i2 = 0;
                for (int i3 = iH4 - 1; i3 > 0; i3 >>= 1) {
                    i2++;
                }
                fc4Var.r(i2);
            }
        }
        fc4Var.q();
        int iH5 = fc4Var.h(13);
        fc4Var.q();
        int iH6 = fc4Var.h(13);
        fc4Var.q();
        fc4Var.q();
        return new m.b().U(str).g0("video/mp4v-es").n0(iH5).S(iH6).c0(f).V(Collections.singletonList(bArrCopyOf)).G();
    }

    @Override // defpackage.gl1
    public void a(gc4 gc4Var) {
        vh.i(this.f);
        vh.i(this.i);
        int iF = gc4Var.f();
        int iG = gc4Var.g();
        byte[] bArrE = gc4Var.e();
        this.g += (long) gc4Var.a();
        this.i.d(gc4Var, gc4Var.a());
        while (true) {
            int iC = ot3.c(bArrE, iF, iG, this.c);
            if (iC == iG) {
                break;
            }
            int i = iC + 3;
            int i2 = gc4Var.e()[i] & UByte.MAX_VALUE;
            int i3 = iC - iF;
            int i4 = 0;
            if (!this.j) {
                if (i3 > 0) {
                    this.d.a(bArrE, iF, iC);
                }
                if (this.d.b(i2, i3 < 0 ? -i3 : 0)) {
                    c06 c06Var = this.i;
                    a aVar = this.d;
                    c06Var.b(c(aVar, aVar.d, (String) vh.e(this.h)));
                    this.j = true;
                }
            }
            this.f.a(bArrE, iF, iC);
            nt3 nt3Var = this.e;
            if (nt3Var != null) {
                if (i3 > 0) {
                    nt3Var.a(bArrE, iF, iC);
                } else {
                    i4 = -i3;
                }
                if (this.e.b(i4)) {
                    nt3 nt3Var2 = this.e;
                    ((gc4) g86.j(this.b)).S(this.e.d, ot3.q(nt3Var2.d, nt3Var2.e));
                    ((f66) g86.j(this.f18677a)).a(this.k, this.b);
                }
                if (i2 == 178 && gc4Var.e()[iC + 2] == 1) {
                    this.e.e(i2);
                }
            }
            int i5 = iG - iC;
            this.f.b(this.g - ((long) i5), i5, this.j);
            this.f.c(i2, this.k);
            iF = i;
        }
        if (!this.j) {
            this.d.a(bArrE, iF, iG);
        }
        this.f.a(bArrE, iF, iG);
        nt3 nt3Var3 = this.e;
        if (nt3Var3 != null) {
            nt3Var3.a(bArrE, iF, iG);
        }
    }

    @Override // defpackage.gl1
    public void b(qs1 qs1Var, j26.d dVar) {
        dVar.a();
        this.h = dVar.b();
        c06 c06VarTrack = qs1Var.track(dVar.c(), 2);
        this.i = c06VarTrack;
        this.f = new b(c06VarTrack);
        f66 f66Var = this.f18677a;
        if (f66Var != null) {
            f66Var.b(qs1Var, dVar);
        }
    }

    @Override // defpackage.gl1
    public void packetStarted(long j, int i) {
        if (j != -9223372036854775807L) {
            this.k = j;
        }
    }

    @Override // defpackage.gl1
    public void seek() {
        ot3.a(this.c);
        this.d.c();
        b bVar = this.f;
        if (bVar != null) {
            bVar.d();
        }
        nt3 nt3Var = this.e;
        if (nt3Var != null) {
            nt3Var.d();
        }
        this.g = 0L;
        this.k = -9223372036854775807L;
    }

    @Override // defpackage.gl1
    public void packetFinished() {
    }
}
