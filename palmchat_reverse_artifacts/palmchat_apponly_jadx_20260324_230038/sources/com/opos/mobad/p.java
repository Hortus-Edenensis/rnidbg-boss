package com.opos.mobad;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class p {
    public static boolean a(com.opos.mobad.d.a.b bVar, int i, int i2) {
        boolean z = true;
        if (bVar == null) {
            return true;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i) {
                z = false;
                break;
            }
            if (bVar.a()) {
                break;
            }
            com.opos.cmn.an.f.a.a("RetryFileLockTool", "acquireFileLock but thread has acquire " + i3);
            try {
                Thread.sleep(i2);
            } catch (InterruptedException e) {
                com.opos.cmn.an.f.a.a("RetryFileLockTool", "", (Throwable) e);
            }
            i3++;
        }
        com.opos.cmn.an.f.a.b("RetryFileLockTool", "acquireFileLock retry time=" + i + ",interval =" + i2 + ",result =" + z);
        return z;
    }
}
