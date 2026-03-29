package com.opos.exoplayer.core.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.oplus.tblplayer.misc.IMediaFormat;
import com.opos.exoplayer.core.ExoPlaybackException;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.a.e;
import com.opos.exoplayer.core.a.f;
import com.opos.exoplayer.core.decoder.DecoderInputBuffer;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.util.y;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@TargetApi(16)
public class i extends com.opos.exoplayer.core.b.b implements com.opos.exoplayer.core.util.l {
    private final e.a b;
    private final f c;
    private boolean d;
    private boolean e;
    private MediaFormat f;
    private int g;
    private int h;
    private int i;
    private int j;
    private long k;
    private boolean l;
    private boolean m;

    /* JADX INFO: compiled from: SearchBox */
    public final class b implements f.c {
        private b() {
        }

        @Override // com.opos.exoplayer.core.a.f.c
        public void a() {
            i.this.v();
            i.this.m = true;
        }

        @Override // com.opos.exoplayer.core.a.f.c
        public void a(int i) {
            i.this.b.a(i);
            i.this.b(i);
        }

        @Override // com.opos.exoplayer.core.a.f.c
        public void a(int i, long j, long j2) {
            i.this.b.a(i, j, j2);
            i.this.a(i, j, j2);
        }
    }

    public i(com.opos.exoplayer.core.b.c cVar, @Nullable com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.e> bVar, boolean z, @Nullable Handler handler, @Nullable e eVar, @Nullable c cVar2, d... dVarArr) {
        this(cVar, bVar, z, handler, eVar, new g(cVar2, dVarArr));
    }

    private void D() {
        long jA = this.c.a(u());
        if (jA != Long.MIN_VALUE) {
            if (!this.m) {
                jA = Math.max(this.k, jA);
            }
            this.k = jA;
            this.m = false;
        }
    }

    @Override // com.opos.exoplayer.core.b.b
    public int a(com.opos.exoplayer.core.b.c cVar, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.e> bVar, Format format) {
        boolean z;
        int i;
        int i2;
        String str = format.f;
        boolean z2 = false;
        if (!com.opos.exoplayer.core.util.m.a(str)) {
            return 0;
        }
        int i3 = y.f8407a >= 21 ? 32 : 0;
        boolean zA = com.opos.exoplayer.core.a.a(bVar, format.i);
        if (zA && a(str) && cVar.a() != null) {
            return i3 | 8 | 4;
        }
        if (("audio/raw".equals(str) && !this.c.a(format.t)) || !this.c.a(2)) {
            return 1;
        }
        DrmInitData drmInitData = format.i;
        if (drmInitData != null) {
            z = false;
            for (int i4 = 0; i4 < drmInitData.b; i4++) {
                z |= drmInitData.a(i4).c;
            }
        } else {
            z = false;
        }
        com.opos.exoplayer.core.b.a aVarA = cVar.a(str, z);
        if (aVarA == null) {
            return (!z || cVar.a(str, false) == null) ? 1 : 2;
        }
        if (!zA) {
            return 2;
        }
        if (y.f8407a < 21 || (((i = format.s) == -1 || aVarA.a(i)) && ((i2 = format.r) == -1 || aVarA.b(i2)))) {
            z2 = true;
        }
        return i3 | 8 | (z2 ? 4 : 3);
    }

    public void b(int i) {
    }

    @Override // com.opos.exoplayer.core.util.l
    public long d() {
        if (a_() == 2) {
            D();
        }
        return this.k;
    }

    @Override // com.opos.exoplayer.core.util.l
    public com.opos.exoplayer.core.n e() {
        return this.c.f();
    }

    @Override // com.opos.exoplayer.core.b.b, com.opos.exoplayer.core.a
    public void n() {
        super.n();
        this.c.a();
    }

    @Override // com.opos.exoplayer.core.b.b, com.opos.exoplayer.core.a
    public void o() {
        this.c.h();
        D();
        super.o();
    }

