package com.opos.mobad.i.a;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f8926a;
    private int b;
    private c[] c;
    private volatile boolean d = false;

    public b(File file, int i, c[] cVarArr) {
        setName("download_monitor_" + file.getName());
        setPriority(5);
        this.f8926a = file;
        this.b = i;
        this.c = cVarArr;
    }

    public void a() {
        this.d = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        StringBuilder sb;
        com.opos.cmn.an.f.a.b("DownloadMonitorThread", "DownloadMonitorThread start running.");
        e eVar = new e(this.f8926a);
        try {
            try {
                if (eVar.a()) {
                    while (!this.d) {
                        a(this.f8926a, this.b, this.c);
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException e) {
                            com.opos.cmn.an.f.a.b("DownloadMonitorThread", "", e);
                        }
                    }
                }
                com.opos.cmn.an.f.a.b("DownloadMonitorThread", "DownloadMonitorThread end running.");
                eVar.b();
                sb = new StringBuilder();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("DownloadMonitorThread", "DownloadMonitorThread run", (Throwable) e2);
                com.opos.cmn.an.f.a.b("DownloadMonitorThread", "DownloadMonitorThread end running.");
                eVar.b();
                sb = new StringBuilder();
            }
            sb.append("posInfoFile releaseFileLock success.");
            sb.append(this.f8926a);
            com.opos.cmn.an.f.a.b("DownloadMonitorThread", sb.toString());
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("DownloadMonitorThread", "DownloadMonitorThread end running.");
            eVar.b();
            com.opos.cmn.an.f.a.b("DownloadMonitorThread", "posInfoFile releaseFileLock success." + this.f8926a);
            throw th;
        }
    }

    private void a(File file, int i, c[] cVarArr) {
        com.opos.cmn.an.f.a.b("DownloadMonitorThread", "writePosInfoToFile start");
        if (file != null && cVarArr != null && cVarArr.length > 0) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
                    try {
                        dataOutputStream.writeInt(i);
                        for (int i2 = 0; i2 < cVarArr.length; i2++) {
                            dataOutputStream.writeLong(cVarArr[i2].a());
                            dataOutputStream.writeLong(cVarArr[i2].b());
                        }
                        dataOutputStream.close();
                        fileOutputStream.close();
                    } finally {
                    }
                } finally {
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("DownloadMonitorThread", "writePosInfoToFile", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("DownloadMonitorThread", "writePosInfoToFile end");
    }
}
