package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ut5 extends xw2 {
    public byte[] c;
    public Context d;

    public ut5(Context context, byte[] bArr) {
        this.d = context;
        this.c = bArr;
        this.f22065a = "TcpRecvAction";
    }

    @Override // defpackage.xw2
    public void a() {
        try {
            tt5.u().r(this.d, "tcp_a22", null);
            hv2.a(this.d, this.c);
        } catch (Throwable th) {
            k63.l("TcpRecvAction", "TcpRecvAction failed:" + th.getMessage());
        }
    }
}
