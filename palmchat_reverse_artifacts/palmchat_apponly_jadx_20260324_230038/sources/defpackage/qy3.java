package defpackage;

import org.jsoup.nodes.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class qy3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sy3 f20353a;

    public qy3(sy3 sy3Var) {
        this.f20353a = sy3Var;
    }

    public void a(g gVar) {
        g gVarL = gVar;
        int i = 0;
        while (gVarL != null) {
            this.f20353a.b(gVarL, i);
            if (gVarL.m() > 0) {
                gVarL = gVarL.l(0);
                i++;
            } else {
                while (gVarL.w() == null && i > 0) {
                    this.f20353a.a(gVarL, i);
                    gVarL = gVarL.E();
                    i--;
                }
                this.f20353a.a(gVarL, i);
                if (gVarL == gVar) {
                    return;
                } else {
                    gVarL = gVarL.w();
                }
            }
        }
    }
}
