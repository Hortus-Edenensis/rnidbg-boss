package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import defpackage.v45;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ry2 implements os1 {
    public qs1 b;
    public int c;
    public int d;
    public int e;

    @Nullable
    public MotionPhotoMetadata g;
    public ps1 h;
    public jk5 i;

    @Nullable
    public wr3 j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gc4 f20622a = new gc4(6);
    public long f = -1;

    @Nullable
    public static MotionPhotoMetadata f(String str, long j) throws IOException {
        gr3 gr3VarA;
        if (j == -1 || (gr3VarA = dp6.a(str)) == null) {
            return null;
        }
        return gr3VarA.a(j);
    }

    public final void a(ps1 ps1Var) throws IOException {
        this.f20622a.Q(2);
        ps1Var.peekFully(this.f20622a.e(), 0, 2);
        ps1Var.advancePeekPosition(this.f20622a.N() - 2);
    }

    @Override // defpackage.os1
    public void b(qs1 qs1Var) {
        this.b = qs1Var;
    }

    @Override // defpackage.os1
    public int c(ps1 ps1Var, vk4 vk4Var) throws IOException {
        int i = this.c;
        if (i == 0) {
            i(ps1Var);
            return 0;
        }
        if (i == 1) {
            k(ps1Var);
            return 0;
        }
        if (i == 2) {
            j(ps1Var);
            return 0;
        }
        if (i == 4) {
            long position = ps1Var.getPosition();
            long j = this.f;
            if (position != j) {
                vk4Var.f21468a = j;
                return 1;
            }
            l(ps1Var);
            return 0;
        }
        if (i != 5) {
            if (i == 6) {
                return -1;
            }
            throw new IllegalStateException();
        }
        if (this.i == null || ps1Var != this.h) {
            this.h = ps1Var;
            this.i = new jk5(ps1Var, this.f);
        }
        int iC = ((wr3) vh.e(this.j)).c(this.i, vk4Var);
        if (iC == 1) {
            vk4Var.f21468a += this.f;
        }
        return iC;
    }

    @Override // defpackage.os1
    public boolean d(ps1 ps1Var) throws IOException {
        if (h(ps1Var) != 65496) {
            return false;
        }
        int iH = h(ps1Var);
        this.d = iH;
        if (iH == 65504) {
            a(ps1Var);
            this.d = h(ps1Var);
        }
        if (this.d != 65505) {
            return false;
        }
        ps1Var.advancePeekPosition(2);
        this.f20622a.Q(6);
        ps1Var.peekFully(this.f20622a.e(), 0, 6);
        return this.f20622a.J() == 1165519206 && this.f20622a.N() == 0;
    }

    public final void e() {
        g(new Metadata.Entry[0]);
        ((qs1) vh.e(this.b)).endTracks();
        this.b.d(new v45.b(-9223372036854775807L));
        this.c = 6;
    }

    public final void g(Metadata.Entry... entryArr) {
        ((qs1) vh.e(this.b)).track(1024, 4).b(new m.b().M("image/jpeg").Z(new Metadata(entryArr)).G());
    }

    public final int h(ps1 ps1Var) throws IOException {
        this.f20622a.Q(2);
        ps1Var.peekFully(this.f20622a.e(), 0, 2);
        return this.f20622a.N();
    }

    public final void i(ps1 ps1Var) throws IOException {
        this.f20622a.Q(2);
        ps1Var.readFully(this.f20622a.e(), 0, 2);
        int iN = this.f20622a.N();
        this.d = iN;
        if (iN == 65498) {
            if (this.f != -1) {
                this.c = 4;
                return;
            } else {
                e();
                return;
            }
        }
        if ((iN < 65488 || iN > 65497) && iN != 65281) {
            this.c = 1;
        }
    }

    public final void j(ps1 ps1Var) throws IOException {
        String strB;
        if (this.d == 65505) {
            gc4 gc4Var = new gc4(this.e);
            ps1Var.readFully(gc4Var.e(), 0, this.e);
            if (this.g == null && "http://ns.adobe.com/xap/1.0/".equals(gc4Var.B()) && (strB = gc4Var.B()) != null) {
                MotionPhotoMetadata motionPhotoMetadataF = f(strB, ps1Var.getLength());
                this.g = motionPhotoMetadataF;
                if (motionPhotoMetadataF != null) {
                    this.f = motionPhotoMetadataF.videoStartPosition;
                }
            }
        } else {
            ps1Var.skipFully(this.e);
        }
        this.c = 0;
    }

    public final void k(ps1 ps1Var) throws IOException {
        this.f20622a.Q(2);
        ps1Var.readFully(this.f20622a.e(), 0, 2);
        this.e = this.f20622a.N() - 2;
        this.c = 2;
    }

    public final void l(ps1 ps1Var) throws IOException {
        if (!ps1Var.peekFully(this.f20622a.e(), 0, 1, true)) {
            e();
            return;
        }
        ps1Var.resetPeekPosition();
        if (this.j == null) {
            this.j = new wr3();
        }
        jk5 jk5Var = new jk5(ps1Var, this.f);
        this.i = jk5Var;
        if (!this.j.d(jk5Var)) {
            e();
        } else {
            this.j.b(new kk5(this.f, (qs1) vh.e(this.b)));
            m();
        }
    }

    public final void m() {
        g((Metadata.Entry) vh.e(this.g));
        this.c = 5;
    }

    @Override // defpackage.os1
    public void release() {
        wr3 wr3Var = this.j;
        if (wr3Var != null) {
            wr3Var.release();
        }
    }

    @Override // defpackage.os1
    public void seek(long j, long j2) {
        if (j == 0) {
            this.c = 0;
            this.j = null;
        } else if (this.c == 5) {
            ((wr3) vh.e(this.j)).seek(j, j2);
        }
    }
}
