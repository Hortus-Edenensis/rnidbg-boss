package com.bytedance.sdk.openadsdk.core.ugeno.iz;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.b.jk;
import com.bytedance.sdk.component.adexpress.pn.pn;
import com.bytedance.sdk.component.adexpress.u.fx.u;
import com.bytedance.sdk.component.adexpress.u.nr.b;
import com.bytedance.sdk.component.adexpress.u.nr.fx;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.jk.x;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.ugeno.x.nr;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends fx {
    private static volatile File fx;
    private static AtomicReference<nr> pn = new AtomicReference<>(null);
    private static volatile u u;
    private AtomicBoolean nr = new AtomicBoolean(false);
    private AtomicBoolean b = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            if (pn.get() != null) {
                return;
            }
            File file = new File(u(), "package_ugen_temp.json");
            Long lValueOf = Long.valueOf(file.length());
            if (lValueOf.longValue() > 0 && file.exists() && file.isFile()) {
                byte[] bArr = new byte[lValueOf.intValue()];
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                    pn.set(nr.nr(new JSONObject(new String(bArr, "utf-8"))));
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                    return;
                } catch (IOException unused) {
                    return;
                }
            }
            return;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
        try {
            k.u("PlayComponentEngineCacheManager", "version init error", th);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                }
            }
        } catch (Throwable th4) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th4;
        }
    }

    public static u nr() {
        if (u == null) {
            synchronized (u.class) {
                if (u == null) {
                    u = new u();
                }
            }
        }
        return u;
    }

    public void b() {
        try {
            if (this.nr.get()) {
                return;
            }
            boolean z = true;
            this.nr.set(true);
            nr nrVar = new nr(dw.u().u(2));
            nr nrVar2 = pn.get();
            if (!nrVar.iz()) {
                this.nr.set(false);
                return;
            }
            if (!fx.u(nrVar2, nrVar.fx())) {
                this.nr.set(false);
                return;
            }
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.iz.u.2
                @Override // java.lang.Runnable
                public void run() {
                    pn.u().nr();
                }
            });
            List<u.C0206u> listNr = nr(nrVar, nrVar2);
            if (listNr == null) {
                z = false;
            }
            if (listNr == null) {
                this.nr.set(false);
            }
            if (z && u(nrVar.getResources())) {
                pn.set(nrVar);
                fx.u(u(), pn.get(), "package_ugen_temp.json");
                nr(listNr);
            }
            x();
            this.nr.set(false);
        } catch (Throwable unused) {
        }
    }

    public void fx() {
        x.u(new a("enginecache-init") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.iz.u.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    u.this.a();
                    u.this.x();
                    u.this.b();
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void iz() {
        try {
            pn();
            File fileU = u();
            if (fileU == null || !fileU.exists()) {
                return;
            }
            if (fileU.getParentFile() != null) {
                n.fx(fileU.getParentFile());
            } else {
                n.fx(fileU);
            }
        } catch (Throwable unused) {
        }
    }

    public boolean n() {
        AtomicBoolean atomicBoolean = this.b;
        return atomicBoolean != null && atomicBoolean.get();
    }

    public void pn() {
        fx.nr(u(), pn.get(), "package_ugen_temp.json");
        pn.set(null);
    }

    public void x() {
        nr nrVar = pn.get();
        if (nrVar == null || !nrVar.iz()) {
            return;
        }
        boolean zU = u(nrVar.getResources());
        if (!zU) {
            pn();
        }
        this.b.set(zU);
    }

    @Override // com.bytedance.sdk.component.adexpress.u.nr.fx
    public File u() {
        if (fx == null) {
            try {
                File file = new File(new File(b.u(), "tt_ugen_pkg"), "engine");
                file.mkdirs();
                fx = file;
            } catch (Throwable th) {
                k.u("PlayComponentEngineCacheManager", "ge", th);
            }
        }
        return fx;
    }

    private File nr(String str) {
        nr nrVar;
        if (!n() || (nrVar = pn.get()) == null) {
            return null;
        }
        for (u.C0206u c0206u : nrVar.getResources()) {
            if (c0206u.u() != null && c0206u.u().equals(str)) {
                File file = new File(u(), com.bytedance.sdk.component.utils.x.nr(c0206u.u()));
                String strU = com.bytedance.sdk.component.utils.x.u(file);
                if (c0206u.nr() == null || !c0206u.nr().equals(strU)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    public WebResourceResponse u(WebView webView, jk.u uVar, String str) {
        File fileNr;
        try {
            if (TextUtils.isEmpty(str) || uVar == jk.u.IMAGE || (fileNr = nr(str)) == null) {
                return null;
            }
            return new WebResourceResponse(uVar.getType(), "utf-8", new FileInputStream(fileNr));
        } catch (Throwable th) {
            k.u("PlayComponentEngineCacheManager", "grwe", th);
            return null;
        }
    }
}
