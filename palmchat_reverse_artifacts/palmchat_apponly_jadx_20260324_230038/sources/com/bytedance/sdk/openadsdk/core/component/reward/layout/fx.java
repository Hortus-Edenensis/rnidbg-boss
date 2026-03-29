package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.rh;
import com.bytedance.sdk.openadsdk.core.widget.l;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends nr {
    private TextView bg;
    private TTRatingBar bq;
    private FrameLayout c;
    private FrameLayout dw;
    protected final AtomicBoolean k;
    private TTRoundRectImageView my;
    private TextView o;
    protected int s;
    private TextView sx;

    public fx(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar, boolean z) {
        super(tTBaseVideoActivity, bcVar, z);
        this.s = 0;
        this.k = new AtomicBoolean(false);
    }

    private void b() {
        String strValueOf;
        if (this.sx == null) {
            return;
        }
        int iIz = this.fx.pu() != null ? this.fx.pu().iz() : 6870;
        if (iIz > 10000) {
            strValueOf = (iIz / 10000) + "万";
        } else {
            strValueOf = String.valueOf(iIz);
        }
        this.sx.setText(String.format("%1$s个评分", strValueOf));
    }

    private void fx() {
        if (this.my != null) {
            rh rhVarDd = this.fx.dd();
            if (rhVarDd == null || TextUtils.isEmpty(rhVarDd.u())) {
                q.u((Context) this.nr, "tt_ad_logo_small", (ImageView) this.my);
            } else {
                com.bytedance.sdk.openadsdk.n.nr.u(rhVarDd).to(this.my);
            }
        }
        if (this.o != null) {
            if (this.b != 1 || this.fx.pu() == null || TextUtils.isEmpty(this.fx.pu().fx())) {
                this.o.setText(this.fx.wf());
            } else {
                this.o.setText(this.fx.pu().fx());
            }
        }
    }

    private void iz() {
        if (this.b == 1) {
            TextView textView = this.o;
            if (textView != null) {
                textView.setMaxWidth(y.fx(this.nr, 153.0f));
            }
        } else {
            TextView textView2 = this.o;
            if (textView2 != null) {
                textView2.setMaxWidth(y.fx(this.nr, 404.0f));
            }
        }
        if (this.iz) {
            return;
        }
        y.u((View) this.n, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String n() {
        boolean z;
        boolean zEquals;
        String strU = jp.u(this.nr);
        if (strU == null) {
            strU = "";
        }
        try {
            if (strU.equals(Locale.CHINESE.getLanguage()) || strU.equals(Locale.CHINA.getLanguage())) {
                z = true;
                try {
                    zEquals = strU.equals(Locale.ENGLISH.getLanguage());
                } catch (Throwable unused) {
                    zEquals = false;
                }
            } else {
                if (!strU.equals(Locale.TRADITIONAL_CHINESE.getLanguage())) {
                    z = false;
                }
                zEquals = strU.equals(Locale.ENGLISH.getLanguage());
            }
        } catch (Throwable unused2) {
            z = true;
        }
        String strYb = "下载";
        if (!z && zEquals) {
            strYb = "Install";
        }
        bc bcVar = this.fx;
        if (bcVar == null) {
            return strYb;
        }
        if (!TextUtils.isEmpty(bcVar.yb())) {
            strYb = this.fx.yb();
            if (strYb != null) {
                if (!jp.x(strYb) || strYb.length() <= 2) {
                    if (!jp.x(strYb) && strYb.length() > 7) {
                        if (z) {
                            strYb = u(true);
                        } else if (zEquals) {
                            strYb = u(false);
                        }
                    }
                } else if (z) {
                    strYb = u(true);
                } else if (zEquals) {
                    strYb = u(false);
                }
            }
        } else if (this.fx.qf() != 4) {
            if (z) {
                strYb = "查看";
            } else if (zEquals) {
                strYb = "View";
            }
        }
        if (zEquals && !jp.x(strYb)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bg.getLayoutParams();
            layoutParams.bottomMargin = y.fx(this.nr, 4.0f);
            this.bg.setLayoutParams(layoutParams);
        }
        return strYb;
    }

    private void pn() {
        TextView textView = this.bg;
        if (textView != null) {
            textView.setText(this.fx.za() == 3 ? n() : nr());
        }
    }

    private void x() {
        if (this.fx.za() == 3) {
            int[] iArr = {Color.parseColor("#0070FF")};
            int iFx = y.fx(this.nr, 17.0f);
            int color = Color.parseColor("#80000000");
            l.u((LinearLayout) this.nr.findViewById(2114387898), new l.u().u(iArr[0]).nr(color).u(iArr).fx(iFx).b(0).pn(y.fx(this.nr, 3.0f)));
        }
    }

    public String nr() {
        bc bcVar = this.fx;
        return bcVar == null ? "立即下载" : TextUtils.isEmpty(bcVar.yb()) ? this.fx.qf() != 4 ? "查看详情" : "立即下载" : this.fx.yb();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.nr
    public void u() {
        FrameLayout frameLayout;
        super.u();
        this.n = (RelativeLayout) this.nr.findViewById(2114387649);
        this.my = (TTRoundRectImageView) this.nr.findViewById(2114387793);
        this.o = (TextView) this.nr.findViewById(2114387875);
        this.sx = (TextView) this.nr.findViewById(2114387630);
        this.bg = (TextView) this.nr.findViewById(2114387830);
        TTRatingBar tTRatingBar = (TTRatingBar) this.nr.findViewById(2114387609);
        this.bq = tTRatingBar;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.bq.setStarFillNum(4);
            this.bq.setStarImageWidth(y.fx(this.nr, 15.0f));
            this.bq.setStarImageHeight(y.fx(this.nr, 14.0f));
            this.bq.setStarImagePadding(y.fx(this.nr, 4.0f));
            this.bq.u();
        }
        this.jk = (TextView) this.nr.findViewById(2114387658);
        this.f5236a = (FrameLayout) this.nr.findViewById(2114387642);
        this.dw = (FrameLayout) this.nr.findViewById(2114387964);
        this.c = (FrameLayout) this.nr.findViewById(2114387925);
        y.u(this.jk, this.fx);
        try {
            if (this.b == 2 && this.fx.za() == 1 && (this.bg.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bg.getLayoutParams();
                layoutParams.height = y.fx(this.nr, 55.0f);
                layoutParams.topMargin = y.fx(this.nr, 20.0f);
                this.bg.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
                layoutParams2.bottomMargin = y.fx(this.nr, 12.0f);
                this.n.setLayoutParams(layoutParams2);
            }
        } catch (Throwable unused) {
        }
        if (this.fx.za() == 1 && (frameLayout = this.f5236a) != null && (frameLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f5236a.getLayoutParams();
            int iB = y.b((Context) this.nr);
            layoutParams3.width = iB;
            int i = (iB * 9) / 16;
            layoutParams3.height = i;
            this.f5236a.setLayoutParams(layoutParams3);
            this.s = (y.pn((Context) this.nr) - i) / 2;
        }
        fx();
        b();
        pn();
        iz();
        x();
        t();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.nr
    public void nr(int i) {
        int i2;
        if (this.n == null || (i2 = this.mv) == -1 || i != i2 || this.k.getAndSet(true)) {
            return;
        }
        y.u((View) this.n, 0);
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.65f, 1.0f);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.765f, 0.9f);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(0.88f, 1.0f);
        Keyframe keyframeOfFloat5 = Keyframe.ofFloat(0.95f, 0.95f);
        Keyframe keyframeOfFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.n, PropertyValuesHolder.ofKeyframe("scaleX", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6), PropertyValuesHolder.ofKeyframe("scaleY", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6));
        objectAnimatorOfPropertyValuesHolder.setDuration(1000L);
        objectAnimatorOfPropertyValuesHolder.start();
    }

    private String u(boolean z) {
        bc bcVar = this.fx;
        if (bcVar == null) {
            return null;
        }
        return z ? bcVar.qf() == 4 ? "下载" : "查看" : bcVar.qf() == 4 ? "Install" : "View";
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.nr
    public void u(com.bytedance.sdk.openadsdk.core.nr.nr nrVar, com.bytedance.sdk.openadsdk.core.nr.nr nrVar2) {
        if (this.fx == null) {
            return;
        }
        y.u((View) this.bg, (View.OnClickListener) nrVar, (String) null);
        y.u((View) this.bg, (View.OnTouchListener) nrVar, (String) null);
        u((View.OnTouchListener) nrVar2);
        u((View.OnClickListener) nrVar2);
        if (this.fx.za() == 1) {
            FrameLayout frameLayout = this.dw;
            if (frameLayout != null) {
                y.u((View) frameLayout, 0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dw.getLayoutParams();
                layoutParams.height = this.s;
                this.dw.setLayoutParams(layoutParams);
            }
            FrameLayout frameLayout2 = this.c;
            if (frameLayout2 != null) {
                y.u((View) frameLayout2, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
                layoutParams2.height = this.s;
                this.c.setLayoutParams(layoutParams2);
            }
        }
    }

    private void u(View.OnTouchListener onTouchListener) {
        y.u(this.n, onTouchListener, "TTBaseVideoActivity#mRlDownloadBar");
        y.u(this.o, onTouchListener, "TTBaseVideoActivity#mTvAppName");
        y.u(this.my, onTouchListener, "TTBaseVideoActivity#mIvIcon");
        y.u(this.sx, onTouchListener, "TTBaseVideoActivity#mTvCommentVertical");
        y.u(this.bq, onTouchListener, "TTBaseVideoActivity#mRbScore");
        y.u(this.f5236a, onTouchListener, "TTBaseVideoActivity#mVideoNativeFrame");
        y.u(this.dw, onTouchListener, "TTBaseVideoActivity#mClickUpperNonContentArea");
        y.u(this.c, onTouchListener, "TTBaseVideoActivity#mClickLowerNonContentArea");
    }

    private void u(View.OnClickListener onClickListener) {
        y.u(this.n, onClickListener, "TTBaseVideoActivity#mRlDownloadBar");
        y.u(this.o, onClickListener, "TTBaseVideoActivity#mTvAppName");
        y.u(this.my, onClickListener, "TTBaseVideoActivity#mIvIcon");
        y.u(this.sx, onClickListener, "TTBaseVideoActivity#mTvCommentVertical");
        y.u(this.bq, onClickListener, "TTBaseVideoActivity#mRbScore");
        y.u(this.f5236a, onClickListener, "TTBaseVideoActivity#mVideoNativeFrame");
        y.u(this.dw, onClickListener, "TTBaseVideoActivity#mClickUpperNonContentArea");
        y.u(this.c, onClickListener, "TTBaseVideoActivity#mClickLowerNonContentArea");
    }
}
