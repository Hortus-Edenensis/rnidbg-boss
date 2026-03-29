package defpackage;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.google.android.exoplayer2.ParserException;
import defpackage.j26;
import defpackage.v45;
import java.io.IOException;
import java.util.Map;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class wo4 implements os1 {
    public static final ys1 l = new ys1() { // from class: to4
        @Override // defpackage.ys1
        public final os1[] createExtractors() {
            return wo4.e();
        }

        @Override // defpackage.ys1
        public /* synthetic */ os1[] createExtractors(Uri uri, Map map) {
            return vs1.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jy5 f21764a;
    public final SparseArray<a> b;
    public final gc4 c;
    public final so4 d;
    public boolean e;
    public boolean f;
    public boolean g;
    public long h;

    @Nullable
    public ro4 i;
    public qs1 j;
    public boolean k;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final gl1 f21765a;
        public final jy5 b;
        public final fc4 c = new fc4(new byte[64]);
        public boolean d;
        public boolean e;
        public boolean f;
        public int g;
        public long h;

        public a(gl1 gl1Var, jy5 jy5Var) {
            this.f21765a = gl1Var;
            this.b = jy5Var;
        }

        public void a(gc4 gc4Var) throws ParserException {
            gc4Var.l(this.c.f17507a, 0, 3);
            this.c.p(0);
            b();
            gc4Var.l(this.c.f17507a, 0, this.g);
            this.c.p(0);
            c();
            this.f21765a.packetStarted(this.h, 4);
            this.f21765a.a(gc4Var);
            this.f21765a.packetFinished();
        }

        public final void b() {
            this.c.r(8);
            this.d = this.c.g();
            this.e = this.c.g();
            this.c.r(6);
            this.g = this.c.h(8);
        }

        public final void c() {
            this.h = 0L;
            if (this.d) {
                this.c.r(4);
                long jH = ((long) this.c.h(3)) << 30;
                this.c.r(1);
                long jH2 = jH | ((long) (this.c.h(15) << 15));
                this.c.r(1);
                long jH3 = jH2 | ((long) this.c.h(15));
                this.c.r(1);
                if (!this.f && this.e) {
                    this.c.r(4);
                    long jH4 = ((long) this.c.h(3)) << 30;
                    this.c.r(1);
                    long jH5 = jH4 | ((long) (this.c.h(15) << 15));
                    this.c.r(1);
                    long jH6 = jH5 | ((long) this.c.h(15));
                    this.c.r(1);
                    this.b.b(jH6);
                    this.f = true;
                }
                this.h = this.b.b(jH3);
            }
        }

        public void d() {
            this.f = false;
            this.f21765a.seek();
        }
    }

    public wo4() {
        this(new jy5(0L));
    }

    public static /* synthetic */ os1[] e() {
        return new os1[]{new wo4()};
    }

    @Override // defpackage.os1
    public void b(qs1 qs1Var) {
        this.j = qs1Var;
    }

    @Override // defpackage.os1
    public int c(ps1 ps1Var, vk4 vk4Var) throws IOException {
        gl1 jf2Var;
        vh.i(this.j);
        long length = ps1Var.getLength();
        if ((length != -1) && !this.d.e()) {
            return this.d.g(ps1Var, vk4Var);
        }
        f(length);
        ro4 ro4Var = this.i;
        if (ro4Var != null && ro4Var.d()) {
            return this.i.c(ps1Var, vk4Var);
        }
        ps1Var.resetPeekPosition();
        long peekPosition = length != -1 ? length - ps1Var.getPeekPosition() : -1L;
        if ((peekPosition != -1 && peekPosition < 4) || !ps1Var.peekFully(this.c.e(), 0, 4, true)) {
            return -1;
        }
        this.c.U(0);
        int iQ = this.c.q();
        if (iQ == 441) {
            return -1;
        }
        if (iQ == 442) {
            ps1Var.peekFully(this.c.e(), 0, 10);
            this.c.U(9);
            ps1Var.skipFully((this.c.H() & 7) + 14);
            return 0;
        }
        if (iQ == 443) {
            ps1Var.peekFully(this.c.e(), 0, 2);
            this.c.U(0);
            ps1Var.skipFully(this.c.N() + 6);
            return 0;
        }
        if (((iQ & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
            ps1Var.skipFully(1);
            return 0;
        }
        int i = iQ & 255;
        a aVar = this.b.get(i);
        if (!this.e) {
            if (aVar == null) {
                if (i == 189) {
                    jf2Var = new g2();
                    this.f = true;
                    this.h = ps1Var.getPosition();
                } else if ((i & 224) == 192) {
                    jf2Var = new zr3();
                    this.f = true;
                    this.h = ps1Var.getPosition();
                } else if ((i & 240) == 224) {
                    jf2Var = new jf2();
                    this.g = true;
                    this.h = ps1Var.getPosition();
                } else {
                    jf2Var = null;
                }
                if (jf2Var != null) {
                    jf2Var.b(this.j, new j26.d(i, 256));
                    aVar = new a(jf2Var, this.f21764a);
                    this.b.put(i, aVar);
                }
            }
            if (ps1Var.getPosition() > ((this.f && this.g) ? this.h + PlaybackStateCompat.ACTION_PLAY_FROM_URI : 1048576L)) {
                this.e = true;
                this.j.endTracks();
            }
        }
        ps1Var.peekFully(this.c.e(), 0, 2);
        this.c.U(0);
        int iN = this.c.N() + 6;
        if (aVar == null) {
            ps1Var.skipFully(iN);
        } else {
            this.c.Q(iN);
            ps1Var.readFully(this.c.e(), 0, iN);
            this.c.U(6);
            aVar.a(this.c);
            gc4 gc4Var = this.c;
            gc4Var.T(gc4Var.b());
        }
        return 0;
    }

    @Override // defpackage.os1
    public boolean d(ps1 ps1Var) throws IOException {
        byte[] bArr = new byte[14];
        ps1Var.peekFully(bArr, 0, 14);
        if (442 != (((bArr[0] & UByte.MAX_VALUE) << 24) | ((bArr[1] & UByte.MAX_VALUE) << 16) | ((bArr[2] & UByte.MAX_VALUE) << 8) | (bArr[3] & UByte.MAX_VALUE)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        ps1Var.advancePeekPosition(bArr[13] & 7);
        ps1Var.peekFully(bArr, 0, 3);
        return 1 == ((((bArr[0] & UByte.MAX_VALUE) << 16) | ((bArr[1] & UByte.MAX_VALUE) << 8)) | (bArr[2] & UByte.MAX_VALUE));
    }

    public final void f(long j) {
        if (this.k) {
            return;
        }
        this.k = true;
        if (this.d.c() == -9223372036854775807L) {
            this.j.d(new v45.b(this.d.c()));
            return;
        }
        ro4 ro4Var = new ro4(this.d.d(), this.d.c(), j);
        this.i = ro4Var;
        this.j.d(ro4Var.b());
    }

    @Override // defpackage.os1
    public void seek(long j, long j2) {
        boolean z = this.f21764a.e() == -9223372036854775807L;
        if (!z) {
            long jC = this.f21764a.c();
            z = (jC == -9223372036854775807L || jC == 0 || jC == j2) ? false : true;
        }
        if (z) {
            this.f21764a.h(j2);
        }
        ro4 ro4Var = this.i;
        if (ro4Var != null) {
            ro4Var.h(j2);
        }
        for (int i = 0; i < this.b.size(); i++) {
            this.b.valueAt(i).d();
        }
    }

    public wo4(jy5 jy5Var) {
        this.f21764a = jy5Var;
        this.c = new gc4(4096);
        this.b = new SparseArray<>();
        this.d = new so4();
    }

    @Override // defpackage.os1
    public void release() {
    }
}
