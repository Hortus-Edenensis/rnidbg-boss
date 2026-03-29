package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.opensource.svgaplayer.SVGAImageView;
import com.zenmen.giftkit.R$anim;
import com.zenmen.giftkit.R$drawable;
import com.zenmen.giftkit.R$id;
import com.zenmen.giftkit.R$layout;
import com.zenmen.palmchat.giftkit.GiftBizType;
import com.zenmen.palmchat.giftkit.play.GiftPlayVo;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.c15;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"SetTextI18n"})
public class wb2 {
    public static final String R = "wb2";
    public View B;
    public TextView C;
    public View D;
    public TextView E;
    public ImageView F;
    public TextView G;
    public ImageView H;
    public View I;
    public TextView J;
    public View K;
    public TextView L;
    public ImageView M;
    public TextView N;
    public ImageView O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SVGAImageView f21651a;
    public ImageView b;
    public final ViewGroup c;
    public final ViewGroup d;
    public final Context e;
    public View k;
    public TranslateAnimation l;
    public TranslateAnimation m;
    public AlphaAnimation n;
    public AlphaAnimation o;
    public Animation p;
    public Animation q;
    public final GiftBizType r;
    public View s;
    public View t;
    public GiftPlayVo u;
    public GiftPlayVo v;
    public Timer w;
    public Timer x;
    public Timer y;
    public Timer z;
    public final xb2<GiftPlayVo> f = new xb2<>();
    public final xb2<GiftPlayVo> g = new xb2<>();
    public boolean h = false;
    public boolean i = false;
    public boolean j = false;
    public final int[] A = {R$drawable.bg_item_small_gift_play_1, R$drawable.bg_item_small_gift_play_2, R$drawable.bg_item_small_gift_play_3};
    public Runnable P = new d();
    public Runnable Q = new j();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends TimerTask {

        /* JADX INFO: renamed from: wb2$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC1283a implements Runnable {
            public RunnableC1283a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                wb2 wb2Var = wb2.this;
                GiftPlayVo giftPlayVoB = wb2Var.B(wb2Var.u);
                if (giftPlayVoB != null) {
                    wb2.this.U();
                    long j = wb2.this.u.comboNumber;
                    long j2 = giftPlayVoB.comboNumber;
                    wb2.this.u = giftPlayVoB;
                    wb2.this.g.i(giftPlayVoB);
                    if (j2 > j) {
                        if (wb2.this.E != null) {
                            wb2.this.E.setText(giftPlayVoB.comboNumber + " ");
                        }
                        if (wb2.this.D != null) {
                            wb2.this.D.clearAnimation();
                            wb2.this.D.startAnimation(wb2.this.F());
                        }
                    }
                }
            }
        }

        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (wb2.this.s == null || wb2.this.s.getVisibility() != 0) {
                return;
            }
            wb2.this.s.post(new RunnableC1283a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends TimerTask {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                wb2 wb2Var = wb2.this;
                GiftPlayVo giftPlayVoB = wb2Var.B(wb2Var.v);
                if (giftPlayVoB != null) {
                    wb2.this.V();
                    long j = wb2.this.v.comboNumber;
                    long j2 = giftPlayVoB.comboNumber;
                    wb2.this.v = giftPlayVoB;
                    wb2.this.g.i(giftPlayVoB);
                    if (j2 > j) {
                        if (wb2.this.L != null) {
                            wb2.this.L.setText(giftPlayVoB.comboNumber + " ");
                        }
                        if (wb2.this.K != null) {
                            wb2.this.K.clearAnimation();
                            wb2.this.K.startAnimation(wb2.this.F());
                        }
                    }
                }
            }
        }

        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (wb2.this.t == null || wb2.this.t.getVisibility() != 0) {
                return;
            }
            wb2.this.t.post(new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ey1<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftPlayVo f21656a;

        public c(GiftPlayVo giftPlayVo) {
            this.f21656a = giftPlayVo;
        }

        @Override // defpackage.ey1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
            wb2.this.M();
        }

        @Override // defpackage.ey1
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            wb2.this.O(this.f21656a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            wb2.this.b.setImageResource(0);
            wb2.this.b.setVisibility(8);
            wb2.this.M();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Timer f21660a;
        public final /* synthetic */ View b;
        public final /* synthetic */ AlphaAnimation c;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.b.clearAnimation();
                f fVar = f.this;
                AlphaAnimation alphaAnimation = fVar.c;
                if (alphaAnimation != null) {
                    fVar.b.startAnimation(alphaAnimation);
                }
            }
        }

        public f(Timer timer, View view, AlphaAnimation alphaAnimation) {
            this.f21660a = timer;
            this.b = view;
            this.c = alphaAnimation;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            wb2.this.A(this.f21660a);
            View view = this.b;
            if (view == null || view.getVisibility() != 0) {
                return;
            }
            this.b.post(new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (wb2.this.g.g() || wb2.this.t.getVisibility() == 0) {
                return;
            }
            wb2.this.P();
        }
    }

    public wb2(Context context, GiftBizType giftBizType, ViewGroup viewGroup, ViewGroup viewGroup2) {
        this.e = context;
        this.r = giftBizType;
        this.c = viewGroup;
        this.d = viewGroup2;
    }

    public final void A(Timer timer) {
        if (timer != null) {
            timer.cancel();
            timer.purge();
        }
    }

    public final synchronized GiftPlayVo B(GiftPlayVo giftPlayVo) {
        GiftPlayVo giftPlayVoE;
        if (giftPlayVo != null) {
            if (!TextUtils.isEmpty(giftPlayVo.relatedId) && !TextUtils.isEmpty(giftPlayVo.toUserId) && (giftPlayVoE = this.g.e()) != null && !TextUtils.isEmpty(giftPlayVoE.relatedId) && !TextUtils.isEmpty(giftPlayVoE.toUserId) && giftPlayVo.relatedId.equals(giftPlayVoE.relatedId)) {
                if (giftPlayVo.toUserId.equals(giftPlayVoE.toUserId)) {
                    return giftPlayVoE;
                }
            }
        }
        return null;
    }

    public final AlphaAnimation C() {
        if (this.n == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.n = alphaAnimation;
            alphaAnimation.setDuration(200L);
            this.n.setRepeatCount(0);
            this.n.setAnimationListener(new i());
        }
        return this.n;
    }

    public final AlphaAnimation D() {
        if (this.o == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.o = alphaAnimation;
            alphaAnimation.setDuration(200L);
            this.o.setRepeatCount(0);
            this.o.setAnimationListener(new k());
        }
        return this.o;
    }

    @NonNull
    public final TimerTask E(View view, Timer timer, AlphaAnimation alphaAnimation) {
        return new f(timer, view, alphaAnimation);
    }

    public final Animation F() {
        if (this.p == null) {
            this.p = AnimationUtils.loadAnimation(this.e, R$anim.anim_gift_play_gift_count);
        }
        return this.p;
    }

    public final Animation G() {
        if (this.q == null) {
            this.q = AnimationUtils.loadAnimation(this.e, R$anim.anim_gift_play_gift_count);
        }
        return this.q;
    }

    public final TranslateAnimation H() {
        if (this.l == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            this.l = translateAnimation;
            translateAnimation.setDuration(350L);
            this.l.setRepeatCount(0);
            this.l.setAnimationListener(new g());
        }
        return this.l;
    }

    public final TranslateAnimation I() {
        if (this.m == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            this.m = translateAnimation;
            translateAnimation.setDuration(350L);
            this.m.setRepeatCount(0);
            this.m.setAnimationListener(new h());
        }
        return this.m;
    }

    public final void J() {
        View viewInflate = LayoutInflater.from(this.e).inflate(R$layout.layout_small_gift_play, (ViewGroup) null);
        this.k = viewInflate;
        if (GiftBizType.VoiceRoom == this.r) {
            this.s = viewInflate.findViewById(R$id.item_one_voice_room);
            this.t = this.k.findViewById(R$id.item_two_voice_room);
        } else {
            this.s = viewInflate.findViewById(R$id.item_one_chat);
            this.t = this.k.findViewById(R$id.item_two_chat);
        }
        View view = this.s;
        int i2 = R$id.ll_gift_info;
        this.B = view.findViewById(i2);
        View view2 = this.s;
        int i3 = R$id.tv_gift_name;
        this.C = (TextView) view2.findViewById(i3);
        View view3 = this.s;
        int i4 = R$id.ll_gift_count;
        this.D = view3.findViewById(i4);
        View view4 = this.s;
        int i5 = R$id.tv_gift_count;
        this.E = (TextView) view4.findViewById(i5);
        View view5 = this.s;
        int i6 = R$id.iv_user_icon;
        this.F = (ImageView) view5.findViewById(i6);
        View view6 = this.s;
        int i7 = R$id.tv_username;
        this.G = (TextView) view6.findViewById(i7);
        View view7 = this.s;
        int i8 = R$id.iv_gift_icon;
        this.H = (ImageView) view7.findViewById(i8);
        this.I = this.t.findViewById(i2);
        this.J = (TextView) this.t.findViewById(i3);
        this.K = this.t.findViewById(i4);
        this.L = (TextView) this.t.findViewById(i5);
        this.M = (ImageView) this.t.findViewById(i6);
        this.N = (TextView) this.t.findViewById(i7);
        this.O = (ImageView) this.t.findViewById(i8);
        this.s.setVisibility(8);
        this.t.setVisibility(8);
        this.d.addView(this.k, new ViewGroup.LayoutParams(-2, -2));
    }

    public synchronized void K(GiftPlayVo giftPlayVo) {
        L(giftPlayVo, false);
    }

    public final synchronized void L(GiftPlayVo giftPlayVo, boolean z) {
        if (giftPlayVo != null) {
            if (giftPlayVo.itemId > 0 && !TextUtils.isEmpty(giftPlayVo.itemName) && !TextUtils.isEmpty(giftPlayVo.fromUserId) && !TextUtils.isEmpty(giftPlayVo.toUserId)) {
                if (this.e == null) {
                    return;
                }
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    return;
                }
                LogUtil.json(R, az2.c(giftPlayVo), "onlyPlaySmallGift:" + z);
                int i2 = 0;
                if (z) {
                    if (giftPlayVo.priceLevel > 0) {
                        while (true) {
                            if (i2 >= this.g.f()) {
                                i2 = -1;
                                break;
                            }
                            GiftPlayVo giftPlayVoD = this.g.d(i2);
                            if (giftPlayVoD != null && giftPlayVoD.priceLevel < giftPlayVo.priceLevel) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (i2 == -1) {
                            this.g.b(giftPlayVo);
                        } else {
                            this.g.a(i2, giftPlayVo);
                        }
                    } else {
                        this.g.b(giftPlayVo);
                    }
                } else if (giftPlayVo.priceLevel > 0) {
                    while (true) {
                        if (i2 >= this.f.f()) {
                            i2 = -1;
                            break;
                        }
                        GiftPlayVo giftPlayVoD2 = this.f.d(i2);
                        if (giftPlayVoD2 != null && giftPlayVoD2.priceLevel < giftPlayVo.priceLevel) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 == -1) {
                        this.f.b(giftPlayVo);
                    } else {
                        this.f.a(i2, giftPlayVo);
                    }
                } else if (GiftBizType.Chat == this.r) {
                    this.f.b(giftPlayVo);
                } else {
                    this.g.b(giftPlayVo);
                }
                if (!z) {
                    if (!this.h) {
                        M();
                    }
                    if (!this.i || !this.j) {
                        P();
                    }
                } else if (!this.i || !this.j) {
                    P();
                }
            }
        }
    }

    public final synchronized void M() {
        if (this.c == null) {
            return;
        }
        if (this.f21651a == null) {
            SVGAImageView sVGAImageView = new SVGAImageView(this.e);
            this.f21651a = sVGAImageView;
            sVGAImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f21651a.setFillMode(SVGAImageView.FillMode.Clear);
            this.f21651a.setLoops(1);
            this.f21651a.setClearsAfterDetached(true);
            this.c.addView(this.f21651a, new ViewGroup.LayoutParams(-1, -1));
        }
        if (this.b == null) {
            LinearLayout linearLayout = new LinearLayout(this.e);
            linearLayout.setOrientation(1);
            linearLayout.removeAllViews();
            RelativeLayout relativeLayout = new RelativeLayout(this.e);
            relativeLayout.removeAllViews();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            relativeLayout.setLayoutParams(layoutParams);
            linearLayout.addView(relativeLayout);
            View view = new View(this.e);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            linearLayout.addView(view);
            ImageView imageView = new ImageView(this.e);
            this.b = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(me1.b(this.e, 120), me1.b(this.e, 120));
            layoutParams3.alignWithParent = true;
            layoutParams3.addRule(12);
            layoutParams3.addRule(14);
            this.b.setLayoutParams(layoutParams3);
            relativeLayout.addView(this.b);
            this.c.addView(linearLayout, new ViewGroup.LayoutParams(-1, -1));
        }
        GiftPlayVo giftPlayVoH = this.f.h();
        if (giftPlayVoH == null) {
            this.h = false;
            this.f.c();
            return;
        }
        this.h = true;
        if (TextUtils.isEmpty(giftPlayVoH.showIconUrl) || !(giftPlayVoH.showIconUrl.endsWith("png") || giftPlayVoH.showIconUrl.endsWith("jpg") || giftPlayVoH.showIconUrl.endsWith("jpeg"))) {
            String giftAnimationLocalPath = giftPlayVoH.getGiftAnimationLocalPath();
            if (TextUtils.isEmpty(giftAnimationLocalPath) || !new File(giftAnimationLocalPath).exists()) {
                ov.a(giftPlayVoH.itemId, giftPlayVoH.showIconUrl, new c(giftPlayVoH));
            } else {
                O(giftPlayVoH);
            }
        } else {
            N(giftPlayVoH);
        }
    }

    public final void N(GiftPlayVo giftPlayVo) {
        try {
            this.b.setVisibility(0);
            hc2.a(com.zenmen.palmchat.c.b()).load(giftPlayVo.showIconUrl).into(this.b);
            this.b.postDelayed(this.P, 2000L);
            L(giftPlayVo, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            M();
        }
    }

    public final void O(GiftPlayVo giftPlayVo) {
        FileInputStream fileInputStream;
        try {
            try {
                fileInputStream = new FileInputStream(giftPlayVo.getGiftAnimationLocalPath());
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                fileInputStream = null;
            }
            FileInputStream fileInputStream2 = fileInputStream;
            if (fileInputStream2 == null) {
                M();
            } else {
                c15.INSTANCE.b().q(fileInputStream2, String.valueOf(giftPlayVo.itemId), new e(), true, null, giftPlayVo.itemName);
                L(giftPlayVo, true);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            M();
        }
    }

    public final synchronized void P() {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
            P();
        }
        if (this.d == null) {
            return;
        }
        if (this.k == null) {
            J();
        }
        GiftPlayVo giftPlayVoE = this.g.e();
        GiftPlayVo giftPlayVo = this.u;
        if (giftPlayVo == null || TextUtils.isEmpty(giftPlayVo.relatedId) || TextUtils.isEmpty(this.u.toUserId) || giftPlayVoE == null || !this.u.relatedId.equals(giftPlayVoE.relatedId) || !this.u.toUserId.equals(giftPlayVoE.toUserId)) {
            GiftPlayVo giftPlayVo2 = this.v;
            if (giftPlayVo2 == null || TextUtils.isEmpty(giftPlayVo2.relatedId) || TextUtils.isEmpty(this.v.toUserId) || giftPlayVoE == null || !this.v.relatedId.equals(giftPlayVoE.relatedId) || !this.v.toUserId.equals(giftPlayVoE.toUserId)) {
                GiftPlayVo giftPlayVoH = this.g.h();
                if (giftPlayVoH == null) {
                    this.g.c();
                    if (this.s.getVisibility() != 0) {
                        this.i = false;
                        this.u = null;
                        this.s.setVisibility(8);
                    }
                    if (this.t.getVisibility() != 0) {
                        this.j = false;
                        this.v = null;
                        this.t.setVisibility(8);
                    }
                    return;
                }
                if (this.s.getVisibility() != 0) {
                    this.i = true;
                    this.u = giftPlayVoH;
                    R(giftPlayVoH, this.B, this.C, this.D, this.E, this.F, this.G, this.H);
                    this.s.clearAnimation();
                    this.s.startAnimation(H());
                    this.s.setVisibility(0);
                } else if (this.t.getVisibility() != 0) {
                    this.j = true;
                    this.v = giftPlayVoH;
                    R(giftPlayVoH, this.I, this.J, this.K, this.L, this.M, this.N, this.O);
                    this.t.clearAnimation();
                    this.t.startAnimation(I());
                    this.t.setVisibility(0);
                }
            }
        }
    }

    public void Q() {
        this.f.c();
        this.g.c();
        View view = this.s;
        if (view != null) {
            view.removeCallbacks(this.Q);
        }
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.removeCallbacks(this.P);
        }
        A(this.w);
        A(this.x);
        A(this.y);
        A(this.z);
        View view2 = this.s;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.t;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        SVGAImageView sVGAImageView = this.f21651a;
        if (sVGAImageView == null || !sVGAImageView.getIsAnimating()) {
            return;
        }
        this.f21651a.stopAnimation();
    }

    public final void R(GiftPlayVo giftPlayVo, View view, TextView textView, View view2, TextView textView2, ImageView imageView, TextView textView3, ImageView imageView2) {
        try {
            GiftBizType giftBizType = GiftBizType.VoiceRoom;
            if (giftBizType == this.r) {
                view.setBackgroundResource(this.A[new Random().nextInt(this.A.length)]);
            }
            GiftBizType giftBizType2 = this.r;
            if (giftBizType == giftBizType2) {
                textView.setText("送给 " + giftPlayVo.toUserName + " " + giftPlayVo.itemName);
            } else if (GiftBizType.Chat != giftBizType2) {
                textView.setText("送你" + giftPlayVo.itemName);
            } else if (giftPlayVo.giftMessageType == 0) {
                textView.setText("收到 " + giftPlayVo.itemName);
            } else {
                textView.setText("送出 " + giftPlayVo.itemName);
            }
            if (giftPlayVo.itemCount > 0 || giftPlayVo.comboNumber > 1) {
                view2.setVisibility(0);
                long j2 = giftPlayVo.comboNumber;
                if (j2 <= 1) {
                    j2 = giftPlayVo.itemCount;
                }
                textView2.setText(j2 + " ");
            } else {
                view2.setVisibility(8);
            }
            textView3.setText(giftPlayVo.fromUserName);
            hc2.a(com.zenmen.palmchat.c.b()).load(giftPlayVo.fromUserAvatarUrl).error(R$drawable.default_portrait).into(imageView);
            hc2.a(com.zenmen.palmchat.c.b()).load(giftPlayVo.iconUrl).into(imageView2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final synchronized void S() {
        A(this.x);
        Timer timer = new Timer();
        this.x = timer;
        timer.schedule(new a(), 200L, 200L);
    }

    public final synchronized void T() {
        A(this.z);
        Timer timer = new Timer();
        this.z = timer;
        timer.schedule(new b(), 200L, 200L);
    }

    public final synchronized void U() {
        A(this.w);
        Timer timer = new Timer();
        this.w = timer;
        timer.schedule(E(this.s, this.x, C()), 2500L);
    }

    public final synchronized void V() {
        A(this.y);
        Timer timer = new Timer();
        this.y = timer;
        timer.schedule(E(this.t, this.z, D()), 2500L);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Animation.AnimationListener {
        public g() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (wb2.this.D != null) {
                wb2.this.D.clearAnimation();
                wb2.this.D.startAnimation(wb2.this.F());
            }
            wb2.this.U();
            wb2.this.S();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Animation.AnimationListener {
        public h() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (wb2.this.K != null) {
                wb2.this.K.clearAnimation();
                wb2.this.K.startAnimation(wb2.this.G());
            }
            wb2.this.V();
            wb2.this.T();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Animation.AnimationListener {
        public i() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            wb2.this.u = null;
            wb2.this.s.setVisibility(8);
            wb2.this.P();
            if (wb2.this.g.g() || wb2.this.t.getVisibility() == 0) {
                return;
            }
            wb2.this.s.postDelayed(wb2.this.Q, 500L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Animation.AnimationListener {
        public k() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            wb2.this.v = null;
            wb2.this.t.setVisibility(8);
            wb2.this.P();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements c15.d {
        public e() {
        }

        @Override // c15.d
        public void onComplete(@NonNull m15 m15Var) {
            LogUtil.d(wb2.R, "load onComplete");
            wb2.this.f21651a.setVideoItem(m15Var);
            wb2.this.f21651a.startAnimation();
            wb2.this.f21651a.setCallback(new a());
        }

        @Override // c15.d
        public void onError() {
            LogUtil.d(wb2.R, "load onError");
            wb2.this.M();
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements v05 {
            public a() {
            }

            @Override // defpackage.v05
            public void a() {
                LogUtil.d(wb2.R, "onFinished");
                wb2.this.M();
            }

            @Override // defpackage.v05
            public void c() {
                LogUtil.d(wb2.R, "onRepeat");
            }

            @Override // defpackage.v05
            public void onPause() {
                LogUtil.d(wb2.R, "onPause");
            }

            @Override // defpackage.v05
            public void b(int i, double d) {
            }
        }
    }
}
