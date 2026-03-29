package com.bykv.vk.openvk.component.video.u.u.nr;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.bykv.vk.openvk.component.video.api.fx.iz;
import com.bykv.vk.openvk.component.video.api.pn.u;
import com.bytedance.sdk.component.nr.u.l;
import com.bytedance.sdk.component.nr.u.my;
import com.bytedance.sdk.component.nr.u.o;
import com.bytedance.sdk.component.nr.u.s;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr {
    private File b;
    private iz nr;
    private File pn;
    private Context u;
    private volatile boolean fx = false;
    private final List<u.InterfaceC0155u> iz = new ArrayList();
    private volatile boolean x = false;

    public nr(Context context, iz izVar) {
        this.b = null;
        this.pn = null;
        this.u = context;
        this.nr = izVar;
        this.b = com.bykv.vk.openvk.component.video.u.pn.fx.nr(izVar.pn(), izVar.o());
        this.pn = com.bykv.vk.openvk.component.video.u.pn.fx.fx(izVar.pn(), izVar.o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            this.pn.delete();
            this.b.delete();
        } catch (Throwable unused) {
        }
    }

    private void fx() {
        l.u uVarNr = com.bykv.vk.openvk.component.video.api.fx.fx() != null ? com.bykv.vk.openvk.component.video.api.fx.fx().nr() : new l.u("v_preload");
        long jBg = this.nr.bg();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        uVarNr.u(jBg, timeUnit).nr(this.nr.bq(), timeUnit).fx(this.nr.dw(), timeUnit);
        l lVarU = uVarNr.u();
        s.u uVar = new s.u();
        final long length = this.b.length();
        int iIz = this.nr.iz();
        boolean zMv = this.nr.mv();
        int iNr = this.nr.nr();
        if (iNr > 0) {
            if (iNr >= this.nr.l()) {
                zMv = true;
            } else {
                iIz = iNr;
            }
        }
        if (zMv) {
            uVar.u("RANGE", "bytes=" + length + "-").u(this.nr.my()).u().nr();
        } else {
            uVar.u("RANGE", "bytes=" + length + "-" + iIz).u(this.nr.my()).u().nr();
        }
        lVarU.u(uVar.nr()).u(new com.bytedance.sdk.component.nr.u.fx() { // from class: com.bykv.vk.openvk.component.video.u.u.nr.nr.1
            @Override // com.bytedance.sdk.component.nr.u.fx
            public void onFailure(com.bytedance.sdk.component.nr.u.nr nrVar, IOException iOException) {
                nr nrVar2 = nr.this;
                nrVar2.u(nrVar2.nr, 601, iOException.getMessage());
                fx.u(nr.this.nr);
            }

            /* JADX WARN: Removed duplicated region for block: B:70:0x014b A[Catch: all -> 0x0162, TryCatch #1 {all -> 0x0162, blocks: (B:68:0x013e, B:70:0x014b, B:71:0x014f), top: B:77:0x013e }] */
            @Override // com.bytedance.sdk.component.nr.u.fx
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onResponse(com.bytedance.sdk.component.nr.u.nr nrVar, my myVar) throws IOException {
                int iFx;
                InputStream inputStreamFx;
                RandomAccessFile randomAccessFile;
                o oVarIz;
                boolean zB;
                long jU;
                long j = length;
                o oVar = null;
                oVar = null;
                randomAccessFile = null;
                randomAccessFile = null;
                oVar = null;
                RandomAccessFile randomAccessFile2 = null;
                if (myVar != null) {
                    try {
                        zB = myVar.b();
                    } catch (Throwable th) {
                        th = th;
                        inputStreamFx = null;
                        randomAccessFile = null;
                    }
                    if (zB) {
                        oVarIz = myVar.iz();
                        try {
                            oVarIz = myVar.iz();
                            if (!zB || oVarIz == null) {
                                inputStreamFx = null;
                                jU = 0;
                            } else {
                                jU = length + oVarIz.u();
                                inputStreamFx = oVarIz.fx();
                            }
                            try {
                                if (inputStreamFx == null) {
                                    nr nrVar2 = nr.this;
                                    nrVar2.u(nrVar2.nr, myVar.fx(), myVar.pn());
                                } else {
                                    randomAccessFile = new RandomAccessFile(nr.this.b, "rw");
                                    try {
                                        byte[] bArr = new byte[8192];
                                        long j2 = 0;
                                        loop0: while (true) {
                                            int i = 0;
                                            do {
                                                int i2 = inputStreamFx.read(bArr, i, 8192 - i);
                                                if (i2 == -1) {
                                                    if (nr.this.nr.mv() && jU == nr.this.b.length()) {
                                                        nr.this.pn();
                                                    }
                                                    nr nrVar3 = nr.this;
                                                    nrVar3.u(nrVar3.nr, myVar.fx());
                                                    randomAccessFile2 = randomAccessFile;
                                                } else {
                                                    if (nr.this.fx) {
                                                        nr nrVar4 = nr.this;
                                                        nrVar4.nr(nrVar4.nr, myVar.fx());
                                                        nr.this.u(randomAccessFile);
                                                        break loop0;
                                                    }
                                                    i += i2;
                                                    j2 += (long) i2;
                                                }
                                            } while (!(j2 % PlaybackStateCompat.ACTION_PLAY_FROM_URI == 0 || j2 == jU - length));
                                            com.bykv.vk.openvk.component.video.u.pn.fx.u(randomAccessFile, bArr, j, i);
                                            j += (long) i;
                                        }
                                        nr.this.u(inputStreamFx);
                                        nr.this.u(oVarIz);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        oVar = oVarIz;
                                        iFx = 601;
                                        try {
                                            nr.this.b();
                                            nr nrVar5 = nr.this;
                                            iz izVar = nrVar5.nr;
                                            if (myVar != null) {
                                                iFx = myVar.fx();
                                            }
                                            nrVar5.u(izVar, iFx, th.getMessage());
                                            nr.this.u(randomAccessFile);
                                            nr.this.u(inputStreamFx);
                                            nr.this.u(oVar);
                                        } catch (Throwable th3) {
                                            nr.this.u(randomAccessFile);
                                            nr.this.u(inputStreamFx);
                                            nr.this.u(oVar);
                                            nr.this.u(myVar);
                                            nr.this.nr.my();
                                            nr.this.nr.iz();
                                            fx.u(nr.this.nr);
                                            throw th3;
                                        }
                                    }
                                }
                                nr.this.u(randomAccessFile2);
                                nr.this.u(inputStreamFx);
                                nr.this.u(oVarIz);
                            } catch (Throwable th4) {
                                th = th4;
                                randomAccessFile = randomAccessFile2;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            inputStreamFx = null;
                            randomAccessFile = null;
                        }
                    } else {
                        nr nrVar6 = nr.this;
                        nrVar6.u(nrVar6.nr, myVar.fx(), myVar.pn());
                        nr.this.u((Closeable) null);
                        nr.this.u((Closeable) null);
                        nr.this.u(oVar);
                    }
                } else {
                    try {
                        nr nrVar7 = nr.this;
                        iFx = 601;
                        try {
                            nrVar7.u(nrVar7.nr, 601, "Network link failed.");
                            oVarIz = null;
                            inputStreamFx = null;
                            nr.this.u(randomAccessFile2);
                            nr.this.u(inputStreamFx);
                            nr.this.u(oVarIz);
                        } catch (Throwable th6) {
                            th = th6;
                            inputStreamFx = null;
                            randomAccessFile = null;
                            nr.this.b();
                            nr nrVar52 = nr.this;
                            iz izVar2 = nrVar52.nr;
                            if (myVar != null) {
                            }
                            nrVar52.u(izVar2, iFx, th.getMessage());
                            nr.this.u(randomAccessFile);
                            nr.this.u(inputStreamFx);
                            nr.this.u(oVar);
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        iFx = 601;
                    }
                }
                nr.this.u(myVar);
                nr.this.nr.my();
                nr.this.nr.iz();
                fx.u(nr.this.nr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pn() {
        try {
            if (this.b.renameTo(this.pn)) {
                return;
            }
            throw new IOException("Error renaming file " + this.b + " to " + this.pn + " for completion!");
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private boolean nr() {
        if (this.pn.exists()) {
            return true;
        }
        if (!this.nr.mv()) {
            if (this.b.length() >= this.nr.iz()) {
                return true;
            }
            if (this.nr.nr() > 0 && this.b.length() >= this.nr.nr()) {
                return true;
            }
        }
        return false;
    }

    public void u(u.InterfaceC0155u interfaceC0155u) {
        if (this.x) {
            synchronized (u.InterfaceC0155u.class) {
                this.iz.add(interfaceC0155u);
            }
            return;
        }
        this.iz.add(interfaceC0155u);
        if (nr()) {
            this.nr.a(1);
            u(this.nr, 200);
            fx.u(this.nr);
        } else {
            this.x = true;
            this.nr.a(0);
            fx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(iz izVar, int i) {
        synchronized (u.InterfaceC0155u.class) {
            for (u.InterfaceC0155u interfaceC0155u : this.iz) {
                if (interfaceC0155u != null) {
                    interfaceC0155u.nr(izVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public iz u() {
        return this.nr;
    }

    public void u(boolean z) {
        this.fx = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(iz izVar, int i) {
        synchronized (u.InterfaceC0155u.class) {
            for (u.InterfaceC0155u interfaceC0155u : this.iz) {
                if (interfaceC0155u != null) {
                    interfaceC0155u.u(izVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(iz izVar, int i, String str) {
        synchronized (u.InterfaceC0155u.class) {
            for (u.InterfaceC0155u interfaceC0155u : this.iz) {
                if (interfaceC0155u != null) {
                    interfaceC0155u.u(izVar, i, str);
                }
            }
        }
    }
}
