package com.zenmen.square.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import defpackage.ai5;
import defpackage.gr2;
import defpackage.je1;
import defpackage.l50;
import defpackage.n5;
import defpackage.tk3;
import defpackage.zn6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareFirstPublicActivity extends FrameworkBaseActivity {
    public je1 q;
    public TextView r;
    public TextView s;
    public TextView t;
    public ImageView u;
    public boolean v = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareFirstPublicActivity.this.D1();
            zn6.c("pagephotoupload_upright_skip", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            SquareFirstPublicActivity.this.F1();
        }
    }

    public final void C1() {
        je1.a aVarQ = new je1.a().s(false).t(true).u(true).q(Bitmap.Config.RGB_565);
        int i = R$drawable.icon_square_first_pub_upload;
        this.q = aVarQ.z(i).A(i).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();
        this.u = (ImageView) findViewById(R$id.upload_pic);
        String pageuploadpic = ai5.k().j().getGuideInfo().getPageuploadpic();
        LogUtil.d("SquareFirstPublicActivity", "picUrl:" + pageuploadpic);
        if (TextUtils.isEmpty(pageuploadpic)) {
            gr2.j().e(i, this.u, this.q);
        } else {
            gr2.j().h(pageuploadpic, this.u, this.q);
        }
        this.s = (TextView) findViewById(R$id.upload_intro);
        String pageuploadintro2 = ai5.k().j().getGuideInfo().getPageuploadintro2();
        if (!TextUtils.isEmpty(pageuploadintro2)) {
            this.s.setText(pageuploadintro2);
        }
        this.t = (TextView) findViewById(R$id.upload_btn);
        String pageuploadbutton = ai5.k().j().getGuideInfo().getPageuploadbutton();
        if (!TextUtils.isEmpty(pageuploadbutton)) {
            this.t.setText(pageuploadbutton);
        }
        this.t.setOnClickListener(new b());
        zn6.c("newpagephotoupload", "view");
    }

    public final void D1() {
        startActivity(n5.b(this, null));
        finish();
    }

    public final void E1() {
        this.v = getIntent().getBooleanExtra("key_goto_square", false);
    }

    public final void F1() {
        tk3.j(this, 1);
        zn6.c("newpagephotoupload_center_upload", "click");
    }

    public final void initActionBar() {
        TextView textView = (TextView) initToolbar(R$id.toolbar, "", false).findViewById(R$id.jump);
        this.r = textView;
        textView.setOnClickListener(new a());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i != 1 && i == 2) {
            D1();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.square_layout_activity_first_public);
        E1();
        initActionBar();
        C1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }
}
