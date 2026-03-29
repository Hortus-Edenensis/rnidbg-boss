package com.ss.android.socialbase.appdownloader.u;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class l extends u {
    public l(Context context, com.ss.android.socialbase.downloader.n.u uVar, String str) {
        super(context, uVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.u.pn
    public Intent nr() {
        String strFx = this.nr.fx("s");
        String strU = com.ss.android.socialbase.appdownloader.iz.fx.u(this.nr.fx("ag"), strFx);
        String strU2 = com.ss.android.socialbase.appdownloader.iz.fx.u(this.nr.fx("ah"), strFx);
        String strU3 = com.ss.android.socialbase.appdownloader.iz.fx.u(this.nr.fx("ai"), strFx);
        String strU4 = com.ss.android.socialbase.appdownloader.iz.fx.u(this.nr.fx("aj"), strFx);
        Intent intent = new Intent();
        intent.putExtra(strU, this.fx);
        intent.putExtra(strU2, "*/*");
        intent.putExtra(strU3, true);
        intent.setAction(strU4);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        return intent;
    }
}
