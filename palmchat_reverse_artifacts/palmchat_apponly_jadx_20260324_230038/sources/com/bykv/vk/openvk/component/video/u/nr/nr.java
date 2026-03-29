package com.bykv.vk.openvk.component.video.u.nr;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.u.nr.iz;
import com.bykv.vk.openvk.component.video.u.nr.n;
import com.bykv.vk.openvk.component.video.u.nr.pn;
import com.bytedance.sdk.component.utils.k;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class nr extends com.bykv.vk.openvk.component.video.u.nr.u {
    private final InterfaceC0160nr k;
    final Object l;
    final Object mv;
    private final int s;

    /* JADX INFO: renamed from: com.bykv.vk.openvk.component.video.u.nr.nr$nr, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0160nr {
        void u(nr nrVar);
    }

    public nr(u uVar) {
        super(uVar.b, uVar.pn);
        this.s = uVar.x;
        this.k = uVar.n;
        this.l = this;
        this.x = uVar.u;
        this.n = uVar.nr;
        this.iz = uVar.iz;
        this.f4973a = uVar.fx;
        this.mv = uVar.f4972a;
    }

    private void u(n.u uVar) throws Throwable {
        String strU;
        byte[] bArr;
        File fileFx = this.u.fx(this.n);
        long length = fileFx.length();
        int i = this.s;
        if (i > 0 && length >= i) {
            int i2 = b.fx;
            return;
        }
        int iPn = pn();
        com.bykv.vk.openvk.component.video.u.nr.nr.u uVarQuery = this.nr.query(this.n, iPn);
        if (uVarQuery != null && length >= uVarQuery.fx) {
            int i3 = b.fx;
            return;
        }
        b();
        int i4 = (int) length;
        com.bykv.vk.openvk.component.video.u.nr.pn.u uVarU = u(uVar, i4, this.s, "GET");
        if (uVarU == null) {
            return;
        }
        boolean z = true;
        pn pnVar = null;
        try {
            b();
            strU = com.bykv.vk.openvk.component.video.u.fx.u.u(uVarU, b.x, true);
        } catch (Throwable th) {
            th = th;
        }
        if (strU != null) {
            throw new com.bykv.vk.openvk.component.video.u.nr.fx.fx(strU + ", rawKey: " + this.x + ", url: " + uVar);
        }
        int iU = com.bykv.vk.openvk.component.video.u.fx.u.u(uVarU);
        if (uVarQuery != null && uVarQuery.fx != iU) {
            if (b.pn) {
                k.nr("TAG_PROXY_DownloadTask", "Content-Length not match, old: " + uVarQuery.fx + ", " + iU + ", key: " + this.n);
            }
            throw new com.bykv.vk.openvk.component.video.u.nr.fx.nr("Content-Length not match, old length: " + uVarQuery.fx + ", new length: " + iU + ", rawKey: " + this.x + ", currentUrl: " + uVar + ", previousInfo: " + uVarQuery.pn);
        }
        com.bykv.vk.openvk.component.video.u.fx.u.u(uVarU, this.nr, this.n, iPn);
        com.bykv.vk.openvk.component.video.u.nr.nr.u uVarQuery2 = this.nr.query(this.n, iPn);
        int i5 = uVarQuery2 == null ? 0 : uVarQuery2.fx;
        InputStream inputStreamB = uVarU.b();
        pn pnVar2 = new pn(fileFx, b.iz ? "rwd" : "rw");
        try {
            pnVar2.u(length);
            int i6 = b.fx;
            bArr = new byte[8192];
        } catch (Throwable th2) {
            th = th2;
            pnVar = pnVar2;
        }
        while (true) {
            int i7 = inputStreamB.read(bArr);
            if (i7 >= 0) {
                b();
                if (i7 > 0) {
                    pnVar2.u(bArr, 0, i7);
                    i4 += i7;
                    this.fx.addAndGet(i7);
                    u(i5, i4);
                }
                int i8 = this.s;
                if (i8 > 0 && i4 >= i8) {
                    int i9 = b.fx;
                    com.bykv.vk.openvk.component.video.u.fx.u.u(uVarU.b());
                    pnVar2.u();
                    u();
                    return;
                }
                b();
            } else {
                try {
                    fx();
                    int i10 = b.fx;
                    com.bykv.vk.openvk.component.video.u.fx.u.u(uVarU.b());
                    pnVar2.u();
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    pnVar = pnVar2;
                    z = false;
                }
            }
            com.bykv.vk.openvk.component.video.u.fx.u.u(uVarU.b());
            if (pnVar != null) {
                pnVar.u();
            }
            if (z) {
                u();
                int i11 = b.fx;
            }
            throw th;
        }
    }

    private boolean x() throws com.bykv.vk.openvk.component.video.u.nr.fx.u {
        while (this.f4973a.u()) {
            b();
            n.u uVarNr = this.f4973a.nr();
            try {
                u(uVarNr);
                return true;
            } catch (com.bykv.vk.openvk.component.video.u.nr.fx.fx unused) {
                uVarNr.u();
                iz();
            } catch (pn.u unused2) {
                iz();
                return false;
            } catch (IOException e) {
                if (e instanceof SocketTimeoutException) {
                    uVarNr.nr();
                }
                if (!nr()) {
                    iz();
                }
            } catch (Throwable unused3) {
                return false;
            }
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.u.u(this.n);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            x();
        } catch (Throwable unused) {
        }
        this.b.set(SystemClock.elapsedRealtime() - jElapsedRealtime);
        this.u.nr(this.n);
        InterfaceC0160nr interfaceC0160nr = this.k;
        if (interfaceC0160nr != null) {
            interfaceC0160nr.u(this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f4972a;
        com.bykv.vk.openvk.component.video.u.nr.u.u b;
        n fx;
        List<iz.nr> iz;
        InterfaceC0160nr n;
        String nr;
        com.bykv.vk.openvk.component.video.u.nr.nr.fx pn;
        String u;
        int x;

        public u nr(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("key == null");
            }
            this.nr = str;
            return this;
        }

        public u u(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("rawKey == null");
            }
            this.u = str;
            return this;
        }

        public u u(n nVar) {
            if (nVar != null) {
                this.fx = nVar;
                return this;
            }
            throw new IllegalArgumentException("urls is empty");
        }

        public u u(com.bykv.vk.openvk.component.video.u.nr.u.u uVar) {
            if (uVar != null) {
                this.b = uVar;
                return this;
            }
            throw new IllegalArgumentException("cache == null");
        }

        public u u(com.bykv.vk.openvk.component.video.u.nr.nr.fx fxVar) {
            if (fxVar != null) {
                this.pn = fxVar;
                return this;
            }
            throw new IllegalArgumentException("db == null");
        }

        public u u(List<iz.nr> list) {
            this.iz = list;
            return this;
        }

        public u u(int i) {
            this.x = i;
            return this;
        }

        public u u(InterfaceC0160nr interfaceC0160nr) {
            this.n = interfaceC0160nr;
            return this;
        }

        public u u(Object obj) {
            this.f4972a = obj;
            return this;
        }

        public nr u() {
            if (this.b != null && this.pn != null && !TextUtils.isEmpty(this.u) && !TextUtils.isEmpty(this.nr) && this.fx != null) {
                return new nr(this);
            }
            throw new IllegalArgumentException();
        }
    }
}
