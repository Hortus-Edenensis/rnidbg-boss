package com.zenmen.palmchat.miniwidget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.RemoteViews;
import com.google.gson.reflect.TypeToken;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.d;
import com.zenmen.palmchat.miniwidget.RecommendData;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.az2;
import defpackage.bo0;
import defpackage.go2;
import defpackage.gr2;
import defpackage.hs;
import defpackage.jr2;
import defpackage.nl0;
import defpackage.sw4;
import defpackage.zw4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class RecommendWidgetProvider extends hs {
    public static RecommendData.RecommendItem b;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2<LXBaseNetBean<RecommendData>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f14763a;

        public a(Context context) {
            this.f14763a = context;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            LocationEx locationExI = d.g().i(86400000L);
            if (locationExI != null) {
                map.put("longitude", Double.valueOf(locationExI.getLongitude()));
                map.put("latitude", Double.valueOf(locationExI.getLatitude()));
            }
            ContactInfoItem contactInfoItemS = bo0.r().s();
            map.put("sex", Integer.valueOf(contactInfoItemS != null ? contactInfoItemS.getGender() : -1));
            sw4 sw4VarB = sw4.b(1, nl0.z + "/userem.desktop.show.v1", map);
            sw4VarB.g = true;
            return sw4VarB;
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<RecommendData> lXBaseNetBean, Exception exc) {
            RecommendData recommendData;
            LogUtil.i("RecommendWidgetProvider", "updateImp request end" + az2.c(lXBaseNetBean));
            if (!z || lXBaseNetBean == null || (recommendData = lXBaseNetBean.data) == null || recommendData.list == null) {
                return;
            }
            RecommendData.RecommendItem recommendItemRemove = recommendData.list.remove(0);
            RecommendWidgetProvider.this.l(lXBaseNetBean.data.list);
            RecommendWidgetProvider.this.n(this.f14763a, recommendItemRemove);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends TypeToken<ArrayList<RecommendData.RecommendItem>> {
        public b() {
        }
    }

    public static Bitmap k(Bitmap bitmap, int i) {
        int i2;
        if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return bitmap;
        }
        float width = bitmap.getWidth() / bitmap.getHeight();
        if (width >= 1.0f) {
            i2 = (int) (i / width);
        } else {
            int i3 = (int) (i * width);
            i2 = i;
            i = i3;
        }
        LogUtil.i("RecommendWidgetProvider", "scaleBitmapToSize start" + bitmap.getWidth() + bitmap.getHeight());
        if (i >= bitmap.getWidth() || i2 >= bitmap.getHeight()) {
            return bitmap;
        }
        try {
            bitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
            LogUtil.i("RecommendWidgetProvider", "scaleBitmapToSize size=" + i + "*" + i2);
            return bitmap;
        } catch (OutOfMemoryError e) {
            LogUtil.e("RecommendWidgetProvider", e);
            return bitmap;
        }
    }

    @Override // defpackage.hs
    public int b() {
        return 1;
    }

    @Override // defpackage.hs
    public void e(Context context) {
        super.e(context);
        LogUtil.i("RecommendWidgetProvider", "updateClickIntent" + az2.c(b));
        m(context);
    }

    @Override // defpackage.hs
    public void f(Context context) {
        if (AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, (Class<?>) RecommendWidgetProvider.class)).length > 0) {
            m(context);
        }
    }

    public final List<RecommendData.RecommendItem> j() {
        String strN = SPUtil.f14322a.n(SPUtil.SCENE.APP_WAKE_UP, "key_widget_cache_item_recommend", "");
        if (TextUtils.isEmpty(strN)) {
            return null;
        }
        return (List) az2.b(strN, new b().getType());
    }

    public final void l(List<RecommendData.RecommendItem> list) {
        SPUtil.f14322a.t(SPUtil.SCENE.APP_WAKE_UP, "key_widget_cache_item_recommend", az2.c(list));
    }

    public final void m(Context context) {
        LogUtil.i("RecommendWidgetProvider", "updateImp start");
        List<RecommendData.RecommendItem> listJ = j();
        if (listJ != null && listJ.size() > 0) {
            RecommendData.RecommendItem recommendItemRemove = listJ.remove(0);
            l(listJ);
            n(context, recommendItemRemove);
        } else {
            LogUtil.i("RecommendWidgetProvider", "updateImp request start");
            if (AccountUtils.t(AppContext.getContext())) {
                zw4.e(new a(context));
            } else {
                n(context, null);
            }
        }
    }

    public final void n(Context context, RecommendData.RecommendItem recommendItem) {
        LogUtil.i("RecommendWidgetProvider", "updateUI" + az2.c(recommendItem));
        if (recommendItem != null && recommendItem.icon != null && recommendItem.turnUrl != null) {
            b = recommendItem;
            gr2.j().l(recommendItem.icon, new c(recommendItem, context));
            return;
        }
        LogUtil.i("RecommendWidgetProvider", "updateUI default");
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        ComponentName componentName = new ComponentName(context, (Class<?>) RecommendWidgetProvider.class);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.recommend_widget_remote_view);
        remoteViews.setOnClickPendingIntent(R.id.icon, a(context, "zenxin://activity?page=a0510", b()));
        remoteViews.setImageViewResource(R.id.icon, R.drawable.widget_provider_default_rec);
        remoteViews.setTextViewText(R.id.title, "今日推荐");
        remoteViews.setTextViewText(R.id.name, "阿香");
        remoteViews.setTextViewText(R.id.des, "1.3km");
        appWidgetManager.updateAppWidget(componentName, remoteViews);
    }

    @Override // defpackage.hs, android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        f(context);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements jr2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecommendData.RecommendItem f14765a;
        public final /* synthetic */ Context b;

        public c(RecommendData.RecommendItem recommendItem, Context context) {
            this.f14765a = recommendItem;
            this.b = context;
        }

        @Override // defpackage.jr2
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            LogUtil.i("RecommendWidgetProvider", "updateUI enter" + this.f14765a.turnUrl);
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.b);
            ComponentName componentName = new ComponentName(this.b, (Class<?>) RecommendWidgetProvider.class);
            RemoteViews remoteViews = new RemoteViews(this.b.getPackageName(), R.layout.recommend_widget_remote_view);
            RecommendWidgetProvider recommendWidgetProvider = RecommendWidgetProvider.this;
            remoteViews.setOnClickPendingIntent(R.id.icon, recommendWidgetProvider.a(this.b, this.f14765a.turnUrl, recommendWidgetProvider.b()));
            remoteViews.setImageViewBitmap(R.id.icon, RecommendWidgetProvider.k(bitmap, 400));
            remoteViews.setTextViewText(R.id.title, this.f14765a.title);
            remoteViews.setTextViewText(R.id.name, this.f14765a.nickName);
            remoteViews.setTextViewText(R.id.des, this.f14765a.desc);
            appWidgetManager.updateAppWidget(componentName, remoteViews);
        }

        @Override // defpackage.jr2
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingStarted(String str, View view) {
        }

        @Override // defpackage.jr2
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }
    }
}
