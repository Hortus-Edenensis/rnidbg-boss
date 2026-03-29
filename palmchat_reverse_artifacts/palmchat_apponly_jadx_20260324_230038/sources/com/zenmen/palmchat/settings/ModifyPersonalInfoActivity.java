package com.zenmen.palmchat.settings;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.constant.az;
import com.litesuits.async.AsyncTask;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.cq3;
import defpackage.dt;
import defpackage.dt2;
import defpackage.gr2;
import defpackage.hx3;
import defpackage.il5;
import defpackage.iq5;
import defpackage.je1;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.yy2;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ModifyPersonalInfoActivity extends BaseActionBarActivity {
    public String A;
    public RelativeLayout B;
    public TextView C;
    public EditText E;
    public je1 F;
    public dt G;
    public cq3 H;
    public AsyncTask<Integer, Void, Boolean> I;
    public TextView q;
    public TextView r;
    public EditText s;
    public View t;
    public EffectiveShapeView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public String y;
    public int z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.ErrorListener {
        public a() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.i("bindAccount", "error =" + volleyError.toString());
            ModifyPersonalInfoActivity.this.hideBaseProgressBar();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {
        public b() {
            put(az.at, ModifyPersonalInfoActivity.this.A);
            put("type", Integer.valueOf(ModifyPersonalInfoActivity.this.z));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.Listener<JSONObject> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends AsyncTask<Integer, Void, Boolean> {
            public a() {
            }

            @Override // com.litesuits.async.AsyncTask
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            public Boolean g(Integer... numArr) {
                if (numArr[0].intValue() != 0) {
                    return Boolean.FALSE;
                }
                iq5.j(true, new String[0]);
                return Boolean.TRUE;
            }

            @Override // com.litesuits.async.AsyncTask
            /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
            public void n(Boolean bool) {
                super.n(bool);
                ModifyPersonalInfoActivity.this.hideBaseProgressBar();
                if (bool.booleanValue()) {
                    Intent intent = new Intent();
                    String string = ModifyPersonalInfoActivity.this.z == 0 ? ModifyPersonalInfoActivity.this.s.getText().toString() : (ModifyPersonalInfoActivity.this.z == 1 || ModifyPersonalInfoActivity.this.z == 3) ? ModifyPersonalInfoActivity.this.E.getText().toString() : "";
                    intent.putExtra("info", string);
                    ModifyPersonalInfoActivity.this.setResult(-1, intent);
                    ModifyPersonalInfoActivity.this.finish();
                }
            }
        }

        public c() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.i("Save", "response=" + jSONObject.toString());
            ModifyPersonalInfoActivity.this.I = new a();
            try {
                int i = jSONObject.getInt("resultCode");
                if (i == 0) {
                    ModifyPersonalInfoActivity.this.I.h(Integer.valueOf(i));
                } else {
                    ModifyPersonalInfoActivity.this.hideBaseProgressBar();
                    ModifyPersonalInfoActivity.this.showRequestFailDialog(yy2.a(jSONObject), ModifyPersonalInfoActivity.this.getString(R.string.send_failed));
                }
            } catch (JSONException e) {
                e.printStackTrace();
                ModifyPersonalInfoActivity.this.hideBaseProgressBar();
                sy5.e(ModifyPersonalInfoActivity.this, R.string.save_failure, 1).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.ErrorListener {
        public d() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.i("Save", "error=" + volleyError.toString());
            ModifyPersonalInfoActivity.this.hideBaseProgressBar();
            sy5.e(ModifyPersonalInfoActivity.this, R.string.save_failure, 1).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HashMap f15206a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15207a;

            public a(String str) {
                this.f15207a = str;
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                ModifyPersonalInfoActivity.this.N1(this.f15207a);
                super.onPositive(materialDialog);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {
            public b() {
                put(az.at, ModifyPersonalInfoActivity.this.A);
                put("type", Integer.valueOf(ModifyPersonalInfoActivity.this.z));
            }
        }

        public e(HashMap map) {
            this.f15206a = map;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x00ad A[PHI: r8
          0x00ad: PHI (r8v42 java.lang.String) = (r8v39 java.lang.String), (r8v52 java.lang.String) binds: [B:18:0x00a1, B:13:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String string;
            String string2;
            if (!hx3.m(AppContext.getContext())) {
                sy5.e(ModifyPersonalInfoActivity.this, R.string.net_status_unavailable, 1).g();
                return;
            }
            int i = ModifyPersonalInfoActivity.this.z;
            if (i != 0) {
                string = "";
                if (i == 1) {
                    string2 = ModifyPersonalInfoActivity.this.E.getText().toString();
                    if (!ModifyPersonalInfoActivity.this.O1(string2)) {
                        ModifyPersonalInfoActivity.this.E.setText("");
                    }
                } else if (i == 2) {
                    String string3 = ModifyPersonalInfoActivity.this.s.getText().toString();
                    new sd3(ModifyPersonalInfoActivity.this).T(R.string.update_install_dialog_title).k(ModifyPersonalInfoActivity.this.getString(R.string.set_accout_confirm_tips, string3)).O(R.string.alert_dialog_ok).K(R.string.alert_dialog_cancel).f(new a(string3)).e().show();
                    return;
                } else if (i == 3) {
                    string2 = ModifyPersonalInfoActivity.this.E.getText().toString();
                    if (ModifyPersonalInfoActivity.this.O1(string2)) {
                        string = string2;
                    } else {
                        ModifyPersonalInfoActivity.this.E.setText("");
                    }
                }
            } else {
                string = ModifyPersonalInfoActivity.this.s.getText().toString();
            }
            if (il5.p(string) && ModifyPersonalInfoActivity.this.z == 0) {
                new sd3(ModifyPersonalInfoActivity.this).T(R.string.update_install_dialog_title).k(ModifyPersonalInfoActivity.this.getString(R.string.set_nick_tips)).O(R.string.alert_dialog_ok).f(null).e().show();
                return;
            }
            if (ModifyPersonalInfoActivity.this.z == 0) {
                this.f15206a.put("nickname", string);
            } else if (ModifyPersonalInfoActivity.this.z == 1) {
                this.f15206a.put(com.umeng.ccg.a.A, string);
            } else if (ModifyPersonalInfoActivity.this.z == 3) {
                this.f15206a.put("hobby", string);
            }
            try {
                ModifyPersonalInfoActivity.this.showBaseProgressBar(R.string.progress_sending, false);
                ModifyPersonalInfoActivity.this.H.n(this.f15206a);
            } catch (DaoException e) {
                e.printStackTrace();
                ModifyPersonalInfoActivity.this.hideBaseProgressBar();
            } catch (JSONException e2) {
                e2.printStackTrace();
                ModifyPersonalInfoActivity.this.hideBaseProgressBar();
            }
            LogUtil.uploadInfoImmediate("97003", new b());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends NumberKeyListener {
        public f() {
        }

        @Override // android.text.method.NumberKeyListener
        public char[] getAcceptedChars() {
            return "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_-".toCharArray();
        }

        @Override // android.text.method.KeyListener
        public int getInputType() {
            return 33;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements TextView.OnEditorActionListener {
        public h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            return keyEvent != null && keyEvent.getKeyCode() == 66;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15213a;

        public j(String str) {
            this.f15213a = str;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.i("bindAccount", "response = " + jSONObject.toString());
            ModifyPersonalInfoActivity.this.hideBaseProgressBar();
            try {
                int i = jSONObject.getInt("resultCode");
                String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
                if (i == 0) {
                    iq5.j(false, new String[0]);
                    Intent intent = new Intent(ModifyPersonalInfoActivity.this, (Class<?>) BindAccoutResultActivity.class);
                    intent.putExtra("info", this.f15213a);
                    ModifyPersonalInfoActivity.this.setResult(-1, intent);
                    ModifyPersonalInfoActivity.this.startActivity(intent);
                    ModifyPersonalInfoActivity.this.finish();
                } else if (i == 1107) {
                    new sd3(ModifyPersonalInfoActivity.this).j(R.string.accout_exist).O(R.string.alert_dialog_ok).e().show();
                } else if (i == 1106) {
                    iq5.j(false, new String[0]);
                    sy5.f(ModifyPersonalInfoActivity.this, strOptString, 1).g();
                    ModifyPersonalInfoActivity.this.finish();
                } else {
                    ModifyPersonalInfoActivity modifyPersonalInfoActivity = ModifyPersonalInfoActivity.this;
                    modifyPersonalInfoActivity.showRequestFailDialog(strOptString, modifyPersonalInfoActivity.getString(R.string.save_failure));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final void N1(String str) {
        this.G = new dt(new j(str), new a());
        showBaseProgressBar(R.string.progress_sending, false);
        try {
            this.G.n(str);
        } catch (DaoException e2) {
            e2.printStackTrace();
            hideBaseProgressBar();
        } catch (JSONException e3) {
            e3.printStackTrace();
            hideBaseProgressBar();
        }
    }

    public final boolean O1(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (!Character.isWhitespace(str.charAt(i2))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void P1() {
        Intent intent = getIntent();
        this.z = intent.getIntExtra("mode", 0);
        this.y = intent.getStringExtra("info");
        String stringExtra = intent.getStringExtra(az.at);
        this.A = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            this.A = MapController.DEFAULT_LAYER_TAG;
        }
    }

    public final void Q1() {
        HashMap map = new HashMap();
        this.H = new cq3(new c(), new d());
        this.q.setOnClickListener(new e(map));
    }

    public final void R1() {
        EditText editText = (EditText) findViewById(R.id.edit_text);
        this.s = editText;
        if (this.z == 2) {
            editText.setKeyListener(new f());
        }
        this.s.addTextChangedListener(new g());
        this.B = (RelativeLayout) findViewById(R.id.contentLayout);
        this.C = (TextView) findViewById(R.id.count);
        EditText editText2 = (EditText) findViewById(R.id.edit_text_sign);
        this.E = editText2;
        editText2.setOnEditorActionListener(new h());
        this.E.addTextChangedListener(new i());
        this.t = findViewById(R.id.account_area);
        EffectiveShapeView effectiveShapeView = (EffectiveShapeView) findViewById(R.id.portrait);
        this.u = effectiveShapeView;
        effectiveShapeView.changeShapeType(1);
        this.u.setDegreeForRoundRectangle(13, 13);
        this.v = (TextView) findViewById(R.id.nick_name);
        this.w = (TextView) findViewById(R.id.account);
        this.x = (TextView) findViewById(R.id.tips);
        int i2 = this.z;
        if (i2 == 0) {
            this.r.setText(getText(R.string.modify_personal_info_actionbar_title_nickname));
            if (!TextUtils.isEmpty(this.y)) {
                this.s.setText(this.y);
            }
            if (!TextUtils.isEmpty(this.s.getText())) {
                Selection.setSelection(this.s.getText(), this.s.getText().length());
            }
            this.x.setText(R.string.nick_name_tips);
            this.x.setVisibility(0);
            this.s.requestFocus();
        } else if (i2 == 1) {
            this.B.setVisibility(0);
            this.s.setVisibility(8);
            this.r.setText(getText(R.string.modify_personal_info_actionbar_title_signature));
            if (!TextUtils.isEmpty(this.y)) {
                this.E.setText(this.y);
            }
            if (!TextUtils.isEmpty(this.E.getText())) {
                Selection.setSelection(this.E.getText(), this.E.getText().length());
            }
        } else if (i2 == 2) {
            this.r.setText(R.string.set_account);
            String stringExtra = getIntent().getStringExtra("info_2");
            if (!TextUtils.isEmpty(stringExtra)) {
                gr2.j().h(stringExtra, this.u, this.F);
            }
            this.v.setText(this.y);
            this.t.setVisibility(0);
            this.x.setText(R.string.account_tips);
            this.x.setVisibility(0);
            this.s.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        } else if (i2 == 3) {
            this.B.setVisibility(0);
            this.s.setVisibility(8);
            this.r.setText(getText(R.string.modify_personal_info_actionbar_title_hobby));
            if (!TextUtils.isEmpty(this.y)) {
                this.E.setText(this.y);
            }
            if (!TextUtils.isEmpty(this.E.getText())) {
                Selection.setSelection(this.E.getText(), this.E.getText().length());
            }
        }
        this.q.setEnabled(false);
    }

    public final void initActionBar() {
        initToolbar(-1);
        TextView textView = (TextView) getToolbar().findViewById(R.id.action_button);
        this.q = textView;
        textView.setText(R.string.string_save);
        TextView textView2 = (TextView) getToolbar().findViewById(R.id.title);
        this.r = textView2;
        textView2.setText(R.string.modify_personal_info_actionbar_title_nickname);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_modify_personal_info);
        this.F = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).B(R.drawable.default_portrait).A(R.drawable.default_portrait).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();
        P1();
        initActionBar();
        R1();
        Q1();
        LogUtil.uploadInfoImmediate("97002", new b());
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        dt dtVar = this.G;
        if (dtVar != null) {
            dtVar.onCancel();
        }
        cq3 cq3Var = this.H;
        if (cq3Var != null) {
            cq3Var.onCancel();
        }
        super.onDestroy();
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
    public class g implements TextWatcher {
        public g() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (ModifyPersonalInfoActivity.this.z != 2) {
                if (ModifyPersonalInfoActivity.this.z != 0) {
                    ModifyPersonalInfoActivity.this.q.setEnabled(true);
                    return;
                } else {
                    dt2.d(ModifyPersonalInfoActivity.this.s, charSequence, 32);
                    ModifyPersonalInfoActivity.this.q.setEnabled(true);
                    return;
                }
            }
            String string = ModifyPersonalInfoActivity.this.s.getText().toString();
            ModifyPersonalInfoActivity.this.w.setVisibility(TextUtils.isEmpty(string) ? 8 : 0);
            ModifyPersonalInfoActivity.this.w.setText(ModifyPersonalInfoActivity.this.getString(R.string.user_detail_accout, string));
            if (dt2.c("^[a-zA-Z][a-zA-Z0-9_\\-]{5,19}$", string)) {
                ModifyPersonalInfoActivity.this.q.setEnabled(true);
                ModifyPersonalInfoActivity.this.x.setTextColor(ModifyPersonalInfoActivity.this.getResources().getColor(R.color.text_color_999));
                ModifyPersonalInfoActivity.this.x.setText(R.string.account_tips);
            } else {
                ModifyPersonalInfoActivity.this.q.setEnabled(false);
                ModifyPersonalInfoActivity.this.x.setTextColor(ModifyPersonalInfoActivity.this.getResources().getColor(R.color.draft_color));
                ModifyPersonalInfoActivity.this.x.setText(R.string.account_rule_tips);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements TextWatcher {
        public i() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ModifyPersonalInfoActivity.this.q.setEnabled(true);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int iD = dt2.d(ModifyPersonalInfoActivity.this.E, charSequence, 60);
            if (iD <= 60) {
                ModifyPersonalInfoActivity.this.C.setText(((int) Math.floor(((double) (60 - iD)) * 0.5d)) + "");
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
