package com.ss.android.socialbase.appdownloader.view;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.igexin.assist.util.AssistUtils;
import com.ss.android.socialbase.appdownloader.pn.b;
import com.ss.android.socialbase.downloader.constants.pn;
import com.ss.android.socialbase.downloader.downloader.fx;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u extends Fragment {
    public static Intent b() {
        return new Intent("android.settings.APPLICATION_SETTINGS");
    }

    private Intent iz() {
        Context contextPn = pn();
        if (contextPn == null) {
            return null;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        String packageName = contextPn.getPackageName();
        intent.putExtra("package", packageName);
        intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        intent.putExtra(WfConstant.EXTRA_KEY_APP_PKG, packageName);
        int i = contextPn.getApplicationInfo().uid;
        intent.putExtra(DeviceInfoUtil.UID_TAG, i);
        intent.putExtra("app_uid", i);
        return intent;
    }

    private Context pn() {
        Context contextOa = fx.oa();
        return (contextOa != null || getActivity() == null || getActivity().isFinishing()) ? contextOa : getActivity().getApplicationContext();
    }

    public Intent fx() {
        Context contextPn = pn();
        if (contextPn == null) {
            return null;
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + contextPn.getPackageName()));
    }

    public Intent nr() {
        Context contextPn = pn();
        if (contextPn == null) {
            return null;
        }
        String packageName = contextPn.getPackageName();
        String str = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.contains(pn.fx)) {
                Intent intent = new Intent();
                intent.putExtra("packageName", packageName);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                return intent;
            }
            if (lowerCase.contains("vivo")) {
                Intent intent2 = new Intent();
                intent2.putExtra("packagename", packageName);
                if (Build.VERSION.SDK_INT >= 25) {
                    intent2.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
                } else {
                    intent2.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
                }
                return intent2;
            }
            if (lowerCase.contains(AssistUtils.BRAND_MZ) && Build.VERSION.SDK_INT < 25) {
                Intent intent3 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                intent3.putExtra("packageName", packageName);
                intent3.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
                return intent3;
            }
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + contextPn.getPackageName()));
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (b.u()) {
            b.u(true);
        } else {
            b.u(false);
        }
    }

    public void u() {
        try {
            try {
                try {
                    startActivityForResult(iz(), 1000);
                } catch (Throwable unused) {
                    startActivityForResult(fx(), 1000);
                }
            } catch (Throwable unused2) {
                startActivityForResult(b(), 1000);
            }
        } catch (Throwable unused3) {
            startActivityForResult(nr(), 1000);
        }
    }
}
