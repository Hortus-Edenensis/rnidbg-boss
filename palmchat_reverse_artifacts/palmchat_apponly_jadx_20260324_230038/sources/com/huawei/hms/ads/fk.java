package com.huawei.hms.ads;

import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class fk extends ff {
    private static final String I = "HiAdLog";
    private static final int V = 60;
    private final Executor B = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.huawei.openalliance.ad.utils.j("FileLog"));
    private final fm Z;

    public fk(fm fmVar) {
        this.Z = fmVar;
    }

    @Override // com.huawei.hms.ads.fm
    public fm Code(final String str, final String str2) {
        this.B.execute(new Runnable() { // from class: com.huawei.hms.ads.fk.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    fk.this.Z.Code(str, str2);
                } catch (Throwable th) {
                    Log.w(fk.I, "init err: " + th.getClass().getSimpleName());
                }
            }
        });
        fm fmVar = this.Code;
        if (fmVar != null) {
            fmVar.Code(str, str2);
        }
        return this;
    }

    @Override // com.huawei.hms.ads.fm
    public void Code(final fo foVar, final int i, final String str) {
        this.B.execute(new Runnable() { // from class: com.huawei.hms.ads.fk.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    fk.this.Z.Code(foVar, i, str);
                } catch (Throwable th) {
                    Log.w(fk.I, "log err: " + th.getClass().getSimpleName());
                }
            }
        });
        fm fmVar = this.Code;
        if (fmVar != null) {
            fmVar.Code(foVar, i, str);
        }
    }
}
