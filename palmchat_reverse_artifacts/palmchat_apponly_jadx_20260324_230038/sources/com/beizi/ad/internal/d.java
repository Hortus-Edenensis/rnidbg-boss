package com.beizi.ad.internal;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class d extends com.beizi.ad.internal.e.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4391a;

    public d(String str) {
        super(false, false);
        this.f4391a = str;
    }

    @Override // com.beizi.ad.internal.e.d, android.os.AsyncTask
    /* JADX INFO: renamed from: a */
    public void onPostExecute(com.beizi.ad.internal.e.e eVar) {
        if (eVar == null || !eVar.a()) {
            return;
        }
        int iC = eVar.c();
        String strD = eVar.d();
        if (iC != 302 || TextUtils.isEmpty(strD)) {
            return;
        }
        new d(strD).execute(new Void[0]);
    }

    @Override // com.beizi.ad.internal.e.d
    public String a() {
        return this.f4391a;
    }
}
