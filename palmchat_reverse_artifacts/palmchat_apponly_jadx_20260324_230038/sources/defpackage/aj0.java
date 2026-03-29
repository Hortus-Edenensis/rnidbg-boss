package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.zenmen.palmchat.deamon.comp.ConDirProvider;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class aj0 {
    public static void a(Context context, boolean z) {
        ComponentName componentName = new ComponentName(context, (Class<?>) ConDirProvider.class);
        PackageManager packageManager = context.getPackageManager();
        if (!z) {
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } else {
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
            ConDirProvider.a();
        }
    }
}
