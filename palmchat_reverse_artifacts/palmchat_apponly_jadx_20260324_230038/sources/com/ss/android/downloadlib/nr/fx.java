package com.ss.android.downloadlib.nr;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.x.mv;
import com.ss.android.socialbase.downloader.u.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class fx {
    public static void u(final com.ss.android.downloadad.api.u.nr nrVar, @NonNull final com.ss.android.downloadlib.guide.install.u uVar) {
        boolean zNr = com.ss.android.socialbase.downloader.u.u.u().nr();
        if (!zNr && Build.VERSION.SDK_INT >= 29) {
            mv.fx();
        }
        boolean zNr2 = com.ss.android.socialbase.downloader.u.u.u().nr();
        if (!zNr && zNr2 && nrVar != null) {
            nrVar.l(true);
        }
        uVar.u();
        com.ss.android.socialbase.downloader.fx.u.nr("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::".concat(String.valueOf(zNr2)));
        if (zNr2) {
            return;
        }
        com.ss.android.socialbase.downloader.u.u.u().u(new u.InterfaceC0886u() { // from class: com.ss.android.downloadlib.nr.fx.1
            @Override // com.ss.android.socialbase.downloader.u.u.InterfaceC0886u
            public void nr() {
                com.ss.android.socialbase.downloader.fx.u.nr("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                com.ss.android.socialbase.downloader.u.u.u().nr(this);
                if (mv.nr(nrVar)) {
                    return;
                }
                nrVar.mv(true);
                com.ss.android.downloadlib.b.u.u().u("install_delay_invoke", nrVar);
                uVar.u();
            }

            @Override // com.ss.android.socialbase.downloader.u.u.InterfaceC0886u
            public void fx() {
            }
        });
    }
}
