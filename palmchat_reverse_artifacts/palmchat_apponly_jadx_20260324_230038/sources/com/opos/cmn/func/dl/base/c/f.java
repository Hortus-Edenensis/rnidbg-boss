package com.opos.cmn.func.dl.base.c;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.func.dl.base.exception.DlException;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7977a;

    @Override // com.opos.cmn.func.dl.base.c.e
    public final String a() {
        return this.f7977a;
    }

    @Override // com.opos.cmn.func.dl.base.c.e
    public final void a(Context context, d dVar, String str, b bVar) throws DlException {
        com.opos.cmn.an.f.a.a("RedirectHandler", "RedirectHandler process ,url=".concat(String.valueOf(str)));
        int iD = dVar.d();
        this.f7977a = "";
        a aVar = (a) dVar;
        aVar.a((d) null);
        int i = 0;
        while (true) {
            if (!(iD == 301 || iD == 302 || iD == 303 || iD == 300 || iD == 307 || iD == 308)) {
                if (TextUtils.isEmpty(this.f7977a) || !com.opos.cmn.func.dl.base.i.a.a(iD)) {
                    return;
                }
                aVar.a(dVar);
                return;
            }
            dVar.c();
            i++;
            if (i > 5) {
                throw new DlException(1002);
            }
            String strA = dVar.a(HttpHeaders.LOCATION);
            if (strA == null) {
                throw new DlException(1002);
            }
            this.f7977a = strA;
            dVar = new c();
            dVar.a(context, this.f7977a, bVar);
            iD = dVar.d();
        }
    }
}
