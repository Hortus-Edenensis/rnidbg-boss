package com.ss.android.socialbase.appdownloader.u;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class n extends u {
    public n(Context context, com.ss.android.socialbase.downloader.n.u uVar, String str) {
        super(context, uVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.u.pn
    public Intent nr() {
        Intent intent = new Intent(com.ss.android.socialbase.downloader.constants.pn.fx + ".intent.action.OPEN_FILEMANAGER");
        intent.putExtra("CurrentDir", this.fx);
        intent.putExtra("first_position", 1);
        intent.putExtra("CurrentMode", 1);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
