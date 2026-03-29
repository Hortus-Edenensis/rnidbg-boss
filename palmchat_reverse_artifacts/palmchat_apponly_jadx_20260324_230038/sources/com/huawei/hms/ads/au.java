package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class au extends ah {
    private static final String Z = "CmdBaseDownload";

    public au(String str) {
        super(str);
    }

    public IAppDownloadManager V(Context context, String str) {
        IAppDownloadManager iAppDownloadManagerCode = com.huawei.hms.ads.jsb.a.Code(context).Code();
        iAppDownloadManagerCode.Code(B(str));
        if (com.huawei.openalliance.ad.utils.z.B(context)) {
            iAppDownloadManagerCode.Code(true);
        }
        return iAppDownloadManagerCode;
    }
}
