package com.ss.android.socialbase.appdownloader.u;

import android.content.Context;
import com.bytedance.sdk.component.utils.k;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class u implements pn {
    protected final String fx;
    protected final com.ss.android.socialbase.downloader.n.u nr;
    protected final Context u;

    public u(Context context, com.ss.android.socialbase.downloader.n.u uVar, String str) {
        this.u = context;
        this.nr = uVar;
        this.fx = str;
    }

    public boolean u() {
        if (this.u == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            if (com.ss.android.socialbase.downloader.fx.u.u()) {
                k.u("AbsDevicePlan", "check is valid failed!", th);
            }
        }
        return nr().resolveActivity(this.u.getPackageManager()) != null;
    }
}
