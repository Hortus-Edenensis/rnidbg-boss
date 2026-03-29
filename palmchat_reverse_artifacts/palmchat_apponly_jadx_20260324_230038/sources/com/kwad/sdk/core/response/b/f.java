package com.kwad.sdk.core.response.b;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class f {
    private static volatile f aNC;
    private String aND = KM();

    private f() {
    }

    public static f KK() {
        if (aNC == null) {
            synchronized (f.class) {
                if (aNC == null) {
                    aNC = new f();
                }
            }
        }
        return aNC;
    }

    @Nullable
    @WorkerThread
    private static String KM() {
        try {
            return w.a(new File(be.dV(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())), Charset.forName("UTF-8"));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    @WorkerThread
    private static void eQ(String str) {
        try {
            w.a(new File(be.dV(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())), str, Charset.forName("UTF-8"), false);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    @Nullable
    @WorkerThread
    public final String KL() {
        return this.aND;
    }

    @WorkerThread
    public final void eP(String str) {
        if (bp.isEquals(this.aND, str)) {
            return;
        }
        this.aND = str;
        eQ(str);
    }
}
