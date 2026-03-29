package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.gift.ChatAmuletGuideCard;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.LXPortraitView;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class n10 extends SimpleChatViewAdapter {
    public boolean i;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatAmuletGuideCard f19409a;

        public a(ChatAmuletGuideCard chatAmuletGuideCard) {
            this.f19409a = chatAmuletGuideCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtil.i("ChatAmuletTipsChatViewAdapter", "" + az2.c(this.f19409a));
            if (l50.a()) {
                return;
            }
            n10.this.z();
            rk4.d(n10.this.r().getActivity(), 4, (ContactInfoItem) n10.this.o(), 1, this.f19409a.amuletid, 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {
        public b() {
            put("target_uid", n10.this.o().getChatId());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {
        public c() {
            put("target_uid", n10.this.o().getChatId());
        }
    }

    public final void A() {
        if (this.i) {
            return;
        }
        zn6.j("chat_amulet_sale", "view", new b());
        this.i = true;
    }

    @Override // defpackage.o40
    public int a() {
        return 45;
    }

    @Override // defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        if (20004 != messageVo.mimeType) {
            return null;
        }
        return this.e.inflate(R.layout.list_item_chat_amulet_tips, (ViewGroup) null);
    }

    @Override // defpackage.o40
    public if6 c(View view) {
        return new o10(view);
    }

    @Override // defpackage.o40
    public int getViewTypeCount() {
        return 1;
    }

    @Override // defpackage.o40
    public <T extends if6> void l(T t, MessageVo messageVo) {
        if (t instanceof o10) {
            y(messageVo, (o10) t);
        }
    }

    @Override // defpackage.o40
    public int m(boolean z, int i, MessageVo messageVo) {
        return i == 20004 ? 45 : -1;
    }

    @Override // com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter
    public ChatItem o() {
        return super.o();
    }

    public final ChatAmuletGuideCard x(MessageVo messageVo) {
        ChatAmuletGuideCard chatAmuletGuideCard;
        if (TextUtils.isEmpty(messageVo.extention) || (chatAmuletGuideCard = (ChatAmuletGuideCard) az2.a(messageVo.extention, ChatAmuletGuideCard.class)) == null) {
            return null;
        }
        return chatAmuletGuideCard;
    }

    public void y(MessageVo messageVo, o10 o10Var) {
        String str;
        String str2;
        View view = o10Var.g;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = o10Var.h;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        LXPortraitView lXPortraitView = o10Var.i;
        if (lXPortraitView != null) {
            lXPortraitView.setVisibility(8);
        }
        View view3 = o10Var.j;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        ImageView imageView = o10Var.k;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = o10Var.c;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = o10Var.d;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        ChatAmuletGuideCard chatAmuletGuideCardX = x(messageVo);
        if (chatAmuletGuideCardX == null) {
            return;
        }
        TextView textView3 = o10Var.s;
        if (textView3 != null && (str2 = chatAmuletGuideCardX.title) != null) {
            textView3.setText(str2);
        }
        TextView textView4 = o10Var.t;
        if (textView4 != null && (str = chatAmuletGuideCardX.content) != null) {
            textView4.setText(str);
        }
        o10Var.r.getPortraitView().setImageResource(R.drawable.ic_chat_amulet_guide_head);
        o10Var.r.setDecor(chatAmuletGuideCardX.getAmulet());
        View view4 = o10Var.u;
        if (view4 != null) {
            view4.setOnClickListener(new a(chatAmuletGuideCardX));
        }
        A();
    }

    public final void z() {
        zn6.j("chat_amulet_sale", "click", new c());
    }
}
