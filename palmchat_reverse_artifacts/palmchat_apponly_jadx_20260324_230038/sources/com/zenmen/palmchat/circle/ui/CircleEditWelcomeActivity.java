package com.zenmen.palmchat.circle.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.MediaPickActivity;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import defpackage.c70;
import defpackage.gr2;
import defpackage.j56;
import defpackage.j70;
import defpackage.je1;
import defpackage.k80;
import defpackage.k86;
import defpackage.l50;
import defpackage.sy5;
import defpackage.wi0;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleEditWelcomeActivity extends BaseActionBarActivity {
    public String q;
    public EditText r;
    public TextView s;
    public ImageView t;
    public TextView u;
    public Toolbar v;
    public String w = null;
    public k80 x;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse<GroupInfoItem>> {
        public a() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<GroupInfoItem> baseResponse) {
            CircleEditWelcomeActivity.this.hideBaseProgressBar();
            if (baseResponse == null || baseResponse.getData() == null) {
                sy5.f(CircleEditWelcomeActivity.this, "数据错误", 0).g();
                CircleEditWelcomeActivity.this.finish();
                return;
            }
            String welContent = baseResponse.getData().getWelContent();
            CircleEditWelcomeActivity.this.r.setHint("请输入新人欢迎语（500字以内）");
            if (TextUtils.isEmpty(welContent)) {
                return;
            }
            CircleEditWelcomeActivity.this.r.setText(welContent);
            CircleEditWelcomeActivity.this.r.setSelection(welContent.length());
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
            CircleEditWelcomeActivity.this.H1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CircleEditWelcomeActivity.this.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
            if (TextUtils.isEmpty(CircleEditWelcomeActivity.this.w)) {
                CircleEditWelcomeActivity.this.J1(null);
            } else {
                CircleEditWelcomeActivity.this.L1();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements j56 {
        public e() {
        }

        @Override // defpackage.j56
        public void onFailed(Throwable th) {
            CircleEditWelcomeActivity.this.hideBaseProgressBar();
            sy5.e(CircleEditWelcomeActivity.this, R.string.send_failed, 0).g();
        }

        @Override // defpackage.j56
        public void onSuccess(String str, String str2) {
            CircleEditWelcomeActivity.this.J1(str2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends wi0<BaseResponse> {
        public f() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CircleEditWelcomeActivity.this.hideBaseProgressBar();
            if (baseResponse.getResultCode() == 0) {
                sy5.e(CircleEditWelcomeActivity.this, R.string.send_success, 0).g();
                Intent intent = CircleEditWelcomeActivity.this.getIntent();
                intent.putExtra("intent_wel_content", CircleEditWelcomeActivity.this.r.getText().toString());
                CircleEditWelcomeActivity.this.setResult(-1, intent);
                CircleEditWelcomeActivity.this.finish();
                return;
            }
            if (CircleEditWelcomeActivity.this.x.d(CircleEditWelcomeActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                return;
            }
            if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                sy5.e(CircleEditWelcomeActivity.this, R.string.send_failed, 0).g();
            } else {
                sy5.f(CircleEditWelcomeActivity.this, baseResponse.getErrorMsg(), 0).g();
            }
        }
    }

    public final void H1() {
        Intent intent = new Intent(this, (Class<?>) MediaPickActivity.class);
        intent.putExtra("select_mode_key", 1);
        intent.putExtra("crop_portrait", false);
        intent.putExtra("crop_max_size", 1280);
        startActivityForResult(intent, 1);
    }

    public final boolean I1() {
        if (TextUtils.isEmpty(this.w)) {
            return true;
        }
        return new File(this.w).delete();
    }

    public final void J1(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(str);
        }
        c70.R().z0(this.q, this.r.getText().toString(), arrayList, new f());
    }

    public final void K1() {
        if (TextUtils.isEmpty(this.w)) {
            this.t.setImageResource(R.drawable.circle_add_pic);
        } else {
            gr2.j().h(k86.p(this.w), this.t, new je1.a().s(false).t(false).u(true).q(Bitmap.Config.RGB_565).B(R.drawable.circle_add_pic).A(R.drawable.circle_add_pic).z(R.drawable.circle_add_pic).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r());
        }
    }

    public final void L1() {
        c70.R().H0(this.w, new e());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            String stringExtra = intent.getStringExtra("media_pick_photo_key");
            if (k86.I(stringExtra) && I1()) {
                String str = stringExtra + "." + System.currentTimeMillis();
                if (new File(stringExtra).renameTo(new File(str))) {
                    this.w = str;
                    K1();
                }
            }
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_welcome);
        Toolbar toolbarInitToolbar = initToolbar("");
        this.v = toolbarInitToolbar;
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText("新人欢迎语");
        setSupportActionBar(this.v);
        TextView textView = (TextView) findViewById(R.id.action_button);
        this.u = textView;
        textView.setTextColor(getResources().getColor(R.color.color_262626));
        this.u.setBackgroundDrawable(null);
        this.u.setText("发布");
        this.r = (EditText) findViewById(R.id.circle_edit_welcome_edit);
        this.s = (TextView) findViewById(R.id.circle_edit_welcome_hint);
        this.t = (ImageView) findViewById(R.id.circle_edit_welcome_img);
        this.q = getIntent().getStringExtra(j70.f18338a);
        showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        c70.R().S(this.q, new a());
        this.r.addTextChangedListener(new b());
        this.t.setOnClickListener(new c());
        this.u.setOnClickListener(new d());
        this.x = new k80(this.q);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            CircleEditWelcomeActivity.this.s.setText(editable.toString().length() + "/500");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
