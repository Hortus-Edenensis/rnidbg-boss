package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.embedapplog.jk;
import com.bytedance.embedapplog.ky;
import com.bytedance.embedapplog.wv;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class hm implements ky {
    private static final ob<Boolean> nr = new ob<Boolean>() { // from class: com.bytedance.embedapplog.hm.1
        @Override // com.bytedance.embedapplog.ob
        /* JADX INFO: renamed from: fx, reason: merged with bridge method [inline-methods] */
        public Boolean u(Object... objArr) {
            return Boolean.valueOf(pq.u((Context) objArr[0]));
        }
    };
    private String u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends ky.u {
        long u = 0;
    }

    public static boolean fx(Context context) {
        if (context == null) {
            return false;
        }
        return nr.nr(context).booleanValue();
    }

    @Nullable
    private Pair<String, Boolean> iz(Context context) {
        if (TextUtils.isEmpty(this.u)) {
            return null;
        }
        return (Pair) new jk(context, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage(this.u), new jk.nr<wv, Pair<String, Boolean>>() { // from class: com.bytedance.embedapplog.hm.2
            @Override // com.bytedance.embedapplog.jk.nr
            /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
            public wv u(IBinder iBinder) {
                return wv.u.u(iBinder);
            }

            @Override // com.bytedance.embedapplog.jk.nr
            public Pair<String, Boolean> u(wv wvVar) {
                if (wvVar == null) {
                    return null;
                }
                return new Pair<>(wvVar.u(), Boolean.valueOf(wvVar.nr()));
            }
        }).u();
    }

    private boolean pn(Context context) {
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.u = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.u = "com.huawei.hwid.tv";
            } else {
                this.u = "com.huawei.hms";
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    @Override // com.bytedance.embedapplog.ky
    @Nullable
    @WorkerThread
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public u nr(Context context) {
        u uVar = new u();
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                String string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
                if (!TextUtils.isEmpty(string)) {
                    uVar.nr = string;
                    uVar.fx = Boolean.parseBoolean(string2);
                    uVar.u = 202003021704L;
                    return uVar;
                }
            } catch (Throwable th) {
                ti.u(th);
            }
        }
        Pair<String, Boolean> pairIz = iz(context);
        if (pairIz != null) {
            uVar.nr = (String) pairIz.first;
            uVar.fx = ((Boolean) pairIz.second).booleanValue();
            uVar.u = u(context, this.u);
        }
        return uVar;
    }

    @Override // com.bytedance.embedapplog.ky
    public boolean u(Context context) {
        return pn(context);
    }

    private static int u(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException e) {
            ti.u(e);
            return 0;
        }
    }
}
