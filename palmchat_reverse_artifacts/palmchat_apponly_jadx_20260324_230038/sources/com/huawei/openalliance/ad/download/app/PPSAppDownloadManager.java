package com.huawei.openalliance.ad.download.app;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.db;
import com.huawei.hms.ads.dp;
import com.huawei.hms.ads.dq;
import com.huawei.hms.ads.ex;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.ji;
import com.huawei.hms.ads.jk;
import com.huawei.hms.ads.ke;
import com.huawei.hms.ads.kk;
import com.huawei.hms.ads.kl;
import com.huawei.hms.ads.kw;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.constant.aj;
import com.huawei.openalliance.ad.constant.be;
import com.huawei.openalliance.ad.constant.v;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.download.app.g;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import com.huawei.openalliance.ad.inter.data.s;
import com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager;
import com.huawei.openalliance.ad.utils.ag;
import com.huawei.openalliance.ad.utils.al;
import com.huawei.openalliance.ad.utils.z;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@AllApi
public class PPSAppDownloadManager implements IAppDownloadManager {
    private String L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6934a;
    private final dq B = new dp();
    private Map<String, Pair<String, Long>> C = new HashMap();
    private int S = 2;
    private Integer F = 6;
    private com.huawei.openalliance.ad.download.g b = new com.huawei.openalliance.ad.download.g() { // from class: com.huawei.openalliance.ad.download.app.PPSAppDownloadManager.1
        @Override // com.huawei.openalliance.ad.download.g
        public void Code(AppDownloadTask appDownloadTask) {
        }

        @Override // com.huawei.openalliance.ad.download.g
        public void V(AppDownloadTask appDownloadTask) {
            if (appDownloadTask == null || appDownloadTask.o() != 7) {
                return;
            }
            appDownloadTask.B(0);
            PPSAppDownloadManager.this.Code.I(appDownloadTask);
            PPSAppDownloadManager.this.Code.V(appDownloadTask.L(), this);
        }

        @Override // com.huawei.openalliance.ad.download.g
        public void Code(String str) {
        }

        @Override // com.huawei.openalliance.ad.download.g
        public void V(String str) {
        }

        @Override // com.huawei.openalliance.ad.download.f
        public void Code(String str, int i) {
        }

        @Override // com.huawei.openalliance.ad.download.g
        public void I(String str) {
        }
    };
    g Code = g.I();

    @AllApi
    public PPSAppDownloadManager() {
    }

    private int D(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        if (dVar == null) {
            fh.V("PPSAppDownloadManager", "ad is empty");
            return -1;
        }
        if (!Z(dVar.E())) {
            return -1;
        }
        if (b(context, dVar)) {
            fh.V("PPSAppDownloadManager", "app is installed, open it.");
            return 0;
        }
        if (L(context, dVar)) {
            fh.V("PPSAppDownloadManager", "open landing page action");
            return -4;
        }
        Integer numV = V(context, dVar);
        if (numV != null) {
            return numV.intValue();
        }
        if (this.B.Code(context, dVar, true)) {
            return a(context, dVar);
        }
        fh.V("PPSAppDownloadManager", "download has not permission, please add white list");
        return -2;
    }

    private boolean L(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        AppInfo appInfoE;
        if (context == null || dVar == null || (appInfoE = dVar.E()) == null) {
            return false;
        }
        if ("21".equals(appInfoE.T()) || Code(context, dVar.q())) {
            return new kl(context, dVar.q(), true, dVar instanceof com.huawei.openalliance.ad.inter.data.l ? ((com.huawei.openalliance.ad.inter.data.l) dVar).au() : null).Code();
        }
        return false;
    }

    private int a(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        if (c(context, dVar)) {
            fh.V("PPSAppDownloadManager", "do app click action.");
            return 0;
        }
        AppInfo appInfoE = dVar.E();
        Code(appInfoE);
        AppDownloadTask appDownloadTaskCode = this.Code.Code(appInfoE);
        if (appDownloadTaskCode == null) {
            AppDownloadTask appDownloadTaskCode2 = Code(dVar);
            if (appDownloadTaskCode2 == null) {
                fh.V("PPSAppDownloadManager", "failed when create task");
                return -1;
            }
            if (appInfoE != null) {
                Code(appInfoE.Code(), appInfoE.e());
            }
            Code(dVar, appDownloadTaskCode2);
            if (!Code()) {
                I(context, null, dVar);
                Code(context, dVar, appInfoE, com.huawei.openalliance.ad.utils.b.Code(context));
            }
            this.Code.Code(appDownloadTaskCode2);
        } else {
            V(dVar, appDownloadTaskCode);
            Code(dVar, appDownloadTaskCode);
            this.Code.I(appDownloadTaskCode);
        }
        return 0;
    }

