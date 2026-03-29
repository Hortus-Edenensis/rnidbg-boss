package com.bytedance.sdk.openadsdk.core.activity.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.openadsdk.core.dislike.ui.nr;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.yd;
import com.bytedance.sdk.openadsdk.core.l.fx.fx;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.s.x;
import com.bytedance.sdk.openadsdk.core.ugeno.b.u;
import com.bytedance.sdk.openadsdk.core.ugeno.jk;
import com.bytedance.sdk.openadsdk.core.ugeno.jk.b;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.res.pn;
import com.ss.android.download.api.constant.BaseConstants;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class TTNativePageActivity extends BaseLandingPageActivity implements rh.u {
    private static WeakReference<fx> x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f5208a;
    private long bf;
    private Activity bq;
    private b c;
    private boolean d;
    private FrameLayout dw;
    private boolean gi;
    private int h;
    nr iz;
    private TextView jk;
    private TTViewStub k;
    private boolean kj;
    private Context l;
    private TTViewStub mv;
    private TTViewStub my;
    private ImageView n;
    private ImageView o;
    private com.bytedance.sdk.openadsdk.core.ugeno.jk.nr q;
    private u qq;
    private int rh;
    private TTViewStub s;
    private x sx;
    private TextView t;
    private FrameLayout z;
    private AtomicBoolean bg = new AtomicBoolean(true);
    private boolean ja = true;
    private final rh wq = new rh(Looper.getMainLooper(), this);
    private String pb = "立即下载";

    private void a() {
        com.bytedance.sdk.openadsdk.core.ugeno.x.u uVarJa = this.pn.ja();
        if (uVarJa == null) {
            return;
        }
        int iB = uVarJa.b();
        if (iB == 2) {
            b bVar = new b(this.l, this.dw, this.sx, this.pn, this.fx, this.b);
            this.c = bVar;
            bVar.mv();
            return;
        }
        if (iB == 3) {
            com.bytedance.sdk.openadsdk.core.ugeno.jk.nr nrVar = new com.bytedance.sdk.openadsdk.core.ugeno.jk.nr(this.l, this.dw, this.sx, this.pn, this.fx, this.b);
            this.q = nrVar;
            nrVar.nr(false);
            this.q.mv();
            if (TextUtils.equals(uVarJa.u(), "3")) {
                return;
            }
            final ImageView imageView = new ImageView(this.l);
            float fFx = y.fx(this.l, 18.0f);
            float fFx2 = y.fx(this.l, 18.0f);
            int i = (int) fFx;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
            layoutParams.gravity = 53;
            int i2 = (int) fFx2;
            layoutParams.setMargins(i2, i2, i2, i2);
            this.z.addView(imageView, layoutParams);
            q.u(this.l, "tt_unmute", imageView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.kj = !r3.kj;
                    q.u(TTNativePageActivity.this.l, TTNativePageActivity.this.kj ? "tt_mute" : "tt_unmute", imageView);
                    TTNativePageActivity.this.q.fx(TTNativePageActivity.this.kj);
                }
            });
        }
    }

    private void iz() {
        this.d = yd.bg(this.pn);
        boolean zSx = yd.sx(this.pn);
        this.gi = zSx;
        if (this.d) {
            if (!com.bytedance.sdk.openadsdk.core.n.b.b) {
                this.gi = false;
            } else if (zSx) {
                this.d = false;
            }
        }
    }

    private void jk() {
        TTViewStub tTViewStub;
        this.z = (FrameLayout) findViewById(2114387634);
        this.dw = (FrameLayout) findViewById(2114387720);
        this.my = (TTViewStub) findViewById(2114387956);
        this.mv = (TTViewStub) findViewById(2114387770);
        this.s = (TTViewStub) findViewById(2114387792);
        TTViewStub tTViewStub2 = (TTViewStub) findViewById(2114387933);
        this.k = tTViewStub2;
        if (this.gi || this.d) {
            if (tTViewStub2 != null) {
                tTViewStub2.setVisibility(0);
            }
            this.o = (ImageView) findViewById(2114387843);
        } else {
            int iH = n.o().h();
            if (iH == 0) {
                TTViewStub tTViewStub3 = this.mv;
                if (tTViewStub3 != null) {
                    tTViewStub3.setVisibility(0);
                }
            } else if (iH == 1 && (tTViewStub = this.s) != null) {
                tTViewStub.setVisibility(0);
            }
        }
        ImageView imageView = (ImageView) findViewById(2114387705);
        this.n = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.finish();
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387704);
        this.f5208a = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.finish();
                }
            });
        }
        this.jk = (TextView) findViewById(2114387952);
        TextView textView = (TextView) findViewById(2114387627);
        this.t = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.u();
                }
            });
        }
    }

    private boolean l() {
        return bc.fx(this.pn);
    }

    private void mv() {
        this.h = 0;
        if (this.gi) {
            this.h = com.bytedance.sdk.openadsdk.core.n.b.u;
        } else if (this.d && !com.bytedance.sdk.openadsdk.core.n.b.b) {
            this.h = yd.s(this.pn);
        }
        fx(this.h);
        if (this.h > 0 && !this.wq.hasMessages(10)) {
            if (this.gi) {
                this.wq.sendEmptyMessageDelayed(10, 1000L);
            } else if (this.d) {
                this.wq.sendEmptyMessageDelayed(10, 1000L);
            }
        }
    }

    private com.bytedance.sdk.openadsdk.core.multipro.nr.u n() {
        String stringExtra = getIntent().getStringExtra("multi_process_data");
        if (TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        try {
            return com.bytedance.sdk.openadsdk.core.multipro.nr.u.u(new JSONObject(stringExtra));
        } catch (JSONException unused) {
            return null;
        }
    }

    private void pn() {
        bc bcVar = this.pn;
        if (bcVar == null || bcVar.ja() == null || this.pn.ja().b() != 3) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.playable.nr.u().u(this.pn);
    }

    private boolean t() {
        return this.gi || this.d;
    }

    private void x() {
        if (!jk.n(this.pn)) {
            a();
            return;
        }
        u uVar = new u(this, this.dw, this.sx, this.pn, this.fx, this.b, n());
        this.qq = uVar;
        uVar.u(new com.bytedance.sdk.openadsdk.core.ugeno.pn.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.pn.u
            public void u(View view) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.pn.u
            public void u(int i) {
                TTNativePageActivity.this.u(i);
            }
        });
        this.qq.u();
    }

    public void b() {
        if (!t() || this.wq.hasMessages(10)) {
            return;
        }
        this.wq.sendEmptyMessageDelayed(10, 1000L);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.pn == null) {
            return;
        }
        setRequestedOrientation(1);
        this.bq = this;
        this.l = this;
        getWindow().addFlags(1024);
        try {
            dw.u(this.bq);
        } catch (Throwable unused) {
        }
        setContentView(pn.m(this.l));
        this.bf = System.currentTimeMillis();
        String stringExtra = getIntent().getStringExtra("title");
        pn();
        iz();
        jk();
        bc bcVar = this.pn;
        if (bcVar != null && bcVar.vz() != null) {
            this.pn.vz().u("landing_page");
        }
        x xVar = new x(this.pn);
        this.sx = xVar;
        xVar.u(true);
        this.sx.u();
        if (this.pn != null) {
            x();
        }
        TextView textView = this.jk;
        if (textView != null && !this.gi && !this.d) {
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = q.u(this.bq, "tt_web_title_default");
            }
            textView.setText(stringExtra);
        }
        nr(4);
        com.bytedance.sdk.openadsdk.core.s.b.u(this.pn, getClass().getName());
        if (this.gi || this.d) {
            mv();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        u uVar = this.qq;
        if (uVar != null) {
            uVar.b();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.jk.nr nrVar = this.q;
        if (nrVar != null) {
            nrVar.my();
        }
        x xVar = this.sx;
        if (xVar != null) {
            xVar.b();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        u uVar = this.qq;
        if (uVar != null) {
            uVar.nr();
        }
        fx();
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        x xVar = this.sx;
        if (xVar != null) {
            xVar.fx();
        }
        b();
        u uVar = this.qq;
        if (uVar != null) {
            uVar.fx();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        x xVar = this.sx;
        if (xVar != null) {
            xVar.u(0);
        }
        if (this.ja) {
            this.ja = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.bf);
                jSONObject.put("end", System.currentTimeMillis());
                com.bytedance.sdk.openadsdk.pn.u.u(jSONObject, this.pn);
            } catch (JSONException unused) {
            }
            com.bytedance.sdk.openadsdk.core.s.b.u(this.pn, com.huawei.openalliance.ad.constant.x.df, "agg_stay_page", new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.6
                @Override // com.bytedance.sdk.openadsdk.iz.u.u
                public void u(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
                }
            });
        }
    }

    private void fx(int i) {
        if (i <= 0) {
            if (this.gi) {
                y.u(this.jk, "领取成功");
                return;
            } else {
                if (this.d) {
                    y.u((View) this.o, 8);
                    y.u(this.jk, "恭喜你！福利已领取");
                    return;
                }
                return;
            }
        }
        if (this.gi) {
            y.u(this.jk, i + "s后可领取奖励");
            return;
        }
        if (this.d) {
            SpannableString spannableString = new SpannableString("浏览 " + i + "秒 获得更多福利");
            spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), spannableString.length() + (-4), spannableString.length(), 17);
            y.u(this.jk, spannableString);
        }
    }

    private void nr(int i) {
        if (l()) {
            y.u((View) this.f5208a, 4);
        } else {
            if (this.f5208a == null || !l()) {
                return;
            }
            y.u((View) this.f5208a, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i) {
        Intent intent;
        WeakReference<fx> weakReference;
        Intent intent2 = getIntent();
        if (intent2 == null) {
            return;
        }
        if (intent2.getBooleanExtra("is_replace_dialog", false) && (weakReference = x) != null && weakReference.get() != null) {
            x.get().nr(false);
            x.get().u(jp.dw(this.pn), false);
            x = null;
        } else {
            if (bc.nr(this.pn) && jp.x(this.pn)) {
                intent = new Intent(this, (Class<?>) TTVideoWebPageActivity.class);
            } else {
                intent = new Intent(this, (Class<?>) TTWebPageActivity.class);
            }
            intent.putExtras(intent2);
            try {
                com.bytedance.sdk.component.utils.nr.u(this.bq, intent, null);
            } catch (Throwable unused) {
            }
        }
        finish();
    }

    public void nr() {
        nr nrVar = new nr(this.bq, this.pn.vz(), this.fx, true, com.bytedance.sdk.openadsdk.n.nr.u());
        this.iz = nrVar;
        com.bytedance.sdk.openadsdk.core.dislike.fx.u(this.bq, this.pn, nrVar);
        this.iz.u(new nr.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.7
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.nr.u
            public void nr() {
                TTNativePageActivity.this.b();
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.nr.u
            public void u() {
                TTNativePageActivity.this.fx();
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.nr.u
            public void u(int i, String str, boolean z) {
                TTNativePageActivity.this.b();
            }
        });
    }

    public void fx() {
        if (t()) {
            this.wq.removeMessages(10);
        }
    }

    public void u() {
        if (this.pn == null || isFinishing()) {
            return;
        }
        if (this.iz == null) {
            nr();
        }
        this.iz.u();
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        if (message.what == 10 && t()) {
            int i = this.rh + 1;
            this.rh = i;
            if (this.gi) {
                com.bytedance.sdk.openadsdk.core.n.b.nr = i;
            }
            int iMax = Math.max(0, this.h - i);
            fx(iMax);
            if (iMax <= 0 && this.d) {
                com.bytedance.sdk.openadsdk.core.n.b.b = true;
            }
            this.wq.sendEmptyMessageDelayed(10, 1000L);
        }
    }

    public static void u(fx fxVar) {
        x = new WeakReference<>(fxVar);
    }
}
