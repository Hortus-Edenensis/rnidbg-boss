package com.zenmen.palmchat.circle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.circle.bean.CircleApplyGroupType;
import com.zenmen.palmchat.circle.bean.CircleRecommendItem;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.ui.adapter.CircleHotAdapter;
import com.zenmen.palmchat.circle.ui.adapter.CircleSearchGroupAdapter;
import com.zenmen.palmchat.circle.ui.view.RecyclerViewItemShowListener;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.widget.ClearEditText;
import com.zenmen.palmchat.widget.adapters.EndlessScrollListener;
import defpackage.c70;
import defpackage.oc0;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.wi0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleSearchActivity extends BaseActionBarActivity implements CircleHotAdapter.b {
    public int A;
    public RecyclerView B;
    public LinearLayout C;
    public String E;
    public LocationEx F;
    public Toolbar q;
    public ClearEditText r;
    public RecyclerView s;
    public CircleSearchGroupAdapter t;
    public EndlessScrollListener v;
    public long y;
    public TextView z;
    public List<CircleRecommendItem> u = new ArrayList();
    public final int w = 15;
    public int x = 1;
    public CircleSearchGroupAdapter.b G = new i();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CircleRecommendItem f13230a;

        /* JADX INFO: renamed from: com.zenmen.palmchat.circle.ui.CircleSearchActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1014a extends MaterialDialog.e {
            public C1014a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
            }
        }

        public a(CircleRecommendItem circleRecommendItem) {
            this.f13230a = circleRecommendItem;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CircleSearchActivity.this.hideBaseProgressBar();
            if (baseResponse.getResultCode() == 0 || baseResponse.getResultCode() == 4001 || baseResponse.getResultCode() == 4006) {
                Intent intent = new Intent(CircleSearchActivity.this, (Class<?>) ChatterActivity.class);
                intent.putExtra("chat_item", this.f13230a.copyForGroupInfoItem());
                intent.putExtra("chat_need_back_to_main", false);
                intent.putExtra("fromType", 5);
                CircleSearchActivity.this.startActivity(intent);
                return;
            }
            if (baseResponse.getResultCode() == 5065) {
                sy5.f(CircleSearchActivity.this, "此群不允许任何人加群", 0).g();
                return;
            }
            if (baseResponse.getResultCode() == 4027 || baseResponse.getResultCode() == 5077) {
                new sd3(CircleSearchActivity.this).k(baseResponse.getErrorMsg()).O(R.string.red_packet_timeout_know).f(new C1014a()).e().show();
            } else if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                sy5.e(CircleSearchActivity.this, R.string.send_failed, 0).g();
            } else {
                sy5.f(CircleSearchActivity.this, baseResponse.getErrorMsg(), 0).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends wi0<BaseResponse<List<String>>> {
        public b() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<List<String>> baseResponse) {
            CircleSearchActivity.this.hideBaseProgressBar();
            if (baseResponse != null && baseResponse.getResultCode() == 0) {
                CircleSearchActivity.this.a2(baseResponse.getData());
            } else if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                sy5.e(CircleSearchActivity.this, R.string.send_failed, 0).g();
            } else {
                sy5.f(CircleSearchActivity.this, baseResponse.getErrorMsg(), 0).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CircleSearchActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements RecyclerViewItemShowListener.a {
        public e() {
        }

        @Override // com.zenmen.palmchat.circle.ui.view.RecyclerViewItemShowListener.a
        public void a(int i) {
            if (CircleSearchActivity.this.u == null || CircleSearchActivity.this.u.size() == 0 || i >= CircleSearchActivity.this.u.size()) {
                return;
            }
            HashMap map = new HashMap(2);
            map.put("rid", Long.valueOf(((CircleRecommendItem) CircleSearchActivity.this.u.get(i)).id));
            map.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(AppContext.getContext()));
            oc0.h("lx_group_explorepage_card_show", map);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements EndlessScrollListener.a {
        public f() {
        }

        @Override // com.zenmen.palmchat.widget.adapters.EndlessScrollListener.a
        public void a(int i) {
            CircleSearchActivity.this.v.a();
        }

        @Override // com.zenmen.palmchat.widget.adapters.EndlessScrollListener.a
        public void b() {
            if (CircleSearchActivity.this.t != null) {
                CircleSearchActivity.this.t.g();
            }
        }

        @Override // com.zenmen.palmchat.widget.adapters.EndlessScrollListener.a
        public void c(int i) {
            CircleSearchActivity.this.x = i;
            if (CircleSearchActivity.this.u.size() > 0) {
                CircleSearchActivity circleSearchActivity = CircleSearchActivity.this;
                circleSearchActivity.y = ((CircleRecommendItem) circleSearchActivity.u.get(CircleSearchActivity.this.u.size() - 1)).id;
            }
            CircleSearchActivity.this.R1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends wi0<BaseResponse<List<CircleRecommendItem>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13237a;

        public g(String str) {
            this.f13237a = str;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<List<CircleRecommendItem>> baseResponse) {
            if (this.f13237a == null || !TextUtils.isEmpty(CircleSearchActivity.this.r.getText().toString().trim())) {
                if (baseResponse.getResultCode() != 0) {
                    if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                        sy5.e(CircleSearchActivity.this, R.string.send_failed, 0).g();
                    } else {
                        sy5.f(CircleSearchActivity.this, baseResponse.getErrorMsg(), 0).g();
                    }
                    CircleSearchActivity.this.v.c(CircleSearchActivity.this.x);
                    return;
                }
                if (baseResponse.getData() == null) {
                    if (CircleSearchActivity.this.u.size() == 0) {
                        CircleSearchActivity.this.Z1(false);
                        return;
                    }
                    return;
                }
                CircleSearchActivity.this.Z1(true);
                if (CircleSearchActivity.this.y == 0) {
                    CircleSearchActivity.this.u.clear();
                }
                CircleSearchActivity.this.u.addAll(baseResponse.getData());
                if (CircleSearchActivity.this.y == 0) {
                    CircleSearchActivity.this.s.setAdapter(CircleSearchActivity.this.t);
                } else {
                    CircleSearchActivity.this.t.notifyDataSetChanged();
                }
                if (baseResponse.getData().size() < 15) {
                    CircleSearchActivity.this.v.a();
                } else {
                    CircleSearchActivity.this.v.b();
                }
                if (CircleSearchActivity.this.u.size() == 0) {
                    CircleSearchActivity.this.Z1(false);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends wi0<BaseResponse<List<CircleRecommendItem>>> {
        public h() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<List<CircleRecommendItem>> baseResponse) {
            if (baseResponse.getResultCode() != 0) {
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleSearchActivity.this, R.string.send_failed, 0).g();
                    return;
                } else {
                    sy5.f(CircleSearchActivity.this, baseResponse.getErrorMsg(), 0).g();
                    return;
                }
            }
            if (baseResponse.getData() == null || baseResponse.getData().size() <= 0) {
                if (CircleSearchActivity.this.u.size() == 0) {
                    CircleSearchActivity.this.Z1(false);
                }
            } else {
                CircleSearchActivity.this.Z1(true);
                if (CircleSearchActivity.this.u.size() > 0) {
                    CircleSearchActivity.this.u.clear();
                }
                CircleSearchActivity.this.u.addAll(baseResponse.getData());
                CircleSearchActivity.this.s.setAdapter(CircleSearchActivity.this.t);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements CircleSearchGroupAdapter.b {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends wi0<BaseResponse<CircleApplyGroupType>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CircleRecommendItem f13240a;
            public final /* synthetic */ HashMap b;

            public a(CircleRecommendItem circleRecommendItem, HashMap map) {
                this.f13240a = circleRecommendItem;
                this.b = map;
            }

            @Override // defpackage.wi0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(BaseResponse<CircleApplyGroupType> baseResponse) {
                CircleSearchActivity.this.hideBaseProgressBar();
                if (baseResponse.getResultCode() != 0) {
                    if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                        sy5.e(CircleSearchActivity.this, R.string.send_failed, 0).g();
                        return;
                    } else {
                        sy5.f(CircleSearchActivity.this, baseResponse.getErrorMsg(), 0).g();
                        return;
                    }
                }
                CircleApplyGroupType data = baseResponse.getData();
                this.f13240a.addType = baseResponse.getData().getAddType();
                CircleSearchActivity.this.Q1(this.f13240a, this.b, data);
            }
        }

        public i() {
        }

        @Override // com.zenmen.palmchat.circle.ui.adapter.CircleSearchGroupAdapter.b
        public void a(CircleRecommendItem circleRecommendItem) {
            HashMap map = new HashMap(2);
            map.put("rid", Long.valueOf(circleRecommendItem.id));
            map.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(AppContext.getContext()));
            if (circleRecommendItem.hasJoined != 1) {
                CircleSearchActivity.this.showBaseProgressBar();
                c70.R().C(String.valueOf(circleRecommendItem.id), new a(circleRecommendItem, map));
                return;
            }
            oc0.h("lx_group_explorepage_card_join_click", map);
            Intent intent = new Intent(CircleSearchActivity.this, (Class<?>) ChatterActivity.class);
            intent.putExtra("chat_item", circleRecommendItem.copyForGroupInfoItem());
            intent.putExtra("chat_need_back_to_main", false);
            intent.putExtra("fromType", 5);
            CircleSearchActivity.this.startActivity(intent);
        }
    }

    @Override // com.zenmen.palmchat.circle.ui.adapter.CircleHotAdapter.b
    public void K(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("report_type", "click");
        map.put("typeid", str);
        oc0.h("pagesearch_poshotsearch", map);
        this.r.setText(str);
        this.r.setSelection(str.length());
        this.C.setVisibility(8);
        R1();
    }

    public final void Q1(CircleRecommendItem circleRecommendItem, HashMap<String, Object> map, CircleApplyGroupType circleApplyGroupType) {
        int i2 = circleRecommendItem.addType;
        if (i2 == 2) {
            oc0.h("lx_group_explorepage_card_join_click", map);
            CircleApplyGroupActivity.J1(this, circleApplyGroupType, 4, "");
        } else if (i2 == 1) {
            showBaseProgressBar();
            c70.R().j(String.valueOf(circleRecommendItem.id), 4, "", "", new a(circleRecommendItem));
            oc0.h("lx_group_explorepage_card_join_click", map);
        } else if (i2 == 3) {
            sy5.h(this, getString(R.string.circle_not_allow_join), 0);
            oc0.h("lx_group_explorepage_card_join_click", map);
        }
    }

    public final void R1() {
        this.C.setVisibility(8);
        String strTrim = this.r.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim)) {
            if (this.u.size() > 0) {
                this.u.clear();
            }
            this.t.g();
            Z1(true);
            return;
        }
        int i2 = this.A;
        if (i2 == 0) {
            V1(strTrim);
        } else if (i2 == 2) {
            W1(strTrim);
        } else if (i2 == 1) {
            V1(strTrim);
        }
    }

    public final void S1() {
        Toolbar toolbarInitToolbar = initToolbar(-1, false);
        this.q = toolbarInitToolbar;
        setSupportActionBar(toolbarInitToolbar);
        ClearEditText clearEditText = (ClearEditText) findViewById(R.id.search);
        this.r = clearEditText;
        clearEditText.setClearDrawable(R.drawable.clear_search, R.drawable.clear_search);
        findViewById(R.id.cancel_search).setOnClickListener(new c());
    }

    public final void T1() {
        this.s = (RecyclerView) findViewById(R.id.circleRecyclerView);
        this.B = (RecyclerView) findViewById(R.id.recycler_hot);
        this.s.setLayoutManager(new LinearLayoutManager(this));
        this.z = (TextView) findViewById(R.id.tv_empty);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_hot);
        this.C = linearLayout;
        if (this.A == 2) {
            linearLayout.setVisibility(8);
            this.r.setHint("搜索");
            return;
        }
        if (!TextUtils.isEmpty(this.E)) {
            this.r.setHint("大家都在搜：" + this.E);
        }
        this.C.setVisibility(0);
        U1();
    }

    public final void U1() {
        showBaseProgressBar();
        c70.R().Q(new b());
    }

    public final void V1(String str) {
        c70.R().H(str, this.y, 15, new g(str));
    }

    public final void W1(String str) {
        c70.R().V(str, new h());
    }

    public final void X1() {
        this.r.addTextChangedListener(new d());
        this.r.setEnabled(true);
        this.r.requestFocus();
        CircleSearchGroupAdapter circleSearchGroupAdapter = new CircleSearchGroupAdapter(this, this.u);
        this.t = circleSearchGroupAdapter;
        circleSearchGroupAdapter.h(this.A);
        int i2 = this.A;
        if (i2 == 0 || i2 == 1) {
            Y1();
            this.t.i(this.G);
        } else {
            this.t.i = false;
        }
        this.s.addOnScrollListener(new RecyclerViewItemShowListener(new e()));
    }

    public final void Y1() {
        EndlessScrollListener endlessScrollListener = new EndlessScrollListener(new f());
        this.v = endlessScrollListener;
        this.s.addOnScrollListener(endlessScrollListener);
    }

    public final void Z1(boolean z) {
        if (z) {
            this.z.setVisibility(8);
            this.s.setVisibility(0);
        } else {
            this.z.setVisibility(0);
            this.s.setVisibility(8);
        }
    }

    public final void a2(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.C.setVisibility(8);
            return;
        }
        this.C.setVisibility(0);
        CircleHotAdapter circleHotAdapter = new CircleHotAdapter(list, this);
        this.B.setLayoutManager(new GridLayoutManager(this, 2));
        this.B.setAdapter(circleHotAdapter);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_search_circle);
        this.A = getIntent().getIntExtra("intent_from", 0);
        this.E = getIntent().getStringExtra("intent_hot_word");
        this.F = (LocationEx) getIntent().getParcelableExtra("intent_location");
        S1();
        T1();
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

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        oc0.g("lx_group_explorepage_show");
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements TextWatcher {
        public d() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.length() == 0) {
                if (CircleSearchActivity.this.A == 0 || CircleSearchActivity.this.A == 1) {
                    CircleSearchActivity.this.C.setVisibility(0);
                    CircleSearchActivity.this.z.setVisibility(8);
                    CircleSearchActivity.this.s.setVisibility(8);
                    return;
                }
                return;
            }
            CircleSearchActivity.this.y = 0L;
            CircleSearchActivity.this.x = 1;
            if (CircleSearchActivity.this.t != null && CircleSearchActivity.this.A == 0) {
                CircleSearchActivity.this.t.d();
            }
            CircleSearchActivity.this.R1();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
