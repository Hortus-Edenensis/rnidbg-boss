package com.bytedance.sdk.openadsdk.core.y;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.openadsdk.core.kj.d;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class oa {
    private static volatile oa u;
    private final Set<String> fx = Collections.synchronizedSet(new HashSet());
    private String nr;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private final String u;
        private final AtomicInteger nr = new AtomicInteger(0);
        private final AtomicInteger fx = new AtomicInteger(0);

        public u(String str) {
            this.u = str;
        }

        public int b() {
            return this.nr.get();
        }

        public String fx() {
            return this.u;
        }

        public void nr() {
            this.fx.incrementAndGet();
        }

        public int pn() {
            return this.fx.get();
        }

        public void u() {
            this.nr.incrementAndGet();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String fx(String str) {
        File file = new File(nr(), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private void nr(File file) {
        try {
            if (file.exists()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (file.setLastModified(jCurrentTimeMillis)) {
                    return;
                }
                file.renameTo(file);
                if (file.lastModified() < jCurrentTimeMillis) {
                    new Date(file.lastModified());
                    file.getAbsolutePath();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static oa u() {
        if (u == null) {
            synchronized (oa.class) {
                if (u == null) {
                    u = new oa();
                }
            }
        }
        return u;
    }

    private String nr() {
        if (TextUtils.isEmpty(this.nr)) {
            try {
                File file = new File(com.bytedance.sdk.openadsdk.api.plugin.nr.nr(com.bytedance.sdk.openadsdk.core.dw.getContext()), "tt_web_resource");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.nr = file.getAbsolutePath();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.k.nr("WebCacheResourceManager", "init root path error: ".concat(String.valueOf(th)));
            }
        }
        return this.nr;
    }

    public void u(List<d.fx> list, d.u uVar) {
        nr(list, uVar);
        Iterator<d.fx> it = list.iterator();
        while (it.hasNext()) {
            u(it.next(), uVar);
        }
    }

    private void u(final d.fx fxVar, final d.u uVar) {
        File[] fileArrListFiles;
        d.b bVarFx = fxVar.fx();
        final String strU = fxVar.fx().u();
        if (this.fx.contains(strU)) {
            return;
        }
        File file = new File(nr());
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    String name = file2.getName();
                    String strSubstring = name.substring(0, name.indexOf("$"));
                    String strSubstring2 = name.substring(name.indexOf("$") + 1);
                    if (!strSubstring.equals(fxVar.u())) {
                        continue;
                    } else {
                        if (strSubstring2.equals(com.bytedance.sdk.component.utils.x.nr(bVarFx.nr()))) {
                            return;
                        }
                        com.bytedance.sdk.component.utils.n.fx(file2);
                        if (uVar != null) {
                            uVar.nr(nr(fxVar.u()));
                        }
                    }
                }
            }
        }
        this.fx.add(strU);
        File file3 = new File(nr(), com.bytedance.sdk.component.utils.x.nr(strU));
        com.bytedance.sdk.component.a.nr.nr nrVarB = com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().b();
        nrVarB.u(strU);
        nrVarB.u(file3.getParent(), file3.getName());
        nrVarB.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.y.oa.1
            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, final com.bytedance.sdk.component.a.nr nrVar) {
                oa.this.fx.remove(strU);
                if (nrVar.a() && nrVar.n() != null && nrVar.n().exists()) {
                    com.bytedance.sdk.component.jk.x.u(new com.bytedance.sdk.component.jk.a("downloadZip") { // from class: com.bytedance.sdk.openadsdk.core.y.oa.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                String absolutePath = nrVar.n().getAbsolutePath();
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                com.bytedance.sdk.component.utils.bf.u(absolutePath, oa.this.fx(fxVar.b()));
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                d.u uVar2 = uVar;
                                if (uVar2 != null) {
                                    uVar2.u(fxVar);
                                }
                            } catch (Throwable th) {
                                StringBuilder sb = new StringBuilder("unzip web resources failed：");
                                AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                                sb.append(oa.this.fx(fxVar.b()));
                                com.bytedance.sdk.component.utils.k.u("WebCacheResourceManager", sb.toString(), th);
                            }
                            try {
                                nrVar.n().delete();
                            } catch (Throwable unused) {
                            }
                        }
                    }, 5);
                    return;
                }
                com.bytedance.sdk.component.utils.k.nr("WebCacheResourceManager", "download resources failed 1：" + strU);
            }

            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
                oa.this.fx.remove(strU);
                com.bytedance.sdk.component.utils.k.nr("WebCacheResourceManager", "download resources failed 2：" + strU);
            }
        });
    }

    public void nr(List<d.fx> list, d.u uVar) {
        File[] fileArrListFiles;
        boolean z;
        File file = new File(nr());
        if (!file.exists() || (fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.core.y.oa.2
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.isDirectory();
            }
        })) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            String strSubstring = file2.getName().substring(0, file2.getName().indexOf("$"));
            Iterator<d.fx> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().u().equals(strSubstring)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                com.bytedance.sdk.component.utils.n.fx(file2);
                if (uVar != null) {
                    uVar.nr(nr(strSubstring));
                }
            }
        }
    }

    public static d.fx nr(String str) {
        if (com.bytedance.sdk.openadsdk.core.kj.d.u().isEmpty()) {
            return null;
        }
        for (d.fx fxVar : com.bytedance.sdk.openadsdk.core.kj.d.u()) {
            if (fxVar.u().equals(str)) {
                return fxVar;
            }
        }
        return null;
    }

    private void u(File file) {
        nr(file);
        try {
            com.bytedance.sdk.openadsdk.core.n.o().bc().u(file);
        } catch (Throwable unused) {
        }
    }

    public List<d.fx> u(String str) {
        if (!com.bytedance.sdk.openadsdk.core.kj.d.u || com.bytedance.sdk.openadsdk.core.kj.d.u().isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            String path = new URL(str).getPath();
            if (path != null && !path.isEmpty()) {
                for (d.fx fxVar : com.bytedance.sdk.openadsdk.core.kj.d.u()) {
                    if (path.contains(fxVar.nr())) {
                        arrayList.add(fxVar);
                    }
                }
                return arrayList;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public WebResourceResponse u(WebResourceResponse webResourceResponse, String str, List<d.fx> list, Map<String, u> map) {
        u uVar;
        try {
            String path = new URL(str).getPath();
            if (map != null) {
                uVar = map.get(path);
                if (uVar == null) {
                    uVar = new u(path);
                    map.put(path, uVar);
                }
            } else {
                uVar = new u(path);
            }
            String strU = "text/html";
            for (d.fx fxVar : list) {
                File file = new File(fx(fxVar.b()), path.substring(path.indexOf(fxVar.nr())).replace(fxVar.nr(), ""));
                if (file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    if (webResourceResponse == null) {
                        Iterator<d.nr> it = fxVar.fx().fx().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            d.nr next = it.next();
                            if (TextUtils.equals(next.nr(), file.getName())) {
                                strU = next.u();
                                break;
                            }
                        }
                        WebResourceResponse webResourceResponse2 = new WebResourceResponse(strU, "utf-8", fileInputStream);
                        try {
                            uVar.u();
                            webResourceResponse = webResourceResponse2;
                        } catch (Exception unused) {
                            return webResourceResponse2;
                        }
                    }
                    webResourceResponse.setData(fileInputStream);
                    u(new File(fx(fxVar.b())));
                    return webResourceResponse;
                }
            }
            uVar.nr();
            return webResourceResponse;
        } catch (Exception unused2) {
            return webResourceResponse;
        }
    }

    public void u(d.u uVar) {
        try {
            for (File file : new File(nr()).listFiles()) {
                if (System.currentTimeMillis() - file.lastModified() >= com.igexin.push.f.b.d.b) {
                    try {
                        com.bytedance.sdk.component.utils.n.fx(file);
                        String name = file.getName();
                        String strSubstring = name.substring(0, name.indexOf("$"));
                        if (uVar != null) {
                            uVar.nr(nr(strSubstring));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }
}
