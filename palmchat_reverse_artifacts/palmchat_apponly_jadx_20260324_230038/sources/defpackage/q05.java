package defpackage;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.opensource.svgaplayer.SVGAImageView;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.bean.ContactExtBean;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.widget.MSVGAImageView;
import defpackage.c15;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class q05 {

    /* JADX INFO: compiled from: SearchBox */
    public class b extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f20152a;

        public b(View.OnClickListener onClickListener) {
            this.f20152a = onClickListener;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            View.OnClickListener onClickListener = this.f20152a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d<T> {
        void a(Exception exc);

        void b(T t);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e<T> {
        void a(T t);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void a();
    }

    public static void A(int i, ImageView imageView) {
        imageView.setVisibility(0);
        if (i == 1) {
            imageView.setImageResource(R$drawable.icon_sex_female);
        } else if (i == 0) {
            imageView.setImageResource(R$drawable.icon_sex_male);
        } else {
            imageView.setVisibility(8);
        }
    }

    public static void B(TextView textView, SpannableString spannableString, int i, String str, View.OnClickListener onClickListener) {
        String string = spannableString.toString();
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i);
        int iIndexOf = string.indexOf(str);
        if (iIndexOf >= 0) {
            spannableString.setSpan(foregroundColorSpan, iIndexOf, str.length() + iIndexOf, 34);
            spannableString.setSpan(new b(onClickListener), string.indexOf(str), string.indexOf(str) + str.length(), 34);
            textView.setText(spannableString);
            textView.setHighlightColor(ContextCompat.getColor(textView.getContext(), R.color.transparent));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static void C(TextView textView, float f2) {
        textView.setTextSize(1, f2);
    }

    public static void D(ViewGroup viewGroup) {
        viewGroup.setPadding(0, me1.h(viewGroup.getContext()), 0, 0);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        layoutParams.height = me1.h(viewGroup.getContext());
        viewGroup.setLayoutParams(layoutParams);
    }

    public static void E(ImageView imageView, String str) {
        int iH = fg6.h(str);
        if (!fg6.q(iH)) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(fg6.e(iH));
            imageView.setVisibility(0);
        }
    }

    public static void a(String str, int i, Map<String, Object> map) {
        String str2 = i == 1 ? "view" : i == 2 ? "click" : null;
        if (map == null) {
            zn6.c(str, str2);
        } else {
            zn6.j(str, str2, map);
        }
    }

    public static String b(long j) {
        if (j >= 1024) {
            return j < 1048576 ? String.format("%.1f KB", Double.valueOf(j / 1024.0d)) : j < 1073741824 ? String.format("%.1f MB", Double.valueOf(j / 1048576.0d)) : String.format("%.1f GB", Double.valueOf(j / 1.073741824E9d));
        }
        return j + " B";
    }

    public static String c() {
        return nl0.z;
    }

    public static MaterialDialog d(Context context, @LayoutRes int i) {
        MaterialDialog materialDialogE = new sd3(context).b(true).c(0).q(0.8f).o(i, false).e();
        materialDialogE.c(false);
        Window window = materialDialogE.getWindow();
        if (window != null) {
            window.setGravity(17);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = (-me1.h(context)) / 2;
            window.setAttributes(attributes);
        }
        return materialDialogE;
    }

    public static ContactInfoItem e() {
        return v4.f();
    }

    public static JSONObject f(String str) {
        try {
            try {
                return vs0.a().getConfig(str);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String g(String str) {
        return !TextUtils.isEmpty(str) ? str.replace("{", "<a").replace("}", "</a>") : str;
    }

    public static String h(TextView textView, String str) {
        int width = (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight();
        TextPaint paint = textView.getPaint();
        float f2 = width;
        if (paint.measureText(str) <= f2) {
            return str;
        }
        float fMeasureText = f2 - paint.measureText("...");
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                break;
            }
            int i2 = i + 1;
            if (paint.measureText(str, 0, i2) > fMeasureText) {
                length = i;
                break;
            }
            i = i2;
        }
        return str.substring(0, length) + "...";
    }

    public static LocationEx i() {
        return com.zenmen.palmchat.location.d.g().i(86400000L);
    }

    public static <T> T j(String str, Object obj) {
        return (T) SPUtil.f14322a.q(SPUtil.SCENE.APP_COMMON, str, obj);
    }

    public static <T> T k(String str, Object obj) {
        return (T) SPUtil.f14322a.q(SPUtil.SCENE.APP_COMMON, k86.a(str), obj);
    }

    public static CountDownTimer l(Activity activity, long j, e eVar) {
        a aVar = new a(j, 1000L, activity, eVar);
        aVar.start();
        return aVar;
    }

    public static ContactExtBean m(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return (ContactExtBean) az2.a(str, ContactExtBean.class);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void n(MSVGAImageView mSVGAImageView, String str) {
        mSVGAImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mSVGAImageView.setFillMode(SVGAImageView.FillMode.Clear);
        mSVGAImageView.setLoops(Integer.MAX_VALUE);
        mSVGAImageView.setClearsAfterDetached(true);
        try {
            c15.INSTANCE.b().n(str, new c(mSVGAImageView), null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean o(Activity activity) {
        return activity == null || activity.isFinishing() || activity.isDestroyed();
    }

    public static boolean p() {
        return l50.a();
    }

    public static boolean q(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        int i = calendar.get(1);
        int i2 = calendar.get(6);
        calendar.setTime(new Date(System.currentTimeMillis()));
        return i == calendar.get(1) && i2 == calendar.get(6);
    }

    public static boolean r(View view) {
        while (view != null) {
            if (view.getVisibility() != 0) {
                return false;
            }
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return true;
    }

    public static void s(Context context, ImageView imageView, String str, @DrawableRes int i, @DrawableRes int i2) {
        hc2.a(context).load(str).placeholder(i).error(i).into(imageView);
    }

    public static void t(String str) {
        SPUtil.f14322a.r(SPUtil.SCENE.APP_COMMON, k86.a(str));
    }

    public static void u(Activity activity, f fVar) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || fVar == null) {
            return;
        }
        fVar.a();
    }

    public static void v(String str, Object obj) {
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, str, obj);
    }

    public static void w(String str, Object obj) {
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, k86.a(str), obj);
    }

    public static void x(TextView textView, long j) {
        if (j <= 0) {
            textView.setVisibility(8);
            return;
        }
        double dFloor = j / 1000.0f;
        if (dFloor < 0.01d) {
            dFloor = 0.01d;
        }
        if (dFloor > 10.0d) {
            dFloor = Math.floor(dFloor);
        }
        String str = String.format("%.2f", Double.valueOf(dFloor));
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length > 1) {
            char[] charArray = strArrSplit[1].toCharArray();
            int length = charArray.length;
            for (int length2 = charArray.length - 1; length2 >= 0 && charArray[length2] == '0'; length2--) {
                length--;
            }
            str = length > 0 ? strArrSplit[0] + "." + strArrSplit[1].substring(0, length) : strArrSplit[0];
        }
        textView.setText(str + "km · ");
        textView.setVisibility(0);
    }

    public static void y(View view, Integer num, Integer num2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (num != null) {
            layoutParams.width = num.intValue();
        }
        if (num2 != null) {
            layoutParams.height = num2.intValue();
        }
        view.setLayoutParams(layoutParams);
    }

    public static void z(int i, String str, TextView textView) {
        textView.setText(str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f20150a;
        public final /* synthetic */ e b;

        /* JADX INFO: renamed from: q05$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1267a implements f {
            public C1267a() {
            }

            @Override // q05.f
            public void a() {
                e eVar = a.this.b;
                if (eVar != null) {
                    eVar.a("");
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j, long j2, Activity activity, e eVar) {
            super(j, j2);
            this.f20150a = activity;
            this.b = eVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            q05.u(this.f20150a, new C1267a());
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements c15.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MSVGAImageView f20153a;

        public c(MSVGAImageView mSVGAImageView) {
            this.f20153a = mSVGAImageView;
        }

        @Override // c15.d
        public void onComplete(@NonNull m15 m15Var) {
            this.f20153a.setVideoItem(m15Var);
            this.f20153a.stepToPercentage(0.5d, false);
            this.f20153a.setCallback(new a());
            this.f20153a.setHasLoad(true);
            this.f20153a.startSvgaAnimation();
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements v05 {
            public a() {
            }

            @Override // defpackage.v05
            public void a() {
            }

            @Override // defpackage.v05
            public void c() {
            }

            @Override // defpackage.v05
            public void onPause() {
            }

            @Override // defpackage.v05
            public void b(int i, double d) {
            }
        }

        @Override // c15.d
        public void onError() {
        }
    }
}
