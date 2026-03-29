package com.kwad.sdk.core.webview.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.webview.b.b.a;
import com.kwad.sdk.core.webview.b.c.b;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile a aSi;
    private long acP;
    private Context mContext;
    private volatile boolean mHasInit = false;
    private final List<com.kwad.sdk.h.a.b> aSj = new CopyOnWriteArrayList();
    private final List<String> aSk = new CopyOnWriteArrayList();
    private final List<String> aSl = new CopyOnWriteArrayList();
    private final NetworkMonitor.a aSm = new NetworkMonitor.a() { // from class: com.kwad.sdk.core.webview.b.a.2
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            if (networkState == NetworkMonitor.NetworkState.NETWORK_WIFI || networkState == NetworkMonitor.NetworkState.NETWORK_MOBILE) {
                a.this.MO();
            }
        }
    };

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(List<com.kwad.sdk.h.a.b> list) {
        synchronized (this.aSj) {
            ce(this.mContext);
            for (com.kwad.sdk.h.a.b bVar : this.aSj) {
                if (!list.contains(bVar)) {
                    w.ab(new File(bVar.aWo));
                    this.aSj.remove(bVar);
                } else if (w.hh(com.kwad.sdk.core.webview.b.c.a.M(this.mContext, bVar.aWn))) {
                    list.remove(bVar);
                }
            }
            cd(this.mContext);
        }
    }

    public static a MN() {
        if (aSi == null) {
            synchronized (a.class) {
                if (aSi == null) {
                    aSi = new a();
                }
            }
        }
        return aSi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public List<com.kwad.sdk.h.a.b> MP() {
        List<com.kwad.sdk.h.a.a> list;
        List<com.kwad.sdk.h.a.b> list2;
        SdkConfigData sdkConfigDataHl = e.Hl();
        if (sdkConfigDataHl == null || (list = sdkConfigDataHl.h5PreloadConfigs) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.kwad.sdk.h.a.a aVar : list) {
            if (aVar != null && (list2 = aVar.aWl) != null) {
                for (com.kwad.sdk.h.a.b bVar : list2) {
                    a(bVar, aVar);
                    if (bVar.isValid()) {
                        arrayList.add(bVar);
                    }
                }
            }
        }
        return arrayList;
    }

    private WebResourceResponse ac(String str, String str2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            b.a aVar = new b.a();
            this.aSk.add(str);
            WebResourceResponse webResourceResponseA = a(str, str2, aVar, false);
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (webResourceResponseA != null) {
                c.d("HybridPackageManager", "load success time:" + jCurrentTimeMillis2 + "--url:" + str2);
                com.kwad.sdk.core.webview.b.c.b.a(str2, str, 1, "", jCurrentTimeMillis2);
            } else {
                c.d("HybridPackageManager", "load fail errorMsg:" + aVar.msg + "-url:" + str2);
                com.kwad.sdk.core.webview.b.c.b.a(str2, str, 2, aVar.msg, jCurrentTimeMillis2);
            }
            return webResourceResponseA;
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
            com.kwad.sdk.core.webview.b.c.b.a(str2, str, 2, "HybridWebViewClient中 Exception " + Log.getStackTraceString(th), System.currentTimeMillis() - jCurrentTimeMillis);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(Context context) {
        String string;
        FileOutputStream fileOutputStream;
        synchronized (this.aSj) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    File fileCh = com.kwad.sdk.core.webview.b.c.a.ch(context);
                    string = aa.S(this.aSj).toString();
                    fileOutputStream = new FileOutputStream(fileCh);
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(string.getBytes());
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            } catch (Exception unused2) {
                fileOutputStream2 = fileOutputStream;
                c.e("updatePackageIndexFile", "read packageIndex file error");
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                throw th;
            }
            this.aSk.clear();
            for (com.kwad.sdk.h.a.b bVar : this.aSj) {
                if (bVar.aWq) {
                    this.aSk.add(bVar.aWm);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ce(Context context) {
        FileInputStream fileInputStream;
        List<com.kwad.sdk.h.a.b> listA;
        synchronized (this.aSj) {
            FileInputStream fileInputStream2 = null;
            FileInputStream fileInputStream3 = null;
            List<com.kwad.sdk.h.a.b> list = null;
            try {
                File fileCh = com.kwad.sdk.core.webview.b.c.a.ch(context);
                if (w.O(fileCh)) {
                    fileInputStream = new FileInputStream(fileCh);
                    try {
                        try {
                            listA = a(h.b(new InputStreamReader(fileInputStream)), new com.kwad.sdk.core.c<com.kwad.sdk.h.a.b>() { // from class: com.kwad.sdk.core.webview.b.a.6
                                private static com.kwad.sdk.h.a.b MQ() {
                                    return new com.kwad.sdk.h.a.b();
                                }

                                @Override // com.kwad.sdk.core.c
                                public final /* synthetic */ com.kwad.sdk.core.b FU() {
                                    return MQ();
                                }
                            });
                            fileInputStream3 = fileInputStream;
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                        throw th;
                    }
                } else {
                    listA = null;
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream3);
                list = listA;
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                throw th;
            }
            if (list != null) {
                this.aSj.clear();
                this.aSj.addAll(list);
            }
            this.aSk.clear();
            for (com.kwad.sdk.h.a.b bVar : this.aSj) {
                if (!w.hh(com.kwad.sdk.core.webview.b.c.a.M(this.mContext, bVar.aWn))) {
                    this.aSj.remove(bVar);
                }
                if (bVar.aWq) {
                    this.aSk.add(bVar.aWm);
                }
            }
        }
    }

    private WebResourceResponse fl(String str) {
        try {
            b.a aVar = new b.a();
            synchronized (this.aSj) {
                Iterator<String> it = this.aSk.iterator();
                while (it.hasNext()) {
                    WebResourceResponse webResourceResponseA = a(it.next(), str, aVar, true);
                    if (webResourceResponseA != null) {
                        return webResourceResponseA;
                    }
                }
                return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private com.kwad.sdk.h.a.b fm(String str) {
        List<com.kwad.sdk.h.a.b> listMP = MP();
        if (listMP != null && !listMP.isEmpty()) {
            for (com.kwad.sdk.h.a.b bVar : listMP) {
                if (bp.isEquals(str, bVar.aWm)) {
                    return bVar;
                }
            }
        }
        return null;
    }

    private com.kwad.sdk.h.a.b fn(String str) {
        synchronized (this.aSj) {
            if (!TextUtils.isEmpty(str) && this.aSj.size() > 0) {
                for (com.kwad.sdk.h.a.b bVar : this.aSj) {
                    if (TextUtils.equals(str, bVar.aWm)) {
                        return bVar;
                    }
                }
                return null;
            }
            return null;
        }
    }

    public final void MO() {
        if (e.Hu()) {
            com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.sdk.core.webview.b.a.3
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    int i;
                    try {
                        List<com.kwad.sdk.h.a.b> listMP = a.this.MP();
                        if (listMP != null && !listMP.isEmpty()) {
                            a.this.G(listMP);
                            for (com.kwad.sdk.h.a.b bVar : listMP) {
                                if (bVar != null && bVar.packageType == 1 && ((i = bVar.loadType) == 1 || (i == 2 && ao.isWifiConnected(a.this.mContext)))) {
                                    a.this.a(bVar);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
                    }
                }
            });
        }
    }

    @Nullable
    public final WebResourceResponse ab(String str, String str2) {
        if (!this.mHasInit) {
            return null;
        }
        String strFq = com.kwad.sdk.core.webview.b.c.a.fq(str);
        if (TextUtils.isEmpty(strFq)) {
            return fl(str);
        }
        com.kwad.sdk.core.webview.b.c.b.c(str2, strFq, str);
        WebResourceResponse webResourceResponseAc = ac(strFq, str);
        com.kwad.sdk.core.webview.b.c.b.d(str2, strFq, str);
        return webResourceResponseAc;
    }

    public final synchronized void init(final Context context) {
        if (!this.mHasInit && context != null) {
            this.mContext = ServiceProvider.Re();
            this.mHasInit = true;
            com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.sdk.core.webview.b.a.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    try {
                        if (e.b(com.kwad.sdk.core.config.c.aEO)) {
                            a.this.acP = System.currentTimeMillis();
                            a.this.ce(context);
                            a.this.MO();
                            NetworkMonitor.getInstance().a(a.this.mContext, a.this.aSm);
                        }
                    } catch (Throwable th) {
                        ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
                    }
                }
            });
        }
    }

    public final long uB() {
        return this.acP;
    }

    private void b(@NonNull final com.kwad.sdk.h.a.b bVar) {
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.sdk.core.webview.b.a.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.h.a.b bVar2 = bVar;
                if (bVar2 != null) {
                    a.this.a(bVar2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.kwad.sdk.h.a.b bVar) {
        if (this.aSl.contains(bVar.aWm) || TextUtils.isEmpty(bVar.packageUrl)) {
            return;
        }
        com.kwad.sdk.core.webview.b.b.a.a(bVar, new a.InterfaceC0619a() { // from class: com.kwad.sdk.core.webview.b.a.4
            @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0619a
            public final void c(com.kwad.sdk.h.a.b bVar2) {
                a.this.aSl.add(bVar2.aWm);
                c.d("HybridPackageManager", "download onStart: " + bVar2.toString());
            }

            @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0619a
            public final void d(com.kwad.sdk.h.a.b bVar2) {
                c.d("HybridPackageManager", "download success: " + bVar2.toString());
                if (com.kwad.sdk.core.webview.b.b.b.a(a.this.mContext, bVar2)) {
                    c.d("HybridPackageManager", "install success: " + bVar2.toString());
                    a.this.aSj.add(bVar2);
                    a aVar = a.this;
                    aVar.cd(aVar.mContext);
                    com.kwad.sdk.core.webview.b.c.b.a(bVar2, 4);
                }
                a.this.aSl.remove(bVar2.aWm);
            }

            @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0619a
            public final void e(com.kwad.sdk.h.a.b bVar2) {
                c.d("HybridPackageManager", "download failure: " + bVar2.toString());
                a.this.aSl.remove(bVar2.aWm);
            }
        });
    }

    private WebResourceResponse a(@NonNull String str, String str2, b.a aVar, boolean z) {
        com.kwad.sdk.h.a.b bVarFn = fn(str);
        if (bVarFn == null) {
            com.kwad.sdk.h.a.b bVarFm = fm(str);
            if (bVarFm == null) {
                aVar.msg = "配置文件没有下发该zip资源";
                return null;
            }
            aVar.msg = "资源未下载:" + bVarFm.loadType;
            b(bVarFm);
            return null;
        }
        return b.a(this.mContext, str2, bVarFn, aVar, z);
    }

    private void a(com.kwad.sdk.h.a.b bVar, com.kwad.sdk.h.a.a aVar) {
        bVar.aWm = aVar.sceneId;
        if (TextUtils.isEmpty(bVar.packageUrl)) {
            return;
        }
        String strFr = com.kwad.sdk.core.webview.b.c.a.fr(bVar.packageUrl);
        if (TextUtils.isEmpty(strFr)) {
            return;
        }
        bVar.aWn = strFr;
        bVar.aWo = com.kwad.sdk.core.webview.b.c.a.K(this.mContext, strFr);
    }

    @Deprecated
    private static List<com.kwad.sdk.h.a.b> a(String str, @NonNull com.kwad.sdk.core.c<com.kwad.sdk.h.a.b> cVar) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                com.kwad.sdk.h.a.b bVar = (com.kwad.sdk.h.a.b) cVar.FU();
                bVar.parseJson(jSONObject);
                arrayList.add(bVar);
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }
}
