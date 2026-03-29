package defpackage;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.InputFragment;
import com.zenmen.palmchat.chat.mate.ChatMateActivityStatusData;
import com.zenmen.palmchat.chat.mate.ChatMateRoomTypeData;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class p30 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19925a;
    public ChatItem b;
    public ChatterActivity c;
    public boolean d;
    public InputFragment e;
    public String f;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f19926a;
        public final /* synthetic */ m30 b;

        public a(int i, m30 m30Var) {
            this.f19926a = i;
            this.b = m30Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatMateRoomTypeData chatMateRoomTypeDataL;
            int i = this.f19926a;
            if (i == 3) {
                String str = this.b.c;
                ChatMateRoomTypeData chatMateRoomTypeDataL2 = o30.l(v4.e(AppContext.getContext()));
                if (chatMateRoomTypeDataL2 == null || TextUtils.isEmpty(str) || !str.equals(chatMateRoomTypeDataL2.roomId)) {
                    return;
                }
                p30.this.f19925a = false;
                if (p30.this.e != null) {
                    p30.this.e.a2(false);
                    return;
                }
                return;
            }
            if (i != 6) {
                if (i == 7) {
                    p30.this.j();
                    return;
                }
                return;
            }
            String str2 = this.b.d;
            if (TextUtils.isEmpty(str2) || (chatMateRoomTypeDataL = o30.l(str2)) == null) {
                return;
            }
            String str3 = chatMateRoomTypeDataL.roomId;
            int i2 = chatMateRoomTypeDataL.type;
            if (TextUtils.isEmpty(str3) || i2 != 1 || p30.this.e == null) {
                return;
            }
            p30.this.e.u3(this.b.f);
            p30.this.e.S2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements sk2 {
        public b() {
        }

        @Override // defpackage.sk2
        public void onSuccess(Object obj) {
            p30.this.h(obj);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f19928a;

        public c(MaterialDialog materialDialog) {
            this.f19928a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            this.f19928a.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f19929a;

        public d(MaterialDialog materialDialog) {
            this.f19929a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            this.f19929a.dismiss();
            o30.w(p30.this.b, p30.this.f);
        }
    }

    public p30(g50 g50Var) {
        this.c = g50Var.getActivity();
        this.b = g50Var.b();
        this.e = g50Var.g();
        if (o30.s() && !o30.t()) {
            this.f19925a = o30.q(this.b.getChatId()) && !this.c.s;
        }
        LogUtil.d("ChatMateGiftManagerTAG", "roomDataCheck ChattActivity 判断isChatMate " + this.f19925a);
        ds0.a().c(this);
    }

    @qm5
    public void chatMateEvent(m30 m30Var) {
        if (m30Var != null) {
            int i = m30Var.b;
            LogUtil.d("ChatMateGiftManagerTAG", "ChatActivity chatMateEvent type " + i);
            u93.c(new a(i, m30Var));
        }
    }

    public void g() {
        if (this.f19925a) {
            LogUtil.d("ChatMateGiftManagerTAG", "roomDataCheck ChatAdapter checkChatMateStatus判断 chatMateLoadSuccess " + this.d);
            if (this.d) {
                return;
            }
            this.d = true;
            o30.v(v4.e(AppContext.getContext()), new b());
        }
    }

    public final void h(Object obj) {
        if (obj instanceof ChatMateActivityStatusData) {
            ChatMateActivityStatusData chatMateActivityStatusData = (ChatMateActivityStatusData) obj;
            this.f = chatMateActivityStatusData.roomId;
            this.f19925a = true;
            InputFragment inputFragment = this.e;
            if (inputFragment != null) {
                inputFragment.V2(chatMateActivityStatusData);
                this.e.a2(this.f19925a);
            }
            if (this.c.q3() == 1) {
                j();
            }
            LogUtil.d("ChatMateGiftManagerTAG", "ChatterActivity onChatMateStatus success end");
            o30.j(chatMateActivityStatusData.type, this.c.p3(), v4.e(AppContext.getContext()), this.b.getChatId(), chatMateActivityStatusData.roomId);
        }
    }

    public void i() {
        try {
            ds0.a().d(this);
        } catch (Exception unused) {
        }
    }

    public final void j() {
        View viewInflate = View.inflate(this.c, R.layout.chat_mate_send_gift_dialog, null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.gift_send_text);
        if (!TextUtils.isEmpty(o30.F)) {
            textView.setText(o30.F);
        }
        MaterialDialog materialDialogE = new sd3(this.c).p(viewInflate, false).v(true).d(R.color.transparent).h(false).e();
        materialDialogE.show();
        viewInflate.findViewById(R.id.mate_dialog_cancel).setOnClickListener(new c(materialDialogE));
        viewInflate.findViewById(R.id.mate_dialog_confirm).setOnClickListener(new d(materialDialogE));
    }
}
