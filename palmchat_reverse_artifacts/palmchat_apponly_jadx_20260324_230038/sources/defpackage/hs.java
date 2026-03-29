package defpackage;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.login.InitActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class hs extends AppWidgetProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f18038a = 100;

    public static void d(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("type", "self_update");
        if (str != null) {
            intent.putExtra("_action", str);
            intent.putExtra("_type", Integer.valueOf(str2).intValue());
        }
        intent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
        AppContext.getContext().sendBroadcast(intent);
    }

    public PendingIntent a(Context context, String str, int i) {
        Intent intent = new Intent(context, (Class<?>) InitActivity.class);
        intent.putExtra("key_push_param", ts2.g(str, String.valueOf(i)));
        intent.putExtra("key_from_push", true);
        intent.addFlags(268435456);
        intent.setAction("ActionIdentifier" + System.currentTimeMillis());
        int i2 = f18038a;
        f18038a = i2 + 1;
        return PendingIntent.getActivity(context, i2, intent, 134217728);
    }

    public abstract int b();

    public final void c() {
        vt0.d().n("from_widget");
    }

    public void e(Context context) {
        LogUtil.i("BaseWidgetProvider", "updateClickIntent");
    }

    public void f(Context context) {
        LogUtil.i("BaseWidgetProvider", "updateWidget");
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int i, Bundle bundle) {
        super.onAppWidgetOptionsChanged(context, appWidgetManager, i, bundle);
        LogUtil.i("BaseWidgetProvider", "onAppWidgetOptionsChanged " + getClass());
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] iArr) {
        super.onDeleted(context, iArr);
        LogUtil.i("BaseWidgetProvider", "onDeleted " + getClass());
        HashMap map = new HashMap();
        map.put("type", String.valueOf(b()));
        zn6.h("widget_window", "cancel", map);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(Context context) {
        super.onDisabled(context);
        LogUtil.i("BaseWidgetProvider", "onDisable " + getClass());
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        super.onEnabled(context);
        LogUtil.i("BaseWidgetProvider", "onEnabled " + getClass());
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_widget_has_show", Boolean.TRUE);
        HashMap map = new HashMap();
        map.put("type", String.valueOf(b()));
        zn6.h("widget_window", "add", map);
        c();
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        LogUtil.i("BaseWidgetProvider", "onReceive" + intent + getClass());
        if ("android.appwidget.action.APPWIDGET_UPDATE".equals(intent.getAction()) && "self_update".equals(intent.getStringExtra("type"))) {
            if ("update_click".equals(intent.getStringExtra("_action"))) {
                if (b() == intent.getIntExtra("_type", 0)) {
                    e(context);
                }
            } else {
                f(context);
            }
        }
        c();
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onRestored(Context context, int[] iArr, int[] iArr2) {
        super.onRestored(context, iArr, iArr2);
        LogUtil.i("BaseWidgetProvider", "onRestored " + getClass());
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        LogUtil.i("BaseWidgetProvider", "onUpdate");
        HashMap map = new HashMap();
        map.put("type", String.valueOf(b()));
        zn6.h("widget_window", "update", map);
        c();
    }
}
