package com.zenmen.palmchat.circle.ui;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.MediaPickActivity;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.groupchat.GroupChatInitActivity;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.groupchat.dao.GroupModifyResultVo;
import com.zenmen.palmchat.settings.cert.a;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.al4;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.c70;
import defpackage.gr2;
import defpackage.hc2;
import defpackage.hx3;
import defpackage.j56;
import defpackage.k80;
import defpackage.k86;
import defpackage.oc0;
import defpackage.ry5;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.us2;
import defpackage.w4;
import defpackage.wi0;
import defpackage.xn3;
import defpackage.ze2;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleCreateActivity extends BaseActionBarActivity {
    public String A;
    public Toolbar B;
    public int C;
    public TextView E;
    public EffectiveShapeView q;
    public String s;
    public String t;
    public EditText u;
    public CheckBox v;
    public k80 x;
    public GroupInfoItem y;
    public HashMap<String, String> z;
    public final int r = 1;
    public boolean w = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CircleCreateActivity.this.i2();
            oc0.g("lx_new_group_select_create_group_show_ceate_click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements j56 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13095a;
        public final /* synthetic */ String b;

        public c(String str, String str2) {
            this.f13095a = str;
            this.b = str2;
        }

        @Override // defpackage.j56
        public void onFailed(Throwable th) {
            CircleCreateActivity.this.hideBaseProgressBar();
            sy5.e(CircleCreateActivity.this, R.string.circle_avatar_upload_fail, 0).g();
        }

        @Override // defpackage.j56
        public void onSuccess(String str, String str2) {
            CircleCreateActivity.this.S1(str2, ("1".equals(this.f13095a) || !TextUtils.equals(this.b, CircleCreateActivity.this.y.getGroupName())) ? this.b : null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends wi0<BaseResponse> {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements a.b {
            public a() {
            }

            @Override // com.zenmen.palmchat.settings.cert.a.b
            public void onResult(boolean z) {
                if (z) {
                    CircleCreateActivity.this.R1(true);
                } else {
                    ry5.a(CircleCreateActivity.this.getString(R.string.circle_real_name_failed));
                    CircleCreateActivity.this.R1(false);
                }
            }
        }

        public d() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CircleCreateActivity.this.hideBaseProgressBar();
            c70.R().C0(false, new String[0]);
            if (baseResponse.getResultCode() != 0) {
                if (CircleCreateActivity.this.x == null || !CircleCreateActivity.this.x.d(CircleCreateActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                    if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                        sy5.e(CircleCreateActivity.this, R.string.send_failed, 0).g();
                        return;
                    } else {
                        sy5.f(CircleCreateActivity.this, baseResponse.getErrorMsg(), 0).g();
                        return;
                    }
                }
                return;
            }
            if (CircleCreateActivity.this.z != null) {
                if (!"1".equals((String) CircleCreateActivity.this.z.get("verifyCheckResult"))) {
                    CircleCreateActivity.this.R1(true);
                    return;
                }
                if (CircleCreateActivity.this.y.getRoleType() == 1) {
                    com.zenmen.palmchat.settings.cert.a.a().d(CircleCreateActivity.this, new a());
                } else if (CircleCreateActivity.this.y.getRoleType() == 2) {
                    ry5.a(CircleCreateActivity.this.getString(R.string.circle_real_name_group_owner));
                    CircleCreateActivity.this.R1(false);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements j56 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13098a;

        public e(String str) {
            this.f13098a = str;
        }

        @Override // defpackage.j56
        public void onFailed(Throwable th) {
            CircleCreateActivity.this.hideBaseProgressBar();
            sy5.e(CircleCreateActivity.this, R.string.circle_avatar_upload_fail, 0).g();
        }

        @Override // defpackage.j56
        public void onSuccess(String str, String str2) {
            CircleCreateActivity.this.hideBaseProgressBar();
            CircleCreateActivity.this.T1(str, this.f13098a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends AsyncTask<Void, Void, GroupModifyResultVo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13099a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public f(String str, int i, String str2) {
            this.f13099a = str;
            this.b = i;
            this.c = str2;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GroupModifyResultVo doInBackground(Void... voidArr) {
            try {
                return new us2().o(CircleCreateActivity.this.t, this.f13099a, CircleCreateActivity.this.A, this.b, this.c);
            } catch (DaoException unused) {
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(GroupModifyResultVo groupModifyResultVo) {
            Intent intent;
            super.onPostExecute(groupModifyResultVo);
            CircleCreateActivity.this.hideBaseProgressBar();
            if (groupModifyResultVo == null) {
                sy5.e(CircleCreateActivity.this, R.string.send_failed, 0).g();
                return;
            }
            int i = groupModifyResultVo.resultCode;
            if (i == 0 || i == 4001) {
                GroupInfoItem groupInfoItemA = ze2.a(groupModifyResultVo.roomId, 0);
                if (groupInfoItemA != null) {
                    groupInfoItemA.setGroupHeadImgUrl(this.f13099a);
                    sy5.e(CircleCreateActivity.this, R.string.send_success, 0).g();
                    LogUtil.onClickEvent("512", "1", null);
                    intent = new Intent(CircleCreateActivity.this, (Class<?>) CircleAddLocationActivity.class);
                    intent.putExtra("fromType", 0);
                    intent.putExtra("chat_item", groupInfoItemA);
                } else {
                    intent = new Intent();
                    intent.setClass(CircleCreateActivity.this, MainTabsActivity.class);
                    k86.X(intent);
                    intent.putExtra("new_intent_position", "tab_msg");
                }
                CircleCreateActivity.this.startActivity(intent);
                CircleCreateActivity.this.finish();
                return;
            }
            if (i == 4028) {
                CircleCreateActivity.this.d2(groupModifyResultVo);
                return;
            }
            if (i == 4002) {
                if (groupModifyResultVo.members != null) {
                    GroupModifyResultVo.onDialogEvent(groupModifyResultVo, "view");
                    CircleCreateActivity circleCreateActivity = CircleCreateActivity.this;
                    CircleCreateActivity.b2(circleCreateActivity.getString(R.string.string_create_group_failed_content, circleCreateActivity.U1(groupModifyResultVo.members)), CircleCreateActivity.this);
                } else {
                    sy5.e(CircleCreateActivity.this, R.string.send_failed, 0).g();
                }
                LogUtil.onClickEvent("512", "2", null);
                return;
            }
            if (i == 4015) {
                GroupModifyResultVo.onDialogEvent(groupModifyResultVo, "view");
                CircleCreateActivity.this.c2();
            } else if (TextUtils.isEmpty(groupModifyResultVo.errorMsg)) {
                sy5.e(CircleCreateActivity.this, R.string.send_failed, 0).g();
            } else {
                GroupModifyResultVo.onDialogEvent(groupModifyResultVo, "view");
                CircleCreateActivity.b2(groupModifyResultVo.errorMsg, CircleCreateActivity.this);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements a.b {
        public g() {
        }

        @Override // com.zenmen.palmchat.settings.cert.a.b
        public void onResult(boolean z) {
            if (z) {
                return;
            }
            ry5.a(CircleCreateActivity.this.getString(R.string.circle_real_name_failed));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements al4 {
        public i() {
        }

        @Override // defpackage.al4
        public void a(GroupModifyResultVo groupModifyResultVo) {
            GroupModifyResultVo.onDialogEvent(groupModifyResultVo, "click");
            CircleCreateActivity.this.f2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y1(View view) {
        Intent intent = new Intent(this, (Class<?>) MediaPickActivity.class);
        intent.putExtra("select_mode_key", 1);
        intent.putExtra("from", "from_person_info");
        startActivityForResult(intent, 1);
    }

    public static void b2(String str, Context context) {
        new sd3(context).k(str.replace("\"", "")).O(R.string.square_btn_know).f(null).e().show();
    }

    public static void e2(Context context, HashMap<String, String> map, GroupInfoItem groupInfoItem) {
        context.startActivity(new Intent(context, (Class<?>) CircleCreateActivity.class).putExtra("key_rec_set_check_data", map).putExtra("key_group_info", groupInfoItem));
    }

    public final void R1(boolean z) {
        Intent intent = new Intent(this, (Class<?>) CircleChooseSearchFunActivity.class);
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        intent.putExtra("key_need_set_rec", z);
        startActivity(intent);
    }

    public final void S1(String str, String str2) {
        c70.R().u(this.y.getGroupId(), str, str2, null, new d());
    }

    public final void T1(String str, String str2) {
        showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        new f(str, this.v.isChecked() ? 1 : 0, str2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final String U1(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr != null) {
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                ContactInfoItem contactInfoItemL = bo0.r().l(strArr[i2]);
                if (contactInfoItemL != null) {
                    sb.append(contactInfoItemL.getNameForShow());
                    if (i2 != length - 1) {
                        sb.append(getString(R.string.name_divider));
                    }
                }
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: V1, reason: merged with bridge method [inline-methods] */
    public final void Z1(View view) {
        InputMethodManager inputMethodManager;
        if (view == null || (inputMethodManager = (InputMethodManager) getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
    }

    public final void W1() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("key_rec_set_check_data");
            this.y = (GroupInfoItem) intent.getParcelableExtra("key_group_info");
            this.A = intent.getStringExtra("extra_selected_cate_id");
            if (serializableExtra instanceof HashMap) {
                this.z = (HashMap) serializableExtra;
                this.w = true;
            }
            this.C = intent.getIntExtra("extra_from", 0);
        }
        HashMap map = new HashMap(1);
        int i2 = this.C;
        if (i2 == 0) {
            map.put("fromtype", 2);
        } else if (i2 == 2) {
            map.put("fromtype", 1);
        }
        oc0.h("lx_new_group_select_create_group_show", map);
    }

    public final void X1() {
        this.u = (EditText) findViewById(R.id.circleNameEt);
        this.v = (CheckBox) findViewById(R.id.circleRecommendCheckBox);
        EffectiveShapeView effectiveShapeView = (EffectiveShapeView) findViewById(R.id.circleAvatarImg);
        this.q = effectiveShapeView;
        effectiveShapeView.setBorderColor(getResources().getColor(R.color.portrait_line));
        this.q.setOnClickListener(new View.OnClickListener() { // from class: r70
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20406a.Y1(view);
            }
        });
        this.t = xn3.a();
        TextView textView = (TextView) findViewById(R.id.circle_create_submit);
        this.E = textView;
        if (this.w) {
            ((TextView) this.B.findViewById(R.id.title)).setText("编辑群信息");
            findViewById(R.id.ll_allow_recommended_block).setVisibility(8);
            this.E.setText(R.string.circle_submit);
            this.E.setVisibility(0);
            HashMap<String, String> map = this.z;
            if (map != null) {
                if ("0".equals(map.get("verifyCheckResult"))) {
                    this.E.setText(R.string.circle_submit);
                } else if (this.y.getRoleType() == 1) {
                    this.E.setText(R.string.circle_next);
                } else if (this.y.getRoleType() == 2) {
                    this.E.setText(R.string.circle_submit);
                }
            }
            if (this.y != null) {
                gr2.j().h(this.y.getGroupHeadImgUrl(), this.q, bq6.s());
                if (!TextUtils.isEmpty(this.y.getGroupName())) {
                    this.u.setText(this.y.getGroupName());
                    EditText editText = this.u;
                    editText.setSelection(editText.getText().length());
                }
                this.x = new k80(this.y.getGroupId());
            }
            this.E.setOnClickListener(new View.OnClickListener() { // from class: s70
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20678a.g2(view);
                }
            });
        } else {
            textView.setOnClickListener(new a());
        }
        this.u.addTextChangedListener(new b());
        findViewById(R.id.root_view).setOnClickListener(new View.OnClickListener() { // from class: t70
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20916a.Z1(view);
            }
        });
        h2();
    }

    public final void a2() {
        Toolbar toolbarInitToolbar = initToolbar(R.string.circle_create);
        this.B = toolbarInitToolbar;
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(R.string.circle_create);
        setSupportActionBar(this.B);
        this.B.findViewById(R.id.action_button).setVisibility(8);
    }

    public final void c2() {
        new sd3(this).k(getString(R.string.group_select_max_dialog_text, Integer.valueOf(GroupChatInitActivity.q0))).O(R.string.alert_dialog_ok).f(new h()).e().show();
    }

    public final void d2(GroupModifyResultVo groupModifyResultVo) {
        w4.C(this, groupModifyResultVo, new i());
        GroupModifyResultVo.onDialogEvent(groupModifyResultVo, "view");
    }

    public final void f2() {
        com.zenmen.palmchat.settings.cert.a.a().d(this, new g());
    }

    public final void g2(View view) {
        HashMap<String, String> map = this.z;
        if (map != null) {
            String str = map.get("nameCheckResult");
            String str2 = this.z.get("headImgCheckResult");
            String strTrim = this.u.getText().toString().trim();
            if ("1".equals(str) && TextUtils.isEmpty(strTrim)) {
                ry5.a("请设置群名称");
                return;
            }
            if ("1".equals(str2) && TextUtils.isEmpty(this.s)) {
                ry5.a("请设置群头像");
                return;
            }
            if (TextUtils.isEmpty(this.s) || !k86.I(this.s)) {
                showBaseProgressBar();
                S1(null, strTrim);
            } else {
                showBaseProgressBar(getString(R.string.settings_uploading), false);
                c70.R().H0(this.s, new c(str, strTrim));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h2() {
        String strTrim;
        TextView textView;
        if (this.w) {
            return;
        }
        EditText editText = this.u;
        if (editText != null && editText.getText() != null) {
            strTrim = this.u.getText().toString().trim();
            int length = TextUtils.isEmpty(strTrim) ? 0 : strTrim.length();
            if (!TextUtils.isEmpty(this.s) || TextUtils.isEmpty(strTrim) || length < 2 || length > 15) {
                textView = this.E;
                if (textView == null) {
                    textView.setEnabled(false);
                    return;
                }
                return;
            }
            TextView textView2 = this.E;
            if (textView2 != null) {
                textView2.setEnabled(true);
                return;
            }
            return;
        }
        strTrim = "";
        if (TextUtils.isEmpty(this.s)) {
        }
        textView = this.E;
        if (textView == null) {
        }
    }

    public final void i2() {
        if (TextUtils.isEmpty(this.s)) {
            sy5.e(this, R.string.circle_select_avatar, 0).g();
            return;
        }
        String strTrim = this.u.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim) || strTrim.length() < 2) {
            sy5.f(this, "群名称为2到15个字符", 0).g();
            return;
        }
        if (!hx3.m(this)) {
            sy5.e(this, R.string.network_error, 0).g();
        } else {
            if (TextUtils.isEmpty(this.s) || !k86.I(this.s)) {
                return;
            }
            showBaseProgressBar(getString(R.string.settings_uploading), false);
            c70.R().H0(this.s, new e(strTrim));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 1) {
            this.s = intent.getStringExtra("media_pick_photo_key");
            h2();
            if (k86.I(this.s)) {
                hc2.b(this).load(this.s).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(this.q);
            }
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_avatar_setting);
        a2();
        W1();
        X1();
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
    public class h extends MaterialDialog.e {
        public h() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            CircleCreateActivity.this.h2();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
