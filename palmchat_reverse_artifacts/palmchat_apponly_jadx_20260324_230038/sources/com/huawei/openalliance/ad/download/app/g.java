package com.huawei.openalliance.ad.download.app;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.dt;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.kc;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.z;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class g extends com.huawei.openalliance.ad.download.b<AppDownloadTask> {
    private static final byte[] B = new byte[0];
    private static g C = null;
    private static final String Z = "ApDnMgr";
    private e F;
    private Context S;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void Code(boolean z, String str);
    }

    private g(Context context) {
        super(context);
        super.Code();
        this.S = context.getApplicationContext();
        e eVar = new e(context);
        this.F = eVar;
        super.Code(eVar);
    }

    private boolean B(AppDownloadTask appDownloadTask) {
        return appDownloadTask.B() == 2 && appDownloadTask.S() == 50 && appDownloadTask.Z() == 0;
    }

    private boolean C(AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null) {
            return false;
        }
        while (appDownloadTask.l()) {
            fh.V(Z, "switch next install way succ, curInstallWay:%s", appDownloadTask.j());
            if (!appDownloadTask.n() || z.S(this.Code)) {
                return true;
            }
        }
        fh.V(Z, "switch next install way fail, curInstallWay:%s", appDownloadTask.j());
        return false;
    }

    public static g I() {
        g gVar;
        synchronized (B) {
            gVar = C;
            if (gVar == null) {
                throw new dt("AppDownloadManager instance is not init!");
            }
        }
        return gVar;
    }

    private boolean S(AppDownloadTask appDownloadTask) {
        AdContentData adContentDataF = appDownloadTask.f();
        if (adContentDataF != null) {
            return new kc(this.Code, adContentDataF).Code();
        }
        return false;
    }

    @Override // com.huawei.openalliance.ad.download.b
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public AppDownloadTask Code(String str) {
        fh.V(Z, "getTask by pkg");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        AppDownloadTask appDownloadTask = (AppDownloadTask) super.Code(str);
        if (appDownloadTask != null) {
            return appDownloadTask;
        }
        fh.Code(Z, " local task is null,try get remote");
        AppInfo appInfo = new AppInfo();
        appInfo.b(str);
        appInfo.I("5");
        RemoteAppDownloadTask remoteAppDownloadTask = (RemoteAppDownloadTask) c.Code(this.S, appInfo, true, RemoteAppDownloadTask.class);
        if (remoteAppDownloadTask == null) {
            fh.V(Z, "remote agd task is null, get restore task");
            appInfo.I("11");
            remoteAppDownloadTask = (RemoteAppDownloadTask) c.Code(this.S, appInfo, false, RemoteAppDownloadTask.class);
        }
        return Code(appInfo, remoteAppDownloadTask);
    }

    public boolean Z(AppDownloadTask appDownloadTask) {
        if (!C(appDownloadTask)) {
            return false;
        }
        V(appDownloadTask);
        Code(appDownloadTask);
        return true;
    }

    public AppDownloadTask Code(AppInfo appInfo) {
        fh.V(Z, "getTask by appInfo");
        if (V(appInfo)) {
            return null;
        }
        AppDownloadTask appDownloadTaskCode = (AppDownloadTask) super.Code(appInfo.Code());
        if (appDownloadTaskCode == null) {
            fh.Code(Z, " local task is null,try get remote");
            RemoteAppDownloadTask remoteAppDownloadTask = (RemoteAppDownloadTask) c.Code(this.S, appInfo, false, RemoteAppDownloadTask.class);
            if (remoteAppDownloadTask == null && "11".equals(appInfo.i())) {
                fh.Code(Z, "restore scenario, but may has agd task, query again");
                remoteAppDownloadTask = (RemoteAppDownloadTask) c.Code(this.S, appInfo, true, RemoteAppDownloadTask.class);
            }
            appDownloadTaskCode = Code(appInfo, remoteAppDownloadTask);
        }
        if (appDownloadTaskCode != null && !appDownloadTaskCode.m()) {
            appDownloadTaskCode.a(appInfo.x());
        }
        return appDownloadTaskCode;
    }

    public void I(final AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null) {
            return;
        }
        c.Code(this.S, appDownloadTask, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.download.app.g.3
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() != -1) {
                    fh.V(g.Z, " resume task is success:" + appDownloadTask.F());
                }
            }
        }, String.class);
    }

    public void V(final AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null) {
            return;
        }
        c.V(this.S, appDownloadTask, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.download.app.g.2
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() != -1) {
                    fh.V(g.Z, " pause task is success:" + appDownloadTask.F());
                }
            }
        }, String.class);
    }

    private AppDownloadTask Code(AppInfo appInfo, RemoteAppDownloadTask remoteAppDownloadTask) {
        if (remoteAppDownloadTask == null) {
            return null;
        }
        fh.V(Z, "remote task is exist, create local by remote");
        AppDownloadTask appDownloadTaskCode = remoteAppDownloadTask.Code(appInfo);
        if (TextUtils.isEmpty(remoteAppDownloadTask.L())) {
            appDownloadTaskCode.L(B(appDownloadTaskCode) ? "11" : "5");
        }
        super.Code(appDownloadTaskCode);
        return appDownloadTaskCode;
    }

    public void V(AppInfo appInfo, com.huawei.openalliance.ad.download.g gVar) {
        if (!V(appInfo)) {
            this.F.V(appInfo.Code(), gVar);
        }
        if (com.huawei.hms.ads.utils.a.Code(appInfo)) {
            b.Code(this.Code).V(appInfo.Q(), gVar);
        }
    }

    public static void Code(Context context) {
        synchronized (B) {
            if (C == null) {
                C = new g(context);
            }
        }
    }

    private static boolean V(AppInfo appInfo) {
        return appInfo == null || TextUtils.isEmpty(appInfo.Code());
    }

    @Override // com.huawei.openalliance.ad.download.b
    public void Code(final AppDownloadTask appDownloadTask) {
        if (!appDownloadTask.k()) {
            super.Code(appDownloadTask);
            c.Code(this.S, appDownloadTask, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.download.app.g.1
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                    if (callResult.getCode() == -1) {
                        g.this.V(appDownloadTask);
                    }
                }
            }, String.class);
            return;
        }
        AppInfo appInfoL = appDownloadTask.L();
        if (appInfoL == null || TextUtils.isEmpty(appInfoL.j()) || !S(appDownloadTask)) {
            fh.V(Z, "can not open Ag detail");
            Z(appDownloadTask);
        }
    }

    public void Code(AppInfo appInfo, final a aVar) {
        if (V(appInfo)) {
            return;
        }
        final AppDownloadTask appDownloadTaskCode = Code(appInfo);
        if (appDownloadTaskCode != null) {
            c.I(this.S, appDownloadTaskCode, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.download.app.g.4
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                    if (callResult.getCode() == 200 && String.valueOf(Boolean.TRUE).equals(callResult.getData())) {
                        String strE = appDownloadTaskCode.L() != null ? appDownloadTaskCode.L().e() : "";
                        g.super.I(appDownloadTaskCode);
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.Code(true, strE);
                        }
                        fh.V(g.Z, " removeTask task is success:" + appDownloadTaskCode.F());
                    }
                }
            }, String.class);
            return;
        }
        fh.V(Z, " removeTask failed:" + appInfo.Code());
    }

    public void Code(AppInfo appInfo, com.huawei.openalliance.ad.download.g gVar) {
        if (!V(appInfo)) {
            this.F.Code(appInfo.Code(), gVar);
        }
        if (com.huawei.hms.ads.utils.a.Code(appInfo)) {
            b.Code(this.Code).Code(appInfo.Q(), gVar);
        }
    }

    public void Code(AppDownloadListener appDownloadListener) {
        this.F.Code(appDownloadListener);
    }
}
