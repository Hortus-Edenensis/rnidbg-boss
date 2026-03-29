package com.beizi.fusion.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.fusion.R;
import com.beizi.fusion.tool.aa;
import com.beizi.fusion.tool.ap;
import com.oplus.tblplayer.processor.util.EffectConstants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ScrollClickView extends LinearLayout {
    public static final String DIR_DOWN = "down";
    public static final String DIR_LEFT = "left";
    public static final String DIR_RIGHT = "right";
    public static final String DIR_UP = "up";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ImageView f4783a;
    ImageView b;
    TextView c;
    TextView d;
    private boolean e;
    private String f;
    private String g;
    private int h;
    private int i;
    private String j;
    private int k;
    private int l;
    private ValueAnimator m;
    private Context n;
    private FrameLayout o;
    private FrameLayout p;
    private LinearLayout q;

    public ScrollClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = false;
        this.j = "up";
        this.k = 45;
        this.l = EffectConstants.ROTATION_DEGREES_180;
        this.q = null;
        init(context);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0042 -> B:49:0x0073). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x005d -> B:49:0x0073). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x005f -> B:49:0x0073). Please report as a decompilation issue!!! */
    public void buildRealView() {
        try {
            if ("up".equalsIgnoreCase(this.j)) {
                this.q = (LinearLayout) LayoutInflater.from(this.n).inflate(R.layout.beizi_layout_scrollview_up, this);
            } else if (DIR_DOWN.equalsIgnoreCase(this.j)) {
                this.q = (LinearLayout) LayoutInflater.from(this.n).inflate(R.layout.beizi_layout_scrollview_down, this);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            if ("up".equalsIgnoreCase(this.j)) {
                this.q = (LinearLayout) LayoutInflater.from(this.n.getApplicationContext()).inflate(R.layout.beizi_layout_scrollview_up, this);
            } else if (DIR_DOWN.equalsIgnoreCase(this.j)) {
                this.q = (LinearLayout) LayoutInflater.from(this.n.getApplicationContext()).inflate(R.layout.beizi_layout_scrollview_down, this);
            }
        }
        try {
            LinearLayout linearLayout = this.q;
            if (linearLayout == null) {
                return;
            }
            this.f4783a = (ImageView) linearLayout.findViewById(R.id.hand);
            this.b = (ImageView) this.q.findViewById(R.id.scrollbar);
            this.c = (TextView) this.q.findViewById(R.id.title);
            this.d = (TextView) this.q.findViewById(R.id.details);
            this.o = (FrameLayout) this.q.findViewById(R.id.scroll_container);
            this.p = (FrameLayout) this.q.findViewById(R.id.scrollbar_container);
            this.k = ap.a(this.n, this.k);
            this.l = ap.a(this.n, this.l) + this.k;
            TextView textView = this.c;
            if (textView != null) {
                textView.setText(this.f);
                this.c.setTextSize(2, this.h);
            }
            TextView textView2 = this.d;
            if (textView2 != null) {
                textView2.setText(this.g);
                this.d.setTextSize(2, this.i);
            }
            ImageView imageView = this.f4783a;
            if (imageView == null || this.b == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.b.getLayoutParams();
            if (layoutParams != null) {
                int i = this.k;
                layoutParams.width = i;
                layoutParams.height = i;
                if (layoutParams2 != null) {
                    layoutParams2.height = this.l;
                    layoutParams2.width = (int) (i * 0.55f);
                }
            }
            if (DIR_DOWN.equalsIgnoreCase(this.j)) {
                b();
            } else if ("up".equalsIgnoreCase(this.j)) {
                a();
            } else {
                if ("left".equalsIgnoreCase(this.j)) {
                    return;
                }
                "right".equalsIgnoreCase(this.j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init(Context context) {
        if (this.e) {
            return;
        }
        this.n = context;
        this.e = true;
    }

    public void setDetailText(String str) {
        this.g = str;
    }

    public void setDetailsFont(int i) {
        this.i = i;
    }

    public void setHandWidth(int i) {
        this.k = i;
    }

    public void setScrollDirection(String str) {
        this.j = str;
    }

    public void setScrollbarHeight(int i) {
        this.l = i;
    }

    public void setTitleFont(int i) {
        this.h = i;
    }

    public void setTitleText(String str) {
        this.f = str;
    }

    public void startAnim() {
        StringBuilder sb = new StringBuilder();
        sb.append("startAnim animator != null ? ");
        sb.append(this.m != null);
        aa.b("ScrollClickUtil", sb.toString());
        try {
            ValueAnimator valueAnimator = this.m;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopAnim() {
        try {
            ValueAnimator valueAnimator = this.m;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.m.cancel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b() {
        try {
            this.f4783a.post(new Runnable() { // from class: com.beizi.fusion.widget.ScrollClickView.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ScrollClickView.this.o != null && ScrollClickView.this.p != null) {
                            if (ScrollClickView.this.f4783a.getLayoutParams() == null) {
                                return;
                            }
                            final int i = ScrollClickView.this.f4783a.getLayoutParams().height;
                            ScrollClickView scrollClickView = ScrollClickView.this;
                            scrollClickView.m = ValueAnimator.ofInt(i, scrollClickView.l);
                            ViewGroup.LayoutParams layoutParams = ScrollClickView.this.b.getLayoutParams();
                            aa.b("ScrollClickUtil", "handHeight = " + i);
                            if (layoutParams != null) {
                                layoutParams.height = ScrollClickView.this.l;
                            }
                            ScrollClickView.this.m.setDuration(1000L);
                            ScrollClickView.this.m.setRepeatCount(-1);
                            ScrollClickView.this.m.setRepeatMode(1);
                            ScrollClickView.this.m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.beizi.fusion.widget.ScrollClickView.2.1
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    try {
                                        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                        ViewGroup.LayoutParams layoutParams2 = ScrollClickView.this.o.getLayoutParams();
                                        if (layoutParams2 != null) {
                                            layoutParams2.height = iIntValue;
                                        }
                                        ViewGroup.LayoutParams layoutParams3 = ScrollClickView.this.p.getLayoutParams();
                                        if (layoutParams3 != null) {
                                            layoutParams3.height = iIntValue - (i / 3);
                                        }
                                        ScrollClickView.this.o.requestLayout();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                            return;
                        }
                        aa.b("ScrollClickUtil", "scrollContainer or scrollBarContainer is null , please check !");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a() {
        try {
            this.f4783a.post(new Runnable() { // from class: com.beizi.fusion.widget.ScrollClickView.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ScrollClickView.this.o != null && ScrollClickView.this.p != null) {
                            if (ScrollClickView.this.f4783a.getLayoutParams() == null) {
                                return;
                            }
                            final int i = ScrollClickView.this.f4783a.getLayoutParams().height;
                            ScrollClickView scrollClickView = ScrollClickView.this;
                            scrollClickView.m = ValueAnimator.ofInt(i, scrollClickView.l);
                            aa.b("ScrollClickUtil", "handHeight = " + i + ",scrollbarHeight = " + ScrollClickView.this.l);
                            ViewGroup.LayoutParams layoutParams = ScrollClickView.this.b.getLayoutParams();
                            StringBuilder sb = new StringBuilder();
                            sb.append("handHeight = ");
                            sb.append(i);
                            aa.b("ScrollClickUtil", sb.toString());
                            if (layoutParams != null) {
                                layoutParams.height = ScrollClickView.this.l;
                            }
                            ScrollClickView.this.m.setDuration(1000L);
                            ScrollClickView.this.m.setRepeatCount(-1);
                            ScrollClickView.this.m.setRepeatMode(1);
                            ScrollClickView.this.m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.beizi.fusion.widget.ScrollClickView.1.1
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    try {
                                        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                        ViewGroup.LayoutParams layoutParams2 = ScrollClickView.this.f4783a.getLayoutParams();
                                        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                                            ((FrameLayout.LayoutParams) layoutParams2).topMargin = ScrollClickView.this.l - iIntValue;
                                        }
                                        ViewGroup.LayoutParams layoutParams3 = ScrollClickView.this.p.getLayoutParams();
                                        if (layoutParams3 instanceof FrameLayout.LayoutParams) {
                                            layoutParams3.height = iIntValue - (i / 3);
                                            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
                                            layoutParams4.topMargin = ScrollClickView.this.l - layoutParams4.height;
                                        }
                                        ScrollClickView.this.o.requestLayout();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                            return;
                        }
                        aa.b("ScrollClickUtil", "scrollContainer or scrollBarContainer is null , please check !");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ScrollClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = false;
        this.j = "up";
        this.k = 45;
        this.l = EffectConstants.ROTATION_DEGREES_180;
        this.q = null;
        init(context);
    }

    public ScrollClickView(Context context) {
        super(context);
        this.e = false;
        this.j = "up";
        this.k = 45;
        this.l = EffectConstants.ROTATION_DEGREES_180;
        this.q = null;
        init(context);
    }
}
