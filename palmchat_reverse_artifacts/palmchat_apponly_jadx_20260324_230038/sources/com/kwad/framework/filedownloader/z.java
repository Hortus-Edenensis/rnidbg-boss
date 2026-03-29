package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class z extends e implements v {
    private final ArrayList<a.InterfaceC0580a> aqH = new ArrayList<>();

    @Override // com.kwad.framework.filedownloader.v
    public final boolean d(a.InterfaceC0580a interfaceC0580a) {
        return !this.aqH.isEmpty() && this.aqH.contains(interfaceC0580a);
    }

    @Override // com.kwad.framework.filedownloader.v
    public final void e(a.InterfaceC0580a interfaceC0580a) {
        if (this.aqH.isEmpty()) {
            return;
        }
        synchronized (this.aqH) {
            this.aqH.remove(interfaceC0580a);
        }
    }

    @Override // com.kwad.framework.filedownloader.v
    public final boolean f(a.InterfaceC0580a interfaceC0580a) {
        r.zm();
        if (!r.zo()) {
            synchronized (this.aqH) {
                r.zm();
                if (!r.zo()) {
                    if (com.kwad.framework.filedownloader.f.d.atL) {
                        com.kwad.framework.filedownloader.f.d.c(this, "Waiting for connecting with the downloader service... %d", Integer.valueOf(interfaceC0580a.yv().getId()));
                    }
                    n.ze().aO(com.kwad.framework.filedownloader.f.c.Bd());
                    if (!this.aqH.contains(interfaceC0580a)) {
                        interfaceC0580a.free();
                        this.aqH.add(interfaceC0580a);
                    }
                    return true;
                }
            }
        }
        e(interfaceC0580a);
        return false;
    }

    @Override // com.kwad.framework.filedownloader.e
    public final void yO() {
        w wVarZp = r.zm().zp();
        if (com.kwad.framework.filedownloader.f.d.atL) {
            com.kwad.framework.filedownloader.f.d.c(this, "The downloader service is connected.", new Object[0]);
        }
        synchronized (this.aqH) {
            List<a.InterfaceC0580a> list = (List) this.aqH.clone();
            this.aqH.clear();
            ArrayList arrayList = new ArrayList(wVarZp.zt());
            for (a.InterfaceC0580a interfaceC0580a : list) {
                int iYx = interfaceC0580a.yx();
                if (wVarZp.bS(iYx)) {
                    interfaceC0580a.yv().ye().yD();
                    if (!arrayList.contains(Integer.valueOf(iYx))) {
                        arrayList.add(Integer.valueOf(iYx));
                    }
                } else {
                    interfaceC0580a.yB();
                }
            }
            wVarZp.q(arrayList);
        }
    }

    @Override // com.kwad.framework.filedownloader.e
    public final void yP() {
        if (yQ() != DownloadServiceConnectChangedEvent.ConnectStatus.lost) {
            if (h.yT().size() > 0) {
                com.kwad.framework.filedownloader.f.d.d(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(h.yT().size()));
                return;
            }
            return;
        }
        w wVarZp = r.zm().zp();
        if (com.kwad.framework.filedownloader.f.d.atL) {
            com.kwad.framework.filedownloader.f.d.c(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(h.yT().size()));
        }
        if (h.yT().size() > 0) {
            synchronized (this.aqH) {
                h.yT().p(this.aqH);
                Iterator<a.InterfaceC0580a> it = this.aqH.iterator();
                while (it.hasNext()) {
                    it.next().free();
                }
                wVarZp.zs();
            }
            r.zm().zn();
        }
    }
}
