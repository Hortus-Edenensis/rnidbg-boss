package com.zenmen.palmchat.groupchat;

import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.groupchat.dao.GroupModifyResultVo;
import com.zenmen.palmchat.redpacket.pay.SPWalletUtils;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.UI;
import defpackage.au1;
import defpackage.bq6;
import defpackage.de2;
import defpackage.gr2;
import defpackage.hx3;
import defpackage.k86;
import defpackage.ke2;
import defpackage.me1;
import defpackage.pe2;
import defpackage.pm2;
import defpackage.re2;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.vm1;
import defpackage.ye2;
import defpackage.ze2;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class GroupDetailActivity extends BaseActionBarActivity implements pm2<Cursor> {
    public TextView A;
    public TextView B;
    public TextView C;
    public TextView E;
    public View F;
    public View G;
    public TextView H;
    public TextView I;
    public boolean K;
    public re2 L;
    public Response.Listener<JSONObject> M;
    public Response.ErrorListener N;
    public GroupInfoItem q;
    public String r;
    public boolean s;
    public String t;
    public String u;
    public Toolbar w;
    public EffectiveShapeView x;
    public TextView y;
    public TextView z;
    public int v = 0;
    public boolean J = false;
    public int O = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GroupDetailActivity.this.b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.Listener<JSONObject> {
        public b() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            GroupDetailActivity.this.hideBaseProgressBar();
            try {
                int i = jSONObject.getInt("resultCode");
                String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
                if (i != 0) {
                    GroupDetailActivity.this.F.setVisibility(0);
                    GroupDetailActivity.this.G.setVisibility(8);
                    if (TextUtils.isEmpty(strOptString)) {
                        GroupDetailActivity.this.H.setText(R.string.group_detail_network);
                        return;
                    } else {
                        GroupDetailActivity.this.H.setText(strOptString);
                        return;
                    }
                }
                GroupDetailActivity.this.G.setVisibility(0);
                GroupDetailActivity.this.F.setVisibility(8);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                if (jSONObjectOptJSONObject != null) {
                    String strOptString2 = jSONObjectOptJSONObject.optString("roomName");
                    String strOptString3 = jSONObjectOptJSONObject.optString("roomIcon");
                    int iOptInt = jSONObjectOptJSONObject.optInt("roomNum");
                    String strOptString4 = jSONObjectOptJSONObject.optString("roomId");
                    GroupDetailActivity.this.K = jSONObjectOptJSONObject.optBoolean("inRoom");
                    if (GroupDetailActivity.this.q == null) {
                        GroupDetailActivity.this.q = new GroupInfoItem();
                    }
                    GroupDetailActivity.this.q.setGroupName(strOptString2);
                    GroupDetailActivity.this.q.setGroupHeadImgUrl(strOptString3);
                    GroupDetailActivity.this.q.setGroupId(strOptString4);
                    GroupDetailActivity.this.q.setMemberCount(iOptInt);
                    GroupDetailActivity.this.d2();
                    LogUtil.uploadInfoImmediate("hgrz113", "1", null, null);
                    if (!TextUtils.isEmpty(strOptString)) {
                        GroupDetailActivity.this.I.setVisibility(0);
                        GroupDetailActivity.this.I.setText(strOptString);
                    }
                    if (GroupDetailActivity.this.K) {
                        GroupInfoItem groupInfoItemA = ze2.a(strOptString4, 0);
                        com.zenmen.palmchat.database.b.w(GroupDetailActivity.this.q, GroupDetailActivity.this.getResources().getString(R.string.qrcode_in_room));
                        if (groupInfoItemA != null) {
                            Intent intent = new Intent(GroupDetailActivity.this, (Class<?>) ChatterActivity.class);
                            intent.putExtra("chat_item", groupInfoItemA);
                            k86.X(intent);
                            GroupDetailActivity.this.startActivity(intent);
                        } else {
                            Intent intent2 = new Intent();
                            intent2.setClass(GroupDetailActivity.this, MainTabsActivity.class);
                            k86.X(intent2);
                            intent2.putExtra("new_intent_position", "tab_msg");
                            GroupDetailActivity.this.startActivity(intent2);
                        }
                        GroupDetailActivity.this.finish();
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.ErrorListener {
        public c() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            GroupDetailActivity.this.hideBaseProgressBar();
            GroupDetailActivity.this.F.setVisibility(0);
            GroupDetailActivity.this.G.setVisibility(8);
            GroupDetailActivity.this.H.setText(R.string.group_detail_network);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends MaterialDialog.e {
        public f() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            GroupDetailActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends AsyncTask<Void, Void, ke2> {
        public g() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ke2 doInBackground(Void... voidArr) {
            try {
                return new au1().n(GroupDetailActivity.this.u, GroupDetailActivity.this.q.getGroupId(), 7);
            } catch (DaoException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(ke2 ke2Var) {
            GroupDetailActivity.this.hideBaseProgressBar();
            if (ke2Var == null || ke2Var.f18672a != 0) {
                GroupDetailActivity.this.c2();
                return;
            }
            GroupDetailActivity.this.q.setGroupHeadImgUrl(ke2Var.b);
            if (TextUtils.isEmpty(ke2Var.c)) {
                GroupDetailActivity.this.q.setGroupName(ke2Var.e);
            } else {
                GroupDetailActivity.this.q.setGroupName(ke2Var.c);
            }
            GroupDetailActivity.this.q.setMemberCount(ke2Var.d);
            GroupDetailActivity.this.v = ke2Var.g;
            if (GroupDetailActivity.this.v == 1) {
                GroupDetailActivity.this.s = false;
            }
            if (!TextUtils.isEmpty(ke2Var.f)) {
                GroupDetailActivity.this.I.setVisibility(0);
                GroupDetailActivity.this.I.setText(ke2Var.f);
            }
            GroupDetailActivity.this.d2();
            LogUtil.uploadInfoImmediate("hgrz113", "1", null, null);
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            GroupDetailActivity.this.showBaseProgressBar();
        }
    }

    public final void T1() {
        new d().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void U1() {
        new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void V1() {
        new g().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void W1(String str) {
        re2 re2Var = this.L;
        if (re2Var != null) {
            re2Var.onCancel();
        }
        showBaseProgressBar(R.string.loading, false);
        HashMap map = new HashMap();
        map.put("qrCode", str);
        re2 re2Var2 = new re2(this.M, this.N, map);
        this.L = re2Var2;
        try {
            re2Var2.n();
        } catch (DaoException e2) {
            e2.printStackTrace();
        }
    }

    public final void X1() {
        this.M = new b();
        this.N = new c();
    }

    public final void Y1() {
        Toolbar toolbarInitToolbar = initToolbar(R.string.activity_title_group_detail);
        this.w = toolbarInitToolbar;
        setSupportActionBar(toolbarInitToolbar);
    }

    public final void Z1() {
        EffectiveShapeView effectiveShapeView = (EffectiveShapeView) findViewById(R.id.portrait);
        this.x = effectiveShapeView;
        effectiveShapeView.changeShapeType(3);
        this.x.setDegreeForRoundRectangle(13, 13);
        this.x.setBorderWidth(me1.b(this, 1));
        this.x.setBorderColor(-1);
        this.y = (TextView) findViewById(R.id.nameMain);
        this.z = (TextView) findViewById(R.id.memberCount);
        this.A = (TextView) findViewById(R.id.group_detail_des);
        this.B = (TextView) findViewById(R.id.group_detail_des2);
        this.C = (TextView) findViewById(R.id.group_green_tips);
        this.E = (TextView) findViewById(R.id.action);
        this.G = findViewById(R.id.user_detail);
        this.F = findViewById(R.id.none_area);
        this.H = (TextView) findViewById(R.id.error_msg);
        this.F.setVisibility(8);
        this.G.setVisibility(8);
        this.E.setOnClickListener(new a());
        TextView textView = (TextView) findViewById(R.id.group_detail_realname);
        this.I = textView;
        textView.setVisibility(8);
        d2();
    }

    public final void a2() {
        Intent intent = getIntent();
        this.q = (GroupInfoItem) intent.getParcelableExtra(com.umeng.analytics.pro.f.K);
        this.r = intent.getStringExtra("user_detail_name_card_sender_name");
        this.s = intent.getBooleanExtra("issend", false);
        String stringExtra = intent.getStringExtra("group_qrcode");
        this.t = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            this.O = 1;
        } else {
            this.O = 0;
        }
        if (!hx3.m(AppContext.getContext())) {
            this.F.setVisibility(0);
            this.G.setVisibility(8);
            this.H.setText(R.string.group_detail_network);
        } else if (this.O == 0) {
            X1();
            W1(this.t);
        } else {
            this.G.setVisibility(0);
            this.F.setVisibility(8);
            this.u = this.q.getCardCode();
            V1();
        }
    }

    public final void b() {
        if (this.B.getVisibility() == 0) {
            finish();
            return;
        }
        GroupInfoItem groupInfoItem = this.q;
        if (groupInfoItem != null) {
            if (!this.J || groupInfoItem.getGroupState() == 1) {
                LogUtil.uploadInfoImmediate("hgrz114", "1", null, null);
                if (this.O == 1) {
                    U1();
                    return;
                } else {
                    T1();
                    return;
                }
            }
            Intent intent = new Intent();
            intent.setClass(this, ChatterActivity.class);
            intent.putExtra("chat_item", this.q);
            k86.X(intent);
            startActivity(intent);
        }
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: b2, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor == null || !cursor.moveToNext()) {
            return;
        }
        GroupInfoItem itemFromCursor = GroupInfoItem.getItemFromCursor(cursor, this.q);
        this.J = true;
        this.q = itemFromCursor;
        d2();
    }

    public final void c2() {
        new sd3(this).j(R.string.network_exception_title).O(R.string.alert_dialog_ok).f(new f()).e().show();
    }

    public final void d2() {
        if (this.q != null) {
            gr2.j().h(this.q.getIconURL(), this.x, bq6.s());
            this.y.setText(this.q.getGroupName());
            this.z.setText(getString(R.string.group_detail_mem_count, String.valueOf(this.q.getMemberCount())));
            if (this.s) {
                this.A.setVisibility(8);
            }
            if (this.L != null) {
                this.A.setText(getString(R.string.group_qr_detail));
            } else {
                this.A.setText(getString(R.string.group_detail_invest, this.r));
            }
            GroupInfoItem groupInfoItem = this.q;
            if (groupInfoItem != null) {
                if ((!this.J || groupInfoItem.getGroupState() == 1) && this.v == 0) {
                    this.C.setVisibility(8);
                    this.E.setVisibility(0);
                    return;
                }
                if (this.s) {
                    this.C.setText(R.string.group_invited_myself_tips);
                } else {
                    this.C.setText(R.string.group_invited_tips);
                }
                this.C.setVisibility(0);
                this.E.setVisibility(8);
            }
        }
    }

    public final void e2() {
        this.E.setText(R.string.modify_contact_info_finish);
        this.A.setVisibility(8);
        this.B.setVisibility(0);
        LogUtil.uploadInfoImmediate("hgrz115", "1", null, null);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_group_detail);
        Y1();
        Z1();
        a2();
        UI.c(this, 1, null, this);
    }

    @Override // defpackage.pm2
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        GroupInfoItem groupInfoItem = this.q;
        if (groupInfoItem == null || groupInfoItem.getGroupId() == null) {
            return null;
        }
        return new CursorLoader(this, DBUriManager.b(ye2.class, this.q), null, "group_id=?", new String[]{this.q.getGroupId()}, "_id DESC ");
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        hideBaseProgressBar();
        re2 re2Var = this.L;
        if (re2Var != null) {
            re2Var.onCancel();
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

    @Override // defpackage.pm2
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends AsyncTask<Void, Void, GroupModifyResultVo> {
        public d() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GroupModifyResultVo doInBackground(Void... voidArr) {
            try {
                return new pe2().n(GroupDetailActivity.this.t);
            } catch (DaoException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(GroupModifyResultVo groupModifyResultVo) {
            GroupDetailActivity.this.hideBaseProgressBar();
            if (groupModifyResultVo == null) {
                sy5.e(GroupDetailActivity.this, R.string.send_failed, 0).g();
                return;
            }
            int i = groupModifyResultVo.resultCode;
            if (i != 0) {
                if (i == 4033 || i == 4034) {
                    if (i == 4034) {
                        GroupDetailActivity.this.e2();
                    }
                    de2.a(GroupDetailActivity.this, groupModifyResultVo, null, new a());
                    return;
                } else if (TextUtils.isEmpty(groupModifyResultVo.errorMsg)) {
                    sy5.e(GroupDetailActivity.this, R.string.send_failed, 0).g();
                    return;
                } else {
                    GroupChatInitActivity.x2(groupModifyResultVo.errorMsg, GroupDetailActivity.this);
                    return;
                }
            }
            sy5.e(GroupDetailActivity.this, R.string.send_success, 0).g();
            GroupInfoItem groupInfoItemA = ze2.a(GroupDetailActivity.this.q.getGroupId(), 0);
            if (GroupDetailActivity.this.K) {
                com.zenmen.palmchat.database.b.w(GroupDetailActivity.this.q, GroupDetailActivity.this.getResources().getString(R.string.qrcode_in_room));
            }
            if (groupInfoItemA != null) {
                Intent intent = new Intent(GroupDetailActivity.this, (Class<?>) ChatterActivity.class);
                intent.putExtra("chat_item", groupInfoItemA);
                k86.X(intent);
                GroupDetailActivity.this.startActivity(intent);
            } else {
                Intent intent2 = new Intent();
                intent2.setClass(GroupDetailActivity.this, MainTabsActivity.class);
                k86.X(intent2);
                intent2.putExtra("new_intent_position", "tab_msg");
                GroupDetailActivity.this.startActivity(intent2);
            }
            GroupDetailActivity.this.finish();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            GroupDetailActivity.this.showBaseProgressBar();
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements SPWalletUtils.BindCardCallback {
            public a() {
            }

            @Override // com.zenmen.palmchat.redpacket.pay.SPWalletUtils.BindCardCallback
            public void onSuccess(int i, String str, Object obj) {
                GroupDetailActivity.this.T1();
            }

            @Override // com.zenmen.palmchat.redpacket.pay.SPWalletUtils.BindCardCallback
            public void onFail(int i, String str, Object obj) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends AsyncTask<Void, Void, GroupModifyResultVo> {
        public e() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GroupModifyResultVo doInBackground(Void... voidArr) {
            try {
                return new vm1().n(GroupDetailActivity.this.u, GroupDetailActivity.this.q.getGroupId());
            } catch (DaoException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(GroupModifyResultVo groupModifyResultVo) {
            GroupDetailActivity.this.hideBaseProgressBar();
            if (groupModifyResultVo == null) {
                sy5.e(GroupDetailActivity.this, R.string.send_failed, 0).g();
                return;
            }
            int i = groupModifyResultVo.resultCode;
            if (i != 0) {
                if (i == 4029 || i == 4030) {
                    if (i == 4030) {
                        GroupDetailActivity.this.e2();
                    }
                    de2.a(GroupDetailActivity.this, groupModifyResultVo, null, new a());
                    return;
                } else if (TextUtils.isEmpty(groupModifyResultVo.errorMsg)) {
                    sy5.e(GroupDetailActivity.this, R.string.send_failed, 0).g();
                    return;
                } else {
                    GroupChatInitActivity.x2(groupModifyResultVo.errorMsg, GroupDetailActivity.this);
                    return;
                }
            }
            sy5.e(GroupDetailActivity.this, R.string.send_success, 0).g();
            GroupInfoItem groupInfoItemA = ze2.a(GroupDetailActivity.this.q.getGroupId(), 0);
            if (groupInfoItemA != null) {
                Intent intent = new Intent(GroupDetailActivity.this, (Class<?>) ChatterActivity.class);
                intent.putExtra("chat_item", groupInfoItemA);
                k86.X(intent);
                GroupDetailActivity.this.startActivity(intent);
            } else {
                Intent intent2 = new Intent();
                intent2.setClass(GroupDetailActivity.this, MainTabsActivity.class);
                k86.X(intent2);
                intent2.putExtra("new_intent_position", "tab_msg");
                GroupDetailActivity.this.startActivity(intent2);
            }
            GroupDetailActivity.this.finish();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            GroupDetailActivity.this.showBaseProgressBar();
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements SPWalletUtils.BindCardCallback {
            public a() {
            }

            @Override // com.zenmen.palmchat.redpacket.pay.SPWalletUtils.BindCardCallback
            public void onSuccess(int i, String str, Object obj) {
                GroupDetailActivity.this.U1();
            }

            @Override // com.zenmen.palmchat.redpacket.pay.SPWalletUtils.BindCardCallback
            public void onFail(int i, String str, Object obj) {
            }
        }
    }
}