    private boolean b(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        String str;
        if (dVar == null || dVar.E() == null) {
            str = "param is empty";
        } else {
            AppInfo appInfoE = dVar.E();
            if (com.huawei.openalliance.ad.utils.h.Code(context, appInfoE.Code()) || !com.huawei.openalliance.ad.utils.h.Code()) {
                String strCode = Code(appInfoE.Code());
                if (!TextUtils.isEmpty(strCode)) {
                    appInfoE.V(strCode);
                }
                kw.a aVar = new kw.a();
                aVar.Code(appInfoE).Code(dVar.q());
                if (com.huawei.openalliance.ad.utils.h.Code(context, appInfoE.Code(), appInfoE.D(), aVar.Code())) {
                    Code(context, appInfoE);
                    jk.Code(context, dVar.q(), "intentSuccess", (Integer) 1, (Integer) null);
                    if (!Code()) {
                        I(context, null, dVar);
                        Code(context, dVar, com.huawei.openalliance.ad.utils.b.Code(context));
                    }
                    return true;
                }
                fh.V("PPSAppDownloadManager", "handleClick, openAppIntent failed");
                jk.Code(context, dVar.q(), aj.D, (Integer) 1, (Integer) 2);
                if (com.huawei.openalliance.ad.utils.h.Code(context, appInfoE.Code(), aVar.Code())) {
                    Code(context, appInfoE);
                    jk.Code(context, dVar.q(), (Integer) 6);
                    if (!Code()) {
                        I(context, null, dVar);
                        Code(context, dVar, com.huawei.openalliance.ad.utils.b.Code(context));
                    }
                    return true;
                }
                str = "handleClick, openAppMainPage failed";
            } else {
                str = "app not installed, need download";
            }
        }
        fh.V("PPSAppDownloadManager", str);
        return false;
    }

