package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk extends AlertDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5399a;
    private Button b;
    private Button fx;
    private String iz;
    private Drawable jk;
    private String n;
    private TextView nr;
    private Context pn;
    private u t;
    private TextView u;
    private String x;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void onClickNo(Dialog dialog);

        void onClickYes(Dialog dialog);
    }

    public jk(Context context) {
        super(context, q.x(context, "tt_custom_dialog"));
        this.pn = context;
    }

    private void nr() {
        TextView textView = this.u;
        if (textView != null) {
            textView.setText(this.iz);
            Drawable drawable = this.jk;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.jk.getIntrinsicHeight();
                int iFx = y.fx(this.pn, 45.0f);
                if (intrinsicWidth > iFx || intrinsicWidth < iFx) {
                    intrinsicWidth = iFx;
                }
                if (intrinsicHeight > iFx || intrinsicHeight < iFx) {
                    intrinsicHeight = iFx;
                }
                this.jk.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                this.u.setCompoundDrawables(this.jk, null, null, null);
                this.u.setCompoundDrawablePadding(y.fx(this.pn, 10.0f));
            }
        }
        TextView textView2 = this.nr;
        if (textView2 != null) {
            textView2.setText(this.x);
        }
        Button button = this.fx;
        if (button != null) {
            button.setText(this.n);
        }
        Button button2 = this.b;
        if (button2 != null) {
            button2.setText(this.f5399a);
        }
    }

    public jk b(String str) {
        this.f5399a = str;
        return this;
    }

    public jk fx(String str) {
        this.n = str;
        return this;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.pn.lf(this.pn));
        setCanceledOnTouchOutside(true);
        u();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        nr();
    }

    private void u() {
        this.u = (TextView) findViewById(2114387852);
        this.nr = (TextView) findViewById(2114387654);
        this.fx = (Button) findViewById(2114387751);
        this.b = (Button) findViewById(2114387889);
        this.fx.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.jk.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                jk.this.dismiss();
                if (jk.this.t != null) {
                    jk.this.t.onClickYes(jk.this);
                }
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.jk.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                jk.this.dismiss();
                if (jk.this.t != null) {
                    jk.this.t.onClickNo(jk.this);
                }
            }
        });
    }

    public jk u(String str) {
        this.iz = str;
        return this;
    }

    public jk u(Drawable drawable) {
        this.jk = drawable;
        return this;
    }

    public jk u(u uVar) {
        this.t = uVar;
        return this;
    }

    public jk u(DialogInterface.OnCancelListener onCancelListener) {
        setOnCancelListener(onCancelListener);
        return this;
    }

    public jk nr(String str) {
        this.x = str;
        return this;
    }
}
