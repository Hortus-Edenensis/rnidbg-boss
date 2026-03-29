package com.zenmen.palmchat.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.search.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.CharIndexView;
import defpackage.bo0;
import defpackage.eo0;
import defpackage.fn0;
import defpackage.il5;
import defpackage.qm5;
import defpackage.v8;
import defpackage.wn0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SelectContactActivity extends BaseActionBarActivity implements CharIndexView.a {
    public CopyOnWriteArrayList<ContactInfoItem> A;
    public int[] E;
    public HashMap<Character, Integer> F;
    public com.zenmen.palmchat.activity.search.c G;
    public ListView q;
    public CharIndexView r;
    public TextView s;
    public EditText t;
    public TextWatcher u;
    public ListView v;
    public View w;
    public wn0 x;
    public ArrayList<ContactInfoItem> y;
    public wn0 z;
    public ArrayList<ContactInfoItem> B = new ArrayList<>();
    public HashMap<String, ContactInfoItem> C = new HashMap<>();
    public int H = 0;
    public String I = null;
    public c.d J = new c();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            int firstVisiblePosition;
            View childAt = SelectContactActivity.this.q.getChildAt(0);
            if (childAt != null) {
                firstVisiblePosition = (-childAt.getTop()) + (SelectContactActivity.this.q.getFirstVisiblePosition() * childAt.getHeight());
            } else {
                firstVisiblePosition = 0;
            }
            if (firstVisiblePosition > 0) {
                SelectContactActivity.this.w.setVisibility(0);
            } else {
                SelectContactActivity.this.w.setVisibility(8);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            SelectContactActivity.this.t.clearFocus();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            SelectContactActivity.this.T1((ContactInfoItem) adapterView.getItemAtPosition(i));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements c.d {
        public c() {
        }

        @Override // com.zenmen.palmchat.activity.search.c.d
        public void a(c.f fVar) {
            SelectContactActivity.this.v.setVisibility(0);
            SelectContactActivity.this.q.setVisibility(8);
            SelectContactActivity.this.r.setVisibility(8);
            SelectContactActivity.this.y.clear();
            if (fVar.b != null) {
                if (SelectContactActivity.this.H != 0 || SelectContactActivity.this.I == null) {
                    SelectContactActivity.this.y.addAll(fVar.b);
                } else {
                    for (ContactInfoItem contactInfoItem : fVar.b) {
                        if (!SelectContactActivity.this.I.equals(contactInfoItem.getUid())) {
                            SelectContactActivity.this.y.add(contactInfoItem);
                        }
                    }
                }
            }
            if (TextUtils.isEmpty(SelectContactActivity.this.t.getText())) {
                SelectContactActivity.this.x.e(false);
            } else {
                SelectContactActivity.this.x.e(true);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SelectContactActivity.this.t.setText((CharSequence) null);
            SelectContactActivity.this.t.clearFocus();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements AdapterView.OnItemClickListener {
        public f() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            SelectContactActivity.this.T1((ContactInfoItem) adapterView.getItemAtPosition(i));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SelectContactActivity.this.z.c(SelectContactActivity.this.A);
            SelectContactActivity.this.z.notifyDataSetChanged();
        }
    }

    @Override // com.zenmen.palmchat.widget.CharIndexView.a
    public void F0() {
        this.s.setVisibility(8);
    }

    public final void N1() {
        CopyOnWriteArrayList<ContactInfoItem> copyOnWriteArrayListT = bo0.r().t(null);
        this.A = copyOnWriteArrayListT;
        if (this.H != 0 || this.I == null || copyOnWriteArrayListT == null) {
            return;
        }
        for (ContactInfoItem contactInfoItem : copyOnWriteArrayListT) {
            if (this.I.equals(contactInfoItem.getUid())) {
                this.A.remove(contactInfoItem);
            }
        }
        if (v8.h()) {
            ArrayList arrayList = new ArrayList();
            for (ContactInfoItem contactInfoItem2 : this.A) {
                if (v8.C(contactInfoItem2.getUid())) {
                    arrayList.add(contactInfoItem2);
                }
            }
            if (arrayList.size() > 0) {
                LogUtil.d("AiChatPeopleManagerTag", "SelectContactActivity removeAll aiItems size " + arrayList.size());
                this.A.removeAll(arrayList);
            }
        }
    }

    public final void O1(List<ContactInfoItem> list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            char cA = eo0.a(list.get(i2).getIndexPinyin(true).charAt(0));
            if (this.F.get(Character.valueOf(cA)) == null) {
                this.F.put(Character.valueOf(cA), Integer.valueOf(i2));
            }
        }
        char c2 = 0;
        while (true) {
            char[] cArr = CharIndexView.charArray;
            if (i >= cArr.length) {
                return;
            }
            char c3 = cArr[i];
            if (this.F.get(Character.valueOf(c3)) != null) {
                c2 = c3;
            } else if (c2 != 0) {
                this.F.put(Character.valueOf(c3), this.F.get(Character.valueOf(c2)));
            }
            i++;
        }
    }

    @Override // com.zenmen.palmchat.widget.CharIndexView.a
    public void P0(char c2) {
        int iIntValue;
        this.s.setText(Character.toString(c2));
        if (this.F.get(Character.valueOf(c2)) == null || (iIntValue = this.F.get(Character.valueOf(c2)).intValue()) < 0) {
            return;
        }
        this.q.setSelectionFromTop(iIntValue + 1, (int) getResources().getDimension(R.dimen.list_group_header_height));
    }

    public final void P1() {
        this.y = new ArrayList<>();
        this.v = (ListView) findViewById(R.id.search_result_list);
        findViewById(R.id.empty_view).setOnClickListener(new d());
        this.v.setChoiceMode(2);
        wn0 wn0Var = new wn0(this, this.t);
        this.x = wn0Var;
        this.v.setAdapter((ListAdapter) wn0Var);
        this.x.c(this.y);
        this.x.b(this.C);
        if (this.u == null) {
            this.u = new e();
        }
        this.v.setOnItemClickListener(new f());
        this.t.addTextChangedListener(this.u);
    }

    public final void Q1() {
        initToolbar(R.string.choose_contact);
    }

    public final void R1() {
        N1();
        int[] iArr = new int[CharIndexView.charArray.length];
        this.E = iArr;
        Arrays.fill(iArr, -1);
        this.F = new HashMap<>();
        CharIndexView charIndexView = (CharIndexView) findViewById(R.id.index_view);
        this.r = charIndexView;
        charIndexView.setOnCharacterTouchedListener(this);
        this.s = (TextView) findViewById(R.id.char_indicator);
        this.w = findViewById(R.id.sepView);
        this.q = (ListView) findViewById(R.id.contacts_list);
        this.t = (EditText) findViewById(R.id.search);
        this.q.setOnScrollListener(new a());
        this.q.setOnItemClickListener(new b());
        this.q.addHeaderView(getLayoutInflater().inflate(R.layout.list_headerview_group_chat_contacts_header, (ViewGroup) null, false));
        wn0 wn0Var = new wn0(this, this.t);
        this.z = wn0Var;
        this.q.setAdapter((ListAdapter) wn0Var);
        this.z.b(this.C);
        this.z.c(this.A);
        O1(this.A);
        this.z.notifyDataSetChanged();
        bo0.r().i().j(this);
        this.G = new com.zenmen.palmchat.activity.search.c(this.J, false);
        P1();
    }

    public final void S1() {
        this.H = getIntent().getIntExtra("extra_from", 0);
        this.I = getIntent().getStringExtra("current_chat_id");
    }

    public final void T1(ContactInfoItem contactInfoItem) {
        if (contactInfoItem != null) {
            Intent intent = new Intent();
            intent.putExtra("selected_item", contactInfoItem);
            setResult(-1, intent);
        }
        finish();
    }

    @qm5
    public void onContactChanged(fn0 fn0Var) {
        N1();
        O1(this.A);
        runOnUiThread(new g());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        S1();
        setContentView(R.layout.layout_activity_select_contact);
        Q1();
        R1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bo0.r().i().l(this);
        this.G.q();
    }

    @Override // com.zenmen.palmchat.widget.CharIndexView.a
    public void r() {
        this.s.setVisibility(0);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements TextWatcher {
        public e() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String strQ = il5.q(charSequence.toString().toLowerCase());
            if (!TextUtils.isEmpty(strQ)) {
                SelectContactActivity.this.G.p(0, strQ);
                return;
            }
            SelectContactActivity.this.v.setVisibility(8);
            SelectContactActivity.this.q.setVisibility(0);
            SelectContactActivity.this.r.setVisibility(0);
            SelectContactActivity.this.y.clear();
            SelectContactActivity.this.y.addAll(SelectContactActivity.this.A);
            SelectContactActivity.this.x.e(false);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
