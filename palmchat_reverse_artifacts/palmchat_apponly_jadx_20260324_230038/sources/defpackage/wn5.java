package defpackage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.paidservices.superexpose.dialog.SuperExposeDialogLoopItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class wn5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f21758a;
    public ArrayList<String> i;
    public Integer l;
    public String m;
    public FrameLayout b = null;
    public ArrayList<SuperExposeDialogLoopItem> c = new ArrayList<>();
    public int d = 4;
    public float e = 16.0f;
    public ValueAnimator f = null;
    public int g = LiveError.PARSE_JSON;
    public FrameLayout.LayoutParams h = null;
    public boolean j = false;
    public int k = TTAdConstant.STYLE_SIZE_RADIO_3_2;
    public int n = -me1.b(c.b(), 100);
    public int p = 0;
    public Runnable q = new b();
    public Handler o = new Handler();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuperExposeDialogLoopItem f21759a;

        public a(SuperExposeDialogLoopItem superExposeDialogLoopItem) {
            this.f21759a = superExposeDialogLoopItem;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Float f = (Float) valueAnimator.getAnimatedValue();
            float fFloatValue = f.floatValue() <= 5.0f ? 0.0f : f.floatValue() <= 15.0f ? (f.floatValue() - 5.0f) / 10.0f : f.floatValue() < 90.0f ? 1.0f : 1.0f - ((f.floatValue() - 90.0f) / 10.0f);
            float fFloatValue2 = (wn5.this.n * f.floatValue()) / 100.0f;
            if (f.floatValue() >= 50.0f) {
                Math.max(0.5f, 1.0f - ((f.floatValue() - 50.0f) / 50.0f));
            }
            this.f21759a.setAlpha(fFloatValue);
            this.f21759a.setTranslationY(fFloatValue2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (wn5.this.j) {
                return;
            }
            wn5 wn5Var = wn5.this;
            wn5Var.j(wn5Var.l());
            wn5.this.o.postDelayed(wn5.this.q, wn5.this.k);
        }
    }

    public wn5(Context context) {
        this.f21758a = null;
        this.f21758a = context;
    }

    public void h(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.i = arrayList;
    }

    public final void i(SuperExposeDialogLoopItem superExposeDialogLoopItem) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 100.0f);
        valueAnimatorOfFloat.setDuration(5500L);
        valueAnimatorOfFloat.addUpdateListener(new a(superExposeDialogLoopItem));
        valueAnimatorOfFloat.start();
    }

    public final void j(String str) {
        SuperExposeDialogLoopItem superExposeDialogLoopItemK = k();
        LogUtil.e("SuperExpose", "animatorItem" + superExposeDialogLoopItemK + str);
        if (superExposeDialogLoopItemK == null || str == null) {
            return;
        }
        superExposeDialogLoopItemK.setTextData(str);
        superExposeDialogLoopItemK.setAlpha(0.0f);
        superExposeDialogLoopItemK.setTranslationY(0.0f);
        Integer num = this.l;
        if (num != null) {
            superExposeDialogLoopItemK.setTextBackgroundResource(num);
        }
        if (!TextUtils.isEmpty(this.m)) {
            superExposeDialogLoopItemK.setTextColor(this.m);
        }
        i(superExposeDialogLoopItemK);
    }

    public final SuperExposeDialogLoopItem k() {
        for (SuperExposeDialogLoopItem superExposeDialogLoopItem : this.c) {
            if (superExposeDialogLoopItem.getTranslationY() == this.n) {
                return superExposeDialogLoopItem;
            }
        }
        return null;
    }

    public final String l() {
        if (this.i.size() <= 0) {
            return null;
        }
        if (this.p >= this.i.size() || this.p <= 0) {
            this.p = 0;
        }
        String str = this.i.get(this.p);
        this.p++;
        return str;
    }

    public void m(FrameLayout frameLayout) {
        if (frameLayout != null) {
            this.b = frameLayout;
            for (int i = 0; i < this.d; i++) {
                SuperExposeDialogLoopItem superExposeDialogLoopItem = new SuperExposeDialogLoopItem(this.f21758a);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = a46.b(this.f21758a, this.e);
                layoutParams.rightMargin = a46.b(this.f21758a, this.e);
                layoutParams.bottomMargin = a46.b(this.f21758a, 10.0f);
                layoutParams.gravity = 80;
                superExposeDialogLoopItem.setAlpha(0.0f);
                superExposeDialogLoopItem.setTranslationY(this.n);
                this.b.addView(superExposeDialogLoopItem, layoutParams);
                this.c.add(superExposeDialogLoopItem);
            }
        }
    }

    public void n() {
        this.o.postDelayed(this.q, 500L);
    }

    public void o() {
        this.j = true;
        this.o.removeCallbacks(this.q);
    }
}
