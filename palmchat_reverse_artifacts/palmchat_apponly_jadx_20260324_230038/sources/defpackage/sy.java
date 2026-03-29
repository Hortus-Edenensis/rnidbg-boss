package defpackage;

import androidx.annotation.Nullable;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.m;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class sy extends e {
    public final DecoderInputBuffer p;
    public final gc4 q;
    public long r;

    @Nullable
    public ry s;
    public long t;

    public sy() {
        super(6);
        this.p = new DecoderInputBuffer(1);
        this.q = new gc4();
    }

    @Nullable
    public final float[] A(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.q.S(byteBuffer.array(), byteBuffer.limit());
        this.q.U(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i = 0; i < 3; i++) {
            fArr[i] = Float.intBitsToFloat(this.q.u());
        }
        return fArr;
    }

    public final void B() {
        ry ryVar = this.s;
        if (ryVar != null) {
            ryVar.onCameraMotionReset();
        }
    }

    @Override // com.google.android.exoplayer2.a0
    public int a(m mVar) {
        return "application/x-camera-motion".equals(mVar.l) ? qv4.a(4) : qv4.a(0);
    }

    @Override // com.google.android.exoplayer2.z, com.google.android.exoplayer2.a0
    public String getName() {
        return "CameraMotionRenderer";
    }

    @Override // com.google.android.exoplayer2.e, com.google.android.exoplayer2.w.b
    public void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 8) {
            this.s = (ry) obj;
        } else {
            super.handleMessage(i, obj);
        }
    }

    @Override // com.google.android.exoplayer2.z
    public boolean isEnded() {
        return hasReadStreamToEnd();
    }

    @Override // com.google.android.exoplayer2.z
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.e
    public void o() {
        B();
    }

    @Override // com.google.android.exoplayer2.e
    public void q(long j, boolean z) {
        this.t = Long.MIN_VALUE;
        B();
    }

    @Override // com.google.android.exoplayer2.z
    public void render(long j, long j2) {
        while (!hasReadStreamToEnd() && this.t < SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US + j) {
            this.p.b();
            if (x(j(), this.p, 0) != -4 || this.p.g()) {
                return;
            }
            DecoderInputBuffer decoderInputBuffer = this.p;
            this.t = decoderInputBuffer.e;
            if (this.s != null && !decoderInputBuffer.f()) {
                this.p.n();
                float[] fArrA = A((ByteBuffer) g86.j(this.p.c));
                if (fArrA != null) {
                    ((ry) g86.j(this.s)).onCameraMotion(this.t - this.r, fArrA);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.e
    public void w(m[] mVarArr, long j, long j2) {
        this.r = j2;
    }
}
