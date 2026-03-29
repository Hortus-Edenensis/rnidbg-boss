package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.gift.ChatAmuletMessageExtensionBean;
import com.zenmen.palmchat.chat.gift.GiftMessageHelper;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class p10 extends SimpleChatViewAdapter {
    public boolean i;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f19914a;
        public final /* synthetic */ ChatAmuletMessageExtensionBean b;

        public a(MessageVo messageVo, ChatAmuletMessageExtensionBean chatAmuletMessageExtensionBean) {
            this.f19914a = messageVo;
            this.b = chatAmuletMessageExtensionBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p10 p10Var = p10.this;
            boolean z = this.f19914a.isSend;
            ChatAmuletMessageExtensionBean chatAmuletMessageExtensionBean = this.b;
            p10Var.A(false, z, chatAmuletMessageExtensionBean.itemId, chatAmuletMessageExtensionBean.ornamentId);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f19915a;
        public final /* synthetic */ ChatAmuletMessageExtensionBean b;

        public b(MessageVo messageVo, ChatAmuletMessageExtensionBean chatAmuletMessageExtensionBean) {
            this.f19915a = messageVo;
            this.b = chatAmuletMessageExtensionBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p10 p10Var = p10.this;
            boolean z = this.f19915a.isSend;
            ChatAmuletMessageExtensionBean chatAmuletMessageExtensionBean = this.b;
            p10Var.A(false, z, chatAmuletMessageExtensionBean.itemId, chatAmuletMessageExtensionBean.ornamentId);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f19916a;
        public final /* synthetic */ ChatAmuletMessageExtensionBean b;

        public c(MessageVo messageVo, ChatAmuletMessageExtensionBean chatAmuletMessageExtensionBean) {
            this.f19916a = messageVo;
            this.b = chatAmuletMessageExtensionBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p10 p10Var = p10.this;
            boolean z = this.f19916a.isSend;
            ChatAmuletMessageExtensionBean chatAmuletMessageExtensionBean = this.b;
            p10Var.A(true, z, chatAmuletMessageExtensionBean.itemId, chatAmuletMessageExtensionBean.ornamentId);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {
        public d() {
            put("target_uid", p10.this.o().getChatId());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {
        public e() {
            put("target_uid", p10.this.o().getChatId());
        }
    }

    public final void A(boolean z, boolean z2, int i, int i2) {
        if (l50.a()) {
            return;
        }
        rk4.d(r().getActivity(), z2 ? 5 : 6, (ContactInfoItem) o(), z ? 2 : 1, i, i2);
        y(z2);
    }

    @Override // defpackage.o40
    public int a() {
        return 51;
    }

    @Override // defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        if (messageVo != null && 35 == messageVo.mimeType && String.valueOf(1).equals(messageVo.data1) && String.valueOf(3).equals(messageVo.data2)) {
            return messageVo.isSend ? this.e.inflate(R.layout.list_item_single_chat_amulet_card_right, (ViewGroup) null) : this.e.inflate(R.layout.list_item_single_chat_amulet_card_left, (ViewGroup) null);
        }
        return null;
    }

    @Override // defpackage.o40
    public if6 c(View view) {
        return new q10(view);
    }

    @Override // defpackage.o40
    public int getViewTypeCount() {
        return 2;
    }

    @Override // defpackage.o40
    public <T extends if6> void l(T t, MessageVo messageVo) {
        x(messageVo, (q10) t);
    }

    @Override // defpackage.o40
    public int m(boolean z, int i, MessageVo messageVo) {
        if (messageVo != null && 35 == messageVo.mimeType && String.valueOf(1).equals(messageVo.data1) && String.valueOf(3).equals(messageVo.data2)) {
            return z ? 52 : 51;
        }
        return -1;
    }

    public void x(MessageVo messageVo, q10 q10Var) {
        View view = q10Var.g;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = q10Var.h;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = q10Var.j;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        ImageView imageView = q10Var.k;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = q10Var.c;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = q10Var.d;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        ChatAmuletMessageExtensionBean chatAmuletMessageExtensionBeanP = GiftMessageHelper.P(messageVo.extention);
        if (chatAmuletMessageExtensionBeanP == null) {
            q10Var.r.setVisibility(8);
        } else {
            q10Var.r.setVisibility(0);
            q10Var.s.setVisibility(0);
            q10Var.s.setText(chatAmuletMessageExtensionBeanP.title);
            q10Var.t.setText(chatAmuletMessageExtensionBeanP.subTitle);
            q10Var.w.getPortraitView().setImageResource(R.drawable.ic_chat_msg_amulet_head);
            q10Var.w.setDecor(chatAmuletMessageExtensionBeanP.getAmulet());
            q10Var.r.setOnClickListener(new a(messageVo, chatAmuletMessageExtensionBeanP));
            TextView textView3 = q10Var.u;
            if (textView3 != null) {
                textView3.setOnClickListener(new b(messageVo, chatAmuletMessageExtensionBeanP));
            }
            TextView textView4 = q10Var.v;
            if (textView4 != null) {
                textView4.setOnClickListener(new c(messageVo, chatAmuletMessageExtensionBeanP));
            }
        }
        z(messageVo.isSend);
    }

    public final void y(boolean z) {
        zn6.j(z ? "chat_amulet_send" : "chat_amulet_recieve", "click", new e());
    }

    public final void z(boolean z) {
        if (this.i) {
            return;
        }
        zn6.j(z ? "chat_amulet_send" : "chat_amulet_recieve", "view", new d());
        this.i = true;
    }
}
