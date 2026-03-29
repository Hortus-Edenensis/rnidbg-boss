package com.xiaomi.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.cdo.oaps.ad.OapsKey;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class dw extends dx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11527a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private PendingIntent f342a;
    private int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Bitmap f343b;
    private int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private CharSequence f344c;

    public dw(Context context, int i, String str) {
        super(context, i, str);
        this.f11527a = 16777216;
        this.b = 16777216;
        this.c = 16777216;
    }

    @Override // com.xiaomi.push.dx
    /* JADX INFO: renamed from: a */
    public String mo391a() {
        return "notification_colorful";
    }

    @Override // com.xiaomi.push.dx
    public String b() {
        return "notification_colorful_copy";
    }

    public dw c(String str) {
        if (m394b() && !TextUtils.isEmpty(str)) {
            try {
                this.c = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m74a("parse colorful notification image text color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dx
    /* JADX INFO: renamed from: a */
    public boolean mo385a() {
        if (!j.m650a()) {
            return false;
        }
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        return (a(resources, "icon", "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || a(resources, "content", "id", packageName) == 0) ? false : true;
    }

    public dw b(String str) {
        if (m394b() && !TextUtils.isEmpty(str)) {
            try {
                this.f11527a = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m74a("parse colorful notification bg color error");
            }
        }
        return this;
    }

    public dw a(CharSequence charSequence, PendingIntent pendingIntent) {
        if (m394b()) {
            super.addAction(0, charSequence, pendingIntent);
            this.f344c = charSequence;
            this.f342a = pendingIntent;
        }
        return this;
    }

    @Override // com.xiaomi.push.dv
    /* JADX INFO: renamed from: a */
    public dw mo386a(String str) {
        if (m394b() && !TextUtils.isEmpty(str)) {
            try {
                this.b = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m74a("parse colorful notification button bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dx
    /* JADX INFO: renamed from: a */
    public dw setLargeIcon(Bitmap bitmap) {
        if (m394b() && bitmap != null) {
            if (bitmap.getWidth() == 984 && bitmap.getHeight() >= 177 && bitmap.getHeight() <= 207) {
                this.f343b = bitmap;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m74a("colorful notification bg image resolution error, must [984*177, 984*207]");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dx, com.xiaomi.push.dv
    /* JADX INFO: renamed from: a */
    public void mo384a() {
        if (m394b()) {
            super.mo384a();
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            int iA = a(resources, "icon", "id", packageName);
            if (((dx) this).f345a == null) {
                a(iA);
            } else {
                m390a().setImageViewBitmap(iA, ((dx) this).f345a);
            }
            int iA2 = a(resources, "title", "id", packageName);
            int iA3 = a(resources, "content", "id", packageName);
            m390a().setTextViewText(iA2, ((dx) this).f347a);
            m390a().setTextViewText(iA3, ((dx) this).f352b);
            if (!TextUtils.isEmpty(this.f344c)) {
                int iA4 = a(resources, "buttonContainer", "id", packageName);
                int iA5 = a(resources, "button", "id", packageName);
                int iA6 = a(resources, "buttonBg", "id", packageName);
                m390a().setViewVisibility(iA4, 0);
                m390a().setTextViewText(iA5, this.f344c);
                m390a().setOnClickPendingIntent(iA4, this.f342a);
                if (this.b != 16777216) {
                    int iA7 = a(70.0f);
                    int iA8 = a(29.0f);
                    m390a().setImageViewBitmap(iA6, com.xiaomi.push.service.x.a(a(this.b, iA7, iA8, iA8 / 2.0f)));
                    m390a().setTextColor(iA5, m392a(this.b) ? -1 : -16777216);
                }
            }
            int iA9 = a(resources, OapsKey.KEY_BG, "id", packageName);
            int iA10 = a(resources, "container", "id", packageName);
            if (this.f11527a != 16777216) {
                if (j.a(a()) >= 10) {
                    m390a().setImageViewBitmap(iA9, com.xiaomi.push.service.x.a(a(this.f11527a, 984, 192, 30.0f)));
                } else {
                    m390a().setImageViewBitmap(iA9, com.xiaomi.push.service.x.a(a(this.f11527a, 984, 192, 0.0f)));
                }
                a(m390a(), iA10, iA2, iA3, m392a(this.f11527a));
            } else if (this.f343b != null) {
                if (j.a(a()) >= 10) {
                    m390a().setImageViewBitmap(iA9, a(this.f343b, 30.0f));
                } else {
                    m390a().setImageViewBitmap(iA9, this.f343b);
                }
                Map<String, String> map = ((dx) this).f350a;
                if (map != null && this.c == 16777216) {
                    c(map.get("notification_image_text_color"));
                }
                int i = this.c;
                a(m390a(), iA10, iA2, iA3, i == 16777216 || !m392a(i));
            } else if (Build.VERSION.SDK_INT >= 24) {
                m390a().setViewVisibility(iA, 8);
                m390a().setViewVisibility(iA9, 8);
                try {
                    aw.a((Object) this, "setStyle", C1401r.a(a(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("load class DecoratedCustomViewStyle failed");
                }
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            setCustomContentView(m390a());
            return;
        }
        m393b();
    }

    private void a(RemoteViews remoteViews, int i, int i2, int i3, boolean z) {
        int iA = a(6.0f);
        remoteViews.setViewPadding(i, iA, 0, iA, 0);
        if (z) {
            remoteViews.setTextColor(i2, -1);
            remoteViews.setTextColor(i3, -1);
        } else {
            remoteViews.setTextColor(i2, -16777216);
            remoteViews.setTextColor(i3, -16777216);
        }
    }

    private Drawable a(int i, int i2, int i3, float f) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.setIntrinsicWidth(i2);
        shapeDrawable.setIntrinsicHeight(i3);
        return shapeDrawable;
    }
}
