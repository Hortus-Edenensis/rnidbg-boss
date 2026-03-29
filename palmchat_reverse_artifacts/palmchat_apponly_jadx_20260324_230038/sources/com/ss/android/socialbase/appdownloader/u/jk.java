package com.ss.android.socialbase.appdownloader.u;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class jk extends u {
    public jk(Context context, com.ss.android.socialbase.downloader.n.u uVar, String str) {
        super(context, uVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.u.pn
    public Intent nr() {
        Intent intent = new Intent("com.android.filemanager.FILE_OPEN");
        intent.putExtra("FilePathToBeOpenAfterScan", this.fx);
        intent.putExtra("com.iqoo.secure", true);
        intent.putExtra("OpenParentAndLocationDestFile", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
