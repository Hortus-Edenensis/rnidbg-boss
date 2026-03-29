package com.zenmen.palmchat.refund;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.av4;
import defpackage.l50;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class RefundDialogActivity extends FrameworkBaseActivity {
    public Context q;
    public View r = null;
    public View s = null;
    public View t = null;
    public View u = null;
    public View v = null;
    public View w = null;
    public View x = null;
    public View y = null;
    public View z = null;
    public TextView A = null;
    public ImageView B = null;
    public TextView C = null;
    public View E = null;
    public RefundData F = null;
    public View G = null;
    public int H = 0;
    public ArrayList<ValueAnimator> I = new ArrayList<>();
    public Timer J = null;
    public final int K = 1;
    public int L = 0;
    public boolean M = false;
    public Handler N = new j(Looper.getMainLooper());
    public float O = 0.2f;
    public float P = av4.d(com.zenmen.palmchat.c.b(), 30.0f);
    public float Q = 0.3f;
    public float R = 1.5f;
    public float S = 2.5f;
    public boolean T = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f = RefundDialogActivity.this.Q + fFloatValue;
            RefundDialogActivity.this.r.setScaleX(f);
            RefundDialogActivity.this.r.setScaleY(f);
            RefundDialogActivity.this.u.setScaleX(RefundDialogActivity.this.S * fFloatValue);
            RefundDialogActivity.this.u.setScaleY(RefundDialogActivity.this.R * fFloatValue);
            RefundDialogActivity.this.u.setAlpha(fFloatValue * 0.9f);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            RefundDialogActivity.this.r.setScaleX(RefundDialogActivity.this.Q + 1.0f);
            RefundDialogActivity.this.r.setScaleY(RefundDialogActivity.this.Q + 1.0f);
            RefundDialogActivity.this.u.setScaleX(RefundDialogActivity.this.S);
            RefundDialogActivity.this.u.setScaleY(RefundDialogActivity.this.R);
            RefundDialogActivity.this.u.setAlpha(1.0f);
            RefundDialogActivity.this.r.setVisibility(8);
            RefundDialogActivity.this.v.setVisibility(0);
            RefundDialogActivity.this.v.setScaleX(1.5f);
            RefundDialogActivity.this.v.setScaleY(1.5f);
            RefundDialogActivity.this.e2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f = 1.5f - (fFloatValue * 0.5f);
            RefundDialogActivity.this.u.setAlpha(1.0f - fFloatValue);
            RefundDialogActivity.this.u.setScaleX(RefundDialogActivity.this.S - fFloatValue);
            RefundDialogActivity.this.u.setScaleY(RefundDialogActivity.this.R - fFloatValue);
            RefundDialogActivity.this.v.setScaleX(f);
            RefundDialogActivity.this.v.setScaleY(f);
            if (fFloatValue < 0.5f || RefundDialogActivity.this.y.getVisibility() != 8) {
                return;
            }
            RefundDialogActivity refundDialogActivity = RefundDialogActivity.this;
            refundDialogActivity.f2(refundDialogActivity.y, true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            RefundDialogActivity.this.u.setAlpha(0.0f);
            RefundDialogActivity.this.v.setScaleX(1.0f);
            RefundDialogActivity.this.v.setScaleY(1.0f);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f15069a;
        public final /* synthetic */ boolean b;

        public e(View view, boolean z) {
            this.f15069a = view;
            this.b = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f = (0.6f * fFloatValue) + 0.5f;
            this.f15069a.setScaleX(f);
            this.f15069a.setScaleY(f);
            this.f15069a.setAlpha(1.0f - fFloatValue);
            if (this.b && fFloatValue >= 0.5f && RefundDialogActivity.this.z.getVisibility() == 8) {
                RefundDialogActivity refundDialogActivity = RefundDialogActivity.this;
                refundDialogActivity.f2(refundDialogActivity.z, false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a() || RefundDialogActivity.this.T) {
                return;
            }
            RefundDialogActivity.this.T = true;
            RefundDialogActivity.this.d2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            RefundDialogActivity.this.V1("button");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            LogUtil.d("RefundManager", "RefundDialogActivity clockView onClick");
            RefundDialogActivity.this.V1("close");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends TimerTask {
        public i() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            RefundDialogActivity.this.N.sendMessage(messageObtain);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends Handler {
        public j(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what != 1) {
                return;
            }
            RefundDialogActivity refundDialogActivity = RefundDialogActivity.this;
            int i = refundDialogActivity.L - 1;
            refundDialogActivity.L = i;
            if (i < 0) {
                refundDialogActivity.V1("close");
            } else if (refundDialogActivity.A != null) {
                RefundDialogActivity.this.A.setText(av4.f(RefundDialogActivity.this.L));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements ValueAnimator.AnimatorUpdateListener {
        public k() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            RefundDialogActivity.this.G.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l extends AnimatorListenerAdapter {
        public l() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            RefundDialogActivity.this.r.setVisibility(0);
            RefundDialogActivity.this.r.setScaleX(RefundDialogActivity.this.O);
            RefundDialogActivity.this.r.setScaleY(RefundDialogActivity.this.O);
            RefundDialogActivity.this.a2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f15077a;

        public m(float f) {
            this.f15077a = f;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float fFloatValue = (((Float) valueAnimator.getAnimatedValue()).floatValue() * this.f15077a) + RefundDialogActivity.this.O;
            RefundDialogActivity.this.r.setScaleX(fFloatValue);
            RefundDialogActivity.this.r.setScaleY(fFloatValue);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n extends AnimatorListenerAdapter {
        public n() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            RefundDialogActivity.this.r.setScaleX(1.0f);
            RefundDialogActivity.this.r.setScaleY(1.0f);
            RefundDialogActivity.this.b2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements ValueAnimator.AnimatorUpdateListener {
        public o() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float fFloatValue = 1.0f - (((Float) valueAnimator.getAnimatedValue()).floatValue() * RefundDialogActivity.this.Q);
            RefundDialogActivity.this.r.setScaleX(fFloatValue);
            RefundDialogActivity.this.r.setScaleY(fFloatValue);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p extends AnimatorListenerAdapter {
        public p() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            RefundDialogActivity.this.r.setScaleX(1.0f - RefundDialogActivity.this.Q);
            RefundDialogActivity.this.r.setScaleY(1.0f - RefundDialogActivity.this.Q);
            RefundDialogActivity.this.r.setTranslationY(0.0f);
            RefundDialogActivity.this.c2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements ValueAnimator.AnimatorUpdateListener {
        public q() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float fFloatValue = (1.0f - RefundDialogActivity.this.Q) + (((Float) valueAnimator.getAnimatedValue()).floatValue() * RefundDialogActivity.this.Q);
            RefundDialogActivity.this.r.setScaleX(fFloatValue);
            RefundDialogActivity.this.r.setScaleY(fFloatValue);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r extends AnimatorListenerAdapter {
        public r() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            RefundDialogActivity.this.r.setScaleX(1.0f);
            RefundDialogActivity.this.r.setScaleY(1.0f);
        }
    }

    public final void V1(String str) {
        finish();
        av4.c(this.H, str);
    }

    public final void W1() {
        LogUtil.d("RefundManager", "RefundDialogActivity initTimer mAllTimer " + this.J);
        if (this.J == null) {
            Timer timer = new Timer();
            this.J = timer;
            timer.schedule(new i(), 1000L, 1000L);
        }
    }

    public final void X1() {
        this.G = findViewById(R$id.refund_dialog_all_bg);
        View viewFindViewById = findViewById(R$id.refund_redpkg_dialog_red_1_all);
        this.r = viewFindViewById;
        viewFindViewById.setOnClickListener(new f());
        this.s = findViewById(R$id.refund_redpkg_dialog_red_xx_img);
        this.s = findViewById(R$id.refund_redpkg_dialog_red_rr_img);
        this.u = findViewById(R$id.refund_redpkg_dialog_red_j_all);
        this.v = findViewById(R$id.refund_redpkg_dialog_red_2_all);
        this.w = findViewById(R$id.refund_redpkg_dialog_red_xx1_img);
        this.x = findViewById(R$id.refund_redpkg_dialog_red_xx2_img);
        this.y = findViewById(R$id.refund_redpkg_dialog_red_quan_img);
        this.z = findViewById(R$id.refund_redpkg_dialog_red_quan_img2);
        this.A = (TextView) findViewById(R$id.refund_redpkg_dialog_red_time);
        ImageView imageView = (ImageView) findViewById(R$id.refund_redpkg_dialog_red_2_button_img);
        this.B = imageView;
        imageView.setOnClickListener(new g());
        this.C = (TextView) findViewById(R$id.refund_redpkg_dialog_red_2_desc);
        View viewFindViewById2 = findViewById(R$id.refund_redpkg_dialog_red_2_close);
        this.E = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new h());
        this.G.setAlpha(0.0f);
        this.r.setVisibility(8);
        this.v.setVisibility(8);
        this.y.setVisibility(8);
        this.z.setVisibility(8);
        this.u.setAlpha(0.0f);
    }

    public final void Y1() {
        int i2 = this.H;
        if (i2 == 1) {
            this.B.setImageDrawable(this.q.getResources().getDrawable(R$drawable.refund_redpkg_dialog_red_2_button));
        } else if (i2 == 2) {
            this.B.setImageDrawable(this.q.getResources().getDrawable(R$drawable.refund_redpkg_dialog_red_2_button_super));
        }
        if (!TextUtils.isEmpty(this.F.text)) {
            this.C.setText(Html.fromHtml(this.F.text));
        }
        if (this.F.expires > 0) {
            LogUtil.d("RefundManager", "startDialogAnim4 setData mData.startTime " + this.F.expires);
            int i3 = this.F.expires;
            this.L = i3;
            this.A.setText(av4.f(i3));
            W1();
        }
    }

    public final void Z1() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.I.add(valueAnimatorOfFloat);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.addUpdateListener(new k());
        valueAnimatorOfFloat.addListener(new l());
        valueAnimatorOfFloat.start();
    }

    public final void a2() {
        float f2 = 1.0f - this.O;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.I.add(valueAnimatorOfFloat);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.addUpdateListener(new m(f2));
        valueAnimatorOfFloat.addListener(new n());
        valueAnimatorOfFloat.start();
    }

    public final void b2() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.I.add(valueAnimatorOfFloat);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.addUpdateListener(new o());
        valueAnimatorOfFloat.addListener(new p());
        valueAnimatorOfFloat.start();
    }

    public final void c2() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.I.add(valueAnimatorOfFloat);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.addUpdateListener(new q());
        valueAnimatorOfFloat.addListener(new r());
        valueAnimatorOfFloat.start();
    }

    public final void d2() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.I.add(valueAnimatorOfFloat);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.addUpdateListener(new a());
        valueAnimatorOfFloat.addListener(new b());
        valueAnimatorOfFloat.start();
    }

    public final void e2() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.I.add(valueAnimatorOfFloat);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.addUpdateListener(new c());
        valueAnimatorOfFloat.addListener(new d());
        valueAnimatorOfFloat.start();
    }

    public final void f2(View view, boolean z) {
        view.setVisibility(0);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.I.add(valueAnimatorOfFloat);
        valueAnimatorOfFloat.setDuration(2000L);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.addUpdateListener(new e(view, z));
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.start();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.dialog_refund_redpkg);
        this.q = getApplicationContext();
        this.H = 1;
        this.F = new RefundData();
        if (getIntent() != null) {
            this.H = getIntent().getIntExtra("from", 1);
            String stringExtra = getIntent().getStringExtra("data");
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    this.F.expires = jSONObject.optInt(RefundData.TAG_CLOCK);
                    this.F.status = jSONObject.optInt("status");
                    this.F.text = jSONObject.optString("text");
                } catch (Exception unused) {
                }
            }
            this.M = getIntent().getBooleanExtra("allowAnim", false);
        }
        LogUtil.d("RefundManager", "RefundDialogActivity start mFrom " + this.H + " refundData:" + this.F.toString() + " allowAnim " + this.M);
        X1();
        if (this.M) {
            Z1();
        } else {
            this.G.setAlpha(1.0f);
            f2(this.y, true);
            this.v.setVisibility(0);
        }
        Y1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        LogUtil.d("RefundManager", "RefundDialogActivity onDestroy");
        for (int i2 = 0; i2 < this.I.size(); i2++) {
            this.I.get(i2).cancel();
        }
        this.I.clear();
        Timer timer = this.J;
        if (timer != null) {
            timer.cancel();
            this.J = null;
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }
}
