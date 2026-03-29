package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.gift.ShowChatGiftPanelEvent;
import com.zenmen.palmchat.chat.gift.quicksend.QuickSendVo;
import com.zenmen.palmchat.giftkit.SendGiftInfo;
import com.zenmen.palmchat.giftkit.a;
import com.zenmen.palmchat.giftkit.b;
import com.zenmen.palmchat.giftkit.event.GiftSendResultEvent;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.voiceroom.adapter.RcyHolder;
import com.zenmen.palmchat.voiceroom.adapter.RcySAdapter;
import defpackage.aq4;
import defpackage.b05;
import defpackage.je1;
import defpackage.q05;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class iq4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f18229a;
    public View b;
    public je1 c;
    public ChatItem d;
    public int e;
    public String h;
    public QuickSendVo k;
    public List<String> f = null;
    public String g = null;
    public RcySAdapter<QuickSendVo, RcyHolder> i = null;
    public boolean j = false;
    public f l = new d();
    public boolean m = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements q05.e<List<QuickSendVo>> {
        public a() {
        }

        @Override // q05.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(List<QuickSendVo> list) {
            iq4.this.A(list);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends RcySAdapter<QuickSendVo, RcyHolder> {
        public b(Context context, int i) {
            super(context, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(QuickSendVo quickSendVo, View view) {
            iq4.this.l.a(quickSendVo);
        }

        @Override // com.zenmen.palmchat.voiceroom.adapter.RcySAdapter
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void h(RcyHolder rcyHolder, final QuickSendVo quickSendVo, int i) {
            View viewL = rcyHolder.l(R.id.rootView);
            View viewL2 = rcyHolder.l(R.id.contentLayout);
            TextView textView = (TextView) rcyHolder.l(R.id.label);
            ImageView imageView = (ImageView) rcyHolder.l(R.id.icon);
            TextView textView2 = (TextView) rcyHolder.l(R.id.giftName);
            TextView textView3 = (TextView) rcyHolder.l(R.id.giftPrice);
            View viewL3 = rcyHolder.l(R.id.giftPriceIcon);
            textView.setText(quickSendVo.supportTitle);
            gr2.j().h(quickSendVo.iconUrl, imageView, iq4.this.c);
            textView2.setText(quickSendVo.itemName);
            long j = quickSendVo.realPrice;
            if (j == 0) {
                textView3.setText("免费");
                viewL3.setVisibility(8);
            } else {
                textView3.setText(String.valueOf(j));
                viewL3.setVisibility(0);
            }
            if (TextUtils.isEmpty(quickSendVo.supportTitle)) {
                textView.setVisibility(4);
                viewL.setBackgroundColor(0);
                viewL2.setBackgroundResource(R.drawable.shape_gift_quick_send_bg_inner);
            } else {
                textView.setVisibility(0);
                viewL.setBackgroundResource(R.drawable.shape_gift_quick_send_bg);
                viewL2.setBackgroundResource(R.drawable.shape_gift_quick_send_bg_inner2);
            }
            rcyHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: jq4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f18480a.k(quickSendVo, view);
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements aq4.b {
        public c() {
        }

        @Override // aq4.b
        public void a(QuickSendVo quickSendVo) {
            com.zenmen.palmchat.giftkit.b.j().l(iq4.this.e, 1, iq4.this.h, quickSendVo.isPack(), quickSendVo.itemId, 1, false, iq4.this.r(false), iq4.this.f, iq4.this.g, System.currentTimeMillis(), quickSendVo.realPrice, quickSendVo.intimacyGuideMid, quickSendVo.isIntimacyFreeGift, quickSendVo.itemName);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements f {
        public d() {
        }

        @Override // iq4.f
        public void a(QuickSendVo quickSendVo) {
            bq4.a(iq4.this.e, iq4.this.h, quickSendVo.isPack(), quickSendVo.itemId);
            iq4.this.s(quickSendVo);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements a.InterfaceC1055a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftSendResultEvent f18233a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements b.m {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f18234a;

            /* JADX INFO: renamed from: iq4$e$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1212a implements b.m {
                public C1212a() {
                }

                @Override // com.zenmen.palmchat.giftkit.b.m
                public void call() {
                    e.this.f18233a.sendGiftInfo.reSendGift();
                    int i = e.this.f18233a.sceneType;
                    if (i == 4 || i == 5 || i == 6) {
                        ds0.a().b(new ShowChatGiftPanelEvent(null, null));
                    }
                }
            }

            /* JADX INFO: compiled from: SearchBox */
            public class b implements b.m {
                public b() {
                }

                @Override // com.zenmen.palmchat.giftkit.b.m
                public void call() {
                    int i = e.this.f18233a.sceneType;
                    if (i == 4 || i == 5 || i == 6) {
                        ds0.a().b(new ShowChatGiftPanelEvent(null, null));
                    }
                }
            }

            public a(boolean z) {
                this.f18234a = z;
            }

            @Override // com.zenmen.palmchat.giftkit.b.m
            public void call() {
                GiftSendResultEvent giftSendResultEvent;
                SendGiftInfo sendGiftInfo;
                if (!this.f18234a || iq4.this.d.getChatType() != 0 || !c46.b() || (giftSendResultEvent = e.this.f18233a) == null || (sendGiftInfo = giftSendResultEvent.sendGiftInfo) == null) {
                    int i = e.this.f18233a.sceneType;
                    if (i == 4 || i == 5 || i == 6) {
                        ds0.a().b(new ShowChatGiftPanelEvent(null, null));
                        return;
                    }
                    return;
                }
                if (sendGiftInfo.needLxBean <= com.zenmen.palmchat.giftkit.b.j().g()) {
                    com.zenmen.palmchat.giftkit.b bVarJ = com.zenmen.palmchat.giftkit.b.j();
                    Context contextQ = iq4.this.q();
                    SendGiftInfo sendGiftInfo2 = e.this.f18233a.sendGiftInfo;
                    bVarJ.w(contextQ, sendGiftInfo2.itemId, sendGiftInfo2.giftName, e.this.f18233a.sendGiftInfo.needLxBean + "", new C1212a(), new b());
                }
            }
        }

        public e(GiftSendResultEvent giftSendResultEvent) {
            this.f18233a = giftSendResultEvent;
        }

        @Override // com.zenmen.palmchat.giftkit.a.InterfaceC1055a
        public void a(boolean z) {
            iq4.this.m = false;
            com.zenmen.palmchat.giftkit.b.j().r(new a(z));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void a(QuickSendVo quickSendVo);
    }

    public iq4(View view, View view2) {
        this.f18229a = view;
        view.setVisibility(8);
        if (view2 != null) {
            View viewFindViewById = view2.findViewById(R.id.giftGapView);
            this.b = viewFindViewById;
            viewFindViewById.setVisibility(8);
        }
        this.c = new je1.a().s(true).A(R.drawable.ic_chat_input_header_panel_gift).t(true).q(Bitmap.Config.RGB_565).B(R.drawable.ic_chat_input_header_panel_gift).z(R.drawable.ic_chat_input_header_panel_gift).r();
    }

    public static /* synthetic */ Object u() {
        return "快捷礼物走新逻辑";
    }

    public static /* synthetic */ Object v() {
        return "快捷礼物走老逻辑";
    }

    public static /* synthetic */ Object w() {
        return "onGiftSendResultEvent赠送结果如下";
    }

    public static /* synthetic */ Object y() {
        return "背包礼物更新-新逻辑";
    }

    public static /* synthetic */ Object z() {
        return "背包礼物更新-老逻辑";
    }

    public void A(List<QuickSendVo> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) this.f18229a.findViewById(R.id.giftList);
        b bVar = new b(this.f18229a.getContext(), R.layout.item_gift_quicksend);
        this.i = bVar;
        recyclerView.setAdapter(bVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f18229a.getContext(), 0, false));
        this.i.g(list, true);
        this.f18229a.setVisibility(0);
        View view = this.b;
        if (view != null) {
            view.setVisibility(0);
        }
        bq4.b(this.h);
        this.j = true;
        LogUtil.i("QuickSendManager", "view init");
    }

    public void B(final GiftSendResultEvent giftSendResultEvent) {
        b05.c(new b05.a() { // from class: eq4
            @Override // b05.a
            public final Object getValue() {
                return iq4.w();
            }
        });
        b05.c(new b05.a() { // from class: fq4
            @Override // b05.a
            public final Object getValue() {
                return iq4.x(giftSendResultEvent);
            }
        });
        try {
            int i = giftSendResultEvent.ret;
            if (i == 0) {
                if (giftSendResultEvent.sendPackGift) {
                    F(giftSendResultEvent.itemId, giftSendResultEvent.sendNum, false);
                }
                int i2 = giftSendResultEvent.sceneType;
                if (i2 == 4 || i2 == 5 || i2 == 6) {
                    ds0.a().b(new ShowChatGiftPanelEvent(null, null));
                    return;
                }
                return;
            }
            int i3 = giftSendResultEvent.sceneType;
            if (i3 == 1) {
                if (i != 1001) {
                    if (TextUtils.isEmpty(giftSendResultEvent.errorMsg)) {
                        sy5.f(this.f18229a.getContext(), "赠送失败，请再试试", 0).g();
                        return;
                    } else {
                        sy5.f(this.f18229a.getContext(), giftSendResultEvent.errorMsg, 0).g();
                        return;
                    }
                }
                if (!giftSendResultEvent.sendPackGift) {
                    D(giftSendResultEvent.needLxBean, giftSendResultEvent.isHit, giftSendResultEvent);
                    return;
                }
                com.zenmen.palmchat.giftkit.b.j().s(this.e);
                sy5.f(this.f18229a.getContext(), giftSendResultEvent.errorMsg, 0).g();
                long j = giftSendResultEvent.itemId;
                int i4 = giftSendResultEvent.sendNum;
                F(j, i4, i4 == 1);
                return;
            }
            if (i3 == 2) {
                if (i == 1001) {
                    D(giftSendResultEvent.needLxBean, giftSendResultEvent.isHit, giftSendResultEvent);
                    return;
                } else if (TextUtils.isEmpty(giftSendResultEvent.errorMsg)) {
                    sy5.f(this.f18229a.getContext(), "赠送失败，请再试试", 0).g();
                    return;
                } else {
                    sy5.f(this.f18229a.getContext(), giftSendResultEvent.errorMsg, 0).g();
                    return;
                }
            }
            if (i3 == 4 || i3 == 5 || i3 == 6) {
                if (i == 1001) {
                    D(giftSendResultEvent.needLxBean, giftSendResultEvent.isHit, giftSendResultEvent);
                } else if (TextUtils.isEmpty(giftSendResultEvent.errorMsg)) {
                    sy5.f(this.f18229a.getContext(), "赠送失败，请再试试", 0).g();
                } else {
                    sy5.f(this.f18229a.getContext(), giftSendResultEvent.errorMsg, 0).g();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void C(boolean z) {
        LogUtil.i("QuickSendManager", "onOpenVipPopWindowChange " + z + " hasInit=" + this.j);
        if (this.j) {
            if (z) {
                this.f18229a.setVisibility(8);
                View view = this.b;
                if (view != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            this.f18229a.setVisibility(0);
            View view2 = this.b;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void D(long j, boolean z, GiftSendResultEvent giftSendResultEvent) {
        int i;
        String str;
        String str2;
        int i2;
        int i3;
        ChatItem chatItem;
        b05.d("recharge()");
        if (this.m) {
            return;
        }
        if (301 != this.e || (chatItem = this.d) == null) {
            i = 3;
        } else if (5016 == chatItem.getBizType()) {
            i = 10;
        } else if (5012 == this.d.getBizType()) {
            i = 9;
        }
        int i4 = this.e;
        ChatItem chatItem2 = this.d;
        if (chatItem2 != null) {
            str = fu5.k(chatItem2.getBizType()).domain;
            if (5055 == this.d.getBizType() || 5058 == this.d.getBizType()) {
                str2 = str;
                i3 = 200301;
                i2 = 2003;
            }
            String str3 = this.h;
            int iH = n20.h(this.d);
            ChatItem chatItem3 = this.d;
            com.zenmen.palmchat.giftkit.a.a().b(q(), of2.f(i3, i2, str3, iH, str2, chatItem3 == null ? chatItem3.getBizType() : 0), j, new e(giftSendResultEvent));
            this.m = true;
        }
        str = "";
        i3 = i;
        i2 = i4;
        str2 = str;
        String str32 = this.h;
        int iH2 = n20.h(this.d);
        ChatItem chatItem32 = this.d;
        com.zenmen.palmchat.giftkit.a.a().b(q(), of2.f(i3, i2, str32, iH2, str2, chatItem32 == null ? chatItem32.getBizType() : 0), j, new e(giftSendResultEvent));
        this.m = true;
    }

    public void E(ChatItem chatItem, int i, String str, String str2, String str3) {
        this.e = i;
        this.h = str;
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        arrayList.add(str2);
        this.g = str3;
        this.d = chatItem;
        if (vp4.a().g(chatItem)) {
            return;
        }
        if (v8.h() && chatItem != null && v8.C(chatItem.getChatId())) {
            return;
        }
        t();
    }

    public final void F(long j, int i, boolean z) {
        boolean z2;
        boolean z3;
        if (this.i != null) {
            ArrayList<QuickSendVo> arrayList = new ArrayList<>();
            boolean z4 = false;
            if (this.i.getData() != null) {
                boolean z5 = false;
                for (QuickSendVo quickSendVo : this.i.getData()) {
                    if (quickSendVo.itemId == j) {
                        int i2 = quickSendVo.itemCount - i;
                        quickSendVo.itemCount = i2;
                        z3 = i2 <= 0 || z;
                        z2 = true;
                    } else {
                        z2 = z5;
                        z3 = false;
                    }
                    if (!z3) {
                        arrayList.add(quickSendVo);
                    }
                    z5 = z2;
                }
                z4 = z5;
            }
            if (z4) {
                this.i.g(arrayList, true);
                if (!p05.c()) {
                    b05.c(new b05.a() { // from class: hq4
                        @Override // b05.a
                        public final Object getValue() {
                            return iq4.z();
                        }
                    });
                    rq4.l().z(arrayList);
                    return;
                }
                b05.c(new b05.a() { // from class: gq4
                    @Override // b05.a
                    public final Object getValue() {
                        return iq4.y();
                    }
                });
                ChatItem chatItem = this.d;
                if (chatItem != null) {
                    String str = fu5.k(chatItem.getBizType()).domain;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    rq4.l().y(str, arrayList);
                }
            }
        }
    }

    public final Context q() {
        return this.f18229a.getContext();
    }

    public final String r(boolean z) {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void s(QuickSendVo quickSendVo) {
        this.k = quickSendVo;
        if (!hx3.m(q())) {
            sy5.f(q(), "网络好像有点问题，稍后再试", 0).g();
        } else if (quickSendVo.isIntimacyFreeGift) {
            com.zenmen.palmchat.giftkit.b.j().l(this.e, 1, this.h, quickSendVo.isPack(), quickSendVo.itemId, 1, false, r(false), this.f, this.g, System.currentTimeMillis(), quickSendVo.realPrice, quickSendVo.intimacyGuideMid, quickSendVo.isIntimacyFreeGift, quickSendVo.itemName);
        } else {
            aq4.a(q(), quickSendVo, new c());
        }
    }

    public void t() {
        if (!p05.c()) {
            b05.c(new b05.a() { // from class: dq4
                @Override // b05.a
                public final Object getValue() {
                    return iq4.v();
                }
            });
            A(rq4.l().m());
            return;
        }
        b05.c(new b05.a() { // from class: cq4
            @Override // b05.a
            public final Object getValue() {
                return iq4.u();
            }
        });
        ChatItem chatItem = this.d;
        if (chatItem != null) {
            String str = fu5.k(chatItem.getBizType()).domain;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            rq4.l().x(str, new a());
        }
    }

    public static /* synthetic */ Object x(GiftSendResultEvent giftSendResultEvent) {
        return giftSendResultEvent;
    }
}
