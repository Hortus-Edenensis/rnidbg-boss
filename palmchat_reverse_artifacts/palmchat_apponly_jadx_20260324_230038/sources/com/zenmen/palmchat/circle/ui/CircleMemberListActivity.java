package com.zenmen.palmchat.circle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.wifi.adsdk.utils.CollectionUtils;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.search.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.widget.CharIndexView;
import defpackage.bo0;
import defpackage.c70;
import defpackage.dv0;
import defpackage.eo0;
import defpackage.il5;
import defpackage.k70;
import defpackage.ry5;
import defpackage.sy5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleMemberListActivity extends BaseActionBarActivity implements CharIndexView.a {
    public int[] B;
    public HashMap<Character, Integer> C;
    public com.zenmen.palmchat.activity.search.c E;
    public GroupInfoItem H;
    public TextView I;
    public ListView q;
    public TextView r;
    public EditText s;
    public TextWatcher t;
    public ListView u;
    public View v;
    public k70 w;
    public k70 y;
    public ArrayList<ContactInfoItem> x = new ArrayList<>();
    public CopyOnWriteArrayList<ContactInfoItem> z = new CopyOnWriteArrayList<>();
    public ArrayList<ContactInfoItem> A = new ArrayList<>(5);
    public String F = null;
    public int G = 0;
    public c.d J = new c();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            int firstVisiblePosition;
            View childAt = CircleMemberListActivity.this.q.getChildAt(0);
            if (childAt != null) {
                firstVisiblePosition = (-childAt.getTop()) + (CircleMemberListActivity.this.q.getFirstVisiblePosition() * childAt.getHeight());
            } else {
                firstVisiblePosition = 0;
            }
            if (firstVisiblePosition > 0) {
                CircleMemberListActivity.this.v.setVisibility(0);
            } else {
                CircleMemberListActivity.this.v.setVisibility(8);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            CircleMemberListActivity.this.s.clearFocus();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            CircleMemberListActivity.this.Y1((ContactInfoItem) adapterView.getItemAtPosition(i));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements c.d {
        public c() {
        }

        @Override // com.zenmen.palmchat.activity.search.c.d
        public void a(c.f fVar) {
            boolean z;
            CircleMemberListActivity.this.u.setVisibility(0);
            CircleMemberListActivity.this.q.setVisibility(8);
            CircleMemberListActivity.this.x.clear();
            if (fVar.b != null) {
                if (CircleMemberListActivity.this.F != null) {
                    for (ContactInfoItem contactInfoItem : fVar.b) {
                        if (!CircleMemberListActivity.this.F.equals(contactInfoItem.getUid())) {
                            if (CircleMemberListActivity.this.G == 0 || CircleMemberListActivity.this.G == 1) {
                                Iterator it = CircleMemberListActivity.this.z.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (TextUtils.equals(((ContactInfoItem) it.next()).getUid(), contactInfoItem.getUid())) {
                                            z = true;
                                            break;
                                        }
                                    } else {
                                        z = false;
                                        break;
                                    }
                                }
                                if (z) {
                                    CircleMemberListActivity.this.x.add(contactInfoItem);
                                }
                            } else {
                                CircleMemberListActivity.this.x.add(contactInfoItem);
                            }
                        }
                    }
                } else if (CircleMemberListActivity.this.G == 0 || CircleMemberListActivity.this.G == 1) {
                    for (ContactInfoItem contactInfoItem2 : CircleMemberListActivity.this.z) {
                        String strQ = il5.q(CircleMemberListActivity.this.s.getText().toString().toLowerCase());
                        if (!TextUtils.isEmpty(contactInfoItem2.getFirstPinyin()) && contactInfoItem2.getFirstPinyin().toLowerCase().contains(strQ)) {
                            CircleMemberListActivity.this.x.add(contactInfoItem2);
                        } else if (!TextUtils.isEmpty(contactInfoItem2.getNickName()) && contactInfoItem2.getNickName().toLowerCase().contains(strQ)) {
                            CircleMemberListActivity.this.x.add(contactInfoItem2);
                        } else if (!TextUtils.isEmpty(contactInfoItem2.getAllPinyin()) && contactInfoItem2.getAllPinyin().toLowerCase().contains(strQ)) {
                            CircleMemberListActivity.this.x.add(contactInfoItem2);
                        }
                    }
                } else {
                    CircleMemberListActivity.this.x.addAll(fVar.b);
                }
            }
            if (TextUtils.isEmpty(CircleMemberListActivity.this.s.getText())) {
                CircleMemberListActivity.this.w.e(false);
            } else {
                CircleMemberListActivity.this.w.e(true);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CircleMemberListActivity.this.s.setText((CharSequence) null);
            CircleMemberListActivity.this.s.clearFocus();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements AdapterView.OnItemClickListener {
        public f() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            CircleMemberListActivity.this.Y1((ContactInfoItem) adapterView.getItemAtPosition(i));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements AdapterView.OnItemClickListener {
        public g() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            CircleMemberListActivity.this.Y1((ContactInfoItem) adapterView.getItemAtPosition(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V1(List list, List list2) {
        for (int i = 0; i < list.size(); i++) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (((ContactInfoItem) list.get(i)).getUid().equals(((ContactInfoItem) list2.get(i2)).getUid())) {
                    list.remove(i);
                }
            }
        }
        P1(list);
        findViewById(R.id.circle_member_list_empty_title).setVisibility(CollectionUtils.isEmpty(list) ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W1(final List list) {
        if (list == null || list.size() <= 0) {
            findViewById(R.id.circle_member_list_empty_title).setVisibility(0);
            sy5.f(this, "没有群成员", 0).g();
            return;
        }
        int i = this.G;
        if (i == 0) {
            P1(list);
        } else if (i == 1) {
            c70.R().O(this.H.getGroupId(), new dv0() { // from class: oa0
                @Override // defpackage.dv0
                public final void onResponse(Object obj) {
                    this.f19723a.V1(list, (List) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X1(View view) {
        int i = this.G;
        if (i == 0) {
            a2();
            return;
        }
        if (i == 1) {
            if (CollectionUtils.isEmpty(this.A)) {
                ry5.a("请选择成员");
                return;
            }
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("key_select_member", this.A);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.zenmen.palmchat.widget.CharIndexView.a
    public void F0() {
        this.r.setVisibility(8);
    }

    public final void O1() {
        c70.R().L(this.H.getGroupId(), 3, new dv0() { // from class: na0
            @Override // defpackage.dv0
            public final void onResponse(Object obj) {
                this.f19469a.W1((List) obj);
            }
        });
    }

    @Override // com.zenmen.palmchat.widget.CharIndexView.a
    public void P0(char c2) {
        int iIntValue;
        this.r.setText(Character.toString(c2));
        if (this.C.get(Character.valueOf(c2)) == null || (iIntValue = this.C.get(Character.valueOf(c2)).intValue()) < 0) {
            return;
        }
        this.q.setSelectionFromTop(iIntValue + 1, (int) getResources().getDimension(R.dimen.list_group_header_height));
    }

    public final void P1(List<ContactInfoItem> list) {
        CopyOnWriteArrayList<ContactInfoItem> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.z = copyOnWriteArrayList;
        copyOnWriteArrayList.addAll(list);
        this.y.c(this.z);
        Q1(this.z);
        this.y.notifyDataSetChanged();
    }

    public final void Q1(List<ContactInfoItem> list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            char cA = eo0.a(list.get(i2).getIndexPinyin(true).charAt(0));
            if (this.C.get(Character.valueOf(cA)) == null) {
                this.C.put(Character.valueOf(cA), Integer.valueOf(i2));
            }
        }
        char c2 = 0;
        while (true) {
            char[] cArr = CharIndexView.charArray;
            if (i >= cArr.length) {
                return;
            }
            char c3 = cArr[i];
            if (this.C.get(Character.valueOf(c3)) != null) {
                c2 = c3;
            } else if (c2 != 0) {
                this.C.put(Character.valueOf(c3), this.C.get(Character.valueOf(c2)));
            }
            i++;
        }
    }

    public final void R1() {
        this.x = new ArrayList<>();
        this.u = (ListView) findViewById(R.id.search_result_list);
        findViewById(R.id.empty_view).setOnClickListener(new d());
        this.u.setChoiceMode(2);
        k70 k70Var = new k70(this, this.s);
        this.w = k70Var;
        this.u.setAdapter((ListAdapter) k70Var);
        this.w.c(this.x);
        this.w.f(this.A);
        this.w.g(true);
        if (this.t == null) {
            this.t = new e();
        }
        this.u.setOnItemClickListener(new f());
        this.s.addTextChangedListener(this.t);
        this.q.setOnItemClickListener(new g());
    }

    public final void S1() {
        Toolbar toolbarInitToolbar = initToolbar(R.string.circle_add_manager);
        TextView textView = (TextView) toolbarInitToolbar.findViewById(R.id.title);
        int i = this.G;
        if (i == 0) {
            textView.setText(R.string.circle_add_manager);
        } else if (i == 1) {
            textView.setText(R.string.circle_forbidden_message);
        }
        setSupportActionBar(toolbarInitToolbar);
        TextView textView2 = (TextView) findViewById(R.id.action_button);
        this.I = textView2;
        textView2.setTextColor(getResources().getColor(R.color.color_262626));
        this.I.setBackgroundDrawable(null);
        this.I.setText(R.string.confirm);
        this.I.setOnClickListener(new View.OnClickListener() { // from class: ma0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19173a.X1(view);
            }
        });
    }

    public final void T1() {
        int[] iArr = new int[CharIndexView.charArray.length];
        this.B = iArr;
        Arrays.fill(iArr, -1);
        this.C = new HashMap<>();
        this.r = (TextView) findViewById(R.id.char_indicator);
        this.v = findViewById(R.id.sepView);
        this.q = (ListView) findViewById(R.id.circle_contacts_list);
        this.s = (EditText) findViewById(R.id.search);
        this.q.setOnScrollListener(new a());
        this.q.setOnItemClickListener(new b());
        this.q.addHeaderView(getLayoutInflater().inflate(R.layout.list_headerview_group_chat_contacts_header, (ViewGroup) null, false));
        k70 k70Var = new k70(this, this.s);
        this.y = k70Var;
        this.q.setAdapter((ListAdapter) k70Var);
        this.y.f(this.A);
        this.y.g(true);
        this.E = new com.zenmen.palmchat.activity.search.c(this.J, false);
        R1();
    }

    public final boolean U1(String str) {
        for (int i = 0; i < this.A.size(); i++) {
            if (this.A.get(i).getUid().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public final void Y1(ContactInfoItem contactInfoItem) {
        if (this.G == 2) {
            return;
        }
        if (contactInfoItem != null) {
            if (U1(contactInfoItem.getUid())) {
                Z1(contactInfoItem.getUid(), this.A);
            } else {
                this.A.add(contactInfoItem);
                this.I.setEnabled(true);
            }
        }
        this.y.notifyDataSetChanged();
        this.w.notifyDataSetChanged();
    }

    public final void Z1(String str, List<ContactInfoItem> list) {
        for (int i = 0; i < list.size(); i++) {
            if (str.equals(list.get(i).getUid())) {
                list.remove(i);
                return;
            }
        }
    }

    public final void a2() {
        if (CollectionUtils.isEmpty(this.A)) {
            ry5.a("请选择成员");
            return;
        }
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("key_select_member", this.A);
        setResult(-1, intent);
        finish();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("type");
        if (stringExtra.equals("admin")) {
            this.G = 0;
        }
        if (stringExtra.equals("forbidden")) {
            this.G = 1;
        }
        if (stringExtra.equals("transfer")) {
            this.G = 2;
        }
        setContentView(R.layout.activity_circle_member_list);
        S1();
        this.H = (GroupInfoItem) getIntent().getParcelableExtra("key_group_info");
        T1();
        O1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bo0.r().i().l(this);
        this.E.q();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.widget.CharIndexView.a
    public void r() {
        this.r.setVisibility(0);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements TextWatcher {
        public e() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String strQ = il5.q(charSequence.toString().toLowerCase());
            if (!TextUtils.isEmpty(strQ)) {
                CircleMemberListActivity.this.E.p(0, strQ);
                return;
            }
            CircleMemberListActivity.this.u.setVisibility(8);
            CircleMemberListActivity.this.q.setVisibility(0);
            CircleMemberListActivity.this.x.clear();
            CircleMemberListActivity.this.x.addAll(CircleMemberListActivity.this.z);
            CircleMemberListActivity.this.w.e(false);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
