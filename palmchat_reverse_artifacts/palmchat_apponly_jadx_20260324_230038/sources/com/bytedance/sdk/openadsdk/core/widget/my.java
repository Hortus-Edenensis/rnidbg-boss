package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class my extends AlertDialog {
    private u b;
    private boolean fx;
    private String nr;
    private Context u;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void nr(String str);

        void u(String str);
    }

    public my(Context context, String str) {
        super(context, q.x(context, "tt_dialog_full"));
        this.u = context;
        this.nr = str;
        this.fx = TextUtils.isEmpty(str);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        u uVar = this.b;
        if (uVar == null) {
            return;
        }
        uVar.nr(this.nr);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(false);
        if (this.u == null) {
            this.u = dw.getContext();
        }
        u();
    }

    private View nr() {
        LinearLayout linearLayout = new LinearLayout(this.u);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-16777216);
        linearLayout.setGravity(17);
        TextView textView = new TextView(this.u);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        textView.setLayoutParams(layoutParams2);
        textView.setText("您要访问的网站存在风险");
        textView.setTextColor(-1);
        textView.setTextSize(20.0f);
        linearLayout.addView(textView);
        int iFx = y.fx(this.u, 10.0f) * 2;
        TextView textView2 = new TextView(this.u);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = iFx;
        layoutParams3.gravity = 17;
        textView2.setLayoutParams(layoutParams3);
        textView2.setText("继续访问可能导致个人隐私泄漏、账号被盗用等危害");
        textView2.setTextColor(-1);
        textView2.setTextSize(15.0f);
        linearLayout.addView(textView2);
        int iFx2 = y.fx(this.u, 25.0f);
        int iFx3 = y.fx(this.u, 8.0f);
        if (!this.fx) {
            Button button = new Button(this.u);
            button.setBackgroundColor(-7829368);
            button.setText("继续访问");
            button.setTextColor(-1);
            button.setPadding(iFx2, iFx3, iFx2, iFx3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(y.fx(this.u, 230.0f), -2);
            layoutParams4.topMargin = iFx;
            layoutParams4.gravity = 17;
            button.setLayoutParams(layoutParams4);
            button.setTextSize(25.0f);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.my.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    my.this.dismiss();
                    if (my.this.b == null) {
                        return;
                    }
                    my.this.b.u(my.this.nr);
                }
            });
            linearLayout.addView(button);
        }
        Button button2 = new Button(this.u);
        button2.setBackgroundColor(SupportMenu.CATEGORY_MASK);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(y.fx(this.u, 230.0f), -2);
        layoutParams5.topMargin = iFx;
        layoutParams5.gravity = 17;
        button2.setLayoutParams(layoutParams5);
        button2.setText("返回安全链接");
        button2.setTextColor(-1);
        button2.setTextSize(25.0f);
        button2.setTypeface(null, 1);
        button2.setPadding(iFx2, iFx3, iFx2, iFx3);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.my.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                my.this.dismiss();
                if (my.this.b == null) {
                    return;
                }
                my.this.b.nr(my.this.nr);
            }
        });
        linearLayout.addView(button2);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    private void u() {
        setContentView(nr());
    }

    public void u(u uVar) {
        this.b = uVar;
    }
}
