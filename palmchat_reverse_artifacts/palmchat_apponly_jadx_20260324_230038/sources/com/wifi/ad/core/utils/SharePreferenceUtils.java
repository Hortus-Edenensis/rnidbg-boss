package com.wifi.ad.core.utils;

import android.content.Context;
import com.wifi.ad.core.p001const.WifiNestConst;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tJ(\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tJ\"\u0010\u000b\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tJ$\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\u000e"}, d2 = {"Lcom/wifi/ad/core/utils/SharePreferenceUtils;", "", "()V", "getLong", "", "keyName", "", "defalutvalue", "context", "Landroid/content/Context;", "getString", "setLong", "", "setString", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SharePreferenceUtils {
    public static final SharePreferenceUtils INSTANCE = new SharePreferenceUtils();

    private SharePreferenceUtils() {
    }

    public static /* synthetic */ long getLong$default(SharePreferenceUtils sharePreferenceUtils, String str, long j, Context context, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return sharePreferenceUtils.getLong(str, j, context);
    }

    public static /* synthetic */ String getString$default(SharePreferenceUtils sharePreferenceUtils, String str, String str2, Context context, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return sharePreferenceUtils.getString(str, str2, context);
    }

    public final long getLong(String keyName, long defalutvalue, Context context) {
        return context == null ? defalutvalue : context.getSharedPreferences(WifiNestConst.ThirdConst.SP_FILE_NAME, 0).getLong(keyName, defalutvalue);
    }

    public final String getString(String keyName, String defalutvalue, Context context) {
        return context == null ? defalutvalue : context.getSharedPreferences(WifiNestConst.ThirdConst.SP_FILE_NAME, 0).getString(keyName, defalutvalue);
    }

    public final void setLong(String keyName, long defalutvalue, Context context) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences(WifiNestConst.ThirdConst.SP_FILE_NAME, 0).edit().putLong(keyName, defalutvalue).commit();
    }

    public final void setString(String keyName, String defalutvalue, Context context) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences(WifiNestConst.ThirdConst.SP_FILE_NAME, 0).edit().putString(keyName, defalutvalue).commit();
    }
}
