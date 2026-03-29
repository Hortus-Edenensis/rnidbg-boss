package com.zenmen.palmchat.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.ServiceAccountDetailActivity;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a65;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.c65;
import defpackage.d65;
import defpackage.fn0;
import defpackage.gr2;
import defpackage.i65;
import defpackage.iq5;
import defpackage.jw5;
import defpackage.m66;
import defpackage.qm5;
import defpackage.rx4;
import defpackage.sy5;
import defpackage.td3;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class BlackListActivity extends BaseActionBarActivity {
    public ListView q;
    public g r;
    public i65 s;
    public Response.ErrorListener t = new d();
    public Response.Listener<JSONObject> u = new e();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BlackListActivity.this.G1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ContactInfoItem contactInfoItem = (ContactInfoItem) adapterView.getItemAtPosition(i);
            if (d65.b() && a65.e(contactInfoItem)) {
                c65.c("address_p_u02", contactInfoItem.getUid());
                ServiceAccountDetailActivity.Y1(BlackListActivity.this, contactInfoItem);
            } else {
                Intent intent = new Intent(BlackListActivity.this, (Class<?>) m66.c());
                intent.putExtra("user_item_info", contactInfoItem);
                intent.putExtra("from", 9);
                BlackListActivity.this.startActivity(intent);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements AdapterView.OnItemLongClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements td3.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ContactInfoItem f15153a;

            public a(ContactInfoItem contactInfoItem) {
                this.f15153a = contactInfoItem;
            }

            @Override // td3.f
            public void a(td3 td3Var, int i, CharSequence charSequence) {
                if (d65.b() && a65.e(this.f15153a)) {
                    BlackListActivity.this.F1(this.f15153a);
                    return;
                }
                BlackListActivity.this.D1(this.f15153a.getChatId(), jw5.d(0, jw5.j(this.f15153a.getSessionConfig()), jw5.g(this.f15153a.getSessionConfig()), false, !jw5.e(this.f15153a.getSessionConfig()), jw5.i(this.f15153a.getSessionConfig())));
            }
        }

        public c() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            ContactInfoItem contactInfoItem = (ContactInfoItem) adapterView.getItemAtPosition(i);
            if (contactInfoItem == null) {
                return true;
            }
            new td3.c(BlackListActivity.this).c(new String[]{BlackListActivity.this.getString(R.string.remove_blacklist)}).d(new a(contactInfoItem)).a().b();
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.ErrorListener {
        public d() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.d(BaseActionBarActivity.TAG, volleyError.toString());
            BlackListActivity.this.hideBaseProgressBar();
            sy5.e(BlackListActivity.this, R.string.send_failed, 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Response.Listener<JSONObject> {
        public e() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.d(BaseActionBarActivity.TAG, jSONObject.toString());
            int iOptInt = jSONObject.optInt("resultCode");
            BlackListActivity.this.hideBaseProgressBar();
            if (iOptInt == 0) {
                iq5.j(false, new String[0]);
            } else if (iOptInt == 1320 || iOptInt == 1321) {
                rx4.b(BlackListActivity.this, jSONObject);
            } else {
                sy5.e(BlackListActivity.this, R.string.send_failed, 0).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements d65.c {
        public f() {
        }

        @Override // d65.c
        public void onError() {
            BlackListActivity.this.hideBaseProgressBar();
            sy5.e(BlackListActivity.this, R.string.send_failed, 0).g();
        }

        @Override // d65.c
        public void onSuccess() {
            BlackListActivity.this.hideBaseProgressBar();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<ContactInfoItem> f15157a = new ArrayList();
        public LayoutInflater b;
        public Context c;

        /* JADX INFO: compiled from: SearchBox */
        public class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public ImageView f15158a;
            public TextView b;

            public a() {
            }
        }

        public g(Context context) {
            this.c = context;
            this.b = LayoutInflater.from(context);
        }

        public void a(ArrayList<ContactInfoItem> arrayList) {
            this.f15157a.clear();
            if (arrayList != null) {
                this.f15157a.addAll(arrayList);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f15157a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f15157a.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = this.b.inflate(R.layout.list_item_blacklist, (ViewGroup) null);
                aVar = new a();
                aVar.f15158a = (ImageView) view.findViewById(R.id.portrait);
                aVar.b = (TextView) view.findViewById(R.id.name);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            ContactInfoItem contactInfoItem = this.f15157a.get(i);
            String nameForShow = contactInfoItem.getNameForShow();
            String iconURL = contactInfoItem.getIconURL();
            aVar.b.setText(nameForShow);
            if (TextUtils.isEmpty(iconURL)) {
                aVar.f15158a.setImageResource(R.drawable.default_portrait);
            } else {
                gr2.j().h(iconURL, aVar.f15158a, bq6.s());
            }
            if (d65.b() && a65.e(contactInfoItem)) {
                c65.c("address_p_u01", contactInfoItem.getUid());
            }
            return view;
        }
    }

    public final void D1(String str, int i) {
        i65 i65Var = new i65(this.u, this.t);
        this.s = i65Var;
        try {
            i65Var.n(str, i);
            showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        } catch (DaoException e2) {
            e2.printStackTrace();
            hideBaseProgressBar();
        }
    }

    public final void E1() {
        ListView listView = (ListView) findViewById(R.id.contacts_list);
        this.q = listView;
        listView.setEmptyView(findViewById(R.id.empty_view));
        this.r = new g(this);
        G1();
        this.q.setAdapter((ListAdapter) this.r);
        this.q.setOnItemClickListener(new b());
        this.q.setOnItemLongClickListener(new c());
        if (d65.b()) {
            c65.a("address_p01");
        }
    }

    public final void F1(ContactInfoItem contactInfoItem) {
        showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        d65.k(contactInfoItem, true, new f());
    }

    public final void G1() {
        this.r.a(bo0.r().h());
    }

    @qm5
    public void onContactChanged(fn0 fn0Var) {
        runOnUiThread(new a());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_blacklist);
        initToolbar(R.string.contact_blacklist);
        E1();
        bo0.r().i().j(this);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        i65 i65Var = this.s;
        if (i65Var != null) {
            i65Var.onCancel();
        }
        bo0.r().i().l(this);
        super.onDestroy();
    }
}
