package com.kwad.framework.filedownloader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.services.c;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class r {
    private static final Object aqC = new Object();
    private static final Object aqE = new Object();
    private w aqD;
    private volatile v aqF;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {
        private static final r aqG = new r();
    }

    public static void a(Context context, c.b bVar) {
        if (com.kwad.framework.filedownloader.f.d.atL) {
            com.kwad.framework.filedownloader.f.d.c(r.class, "init Downloader with params: %s %s", context, bVar);
        }
        if (context == null) {
            throw new IllegalArgumentException("the provided context must not be null!");
        }
        com.kwad.framework.filedownloader.f.c.aQ(context.getApplicationContext());
        com.kwad.framework.filedownloader.download.b.zG().a(bVar);
    }

    public static void aP(Context context) {
        com.kwad.framework.filedownloader.f.c.aQ(context.getApplicationContext());
    }

    private int bR(int i) {
        List<a.InterfaceC0580a> listBM = h.yT().bM(i);
        if (listBM.isEmpty()) {
            com.kwad.framework.filedownloader.f.d.d(this, "request pause but not exist %d", Integer.valueOf(i));
            return 0;
        }
        Iterator<a.InterfaceC0580a> it = listBM.iterator();
        while (it.hasNext()) {
            it.next().yv().pause();
        }
        return listBM.size();
    }

    public static com.kwad.framework.filedownloader.a by(String str) {
        return new c(str);
    }

    public static r zm() {
        return a.aqG;
    }

    public static boolean zo() {
        return n.ze().isConnected();
    }

    public final boolean t(int i, String str) {
        bR(i);
        if (!n.ze().bQ(i)) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        File file = new File(com.kwad.framework.filedownloader.f.f.bP(str));
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(str);
        if (file2.exists()) {
            file2.delete();
        }
        return true;
    }

    public final void zn() {
        if (zo()) {
            return;
        }
        n.ze().aO(com.kwad.framework.filedownloader.f.c.Bd());
    }

    public final w zp() {
        if (this.aqD == null) {
            synchronized (aqC) {
                if (this.aqD == null) {
                    this.aqD = new ab();
                }
            }
        }
        return this.aqD;
    }

    public final v zq() {
        if (this.aqF == null) {
            synchronized (aqE) {
                if (this.aqF == null) {
                    this.aqF = new z();
                    a((e) this.aqF);
                }
            }
        }
        return this.aqF;
    }

    private static void a(e eVar) {
        f.yR().a("event.service.connect.changed", eVar);
    }
}
