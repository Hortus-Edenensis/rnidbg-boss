package defpackage;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.zxing.FormatException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class s96 {
    public static final s96[] h = a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20686a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final c f;
    public final int g;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20687a;
        public final int b;

        public int a() {
            return this.f20687a;
        }

        public int b() {
            return this.b;
        }

        public b(int i, int i2) {
            this.f20687a = i;
            this.b = i2;
        }
    }

    public s96(int i, int i2, int i3, int i4, int i5, c cVar) {
        this.f20686a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = cVar;
        int iB = cVar.b();
        int iA = 0;
        for (b bVar : cVar.a()) {
            iA += bVar.a() * (bVar.b() + iB);
        }
        this.g = iA;
    }

    public static s96[] a() {
        int i = 8;
        int i2 = 1;
        int i3 = 5;
        s96 s96Var = new s96(3, 14, 14, 12, 12, new c(10, new b(i2, i)));
        int i4 = 2;
        int i5 = 12;
        int i6 = 18;
        s96 s96Var2 = new s96(7, 22, 22, 20, 20, new c(20, new b(i2, 30)));
        int i7 = 6;
        int i8 = 36;
        int i9 = 62;
        int i10 = 56;
        int i11 = 68;
        b bVar = new b(i2, 5);
        b bVar2 = new b(i2, 10);
        b bVar3 = new b(i2, 16);
        return new s96[]{new s96(1, 10, 10, 8, 8, new c(i3, new b(i2, 3))), new s96(2, 12, 12, 10, 10, new c(7, new b(i2, i3))), s96Var, new s96(4, 16, 16, 14, 14, new c(i5, new b(i2, i5))), new s96(5, 18, 18, 16, 16, new c(14, new b(i2, i6))), new s96(6, 20, 20, 18, 18, new c(i6, new b(i2, 22))), s96Var2, new s96(8, 24, 24, 22, 22, new c(24, new b(i2, i8))), new s96(9, 26, 26, 24, 24, new c(28, new b(i2, 44))), new s96(10, 32, 32, 14, 14, new c(i8, new b(i2, i9))), new s96(11, 36, 36, 16, 16, new c(42, new b(i2, 86))), new s96(12, 40, 40, 18, 18, new c(48, new b(i2, 114))), new s96(13, 44, 44, 20, 20, new c(i10, new b(i2, 144))), new s96(14, 48, 48, 22, 22, new c(i11, new b(i2, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE))), new s96(15, 52, 52, 24, 24, new c(42, new b(i4, 102))), new s96(16, 64, 64, 14, 14, new c(i10, new b(i4, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID))), new s96(17, 72, 72, 16, 16, new c(i8, new b(4, 92))), new s96(18, 80, 80, 18, 18, new c(48, new b(4, 114))), new s96(19, 88, 88, 20, 20, new c(i10, new b(4, 144))), new s96(20, 96, 96, 22, 22, new c(i11, new b(4, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE))), new s96(21, 104, 104, 24, 24, new c(i10, new b(i7, 136))), new s96(22, 120, 120, 18, 18, new c(i11, new b(i7, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED))), new s96(23, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, 20, 20, new c(i9, new b(i, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME))), new s96(24, 144, 144, 22, 22, new c(i9, new b(i, 156), new b(i4, 155))), new s96(25, 8, 18, 6, 16, new c(7, bVar)), new s96(26, 8, 32, 6, 14, new c(11, bVar2)), new s96(27, 12, 26, 10, 24, new c(14, bVar3)), new s96(28, 12, 36, 10, 16, new c(i6, new b(i2, 22))), new s96(29, 16, 36, 14, 16, new c(24, new b(i2, 32))), new s96(30, 16, 48, 14, 22, new c(28, new b(i2, 49)))};
    }

    public static s96 h(int i, int i2) throws FormatException {
        if ((i & 1) != 0 || (i2 & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        for (s96 s96Var : h) {
            if (s96Var.b == i && s96Var.c == i2) {
                return s96Var;
            }
        }
        throw FormatException.getFormatInstance();
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.d;
    }

    public c d() {
        return this.f;
    }

    public int e() {
        return this.c;
    }

    public int f() {
        return this.b;
    }

    public int g() {
        return this.g;
    }

    public int i() {
        return this.f20686a;
    }

    public String toString() {
        return String.valueOf(this.f20686a);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20688a;
        public final b[] b;

        public b[] a() {
            return this.b;
        }

        public int b() {
            return this.f20688a;
        }

        public c(int i, b bVar) {
            this.f20688a = i;
            this.b = new b[]{bVar};
        }

        public c(int i, b bVar, b bVar2) {
            this.f20688a = i;
            this.b = new b[]{bVar, bVar2};
        }
    }
}
