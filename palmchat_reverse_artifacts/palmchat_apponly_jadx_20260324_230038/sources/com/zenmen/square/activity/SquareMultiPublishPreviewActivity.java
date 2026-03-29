package com.zenmen.square.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.photoview.FeedBean;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.adapter.MultiPublishPreviewFragmentAdapter;
import defpackage.ds0;
import defpackage.g22;
import defpackage.me1;
import defpackage.px5;
import defpackage.sd3;
import defpackage.yy3;
import defpackage.zn6;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareMultiPublishPreviewActivity extends FrameworkBaseActivity {
    public ViewPager q;
    public int r;
    public int s;
    public ImageView t;
    public TextView u;
    public RelativeLayout v;
    public MultiPublishPreviewFragmentAdapter w;
    public ArrayList<FeedBean> x = new ArrayList<>();
    public com.zenmen.palmchat.photoview.a y;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareMultiPublishPreviewActivity.this.L1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SquareMultiPublishPreviewActivity.this.x.size() == 0) {
                return;
            }
            SquareMultiPublishPreviewActivity squareMultiPublishPreviewActivity = SquareMultiPublishPreviewActivity.this;
            squareMultiPublishPreviewActivity.N1(squareMultiPublishPreviewActivity.s);
            zn6.c("pagemultipleedit_preview_cancel", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f16126a;

        public d(int i) {
            this.f16126a = i;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            SquareMultiPublishPreviewActivity.this.G1(this.f16126a);
        }
    }

    public final void G1(int i) {
        if (i >= this.x.size()) {
            return;
        }
        this.x.remove(i);
        MultiPublishPreviewFragmentAdapter multiPublishPreviewFragmentAdapter = new MultiPublishPreviewFragmentAdapter(getSupportFragmentManager(), this.x);
        this.w = multiPublishPreviewFragmentAdapter;
        this.q.setAdapter(multiPublishPreviewFragmentAdapter);
        if (this.x.size() != i) {
            this.q.setCurrentItem(i, true);
            M1(i);
        } else {
            if (this.x.size() == 0) {
                finish();
                return;
            }
            int i2 = i - 1;
            this.q.setCurrentItem(i2, true);
            M1(i2);
        }
    }

    public final boolean H1() {
        return true;
    }

    public String I1(String str, String str2) {
        return !TextUtils.isEmpty(str2) && new File(str2).exists() ? str2 : str;
    }

    public final void J1() {
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("selectIndex", 0);
        this.r = intExtra;
        this.s = intExtra;
        this.x = intent.getParcelableArrayListExtra("extra_key_feeds");
    }

    public final void K1() {
        yy3.a(this);
        setContentView(R$layout.activity_multi_publish_preview);
        this.q = (ViewPager) findViewById(R$id.viewpager);
        this.v = (RelativeLayout) findViewById(R$id.rootView);
        Toolbar toolbarInitToolbar = initToolbar(R$id.toolbar, "", true);
        toolbarInitToolbar.setNavigationIcon(R$drawable.selector_arrow_back);
        toolbarInitToolbar.setNavigationOnClickListener(new b());
        if (H1()) {
            this.y = new com.zenmen.palmchat.photoview.a(this.v, toolbarInitToolbar);
        }
        TextView textView = (TextView) findViewById(R$id.title);
        this.u = textView;
        if (this.x != null) {
            textView.setText(String.format("%d/%d", Integer.valueOf(this.r + 1), Integer.valueOf(this.x.size())));
        }
        ImageView imageView = (ImageView) findViewById(R$id.action_button);
        this.t = imageView;
        imageView.setOnClickListener(new c());
        zn6.c("pagemultipleedit_preview", "view");
    }

    public final void L1() {
        zn6.c("pagemultipleedit_preview_back", "click");
        finish();
    }

    public final void M1(int i) {
        this.s = i;
        this.u.setText(String.format("%d/%d", Integer.valueOf(i + 1), Integer.valueOf(this.x.size())));
        ds0.a().b(new g22(i));
    }

    public final void N1(int i) {
        new sd3(this).k(this.x.get(i).getMediaItem().mimeType == 1 ? "要删除这个视频吗？" : "要删除这张照片吗？").n(GravityEnum.CENTER).P("删除").M(Color.parseColor("#FF463C")).L("取消").f(new d(i)).e().show();
    }

    public void O1() {
        com.zenmen.palmchat.photoview.a aVar = this.y;
        if (aVar != null) {
            aVar.h();
        }
    }

    public final void P1() {
        MultiPublishPreviewFragmentAdapter multiPublishPreviewFragmentAdapter = new MultiPublishPreviewFragmentAdapter(getSupportFragmentManager(), this.x);
        this.w = multiPublishPreviewFragmentAdapter;
        this.q.setAdapter(multiPublishPreviewFragmentAdapter);
        this.q.setCurrentItem(this.r, true);
        this.q.setPageMargin(me1.b(this, 17));
        this.q.addOnPageChangeListener(new a());
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("extra_key_feeds", this.x);
        setResult(-1, intent);
        super.finish();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        L1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        J1();
        K1();
        P1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        px5.g();
        super.onDestroy();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SquareMultiPublishPreviewActivity.this.M1(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }
}
