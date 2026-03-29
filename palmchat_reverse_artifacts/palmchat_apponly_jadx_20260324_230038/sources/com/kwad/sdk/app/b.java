package com.kwad.sdk.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.components.p;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b {
    private static final Map<String, String> azd = new HashMap();
    private final AtomicBoolean RD;
    private final AtomicBoolean aze;
    private final AtomicBoolean azf;
    private final AtomicBoolean azg;
    private final List<String> azh;
    private final List<String> azi;
    private final d azj;
    private final BroadcastReceiver azk;
    private Context mContext;
    private final List<com.kwad.sdk.app.a> mListeners;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private static final b azn = new b(0);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Context context, @NonNull String str) {
        c.d("AppInstallManager", "installApp packageName: " + str);
        F(context, str);
        cK(str);
        D(context, str);
    }

    private void D(Context context, String str) {
        com.kwad.sdk.core.c.b.Ji();
        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
            E(context, str);
            return;
        }
        this.azh.add(str);
        com.kwad.sdk.core.c.b.Ji();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.app.b.4
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                if (b.this.azh.size() > 0) {
                    for (int i = 0; i < b.this.azh.size(); i++) {
                        b.E(b.this.mContext, (String) b.this.azh.get(i));
                    }
                    b.this.azh.clear();
                }
                com.kwad.sdk.core.c.b.Ji();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void E(Context context, @NonNull String str) {
        try {
            p pVar = (p) com.kwad.sdk.components.d.f(p.class);
            if (pVar == null || !s.RL()) {
                return;
            }
            ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).e(pVar.e(context, str), 1);
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
    }

    private static void F(Context context, String str) {
        str.hashCode();
        switch (str) {
            case "com.tencent.mm":
                azd.put("com.tencent.mm", m.Q(context, "com.tencent.mm"));
                break;
            case "com.kuaishou.nebula":
                azd.put("com.kuaishou.nebula", m.Q(context, "com.kuaishou.nebula"));
                break;
            case "com.smile.gifmaker":
                azd.put("com.smile.gifmaker", m.Q(context, "com.smile.gifmaker"));
                break;
        }
    }

    public static b Fi() {
        return a.azn;
    }

    private void Fj() {
        com.kwad.sdk.core.c.b.Ji();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.app.b.2
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                try {
                    b.this.Fn();
                } catch (Throwable th) {
                    c.printStackTraceOnly(th);
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                try {
                    b.this.Fm();
                    b.this.Fo();
                } catch (Throwable th) {
                    c.printStackTraceOnly(th);
                }
            }
        });
    }

    private void Fk() {
        if (this.azg.get()) {
            return;
        }
        com.kwad.sdk.core.c.b.Ji();
        com.kwad.sdk.core.c.b.a(this.azj);
        this.azg.set(true);
    }

    private void Fl() {
        if (this.azg.get()) {
            com.kwad.sdk.core.c.b.Ji();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this.azj);
            this.azg.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fm() {
        Context contextRe = ServiceProvider.Re();
        bp(contextRe);
        Iterator<AdTemplate> it = ((f) ServiceProvider.get(f.class)).CZ().iterator();
        while (it.hasNext()) {
            AdInfo adInfoEr = e.er(it.next());
            int iBC = com.kwad.sdk.core.response.b.a.bC(adInfoEr);
            String strAz = com.kwad.sdk.core.response.b.a.az(adInfoEr);
            if (iBC != 12) {
                if (as.at(contextRe, strAz)) {
                    C(contextRe, strAz);
                }
            } else if (!as.at(contextRe, strAz)) {
                cH(strAz);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fn() {
        if (this.RD.get()) {
            ServiceProvider.Re().unregisterReceiver(this.azk);
            this.RD.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fo() {
        if (this.RD.get()) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        ServiceProvider.Re().registerReceiver(this.azk, intentFilter);
        this.RD.set(true);
    }

    private synchronized void bo(Context context) {
        if (this.aze.get()) {
            return;
        }
        F(context, "com.smile.gifmaker");
        F(context, "com.kuaishou.nebula");
        F(context, "com.tencent.mm");
        this.aze.set(true);
    }

    private void bp(Context context) {
        if (this.aze.get()) {
            for (String str : azd.keySet()) {
                String str2 = azd.get(str);
                String strQ = m.Q(context, str);
                if (!TextUtils.isEmpty(strQ) && !TextUtils.equals(str2, strQ)) {
                    C(context, str);
                } else if (TextUtils.isEmpty(strQ) && !TextUtils.isEmpty(str2)) {
                    cH(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cH(@NonNull String str) {
        c.d("AppInstallManager", "unInstallApp packageName: " + str);
        cM(str);
        cL(str);
        cI(str);
    }

    private void cI(String str) {
        com.kwad.sdk.core.c.b.Ji();
        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
            cJ(str);
            return;
        }
        this.azi.add(str);
        com.kwad.sdk.core.c.b.Ji();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.app.b.5
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                if (b.this.azi.size() > 0) {
                    for (int i = 0; i < b.this.azi.size(); i++) {
                        b.cJ((String) b.this.azi.get(i));
                    }
                    b.this.azi.clear();
                }
                com.kwad.sdk.core.c.b.Ji();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cJ(@NonNull String str) {
        try {
            p pVar = (p) com.kwad.sdk.components.d.f(p.class);
            if (pVar == null || !s.RL()) {
                return;
            }
            ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).e(pVar.C(str), 2);
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
    }

    private void cK(String str) {
        Iterator<com.kwad.sdk.app.a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().U(str);
            } catch (Throwable th) {
                c.printStackTrace(th);
            }
        }
    }

    private void cL(String str) {
        Iterator<com.kwad.sdk.app.a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().V(str);
            } catch (Throwable th) {
                c.printStackTrace(th);
            }
        }
    }

    private static void cM(String str) {
        str.hashCode();
        switch (str) {
            case "com.tencent.mm":
                azd.put("com.tencent.mm", "");
                break;
            case "com.kuaishou.nebula":
                azd.put("com.kuaishou.nebula", "");
                break;
            case "com.smile.gifmaker":
                azd.put("com.smile.gifmaker", "");
                break;
        }
    }

    public final String getVersion(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        bo(context);
        return azd.get(str);
    }

    public final synchronized void init() {
        try {
            if (this.azf.get()) {
                return;
            }
            if (((h) ServiceProvider.get(h.class)).DD()) {
                Fl();
                if (((h) ServiceProvider.get(h.class)).DC()) {
                    com.kwad.sdk.core.c.b.Ji();
                    if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        Fo();
                    }
                    Fj();
                } else {
                    Fo();
                }
                this.azf.set(true);
            }
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
    }

    private b() {
        this.aze = new AtomicBoolean();
        this.azf = new AtomicBoolean();
        this.RD = new AtomicBoolean();
        this.azg = new AtomicBoolean();
        this.mListeners = new CopyOnWriteArrayList();
        this.azh = new CopyOnWriteArrayList();
        this.azi = new CopyOnWriteArrayList();
        this.azj = new d() { // from class: com.kwad.sdk.app.b.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                try {
                    b.this.Fm();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        this.azk = new BroadcastReceiver() { // from class: com.kwad.sdk.app.b.3
            Intent azm;

            private boolean d(Intent intent) {
                boolean z = TextUtils.equals(this.azm.getAction(), intent.getAction()) && this.azm.getFlags() == intent.getFlags() && TextUtils.equals(this.azm.getDataString(), intent.getDataString());
                this.azm = intent;
                return z;
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                Uri data;
                if (intent == null) {
                    return;
                }
                try {
                    if (this.azm == null) {
                        this.azm = intent;
                    } else if (d(intent)) {
                        return;
                    }
                    c.d("AppInstallManager", "onReceive intent: " + intent.toString());
                    String action = intent.getAction();
                    if (TextUtils.isEmpty(action) || (data = intent.getData()) == null) {
                        return;
                    }
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    if (TextUtils.isEmpty(schemeSpecificPart)) {
                        return;
                    }
                    b.this.mContext = context;
                    if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", action)) {
                        b.this.C(context, schemeSpecificPart);
                    } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", action)) {
                        b.this.cH(schemeSpecificPart);
                    }
                } catch (Throwable th) {
                    c.printStackTrace(th);
                }
            }
        };
    }

    public final void b(com.kwad.sdk.app.a aVar) {
        if (aVar == null) {
            return;
        }
        Fk();
        this.mListeners.remove(aVar);
    }

    public final void a(com.kwad.sdk.app.a aVar) {
        if (aVar == null) {
            return;
        }
        Fk();
        this.mListeners.add(aVar);
    }
}
