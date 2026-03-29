package com.zenmen.square;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.zenmen.listui.duration.BaseDurationActivity;
import com.zenmen.square.activity.SquareDetailHalfActivity;
import com.zenmen.square.adapter.FeedDetailAdapter;
import com.zenmen.square.lxpager.SquareViewPager2;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.a46;
import defpackage.hx3;
import defpackage.k66;
import defpackage.l66;
import defpackage.o22;
import defpackage.p66;
import defpackage.ry5;
import defpackage.sy5;
import defpackage.ub4;
import defpackage.ut1;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class MediaViewActivity extends BaseDurationActivity {
    public int r;
    public int s;
    public boolean t = false;
    public k66 u = null;
    public l66 v = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f16083a;

        public a(Context context) {
            this.f16083a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            sy5.e(this.f16083a, com.zenmen.openapi.R$string.square_toast_net_err, 1).g();
        }
    }

    public static boolean B1(int i, Context context, SquareFeed squareFeed, boolean z) {
        if (!hx3.m(context) && (context instanceof Activity)) {
            ((Activity) context).runOnUiThread(new a(context));
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(squareFeed);
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_show_comment", z);
        return C1(i, arrayList, context, bundle);
    }

    public static boolean C1(int i, List<SquareFeed> list, Context context, Bundle bundle) {
        if (list == null || list.isEmpty()) {
            ry5.a("加载失败");
            return false;
        }
        if (list.get(0).feedType == 1) {
            SquareDetailHalfActivity.C1(context, i, list.get(0), bundle);
            return true;
        }
        Intent intent = new Intent(context, (Class<?>) MediaViewActivity.class);
        intent.putExtra("key_from", i);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putParcelableArrayListExtra("key_feed_list", (ArrayList) list);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final void A1() {
        List<SquareFeed> list;
        SquareViewPager2 squareViewPager2 = (SquareViewPager2) findViewById(R$id.square_detail_pager);
        squareViewPager2.setBackView(findViewById(R$id.back_arrow));
        FeedDetailAdapter feedDetailAdapter = new FeedDetailAdapter(this);
        Bundle extras = getIntent().getExtras();
        extras.remove("key_feed_list");
        String strReplaceAll = UUID.randomUUID().toString().replaceAll("-", "");
        extras.putString("key_sid", strReplaceAll);
        feedDetailAdapter.k(extras);
        squareViewPager2.setAdapter(feedDetailAdapter);
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("key_feed_list");
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.size() == 0) {
            finish();
            return;
        }
        if (this.s >= parcelableArrayListExtra.size()) {
            this.s = 0;
        }
        ut1 ut1VarA = ub4.a(this.r, new Bundle(extras), (SquareFeed) parcelableArrayListExtra.get(this.s));
        squareViewPager2.setPagerListModel(ut1VarA);
        o22 o22Var = new o22(squareViewPager2, ut1VarA);
        ((SquareFeed) parcelableArrayListExtra.get(this.s)).isTargetPosition = true;
        ((SquareFeed) parcelableArrayListExtra.get(this.s)).isFirstRefresh = true;
        if (!p66.e(this.r, parcelableArrayListExtra) || p66.f()) {
            list = parcelableArrayListExtra;
        } else {
            k66 k66Var = new k66(this, o22Var, this.s, parcelableArrayListExtra.size(), strReplaceAll);
            this.u = k66Var;
            List<SquareFeed> listA = k66Var.a(parcelableArrayListExtra);
            this.s = this.u.c();
            list = listA;
        }
        o22Var.l(list, this.s);
        if (p66.e(this.r, list) && p66.f()) {
            this.v = new l66(this, o22Var, list, strReplaceAll, this.s);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(com.zenmen.palmchat.framework.R$anim.enter_from_left, com.zenmen.palmchat.framework.R$anim.out_to_right);
    }

    public final void initActionBar() {
        setStatusBarColor(-16777216);
        a46.A(getWindow(), false);
        findViewById(R$id.back_arrow).setPadding(0, a46.n(this), 0, 0);
    }

    @Override // com.zenmen.listui.duration.BaseDurationActivity
    public int o() {
        return 4;
    }

    public void onArrowPress(View view) {
        onBackPressed();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // com.zenmen.listui.duration.BaseDurationActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.layout_square_detail);
        this.r = getIntent().getIntExtra("key_from", 0);
        this.s = getIntent().getIntExtra("key_target_position", 0);
        initActionBar();
        A1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        k66 k66Var = this.u;
        if (k66Var != null) {
            k66Var.e();
        }
        l66 l66Var = this.v;
        if (l66Var != null) {
            l66Var.f();
        }
    }

    @Override // com.zenmen.listui.duration.BaseDurationActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.zenmen.listui.duration.BaseDurationActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
