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
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.MaterialDialog;
import com.wifi.adsdk.utils.CollectionUtils;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.ui.CircleAdministratorActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.bq6;
import defpackage.c70;
import defpackage.gr2;
import defpackage.qa0;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.wi0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleAdministratorActivity extends BaseActionBarActivity {
    public ListView q;
    public f s;
    public TextView t;
    public Toolbar u;
    public GroupInfoItem v;
    public int y;
    public ArrayList<ContactInfoItem> r = new ArrayList<>();
    public final int w = 1;
    public final int x = 2;
    public boolean z = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CircleAdministratorActivity.this.z) {
                CircleAdministratorActivity.this.t.setText("编辑");
            } else {
                CircleAdministratorActivity.this.t.setText("完成");
            }
            CircleAdministratorActivity.this.z = !r2.z;
            CircleAdministratorActivity.this.s.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < CircleAdministratorActivity.this.r.size() || CircleAdministratorActivity.this.z) {
                return;
            }
            Intent intent = CircleAdministratorActivity.this.getIntent();
            intent.setClass(CircleAdministratorActivity.this, CircleMemberListActivity.class);
            intent.putExtra("type", "admin");
            CircleAdministratorActivity.this.startActivityForResult(intent, 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends wi0<BaseResponse<List<ContactInfoItem>>> {
        public c() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<List<ContactInfoItem>> baseResponse) {
            if (baseResponse == null || CollectionUtils.isEmpty(baseResponse.getData())) {
                return;
            }
            List<ContactInfoItem> data = baseResponse.getData();
            CircleAdministratorActivity.this.O1(data);
            CircleAdministratorActivity.this.r.addAll(data);
            CircleAdministratorActivity.this.s.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f13057a;

        public d(List list) {
            this.f13057a = list;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            boolean z;
            if (baseResponse.getResultCode() != 0) {
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleAdministratorActivity.this, R.string.send_failed, 0).g();
                    return;
                } else {
                    sy5.f(CircleAdministratorActivity.this, baseResponse.getErrorMsg(), 0).g();
                    return;
                }
            }
            Iterator it = this.f13057a.iterator();
            while (it.hasNext()) {
                ((ContactInfoItem) it.next()).setRoleType(2);
            }
            for (ContactInfoItem contactInfoItem : this.f13057a) {
                String uid = contactInfoItem.getUid();
                Iterator it2 = CircleAdministratorActivity.this.r.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (TextUtils.equals(uid, ((ContactInfoItem) it2.next()).getUid())) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    CircleAdministratorActivity.this.r.add(contactInfoItem);
                }
            }
            CircleAdministratorActivity circleAdministratorActivity = CircleAdministratorActivity.this;
            circleAdministratorActivity.O1(circleAdministratorActivity.r);
            CircleAdministratorActivity.this.s.notifyDataSetChanged();
            c70.R().C0(false, new String[0]);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f13058a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends wi0<BaseResponse> {
            public a() {
            }

            @Override // defpackage.wi0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(BaseResponse baseResponse) {
                if (baseResponse.getResultCode() != 0) {
                    if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                        sy5.e(CircleAdministratorActivity.this, R.string.send_failed, 0).g();
                        return;
                    } else {
                        sy5.f(CircleAdministratorActivity.this, baseResponse.getErrorMsg(), 0).g();
                        return;
                    }
                }
                for (int i = 0; i < CircleAdministratorActivity.this.r.size(); i++) {
                    for (int i2 = 0; i2 < e.this.f13058a.size(); i2++) {
                        if (((ContactInfoItem) CircleAdministratorActivity.this.r.get(i)).getUid().equals(((ContactInfoItem) e.this.f13058a.get(i2)).getUid())) {
                            CircleAdministratorActivity.this.r.remove(i);
                        }
                    }
                }
                CircleAdministratorActivity circleAdministratorActivity = CircleAdministratorActivity.this;
                circleAdministratorActivity.O1(circleAdministratorActivity.r);
                CircleAdministratorActivity.this.s.notifyDataSetChanged();
                c70.R().C0(false, new String[0]);
            }
        }

        public e(List list) {
            this.f13058a = list;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            ArrayList arrayList = new ArrayList(this.f13058a.size());
            for (int i = 0; i < this.f13058a.size(); i++) {
                arrayList.add(((ContactInfoItem) this.f13058a.get(i)).getUid());
            }
            qa0.i().l(CircleAdministratorActivity.this.v.getGroupId(), arrayList, new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f13060a;
        public LayoutInflater b;
        public HashMap<String, Integer> c;

        /* JADX INFO: compiled from: SearchBox */
        public class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public TextView f13061a;
            public TextView b;
            public ImageView c;
            public EffectiveShapeView d;

            public a() {
            }
        }

        public f(Context context) {
            this.b = LayoutInflater.from(context);
            this.f13060a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(ArrayList arrayList, View view) {
            CircleAdministratorActivity.this.L1(arrayList);
        }

        public void c(HashMap<String, Integer> map) {
            this.c = map;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return CircleAdministratorActivity.this.r.size() + 1;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (i < CircleAdministratorActivity.this.r.size()) {
                return CircleAdministratorActivity.this.r.get(i);
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
                viewInflate = this.b.inflate(R.layout.list_item_circle_admin, (ViewGroup) null);
                aVar.b = (TextView) viewInflate.findViewById(R.id.nameTv);
                aVar.c = (ImageView) viewInflate.findViewById(R.id.circle_iv_del_admin);
                aVar.f13061a = (TextView) viewInflate.findViewById(R.id.circle_tv_role_type_section_header);
                aVar.d = (EffectiveShapeView) viewInflate.findViewById(R.id.avatarIv);
                viewInflate.setTag(aVar);
            } else {
                viewInflate = view;
                aVar = (a) view.getTag();
            }
            int i2 = 8;
            if (i >= CircleAdministratorActivity.this.r.size()) {
                aVar.b.setText("添加群管理员");
                aVar.f13061a.setVisibility(8);
                gr2.j().e(R.drawable.circle_add_admin, aVar.d, bq6.s());
                if (CircleAdministratorActivity.this.z) {
                    aVar.b.setTextColor(-1644826);
                } else {
                    aVar.b.setTextColor(-14671840);
                }
                aVar.c.setVisibility(8);
            } else {
                HashMap<String, Integer> map = this.c;
                if (map == null) {
                    aVar.f13061a.setVisibility(8);
                } else if (map.containsKey("owner") && i == this.c.get("owner").intValue()) {
                    aVar.f13061a.setVisibility(0);
                    aVar.f13061a.setText(R.string.circle_role_type_owner);
                } else if (this.c.containsKey("admin") && i == this.c.get("admin").intValue()) {
                    aVar.f13061a.setVisibility(0);
                    TextView textView = aVar.f13061a;
                    CircleAdministratorActivity circleAdministratorActivity = CircleAdministratorActivity.this;
                    textView.setText(circleAdministratorActivity.getString(R.string.circle_role_type_admin, Integer.valueOf(circleAdministratorActivity.y)));
                } else {
                    aVar.f13061a.setVisibility(8);
                }
                ContactInfoItem contactInfoItem = (ContactInfoItem) CircleAdministratorActivity.this.r.get(i);
                aVar.b.setTextColor(-14671840);
                aVar.b.setText(contactInfoItem.getNameForShow());
                String himg = contactInfoItem.getHimg();
                if (TextUtils.isEmpty(himg)) {
                    himg = contactInfoItem.getIconURL();
                }
                gr2.j().h(himg, aVar.d, bq6.s());
                ImageView imageView = aVar.c;
                if (CircleAdministratorActivity.this.z && contactInfoItem.getRoleType() == 2) {
                    i2 = 0;
                }
                imageView.setVisibility(i2);
                final ArrayList arrayList = new ArrayList();
                arrayList.add((ContactInfoItem) CircleAdministratorActivity.this.r.get(i));
                aVar.c.setOnClickListener(new View.OnClickListener() { // from class: m60
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.f19143a.b(arrayList, view2);
                    }
                });
            }
            return viewInflate;
        }
    }

    public static /* synthetic */ int N1(ContactInfoItem contactInfoItem, ContactInfoItem contactInfoItem2) {
        return contactInfoItem.getRoleType() - contactInfoItem2.getRoleType();
    }

    public final void K1(List<ContactInfoItem> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(list.get(i).getUid());
        }
        qa0.i().b(this.v.getGroupId(), arrayList, new d(list));
    }

    public final void L1(List<ContactInfoItem> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        new sd3(this).k("是否移除" + list.get(0).getNameForShow() + "管理员身份。解除后他将不再有群管理权限。").O(R.string.dialog_confirm).K(R.string.sr_cancel_str).h(false).f(new e(list)).e().show();
    }

    public final void M1() {
        qa0.i().h(this.v.getGroupId(), new c());
    }

    public final void O1(List<ContactInfoItem> list) {
        Collections.sort(list, new Comparator() { // from class: l60
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return CircleAdministratorActivity.N1((ContactInfoItem) obj, (ContactInfoItem) obj2);
            }
        });
        HashMap<String, Integer> map = new HashMap<>();
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            ContactInfoItem contactInfoItem = list.get(i2);
            if (contactInfoItem.getRoleType() == 1) {
                if (!map.containsKey("owner")) {
                    map.put("owner", Integer.valueOf(i2));
                }
            } else if (contactInfoItem.getRoleType() == 2) {
                i++;
                if (!map.containsKey("admin")) {
                    map.put("admin", Integer.valueOf(i2));
                }
            }
        }
        this.y = i;
        this.s.c(map);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i == 1) {
            K1(intent.getParcelableArrayListExtra("key_select_member"));
        } else if (i == 2) {
            L1(intent.getParcelableArrayListExtra("key_select_member"));
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_administrator);
        Toolbar toolbarInitToolbar = initToolbar("群管理员");
        this.u = toolbarInitToolbar;
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText("群管理员");
        setSupportActionBar(this.u);
        this.v = (GroupInfoItem) getIntent().getParcelableExtra("key_group_info");
        TextView textView = (TextView) findViewById(R.id.action_button);
        this.t = textView;
        textView.setTextColor(getResources().getColor(R.color.color_262626));
        this.t.setText("编辑");
        this.t.setBackgroundDrawable(null);
        this.t.setOnClickListener(new a());
        this.q = (ListView) findViewById(R.id.layout_circle_admin_list);
        f fVar = new f(this);
        this.s = fVar;
        this.q.setAdapter((ListAdapter) fVar);
        this.q.setOnItemClickListener(new b());
        M1();
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
