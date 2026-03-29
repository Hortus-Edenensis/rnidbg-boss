package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.sdk.impl.helper.JException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ix3 extends xw2 {
    public Context c;
    public boolean d;
    public ur e = new zx3(8128, 20);

    static {
        bw2.h("NetworkingClient");
    }

    public ix3(Context context) {
        this.c = context;
        this.f22065a = "NetworkingClient";
    }

    @Override // defpackage.xw2
    public void a() {
        k63.h("NetworkingClient", "Begin to run in ConnectingThread - id:" + Thread.currentThread().getId());
        try {
            if (!g(this.c)) {
                k63.b("NetworkingClient", "prepare Push Channel failed , returned");
                return;
            }
            while (!this.d) {
                k63.b("NetworkingClient", "Network listening...");
                try {
                    ByteBuffer byteBufferF = this.e.f();
                    h(byteBufferF);
                    k63.b("NetworkingClient", "Received bytes - len:" + byteBufferF.array().length + ", pkg:" + ad.l(this.c));
                } catch (JException e) {
                    k63.l("NetworkingClient", " recv failed with error:" + e + " ,No Break!!");
                }
            }
        } catch (Throwable th) {
            k63.i("NetworkingClient", "run exception", th);
        }
        if (this.d) {
            k63.b("NetworkingClient", "Break receiving by wantStop");
        }
        b();
    }

    public final void b() {
        k63.b("NetworkingClient", "Action - closeConnection");
        z86.b(this.e);
        tt5.u().r(this.c, "tcp_a19", null);
    }

    public ur c() {
        return this.e;
    }

    public final boolean d(int i) {
        if (this.d) {
            return false;
        }
        if (i <= 0) {
            k63.b("NetworkingClient", "login error,retry login too many times");
            e();
            b();
            return false;
        }
        k63.a("NetworkingClient", "loginTimes:" + i);
        if (!i()) {
            return false;
        }
        int iJ = jm0.j(this.c, this.e);
        if (iJ < 0) {
            b();
            return false;
        }
        if (iJ <= 0) {
            tt5.u().r(this.c, "tcp_a10", null);
            return true;
        }
        e();
        if (iJ == 108) {
            bw2.b(this.c);
            return d(i - 1);
        }
        f(iJ);
        return false;
    }

    public final void e() {
        jm0.a(this.c);
    }

    public final void f(int i) {
        k63.j("NetworkingClient", "Action - onLoginFailed - respCode:" + i);
        Bundle bundle = new Bundle();
        bundle.putInt("resCode", i);
        tt5.u().r(this.c, "tcp_a12", bundle);
    }

    public final boolean g(Context context) {
        k63.a("NetworkingClient", "google:false");
        vb1.a(context);
        try {
            this.e = new he5(ie5.g(context)).h(this);
            if (d(2)) {
                return true;
            }
            k63.l("NetworkingClient", "login failed");
            return false;
        } catch (Exception e) {
            b();
            k63.l("NetworkingClient", "sis and connect failed:" + e);
            return false;
        }
    }

    public final void h(ByteBuffer byteBuffer) {
        bw2.f(new ut5(this.c, byteBuffer.array()), new int[0]);
    }

    public final boolean i() {
        if (mg5.d(this.c) && !TextUtils.isEmpty(fv2.j(this.c))) {
            return true;
        }
        int iO = jm0.o(this.c, this.e);
        if (iO == 0) {
            tt5.u().r(this.c, "tcp_a11", null);
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("resCode", iO);
        tt5.u().r(this.c, "tcp_a13", bundle);
        e();
        b();
        return false;
    }

    public synchronized void j() {
        try {
            wz4.a("TCP_CONN_TASK", this);
        } catch (Throwable th) {
            k63.n("NetworkingClient", "execute networkingClient exception :" + th);
        }
    }

    public synchronized void k() {
        k63.b("NetworkingClient", "Action - stop");
        z86.b(this.e);
        this.d = true;
        wz4.d("TCP_CONN_TASK");
    }
}
