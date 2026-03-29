package com.opos.mobad.template;

import android.animation.Animator;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.d.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.baseview.BaseTextView;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class h {
    public static BitmapDrawable a(Context context, Bitmap bitmap) {
        if (bitmap != null) {
            return context == null ? new BitmapDrawable(bitmap) : new BitmapDrawable(context.getResources(), bitmap);
        }
        return null;
    }

    public static void b(final a.InterfaceC0778a interfaceC0778a, String str, com.opos.mobad.d.a aVar, String str2, final b bVar) {
        if (bVar == null) {
            return;
        }
        if (aVar == null) {
            a((Bitmap) null, bVar);
            return;
        }
        if (com.opos.cmn.an.d.b.a(str)) {
            a((Bitmap) null, bVar);
            return;
        }
        try {
            aVar.a(str, str2, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.h.2
                @Override // com.opos.mobad.d.a.InterfaceC0732a
                public void a(int i, Bitmap bitmap) {
                    a.InterfaceC0778a interfaceC0778a2;
                    if (i != 0 && i != 1) {
                        h.a((Bitmap) null, bVar);
                        return;
                    }
                    if (i == 1 && (interfaceC0778a2 = interfaceC0778a) != null) {
                        interfaceC0778a2.c(i);
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        h.a((Bitmap) null, bVar);
                    } else {
                        h.a(bitmap, bVar);
                    }
                }
            });
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.a("TemplateUtils", "", th);
        }
    }

    public static int c(Context context) {
        int identifier;
        if (context != null && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean d(Context context) {
        if (context == null) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        ContentResolver contentResolver = context.getContentResolver();
        if (i < 31) {
            return Settings.Secure.getInt(contentResolver, "navigation_mode", 0) == 2;
        }
        int i2 = Settings.Secure.getInt(contentResolver, "hide_navigationbar_enable", 0);
        return i2 == 2 || i2 == 3;
    }

    public static int e(Context context) {
        int dimensionPixelSize = 0;
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
                if (identifier > 0) {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                }
            } else {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                dimensionPixelSize = context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("navigation_bar_height").get(cls.newInstance()).toString()));
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TemplateUtils", "getNavBarHeightRes", e);
        }
        com.opos.cmn.an.f.a.b("TemplateUtils", "navbarHeight=" + dimensionPixelSize);
        return dimensionPixelSize;
    }

    public static boolean f(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static final View a(com.opos.mobad.template.d.b bVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, com.opos.mobad.d.a aVar, a.InterfaceC0778a interfaceC0778a) {
        return a(bVar, viewGroup, layoutParams, aVar, interfaceC0778a, true);
    }

    public static void b(String str, String str2, int i, int i2, com.opos.mobad.d.a aVar, final b bVar, final a.InterfaceC0778a interfaceC0778a) {
        if (bVar == null) {
            return;
        }
        if (aVar == null) {
            a((Bitmap) null, bVar);
            return;
        }
        if (com.opos.cmn.an.d.b.a(str)) {
            a((Bitmap) null, bVar);
            return;
        }
        try {
            aVar.a(str, str2, i, i2, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.h.5
                @Override // com.opos.mobad.d.a.InterfaceC0732a
                public void a(int i3, Bitmap bitmap) {
                    a.InterfaceC0778a interfaceC0778a2;
                    if (i3 != 0 && i3 != 1) {
                        h.a((Bitmap) null, bVar);
                        return;
                    }
                    if (i3 == 1 && (interfaceC0778a2 = interfaceC0778a) != null) {
                        interfaceC0778a2.c(i3);
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        h.a((Bitmap) null, bVar);
                    } else {
                        h.a(bitmap, bVar);
                    }
                }
            });
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.a("TemplateUtils", "", th);
        }
    }

    public static final View a(final com.opos.mobad.template.d.b bVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, com.opos.mobad.d.a aVar, a.InterfaceC0778a interfaceC0778a, final boolean z) {
        if (viewGroup == null) {
            return null;
        }
        final Context context = viewGroup.getContext();
        final BaseTextView baseTextView = new BaseTextView(context);
        baseTextView.setPadding(com.opos.cmn.an.h.f.a.a(context, 4.0f), com.opos.cmn.an.h.f.a.a(context, 2.0f), com.opos.cmn.an.h.f.a.a(context, 4.0f), com.opos.cmn.an.h.f.a.a(context, 2.0f));
        baseTextView.setTextColor(Color.parseColor("#FFFFFF"));
        baseTextView.setTextSize(1, 8.0f);
        baseTextView.setGravity(17);
        baseTextView.setMaxEms(6);
        baseTextView.setEllipsize(TextUtils.TruncateAt.END);
        baseTextView.setSingleLine();
        baseTextView.setVisibility(8);
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        if (bVar != null && bVar.e) {
            com.opos.mobad.template.d.e eVar = bVar.f;
            if (eVar == null || com.opos.cmn.an.d.b.a(eVar.f9414a)) {
                if (z) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(Color.parseColor("#3D151515"));
                    gradientDrawable.setCornerRadius(5.0f);
                    a(baseTextView, gradientDrawable);
                }
                baseTextView.setText(!TextUtils.isEmpty(bVar.i) ? bVar.i : "广告");
                layoutParams.width = -2;
                layoutParams.height = -2;
                baseTextView.setVisibility(0);
            } else {
                com.opos.mobad.template.d.e eVar2 = bVar.f;
                final ViewGroup.LayoutParams layoutParams2 = layoutParams;
                a(interfaceC0778a, eVar2.f9414a, aVar, eVar2.b, new b() { // from class: com.opos.mobad.template.h.1
                    @Override // com.opos.mobad.template.b
                    public void a(Bitmap bitmap) {
                        BaseTextView baseTextView2;
                        String str;
                        ViewGroup.LayoutParams layoutParams3;
                        int iA;
                        BitmapDrawable bitmapDrawableA = bitmap != null ? h.a(context, bitmap) : null;
                        StringBuilder sb = new StringBuilder();
                        sb.append("getLogoDrawable=");
                        sb.append(bitmapDrawableA != null ? bitmapDrawableA : com.igexin.push.core.b.m);
                        com.opos.cmn.an.f.a.b("TemplateUtils", sb.toString());
                        if (bitmapDrawableA != null) {
                            if (z) {
                                GradientDrawable gradientDrawable2 = new GradientDrawable();
                                gradientDrawable2.setColor(637534208);
                                gradientDrawable2.setCornerRadius(9.0f);
                                h.a(baseTextView, new LayerDrawable(new Drawable[]{gradientDrawable2, bitmapDrawableA}));
                            } else {
                                h.a(baseTextView, bitmapDrawableA);
                            }
                            layoutParams2.width = com.opos.cmn.an.h.f.a.a(context, 26.0f);
                            layoutParams3 = layoutParams2;
                            iA = com.opos.cmn.an.h.f.a.a(context, 12.0f);
                        } else {
                            if (z) {
                                GradientDrawable gradientDrawable3 = new GradientDrawable();
                                gradientDrawable3.setColor(Color.parseColor("#3D151515"));
                                gradientDrawable3.setCornerRadius(5.0f);
                                h.a(baseTextView, gradientDrawable3);
                            }
                            if (TextUtils.isEmpty(bVar.i)) {
                                baseTextView2 = baseTextView;
                                str = "广告";
                            } else {
                                baseTextView2 = baseTextView;
                                str = bVar.i;
                            }
                            baseTextView2.setText(str);
                            layoutParams3 = layoutParams2;
                            iA = -2;
                            layoutParams3.width = -2;
                        }
                        layoutParams3.height = iA;
                        baseTextView.setVisibility(0);
                    }
                });
            }
        }
        viewGroup.addView(baseTextView, layoutParams);
        return baseTextView;
    }

    public static boolean b(Context context) {
        Sensor defaultSensor;
        if (context == null) {
            return false;
        }
        Sensor defaultSensor2 = null;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            defaultSensor = sensorManager.getDefaultSensor(1);
            try {
                defaultSensor2 = sensorManager.getDefaultSensor(2);
            } catch (Throwable th) {
                th = th;
                com.opos.cmn.an.f.a.b("TemplateUtils", "shake animal check", th);
            }
        } catch (Throwable th2) {
            th = th2;
            defaultSensor = null;
        }
        return (defaultSensor == null || defaultSensor2 == null) ? false : true;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new BigDecimal(str).setScale(2, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString();
        } catch (NumberFormatException e) {
            com.opos.cmn.an.f.a.b("TemplateUtils", "reduceZero  NumberFormatException  number ： " + str, e);
            return "";
        }
    }

    public static Map<String, String> a(com.opos.mobad.template.e.c.a aVar) {
        HashMap map = new HashMap();
        com.opos.mobad.template.e.a aVar2 = com.opos.mobad.template.e.a.UNKNOWN;
        if (aVar != null) {
            aVar2 = aVar.f9430a;
        }
        map.put("template_interactive_mode", String.valueOf(aVar2.ordinal()));
        return map;
    }

    public static Map<String, String> a(com.opos.mobad.template.e.c.a aVar, com.opos.mobad.template.d.b bVar) {
        Map<String, String> mapA = a(aVar);
        mapA.put("isShowCoupons", a(bVar) ? "1" : "0");
        return mapA;
    }

    public static void a(int i, int i2, ImageView imageView) {
        if (imageView == null || i == 0 || i2 == 0) {
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.eraseColor(Color.argb(20, 0, 0, 0));
        imageView.setImageBitmap(bitmapCreateBitmap);
    }

    public static void a(Animator animator) {
        if (animator == null) {
            return;
        }
        try {
            animator.removeAllListeners();
            animator.end();
            animator.cancel();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TemplateUtils", "endAnimator() fail", e);
        }
    }

    public static void a(Context context, int i, RelativeLayout relativeLayout) {
        if (context == null || relativeLayout == null) {
            return;
        }
        View view = new View(context);
        int iA = com.opos.cmn.an.h.f.a.a(context, i == 0 ? 280.0f : 142.0f);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, 855638016});
        gradientDrawable.setGradientType(0);
        view.setBackground(gradientDrawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, iA);
        layoutParams.addRule(12);
        relativeLayout.addView(view, layoutParams);
    }

    public static void a(final Bitmap bitmap, final b bVar) {
        if (bVar == null) {
            return;
        }
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.h.3
            @Override // java.lang.Runnable
            public void run() {
                bVar.a(bitmap);
            }
        });
    }

    public static void a(View view, Drawable drawable) {
        if (view == null || drawable == null) {
            return;
        }
        view.setBackground(drawable);
    }

    public static void a(TextView textView) {
        if (textView != null) {
            TextPaint paint = textView.getPaint();
            paint.setStrokeWidth(0.8f);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setAntiAlias(true);
        }
    }

    public static void a(a.InterfaceC0778a interfaceC0778a, String str, com.opos.mobad.d.a aVar, String str2, b bVar) {
        b(interfaceC0778a, str, aVar, str2, bVar);
    }

    public static void a(String str, String str2, final int i, int i2, com.opos.mobad.d.a aVar, final b bVar, final a.InterfaceC0778a interfaceC0778a) {
        if (bVar == null) {
            return;
        }
        if (aVar == null) {
            a((Bitmap) null, bVar);
            return;
        }
        if (com.opos.cmn.an.d.b.a(str)) {
            a((Bitmap) null, bVar);
            return;
        }
        try {
            aVar.a(str, str2, i, i2, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.h.4
                @Override // com.opos.mobad.d.a.InterfaceC0732a
                public void a(int i3, Bitmap bitmap) {
                    a.InterfaceC0778a interfaceC0778a2;
                    if (i3 != 0 && i3 != 1) {
                        h.a(bitmap, bVar);
                        return;
                    }
                    if (i3 == 1 && (interfaceC0778a2 = interfaceC0778a) != null) {
                        interfaceC0778a2.c(i3);
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        h.a((Bitmap) null, bVar);
                    } else {
                        int i4 = i;
                        h.a(com.opos.cmn.an.e.c.a.a(bitmap, i4, (bitmap.getHeight() * i4) / bitmap.getWidth(), 1), bVar);
                    }
                }
            });
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.a("TemplateUtils", "", th);
        }
    }

    public static boolean a() {
        return true;
    }

    public static boolean a(Context context) {
        Sensor defaultSensor;
        if (context == null) {
            return false;
        }
        try {
            defaultSensor = ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(1);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("TemplateUtils", "check", th);
            defaultSensor = null;
        }
        return defaultSensor != null;
    }

    public static boolean a(com.opos.mobad.template.d.b bVar) {
        if (bVar == null || !bVar.J.containsKey("EXT_PARAM_KEY_QPON_TYPE") || !"2".equals(bVar.J.get("EXT_PARAM_KEY_QPON_TYPE")) || !bVar.J.containsKey("EXT_PARAM_KEY_QPON_VALUE") || !bVar.J.containsKey("EXT_PARAM_KEY_QPON_THRESHOLD")) {
            return false;
        }
        String str = bVar.J.get("EXT_PARAM_KEY_QPON_VALUE");
        String str2 = bVar.J.get("EXT_PARAM_KEY_QPON_THRESHOLD");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            return Double.parseDouble(str) > 0.0d && Double.parseDouble(str2) >= 0.0d;
        } catch (NumberFormatException unused) {
            com.opos.cmn.an.f.a.d("TemplateUtils", " NumberFormatException EXT_PARAM_KEY_QPON_VALUE not number");
            return false;
        }
    }
}
