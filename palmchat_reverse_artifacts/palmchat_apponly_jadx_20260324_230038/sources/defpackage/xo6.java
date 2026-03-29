package defpackage;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.protobuf.GeneratedMessageLite;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.messaging.smack.ManualException;
import com.zenmen.palmchat.messaging.smack.XMPPException;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.AuthResponseProto;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class xo6 extends km0 {
    public String l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public nb4 q;
    public jb4 r;
    public mi4 s;
    public InputStream t;
    public OutputStream u;

    public xo6(lm0 lm0Var) {
        super(lm0Var);
        this.l = null;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
    }

    public void A() {
        z(this.n);
        this.n = false;
        y(false);
        try {
            this.s.i();
            this.r.f();
            this.q.h();
        } catch (Exception unused) {
        }
        try {
            Thread.sleep(150L);
        } catch (Exception unused2) {
        }
        try {
            this.f18720a.close();
        } catch (Exception unused3) {
        }
    }

    @Override // defpackage.km0
    public boolean i() {
        return this.m;
    }

    @Override // defpackage.km0
    public void k(GeneratedMessageLite generatedMessageLite, String str) {
        if (!i()) {
            LogUtil.x("TAG_MESSAGING", "sendPacket, Not connected to server.");
        } else {
            if (generatedMessageLite == null) {
                throw new NullPointerException("Packet is null.");
            }
            this.q.g(generatedMessageLite, str);
        }
    }

    public void l() {
        jb4 jb4Var = this.r;
        if (jb4Var != null) {
            jb4Var.b(new ManualException("manually close connection"));
        }
    }

    public void m() throws XMPPException {
        if (this.m) {
            return;
        }
        n(this.h);
    }

    public final void n(lm0 lm0Var) throws XMPPException {
        String strA = lm0Var.a();
        int iD = lm0Var.d();
        try {
            if (lm0Var.e() == null) {
                this.f18720a = new Socket(strA, iD);
            } else {
                this.f18720a = lm0Var.e().createSocket(strA, iD);
            }
            s();
        } catch (UnknownHostException e) {
            throw new XMPPException("Could not connect to " + strA + ":" + iD + ".", e);
        } catch (IOException e2) {
            throw new XMPPException("XMPPError connecting to " + strA + ":" + iD + ".", e2);
        } catch (IllegalArgumentException e3) {
            throw new XMPPException("IllegalArgument, Could not connect to " + strA + ":" + iD + ".", e3);
        }
    }

    public jb4 o() {
        return new yo6(this);
    }

    public nb4 p() {
        return new zo6(this);
    }

    public mi4 q() {
        return new mi4(this);
    }

    public void r() {
        mi4 mi4Var;
        LogUtil.d("TAG_MESSAGING", "detectConnection");
        if (this.m && this.n && (mi4Var = this.s) != null) {
            mi4Var.e();
        } else {
            LogUtil.d("TAG_MESSAGING", "not connect,not authenticate or no ping processor", 1);
        }
    }

    public void s() throws XMPPException {
        t();
        boolean z = this.r == null || this.q == null;
        try {
            if (z) {
                this.q = p();
                this.r = o();
                this.s = q();
            } else {
                this.q.e();
                this.r.a();
                this.s.f();
            }
            this.q.i();
            this.r.g();
            y(true);
            this.s.j();
            if (!z) {
                this.r.c();
                return;
            }
            Iterator<mm0> it = km0.f().iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
        } catch (XMPPException e) {
            w(e);
            throw e;
        } catch (Exception e2) {
            w(e2);
            e2.printStackTrace();
            throw new XMPPException(e2.getMessage(), e2);
        }
    }

    public final void t() throws XMPPException {
        try {
            this.t = this.f18720a.getInputStream();
            this.u = this.f18720a.getOutputStream();
        } catch (IOException e) {
            throw new XMPPException("XMPPError establishing connection with server.", e);
        }
    }

    public boolean u() {
        return this.n;
    }

    public synchronized void v(String str, String str2, String str3) throws Exception {
        if (!i()) {
            throw new IllegalStateException("Not connected to server.");
        }
        if (this.n) {
            throw new IllegalStateException("Already logged in to server.");
        }
        AuthResponseProto.AuthResponse authResponseA = new uy3(this).a(str, str2, str3);
        LogUtil.d("TAG_MESSAGING", "log in success:" + authResponseA.getSessionId());
        LogUtil.d("TAG_MESSAGING", "log in success:" + authResponseA.getTimestamp());
        ir5.g(authResponseA.getTimestamp());
        bs3.b().a();
        this.n = true;
        this.p = false;
        this.h.g(str, str2, str3);
    }

    public void w(Exception exc) {
        mi4 mi4Var = this.s;
        if (mi4Var != null) {
            try {
                mi4Var.i();
            } catch (Throwable unused) {
            }
            this.s = null;
        }
        nb4 nb4Var = this.q;
        if (nb4Var != null) {
            try {
                nb4Var.h();
            } catch (Throwable unused2) {
            }
            this.q = null;
        }
        jb4 jb4Var = this.r;
        if (jb4Var != null) {
            try {
                jb4Var.f();
            } catch (Throwable unused3) {
            }
            this.r = null;
        }
        InputStream inputStream = this.t;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Throwable unused4) {
            }
            this.t = null;
        }
        OutputStream outputStream = this.u;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Throwable unused5) {
            }
            this.u = null;
        }
        Socket socket = this.f18720a;
        if (socket != null) {
            try {
                socket.close();
            } catch (Exception unused6) {
            }
            this.f18720a = null;
        }
        z(this.n);
        this.n = false;
        y(false);
    }

    public void x() {
        mi4 mi4Var;
        LogUtil.d("TAG_MESSAGING", "ping");
        if (this.m && this.n && (mi4Var = this.s) != null) {
            mi4Var.h();
        } else {
            LogUtil.d("TAG_MESSAGING", "not connect,not authenticate or no ping processor", 1);
        }
    }

    public final void y(boolean z) {
        this.m = z;
        Intent intent = new Intent();
        intent.setAction(bs3.a());
        LocalBroadcastManager.getInstance(c.b()).sendBroadcast(intent);
    }

    public void z(boolean z) {
        if (this.o) {
            return;
        }
        this.o = z;
    }
}
