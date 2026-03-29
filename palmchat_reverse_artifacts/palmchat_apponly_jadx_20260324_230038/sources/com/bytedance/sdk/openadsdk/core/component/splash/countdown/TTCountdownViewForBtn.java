package com.bytedance.sdk.openadsdk.core.component.splash.countdown;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.openadsdk.core.y.y;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class TTCountdownViewForBtn extends LinearLayout implements rh.u, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5256a;
    private TextView b;
    private TextView fx;
    private AtomicBoolean iz;
    private int n;
    private Context nr;
    private u pn;
    protected final rh u;
    private int x;

    public TTCountdownViewForBtn(Context context) {
        super(context);
        this.iz = new AtomicBoolean(true);
        this.u = new rh(Looper.getMainLooper(), this);
        this.x = 5;
        this.n = 1;
        this.f5256a = false;
        this.nr = context;
        b();
    }

    private void b() {
        setOrientation(0);
        setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#99333333"));
        int iFx = y.fx(this.nr, 14.0f);
        gradientDrawable.setCornerRadius(iFx);
        int i = iFx * 2;
        gradientDrawable.setSize(i, i);
        setBackground(gradientDrawable);
        this.fx = new TextView(this.nr);
        int iFx2 = y.fx(this.nr, 6.0f);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.fx.setTextColor(-1);
        this.fx.setTextSize(2, 14.0f);
        addView(this.fx, layoutParams);
        View view = new View(this.nr);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.width = y.fx(this.nr, 1.0f);
        layoutParams2.height = y.fx(this.nr, 12.0f);
        layoutParams2.leftMargin = iFx2;
        layoutParams2.rightMargin = iFx2;
        view.setBackgroundColor(-1);
        addView(view, layoutParams2);
        this.b = new TextView(this.nr);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        this.b.setTextColor(-1);
        this.b.setTextSize(2, 14.0f);
        this.b.setText("跳过");
        addView(this.b, layoutParams3);
    }

    private void iz() {
        try {
            if (this.f5256a || this.fx == null) {
                return;
            }
            x();
            int i = this.n;
            if (i < this.x + 1) {
                this.n = i + 1;
                this.u.sendEmptyMessageDelayed(1, 1000L);
            } else {
                u uVar = this.pn;
                if (uVar != null) {
                    uVar.u();
                }
            }
        } catch (Exception unused) {
        }
    }

    private void pn() {
        rh rhVar = this.u;
        if (rhVar != null) {
            rhVar.removeMessages(1);
        }
        this.n = 1;
    }

    private void x() {
        if (this.fx != null) {
            StringBuilder sb = new StringBuilder();
            int i = this.n;
            int i2 = this.x;
            sb.append(i <= i2 ? i2 - i : 0);
            sb.append("s");
            this.fx.setText(sb.toString());
        }
    }

    public void fx() {
        try {
            iz();
        } catch (Throwable unused) {
        }
    }

    public void nr() {
        try {
            rh rhVar = this.u;
            if (rhVar != null) {
                rhVar.removeMessages(1);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        pn();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.iz.set(z);
        if (this.f5256a) {
            return;
        }
        if (this.iz.get()) {
            fx();
        } else {
            nr();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.b
    public void setCountDownTime(int i) {
        this.x = i;
        x();
        pn();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.b
    public void setCountdownListener(u uVar) {
        this.pn = uVar;
        this.iz.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.b
    public void u() {
        if (this.f5256a) {
            return;
        }
        pn();
        iz();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.b
    public void u(boolean z) {
        this.f5256a = z;
        if (z) {
            pn();
        }
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        if (message.what == 1) {
            iz();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.b
    public View getView() {
        return this;
    }
}
