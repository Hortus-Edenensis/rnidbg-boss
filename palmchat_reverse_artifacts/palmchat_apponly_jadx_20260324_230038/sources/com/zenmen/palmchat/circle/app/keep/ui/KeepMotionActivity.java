package com.zenmen.palmchat.circle.app.keep.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import com.huawei.openalliance.ad.constant.az;
import com.zenmen.media.player.MagicTextureMediaPlayer;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.app.keep.model.KeepMotionParam;
import com.zenmen.palmchat.circle.app.keep.widget.KeepChronometer;
import com.zenmen.palmchat.circle.app.keep.widget.KeepCountDownView;
import com.zenmen.palmchat.circle.app.keep.widget.KeepMotionCountView;
import com.zenmen.palmchat.circle.app.keep.widget.KeepProgressBar;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.widget.ZXWebView;
import defpackage.b5;
import defpackage.c70;
import defpackage.gr2;
import defpackage.gz2;
import defpackage.hr2;
import defpackage.hz2;
import defpackage.je1;
import defpackage.k86;
import defpackage.mz2;
import defpackage.oc0;
import defpackage.uz2;
import defpackage.wi0;
import defpackage.wz2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class KeepMotionActivity extends FrameworkBaseActivity implements CordovaInterface {
    public static final String J = "com.zenmen.palmchat.circle.app.keep.ui.KeepMotionActivity";
    public mz2 A;
    public ViewPager B;
    public long C;
    public String E;
    public String F;
    public String G;
    public KeepCountDownView H;
    public uz2 I = new c();
    public hz2 q;
    public KeepMotionCountView r;
    public String s;
    public KeepChronometer t;
    public TextView u;
    public TextView v;
    public KeepProgressBar w;
    public RelativeLayout x;
    public KeepMotionParam y;
    public ImageView z;

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {
        public b() {
            put("report_type", "view");
            put("actid", KeepMotionActivity.this.y.actionId);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends uz2 {
        public c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            KeepMotionActivity.this.isPaused();
        }

        @Override // defpackage.uz2, com.zenmen.media.player.OnStateChangeListener
        public void onCompleted() {
            Log.d(KeepMotionActivity.J, "on completed");
            KeepMotionActivity.this.q.f18074a++;
            super.onCompleted();
        }

        @Override // defpackage.uz2, com.zenmen.media.player.OnStateChangeListener
        public void onPaused() {
            KeepMotionActivity.this.t.onPause();
            KeepMotionActivity.this.r.stopTimer();
            KeepMotionActivity.this.w.stopTimer();
        }

        @Override // defpackage.uz2, com.zenmen.media.player.OnStateChangeListener
        public void onPrepared(int i, int i2) {
            Log.d(KeepMotionActivity.J, "on prepared");
            super.onPrepared(i, i2);
            KeepMotionActivity.this.M1(new b5() { // from class: kz2
                @Override // defpackage.b5
                public final void call() {
                    this.f18858a.b();
                }
            });
            KeepMotionActivity.this.q.m();
        }

        @Override // defpackage.uz2, com.zenmen.media.player.OnStateChangeListener
        public void onStarted() {
            Log.d(KeepMotionActivity.J, "on started");
            int iB = KeepMotionActivity.this.q.b();
            KeepMotionActivity.this.w.setMax(iB);
            KeepMotionActivity.this.q.c = iB;
            KeepMotionActivity.this.r.attachProgress(KeepMotionActivity.this.q);
            KeepMotionActivity.this.t.onStart();
            KeepMotionActivity.this.r.startTimer();
            KeepMotionActivity.this.w.startTimer();
        }

        @Override // defpackage.uz2, com.zenmen.media.player.OnStateChangeListener
        public void onVideoFirstFrame() {
            super.onVideoFirstFrame();
            KeepMotionActivity.this.z.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {
        public d() {
            put("report_type", "click");
            put("sessionid", KeepMotionActivity.this.G);
            put(az.at, "1");
            put("time", Long.valueOf(System.currentTimeMillis() - KeepMotionActivity.this.C));
            put("planid", KeepMotionActivity.this.y.planId);
            put("lessonid", KeepMotionActivity.this.y.lessonId);
            put("actid", KeepMotionActivity.this.y.actionId);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {
        public e() {
            put(az.at, "1");
            put("report_type", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends wi0<BaseResponse> {
        public f() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            if (baseResponse != null) {
                baseResponse.getResultCode();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q1() {
        this.B.setCurrentItem(1);
    }

    public static void R1(Activity activity, KeepMotionParam keepMotionParam, String str, String str2) {
        Intent intent = new Intent(activity, (Class<?>) KeepMotionActivity.class);
        intent.putExtra("data", keepMotionParam);
        intent.putExtra("info", str);
        intent.putExtra("args", str2);
        activity.startActivity(intent);
    }

    public final void M1(b5 b5Var) {
        this.H = new KeepCountDownView(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.H.setLayoutParams(layoutParams);
        this.H.setAction0(b5Var);
        this.x.addView(this.H);
        this.H.startTimer();
    }

    public final void N1() {
        String str = "我完成了训练，" + this.y.nums + "次重复";
        long jCurrentTimeMillis = (System.currentTimeMillis() - this.C) / 1000;
        KeepShareActivity.G1(this, gz2.b(gz2.c(this.y, 1, this.t.getText().toString()), this.E, gz2.a(this.F, str, this.y.name, this.t.getText().toString())));
        finish();
    }

    public final void O1() {
        this.y = (KeepMotionParam) getIntent().getParcelableExtra("data");
        Log.d(J, "handle param:" + this.y);
        this.E = getIntent().getStringExtra("info");
        this.F = getIntent().getStringExtra("args");
        mz2 mz2Var = new mz2();
        this.A = mz2Var;
        KeepMotionParam keepMotionParam = this.y;
        mz2Var.f19395a = keepMotionParam;
        mz2Var.b = false;
        String str = keepMotionParam.url;
        this.s = str;
        if (TextUtils.isEmpty(str)) {
            finish();
            return;
        }
        this.r.setTotalMotion(this.y.nums);
        this.q.b = this.y.unit;
    }

    public final void S1() {
        this.q.f(true);
        this.q.g();
    }

    public final void T1() {
        this.q.k(this.I);
        this.q.l(this.s);
        this.q.f(false);
    }

    public final void U1() {
        this.q.f(false);
        this.q.m();
    }

    public void V1() {
        mz2 mz2Var = this.A;
        if (mz2Var.b) {
            return;
        }
        mz2Var.b = true;
        c70.R().B("2", this.y.actionId, new f());
        N1();
    }

    public final void W1() {
        this.u.setText(this.y.name);
        String str = this.y.cover;
        je1 je1VarL = hr2.l();
        this.z.setScaleType(ImageView.ScaleType.CENTER_CROP);
        gr2.j().i(k86.p(str), this.z, je1VarL, null);
    }

    @Override // org.apache.cordova.CordovaInterface
    public String getAppId() {
        return null;
    }

    @Override // org.apache.cordova.CordovaInterface
    public String getLaunchUrl() {
        return null;
    }

    @Override // org.apache.cordova.CordovaInterface
    public ExecutorService getThreadPool() {
        return ZXWebView.getThreadPool();
    }

    public void guideToHtml(View view) {
        oc0.h("pagekeeplessonplayer_detail", new e());
        Intent intent = new Intent(this, (Class<?>) KeepMotionWebActivity.class);
        intent.putExtra("url", this.y.guideUrl);
        startActivity(intent);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_keep_motion);
        hz2 hz2Var = new hz2((MagicTextureMediaPlayer) findViewById(R.id.player));
        this.q = hz2Var;
        hz2Var.j(5000);
        this.t = (KeepChronometer) findViewById(R.id.chronometer);
        this.B = (ViewPager) findViewById(R.id.view_pager);
        ArrayList arrayList = new ArrayList();
        LayoutInflater layoutInflater = getLayoutInflater();
        arrayList.add(new View(this));
        arrayList.add(layoutInflater.inflate(R.layout.keep_motion_scroll_end, (ViewGroup) null, false));
        KeepMotionPageAdapter keepMotionPageAdapter = new KeepMotionPageAdapter(arrayList);
        this.B.addOnPageChangeListener(new a());
        this.B.setOffscreenPageLimit(2);
        this.B.post(new Runnable() { // from class: iz2
            @Override // java.lang.Runnable
            public final void run() {
                this.f18293a.Q1();
            }
        });
        this.B.setAdapter(keepMotionPageAdapter);
        this.r = (KeepMotionCountView) findViewById(R.id.motion_count);
        this.u = (TextView) findViewById(R.id.motion_name);
        this.v = (TextView) findViewById(R.id.slide_over);
        this.z = (ImageView) findViewById(R.id.cover);
        this.x = (RelativeLayout) findViewById(R.id.root);
        KeepProgressBar keepProgressBar = (KeepProgressBar) findViewById(R.id.pb);
        this.w = keepProgressBar;
        keepProgressBar.setAction0(new b5() { // from class: jz2
            @Override // defpackage.b5
            public final void call() {
                this.f18536a.V1();
            }
        });
        this.w.setDelayTime(5000);
        this.w.attachProgress(this.q);
        O1();
        this.r.setActionFlag(this.y.actionFlag);
        this.r.motionUpdate(2, 0);
        this.w.setState(101);
        this.w.setProgressDrawable(ContextCompat.getDrawable(this, R.drawable.keep_motion_shapre_g_2));
        P1();
        T1();
        W1();
        oc0.h("pagekeepactplayer", new b());
        this.G = wz2.c();
        this.C = System.currentTimeMillis();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.q.h();
    }

    @Override // org.apache.cordova.CordovaInterface
    public Object onMessage(String str, Object obj) {
        return null;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        KeepCountDownView keepCountDownView = this.H;
        if (keepCountDownView != null && !keepCountDownView.isFinishCountDown()) {
            this.H.stopTimer();
        }
        S1();
        oc0.h("keep_player_time", new d());
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        KeepCountDownView keepCountDownView = this.H;
        if (keepCountDownView != null && !keepCountDownView.isFinishCountDown()) {
            this.H.startTimer();
        }
        if (this.q.d()) {
            U1();
        }
        super.onResume();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: com.zenmen.palmchat.circle.app.keep.ui.KeepMotionActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1007a extends HashMap<String, Object> {
            public C1007a() {
                put("report_type", "click");
                put("type", Integer.valueOf(!KeepMotionActivity.this.A.b ? 1 : 0));
            }
        }

        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Log.d(KeepMotionActivity.J, "btm pageselected:" + i);
            if (i == 0) {
                oc0.h("pagekeepactplayer_slide", new C1007a());
                if (KeepMotionActivity.this.A.b) {
                    KeepMotionActivity.this.N1();
                } else {
                    KeepMotionActivity.this.finish();
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }

    @Override // org.apache.cordova.CordovaInterface
    public void setActivityResultCallback(CordovaPlugin cordovaPlugin) {
    }

    public final void P1() {
    }

    @Override // org.apache.cordova.CordovaInterface
    /* JADX INFO: renamed from: getActivity */
    public Activity getOwnerActivity2() {
        return this;
    }

    @Override // org.apache.cordova.CordovaInterface
    public void startActivityForResult(CordovaPlugin cordovaPlugin, Intent intent, int i) {
    }
}
