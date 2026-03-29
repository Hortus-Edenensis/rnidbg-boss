package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.gift.ChatGiftGuideCard;
import com.zenmen.palmchat.chat.gift.GiftMessageHelper;
import com.zenmen.palmchat.chat.gift.ShowChatGiftPanelEvent;
import com.zenmen.palmchat.chat.gift.quicksend.QuickSendVo;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.widget.LXPortraitView;
import defpackage.aq4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class o20 extends SimpleChatViewAdapter {
    public HashMap<String, String> i = new HashMap<>();
    public boolean j;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            o20.this.E();
            ds0.a().b(new ShowChatGiftPanelEvent(null, null));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19659a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ChatGiftGuideCard e;
        public final /* synthetic */ ContactInfoItem f;
        public final /* synthetic */ int g;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements aq4.b {
            public a() {
            }

            @Override // aq4.b
            public void a(QuickSendVo quickSendVo) {
                b bVar = b.this;
                o20.this.F(bVar.e);
                ArrayList arrayList = new ArrayList();
                arrayList.add(b.this.f.getChatId());
                HashMap map = new HashMap();
                int bizType = b.this.f.getBizType();
                String str = DomainHelper.m(b.this.f).domain;
                map.put("domain", str);
                if (DomainHelper.Domains.DOMAIN_PRIVATE.domain.equalsIgnoreCase(str) && fu5.q(bizType)) {
                    map.put("bizType", Integer.valueOf(bizType + AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite));
                } else {
                    map.put("bizType", Integer.valueOf(bizType));
                }
                com.zenmen.palmchat.giftkit.b.j().l(301, b.this.g, b.this.f.getChatId() + str, false, quickSendVo.itemId, 1, false, UUID.randomUUID().toString().replace("-", ""), arrayList, new JSONObject(map).toString(), System.currentTimeMillis(), quickSendVo.realPrice, "", false, quickSendVo.itemName);
            }
        }

        public b(String str, int i, int i2, String str2, ChatGiftGuideCard chatGiftGuideCard, ContactInfoItem contactInfoItem, int i3) {
            this.f19659a = str;
            this.b = i;
            this.c = i2;
            this.d = str2;
            this.e = chatGiftGuideCard;
            this.f = contactInfoItem;
            this.g = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            QuickSendVo quickSendVo = new QuickSendVo();
            quickSendVo.itemName = this.f19659a;
            quickSendVo.realPrice = this.b;
            quickSendVo.itemId = this.c;
            quickSendVo.iconUrl = this.d;
            aq4.b(o20.this.f, quickSendVo, new a(), true);
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
            o20.this.E();
            ds0.a().b(new ShowChatGiftPanelEvent(null, null));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {
        public d() {
            put("scene", 301);
            put("roomid", o20.this.o().getChatId() + DomainHelper.m(o20.this.o()).domain);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {
        public e() {
            put("scene", 301);
            put("roomid", o20.this.o().getChatId() + DomainHelper.m(o20.this.o()).domain);
        }
    }

    public final int A(ChatGiftGuideCard chatGiftGuideCard) {
        if (chatGiftGuideCard == null) {
            return 1;
        }
        int i = chatGiftGuideCard.guideType;
        return i != 1 ? i != 2 ? 1 : 4 : chatGiftGuideCard.applySource == 1 ? 3 : 2;
    }

    public void B(MessageVo messageVo, p20 p20Var) {
        View view = p20Var.g;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = p20Var.h;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        LXPortraitView lXPortraitView = p20Var.i;
        if (lXPortraitView != null) {
            lXPortraitView.setVisibility(8);
        }
        View view3 = p20Var.j;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        ImageView imageView = p20Var.k;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = p20Var.c;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = p20Var.d;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        TextView textView3 = p20Var.s;
        if (textView3 != null) {
            textView3.setText(z(messageVo).getTitleForShow());
        }
        TextView textView4 = p20Var.t;
        if (textView4 != null) {
            textView4.setText(z(messageVo).getContentForShow());
        }
        if (p20Var.u != null) {
            hc2.a(this.f).load(z(messageVo).getUrlForShow()).error(R.drawable.ic_chat_flowers_buy_vip_gift_tips).into(p20Var.u);
        }
        View view4 = p20Var.r;
        if (view4 != null) {
            view4.setOnClickListener(new a());
        }
        G();
    }

    public void C(MessageVo messageVo, q20 q20Var) {
        View view = q20Var.g;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = q20Var.h;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        LXPortraitView lXPortraitView = q20Var.i;
        if (lXPortraitView != null) {
            lXPortraitView.setVisibility(8);
        }
        View view3 = q20Var.j;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        ImageView imageView = q20Var.k;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = q20Var.c;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = q20Var.d;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        ChatGiftGuideCard chatGiftGuideCardZ = z(messageVo);
        TextView textView3 = q20Var.s;
        if (textView3 != null) {
            textView3.setText(chatGiftGuideCardZ.getTitleForShow());
            q20Var.s.setTextColor(chatGiftGuideCardZ.getTitleColor().intValue());
        }
        TextView textView4 = q20Var.t;
        if (textView4 != null) {
            textView4.setText(chatGiftGuideCardZ.getContentForShow());
        }
        if (q20Var.x != null) {
            hc2.a(this.f).load(chatGiftGuideCardZ.getUrlForShow()).error(R.drawable.ic_chat_flowers_buy_vip_gift_tips).into(q20Var.x);
        }
        if (q20Var.v != null) {
            if (TextUtils.isEmpty(chatGiftGuideCardZ.getBtnBgUrl())) {
                q20Var.v.setImageResource(R.drawable.bg_gift_chat_guide_btn);
            } else {
                hc2.a(this.f).load(chatGiftGuideCardZ.getBtnBgUrl()).error(R.drawable.bg_gift_chat_guide_btn).into(q20Var.v);
            }
        }
        TextView textView5 = q20Var.w;
        if (textView5 != null) {
            textView5.setText(chatGiftGuideCardZ.getBtnText());
            q20Var.w.setTextColor(chatGiftGuideCardZ.getBtnTextColor().intValue());
        }
        if (q20Var.u != null) {
            if (TextUtils.isEmpty(chatGiftGuideCardZ.getCardBgUrl())) {
                q20Var.u.setImageResource(R.drawable.bg_gift_chat_guid_card);
            } else {
                hc2.a(this.f).load(chatGiftGuideCardZ.getCardBgUrl()).error(R.drawable.bg_gift_chat_guid_card).into(q20Var.u);
            }
        }
        View view4 = q20Var.r;
        if (view4 != null) {
            view4.setOnClickListener(new c());
        }
        G();
    }

    public void D(MessageVo messageVo, q20 q20Var) {
        String str;
        View view = q20Var.g;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = q20Var.h;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        LXPortraitView lXPortraitView = q20Var.i;
        if (lXPortraitView != null) {
            lXPortraitView.setVisibility(8);
        }
        View view3 = q20Var.j;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        ImageView imageView = q20Var.k;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = q20Var.c;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = q20Var.d;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        ChatItem chatItemO = o();
        if (chatItemO == null || chatItemO.getChatType() != 0) {
            return;
        }
        ContactInfoItem contactInfoItem = (ContactInfoItem) chatItemO;
        ChatGiftGuideCard chatGiftGuideCardZ = z(messageVo);
        int i = chatGiftGuideCardZ != null ? chatGiftGuideCardZ.guideType : 0;
        String str2 = chatGiftGuideCardZ.giftName;
        int i2 = chatGiftGuideCardZ.giftPrice;
        int i3 = chatGiftGuideCardZ.giftId;
        String str3 = chatGiftGuideCardZ.giftIcon;
        String str4 = chatGiftGuideCardZ.subtitle;
        int i4 = i == 1 ? 5 : i == 2 ? 6 : 4;
        if (q20Var.s != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("点击送");
            sb.append(contactInfoItem.getGender() == 1 ? "她" : "他");
            sb.append("\"");
            sb.append(str2);
            sb.append("\"");
            q20Var.s.setText(sb.toString());
        }
        TextView textView3 = q20Var.y;
        if (textView3 != null) {
            textView3.setText(" " + i2);
        }
        TextView textView4 = q20Var.t;
        if (textView4 != null) {
            textView4.setText(str4);
        }
        if (q20Var.x != null) {
            hc2.a(this.f).load(str3).error(R.drawable.ic_chat_flowers_buy_vip_gift_tips).into(q20Var.x);
        }
        View view4 = q20Var.r;
        if (view4 != null) {
            view4.setOnClickListener(new b(str2, i2, i3, str3, chatGiftGuideCardZ, contactInfoItem, i4));
        }
        if (messageVo == null || (str = messageVo.mid) == null || this.i.containsKey(str)) {
            return;
        }
        H(chatGiftGuideCardZ);
        HashMap<String, String> map = this.i;
        String str5 = messageVo.mid;
        map.put(str5, str5);
    }

    public final void E() {
        zn6.j("gift_invite", "click", new e());
    }

    public final void F(ChatGiftGuideCard chatGiftGuideCard) {
        int iA = A(chatGiftGuideCard);
        HashMap map = new HashMap();
        map.put("type", Integer.valueOf(iA));
        q05.a("gift_invite_new", 2, map);
    }

    public final void G() {
        if (this.j) {
            return;
        }
        zn6.j("gift_invite", "view", new d());
        this.j = true;
    }

    public final void H(ChatGiftGuideCard chatGiftGuideCard) {
        int iA = A(chatGiftGuideCard);
        HashMap map = new HashMap();
        map.put("type", Integer.valueOf(iA));
        q05.a("gift_invite_new", 1, map);
    }

    @Override // defpackage.o40
    public int a() {
        return 45;
    }

    @Override // defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        if (20000 != messageVo.mimeType) {
            return null;
        }
        return y(messageVo) ? this.e.inflate(R.layout.list_item_chat_gift_tips_new, (ViewGroup) null) : this.e.inflate(R.layout.list_item_chat_gift_tips_b, (ViewGroup) null);
    }

    @Override // defpackage.o40
    public if6 c(View view) {
        return new q20(view);
    }

    @Override // defpackage.o40
    public int getViewTypeCount() {
        return 2;
    }

    @Override // defpackage.o40
    public <T extends if6> void l(T t, MessageVo messageVo) {
        if (!(t instanceof q20)) {
            B(messageVo, (p20) t);
            return;
        }
        q20 q20Var = (q20) t;
        if (y(messageVo)) {
            D(messageVo, q20Var);
        } else {
            C(messageVo, q20Var);
        }
    }

    @Override // defpackage.o40
    public int m(boolean z, int i, MessageVo messageVo) {
        if (i == 20000) {
            return y(messageVo) ? 46 : 45;
        }
        return -1;
    }

    @Override // com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter
    public ChatItem o() {
        return super.o();
    }

    public final boolean y(MessageVo messageVo) {
        if (TextUtils.isEmpty(messageVo.extention)) {
            return false;
        }
        try {
            ChatGiftGuideCard chatGiftGuideCard = (ChatGiftGuideCard) az2.a(messageVo.extention, ChatGiftGuideCard.class);
            if (chatGiftGuideCard != null) {
                return chatGiftGuideCard.isNewStyle;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final ChatGiftGuideCard z(MessageVo messageVo) {
        ChatGiftGuideCard chatGiftGuideCard = !TextUtils.isEmpty(messageVo.extention) ? (ChatGiftGuideCard) az2.a(messageVo.extention, ChatGiftGuideCard.class) : null;
        return chatGiftGuideCard == null ? GiftMessageHelper.F() : chatGiftGuideCard;
    }
}
