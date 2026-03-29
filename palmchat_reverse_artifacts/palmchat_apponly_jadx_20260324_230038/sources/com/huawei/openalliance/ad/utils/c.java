package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.DefaultTemplate;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.ei;
import com.huawei.hms.ads.ej;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.beans.inner.BaseAdReqParam;
import com.huawei.openalliance.ad.beans.metadata.CtrlExt;
import com.huawei.openalliance.ad.beans.metadata.PromoteInfo;
import com.huawei.openalliance.ad.constant.cz;
import com.huawei.openalliance.ad.constant.da;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c {
    private static final String Code = "AdDataUtil";
    private static final int I = 30459301;
    private static final String V = "updateStyleFcFlag";

    public static Bundle Code(String str, Bundle bundle, IObjectWrapper iObjectWrapper) {
        try {
            com.huawei.hms.ads.uiengine.d dVarV = com.huawei.hms.ads.h.V();
            if (dVarV != null) {
                return dVarV.Code(str, bundle, iObjectWrapper);
            }
            return null;
        } catch (Throwable th) {
            fh.I(Code, "invoke ui engine method %s, err: %s", str, th.getClass().getSimpleName());
            return null;
        }
    }

    private static String V(Context context, int i) {
        return context.getResources().getString(i, context.getResources().getString(R.string.hiad_appGallery));
    }

    public static BaseAdReqParam Code(Context context) {
        final at atVarCode = at.Code(context);
        i.Code(new Runnable() { // from class: com.huawei.openalliance.ad.utils.c.1
            @Override // java.lang.Runnable
            public void run() {
                ej ejVar = new ej(c.Code(cz.Code, (Bundle) null, (IObjectWrapper) null));
                String strW = ejVar.w(da.Code);
                String strW2 = ejVar.w(da.V);
                fh.V(c.Code, "cache uiEngineInfo, dslVersion: %s, cachedDslEngineVer: %s", strW, strW2);
                atVarCode.Z(strW);
                atVarCode.B(strW2);
            }
        });
        String strD = atVarCode.d();
        String strE = atVarCode.e();
        fh.V(Code, "uiEngineInfo from propertiesCache, dslVersion: %s, cachedDslEngineVer: %s", strD, strE);
        if (TextUtils.isEmpty(strD) || TextUtils.isEmpty(strE)) {
            return null;
        }
        BaseAdReqParam baseAdReqParam = new BaseAdReqParam();
        baseAdReqParam.Code(strD);
        baseAdReqParam.V(strE);
        return baseAdReqParam;
    }

    private static String V(Context context, AdContentData adContentData) {
        String name;
        int iJ = adContentData.j();
        if (iJ == 0) {
            return null;
        }
        PromoteInfo promoteInfoZ = adContentData.z();
        if (iJ == 10) {
            if (promoteInfoZ != null && promoteInfoZ.getType() == 2 && !TextUtils.isEmpty(promoteInfoZ.getName())) {
                return context.getResources().getString(R.string.hiad_wechat_mini_spec, promoteInfoZ.getName());
            }
            String string = context.getResources().getString(R.string.hiad_wechat_mini_spec, "");
            if (string == null) {
                return null;
            }
            return string.trim();
        }
        if (iJ == 11) {
            return context.getResources().getString(R.string.hiad_share_wx);
        }
        if (iJ == 8) {
            return context.getResources().getString(R.string.hiad_appGallery);
        }
        if (promoteInfoZ != null) {
            name = promoteInfoZ.getName();
            if (promoteInfoZ.getType() == 1) {
                boolean zIsEmpty = TextUtils.isEmpty(name);
                Resources resources = context.getResources();
                if (!zIsEmpty) {
                    return resources.getString(R.string.hiad_fast_app_spec, name);
                }
                String string2 = resources.getString(R.string.hiad_fast_app_spec, "");
                if (string2 == null) {
                    return null;
                }
                return string2.trim();
            }
        } else {
            name = null;
        }
        if (!TextUtils.isEmpty(name)) {
            return name;
        }
        AppInfo appInfoY = adContentData.y();
        if (appInfoY == null) {
            return null;
        }
        return (TextUtils.isEmpty(appInfoY.L()) || !h.Code(context, appInfoY.Code())) ? name : appInfoY.L();
    }

    public static String Code(Context context, int i) {
        int i2;
        String strV = V(context, R.string.hiad_click_card_to_open);
        if (context == null) {
            return strV;
        }
        if (i == 7 || i == 8) {
            i2 = R.string.hiad_click_open_to;
        } else {
            if (i != 12) {
                return strV;
            }
            i2 = R.string.hiad_click_material_open;
        }
        return V(context, i2);
    }

    public static boolean V() {
        String strCode = com.huawei.hms.ads.h.Code();
        return !TextUtils.isEmpty(strCode) && 30461200 <= Integer.parseInt(strCode);
    }

    public static String Code(Context context, AdContentData adContentData, int i) {
        if (context == null || adContentData == null) {
            return null;
        }
        String strV = V(context, adContentData);
        if (TextUtils.isEmpty(strV)) {
            return null;
        }
        Resources resources = context.getResources();
        return i == 0 ? resources.getString(R.string.hiad_touch_jump_to, strV) : resources.getString(R.string.hiad_jump_to, strV);
    }

    public static String Code(AdContentData adContentData, Context context) {
        return (adContentData != null && adContentData.j() == 8) ? Code(context, adContentData.Z()) : "";
    }

    public static void Code(Context context, AdContentData adContentData) {
        if (adContentData == null) {
            return;
        }
        String strBg = adContentData.bg();
        if (bc.Code(strBg)) {
            return;
        }
        Map map = (Map) ad.V(strBg, Map.class, new Class[0]);
        if (al.Code(map)) {
            return;
        }
        Code(context, (Map<String, String>) map);
    }

    public static void Code(Context context, String str) {
        if (bc.Code(str)) {
            return;
        }
        Map map = (Map) ad.V(str, Map.class, new Class[0]);
        if (al.Code(map)) {
            return;
        }
        Code(context, (Map<String, String>) map);
    }

    private static void Code(Context context, Map<String, String> map) {
        int iCode = bc.Code(map.get(V), 0);
        if (ei.Code(context).Code() == 0 && iCode == 1) {
            ei.Code(context).Code(1);
            fh.Code(Code, "updateStyleFcFlag: %s", Integer.valueOf(ei.Code(context).Code()));
        }
    }

    public static boolean Code() {
        String strCode = com.huawei.hms.ads.h.Code();
        return !TextUtils.isEmpty(strCode) && 30482100 <= Integer.parseInt(strCode);
    }

    private static boolean Code(int i, String str) {
        com.huawei.hms.ads.uiengine.d dVarV = com.huawei.hms.ads.h.V();
        if (dVarV != null) {
            try {
                return dVarV.Code(str, i, (Bundle) null);
            } catch (Throwable th) {
                fh.V(Code, "check valid err: %s", th.getClass().getSimpleName());
            }
        }
        return false;
    }

    public static boolean Code(Context context, DefaultTemplate defaultTemplate, String str, int i) {
        String str2;
        if (context == null) {
            return false;
        }
        String strCode = com.huawei.hms.ads.h.Code();
        if (TextUtils.isEmpty(strCode) || I > Integer.parseInt(strCode)) {
            str2 = "uiengine not support";
        } else if (defaultTemplate == null || !defaultTemplate.I()) {
            str2 = "data is invalid";
        } else {
            if (Code(i, defaultTemplate.Code())) {
                if (defaultTemplate.V() == null) {
                    fh.V(Code, "isShowV2Tpt, no fcCtl");
                    return true;
                }
                int iIntValue = defaultTemplate.V().intValue();
                int I2 = ei.Code(context).I(str);
                fh.V(Code, "isShowV2Tpt, tptFcCtl = %s, showTimes = %s", Integer.valueOf(iIntValue), Integer.valueOf(I2));
                return iIntValue > I2;
            }
            str2 = "templateId is invalid";
        }
        fh.V(Code, str2);
        return false;
    }

    public static boolean Code(CtrlExt ctrlExt) {
        if (ctrlExt == null) {
            return false;
        }
        return "1".equals(ctrlExt.Code());
    }

    public static boolean Code(CtrlExt ctrlExt, Integer num) {
        return Code(ctrlExt) && Code(num);
    }

    public static boolean Code(Integer num) {
        if (num == null) {
            return false;
        }
        int iIntValue = num.intValue();
        if (iIntValue != 1 && iIntValue != 2 && iIntValue != 6) {
            switch (iIntValue) {
                case 12:
                case 13:
                case 14:
                case 15:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public static boolean Code(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(da.I, str);
        bundle.putString(da.Code, str2);
        ej ejVar = new ej(Code(cz.V, bundle, (IObjectWrapper) null));
        boolean zCode = ejVar.Code(da.Z);
        String strCode = ejVar.Code(da.B, "");
        fh.V(Code, "update style result:%s", Boolean.valueOf(zCode));
        if (!zCode) {
            fh.Code(Code, "error msg:%s", strCode);
        }
        return zCode;
    }
}
