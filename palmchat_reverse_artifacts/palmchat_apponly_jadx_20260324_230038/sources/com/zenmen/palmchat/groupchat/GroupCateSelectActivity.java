package com.zenmen.palmchat.groupchat;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.GroupCateConfig;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.iq5;
import defpackage.j65;
import defpackage.rl0;
import defpackage.sy5;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class GroupCateSelectActivity extends BaseActionBarActivity {
    public ListView q;
    public String r;
    public int s;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f14230a;

        public a(ArrayList arrayList) {
            this.f14230a = arrayList;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            GroupCateSelectActivity groupCateSelectActivity = GroupCateSelectActivity.this;
            groupCateSelectActivity.F1(groupCateSelectActivity.r, ((GroupCateConfig.CateItem) this.f14230a.get(i)).f12155a);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", GroupCateSelectActivity.this.s);
                jSONObject.put("val", ((GroupCateConfig.CateItem) this.f14230a.get(i)).f12155a);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("hgrz205", "1", "1", jSONObject.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.Listener<JSONObject> {
        public b() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            GroupCateSelectActivity.this.hideBaseProgressBar();
            if (jSONObject != null) {
                if (jSONObject.optInt("resultCode") == 0) {
                    iq5.j(false, new String[0]);
                    GroupCateSelectActivity.this.finish();
                } else {
                    String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
                    if (TextUtils.isEmpty(strOptString)) {
                        strOptString = GroupCateSelectActivity.this.getString(R.string.send_failed);
                    }
                    sy5.f(GroupCateSelectActivity.this, strOptString, 0).g();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.ErrorListener {
        public c() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            GroupCateSelectActivity.this.hideBaseProgressBar();
            sy5.e(GroupCateSelectActivity.this, R.string.send_failed, 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList<GroupCateConfig.CateItem> f14233a;
        public Context b;

        public d(Context context, ArrayList<GroupCateConfig.CateItem> arrayList) {
            this.b = context;
            this.f14233a = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f14233a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f14233a.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewInflate;
            e eVar;
            if (view == null) {
                eVar = new e();
                viewInflate = LayoutInflater.from(this.b).inflate(R.layout.layout_item_grouptype, (ViewGroup) null);
                eVar.f14234a = viewInflate.findViewById(R.id.layout);
                eVar.b = (TextView) viewInflate.findViewById(R.id.address);
                eVar.c = (TextView) viewInflate.findViewById(R.id.selectView);
                eVar.d = viewInflate.findViewById(R.id.sep);
                eVar.e = viewInflate.findViewById(R.id.spaceTop);
                viewInflate.setTag(eVar);
            } else {
                viewInflate = view;
                eVar = (e) view.getTag();
            }
            GroupCateConfig.CateItem cateItem = this.f14233a.get(i);
            if (i == 0) {
                eVar.e.setVisibility(0);
            } else {
                eVar.e.setVisibility(8);
            }
            if (i == this.f14233a.size() - 1) {
                eVar.d.setVisibility(8);
            } else {
                eVar.d.setVisibility(0);
            }
            eVar.b.setText(cateItem.b);
            return viewInflate;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f14234a;
        public TextView b;
        public TextView c;
        public View d;
        public View e;
    }

    public final void D1() {
        this.r = getIntent().getStringExtra("extra_groupid");
        this.s = getIntent().getIntExtra("extra_from", 1);
    }

    public final void E1() {
        this.q = (ListView) findViewById(R.id.list);
        ArrayList<GroupCateConfig.CateItem> arrayList = rl0.h().g().f12154a;
        this.q.setAdapter((ListAdapter) new d(this, arrayList));
        this.q.setOnItemClickListener(new a(arrayList));
    }

    public final void F1(String str, int i) {
        try {
            new j65(new b(), new c()).n(str, i);
            showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        } catch (DaoException e2) {
            e2.printStackTrace();
            hideBaseProgressBar();
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_group_cate_select);
        D1();
        E1();
        initToolbar(R.string.group_cat_des);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.s);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("hgrz204", "1", "1", jSONObject.toString());
    }
}
