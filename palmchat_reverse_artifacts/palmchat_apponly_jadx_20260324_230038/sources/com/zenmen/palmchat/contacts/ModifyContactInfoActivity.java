package com.zenmen.palmchat.contacts;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bo0;
import defpackage.bq3;
import defpackage.dt2;
import defpackage.fn0;
import defpackage.ho0;
import defpackage.ie2;
import defpackage.il5;
import defpackage.iq5;
import defpackage.sd3;
import defpackage.sy5;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ModifyContactInfoActivity extends BaseActionBarActivity {
    public TextView A;
    public String B;
    public String C;
    public String E;
    public String F;
    public String G;
    public String[] I;
    public String J;
    public String L;
    public bq3 M;
    public TextView q;
    public TextView r;
    public EditText s;
    public ViewGroup t;
    public TextView u;
    public TextView v;
    public EditText w;
    public ViewGroup x;
    public EditText[] y;
    public EditText z;
    public boolean H = false;
    public boolean K = false;
    public TextWatcher N = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Response.Listener<JSONObject> {
            public a() {
            }

            @Override // com.android.volley.Response.Listener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponse(JSONObject jSONObject) {
                LogUtil.i("Save", "response=" + jSONObject.toString());
                ModifyContactInfoActivity.this.hideBaseProgressBar();
                try {
                    if (jSONObject.getInt("resultCode") != 0) {
                        sy5.e(ModifyContactInfoActivity.this, R.string.save_failure, 1).g();
                        return;
                    }
                    if (!ModifyContactInfoActivity.this.K) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("contact_operation", (Integer) 1);
                        contentValues.put(DeviceInfoUtil.UID_TAG, ModifyContactInfoActivity.this.B);
                        contentValues.put("nick_name", ModifyContactInfoActivity.this.E);
                        contentValues.put("head_img_url", ModifyContactInfoActivity.this.C);
                        contentValues.put("remark_name", ModifyContactInfoActivity.this.s.getText().toString());
                        contentValues.put("description", ModifyContactInfoActivity.this.z.getText().toString());
                        contentValues.put("data2", (Integer) 1);
                        ModifyContactInfoActivity.this.getContentResolver().insert(ho0.f18003a, contentValues);
                        ie2.c(ModifyContactInfoActivity.this.B, ModifyContactInfoActivity.this.s.getText().toString());
                        bo0.r().i().i(ModifyContactInfoActivity.this.i2());
                    }
                    iq5.j(false, new String[0]);
                    ModifyContactInfoActivity.this.finish();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        /* JADX INFO: renamed from: com.zenmen.palmchat.contacts.ModifyContactInfoActivity$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1016b implements Response.ErrorListener {
            public C1016b() {
            }

            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                LogUtil.i("Save", "error=" + volleyError.toString());
                ModifyContactInfoActivity.this.hideBaseProgressBar();
                sy5.e(ModifyContactInfoActivity.this, R.string.sent_request_failed, 1).g();
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = new a();
            C1016b c1016b = new C1016b();
            HashMap map = new HashMap();
            ModifyContactInfoActivity.this.M = new bq3(aVar, c1016b);
            map.put("fuid", ModifyContactInfoActivity.this.B);
            if (TextUtils.isEmpty(il5.q(ModifyContactInfoActivity.this.s.getText().toString()))) {
                map.put("remarkName", il5.q(ModifyContactInfoActivity.this.s.getText().toString()));
            } else {
                map.put("remarkName", ModifyContactInfoActivity.this.s.getText().toString());
            }
            map.put("description", ModifyContactInfoActivity.this.z.getText().toString());
            if (ModifyContactInfoActivity.this.K) {
                map.put("remarkTel", ModifyContactInfoActivity.this.Z1());
            }
            try {
                ModifyContactInfoActivity.this.showBaseProgressBar(R.string.progress_sending, false);
                ModifyContactInfoActivity.this.M.n(map);
            } catch (DaoException e) {
                e.printStackTrace();
                ModifyContactInfoActivity.this.hideBaseProgressBar();
            } catch (JSONException e2) {
                e2.printStackTrace();
                ModifyContactInfoActivity.this.hideBaseProgressBar();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ModifyContactInfoActivity.this.s.getText().clear();
            ModifyContactInfoActivity.this.s.setText(ModifyContactInfoActivity.this.L);
            Selection.setSelection(ModifyContactInfoActivity.this.s.getText(), ModifyContactInfoActivity.this.s.getText().length());
            ModifyContactInfoActivity.this.t.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            ModifyContactInfoActivity.this.A.setVisibility(0);
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends MaterialDialog.e {
        public g() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            ModifyContactInfoActivity.this.finish();
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            ModifyContactInfoActivity.this.q.performClick();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
                ModifyContactInfoActivity.this.y[0].removeTextChangedListener(ModifyContactInfoActivity.this.N);
                ModifyContactInfoActivity modifyContactInfoActivity = ModifyContactInfoActivity.this;
                modifyContactInfoActivity.j2(modifyContactInfoActivity.y[0]);
                ModifyContactInfoActivity.this.y[0] = (EditText) ((ViewGroup) LayoutInflater.from(ModifyContactInfoActivity.this).inflate(R.layout.phone_edit_text, (ViewGroup) null)).getChildAt(0);
                ModifyContactInfoActivity.this.y[0].addTextChangedListener(ModifyContactInfoActivity.this.N);
                if (ModifyContactInfoActivity.this.a2() == ModifyContactInfoActivity.this.y.length - 1 && ModifyContactInfoActivity.this.Y1().length() > 0) {
                    ModifyContactInfoActivity modifyContactInfoActivity2 = ModifyContactInfoActivity.this;
                    modifyContactInfoActivity2.V1(modifyContactInfoActivity2.X1());
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("data1", "1");
                ModifyContactInfoActivity.this.getContentResolver().update(ho0.f18003a, contentValues, "uid=?", new String[]{ModifyContactInfoActivity.this.B});
                bo0.r().i().i(ModifyContactInfoActivity.this.i2());
            }
        }

        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new sd3(ModifyContactInfoActivity.this).j(R.string.hide_phone_number).O(R.string.hide).K(R.string.get_it).f(new a()).Q();
        }
    }

    public final void V1(EditText editText) {
        if (editText != null) {
            editText.setVisibility(0);
            this.x.addView((ViewGroup) editText.getParent());
        }
    }

    public final void W1() {
        if (h2()) {
            new sd3(this).j(R.string.save_modification).O(R.string.save).K(R.string.not_save).f(new g()).Q();
        } else {
            finish();
        }
    }

    public final EditText X1() {
        int i = 0;
        while (true) {
            EditText[] editTextArr = this.y;
            if (i >= editTextArr.length) {
                return null;
            }
            if (editTextArr[i].getVisibility() == 8) {
                return this.y[i];
            }
            i++;
        }
    }

    public final EditText Y1() {
        return (EditText) ((ViewGroup) this.x.getChildAt(r0.getChildCount() - 1)).getChildAt(0);
    }

    public final String Z1() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < this.x.getChildCount(); i++) {
            EditText editText = (EditText) ((ViewGroup) this.x.getChildAt(i)).getChildAt(0);
            String string = editText.getText().toString();
            if (editText.isEnabled() && !TextUtils.isEmpty(string)) {
                sb.append(string);
                sb.append("$");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public final int a2() {
        int i = 0;
        for (EditText editText : this.y) {
            if (editText.getVisibility() == 0) {
                i++;
            }
        }
        return i;
    }

    public final void b2(EditText editText) {
        ImageView imageView = (ImageView) ((ViewGroup) editText.getParent()).getChildAt(1);
        imageView.setVisibility(0);
        imageView.setOnClickListener(new h());
    }

    public final void c2() {
        Intent intent = getIntent();
        this.B = intent.getStringExtra("fuid");
        this.C = intent.getStringExtra("head_img_url");
        this.E = intent.getStringExtra("nick_name");
        this.F = intent.getStringExtra("remark_name");
        this.G = intent.getStringExtra("register_mobile_number");
        this.H = intent.getBooleanExtra("hide_register_mobile", false);
        this.I = intent.getStringArrayExtra("remark_tel");
        this.K = intent.getBooleanExtra("is_friend", false);
        this.J = intent.getStringExtra("description");
    }

    public final void e2() {
        V1(this.y[0]);
        if (!TextUtils.isEmpty(this.L) && !this.H) {
            this.y[0].setText(this.G);
            this.y[0].setFocusable(false);
            this.y[0].setFocusableInTouchMode(false);
            this.y[0].setEnabled(false);
            b2(this.y[0]);
            V1(this.y[1]);
        }
        if (this.I != null) {
            int i = !this.y[0].isEnabled() ? 1 : 0;
            for (String str : this.I) {
                EditText[] editTextArr = this.y;
                if (i < editTextArr.length) {
                    editTextArr[i].setText(str);
                    i++;
                }
                EditText[] editTextArr2 = this.y;
                if (i < editTextArr2.length) {
                    V1(editTextArr2[i]);
                }
            }
        }
    }

    public final void f2() {
        this.q.setOnClickListener(new b());
    }

    public final void g2() {
        getWindow().setSoftInputMode(2);
        EditText editText = (EditText) findViewById(R.id.nick_name_edit);
        this.w = editText;
        String str = this.E;
        if (str != null) {
            editText.setText(str);
        }
        this.s = (EditText) findViewById(R.id.remark_edit);
        if (!TextUtils.isEmpty(this.F)) {
            this.s.setText(this.F);
            Selection.setSelection(this.s.getText(), this.F.length());
        }
        this.s.addTextChangedListener(new c());
        this.t = (ViewGroup) findViewById(R.id.remark_recommend_layout);
        this.u = (TextView) findViewById(R.id.remark_recommend_text);
        TextView textView = (TextView) findViewById(R.id.remark_recommend_btn);
        this.v = textView;
        textView.setOnClickListener(new d());
        d2();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.phone_layout);
        this.x = viewGroup;
        if (this.K) {
            this.y = new EditText[]{(EditText) ((ViewGroup) getLayoutInflater().inflate(R.layout.phone_edit_text, (ViewGroup) null)).getChildAt(0), (EditText) ((ViewGroup) getLayoutInflater().inflate(R.layout.phone_edit_text, (ViewGroup) null)).getChildAt(0), (EditText) ((ViewGroup) getLayoutInflater().inflate(R.layout.phone_edit_text, (ViewGroup) null)).getChildAt(0), (EditText) ((ViewGroup) getLayoutInflater().inflate(R.layout.phone_edit_text, (ViewGroup) null)).getChildAt(0), (EditText) ((ViewGroup) getLayoutInflater().inflate(R.layout.phone_edit_text, (ViewGroup) null)).getChildAt(0)};
            e2();
            int i = 0;
            while (true) {
                EditText[] editTextArr = this.y;
                if (i >= editTextArr.length) {
                    break;
                }
                editTextArr[i].addTextChangedListener(this.N);
                i++;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        this.z = (EditText) findViewById(R.id.description_edit);
        this.A = (TextView) findViewById(R.id.description_count);
        this.z.addTextChangedListener(new e());
        this.z.setOnTouchListener(new f());
        if (!TextUtils.isEmpty(this.J)) {
            this.z.setText(this.J);
            this.A.setText(((int) Math.floor(((double) (800 - dt2.b(this.J))) * 0.5d)) + "");
        }
        if (TextUtils.isEmpty(this.L)) {
            return;
        }
        if (TextUtils.isEmpty(this.F) && !this.L.equals(this.E)) {
            this.s.getText().clear();
            this.s.setText(this.L);
            Selection.setSelection(this.s.getText(), this.s.getText().length());
        } else {
            if (this.L.equals(this.E) || this.L.equals(this.F)) {
                return;
            }
            this.u.setText(getString(R.string.remark_recommend_by_phonebook, this.L));
            this.t.setVisibility(0);
        }
    }

    public final boolean h2() {
        int i = 0;
        if (this.s == null || this.z == null) {
            return false;
        }
        if (!TextUtils.isEmpty(this.F) ? this.F.equals(this.s.getText().toString()) : this.s.length() <= 0 || this.s.getText().toString().equals(this.E)) {
            return true;
        }
        if (!TextUtils.isEmpty(this.J) ? this.J.equals(this.z.getText().toString()) : this.z.length() <= 0) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if (this.I != null) {
            while (true) {
                String[] strArr = this.I;
                if (i >= strArr.length) {
                    break;
                }
                sb.append(strArr[i]);
                sb.append("$");
                i++;
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return !sb.toString().equals(Z1());
    }

    public fn0 i2() {
        return new fn0();
    }

    public final void initActionBar() {
        setSupportActionBar(initToolbar(-1));
        TextView textView = (TextView) getToolbar().findViewById(R.id.action_button);
        this.q = textView;
        textView.setText(R.string.modify_contact_info_finish);
        this.q.setEnabled(false);
        TextView textView2 = (TextView) getToolbar().findViewById(R.id.title);
        this.r = textView2;
        textView2.setText(getText(R.string.modify_contact_info_remark));
    }

    public final void j2(EditText editText) {
        if (editText != null) {
            editText.setVisibility(8);
            this.x.removeView((ViewGroup) editText.getParent());
            Y1().requestFocus();
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_modify_contact_info);
        c2();
        initActionBar();
        g2();
        f2();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        bq3 bq3Var = this.M;
        if (bq3Var != null) {
            bq3Var.onCancel();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        W1();
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        W1();
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ModifyContactInfoActivity.this.q.setEnabled(ModifyContactInfoActivity.this.h2());
            dt2.d(ModifyContactInfoActivity.this.s, charSequence, 32);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements TextWatcher {
        public e() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ModifyContactInfoActivity.this.q.setEnabled(ModifyContactInfoActivity.this.h2());
            int iD = dt2.d(ModifyContactInfoActivity.this.z, charSequence, 800);
            if (iD <= 800) {
                ModifyContactInfoActivity.this.A.setText(((int) Math.floor(((double) (800 - iD)) * 0.5d)) + "");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public final void d2() {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ModifyContactInfoActivity.this.q.setEnabled(ModifyContactInfoActivity.this.h2());
            for (int i = 0; i < ModifyContactInfoActivity.this.y.length; i++) {
                EditText editText = ModifyContactInfoActivity.this.y[i];
                if (editText.getText() == editable) {
                    int iA2 = ModifyContactInfoActivity.this.a2();
                    if (editable.length() != 0 || iA2 <= 1) {
                        if (editable.length() <= 0 || ModifyContactInfoActivity.this.Y1() != editText) {
                            return;
                        }
                        ModifyContactInfoActivity modifyContactInfoActivity = ModifyContactInfoActivity.this;
                        modifyContactInfoActivity.V1(modifyContactInfoActivity.X1());
                        return;
                    }
                    ModifyContactInfoActivity.this.j2(editText);
                    if (iA2 - 1 == 0 || ModifyContactInfoActivity.this.Y1().length() != 0) {
                        ModifyContactInfoActivity modifyContactInfoActivity2 = ModifyContactInfoActivity.this;
                        modifyContactInfoActivity2.V1(modifyContactInfoActivity2.X1());
                        return;
                    }
                    return;
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
