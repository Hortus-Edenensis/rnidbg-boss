package com.google.android.exoplayer2.audio;

import androidx.media3.extractor.OpusUtil;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import defpackage.g86;
import defpackage.ku2;
import defpackage.ot2;
import java.math.RoundingMode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class h implements DefaultAudioSink.e {
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5840a = 250000;
        public int b = 750000;
        public int c = 4;
        public int d = 250000;
        public int e = 50000000;
        public int f = 2;

        public h g() {
            return new h(this);
        }
    }

    public h(a aVar) {
        this.b = aVar.f5840a;
        this.c = aVar.b;
        this.d = aVar.c;
        this.e = aVar.d;
        this.f = aVar.e;
        this.g = aVar.f;
    }

    public static int a(int i, int i2, int i3) {
        return ku2.e(((((long) i) * ((long) i2)) * ((long) i3)) / 1000000);
    }

    public static int c(int i) {
        switch (i) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 13:
            case 19:
            default:
                throw new IllegalArgumentException();
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case 16:
                return 256000;
            case 17:
                return 336000;
            case 20:
                return OpusUtil.MAX_BYTES_PER_SECOND;
        }
    }

    public int b(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i3 == 0) {
            return f(i, i5, i4);
        }
        if (i3 == 1) {
            return d(i2);
        }
        if (i3 == 2) {
            return e(i2, i6);
        }
        throw new IllegalArgumentException();
    }

    public int d(int i) {
        return ku2.e((((long) this.f) * ((long) c(i))) / 1000000);
    }

    public int e(int i, int i2) {
        int i3 = this.e;
        if (i == 5) {
            i3 *= this.g;
        }
        return ku2.e((((long) i3) * ((long) (i2 != -1 ? ot2.b(i2, 8, RoundingMode.CEILING) : c(i)))) / 1000000);
    }

    public int f(int i, int i2, int i3) {
        return g86.q(i * this.d, a(this.b, i2, i3), a(this.c, i2, i3));
    }

    @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.e
    public int getBufferSizeInBytes(int i, int i2, int i3, int i4, int i5, int i6, double d) {
        return (((Math.max(i, (int) (((double) b(i, i2, i3, i4, i5, i6)) * d)) + i4) - 1) / i4) * i4;
    }
}
