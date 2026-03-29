package com.bytedance.sdk.openadsdk.core.l.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.sdk.component.utils.bq;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.l.b.fx;
import com.bytedance.sdk.openadsdk.core.l.b.s;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.huawei.openalliance.ad.constant.az;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.bg;
import com.ss.android.download.api.config.dw;
import com.ss.android.download.api.config.sx;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.nr;
import com.ss.android.download.api.model.u;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.u.u;
import com.ss.android.socialbase.downloader.depend.gi;
import com.ss.android.socialbase.downloader.depend.h;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.umeng.commonsdk.framework.UMModuleRegister;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.ss.android.download.api.download.u.u f5328a;
    public static com.bytedance.sdk.openadsdk.core.l.b.b fx;
    private static Context iz;
    private static TTAdInteractionListener n;
    public static volatile String u;
    private static Map<Integer, fx.u> x;
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static final AtomicBoolean pn = new AtomicBoolean(false);
    public static boolean nr = true;

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements com.ss.android.download.api.config.a {
        @Override // com.ss.android.download.api.config.a
        public void u(Activity activity, int i, String[] strArr, int[] iArr) {
        }

        @Override // com.ss.android.download.api.config.a
        public void u(Activity activity, String[] strArr, final dw dwVar) {
            if (k.x() != null) {
                k.x().u(activity, strArr, new com.bytedance.sdk.openadsdk.core.l.b.iz() { // from class: com.bytedance.sdk.openadsdk.core.l.b.k.b.1
                    @Override // com.bytedance.sdk.openadsdk.core.l.b.iz
                    public void u() {
                        dw dwVar2 = dwVar;
                        if (dwVar2 != null) {
                            dwVar2.u();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.l.b.iz
                    public void u(String str) {
                        dw dwVar2 = dwVar;
                        if (dwVar2 != null) {
                            dwVar2.u(str);
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.download.api.config.a
        public boolean u(Context context, String str) {
            if (k.x() != null) {
                return k.x().u(context, str);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class iz implements IDownloadHttpService {
        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
        public com.ss.android.socialbase.downloader.network.a downloadWithConnection(int i, String str, List<com.ss.android.socialbase.downloader.model.fx> list) throws IOException {
            final s.u uVarU = s.u(str, list);
            if (uVarU != null) {
                return new com.ss.android.socialbase.downloader.network.a() { // from class: com.bytedance.sdk.openadsdk.core.l.b.k.iz.1
                    @Override // com.ss.android.socialbase.downloader.network.a
                    public void b() {
                        try {
                            uVarU.b.disconnect();
                        } catch (Exception unused) {
                        }
                    }

                    @Override // com.ss.android.socialbase.downloader.network.x
                    public int nr() {
                        return uVarU.fx;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.a
                    public InputStream u() {
                        return uVarU.u;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.x
                    public String u(String str2) {
                        Map<String, String> map = uVarU.nr;
                        if (map != null) {
                            return map.get(str2);
                        }
                        return null;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.x
                    public void fx() {
                    }
                };
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr implements com.ss.android.download.api.config.x {
        private void fx(com.ss.android.download.api.model.fx fxVar) {
            if (fxVar == null) {
                return;
            }
            Object objL = fxVar.l();
            n nVarNr = n.u().u(fxVar.nr()).nr(fxVar.n()).u(objL instanceof JSONObject ? (JSONObject) objL : null).nr(fxVar.fx());
            boolean z = "download_notification".equals(fxVar.nr()) || "landing_h5_download_ad_button".equals(fxVar.nr());
            if (k.x() != null) {
                k.x().u(nVarNr, z);
            }
        }

        @Override // com.ss.android.download.api.config.x
        public void nr(com.ss.android.download.api.model.fx fxVar) {
            u(fxVar, false);
            fx(fxVar);
        }

        @Override // com.ss.android.download.api.config.x
        public void u(com.ss.android.download.api.model.fx fxVar) {
            u(fxVar, true);
        }

        private void u(com.ss.android.download.api.model.fx fxVar, boolean z) {
            x xVarNr;
            if (k.x() == null || (xVarNr = k.x().nr()) == null || fxVar == null) {
                return;
            }
            if (xVarNr.u() && k.x().u(fxVar.toString())) {
                return;
            }
            if (z) {
                k.nr(fxVar);
            } else {
                k.nr(fxVar);
            }
        }
    }

    static {
        try {
            u = com.bytedance.sdk.openadsdk.api.plugin.nr.u(getContext(), Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (Throwable unused) {
        }
        f5328a = new com.ss.android.download.api.download.u.u() { // from class: com.bytedance.sdk.openadsdk.core.l.b.k.8
            @Override // com.ss.android.download.api.download.u.u
            public void u(DownloadInfo downloadInfo, String str) {
                k.fx(str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject a() {
        try {
            com.bytedance.sdk.openadsdk.core.l.b.b bVarX = x();
            if (bVarX != null) {
                JSONObject jSONObjectU = bVarX.u();
                if (jSONObjectU.optInt("enable_app_install_receiver", 1) == 0) {
                    jSONObjectU.put("enable_app_install_receiver", 0);
                }
                return jSONObjectU;
            }
        } catch (Exception unused) {
        }
        return new JSONObject();
    }

    public static Map<Integer, fx.u> b() {
        return x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fx(String str) {
        com.ss.android.downloadad.api.u.nr nrVarU;
        JSONObject jSONObjectX;
        if (TextUtils.isEmpty(str) || (nrVarU = com.ss.android.downloadlib.addownload.nr.iz.u().u(str)) == null || (jSONObjectX = nrVarU.x()) == null || x() == null) {
            return;
        }
        x().u(jSONObjectX, str);
    }

    private static Context getContext() {
        Context context = iz;
        return context == null ? com.bytedance.sdk.openadsdk.core.dw.getContext() : context;
    }

    private static boolean n() {
        return UMModuleRegister.INNER.equals(d.x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.core.l.b.b x() {
        if (fx == null) {
            fx = mv.b();
        }
        return fx;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements com.ss.android.download.api.config.jk {
        private u() {
        }

        @Override // com.ss.android.download.api.config.jk
        public boolean nr(DownloadModel downloadModel, DownloadInfo downloadInfo) {
            com.bytedance.sdk.openadsdk.core.l.b.b bVarX = k.x();
            if (bVarX != null) {
                return bVarX.nr(downloadModel, downloadInfo);
            }
            return false;
        }

        @Override // com.ss.android.download.api.config.jk
        public boolean u(DownloadModel downloadModel, DownloadInfo downloadInfo) {
            com.bytedance.sdk.openadsdk.core.l.b.b bVarX = k.x();
            if (bVarX != null) {
                return bVarX.u(downloadModel, downloadInfo);
            }
            return false;
        }

        @Override // com.ss.android.download.api.config.jk
        public boolean u(DownloadModel downloadModel) {
            com.bytedance.sdk.openadsdk.core.l.b.b bVarX = k.x();
            if (bVarX != null) {
                return bVarX.u(downloadModel);
            }
            return false;
        }
    }

    public static com.ss.android.downloadlib.jk nr() {
        u(getContext());
        return com.ss.android.downloadlib.jk.u(getContext());
    }

    public static void u(TTAdInteractionListener tTAdInteractionListener) {
        n = tTAdInteractionListener;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class fx implements com.ss.android.download.api.config.n {
        private fx() {
        }

        @Override // com.ss.android.download.api.config.n
        public void u(String str, String str2, Map<String, Object> map, final bg bgVar) {
            str.hashCode();
            int i = 0;
            if (!str.equals("GET") && str.equals("POST")) {
                i = 1;
            }
            if (k.x() != null) {
                k.x().u(i, str2, map, new com.bytedance.sdk.openadsdk.core.l.b.pn() { // from class: com.bytedance.sdk.openadsdk.core.l.b.k.fx.1
                    @Override // com.bytedance.sdk.openadsdk.core.l.b.pn
                    public void u(String str3) {
                        bg bgVar2 = bgVar;
                        if (bgVar2 != null) {
                            bgVar2.u(str3);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.l.b.pn
                    public void u(Throwable th) {
                        bg bgVar2 = bgVar;
                        if (bgVar2 != null) {
                            bgVar2.u(th);
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.download.api.config.n
        public void u(String str, byte[] bArr, String str2, int i, final bg bgVar) {
            if (k.x() != null) {
                k.x().u(str, bArr, str2, new com.bytedance.sdk.openadsdk.core.l.b.pn() { // from class: com.bytedance.sdk.openadsdk.core.l.b.k.fx.2
                    @Override // com.bytedance.sdk.openadsdk.core.l.b.pn
                    public void u(String str3) {
                        bg bgVar2 = bgVar;
                        if (bgVar2 != null) {
                            bgVar2.u(str3);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.l.b.pn
                    public void u(Throwable th) {
                        bg bgVar2 = bgVar;
                        if (bgVar2 != null) {
                            bgVar2.u(th);
                        }
                    }
                });
            }
        }
    }

    public static TTAdInteractionListener u() {
        return n;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class pn implements com.ss.android.download.api.config.mv {
        private final WeakReference<Context> u;

        public pn(Context context) {
            this.u = new WeakReference<>(context);
        }

        private com.bytedance.sdk.openadsdk.core.l.b.u fx(final com.ss.android.download.api.model.nr nrVar) {
            return com.bytedance.sdk.openadsdk.core.l.b.u.u().u(nrVar.nr).nr(nrVar.fx).b(nrVar.pn).fx(nrVar.b).u(nrVar.x).u(new com.bytedance.sdk.openadsdk.core.l.b.nr() { // from class: com.bytedance.sdk.openadsdk.core.l.b.k.pn.2
                @Override // com.bytedance.sdk.openadsdk.core.l.b.nr
                public void fx(DialogInterface dialogInterface) {
                    nr.InterfaceC0840nr interfaceC0840nr = nrVar.n;
                    if (interfaceC0840nr != null) {
                        interfaceC0840nr.fx(dialogInterface);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.l.b.nr
                public void nr(DialogInterface dialogInterface) {
                    nr.InterfaceC0840nr interfaceC0840nr = nrVar.n;
                    if (interfaceC0840nr != null) {
                        try {
                            interfaceC0840nr.nr(dialogInterface);
                        } catch (Exception unused) {
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.l.b.nr
                public void u(DialogInterface dialogInterface) {
                    nr.InterfaceC0840nr interfaceC0840nr = nrVar.n;
                    if (interfaceC0840nr != null) {
                        interfaceC0840nr.u(dialogInterface);
                    }
                }
            });
        }

        @Override // com.ss.android.download.api.config.mv
        public void u(int i, final Context context, DownloadModel downloadModel, final String str, Drawable drawable, int i2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                com.bytedance.sdk.openadsdk.gi.x.u((Runnable) new com.bytedance.sdk.component.jk.a("tt_download_toast") { // from class: com.bytedance.sdk.openadsdk.core.l.b.k.pn.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, str, 0).show();
                    }
                });
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.k.nr("LibUIFactory", "showToastWithDuration e " + e.getMessage());
            }
        }

        @Override // com.ss.android.download.api.config.mv
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public AlertDialog nr(com.ss.android.download.api.model.nr nrVar) {
            if (nrVar != null && k.x() != null) {
                Context context = nrVar.u;
                if (context != null && (context instanceof Activity)) {
                    return k.x().u((Activity) nrVar.u, nrVar.jk == 1, fx(nrVar));
                }
                k.x().u(this.u, nrVar.jk == 1, fx(nrVar));
            }
            return null;
        }
    }

    private static boolean nr(final Context context) {
        com.ss.android.download.api.u uVarU;
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            packageName = "";
        }
        if (n()) {
            try {
                uVarU = com.ss.android.downloadlib.jk.u(applicationContext).u(AdBaseConstants.DownloadConfigureName.PANGOLIN);
            } catch (Throwable unused) {
                uVarU = com.ss.android.downloadlib.jk.u(applicationContext).u();
            }
        } else {
            uVarU = com.ss.android.downloadlib.jk.u(applicationContext).u();
        }
        if (uVarU == null) {
            return false;
        }
        uVarU.u(new b()).u(new nr()).u(new pn(applicationContext)).u(new fx()).u(new com.ss.android.socialbase.appdownloader.fx.x() { // from class: com.bytedance.sdk.openadsdk.core.l.b.k.5
            @Override // com.ss.android.socialbase.appdownloader.fx.x
            public Uri u(int i, String str, String str2) {
                return my.u(context).u(str, str2);
            }
        }).u(new com.ss.android.socialbase.appdownloader.fx.fx() { // from class: com.bytedance.sdk.openadsdk.core.l.b.k.4
            @Override // com.ss.android.socialbase.appdownloader.fx.fx
            public Map<String, Object> u(Object obj) {
                if (com.bytedance.sdk.openadsdk.my.fx.b.nr(d.fx)) {
                    return my.u(context).u(obj);
                }
                return null;
            }
        }).u(new com.ss.android.download.api.config.t() { // from class: com.bytedance.sdk.openadsdk.core.l.b.k.3
            @Override // com.ss.android.download.api.config.t
            public JSONObject u() {
                return k.a();
            }
        }).u(new u()).u(new com.ss.android.download.api.config.nr() { // from class: com.bytedance.sdk.openadsdk.core.l.b.k.2
            @Override // com.ss.android.download.api.config.nr
            public boolean u() {
                if (k.x() != null) {
                    return k.x().fx();
                }
                return false;
            }
        }).u(new u.C0841u().nr("143").u("open_news").fx(d.b).b(String.valueOf(d.fx)).u()).u(new sx() { // from class: com.bytedance.sdk.openadsdk.core.l.b.k.1
            @Override // com.ss.android.download.api.config.sx
            public byte[] u(byte[] bArr, int i) {
                return new byte[0];
            }
        }).u(packageName + ".TTFileProvider").u(u(applicationContext, a())).u();
        com.ss.android.downloadlib.x.u.u();
        if (!d.x.equals(UMModuleRegister.INNER)) {
            com.ss.android.downloadlib.jk.u(applicationContext).b().u(1);
            com.ss.android.downloadlib.jk.u(applicationContext).u(f5328a);
            com.ss.android.socialbase.appdownloader.b.t().u(new h() { // from class: com.bytedance.sdk.openadsdk.core.l.b.k.6
                @Override // com.ss.android.socialbase.downloader.depend.h
                public boolean u(Intent intent) {
                    return false;
                }
            });
        }
        return true;
    }

    public static void u(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.dw.getContext();
        }
        if (context == null) {
            return;
        }
        String strNr = bq.nr(context);
        if (strNr != null && strNr.contains(":downloader") && d.fx >= 7000) {
            com.ss.android.socialbase.downloader.downloader.fx.u(new iz());
        }
        AtomicBoolean atomicBoolean = b;
        if (!atomicBoolean.get()) {
            synchronized (k.class) {
                if (!atomicBoolean.get()) {
                    iz = context.getApplicationContext();
                    if (x() != null) {
                        String strU = x().u(nr);
                        if (!TextUtils.isEmpty(strU)) {
                            u = strU;
                        }
                    }
                    atomicBoolean.set(nr(iz));
                }
            }
        }
        if (atomicBoolean.get()) {
            AtomicBoolean atomicBoolean2 = pn;
            if (atomicBoolean2.compareAndSet(false, true)) {
                if ((x() != null ? x().nr() : null) == null) {
                    atomicBoolean2.set(false);
                }
            }
        }
    }

    public static void fx() {
        nr().x();
        if (x() != null) {
            x().nr(u);
        }
    }

    public static void u(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        u = str;
    }

    public static boolean u(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return nr().pn().u(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener);
    }

    public static boolean u(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return nr().pn().u(context, uri, downloadModel, downloadEventConfig, downloadController);
    }

    public static boolean u(Uri uri) {
        return com.ss.android.downloadlib.nr.jk.u(uri);
    }

    public static void u(int i) {
        Map<Integer, fx.u> map = x;
        if (map != null) {
            map.remove(Integer.valueOf(i));
        }
    }

    public static void u(int i, fx.u uVar) {
        if (uVar != null) {
            if (x == null) {
                x = DesugarCollections.synchronizedMap(new WeakHashMap());
            }
            x.put(Integer.valueOf(i), uVar);
        }
    }

    public static boolean u(String str, String str2, JSONObject jSONObject, Object obj) {
        Map<Integer, fx.u> mapB;
        boolean z = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && jSONObject != null && (mapB = b()) != null) {
            for (Map.Entry<Integer, fx.u> entry : mapB.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                fx.u value = entry.getValue();
                if (value != null) {
                    boolean zU = value.u(iIntValue, jSONObject.toString(), str, str2, obj);
                    if (!z && !zU) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject nr(com.ss.android.download.api.model.fx fxVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.huawei.openalliance.ad.constant.x.cw, fxVar.u());
            jSONObject.put("tag", fxVar.nr());
            jSONObject.put("label", fxVar.fx());
            jSONObject.put("isAd", fxVar.b());
            jSONObject.put("adId", fxVar.pn());
            jSONObject.put("logExtra", fxVar.iz());
            jSONObject.put("extValue", fxVar.x());
            jSONObject.put("extJson", fxVar.n());
            jSONObject.put("paramsJson", fxVar.a());
            jSONObject.put("eventSource", fxVar.t());
            jSONObject.put("extraObject", fxVar.l());
            jSONObject.put("clickTrackUrl", fxVar.jk());
            jSONObject.put("isV3", fxVar.mv());
            jSONObject.put("V3EventName", fxVar.s());
            jSONObject.put("V3EventParams", fxVar.k());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private static DownloaderBuilder u(Context context, JSONObject jSONObject) {
        return new DownloaderBuilder(context).downloadSetting(new gi() { // from class: com.bytedance.sdk.openadsdk.core.l.b.k.7
            @Override // com.ss.android.socialbase.downloader.depend.gi
            public JSONObject u() {
                return k.a();
            }
        }).httpService(new iz());
    }

    public static boolean u(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            List<DownloadInfo> listNr = com.ss.android.socialbase.appdownloader.b.t().nr(context);
            if (!listNr.isEmpty()) {
                for (DownloadInfo downloadInfo : listNr) {
                    if (downloadInfo != null && str.equals(downloadInfo.getUrl())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static Bundle u(com.bytedance.sdk.openadsdk.core.l.fx.nr.u uVar, int i) {
        String str;
        boolean z;
        String str2;
        Bundle bundle = new Bundle();
        try {
            if (i == 101) {
                boolean zFx = jp.fx(iz, uVar.fx());
                String str3 = zFx ? "open" : az.ah;
                if (zFx) {
                    com.ss.android.downloadlib.addownload.nr.x xVarU = com.ss.android.downloadlib.x.a.u(uVar.fx());
                    str2 = xVarU.getType() + "_" + xVarU.u() + "_" + xVarU.nr();
                    bundle.putString("msg", "open ".concat(String.valueOf(str2)));
                    z = true;
                } else {
                    boolean zU = com.ss.android.socialbase.appdownloader.b.u(iz, uVar.b());
                    if (zU) {
                        str = "mem install";
                    } else {
                        str = "cache install";
                        zU = com.ss.android.socialbase.appdownloader.b.u(iz, u(uVar.jk(), uVar.a()));
                    }
                    String str4 = str;
                    z = zU;
                    str2 = str4;
                    bundle.putString("msg", "install ".concat(String.valueOf(z)));
                }
                com.bytedance.sdk.openadsdk.core.l.pn.u(uVar.x(), uVar, str3, "media_install", str2, z ? "success" : "failure");
            } else {
                bundle.putString("msg", "event_type:" + i + " not support");
                com.bytedance.sdk.openadsdk.core.l.pn.u(uVar.x(), uVar, "notSupport_".concat(String.valueOf(i)), "media_install", "error", "failure");
            }
        } catch (Exception e) {
            bundle.putString("msg", e.getMessage());
        }
        return bundle;
    }

    private static int u(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String strPn = com.ss.android.socialbase.downloader.jk.iz.pn(String.format("%s_%s", str, str2));
        if (TextUtils.isEmpty(strPn)) {
            return 0;
        }
        return strPn.hashCode();
    }

    public static boolean u(Activity activity, final com.bytedance.sdk.openadsdk.my.fx.u.u uVar) {
        return com.ss.android.downloadlib.addownload.u.u.u().u(activity, false, new u.InterfaceC0843u() { // from class: com.bytedance.sdk.openadsdk.core.l.b.k.9
            @Override // com.ss.android.downloadlib.addownload.u.u.InterfaceC0843u
            public void u() {
                com.bytedance.sdk.openadsdk.my.fx.u.u uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.u();
                }
            }
        });
    }
}
