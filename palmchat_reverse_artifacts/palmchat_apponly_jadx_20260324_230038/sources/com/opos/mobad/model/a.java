package com.opos.mobad.model;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.d.d;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.AdxAdExtInfoData;
import com.opos.mobad.model.data.AppPrivacyData;
import com.opos.mobad.model.data.FloatLayerData;
import com.opos.mobad.model.data.InteractionSensorData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.template.d.f;
import java.text.DecimalFormat;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {
    private static com.opos.mobad.template.d.a a(AppPrivacyData appPrivacyData) {
        if (appPrivacyData == null) {
            return null;
        }
        return new com.opos.mobad.template.d.a(appPrivacyData.d, appPrivacyData.c);
    }

    private static String b(long j) {
        StringBuilder sb;
        if (j <= 0) {
            return null;
        }
        try {
            DecimalFormat decimalFormat = new DecimalFormat("0");
            if (j >= 1073741824) {
                sb = new StringBuilder();
                sb.append(decimalFormat.format(j / 1.0737418E9f));
                sb.append("GB");
            } else {
                if (j < 1048576) {
                    return null;
                }
                sb = new StringBuilder();
                sb.append(decimalFormat.format(j / 1048576.0f));
                sb.append("MB");
            }
            return sb.toString();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("", "", (Throwable) e);
            return null;
        }
    }

    public static final f a(Context context, com.opos.mobad.b bVar, AdItemData adItemData, MaterialData materialData, boolean z, int i) {
        return a(context, bVar, adItemData, materialData, z, materialData.W(), i);
    }

    public static final f a(Context context, com.opos.mobad.b bVar, AdItemData adItemData, MaterialData materialData, boolean z, boolean z2, int i) {
        return a(context, bVar, adItemData, materialData, z, materialData.W(), i, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02cf A[LOOP:0: B:64:0x02c9->B:66:0x02cf, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x032d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final f a(Context context, com.opos.mobad.b bVar, AdItemData adItemData, MaterialData materialData, boolean z, boolean z2, int i, boolean z3) {
        int i2;
        int iOptInt;
        double d;
        double d2;
        f fVar;
        MaterialFileData materialFileDataL;
        MaterialFileData materialFileDataM;
        MaterialFileData materialFileDataN;
        List<MaterialFileData> listE;
        List<MaterialFileData> listH;
        int i3;
        List<MaterialFileData> listD;
        AdxAdExtInfoData adxAdExtInfoData;
        List<String> list;
        int i4;
        Object[] objArr;
        StringBuilder sb;
        com.opos.cmn.an.f.a.b("AdShowDataWrapper", "transformData");
        InteractionSensorData interactionSensorDataAk = adItemData.ak();
        int iA = interactionSensorDataAk.a();
        int iB = interactionSensorDataAk.b();
        int i5 = adItemData.F() == 2 ? 1 : 0;
        List<AdxAdExtInfoData> listAh = materialData.ah();
        if (listAh == null || listAh.isEmpty() || (list = (adxAdExtInfoData = listAh.get(0)).b) == null || list.isEmpty()) {
            i2 = iB;
            iOptInt = 0;
            d = 0.0d;
            d2 = 0.0d;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(adxAdExtInfoData.b.get(0));
                double dOptDouble = jSONObject.optDouble("qpon_value", -1.0d);
                try {
                    double dOptDouble2 = jSONObject.optDouble("qpon_threshold", -1.0d);
                    try {
                        iOptInt = jSONObject.optInt("qpon_type", -1);
                        try {
                            objArr = new Object[1];
                            sb = new StringBuilder();
                            i2 = iB;
                        } catch (Exception e) {
                            e = e;
                            i2 = iB;
                        }
                        try {
                            sb.append("contentType：");
                            sb.append(i5);
                            sb.append("QponType: ");
                            sb.append(iOptInt);
                            sb.append(" QponValue: ");
                            sb.append(dOptDouble);
                            sb.append(" QponThreshold: ");
                            sb.append(dOptDouble2);
                            objArr[0] = sb.toString();
                            com.opos.cmn.an.f.a.b("AdShowDataWrapper", objArr);
                            d2 = dOptDouble2;
                            d = dOptDouble;
                        } catch (Exception e2) {
                            e = e2;
                            d2 = dOptDouble2;
                            i4 = 1;
                            d = dOptDouble;
                            Object[] objArr2 = new Object[i4];
                            objArr2[0] = "QPON JSON fail exception : " + e.getMessage();
                            com.opos.cmn.an.f.a.d("AdShowDataWrapper", objArr2);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        i2 = iB;
                        d2 = dOptDouble2;
                        i4 = 1;
                        iOptInt = 0;
                    }
                } catch (Exception e4) {
                    e = e4;
                    i2 = iB;
                    d = dOptDouble;
                    i4 = 1;
                    iOptInt = 0;
                    d2 = 0.0d;
                    Object[] objArr22 = new Object[i4];
                    objArr22[0] = "QPON JSON fail exception : " + e.getMessage();
                    com.opos.cmn.an.f.a.d("AdShowDataWrapper", objArr22);
                    com.opos.cmn.an.f.a.b("AdShowDataWrapper", "InteractionSensorData:" + interactionSensorDataAk);
                    fVar = new f();
                    fVar.a(materialData.g()).b(materialData.f()).a(adItemData.j()).c(adItemData.E()).d(a(context, adItemData, materialData, z)).f(adItemData.k()).g(materialData.g).a(adItemData.Q() <= 0 ? adItemData.Q() : materialData.s(), materialData.t() * 1000).e(adItemData.b()).h(adItemData.Y()).a(a(adItemData.U())).i(a(materialData.Y())).h(b(materialData.j())).e(adItemData.Z()).b(z2).a(iA).b(i2).i(materialData.Q() == 1 ? 1 : 0);
                    fVar.a(materialData.b() != i ? com.opos.mobad.template.e.a.a(materialData.af()) : com.opos.mobad.template.e.a.UNKNOWN);
                    fVar.i("EXT_PARAM_KEY_FORWARD_DEGREE", String.valueOf(interactionSensorDataAk.f()));
                    fVar.i("EXT_PARAM_KEY_FORWARD_TIME", String.valueOf(interactionSensorDataAk.g()));
                    fVar.i("EXT_PARAM_KEY_TILT_DEGREE", String.valueOf(interactionSensorDataAk.c()));
                    fVar.i("EXT_PARAM_KEY_TILT_TIME", String.valueOf(interactionSensorDataAk.d()));
                    fVar.i("EXT_PARAM_KEY_TILT_TWOWAY", String.valueOf(interactionSensorDataAk.e()));
                    fVar.i("EXT_PARAM_KEY_UP_SLIDE_DISTANCE", String.valueOf(interactionSensorDataAk.h()));
                    fVar.i("EXT_PARAM_KEY_FULL_SCREEN_SLIDE_DISTANCE", String.valueOf(interactionSensorDataAk.i()));
                    fVar.i("EXT_PARAM_KEY_SHAKE_UP_SLIDE_SENSOR_TIME", String.valueOf(interactionSensorDataAk.j()));
                    fVar.i("EXT_PARAM_KEY_SHAKE_UP_SLIDE_SENSOR_DIFF", String.valueOf(interactionSensorDataAk.k()));
                    fVar.i("EXT_PARAM_KEY_SHAKE_UP_SLIDE_DISTANCE", String.valueOf(interactionSensorDataAk.l()));
                    fVar.i("EXT_PARAM_KEY_SLIDE_LAYER_DISTANCE", String.valueOf(interactionSensorDataAk.m()));
                    fVar.i("EXT_PARAM_KEY_SHAKE_SENSOR_ANGLE", String.valueOf(interactionSensorDataAk.n()));
                    fVar.i("EXT_PARAM_KEY_AUTO_PLAY", String.valueOf(z3));
                    fVar.i("EXT_PARAM_KEY_TYPE_DOWNLOAD", String.valueOf(i5));
                    fVar.i("EXT_PARAM_KEY_QPON_TYPE", String.valueOf(iOptInt));
                    fVar.i("EXT_PARAM_KEY_QPON_VALUE", String.valueOf(d));
                    fVar.i("EXT_PARAM_KEY_QPON_THRESHOLD", String.valueOf(d2));
                    materialFileDataL = adItemData.l();
                    if (materialFileDataL != null) {
                    }
                    materialFileDataM = adItemData.m();
                    if (materialFileDataM != null) {
                    }
                    materialFileDataN = adItemData.n();
                    if (materialFileDataN != null) {
                    }
                    listE = materialData.e();
                    if (listE != null) {
                        while (r2.hasNext()) {
                        }
                    }
                    listH = materialData.h();
                    if (listH != null) {
                        i3 = 0;
                    }
                    listD = materialData.D();
                    if (listD != null) {
                        MaterialFileData materialFileData = listD.get(i3);
                        String strA = materialFileData.a();
                        if (adItemData.t() != 1) {
                        }
                        fVar.g(strA, materialFileData.b());
                    }
                    fVar.d(!adItemData.J() ? 1 : 0);
                    a(context, fVar, adItemData, materialData, z);
                    a(fVar, adItemData, materialData);
                    com.opos.cmn.an.f.a.a("AdShowDataWrapper", fVar);
                    return fVar;
                }
            } catch (Exception e5) {
                e = e5;
                i2 = iB;
                i4 = 1;
                iOptInt = 0;
                d = 0.0d;
            }
        }
        com.opos.cmn.an.f.a.b("AdShowDataWrapper", "InteractionSensorData:" + interactionSensorDataAk);
        fVar = new f();
        fVar.a(materialData.g()).b(materialData.f()).a(adItemData.j()).c(adItemData.E()).d(a(context, adItemData, materialData, z)).f(adItemData.k()).g(materialData.g).a(adItemData.Q() <= 0 ? adItemData.Q() : materialData.s(), materialData.t() * 1000).e(adItemData.b()).h(adItemData.Y()).a(a(adItemData.U())).i(a(materialData.Y())).h(b(materialData.j())).e(adItemData.Z()).b(z2).a(iA).b(i2).i(materialData.Q() == 1 ? 1 : 0);
        fVar.a(materialData.b() != i ? com.opos.mobad.template.e.a.a(materialData.af()) : com.opos.mobad.template.e.a.UNKNOWN);
        fVar.i("EXT_PARAM_KEY_FORWARD_DEGREE", String.valueOf(interactionSensorDataAk.f()));
        fVar.i("EXT_PARAM_KEY_FORWARD_TIME", String.valueOf(interactionSensorDataAk.g()));
        fVar.i("EXT_PARAM_KEY_TILT_DEGREE", String.valueOf(interactionSensorDataAk.c()));
        fVar.i("EXT_PARAM_KEY_TILT_TIME", String.valueOf(interactionSensorDataAk.d()));
        fVar.i("EXT_PARAM_KEY_TILT_TWOWAY", String.valueOf(interactionSensorDataAk.e()));
        fVar.i("EXT_PARAM_KEY_UP_SLIDE_DISTANCE", String.valueOf(interactionSensorDataAk.h()));
        fVar.i("EXT_PARAM_KEY_FULL_SCREEN_SLIDE_DISTANCE", String.valueOf(interactionSensorDataAk.i()));
        fVar.i("EXT_PARAM_KEY_SHAKE_UP_SLIDE_SENSOR_TIME", String.valueOf(interactionSensorDataAk.j()));
        fVar.i("EXT_PARAM_KEY_SHAKE_UP_SLIDE_SENSOR_DIFF", String.valueOf(interactionSensorDataAk.k()));
        fVar.i("EXT_PARAM_KEY_SHAKE_UP_SLIDE_DISTANCE", String.valueOf(interactionSensorDataAk.l()));
        fVar.i("EXT_PARAM_KEY_SLIDE_LAYER_DISTANCE", String.valueOf(interactionSensorDataAk.m()));
        fVar.i("EXT_PARAM_KEY_SHAKE_SENSOR_ANGLE", String.valueOf(interactionSensorDataAk.n()));
        fVar.i("EXT_PARAM_KEY_AUTO_PLAY", String.valueOf(z3));
        fVar.i("EXT_PARAM_KEY_TYPE_DOWNLOAD", String.valueOf(i5));
        fVar.i("EXT_PARAM_KEY_QPON_TYPE", String.valueOf(iOptInt));
        fVar.i("EXT_PARAM_KEY_QPON_VALUE", String.valueOf(d));
        fVar.i("EXT_PARAM_KEY_QPON_THRESHOLD", String.valueOf(d2));
        materialFileDataL = adItemData.l();
        if (materialFileDataL != null) {
            fVar.c(materialFileDataL.a(), materialFileDataL.b());
        }
        materialFileDataM = adItemData.m();
        if (materialFileDataM != null) {
            fVar.e(materialFileDataM.a(), materialFileDataM.b());
        }
        materialFileDataN = adItemData.n();
        if (materialFileDataN != null) {
            fVar.d(materialFileDataN.a(), materialFileDataN.b());
        }
        listE = materialData.e();
        if (listE != null && listE.size() > 0) {
            for (MaterialFileData materialFileData2 : listE) {
                fVar.a(materialFileData2.a(), materialFileData2.b());
            }
        }
        listH = materialData.h();
        if (listH != null || listH.size() <= 0) {
            i3 = 0;
        } else {
            i3 = 0;
            fVar.f(listH.get(0).a(), listH.get(0).b());
        }
        listD = materialData.D();
        if (listD != null && listD.size() > 0) {
            MaterialFileData materialFileData3 = listD.get(i3);
            String strA2 = materialFileData3.a();
            if (adItemData.t() != 1) {
                strA2 = d.a(context, materialFileData3.a());
            } else if (adItemData.t() == 2) {
                strA2 = com.opos.mobad.mediaplayer.a.d.a(context, materialFileData3.a(), adItemData.W());
            }
            fVar.g(strA2, materialFileData3.b());
        }
        fVar.d(!adItemData.J() ? 1 : 0);
        a(context, fVar, adItemData, materialData, z);
        a(fVar, adItemData, materialData);
        com.opos.cmn.an.f.a.a("AdShowDataWrapper", fVar);
        return fVar;
    }

    public static final f a(Context context, com.opos.mobad.b bVar, AdHelper.a aVar, boolean z, boolean z2, int i) {
        return a(context, bVar, aVar.c, aVar.d, z, z2, i);
    }

    private static String a(long j) {
        StringBuilder sb;
        if (j <= 0) {
            return null;
        }
        try {
            DecimalFormat decimalFormat = new DecimalFormat("0");
            if (j >= 100000000) {
                sb = new StringBuilder();
                sb.append(decimalFormat.format(j / 1.0E8f));
                sb.append("亿次");
            } else {
                if (j < 10000) {
                    return null;
                }
                sb = new StringBuilder();
                sb.append(decimalFormat.format(j / 10000.0f));
                sb.append("万次");
            }
            return sb.toString();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("", "", (Throwable) e);
            return null;
        }
    }

    private static String a(Context context, AdItemData adItemData, int i, boolean z, boolean z2) {
        String str;
        str = "立即打开";
        String str2 = "";
        if (i != 2102) {
            if (i != 2115) {
                return "";
            }
            if (adItemData.C()) {
                str2 = z2 ? "查看详情" : "查看详情领取奖励";
            }
            if (!adItemData.y() && !adItemData.z()) {
                return str2;
            }
            if (!z) {
                str = z2 ? "立即下载" : "立即安装领取奖励";
            } else if (!z2) {
                str = "打开应用领取激励";
            }
            return str;
        }
        if (adItemData.C()) {
            return z2 ? "查看详情" : "查看详情立即获得奖励";
        }
        str = z ? "立即打开" : "立即下载";
        String str3 = z ? "打开应用立即获得奖励" : "安装应用立即获得奖励";
        String str4 = z ? "打开应用立即获得奖励" : "下载打开应用立即获得奖励";
        if (!adItemData.y() && !adItemData.z()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getClickBnTextWithTemplateId: ");
        sb.append(z2 ? str : adItemData.z() ? str4 : str3);
        com.opos.cmn.an.f.a.b("AdShowDataWrapper", sb.toString());
        return z2 ? str : adItemData.z() ? str4 : str3;
    }

    public static String a(Context context, AdItemData adItemData, MaterialData materialData, boolean z) {
        return a(context, adItemData, materialData, z, false, false);
    }

    public static String a(Context context, AdItemData adItemData, MaterialData materialData, boolean z, boolean z2, boolean z3) {
        String strA = "";
        if (materialData == null) {
            return "";
        }
        if (!z2) {
            strA = a(context, adItemData, materialData.b(), z, z3);
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
        }
        if (z) {
            return "立刻打开";
        }
        if (!TextUtils.isEmpty(materialData.V())) {
            return materialData.V();
        }
        switch (materialData.d()) {
            case 1:
                return "点击查看";
            case 2:
                return (com.opos.cmn.an.d.b.a(materialData.i()) || !com.opos.cmn.an.h.d.a.d(context, materialData.i())) ? "点击安装" : "立刻打开";
            case 3:
                return (com.opos.cmn.an.d.b.a(materialData.i()) || !com.opos.cmn.an.h.d.a.d(context, materialData.i())) ? "立即下载" : "立刻打开";
            case 4:
                return "立刻打开";
            case 5:
                return "查看详情";
            case 6:
                return "秒开";
            case 7:
                return "打开";
            default:
                return strA;
        }
    }

    private static void a(Context context, f fVar, AdItemData adItemData, MaterialData materialData, boolean z) {
        FloatLayerData floatLayerDataR = materialData.R();
        if (floatLayerDataR == null) {
            return;
        }
        fVar.l(floatLayerDataR.b());
        fVar.k(floatLayerDataR.c());
        fVar.j(a(context, adItemData, materialData, z, true, false));
        List<MaterialFileData> listD = floatLayerDataR.d();
        if (listD != null && listD.size() > 0) {
            for (MaterialFileData materialFileData : listD) {
                fVar.b(materialFileData.a(), materialFileData.b());
            }
        }
        MaterialFileData materialFileDataA = floatLayerDataR.a();
        if (materialFileDataA != null) {
            fVar.h(materialFileDataA.a(), materialFileDataA.b());
        }
    }

    private static void a(f fVar, AdItemData adItemData, MaterialData materialData) {
        if (materialData == null) {
            return;
        }
        String strP = materialData.p();
        boolean zEquals = false;
        if (!TextUtils.isEmpty(strP)) {
            try {
                String strOptString = new JSONObject(strP).optString("adCat");
                if (!TextUtils.isEmpty(strOptString)) {
                    zEquals = "2".equals(strOptString);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (adItemData != null && adItemData.F() == 2) {
            zEquals = true;
        }
        if (zEquals) {
            String strA = a(materialData.Y());
            if (!TextUtils.isEmpty(strA)) {
                fVar.j("下载", strA);
            }
            String strB = b(materialData.j());
            if (!TextUtils.isEmpty(strB)) {
                fVar.j("大小", strB);
            }
            String strAe = materialData.ae();
            if (TextUtils.isEmpty(strAe)) {
                return;
            }
            try {
                strAe = new DecimalFormat("#.#").format(Float.parseFloat(strAe));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            fVar.j("评分", strAe);
        }
    }
}
