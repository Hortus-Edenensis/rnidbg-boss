package com.huawei.openalliance.ad.download;

import com.huawei.openalliance.ad.download.app.AppStatus;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a implements AppDownloadListener {
    private static final String Code = "AppDownloadListenerRegister";
    private static final String I = "outer_listener_key";
    private static final String Z = "jsb_listener_key";
    private final CopyOnWriteArraySet<AppDownloadListener> B;
    private Map<String, AppDownloadListener> V;

    /* JADX INFO: renamed from: com.huawei.openalliance.ad.download.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0446a {
        private static a Code = new a();

        private C0446a() {
        }
    }

    private a() {
        this.V = new ConcurrentHashMap();
        this.B = new CopyOnWriteArraySet<>();
        com.huawei.openalliance.ad.download.app.g.I().Code(this);
    }

    public static a Code() {
        return C0446a.Code;
    }

    public void I(AppDownloadListener appDownloadListener) {
        if (appDownloadListener == null) {
            return;
        }
        this.B.remove(appDownloadListener);
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
    public void V(AppInfo appInfo) {
        for (AppDownloadListener appDownloadListener : this.V.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.V(appInfo);
            }
        }
        for (AppDownloadListener appDownloadListener2 : this.B) {
            if (appDownloadListener2 != null) {
                appDownloadListener2.V(appInfo);
            }
        }
    }

    public void Z(AppDownloadListener appDownloadListener) {
        if (appDownloadListener == null) {
            this.V.remove(Z);
        } else {
            this.V.put(Z, appDownloadListener);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
    public void Code(AppStatus appStatus, AppInfo appInfo) {
        for (AppDownloadListener appDownloadListener : this.V.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.Code(appStatus, appInfo);
            }
        }
        for (AppDownloadListener appDownloadListener2 : this.B) {
            if (appDownloadListener2 != null) {
                appDownloadListener2.Code(appStatus, appInfo);
            }
        }
    }

    public void V(AppDownloadListener appDownloadListener) {
        if (appDownloadListener == null) {
            return;
        }
        this.B.add(appDownloadListener);
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
    public void Code(AppInfo appInfo) {
        for (AppDownloadListener appDownloadListener : this.V.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.Code(appInfo);
            }
        }
        for (AppDownloadListener appDownloadListener2 : this.B) {
            if (appDownloadListener2 != null) {
                appDownloadListener2.Code(appInfo);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
    public void Code(AppInfo appInfo, int i) {
        for (AppDownloadListener appDownloadListener : this.V.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.Code(appInfo, i);
            }
        }
        for (AppDownloadListener appDownloadListener2 : this.B) {
            if (appDownloadListener2 != null) {
                appDownloadListener2.Code(appInfo, i);
            }
        }
    }

    public void Code(AppDownloadListener appDownloadListener) {
        if (appDownloadListener == null) {
            this.V.remove(I);
        } else {
            this.V.put(I, appDownloadListener);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
    public void Code(String str) {
        for (AppDownloadListener appDownloadListener : this.V.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.Code(str);
            }
        }
        for (AppDownloadListener appDownloadListener2 : this.B) {
            if (appDownloadListener2 != null) {
                appDownloadListener2.Code(str);
            }
        }
    }
}
