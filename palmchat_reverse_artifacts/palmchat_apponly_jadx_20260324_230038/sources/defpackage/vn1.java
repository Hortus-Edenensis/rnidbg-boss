package defpackage;

import com.google.android.exoplayer2.metadata.emsg.EventMessage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class vn1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventMessage[] f21484a;
    public final long[] b;
    public final String c;
    public final String d;
    public final long e;

    public vn1(String str, String str2, long j, long[] jArr, EventMessage[] eventMessageArr) {
        this.c = str;
        this.d = str2;
        this.e = j;
        this.b = jArr;
        this.f21484a = eventMessageArr;
    }

    public String a() {
        return this.c + "/" + this.d;
    }
}
