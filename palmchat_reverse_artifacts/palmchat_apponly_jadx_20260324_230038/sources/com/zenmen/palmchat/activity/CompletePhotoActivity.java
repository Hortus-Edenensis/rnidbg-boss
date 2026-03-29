package com.zenmen.palmchat.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.MediaPickActivity;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.dq3;
import defpackage.hc2;
import defpackage.ir5;
import defpackage.k86;
import defpackage.l50;
import defpackage.rl0;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.yy2;
import java.util.Timer;
import java.util.TimerTask;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CompletePhotoActivity extends BaseActionBarActivity {
    public TimerTask B;
    public ImageView q;
    public TextView r;
    public String s;
    public dq3 t;
    public long u;
    public ProgressBar w;
    public Timer x;
    public MaterialDialog v = null;
    public int y = 0;
    public boolean z = false;
    public int A = 0;
    public boolean C = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtil.uploadInfoImmediate("96002", "1", null, null);
            CompletePhotoActivity.this.finish();
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
            LogUtil.uploadInfoImmediate("96004", "1", null, null);
            if (TextUtils.isEmpty(CompletePhotoActivity.this.s)) {
                if (ir5.b() - CompletePhotoActivity.this.u >= 3000) {
                    sy5.e(CompletePhotoActivity.this, R.string.mend_photo_toast, 2000).g();
                    CompletePhotoActivity.this.u = ir5.b();
                    return;
                }
                return;
            }
            if (!k86.N(CompletePhotoActivity.this)) {
                sy5.e(CompletePhotoActivity.this, R.string.no_network_show_tips, 1).g();
            } else if (CompletePhotoActivity.this.r.isClickable()) {
                CompletePhotoActivity.this.r.setClickable(false);
                CompletePhotoActivity.this.e2();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            LogUtil.uploadInfoImmediate("96003", "1", null, null);
            Intent intent = new Intent(CompletePhotoActivity.this, (Class<?>) MediaPickActivity.class);
            intent.putExtra("select_mode_key", 1);
            CompletePhotoActivity.this.startActivityForResult(intent, 2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.Listener<String> {
        public d() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("resultCode", -1);
                if (iOptInt == 0) {
                    if (CompletePhotoActivity.this.C) {
                        return;
                    }
                    CompletePhotoActivity.this.g2();
                } else {
                    if (iOptInt != 1131) {
                        CompletePhotoActivity.this.c2();
                        return;
                    }
                    if (CompletePhotoActivity.this.y < 100) {
                        CompletePhotoActivity.this.y = 0;
                        CompletePhotoActivity.this.b2();
                    }
                    CompletePhotoActivity.this.V1();
                    CompletePhotoActivity.this.showRequestFailDialog(yy2.a(jSONObject), CompletePhotoActivity.this.getString(R.string.send_failed));
                }
            } catch (JSONException e) {
                e.printStackTrace();
                CompletePhotoActivity.this.c2();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Response.ErrorListener {
        public e() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            CompletePhotoActivity.this.c2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends TimerTask {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (CompletePhotoActivity.this.C) {
                    return;
                }
                CompletePhotoActivity.this.A += 250;
                if (CompletePhotoActivity.this.y < 61) {
                    CompletePhotoActivity.this.y += 5;
                    CompletePhotoActivity.this.w.setProgress(CompletePhotoActivity.this.y);
                } else if (CompletePhotoActivity.this.y > 60 && CompletePhotoActivity.this.y < 81) {
                    CompletePhotoActivity.this.y += 2;
                    CompletePhotoActivity.this.w.setProgress(CompletePhotoActivity.this.y);
                } else {
                    if (CompletePhotoActivity.this.y <= 80 || CompletePhotoActivity.this.y >= 99) {
                        CompletePhotoActivity.this.w.setProgress(CompletePhotoActivity.this.y);
                        return;
                    }
                    CompletePhotoActivity.this.y++;
                    CompletePhotoActivity.this.w.setProgress(CompletePhotoActivity.this.y);
                }
            }
        }

        public f() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            CompletePhotoActivity.this.runOnUiThread(new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements DialogInterface.OnCancelListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onNegative(MaterialDialog materialDialog) {
                CompletePhotoActivity.this.z = false;
                if (CompletePhotoActivity.this.t != null) {
                    CompletePhotoActivity.this.t.onCancel();
                }
                if (CompletePhotoActivity.this.y < 100) {
                    CompletePhotoActivity.this.y = 0;
                    CompletePhotoActivity.this.b2();
                }
                CompletePhotoActivity.this.r.setClickable(true);
                sy5.e(CompletePhotoActivity.this, R.string.mend_update_cancle_toast, 0).g();
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
                CompletePhotoActivity.this.Y1();
            }
        }

        public g() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (CompletePhotoActivity.this.z) {
                new sd3(CompletePhotoActivity.this).j(R.string.mend_exit_update).h(false).O(R.string.mend_update_wait).K(R.string.mend_update_cancle).f(new a()).e().show();
            }
        }
    }

    public static String T1() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.COMPLETE_PHOTO);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            return "有头像的用户，可结识更多新朋友";
        }
        String extra = dynamicConfig.getExtra();
        if (TextUtils.isEmpty(extra)) {
            return "有头像的用户，可结识更多新朋友";
        }
        try {
            return new JSONObject(extra).optString("title", "有头像的用户，可结识更多新朋友");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "有头像的用户，可结识更多新朋友";
        }
    }

    public static String U1() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.COMPLETE_PHOTO);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            return "添加头像";
        }
        String extra = dynamicConfig.getExtra();
        if (TextUtils.isEmpty(extra)) {
            return "添加头像";
        }
        try {
            return new JSONObject(extra).optString("mainTitle", "添加头像");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "添加头像";
        }
    }

    public final void V1() {
        this.r.setClickable(true);
        MaterialDialog materialDialog = this.v;
        if (materialDialog != null) {
            try {
                materialDialog.dismiss();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void W1() {
        Toolbar toolbarInitToolbar = initToolbar(-1, false);
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(R.string.mend_userinfo_title);
        TextView textView = (TextView) toolbarInitToolbar.findViewById(R.id.action_button);
        textView.setText(R.string.recommend_friend_skip);
        textView.setOnClickListener(new a());
    }

    public final void X1() {
        TextView textView = (TextView) findViewById(R.id.tv_text_title);
        TextView textView2 = (TextView) findViewById(R.id.tv_text_subtitle);
        textView.setText(U1());
        textView2.setText(T1());
        TextView textView3 = (TextView) findViewById(R.id.btn_next);
        this.r = textView3;
        textView3.setOnClickListener(new b());
        ImageView imageView = (ImageView) findViewById(R.id.take_photo);
        this.q = imageView;
        imageView.setOnClickListener(new c());
        if (!TextUtils.isEmpty(this.s)) {
            hc2.b(this).load(k86.p(this.s)).placeholder(R.drawable.default_portrait).error(R.drawable.default_portrait).transform(new RoundedCornersTransformation(13, 0)).into(this.q);
        }
        Z1();
    }

    public final void Y1() {
        View viewInflate = LayoutInflater.from(AppContext.getContext()).inflate(R.layout.layout_mend_dialog, (ViewGroup) null);
        this.w = (ProgressBar) viewInflate.findViewById(R.id.progress_bar);
        a2();
        MaterialDialog materialDialogE = new sd3(this).b(false).p(viewInflate, true).L(null).g(new g()).P(null).e();
        this.v = materialDialogE;
        materialDialogE.setCanceledOnTouchOutside(false);
        this.v.show();
    }

    public final void Z1() {
        this.r.setEnabled(k86.I(this.s));
    }

    public final void a2() {
        if (this.x != null) {
            return;
        }
        this.C = false;
        this.x = new Timer();
        f fVar = new f();
        this.B = fVar;
        this.A = 0;
        if (this.y <= 60) {
            this.x.schedule(fVar, 0L, 250L);
        }
    }

    public final void b2() {
        this.C = true;
        Timer timer = this.x;
        if (timer != null) {
            timer.cancel();
            this.x = null;
        }
        TimerTask timerTask = this.B;
        if (timerTask != null) {
            timerTask.cancel();
            this.B = null;
        }
    }

    public final void c2() {
        d2(false);
    }

    public final void d2(boolean z) {
        if (this.y < 100) {
            this.y = 0;
            b2();
        }
        V1();
        if (z) {
            sy5.e(AppContext.getContext(), R.string.mend_update_session_error, 0).g();
        } else {
            showRequestFailDialog(null, getString(R.string.profile_fail));
        }
    }

    public final void e2() {
        this.z = true;
        Y1();
        f2();
    }

    public final void f2() {
        dq3 dq3Var = new dq3(new d(), new e(), this.s, true);
        this.t = dq3Var;
        try {
            dq3Var.n();
        } catch (Exception e2) {
            e2.printStackTrace();
            c2();
        }
    }

    public final void g2() {
        LogUtil.i(BaseActionBarActivity.TAG, "uploadSuccess slide");
        this.r.setClickable(true);
        this.z = false;
        this.y = 100;
        this.w.setProgress(100);
        b2();
        sy5.e(this, R.string.mend_update_success, 0).g();
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2 && i2 == -1) {
            String stringExtra = intent.getStringExtra("media_pick_photo_key");
            if (k86.I(stringExtra)) {
                this.s = stringExtra;
                hc2.b(this).load(k86.p(this.s)).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(R.drawable.default_portrait).error(R.drawable.default_portrait).transform(new RoundedCornersTransformation(13, 0)).into(this.q);
                Z1();
            }
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_complete_photo);
        W1();
        X1();
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, k86.a("key_complete_photo_show"), Boolean.TRUE);
        LogUtil.uploadInfoImmediate("96001", "1", null, null);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        dq3 dq3Var = this.t;
        if (dq3Var != null) {
            dq3Var.onCancel();
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        return true;
    }
}
