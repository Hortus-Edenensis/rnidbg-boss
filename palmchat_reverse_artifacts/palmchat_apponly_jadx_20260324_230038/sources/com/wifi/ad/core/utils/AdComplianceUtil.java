package com.wifi.ad.core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.wifi.ad.core.dialog.ComplianceDialog;
import com.wifi.adsdk.WifiAdWebViewActivity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AdComplianceUtil {
    public static void showComplianceDialog(Context context, Bitmap bitmap, String str, String str2, String str3, String str4, String str5, String str6, ComplianceDialog.DialogClickListener dialogClickListener) {
        new ComplianceDialog(context).adLogoInfo(bitmap, str).adName(str2).adVersion(str3).adDeveloperName(str4).adPermissionsUrl(str5).adPrivacyUrl(str6).setDialogListener(dialogClickListener).show();
    }

    public static boolean startCommonWebView(String str, String str2, Context context) {
        WifiLog.d("startCommonWebView url = " + str);
        try {
            Intent intent = new Intent(context, (Class<?>) WifiAdWebViewActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("url", str);
            intent.putExtra("title", str2);
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
