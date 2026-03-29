package com.zenmen.palmchat.giftkit;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.zenmen.giftkit.R$drawable;
import com.zenmen.giftkit.R$id;
import com.zenmen.giftkit.R$layout;
import com.zenmen.palmchat.chat.ChatGiftConfig;
import com.zenmen.palmchat.giftkit.a;
import com.zenmen.palmchat.giftkit.b;
import com.zenmen.palmchat.giftkit.bean.GiftPanelItem;
import com.zenmen.palmchat.giftkit.bean.PackPanelItem;
import com.zenmen.palmchat.giftkit.event.BalanceUpdateEvent;
import com.zenmen.palmchat.giftkit.event.GiftPanelUpdateEvent;
import com.zenmen.palmchat.giftkit.event.GiftSendResultEvent;
import com.zenmen.palmchat.giftkit.event.PackPanelUIUpdateEvent;
import com.zenmen.palmchat.giftkit.event.PackPanelUpdateEvent;
import com.zenmen.palmchat.giftkit.event.SetGiftTabEvent;
import com.zenmen.palmchat.giftkit.event.VoiceRoomMemberSelectEvent;
import com.zenmen.palmchat.giftkit.widgit.CustomBottomSheetDialog;
import com.zenmen.palmchat.giftkit.widgit.GiftListView;
import com.zenmen.palmchat.giftkit.widgit.GiftNumSelectorView;
import com.zenmen.palmchat.giftkit.widgit.GiftTabHeaderView;
import com.zenmen.palmchat.giftkit.widgit.PackListView;
import defpackage.b05;
import defpackage.ds0;
import defpackage.eh;
import defpackage.hx3;
import defpackage.jo6;
import defpackage.k86;
import defpackage.me1;
import defpackage.n30;
import defpackage.of2;
import defpackage.q05;
import defpackage.qm5;
import defpackage.qy5;
import defpackage.ub2;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class GiftPanel extends BottomSheetDialogFragment {
    public GiftPanelItem A;
    public PackPanelItem B;
    public int C;
    public h E;
    public boolean G;
    public int d;
    public int e;
    public View f;
    public GiftTabHeaderView g;
    public ViewPager h;
    public PagerAdapter i;
    public GiftNumSelectorView j;
    public GiftNumSelectorView k;
    public View l;
    public GiftListView m;
    public PackListView n;
    public i o;
    public ub2 p;
    public qy5 v;
    public String w;
    public int z;
    public int q = 1;
    public int r = 1;
    public String s = null;
    public String t = null;
    public List<String> u = null;
    public int x = -1;
    public String y = "";
    public g F = null;
    public int H = 0;
    public boolean I = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends CustomBottomSheetDialog {
        public a(Context context, int i, g gVar) {
            super(context, i, gVar);
        }

        @Override // com.zenmen.palmchat.giftkit.widgit.CustomBottomSheetDialog
        public View m() {
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
            GiftPanel giftPanel = GiftPanel.this;
            giftPanel.f = layoutInflaterFrom.inflate(giftPanel.e == 0 ? R$layout.layout_gift_panel_light : R$layout.layout_gift_panel_dark, (ViewGroup) null);
            GiftPanel.this.R0();
            return GiftPanel.this.f;
        }

        @Override // com.zenmen.palmchat.giftkit.widgit.CustomBottomSheetDialog
        public View n() {
            if (GiftPanel.this.o != null) {
                return GiftPanel.this.o.getView();
            }
            return null;
        }

        @Override // com.zenmen.palmchat.giftkit.widgit.CustomBottomSheetDialog
        public int o() {
            if (GiftPanel.this.o != null) {
                return GiftPanel.this.o.getHeight();
            }
            return 0;
        }

        @Override // com.zenmen.palmchat.giftkit.widgit.CustomBottomSheetDialog
        public boolean p() {
            if (GiftPanel.this.o != null) {
                return GiftPanel.this.o.a();
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements GiftTabHeaderView.b {
        public b() {
        }

        @Override // com.zenmen.palmchat.giftkit.widgit.GiftTabHeaderView.b
        public void a() {
            GiftPanel.this.f1(-1L, false, null);
            GiftPanel.this.p.j();
        }

        @Override // com.zenmen.palmchat.giftkit.widgit.GiftTabHeaderView.b
        public void onItemSelected(int i) {
            GiftPanel.this.h.setCurrentItem(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends PagerAdapter {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements GiftListView.e {
            public a() {
            }

            @Override // com.zenmen.palmchat.giftkit.widgit.GiftListView.e
            public void a(int i) {
                GiftPanel.this.g1(false, true, i);
            }

            @Override // com.zenmen.palmchat.giftkit.widgit.GiftListView.e
            public void b(GiftPanelItem giftPanelItem) {
                if (giftPanelItem != null) {
                    GiftPanel.this.p.e(0, giftPanelItem.itemId);
                    GiftPanel.this.Q0(giftPanelItem.activityUrl);
                }
            }

            @Override // com.zenmen.palmchat.giftkit.widgit.GiftListView.e
            public void c(GiftPanelItem giftPanelItem) {
                if (GiftPanel.this.A != null && giftPanelItem != null && GiftPanel.this.A.itemId != giftPanelItem.itemId) {
                    GiftPanel.this.j.setNumber(GiftPanel.this.q = 1);
                }
                if (giftPanelItem != null) {
                    GiftPanel.this.p.e(0, giftPanelItem.itemId);
                }
                GiftPanel.this.A = giftPanelItem;
            }

            @Override // com.zenmen.palmchat.giftkit.widgit.GiftListView.e
            public void onPageSelected(int i) {
                GiftPanel.this.p.i(0, i);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements PackListView.d {
            public b() {
            }

            @Override // com.zenmen.palmchat.giftkit.widgit.PackListView.d
            public void a(PackPanelItem packPanelItem) {
                if (GiftPanel.this.B != null && packPanelItem != null && GiftPanel.this.B.itemId != packPanelItem.itemId) {
                    GiftPanel.this.k.setNumber(GiftPanel.this.r = 1);
                }
                if (packPanelItem != null && (GiftPanel.this.B == null || GiftPanel.this.B.itemId != packPanelItem.itemId)) {
                    GiftPanel.this.p.e(1, packPanelItem.itemId);
                }
                GiftPanel.this.B = packPanelItem;
            }

            @Override // com.zenmen.palmchat.giftkit.widgit.PackListView.d
            public void b(boolean z) {
                GiftPanel.this.g.updatePackStatus(z);
            }

            @Override // com.zenmen.palmchat.giftkit.widgit.PackListView.d
            public void onPageSelected(int i) {
                GiftPanel.this.p.i(1, i);
            }
        }

        public c() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            if (i != 0) {
                GiftPanel.this.n = new PackListView(GiftPanel.this.getContext(), GiftPanel.this.e, GiftPanel.this.d, null, new b());
                GiftPanel.this.n.setEventDataHelper(GiftPanel.this.p);
                viewGroup.addView(GiftPanel.this.n);
                return GiftPanel.this.n;
            }
            GiftPanel.this.m = new GiftListView(GiftPanel.this.getContext(), GiftPanel.this.e, GiftPanel.this.d, GiftPanel.this.A, new a());
            GiftPanel.this.m.setEventDataHelper(GiftPanel.this.p);
            viewGroup.addView(GiftPanel.this.m);
            GiftPanel.this.p.k(0, GiftPanel.this.m.isShowError(), GiftPanel.this.m.getActivityId());
            return GiftPanel.this.m;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return view == obj;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements a.InterfaceC1055a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftSendResultEvent f14066a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements b.m {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f14067a;

            /* JADX INFO: renamed from: com.zenmen.palmchat.giftkit.GiftPanel$e$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1054a implements b.m {
                public C1054a() {
                }

                @Override // com.zenmen.palmchat.giftkit.b.m
                public void call() {
                    e.this.f14066a.sendGiftInfo.reSendGift();
                }
            }

            public a(boolean z) {
                this.f14067a = z;
            }

            @Override // com.zenmen.palmchat.giftkit.b.m
            public void call() {
                GiftSendResultEvent giftSendResultEvent;
                SendGiftInfo sendGiftInfo;
                if (!this.f14067a || !GiftPanel.this.G || !com.zenmen.palmchat.giftkit.a.a().d() || (giftSendResultEvent = e.this.f14066a) == null || (sendGiftInfo = giftSendResultEvent.sendGiftInfo) == null || sendGiftInfo.needLxBean > com.zenmen.palmchat.giftkit.b.j().g()) {
                    return;
                }
                com.zenmen.palmchat.giftkit.b bVarJ = com.zenmen.palmchat.giftkit.b.j();
                Context context = GiftPanel.this.getContext();
                SendGiftInfo sendGiftInfo2 = e.this.f14066a.sendGiftInfo;
                bVarJ.v(context, sendGiftInfo2.itemId, sendGiftInfo2.giftName, e.this.f14066a.sendGiftInfo.needLxBean + "", new C1054a());
            }
        }

        public e(GiftSendResultEvent giftSendResultEvent) {
            this.f14066a = giftSendResultEvent;
        }

        @Override // com.zenmen.palmchat.giftkit.a.InterfaceC1055a
        public void a(boolean z) {
            GiftPanel.this.I = false;
            com.zenmen.palmchat.giftkit.b.j().r(new a(z));
            if (z && GiftPanel.this.m.hasActivity()) {
                com.zenmen.palmchat.giftkit.b.j().x(GiftPanel.this.d, true);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements a.InterfaceC1055a {
        public f() {
        }

        @Override // com.zenmen.palmchat.giftkit.a.InterfaceC1055a
        public void a(boolean z) {
            GiftPanel.this.I = false;
            if (z) {
                com.zenmen.palmchat.giftkit.b.j().x(GiftPanel.this.d, true);
                com.zenmen.palmchat.giftkit.b.j().q();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface h {
        void onDismiss();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface i {
        boolean a();

        List<String> b();

        int getHeight();

        View getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(int i2) {
        this.q = i2;
        this.p.g(i2);
        if (i2 > 1) {
            this.m.resetContinue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(int i2) {
        this.r = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V0(View view) {
        f1(-1L, false, null);
        this.p.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W0(View view) {
        if (eh.d(view.getId(), 100L)) {
            return;
        }
        if (this.C == 0) {
            this.m.resetHit();
        }
        g1(this.C == 1, false, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X0(BalanceUpdateEvent balanceUpdateEvent) {
        this.g.updateBalance(balanceUpdateEvent.balance);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z0() {
        this.m.update(false);
        t1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a1(GiftSendResultEvent giftSendResultEvent) {
        try {
            this.g.updateBalance(giftSendResultEvent.balance);
            int i2 = giftSendResultEvent.ret;
            boolean z = false;
            if (i2 != 0) {
                if (i2 != 1001) {
                    if (TextUtils.isEmpty(giftSendResultEvent.errorMsg)) {
                        this.v.a(getContext(), "赠送失败，请再试试", 0);
                        return;
                    } else {
                        this.v.a(getContext(), giftSendResultEvent.errorMsg, 0);
                        return;
                    }
                }
                if (!giftSendResultEvent.sendPackGift) {
                    f1(giftSendResultEvent.needLxBean, giftSendResultEvent.isHit, giftSendResultEvent);
                    return;
                } else {
                    com.zenmen.palmchat.giftkit.b.j().s(this.d);
                    this.v.a(getContext(), giftSendResultEvent.errorMsg, 0);
                    return;
                }
            }
            if (giftSendResultEvent.sendPackGift) {
                PackPanelItem packPanelItem = this.B;
                if (packPanelItem != null) {
                    this.n.onGiftSend(packPanelItem, giftSendResultEvent.toUidsCount * giftSendResultEvent.sendNum);
                    t1();
                    ds0.a().b(new PackPanelUIUpdateEvent(giftSendResultEvent.panelId));
                    return;
                }
                return;
            }
            GiftPanelItem giftPanelItem = this.A;
            if (giftPanelItem == null || giftSendResultEvent.itemId != giftPanelItem.itemId) {
                return;
            }
            int i3 = this.d;
            if (i3 != 301 && i3 != 801 && this.q == 1 && giftSendResultEvent.toUidsCount == 1 && giftPanelItem.continuable == 1) {
                z = true;
            }
            this.m.onGiftSend(giftPanelItem, z);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b1(PackPanelUpdateEvent packPanelUpdateEvent) {
        this.g.updateBalance(packPanelUpdateEvent.balance);
        this.n.update(packPanelUpdateEvent.netError);
        t1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c1() {
        this.h.setCurrentItem(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e1() {
        this.m.resetContinue();
    }

    public void K0(i iVar) {
        this.o = iVar;
    }

    public final String L0(boolean z) {
        if (z && !TextUtils.isEmpty(this.s)) {
            return this.s;
        }
        String strReplace = UUID.randomUUID().toString().replace("-", "");
        this.s = strReplace;
        return strReplace;
    }

    public final long M0(boolean z) {
        GiftPanelItem giftPanelItem;
        PackPanelItem packPanelItem;
        if (z && (packPanelItem = this.B) != null) {
            return packPanelItem.itemId;
        }
        if (z || (giftPanelItem = this.A) == null) {
            return 0L;
        }
        return giftPanelItem.itemId;
    }

    public final int N0(boolean z) {
        return z ? this.r : this.q;
    }

    public final List<String> O0() {
        i iVar = this.o;
        if (iVar != null) {
            return iVar.b();
        }
        List<String> list = this.u;
        if (list != null) {
            return list;
        }
        return null;
    }

    public final void Q0(String str) {
        if (this.I) {
            return;
        }
        if (!hx3.m(getContext())) {
            this.v.a(getContext(), "网络好像有点问题，稍后再试", 0);
            return;
        }
        com.zenmen.palmchat.giftkit.a.a().b(getContext(), of2.a(str, this.d, this.w), -1L, new f());
        this.I = true;
    }

    public final void R0() {
        this.g = (GiftTabHeaderView) this.f.findViewById(R$id.header);
        View viewFindViewById = this.f.findViewById(R$id.tab_line);
        this.g.initItems(this.d);
        this.g.updateBalance(com.zenmen.palmchat.giftkit.b.j().g());
        this.g.updateFirstChargeGuideInfo(null);
        this.g.setHeaderViewEventListener(new b());
        GiftNumSelectorView giftNumSelectorView = (GiftNumSelectorView) this.f.findViewById(R$id.number_selector);
        this.j = giftNumSelectorView;
        giftNumSelectorView.setNumber(this.q);
        this.j.setNumberSelectListener(new GiftNumSelectorView.b() { // from class: lb2
            @Override // com.zenmen.palmchat.giftkit.widgit.GiftNumSelectorView.b
            public final void a(int i2) {
                this.f18951a.S0(i2);
            }
        });
        GiftNumSelectorView giftNumSelectorView2 = (GiftNumSelectorView) this.f.findViewById(R$id.pack_number_selector);
        this.k = giftNumSelectorView2;
        giftNumSelectorView2.setNumber(this.r);
        this.k.setNumberSelectListener(new GiftNumSelectorView.b() { // from class: mb2
            @Override // com.zenmen.palmchat.giftkit.widgit.GiftNumSelectorView.b
            public final void a(int i2) {
                this.f19183a.T0(i2);
            }
        });
        boolean z = com.zenmen.palmchat.giftkit.a.a().c() && ChatGiftConfig.getChatGiftConfig().gift_newpanel;
        if (z) {
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            viewFindViewById.setVisibility(8);
        } else {
            viewFindViewById.setVisibility(0);
            int i2 = 4;
            this.j.setVisibility((this.C == 0 && this.d == 301) ? 0 : 4);
            GiftNumSelectorView giftNumSelectorView3 = this.k;
            if (jo6.a("LX-41929", false) && this.C == 1 && this.d == 301) {
                i2 = 0;
            }
            giftNumSelectorView3.setVisibility(i2);
        }
        this.h = (ViewPager) this.f.findViewById(R$id.vp_panel);
        this.i = new c();
        this.h.addOnPageChangeListener(new d());
        this.h.setAdapter(this.i);
        this.g.onSelect(this.C);
        View viewFindViewById2 = this.f.findViewById(R$id.tv_gift_send);
        this.l = viewFindViewById2;
        ViewGroup.LayoutParams layoutParams = viewFindViewById2.getLayoutParams();
        layoutParams.width = k86.e(getContext(), z ? 80.0f : 62.0f);
        this.l.setLayoutParams(layoutParams);
        View viewFindViewById3 = this.f.findViewById(R$id.bottom_layout);
        if (z) {
            viewFindViewById3.setVisibility(0);
            this.l.setBackgroundResource(R$drawable.selector_gift_send_bg_light_new);
        }
        View viewFindViewById4 = this.f.findViewById(R$id.ll_recharge_layout);
        viewFindViewById4.setVisibility(z ? 0 : 8);
        viewFindViewById4.setOnClickListener(new View.OnClickListener() { // from class: nb2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19479a.V0(view);
            }
        });
        View viewFindViewById5 = this.f.findViewById(R$id.bottom_linearlayout);
        if (z) {
            q05.y(viewFindViewById5, null, Integer.valueOf(me1.b(getContext(), 40)));
        }
        this.l.setOnClickListener(new View.OnClickListener() { // from class: ob2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19733a.W0(view);
            }
        });
        t1();
    }

    public final void f1(long j, boolean z, GiftSendResultEvent giftSendResultEvent) {
        String strF;
        b05.d("礼物面板调起充值recharge()");
        if (this.I) {
            return;
        }
        if (!hx3.m(getContext())) {
            this.v.a(getContext(), "网络好像有点问题，稍后再试", 0);
            return;
        }
        int i2 = z ? 2 : j > 0 ? 1 : 0;
        int i3 = this.d;
        if (301 == i3) {
            int i4 = this.x;
            strF = of2.f(i4 == 5016 ? 10 : i4 == 5012 ? 9 : i2, i3, this.w, this.z, this.y, i4);
        } else {
            strF = "";
        }
        if (801 == this.d) {
            int i5 = this.H;
            if (i5 <= 0) {
                Toast.makeText(getContext(), "请设置giftPanelFrom", 0).show();
                return;
            }
            strF = of2.f(i5, 2001, this.w, this.z, this.y, this.x);
        }
        com.zenmen.palmchat.giftkit.a.a().b(getContext(), strF, j, new e(giftSendResultEvent));
        this.I = true;
    }

    public final void g1(boolean z, boolean z2, int i2) {
        GiftPanelItem giftPanelItem;
        PackPanelItem packPanelItem;
        b05.d("面板赠送礼物");
        long jM0 = M0(z);
        long j = 0;
        if (jM0 <= 0) {
            this.v.a(getContext(), "请选择礼物", 0);
            return;
        }
        int iN0 = N0(z);
        List<String> listO0 = O0();
        if (listO0 == null || listO0.isEmpty()) {
            this.v.a(getContext(), "请选择送礼对象", 0);
            this.p.h(this.C, null, jM0, iN0, z2, i2, 1);
            return;
        }
        if (!hx3.m(getContext())) {
            this.v.a(getContext(), "网络好像有点问题，稍后再试", 0);
            this.p.h(this.C, listO0, jM0, iN0, z2, i2, 3);
            return;
        }
        if (z) {
            PackPanelItem packPanelItem2 = this.B;
            if (packPanelItem2 != null && packPanelItem2.itemCount < ((long) listO0.size()) * ((long) iN0)) {
                this.v.a(getContext(), "背包库存礼物不足", 0);
                this.p.h(this.C, listO0, jM0, iN0, z2, i2, 2);
                return;
            }
        } else {
            GiftPanelItem giftPanelItem2 = this.A;
            if (giftPanelItem2 != null) {
                long size = giftPanelItem2.price * ((long) listO0.size()) * ((long) iN0);
                if (size > com.zenmen.palmchat.giftkit.b.j().g()) {
                    this.p.h(this.C, listO0, jM0, iN0, z2, i2, 2);
                    SendGiftInfo sendGiftInfo = new SendGiftInfo(this.d, 0, this.w, z, jM0, N0(z), z2, L0(z2), listO0, this.t, System.currentTimeMillis(), size, null, false, this.A.itemName);
                    GiftSendResultEvent giftSendResultEvent = new GiftSendResultEvent();
                    giftSendResultEvent.sendGiftInfo = sendGiftInfo;
                    f1(size, z2, giftSendResultEvent);
                    return;
                }
                j = size;
            }
        }
        com.zenmen.palmchat.giftkit.b.j().l(this.d, 0, this.w, z, jM0, N0(z), z2, L0(z2), listO0, this.t, System.currentTimeMillis(), j, null, false, (!z || (packPanelItem = this.B) == null) ? (z || (giftPanelItem = this.A) == null) ? "" : giftPanelItem.itemName : packPanelItem.itemName);
        this.p.h(this.C, listO0, jM0, iN0, z2, i2, 0);
    }

    public void h1(g gVar) {
        this.F = gVar;
    }

    public void i1(String str) {
        this.t = str;
    }

    public void j1(h hVar) {
        this.E = hVar;
    }

    public void k1(int i2, int i3, String str, Bundle bundle, String str2, int i4) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("panelId", i2);
        bundle.putInt("groupType", i3);
        bundle.putString("reportId", str);
        bundle.putString("domain", str2);
        bundle.putInt("bizType", i4);
        setArguments(bundle);
    }

    public void l1(int i2, String str) {
        n1(i2, str, null);
    }

    public void m1(int i2, String str, int i3, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("panelId", i2);
        bundle.putString("reportId", str);
        bundle.putInt("bizType", i3);
        bundle.putString("domain", str2);
        setArguments(bundle);
    }

    public void n1(int i2, String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("panelId", i2);
        bundle.putString("reportId", str);
        setArguments(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @qm5
    public void onBalanceUpdateEvent(final BalanceUpdateEvent balanceUpdateEvent) {
        View view = this.f;
        if (view == null || this.g == null) {
            return;
        }
        view.post(new Runnable() { // from class: qb2
            @Override // java.lang.Runnable
            public final void run() {
                this.f20220a.X0(balanceUpdateEvent);
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.d = arguments.getInt("panelId", 201);
            this.w = arguments.getString("reportId");
            this.z = arguments.getInt("groupType", 0);
            this.x = arguments.getInt("bizType", -1);
            this.y = arguments.getString("domain", "");
            int i2 = this.d;
            this.e = i2 == 201 ? 1 : 0;
            ub2 ub2Var = new ub2(i2, this.w, this.z);
            this.p = ub2Var;
            ub2Var.d = this.H;
            this.v = new qy5();
            com.zenmen.palmchat.giftkit.b.j().x(this.d, false);
            com.zenmen.palmchat.giftkit.b.j().q();
            this.C = arguments.getInt("default_index", 0);
        }
        ds0.a().c(this);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        a aVar = new a(getContext(), this.e, this.F);
        if (com.zenmen.palmchat.giftkit.a.a().c()) {
            boolean z = ChatGiftConfig.getChatGiftConfig().gift_newpanel;
        }
        int iE = k86.e(getContext(), 362.0f);
        if (this.F != null) {
            iE += k86.e(getContext(), 86.0f);
        }
        i iVar = this.o;
        if (iVar != null) {
            iE += iVar.getHeight();
        }
        aVar.q(iE);
        com.zenmen.palmchat.giftkit.b.j().s(this.d);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        ds0.a().d(this);
        com.zenmen.palmchat.giftkit.b.j().t();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        this.B = null;
        if (com.zenmen.palmchat.giftkit.a.a().c() && ChatGiftConfig.getChatGiftConfig().gift_newpanel) {
            this.A = null;
        }
        super.onDismiss(dialogInterface);
        h hVar = this.E;
        if (hVar != null) {
            hVar.onDismiss();
        }
        ds0.a().b(new n30(n30.b));
    }

    @qm5
    public void onGiftPanelUpdateEvent(GiftPanelUpdateEvent giftPanelUpdateEvent) {
        View view;
        if (giftPanelUpdateEvent.panelId != this.d || (view = this.f) == null || this.m == null) {
            return;
        }
        view.post(new Runnable() { // from class: rb2
            @Override // java.lang.Runnable
            public final void run() {
                this.f20433a.Z0();
            }
        });
    }

    @qm5
    public void onGiftSendResultEvent(final GiftSendResultEvent giftSendResultEvent) {
        b05.d("GiftPanel类收到GiftSendResultEvent===》事件");
        if (giftSendResultEvent.panelId == this.d && this.f != null && giftSendResultEvent.sceneType == 0) {
            b05.d("属于GiftPanel事件");
            this.f.post(new Runnable() { // from class: pb2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19986a.a1(giftSendResultEvent);
                }
            });
        }
    }

    @qm5
    public void onPackPanelUpdateEvent(final PackPanelUpdateEvent packPanelUpdateEvent) {
        View view;
        if (packPanelUpdateEvent.panelId != this.d || (view = this.f) == null || this.n == null) {
            return;
        }
        view.post(new Runnable() { // from class: kb2
            @Override // java.lang.Runnable
            public final void run() {
                this.f18615a.b1(packPanelUpdateEvent);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.I = false;
    }

    @qm5
    public void onSetGiftTabEvent(SetGiftTabEvent setGiftTabEvent) {
        View view = this.f;
        if (view == null || this.h == null) {
            return;
        }
        view.post(new Runnable() { // from class: tb2
            @Override // java.lang.Runnable
            public final void run() {
                this.f20949a.c1();
            }
        });
    }

    public void p1(boolean z) {
        this.G = z;
    }

    public void r1(String str) {
        ArrayList arrayList = new ArrayList();
        this.u = arrayList;
        arrayList.add(str);
    }

    public void s1(@NonNull FragmentManager fragmentManager, int i2) {
        this.H = i2;
        if (fragmentManager.isStateSaved() || isAdded()) {
            return;
        }
        String strValueOf = String.valueOf(this.d);
        if (fragmentManager.findFragmentByTag(strValueOf) != null) {
            return;
        }
        try {
            fragmentManager.beginTransaction().remove(this).commit();
            super.show(fragmentManager, strValueOf);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void t1() {
        PackListView packListView;
        GiftListView giftListView = this.m;
        if (giftListView == null || (packListView = this.n) == null) {
            return;
        }
        View view = this.l;
        boolean z = true;
        if (this.C != 0 ? packListView.getItemCount() <= 0 : giftListView.getItemCount() <= 0) {
            z = false;
        }
        view.setEnabled(z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f14070a;
        public String b;

        public g(String str) {
            this.f14070a = str;
        }

        public g(String str, String str2) {
            this.f14070a = str;
            this.b = str2;
        }
    }

    @qm5
    public void onSetGiftTabEvent(VoiceRoomMemberSelectEvent voiceRoomMemberSelectEvent) {
        View view = this.f;
        if (view == null || this.m == null) {
            return;
        }
        view.post(new Runnable() { // from class: sb2
            @Override // java.lang.Runnable
            public final void run() {
                this.f20704a.e1();
            }
        });
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements ViewPager.OnPageChangeListener {
        public d() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            GiftPanel.this.C = i;
            GiftPanel.this.g.onSelect(i);
            boolean z = true;
            if (com.zenmen.palmchat.giftkit.a.a().c() && ChatGiftConfig.getChatGiftConfig().gift_newpanel) {
                GiftPanel.this.j.setVisibility(8);
                GiftPanel.this.k.setVisibility(8);
            } else {
                int i2 = 4;
                GiftPanel.this.j.setVisibility((i == 0 && GiftPanel.this.d == 301) ? 0 : 4);
                GiftNumSelectorView giftNumSelectorView = GiftPanel.this.k;
                if (jo6.a("LX-41929", false) && i == 1 && GiftPanel.this.d == 301) {
                    i2 = 0;
                }
                giftNumSelectorView.setVisibility(i2);
            }
            GiftPanel.this.t1();
            if (GiftPanel.this.C == 1) {
                com.zenmen.palmchat.giftkit.b.j().s(GiftPanel.this.d);
            }
            ub2 ub2Var = GiftPanel.this.p;
            int i3 = GiftPanel.this.C;
            if (GiftPanel.this.C != 0 ? GiftPanel.this.n == null || !GiftPanel.this.n.isShowError() : GiftPanel.this.m == null || !GiftPanel.this.m.isShowError()) {
                z = false;
            }
            ub2Var.k(i3, z, GiftPanel.this.C == 0 ? GiftPanel.this.m.getActivityId() : 0L);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }
}
