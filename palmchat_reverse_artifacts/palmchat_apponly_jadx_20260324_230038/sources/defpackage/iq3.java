package defpackage;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class iq3 {
    public static final iq3 f = new iq3(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_STREAM_RECEIVED_WINDOW, 3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f18228a;
    public final int[] b;
    public final jq3 c;
    public final jq3 d;
    public final int e;

    public iq3(int i, int i2) {
        this.e = i;
        this.f18228a = new int[i];
        this.b = new int[i];
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            this.f18228a[i4] = i3;
            i3 = (i3 * i2) % i;
        }
        for (int i5 = 0; i5 < i - 1; i5++) {
            this.b[this.f18228a[i5]] = i5;
        }
        this.c = new jq3(this, new int[]{0});
        this.d = new jq3(this, new int[]{1});
    }

    public int a(int i, int i2) {
        return (i + i2) % this.e;
    }

    public jq3 b(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.c;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new jq3(this, iArr);
    }

    public int c(int i) {
        return this.f18228a[i];
    }

    public jq3 d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public jq3 f() {
        return this.c;
    }

    public int g(int i) {
        if (i != 0) {
            return this.f18228a[(this.e - this.b[i]) - 1];
        }
        throw new ArithmeticException();
    }

    public int h(int i) {
        if (i != 0) {
            return this.b[i];
        }
        throw new IllegalArgumentException();
    }

    public int i(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.f18228a;
        int[] iArr2 = this.b;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.e - 1)];
    }

    public int j(int i, int i2) {
        int i3 = this.e;
        return ((i + i3) - i2) % i3;
    }
}
