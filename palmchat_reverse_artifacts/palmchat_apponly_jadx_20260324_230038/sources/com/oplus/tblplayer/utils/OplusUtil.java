package com.oplus.tblplayer.utils;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class OplusUtil {
    private static final String OPLUS_VPP_FILTER_FEATURE_OSIE = "oplus.software.video.osie_support";
    private static final String OPLUS_VPP_FILTER_FEATURE_SR = "oplus.software.video.sr_support";

    private static boolean hasSystemFeature(Context context, String str) {
        return context.getPackageManager().hasSystemFeature(str);
    }

    private static boolean invokeOplusFeatureConfigManager(String str) {
        Object objInvokeNoException;
        try {
            Class<?> cls = Class.forName("com.oplus.content.OplusFeatureConfigManager");
            Object objInvokeNoException2 = ReflectUtil.invokeNoException(cls, (Object) null, "getInstance", (Class<?>[]) null, new Object[0]);
            if (objInvokeNoException2 != null && cls.isInstance(objInvokeNoException2) && (objInvokeNoException = ReflectUtil.invokeNoException(cls, cls.cast(objInvokeNoException2), "hasFeature", (Class<?>[]) new Class[]{String.class}, str)) != null) {
                return ((Boolean) objInvokeNoException).booleanValue();
            }
        } catch (ClassNotFoundException e) {
            LogUtil.e("TBLPlayer", "OplusFeatureConfigManager class not found." + e.getMessage());
        } catch (Exception e2) {
            throw new RuntimeException("Error invoke method.", e2);
        }
        return false;
    }

    public static boolean isSupportedConfigureVPPFilterMode(Context context) {
        return hasSystemFeature(context, OPLUS_VPP_FILTER_FEATURE_SR) && hasSystemFeature(context, OPLUS_VPP_FILTER_FEATURE_OSIE);
    }
}
