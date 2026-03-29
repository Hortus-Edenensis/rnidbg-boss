package defpackage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchConfig;
import com.zenmen.palmchat.framework.config.DynamicVo;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$anim;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.databinding.SquareVoiceMatchGuideBubbleBinding;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ti5 {
    public VoiceMatchConfig.EntryBubbleItem e;
    public Fragment j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f20999a = null;
    public SquareVoiceMatchGuideBubbleBinding b = null;
    public int c = 0;
    public Handler d = null;
    public boolean f = false;
    public boolean g = false;
    public boolean h = true;
    public int i = 0;
    public boolean k = true;
    public ValueAnimator l = null;
    public ValueAnimator m = null;
    public Runnable n = new c();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HashMap map = new HashMap();
            map.put("order", String.valueOf(ti5.this.i));
            zn6.h("audioMatch_square_bubble", "click", map);
            if (ti5.this.j == null || ti5.this.j.getActivity() == null) {
                return;
            }
            ap3.v((FrameworkBaseActivity) ti5.this.j.getActivity(), ti5.this.e.url);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21001a;
        public final /* synthetic */ int b;

        public b(int i, int i2) {
            this.f21001a = i;
            this.b = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Float) {
                float fFloatValue = ((Float) animatedValue).floatValue();
                ViewGroup.LayoutParams layoutParams = ti5.this.b.f16249a.getLayoutParams();
                layoutParams.width = (int) (this.f21001a + ((this.b - r1) * fFloatValue));
                layoutParams.height = -2;
                ti5.this.b.f16249a.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ti5.this.s(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends ta1<String> {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements RequestListener<Drawable> {
            public a() {
            }

            @Override // com.bumptech.glide.request.RequestListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                LogUtil.i("SquareGuideBubbleHelper", "onResourceReady ");
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                LogUtil.i("SquareGuideBubbleHelper", "onLoadFailed ");
                return false;
            }
        }

        public d(List<String> list) {
            super(list);
        }

        @Override // defpackage.mp2
        public View a(Context context) {
            return View.inflate(context, R$layout.square_voice_match_guide_item, null);
        }

        @Override // defpackage.mp2
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void d(View view, String str) {
            ImageView imageView = (ImageView) view.findViewById(R$id.icon);
            if (ti5.this.j == null || ti5.this.j.getContext() == null) {
                return;
            }
            kc2<Drawable> kc2VarLoad = hc2.a(ti5.this.j.getContext()).load(k86.p(str));
            int i = R$drawable.default_portrait_new;
            kc2VarLoad.error(i).placeholder(i).listener(new a()).diskCacheStrategy(DiskCacheStrategy.DATA).into(imageView);
        }
    }

    public ti5(Fragment fragment) {
        VoiceMatchConfig.EntryBubble entryBubble;
        int iNextInt = 0;
        this.e = null;
        this.j = fragment;
        DynamicVo dynamicVoA = yi1.a("square_bubble");
        if (dynamicVoA != null && dynamicVoA.isEnable() && !TextUtils.isEmpty(dynamicVoA.getExtra()) && (entryBubble = (VoiceMatchConfig.EntryBubble) az2.a(dynamicVoA.getExtra(), VoiceMatchConfig.EntryBubble.class)) != null) {
            this.e = v4.h() ? entryBubble.female : entryBubble.male;
        }
        if (this.g) {
            this.e = VoiceMatchConfig.EntryBubbleItem.getTestItem();
        }
        VoiceMatchConfig.EntryBubbleItem entryBubbleItem = this.e;
        if (entryBubbleItem != null) {
            String strReplace = entryBubbleItem.subtitle;
            if (strReplace != null && strReplace.contains("x")) {
                iNextInt = new Random().nextInt(8) + 2;
                strReplace = strReplace.replace("x", String.valueOf(iNextInt));
            }
            VoiceMatchConfig.EntryBubbleItem entryBubbleItem2 = this.e;
            entryBubbleItem2.subtitle = strReplace;
            entryBubbleItem2.count = iNextInt;
        }
    }

    public final void f() {
        if (this.f) {
            return;
        }
        View.inflate(this.f20999a.getContext(), R$layout.square_voice_match_guide_bubble, this.f20999a);
        SquareVoiceMatchGuideBubbleBinding squareVoiceMatchGuideBubbleBindingB = SquareVoiceMatchGuideBubbleBinding.b(this.f20999a.findViewById(R$id.root_layout));
        this.b = squareVoiceMatchGuideBubbleBindingB;
        squareVoiceMatchGuideBubbleBindingB.g.setText(this.e.title);
        this.b.f.setText(this.e.subtitle);
        int i = this.e.count;
        if (i > 0) {
            this.b.d.setText(String.valueOf(i));
        }
        List<String> list = this.e.images;
        if (list != null && list.size() > 0) {
            this.b.c.initData(new d(this.e.images), 2500, R$anim.vm_guide_in, R$anim.vm_guide_out);
        }
        this.b.e.setOnClickListener(new a());
        this.d = new Handler();
        this.f = true;
    }

    public final boolean g() {
        boolean zContains = false;
        if (j() && !ap3.a().a()) {
            long jD = ir5.d(ir5.b());
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
            long jK = sPUtil.k(scene, "key_square_bubble_last_show_day_time", 0L);
            List<Integer> list = this.e.day_visits;
            if (list != null && list.size() > 0 && (jD == jK || this.e.frequency_days == 0 || Math.abs(jD - jK) >= ((long) (this.e.frequency_days + 1)) * 86400000)) {
                int iH = sPUtil.h(scene, "key_square_bubble_day_enter_count" + jD, 0) + 1;
                List<Integer> list2 = this.e.day_visits;
                int iIntValue = list2.get(list2.size() - 1).intValue();
                if (iH <= iIntValue) {
                    zContains = this.e.day_visits.contains(Integer.valueOf(iH));
                } else {
                    int i = this.e.day_gap;
                    if (i <= 0 || (iH - iIntValue) % (i + 1) == 0) {
                        zContains = true;
                    }
                }
                if (zContains) {
                    sPUtil.v(scene, "key_square_bubble_last_show_day_time", Long.valueOf(jD));
                }
                sPUtil.v(scene, "key_square_bubble_day_enter_count" + jD, Integer.valueOf(iH));
                this.i = iH;
                LogUtil.i("SquareGuideBubbleHelper", "checkNeedShowOnSelected frequency enter count=" + iH);
            }
        }
        LogUtil.i("SquareGuideBubbleHelper", "checkNeedShowOnSelected needShow=" + zContains);
        return zContains;
    }

    public final ValueAnimator h(boolean z) {
        if (z) {
            if (this.l == null) {
                this.l = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
            }
            return this.l;
        }
        if (this.m == null) {
            this.m = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(300L);
        }
        return this.m;
    }

    public void i(ViewGroup viewGroup) {
        if (j()) {
            this.f20999a = viewGroup;
        }
    }

    public final boolean j() {
        VoiceMatchConfig.EntryBubbleItem entryBubbleItem = this.e;
        return entryBubbleItem != null && entryBubbleItem.isEnable();
    }

    public void k() {
        p();
    }

    public void l() {
        ViewGroup viewGroup = this.f20999a;
        if (viewGroup != null && viewGroup.getVisibility() == 0 && this.f && this.b.e.getVisibility() == 0 && this.h) {
            o();
        }
    }

    public void m(int i) {
        if (this.f) {
            if (i == 0) {
                this.d.removeCallbacksAndMessages(null);
                this.d.postDelayed(this.n, 3000L);
            } else if (this.k) {
                this.d.removeCallbacksAndMessages(null);
                s(false);
            }
        }
    }

    public void n(boolean z) {
        this.h = z;
        if (this.f) {
            q();
        }
    }

    public final void o() {
        if (this.f) {
            this.b.c.startAutoScroll();
        }
    }

    public final void p() {
        if (this.f) {
            this.b.c.stopAutoScroll();
        }
    }

    public final void q() {
        if (!this.h) {
            this.b.e.setVisibility(8);
            p();
            return;
        }
        this.b.e.setVisibility(0);
        o();
        HashMap map = new HashMap();
        map.put("order", String.valueOf(this.i));
        zn6.h("audioMatch_square_bubble", "view", map);
    }

    public void r() {
        if (this.f20999a != null) {
            if (!g()) {
                this.f20999a.setVisibility(8);
                p();
            } else {
                f();
                q();
                this.f20999a.setVisibility(0);
            }
        }
    }

    public final void s(boolean z) {
        LogUtil.i("SquareGuideBubbleHelper", "updateViewState " + z);
        this.k = z;
        int iA = me1.a(com.zenmen.palmchat.c.b(), 50.5f);
        if (this.e.count > 0) {
            this.b.d.setVisibility(z ? 8 : 0);
        }
        this.c = Math.max(this.c, this.b.b.getWidth());
        int iA2 = me1.a(com.zenmen.palmchat.c.b(), 50.5f) + this.c;
        ValueAnimator valueAnimatorH = h(z);
        valueAnimatorH.removeAllUpdateListeners();
        valueAnimatorH.addUpdateListener(new b(iA, iA2));
        valueAnimatorH.cancel();
        valueAnimatorH.start();
    }
}
