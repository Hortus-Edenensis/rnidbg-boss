package com.lantern.auth.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.lantern.auth.core.BLLog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class BLPackageManager {
    private Callback mCallback;
    private Context mContext;
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.lantern.auth.android.BLPackageManager.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z;
            String action = intent.getAction();
            BLLog.i("action:" + action);
            Uri data = intent.getData();
            if (data == null) {
                return;
            }
            String schemeSpecificPart = data.getSchemeSpecificPart();
            BLLog.i("packageName:" + schemeSpecificPart);
            if (schemeSpecificPart == null) {
                return;
            }
            Bundle extras = intent.getExtras();
            if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                z = extras != null ? extras.getBoolean("android.intent.extra.REPLACING", false) : false;
                BLLog.i("replacing:" + z);
                if (z || BLPackageManager.this.mCallback == null) {
                    return;
                }
                BLPackageManager.this.mCallback.onPackageAdded(schemeSpecificPart);
                return;
            }
            if (action.equals("android.intent.action.PACKAGE_REMOVED")) {
                z = extras != null ? extras.getBoolean("android.intent.extra.REPLACING", false) : false;
                BLLog.i("replacing:" + z);
                if (z || BLPackageManager.this.mCallback == null) {
                    return;
                }
                BLPackageManager.this.mCallback.onPackageRemoved(schemeSpecificPart);
                return;
            }
            if (action.equals("android.intent.action.PACKAGE_REPLACED")) {
                if (BLPackageManager.this.mCallback != null) {
                    BLPackageManager.this.mCallback.onPackageReplaced(schemeSpecificPart);
                }
            } else {
                if (!action.equals("android.intent.action.PACKAGE_CHANGED") || BLPackageManager.this.mCallback == null) {
                    return;
                }
                BLPackageManager.this.mCallback.onPackageChanged(schemeSpecificPart);
            }
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public interface Callback {
        void onPackageAdded(String str);

        void onPackageChanged(String str);

        void onPackageRemoved(String str);

        void onPackageReplaced(String str);
    }

    public BLPackageManager(Context context, Callback callback) {
        this.mCallback = callback;
        this.mContext = context;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addDataScheme("package");
        this.mContext.registerReceiver(this.mReceiver, intentFilter);
    }

    public static boolean isAppExsit(Context context, String str) {
        if (str != null && str.length() != 0) {
            try {
                context.getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public static boolean isSystemApp(ApplicationInfo applicationInfo) {
        return applicationInfo != null && (applicationInfo.flags & 1) > 0;
    }

    public void onDestory() {
        this.mContext.unregisterReceiver(this.mReceiver);
    }

    public static boolean isSystemApp(Context context, String str) {
        if (str != null && str.length() != 0) {
            try {
                return isSystemApp(context.getPackageManager().getApplicationInfo(str, 8192));
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }
}
