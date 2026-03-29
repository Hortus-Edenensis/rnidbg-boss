package com.tencent.turingfd.sdk.ams.ad;

import android.app.Activity;
import android.content.Context;
import android.location.LocationListener;
import android.util.Log;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TuringRiskService {

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.TuringRiskService$do, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class Cdo implements RiskDetectResp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bryony f10744a;

        public Cdo(Bryony bryony) {
            this.f10744a = bryony;
        }

        @Override // com.tencent.turingfd.sdk.ams.ad.RiskDetectResp
        public String getDeviceToken() {
            return this.f10744a.b;
        }

        @Override // com.tencent.turingfd.sdk.ams.ad.RiskDetectResp
        public long getErrorCode() {
            return this.f10744a.f10669a;
        }

        @Override // com.tencent.turingfd.sdk.ams.ad.RiskDetectResp
        public long getStagePackTimeMillis() {
            this.f10744a.getClass();
            return 0L;
        }

        @Override // com.tencent.turingfd.sdk.ams.ad.RiskDetectResp
        public long getStageReqTimeMillis() {
            this.f10744a.getClass();
            return 0L;
        }

        @Override // com.tencent.turingfd.sdk.ams.ad.RiskDetectResp
        public boolean isDowngrade() {
            this.f10744a.getClass();
            return false;
        }
    }

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.TuringRiskService$if, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class Cif implements RiskDetectResp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bryony f10745a;

        public Cif(Bryony bryony) {
            this.f10745a = bryony;
        }

        @Override // com.tencent.turingfd.sdk.ams.ad.RiskDetectResp
        public String getDeviceToken() {
            return this.f10745a.b;
        }

        @Override // com.tencent.turingfd.sdk.ams.ad.RiskDetectResp
        public long getErrorCode() {
            return this.f10745a.f10669a;
        }

        @Override // com.tencent.turingfd.sdk.ams.ad.RiskDetectResp
        public long getStagePackTimeMillis() {
            this.f10745a.getClass();
            return 0L;
        }

        @Override // com.tencent.turingfd.sdk.ams.ad.RiskDetectResp
        public long getStageReqTimeMillis() {
            this.f10745a.getClass();
            return 0L;
        }

        @Override // com.tencent.turingfd.sdk.ams.ad.RiskDetectResp
        public boolean isDowngrade() {
            this.f10745a.getClass();
            return false;
        }
    }

    public static LocationListener getLocationListener() {
        return Lyra.c.b();
    }

    public static RiskDetectResp reqRiskDetectV2(Context context) {
        return reqRiskDetectV2(context, true);
    }

    public static RiskDetectResp reqRiskDetectWithParam(Context context, Map<Integer, String> map) {
        Bryony bryonyA;
        int iA = Marc.a();
        if (iA != 0) {
            Log.i("TuringDebug", "init error : " + iA);
            bryonyA = new Bryony(iA);
        } else {
            bryonyA = Blackberry.a(context, map, 0, 0L);
        }
        return new Cif(bryonyA);
    }

    public static boolean screenProtect(Activity activity) {
        try {
            activity.getWindow().addFlags(8192);
            return true;
        } catch (Throwable th) {
            Log.e("", "screenProtect fail", th);
            return false;
        }
    }

    public static boolean screenUnProtect(Activity activity) {
        try {
            activity.getWindow().clearFlags(8192);
            return true;
        } catch (Throwable th) {
            Log.e("", "screenUnProtect fail", th);
            return false;
        }
    }

    public static RiskDetectResp reqRiskDetectV2(Context context, boolean z) {
        Bryony bryonyA;
        int iA = Marc.a();
        if (iA != 0) {
            Log.i("TuringDebug", "init error : " + iA);
            bryonyA = new Bryony(iA);
        } else {
            bryonyA = Blackberry.a(context, (Map<Integer, String>) null, z ? 1 : 0, 0L);
        }
        return new Cdo(bryonyA);
    }
}
