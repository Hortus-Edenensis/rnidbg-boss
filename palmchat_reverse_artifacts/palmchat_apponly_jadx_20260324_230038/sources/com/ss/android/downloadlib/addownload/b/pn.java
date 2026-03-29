package com.ss.android.downloadlib.addownload.b;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.k;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class pn implements x {
    @Override // com.ss.android.downloadlib.addownload.b.x
    public boolean u(com.ss.android.downloadad.api.u.nr nrVar, int i, n nVar, com.ss.android.downloadlib.addownload.u.fx fxVar) {
        if (nrVar == null) {
            return false;
        }
        return k.u(nrVar, !TextUtils.isEmpty(nrVar.f()) ? com.ss.android.downloadlib.jk.u(com.ss.android.downloadlib.addownload.l.getContext()).u(nrVar.f(), null, true) : com.ss.android.downloadlib.jk.u(com.ss.android.downloadlib.addownload.l.getContext()).nr(nrVar.u()), i, nVar, true, fxVar);
    }
}
