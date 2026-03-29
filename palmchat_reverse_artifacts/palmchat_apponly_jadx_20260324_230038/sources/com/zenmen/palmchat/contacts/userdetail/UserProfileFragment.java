package com.zenmen.palmchat.contacts.userdetail;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.zenmen.listui.duration.BaseDurationFragment;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.bean.ContactLoveBean;
import com.zenmen.palmchat.contacts.userdetail.polish.PolishView;
import defpackage.ds0;
import defpackage.eb1;
import defpackage.gs2;
import defpackage.ik4;
import defpackage.ip2;
import defpackage.js2;
import defpackage.l50;
import defpackage.me1;
import defpackage.nn4;
import defpackage.v4;
import defpackage.zn6;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@SuppressLint({"LongLogTag"})
public class UserProfileFragment extends BaseDurationFragment implements ip2 {
    public View A;
    public TextView B;
    public TextView C;
    public View E;
    public TextView F;
    public TextView G;
    public ContactInfoItem H;
    public String I;
    public boolean J;
    public ViewGroup L;
    public com.zenmen.palmchat.contacts.userdetail.b M;
    public View i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public View o;
    public View p;
    public View q;
    public View r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public View y;
    public TextView z;
    public boolean K = false;
    public HashMap<String, Object> N = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserProfileFragment.this.Y(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            js2.g();
            UserProfileFragment.this.Y(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserProfileFragment.this.Y(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements gs2.b {
        public d() {
        }

        @Override // gs2.b
        public void a() {
            UserProfileFragment.this.p0(false);
        }
    }

    public static boolean c0(ContactInfoItem contactInfoItem) {
        if (contactInfoItem == null || contactInfoItem.getExt() == null) {
            return true;
        }
        if (!TextUtils.isEmpty(contactInfoItem.getOccupationForShow()) || !TextUtils.isEmpty(contactInfoItem.getIncomeForShow())) {
            return false;
        }
        String[] intentionForShow = contactInfoItem.getIntentionForShow();
        return intentionForShow == null || intentionForShow.length <= 0;
    }

    public static boolean j0(ContactInfoItem contactInfoItem) {
        return contactInfoItem == null || TextUtils.isEmpty(contactInfoItem.getOccupationForShow()) || TextUtils.isEmpty(contactInfoItem.getIncomeForShow());
    }

    public static boolean k0(ContactInfoItem contactInfoItem) {
        String[] intentionForShow;
        return contactInfoItem == null || (intentionForShow = contactInfoItem.getIntentionForShow()) == null || intentionForShow.length <= 0;
    }

    public static boolean l0(ContactInfoItem contactInfoItem) {
        return j0(contactInfoItem) || k0(contactInfoItem);
    }

    public final void Y(boolean z) {
        if (l50.a()) {
            return;
        }
        if (!this.J) {
            gs2.g(0, getContext(), this.H, new d());
            h0();
            return;
        }
        getActivity().startActivity(nn4.a(getContext(), 4));
        if (z) {
            e0();
        }
    }

    public boolean Z(String str) {
        return gs2.e(str);
    }

    @Override // defpackage.ip2
    public void c(ContactInfoItem contactInfoItem, HashMap<String, Object> map) {
        this.N = map;
        r0(contactInfoItem, false);
    }

    public void e0() {
        Map map = (Map) this.N.clone();
        boolean z = (this.H.needHideProfile() || j0(this.H)) ? false : true;
        boolean z2 = (this.H.needHideProfile() || k0(this.H)) ? false : true;
        if (z && z2) {
            return;
        }
        if (z) {
            map.put("infor", 2);
        } else if (z2) {
            map.put("infor", 1);
        } else {
            map.put("infor", 0);
        }
        zn6.j("newpageprofil_gageclick", "click", map);
    }

    public void h0() {
        Map map = (Map) this.N.clone();
        boolean z = false;
        boolean z2 = (this.H.needHideProfile() || j0(this.H)) ? false : true;
        if (!this.H.needHideProfile() && !k0(this.H)) {
            z = true;
        }
        if (z2 && z) {
            return;
        }
        if (z2) {
            map.put("type", 3);
        } else if (z) {
            map.put("type", 2);
        } else {
            map.put("type", 1);
        }
        zn6.j("Inviteprofile_inviteclick", "click", map);
    }

    public final void m0() {
        if (this.H.needHideProfile()) {
            this.y.setVisibility(8);
            return;
        }
        String hobby = this.H.getHobby();
        if (!TextUtils.isEmpty(hobby)) {
            this.y.setVisibility(0);
            this.z.setVisibility(0);
            this.A.setVisibility(8);
            this.z.setText(hobby);
            return;
        }
        this.y.setVisibility(0);
        this.z.setVisibility(8);
        this.A.setVisibility(0);
        if (!this.J) {
            this.y.setVisibility(8);
            return;
        }
        this.B.setText("让喜欢你的人更懂你，");
        this.C.setText("去完善资料");
        this.C.setEnabled(true);
        this.C.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.user_detail_profile_complete_arrow, 0);
    }

    public final void n0() {
        if (this.H.needHideProfile()) {
            this.o.setVisibility(8);
            return;
        }
        List<ContactLoveBean> loveView = this.H.getLoveView();
        if (loveView == null || loveView.isEmpty()) {
            this.o.setVisibility(8);
            return;
        }
        this.o.setVisibility(0);
        if (loveView.size() >= 1) {
            this.p.setVisibility(0);
            this.s.setText("#" + loveView.get(0).getRecentQuestionTitle());
            this.t.setText(new SpannableStringBuilder("“" + loveView.get(0).getRecentQuestionAnswer() + "”"));
        } else {
            this.p.setVisibility(8);
        }
        if (loveView.size() >= 2) {
            this.q.setVisibility(0);
            this.u.setText("#" + loveView.get(1).getRecentQuestionTitle());
            this.v.setText(new SpannableStringBuilder("“" + loveView.get(1).getRecentQuestionAnswer() + "”"));
        } else {
            this.q.setVisibility(8);
        }
        if (loveView.size() < 3) {
            this.r.setVisibility(8);
            return;
        }
        this.r.setVisibility(0);
        this.w.setText("#" + loveView.get(2).getRecentQuestionTitle());
        this.x.setText(new SpannableStringBuilder("“" + loveView.get(2).getRecentQuestionAnswer() + "”"));
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment
    public int o() {
        return 13;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ds0.a().c(this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            ContactInfoItem contactInfoItem = (ContactInfoItem) arguments.getParcelable("user_item_info");
            this.H = contactInfoItem;
            if (contactInfoItem != null) {
                String uid = contactInfoItem.getUid();
                this.I = uid;
                this.J = uid != null && uid.equals(v4.e(com.zenmen.palmchat.c.b()));
            }
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_fragment_user_detail_profile, (ViewGroup) null, false);
        this.i = viewInflate;
        this.l = (TextView) viewInflate.findViewById(R.id.intention_1);
        this.m = (TextView) this.i.findViewById(R.id.intention_2);
        this.n = (TextView) this.i.findViewById(R.id.intention_3);
        this.j = (TextView) this.i.findViewById(R.id.occupation);
        this.k = (TextView) this.i.findViewById(R.id.income);
        this.L = (ViewGroup) this.i.findViewById(R.id.item_wrappers);
        this.M = new com.zenmen.palmchat.contacts.userdetail.b(getActivity(), this.i.findViewById(R.id.gift), true, this.J);
        this.o = this.i.findViewById(R.id.love);
        this.p = this.i.findViewById(R.id.love_1);
        this.q = this.i.findViewById(R.id.love_2);
        this.r = this.i.findViewById(R.id.love_3);
        this.s = (TextView) this.i.findViewById(R.id.love_title_1);
        this.t = (TextView) this.i.findViewById(R.id.love_answer_1);
        this.u = (TextView) this.i.findViewById(R.id.love_title_2);
        this.v = (TextView) this.i.findViewById(R.id.love_answer_2);
        this.w = (TextView) this.i.findViewById(R.id.love_title_3);
        this.x = (TextView) this.i.findViewById(R.id.love_answer_3);
        this.y = this.i.findViewById(R.id.hobby);
        this.z = (TextView) this.i.findViewById(R.id.hobby_text);
        this.A = this.i.findViewById(R.id.hobby_complete);
        this.B = (TextView) this.i.findViewById(R.id.hobby_complete_title);
        this.C = (TextView) this.i.findViewById(R.id.hobby_complete_action);
        this.E = this.i.findViewById(R.id.profile_complete_task);
        this.F = (TextView) this.i.findViewById(R.id.profile_part1);
        this.G = (TextView) this.i.findViewById(R.id.profile_part2);
        this.i.findViewById(R.id.profile_complete_action).setOnClickListener(new a());
        this.G.setOnClickListener(new b());
        this.C.setOnClickListener(new c());
        if (this.J) {
            new ik4((PolishView) this.i.findViewById(R.id.polishView)).c();
        }
        return this.i;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ds0.a().d(this);
        com.zenmen.palmchat.contacts.userdetail.b bVar = this.M;
        if (bVar != null) {
            bVar.l();
        }
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.zenmen.palmchat.contacts.userdetail.b bVar = this.M;
        if (bVar != null) {
            bVar.m();
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        r0(this.H, true);
    }

    public final void p0(boolean z) {
        if (!l0(this.H)) {
            this.i.findViewById(R.id.profile_complete_wrapper).setVisibility(8);
            return;
        }
        this.i.findViewById(R.id.profile_complete_wrapper).setVisibility(0);
        if (!this.J) {
            this.i.findViewById(R.id.profile_complete).setVisibility(0);
            this.E.setVisibility(8);
            if (Z(this.H.getUid())) {
                ((TextView) this.i.findViewById(R.id.profile_complete_title)).setText("已邀请填写资料，等待更新中...");
                ((TextView) this.i.findViewById(R.id.profile_complete_action)).setVisibility(8);
                ((TextView) this.i.findViewById(R.id.profile_complete_action)).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                ((TextView) this.i.findViewById(R.id.profile_complete_title)).setText("想要更了解Ta，");
                ((TextView) this.i.findViewById(R.id.profile_complete_action)).setText("邀请Ta完善资料");
                ((TextView) this.i.findViewById(R.id.profile_complete_action)).setVisibility(0);
                ((TextView) this.i.findViewById(R.id.profile_complete_action)).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.user_detail_profile_complete_arrow, 0);
            }
        } else if (js2.m()) {
            if (z) {
                js2.q(getActivity());
            }
            this.i.findViewById(R.id.profile_complete).setVisibility(8);
            if (this.E.getVisibility() != 0) {
                js2.h();
            }
            this.E.setVisibility(0);
            this.F.setText(js2.k().f18491a);
            this.G.setText(js2.k().b);
        } else {
            this.i.findViewById(R.id.profile_complete).setVisibility(0);
            this.E.setVisibility(8);
            ((TextView) this.i.findViewById(R.id.profile_complete_title)).setText("让喜欢你的人更懂你，");
            ((TextView) this.i.findViewById(R.id.profile_complete_action)).setText("去完善资料");
            ((TextView) this.i.findViewById(R.id.profile_complete_action)).setVisibility(0);
            ((TextView) this.i.findViewById(R.id.profile_complete_action)).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.user_detail_profile_complete_arrow, 0);
        }
        if (c0(this.H)) {
            this.i.findViewById(R.id.profile_complete_wrapper).setPadding(0, me1.b(getContext(), 20), 0, me1.b(getContext(), 10));
        } else {
            this.i.findViewById(R.id.profile_complete_wrapper).setPadding(0, me1.b(getContext(), 10), 0, 0);
        }
    }

    public void r0(ContactInfoItem contactInfoItem, boolean z) {
        this.H = contactInfoItem;
        if (this.i == null) {
            return;
        }
        s0(z);
        if (!z) {
            if (TextUtils.equals(this.H.getUid(), v4.e(getContext())) || this.H.needHideProfile()) {
                if (this.K) {
                    this.K = false;
                    eb1.g();
                }
            } else if (!this.K) {
                this.K = true;
                eb1.b(this.L, false);
                eb1.k(getActivity(), 1);
                eb1.j(getActivity());
            }
        }
        ContactInfoItem contactInfoItem2 = this.H;
        if (contactInfoItem2 != null) {
            if (!z || this.J) {
                if (contactInfoItem2.needHideProfile()) {
                    this.M.j();
                } else {
                    this.M.o(this.H);
                }
            }
        }
    }

    public final void s0(boolean z) {
        ContactInfoItem contactInfoItem = this.H;
        if (contactInfoItem == null) {
            return;
        }
        if (TextUtils.isEmpty(contactInfoItem.getOccupationForShow())) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
            this.j.setText(this.H.getOccupationForShow());
        }
        if (TextUtils.isEmpty(this.H.getIncomeForShow())) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
            this.k.setText(this.H.getIncomeForShow());
        }
        String[] intentionForShow = this.H.getIntentionForShow();
        if (intentionForShow == null || intentionForShow.length == 0) {
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.n.setVisibility(8);
        } else if (intentionForShow.length == 1) {
            this.l.setVisibility(0);
            this.l.setText(intentionForShow[0]);
            this.m.setVisibility(8);
            this.n.setVisibility(8);
        } else if (intentionForShow.length == 2) {
            this.l.setVisibility(0);
            this.l.setText(intentionForShow[0]);
            this.m.setVisibility(0);
            this.m.setText(intentionForShow[1]);
            this.n.setVisibility(8);
        } else {
            this.l.setVisibility(0);
            this.l.setText(intentionForShow[0]);
            this.m.setVisibility(0);
            this.m.setText(intentionForShow[1]);
            this.n.setVisibility(0);
            this.n.setText(intentionForShow[2]);
        }
        p0(!z);
        n0();
        m0();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
    }
}
