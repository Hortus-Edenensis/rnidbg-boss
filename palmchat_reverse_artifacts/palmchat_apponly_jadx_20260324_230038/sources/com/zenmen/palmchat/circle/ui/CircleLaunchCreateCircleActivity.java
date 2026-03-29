package com.zenmen.palmchat.circle.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.circle.bean.ExpandFirstLevelData;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.ui.adapter.CircleGroupTypeAdapter;
import com.zenmen.palmchat.groupchat.GroupChatInitActivity;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.settings.cert.a;
import defpackage.c70;
import defpackage.hx3;
import defpackage.k80;
import defpackage.oc0;
import defpackage.ry5;
import defpackage.sy5;
import defpackage.wi0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleLaunchCreateCircleActivity extends BaseActionBarActivity implements CircleGroupTypeAdapter.a {
    public CircleGroupTypeAdapter A;
    public String q;
    public int r;
    public String s;
    public ArrayList<ExpandFirstLevelData> t;
    public TextView u;
    public GroupInfoItem v;
    public HashMap<String, String> w;
    public boolean x;
    public k80 y;
    public RecyclerView z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HashMap map = new HashMap(1);
            map.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(CircleLaunchCreateCircleActivity.this));
            oc0.h("lx_new_group_create_select_show_contacts_click", map);
            Intent intent = new Intent(AppContext.getContext(), (Class<?>) GroupChatInitActivity.class);
            intent.putExtra("from_type", 7);
            CircleLaunchCreateCircleActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(CircleLaunchCreateCircleActivity.this.s)) {
                sy5.f(CircleLaunchCreateCircleActivity.this, "请选择群分类", 0).g();
            } else if (CircleLaunchCreateCircleActivity.this.x) {
                CircleLaunchCreateCircleActivity circleLaunchCreateCircleActivity = CircleLaunchCreateCircleActivity.this;
                circleLaunchCreateCircleActivity.N1(circleLaunchCreateCircleActivity.s);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends wi0<BaseResponse> {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements a.b {
            public a() {
            }

            @Override // com.zenmen.palmchat.settings.cert.a.b
            public void onResult(boolean z) {
                if (z) {
                    CircleLaunchCreateCircleActivity.this.M1(true);
                } else {
                    ry5.a(CircleLaunchCreateCircleActivity.this.getString(R.string.circle_real_name_failed));
                    CircleLaunchCreateCircleActivity.this.M1(false);
                }
            }
        }

        public c() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CircleLaunchCreateCircleActivity.this.hideBaseProgressBar();
            c70.R().C0(false, new String[0]);
            if (baseResponse.getResultCode() != 0) {
                if (CircleLaunchCreateCircleActivity.this.y == null || !CircleLaunchCreateCircleActivity.this.y.d(CircleLaunchCreateCircleActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                    if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                        sy5.e(CircleLaunchCreateCircleActivity.this, R.string.send_failed, 0).g();
                        return;
                    } else {
                        sy5.f(CircleLaunchCreateCircleActivity.this, baseResponse.getErrorMsg(), 0).g();
                        return;
                    }
                }
                return;
            }
            if (CircleLaunchCreateCircleActivity.this.w != null) {
                String str = (String) CircleLaunchCreateCircleActivity.this.w.get("verifyCheckResult");
                String str2 = (String) CircleLaunchCreateCircleActivity.this.w.get("nameCheckResult");
                String str3 = (String) CircleLaunchCreateCircleActivity.this.w.get("headImgCheckResult");
                if ("1".equals(str2) || "1".equals(str3)) {
                    CircleLaunchCreateCircleActivity circleLaunchCreateCircleActivity = CircleLaunchCreateCircleActivity.this;
                    CircleCreateActivity.e2(circleLaunchCreateCircleActivity, circleLaunchCreateCircleActivity.w, CircleLaunchCreateCircleActivity.this.v);
                } else {
                    if (!"1".equals(str)) {
                        CircleLaunchCreateCircleActivity.this.M1(true);
                        return;
                    }
                    if (CircleLaunchCreateCircleActivity.this.v.getRoleType() == 1) {
                        com.zenmen.palmchat.settings.cert.a.a().d(CircleLaunchCreateCircleActivity.this, new a());
                    } else if (CircleLaunchCreateCircleActivity.this.v.getRoleType() == 2) {
                        ry5.a(CircleLaunchCreateCircleActivity.this.getString(R.string.circle_real_name_group_owner));
                        CircleLaunchCreateCircleActivity.this.M1(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends wi0<BaseResponse<ArrayList<ExpandFirstLevelData>>> {
        public d() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<ArrayList<ExpandFirstLevelData>> baseResponse) {
            CircleLaunchCreateCircleActivity.this.hideBaseProgressBar();
            if (baseResponse == null) {
                sy5.f(CircleLaunchCreateCircleActivity.this, "接口异常", 0).g();
                return;
            }
            if (baseResponse.getResultCode() != 0) {
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleLaunchCreateCircleActivity.this, R.string.send_failed, 0).g();
                    return;
                } else {
                    sy5.f(CircleLaunchCreateCircleActivity.this, baseResponse.getErrorMsg(), 0).g();
                    return;
                }
            }
            CircleLaunchCreateCircleActivity.this.t = baseResponse.getData();
            if (CircleLaunchCreateCircleActivity.this.t == null || CircleLaunchCreateCircleActivity.this.t.size() == 0) {
                return;
            }
            CircleLaunchCreateCircleActivity circleLaunchCreateCircleActivity = CircleLaunchCreateCircleActivity.this;
            circleLaunchCreateCircleActivity.A = new CircleGroupTypeAdapter(circleLaunchCreateCircleActivity.t, CircleLaunchCreateCircleActivity.this);
            CircleLaunchCreateCircleActivity.this.z.setAdapter(CircleLaunchCreateCircleActivity.this.A);
        }
    }

    public static void R1(Context context, HashMap<String, String> map, GroupInfoItem groupInfoItem) {
        context.startActivity(new Intent(context, (Class<?>) CircleLaunchCreateCircleActivity.class).putExtra("key_rec_set_check_data", map).putExtra("extra_from", 1).putExtra("extra_room_id", groupInfoItem != null ? groupInfoItem.getGroupId() : "").putExtra("key_group_info", groupInfoItem));
    }

    public final void M1(boolean z) {
        Intent intent = new Intent(this, (Class<?>) CircleChooseSearchFunActivity.class);
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        intent.putExtra("key_need_set_rec", z);
        startActivity(intent);
    }

    public final void N1(String str) {
        showBaseProgressBar();
        c70.R().u(this.v.getGroupId(), null, null, str, new c());
    }

    public final void O1() {
        this.q = getIntent().getStringExtra("extra_room_id");
        this.r = getIntent().getIntExtra("extra_from", 0);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_rec_set_check_data");
        this.v = (GroupInfoItem) getIntent().getParcelableExtra("key_group_info");
        if (serializableExtra instanceof HashMap) {
            this.w = (HashMap) serializableExtra;
            this.x = true;
            this.y = new k80(this.v.getGroupId());
        }
        setSupportActionBar(initToolbar(this.r == 1 ? "选择群分类" : "发起群聊"));
    }

    public final void P1() {
        this.u = (TextView) findViewById(R.id.iv_next);
        this.z = (RecyclerView) findViewById(R.id.recycler);
        if (this.r == 1) {
            findViewById(R.id.rl_choose_contact).setVisibility(8);
            this.u.setVisibility(0);
        }
        findViewById(R.id.rl_choose_contact).setOnClickListener(new a());
        this.u.setOnClickListener(new b());
        HashMap<String, String> map = this.w;
        if (map != null) {
            String str = map.get("verifyCheckResult");
            String str2 = this.w.get("nameCheckResult");
            String str3 = this.w.get("headImgCheckResult");
            if (this.v.getRoleType() == 1) {
                if ("0".equals(str3) && "0".equals(str2) && "0".equals(str)) {
                    this.u.setText(R.string.circle_submit);
                    return;
                }
                return;
            }
            if (this.v.getRoleType() == 2 && "0".equals(str3) && "0".equals(str2)) {
                this.u.setText(R.string.circle_submit);
            }
        }
    }

    public final void Q1() {
        if (!hx3.m(this)) {
            sy5.e(this, R.string.network_error, 0).g();
        } else {
            showBaseProgressBar();
            c70.R().y(new d());
        }
    }

    @Override // com.zenmen.palmchat.circle.ui.adapter.CircleGroupTypeAdapter.a
    public int getCurrentId() {
        if (TextUtils.isEmpty(this.s)) {
            return -1;
        }
        return Integer.parseInt(this.s);
    }

    @Override // com.zenmen.palmchat.circle.ui.adapter.CircleGroupTypeAdapter.a
    public void l1(int i) {
        CircleGroupTypeAdapter circleGroupTypeAdapter = this.A;
        if (circleGroupTypeAdapter != null) {
            circleGroupTypeAdapter.notifyDataSetChanged();
        }
        if (this.x) {
            if (TextUtils.equals(this.s, String.valueOf(i))) {
                this.s = "";
                return;
            }
        }
        this.s = String.valueOf(i);
        HashMap map = new HashMap(1);
        map.put("FID", Integer.valueOf(i));
        map.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(this));
        oc0.h("lx_new_group_create_select_show_class_click", map);
        if (this.r == 1) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) CircleCreateActivity.class);
        intent.putExtra("extra_selected_cate_id", this.s);
        intent.putExtra("extra_from", this.r);
        startActivity(intent);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_circle_launcher_create_circle);
        O1();
        P1();
        Q1();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        HashMap map = new HashMap(1);
        int i = this.r;
        if (i == 0) {
            map.put("fromtype", 2);
        } else if (i == 2) {
            map.put("fromtype", 1);
        }
        oc0.h("lx_new_group_select_create_show", map);
    }
}
