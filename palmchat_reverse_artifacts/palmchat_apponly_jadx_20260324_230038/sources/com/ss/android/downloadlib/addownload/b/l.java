package com.ss.android.downloadlib.addownload.b;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.k;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class l implements a {
    @Override // com.ss.android.downloadlib.addownload.b.a
    public boolean u(com.ss.android.downloadad.api.u.nr nrVar, int i, n nVar) {
        if (nrVar == null) {
            return false;
        }
        return k.u(nrVar, !TextUtils.isEmpty(nrVar.f()) ? com.ss.android.downloadlib.jk.u((Context) null).u(nrVar.f(), null, true) : com.ss.android.downloadlib.jk.u((Context) null).nr(nrVar.u()), i, nVar, false, null);
    }
}
