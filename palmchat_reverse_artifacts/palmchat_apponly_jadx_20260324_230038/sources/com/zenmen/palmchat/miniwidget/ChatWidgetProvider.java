package com.zenmen.palmchat.miniwidget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;
import com.zenmen.palmchat.R;
import defpackage.hs;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ChatWidgetProvider extends hs {
    @Override // defpackage.hs
    public int b() {
        return 2;
    }

    @Override // defpackage.hs
    public void e(Context context) {
        super.e(context);
        g(context);
    }

    @Override // defpackage.hs
    public void f(Context context) {
        super.f(context);
        g(context);
    }

    public final void g(Context context) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        ComponentName componentName = new ComponentName(context, (Class<?>) ChatWidgetProvider.class);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.chat_widget_remote_view);
        remoteViews.setOnClickPendingIntent(R.id.root, a(context, "zenxin://activity?page=a0510&tab=tab_msg", b()));
        remoteViews.setImageViewResource(R.id.icon, R.drawable.widget_provider_preview_chat);
        appWidgetManager.updateAppWidget(componentName, remoteViews);
    }

    @Override // defpackage.hs, android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        f(context);
    }
}
