package com.huawei.hms.ads.jsb;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.cn;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.download.g;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager;
import com.huawei.openalliance.ad.utils.au;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {
    private static final String Code = "JsbHelper";
    private static final byte[] V = new byte[0];
    private static a Z;
    private Context B;
    private Map<String, g> I = new ConcurrentHashMap();

    /* JADX INFO: renamed from: com.huawei.hms.ads.jsb.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0433a {
        private static IAppDownloadManager Code = (IAppDownloadManager) au.V(x.ak);

        private C0433a() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements g {
        private AppInfo Code;
        private AppDownloadTask V;

        public b(AppInfo appInfo) {
            this.Code = appInfo;
            if (appInfo != null) {
                com.huawei.openalliance.ad.download.app.g.I().Code(appInfo, this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Code() {
            com.huawei.openalliance.ad.download.app.g.I().V(this.Code, this);
        }

        @Override // com.huawei.openalliance.ad.download.g
        public void V(AppDownloadTask appDownloadTask) {
        }

        @Override // com.huawei.openalliance.ad.download.g
        public void V(String str) {
        }

        @Override // com.huawei.openalliance.ad.download.g
        public void Code(AppDownloadTask appDownloadTask) {
        }

        @Override // com.huawei.openalliance.ad.download.g
        public void Code(String str) {
            if (this.V != null || this.Code == null) {
                return;
            }
            this.V = com.huawei.openalliance.ad.download.app.g.I().Code(this.Code);
        }

        @Override // com.huawei.openalliance.ad.download.f
        public void Code(String str, int i) {
        }

        @Override // com.huawei.openalliance.ad.download.g
        public void I(String str) {
        }
    }

    private a(Context context) {
        this.B = context.getApplicationContext();
    }

    public static a Code(Context context) {
        return V(context);
    }

    private static a V(Context context) {
        a aVar;
        synchronized (V) {
            if (Z == null) {
                Z = new a(context);
            }
            aVar = Z;
        }
        return aVar;
    }

    public IAppDownloadManager Code() {
        return C0433a.Code;
    }

    public void Code(JsbConfig jsbConfig) {
        synchronized (V) {
            if (jsbConfig != null) {
                HiAd.getInstance(this.B).enableUserInfo(jsbConfig.Code());
                HiAd.getInstance(this.B).initLog(jsbConfig.Z(), 3);
                if (cn.V(this.B)) {
                    HiAd.getInstance(this.B).initGrs(jsbConfig.V());
                } else {
                    HiAd.getInstance(this.B).initGrs(jsbConfig.V(), jsbConfig.I());
                }
            }
        }
    }

    public synchronized void Code(String str) {
        if (!TextUtils.isEmpty(str) && this.I.get(str) != null) {
            ((b) this.I.get(str)).Code();
            this.I.remove(str);
        }
    }

    public synchronized void Code(String str, AppInfo appInfo) {
        if (appInfo != null) {
            if (!TextUtils.isEmpty(str) && this.I.get(str) == null) {
                this.I.put(str, new b(appInfo));
            }
        }
    }
}
