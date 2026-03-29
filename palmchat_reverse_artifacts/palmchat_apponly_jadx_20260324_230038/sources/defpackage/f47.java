package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import com.igexin.push.f.b.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class f47 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17433a;
    public String b;
    public String c;
    public long d;
    public long e;
    public long f;
    public long g;
    public byte[] h;
    public byte[] i;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17434a;
        public String b;
        public byte[] e;
        public byte[] f;
        public long c = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        public long d = d.b;
        public long g = 52428800;
        public String h = "";

        public final a a(long j) {
            this.d = j * 86400000;
            return this;
        }

        public final f47 b() {
            f47 f47Var = new f47((byte) 0);
            f47Var.f17433a = this.f17434a;
            f47Var.b = this.b;
            f47Var.d = this.c;
            f47Var.g = this.g;
            f47Var.e = this.d;
            f47Var.h = this.e;
            f47Var.i = this.f;
            f47Var.c = this.h;
            return f47Var;
        }
    }

    public f47() {
        this.c = "";
        this.d = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        this.e = d.b;
        this.f = 500L;
        this.g = 52428800L;
    }

    public /* synthetic */ f47(byte b) {
        this();
    }
}
