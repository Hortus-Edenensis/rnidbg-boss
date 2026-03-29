package com.xiaomi.push;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.cdo.oaps.ad.OapsKey;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class du extends dx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11525a;
    private Bitmap b;
    private Bitmap c;

    public du(Context context, String str) {
        super(context, str);
        this.f11525a = 16777216;
    }

    @Override // com.xiaomi.push.dx, android.app.Notification.Builder
    /* JADX INFO: renamed from: a */
    public dx setLargeIcon(Bitmap bitmap) {
        return this;
    }

    @Override // com.xiaomi.push.dx
    public String b() {
        return null;
    }

    @Override // com.xiaomi.push.dx
    /* JADX INFO: renamed from: a */
    public String mo391a() {
        return "notification_banner";
    }

    public du b(Bitmap bitmap) {
        if (m394b() && bitmap != null) {
            this.c = bitmap;
        }
        return this;
    }

    @Override // com.xiaomi.push.dx
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo385a() {
        if (!j.m650a()) {
            return false;
        }
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        return (a(a().getResources(), OapsKey.KEY_BG, "id", a().getPackageName()) == 0 || a(resources, "icon", "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || j.a(a()) < 9) ? false : true;
    }

    @Override // com.xiaomi.push.dx
    /* JADX INFO: renamed from: a */
    public du setLargeIcon(Bitmap bitmap) {
        if (m394b() && bitmap != null) {
            if (bitmap.getWidth() == 984 && 184 <= bitmap.getHeight() && bitmap.getHeight() <= 1678) {
                this.b = bitmap;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m74a("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dv
    /* JADX INFO: renamed from: a */
    public du mo386a(String str) {
        if (m394b() && !TextUtils.isEmpty(str)) {
            try {
                this.f11525a = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.m74a("parse banner notification image text color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dx, com.xiaomi.push.dv
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo384a() {
        if (m394b() && this.b != null) {
            super.mo384a();
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            int iA = a(resources, OapsKey.KEY_BG, "id", packageName);
            if (j.a(a()) >= 10) {
                m390a().setImageViewBitmap(iA, a(this.b, 30.0f));
            } else {
                m390a().setImageViewBitmap(iA, this.b);
            }
            int iA2 = a(resources, "icon", "id", packageName);
            if (this.c != null) {
                m390a().setImageViewBitmap(iA2, this.c);
            } else {
                a(iA2);
            }
            int iA3 = a(resources, "title", "id", packageName);
            m390a().setTextViewText(iA3, ((dx) this).f347a);
            Map<String, String> map = ((dx) this).f350a;
            if (map != null && this.f11525a == 16777216) {
                mo386a(map.get("notification_image_text_color"));
            }
            RemoteViews remoteViewsM390a = m390a();
            int i = this.f11525a;
            remoteViewsM390a.setTextColor(iA3, (i == 16777216 || !m392a(i)) ? -1 : -16777216);
            setCustomContentView(m390a());
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            return;
        }
        m393b();
    }
}