    private boolean c(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        AppInfo appInfoE;
        boolean z = dVar instanceof s;
        if (!this.f6934a || !z || (appInfoE = dVar.E()) == null || ag.Code(appInfoE.E()) || !ke.Code(context, dVar.q(), Code(dVar.q()), appInfoE.E()).Code()) {
            return false;
        }
        I(context, null, dVar);
        Code(context, dVar.q(), com.huawei.openalliance.ad.utils.b.Code(context));
        return true;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public int B(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        if (L(context, dVar)) {
            fh.V("PPSAppDownloadManager", "open landing page action");
            return -4;
        }
        if (V(context, dVar) != null) {
            fh.V("PPSAppDownloadManager", "ad is invalid ad when pause");
            return -1;
        }
        if (!this.B.Code(context, dVar, false)) {
            fh.V("PPSAppDownloadManager", "pauseDownload has not permission, please add white list");
            return -2;
        }
        AppDownloadTask appDownloadTaskCode = this.Code.Code(dVar.E());
        if (appDownloadTaskCode == null) {
            return 1;
        }
        V(dVar, appDownloadTaskCode);
        Code(dVar, appDownloadTaskCode);
        this.Code.V(appDownloadTaskCode);
        return 1;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public void C(final Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        String str;
        if (V(context, dVar) != null) {
            str = "ad is invalid ad when cancel";
        } else {
            if (this.B.Code(context, dVar, false)) {
                final AppInfo appInfoE = dVar.E();
                AppDownloadTask appDownloadTaskCode = this.Code.Code(appInfoE);
                if (appDownloadTaskCode != null) {
                    V(dVar, appDownloadTaskCode);
                    Code(dVar, appDownloadTaskCode);
                    this.Code.Code(appInfoE, new g.a() { // from class: com.huawei.openalliance.ad.download.app.PPSAppDownloadManager.2
                        @Override // com.huawei.openalliance.ad.download.app.g.a
                        public void Code(boolean z, String str2) {
                            if (z && PPSAppDownloadManager.this.F != null) {
                                if (PPSAppDownloadManager.this.F.intValue() == 14 || PPSAppDownloadManager.this.F.intValue() == 10005) {
                                    PPSAppDownloadManager.V(context, appInfoE);
                                }
                            }
                        }
                    });
                    return;
                }
                return;
            }
            str = "cancelDownload has not permission, please add white list";
        }
        fh.V("PPSAppDownloadManager", str);
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public int Code(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        int iD = D(context, dVar);
        if (dVar != null) {
            db.Code(context, dVar.r(), dVar.d(), dVar.q() == null ? null : dVar.q().aa(), iD);
        }
        return iD;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public int F(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        String str;
        if (dVar == null) {
            str = "ad is empty";
        } else if (V(dVar)) {
            AppDownloadTask appDownloadTaskCode = this.Code.Code(dVar.E());
            if (appDownloadTaskCode != null) {
                return appDownloadTaskCode.S();
            }
            str = "task is not exist.";
        } else {
            str = "ad is not native ad";
        }
        fh.V("PPSAppDownloadManager", str);
        return 0;
    }

    public Integer I(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        return (context == null || dVar == null) ? -1 : null;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public AppStatus S(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        if (dVar == null) {
            return AppStatus.DOWNLOAD;
        }
        if (!I(dVar)) {
            fh.V("PPSAppDownloadManager", "this ad is not a native ad");
            return AppStatus.DOWNLOAD;
        }
        AppInfo appInfoE = dVar.E();
        if (appInfoE != null && com.huawei.openalliance.ad.utils.h.Code(context, appInfoE.Code())) {
            fh.V("PPSAppDownloadManager", "app installed");
            return AppStatus.INSTALLED;
        }
        if (!Z(dVar.E())) {
            return AppStatus.DOWNLOAD;
        }
        AppDownloadTask appDownloadTaskCode = this.Code.Code(appInfoE);
        if (appDownloadTaskCode == null) {
            return AppStatus.DOWNLOAD;
        }
        appDownloadTaskCode.C(dVar.d());
        return com.huawei.hms.ads.utils.a.Code(appDownloadTaskCode);
    }

    public Integer V(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        Integer numI = I(context, dVar);
        return numI != null ? numI : !V(dVar) ? -1 : null;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public int Z(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        if (L(context, dVar)) {
            fh.V("PPSAppDownloadManager", "open landing page action");
            return -4;
        }
        Integer numV = V(context, dVar);
        if (numV != null) {
            return numV.intValue();
        }
        if (!this.B.Code(context, dVar, true)) {
            fh.V("PPSAppDownloadManager", "resumeDownload has not permission, please add white list");
            return -2;
        }
        if (b(context, dVar)) {
            fh.V("PPSAppDownloadManager", "app is installed, open it.");
            return 0;
        }
        if (c(context, dVar)) {
            fh.V("PPSAppDownloadManager", "do app click action.");
            return 0;
        }
        AppDownloadTask appDownloadTaskCode = this.Code.Code(dVar.E());
        if (appDownloadTaskCode == null) {
            fh.V("PPSAppDownloadManager", "app download info is empty, must first invoke startDownload method");
            return -1;
        }
        V(dVar, appDownloadTaskCode);
        Code(dVar, appDownloadTaskCode);
        this.Code.I(appDownloadTaskCode);
        return 0;
    }

    private boolean B(AppInfo appInfo) {
        if (appInfo == null) {
            return true;
        }
        return appInfo.S() && TextUtils.isEmpty(appInfo.C());
    }

    private AppDownloadTask Code(com.huawei.openalliance.ad.inter.data.d dVar) {
        AppDownloadTask appDownloadTaskCode = new AppDownloadTask.a().Code(true).Code(dVar.E()).Code();
        if (appDownloadTaskCode != null) {
            appDownloadTaskCode.C(dVar.d());
            appDownloadTaskCode.Z(dVar.r());
            AdContentData adContentDataQ = dVar.q();
            appDownloadTaskCode.Code(adContentDataQ);
            if (adContentDataQ != null) {
                appDownloadTaskCode.B(adContentDataQ.w());
                appDownloadTaskCode.I(adContentDataQ.D());
                appDownloadTaskCode.D(adContentDataQ.M());
                appDownloadTaskCode.b(adContentDataQ.aE());
                appDownloadTaskCode.C(adContentDataQ.aF());
            }
        }
        return appDownloadTaskCode;
    }

    private void I(Context context, View view, com.huawei.openalliance.ad.inter.data.d dVar) {
        if (view != null && (view instanceof PPSNativeView)) {
            ((PPSNativeView) view).Code((Integer) 6, true);
            return;
        }
        if (dVar != null) {
            String strD = dVar instanceof s ? ((s) dVar).q().D() : null;
            if (strD == null || !strD.equals(this.L)) {
                this.L = strD;
                ji.a aVar = new ji.a();
                aVar.V(Long.valueOf(z.Code())).Code(Long.valueOf(dVar.x())).Code(Integer.valueOf(dVar.y())).V((Integer) 6).I(com.huawei.openalliance.ad.utils.b.Code(context));
                jk.Code(context, dVar.q(), aVar.Code());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        if (al.Code(this.C)) {
            return;
        }
        fh.Code("PPSAppDownloadManager", "clean invalid uniqueId");
        try {
            Set<Map.Entry<String, Pair<String, Long>>> setEntrySet = this.C.entrySet();
            if (setEntrySet == null) {
                return;
            }
            for (Map.Entry<String, Pair<String, Long>> entry : setEntrySet) {
                if (entry != null && entry.getValue() != null && entry.getValue().second != null && z.Code() - ((Long) entry.getValue().second).longValue() > 86400000) {
                    this.C.remove(entry.getKey());
                }
            }
        } catch (Throwable th) {
            fh.I("PPSAppDownloadManager", "clear uniqueIdMap ex: %s", th.getClass().getSimpleName());
        }
    }

    private boolean Z(AppInfo appInfo) {
        String str;
        if (appInfo == null) {
            str = " download app info is empty";
        } else if (TextUtils.isEmpty(appInfo.Code())) {
            str = "app packageName is empty";
        } else {
            if ("11".equals(appInfo.i())) {
                return true;
            }
            if (!V(appInfo) && !com.huawei.hms.ads.utils.a.Code(appInfo) && (TextUtils.isEmpty(appInfo.Z()) || B(appInfo) || appInfo.B() <= 0)) {
                str = " download app info is invalid";
            } else {
                if (this.Code != null) {
                    return true;
                }
                str = " download manager is not init";
            }
        }
        fh.V("PPSAppDownloadManager", str);
        return false;
    }

    private boolean I(AppInfo appInfo) {
        if (appInfo == null) {
            return false;
        }
        String strZ = appInfo.z();
        return (TextUtils.isEmpty(strZ) || TextUtils.isEmpty(appInfo.Code()) || !strZ.equals("6")) ? false : true;
    }

    public static void V(Context context, final AppInfo appInfo) {
        if (appInfo == null) {
            fh.V("PPSAppDownloadManager", "appInfo is empty.");
        } else {
            com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.PPSAppDownloadManager.5
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.download.a aVarCode = com.huawei.openalliance.ad.download.a.Code();
                    if (aVarCode != null) {
                        aVarCode.V(appInfo);
                    }
                }
            });
        }
    }

    private String Code(String str) {
        if (TextUtils.isEmpty(str) || !this.C.containsKey(str) || this.C.get(str) == null) {
            return null;
        }
        return (String) this.C.get(str).first;
    }

    private boolean I(com.huawei.openalliance.ad.inter.data.d dVar) {
        return (dVar instanceof com.huawei.openalliance.ad.inter.data.l) || (dVar instanceof s);
    }

    private void V(com.huawei.openalliance.ad.inter.data.d dVar, AppDownloadTask appDownloadTask) {
        AdContentData adContentDataQ = dVar.q();
        if (adContentDataQ != null) {
            appDownloadTask.I(adContentDataQ.D());
        }
    }

    public Map<String, String> Code(AdContentData adContentData) {
        HashMap map = new HashMap();
        if (adContentData != null) {
            MetaData metaDataS = adContentData.S();
            map.put("appId", metaDataS == null ? "" : metaDataS.b());
            map.put(kk.V, metaDataS != null ? metaDataS.a() : "");
            if (adContentData.t() == null) {
                return map;
            }
            VideoInfo videoInfo = new VideoInfo(adContentData.t());
            map.put(be.m, adContentData.D());
            int iL = videoInfo.L();
            fh.V("PPSAppDownloadManager", "buildLinkedAdConfig, set progress from native view " + iL);
            map.put(be.p, String.valueOf(adContentData.J()));
            map.put(be.s, adContentData.H() ? ex.Code : ex.V);
            map.put(be.r, videoInfo.a());
            map.put(be.q, String.valueOf(iL));
        }
        return map;
    }

    private void Code(Context context, AdContentData adContentData, String str) {
        if (adContentData != null) {
            jk.Code(context, adContentData, 0, 0, "app", 6, str);
        }
    }

    private boolean V(AppInfo appInfo) {
        if (appInfo == null) {
            return false;
        }
        return appInfo.w();
    }

    public static void Code(Context context, final AppInfo appInfo) {
        if (appInfo == null) {
            fh.V("PPSAppDownloadManager", "appInfo is empty.");
        } else {
            com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.PPSAppDownloadManager.3
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.download.a aVarCode = com.huawei.openalliance.ad.download.a.Code();
                    if (aVarCode != null) {
                        aVarCode.Code(appInfo.Code());
                    }
                }
            });
            com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.PPSAppDownloadManager.4
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.download.a aVarCode = com.huawei.openalliance.ad.download.a.Code();
                    if (aVarCode != null) {
                        aVarCode.Code(appInfo);
                    }
                }
            });
        }
    }

    private boolean V(com.huawei.openalliance.ad.inter.data.d dVar) {
        return I(dVar) && Z(dVar.E());
    }

    private void Code(Context context, com.huawei.openalliance.ad.inter.data.d dVar, AppInfo appInfo, String str) {
        if (dVar == null || dVar.q() == null) {
            return;
        }
        String str2 = I(appInfo) ? v.F : "download";
        if (appInfo != null && "11".equals(appInfo.y())) {
            str2 = "restore";
        }
        if (dVar instanceof com.huawei.openalliance.ad.inter.data.l) {
            com.huawei.openalliance.ad.inter.data.l lVar = (com.huawei.openalliance.ad.inter.data.l) dVar;
            if (lVar.g_() != null) {
                fh.V("PPSAppDownloadManager", "fastAppClickInfo is %s ", lVar.g_());
                jk.Code(context, dVar.q(), lVar.g_(), 0, 0, str2, 6, str);
                return;
            }
        }
        jk.Code(context, dVar.q(), 0, 0, str2, 6, str);
    }

    private void Code(Context context, com.huawei.openalliance.ad.inter.data.d dVar, String str) {
        if (dVar == null || dVar.q() == null) {
            return;
        }
        if (dVar instanceof com.huawei.openalliance.ad.inter.data.l) {
            com.huawei.openalliance.ad.inter.data.l lVar = (com.huawei.openalliance.ad.inter.data.l) dVar;
            if (lVar.g_() != null) {
                fh.V("PPSAppDownloadManager", "fastAppClickInfo is %s ", lVar.g_());
                jk.Code(context, dVar.q(), lVar.g_(), 0, 0, "app", 6, str);
                return;
            }
        }
        jk.Code(context, dVar.q(), 0, 0, "app", 6, str);
    }

    private void Code(AppInfo appInfo) {
        if (appInfo == null || !"11".equals(appInfo.y())) {
            return;
        }
        this.Code.Code(appInfo, this.b);
    }

    private void Code(com.huawei.openalliance.ad.inter.data.d dVar, AppDownloadTask appDownloadTask) {
        RewardVerifyConfig rewardVerifyConfigP = dVar.P();
        if (rewardVerifyConfigP != null) {
            appDownloadTask.S(rewardVerifyConfigP.getData());
            appDownloadTask.F(rewardVerifyConfigP.getUserId());
            AdContentData adContentDataF = appDownloadTask.f();
            if (adContentDataF != null) {
                adContentDataF.q(rewardVerifyConfigP.getData());
                adContentDataF.r(rewardVerifyConfigP.getUserId());
            }
        }
        if (dVar.q() != null) {
            AdContentData adContentDataQ = dVar.q();
            if (!TextUtils.isEmpty(adContentDataQ.L())) {
                appDownloadTask.Z(adContentDataQ.L());
            }
            if (!TextUtils.isEmpty(adContentDataQ.aE())) {
                appDownloadTask.b(adContentDataQ.aE());
            }
            if (adContentDataQ.aF() >= 0) {
                appDownloadTask.C(adContentDataQ.aF());
            }
        }
        appDownloadTask.C(dVar.d());
        appDownloadTask.Code(this.F);
        appDownloadTask.V(this.F);
        appDownloadTask.I(Integer.valueOf(this.S));
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public void Code(Integer num) {
        this.F = num;
    }

    private void Code(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        fh.Code("PPSAppDownloadManager", "update uniqueIdMap, pkg: %s, uniqueId: %s", str, str2);
        this.C.put(str, new Pair<>(str2, Long.valueOf(z.Code())));
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.PPSAppDownloadManager.6
            @Override // java.lang.Runnable
            public void run() {
                PPSAppDownloadManager.this.V();
            }
        });
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public void Code(boolean z) {
        this.f6934a = z;
    }

    private boolean Code() {
        return this.F.intValue() == 14 || this.F.intValue() == 10005;
    }

    private boolean Code(Context context, AdContentData adContentData) {
        return (adContentData == null || adContentData.y() == null || adContentData.j() != 7 || com.huawei.openalliance.ad.utils.h.Code(context, adContentData.y().Code())) ? false : true;
    }
}
