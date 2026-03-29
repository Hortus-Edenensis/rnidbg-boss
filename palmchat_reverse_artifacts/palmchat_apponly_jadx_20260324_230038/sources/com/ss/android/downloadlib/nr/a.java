package com.ss.android.downloadlib.nr;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.l;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {
    public static boolean u(@NonNull com.ss.android.downloadad.api.u.u uVar) {
        return com.ss.android.socialbase.appdownloader.iz.pn.pn() && Build.VERSION.SDK_INT < 29 && l.l() != null && l.l().u() && com.ss.android.downloadlib.x.pn.u(uVar).nr("invoke_app_form_background_switch") == 1 && uVar.o();
    }
}
