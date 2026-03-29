package defpackage;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.hls.SampleQueueMappingException;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class gi2 implements d25 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17730a;
    public final ki2 b;
    public int c = -1;

    public gi2(ki2 ki2Var, int i) {
        this.b = ki2Var;
        this.f17730a = i;
    }

    public void a() {
        vh.a(this.c == -1);
        this.c = this.b.l(this.f17730a);
    }

    public final boolean b() {
        int i = this.c;
        return (i == -1 || i == -3 || i == -2) ? false : true;
    }

    @Override // defpackage.d25
    public int c(f12 f12Var, DecoderInputBuffer decoderInputBuffer, int i) {
        if (this.c == -3) {
            decoderInputBuffer.a(4);
            return -4;
        }
        if (b()) {
            return this.b.R(this.c, f12Var, decoderInputBuffer, i);
        }
        return -3;
    }

    public void d() {
        if (this.c != -1) {
            this.b.c0(this.f17730a);
            this.c = -1;
        }
    }

    @Override // defpackage.d25
    public boolean isReady() {
        return this.c == -3 || (b() && this.b.D(this.c));
    }

    @Override // defpackage.d25
    public void maybeThrowError() throws IOException {
        int i = this.c;
        if (i == -2) {
            throw new SampleQueueMappingException(this.b.getTrackGroups().b(this.f17730a).c(0).l);
        }
        if (i == -1) {
            this.b.H();
        } else if (i != -3) {
            this.b.I(i);
        }
    }

    @Override // defpackage.d25
    public int skipData(long j) {
        if (b()) {
            return this.b.b0(this.c, j);
        }
        return 0;
    }
}
