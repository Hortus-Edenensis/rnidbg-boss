package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.umeng.analytics.pro.bt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class mk extends w {
    private final mh iz;
    private final Context pn;

    public mk(Context context, mh mhVar) {
        super(false, false);
        this.pn = context;
        this.iz = mhVar;
    }

    @Override // com.bytedance.embedapplog.w
    public boolean u(JSONObject jSONObject) throws JSONException {
        int i;
        ApplicationInfo applicationInfo;
        int i2;
        String packageName = this.pn.getPackageName();
        PackageInfo packageInfo = null;
        if (TextUtils.isEmpty(this.iz.wi())) {
            jSONObject.put("package", packageName);
        } else {
            if (ti.nr) {
                ti.u("has zijie pkg", null);
            }
            jSONObject.put("package", this.iz.wi());
            jSONObject.put("real_package_name", packageName);
        }
        try {
            packageInfo = this.pn.getPackageManager().getPackageInfo(packageName, 0);
        } catch (Throwable unused) {
        }
        if (packageInfo != null) {
            try {
                i = packageInfo.versionCode;
            } catch (Throwable th) {
                ti.nr(th);
                return false;
            }
        } else {
            i = 0;
        }
        if (TextUtils.isEmpty(this.iz.wq())) {
            jSONObject.put("app_version", packageInfo != null ? packageInfo.versionName : "");
        } else {
            jSONObject.put("app_version", this.iz.wq());
        }
        if (TextUtils.isEmpty(this.iz.y())) {
            jSONObject.put("app_version_minor", "");
        } else {
            jSONObject.put("app_version_minor", this.iz.y());
        }
        if (this.iz.rh() != 0) {
            jSONObject.put("version_code", this.iz.rh());
        } else {
            jSONObject.put("version_code", i);
        }
        if (this.iz.ja() != 0) {
            jSONObject.put("update_version_code", this.iz.ja());
        } else {
            jSONObject.put("update_version_code", i);
        }
        if (this.iz.bf() != 0) {
            jSONObject.put("manifest_version_code", this.iz.bf());
        } else {
            jSONObject.put("manifest_version_code", i);
        }
        if (!TextUtils.isEmpty(this.iz.h())) {
            jSONObject.put("app_name", this.iz.h());
        }
        if (!TextUtils.isEmpty(this.iz.pb())) {
            jSONObject.put("tweaked_channel", this.iz.pb());
        }
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (i2 = applicationInfo.labelRes) <= 0) {
            return true;
        }
        jSONObject.put(bt.s, this.pn.getString(i2));
        return true;
    }
}
