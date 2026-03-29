package com.bytedance.sdk.openadsdk.core.l;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.iz.my;
import com.bytedance.sdk.component.iz.qq;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.huawei.openalliance.ad.constant.az;
import com.ss.android.download.api.constant.BaseConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn implements b {
    private fx u;

    public pn(fx fxVar) {
        this.u = fxVar;
    }

    private String b(com.bytedance.sdk.openadsdk.core.l.fx.nr.u uVar) {
        ApplicationInfo applicationInfo;
        if (!this.u.nr()) {
            return "enable_action_notification=0";
        }
        if (uVar.iz() == 0) {
            return "enable_notification=0";
        }
        Context context = dw.getContext();
        if (context != null && (applicationInfo = context.getApplicationInfo()) != null && applicationInfo.targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33 && !com.bytedance.sdk.openadsdk.core.h.pn.u().nr(dw.getContext(), com.huawei.openalliance.ad.constant.x.cI)) {
            return "post_notifications_deny";
        }
        if (u(1440L, this.u.iz(), 1000 * this.u.pn())) {
            return null;
        }
        return "max_times_limit";
    }

    private String fx(com.bytedance.sdk.openadsdk.core.l.fx.nr.u uVar) {
        ApplicationInfo applicationInfo;
        if (!this.u.u()) {
            return "enable_install_notification";
        }
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx = com.bytedance.sdk.openadsdk.core.n.o().sx();
        if (bVarSx != null && !bVarSx.n()) {
            return "isCanUseMessage";
        }
        if (uVar.iz() == 0) {
            return "enable_notification=0";
        }
        Context context = dw.getContext();
        if (context != null && (applicationInfo = context.getApplicationInfo()) != null && applicationInfo.targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33 && !com.bytedance.sdk.openadsdk.core.h.pn.u().nr(dw.getContext(), com.huawei.openalliance.ad.constant.x.cI)) {
            return "post_notifications_deny";
        }
        if (u(1440L, this.u.iz(), 1000 * this.u.pn())) {
            return null;
        }
        return "max_times_limit";
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.b
    public boolean nr(com.bytedance.sdk.openadsdk.core.l.fx.nr.u uVar) {
        String strB = b(uVar);
        if (TextUtils.isEmpty(strB)) {
            u(uVar, "pushUnActiveFromMarketMessage");
            return true;
        }
        u("notification", uVar, "open", "othershow", strB, "failure");
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.b
    public boolean u(final com.bytedance.sdk.openadsdk.core.l.fx.nr.u uVar) {
        String strFx = fx(uVar);
        if (TextUtils.isEmpty(strFx)) {
            jk.u().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.l.pn.1
                @Override // java.lang.Runnable
                public void run() {
                    pn.this.u(uVar, "startUnInstallNotification");
                }
            }, this.u.b() * 1000);
            return true;
        }
        u("notification", uVar, az.ah, "othershow", strFx, "failure");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final com.bytedance.sdk.openadsdk.core.l.fx.nr.u uVar, final String str) {
        if (uVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.n.nr.u(uVar.nr()).config(Bitmap.Config.ARGB_4444).type(2).to(new qq<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.l.pn.2
            @Override // com.bytedance.sdk.component.iz.qq
            public void onSuccess(my<Bitmap> myVar) {
                if (myVar != null) {
                    Bitmap result = myVar.getResult();
                    final Bitmap bitmapU = pn.u(result, 10.0f);
                    if (result != null) {
                        final boolean zFx = jp.fx(dw.getContext(), uVar.fx());
                        pn.u("notification", uVar, zFx ? "open" : az.ah, "othershow", str + "_" + uVar.fx(), "success");
                        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.l.pn.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(uVar, "com.csj.install", zFx ? 1 : 2, bitmapU);
                            }
                        });
                    }
                }
            }

            @Override // com.bytedance.sdk.component.iz.qq
            public void onFailed(int i, String str2, Throwable th) {
            }
        }, 4);
    }

    public static void u(String str, final com.bytedance.sdk.openadsdk.core.l.fx.nr.u uVar, final String str2, String str3, final String str4, final String str5) {
        com.bytedance.sdk.openadsdk.core.s.b.u(str, str3, uVar.n(), uVar.pn(), new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.l.pn.3
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", str2);
                jSONObject2.put("installer_package_name", uVar.fx());
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put("detail_info", str4);
                }
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject2.put("status", str5);
                }
                if (jSONObject != null) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                }
            }
        });
    }

    public static Bitmap u(Bitmap bitmap, float f) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap;
    }

    public boolean u(long j, int i, long j2) {
        int i2;
        try {
            Long lValueOf = -1L;
            try {
                lValueOf = Long.valueOf(60 * j * 1000);
                i2 = i;
            } catch (Exception e) {
                e.getMessage();
                i2 = -1;
            }
            if (lValueOf.longValue() >= 0 && i2 >= 0 && lValueOf.longValue() != 0 && i2 != 0) {
                String strU = u();
                StringBuilder sb = new StringBuilder();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (TextUtils.isEmpty(strU)) {
                    sb.append(jCurrentTimeMillis);
                    u(sb.toString());
                    return true;
                }
                String[] strArrSplit = strU.split("_");
                int length = strArrSplit.length;
                if (length < i2) {
                    if (jCurrentTimeMillis - Long.parseLong(strArrSplit[length - 1]) <= j2) {
                        return false;
                    }
                    for (String str : strArrSplit) {
                        sb.append(str);
                        sb.append("_");
                    }
                    sb.append(jCurrentTimeMillis);
                    u(sb.toString());
                    return true;
                }
                int i3 = length - i2;
                if (jCurrentTimeMillis - Long.valueOf(Long.parseLong(strArrSplit[length + (-1)])).longValue() > j2 && jCurrentTimeMillis - Long.valueOf(Long.parseLong(strArrSplit[i3])).longValue() > lValueOf.longValue()) {
                    for (int i4 = i3; i4 < length; i4++) {
                        String str2 = strArrSplit[i4];
                        if (i4 != i3 && !TextUtils.isEmpty(str2)) {
                            sb.append(str2);
                            sb.append("_");
                        }
                    }
                    sb.append(jCurrentTimeMillis);
                    u(sb.toString());
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            e2.getMessage();
            return false;
        }
    }

    public static String u() {
        return com.bytedance.sdk.openadsdk.core.nr.u().get("notification_a", "");
    }

    public static void u(String str) {
        com.bytedance.sdk.openadsdk.core.nr.u().put("notification_a", str);
    }
}