    @Override // com.opos.exoplayer.core.b.b, com.opos.exoplayer.core.a
    public void p() {
        try {
            this.c.j();
            try {
                super.p();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.p();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.opos.exoplayer.core.b.b, com.opos.exoplayer.core.q
    public boolean t() {
        return this.c.e() || super.t();
    }

    @Override // com.opos.exoplayer.core.b.b, com.opos.exoplayer.core.q
    public boolean u() {
        return super.u() && this.c.d();
    }

    @Override // com.opos.exoplayer.core.b.b
    public void w() throws ExoPlaybackException {
        try {
            this.c.c();
        } catch (f.d e) {
            String strA = y.a(e);
            ExoPlaybackException exoPlaybackExceptionA = ExoPlaybackException.a(e, r());
            exoPlaybackExceptionA.a(strA);
            throw exoPlaybackExceptionA;
        }
    }

    public i(com.opos.exoplayer.core.b.c cVar, @Nullable com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.e> bVar, boolean z, @Nullable Handler handler, @Nullable e eVar, f fVar) {
        super(1, cVar, bVar, z);
        this.b = new e.a(handler, eVar);
        this.c = fVar;
        fVar.a(new b());
    }

    @Override // com.opos.exoplayer.core.b.b
    public void b(Format format) {
        super.b(format);
        this.b.a(format);
        this.g = "audio/raw".equals(format.f) ? format.t : 2;
        this.h = format.r;
        int i = format.u;
        if (i == -1) {
            i = 0;
        }
        this.i = i;
        int i2 = format.v;
        this.j = i2 != -1 ? i2 : 0;
    }

    private static boolean b(String str) {
        if (y.f8407a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(y.c)) {
            String str2 = y.b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    @Override // com.opos.exoplayer.core.b.b
    public com.opos.exoplayer.core.b.a a(com.opos.exoplayer.core.b.c cVar, Format format, boolean z) {
        com.opos.exoplayer.core.b.a aVarA;
        if (!a(format.f) || (aVarA = cVar.a()) == null) {
            this.d = false;
            return super.a(cVar, format, z);
        }
        this.d = true;
        return aVarA;
    }

    @Override // com.opos.exoplayer.core.util.l
    public com.opos.exoplayer.core.n a(com.opos.exoplayer.core.n nVar) {
        return this.c.a(nVar);
    }

    public void a(int i, long j, long j2) {
    }

    @Override // com.opos.exoplayer.core.a, com.opos.exoplayer.core.o.b
    public void a(int i, Object obj) {
        if (i == 2) {
            this.c.a(((Float) obj).floatValue());
        } else if (i != 3) {
            super.a(i, obj);
        } else {
            this.c.a((com.opos.exoplayer.core.a.b) obj);
        }
    }

    @Override // com.opos.exoplayer.core.b.b, com.opos.exoplayer.core.q
    public void a(long j, long j2) throws ExoPlaybackException {
        try {
            super.a(j, j2);
        } catch (Exception e) {
            throw ExoPlaybackException.b(e, 0);
        }
    }

    @Override // com.opos.exoplayer.core.b.b, com.opos.exoplayer.core.a
    public void a(long j, boolean z) {
        super.a(j, z);
        this.c.i();
        this.k = j;
        this.l = true;
        this.m = true;
    }

    @Override // com.opos.exoplayer.core.b.b
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
        int iF;
        int[] iArr;
        int i;
        MediaFormat mediaFormat2 = this.f;
        if (mediaFormat2 != null) {
            iF = com.opos.exoplayer.core.util.m.f(mediaFormat2.getString(IMediaFormat.KEY_MIME));
            mediaFormat = this.f;
        } else {
            iF = this.g;
        }
        int i2 = iF;
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.e && integer == 6 && (i = this.h) < 6) {
            iArr = new int[i];
            for (int i3 = 0; i3 < this.h; i3++) {
                iArr[i3] = i3;
            }
        } else {
            iArr = null;
        }
        try {
            this.c.a(i2, integer, integer2, 0, iArr, this.i, this.j);
        } catch (f.a e) {
            String strA = y.a(e);
            ExoPlaybackException exoPlaybackExceptionA = ExoPlaybackException.a(e, r());
            exoPlaybackExceptionA.a(strA);
            throw exoPlaybackExceptionA;
        }
    }

    @Override // com.opos.exoplayer.core.b.b
    public void a(com.opos.exoplayer.core.b.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        this.e = b(aVar.f8111a);
        MediaFormat mediaFormatC = c(format);
        if (!this.d) {
            mediaCodec.configure(mediaFormatC, (Surface) null, mediaCrypto, 0);
            this.f = null;
        } else {
            this.f = mediaFormatC;
            mediaFormatC.setString(IMediaFormat.KEY_MIME, "audio/raw");
            mediaCodec.configure(this.f, (Surface) null, mediaCrypto, 0);
            this.f.setString(IMediaFormat.KEY_MIME, format.f);
        }
    }

    @Override // com.opos.exoplayer.core.b.b
    public void a(DecoderInputBuffer decoderInputBuffer) {
        if (!this.l || decoderInputBuffer.d_()) {
            return;
        }
        if (Math.abs(decoderInputBuffer.c - this.k) > 500000) {
            this.k = decoderInputBuffer.c;
        }
        this.l = false;
    }

    @Override // com.opos.exoplayer.core.b.b
    public void a(String str, long j, long j2) {
        this.b.a(str, j, j2);
    }

    @Override // com.opos.exoplayer.core.b.b, com.opos.exoplayer.core.a
    public void a(boolean z) {
        super.a(z);
        this.b.a(((com.opos.exoplayer.core.b.b) this).f8112a);
        int i = q().b;
        if (i != 0) {
            this.c.b(i);
        } else {
            this.c.g();
        }
    }

    @Override // com.opos.exoplayer.core.b.b
    public boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException {
        if (this.d && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        }
        if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            ((com.opos.exoplayer.core.b.b) this).f8112a.f++;
            this.c.b();
            return true;
        }
        try {
            if (!this.c.a(byteBuffer, j3)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i, false);
            ((com.opos.exoplayer.core.b.b) this).f8112a.e++;
            return true;
        } catch (f.b | f.d e) {
            String strA = y.a(e);
            ExoPlaybackException exoPlaybackExceptionA = ExoPlaybackException.a(e, r());
            exoPlaybackExceptionA.a(strA);
            throw exoPlaybackExceptionA;
        }
    }

    public boolean a(String str) {
        int iF = com.opos.exoplayer.core.util.m.f(str);
        return iF != 0 && this.c.a(iF);
    }

    @Override // com.opos.exoplayer.core.a, com.opos.exoplayer.core.q
    public com.opos.exoplayer.core.util.l c() {
        return this;
    }

    public void v() {
    }
}
