package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class t8 extends SimpleChatViewAdapter {
    public ChatItem i;
    public ContactInfoItem j;
    public long k;
    public long l;
    public int m;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a() || t8.this.q() == null || t8.this.p() == null) {
                return;
            }
            t8.this.q().q0(t8.this.p());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f20920a;
        public final /* synthetic */ int b;

        public b(String str, int i) {
            this.f20920a = str;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            v8.n(this.f20920a, "click", t8.this.n());
            t8 t8Var = t8.this;
            v8.N(t8Var.f, 190102, t8Var.k, t8.this.l, t8.this.m, this.b);
        }
    }

    @Override // defpackage.o40
    public int a() {
        return 45;
    }

    @Override // defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        if (65 != messageVo.mimeType) {
            return null;
        }
        return this.e.inflate(R.layout.layout_aichat_chat_item, (ViewGroup) null);
    }

    @Override // defpackage.o40
    public if6 c(View view) {
        return new u8(view);
    }

    @Override // defpackage.o40
    public int getViewTypeCount() {
        return 1;
    }

    @Override // defpackage.o40
    public <T extends if6> void l(T t, MessageVo messageVo) {
        z(messageVo, (u8) t);
    }

    @Override // defpackage.o40
    public int m(boolean z, int i, MessageVo messageVo) {
        if (i != 65) {
            return -1;
        }
        LogUtil.d("AiChatPeopleManagerTag", "AiChatGuardViewAdapter getItemViewType mimeType is MESSAGE_TYPE_AI_CHAT_CARD");
        return 45;
    }

    public void z(MessageVo messageVo, u8 u8Var) {
        LogUtil.d("AiChatPeopleManagerTag", "AiChatGuardViewAdapter handleTextMessage start");
        View view = u8Var.g;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = u8Var.h;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = u8Var.j;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        ImageView imageView = u8Var.k;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = u8Var.c;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = u8Var.d;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        this.i = o();
        String strP = AccountUtils.p(AppContext.getContext());
        this.j = bo0.r().l(strP);
        try {
            ChatItem chatItem = this.i;
            if (chatItem != null) {
                String iconURL = chatItem.getIconURL();
                if (!TextUtils.isEmpty(iconURL)) {
                    u8Var.i.setAvatarView(iconURL, null);
                    u8Var.i.setOnClickListener(new a());
                    Glide.with(this.f).load2(iconURL).error(R.drawable.default_portrait).into(u8Var.s);
                }
                ContactInfoItem contactInfoItem = this.j;
                if (contactInfoItem != null && !TextUtils.isEmpty(contactInfoItem.getIconURL())) {
                    Glide.with(this.f).load2(this.j.getIconURL()).error(R.drawable.default_portrait).into(u8Var.r);
                }
                String chatName = this.i.getChatName();
                if (!TextUtils.isEmpty(chatName)) {
                    u8Var.t.setText("守护" + chatName);
                }
                String chatId = this.i.getChatId();
                int bizType = this.i.getBizType();
                this.m = this.j.getGender();
                if (n() == 1) {
                    u8Var.v.setText("查看守护");
                } else {
                    u8Var.v.setText("去解锁");
                }
                if (!TextUtils.isEmpty(strP) && !TextUtils.isEmpty(chatId)) {
                    this.l = Long.parseLong(strP);
                    this.k = Long.parseLong(chatId);
                }
                u8Var.x.setOnClickListener(new b(chatId, bizType));
                v8.n(chatId, "view", n());
            }
        } catch (Exception unused) {
        }
    }
}
