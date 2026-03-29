package com.opos.mobad.activity.webview.c;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8510a;
    private LinearLayout b;
    private TextView c = null;
    private com.opos.mobad.activity.webview.b.a d;

    public a(Context context, com.opos.mobad.activity.webview.b.a aVar) {
        this.f8510a = context;
        this.d = aVar;
        b();
    }

    private void b() {
        c();
        d();
    }

    private void c() {
        LinearLayout linearLayout = new LinearLayout(this.f8510a);
        this.b = linearLayout;
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f8510a, 43.33f)));
        com.opos.cmn.module.ui.d.a.a(this.b, com.opos.cmn.an.e.a.a.c(this.f8510a, "o_cmn_biz_ui_web_title_bar_bg.9.png"));
        this.c = new TextView(this.f8510a);
        Drawable drawableC = com.opos.cmn.an.e.a.a.c(this.f8510a, "o_cmn_biz_ui_web_close_bn.png");
        drawableC.setBounds(0, 0, com.opos.cmn.an.h.f.a.a(this.f8510a, 26.0f), com.opos.cmn.an.h.f.a.a(this.f8510a, 24.0f));
        this.c.setCompoundDrawables(drawableC, null, null, null);
        this.c.setGravity(17);
        this.c.setTextSize(1, 15.0f);
        this.c.setTextColor(Color.parseColor("#2ac795"));
        this.c.setCompoundDrawablePadding(com.opos.cmn.an.h.f.a.a(this.f8510a, 2.0f));
        this.c.setText(this.f8510a.getResources().getString(R.string.opos_mob_web_return));
        this.b.addView(this.c, new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.f8510a, 43.33f)));
    }

    private void d() {
        TextView textView = this.c;
        if (textView == null || this.d == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.activity.webview.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.d.c();
            }
        });
    }

    public View a() {
        return this.b;
    }
}
