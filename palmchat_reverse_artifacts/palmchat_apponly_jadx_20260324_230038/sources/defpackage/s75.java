package defpackage;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class s75 {
    public static void a(Activity activity, int i, int i2) {
        try {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", activity.getString(i2));
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(activity, i));
            Intent component = new Intent("android.intent.action.MAIN").setComponent(new ComponentName(activity.getPackageName(), activity.getClass().getName()));
            component.addCategory("android.intent.category.LAUNCHER");
            intent.putExtra("android.intent.extra.shortcut.INTENT", component);
            activity.sendBroadcast(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
