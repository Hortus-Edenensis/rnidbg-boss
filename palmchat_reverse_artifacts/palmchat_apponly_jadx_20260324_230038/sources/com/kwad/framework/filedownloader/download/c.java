package com.kwad.framework.filedownloader.download;

import android.os.Process;
import com.kwad.framework.filedownloader.download.ConnectTask;
import com.kwad.framework.filedownloader.download.e;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import java.io.IOException;
import java.net.SocketException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c implements Runnable {
    private final String afW;
    private final boolean arE;
    private final int arh;
    private final ConnectTask asd;
    private final f ase;
    private e asf;
    final int asg;
    private volatile boolean ne;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private String afW;
        private Boolean asb;
        private f ase;
        private final ConnectTask.a ash = new ConnectTask.a();
        private Integer asi;

        public final a a(f fVar) {
            this.ase = fVar;
            return this;
        }

        public final a b(com.kwad.framework.filedownloader.download.a aVar) {
            this.ash.a(aVar);
            return this;
        }

        public final a bE(String str) {
            this.ash.bB(str);
            return this;
        }

        public final a bF(String str) {
            this.ash.bC(str);
            return this;
        }

        public final a bG(String str) {
            this.afW = str;
            return this;
        }

        public final a bk(boolean z) {
            this.asb = Boolean.valueOf(z);
            return this;
        }

        public final a c(com.kwad.framework.filedownloader.d.b bVar) {
            this.ash.a(bVar);
            return this;
        }

        public final a ce(int i) {
            this.ash.cd(i);
            return this;
        }

        public final a i(Integer num) {
            this.asi = num;
            return this;
        }

        public final c zX() {
            if (this.ase == null || this.afW == null || this.asb == null || this.asi == null) {
                throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.c("%s %s %B", this.ase, this.afW, this.asb));
            }
            ConnectTask connectTaskZF = this.ash.zF();
            return new c(connectTaskZF.arh, this.asi.intValue(), connectTaskZF, this.ase, this.asb.booleanValue(), this.afW, (byte) 0);
        }
    }

    public /* synthetic */ c(int i, int i2, ConnectTask connectTask, f fVar, boolean z, String str, byte b) {
        this(i, i2, connectTask, fVar, z, str);
    }

    public final void pause() {
        this.ne = true;
        e eVar = this.asf;
        if (eVar != null) {
            eVar.pause();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        Exception e;
        Process.setThreadPriority(10);
        long j = this.asd.zE().arq;
        com.kwad.framework.filedownloader.a.b bVarZB = null;
        boolean z2 = false;
        while (!this.ne) {
            try {
                try {
                    bVarZB = this.asd.zB();
                    int responseCode = bVarZB.getResponseCode();
                    if (com.kwad.framework.filedownloader.f.d.atL) {
                        com.kwad.framework.filedownloader.f.d.c(this, "the connection[%d] for %d, is connected %s with requestHttpCode[%d]", Integer.valueOf(this.asg), Integer.valueOf(this.arh), this.asd.zE(), Integer.valueOf(responseCode));
                    }
                    if (responseCode != 206 && responseCode != 200) {
                        throw new SocketException(com.kwad.framework.filedownloader.f.f.c("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.asd.getRequestHeader(), bVarZB.zv(), Integer.valueOf(responseCode), Integer.valueOf(this.arh), Integer.valueOf(this.asg)));
                    }
                } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e2) {
                    e = e2;
                    z = false;
                }
            } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e3) {
                z = z2;
                e = e3;
            }
            try {
                e.a aVar = new e.a();
                if (this.ne) {
                    bVarZB.zw();
                    return;
                }
                e eVarAk = aVar.ch(this.arh).cg(this.asg).b(this.ase).a(this).bm(this.arE).d(bVarZB).c(this.asd.zE()).bH(this.afW).Ak();
                this.asf = eVarAk;
                eVarAk.run();
                if (this.ne) {
                    this.asf.pause();
                }
                bVarZB.zw();
                return;
            } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e4) {
                e = e4;
                z = true;
                try {
                    if (!this.ase.a(e)) {
                        this.ase.b(e);
                        if (bVarZB != null) {
                            bVarZB.zw();
                            return;
                        }
                        return;
                    }
                    if (z) {
                        e eVar = this.asf;
                        if (eVar == null) {
                            com.kwad.framework.filedownloader.f.d.d(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e);
                            this.ase.b(e);
                            if (bVarZB != null) {
                                return;
                            } else {
                                return;
                            }
                        }
                        this.ase.a(e, eVar.arq - j);
                    } else {
                        this.ase.a(e, 0L);
                    }
                    if (bVarZB != null) {
                        bVarZB.zw();
                    }
                    z2 = z;
                } finally {
                    if (bVarZB != null) {
                        bVarZB.zw();
                    }
                }
            }
        }
        if (bVarZB != null) {
            bVarZB.zw();
        }
    }

    public final void zc() {
        pause();
    }

    private c(int i, int i2, ConnectTask connectTask, f fVar, boolean z, String str) {
        this.arh = i;
        this.asg = i2;
        this.ne = false;
        this.ase = fVar;
        this.afW = str;
        this.asd = connectTask;
        this.arE = z;
    }
}
