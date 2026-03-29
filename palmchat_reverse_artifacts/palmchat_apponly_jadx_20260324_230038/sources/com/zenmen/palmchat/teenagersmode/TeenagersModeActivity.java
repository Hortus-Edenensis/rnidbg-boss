package com.zenmen.palmchat.teenagersmode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.ym4;
import defpackage.zt5;
import defpackage.zy4;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class TeenagersModeActivity extends BaseActionBarActivity {
    public ImageView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public View v;
    public ImageView w;
    public TextView x;
    public boolean y;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: com.zenmen.palmchat.teenagersmode.TeenagersModeActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC1109a implements Runnable {
            public RunnableC1109a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                TeenagersModeActivity.this.H1();
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zD = TeenagersModeManager.a().d();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("status", zD ? 2 : 1);
                LogUtil.onClickEvent("click_mainbutton", null, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (zD) {
                TeenagersModeActivity.this.G1();
            } else {
                TeenagersModeManager.a().c().a(TeenagersModeActivity.this, true, new RunnableC1109a());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TeenagersModeActivity.this.y = !r2.y;
            TeenagersModeActivity.this.I1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zy4.l(TeenagersModeActivity.this, ym4.f(), null, false, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends MaterialDialog.e {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                TeenagersModeActivity.this.H1();
            }
        }

        public d() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("choice", 1);
                LogUtil.onClickEvent("click_popupwindow", null, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            TeenagersModeManager.a().c().a(TeenagersModeActivity.this, false, new a());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("choice", 2);
                LogUtil.onClickEvent("click_popupwindow", null, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements TeenagersModeManager.d {
        public e() {
        }

        @Override // com.zenmen.palmchat.teenagersmode.TeenagersModeManager.d
        public void onFail() {
            TeenagersModeActivity.this.hideBaseProgressBar();
        }

        @Override // com.zenmen.palmchat.teenagersmode.TeenagersModeManager.d
        public void onSuccess() {
            TeenagersModeActivity.this.hideBaseProgressBar();
            sy5.e(TeenagersModeActivity.this, TeenagersModeManager.a().d() ? R.string.teenagers_mode_open_tip : R.string.teenagers_mode_close_tip, 0).g();
            TeenagersModeActivity.this.y = false;
            TeenagersModeActivity.this.I1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements TeenagersModeManager.d {
        public f() {
        }

        @Override // com.zenmen.palmchat.teenagersmode.TeenagersModeManager.d
        public void onFail() {
            TeenagersModeActivity.this.hideBaseProgressBar();
        }

        @Override // com.zenmen.palmchat.teenagersmode.TeenagersModeManager.d
        public void onSuccess() {
            TeenagersModeActivity.this.I1();
            TeenagersModeActivity.this.hideBaseProgressBar();
        }
    }

    public final void E1() {
        this.q = (ImageView) findViewById(R.id.img_icon);
        this.r = (TextView) findViewById(R.id.tv_title);
        this.s = (TextView) findViewById(R.id.subtitle1);
        this.t = (TextView) findViewById(R.id.subtitle2);
        TextView textView = (TextView) findViewById(R.id.tv_switch);
        this.u = textView;
        textView.setOnClickListener(new a());
        this.v = findViewById(R.id.agreement_layout);
        ImageView imageView = (ImageView) findViewById(R.id.img_select);
        this.w = imageView;
        imageView.setOnClickListener(new b());
        TextView textView2 = (TextView) findViewById(R.id.tv_agreement);
        this.x = textView2;
        textView2.setOnClickListener(new c());
    }

    public void F1(TeenagersModeManager.SmallVideoMode smallVideoMode) {
        showBaseProgressBar(getString(R.string.progress_sending), false);
        TeenagersModeManager.a().h(smallVideoMode, new f());
    }

    public final void G1() {
        MaterialDialog materialDialogE = new sd3(this).j(R.string.teenagers_mode_close_confirm_tip).O(R.string.teenagers_mode_close_confirm_btn_close).K(R.string.alert_dialog_cancel).h(false).f(new d()).e();
        materialDialogE.setCanceledOnTouchOutside(false);
        materialDialogE.show();
        LogUtil.onClickEvent("popupwindow_show", null, null);
    }

    public void H1() {
        showBaseProgressBar(getString(R.string.progress_sending), false);
        TeenagersModeManager.a().i(!TeenagersModeManager.a().d(), new e());
    }

    public final void I1() {
        if (TeenagersModeManager.a().d()) {
            this.q.setImageResource(R.drawable.ic_teenagers_mode_on);
            this.r.setText(R.string.teenagers_mode_on_title);
            this.u.setText(R.string.teenagers_mode_close_btn);
            this.u.setEnabled(true);
            this.v.setVisibility(8);
        } else {
            this.q.setImageResource(R.drawable.ic_teenagers_mode_off);
            this.r.setText(R.string.teenagers_mode_off_title);
            this.u.setText(R.string.teenagers_mode_open_btn);
            this.u.setEnabled(this.y);
            this.v.setVisibility(0);
            this.w.setImageResource(this.y ? R.drawable.ic_teenager_mode_agreement_selected : R.drawable.ic_teenager_mode_agreement_unselect);
        }
        this.s.setText(zt5.a());
        this.t.setText(zt5.b());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1 || i2 != -1) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        int intExtra = intent.getIntExtra("extra_mode", TeenagersModeManager.SmallVideoMode.ATTENTION.value());
        if (TeenagersModeManager.a().b().value() != intExtra) {
            F1(TeenagersModeManager.SmallVideoMode.valueOf(intExtra));
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_teenagers_mode);
        initToolbar(R.string.string_setting_teenagers_mode);
        E1();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        I1();
    }
}
