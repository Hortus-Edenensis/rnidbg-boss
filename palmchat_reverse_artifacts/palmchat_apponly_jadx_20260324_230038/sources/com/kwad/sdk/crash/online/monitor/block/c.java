package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.n.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c {
    private static volatile boolean aUK;

    private static String a(com.kwad.sdk.crash.online.monitor.a.b bVar) {
        String str = new String(com.kwad.sdk.core.a.c.Jb().decode((bVar == null || TextUtils.isEmpty(bVar.aVd)) ? "b25SZXBvcnRJc3N1ZQ==" : bVar.aVd));
        com.kwad.sdk.core.d.c.d("perfMonitor.Injector", "report methodName:" + str);
        return str;
    }

    public static void b(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        if (aUK) {
            return;
        }
        try {
            com.kwad.sdk.crash.online.monitor.a.b bVarC = c(aVar);
            com.kwad.sdk.n.e.a(b(bVarC), a(bVarC), new e.a() { // from class: com.kwad.sdk.crash.online.monitor.block.c.1
                @Override // com.kwad.sdk.n.e.a
                public final void a(String str, long j, long j2, String str2, String str3) {
                    f.a(str, j, j2, str2, str3, false);
                }

                @Override // com.kwad.sdk.n.e.a
                public final void onError(String str) {
                    c.onError(str);
                }
            });
            aUK = true;
        } catch (Exception e) {
            onError(Log.getStackTraceString(e));
        }
    }

    private static com.kwad.sdk.crash.online.monitor.a.b c(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        h hVar = (h) ServiceProvider.get(h.class);
        String appId = hVar != null ? hVar.getAppId() : "";
        if (TextUtils.isEmpty(appId)) {
            return null;
        }
        return aVar.gd(appId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onError(String str) {
        f.gc(str);
        com.kwad.sdk.core.d.c.w("perfMonitor.Injector", str);
    }

    private static String b(com.kwad.sdk.crash.online.monitor.a.b bVar) {
        String str = new String(com.kwad.sdk.core.a.c.Jb().decode((bVar == null || TextUtils.isEmpty(bVar.aVc)) ? "Y29tLnRlbmNlbnQubWF0cml4LnBsdWdpbi5QbHVnaW5MaXN0ZW5lcg==" : bVar.aVc));
        com.kwad.sdk.core.d.c.d("perfMonitor.Injector", "ListenerName:" + str);
        return str;
    }
}
