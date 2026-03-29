package com.zenmen.palmchat.friendcircle;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import defpackage.e55;
import defpackage.mr;
import defpackage.vl1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class FullTextActivity extends FrameworkBaseActivity implements View.OnLongClickListener {
    public static String u = "full_text";
    public e55 r;
    public TextView s;
    public String q = "";
    public mr.f t = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends mr.f {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            FullTextActivity.this.s.setBackgroundColor(0);
        }
    }

    public final void A1() {
        initToolbar(R$id.toolbar, getResources().getString(R$string.full_text_title), true);
        this.s = (TextView) findViewById(R$id.full_text);
        this.s.setText(vl1.c(this.q, getApplicationContext(), vl1.i));
        this.s.setOnLongClickListener(this);
        this.r = new e55(this);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.layout_full_text);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.q = extras.getString(u);
        }
        A1();
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        view.setBackgroundColor(Color.parseColor("#e4e4e4"));
        this.r.R(view, this.q, true);
        this.r.J(this.t);
        return false;
    }
}
