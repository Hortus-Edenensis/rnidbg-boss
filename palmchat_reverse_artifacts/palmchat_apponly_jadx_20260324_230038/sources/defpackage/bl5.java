package defpackage;

import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.avi.AviExtractor;
import com.google.android.exoplayer2.m;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class bl5 implements fn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f1748a;

    public bl5(m mVar) {
        this.f1748a = mVar;
    }

    @Nullable
    public static String a(int i) {
        switch (i) {
            case 808802372:
            case 877677894:
            case 1145656883:
            case 1145656920:
            case 1482049860:
            case 1684633208:
            case 2021026148:
                return "video/mp4v-es";
            case 826496577:
            case 828601953:
            case 875967048:
                return "video/avc";
            case 842289229:
                return MimeTypes.VIDEO_MP42;
            case 859066445:
                return MimeTypes.VIDEO_MP43;
            case 1196444237:
            case 1735420525:
                return MimeTypes.VIDEO_MJPEG;
            default:
                return null;
        }
    }

    @Nullable
    public static String b(int i) {
        if (i == 1) {
            return "audio/raw";
        }
        if (i == 85) {
            return "audio/mpeg";
        }
        if (i == 255) {
            return "audio/mp4a-latm";
        }
        if (i == 8192) {
            return "audio/ac3";
        }
        if (i != 8193) {
            return null;
        }
        return "audio/vnd.dts";
    }

    @Nullable
    public static fn c(gc4 gc4Var) {
        gc4Var.V(4);
        int iU = gc4Var.u();
        int iU2 = gc4Var.u();
        gc4Var.V(4);
        int iU3 = gc4Var.u();
        String strA = a(iU3);
        if (strA != null) {
            m.b bVar = new m.b();
            bVar.n0(iU).S(iU2).g0(strA);
            return new bl5(bVar.G());
        }
        y53.i("StreamFormatChunk", "Ignoring track with unsupported compression " + iU3);
        return null;
    }

    @Nullable
    public static fn d(int i, gc4 gc4Var) {
        if (i == 2) {
            return c(gc4Var);
        }
        if (i == 1) {
            return e(gc4Var);
        }
        y53.i("StreamFormatChunk", "Ignoring strf box for unsupported track type: " + g86.n0(i));
        return null;
    }

    @Nullable
    public static fn e(gc4 gc4Var) {
        int iZ = gc4Var.z();
        String strB = b(iZ);
        if (strB == null) {
            y53.i("StreamFormatChunk", "Ignoring track with unsupported format tag " + iZ);
            return null;
        }
        int iZ2 = gc4Var.z();
        int iU = gc4Var.u();
        gc4Var.V(6);
        int iD0 = g86.d0(gc4Var.N());
        int iZ3 = gc4Var.z();
        byte[] bArr = new byte[iZ3];
        gc4Var.l(bArr, 0, iZ3);
        m.b bVar = new m.b();
        bVar.g0(strB).J(iZ2).h0(iU);
        if ("audio/raw".equals(strB) && iD0 != 0) {
            bVar.a0(iD0);
        }
        if ("audio/mp4a-latm".equals(strB) && iZ3 > 0) {
            bVar.V(ImmutableList.of(bArr));
        }
        return new bl5(bVar.G());
    }

    @Override // defpackage.fn
    public int getType() {
        return AviExtractor.FOURCC_strf;
    }
}
