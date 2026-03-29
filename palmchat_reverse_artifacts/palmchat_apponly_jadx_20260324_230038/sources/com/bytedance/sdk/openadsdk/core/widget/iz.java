package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Button f5398a;
    private ImageView b;
    private boolean bg;
    private View bq;
    public View.OnClickListener fx;
    private TextView iz;
    private View jk;
    private String k;
    private Context l;
    private String mv;
    private String my;
    private Button n;
    public u nr;
    private int o;
    private TextView pn;
    private String s;
    private Drawable sx;
    private ViewGroup t;
    TTProgressBar u;
    private Button x;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void nr();

        void u();
    }

    public iz(Context context) {
        super(context);
        this.o = -1;
        this.bg = false;
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.l = context;
    }

    private void b() {
        Button button;
        if (this.pn != null) {
            if (TextUtils.isEmpty(this.s)) {
                this.pn.setVisibility(8);
            } else {
                this.pn.setText(this.s);
                this.pn.setVisibility(0);
            }
        }
        if (this.iz != null && !TextUtils.isEmpty(this.mv)) {
            this.iz.setText(this.mv);
        }
        if (this.n != null) {
            if (TextUtils.isEmpty(this.k)) {
                this.n.setText("确定");
            } else {
                this.n.setText(this.k);
            }
            int i = this.o;
            if (i != -1) {
                this.n.setBackgroundColor(i);
            }
        }
        if (this.x != null) {
            if (TextUtils.isEmpty(this.my)) {
                this.x.setText("取消");
            } else {
                this.x.setText(this.my);
            }
        }
        ImageView imageView = this.b;
        if (imageView != null) {
            Drawable drawable = this.sx;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                this.b.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        View view = this.jk;
        if (view == null || (button = this.x) == null) {
            return;
        }
        if (this.bg) {
            view.setVisibility(8);
            this.x.setVisibility(8);
            return;
        }
        button.setVisibility(0);
        View view2 = this.jk;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    private void fx() {
        y.u(this.n, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.iz.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                u uVar = iz.this.nr;
                if (uVar != null) {
                    uVar.u();
                }
            }
        }, "positiveBn");
        y.u(this.x, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.iz.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                u uVar = iz.this.nr;
                if (uVar != null) {
                    uVar.nr();
                }
            }
        }, "negtiveBn");
        y.u(this.f5398a, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.iz.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View.OnClickListener onClickListener = iz.this.fx;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }, "dialog_change_btn");
    }

    private void pn() {
        this.x = (Button) findViewById(2114387829);
        this.n = (Button) findViewById(2114387914);
        this.pn = (TextView) findViewById(2114387802);
        this.iz = (TextView) findViewById(2114387857);
        this.b = (ImageView) findViewById(2114387832);
        this.jk = findViewById(2114387775);
        this.t = (ViewGroup) findViewById(2114387849);
        this.f5398a = (Button) findViewById(2114387749);
    }

    public iz nr(String str) {
        this.s = str;
        return this;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(false);
        View viewNb = this.bq;
        if (viewNb == null) {
            viewNb = com.bytedance.sdk.openadsdk.res.pn.nb(this.l);
        }
        setContentView(viewNb);
        pn();
        b();
        fx();
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            b();
        } catch (Exception unused) {
        }
    }

    public iz u(u uVar) {
        this.nr = uVar;
        return this;
    }

    public void nr() {
        ViewGroup viewGroup = this.t;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public iz u(View.OnClickListener onClickListener) {
        this.fx = onClickListener;
        return this;
    }

    public iz u(String str) {
        this.mv = str;
        return this;
    }

    public iz fx(String str) {
        this.k = str;
        return this;
    }

    public iz u(int i) {
        this.o = i;
        return this;
    }

    public iz u(Drawable drawable) {
        this.sx = drawable;
        return this;
    }

    public iz u(View view) {
        this.bq = view;
        return this;
    }

    public void u() {
        if (this.t == null) {
            return;
        }
        if (this.u == null) {
            try {
                this.u = new TTProgressBar(this.l);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(240, 240);
                layoutParams.gravity = 17;
                this.u.setLayoutParams(layoutParams);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.parseColor("#77000000"));
                gradientDrawable.setCornerRadius(y.fx(this.l, 2.0f));
                this.u.setBackground(gradientDrawable);
                int iFx = y.fx(this.l, 10.0f);
                this.u.setPadding(iFx, iFx, iFx, iFx);
                this.u.setIndeterminateDrawable(q.fx(this.l, "tt_video_loading_progress_bar"));
                this.t.addView(this.u);
            } catch (Exception unused) {
            }
        }
        this.t.setVisibility(0);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    public iz b(String str) {
        this.my = str;
        return this;
    }
}
