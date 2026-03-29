package com.zenmen.palmchat.groupchat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.dao.DaoException;
import defpackage.ay4;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.iq5;
import defpackage.sd3;
import defpackage.sy5;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class RevokeMemberActivity extends BaseActionBarActivity implements View.OnClickListener {
    public ay4 q;
    public int r = 0;
    public List<ContactInfoItem> s;
    public String t;
    public ListView u;
    public d v;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.ErrorListener {
        public a() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            RevokeMemberActivity.this.hideBaseProgressBar();
            sy5.e(RevokeMemberActivity.this, R.string.send_failed, 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactInfoItem f14308a;

        public b(ContactInfoItem contactInfoItem) {
            this.f14308a = contactInfoItem;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            RevokeMemberActivity.this.hideBaseProgressBar();
            if (iOptInt != 0) {
                sy5.e(RevokeMemberActivity.this, R.string.send_failed, 0).g();
                return;
            }
            RevokeMemberActivity.this.s.remove(this.f14308a);
            RevokeMemberActivity.this.v.notifyDataSetChanged();
            iq5.j(false, new String[0]);
            sy5.e(RevokeMemberActivity.this, R.string.members_removed, 0).g();
            if (RevokeMemberActivity.this.s.size() == 0) {
                RevokeMemberActivity.this.finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Response.Listener f14309a;
        public final /* synthetic */ Response.ErrorListener b;
        public final /* synthetic */ ContactInfoItem c;

        public c(Response.Listener listener, Response.ErrorListener errorListener, ContactInfoItem contactInfoItem) {
            this.f14309a = listener;
            this.b = errorListener;
            this.c = contactInfoItem;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            RevokeMemberActivity.this.q = new ay4(this.f14309a, this.b);
            try {
                RevokeMemberActivity.this.q.n(this.c.getUid(), RevokeMemberActivity.this.t);
                RevokeMemberActivity revokeMemberActivity = RevokeMemberActivity.this;
                revokeMemberActivity.showBaseProgressBar(revokeMemberActivity.getString(R.string.removing_members), false, false);
            } catch (DaoException e) {
                RevokeMemberActivity.this.hideBaseProgressBar();
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends BaseAdapter {

        /* JADX INFO: compiled from: SearchBox */
        public class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public ImageView f14311a;
            public TextView b;
            public TextView c;

            public a() {
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (RevokeMemberActivity.this.s == null) {
                return 0;
            }
            return RevokeMemberActivity.this.s.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (RevokeMemberActivity.this.s == null) {
                return null;
            }
            return RevokeMemberActivity.this.s.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(RevokeMemberActivity.this).inflate(R.layout.list_item_group_member_name, (ViewGroup) null);
                view.setBackgroundResource(android.R.color.white);
                aVar = new a();
                aVar.f14311a = (ImageView) view.findViewById(R.id.portrait);
                aVar.b = (TextView) view.findViewById(R.id.name);
                TextView textView = (TextView) view.findViewById(R.id.btn);
                aVar.c = textView;
                textView.setText(R.string.alert_dialog_revoke_members);
                aVar.c.setVisibility(0);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            ContactInfoItem contactInfoItem = (ContactInfoItem) RevokeMemberActivity.this.s.get(i);
            gr2.j().h(contactInfoItem.getIconURL(), aVar.f14311a, bq6.s());
            aVar.b.setText(contactInfoItem.getNameForShow());
            aVar.c.setTag(contactInfoItem);
            aVar.c.setOnClickListener(RevokeMemberActivity.this);
            return view;
        }

        public d() {
        }
    }

    public final void F1() {
        Intent intent = getIntent();
        this.s = intent.getParcelableArrayListExtra("revoke_members");
        this.t = intent.getStringExtra("group_id");
        this.r = intent.getIntExtra("is_circle", 0);
    }

    public final void G1() {
        setSupportActionBar(initToolbar(R.string.title_remove_members));
    }

    public final void H1() {
        this.u = (ListView) findViewById(R.id.list);
        d dVar = new d();
        this.v = dVar;
        this.u.setAdapter((ListAdapter) dVar);
    }

    public final void I1(ContactInfoItem contactInfoItem) {
        a aVar = new a();
        new sd3(this).k(getString(R.string.revoke_members, contactInfoItem.getNameForShow())).O(R.string.alert_dialog_revoke_members).K(R.string.alert_dialog_cancel).f(new c(new b(contactInfoItem), aVar, contactInfoItem)).Q();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        I1((ContactInfoItem) view.getTag());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_revoke_member);
        F1();
        G1();
        H1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ay4 ay4Var = this.q;
        if (ay4Var != null) {
            ay4Var.onCancel();
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
}
