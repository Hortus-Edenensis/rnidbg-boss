package com.ss.android.downloadlib.nr;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.x.mv;
import com.ss.android.socialbase.downloader.u.u;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class iz {
    private static Handler u = new Handler(Looper.getMainLooper());

    private static int a(com.ss.android.downloadad.api.u.nr nrVar) {
        return com.ss.android.downloadlib.x.pn.u((com.ss.android.downloadad.api.u.u) nrVar).u("app_link_check_delay", 1);
    }

    public static boolean b(com.ss.android.downloadad.api.u.nr nrVar) {
        return com.ss.android.downloadlib.x.pn.u((com.ss.android.downloadad.api.u.u) nrVar).nr("app_link_opt_dialog_switch") == 1;
    }

    public static boolean fx(com.ss.android.downloadad.api.u.nr nrVar) {
        return com.ss.android.downloadlib.x.pn.u((com.ss.android.downloadad.api.u.u) nrVar).nr("app_link_opt_invoke_switch") == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int jk(com.ss.android.downloadad.api.u.nr nrVar) {
        return com.ss.android.downloadlib.x.pn.u((com.ss.android.downloadad.api.u.u) nrVar).u("app_link_check_count", 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long n(com.ss.android.downloadad.api.u.nr nrVar) {
        return com.ss.android.downloadlib.x.pn.u((com.ss.android.downloadad.api.u.u) nrVar).u("app_link_check_timeout", 300000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(@NonNull final com.ss.android.downloadad.api.u.nr nrVar, final int i) {
        if (i <= 0) {
            return;
        }
        com.ss.android.downloadlib.pn.u().u(new Runnable() { // from class: com.ss.android.downloadlib.nr.iz.2
            @Override // java.lang.Runnable
            public void run() {
                int i2 = 1;
                if (!mv.fx(nrVar.pn())) {
                    iz.nr(nrVar, i - 1);
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!nrVar.nb()) {
                        i2 = 2;
                    }
                    jSONObject.putOpt("deeplink_source", Integer.valueOf(i2));
                } catch (JSONException unused) {
                }
                com.ss.android.downloadlib.b.u.u().u("deeplink_success_2", jSONObject, nrVar);
            }
        }, a(nrVar) * 1000);
    }

    public static long pn(com.ss.android.downloadad.api.u.nr nrVar) {
        if (nrVar == null) {
            return 3000L;
        }
        return com.ss.android.downloadlib.x.pn.u((com.ss.android.downloadad.api.u.u) nrVar).u("app_link_opt_back_time_limit", 3) * 1000;
    }

    public static void u(final com.ss.android.downloadad.api.u.nr nrVar, @NonNull final n nVar) {
        boolean zNr = com.ss.android.socialbase.downloader.u.u.u().nr();
        if (!zNr && Build.VERSION.SDK_INT >= 29) {
            mv.fx();
        }
        boolean zNr2 = com.ss.android.socialbase.downloader.u.u.u().nr();
        boolean z = !zNr && zNr2;
        if (nrVar != null) {
            nrVar.l(z);
        }
        nVar.u(z);
        if (nrVar == null) {
            return;
        }
        nr(nrVar, jk(nrVar));
        if (zNr2) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.ss.android.socialbase.downloader.u.u.u().u(new u.InterfaceC0886u() { // from class: com.ss.android.downloadlib.nr.iz.1
            @Override // com.ss.android.socialbase.downloader.u.u.InterfaceC0886u
            public void nr() {
                com.ss.android.socialbase.downloader.u.u.u().nr(this);
                com.ss.android.downloadlib.pn.u().u(new Runnable() { // from class: com.ss.android.downloadlib.nr.iz.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean zFx = mv.fx(nrVar.pn());
                        long jPn = iz.pn(nrVar);
                        if (!zFx || jPn >= System.currentTimeMillis() - jCurrentTimeMillis) {
                            long jN = iz.n(nrVar);
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (jCurrentTimeMillis2 - jCurrentTimeMillis > jN) {
                                com.ss.android.downloadlib.b.u.u().u("deeplink_delay_timeout", nrVar);
                                return;
                            }
                            nrVar.l(true);
                            com.ss.android.downloadlib.b.u.u().u("deeplink_delay_invoke", nrVar);
                            nVar.u(true);
                            com.ss.android.downloadad.api.u.nr nrVar2 = nrVar;
                            iz.nr(nrVar2, iz.jk(nrVar2));
                        }
                    }
                });
            }

            @Override // com.ss.android.socialbase.downloader.u.u.InterfaceC0886u
            public void fx() {
            }
        });
    }

    public static boolean nr(com.ss.android.downloadad.api.u.nr nrVar) {
        return com.ss.android.downloadlib.x.pn.u((com.ss.android.downloadad.api.u.u) nrVar).nr("app_link_opt_install_switch") == 1;
    }

    public static boolean u(com.ss.android.downloadad.api.u.nr nrVar) {
        return com.ss.android.downloadlib.x.pn.u((com.ss.android.downloadad.api.u.u) nrVar).nr("app_link_opt_switch") == 1;
    }
}
