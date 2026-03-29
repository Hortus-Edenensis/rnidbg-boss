package defpackage;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.chatprofile.bean.ChatProfileInfo;
import com.zenmen.palmchat.chat.chatprofile.bean.LifeFeed;
import com.zenmen.palmchat.chat.widget.ChatEnergyView;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.SimpleFeedInfoCellView;
import defpackage.c40;
import defpackage.gs2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class w20 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f21586a;
    public ProgressBar b;
    public ViewGroup c;
    public ViewGroup d;
    public ViewGroup e;
    public ViewGroup f;
    public ViewGroup g;
    public TextView h;
    public TextView i;
    public TextView k;
    public TextView l;
    public TextView m;
    public ChatEnergyView n;
    public ChatterActivity p;
    public ContactInfoItem q;
    public ArrayList<TextView> j = new ArrayList<>();
    public ArrayList<SimpleFeedInfoCellView> o = new ArrayList<>();
    public c40.b r = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (w20.this.p == null || w20.this.p.isFinishing() || w20.this.p.j1) {
                return;
            }
            w20.this.p.G4();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements gs2.b {
        public c() {
        }

        @Override // gs2.b
        public void a() {
            w20 w20Var = w20.this;
            w20Var.m(w20Var.q, null);
        }
    }

    public w20(ChatterActivity chatterActivity) {
        this.p = chatterActivity;
        View viewInflate = chatterActivity.getLayoutInflater().inflate(R.layout.list_headerview_chat_header_new, (ViewGroup) null, false);
        this.f21586a = viewInflate;
        this.b = (ProgressBar) viewInflate.findViewById(R.id.progress_loading);
        ViewGroup viewGroup = (ViewGroup) this.f21586a.findViewById(R.id.user_detail);
        this.c = viewGroup;
        viewGroup.setOnClickListener(this);
        this.d = (ViewGroup) this.f21586a.findViewById(R.id.vg_profile);
        this.e = (ViewGroup) this.f21586a.findViewById(R.id.vg_prefer);
        this.f = (ViewGroup) this.f21586a.findViewById(R.id.vg_state);
        this.g = (ViewGroup) this.f21586a.findViewById(R.id.vg_feed);
        this.h = (TextView) this.f21586a.findViewById(R.id.tv_profile);
        TextView textView = (TextView) this.f21586a.findViewById(R.id.profile_complete_action);
        this.i = textView;
        textView.setOnClickListener(this);
        this.j.add((TextView) this.f21586a.findViewById(R.id.intention_1));
        this.j.add((TextView) this.f21586a.findViewById(R.id.intention_2));
        this.j.add((TextView) this.f21586a.findViewById(R.id.intention_3));
        TextView textView2 = (TextView) this.f21586a.findViewById(R.id.prefer_complete_action);
        this.k = textView2;
        textView2.setOnClickListener(this);
        this.l = (TextView) this.f21586a.findViewById(R.id.tv_state1);
        this.m = (TextView) this.f21586a.findViewById(R.id.tv_state2);
        this.n = (ChatEnergyView) this.f21586a.findViewById(R.id.chat_energy_view);
        this.o.add((SimpleFeedInfoCellView) this.f21586a.findViewById(R.id.feed1));
        this.o.add((SimpleFeedInfoCellView) this.f21586a.findViewById(R.id.feed2));
        this.o.add((SimpleFeedInfoCellView) this.f21586a.findViewById(R.id.feed3));
        this.o.add((SimpleFeedInfoCellView) this.f21586a.findViewById(R.id.feed4));
        this.o.add((SimpleFeedInfoCellView) this.f21586a.findViewById(R.id.feed5));
    }

    public final List<String> d(ContactInfoItem contactInfoItem, ChatProfileInfo chatProfileInfo) {
        String[] intentionForShow;
        if (chatProfileInfo == null) {
            if (contactInfoItem.getIntentionForShow() != null) {
                return Arrays.asList(contactInfoItem.getIntentionForShow());
            }
            return null;
        }
        if (chatProfileInfo.getContactExtBean() == null || (intentionForShow = chatProfileInfo.getContactExtBean().getIntentionForShow()) == null) {
            return null;
        }
        return Arrays.asList(intentionForShow);
    }

    public final String e(ContactInfoItem contactInfoItem, ChatProfileInfo chatProfileInfo) {
        String occupationForShow;
        String strValueOf;
        int i;
        if (chatProfileInfo != null) {
            strValueOf = String.valueOf(chatProfileInfo.age);
            String str = chatProfileInfo.city;
            occupationForShow = chatProfileInfo.getContactExtBean() != null ? chatProfileInfo.getContactExtBean().getOccupationForShow() : null;
            str = str;
        } else {
            String age = contactInfoItem.getAge();
            occupationForShow = contactInfoItem.getOccupationForShow();
            strValueOf = age;
        }
        try {
            i = Integer.parseInt(strValueOf);
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        String str2 = "";
        if (i > 0) {
            str2 = "" + strValueOf + "岁";
        }
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2 + " · ";
            }
            str2 = str2 + str;
        }
        if (!TextUtils.isEmpty(occupationForShow)) {
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2 + " · ";
            }
            str2 = str2 + occupationForShow;
        }
        if (TextUtils.isEmpty(str2)) {
            return str2;
        }
        return str2 + "  ";
    }

    public final String f(boolean z, ChatProfileInfo chatProfileInfo) {
        String str;
        String str2;
        if (z || chatProfileInfo.onlineStatusDesc == null) {
            str = "";
        } else {
            str = " · " + chatProfileInfo.onlineStatusDesc;
        }
        long j = chatProfileInfo.distance;
        if (j >= 0) {
            double d = j / 1000.0d;
            if (d < 0.01d) {
                d = 0.01d;
            }
            if (d > 1.0d) {
                str2 = Math.round(d) + "km";
            } else {
                str2 = String.format("%.2fkm", Double.valueOf(d));
            }
        } else {
            str2 = null;
        }
        String str3 = chatProfileInfo.cityName;
        if (str3 != null && str2 != null) {
            return str3 + "(" + str2 + ")" + str;
        }
        if (str3 == null && str2 != null) {
            return str2 + str;
        }
        if (str3 == null || str2 != null) {
            return null;
        }
        return str3 + str;
    }

    public View g() {
        return this.f21586a;
    }

    public void h(ContactInfoItem contactInfoItem, boolean z) {
        this.b.setVisibility(8);
        b05.d("hideProgress1===>" + z);
        if (!z) {
            this.c.setVisibility(8);
        } else if (this.c.getVisibility() == 8) {
            b05.d("hideProgress2");
            this.c.setVisibility(0);
            k(m(contactInfoItem, null));
        }
    }

    public final boolean i(ContactInfoItem contactInfoItem, ChatProfileInfo chatProfileInfo) {
        String occupationForShow;
        String strValueOf;
        int i;
        if (chatProfileInfo != null) {
            strValueOf = String.valueOf(chatProfileInfo.age);
            occupationForShow = chatProfileInfo.getContactExtBean() != null ? chatProfileInfo.getContactExtBean().getOccupationForShow() : null;
        } else {
            String age = contactInfoItem.getAge();
            occupationForShow = contactInfoItem.getOccupationForShow();
            strValueOf = age;
        }
        try {
            i = Integer.parseInt(strValueOf);
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        return i > 0 && !TextUtils.isEmpty(occupationForShow);
    }

    public final void j(int i) {
        HashMap map = new HashMap();
        map.put("invite_type", String.valueOf(i));
        ContactInfoItem contactInfoItem = this.q;
        map.put("targetUid", contactInfoItem != null ? contactInfoItem.getUid() : "");
        ContactInfoItem contactInfoItem2 = this.q;
        map.put("targetExid", contactInfoItem2 != null ? contactInfoItem2.getExid() : "");
        zn6.i("privatechat_inviteclick", map);
    }

    public final void k(Pair<Boolean, Boolean> pair) {
        HashMap map = new HashMap();
        map.put("guide_profile", ((Boolean) pair.first).booleanValue() ? "1" : "0");
        map.put("guide_intention", ((Boolean) pair.second).booleanValue() ? "1" : "0");
        map.put("guide_intention", ((Boolean) pair.second).booleanValue() ? "1" : "0");
        ContactInfoItem contactInfoItem = this.q;
        map.put("targetUid", contactInfoItem != null ? contactInfoItem.getUid() : "");
        ContactInfoItem contactInfoItem2 = this.q;
        map.put("targetExid", contactInfoItem2 != null ? contactInfoItem2.getExid() : "");
        zn6.i("privatechat_inviteshow", map);
    }

    public void l() {
        this.b.setVisibility(0);
        this.c.setVisibility(8);
    }

    public final Pair<Boolean, Boolean> m(ContactInfoItem contactInfoItem, ChatProfileInfo chatProfileInfo) {
        List<LifeFeed> list;
        ContactInfoItem contactInfoItem2;
        if (contactInfoItem != null) {
            this.q = contactInfoItem;
        }
        boolean z = false;
        ChatProfileInfo chatProfileInfoC = chatProfileInfo != null ? chatProfileInfo : c40.b().c(contactInfoItem.getUid(), this.r, false);
        LogUtil.i("ChatHeaderViewHelper", "updateView" + az2.c(contactInfoItem) + " profile=" + az2.c(chatProfileInfo));
        String strE = e(contactInfoItem, chatProfileInfoC);
        boolean zE = gs2.e(this.q.getUid());
        if (i(contactInfoItem, chatProfileInfoC)) {
            this.i.setVisibility(8);
            this.h.setVisibility(0);
            this.h.setText(strE);
        } else {
            this.i.setVisibility(0);
            if (zE) {
                if (TextUtils.isEmpty(strE)) {
                    this.h.setVisibility(8);
                } else {
                    this.h.setVisibility(0);
                    this.h.setText(strE);
                }
                this.i.setTextColor(this.p.getResources().getColor(R.color.Gc));
                this.i.setText("已邀请完善");
                this.i.setCompoundDrawables(null, null, null, null);
            } else {
                this.h.setVisibility(0);
                if (TextUtils.isEmpty(strE)) {
                    this.h.setText(" 想要更了解Ta，");
                } else {
                    this.h.setText(strE);
                }
            }
        }
        this.h.requestLayout();
        List<String> listD = d(contactInfoItem, chatProfileInfoC);
        if (listD == null || listD.size() <= 0) {
            this.k.setVisibility(0);
            if (zE) {
                this.k.setTextColor(this.p.getResources().getColor(R.color.Gc));
                this.k.setText("已邀请完善");
                this.k.setCompoundDrawables(null, null, null, null);
            }
            Iterator<TextView> it = this.j.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        } else {
            this.k.setVisibility(8);
            Iterator<TextView> it2 = this.j.iterator();
            while (it2.hasNext()) {
                it2.next().setVisibility(8);
            }
            for (int i = 0; i < listD.size() && i < 3; i++) {
                this.j.get(i).setVisibility(0);
                this.j.get(i).setText(listD.get(i));
            }
        }
        if (chatProfileInfoC != null) {
            boolean z2 = chatProfileInfoC.onlineStatusCode == 1;
            if (z2) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
            String strF = f(z2, chatProfileInfoC);
            if (TextUtils.isEmpty(strF)) {
                this.l.setVisibility(8);
            } else {
                this.l.setVisibility(0);
                this.l.setText(strF);
            }
            if (!TextUtils.isEmpty(strF) || z2) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            ChatEnergyView chatEnergyView = this.n;
            if (chatEnergyView != null && (contactInfoItem2 = this.q) != null) {
                chatEnergyView.setContactInfo(contactInfoItem2);
            }
        } else {
            this.f.setVisibility(8);
        }
        if (chatProfileInfoC == null || (list = chatProfileInfoC.lifeList) == null || list.size() <= 0) {
            this.g.setVisibility(8);
        } else {
            this.g.setVisibility(0);
            Iterator<SimpleFeedInfoCellView> it3 = this.o.iterator();
            while (it3.hasNext()) {
                it3.next().setVisibility(8);
            }
            for (int i2 = 0; i2 < chatProfileInfoC.lifeList.size(); i2++) {
                this.o.get(i2).setVisibility(0);
                this.o.get(i2).update(chatProfileInfoC.lifeList.get(i2).thumbUrl, chatProfileInfoC.lifeList.get(i2).feedType == 3);
            }
        }
        if (this.p != null) {
            this.f21586a.postDelayed(new b(), 500L);
        }
        Boolean boolValueOf = Boolean.valueOf(!TextUtils.isEmpty(strE));
        if (listD != null && listD.size() > 0) {
            z = true;
        }
        return new Pair<>(boolValueOf, Boolean.valueOf(z));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ContactInfoItem contactInfoItem;
        if (view != this.i && view != this.k) {
            if (view != this.c || (contactInfoItem = this.q) == null) {
                return;
            }
            this.p.p1.q0(contactInfoItem);
            return;
        }
        ContactInfoItem contactInfoItem2 = this.q;
        if (contactInfoItem2 != null && !gs2.e(contactInfoItem2.getUid())) {
            gs2.g(0, this.p, this.q, new c());
        }
        j(view == this.h ? 1 : 2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements c40.b {
        public a() {
        }

        @Override // c40.b
        public void a(ChatProfileInfo chatProfileInfo) {
            w20.this.m(null, chatProfileInfo);
        }

        @Override // c40.b
        public void onFail() {
        }
    }
}
