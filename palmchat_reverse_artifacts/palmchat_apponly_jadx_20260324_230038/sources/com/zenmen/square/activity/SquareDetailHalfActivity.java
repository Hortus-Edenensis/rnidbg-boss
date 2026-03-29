package com.zenmen.square.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.annotation.Nullable;
import com.zenmen.listui.duration.BaseDurationActivity;
import com.zenmen.palmchat.framework.R$anim;
import com.zenmen.square.R$id;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.ki5;
import defpackage.lo0;
import defpackage.rl2;
import defpackage.xu3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareDetailHalfActivity extends BaseDurationActivity {
    public ki5 r;
    public lo0 s;
    public rl2 t;
    public Handler u = new Handler();
    public Runnable v = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SquareDetailHalfActivity.this.s == null || ((Activity) SquareDetailHalfActivity.this.s.h()) == null || ((Activity) SquareDetailHalfActivity.this.s.h()).isFinishing()) {
                return;
            }
            ((Activity) SquareDetailHalfActivity.this.s.h()).finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements xu3.c {
        public b() {
        }

        @Override // xu3.c
        public void a() {
            SquareDetailHalfActivity squareDetailHalfActivity = SquareDetailHalfActivity.this;
            squareDetailHalfActivity.u.postDelayed(squareDetailHalfActivity.v, 2000L);
        }
    }

    public static void C1(Context context, int i, SquareFeed squareFeed, Bundle bundle) {
        Intent intent = new Intent(context, (Class<?>) SquareDetailHalfActivity.class);
        intent.putExtra("key_feed_bean", squareFeed);
        intent.putExtra("key_from", i);
        intent.putExtra("key_feed_exid", squareFeed.exid);
        intent.putExtra("key_feed_id", squareFeed.id);
        intent.putExtra("key_feed_uid", squareFeed.uid);
        intent.putExtras(bundle);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public rl2 B1() {
        return this.t;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R$anim.enter_from_left, R$anim.out_to_right);
    }

    @Override // com.zenmen.listui.duration.BaseDurationActivity
    public int o() {
        ki5 ki5Var = this.r;
        if (ki5Var != null) {
            return ki5Var.l();
        }
        return 0;
    }

    public void onBackPress(View view) {
        finish();
    }

    @Override // com.zenmen.listui.duration.BaseDurationActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Intent intent = getIntent();
        ki5 ki5Var = new ki5();
        this.r = ki5Var;
        ki5Var.b(intent);
        super.onCreate(bundle);
        lo0 lo0Var = new lo0(this);
        this.s = lo0Var;
        xu3 xu3Var = new xu3(this.r, lo0Var, new b());
        this.t = xu3Var;
        xu3Var.onCreate();
        initToolbar(R$id.toolbar, "", false);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.t.onDestroy();
        Handler handler = this.u;
        if (handler != null) {
            handler.removeCallbacks(this.v);
        }
    }
}
