package com.zenmen.palmchat.chat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.login.InitActivity;
import com.zenmen.palmchat.notification.NotificationChannelManager;
import com.zenmen.palmchat.pullwake.pulldialog.DialogData;
import com.zenmen.palmchat.utils.a;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a46;
import defpackage.az2;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.m5;
import defpackage.me1;
import defpackage.ts2;
import defpackage.zn6;
import defpackage.zs1;
import java.util.HashMap;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CustomDialogActivity extends Activity implements zs1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f12597a;
    public boolean b = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CustomDialogActivity.this.isFinishing()) {
                return;
            }
            CustomDialogActivity customDialogActivity = CustomDialogActivity.this;
            if (customDialogActivity.b) {
                customDialogActivity.e();
            } else {
                customDialogActivity.finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DialogData.DialogItemData f12600a;

        public c(DialogData.DialogItemData dialogItemData) {
            this.f12600a = dialogItemData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn6.c("keepalive_pop", "click");
            Intent intent = new Intent(CustomDialogActivity.this, (Class<?>) InitActivity.class);
            intent.putExtra("key_push_param", ts2.g(this.f12600a.turnUrl, "pop"));
            intent.putExtra("key_from_push", true);
            intent.addFlags(335544320);
            CustomDialogActivity.this.startActivity(intent);
            com.zenmen.palmchat.utils.a.E().u(7000);
            if (CustomDialogActivity.this.isFinishing()) {
                return;
            }
            CustomDialogActivity.this.finish();
        }
    }

    public final int c() {
        try {
            return new int[]{1, 9, 109, 103, 7, 4}[new Random().nextInt(6)];
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public final void d() {
        this.f12597a.setVisibility(0);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        this.f12597a.startAnimation(translateAnimation);
    }

    public final void e() {
        this.f12597a.setVisibility(0);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -0.0f, 1, -2.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        translateAnimation.setAnimationListener(new b());
        this.f12597a.startAnimation(translateAnimation);
    }

    public final void f(DialogData.DialogItemData dialogItemData) {
        a.t tVar = new a.t();
        tVar.f15737a = dialogItemData.nickName;
        tVar.b = dialogItemData.title;
        tVar.c = dialogItemData.icon;
        tVar.d = ts2.g(dialogItemData.turnUrl, "pop_notice");
        tVar.e = 7000;
        tVar.f = NotificationChannelManager.MessageType.APP_INFO;
        com.zenmen.palmchat.utils.a.E().x0(tVar);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // zs1.a
    public String formatStackForLog() {
        return null;
    }

    public final void g() {
        View viewFindViewById = findViewById(R.id.root);
        this.f12597a = viewFindViewById;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewFindViewById.getLayoutParams();
        layoutParams.topMargin = a46.n(this) + me1.b(this, 8);
        layoutParams.leftMargin = me1.b(this, 10);
        layoutParams.rightMargin = me1.b(this, 10);
        this.f12597a.setLayoutParams(layoutParams);
        DialogData.DialogItemData dialogItemData = (DialogData.DialogItemData) getIntent().getSerializableExtra("EXTRA_DATA");
        LogUtil.i("PullDialogManager", "updateUi" + az2.c(dialogItemData));
        if (dialogItemData != null) {
            ((TextView) findViewById(R.id.update_tv)).setText(dialogItemData.nickName);
            ((TextView) findViewById(R.id.update_sub_tv)).setText(dialogItemData.title);
            gr2.j().h(dialogItemData.icon, (ImageView) findViewById(R.id.update_image), bq6.s());
            this.f12597a.setOnClickListener(new c(dialogItemData));
            f(dialogItemData);
        }
    }

    @Override // zs1.a
    public int getPageId() {
        return c();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        m5.c(this, bundle);
        getWindow().addFlags(8192);
        super.onCreate(bundle);
        zn6.c("keepalive_pop", "view");
        me1.k(getWindow(), com.zenmen.palmchat.c.a().getStatusBarColor());
        setContentView(R.layout.pull_dialog_notification_view);
        g();
        new Handler().postDelayed(new a(), (int) (com.zenmen.palmchat.pullwake.pulldialog.a.b().a().lasttime * 1000.0f));
        this.f12597a.setVisibility(8);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.b = false;
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.b = true;
        d();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            CustomDialogActivity.this.f12597a.setVisibility(8);
            if (CustomDialogActivity.this.isFinishing()) {
                return;
            }
            CustomDialogActivity.this.finish();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    @Override // zs1.a
    public void updateCurrentPageInfo(Activity activity, HashMap map) {
    }
}
