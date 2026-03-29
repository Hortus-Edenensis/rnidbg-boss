package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ia7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k87 f18138a;

    public ia7(k87 k87Var) {
        this.f18138a = k87Var;
    }

    public final void a(Context context) {
        HashMap map = new HashMap();
        map.put(ExifInterface.TAG_MODEL, Build.PRODUCT);
        map.put("BrandOS_version", cc7.a());
        map.put("SDK_version", Build.VERSION.RELEASE);
        map.put("ROM_version", Build.DISPLAY);
        map.put("RAMSize", String.valueOf(ja7.a().get("MemTotal:")));
        map.put("InternalFreeSpace", String.valueOf(g47.a(Environment.getDataDirectory()) / 1024));
        map.put("App_version", o17.f(context));
        map.put("App_versioncode", String.valueOf(o17.h(context)));
        if (this.f18138a != null) {
            this.f18138a.b(new m17("BASE_INFO", "record_base_info", (byte) 4, null, map));
        }
    }
}
