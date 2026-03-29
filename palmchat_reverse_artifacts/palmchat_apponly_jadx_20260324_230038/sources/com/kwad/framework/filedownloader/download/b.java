package com.kwad.framework.filedownloader.download;

import com.kwad.framework.filedownloader.a.c;
import com.kwad.framework.filedownloader.b.a;
import com.kwad.framework.filedownloader.f.c;
import com.kwad.framework.filedownloader.services.c;
import java.io.File;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b {
    private com.kwad.framework.filedownloader.services.c ars;
    private c.a art;
    private c.b aru;
    private c.e arv;
    private volatile com.kwad.framework.filedownloader.b.a arw;
    private c.d arx;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {
        private static final b ary = new b();
    }

    public static b zG() {
        return a.ary;
    }

    private c.a zL() {
        c.a aVar = this.art;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.art == null) {
                this.art = zO().AM();
            }
        }
        return this.art;
    }

    private c.b zM() {
        c.b bVar = this.aru;
        if (bVar != null) {
            return bVar;
        }
        synchronized (this) {
            if (this.aru == null) {
                this.aru = zO().AL();
            }
        }
        return this.aru;
    }

    private c.e zN() {
        c.e eVar = this.arv;
        if (eVar != null) {
            return eVar;
        }
        synchronized (this) {
            if (this.arv == null) {
                this.arv = zO().AK();
            }
        }
        return this.arv;
    }

    private com.kwad.framework.filedownloader.services.c zO() {
        com.kwad.framework.filedownloader.services.c cVar = this.ars;
        if (cVar != null) {
            return cVar;
        }
        synchronized (this) {
            if (this.ars == null) {
                this.ars = new com.kwad.framework.filedownloader.services.c();
            }
        }
        return this.ars;
    }

    public final void a(c.b bVar) {
        synchronized (this) {
            this.ars = new com.kwad.framework.filedownloader.services.c(bVar);
            this.aru = null;
            this.arv = null;
            this.arw = null;
            this.arx = null;
        }
    }

    public final void b(c.b bVar) {
        synchronized (this) {
            this.ars = new com.kwad.framework.filedownloader.services.c(bVar);
        }
    }

    public final com.kwad.framework.filedownloader.a.b bD(String str) {
        try {
            return zM().bA(str);
        } catch (Throwable unused) {
            c.b bVar = new c.b();
            this.aru = bVar;
            return bVar.bA(str);
        }
    }

    public final c.d zH() {
        c.d dVar = this.arx;
        if (dVar != null) {
            return dVar;
        }
        synchronized (this) {
            if (this.arx == null) {
                this.arx = zO().AN();
            }
        }
        return this.arx;
    }

    public final synchronized com.kwad.framework.filedownloader.b.a zI() {
        if (this.arw != null) {
            return this.arw;
        }
        this.arw = zO().AJ();
        a(this.arw.zx());
        return this.arw;
    }

    public final int zJ() {
        return zO().zJ();
    }

    public final boolean zK() {
        zN();
        return true;
    }

    public final com.kwad.framework.filedownloader.e.a b(File file) {
        return zN().c(file);
    }

    public final int a(int i, String str, String str2, long j) {
        return zL().V(j);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0053 A[Catch: all -> 0x0144, TryCatch #1 {all -> 0x0144, blocks: (B:9:0x0034, B:11:0x003b, B:13:0x0042, B:15:0x0049, B:18:0x0056, B:21:0x0065, B:23:0x0070, B:17:0x0053), top: B:84:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(a.InterfaceC0581a interfaceC0581a) throws Throwable {
        long j;
        long j2;
        boolean z;
        String str = "refreshed data count: %d , delete data count: %d, reset id count: %d. consume %d";
        Iterator<com.kwad.framework.filedownloader.d.c> it = interfaceC0581a.iterator();
        c.d dVarZH = zG().zH();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        while (it.hasNext()) {
            try {
                try {
                    com.kwad.framework.filedownloader.d.c next = it.next();
                    String str2 = str;
                    if (next.yn() != 3) {
                        try {
                            if (next.yn() == 2 || next.yn() == -1 || (next.yn() == 1 && next.AD() > 0)) {
                                next.d((byte) -2);
                            }
                            String targetFilePath = next.getTargetFilePath();
                            if (targetFilePath == null) {
                                j = jCurrentTimeMillis;
                                j2 = j3;
                                z = true;
                            } else {
                                File file = new File(targetFilePath);
                                if (next.yn() == -2) {
                                    j = jCurrentTimeMillis;
                                    try {
                                        if (com.kwad.framework.filedownloader.f.f.a(next.getId(), next, next.getPath(), null)) {
                                            File file2 = new File(next.zV());
                                            if (!file2.exists() && file.exists()) {
                                                boolean zRenameTo = file.renameTo(file2);
                                                if (com.kwad.framework.filedownloader.f.d.atL) {
                                                    j2 = j3;
                                                    com.kwad.framework.filedownloader.f.d.c(com.kwad.framework.filedownloader.b.a.class, "resume from the old no-temp-file architecture [%B], [%s]->[%s]", Boolean.valueOf(zRenameTo), file.getPath(), file2.getPath());
                                                }
                                                if (next.yn() == 1 || next.AD() > 0) {
                                                    z = com.kwad.framework.filedownloader.f.f.b(next.getId(), next) || file.exists();
                                                }
                                            }
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        j2 = j3;
                                        str = str2;
                                        com.kwad.framework.filedownloader.f.f.aS(com.kwad.framework.filedownloader.f.c.Bd());
                                        interfaceC0581a.zy();
                                        if (com.kwad.framework.filedownloader.f.d.atL) {
                                        }
                                        throw th;
                                    }
                                } else {
                                    j = jCurrentTimeMillis;
                                }
                                j2 = j3;
                                if (next.yn() == 1) {
                                }
                                if (com.kwad.framework.filedownloader.f.f.b(next.getId(), next)) {
                                }
                            }
                            if (z) {
                                try {
                                    it.remove();
                                    j4++;
                                    str = str2;
                                    jCurrentTimeMillis = j;
                                    j3 = j2;
                                } catch (Throwable th2) {
                                    th = th2;
                                    str = str2;
                                    com.kwad.framework.filedownloader.f.f.aS(com.kwad.framework.filedownloader.f.c.Bd());
                                    interfaceC0581a.zy();
                                    if (com.kwad.framework.filedownloader.f.d.atL) {
                                    }
                                    throw th;
                                }
                            } else {
                                int id = next.getId();
                                int iF = dVarZH.f(next.getUrl(), next.getPath(), next.yj());
                                if (iF != id) {
                                    if (com.kwad.framework.filedownloader.f.d.atL) {
                                        com.kwad.framework.filedownloader.f.d.c(com.kwad.framework.filedownloader.b.a.class, "the id is changed on restoring from db: old[%d] -> new[%d]", Integer.valueOf(id), Integer.valueOf(iF));
                                    }
                                    next.setId(iF);
                                    interfaceC0581a.a(id, next);
                                    j5++;
                                }
                                interfaceC0581a.c(next);
                                j3 = j2 + 1;
                                str = str2;
                                jCurrentTimeMillis = j;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            j = jCurrentTimeMillis;
                            j2 = j3;
                            str = str2;
                            com.kwad.framework.filedownloader.f.f.aS(com.kwad.framework.filedownloader.f.c.Bd());
                            interfaceC0581a.zy();
                            if (com.kwad.framework.filedownloader.f.d.atL) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    j = jCurrentTimeMillis;
                    j2 = j3;
                }
            } catch (Throwable th5) {
                th = th5;
            }
            com.kwad.framework.filedownloader.f.f.aS(com.kwad.framework.filedownloader.f.c.Bd());
            interfaceC0581a.zy();
            if (com.kwad.framework.filedownloader.f.d.atL) {
                com.kwad.framework.filedownloader.f.d.c(com.kwad.framework.filedownloader.b.a.class, str, Long.valueOf(j2), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(System.currentTimeMillis() - j));
            }
            throw th;
        }
        String str3 = str;
        long j6 = jCurrentTimeMillis;
        long j7 = j3;
        com.kwad.framework.filedownloader.f.f.aS(com.kwad.framework.filedownloader.f.c.Bd());
        interfaceC0581a.zy();
        if (com.kwad.framework.filedownloader.f.d.atL) {
            com.kwad.framework.filedownloader.f.d.c(com.kwad.framework.filedownloader.b.a.class, str3, Long.valueOf(j7), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(System.currentTimeMillis() - j6));
        }
    }
}
