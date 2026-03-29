package com.bytedance.adsdk.u.u.u;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends IOException {
        public u() {
            super("APNG Format error");
        }
    }

    private static pn nr(com.bytedance.adsdk.u.u.nr.u uVar) throws IOException {
        int iFx = uVar.fx();
        int iNr = uVar.nr();
        int iB_ = uVar.b_();
        pn uVar2 = iB_ == com.bytedance.adsdk.u.u.u.u.u ? new com.bytedance.adsdk.u.u.u.u() : iB_ == iz.u ? new iz() : iB_ == x.u ? new x() : iB_ == jk.u ? new jk() : iB_ == t.u ? new t() : iB_ == l.u ? new l() : new pn();
        uVar2.x = iFx;
        uVar2.pn = iB_;
        uVar2.b = iNr;
        uVar2.nr(uVar);
        uVar2.iz = uVar.nr();
        return uVar2;
    }

    public static List<pn> u(com.bytedance.adsdk.u.u.nr.u uVar) throws IOException {
        if (!uVar.u("\u0089PNG") || !uVar.u("\r\n\u001a\n")) {
            throw new u();
        }
        ArrayList arrayList = new ArrayList();
        while (uVar.b() > 0) {
            arrayList.add(nr(uVar));
        }
        return arrayList;
    }
}
