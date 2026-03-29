package com.zenmen.palmchat.webplatform.miniPrograms;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ListAdapter;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.opos.acs.st.utils.ErrorContants;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.webplatform.R$id;
import com.zenmen.palmchat.webplatform.R$layout;
import com.zenmen.palmchat.webplatform.R$string;
import com.zenmen.palmchat.webplatform.WebModuleActivity;
import com.zenmen.palmchat.webplatform.a;
import com.zenmen.palmchat.webplatform.miniPrograms.a;
import defpackage.b74;
import defpackage.pp3;
import defpackage.yy2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class MiniProgramsListActivity extends FrameworkBaseActivity implements b74 {
    public MiniProgramListView q;
    public com.zenmen.palmchat.webplatform.miniPrograms.a r;
    public List<Package> u;
    public View v;
    public int s = 1;
    public int t = 10;
    public boolean w = true;
    public View.OnClickListener x = new b();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: com.zenmen.palmchat.webplatform.miniPrograms.MiniProgramsListActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC1139a implements Runnable {
            public RunnableC1139a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MiniProgramsListActivity.this.G1();
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MiniProgramsListActivity miniProgramsListActivity = MiniProgramsListActivity.this;
            if (miniProgramsListActivity.w) {
                miniProgramsListActivity.showBaseProgressBar(R$string.loading, false);
                MiniProgramsListActivity.this.w = false;
                new Handler().postDelayed(new RunnableC1139a(), 500L);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.b bVar = (a.b) view.getTag();
            if (bVar != null) {
                Package r6 = (Package) MiniProgramsListActivity.this.u.get(bVar.e);
                Intent intent = new Intent();
                intent.setClass(MiniProgramsListActivity.this, WebModuleActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("extra_type", 1);
                bundle.putInt("extra_from", 2);
                bundle.putBoolean("web_show_share", true);
                bundle.putSerializable("extra_package", r6);
                intent.putExtras(bundle);
                MiniProgramsListActivity.this.startActivityForResult(intent, 0);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements a.InterfaceC1135a {
        public c() {
        }

        @Override // com.zenmen.palmchat.webplatform.a.InterfaceC1135a
        public void a(JSONObject jSONObject, yy2 yy2Var) {
            List<Package> list;
            LogUtil.i(FrameworkBaseActivity.TAG, "getPkgList onSuccess oriData = " + jSONObject.toString());
            MiniProgramsListActivity.this.hideBaseProgressBar();
            MiniProgramsListActivity.this.w = true;
            d dVar = new d();
            dVar.f15947a = jSONObject.optInt("resultCode");
            dVar.b = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
            if (dVar.f15947a != 0) {
                MiniProgramsListActivity.this.q.compelete(false);
                MiniProgramsListActivity.this.I1();
                return;
            }
            dVar.c = new e();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            dVar.c.f15948a = jSONObjectOptJSONObject.optInt("totalCount");
            dVar.c.c = jSONObjectOptJSONObject.optInt("pageNum");
            dVar.c.b = jSONObjectOptJSONObject.optInt("pageSize");
            dVar.c.d = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("page");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                    Package r4 = new Package();
                    r4.pkgId = jSONObjectOptJSONObject2.optString("appId");
                    r4.name = jSONObjectOptJSONObject2.optString("name");
                    r4.md5 = jSONObjectOptJSONObject2.optString("md5");
                    r4.version = jSONObjectOptJSONObject2.optInt("version");
                    r4.icon = jSONObjectOptJSONObject2.optString("icon");
                    r4.description = jSONObjectOptJSONObject2.optString("description");
                    dVar.c.d.add(r4);
                }
            }
            MiniProgramsListActivity.this.q.setVisibility(0);
            e eVar = dVar.c;
            if (eVar == null || (list = eVar.d) == null) {
                MiniProgramsListActivity.this.q.compelete(false);
                return;
            }
            if (list.size() == 0) {
                MiniProgramsListActivity.this.q.compelete(true);
                return;
            }
            List<Package> list2 = eVar.d;
            MiniProgramsListActivity.this.s = eVar.c + 1;
            MiniProgramsListActivity.this.u.addAll(list2);
            MiniProgramsListActivity.this.r.b(MiniProgramsListActivity.this.u);
            MiniProgramsListActivity.this.q.compelete(false);
        }

        @Override // com.zenmen.palmchat.webplatform.a.InterfaceC1135a
        public void onFail(Exception exc) {
            LogUtil.i(FrameworkBaseActivity.TAG, "getPkgList onFail error = " + exc.toString());
            MiniProgramsListActivity.this.hideBaseProgressBar();
            MiniProgramsListActivity miniProgramsListActivity = MiniProgramsListActivity.this;
            miniProgramsListActivity.w = true;
            miniProgramsListActivity.q.compelete(false);
            MiniProgramsListActivity.this.I1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15947a;
        public String b;
        public e c;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15948a;
        public int b;
        public int c;
        public List<Package> d;
    }

    public final void G1() {
        LogUtil.i(FrameworkBaseActivity.TAG, "getPkgList, pageNum = " + this.s + ", pageSize = " + this.t);
        com.zenmen.palmchat.webplatform.a.d(this.s, this.t, new c());
    }

    public final void H1() {
        initToolbar(R$id.toolbar, getResources().getString(R$string.mini_program_nearby), true);
        MiniProgramListView miniProgramListView = (MiniProgramListView) findViewById(R$id.mini_program_listview);
        this.q = miniProgramListView;
        miniProgramListView.setOnLoadMoreListener(this);
        com.zenmen.palmchat.webplatform.miniPrograms.a aVar = new com.zenmen.palmchat.webplatform.miniPrograms.a(this, this.x);
        this.r = aVar;
        this.q.setAdapter((ListAdapter) aVar);
        View viewFindViewById = findViewById(R$id.error_view);
        this.v = viewFindViewById;
        viewFindViewById.setOnClickListener(new a());
    }

    public final void I1() {
        if (this.u.size() == 0) {
            this.v.setVisibility(0);
            this.q.setVisibility(8);
        } else {
            this.v.setVisibility(8);
            this.q.setVisibility(0);
        }
    }

    @Override // defpackage.b74
    public void a() {
        G1();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 0) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == 1000) {
            pp3.e(this);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.layout_activity_miniprograms_list);
        H1();
        this.u = new ArrayList();
        G1();
        showBaseProgressBar(R$string.loading, false);
        LogUtil.uploadInfoImmediate(ErrorContants.NEW_REALTIME_REPORT_ERROR, HiAnalyticsConstant.KeyAndValue.NUMBER_01, null, null);
    }
}
