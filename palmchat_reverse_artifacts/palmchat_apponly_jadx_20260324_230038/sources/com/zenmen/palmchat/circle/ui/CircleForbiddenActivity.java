package com.zenmen.palmchat.circle.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.wifi.adsdk.utils.CollectionUtils;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.bq6;
import defpackage.c70;
import defpackage.gr2;
import defpackage.k80;
import defpackage.qa0;
import defpackage.sy5;
import defpackage.wi0;
import defpackage.ze2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleForbiddenActivity extends BaseActionBarActivity {
    public k80 A;
    public Toolbar q;
    public ListView r;
    public GroupInfoItem s;
    public i t;
    public TextView w;
    public CheckBox x;
    public ArrayList<ContactInfoItem> u = new ArrayList<>();
    public ArrayList<ContactInfoItem> v = new ArrayList<>();
    public final int y = 1;
    public final int z = 2;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = CircleForbiddenActivity.this.getIntent();
            intent.setClass(CircleForbiddenActivity.this, CircleManagerListActivity.class);
            intent.putExtra("type", "forbidden");
            CircleForbiddenActivity.this.startActivityForResult(intent, 2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == 0) {
                Intent intent = CircleForbiddenActivity.this.getIntent();
                intent.setClass(CircleForbiddenActivity.this, CircleMemberListActivity.class);
                intent.putExtra("type", "forbidden");
                CircleForbiddenActivity.this.startActivityForResult(intent, 1);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements CompoundButton.OnCheckedChangeListener {
        public c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                CircleForbiddenActivity.this.G1();
            } else {
                CircleForbiddenActivity.this.K1();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends wi0<BaseResponse<ArrayList<ContactInfoItem>>> {
        public d() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<ArrayList<ContactInfoItem>> baseResponse) {
            if (baseResponse == null || CollectionUtils.isEmpty(baseResponse.getData())) {
                return;
            }
            CircleForbiddenActivity.this.u.addAll(baseResponse.getData());
            CircleForbiddenActivity.this.t.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends wi0<BaseResponse> {
        public e() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            if (baseResponse.getResultCode() == 0) {
                c70.R().C0(false, new String[0]);
            } else {
                if (CircleForbiddenActivity.this.A.d(CircleForbiddenActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                    return;
                }
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleForbiddenActivity.this, R.string.send_failed, 0).g();
                } else {
                    sy5.f(CircleForbiddenActivity.this, baseResponse.getErrorMsg(), 0).g();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends wi0<BaseResponse> {
        public f() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            if (baseResponse.getResultCode() == 0) {
                c70.R().C0(false, new String[0]);
            } else {
                if (CircleForbiddenActivity.this.A.d(CircleForbiddenActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                    return;
                }
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleForbiddenActivity.this, R.string.send_failed, 0).g();
                } else {
                    sy5.f(CircleForbiddenActivity.this, baseResponse.getErrorMsg(), 0).g();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f13164a;

        public g(List list) {
            this.f13164a = list;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            if (baseResponse.getResultCode() == 0) {
                CircleForbiddenActivity.this.u.addAll(this.f13164a);
                CircleForbiddenActivity.this.t.notifyDataSetChanged();
                c70.R().C0(false, new String[0]);
            } else {
                if (CircleForbiddenActivity.this.A.d(CircleForbiddenActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                    return;
                }
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleForbiddenActivity.this, R.string.send_failed, 0).g();
                } else {
                    sy5.f(CircleForbiddenActivity.this, baseResponse.getErrorMsg(), 0).g();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f13165a;

        public h(List list) {
            this.f13165a = list;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            if (baseResponse.getResultCode() != 0) {
                if (CircleForbiddenActivity.this.A.d(CircleForbiddenActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                    return;
                }
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleForbiddenActivity.this, R.string.send_failed, 0).g();
                    return;
                } else {
                    sy5.f(CircleForbiddenActivity.this, baseResponse.getErrorMsg(), 0).g();
                    return;
                }
            }
            for (int i = 0; i < CircleForbiddenActivity.this.u.size(); i++) {
                for (int i2 = 0; i2 < this.f13165a.size(); i2++) {
                    if (((ContactInfoItem) CircleForbiddenActivity.this.u.get(i)).getUid().equals(((ContactInfoItem) this.f13165a.get(i2)).getUid())) {
                        CircleForbiddenActivity.this.u.remove(i);
                    }
                }
            }
            CircleForbiddenActivity.this.t.notifyDataSetChanged();
            c70.R().C0(false, new String[0]);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LayoutInflater f13166a;

        /* JADX INFO: compiled from: SearchBox */
        public class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public TextView f13167a;
            public TextView b;
            public EffectiveShapeView c;

            public a() {
            }
        }

        public i(Context context) {
            this.f13166a = LayoutInflater.from(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(ContactInfoItem contactInfoItem, View view) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(contactInfoItem);
            CircleForbiddenActivity.this.I1(arrayList);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return CircleForbiddenActivity.this.u.size() + 1;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (i < CircleForbiddenActivity.this.u.size()) {
                return CircleForbiddenActivity.this.u.get(i);
            }
            return null;
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
                viewInflate = this.f13166a.inflate(R.layout.list_item_circle_mute_mem_item, (ViewGroup) null);
                aVar.f13167a = (TextView) viewInflate.findViewById(R.id.nameTv);
                aVar.c = (EffectiveShapeView) viewInflate.findViewById(R.id.avatarIv);
                aVar.b = (TextView) viewInflate.findViewById(R.id.circle_mute_cancel_btn);
                viewInflate.setTag(aVar);
            } else {
                viewInflate = view;
                aVar = (a) view.getTag();
            }
            if (i == 0) {
                aVar.f13167a.setText("添加禁言成员");
                aVar.c.setImageResource(R.drawable.circle_add_admin);
                aVar.b.setVisibility(8);
            } else {
                final ContactInfoItem contactInfoItem = (ContactInfoItem) CircleForbiddenActivity.this.u.get(i - 1);
                aVar.f13167a.setText(contactInfoItem.getNameForShow());
                String iconURL = contactInfoItem.getIconURL();
                if (TextUtils.isEmpty(iconURL)) {
                    iconURL = contactInfoItem.getHimg();
                }
                gr2.j().h(iconURL, aVar.c, bq6.s());
                aVar.b.setVisibility(0);
                aVar.b.setOnClickListener(new View.OnClickListener() { // from class: e90
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.f17236a.b(contactInfoItem, view2);
                    }
                });
            }
            return viewInflate;
        }
    }

    public final void G1() {
        qa0.i().f(this.s.getGroupId(), new e());
    }

    public final void H1(List<ContactInfoItem> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(list.get(i2).getUid());
        }
        qa0.i().k(this.s.getGroupId(), arrayList, new g(list));
    }

    public final void I1(List<ContactInfoItem> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(list.get(i2).getUid());
        }
        qa0.i().m(this.s.getGroupId(), arrayList, new h(list));
    }

    public final void J1() {
        c70.R().P(this.s.getGroupId(), new d());
    }

    public final void K1() {
        qa0.i().e(this.s.getGroupId(), new f());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            return;
        }
        if (i2 == 1) {
            H1(intent.getParcelableArrayListExtra("key_select_member"));
        } else if (i2 == 2) {
            I1(intent.getParcelableArrayListExtra("key_select_member"));
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_forbidden);
        Toolbar toolbarInitToolbar = initToolbar("");
        this.q = toolbarInitToolbar;
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(R.string.circle_forbidden_message);
        setSupportActionBar(this.q);
        TextView textView = (TextView) findViewById(R.id.action_button);
        this.w = textView;
        textView.setVisibility(8);
        this.w.setOnClickListener(new a());
        this.s = (GroupInfoItem) getIntent().getParcelableExtra("key_group_info");
        this.r = (ListView) findViewById(R.id.forbiddenListView);
        i iVar = new i(this);
        this.t = iVar;
        this.r.setAdapter((ListAdapter) iVar);
        this.r.setOnItemClickListener(new b());
        CheckBox checkBox = (CheckBox) findViewById(R.id.circle_forbidden_all);
        this.x = checkBox;
        checkBox.setOnCheckedChangeListener(new c());
        boolean z = false;
        GroupInfoItem groupInfoItemA = ze2.a(this.s.getGroupId(), 0);
        CheckBox checkBox2 = this.x;
        if (groupInfoItemA != null && groupInfoItemA.getDiffuse() == 1) {
            z = true;
        }
        checkBox2.setChecked(z);
        J1();
        this.A = new k80(this.s);
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
