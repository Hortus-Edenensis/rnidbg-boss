package com.zenmen.palmchat.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseFragment;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.NewContactActivity;
import com.zenmen.palmchat.contacts.recommend.EnhanceRecommendActivity;
import com.zenmen.palmchat.groupchat.GroupListActivity;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.maintab.CellUpdateEvent;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.CharIndexView;
import com.zenmen.palmchat.widget.SocialPortraitView;
import defpackage.a65;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.ch;
import defpackage.d65;
import defpackage.ds0;
import defpackage.eo0;
import defpackage.f7;
import defpackage.fn0;
import defpackage.gr2;
import defpackage.gu4;
import defpackage.ih;
import defpackage.io0;
import defpackage.ip3;
import defpackage.k86;
import defpackage.l50;
import defpackage.m66;
import defpackage.on0;
import defpackage.qm5;
import defpackage.r75;
import defpackage.td3;
import defpackage.tn0;
import defpackage.uk5;
import defpackage.yb0;
import defpackage.zn6;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ContactsFragment extends BaseFragment implements CharIndexView.a {
    public static final String M = "ContactsFragment";
    public ih A;
    public CopyOnWriteArrayList<ContactInfoItem> C;
    public int[] E;
    public HashMap<Character, Integer> F;
    public ContactInfoItem H;
    public boolean J;
    public boolean K;
    public ViewGroup L;
    public ListView f;
    public eo0 g;
    public View h;
    public CharIndexView i;
    public TextView j;
    public View k;
    public View l;
    public RelativeLayout m;
    public TextView n;
    public LinearLayout o;
    public TextView p;
    public SocialPortraitView q;
    public TextView r;
    public RelativeLayout s;
    public RelativeLayout t;
    public TextView u;
    public View v;
    public TextView w;
    public TextView x;
    public SocialPortraitView y;
    public f7 z;
    public int B = 3;
    public String G = "2";
    public int I = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ContactInfoItem contactInfoItem = (ContactInfoItem) adapterView.getItemAtPosition(i);
            if (contactInfoItem != null) {
                if (!TextUtils.isEmpty(contactInfoItem.getMobile()) && contactInfoItem.getMobile().equals(ContactsFragment.this.getResources().getString(R.string.new_friend_item_title))) {
                    ContactsFragment.this.startActivity(NewContactActivity.h.b(ContactsFragment.this.getContext()));
                    return;
                }
                if (!TextUtils.isEmpty(contactInfoItem.getMobile()) && contactInfoItem.getMobile().equals(ContactsFragment.this.getResources().getString(R.string.group_chat_item_title))) {
                    Intent intent = new Intent(ContactsFragment.this.getActivity(), (Class<?>) GroupListActivity.class);
                    intent.putExtra("extra_save", true);
                    intent.putExtra("group_entry", false);
                    ContactsFragment.this.startActivity(intent);
                    return;
                }
                if (d65.b() && a65.e(contactInfoItem)) {
                    ServiceAccountDetailActivity.Y1(ContactsFragment.this.getContext(), contactInfoItem);
                    return;
                }
                ContactInfoItem contactInfoItemM792clone = contactInfoItem.m792clone();
                Intent intent2 = new Intent(ContactsFragment.this.getActivity(), (Class<?>) m66.c());
                if (contactInfoItem.getIsStranger()) {
                    intent2.putExtra("extra_can_chat", true);
                    contactInfoItemM792clone.setBizType(5000);
                    contactInfoItemM792clone.setSourceType(60);
                }
                intent2.putExtra("user_item_info", contactInfoItemM792clone);
                intent2.putExtra("from", 0);
                ContactsFragment.this.startActivity(intent2);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements AdapterView.OnItemLongClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements td3.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f13325a;
            public final /* synthetic */ ContactInfoItem b;

            public a(String str, ContactInfoItem contactInfoItem) {
                this.f13325a = str;
                this.b = contactInfoItem;
            }

            @Override // td3.f
            public void a(td3 td3Var, int i, CharSequence charSequence) {
                if (i != 0 || TextUtils.isEmpty(this.f13325a)) {
                    return;
                }
                Intent intent = new Intent(ContactsFragment.this.getActivity(), io0.h());
                intent.putExtra("fuid", this.f13325a);
                intent.putExtra("nick_name", this.b.getNickName());
                intent.putExtra("remark_name", this.b.getRemarkName());
                intent.putExtra("register_mobile_number", this.b.getMobile());
                intent.putExtra("remark_tel", this.b.getRemarkTel());
                intent.putExtra("description", this.b.getDescription());
                intent.putExtra("is_friend", true);
                ContactsFragment.this.startActivity(intent);
            }
        }

        public b() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            String uid;
            ContactInfoItem contactInfoItem = (ContactInfoItem) adapterView.getItemAtPosition(i);
            if (a65.e(contactInfoItem) || contactInfoItem == null || (uid = contactInfoItem.getUid()) == null || uid.equals(AccountUtils.p(ContactsFragment.this.getActivity()))) {
                return false;
            }
            new td3.c(ContactsFragment.this.getActivity()).c(new String[]{ContactsFragment.this.getResources().getString(R.string.menu_dialog_item_remark)}).d(new a(uid, contactInfoItem)).a().b();
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ip3.c("pagemy_frd_mayknow");
            ContactsFragment.this.t0();
            EnhanceRecommendActivity.H1(ContactsFragment.this.getActivity());
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "21x", "1", null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ip3.c("pagemy_frd_newfriend");
            LogUtil.onClickEvent("21", null, null);
            ContactsFragment.this.startActivityForResult(NewContactActivity.h.b(ContactsFragment.this.getContext()), 2);
            LogUtil.uploadInfoImmediate("29", "1", null, null);
            zn6.d("lx_client_frd_29", null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ip3.c("pagemy_frd_group");
            Intent intent = new Intent(ContactsFragment.this.getActivity(), (Class<?>) GroupListActivity.class);
            intent.putExtra("extra_save", true);
            intent.putExtra("group_entry", false);
            ContactsFragment.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ip3.c("pagemy_frd_contact");
            if (!AppContext.getContext().getTrayPreferences().a(k86.n(), false)) {
                AppContext.getContext().getTrayPreferences().i(k86.n(), true);
            }
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "28", "1", ContactsFragment.this.G, null);
            ContactsFragment.this.k0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            HashMap map = new HashMap();
            if (ContactsFragment.this.H != null) {
                map.put("fuid", ContactsFragment.this.H.getUid());
            } else {
                map.put("fuid", "");
            }
            ip3.b("pagemy_frd_contactre", "click", map);
            if (!AppContext.getContext().getTrayPreferences().a(k86.n(), false)) {
                AppContext.getContext().getTrayPreferences().i(k86.n(), true);
            }
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "28", "1", ContactsFragment.this.G, null);
            ContactsFragment.this.k0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContactsFragment.this.g.e(ContactsFragment.this.C);
            ContactsFragment.this.g.notifyDataSetChanged();
            ContactsFragment contactsFragment = ContactsFragment.this;
            contactsFragment.r0(contactsFragment.g.getCount());
            if (ContactsFragment.this.H == null || !bo0.r().w(ContactsFragment.this.H.getUid())) {
                return;
            }
            ContactsFragment.this.w0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uk5 f13332a;

        public i(uk5 uk5Var) {
            this.f13332a = uk5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.f13332a.f21235a;
            if (i == 16) {
                LogUtil.i(ContactsFragment.M, "TYPE_DYNAMIC_CONFIG_CHANGE");
                return;
            }
            if (i == 34) {
                ContactsFragment.this.s0(tn0.i().s());
                ds0.a().b(CellUpdateEvent.produceEvent(2, null));
            } else {
                if (i != 35) {
                    return;
                }
                LogUtil.i(ContactsFragment.M, "TYPE_ENHANCED_ITEM_COUNT_CHANGE");
                ContactsFragment.this.u0(true);
            }
        }
    }

    @Override // com.zenmen.palmchat.widget.CharIndexView.a
    public void F0() {
        this.j.setVisibility(8);
    }

    @Override // com.zenmen.palmchat.widget.CharIndexView.a
    public void P0(char c2) {
        int iIntValue;
        this.j.setText(Character.toString(c2));
        if (this.F.get(Character.valueOf(c2)) == null || (iIntValue = this.F.get(Character.valueOf(c2)).intValue()) < 0) {
            return;
        }
        this.f.setSelection(iIntValue + 1);
    }

    public void k0() {
        Intent intentA = on0.a("upload_contact_from_main");
        r75.o(AppContext.getContext(), k86.a("sp_first_friend_recommend"), false);
        intentA.putExtra("SOURCE_TYPE", this.B);
        startActivityForResult(intentA, 1);
        if (this.G.equals("3")) {
            gu4.d(true);
        } else if (this.G.equals("1")) {
            gu4.d(false);
        } else {
            gu4.d(true);
        }
    }

    public final void l0(LayoutInflater layoutInflater) {
        ViewGroup viewGroup = (ViewGroup) layoutInflater.inflate(R.layout.layout_contact_list_footer, (ViewGroup) null);
        this.L = viewGroup;
        this.f.addFooterView(viewGroup);
    }

    public final void m0(List<ContactInfoItem> list) {
        this.F.clear();
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            char cA = eo0.a(list.get(i3).getIndexPinyin(true).charAt(0));
            if (this.F.get(Character.valueOf(cA)) == null) {
                this.F.put(Character.valueOf(cA), Integer.valueOf(i3));
            }
        }
        char c2 = 0;
        while (true) {
            char[] cArr = CharIndexView.charArray;
            if (i2 >= cArr.length) {
                return;
            }
            char c3 = cArr[i2];
            if (this.F.get(Character.valueOf(c3)) != null) {
                c2 = c3;
            } else if (c2 != 0) {
                this.F.put(Character.valueOf(c3), this.F.get(Character.valueOf(c2)));
            }
            i2++;
        }
    }

    public final void n0(LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_new_contact_list_header_e, (ViewGroup) null);
        this.k = viewInflate;
        this.r = (TextView) viewInflate.findViewById(R.id.notification_red_dot);
        this.u = (TextView) this.k.findViewById(R.id.confirm_button);
        this.l = this.k.findViewById(R.id.rl_phone_contact);
        RelativeLayout relativeLayout = (RelativeLayout) this.k.findViewById(R.id.enhanced_contact_area);
        this.m = relativeLayout;
        relativeLayout.setVisibility(8);
        this.n = (TextView) this.k.findViewById(R.id.enhanced_contact_new);
        this.o = (LinearLayout) this.k.findViewById(R.id.ll_online);
        this.p = (TextView) this.k.findViewById(R.id.tv_online_text);
        SocialPortraitView socialPortraitView = (SocialPortraitView) this.k.findViewById(R.id.iv_online);
        this.q = socialPortraitView;
        socialPortraitView.changeShapeType(3);
        this.m.setOnClickListener(new c());
        u0(false);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.k.findViewById(R.id.new_contact_apply_area);
        this.s = relativeLayout2;
        relativeLayout2.setVisibility(8);
        RelativeLayout relativeLayout3 = (RelativeLayout) this.k.findViewById(R.id.group_chat_area);
        this.t = relativeLayout3;
        relativeLayout3.setVisibility(yb0.a().b() ? 0 : 8);
        this.s.setOnClickListener(new d());
        this.t.setOnClickListener(new e());
        this.l.setOnClickListener(new f());
        this.v = this.k.findViewById(R.id.recommendation_item);
        this.w = (TextView) this.k.findViewById(R.id.recommendation_name);
        this.x = (TextView) this.k.findViewById(R.id.phone_describe);
        SocialPortraitView socialPortraitView2 = (SocialPortraitView) this.k.findViewById(R.id.portrait_imageview);
        this.y = socialPortraitView2;
        socialPortraitView2.changeShapeType(3);
        this.y.setBorderColor(getResources().getColor(R.color.portrait_line));
        this.v.setOnClickListener(new g());
        this.f.addHeaderView(this.k);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Intent intent;
        super.onActivityCreated(bundle);
        this.g.e(this.C);
        this.g.c(tn0.i().f());
        m0(this.C);
        this.g.notifyDataSetChanged();
        r0(this.g.getCount());
        bo0.r().i().j(this);
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || !intent.getBooleanExtra("from_daemon", false)) {
            return;
        }
        k0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            if (gu4.b()) {
                w0();
                return;
            } else {
                p0();
                return;
            }
        }
        if (i2 == 2) {
            this.J = true;
            s0(0);
        }
    }

    @qm5
    public void onContactChanged(fn0 fn0Var) {
        CopyOnWriteArrayList<ContactInfoItem> copyOnWriteArrayListP = bo0.r().p();
        this.C = copyOnWriteArrayListP;
        m0(copyOnWriteArrayListP);
        this.h.post(new h());
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.C = bo0.r().p();
        int[] iArr = new int[CharIndexView.charArray.length];
        this.E = iArr;
        Arrays.fill(iArr, -1);
        this.F = new HashMap<>();
        View viewInflate = layoutInflater.inflate(R.layout.layout_activity_contacts, (ViewGroup) null, false);
        this.h = viewInflate;
        CharIndexView charIndexView = (CharIndexView) viewInflate.findViewById(R.id.index_view);
        this.i = charIndexView;
        charIndexView.setOnCharacterTouchedListener(this);
        this.j = (TextView) this.h.findViewById(R.id.char_indicator);
        this.f = (ListView) this.h.findViewById(R.id.contacts_list);
        l0(layoutInflater);
        n0(layoutInflater);
        this.f.setOnItemClickListener(new a());
        this.f.setOnItemLongClickListener(new b());
        eo0 eo0Var = new eo0(getActivity());
        this.g = eo0Var;
        this.f.setAdapter((ListAdapter) eo0Var);
        ip3.d("pagemy_frd");
        return this.h;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        f7 f7Var = this.z;
        if (f7Var != null) {
            f7Var.onCancel();
        }
        ih ihVar = this.A;
        if (ihVar != null) {
            ihVar.onCancel();
        }
        bo0.r().i().l(this);
        super.onDestroy();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ch.s().r().l(this);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ch.s().r().j(this);
        if (this.J) {
            return;
        }
        s0(tn0.i().s());
    }

    @qm5
    public void onStatusChanged(uk5 uk5Var) {
        this.h.post(new i(uk5Var));
    }

    public final void p0() {
        this.H = null;
        this.v.setVisibility(8);
    }

    @Override // com.zenmen.palmchat.widget.CharIndexView.a
    public void r() {
        this.j.setVisibility(0);
    }

    public final void r0(int i2) {
        Iterator<ContactInfoItem> it = bo0.r().q().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (!it.next().getIsStranger()) {
                i3++;
            }
        }
        int i4 = i2 - i3;
        ViewGroup viewGroup = this.L;
        if (viewGroup != null) {
            if (i4 <= 0) {
                viewGroup.setVisibility(8);
                return;
            }
            if (getActivity() != null) {
                ((TextView) this.L.getChildAt(1)).setText(getActivity().getString(R.string.text_contact_count, i4 + ""));
            }
            this.L.setVisibility(0);
        }
    }

    public final void s0(int i2) {
        if (i2 <= 0) {
            this.r.setVisibility(8);
        } else {
            this.r.setVisibility(0);
            this.r.setText(MainTabsActivity.w2(getContext(), i2));
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            gu4.d(true);
            w0();
        }
    }

    public final void t0() {
        this.K = true;
        this.n.setVisibility(8);
        this.o.setVisibility(8);
    }

    public final void u0(boolean z) {
        if (this.n != null) {
            int iR = tn0.i().r();
            if (iR > 0) {
                this.n.setVisibility(0);
                this.n.setText(MainTabsActivity.w2(getContext(), iR));
                this.o.setVisibility(0);
                String strG = tn0.i().g();
                String strH = tn0.i().h();
                if (TextUtils.isEmpty(strH)) {
                    strH = "";
                } else if (strH.length() >= 3) {
                    strH = strH.substring(0, 2) + "...";
                }
                if (!TextUtils.isEmpty(strG)) {
                    gr2.j().h(strG, this.q, bq6.s());
                }
                this.p.setText(strH + "上线了");
            } else {
                this.o.setVisibility(8);
                int iF = SPUtil.f14322a.f(SPUtil.SCENE.CONTACT, k86.a("key_contact_enhanced_contact_new_tag"), 0);
                if (iF > 0) {
                    this.n.setVisibility(0);
                    this.n.setText(MainTabsActivity.w2(getContext(), iF));
                } else {
                    this.n.setVisibility(8);
                }
            }
            if (z) {
                ds0.a().b(CellUpdateEvent.produceEvent(3, null));
            }
        }
    }

    public final void w0() {
        p0();
    }
}
