package com.zenmen.palmchat.circle.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.ExpandFirstLevelData;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.ui.adapter.CircleGroupTypeAdapter;
import defpackage.c70;
import defpackage.hx3;
import defpackage.oc0;
import defpackage.sy5;
import defpackage.wi0;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleCateSelectActivity extends BaseActionBarActivity implements CircleGroupTypeAdapter.a {
    public String q;
    public int r;
    public String s;
    public ArrayList<ExpandFirstLevelData> t;
    public RecyclerView u;
    public CircleGroupTypeAdapter v;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse<ArrayList<ExpandFirstLevelData>>> {
        public a() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<ArrayList<ExpandFirstLevelData>> baseResponse) {
            CircleCateSelectActivity.this.hideBaseProgressBar();
            if (baseResponse == null) {
                sy5.f(CircleCateSelectActivity.this, "接口异常", 0).g();
                return;
            }
            if (baseResponse.getResultCode() != 0) {
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleCateSelectActivity.this, R.string.send_failed, 0).g();
                    return;
                } else {
                    sy5.f(CircleCateSelectActivity.this, baseResponse.getErrorMsg(), 0).g();
                    return;
                }
            }
            CircleCateSelectActivity.this.t = baseResponse.getData();
            if (CircleCateSelectActivity.this.t == null || CircleCateSelectActivity.this.t.size() == 0) {
                return;
            }
            CircleCateSelectActivity circleCateSelectActivity = CircleCateSelectActivity.this;
            circleCateSelectActivity.v = new CircleGroupTypeAdapter(circleCateSelectActivity.t, CircleCateSelectActivity.this);
            CircleCateSelectActivity.this.u.setAdapter(CircleCateSelectActivity.this.v);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends wi0<BaseResponse> {
        public b() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CircleCateSelectActivity.this.hideBaseProgressBar();
            if (baseResponse == null) {
                sy5.f(CircleCateSelectActivity.this, "接口异常", 0).g();
            } else if (baseResponse.getResultCode() != 0) {
                sy5.f(CircleCateSelectActivity.this, TextUtils.isEmpty(baseResponse.getErrorMsg()) ? CircleCateSelectActivity.this.getString(R.string.send_failed) : baseResponse.getErrorMsg(), 0).g();
            } else {
                c70.R().C0(false, new String[0]);
                CircleCateSelectActivity.this.finish();
            }
        }
    }

    public final void F1() {
        this.q = getIntent().getStringExtra("extra_room_id");
        this.s = getIntent().getStringExtra("extra_selected_cate_name");
        String stringExtra = getIntent().getStringExtra("extra_selected_cate_id");
        this.r = TextUtils.isEmpty(stringExtra) ? 0 : Integer.parseInt(stringExtra);
        HashMap map = new HashMap(1);
        map.put("rid", this.q);
        oc0.h("lx_group_edit_type_show", map);
    }

    public final void G1() {
        setSupportActionBar(initToolbar(R.string.circle_cat_select));
        this.u = (RecyclerView) findViewById(R.id.recycler);
    }

    public final void H1() {
        if (!hx3.m(this)) {
            sy5.e(this, R.string.network_error, 0).g();
        } else {
            showBaseProgressBar();
            c70.R().y(new a());
        }
    }

    @Override // com.zenmen.palmchat.circle.ui.adapter.CircleGroupTypeAdapter.a
    public int getCurrentId() {
        return this.r;
    }

    @Override // com.zenmen.palmchat.circle.ui.adapter.CircleGroupTypeAdapter.a
    public void l1(int i) {
        if (this.r == i) {
            return;
        }
        this.r = i;
        this.v.notifyDataSetChanged();
        if (!hx3.m(this)) {
            sy5.e(this, R.string.network_error, 0).g();
        } else {
            showBaseProgressBar();
            c70.R().l(this.q, String.valueOf(this.r), new b());
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_circle_cate_select);
        F1();
        G1();
        H1();
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
