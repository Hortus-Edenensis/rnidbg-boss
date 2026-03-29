package com.zenmen.palmchat.update;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import defpackage.ac1;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AppInfo implements Serializable {
    private static final long serialVersionUID = -4229095029328770749L;
    public String deviceName;
    public String imei;
    public String mobileNumber;
    public String netStatus;
    public String osVersion;
    public String packageName;
    public Version version;

    /* JADX INFO: compiled from: SearchBox */
    public class Version implements Serializable {
        private static final long serialVersionUID = -8278309986269004124L;
        public int code;
        public String name;

        public Version() {
        }
    }

    public AppInfo() {
    }

    public static String getInviteMessage() {
        return AppContext.getContext().getString(R.string.app_name);
    }

    private Version getVersion(Context context) {
        Version version = new Version();
        try {
            version.name = ac1.g;
            version.code = Integer.valueOf(ac1.f).intValue();
        } catch (Exception unused) {
            version.name = "unknown";
            version.code = -1;
        }
        return version;
    }

    public static int getVersionCode(Context context) {
        try {
            return Integer.valueOf(ac1.f).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String getVersionName(Context context) {
        return ac1.g;
    }

    public void fromLocal(Context context) {
        this.version = getVersion(context);
        this.imei = ac1.i;
        this.deviceName = Build.MODEL;
        this.osVersion = Build.VERSION.RELEASE;
        this.packageName = context.getPackageName();
    }

    public void fromPackageInfo(PackageInfo packageInfo) {
        Version version = new Version();
        this.version = version;
        version.code = packageInfo.versionCode;
        version.name = packageInfo.versionName;
        this.packageName = packageInfo.packageName;
    }

    public AppInfo(PackageInfo packageInfo) {
        fromPackageInfo(packageInfo);
    }

    public AppInfo(Context context) {
        fromLocal(context);
    }
}
