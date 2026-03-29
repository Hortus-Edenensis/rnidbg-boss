package com.zenmen.palmchat.circle.app.keep.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.openalliance.ad.constant.az;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.app.keep.model.KeepMotionParam;
import com.zenmen.palmchat.circle.app.keep.ui.KeepMotionItemView;
import com.zenmen.palmchat.circle.app.keep.widget.KeepChronometer;
import com.zenmen.palmchat.circle.app.keep.widget.KeepCountDownView;
import com.zenmen.palmchat.circle.app.keep.widget.KeepMotionCountView;
import com.zenmen.palmchat.circle.app.keep.widget.KeepProgressBar;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import defpackage.b5;
import defpackage.gz2;
import defpackage.hz2;
import defpackage.mz2;
import defpackage.oc0;
import defpackage.wz2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class KeepMotionListActivity extends FrameworkBaseActivity {
    public long A;
    public String B;
    public String C;
    public String E;
    public TextView F;
    public KeepCountDownView G;
    public final int q = 0;
    public KeepRecyclerViewPager r;
    public CheckBox s;
    public KeepMotionCountView t;
    public KeepChronometer u;
    public TextView v;
    public KeepProgressBar w;
    public RelativeLayout x;
    public ArrayList<KeepMotionParam> y;
    public ArrayList<mz2> z;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {
        public a() {
            put("report_type", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {
        public b() {
            put("report_type", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {
        public c() {
            put("report_type", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {
        public d() {
            put("report_type", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends HashMap<String, Object> {
        public f() {
            put("report_type", "view");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends HashMap<String, Object> {
        public g() {
            put(az.at, "0");
            put("report_type", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KeepMotionItemView f13037a;

        public h(KeepMotionItemView keepMotionItemView) {
            this.f13037a = keepMotionItemView;
            put("report_type", "click");
            put("sessionid", KeepMotionListActivity.this.E);
            put(az.at, "0");
            put("time", Long.valueOf(System.currentTimeMillis() - KeepMotionListActivity.this.A));
            put("planid", keepMotionItemView.getParam().planId);
            put("lessonid", keepMotionItemView.getParam().lessonId);
            put("actid", keepMotionItemView.getParam().actionId);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class i extends RecyclerView.Adapter<j> {
        public ArrayList<mz2> e;
        public KeepMotionItemView.c f;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(j jVar, int i) {
            KeepMotionItemView keepMotionItemView = (KeepMotionItemView) jVar.itemView;
            keepMotionItemView.setPos(i);
            keepMotionItemView.bindData(this.e.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public j onCreateViewHolder(ViewGroup viewGroup, int i) {
            KeepMotionItemView keepMotionItemView = new KeepMotionItemView(viewGroup.getContext());
            keepMotionItemView.setPlayCallBack(this.f);
            keepMotionItemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
            return new j(keepMotionItemView);
        }

        public void c(ArrayList<mz2> arrayList) {
            this.e = arrayList;
        }

        public void d(KeepMotionItemView.c cVar) {
            this.f = cVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.e.size();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class j extends RecyclerView.ViewHolder {
        public j(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V1(CompoundButton compoundButton, boolean z) {
        View curView = this.r.getCurView();
        if (curView instanceof KeepMotionItemView) {
            KeepMotionItemView keepMotionItemView = (KeepMotionItemView) curView;
            if (z) {
                oc0.h("pagekeeplessonplayer_start", new c());
                KeepCountDownView keepCountDownView = this.G;
                if (keepCountDownView != null && !keepCountDownView.isFinishCountDown() && !this.G.isRunning()) {
                    this.G.startTimer();
                }
                keepMotionItemView.playVideo();
                return;
            }
            oc0.h("pagekeeplessonplayer_stop", new d());
            KeepCountDownView keepCountDownView2 = this.G;
            if (keepCountDownView2 != null && !keepCountDownView2.isFinishCountDown() && this.G.isRunning()) {
                this.G.stopTimer();
            }
            keepMotionItemView.pauseVideo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W1() {
        if (this.r.getCurView() instanceof KeepMotionItemView) {
            ((KeepMotionItemView) this.r.getCurView()).submit();
        }
    }

    public static void X1(Activity activity, ArrayList<KeepMotionParam> arrayList, String str, String str2) {
        Intent intent = new Intent(activity, (Class<?>) KeepMotionListActivity.class);
        intent.putParcelableArrayListExtra("datas", arrayList);
        intent.putExtra("info", str);
        intent.putExtra("args", str2);
        activity.startActivity(intent);
    }

    public final void Q1() {
        this.x.addView(this.G);
        this.G.startTimer();
    }

    public void R1() {
        Iterator<mz2> it = this.z.iterator();
        boolean z = false;
        int i2 = 0;
        while (it.hasNext()) {
            boolean z2 = it.next().b;
            if (z2) {
                i2++;
            }
            z = z || z2;
        }
        if (z) {
            S1(i2);
        }
    }

    public final void S1(int i2) {
        String str = this.C;
        KeepShareActivity.G1(this, gz2.b(gz2.d(this.z, i2, 0, this.u.getText().toString()), this.B, gz2.a(str, "我完成了训练，" + i2 + "组重复", this.z.get(r2.size() - 1).f19395a.lessonName, this.u.getText().toString())));
        finish();
    }

    public final void T1() {
        this.y = getIntent().getParcelableArrayListExtra("datas");
        this.B = getIntent().getStringExtra("info");
        this.C = getIntent().getStringExtra("args");
    }

    public final void U1(b5 b5Var) {
        this.G = new KeepCountDownView(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.G.setLayoutParams(layoutParams);
        this.G.setAction0(b5Var);
    }

    public void back(View view) {
        finish();
        R1();
    }

    public void guideToHtml(View view) {
        if (this.r.getCurView() instanceof KeepMotionItemView) {
            KeepMotionItemView keepMotionItemView = (KeepMotionItemView) this.r.getCurView();
            oc0.h("pagekeeplessonplayer_detail", new g());
            Intent intent = new Intent(this, (Class<?>) KeepMotionWebActivity.class);
            intent.putExtra("url", keepMotionItemView.getParam().guideUrl);
            startActivity(intent);
        }
    }

    public void next(View view) {
        oc0.h("pagekeeplessonplayer_next", new a());
        this.u.onPause();
        if (this.r.getCurPos() == this.y.size() - 1) {
            R1();
            return;
        }
        KeepCountDownView keepCountDownView = this.G;
        if (keepCountDownView != null) {
            keepCountDownView.stopTimer();
            this.x.removeView(this.G);
        }
        View curView = this.r.getCurView();
        if (curView instanceof KeepMotionItemView) {
            ((KeepMotionItemView) curView).releaseStateChangeListener();
        }
        this.r.next();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        R1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_keep_motion_lst);
        T1();
        this.r = (KeepRecyclerViewPager) findViewById(R.id.rv_pager);
        this.x = (RelativeLayout) findViewById(R.id.root);
        this.F = (TextView) findViewById(R.id.guide);
        CheckBox checkBox = (CheckBox) findViewById(R.id.play_or_pause);
        this.s = checkBox;
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: qz2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f20358a.V1(compoundButton, z);
            }
        });
        this.u = (KeepChronometer) findViewById(R.id.chronometer);
        this.t = (KeepMotionCountView) findViewById(R.id.motion_count);
        this.v = (TextView) findViewById(R.id.motion_name);
        KeepProgressBar keepProgressBar = (KeepProgressBar) findViewById(R.id.pb);
        this.w = keepProgressBar;
        keepProgressBar.setAction0(new b5() { // from class: rz2
            @Override // defpackage.b5
            public final void call() {
                this.f20628a.W1();
            }
        });
        i iVar = new i();
        this.z = new ArrayList<>();
        for (KeepMotionParam keepMotionParam : this.y) {
            mz2 mz2Var = new mz2();
            mz2Var.f19395a = keepMotionParam;
            mz2Var.b = false;
            this.z.add(mz2Var);
        }
        iVar.c(this.z);
        iVar.d(new e());
        this.r.setAdapter(iVar);
        oc0.h("pagekeeplessonplayer", new f());
        this.E = wz2.c();
        this.A = System.currentTimeMillis();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        KeepCountDownView keepCountDownView = this.G;
        if (keepCountDownView != null && !keepCountDownView.isFinishCountDown()) {
            this.G.stopTimer();
        }
        View curView = this.r.getCurView();
        if (curView instanceof KeepMotionItemView) {
            KeepMotionItemView keepMotionItemView = (KeepMotionItemView) curView;
            oc0.h("keep_player_time", new h(keepMotionItemView));
            keepMotionItemView.pauseVideo();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.s.isChecked()) {
            KeepCountDownView keepCountDownView = this.G;
            if (keepCountDownView != null && !keepCountDownView.isFinishCountDown()) {
                this.G.startTimer();
            }
            View curView = this.r.getCurView();
            if (curView instanceof KeepMotionItemView) {
                ((KeepMotionItemView) curView).playVideo();
            }
        }
    }

    public void prev(View view) {
        KeepCountDownView keepCountDownView;
        oc0.h("pagekeeplessonplayer_last", new b());
        this.u.onPause();
        if (this.r.getCurPos() != 0 && (keepCountDownView = this.G) != null) {
            keepCountDownView.stopTimer();
            this.x.removeView(this.G);
        }
        View curView = this.r.getCurView();
        if (curView instanceof KeepMotionItemView) {
            ((KeepMotionItemView) curView).releaseStateChangeListener();
        }
        this.r.prev();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements KeepMotionItemView.c {
        public e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(hz2 hz2Var) {
            if (!KeepMotionListActivity.this.s.isChecked() || KeepMotionListActivity.this.isPaused()) {
                return;
            }
            hz2Var.m();
        }

        @Override // com.zenmen.palmchat.circle.app.keep.ui.KeepMotionItemView.c
        public void b(mz2 mz2Var, final hz2 hz2Var, int i) {
            if (TextUtils.isEmpty(mz2Var.f19395a.url)) {
                KeepMotionListActivity.this.v.setVisibility(4);
                KeepMotionListActivity.this.t.setVisibility(4);
                KeepMotionListActivity.this.F.setVisibility(4);
            } else {
                KeepMotionListActivity.this.v.setVisibility(0);
                KeepMotionListActivity.this.t.setVisibility(0);
                KeepMotionListActivity.this.F.setVisibility(0);
                KeepMotionListActivity.this.U1(new b5() { // from class: sz2
                    @Override // defpackage.b5
                    public final void call() {
                        this.f20877a.i(hz2Var);
                    }
                });
                KeepMotionListActivity.this.t.setTotalMotion(mz2Var.f19395a.nums);
                KeepMotionListActivity.this.t.setActionFlag(mz2Var.f19395a.actionFlag);
                KeepMotionListActivity.this.t.motionUpdate(2, 0);
                String str = (i + 1) + "/" + KeepMotionListActivity.this.z.size();
                KeepMotionListActivity.this.v.setText(str + " " + mz2Var.f19395a.name);
            }
            KeepMotionListActivity.this.s.setChecked(true);
            KeepMotionListActivity.this.w.attachProgress(hz2Var);
        }

        @Override // com.zenmen.palmchat.circle.app.keep.ui.KeepMotionItemView.c
        public void c(mz2 mz2Var, hz2 hz2Var) {
            if (!TextUtils.isEmpty(mz2Var.f19395a.url)) {
                KeepMotionListActivity.this.Q1();
            }
            if (!KeepMotionListActivity.this.isPaused() && KeepMotionListActivity.this.s.isChecked()) {
                hz2Var.m();
            }
        }

        @Override // com.zenmen.palmchat.circle.app.keep.ui.KeepMotionItemView.c
        public void d(mz2 mz2Var) {
            KeepMotionListActivity.this.t.reset();
            KeepMotionListActivity.this.w.reset();
            KeepMotionListActivity.this.x.removeView(KeepMotionListActivity.this.G);
            KeepMotionListActivity.this.G = null;
        }

        @Override // com.zenmen.palmchat.circle.app.keep.ui.KeepMotionItemView.c
        public void e(mz2 mz2Var, hz2 hz2Var) {
            KeepMotionListActivity.this.u.onStart();
            if (TextUtils.isEmpty(mz2Var.f19395a.url)) {
                KeepMotionListActivity.this.w.setDelayTime(0);
            } else {
                KeepMotionListActivity.this.w.setDelayTime(5000);
            }
            int iB = hz2Var.b();
            KeepMotionListActivity.this.w.setMax(iB);
            hz2Var.c = iB;
            KeepMotionListActivity.this.t.attachProgress(hz2Var);
            KeepMotionListActivity.this.t.startTimer();
            KeepMotionListActivity.this.w.startTimer();
        }

        @Override // com.zenmen.palmchat.circle.app.keep.ui.KeepMotionItemView.c
        public void f(mz2 mz2Var) {
            KeepMotionListActivity.this.u.onPause();
            KeepMotionListActivity.this.t.stopTimer();
            KeepMotionListActivity.this.w.stopTimer();
        }

        @Override // com.zenmen.palmchat.circle.app.keep.ui.KeepMotionItemView.c
        public void g(mz2 mz2Var, int i) {
            if (i == KeepMotionListActivity.this.z.size() - 1) {
                KeepMotionListActivity.this.R1();
            } else {
                KeepMotionListActivity.this.next(null);
            }
        }

        @Override // com.zenmen.palmchat.circle.app.keep.ui.KeepMotionItemView.c
        public void a(mz2 mz2Var, int i) {
        }
    }
}
