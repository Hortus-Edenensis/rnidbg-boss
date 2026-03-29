package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.m;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.TECameraUtils;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class n2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f19416a = {2002, 2000, TECameraUtils.CAPTURE_NORMAL, 1601, 1600, 1001, 1000, 960, 800, 800, TECameraSettings.FPS_480, 400, 400, 2048};

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f19417a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        public b(int i, int i2, int i3, int i4, int i5) {
            this.f19417a = i;
            this.c = i2;
            this.b = i3;
            this.d = i4;
            this.e = i5;
        }
    }

    public static void a(int i, gc4 gc4Var) {
        gc4Var.Q(7);
        byte[] bArrE = gc4Var.e();
        bArrE[0] = -84;
        bArrE[1] = 64;
        bArrE[2] = -1;
        bArrE[3] = -1;
        bArrE[4] = (byte) ((i >> 16) & 255);
        bArrE[5] = (byte) ((i >> 8) & 255);
        bArrE[6] = (byte) (i & 255);
    }

    public static m b(gc4 gc4Var, String str, String str2, @Nullable DrmInitData drmInitData) {
        gc4Var.V(1);
        return new m.b().U(str).g0("audio/ac4").J(2).h0(((gc4Var.H() & 32) >> 5) == 1 ? 48000 : 44100).O(drmInitData).X(str2).G();
    }

    public static int c(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(iPosition);
        return d(new fc4(bArr)).e;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b d(fc4 fc4Var) {
        int i;
        int i2;
        int iH = fc4Var.h(16);
        int iH2 = fc4Var.h(16);
        if (iH2 == 65535) {
            iH2 = fc4Var.h(24);
            i = 7;
        } else {
            i = 4;
        }
        int i3 = iH2 + i;
        if (iH == 44097) {
            i3 += 2;
        }
        int i4 = i3;
        int iH3 = fc4Var.h(2);
        if (iH3 == 3) {
            iH3 += f(fc4Var, 2);
        }
        int i5 = iH3;
        int iH4 = fc4Var.h(10);
        if (fc4Var.g() && fc4Var.h(3) > 0) {
            fc4Var.r(2);
        }
        int i6 = fc4Var.g() ? 48000 : 44100;
        int iH5 = fc4Var.h(4);
        if (i6 == 44100 && iH5 == 13) {
            i2 = f19416a[iH5];
        } else if (i6 == 48000) {
            int[] iArr = f19416a;
            if (iH5 < iArr.length) {
                int i7 = iArr[iH5];
                int i8 = iH4 % 5;
                if (i8 == 1) {
                    if (iH5 == 3 || iH5 == 8) {
                        i7++;
                    }
                    i2 = i7;
                } else if (i8 == 2) {
                    if (iH5 == 8 || iH5 == 11) {
                    }
                    i2 = i7;
                } else if (i8 != 3) {
                    if (i8 == 4 && (iH5 == 3 || iH5 == 8 || iH5 == 11)) {
                    }
                    i2 = i7;
                }
            } else {
                i2 = 0;
            }
        }
        return new b(i5, 2, i6, i4, i2);
    }

    public static int e(byte[] bArr, int i) {
        int i2 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        int i3 = ((bArr[2] & UByte.MAX_VALUE) << 8) | (bArr[3] & UByte.MAX_VALUE);
        if (i3 == 65535) {
            i3 = ((bArr[4] & UByte.MAX_VALUE) << 16) | ((bArr[5] & UByte.MAX_VALUE) << 8) | (bArr[6] & UByte.MAX_VALUE);
        } else {
            i2 = 4;
        }
        if (i == 44097) {
            i2 += 2;
        }
        return i3 + i2;
    }

    public static int f(fc4 fc4Var, int i) {
        int i2 = 0;
        while (true) {
            int iH = i2 + fc4Var.h(i);
            if (!fc4Var.g()) {
                return iH;
            }
            i2 = (iH + 1) << i;
        }
    }
}
