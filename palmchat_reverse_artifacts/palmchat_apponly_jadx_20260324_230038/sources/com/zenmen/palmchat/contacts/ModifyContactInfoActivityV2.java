package com.zenmen.palmchat.contacts;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
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
import com.zenmen.palmchat.widget.ClearEditText;
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
import defpackage.vn0;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ModifyContactInfoActivityV2 extends BaseActionBarActivity {
    public String A;
    public String B;
    public String C;
    public String E;
    public String[] G;
    public String H;
    public bq3 K;
    public TextView q;
    public TextView r;
    public ClearEditText s;
    public TextView t;
    public EditText u;
    public ViewGroup v;
    public EditText[] w;
    public EditText x;
    public TextView y;
    public String z;
    public boolean F = false;
    public boolean I = false;
    public String[] J = new String[3];
    public TextWatcher L = new a();

    /* JADX INFO: compiled from: SearchBox */
    public static class NoUnderlineSpan extends UnderlineSpan {
        @Override // android.text.style.UnderlineSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(Color.parseColor("#009687"));
            textPaint.setUnderlineText(false);
        }
    }

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
                ModifyContactInfoActivityV2.this.hideBaseProgressBar();
                try {
                    if (jSONObject.getInt("resultCode") != 0) {
                        sy5.e(ModifyContactInfoActivityV2.this, R.string.save_failure, 1).g();
                        return;
                    }
                    if (!ModifyContactInfoActivityV2.this.I) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("contact_operation", (Integer) 1);
                        contentValues.put(DeviceInfoUtil.UID_TAG, ModifyContactInfoActivityV2.this.z);
                        contentValues.put("nick_name", ModifyContactInfoActivityV2.this.B);
                        contentValues.put("head_img_url", ModifyContactInfoActivityV2.this.A);
                        contentValues.put("remark_name", ModifyContactInfoActivityV2.this.s.getText().toString());
                        contentValues.put("description", ModifyContactInfoActivityV2.this.x.getText().toString());
                        contentValues.put("data2", (Integer) 1);
                        ModifyContactInfoActivityV2.this.getContentResolver().insert(ho0.f18003a, contentValues);
                        ie2.c(ModifyContactInfoActivityV2.this.z, ModifyContactInfoActivityV2.this.s.getText().toString());
                        bo0.r().i().i(ModifyContactInfoActivityV2.this.m2());
                    }
                    iq5.j(false, new String[0]);
                    ModifyContactInfoActivityV2.this.finish();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        /* JADX INFO: renamed from: com.zenmen.palmchat.contacts.ModifyContactInfoActivityV2$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1017b implements Response.ErrorListener {
            public C1017b() {
            }

            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                LogUtil.i("Save", "error=" + volleyError.toString());
                ModifyContactInfoActivityV2.this.hideBaseProgressBar();
                sy5.e(ModifyContactInfoActivityV2.this, R.string.sent_request_failed, 1).g();
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtil.uploadInfoImmediate("comment_finish", "1", null, null);
            a aVar = new a();
            C1017b c1017b = new C1017b();
            HashMap map = new HashMap();
            ModifyContactInfoActivityV2.this.K = new bq3(aVar, c1017b);
            map.put("fuid", ModifyContactInfoActivityV2.this.z);
            if (TextUtils.isEmpty(il5.q(ModifyContactInfoActivityV2.this.s.getText().toString()))) {
                map.put("remarkName", il5.q(ModifyContactInfoActivityV2.this.s.getText().toString()));
            } else {
                map.put("remarkName", ModifyContactInfoActivityV2.this.s.getText().toString());
            }
            map.put("description", ModifyContactInfoActivityV2.this.x.getText().toString());
            if (ModifyContactInfoActivityV2.this.I) {
                map.put("remarkTel", ModifyContactInfoActivityV2.this.d2());
            }
            try {
                ModifyContactInfoActivityV2.this.showBaseProgressBar(R.string.progress_sending, false);
                ModifyContactInfoActivityV2.this.K.n(map);
            } catch (DaoException e) {
                e.printStackTrace();
                ModifyContactInfoActivityV2.this.hideBaseProgressBar();
            } catch (JSONException e2) {
                e2.printStackTrace();
                ModifyContactInfoActivityV2.this.hideBaseProgressBar();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnTouchListener {
        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            ModifyContactInfoActivityV2.this.y.setVisibility(0);
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ModifyContactInfoActivityV2.this.s.setText(ModifyContactInfoActivityV2.this.J[0]);
            ModifyContactInfoActivityV2.this.s.setSelection(ModifyContactInfoActivityV2.this.s.getText().length());
            ModifyContactInfoActivityV2.this.t.setVisibility(8);
            LogUtil.uploadInfoImmediate("remark_tip_click", "1", null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends MaterialDialog.e {
        public g() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            ModifyContactInfoActivityV2.this.finish();
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            ModifyContactInfoActivityV2.this.q.performClick();
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
                ModifyContactInfoActivityV2.this.w[0].removeTextChangedListener(ModifyContactInfoActivityV2.this.L);
                ModifyContactInfoActivityV2 modifyContactInfoActivityV2 = ModifyContactInfoActivityV2.this;
                modifyContactInfoActivityV2.n2(modifyContactInfoActivityV2.w[0]);
                ModifyContactInfoActivityV2.this.w[0] = (EditText) ((ViewGroup) LayoutInflater.from(ModifyContactInfoActivityV2.this).inflate(R.layout.phone_edit_text_v2, (ViewGroup) null)).getChildAt(0);
                ModifyContactInfoActivityV2.this.w[0].addTextChangedListener(ModifyContactInfoActivityV2.this.L);
                if (ModifyContactInfoActivityV2.this.f2() == ModifyContactInfoActivityV2.this.w.length - 1 && ModifyContactInfoActivityV2.this.Z1().length() > 0) {
                    ModifyContactInfoActivityV2 modifyContactInfoActivityV22 = ModifyContactInfoActivityV2.this;
                    modifyContactInfoActivityV22.V1(modifyContactInfoActivityV22.Y1());
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("data1", "1");
                ModifyContactInfoActivityV2.this.getContentResolver().update(ho0.f18003a, contentValues, "uid=?", new String[]{ModifyContactInfoActivityV2.this.z});
                bo0.r().i().i(ModifyContactInfoActivityV2.this.m2());
            }
        }

        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new sd3(ModifyContactInfoActivityV2.this).j(R.string.hide_phone_number).O(R.string.hide).K(R.string.get_it).f(new a()).Q();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class i extends ClickableSpan implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View.OnClickListener f13362a;

        public i(View.OnClickListener onClickListener) {
            this.f13362a = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.view.View.OnClickListener
        public void onClick(View view) {
            this.f13362a.onClick(view);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(Color.parseColor("#009687"));
            textPaint.setUnderlineText(false);
        }
    }

    public final void V1(EditText editText) {
        if (editText != null) {
            editText.setVisibility(0);
            this.v.addView((ViewGroup) editText.getParent());
        }
    }

    public final void W1() {
        if (l2()) {
            new sd3(this).j(R.string.save_modification).O(R.string.save).K(R.string.not_save).f(new g()).Q();
        } else {
            finish();
        }
    }

    public String X1(String str) {
        if (str == null || str.length() <= 2 || str.length() > 7 || !str.startsWith("我是")) {
            return "";
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (19968 > cCharAt || cCharAt >= 40869) {
                return "";
            }
        }
        return str.substring(2);
    }

    public final EditText Y1() {
        int i2 = 0;
        while (true) {
            EditText[] editTextArr = this.w;
            if (i2 >= editTextArr.length) {
                return null;
            }
            if (editTextArr[i2].getVisibility() == 8) {
                return this.w[i2];
            }
            i2++;
        }
    }

    public final EditText Z1() {
        return (EditText) ((ViewGroup) this.v.getChildAt(r0.getChildCount() - 1)).getChildAt(0);
    }

    public final String a2() {
        return "";
    }

    public final String[] b2() {
        String[] strArr = new String[3];
        String strA2 = a2();
        if (TextUtils.isEmpty(strA2)) {
            String strX1 = X1(e2());
            if (!TextUtils.isEmpty(strX1)) {
                String string = getString(R.string.remark_recommend_by_info, strX1);
                String string2 = getString(R.string.remark_recommend_by_info_confirm);
                strArr[0] = strX1;
                strArr[1] = string;
                strArr[2] = string2;
            }
        } else {
            String string3 = getString(R.string.remark_recommend_by_phonebook_b, strA2);
            String string4 = getString(R.string.remark_recommend_by_phonebook_confirm);
            strArr[0] = strA2;
            strArr[1] = string3;
            strArr[2] = string4;
        }
        return strArr;
    }

    public final CharSequence c2() {
        f fVar = new f();
        String str = this.J[1] + " " + this.J[2] + "\u200b";
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new i(fVar), (str.length() - this.J[2].length()) - 1, str.length() - 1, 33);
        return spannableString;
    }

    public final String d2() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 1; i2 < this.v.getChildCount(); i2++) {
            EditText editText = (EditText) ((ViewGroup) this.v.getChildAt(i2)).getChildAt(0);
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

    public final String e2() {
        Cursor cursorQuery;
        if (TextUtils.isEmpty(this.z)) {
            return "";
        }
        try {
            cursorQuery = getContentResolver().query(vn0.f21483a, new String[]{"request_info"}, "from_uid=?", new String[]{this.z}, "_id DESC ");
        } catch (Exception e2) {
            e2.printStackTrace();
            cursorQuery = null;
        }
        if (cursorQuery == null) {
            return "";
        }
        while (cursorQuery.moveToNext()) {
            String string = cursorQuery.getString(0);
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        cursorQuery.close();
        return "";
    }

    public final int f2() {
        int i2 = 0;
        for (EditText editText : this.w) {
            if (editText.getVisibility() == 0) {
                i2++;
            }
        }
        return i2;
    }

    public final void g2(EditText editText) {
        ImageView imageView = (ImageView) ((ViewGroup) editText.getParent()).getChildAt(1);
        imageView.setVisibility(0);
        imageView.setOnClickListener(new h());
    }

    public final void h2() {
        Intent intent = getIntent();
        this.z = intent.getStringExtra("fuid");
        this.A = intent.getStringExtra("head_img_url");
        this.B = intent.getStringExtra("nick_name");
        this.C = intent.getStringExtra("remark_name");
        this.E = intent.getStringExtra("register_mobile_number");
        this.F = intent.getBooleanExtra("hide_register_mobile", false);
        this.G = intent.getStringArrayExtra("remark_tel");
        this.I = intent.getBooleanExtra("is_friend", false);
        this.H = intent.getStringExtra("description");
    }

    public final void i2() {
        V1(this.w[0]);
        if (!TextUtils.isEmpty(a2()) && !this.F) {
            this.w[0].setText(this.E);
            this.w[0].setFocusable(false);
            this.w[0].setFocusableInTouchMode(false);
            this.w[0].setEnabled(false);
            g2(this.w[0]);
            V1(this.w[1]);
        }
        if (this.G != null) {
            int i2 = !this.w[0].isEnabled() ? 1 : 0;
            for (String str : this.G) {
                EditText[] editTextArr = this.w;
                if (i2 < editTextArr.length) {
                    editTextArr[i2].setText(str);
                    i2++;
                }
                EditText[] editTextArr2 = this.w;
                if (i2 < editTextArr2.length) {
                    V1(editTextArr2[i2]);
                }
            }
        }
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

    public final void j2() {
        this.q.setOnClickListener(new b());
    }

    public final void k2() {
        getWindow().setSoftInputMode(2);
        EditText editText = (EditText) findViewById(R.id.nick_name_edit);
        this.u = editText;
        String str = this.B;
        if (str != null) {
            editText.setText(str);
        }
        this.s = (ClearEditText) findViewById(R.id.remark_edit);
        if (!TextUtils.isEmpty(this.C)) {
            this.s.setText(this.C);
            Selection.setSelection(this.s.getText(), this.C.length());
        }
        this.s.setClearDrawable(R.drawable.ic_edittext_clear_gray, R.drawable.ic_edittext_clear_gray);
        this.s.addTextChangedListener(new c());
        this.t = (TextView) findViewById(R.id.phone_name);
        String[] strArrB2 = b2();
        this.J = strArrB2;
        int i2 = 0;
        if (TextUtils.isEmpty(strArrB2[0]) || this.J[0].equals(this.s.getText().toString())) {
            this.t.setVisibility(8);
        } else {
            this.t.setVisibility(0);
            this.t.setText(c2());
            this.t.setMovementMethod(LinkMovementMethod.getInstance());
            this.t.setHighlightColor(getResources().getColor(android.R.color.transparent));
            LogUtil.uploadInfoImmediate("remark_tip_show", "1", null, null);
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.phone_layout);
        this.v = viewGroup;
        if (this.I) {
            this.w = new EditText[]{(EditText) ((ViewGroup) getLayoutInflater().inflate(R.layout.phone_edit_text_v2, (ViewGroup) null)).getChildAt(0), (EditText) ((ViewGroup) getLayoutInflater().inflate(R.layout.phone_edit_text_v2, (ViewGroup) null)).getChildAt(0), (EditText) ((ViewGroup) getLayoutInflater().inflate(R.layout.phone_edit_text_v2, (ViewGroup) null)).getChildAt(0), (EditText) ((ViewGroup) getLayoutInflater().inflate(R.layout.phone_edit_text_v2, (ViewGroup) null)).getChildAt(0), (EditText) ((ViewGroup) getLayoutInflater().inflate(R.layout.phone_edit_text_v2, (ViewGroup) null)).getChildAt(0)};
            i2();
            while (true) {
                EditText[] editTextArr = this.w;
                if (i2 >= editTextArr.length) {
                    break;
                }
                editTextArr[i2].addTextChangedListener(this.L);
                i2++;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        this.x = (EditText) findViewById(R.id.description_edit);
        this.y = (TextView) findViewById(R.id.description_count);
        this.x.addTextChangedListener(new d());
        this.x.setOnTouchListener(new e());
        if (TextUtils.isEmpty(this.H)) {
            return;
        }
        this.x.setText(this.H);
        this.y.setText(((int) Math.floor(((double) (800 - dt2.b(this.H))) * 0.5d)) + "");
    }

    public final boolean l2() {
        int i2 = 0;
        if (this.s == null || this.x == null) {
            return false;
        }
        if (!TextUtils.isEmpty(this.C) ? this.C.equals(this.s.getText().toString()) : this.s.length() <= 0 || this.s.getText().toString().equals(this.B)) {
            return true;
        }
        if (!TextUtils.isEmpty(this.H) ? this.H.equals(this.x.getText().toString()) : this.x.length() <= 0) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if (this.G != null) {
            while (true) {
                String[] strArr = this.G;
                if (i2 >= strArr.length) {
                    break;
                }
                sb.append(strArr[i2]);
                sb.append("$");
                i2++;
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return !sb.toString().equals(d2());
    }

    public fn0 m2() {
        return new fn0();
    }

    public final void n2(EditText editText) {
        if (editText != null) {
            editText.setVisibility(8);
            this.v.removeView((ViewGroup) editText.getParent());
            Z1().requestFocus();
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_modify_contact_info_v2);
        h2();
        initActionBar();
        k2();
        j2();
        LogUtil.uploadInfoImmediate("comment_show", "1", null, null);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        bq3 bq3Var = this.K;
        if (bq3Var != null) {
            bq3Var.onCancel();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyUp(i2, keyEvent);
        }
        LogUtil.uploadInfoImmediate("comment_return", "1", null, null);
        W1();
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        LogUtil.uploadInfoImmediate("comment_return", "1", null, null);
        W1();
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ModifyContactInfoActivityV2.this.q.setEnabled(ModifyContactInfoActivityV2.this.l2());
            dt2.d(ModifyContactInfoActivityV2.this.s, charSequence, 32);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements TextWatcher {
        public d() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ModifyContactInfoActivityV2.this.q.setEnabled(ModifyContactInfoActivityV2.this.l2());
            int iD = dt2.d(ModifyContactInfoActivityV2.this.x, charSequence, 800);
            if (iD <= 800) {
                ModifyContactInfoActivityV2.this.y.setText(((int) Math.floor(((double) (800 - iD)) * 0.5d)) + "");
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
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ModifyContactInfoActivityV2.this.q.setEnabled(ModifyContactInfoActivityV2.this.l2());
            for (int i = 0; i < ModifyContactInfoActivityV2.this.w.length; i++) {
                EditText editText = ModifyContactInfoActivityV2.this.w[i];
                if (editText.getText() == editable) {
                    int iF2 = ModifyContactInfoActivityV2.this.f2();
                    if (editable.length() != 0 || iF2 <= 1) {
                        if (editable.length() <= 0 || ModifyContactInfoActivityV2.this.Z1() != editText) {
                            return;
                        }
                        ModifyContactInfoActivityV2 modifyContactInfoActivityV2 = ModifyContactInfoActivityV2.this;
                        modifyContactInfoActivityV2.V1(modifyContactInfoActivityV2.Y1());
                        return;
                    }
                    ModifyContactInfoActivityV2.this.n2(editText);
                    if (iF2 - 1 == 0 || ModifyContactInfoActivityV2.this.Z1().length() != 0) {
                        ModifyContactInfoActivityV2 modifyContactInfoActivityV22 = ModifyContactInfoActivityV2.this;
                        modifyContactInfoActivityV22.V1(modifyContactInfoActivityV22.Y1());
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
