package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.uc.crashsdk.export.LogType;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class px1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20125a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final long j;

    @Nullable
    public final a k;

    @Nullable
    public final Metadata l;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f20126a;
        public final long[] b;

        public a(long[] jArr, long[] jArr2) {
            this.f20126a = jArr;
            this.b = jArr2;
        }
    }

    public px1(byte[] bArr, int i) {
        fc4 fc4Var = new fc4(bArr);
        fc4Var.p(i * 8);
        this.f20125a = fc4Var.h(16);
        this.b = fc4Var.h(16);
        this.c = fc4Var.h(24);
        this.d = fc4Var.h(24);
        int iH = fc4Var.h(20);
        this.e = iH;
        this.f = j(iH);
        this.g = fc4Var.h(3) + 1;
        int iH2 = fc4Var.h(5) + 1;
        this.h = iH2;
        this.i = e(iH2);
        this.j = fc4Var.j(36);
        this.k = null;
        this.l = null;
    }

    public static int e(int i) {
        if (i == 8) {
            return 1;
        }
        if (i == 12) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i != 20) {
            return i != 24 ? -1 : 6;
        }
        return 5;
    }

    public static int j(int i) {
        switch (i) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case ErrorCode.REASON_HLS_PLAYLIST_RESET /* 24000 */:
                return 7;
            case LogType.UNEXP_KNOWN_REASON /* 32000 */:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public px1 a(List<PictureFrame> list) {
        return new px1(this.f20125a, this.b, this.c, this.d, this.e, this.g, this.h, this.j, this.k, h(new Metadata(list)));
    }

    public px1 b(@Nullable a aVar) {
        return new px1(this.f20125a, this.b, this.c, this.d, this.e, this.g, this.h, this.j, aVar, this.l);
    }

    public px1 c(List<String> list) {
        return new px1(this.f20125a, this.b, this.c, this.d, this.e, this.g, this.h, this.j, this.k, h(wh6.c(list)));
    }

    public long d() {
        long j;
        long j2;
        int i = this.d;
        if (i > 0) {
            j = (((long) i) + ((long) this.c)) / 2;
            j2 = 1;
        } else {
            int i2 = this.f20125a;
            j = ((((i2 != this.b || i2 <= 0) ? 4096L : i2) * ((long) this.g)) * ((long) this.h)) / 8;
            j2 = 64;
        }
        return j + j2;
    }

    public long f() {
        long j = this.j;
        if (j == 0) {
            return -9223372036854775807L;
        }
        return (j * 1000000) / ((long) this.e);
    }

    public m g(byte[] bArr, @Nullable Metadata metadata) {
        bArr[4] = ByteCompanionObject.MIN_VALUE;
        int i = this.d;
        if (i <= 0) {
            i = -1;
        }
        return new m.b().g0("audio/flac").Y(i).J(this.g).h0(this.e).V(Collections.singletonList(bArr)).Z(h(metadata)).G();
    }

    @Nullable
    public Metadata h(@Nullable Metadata metadata) {
        Metadata metadata2 = this.l;
        return metadata2 == null ? metadata : metadata2.copyWithAppendedEntriesFrom(metadata);
    }

    public long i(long j) {
        return g86.r((j * ((long) this.e)) / 1000000, 0L, this.j - 1);
    }

    public px1(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, @Nullable a aVar, @Nullable Metadata metadata) {
        this.f20125a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = j(i5);
        this.g = i6;
        this.h = i7;
        this.i = e(i7);
        this.j = j;
        this.k = aVar;
        this.l = metadata;
    }
}
