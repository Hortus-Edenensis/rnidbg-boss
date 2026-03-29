package com.beizi.fusion.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.beizi.fusion.R;
import com.beizi.fusion.tool.aa;
import com.beizi.fusion.tool.am;
import com.beizi.fusion.tool.ap;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class TwistView extends RelativeLayout {
    public static final long DELAY_TIME_TWIST = 100;
    private int A;
    private int B;
    private a C;
    private int D;
    private boolean E;
    private int F;
    private int G;
    private int H;
    private boolean I;
    private Handler J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f4792a;
    private View b;
    private View c;
    private View d;
    private BackArrowView e;
    private BackArrowView f;
    private BackArrowView g;
    private ShakeView h;
    private TextView i;
    private TextView j;
    private int k;
    private ObjectAnimator l;
    private final int m;
    private final int n;
    private final long o;
    private final long p;
    private final long q;
    private String r;
    private String s;
    private String t;
    private long u;
    private Timer v;
    private TimerTask w;
    private Timer x;
    private TimerTask y;
    private int z;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();
    }

    public TwistView(Context context) {
        super(context);
        this.m = 1000;
        this.n = 2000;
        this.o = 500L;
        this.p = 0L;
        this.q = 0L;
        this.r = "#FFFFFFFF";
        this.s = "#99FFFFFF";
        this.t = "#33FFFFFF";
        this.u = 1000L;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.D = 0;
        this.E = true;
        this.F = 3;
        this.G = 1;
        this.H = 95;
        this.I = false;
        this.J = new Handler(Looper.getMainLooper()) { // from class: com.beizi.fusion.widget.TwistView.1
            @Override // android.os.Handler
            @RequiresApi(api = 21)
            @SuppressLint({"LongLogTag"})
            public void handleMessage(@NonNull Message message) {
                super.handleMessage(message);
                try {
                    int i = message.what;
                    if (i == 2000) {
                        TwistView twistView = TwistView.this;
                        twistView.updateStatus(twistView.D);
                    } else if (i == 1000) {
                        TwistView.this.a();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCountAnimation() {
        return (int) (this.u / 100);
    }

    public void cancelArrowTimerTask() {
        try {
            Timer timer = this.x;
            if (timer != null) {
                timer.cancel();
                this.x = null;
            }
            TimerTask timerTask = this.y;
            if (timerTask != null) {
                timerTask.cancel();
                this.y = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cancelTwistTimerTask() {
        try {
            Timer timer = this.v;
            if (timer != null) {
                timer.cancel();
                this.v = null;
            }
            TimerTask timerTask = this.w;
            if (timerTask != null) {
                timerTask.cancel();
                this.w = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroyView() {
        try {
            ShakeView shakeView = this.h;
            if (shakeView != null) {
                shakeView.stopShake();
            }
            cancelTwistTimerTask();
            cancelArrowTimerTask();
            removeHandlerMsg();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = 21)
    public void hideTargetView(View view, long j, int i) {
        try {
            int right = view.getRight();
            int top = (view.getTop() + view.getBottom()) / 2;
            float fMax = Math.max(view.getWidth(), view.getHeight());
            float countAnimation = fMax / getCountAnimation();
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, right, top, fMax - (i * countAnimation), fMax - (countAnimation * (i + 1)));
            animatorCreateCircularReveal.setDuration(j);
            view.clearAnimation();
            animatorCreateCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: com.beizi.fusion.widget.TwistView.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                }
            });
            animatorCreateCircularReveal.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeHandlerMsg() {
        try {
            Handler handler = this.J;
            if (handler != null) {
                handler.removeCallbacks(null);
                this.J = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDescribeText(String str) {
        try {
            TextView textView = this.j;
            if (textView != null) {
                textView.setText(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDurationAnimation(long j) {
        this.u = j;
    }

    public void setJumpClickListener(View.OnClickListener onClickListener) {
        View view = this.d;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setJumpOnTouchListener(View.OnTouchListener onTouchListener) {
        View view = this.d;
        if (view != null) {
            view.setOnTouchListener(onTouchListener);
        }
    }

    public void setMainTitleText(String str) {
        try {
            TextView textView = this.i;
            if (textView != null) {
                textView.setText(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRotationEndCallback(a aVar) {
        this.C = aVar;
    }

    public void setTwistTotalLayoutBg(String str) {
        View view = this.d;
        if (view != null) {
            try {
                am.a(view, str, 0, "", 100);
            } catch (Exception e) {
                aa.b("TwistView", " e : " + e);
            }
        }
    }

    public void setTwistTotalLayoutWidthAndHeight(int i, int i2) {
        try {
            View view = this.d;
            if (view != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                layoutParams.width = i;
                layoutParams.height = i2 - ap.a(getContext(), this.H);
                this.d.setPadding(ap.a(getContext(), 0.0f), ap.a(getContext(), this.F), ap.a(getContext(), 0.0f), ap.a(getContext(), this.F));
                this.d.setLayoutParams(layoutParams);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = 21)
    public void showTargetView(View view, long j, final int i) {
        try {
            float fMax = Math.max(view.getWidth(), view.getHeight()) / getCountAnimation();
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, view.getRight(), (view.getTop() + view.getBottom()) / 2, (i * fMax) + 0.0f, fMax * (i + 1));
            animatorCreateCircularReveal.setDuration(j);
            view.clearAnimation();
            animatorCreateCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: com.beizi.fusion.widget.TwistView.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (TwistView.this.f()) {
                        return;
                    }
                    TwistView.this.getCountAnimation();
                }
            });
            animatorCreateCircularReveal.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startTwistTimerTask() {
        try {
            if (this.v == null) {
                this.v = new Timer();
            }
            if (this.w == null) {
                this.w = new TimerTask() { // from class: com.beizi.fusion.widget.TwistView.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    @RequiresApi(api = 21)
                    public void run() {
                        try {
                            if (TwistView.this.I || TwistView.this.J == null) {
                                return;
                            }
                            Message messageObtainMessage = TwistView.this.J.obtainMessage();
                            messageObtainMessage.what = 2000;
                            TwistView.this.J.sendMessage(messageObtainMessage);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
            }
            this.v.scheduleAtFixedRate(this.w, 0L, 100L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateRollStatus(int i) {
        this.D = i;
    }

    @RequiresApi(api = 21)
    public void updateStatus(int i) {
        if (i == 0) {
            return;
        }
        try {
            int countAnimation = getCountAnimation();
            if (this.B != i) {
                if (this.E) {
                    this.A = 0;
                } else {
                    this.A = countAnimation - this.A;
                }
                this.B = i;
            }
            if (this.A < 0) {
                this.A = 0;
            }
            if (this.A >= countAnimation) {
                if (this.E) {
                    this.A = 0;
                } else {
                    this.A = countAnimation;
                }
            }
            int i2 = this.A;
            if (i2 < 0 || i2 > countAnimation) {
                return;
            }
            a(this.b, this.f4792a, 100L, i, i2);
            this.A++;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b() {
        try {
            View.inflate(getContext(), R.layout.beizi_twist_view, this);
            c();
            d();
            e();
            startTwistTimerTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void c() {
        try {
            this.f4792a = findViewById(R.id.beizi_twist_go_imageview);
            this.d = findViewById(R.id.beizi_twist_shake_total_layout);
            this.b = findViewById(R.id.beizi_twist_total_layout);
            this.c = findViewById(R.id.beizi_twist_right_total_layout);
            this.i = (TextView) findViewById(R.id.beizi_twist_title_text);
            this.j = (TextView) findViewById(R.id.beizi_twist_describe_text);
            this.e = (BackArrowView) findViewById(R.id.beizi_twist_right_first_image);
            this.f = (BackArrowView) findViewById(R.id.beizi_twist_right_second_image);
            this.g = (BackArrowView) findViewById(R.id.beizi_twist_right_third_image);
            ShakeView shakeView = (ShakeView) findViewById(R.id.beizi_twist_top_view);
            this.h = shakeView;
            shakeView.updateTwistRollAnim();
            setTwistTotalLayoutBg("#d9333333");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void d() {
        try {
            ShakeView shakeView = this.h;
            if (shakeView != null) {
                shakeView.startShake();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void e() {
        try {
            if (this.x == null) {
                this.x = new Timer();
            }
            if (this.y == null) {
                this.y = new TimerTask() { // from class: com.beizi.fusion.widget.TwistView.6
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        try {
                            if (TwistView.this.J != null) {
                                TwistView.this.J.sendEmptyMessage(1000);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
            }
            this.x.schedule(this.y, 0L, 500L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        return this.B == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            int i = this.k;
            if (i == 0) {
                BackArrowView backArrowView = this.e;
                if (backArrowView != null) {
                    backArrowView.setViewColor(Color.parseColor(this.r));
                }
                BackArrowView backArrowView2 = this.f;
                if (backArrowView2 != null) {
                    backArrowView2.setViewColor(Color.parseColor(this.s));
                }
                BackArrowView backArrowView3 = this.g;
                if (backArrowView3 != null) {
                    backArrowView3.setViewColor(Color.parseColor(this.t));
                }
            } else if (i == 1) {
                BackArrowView backArrowView4 = this.e;
                if (backArrowView4 != null) {
                    backArrowView4.setViewColor(Color.parseColor(this.t));
                }
                BackArrowView backArrowView5 = this.f;
                if (backArrowView5 != null) {
                    backArrowView5.setViewColor(Color.parseColor(this.r));
                }
                BackArrowView backArrowView6 = this.g;
                if (backArrowView6 != null) {
                    backArrowView6.setViewColor(Color.parseColor(this.s));
                }
            } else if (i == 2) {
                BackArrowView backArrowView7 = this.e;
                if (backArrowView7 != null) {
                    backArrowView7.setViewColor(Color.parseColor(this.s));
                }
                BackArrowView backArrowView8 = this.f;
                if (backArrowView8 != null) {
                    backArrowView8.setViewColor(Color.parseColor(this.t));
                }
                BackArrowView backArrowView9 = this.g;
                if (backArrowView9 != null) {
                    backArrowView9.setViewColor(Color.parseColor(this.r));
                }
            }
            int i2 = this.k;
            if (i2 == 2) {
                this.k = 0;
            } else {
                this.k = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b(View view, float f, long j, boolean z, final int i) {
        try {
            if (z) {
                float width = f - view.getWidth();
                float countAnimation = width / getCountAnimation();
                float f2 = i * countAnimation;
                float f3 = f2 + 0.0f;
                float f4 = countAnimation + f2;
                if (f3 > 0.0f || f4 > 0.0f) {
                    this.E = false;
                }
                if ((f3 >= width || f4 >= width) && i >= getCountAnimation()) {
                    return;
                }
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationX", f3, f4);
                this.l = objectAnimatorOfFloat;
                objectAnimatorOfFloat.setDuration(j);
                this.l.start();
                this.l.addListener(new Animator.AnimatorListener() { // from class: com.beizi.fusion.widget.TwistView.3
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        try {
                            if (i + 1 < TwistView.this.getCountAnimation() || TwistView.this.C == null) {
                                return;
                            }
                            TwistView.this.I = true;
                            TwistView.this.C.a();
                        } catch (Exception e) {
                            e.printStackTrace();
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
                });
                return;
            }
            float width2 = f - view.getWidth();
            float countAnimation2 = width2 / getCountAnimation();
            float f5 = width2 - (i * countAnimation2);
            float f6 = width2 - ((i + 1) * countAnimation2);
            if (f5 >= 0.0f && f6 >= 0.0f) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationX", f5, f6);
                this.l = objectAnimatorOfFloat2;
                objectAnimatorOfFloat2.setDuration(j);
                this.l.start();
                return;
            }
            this.E = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TwistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = 1000;
        this.n = 2000;
        this.o = 500L;
        this.p = 0L;
        this.q = 0L;
        this.r = "#FFFFFFFF";
        this.s = "#99FFFFFF";
        this.t = "#33FFFFFF";
        this.u = 1000L;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.D = 0;
        this.E = true;
        this.F = 3;
        this.G = 1;
        this.H = 95;
        this.I = false;
        this.J = new Handler(Looper.getMainLooper()) { // from class: com.beizi.fusion.widget.TwistView.1
            @Override // android.os.Handler
            @RequiresApi(api = 21)
            @SuppressLint({"LongLogTag"})
            public void handleMessage(@NonNull Message message) {
                super.handleMessage(message);
                try {
                    int i = message.what;
                    if (i == 2000) {
                        TwistView twistView = TwistView.this;
                        twistView.updateStatus(twistView.D);
                    } else if (i == 1000) {
                        TwistView.this.a();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        b();
    }

    @RequiresApi(api = 21)
    private void a(View view, View view2, long j, int i, int i2) {
        if (view != null) {
            try {
                if (view.getVisibility() == 0 && view.getParent() != null && view.hasWindowFocus()) {
                    if (i == 1) {
                        hideTargetView(view, j, i2);
                        a(view2, view.getRight(), j, true, i2);
                    } else if (i == 2 && !this.E) {
                        showTargetView(view, j, i2);
                        a(view2, view.getRight(), j, false, i2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void a(View view, float f, long j, boolean z, int i) {
        try {
            b(view, f, j, z, i);
            a(view, j, z, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(View view, long j, boolean z, int i) {
        try {
            if (z) {
                float countAnimation = 360.0f / getCountAnimation();
                float f = (i * countAnimation) + 0.0f;
                float f2 = countAnimation * (i + 1);
                if (f <= 360.0f && f2 <= 360.0f) {
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, f, f2);
                    objectAnimatorOfFloat.setDuration(j);
                    objectAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.beizi.fusion.widget.TwistView.4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        }
                    });
                    objectAnimatorOfFloat.start();
                }
                return;
            }
            float countAnimation2 = (-360.0f) / getCountAnimation();
            float f3 = (i * countAnimation2) + 0.0f;
            float f4 = countAnimation2 * (i + 1);
            if (f3 >= -360.0f && f4 >= -360.0f) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, f3, f4);
                objectAnimatorOfFloat2.setDuration(j);
                objectAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.beizi.fusion.widget.TwistView.5
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    }
                });
                objectAnimatorOfFloat2.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TwistView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = 1000;
        this.n = 2000;
        this.o = 500L;
        this.p = 0L;
        this.q = 0L;
        this.r = "#FFFFFFFF";
        this.s = "#99FFFFFF";
        this.t = "#33FFFFFF";
        this.u = 1000L;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.D = 0;
        this.E = true;
        this.F = 3;
        this.G = 1;
        this.H = 95;
        this.I = false;
        this.J = new Handler(Looper.getMainLooper()) { // from class: com.beizi.fusion.widget.TwistView.1
            @Override // android.os.Handler
            @RequiresApi(api = 21)
            @SuppressLint({"LongLogTag"})
            public void handleMessage(@NonNull Message message) {
                super.handleMessage(message);
                try {
                    int i2 = message.what;
                    if (i2 == 2000) {
                        TwistView twistView = TwistView.this;
                        twistView.updateStatus(twistView.D);
                    } else if (i2 == 1000) {
                        TwistView.this.a();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        b();
    }
}
