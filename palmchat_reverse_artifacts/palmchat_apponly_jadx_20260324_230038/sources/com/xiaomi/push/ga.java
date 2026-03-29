package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ga implements XMPushService.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f11594a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f492a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f493a;
    private boolean b;

    public ga(Context context) {
        this.f493a = context;
    }

    @Override // com.xiaomi.push.service.XMPushService.n
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo482a() {
        a(this.f493a);
        if (this.b && a()) {
            com.xiaomi.channel.commonutils.logger.b.m74a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            ge geVarA = gd.a(this.f493a).a();
            if (a(geVarA)) {
                f11594a = true;
                gb.a(this.f493a, geVarA);
            } else {
                com.xiaomi.channel.commonutils.logger.b.m74a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
            }
        }
    }

    private void a(Context context) {
        this.b = com.xiaomi.push.service.ah.a(context).a(gk.TinyDataUploadSwitch.a(), true);
        int iA = com.xiaomi.push.service.ah.a(context).a(gk.TinyDataUploadFrequency.a(), com.cdo.oaps.ad.p.j);
        this.f492a = iA;
        this.f492a = Math.max(60, iA);
    }

    private boolean a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f493a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f492a);
    }

    private boolean a(ge geVar) {
        if (!au.m175a(this.f493a) || geVar == null || TextUtils.isEmpty(a(this.f493a.getPackageName())) || !new File(this.f493a.getFilesDir(), "tiny_data.data").exists() || f11594a) {
            return false;
        }
        return !com.xiaomi.push.service.ah.a(this.f493a).a(gk.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || i.m641a(this.f493a) || i.m644b(this.f493a);
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f493a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    public static void a(boolean z) {
        f11594a = z;
    }
}
