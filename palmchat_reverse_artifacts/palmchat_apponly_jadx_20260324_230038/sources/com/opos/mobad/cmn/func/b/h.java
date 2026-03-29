package com.opos.mobad.cmn.func.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class h {

    /* JADX INFO: renamed from: com.opos.mobad.cmn.func.b.h$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8724a;

        static {
            int[] iArr = new int[a.values().length];
            f8724a = iArr;
            try {
                iArr[a.NON_CLICK_BT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8724a[a.E_COMMERCE_DIALOG_BTN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8724a[a.OUT_COUPONS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8724a[a.FLOAT_LAYER_INTERSTITIAL_RETAIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8724a[a.SHAKE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8724a[a.FORWARD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8724a[a.TILT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8724a[a.LIGHT_INTERACTIVE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8724a[a.CLICK_BT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8724a[a.VIDEO.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f8724a[a.FLOAT_LAYER_CLICK_BT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f8724a[a.FLOAT_LAYER_SHAKE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f8724a[a.FLOAT_LAYER_NON_CLICK_BT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public static int a() {
        return View.generateViewId();
    }

    public static Bitmap a(int i, Bitmap bitmap) {
        if (bitmap == null || i <= 0) {
            return bitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth() * i, bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        for (int i2 = 0; i2 < i; i2++) {
            canvas.drawBitmap(bitmap, bitmap.getWidth() * i2, 0.0f, (Paint) null);
        }
        return bitmapCreateBitmap;
    }

    public static BitmapDrawable a(Context context, Bitmap bitmap) {
        if (bitmap != null) {
            return context == null ? new BitmapDrawable(bitmap) : new BitmapDrawable(context.getResources(), bitmap);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, AdItemData adItemData, boolean z) {
        String strV;
        MaterialData materialData;
        if (adItemData == null || (materialData = adItemData.i().get(0)) == null) {
            strV = "";
        } else {
            strV = "立刻打开";
            if (!z) {
                if (TextUtils.isEmpty(materialData.V())) {
                    switch (materialData.d()) {
                        case 1:
                            strV = "点击查看";
                            break;
                        case 2:
                            if (com.opos.cmn.an.d.b.a(materialData.i()) || !com.opos.cmn.an.h.d.a.d(context, materialData.i())) {
                                strV = "点击安装";
                            }
                            break;
                        case 3:
                            if (com.opos.cmn.an.d.b.a(materialData.i()) || !com.opos.cmn.an.h.d.a.d(context, materialData.i())) {
                                strV = "立即下载";
                            }
                            break;
                        case 5:
                            strV = "查看详情";
                            break;
                        case 6:
                            strV = "秒开";
                            break;
                        case 7:
                            strV = "打开";
                            break;
                    }
                } else {
                    strV = materialData.V();
                }
            }
        }
        com.opos.cmn.an.f.a.b("ViewUtils", "getClickBnText()", "result=", strV);
        return strV;
    }

    public static void a(Activity activity) {
        if (activity != null) {
            activity.requestWindowFeature(1);
        }
    }

    public static void a(Activity activity, String str) {
        if (activity != null) {
            try {
                Window window = activity.getWindow();
                if (Build.VERSION.SDK_INT >= 23) {
                    window.getDecorView().setSystemUiVisibility(1280);
                    window.addFlags(Integer.MIN_VALUE);
                    window.setStatusBarColor(Color.parseColor(str));
                }
                a(activity, true);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("ViewUtils", "setWhiteStatusBar", (Throwable) e);
            }
        }
    }

    private static void a(Activity activity, boolean z) {
        if (activity != null) {
            try {
                Window window = activity.getWindow();
                window.addFlags(Integer.MIN_VALUE);
                int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
                if (Build.VERSION.SDK_INT >= 23) {
                    systemUiVisibility = z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193);
                }
                window.getDecorView().setSystemUiVisibility(systemUiVisibility);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("ViewUtils", "", (Throwable) e);
            }
        }
    }

    public static void a(View view, Drawable drawable) {
        if (view == null || drawable == null) {
            return;
        }
        view.setBackground(drawable);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(AdItemData adItemData, a aVar) {
        boolean z;
        MaterialData materialDataA;
        if (adItemData != null && (materialDataA = com.opos.mobad.model.utils.a.a(adItemData)) != null) {
            switch (AnonymousClass1.f8724a[aVar.ordinal()]) {
                case 1:
                    if (materialDataA.G() != 0) {
                        z = true;
                        break;
                    }
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    if (materialDataA.d() != 0) {
                    }
                    break;
                case 10:
                    if (materialDataA.H() != 0) {
                    }
                    break;
                case 11:
                case 12:
                    if (materialDataA.S() != 0) {
                    }
                    break;
                case 13:
                    if (materialDataA.T() != 0) {
                    }
                    break;
            }
        } else {
            z = false;
        }
        com.opos.cmn.an.f.a.b("ViewUtils", "isValidClickWithInteraction()", "result=", Boolean.valueOf(z));
        return z;
    }
}
