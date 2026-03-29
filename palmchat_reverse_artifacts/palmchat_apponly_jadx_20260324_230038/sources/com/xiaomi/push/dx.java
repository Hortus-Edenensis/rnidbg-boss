package com.xiaomi.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public abstract class dx extends dv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11528a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected Bitmap f345a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private RemoteViews f346a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected CharSequence f347a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f348a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ArrayList<Notification.Action> f349a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected Map<String, String> f350a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f351a;
    private int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    protected CharSequence f352b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private boolean f353b;

    public dx(Context context, String str) {
        this(context, 0, str);
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    private boolean m388c() {
        Map<String, String> map = this.f350a;
        return map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"));
    }

    private void d() {
        super.setContentTitle(this.f347a);
        super.setContentText(this.f352b);
    }

    private boolean e() {
        return m389d() && f();
    }

    private boolean f() {
        List<StatusBarNotification> listM711b = com.xiaomi.push.service.af.a(a(), this.f348a).m711b();
        if (listM711b != null && !listM711b.isEmpty()) {
            for (StatusBarNotification statusBarNotification : listM711b) {
                if (statusBarNotification.getId() == this.f11528a) {
                    if (statusBarNotification.getNotification() == null) {
                        return false;
                    }
                    return !r0.extras.getBoolean("mipush.customCopyLayout", true);
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public abstract String mo391a();

    public void a(int i, Notification.Action action) {
    }

    /* JADX INFO: renamed from: a */
    public abstract boolean mo385a();

    @Override // android.app.Notification.Builder
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public dx setContentText(CharSequence charSequence) {
        this.f352b = charSequence;
        return this;
    }

    public abstract String b();

    public dx(Context context, int i, String str) {
        super(context);
        this.f349a = new ArrayList<>();
        this.b = 0;
        this.f348a = str;
        this.f11528a = i;
        m387c();
    }

    @Override // android.app.Notification.Builder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public dx setContentTitle(CharSequence charSequence) {
        this.f347a = charSequence;
        return this;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public final void m393b() {
        super.setContentTitle(this.f347a);
        super.setContentText(this.f352b);
        Bitmap bitmap = this.f345a;
        if (bitmap != null) {
            super.setLargeIcon(bitmap);
        }
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    private boolean m389d() {
        return (TextUtils.isEmpty(b()) || TextUtils.isEmpty(this.f348a)) ? false : true;
    }

    @Override // android.app.Notification.Builder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public dx setLargeIcon(Bitmap bitmap) {
        this.f345a = bitmap;
        return this;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    private void m387c() {
        int iA = a(a().getResources(), c(), "layout", a().getPackageName());
        if (iA != 0) {
            this.f346a = new RemoteViews(a().getPackageName(), iA);
            this.f351a = mo385a();
        } else {
            com.xiaomi.channel.commonutils.logger.b.m74a("create RemoteViews failed, no such layout resource was found");
        }
    }

    @Override // com.xiaomi.push.dv
    public dv a(Map<String, String> map) {
        this.f350a = map;
        return this;
    }

    @Override // android.app.Notification.Builder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public dx addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        addAction(new Notification.Action(i, charSequence, pendingIntent));
        return this;
    }

    @Override // android.app.Notification.Builder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public dx addAction(Notification.Action action) {
        if (action != null) {
            this.f349a.add(action);
        }
        int i = this.b;
        this.b = i + 1;
        a(i, action);
        return this;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public final boolean m394b() {
        return this.f351a;
    }

    @Override // com.xiaomi.push.dv
    /* JADX INFO: renamed from: a */
    public void mo384a() {
        super.mo384a();
        Bundle bundle = new Bundle();
        if (m389d()) {
            bundle.putBoolean("mipush.customCopyLayout", this.f353b);
        } else {
            bundle.putBoolean("mipush.customCopyLayout", false);
        }
        bundle.putBoolean("miui.customHeight", false);
        bundle.putBoolean("mipush.customNotification", true);
        bundle.putInt("mipush.customLargeIconId", a("large_icon"));
        if (this.f349a.size() > 0) {
            Notification.Action[] actionArr = new Notification.Action[this.f349a.size()];
            this.f349a.toArray(actionArr);
            bundle.putParcelableArray("mipush.customActions", actionArr);
        }
        if (!m388c() && com.xiaomi.push.service.ag.m713a(a().getContentResolver())) {
            bundle.putCharSequence("mipush.customTitle", this.f347a);
            bundle.putCharSequence("mipush.customContent", this.f352b);
        } else {
            d();
        }
        addExtras(bundle);
    }

    private String c() {
        boolean zE = e();
        this.f353b = zE;
        return zE ? b() : mo391a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final RemoteViews m390a() {
        return this.f346a;
    }

    public void a(int i) {
        Bitmap bitmapA = a();
        if (bitmapA != null) {
            m390a().setImageViewBitmap(i, bitmapA);
            return;
        }
        int iB = g.b(a(), this.f348a);
        if (iB != 0) {
            m390a().setImageViewResource(i, iB);
        }
    }

    private Bitmap a() {
        return com.xiaomi.push.service.x.a(g.m474a(a(), this.f348a));
    }

    public int a(float f) {
        return (int) ((f * a().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public Bitmap a(Bitmap bitmap, float f) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawRoundRect(new RectF(rect), f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final boolean m392a(int i) {
        return ((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d) < 192.0d;
    }
}
