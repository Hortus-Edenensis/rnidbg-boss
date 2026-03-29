package cn.fly.verify;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import cn.fly.verify.ce;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ch extends ce {
    public ch(Context context) {
        super(context);
    }

    private String a(String str, String str2) {
        String str3;
        Bundle bundleB = b(str, str2);
        if (a(bundleB)) {
            str3 = "002Cchcb";
        } else {
            if (bundleB == null) {
                return null;
            }
            str3 = "0071ceEeHegeg!c6dd4e";
        }
        return bundleB.getString(ec.b(str3));
    }

    private Bundle b(String str, String str2) {
        Bundle bundleCall = null;
        try {
            Uri uri = Uri.parse(ec.b("036bXdc+dhedhjkkbd*ec+d<cfedchIcRecchcbGedh+chRh(cj?kGchcb7edh0chXh)cj"));
            int i = Build.VERSION.SDK_INT;
            ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = this.f2142a.getContentResolver().acquireUnstableContentProviderClient(uri);
            bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call(str, str2, null);
            contentProviderClientAcquireUnstableContentProviderClient.release();
            return bundleCall;
        } catch (Throwable th) {
            en.a().a(th);
            return bundleCall;
        }
    }

    private boolean f() {
        Bundle bundleB = b(ec.b("009OchegdicfSiiDdcci[h"), null);
        if (a(bundleB)) {
            return bundleB.getBoolean(ec.b("009SchegegcfUii^dcciFh"), true);
        }
        return false;
    }

    private boolean a(Bundle bundle) {
        return bundle != null && bundle.getInt(ec.b("004bKdccbRe"), -1) == 0;
    }

    @Override // cn.fly.verify.ce
    public ce.b b() {
        ce.b bVar = new ce.b();
        bVar.f2144a = f();
        bVar.b = a(ec.b("007Zdd]eh.ffdkdhej"), (String) null);
        return bVar;
    }
}
