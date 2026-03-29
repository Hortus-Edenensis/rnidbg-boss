package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import com.zenmen.palmchat.contacts.ContactInfoItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class d40 extends SimpleChatViewAdapter {
    public boolean i = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f16970a;

        public a(MessageVo messageVo) {
            this.f16970a = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            d40.this.y();
            ChatItem chatItemO = d40.this.o();
            if (chatItemO == null || chatItemO.getChatType() != 0) {
                return;
            }
            String str = this.f16970a.text;
            if (d40.this.q() != null) {
                d40.this.q().D0(str);
            }
        }
    }

    @Override // defpackage.o40
    public int a() {
        return 46;
    }

    @Override // defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        if (30000 != messageVo.mimeType) {
            return null;
        }
        return this.e.inflate(R.layout.list_item_chat_receive_gift_tip, (ViewGroup) null);
    }

    @Override // defpackage.o40
    public if6 c(View view) {
        return new e40(view);
    }

    @Override // defpackage.o40
    public int getViewTypeCount() {
        return 1;
    }

    @Override // defpackage.o40
    public <T extends if6> void l(T t, MessageVo messageVo) {
        x(messageVo, (e40) t);
    }

    @Override // defpackage.o40
    public int m(boolean z, int i, MessageVo messageVo) {
        return i == 30000 ? 46 : -1;
    }

    public void x(MessageVo messageVo, e40 e40Var) {
        ChatItem chatItemO = o();
        String str = "他";
        if (chatItemO != null && chatItemO.getChatType() == 0 && ((ContactInfoItem) chatItemO).getGender() == 1) {
            str = "她";
        }
        TextView textView = e40Var.t;
        if (textView != null) {
            textView.setText("收到" + str + "的心意，回复一个感谢吧：");
        }
        if (e40Var.u != null) {
            String str2 = messageVo.text;
            if (!TextUtils.isEmpty(str2)) {
                e40Var.u.setText("对" + str + "说：" + str2);
            }
        }
        TextView textView2 = e40Var.v;
        if (textView2 != null) {
            textView2.setOnClickListener(new a(messageVo));
        }
        z();
    }

    public final void y() {
        q05.a("gift_recieve_thx", 2, null);
    }

    public final void z() {
        if (this.i) {
            return;
        }
        q05.a("gift_recieve_thx", 1, null);
        this.i = true;
    }
}
