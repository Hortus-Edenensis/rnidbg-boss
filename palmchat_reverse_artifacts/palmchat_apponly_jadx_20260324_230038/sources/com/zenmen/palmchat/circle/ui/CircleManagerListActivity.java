package com.zenmen.palmchat.circle.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.bq6;
import defpackage.c70;
import defpackage.dv0;
import defpackage.gr2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleManagerListActivity extends BaseActionBarActivity {
    public TextView q;
    public ListView r;
    public GroupInfoItem s;
    public ArrayList<ContactInfoItem> t;
    public ArrayList<ContactInfoItem> u;
    public c v;
    public boolean w;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ContactInfoItem contactInfoItem = (ContactInfoItem) CircleManagerListActivity.this.t.get(i);
            if (CircleManagerListActivity.this.u.contains(contactInfoItem)) {
                CircleManagerListActivity.this.u.remove(contactInfoItem);
                if (CircleManagerListActivity.this.u.size() <= 0) {
                    CircleManagerListActivity.this.q.setEnabled(false);
                }
            } else {
                CircleManagerListActivity.this.u.add(contactInfoItem);
                CircleManagerListActivity.this.q.setEnabled(true);
            }
            CircleManagerListActivity.this.v.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements dv0<List<ContactInfoItem>> {
        public b() {
        }

        @Override // defpackage.dv0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(List<ContactInfoItem> list) {
            if (list == null || list.size() <= 0) {
                return;
            }
            if (CircleManagerListActivity.this.t == null) {
                CircleManagerListActivity.this.t = new ArrayList(list.size());
            }
            CircleManagerListActivity.this.t.addAll(list);
            CircleManagerListActivity circleManagerListActivity = CircleManagerListActivity.this;
            CircleManagerListActivity circleManagerListActivity2 = CircleManagerListActivity.this;
            circleManagerListActivity.v = circleManagerListActivity2.new c(circleManagerListActivity2);
            CircleManagerListActivity.this.r.setAdapter((ListAdapter) CircleManagerListActivity.this.v);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LayoutInflater f13184a;

        /* JADX INFO: compiled from: SearchBox */
        public class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public EffectiveShapeView f13185a;
            public TextView b;
            public ImageView c;

            public a() {
            }
        }

        public c(Context context) {
            this.f13184a = LayoutInflater.from(context);
        }

        @Override // android.widget.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ContactInfoItem getItem(int i) {
            return (ContactInfoItem) CircleManagerListActivity.this.t.get(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return CircleManagerListActivity.this.t.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewInflate;
            a aVar;
            if (view == null) {
                aVar = new a();
                viewInflate = this.f13184a.inflate(R.layout.adapter_circle_manager_list, (ViewGroup) null);
                aVar.b = (TextView) viewInflate.findViewById(R.id.nameTv);
                aVar.f13185a = (EffectiveShapeView) viewInflate.findViewById(R.id.avatarIv);
                aVar.c = (ImageView) viewInflate.findViewById(R.id.checkIv);
                viewInflate.setTag(aVar);
            } else {
                viewInflate = view;
                aVar = (a) view.getTag();
            }
            ContactInfoItem item = getItem(i);
            aVar.b.setText(item.getNameForShow());
            gr2.j().h(item.getIconURL(), aVar.f13185a, bq6.s());
            if (CircleManagerListActivity.this.u.contains(item)) {
                aVar.c.setImageResource(R.drawable.ic_checkbox_green_check);
            } else {
                aVar.c.setImageResource(R.drawable.ic_checkbox_uncheck);
            }
            return viewInflate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M1(List list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        if (this.t == null) {
            this.t = new ArrayList<>(list.size());
        }
        this.t.addAll(list);
        c cVar = new c(this);
        this.v = cVar;
        this.r.setAdapter((ListAdapter) cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N1(View view) {
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("key_select_member", this.u);
        setResult(-1, intent);
        finish();
    }

    public final void J1() {
        this.s = (GroupInfoItem) getIntent().getParcelableExtra("key_group_info");
        if (this.w) {
            c70.R().O(this.s.getGroupId(), new dv0() { // from class: ka0
                @Override // defpackage.dv0
                public final void onResponse(Object obj) {
                    this.f18605a.M1((List) obj);
                }
            });
        } else {
            c70.R().L(this.s.getGroupId(), 2, new b());
        }
    }

    public final void K1() {
        this.w = "forbidden".equals(getIntent().getStringExtra("type"));
        Toolbar toolbarInitToolbar = initToolbar(R.string.circle_delete_manager);
        TextView textView = (TextView) toolbarInitToolbar.findViewById(R.id.title);
        if (this.w) {
            textView.setText("解除禁言");
        } else {
            textView.setText(R.string.circle_delete_manager);
        }
        setSupportActionBar(toolbarInitToolbar);
        TextView textView2 = (TextView) findViewById(R.id.action_button);
        this.q = textView2;
        textView2.setText(R.string.confirm);
        this.q.setEnabled(false);
        this.q.setOnClickListener(new View.OnClickListener() { // from class: la0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18945a.N1(view);
            }
        });
    }

    public final void L1() {
        this.r = (ListView) findViewById(R.id.managerListView);
        this.u = new ArrayList<>(5);
        this.r.setOnItemClickListener(new a());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_manager);
        K1();
        L1();
        J1();
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
