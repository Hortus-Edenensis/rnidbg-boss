package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.gift.GiftMessageHelper;
import com.zenmen.palmchat.chat.gift.ShowChatGiftPanelEvent;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.giftkit.chat.ChatGiftMessageExtensionBean;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class r20 extends SimpleChatViewAdapter {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f20379a;

        public a(MessageVo messageVo) {
            this.f20379a = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ds0.a().b(new ShowChatGiftPanelEvent(this.f20379a, r20.this.r().g(this.f20379a)));
            r20.this.z();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f20380a;
        public final /* synthetic */ MessageVo b;
        public final /* synthetic */ s20 c;

        public b(String str, MessageVo messageVo, s20 s20Var) {
            this.f20380a = str;
            this.b = messageVo;
            this.c = s20Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            q05.a("gift_recieve_thx", 2, null);
            if (r20.this.q() != null) {
                r20.this.q().D0(this.f20380a);
            }
            com.zenmen.palmchat.database.b.L(r20.this.o(), this.b, "");
            this.c.B.setVisibility(8);
        }
    }

    @Override // defpackage.o40
    public int a() {
        return 48;
    }

    @Override // defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        if (messageVo == null || 35 != messageVo.mimeType || !String.valueOf(1).equals(messageVo.data1)) {
            return null;
        }
        if (String.valueOf(1).equals(messageVo.data2) || String.valueOf(2).equals(messageVo.data2)) {
            return messageVo.isSend ? this.e.inflate(R.layout.list_item_single_chat_gift_card_right, (ViewGroup) null) : this.e.inflate(R.layout.list_item_single_chat_gift_card_left, (ViewGroup) null);
        }
        return null;
    }

    @Override // defpackage.o40
    public if6 c(View view) {
        return new s20(view);
    }

    @Override // defpackage.o40
    public int getViewTypeCount() {
        return 2;
    }

    @Override // defpackage.o40
    public <T extends if6> void l(T t, MessageVo messageVo) {
        y(messageVo, (s20) t);
    }

    @Override // defpackage.o40
    public int m(boolean z, int i, MessageVo messageVo) {
        if (messageVo == null || 35 != messageVo.mimeType || !String.valueOf(1).equals(messageVo.data1)) {
            return -1;
        }
        if (String.valueOf(1).equals(messageVo.data2) || String.valueOf(2).equals(messageVo.data2)) {
            return z ? 49 : 48;
        }
        return -1;
    }

    public final void x(s20 s20Var, MessageVo messageVo) {
        if (s20Var.B == null) {
            return;
        }
        if (!p05.c()) {
            s20Var.B.setVisibility(8);
            return;
        }
        if (o() == null || o().getChatType() != 0) {
            s20Var.B.setVisibility(8);
            return;
        }
        String str = messageVo.data3;
        if (TextUtils.isEmpty(str)) {
            s20Var.B.setVisibility(8);
            return;
        }
        s20Var.B.setVisibility(0);
        String str2 = "他";
        if ((o() instanceof ContactInfoItem) && ((ContactInfoItem) o()).getGender() == 1) {
            str2 = "她";
        }
        TextView textView = s20Var.C;
        if (textView != null) {
            textView.setText("收到" + str2 + "的心意，回复一个感谢吧：");
        }
        TextView textView2 = s20Var.D;
        if (textView2 != null) {
            textView2.setText("对" + str2 + "说：" + str);
            s20Var.D.setMaxWidth(me1.g() - me1.b(s20Var.D.getContext(), MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD));
        }
        TextView textView3 = s20Var.E;
        if (textView3 != null) {
            textView3.setOnClickListener(new b(str, messageVo, s20Var));
        }
        q05.a("gift_recieve_thx", 1, null);
    }

    public void y(MessageVo messageVo, s20 s20Var) {
        View view = s20Var.g;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = s20Var.h;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        q05.y(s20Var.r, Integer.valueOf(me1.g() - me1.b(s20Var.r.getContext(), 120)), null);
        TextView textView = s20Var.c;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = s20Var.d;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        ChatGiftMessageExtensionBean chatGiftMessageExtensionBeanQ = GiftMessageHelper.Q(messageVo.extention);
        if (chatGiftMessageExtensionBeanQ == null) {
            s20Var.r.setVisibility(8);
        } else {
            s20Var.r.setVisibility(0);
            if (o().getChatType() == 0) {
                s20Var.s.setVisibility(0);
                s20Var.s.setText(chatGiftMessageExtensionBeanQ.title);
                s20Var.x.setVisibility(8);
            } else {
                s20Var.s.setVisibility(8);
                s20Var.x.setVisibility(0);
                s20Var.y.setText("送给");
                if (chatGiftMessageExtensionBeanQ.toUser != null) {
                    Glide.with(this.f).load2(chatGiftMessageExtensionBeanQ.toUser.headIconUrl).error(R.drawable.default_portrait).into(s20Var.z);
                }
                s20Var.A.setText(chatGiftMessageExtensionBeanQ.itemCount + "份礼物");
            }
            s20Var.t.setText(chatGiftMessageExtensionBeanQ.subTitle);
            hc2.a(this.f).load(chatGiftMessageExtensionBeanQ.iconUrl).into(s20Var.v);
            s20Var.w.setVisibility(chatGiftMessageExtensionBeanQ.itemType != 11 ? 8 : 0);
            s20Var.u.setText(chatGiftMessageExtensionBeanQ.action);
            s20Var.r.setOnClickListener(new a(messageVo));
        }
        if (!messageVo.isSend) {
            o30.e(messageVo.from);
            x(s20Var, messageVo);
        } else {
            View view3 = s20Var.B;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        }
    }

    public final void z() {
        JSONObject jSONObject = new JSONObject();
        try {
            ChatItem chatItemO = o();
            jSONObject.put("report_type", "click");
            jSONObject.put("scene", 301);
            jSONObject.put("roomid", chatItemO.getChatId() + DomainHelper.m(chatItemO).domain);
            if (chatItemO.getChatType() == 1) {
                jSONObject.put("type", n20.h(r().getGroupItem()));
            }
            if (fu5.q(chatItemO.getBizType())) {
                jSONObject.put("bizType", chatItemO.getBizType() + AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("gift_card", null, jSONObject.toString());
    }
}
