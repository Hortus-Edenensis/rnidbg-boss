package com.huawei.hms.ads;

import android.content.Context;
import android.os.Bundle;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.beans.inner.ApiStatisticsReq;
import com.huawei.openalliance.ad.beans.metadata.AdTimeStatistics;
import com.huawei.openalliance.ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.ipc.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class db {
    private static final String Code = "AnalysisReport";

    private static <T> void I(Context context, String str, String str2, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        d.Code(context).Code(str, str2, remoteCallResultCallback, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int V(DelayInfo delayInfo) {
        Integer numL;
        int iF = delayInfo.f();
        if (iF == -2) {
            Integer numF = com.huawei.openalliance.ad.utils.bc.F(delayInfo.b());
            iF = delayInfo.i() + (numF != null ? 10000 + numF.intValue() : 10000);
        } else if (iF == 494 && (numL = delayInfo.l()) != null) {
            iF = numL.intValue();
        }
        delayInfo.I(iF);
        return iF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ApiStatisticsReq V(long j, String str, String str2, int i, int i2, DelayInfo delayInfo) {
        ApiStatisticsReq apiStatisticsReq = new ApiStatisticsReq();
        apiStatisticsReq.V(j);
        apiStatisticsReq.V(str);
        apiStatisticsReq.S(str2);
        apiStatisticsReq.I(i);
        apiStatisticsReq.V(i2);
        apiStatisticsReq.Code(delayInfo);
        return apiStatisticsReq;
    }

    public static void Code(int i, long j, Context context, long j2, AdContentData adContentData) {
        if (adContentData == null) {
            return;
        }
        try {
            AnalysisEventReport analysisEventReport = new AnalysisEventReport();
            if (i == 1) {
                analysisEventReport.V(com.huawei.openalliance.ad.beans.inner.a.C);
                analysisEventReport.Z(String.valueOf(j2));
            } else {
                analysisEventReport.V(com.huawei.openalliance.ad.beans.inner.a.S);
            }
            analysisEventReport.B(String.valueOf(j));
            fh.Code(Code, "reportSplashStartMode, mode: %s, timeInterval: %s, adStartLoadTime: %s", Integer.valueOf(i), analysisEventReport.F(), analysisEventReport.D());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(bq.f.T, com.huawei.openalliance.ad.utils.ad.V(analysisEventReport));
            fh.V(Code, "reportSplashStartMode, adContentData.uniqueId: %s", adContentData.aa());
            jSONObject.putOpt(com.huawei.openalliance.ad.constant.be.at, com.huawei.openalliance.ad.utils.ad.V(adContentData));
            V(context, com.huawei.openalliance.ad.constant.s.O, jSONObject.toString(), null, null);
        } catch (Throwable th) {
            fh.I(Code, "reportSplashStartMode ex: %s", th.getClass().getSimpleName());
        }
    }

    public static void V(final Context context, final String str, final AdContentData adContentData) {
        if (adContentData == null) {
            return;
        }
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.db.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                    analysisEventReport.Z(str);
                    analysisEventReport.B(context.getPackageName());
                    analysisEventReport.S("DECOUPLE_SDK");
                    analysisEventReport.V(com.huawei.openalliance.ad.beans.inner.a.B);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(bq.f.T, com.huawei.openalliance.ad.utils.ad.V(analysisEventReport));
                    fh.V(db.Code, "reportJumpFastApp, adContentData.uniqueId: %s", adContentData.aa());
                    jSONObject.putOpt(com.huawei.openalliance.ad.constant.be.at, com.huawei.openalliance.ad.utils.ad.V(adContentData));
                    if (fh.Code()) {
                        fh.Code(db.Code, "ExceptionType is %s, reportJumpFastApp, appName is %s.", com.huawei.openalliance.ad.beans.inner.a.B, str);
                    }
                    db.V(context, com.huawei.openalliance.ad.constant.s.O, jSONObject.toString(), null, null);
                } catch (Throwable th) {
                    fh.I(db.Code, "reportJumpFastApp:" + th.getClass().getSimpleName());
                }
            }
        });
    }

    public static void Code(Context context) {
        V(context, da.F, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void V(Context context, String str, String str2, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        com.huawei.openalliance.ad.ipc.g.V(context).Code(str, str2, remoteCallResultCallback, cls);
    }

    public static void Code(final Context context, final int i, final Integer num, final Integer num2) {
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.db.2
            @Override // java.lang.Runnable
            public void run() {
                AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                analysisEventReport.V(com.huawei.openalliance.ad.constant.x.dL);
                analysisEventReport.I(String.valueOf(i));
                analysisEventReport.Z(String.valueOf(num));
                analysisEventReport.B(String.valueOf(num2));
                analysisEventReport.I(System.currentTimeMillis());
                db.V(context, da.c, com.huawei.openalliance.ad.utils.ad.V(analysisEventReport), null, null);
            }
        });
    }

    public static <T extends com.huawei.openalliance.ad.inter.data.d> void Code(final Context context, final int i, final String str, final int i2, final Map<String, List<T>> map, final long j, final long j2, final long j3) {
        if (j <= 0 || j > j2) {
            return;
        }
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.db.11
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList;
                ArrayList arrayList2;
                DelayInfo delayInfo;
                if (com.huawei.openalliance.ad.utils.al.Code(map)) {
                    arrayList = null;
                    arrayList2 = null;
                    delayInfo = null;
                } else {
                    arrayList = new ArrayList();
                    arrayList2 = new ArrayList();
                    delayInfo = null;
                    for (Map.Entry entry : map.entrySet()) {
                        arrayList.add(entry.getKey());
                        List<com.huawei.openalliance.ad.inter.data.d> list = (List) entry.getValue();
                        if (!com.huawei.openalliance.ad.utils.ag.Code(list)) {
                            for (com.huawei.openalliance.ad.inter.data.d dVar : list) {
                                if (dVar != null) {
                                    if (dVar instanceof com.huawei.openalliance.ad.inter.data.c) {
                                        com.huawei.openalliance.ad.inter.data.c cVar = (com.huawei.openalliance.ad.inter.data.c) dVar;
                                        if (cVar.M() != null) {
                                            delayInfo = cVar.M();
                                        }
                                    }
                                    arrayList2.add(dVar.d());
                                }
                            }
                        }
                    }
                }
                if (delayInfo == null) {
                    delayInfo = new DelayInfo();
                }
                DelayInfo delayInfo2 = delayInfo;
                delayInfo2.Code(arrayList);
                delayInfo2.V(arrayList2);
                delayInfo2.j().Code(j);
                delayInfo2.j().V(j2);
                delayInfo2.j().c(j3);
                db.V(context, com.huawei.openalliance.ad.constant.s.d, com.huawei.openalliance.ad.utils.ad.V(db.V(j2 - j, com.huawei.openalliance.ad.constant.h.Code, str, i2, i, delayInfo2)), null, null);
            }
        });
    }

    public static <T extends com.huawei.openalliance.ad.inter.data.d> void Code(final Context context, final int i, final String str, final int i2, final Map<String, List<T>> map, final long j, final DelayInfo delayInfo) {
        if (fh.Code()) {
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(j);
            objArr[1] = Boolean.valueOf(delayInfo != null);
            fh.Code(Code, "reportE2ECostTime,  duration = %s delayInfo: %s", objArr);
        }
        if (context == null || delayInfo == null || j <= 0) {
            return;
        }
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.db.12
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList;
                ArrayList arrayList2;
                DelayInfo delayInfoM;
                if (com.huawei.openalliance.ad.utils.al.Code(map)) {
                    arrayList = null;
                    arrayList2 = null;
                } else {
                    arrayList = new ArrayList();
                    arrayList2 = new ArrayList();
                    for (Map.Entry entry : map.entrySet()) {
                        arrayList.add(entry.getKey());
                        List<com.huawei.openalliance.ad.inter.data.d> list = (List) entry.getValue();
                        if (!com.huawei.openalliance.ad.utils.ag.Code(list)) {
                            for (com.huawei.openalliance.ad.inter.data.d dVar : list) {
                                if (dVar != null) {
                                    arrayList2.add(dVar.d());
                                    if (dVar instanceof com.huawei.openalliance.ad.inter.data.c) {
                                        com.huawei.openalliance.ad.inter.data.c cVar = (com.huawei.openalliance.ad.inter.data.c) dVar;
                                        if (cVar.M() != null && (delayInfoM = cVar.M()) != null && delayInfoM.p() > 0) {
                                            delayInfo.a(delayInfoM.p());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                delayInfo.Code(arrayList);
                delayInfo.V(arrayList2);
                db.V(context, com.huawei.openalliance.ad.constant.s.d, com.huawei.openalliance.ad.utils.ad.V(db.V(j, com.huawei.openalliance.ad.constant.h.Code, str, i2, i, delayInfo)), null, null);
            }
        });
    }

    public static void Code(Context context, int i, String str, AdContentData adContentData) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.Code(adContentData);
        fh.V(Code, "reportImageLoadFailedEvent, adContentData.uniqueId: %s", adContentData.aa());
        analysisEventReport.Code(i);
        analysisEventReport.I(str);
        analysisEventReport.c(adContentData.a());
        analysisEventReport.d(adContentData.aE());
        analysisEventReport.e(adContentData.L());
        analysisEventReport.I(adContentData.aF());
        V(context, com.huawei.openalliance.ad.constant.s.q, com.huawei.openalliance.ad.utils.ad.V(analysisEventReport), null, null);
    }

    public static void Code(Context context, int i, String str, String str2, String str3) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.V(i);
        analysisEventReport.I(str);
        analysisEventReport.Z(str2);
        analysisEventReport.B(str3);
        V(context, com.huawei.openalliance.ad.download.app.a.Code.equals(str3) ? da.I : da.Z, com.huawei.openalliance.ad.utils.ad.V(analysisEventReport), null, null);
    }

    public static void Code(final Context context, final Bundle bundle, final AdContentData adContentData) {
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.db.16
            @Override // java.lang.Runnable
            public void run() {
                AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                AdContentData adContentData2 = adContentData;
                if (adContentData2 != null) {
                    analysisEventReport.c(adContentData2.a());
                    analysisEventReport.d(adContentData.aE());
                    analysisEventReport.e(adContentData.L());
                    analysisEventReport.I(adContentData.aF());
                    analysisEventReport.Code(adContentData);
                    fh.V(db.Code, "splashEventReport, uniqueId: %s", adContentData.aa());
                }
                Bundle bundle2 = bundle;
                if (bundle2 != null) {
                    ej ejVar = new ej(bundle2);
                    analysisEventReport.V(ejVar.w(bq.f.J));
                    analysisEventReport.I(ejVar.w(bq.f.M));
                    analysisEventReport.Z(ejVar.w(bq.f.N));
                    analysisEventReport.B(ejVar.w(bq.f.O));
                    analysisEventReport.C(ejVar.w(bq.f.P));
                    analysisEventReport.S(ejVar.w(bq.f.Q));
                }
                db.V(context, da.b, com.huawei.openalliance.ad.utils.ad.V(analysisEventReport), null, null);
            }
        });
    }

    public static void Code(final Context context, final kw kwVar, final String str) {
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.db.3
            @Override // java.lang.Runnable
            public void run() {
                AdContentData adContentData = new AdContentData();
                adContentData.B(kwVar.V());
                adContentData.C(kwVar.I());
                adContentData.d(kwVar.Code());
                AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                analysisEventReport.Code(adContentData);
                analysisEventReport.I(kwVar.Z());
                analysisEventReport.Z(kwVar.B());
                analysisEventReport.B(str);
                db.V(context, com.huawei.openalliance.ad.constant.s.M, com.huawei.openalliance.ad.utils.ad.V(analysisEventReport), null, null);
            }
        });
    }

    public void Code(Context context, AnalysisEventReport analysisEventReport, AdContentData adContentData) {
        if (context == null || analysisEventReport == null || adContentData == null) {
            return;
        }
        try {
            fh.Code(Code, "reportCommonExceptionEvent: %s", com.huawei.openalliance.ad.utils.ad.V(analysisEventReport));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(bq.f.T, com.huawei.openalliance.ad.utils.ad.V(analysisEventReport));
            fh.V(Code, "reportCommonExceptionEvent, adContentData.uniqueId: %s", adContentData.aa());
            jSONObject.putOpt(com.huawei.openalliance.ad.constant.be.at, com.huawei.openalliance.ad.utils.ad.V(adContentData));
            V(context, com.huawei.openalliance.ad.constant.s.O, jSONObject.toString(), null, null);
        } catch (Throwable th) {
            fh.I(Code, "reportCommonExceptionEvent ex: %s", th.getClass().getSimpleName());
        }
    }

    public static void Code(Context context, AdContentData adContentData) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        if (adContentData != null) {
            analysisEventReport.c(adContentData.a());
            analysisEventReport.d(adContentData.aE());
            analysisEventReport.e(adContentData.L());
            analysisEventReport.I(adContentData.aF());
            analysisEventReport.I(adContentData.at());
            fh.V(Code, "reportPraise, uniqueId: %s", adContentData.aa());
            analysisEventReport.Code(adContentData);
        } else {
            analysisEventReport.c("");
        }
        V(context, da.L, com.huawei.openalliance.ad.utils.ad.V(analysisEventReport), null, null);
    }

    public static void Code(Context context, AdContentData adContentData, long j, long j2) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.V(j);
        analysisEventReport.I(j2);
        if (adContentData != null) {
            analysisEventReport.c(adContentData.a());
            analysisEventReport.d(adContentData.aE());
            analysisEventReport.e(adContentData.L());
            analysisEventReport.I(adContentData.aF());
            fh.V(Code, "reportVideoStartTimeCost, uniqueId: %s", adContentData.aa());
            analysisEventReport.Code(adContentData);
        } else {
            analysisEventReport.c("");
        }
        V(context, da.V, com.huawei.openalliance.ad.utils.ad.V(analysisEventReport), null, null);
    }

    public static void Code(Context context, AdContentData adContentData, String str) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.Code(adContentData);
        analysisEventReport.I(str);
        if (adContentData != null) {
            analysisEventReport.c(adContentData.a());
            analysisEventReport.d(adContentData.aE());
            analysisEventReport.e(adContentData.L());
            analysisEventReport.I(adContentData.aF());
        }
        V(context, com.huawei.openalliance.ad.constant.s.v, com.huawei.openalliance.ad.utils.ad.V(analysisEventReport), null, null);
    }

    public static void Code(final Context context, final AdContentData adContentData, final String str, final boolean z, final boolean z2) {
        if (adContentData == null) {
            return;
        }
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.db.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                    analysisEventReport.Z(String.valueOf(z));
                    analysisEventReport.B(String.valueOf(z2));
                    analysisEventReport.S(str);
                    analysisEventReport.V(com.huawei.openalliance.ad.beans.inner.a.Z);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(bq.f.T, com.huawei.openalliance.ad.utils.ad.V(analysisEventReport));
                    fh.V(db.Code, "reportBiddingResultByVersionLow, adContentData.uniqueId: %s", adContentData.aa());
                    jSONObject.putOpt(com.huawei.openalliance.ad.constant.be.at, com.huawei.openalliance.ad.utils.ad.V(adContentData));
                    if (fh.Code()) {
                        fh.Code(db.Code, "ExceptionType is %s, Bidding Result is %s, Report Result %s, url is %s", com.huawei.openalliance.ad.beans.inner.a.Z, Boolean.valueOf(z), Boolean.valueOf(z2), str);
                    }
                    db.V(context, com.huawei.openalliance.ad.constant.s.O, jSONObject.toString(), null, null);
                } catch (Throwable th) {
                    fh.I(db.Code, "report onAnalysis error, type: %s, reportBiddingResultByVersionLow: %s", com.huawei.openalliance.ad.beans.inner.a.Z, th.getClass().getSimpleName());
                }
            }
        });
    }

    public static void Code(final Context context, final AdContentData adContentData, final boolean z, final boolean z2, final int i) {
        if (adContentData == null) {
            return;
        }
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.db.5
            @Override // java.lang.Runnable
            public void run() {
                int autoPlayNetwork;
                boolean zIsStartMuted;
                try {
                    AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                    analysisEventReport.V(com.huawei.openalliance.ad.constant.x.dM);
                    analysisEventReport.I(context.getPackageName());
                    if (adContentData.aU() != null) {
                        VideoConfiguration videoConfigurationAU = adContentData.aU();
                        zIsStartMuted = videoConfigurationAU.isStartMuted();
                        autoPlayNetwork = videoConfigurationAU.getAutoPlayNetwork();
                        analysisEventReport.Z(String.valueOf(z));
                        analysisEventReport.B(String.valueOf(autoPlayNetwork));
                        analysisEventReport.C(String.valueOf(z2));
                        analysisEventReport.S(String.valueOf(zIsStartMuted));
                    } else {
                        autoPlayNetwork = 0;
                        zIsStartMuted = false;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(bq.f.T, com.huawei.openalliance.ad.utils.ad.V(analysisEventReport));
                    fh.V(db.Code, "rpt TYPE_CONFIG_VIDEO, uniqueId: %s", adContentData.aa());
                    jSONObject.putOpt(com.huawei.openalliance.ad.constant.be.at, com.huawei.openalliance.ad.utils.ad.V(adContentData));
                    if (fh.Code()) {
                        fh.Code(db.Code, "ExceptionType is %s, Media pkgName is %s, AdType is %s, ServerFirst is %s, AutoPlay is %s, ServerFirst is %s, isMute is %s", com.huawei.openalliance.ad.constant.x.dM, context.getPackageName(), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(zIsStartMuted), Boolean.valueOf(z2), Integer.valueOf(autoPlayNetwork));
                    }
                    db.V(context, com.huawei.openalliance.ad.constant.s.O, jSONObject.toString(), null, null);
                } catch (Throwable th) {
                    fh.I(db.Code, "report onAnalysis error, type: %s, onSetVideoConfigMedia: %s", com.huawei.openalliance.ad.constant.x.dM, th.getClass().getSimpleName());
                }
            }
        });
    }

    public static void Code(final Context context, final com.huawei.openalliance.ad.inter.data.d dVar, final String str) {
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.db.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (dVar == null) {
                        return;
                    }
                    AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                    analysisEventReport.f(dVar.g());
                    analysisEventReport.e(dVar.r());
                    analysisEventReport.c(dVar.d());
                    analysisEventReport.V(str);
                    JSONObject jSONObject = new JSONObject();
                    if (fh.Code()) {
                        fh.Code(db.Code, "ExceptionType is %s, ContentId is %s, SlotId is %s, TaskId is %s", str, dVar.d(), dVar.r(), dVar.g());
                    }
                    if (dVar.q() != null) {
                        fh.V(db.Code, "ExceptionType is %s, uniqueId is %s", str, dVar.q().aa());
                    } else {
                        fh.V(db.Code, "ExceptionType is %s, not has adContentData", str);
                    }
                    jSONObject.put(bq.f.T, com.huawei.openalliance.ad.utils.ad.V(analysisEventReport));
                    jSONObject.putOpt(com.huawei.openalliance.ad.constant.be.at, com.huawei.openalliance.ad.utils.ad.V(dVar.q()));
                    db.V(context, com.huawei.openalliance.ad.constant.s.O, jSONObject.toString(), null, null);
                } catch (Throwable th) {
                    fh.I(db.Code, "report onAnalysis error, type: %s, reportPlayable: %s", str, th.getClass().getSimpleName());
                }
            }
        });
    }

    public static void Code(final Context context, final String str) {
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.db.4
            @Override // java.lang.Runnable
            public void run() {
                db.V(context, com.huawei.openalliance.ad.constant.s.O, str, null, null);
            }
        });
    }

    public static void Code(Context context, String str, int i, int i2) {
        try {
            AnalysisEventReport analysisEventReport = new AnalysisEventReport();
            analysisEventReport.V(com.huawei.openalliance.ad.beans.inner.a.f6913a);
            analysisEventReport.e(str);
            analysisEventReport.Z(String.valueOf(i));
            analysisEventReport.B(String.valueOf(i2));
            fh.Code(Code, "reportSingleSlotShowMultiFail onAnalysis, slotId: %s, adCount: %s, templateAdCount: %s", str, Integer.valueOf(i), Integer.valueOf(i2));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(bq.f.T, com.huawei.openalliance.ad.utils.ad.V(analysisEventReport));
            V(context, com.huawei.openalliance.ad.constant.s.O, jSONObject.toString(), null, null);
        } catch (Throwable th) {
            fh.I(Code, "reportSingleSlotShowMultiFail error : %s", th.getClass().getSimpleName());
        }
    }

    public static void Code(final Context context, final String str, final int i, final AdContentData adContentData, final DelayInfo delayInfo) {
        if (delayInfo == null || delayInfo.Code() == null) {
            return;
        }
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.db.10
            @Override // java.lang.Runnable
            public void run() {
                AdContentData adContentData2 = adContentData;
                if (adContentData2 != null) {
                    delayInfo.V(adContentData2.ak());
                    delayInfo.V(Collections.singletonList(adContentData.a()));
                    delayInfo.Code(adContentData.aq());
                    delayInfo.Code(Integer.valueOf(adContentData.l()));
                    DelayInfo delayInfoAn = adContentData.an();
                    if (delayInfoAn != null) {
                        delayInfo.C(delayInfoAn.c());
                        delayInfo.Code(delayInfoAn.V());
                        delayInfo.I(delayInfoAn.Z());
                        delayInfo.B(delayInfoAn.C());
                        delayInfo.V(delayInfoAn.I());
                        delayInfo.F(delayInfoAn.g().longValue());
                        delayInfo.I(delayInfoAn.m());
                        AdTimeStatistics adTimeStatisticsJ = delayInfoAn.j();
                        if (adTimeStatisticsJ != null) {
                            AdTimeStatistics adTimeStatisticsJ2 = delayInfo.j();
                            adTimeStatisticsJ.Code(adTimeStatisticsJ2.Code());
                            adTimeStatisticsJ.V(adTimeStatisticsJ2.V());
                            adTimeStatisticsJ.c(adTimeStatisticsJ2.c());
                            adTimeStatisticsJ.d(adTimeStatisticsJ2.d());
                            adTimeStatisticsJ.e(adTimeStatisticsJ2.e());
                            delayInfo.Code(adTimeStatisticsJ);
                        }
                    }
                }
                db.V(context, com.huawei.openalliance.ad.constant.s.d, com.huawei.openalliance.ad.utils.ad.V(db.V(delayInfo.Code().longValue(), com.huawei.openalliance.ad.constant.h.Code, str, i, db.V(delayInfo), delayInfo)), null, null);
            }
        });
    }

    public static void Code(final Context context, final String str, final AdContentData adContentData) {
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.db.15
            @Override // java.lang.Runnable
            public void run() {
                AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                analysisEventReport.I(str);
                AdContentData adContentData2 = adContentData;
                if (adContentData2 != null) {
                    analysisEventReport.c(adContentData2.a());
                    analysisEventReport.d(adContentData.aE());
                    analysisEventReport.e(adContentData.L());
                    analysisEventReport.I(adContentData.aF());
                    analysisEventReport.Code(adContentData);
                }
                db.V(context, da.f6534a, com.huawei.openalliance.ad.utils.ad.V(analysisEventReport), null, null);
            }
        });
    }

    public static void Code(Context context, String str, AdContentData adContentData, String str2) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.c(str);
        analysisEventReport.I(str2);
        if (adContentData != null) {
            analysisEventReport.d(adContentData.aE());
            analysisEventReport.e(adContentData.L());
            analysisEventReport.I(adContentData.aF());
        }
        V(context, da.C, com.huawei.openalliance.ad.utils.ad.V(analysisEventReport), null, null);
    }

    public static void Code(final Context context, final String str, final String str2, final int i, final int i2, final String str3) {
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.db.1
            @Override // java.lang.Runnable
            public void run() {
                AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                analysisEventReport.Code(i2);
                analysisEventReport.V(i);
                analysisEventReport.I(str);
                analysisEventReport.Z(str2);
                analysisEventReport.B(str3);
                db.V(context, da.Code, com.huawei.openalliance.ad.utils.ad.V(analysisEventReport), null, null);
            }
        });
    }

    public static void Code(final Context context, final String str, final String str2, final int i, final String str3) {
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.db.14
            @Override // java.lang.Runnable
            public void run() {
                AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                analysisEventReport.I(str);
                analysisEventReport.Z(str2);
                analysisEventReport.Code(i);
                analysisEventReport.B(str3);
                db.V(context, da.D, com.huawei.openalliance.ad.utils.ad.V(analysisEventReport), null, null);
            }
        });
    }

    public static void Code(final Context context, final String str, final String str2, final long j) {
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.db.13
            @Override // java.lang.Runnable
            public void run() {
                AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                analysisEventReport.I(str);
                analysisEventReport.Z(str2);
                analysisEventReport.V(j);
                analysisEventReport.Code(0);
                db.V(context, da.D, com.huawei.openalliance.ad.utils.ad.V(analysisEventReport), null, null);
            }
        });
    }

    public static void Code(Context context, String str, String str2, long j, AdContentData adContentData, String str3) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.Code(adContentData);
        analysisEventReport.c(str2);
        analysisEventReport.I(str);
        analysisEventReport.I(j);
        analysisEventReport.V(str3);
        if (adContentData != null) {
            analysisEventReport.d(adContentData.aE());
            analysisEventReport.e(adContentData.L());
            analysisEventReport.I(adContentData.aF());
        }
        I(context, da.B, com.huawei.openalliance.ad.utils.ad.V(analysisEventReport), null, null);
    }

    public static void Code(Context context, String str, String str2, String str3) {
        try {
            AnalysisEventReport analysisEventReport = new AnalysisEventReport();
            analysisEventReport.V(com.huawei.openalliance.ad.beans.inner.a.L);
            analysisEventReport.I(str);
            analysisEventReport.Z(str2);
            analysisEventReport.B(str3);
            fh.Code(Code, "reportDslZipSha256CheckResult onAnalysis, checkResult: %s, dslVersion: %s, failReason: %s", str, str2, str3);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(bq.f.T, com.huawei.openalliance.ad.utils.ad.V(analysisEventReport));
            V(context, com.huawei.openalliance.ad.constant.s.O, jSONObject.toString(), null, null);
        } catch (Throwable th) {
            fh.I(Code, "reportDslZipSha256CheckResult ex: %s", th.getClass().getSimpleName());
        }
    }

    public static void Code(final Context context, final String str, final String str2, final String str3, final int i) {
        if (context == null) {
            fh.I(Code, "report para err");
        } else {
            com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.db.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                        analysisEventReport.V(com.huawei.openalliance.ad.constant.x.dN);
                        analysisEventReport.I(com.huawei.openalliance.ad.utils.bc.Code(Integer.valueOf(i)));
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(bq.f.T, com.huawei.openalliance.ad.utils.ad.V(analysisEventReport));
                        jSONObject.put("slotid", str);
                        jSONObject.put("content_id", str2);
                        jSONObject.put("unique_id", str3);
                        if (fh.Code()) {
                            fh.Code(db.Code, "ExceptionType is %s, Media pkgName is %s, downloadResult is %s", com.huawei.openalliance.ad.constant.x.dN, context.getPackageName(), Integer.valueOf(i));
                        }
                        db.V(context, com.huawei.openalliance.ad.constant.s.O, com.huawei.openalliance.ad.utils.ad.V(jSONObject), null, null);
                    } catch (Throwable th) {
                        fh.I(db.Code, "report onAnalysis error, type: %s, reportDownloadInterface: %s", com.huawei.openalliance.ad.constant.x.dN, th.getClass().getSimpleName());
                    }
                }
            });
        }
    }
}
