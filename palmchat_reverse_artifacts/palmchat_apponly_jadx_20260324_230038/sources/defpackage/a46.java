package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import com.amap.api.maps2d.AMapUtils;
import com.amap.api.maps2d.model.LatLng;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.huawei.openalliance.ad.constant.bq;
import com.kuaishou.weapon.p0.g;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.b;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.je1;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a46 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f1150a;
    public static transient je1 b;
    public static Point c;
    public static final AtomicInteger d = new AtomicInteger(1);
    public static int e = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnSystemUiVisibilityChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Window f1151a;

        public a(Window window) {
            this.f1151a = window;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            this.f1151a.getDecorView().setSystemUiVisibility(5894);
        }
    }

    public static void A(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    public static void B(Window window, boolean z, @ColorInt int i) {
        window.getDecorView().setSystemUiVisibility(0);
        window.clearFlags(67108864);
        window.clearFlags(1024);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(null);
        A(window, !z);
    }

    public static void C(View view, int i) {
        view.clearAnimation();
        view.startAnimation(AnimationUtils.loadAnimation(c.b(), i));
    }

    public static String a(LocationEx locationEx, LocationEx locationEx2) {
        if (locationEx == null || locationEx2 == null) {
            return "0.01km";
        }
        return String.format("%.2f", Double.valueOf(((double) AMapUtils.calculateLineDistance(new LatLng(locationEx.getLatitude(), locationEx.getLongitude()), new LatLng(locationEx2.getLatitude(), locationEx2.getLongitude()))) / 1000.0d)) + "km";
    }

    public static int b(Context context, float f) {
        if (f1150a == 0.0f) {
            f1150a = context.getResources().getDisplayMetrics().density;
        }
        return (int) ((f * f1150a) + 0.5f);
    }

    public static void c(Activity activity) {
        if (activity != null) {
            activity.finishAndRemoveTask();
        }
    }

    public static CharSequence d(String str, String str2, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(Pattern.quote(str2)).matcher(spannableString);
        while (matcher.find()) {
            spannableString.setSpan(new ForegroundColorSpan(i), matcher.start(), matcher.end(), 33);
        }
        return spannableString;
    }

    public static CharSequence e(CharSequence charSequence, float f, int i) {
        if (charSequence == null) {
            return null;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f);
        return TextUtils.ellipsize(charSequence, textPaint, i, TextUtils.TruncateAt.END);
    }

    public static int f() {
        AtomicInteger atomicInteger;
        int i;
        int i2;
        do {
            atomicInteger = d;
            i = atomicInteger.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!atomicInteger.compareAndSet(i, i2));
        return i;
    }

    public static String g(int i, int i2, String str) {
        if ((i <= 0 && i2 <= 0) || TextUtils.isEmpty(str)) {
            return str;
        }
        LogUtil.i("WebpUrl", "oldUrl:" + str);
        if ((!str.startsWith("http://") && !str.startsWith("https://")) || str.contains(".jpg") || str.contains(".png") || str.contains(".webp") || str.contains(".gif") || str.contains("format=") || str.contains("width=") || str.contains("height=")) {
            return str;
        }
        String str2 = str + "?format=webp&width=" + i + "&height=" + i2;
        LogUtil.i("WebpUrl", "newUrl:" + str2);
        return str2;
    }

    public static String h(View view, String str) {
        int i;
        int i2;
        if (view == null || TextUtils.isEmpty(str)) {
            return str;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return (width <= 0 || height <= 0) ? (layoutParams == null || (i = layoutParams.width) <= 0 || (i2 = layoutParams.height) <= 0) ? g(b(c.b(), 208.0f), b(c.b(), 180.0f), str) : g(Math.max(i, i2), Math.min(layoutParams.width, layoutParams.height), str) : g(Math.max(width, height), Math.min(width, height), str);
    }

    public static je1 i(int i) {
        je1.a aVarB = new je1.a().s(true).A(i > 0 ? i : R$drawable.video_default).t(true).q(Bitmap.Config.RGB_565).B(i > 0 ? i : R$drawable.video_default);
        if (i <= 0) {
            i = R$drawable.video_default;
        }
        return aVarB.z(i).r();
    }

    public static je1 j(Context context, float f, int i) {
        if (i <= 0) {
            i = R$drawable.video_default;
        }
        return new je1.a().s(true).A(i).t(true).q(Bitmap.Config.RGB_565).B(i).z(i).r();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static TranslateAnimation k(int i, boolean z) {
        float f;
        float f2;
        float f3;
        float f4;
        if (i == 1) {
            float f5 = z ? -1.0f : 0.0f;
            f4 = z ? 0.0f : -1.0f;
            f3 = f5;
        } else {
            if (i != 2) {
                if (i == 3) {
                    float f6 = z ? -1.0f : 0.0f;
                    f2 = z ? 0.0f : -1.0f;
                    f = f6;
                } else if (i == 4) {
                    f = z ? 1.0f : 0.0f;
                    f2 = z ? 0.0f : 1.0f;
                } else {
                    f = 0.0f;
                    f2 = 0.0f;
                }
                f3 = 0.0f;
                f4 = 0.0f;
                TranslateAnimation translateAnimation = new TranslateAnimation(2, f, 2, f2, 2, f3, 2, f4);
                if (i != 0) {
                    translateAnimation.setDuration(0L);
                } else {
                    translateAnimation.setDuration(300L);
                }
                translateAnimation.setInterpolator(new LinearInterpolator());
                translateAnimation.setFillAfter(true);
                return translateAnimation;
            }
            f3 = z ? 1.0f : 0.0f;
            f4 = z ? 0.0f : 1.0f;
        }
        f = 0.0f;
        f2 = 0.0f;
        TranslateAnimation translateAnimation2 = new TranslateAnimation(2, f, 2, f2, 2, f3, 2, f4);
        if (i != 0) {
        }
        translateAnimation2.setInterpolator(new LinearInterpolator());
        translateAnimation2.setFillAfter(true);
        return translateAnimation2;
    }

    public static je1 l() {
        if (b == null) {
            je1.a aVarQ = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565);
            int i = R$drawable.default_portrait;
            b = aVarQ.B(i).A(i).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).z(i).r();
        }
        return b;
    }

    public static Point m(Context context) {
        Point point = c;
        if (point == null || point.x == 0 || point.y == 0) {
            c = new Point();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            Point point2 = c;
            point2.x = displayMetrics.widthPixels;
            point2.y = displayMetrics.heightPixels;
        }
        return c;
    }

    public static int n(Context context) {
        int i = e;
        if (i != 0) {
            return i;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            e = context.getResources().getDimensionPixelSize(identifier);
        }
        return e;
    }

    public static boolean o() {
        return b.f(c.b());
    }

    public static boolean p() {
        return q() && o();
    }

    public static boolean q() {
        return tg4.b(c.b(), g.g);
    }

    public static void r(Object obj, Class<?> cls, String str, Object obj2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException unused) {
        }
    }

    public static boolean s(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    public static void t(String str, int i, DrawableImageViewTarget drawableImageViewTarget, Priority priority) {
        Context context = drawableImageViewTarget.getView().getContext();
        if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
            return;
        }
        try {
            RequestBuilder requestBuilderJ = hc2.a(context).load(k86.p(str)).priority(priority).diskCacheStrategy(DiskCacheStrategy.DATA);
            if (i > 0) {
                requestBuilderJ = requestBuilderJ.error(i);
            }
            requestBuilderJ.into(drawableImageViewTarget);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void u(String str, ImageView imageView, int i) {
        v(str, imageView, i, Priority.HIGH);
    }

    public static void v(String str, ImageView imageView, int i, Priority priority) {
        Context context = imageView.getContext();
        if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
            return;
        }
        try {
            kc2<Drawable> kc2VarJ = hc2.a(context).load(k86.p(str)).diskCacheStrategy(DiskCacheStrategy.DATA);
            if (i > 0) {
                kc2VarJ = kc2VarJ.error(i);
            }
            kc2VarJ.into(imageView);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void w(String str, int i, DrawableImageViewTarget drawableImageViewTarget, Priority priority) {
        Context context = drawableImageViewTarget.getView().getContext();
        if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
            return;
        }
        try {
            RequestBuilder requestBuilderJ = hc2.a(context).load(k86.p(str)).priority(priority).diskCacheStrategy(DiskCacheStrategy.DATA);
            if (i > 0) {
                requestBuilderJ = (RequestBuilder) requestBuilderJ.error(i).placeholder(i);
            }
            requestBuilderJ.into(drawableImageViewTarget);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void x(String str, int i, DrawableImageViewTarget drawableImageViewTarget, Priority priority, boolean z) {
        Context context = drawableImageViewTarget.getView().getContext();
        if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
            return;
        }
        try {
            RequestBuilder requestBuilderJ = hc2.a(context).load(k86.p(str)).priority(priority).diskCacheStrategy(DiskCacheStrategy.DATA);
            if (z) {
                requestBuilderJ.transform(new y5(6, 2));
            }
            if (i > 0) {
                requestBuilderJ = (RequestBuilder) requestBuilderJ.error(i).placeholder(i);
            }
            requestBuilderJ.into(drawableImageViewTarget);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void y(Window window, int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            r(attributes, WindowManager.LayoutParams.class, bq.f.A, Integer.valueOf(i));
            window.setAttributes(attributes);
        }
    }

    public static void z(Window window, boolean z) {
        y(window, 1);
        window.addFlags(1024);
        window.getDecorView().setSystemUiVisibility(5122);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(new a(window));
    }
}
