package com.zenmen.palmchat.circle.ui;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.bw4;
import defpackage.dt2;
import defpackage.fo;
import defpackage.fu5;
import defpackage.gr2;
import defpackage.il5;
import defpackage.ir5;
import defpackage.j70;
import defpackage.jw5;
import defpackage.m66;
import defpackage.rn0;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.tj2;
import defpackage.xn3;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleAuthUserDetailActivity extends BaseActionBarActivity {
    public TextView A;
    public TextView B;
    public TextView C;
    public TextView E;
    public TextView F;
    public int G = -1;
    public String H;
    public long I;
    public long J;
    public bw4 K;
    public ContactInfoItem q;
    public String r;
    public ImageView s;
    public TextView t;
    public ImageView u;
    public TextView v;
    public TextView w;
    public View x;
    public TextView y;
    public TextView z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CircleAuthUserDetailActivity.this.f();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CircleAuthUserDetailActivity.this.P1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CircleAuthUserDetailActivity.this.O1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CircleAuthUserDetailActivity.this.Q1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends MaterialDialog.e {
        public f() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            CircleAuthUserDetailActivity circleAuthUserDetailActivity = CircleAuthUserDetailActivity.this;
            circleAuthUserDetailActivity.L1(circleAuthUserDetailActivity.q.getChatId(), jw5.b(CircleAuthUserDetailActivity.this.q.getSessionConfig(), 8));
        }
    }

    public final void M1(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("send_time", Long.valueOf(ir5.b()));
        contentValues.put("from_uid", this.q.getUid());
        contentValues.put("mid", xn3.a());
        contentValues.put("from_nick_name", this.q.getNickName());
        contentValues.put("from_head_img_url", this.q.getIconURL());
        contentValues.put("from_signature", this.q.getSignature());
        contentValues.put("request_info", str);
        contentValues.put("user_info", "");
        contentValues.put("rid", this.H);
        contentValues.put("applyTime", Long.valueOf(this.I));
        contentValues.put("applyExpireSec", Long.valueOf(this.J));
        contentValues.put("request_type", (Integer) 2);
        contentValues.put("read_status", (Long) 1L);
        contentValues.put("readTime", Long.valueOf(ir5.b()));
        contentValues.put("accept_status", (Long) 0L);
        contentValues.put("source_type", Integer.valueOf(this.G));
        contentValues.put("identify_code", this.q.getIdentifyCode());
        rn0.j(contentValues);
    }

    public final boolean N1() {
        return !ContactRequestsVO.isSenderParseFromRid(this.H) && this.I > 0 && System.currentTimeMillis() > this.I + (this.J * 1000);
    }

    public void O1() {
        ContactInfoItem contactInfoItem = this.q;
        if (contactInfoItem != null) {
            jw5.j(contactInfoItem.getSessionConfig());
            jw5.g(this.q.getSessionConfig());
            if (jw5.e(this.q.getSessionConfig())) {
                L1(this.q.getChatId(), jw5.a(this.q.getSessionConfig(), 8));
            } else {
                new sd3(this).T(R.string.add_to_blacklist).j(R.string.blacklist_dialog_content).K(R.string.alert_dialog_cancel).O(R.string.alert_dialog_ok).f(new f()).e().show();
            }
        }
    }

    public final void P1() {
        LogUtil.uploadInfoImmediate("M13", "1", null, null);
        ContactInfoItem contactInfoItemM792clone = this.q.m792clone();
        contactInfoItemM792clone.setSourceType(this.G);
        Intent intent = new Intent(this, (Class<?>) m66.c());
        intent.putExtra("user_item_info", contactInfoItemM792clone);
        intent.putExtra("from", 5);
        startActivity(intent);
    }

    public void Q1() {
        bo0.r().w(this.q.getUid());
        Intent intent = new Intent();
        intent.setClass(this, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("contactInfoItem", this.q);
        LogUtil.i(BaseActionBarActivity.TAG, "report sourceType: 2");
        bundle.putString("web_url", tj2.l() + "uid=" + AccountUtils.p(AppContext.getContext()) + "&sourceType=2&uidTo=" + this.q.getChatId() + "&type=0&from=999");
        bundle.putBoolean("web_show_right_menu", false);
        bundle.putInt("BackgroundColor", -1);
        bundle.putInt("sourceType", 2);
        bundle.putString("uidTo", this.q.getChatId());
        intent.putExtras(bundle);
        startActivity(intent);
        fo.a(999);
    }

    public final void R1() {
        new sd3(this).T(R.string.update_install_dialog_title).k("申请已过期").P("确定").e().show();
    }

    public final void S1() {
        this.s = (ImageView) findViewById(R.id.circle_user_auth_head);
        this.t = (TextView) findViewById(R.id.nameMain);
        this.u = (ImageView) findViewById(R.id.img_gender);
        this.v = (TextView) findViewById(R.id.circle_user_auth_reason);
        this.w = (TextView) findViewById(R.id.reply);
        this.x = findViewById(R.id.moment_view);
        this.y = (TextView) findViewById(R.id.district_text);
        this.z = (TextView) findViewById(R.id.signature_text);
        this.A = (TextView) findViewById(R.id.hobby_text);
        this.B = (TextView) findViewById(R.id.sourceType_tv);
        this.C = (TextView) findViewById(R.id.action_textview);
        this.E = (TextView) findViewById(R.id.action_textview_blacklist);
        this.F = (TextView) findViewById(R.id.action_textview_report);
        if (this.q == null) {
            return;
        }
        gr2.j().h(this.q.getIconURL(), this.s, bq6.s());
        this.t.setText(this.q.getNameForShow());
        if (this.q.getGender() == 1) {
            this.u.setImageResource(R.drawable.nearby_gender_female);
        }
        this.v.setText("");
        this.w.setOnClickListener(new a());
        this.x.setOnClickListener(new b());
        this.C.setOnClickListener(new c());
        this.E.setOnClickListener(new d());
        this.F.setOnClickListener(new e());
        this.y.setText(il5.i(getApplicationContext(), this.q.getCountry(), this.q.getProvince(), this.q.getCity()));
        if (TextUtils.isEmpty(this.q.getSignature())) {
            this.z.setText(R.string.no_signature);
        } else {
            this.z.setText(this.q.getSignature());
        }
        if (TextUtils.isEmpty(this.q.getHobby())) {
            this.A.setText(R.string.no_hobby);
        } else {
            this.A.setText(this.q.getHobby());
        }
    }

    public final void T1() {
        String string = AppContext.getContext().getString(R.string.source_type_recommend);
        ContactInfoItem contactInfoItem = this.q;
        if (contactInfoItem != null) {
            this.G = contactInfoItem.getSourceType();
        }
        int i = this.G;
        if (i == 0) {
            string = getApplicationContext().getString(R.string.source_type_search);
        } else if (i == 1) {
            string = getApplicationContext().getString(R.string.source_type_scan);
        } else if (i == 2 || i == 12) {
            string = getApplicationContext().getString(R.string.source_type_group);
        } else if (i == 16) {
            string = getApplicationContext().getString(R.string.source_type_hotchat);
        } else if (i == 3) {
            string = getApplicationContext().getString(R.string.source_type_contact_recommend);
        } else if (i == 18) {
            string = getApplicationContext().getString(R.string.source_type_accurate_recommend);
        } else if (i == 20) {
            string = getApplicationContext().getString(R.string.source_type_contact_recommend);
        } else if (i == 6) {
            string = getApplicationContext().getString(R.string.contact_source_type_name_card);
        } else if (i == 7) {
            string = getApplicationContext().getString(R.string.source_type_online_recommend);
        } else if (i == 17) {
            string = getApplicationContext().getString(R.string.source_type_newuser_recommend);
        } else if (i == 14 || i == 4 || i == 34) {
            string = getApplicationContext().getString(R.string.source_type_nearby);
        } else if (i == 28) {
            string = getApplicationContext().getString(R.string.source_type_people_match);
        } else if (i == 10) {
            string = getApplicationContext().getString(R.string.source_type_active_friends);
        } else if (i == 22) {
            string = getApplicationContext().getString(R.string.source_type_people_you_may_know);
        } else if (i == 200) {
            string = getApplicationContext().getString(R.string.source_type_contact_recommend);
        } else if (i == 11) {
            string = getApplicationContext().getString(R.string.source_type_single_chat);
        } else if (i == 38) {
            string = getApplicationContext().getString(R.string.source_type_smallvideo);
        } else if (i == 43) {
            string = getApplicationContext().getString(R.string.source_type_fql);
        } else if (i == -1) {
            string = getApplicationContext().getString(R.string.source_type_voice_room);
        } else if (i == -1) {
            string = getApplicationContext().getString(R.string.source_type_people_match);
        } else if (i == 44) {
            string = getApplicationContext().getString(R.string.source_type_square);
        } else if (i == 45) {
            string = getApplicationContext().getString(R.string.source_type_marriage_match);
        } else if (i == 68) {
            string = getApplicationContext().getString(R.string.source_type_find_friend_recommend);
        } else if (i == 69) {
            string = getApplicationContext().getString(R.string.source_type_profile);
        } else if (fu5.q(i)) {
            string = getApplicationContext().getString(R.string.source_type_private_chat);
        }
        this.B.setText(string);
    }

    public final void f() {
        if (N1()) {
            R1();
            return;
        }
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.layout_dialog_add_friend_content, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.count);
        EditText editText = (EditText) viewInflate.findViewById(R.id.edit_text);
        viewInflate.findViewById(R.id.content).setVisibility(8);
        textView.setText(String.valueOf(30));
        editText.addTextChangedListener(new g(editText, textView));
        new sd3(this).p(viewInflate, false).T(R.string.string_reply).K(R.string.alert_dialog_cancel).O(R.string.alert_dialog_ok).f(new h(editText)).e().show();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_user_auth_detail);
        setSupportActionBar(initToolbar(R.string.activity_title_user_detail));
        Intent intent = getIntent();
        this.q = (ContactInfoItem) intent.getParcelableExtra(j70.c);
        this.r = intent.getStringExtra(j70.f18338a);
        this.H = intent.getStringExtra(j70.d);
        S1();
        T1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        bw4 bw4Var = this.K;
        if (bw4Var != null) {
            bw4Var.onCancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f13074a;
        public final /* synthetic */ TextView b;

        public g(EditText editText, TextView textView) {
            this.f13074a = editText;
            this.b = textView;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int iD = dt2.d(this.f13074a, charSequence, 60);
            if (iD <= 60) {
                this.b.setText(((int) Math.floor(((double) (60 - iD)) * 0.5d)) + "");
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
    public class h extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f13075a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Response.ErrorListener {
            public a() {
            }

            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                CircleAuthUserDetailActivity.this.hideBaseProgressBar();
                sy5.e(CircleAuthUserDetailActivity.this, R.string.send_failed, 0).g();
                LogUtil.d(BaseActionBarActivity.TAG, volleyError.toString());
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Response.Listener<JSONObject> {
            public b() {
            }

            @Override // com.android.volley.Response.Listener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponse(JSONObject jSONObject) {
                int iOptInt = jSONObject.optInt("resultCode");
                CircleAuthUserDetailActivity.this.hideBaseProgressBar();
                if (iOptInt == 0) {
                    h hVar = h.this;
                    CircleAuthUserDetailActivity.this.M1(hVar.f13075a.getText().toString());
                } else if (iOptInt == 1318) {
                    sy5.e(CircleAuthUserDetailActivity.this, R.string.send_failed_refuse, 0).g();
                } else if (iOptInt == 7001) {
                    sy5.e(CircleAuthUserDetailActivity.this, R.string.send_failed_too_often, 0).g();
                } else {
                    sy5.e(CircleAuthUserDetailActivity.this, R.string.send_failed, 0).g();
                }
            }
        }

        public h(EditText editText) {
            this.f13075a = editText;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            if (TextUtils.isEmpty(this.f13075a.getText().toString())) {
                return;
            }
            if (CircleAuthUserDetailActivity.this.N1()) {
                CircleAuthUserDetailActivity.this.R1();
                return;
            }
            a aVar = new a();
            b bVar = new b();
            HashMap map = new HashMap();
            map.put("fuid", CircleAuthUserDetailActivity.this.q.getUid());
            map.put("rid", CircleAuthUserDetailActivity.this.H);
            map.put("sourceType", String.valueOf(CircleAuthUserDetailActivity.this.G));
            map.put("info", this.f13075a.getText().toString());
            CircleAuthUserDetailActivity.this.K = new bw4(bVar, aVar);
            try {
                CircleAuthUserDetailActivity.this.K.n(map);
                CircleAuthUserDetailActivity circleAuthUserDetailActivity = CircleAuthUserDetailActivity.this;
                circleAuthUserDetailActivity.showBaseProgressBar(circleAuthUserDetailActivity.getString(R.string.progress_sending), false);
            } catch (DaoException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
        }
    }

    public final void L1(String str, int i) {
    }
}
