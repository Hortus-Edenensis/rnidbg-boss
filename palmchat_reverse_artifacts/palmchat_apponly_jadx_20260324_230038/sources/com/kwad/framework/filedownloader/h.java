package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class h {
    private final ArrayList<a.InterfaceC0580a> aqb;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {
        private static final h aqc = new h(0);
    }

    public /* synthetic */ h(byte b) {
        this();
    }

    public static h yT() {
        return a.aqc;
    }

    public final boolean a(a.InterfaceC0580a interfaceC0580a) {
        return this.aqb.isEmpty() || !this.aqb.contains(interfaceC0580a);
    }

    public final void b(a.InterfaceC0580a interfaceC0580a) {
        if (!interfaceC0580a.yv().yg()) {
            interfaceC0580a.yy();
        }
        if (interfaceC0580a.yw().yL().yY()) {
            c(interfaceC0580a);
        }
    }

    public final int bK(int i) {
        int i2;
        synchronized (this.aqb) {
            Iterator<a.InterfaceC0580a> it = this.aqb.iterator();
            i2 = 0;
            while (it.hasNext()) {
                if (it.next().bJ(i)) {
                    i2++;
                }
            }
        }
        return i2;
    }

    public final List<a.InterfaceC0580a> bL(int i) {
        byte bYn;
        ArrayList arrayList = new ArrayList();
        synchronized (this.aqb) {
            for (a.InterfaceC0580a interfaceC0580a : this.aqb) {
                if (interfaceC0580a.bJ(i) && !interfaceC0580a.isOver() && (bYn = interfaceC0580a.yv().yn()) != 0 && bYn != 10) {
                    arrayList.add(interfaceC0580a);
                }
            }
        }
        return arrayList;
    }

    public final List<a.InterfaceC0580a> bM(int i) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.aqb) {
            for (a.InterfaceC0580a interfaceC0580a : this.aqb) {
                if (interfaceC0580a.bJ(i) && !interfaceC0580a.isOver()) {
                    arrayList.add(interfaceC0580a);
                }
            }
        }
        return arrayList;
    }

    public final void c(a.InterfaceC0580a interfaceC0580a) {
        if (interfaceC0580a.yz()) {
            return;
        }
        synchronized (this.aqb) {
            if (this.aqb.contains(interfaceC0580a)) {
                com.kwad.framework.filedownloader.f.d.d(this, "already has %s", interfaceC0580a);
            } else {
                interfaceC0580a.yA();
                this.aqb.add(interfaceC0580a);
                if (com.kwad.framework.filedownloader.f.d.atL) {
                    com.kwad.framework.filedownloader.f.d.e(this, "add list in all %s %d %d", interfaceC0580a, Byte.valueOf(interfaceC0580a.yv().yn()), Integer.valueOf(this.aqb.size()));
                }
            }
        }
    }

    public final void p(List<a.InterfaceC0580a> list) {
        synchronized (this.aqb) {
            for (a.InterfaceC0580a interfaceC0580a : this.aqb) {
                if (!list.contains(interfaceC0580a)) {
                    list.add(interfaceC0580a);
                }
            }
            this.aqb.clear();
        }
    }

    public final int size() {
        return this.aqb.size();
    }

    private h() {
        this.aqb = new ArrayList<>();
    }

    public final boolean a(a.InterfaceC0580a interfaceC0580a, MessageSnapshot messageSnapshot) {
        boolean zRemove;
        byte bYn = messageSnapshot.yn();
        synchronized (this.aqb) {
            zRemove = this.aqb.remove(interfaceC0580a);
        }
        if (com.kwad.framework.filedownloader.f.d.atL && this.aqb.size() == 0) {
            com.kwad.framework.filedownloader.f.d.e(this, "remove %s left %d %d", interfaceC0580a, Byte.valueOf(bYn), Integer.valueOf(this.aqb.size()));
        }
        if (zRemove) {
            t tVarYL = interfaceC0580a.yw().yL();
            if (bYn == -4) {
                tVarYL.l(messageSnapshot);
            } else if (bYn == -3) {
                tVarYL.j(com.kwad.framework.filedownloader.message.f.t(messageSnapshot));
            } else if (bYn == -2) {
                tVarYL.n(messageSnapshot);
            } else if (bYn == -1) {
                tVarYL.m(messageSnapshot);
            }
        } else {
            com.kwad.framework.filedownloader.f.d.a(this, "remove error, not exist: %s %d", interfaceC0580a, Byte.valueOf(bYn));
        }
        return zRemove;
    }
}
