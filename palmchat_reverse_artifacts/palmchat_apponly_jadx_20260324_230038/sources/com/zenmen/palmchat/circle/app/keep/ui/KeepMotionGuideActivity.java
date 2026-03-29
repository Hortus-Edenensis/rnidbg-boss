package com.zenmen.palmchat.circle.app.keep.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.huawei.openalliance.ad.constant.az;
import com.zenmen.media.player.MagicTextureMediaPlayer;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.app.keep.model.KeepMotionParam;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import defpackage.hz2;
import defpackage.oc0;
import defpackage.tz2;
import defpackage.uz2;
import defpackage.wz2;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class KeepMotionGuideActivity extends FrameworkBaseActivity {
    public long A;
    public String B;
    public hz2 q;
    public String r;
    public TextView s;
    public TextView t;
    public CheckBox u;
    public Timer v = new Timer();
    public TimerTask w;
    public SeekBar x;
    public boolean y;
    public KeepMotionParam z;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends TimerTask {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            KeepMotionGuideActivity.this.s.setText(tz2.a(KeepMotionGuideActivity.this.q.c() / 1000));
            if (KeepMotionGuideActivity.this.y) {
                return;
            }
            KeepMotionGuideActivity.this.x.setProgress(KeepMotionGuideActivity.this.q.c());
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            KeepMotionGuideActivity.this.runOnUiThread(new Runnable() { // from class: pz2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20142a.b();
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends uz2 {
        public c() {
        }

        @Override // defpackage.uz2, com.zenmen.media.player.OnStateChangeListener
        public void onPaused() {
            super.onPaused();
            KeepMotionGuideActivity.this.R1();
        }

        @Override // defpackage.uz2, com.zenmen.media.player.OnStateChangeListener
        public void onPrepared(int i, int i2) {
            super.onPrepared(i, i2);
            KeepMotionGuideActivity.this.x.setMax(KeepMotionGuideActivity.this.q.b());
        }

        @Override // defpackage.uz2, com.zenmen.media.player.OnStateChangeListener
        public void onStarted() {
            super.onStarted();
            KeepMotionGuideActivity.this.t.setText(tz2.a(KeepMotionGuideActivity.this.q.b() / 1000));
            KeepMotionGuideActivity.this.Q1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {
        public d() {
            put("report_type", "click");
            put("sessionid", KeepMotionGuideActivity.this.B);
            put("planid", KeepMotionGuideActivity.this.z.planId);
            put("lessonid", KeepMotionGuideActivity.this.z.lessonId);
            put("actid", KeepMotionGuideActivity.this.z.actionId);
            put(az.at, Integer.valueOf(KeepMotionGuideActivity.this.z.source));
            put("time", Long.valueOf(System.currentTimeMillis() - KeepMotionGuideActivity.this.A));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L1(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.q.m();
        } else {
            this.q.g();
        }
    }

    public static void M1(Activity activity, KeepMotionParam keepMotionParam) {
        Intent intent = new Intent(activity, (Class<?>) KeepMotionGuideActivity.class);
        intent.putExtra("data", keepMotionParam);
        activity.startActivity(intent);
    }

    public final void K1() {
        KeepMotionParam keepMotionParam = (KeepMotionParam) getIntent().getParcelableExtra("data");
        this.z = keepMotionParam;
        String str = keepMotionParam.url;
        this.r = str;
        if (TextUtils.isEmpty(str)) {
            finish();
        }
    }

    public final void N1() {
        this.q.f(true);
        this.q.g();
    }

    public final void O1() {
        this.q.l(this.r);
        this.q.f(false);
        this.q.m();
    }

    public final void P1() {
        this.q.f(false);
        this.q.g();
    }

    public void Q1() {
        if (this.w != null) {
            return;
        }
        if (this.v == null) {
            this.v = new Timer();
        }
        if (this.w == null) {
            this.w = new a();
        }
        this.v.scheduleAtFixedRate(this.w, 0L, 10L);
    }

    public void R1() {
        TimerTask timerTask = this.w;
        if (timerTask != null) {
            timerTask.cancel();
        }
        Timer timer = this.v;
        if (timer != null) {
            timer.cancel();
        }
        this.w = null;
        this.v = null;
    }

    public void back(View view) {
        finish();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_keep_motion_guide);
        this.q = new hz2((MagicTextureMediaPlayer) findViewById(R.id.player));
        this.t = (TextView) findViewById(R.id.duration);
        this.s = (TextView) findViewById(R.id.elapsed);
        CheckBox checkBox = (CheckBox) findViewById(R.id.iv_play);
        this.u = checkBox;
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: oz2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f19905a.L1(compoundButton, z);
            }
        });
        SeekBar seekBar = (SeekBar) findViewById(R.id.pb);
        this.x = seekBar;
        seekBar.setOnSeekBarChangeListener(new b());
        this.q.k(new c());
        K1();
        O1();
        this.B = wz2.c();
        this.A = System.currentTimeMillis();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.q.h();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        N1();
        oc0.h("keep_player_time", new d());
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        if (isPaused()) {
            P1();
        }
        super.onResume();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            KeepMotionGuideActivity.this.y = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            KeepMotionGuideActivity.this.y = false;
            KeepMotionGuideActivity.this.q.i(KeepMotionGuideActivity.this.x.getProgress());
            KeepMotionGuideActivity.this.s.setText(tz2.a(KeepMotionGuideActivity.this.q.c() / 1000));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }
    }
}
