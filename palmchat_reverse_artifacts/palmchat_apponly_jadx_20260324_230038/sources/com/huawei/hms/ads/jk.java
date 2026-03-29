package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.ji;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class jk {
    public static final String Code = "EvtProcessor";

    public static AdEventReport Code(AdContentData adContentData) {
        AdEventReport adEventReport = new AdEventReport();
        if (adContentData != null) {
            adEventReport.Code(adContentData.aa());
            fh.V(Code, "createAdEventReport, uniqueId: %s", adEventReport.Code());
            adEventReport.Code(adContentData.Z());
            adEventReport.I(adContentData.a());
            adEventReport.C(adContentData.D());
            adEventReport.S(adContentData.M());
            adEventReport.a(adContentData.am());
            adEventReport.Z(adContentData.ap());
            adEventReport.Code(adContentData.aB());
            adEventReport.Z(adContentData.aF());
            adEventReport.c(adContentData.aE());
            adEventReport.d(adContentData.L());
            adEventReport.B(adContentData.aN());
            adEventReport.Code(adContentData.I());
            adEventReport.g(h.Code());
        }
        return adEventReport;
    }

    public static void I(Context context, AdContentData adContentData, String str) {
        AdEventReport adEventReportCode = Code(adContentData);
        adEventReportCode.F(str);
        Code(context, com.huawei.openalliance.ad.constant.s.f, adEventReportCode);
    }

    public static void V(Context context, AdContentData adContentData) {
        Code(context, com.huawei.openalliance.ad.constant.s.e, Code(adContentData));
    }

    public static void Code(Context context, AdContentData adContentData) {
        Code(context, com.huawei.openalliance.ad.constant.s.I, Code(adContentData));
    }

    public static void V(Context context, AdContentData adContentData, ji jiVar) {
        Code(context, adContentData, false, jiVar);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, String str) {
        Code(context, adContentData, i, i2, (List<String>) null, str);
    }

    public static void V(Context context, AdContentData adContentData, String str) {
        AdEventReport adEventReportCode = Code(adContentData);
        adEventReportCode.Z(str);
        adEventReportCode.V(adContentData.aS());
        Code(context, com.huawei.openalliance.ad.constant.s.G, adEventReportCode);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, String str, int i3, MaterialClickInfo materialClickInfo, String str2, int[] iArr) {
        Code(context, adContentData, i, i2, str, Integer.valueOf(i3), materialClickInfo, str2, iArr, null);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, String str, int i3, String str2) {
        AdEventReport adEventReportCode = Code(adContentData);
        adEventReportCode.V(i);
        adEventReportCode.I(i2);
        adEventReportCode.B(str);
        adEventReportCode.I(Integer.valueOf(i3));
        adEventReportCode.L(str2);
        adEventReportCode.Z(Long.valueOf(com.huawei.openalliance.ad.utils.z.Code()));
        adEventReportCode.f((Integer) 1);
        Code(context, com.huawei.openalliance.ad.constant.s.B, adEventReportCode);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, String str, int i3, String str2, int[] iArr) {
        AdEventReport adEventReportCode = Code(adContentData);
        adEventReportCode.V(i);
        adEventReportCode.I(i2);
        adEventReportCode.B(str);
        adEventReportCode.I(Integer.valueOf(i3));
        adEventReportCode.L(str2);
        if (!com.huawei.openalliance.ad.utils.ag.Code(iArr) && iArr.length > 1) {
            adEventReportCode.L(Integer.valueOf(iArr[0]));
            adEventReportCode.a(Integer.valueOf(iArr[1]));
            adEventReportCode.b(Integer.valueOf(com.huawei.openalliance.ad.utils.bg.L(context)));
        }
        adEventReportCode.Z(Long.valueOf(com.huawei.openalliance.ad.utils.z.Code()));
        adEventReportCode.f((Integer) 1);
        Code(context, com.huawei.openalliance.ad.constant.s.B, adEventReportCode);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, String str, MaterialClickInfo materialClickInfo, String str2, int[] iArr) {
        AdEventReport adEventReportCode = Code(adContentData);
        adEventReportCode.V(i);
        adEventReportCode.I(i2);
        if (!com.huawei.openalliance.ad.utils.ag.Code(iArr) && iArr.length > 1) {
            adEventReportCode.L(Integer.valueOf(iArr[0]));
            adEventReportCode.a(Integer.valueOf(iArr[1]));
            adEventReportCode.b(Integer.valueOf(com.huawei.openalliance.ad.utils.bg.L(context)));
        }
        adEventReportCode.B(str);
        adEventReportCode.L(str2);
        Code(adEventReportCode, materialClickInfo);
        adEventReportCode.Z(Long.valueOf(com.huawei.openalliance.ad.utils.z.Code()));
        Code(context, com.huawei.openalliance.ad.constant.s.B, adEventReportCode);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, String str, Integer num, MaterialClickInfo materialClickInfo, String str2, int[] iArr, ji jiVar) {
        String strF;
        AdEventReport adEventReportCode = Code(adContentData);
        adEventReportCode.V(i);
        adEventReportCode.I(i2);
        if (!com.huawei.openalliance.ad.utils.ag.Code(iArr) && iArr.length > 1) {
            adEventReportCode.L(Integer.valueOf(iArr[0]));
            adEventReportCode.a(Integer.valueOf(iArr[1]));
            adEventReportCode.b(Integer.valueOf(com.huawei.openalliance.ad.utils.bg.L(context)));
        }
        adEventReportCode.B(str);
        adEventReportCode.I(num);
        adEventReportCode.L(str2);
        Code(adEventReportCode, materialClickInfo);
        if (materialClickInfo != null) {
            adEventReportCode.Z(materialClickInfo.F());
            strF = materialClickInfo.F();
        } else {
            strF = com.huawei.openalliance.ad.constant.s.B;
        }
        adEventReportCode.Z(Long.valueOf(com.huawei.openalliance.ad.utils.z.Code()));
        if (jiVar != null) {
            adEventReportCode.i(jiVar.L());
        }
        Code(context, strF, adEventReportCode);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, String str, String str2) {
        MaterialClickInfo materialClickInfo = new MaterialClickInfo();
        materialClickInfo.B((Integer) 1);
        Code(context, adContentData, i, i2, str, materialClickInfo, str2, new int[0]);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, String str, String str2, int[] iArr) {
        MaterialClickInfo materialClickInfo = new MaterialClickInfo();
        materialClickInfo.B((Integer) 1);
        Code(context, adContentData, i, i2, str, materialClickInfo, str2, iArr);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, List<String> list) {
        Code(context, adContentData, i, i2, list, (String) null);
    }

    private static void Code(Context context, AdContentData adContentData, int i, int i2, List<String> list, String str) {
        AdEventReport adEventReportCode = Code(adContentData);
        adEventReportCode.V(i);
        adEventReportCode.I(i2);
        adEventReportCode.Code(list);
        if (!com.huawei.openalliance.ad.utils.bc.Code(str)) {
            adEventReportCode.Z(str);
        }
        Code(context, com.huawei.openalliance.ad.constant.s.C, adEventReportCode);
    }

    public static void Code(Context context, AdContentData adContentData, long j, int i) {
        ji.a aVar = new ji.a();
        aVar.Code(Long.valueOf(j)).Code(Integer.valueOf(i));
        Code(context, adContentData, true, aVar.Code());
    }

    public static void Code(Context context, AdContentData adContentData, ji jiVar) {
        Code(context, adContentData, false, jiVar);
    }

    public static void Code(Context context, AdContentData adContentData, ji jiVar, String str) {
        Code(context, adContentData, false, jiVar, str);
    }

    public static void Code(Context context, AdContentData adContentData, MaterialClickInfo materialClickInfo, int i, int i2, String str, int i3, String str2) {
        AdEventReport adEventReportCode = Code(adContentData);
        adEventReportCode.V(i);
        adEventReportCode.I(i2);
        adEventReportCode.B(str);
        adEventReportCode.I(Integer.valueOf(i3));
        adEventReportCode.L(str2);
        adEventReportCode.Z(Long.valueOf(com.huawei.openalliance.ad.utils.z.Code()));
        Code(adEventReportCode, materialClickInfo);
        Code(context, com.huawei.openalliance.ad.constant.s.B, adEventReportCode);
    }

    public static void Code(Context context, AdContentData adContentData, Integer num) {
        AdEventReport adEventReportCode = Code(adContentData);
        adEventReportCode.I(num);
        Code(context, com.huawei.openalliance.ad.constant.s.D, adEventReportCode);
    }

    public static void Code(Context context, AdContentData adContentData, Integer num, String str) {
        AdEventReport adEventReportCode = Code(adContentData);
        adEventReportCode.I(num);
        adEventReportCode.F(str);
        Code(context, com.huawei.openalliance.ad.constant.s.F, adEventReportCode);
    }

    public static void Code(Context context, AdContentData adContentData, Long l, Integer num, Integer num2, Long l2, Boolean bool) {
        ji.a aVar = new ji.a();
        aVar.Code(l).Code(num).V(num2).V(l2).Code(bool);
        Code(context, adContentData, false, aVar.Code());
    }

    public static void Code(Context context, AdContentData adContentData, String str) {
        Code(context, adContentData, str, (Long) null, (Boolean) null);
    }

    public static void Code(Context context, AdContentData adContentData, String str, int i, int i2, String str2, int i3, String str3, MaterialClickInfo materialClickInfo) {
        Code(context, adContentData, str, i, i2, str2, i3, str3, null, null, materialClickInfo);
    }

    public static void Code(Context context, AdContentData adContentData, String str, int i, int i2, String str2, int i3, String str3, Long l, Boolean bool, MaterialClickInfo materialClickInfo) {
        AdEventReport adEventReportCode = Code(adContentData);
        adEventReportCode.V(i);
        adEventReportCode.I(i2);
        adEventReportCode.B(str2);
        adEventReportCode.I(Integer.valueOf(i3));
        adEventReportCode.F(str);
        adEventReportCode.L(str3);
        adEventReportCode.Z(l);
        adEventReportCode.Code(bool);
        Code(adEventReportCode, materialClickInfo);
        Code(context, com.huawei.openalliance.ad.constant.s.B, adEventReportCode);
    }

    public static void Code(Context context, AdContentData adContentData, String str, Integer num, Integer num2) {
        Code(context, adContentData, str, num, num2, (Long) null, (Boolean) null);
    }

    public static void Code(Context context, AdContentData adContentData, String str, Integer num, Integer num2, Long l, Boolean bool) {
        AdEventReport adEventReportCode = Code(adContentData);
        adEventReportCode.Z(str);
        adEventReportCode.C(num);
        adEventReportCode.S(num2);
        adEventReportCode.Z(l);
        adEventReportCode.Code(bool);
        Code(context, com.huawei.openalliance.ad.constant.s.S, adEventReportCode);
    }

    public static void Code(Context context, AdContentData adContentData, String str, Long l, Boolean bool) {
        AdEventReport adEventReportCode = Code(adContentData);
        adEventReportCode.F(str);
        Code(context, com.huawei.openalliance.ad.constant.s.I, adEventReportCode);
    }

    public static void Code(Context context, AdContentData adContentData, String str, Long l, Long l2, Integer num, Integer num2) {
        AdEventReport adEventReportCode = Code(adContentData);
        adEventReportCode.Z(str);
        adEventReportCode.V(l);
        adEventReportCode.I(l2);
        adEventReportCode.Z(num);
        adEventReportCode.B(num2);
        Code(context, com.huawei.openalliance.ad.constant.s.Z, adEventReportCode);
    }

    public static void Code(Context context, AdContentData adContentData, String str, Long l, Long l2, Integer num, Integer num2, String str2) {
        AdEventReport adEventReportCode = Code(adContentData);
        adEventReportCode.Z(str);
        adEventReportCode.V(l);
        adEventReportCode.I(l2);
        adEventReportCode.Z(num);
        adEventReportCode.B(num2);
        adEventReportCode.F(str2);
        Code(context, com.huawei.openalliance.ad.constant.s.Z, adEventReportCode);
    }

    public static void Code(Context context, AdContentData adContentData, String str, String str2, String str3) {
        AdEventReport adEventReportCode = Code(adContentData);
        if (str != null) {
            adEventReportCode.F(str);
        } else {
            fh.I("event", "on ad rewarded, customData is null");
        }
        if (str2 != null) {
            adEventReportCode.D(str2);
        } else {
            fh.I("event", "on ad rewarded, userId is null");
        }
        adEventReportCode.L(str3);
        Code(context, com.huawei.openalliance.ad.constant.s.b, adEventReportCode);
    }

    public static void Code(Context context, AdContentData adContentData, List<FeedbackInfo> list, int i) {
        AdEventReport adEventReportCode = Code(adContentData);
        adEventReportCode.F(String.valueOf(i));
        adEventReportCode.V(list);
        Code(context, com.huawei.openalliance.ad.constant.s.w, adEventReportCode);
    }

    public static void Code(Context context, AdContentData adContentData, boolean z) {
        AdEventReport adEventReportCode = Code(adContentData);
        adEventReportCode.I(z);
        Code(context, com.huawei.openalliance.ad.constant.s.j, adEventReportCode);
    }

    private static void Code(Context context, AdContentData adContentData, boolean z, ji jiVar) {
        Code(context, adContentData, z, jiVar, (String) null);
    }

    private static void Code(Context context, AdContentData adContentData, boolean z, ji jiVar, String str) {
        if (adContentData == null) {
            fh.I(Code, "on ad show, ad data is null");
            return;
        }
        AdEventReport adEventReportCode = Code(adContentData);
        adEventReportCode.V(z);
        if (jiVar != null) {
            if (jiVar.F() != null) {
                adEventReportCode.F(jiVar.F());
            }
            if (jiVar.V() != null) {
                adEventReportCode.Code(jiVar.V());
            }
            if (jiVar.I() != null) {
                adEventReportCode.V(jiVar.I());
            }
            if (jiVar.Z() != null) {
                adEventReportCode.I(jiVar.Z());
            }
            if (jiVar.B() != null) {
                adEventReportCode.L(jiVar.B());
            }
            if (jiVar.C() != null) {
                adEventReportCode.Z(jiVar.C());
            }
            if (jiVar.S() != null) {
                adEventReportCode.Code(jiVar.S());
            }
            if (jiVar.D() != null) {
                adEventReportCode.e(jiVar.D());
            }
            if (jiVar.Code() != null) {
                adEventReportCode.b(jiVar.Code());
            }
            if (adContentData.F() != null) {
                adEventReportCode.Code(adContentData.F());
            }
            if (jiVar.L() != null) {
                adEventReportCode.i(jiVar.L());
            }
        }
        if (!com.huawei.openalliance.ad.utils.bc.Code(str)) {
            adEventReportCode.Z(str);
        }
        Code(context, com.huawei.openalliance.ad.constant.s.V, adEventReportCode);
    }

    public static void Code(Context context, String str) {
        com.huawei.openalliance.ad.ipc.h.Code(context, false).Code(com.huawei.openalliance.ad.constant.s.N, str, null, null);
    }

    private static void Code(Context context, String str, AdEventReport adEventReport) {
        if (context == null) {
            return;
        }
        com.huawei.openalliance.ad.ipc.h.Code(context, adEventReport.w()).Code(str, com.huawei.openalliance.ad.utils.ad.V(adEventReport), null, null);
    }

    private static void Code(AdEventReport adEventReport, MaterialClickInfo materialClickInfo) {
        if (materialClickInfo != null) {
            adEventReport.F(materialClickInfo.Code());
            adEventReport.D(materialClickInfo.V());
            adEventReport.q(materialClickInfo.o());
            adEventReport.r(materialClickInfo.p());
            adEventReport.b(materialClickInfo.I());
            adEventReport.c(materialClickInfo.Z());
            adEventReport.Code(materialClickInfo.S());
            adEventReport.d(materialClickInfo.B());
            adEventReport.e(materialClickInfo.C());
            adEventReport.f(materialClickInfo.a());
            adEventReport.C(materialClickInfo.L());
            adEventReport.B(materialClickInfo.D());
            adEventReport.f(materialClickInfo.b());
            adEventReport.j(materialClickInfo.d());
            adEventReport.g(materialClickInfo.e());
            adEventReport.h(materialClickInfo.f());
            adEventReport.i(materialClickInfo.g());
            adEventReport.j(materialClickInfo.h());
            adEventReport.k(materialClickInfo.i());
            adEventReport.l(materialClickInfo.j());
            adEventReport.m(materialClickInfo.k());
            adEventReport.n(materialClickInfo.l());
            adEventReport.o(materialClickInfo.m());
            adEventReport.p(materialClickInfo.n());
            adEventReport.h(materialClickInfo.c());
        }
    }
}
