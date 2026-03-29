package com.zenmen.palmchat.circle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.settings.cert.a;
import defpackage.c70;
import defpackage.dv0;
import defpackage.hx3;
import defpackage.k80;
import defpackage.oc0;
import defpackage.ry5;
import defpackage.sy5;
import defpackage.wi0;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleChooseSearchFunActivity extends BaseActionBarActivity {
    public CheckBox q;
    public String r;
    public int s;
    public k80 t;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse<GroupInfoItem>> {
        public a() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<GroupInfoItem> baseResponse) {
            CircleChooseSearchFunActivity.this.hideBaseProgressBar();
            if (baseResponse == null || baseResponse.getData() == null) {
                sy5.e(CircleChooseSearchFunActivity.this, R.string.circle_not_into_group, 0).g();
                CircleChooseSearchFunActivity.this.finish();
                return;
            }
            CircleChooseSearchFunActivity.this.s = baseResponse.getData().getRecmdSwitch();
            if (CircleChooseSearchFunActivity.this.s == 0) {
                CircleChooseSearchFunActivity.this.q.setChecked(false);
            } else {
                CircleChooseSearchFunActivity.this.q.setChecked(true);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements CompoundButton.OnCheckedChangeListener {
        public b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton.isPressed()) {
                if (z) {
                    CircleChooseSearchFunActivity.this.I1(1, true);
                } else {
                    CircleChooseSearchFunActivity.this.I1(0, true);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends wi0<BaseResponse<HashMap<String, String>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13091a;
        public final /* synthetic */ boolean b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements a.b {
            public a() {
            }

            @Override // com.zenmen.palmchat.settings.cert.a.b
            public void onResult(boolean z) {
                if (!z) {
                    ry5.a(CircleChooseSearchFunActivity.this.getString(R.string.circle_real_name_failed));
                } else {
                    CircleChooseSearchFunActivity.this.q.setChecked(true);
                    CircleChooseSearchFunActivity.this.I1(1, false);
                }
            }
        }

        public c(int i, boolean z) {
            this.f13091a = i;
            this.b = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(BaseResponse baseResponse, GroupInfoItem groupInfoItem) {
            HashMap map = (HashMap) baseResponse.getData();
            String str = (String) map.get("nameCheckResult");
            String str2 = (String) map.get("headImgCheckResult");
            String str3 = (String) map.get("cateCheckResult");
            String str4 = (String) map.get("verifyCheckResult");
            if ("1".equals(str3)) {
                CircleLaunchCreateCircleActivity.R1(CircleChooseSearchFunActivity.this, map, groupInfoItem);
                return;
            }
            if ("1".equals(str) || "1".equals(str2)) {
                CircleCreateActivity.e2(CircleChooseSearchFunActivity.this, map, groupInfoItem);
                return;
            }
            if ("1".equals(str4)) {
                if (groupInfoItem.getRoleType() == 1) {
                    com.zenmen.palmchat.settings.cert.a.a().d(CircleChooseSearchFunActivity.this, new a());
                } else if (groupInfoItem.getRoleType() == 2) {
                    ry5.a(CircleChooseSearchFunActivity.this.getString(R.string.circle_real_name_group_owner));
                }
            }
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(final BaseResponse<HashMap<String, String>> baseResponse) {
            CircleChooseSearchFunActivity.this.hideBaseProgressBar();
            if (baseResponse.getResultCode() == 0) {
                c70.R().C0(false, new String[0]);
                Intent intent = new Intent();
                intent.putExtra("recmdSwitch", this.f13091a);
                CircleChooseSearchFunActivity.this.setResult(-1, intent);
                return;
            }
            if (this.f13091a == 1) {
                CircleChooseSearchFunActivity.this.q.setChecked(false);
            } else {
                CircleChooseSearchFunActivity.this.q.setChecked(true);
            }
            if (CircleChooseSearchFunActivity.this.t.d(CircleChooseSearchFunActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                return;
            }
            if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                sy5.e(CircleChooseSearchFunActivity.this, R.string.send_failed, 0).g();
            } else {
                sy5.f(CircleChooseSearchFunActivity.this, baseResponse.getErrorMsg(), 0).g();
            }
            if (baseResponse.getResultCode() == 5073) {
                CircleChooseSearchFunActivity.this.finish();
                return;
            }
            if ((baseResponse.getResultCode() == 5090 || baseResponse.getResultCode() == 5091 || baseResponse.getResultCode() == 5092 || baseResponse.getResultCode() == 5093) && this.f13091a == 1 && baseResponse.getData() != null && this.b) {
                c70.R().K(CircleChooseSearchFunActivity.this.r, new dv0() { // from class: i70
                    @Override // defpackage.dv0
                    public final void onResponse(Object obj) {
                        this.f18117a.c(baseResponse, (GroupInfoItem) obj);
                    }
                });
            }
        }
    }

    public final void G1() {
        this.q.setOnCheckedChangeListener(new b());
    }

    public final void H1() {
        setSupportActionBar(initToolbar(R.string.circle_choose_search_fun));
        CheckBox checkBox = (CheckBox) findViewById(R.id.ck_promise);
        this.q = checkBox;
        if (this.s == 0) {
            checkBox.setChecked(false);
        } else {
            checkBox.setChecked(true);
        }
    }

    public final void I1(int i, boolean z) {
        if (!hx3.m(this)) {
            sy5.h(this, getString(R.string.network_error), 0);
        } else {
            showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
            c70.R().A0(this.r, i, new c(i, z));
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_choose_search_fun);
        this.r = getIntent().getStringExtra("groupId");
        this.s = getIntent().getIntExtra("recmdSwitch", 0);
        H1();
        G1();
        showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        c70.R().S(this.r, new a());
        this.t = new k80(this.r);
        HashMap map = new HashMap();
        map.put("fromtype", getIntent().getStringExtra("fromtype"));
        map.put("rid", this.r);
        oc0.h("lx_group_edit_recom_show", map);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null || !intent.getBooleanExtra("key_need_set_rec", false)) {
            return;
        }
        this.q.setChecked(true);
        I1(1, false);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
