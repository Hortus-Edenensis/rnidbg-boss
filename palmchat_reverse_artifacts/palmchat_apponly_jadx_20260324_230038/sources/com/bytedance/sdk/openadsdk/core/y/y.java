package com.bytedance.sdk.openadsdk.core.y;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.bytedance.sdk.component.widget.SSWebView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class y {
    private static volatile float b = -1.0f;
    private static volatile int fx = -1;
    private static volatile int iz = -1;
    private static float n = 0.0f;
    private static volatile float nr = -1.0f;
    private static volatile int pn = -1;
    public static volatile int u = -1;
    private static int x = 13;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(View view);
    }

    public static int a(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.dw.getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private static boolean b() {
        return nr < 0.0f || fx < 0 || b < 0.0f || pn < 0 || iz < 0;
    }

    private static float bg(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.dw.getContext();
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static int fx(Context context, float f) {
        u(context);
        return (int) ((f * bg(context)) + 0.5f);
    }

    public static float iz(Context context) {
        u(context);
        return nr;
    }

    public static int jk(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.dw.getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static boolean k(Context context) {
        String strNr = jk.nr();
        return strNr.equals("IN2010") || strNr.equals("IN2020") || strNr.equals("KB2000");
    }

    public static boolean l(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean mv(Context context) {
        try {
            if ("V1938CT".equals(jk.nr())) {
                return false;
            }
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean my(Context context) {
        return Build.MANUFACTURER.equals("samsung");
    }

    public static int n(Context context) {
        u(context);
        return fx;
    }

    public static int nr(float f, float f2) {
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (int) ((f2 / f) + 0.5f);
    }

    public static TextView o(Context context) {
        if (context == null) {
            return null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.bytedance.sdk.openadsdk.core.dislike.u.u.nr().u(context, 4.0f));
        TextView textView = new TextView(context);
        textView.setClickable(false);
        textView.setFocusable(false);
        textView.setBackground(gradientDrawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = (int) (((double) pn(context)) * (-0.3d));
        int iFx = fx(context, 20.0f);
        int iFx2 = fx(context, 11.0f);
        textView.setPadding(iFx, iFx2, iFx, iFx2);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(-1);
        textView.setTextSize(x);
        textView.setGravity(17);
        return textView;
    }

    public static int pn(Context context) {
        u(context);
        return iz;
    }

    public static boolean s(Context context) {
        String strJk = jp.jk("com.kllk.feature.screen.heteromorphism");
        if (context == null || context.getPackageManager() == null) {
            return false;
        }
        try {
            return context.getPackageManager().hasSystemFeature(strJk);
        } catch (Throwable unused) {
            return true;
        }
    }

    public static int sx(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static float t(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.dw.getContext();
        }
        try {
            if (context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android") > 0) {
                return context.getApplicationContext().getResources().getDimensionPixelSize(r1);
            }
            return 0.0f;
        } catch (Throwable th) {
            th.getMessage();
            return 0.0f;
        }
    }

    public static int u(float f, float f2) {
        return (int) ((f2 * f) + 0.5f);
    }

    public static float x(Context context) {
        u(context);
        return b;
    }

    public static int b(Context context, float f) {
        u(context);
        float fBg = bg(context);
        if (fBg <= 0.0f) {
            fBg = 1.0f;
        }
        return (int) ((f / fBg) + 0.5f);
    }

    public static int nr(Context context, float f) {
        u(context);
        float fX = x(context);
        if (fX <= 0.0f) {
            fX = 1.0f;
        }
        return (int) ((f / fX) + 0.5f);
    }

    private static boolean u(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    public static int[] fx(Context context) {
        u(context);
        return new int[]{pn, iz};
    }

    public static void iz(View view) {
        if (view == null) {
            return;
        }
        u(view, 0);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.y.y.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationEnd(animator);
            }
        });
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
    }

    public static void n(Activity activity) {
        try {
            Class<?> cls = null;
            for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", cls);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, null);
        } catch (Throwable unused) {
        }
    }

    public static void pn(final View view) {
        if (view == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.y.y.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                y.u(view, 8);
                ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f).setDuration(0L).start();
            }
        });
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.start();
    }

    public static void u(Context context) {
        Resources resources;
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.dw.getContext();
        }
        if (context == null || (resources = context.getResources()) == null) {
            return;
        }
        if (b()) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            nr = displayMetrics.density;
            fx = displayMetrics.densityDpi;
            b = displayMetrics.scaledDensity;
            pn = displayMetrics.widthPixels;
            iz = displayMetrics.heightPixels;
        }
        if (resources.getConfiguration() != null) {
            if (resources.getConfiguration().orientation == 1) {
                if (pn > iz) {
                    int i = pn;
                    pn = iz;
                    iz = i;
                    return;
                }
                return;
            }
            if (pn < iz) {
                int i2 = pn;
                pn = iz;
                iz = i2;
            }
        }
    }

    public static Bitmap x(View view) {
        if (view == null) {
            return null;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        view.draw(canvas);
        canvas.save();
        return bitmapCreateBitmap;
    }

    public static int b(Context context) {
        u(context);
        return pn;
    }

    public static int[] nr(Context context) {
        WindowManager windowManager = null;
        if (context == null) {
            return null;
        }
        try {
            windowManager = (WindowManager) context.getSystemService("window");
        } catch (Exception unused) {
        }
        int[] iArr = new int[2];
        if (windowManager != null) {
            try {
                if (Build.VERSION.SDK_INT >= 30) {
                    Rect bounds = windowManager.getCurrentWindowMetrics().getBounds();
                    iArr[0] = bounds.width();
                    iArr[1] = bounds.height();
                } else {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                    iArr[0] = displayMetrics.widthPixels;
                    iArr[1] = displayMetrics.heightPixels;
                }
            } catch (Throwable unused2) {
            }
        }
        if (iArr[0] <= 0 || iArr[1] <= 0) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            iArr[0] = displayMetrics2.widthPixels;
            iArr[1] = displayMetrics2.heightPixels;
        }
        return iArr;
    }

    public static int[] fx(View view) {
        if (view != null) {
            return new int[]{view.getWidth(), view.getHeight()};
        }
        return null;
    }

    private static void t(Activity activity) {
        Object objInvoke;
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
            declaredMethod.setAccessible(true);
            objInvoke = declaredMethod.invoke(activity, new Object[0]);
        } catch (Throwable unused) {
            objInvoke = null;
        }
        try {
            Class<?> cls = null;
            for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().startsWith("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(activity, null, objInvoke);
        } catch (Throwable unused2) {
        }
    }

    public static boolean b(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static boolean a(Activity activity) {
        return (activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public static boolean b(Activity activity) {
        return iz(activity) || u("ro.miui.notch", activity) == 1 || l(activity) || mv(activity) || k(activity) || my(activity) || jk(activity) || s(activity);
    }

    public static void fx(Activity activity) {
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(com.umeng.analytics.pro.k.b);
        } catch (Exception unused) {
        }
    }

    private static boolean jk(Activity activity) {
        try {
            if (Build.VERSION.SDK_INT >= 26 && activity.getWindow().getDecorView().getHeight() > 0 && activity.getWindow().getDecorView().getWidth() > 0) {
                if (a((Context) activity) - activity.getWindow().getDecorView().getHeight() <= 0) {
                    return jk((Context) activity) - activity.getWindow().getDecorView().getWidth() > 0;
                }
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void pn(@ForbidWrapParam Activity activity) {
        if (fx()) {
            return;
        }
        try {
            final WeakReference weakReference = new WeakReference(activity);
            activity.getWindow().getDecorView().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.y.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.gi.x.u(new com.bytedance.sdk.component.jk.a("check_notch") { // from class: com.bytedance.sdk.openadsdk.core.y.y.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                Activity activity2 = (Activity) weakReference.get();
                                if (activity2 != null && !y.fx()) {
                                    y.u = y.b(activity2) ? 1 : 0;
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static boolean iz(Activity activity) {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        try {
            WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            return (rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean fx() {
        return u != -1;
    }

    public static void n(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static void x(Activity activity) {
        try {
            t(activity);
        } catch (Throwable unused) {
        }
    }

    public static int[] nr(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static void nr(View view, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        u(view, (ViewGroup.MarginLayoutParams) layoutParams, i, i2, i3, i4);
    }

    public static void nr(Activity activity) {
        try {
            fx(activity);
            activity.getWindow().addFlags(134217728);
        } catch (Exception unused) {
        }
    }

    public static float u(Context context, float f) {
        u(context);
        return TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }

    public static boolean nr() {
        return u == 1 || u == -1;
    }

    public static void u(View view, int i, int i2, int i3, int i4) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i;
        rect.bottom += i2;
        rect.left -= i3;
        rect.right += i4;
        ((View) view.getParent()).setTouchDelegate(new com.bytedance.sdk.component.utils.a(rect, view));
    }

    public static void nr(View view, final float f) {
        if (view != null && f > 0.0f) {
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.y.y.7
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    if (outline == null) {
                        return;
                    }
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f);
                }
            });
            view.setClipToOutline(true);
        }
    }

    public static int[] u(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static void u(View view, int i) {
        if (view == null || view.getVisibility() == i || !u(i)) {
            return;
        }
        view.setVisibility(i);
    }

    public static void u(View view, float f) {
        if (view == null) {
            return;
        }
        view.setAlpha(f);
    }

    public static boolean u(SSWebView sSWebView) {
        if (sSWebView == null || !sSWebView.canGoBack()) {
            return false;
        }
        sSWebView.goBack();
        return true;
    }

    public static void u(final com.bytedance.sdk.component.mv.fx fxVar) {
        if (fxVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.y.1
            @Override // java.lang.Runnable
            public void run() {
                WebSettings settings;
                WebView webView = fxVar.getWebView();
                if (webView == null || (settings = webView.getSettings()) == null) {
                    return;
                }
                settings.setTextZoom(100);
            }
        });
    }

    public static void u(TextView textView, CharSequence charSequence) {
        if (textView == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    private static void u(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        if (view == null || marginLayoutParams == null) {
            return;
        }
        if (marginLayoutParams.leftMargin == i && marginLayoutParams.topMargin == i2 && marginLayoutParams.rightMargin == i3 && marginLayoutParams.bottomMargin == i4) {
            return;
        }
        if (i != -3) {
            marginLayoutParams.leftMargin = i;
        }
        if (i2 != -3) {
            marginLayoutParams.topMargin = i2;
        }
        if (i3 != -3) {
            marginLayoutParams.rightMargin = i3;
        }
        if (i4 != -3) {
            marginLayoutParams.bottomMargin = i4;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public static boolean u() {
        try {
            return !((KeyguardManager) com.bytedance.sdk.openadsdk.core.dw.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static JSONObject u(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            int i = 1;
            if (!jSONObject.has("app_scene")) {
                jSONObject.put("app_scene", com.bytedance.sdk.openadsdk.core.n.o().u() ? 1 : 0);
            }
            if (!jSONObject.has("lock_scene")) {
                if (!(!u())) {
                    i = 0;
                }
                jSONObject.put("lock_scene", i);
            }
            if (str != null && !str.isEmpty() && !jSONObject.has("auto_show_check")) {
                jSONObject.put("auto_show_check", str);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.k.u("addShowScene error " + th.toString());
        }
        return jSONObject;
    }

    public static void u(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(3846);
            nr(activity);
        } catch (Exception unused) {
        }
    }

    public static void u(View view, View view2) {
        if (view == null || view2 == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28 && n == 0.0f) {
                WindowInsets rootWindowInsets = view.getRootWindowInsets();
                if ((rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null) != null) {
                    n = r3.getSafeInsetTop();
                }
            }
            if (n == 0.0f) {
                return;
            }
            float fMax = Math.max(t(view2.getContext()), n);
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).topMargin = (int) (r1.topMargin + fMax);
            }
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).topMargin = (int) (r1.topMargin + fMax);
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).topMargin = (int) (r1.topMargin + fMax);
            }
            view2.setLayoutParams(layoutParams);
        } catch (Throwable unused) {
        }
    }

    public static int u(String str, Activity activity) {
        com.bytedance.sdk.component.b.t tVar;
        if (!gi.my() || (tVar = (com.bytedance.sdk.component.b.t) com.bytedance.sdk.openadsdk.ats.fx.u("system_info")) == null) {
            return 0;
        }
        return tVar.getInt(str);
    }

    public static void u(View view, View.OnClickListener onClickListener, String str) {
        if (view == null) {
            com.bytedance.sdk.component.utils.k.nr("OnclickListener ", str + " is null , can not set OnClickListener !!!");
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public static void u(View view, View.OnTouchListener onTouchListener, String str) {
        if (view == null) {
            com.bytedance.sdk.component.utils.k.nr("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
            return;
        }
        view.setOnTouchListener(onTouchListener);
    }

    public static void u(final View view, final u uVar) {
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.y.y.5
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                u uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.u(view);
                }
            }
        });
    }

    public static void u(View view, final com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        if (view == null || bcVar == null) {
            return;
        }
        view.setClickable(true);
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.y.y.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                iz.u(com.bytedance.sdk.openadsdk.core.dw.getContext(), bcVar);
            }
        });
    }

    public static void u(TextView textView, String str, Context context) {
        if (textView == null || TextUtils.isEmpty(str) || context == null) {
            return;
        }
        textView.setText(str);
        textView.setTextSize(2, 8.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#1F161823"));
        gradientDrawable.setCornerRadius(fx(context, 3.0f));
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setTextColor(com.bytedance.sdk.component.utils.q.a(context, "tt_adx_logo_desc"));
        textView.setGravity(17);
        textView.setPadding(fx(context, 2.0f), fx(context, 3.0f), fx(context, 2.0f), fx(context, 3.0f));
    }

    public static void u(TextView textView, com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        if (textView != null && bcVar != null) {
            String strUc = bcVar.uc();
            if (TextUtils.isEmpty(strUc)) {
                u(textView);
                u((View) textView, bcVar);
                return;
            } else {
                u(textView, strUc, com.bytedance.sdk.openadsdk.core.dw.getContext());
                return;
            }
        }
        u(textView);
    }

    public static void u(TextView textView, com.bytedance.sdk.openadsdk.core.kj.bc bcVar, int i, int i2) {
        if (textView != null && bcVar != null) {
            String strUc = bcVar.uc();
            if (TextUtils.isEmpty(strUc)) {
                u(textView, i, i2);
                u((View) textView, bcVar);
                return;
            } else {
                u(textView, strUc, com.bytedance.sdk.openadsdk.core.dw.getContext());
                return;
            }
        }
        u(textView, i, i2);
    }

    private static void u(TextView textView) {
        if (textView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = fx(com.bytedance.sdk.openadsdk.core.dw.getContext(), 32.0f);
        layoutParams.height = fx(com.bytedance.sdk.openadsdk.core.dw.getContext(), 14.0f);
        textView.setLayoutParams(layoutParams);
    }

    private static void u(TextView textView, int i, int i2) {
        if (i <= 0) {
            i = 32;
        }
        if (i2 <= 0) {
            i2 = 14;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = fx(com.bytedance.sdk.openadsdk.core.dw.getContext(), i);
        layoutParams.height = fx(com.bytedance.sdk.openadsdk.core.dw.getContext(), i2);
        textView.setLayoutParams(layoutParams);
    }

    @Deprecated
    public static void u(Context context, String str, int i) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Toast toast = new Toast(context);
        LinearLayout linearLayout = new LinearLayout(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.bytedance.sdk.openadsdk.core.dislike.u.u.nr().u(context, 4.0f));
        linearLayout.setBackground(gradientDrawable);
        TextView textView = new TextView(context);
        textView.setClickable(false);
        textView.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int iFx = fx(context, 20.0f);
        int iFx2 = fx(context, 11.0f);
        textView.setPadding(iFx, iFx2, iFx, iFx2);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(-1);
        textView.setTextSize(x);
        textView.setGravity(17);
        textView.setText(str);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        toast.setGravity(17, 0, 0);
        toast.setDuration(i);
        toast.show();
    }
}
