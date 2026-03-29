package defpackage;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class w82 {
    public static final w82 h = new w82(TTAdConstant.INIT_FAILED_CREATE_INITIALIZER_FAILED, 4096, 1);
    public static final w82 i = new w82(1033, 1024, 1);
    public static final w82 j;
    public static final w82 k;
    public static final w82 l;
    public static final w82 m;
    public static final w82 n;
    public static final w82 o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f21636a;
    public final int[] b;
    public final x82 c;
    public final x82 d;
    public final int e;
    public final int f;
    public final int g;

    static {
        w82 w82Var = new w82(67, 64, 1);
        j = w82Var;
        k = new w82(19, 16, 1);
        l = new w82(MediaPlayer.MEDIA_PLAYER_OPTION_FRC_LEVEL, 256, 0);
        w82 w82Var2 = new w82(301, 256, 1);
        m = w82Var2;
        n = w82Var2;
        o = w82Var;
    }

    public w82(int i2, int i3, int i4) {
        this.f = i2;
        this.e = i3;
        this.g = i4;
        this.f21636a = new int[i3];
        this.b = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.f21636a[i6] = i5;
            i5 <<= 1;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.b[this.f21636a[i7]] = i7;
        }
        this.c = new x82(this, new int[]{0});
        this.d = new x82(this, new int[]{1});
    }

    public static int a(int i2, int i3) {
        return i2 ^ i3;
    }

    public x82 b(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.c;
        }
        int[] iArr = new int[i2 + 1];
        iArr[0] = i3;
        return new x82(this, iArr);
    }

    public int c(int i2) {
        return this.f21636a[i2];
    }

    public int d() {
        return this.g;
    }

    public x82 e() {
        return this.d;
    }

    public int f() {
        return this.e;
    }

    public x82 g() {
        return this.c;
    }

    public int h(int i2) {
        if (i2 != 0) {
            return this.f21636a[(this.e - this.b[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    public int i(int i2) {
        if (i2 != 0) {
            return this.b[i2];
        }
        throw new IllegalArgumentException();
    }

    public int j(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.f21636a;
        int[] iArr2 = this.b;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f) + ',' + this.e + ')';
    }
}
