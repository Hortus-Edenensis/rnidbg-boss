package defpackage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class np3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONArray f19567a = null;
    public static JSONArray b = null;
    public static long c = 2000;
    public static long d;
    public static ImageView e;
    public static ImageView f;
    public static ImageView g;
    public static View h;
    public static TextView i;
    public static View j;
    public static int k;
    public static Integer[] l = {Integer.valueOf(R.drawable.seeme_man_1), Integer.valueOf(R.drawable.seeme_man_2), Integer.valueOf(R.drawable.seeme_man_3)};
    public static Integer[] m = {Integer.valueOf(R.drawable.seeme_female_1), Integer.valueOf(R.drawable.seeme_female_2), Integer.valueOf(R.drawable.seeme_female_3)};
    public static boolean n = false;
    public static boolean o = false;
    public static ValueAnimator p = null;
    public static ValueAnimator q = null;
    public static boolean r = false;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f19568a;
        public final /* synthetic */ float[] b;
        public final /* synthetic */ float c;

        public b(Context context, float[] fArr, float f) {
            this.f19568a = context;
            this.b = fArr;
            this.c = f;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue instanceof Float) {
                    float fFloatValue = ((Float) animatedValue).floatValue();
                    if (fFloatValue < 0.1f) {
                        np3.e.setAlpha(1.0f * (fFloatValue / 0.1f));
                        np3.e.setTranslationX(me1.a(this.f19568a, 42.0f - (r6 * 21.0f)));
                    } else if (fFloatValue < 0.45f) {
                        np3.e.setAlpha(1.0f);
                        this.b[0] = np3.e.getTranslationX();
                    } else if (fFloatValue < 0.75f) {
                        float f = (fFloatValue - 0.45f) / 0.3f;
                        np3.e.setAlpha(1.0f - (f * 1.0f));
                        np3.e.setTranslationX(this.b[0] - ((this.c * f) * 0.5f));
                    } else {
                        np3.h.setAlpha(((fFloatValue - 0.75f) / 0.25f) * 1.0f);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f19569a;
        public final /* synthetic */ float[] b;
        public final /* synthetic */ float c;

        public c(Context context, float[] fArr, float f) {
            this.f19569a = context;
            this.b = fArr;
            this.c = f;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue instanceof Float) {
                    float fFloatValue = ((Float) animatedValue).floatValue();
                    if (fFloatValue < 0.1f) {
                        float f = fFloatValue / 0.1f;
                        np3.e.setAlpha(f);
                        np3.e.setTranslationX(me1.a(this.f19569a, 42.0f - (f * 28.0f)));
                        if (f > 0.7f) {
                            np3.f.setTranslationX(me1.a(this.f19569a, 28.0f - (14.0f * r9)));
                            np3.f.setAlpha(((f - 0.7f) * 10.0f) / 3.0f);
                        }
                    } else if (fFloatValue < 0.45f) {
                        np3.e.setAlpha(1.0f);
                        np3.f.setAlpha(1.0f);
                        this.b[0] = np3.e.getTranslationX();
                        this.b[1] = np3.f.getTranslationX();
                    } else if (fFloatValue < 0.75f) {
                        float f2 = (fFloatValue - 0.45f) / 0.3f;
                        if (f2 < 0.3f) {
                            float f3 = f2 / 0.3f;
                            np3.e.setAlpha(1.0f - f3);
                            np3.e.setTranslationX(this.b[0] + (f3 * this.c * 0.4f));
                        } else {
                            float f4 = ((f2 - 0.3f) * 10.0f) / 7.0f;
                            np3.f.setAlpha(1.0f - f4);
                            np3.f.setTranslationX(this.b[1] - ((f4 * this.c) * 0.85f));
                        }
                    } else {
                        np3.e.setAlpha(0.0f);
                        np3.f.setAlpha(0.0f);
                        float f5 = ((fFloatValue - 0.75f) / 0.25f) * 1.0f;
                        np3.h.setAlpha(f5);
                        if (f5 >= 0.4f) {
                            np3.h();
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f19570a;
        public final /* synthetic */ float[] b;
        public final /* synthetic */ float c;

        public d(Context context, float[] fArr, float f) {
            this.f19570a = context;
            this.b = fArr;
            this.c = f;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue instanceof Float) {
                    float fFloatValue = ((Float) animatedValue).floatValue();
                    if (fFloatValue < 0.25f) {
                        float f = fFloatValue / 0.25f;
                        np3.e.setAlpha(f);
                        np3.e.setTranslationX(me1.a(this.f19570a, 42.0f - (35.0f * f)));
                        if (f > 0.57f) {
                            np3.f.setTranslationX(me1.a(this.f19570a, 28.0f - (21.0f * r1)));
                            np3.f.setAlpha(((f - 0.57f) * 10.0f) / 4.3f);
                            if (f > 0.9f) {
                                np3.g.setTranslationX(me1.a(this.f19570a, 14.0f - (7.0f * r11)));
                                np3.g.setAlpha(((f - 0.9f) * 10.0f) / 1.0f);
                            }
                        }
                    } else if (fFloatValue < 0.5f) {
                        np3.e.setAlpha(1.0f);
                        np3.f.setAlpha(1.0f);
                        np3.g.setAlpha(1.0f);
                        this.b[0] = np3.e.getTranslationX();
                        this.b[1] = np3.f.getTranslationX();
                        this.b[2] = np3.g.getTranslationX();
                    } else if (fFloatValue < 0.8f) {
                        float f2 = (fFloatValue - 0.5f) / 0.3f;
                        if (f2 < 0.3f) {
                            float f3 = f2 / 0.3f;
                            np3.e.setAlpha(1.0f - f3);
                            np3.e.setTranslationX(this.b[0] + (f3 * this.c * 0.4f));
                        } else {
                            float f4 = ((f2 - 0.3f) * 10.0f) / 7.0f;
                            np3.f.setAlpha(1.0f - f4);
                            np3.f.setTranslationX(this.b[1] - ((f4 * this.c) * 0.85f));
                            if (f2 > 0.5f) {
                                float f5 = ((f2 - 0.5f) * 10.0f) / 5.0f;
                                np3.g.setAlpha(1.0f - f5);
                                np3.g.setTranslationX(this.b[2] - ((f5 * this.c) * 1.3f));
                            }
                        }
                    } else {
                        np3.e.setAlpha(0.0f);
                        np3.f.setAlpha(0.0f);
                        np3.g.setAlpha(0.0f);
                        float f6 = ((fFloatValue - 0.8f) / 0.2f) * 1.0f;
                        np3.h.setAlpha(f6);
                        if (f6 >= 0.4f) {
                            np3.h();
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f19571a;

        public e(int i) {
            this.f19571a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view;
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Float) {
                int iFloatValue = (int) (((Float) animatedValue).floatValue() * this.f19571a);
                if (iFloatValue <= 1) {
                    iFloatValue = 1;
                } else if (iFloatValue >= 97) {
                    if (np3.k > 99 && (view = np3.j) != null && view.getVisibility() == 8) {
                        np3.j.setVisibility(0);
                    }
                    iFloatValue = 99;
                }
                np3.i.setText(iFloatValue + "");
            }
        }
    }

    public static boolean b() {
        return !"A".equals(jo6.c("LX-45677", "A"));
    }

    public static void c(View view) {
        if (view != null) {
            if (b()) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    public static void d() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.MINE_SEEME_STYLE_HEADIMG_CONFIG);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            return;
        }
        j(dynamicConfig.getExtra());
    }

    public static void e(ImageView imageView, ImageView imageView2, ImageView imageView3) {
        if (!b() || imageView == null || imageView2 == null || imageView3 == null) {
            return;
        }
        imageView.setVisibility(8);
        imageView2.setVisibility(8);
        imageView3.setVisibility(8);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - d <= c) {
            LogUtil.d("", "MineSeeMe randImgList time not allow ");
            return;
        }
        LogUtil.d("", "MineSeeMe randImgList time allow ");
        d = jCurrentTimeMillis;
        ContactInfoItem contactInfoItemS = bo0.r().s();
        Integer[] numArr = l;
        int i2 = 0;
        int gender = contactInfoItemS != null ? contactInfoItemS.getGender() : 0;
        JSONArray jSONArray = f19567a;
        if (gender == 1) {
            jSONArray = b;
            numArr = m;
        }
        List<String> listG = g(jSONArray);
        ArrayList arrayList = new ArrayList();
        arrayList.add(imageView);
        arrayList.add(imageView2);
        arrayList.add(imageView3);
        if (listG == null || listG.size() != 3) {
            while (i2 < numArr.length) {
                hc2.a(AppContext.getContext()).load(AppContext.getContext().getDrawable(numArr[i2].intValue())).transform(new gu(10, 2)).into((ImageView) arrayList.get(i2));
                i2++;
            }
        } else {
            while (i2 < listG.size()) {
                hc2.a(AppContext.getContext()).load(k86.p(listG.get(i2))).placeholder(R.drawable.default_portrait).transform(new gu(10, 2)).into((ImageView) arrayList.get(i2));
                i2++;
            }
        }
    }

    public static void f() {
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
    }

    public static List<String> g(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 2) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            int iNextInt = new Random().nextInt(length);
            arrayList.add(jSONArray.optString(iNextInt));
            int i2 = iNextInt - 1;
            if (i2 < 0) {
                i2 = length - 1;
            }
            arrayList.add(jSONArray.optString(i2));
            int i3 = iNextInt + 1;
            if (i3 > length - 1) {
                i3 = 0;
            }
            arrayList.add(jSONArray.optString(i3));
            LogUtil.d("", "MineSeeMe randImgList index1 " + i2 + " index2 " + iNextInt + " index3 " + i3);
            return arrayList;
        } catch (Exception e2) {
            LogUtil.d("", "MineSeeMe randImgList Exception " + e2.toString());
            return null;
        }
    }

    public static void h() {
        if (i == null || r) {
            return;
        }
        r = true;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        q = valueAnimatorOfFloat;
        int i2 = k;
        int i3 = i2 <= 10 ? i2 * 70 : TTAdConstant.STYLE_SIZE_RADIO_3_2;
        if (i2 >= 99) {
            i2 = 99;
        }
        valueAnimatorOfFloat.setDuration(i3);
        q.addUpdateListener(new e(i2));
        q.addListener(new f());
        q.start();
    }

    public static void i() {
        if (b()) {
            if (!n) {
                LogUtil.d("", "MineSeeMeAAA startSeeMeAnim mineTabClick false not allow ");
                return;
            }
            n = false;
            LogUtil.d("", "MineSeeMeAAA startSeeMeAnim readNum " + k);
            ImageView imageView = e;
            if (imageView == null || f == null || g == null || h == null || i == null) {
                return;
            }
            try {
                if (k <= 0) {
                    imageView.setVisibility(8);
                    f.setVisibility(8);
                    g.setVisibility(8);
                    return;
                }
                imageView.setVisibility(0);
                f.setVisibility(0);
                g.setVisibility(0);
                AppContext context = AppContext.getContext();
                ValueAnimator valueAnimator = p;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    p = null;
                }
                ValueAnimator valueAnimator2 = q;
                if (valueAnimator2 != null) {
                    valueAnimator2.cancel();
                    q = null;
                }
                r = false;
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                p = valueAnimatorOfFloat;
                valueAnimatorOfFloat.addListener(new a());
                p.start();
                float fB = me1.b(context, 18);
                int i2 = k;
                if (i2 == 1) {
                    p.setDuration(3000L);
                    e.setVisibility(0);
                    f.setVisibility(8);
                    g.setVisibility(8);
                    h.setVisibility(0);
                    h.setAlpha(0.0f);
                    float fB2 = me1.b(context, 42);
                    e.setAlpha(0.0f);
                    e.setTranslationX(fB2);
                    p.addUpdateListener(new b(context, new float[]{0.0f}, fB));
                    p.start();
                    return;
                }
                if (i2 == 2) {
                    p.setDuration(3000L);
                    e.setVisibility(0);
                    f.setVisibility(0);
                    g.setVisibility(8);
                    h.setVisibility(0);
                    h.setAlpha(0.0f);
                    float fB3 = me1.b(context, 42);
                    float fB4 = me1.b(context, 28);
                    e.setAlpha(0.0f);
                    e.setTranslationX(fB3);
                    f.setAlpha(0.0f);
                    f.setTranslationX(fB4);
                    i.setText("1");
                    p.addUpdateListener(new c(context, new float[]{0.0f, 0.0f}, fB));
                    return;
                }
                p.setDuration(3000L);
                i.setText("1");
                View view = j;
                if (view != null) {
                    view.setVisibility(8);
                }
                e.setVisibility(0);
                f.setVisibility(0);
                g.setVisibility(0);
                h.setVisibility(0);
                h.setAlpha(0.0f);
                float fB5 = me1.b(context, 42);
                float fB6 = me1.b(context, 28);
                float fB7 = me1.b(context, 14);
                e.setAlpha(0.0f);
                e.setTranslationX(fB5);
                f.setAlpha(0.0f);
                f.setTranslationX(fB6);
                g.setAlpha(0.0f);
                g.setTranslationX(fB7);
                p.addUpdateListener(new d(context, new float[]{0.0f, 0.0f, 0.0f}, fB));
            } catch (Exception unused) {
            }
        }
    }

    public static void j(String str) {
        LogUtil.d("", "MineSeeMe updateAdConfig updateValue result = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f19567a = jSONObject.optJSONArray("malePortalHeadImg");
            b = jSONObject.optJSONArray("femalePortalHeadImg");
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            try {
                np3.e.setVisibility(8);
                np3.f.setVisibility(8);
                np3.g.setVisibility(8);
                np3.h.setVisibility(0);
                np3.h.setAlpha(1.0f);
            } catch (Exception unused) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (np3.i != null) {
                LogUtil.d("", "MineSeeMeAAA startRedAnim end  readNum " + np3.k);
                int i = np3.k;
                if (i >= 99) {
                    i = 99;
                }
                np3.i.setText(i + "");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
