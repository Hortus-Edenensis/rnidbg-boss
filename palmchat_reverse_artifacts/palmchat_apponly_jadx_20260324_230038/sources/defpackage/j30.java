package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.chat.gift.quicksend.QuickSendVo;
import com.zenmen.palmchat.chat.intimacy.vo.IntimacyFreeGiftVo;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class j30 extends SimpleChatViewAdapter {
    public HashMap<Long, Boolean> i = new HashMap<>();
    public boolean j;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntimacyFreeGiftVo f18317a;
        public final /* synthetic */ MessageVo b;

        public a(IntimacyFreeGiftVo intimacyFreeGiftVo, MessageVo messageVo) {
            this.f18317a = intimacyFreeGiftVo;
            this.b = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            LogUtil.i("IntimacyManager", "on free gift click " + this.f18317a.giftVo);
            QuickSendVo quickSendVo = this.f18317a.giftVo;
            quickSendVo.intimacyGuideMid = this.b.mid;
            quickSendVo.isIntimacyFreeGift = true;
            j30.this.z();
            ChatterAdapter.h hVarO = j30.this.r().o();
            if (hVarO != null) {
                hVarO.g0(this.b, null, quickSendVo);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntimacyFreeGiftVo f18318a;
        public final /* synthetic */ MessageVo b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("giftid", Long.valueOf(b.this.f18318a.giftVo.itemId));
            }
        }

        public b(IntimacyFreeGiftVo intimacyFreeGiftVo, MessageVo messageVo) {
            this.f18318a = intimacyFreeGiftVo;
            this.b = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            LogUtil.i("IntimacyManager", "on free gift click " + this.f18318a.giftVo);
            QuickSendVo quickSendVo = this.f18318a.giftVo;
            quickSendVo.intimacyGuideMid = this.b.mid;
            quickSendVo.isIntimacyFreeGift = false;
            zn6.j("chatwindow_notfrd_gift", "click", new a());
            ChatterAdapter.h hVarO = j30.this.r().o();
            if (hVarO != null) {
                hVarO.g0(this.b, null, quickSendVo);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntimacyFreeGiftVo f18320a;

        public c(IntimacyFreeGiftVo intimacyFreeGiftVo) {
            this.f18320a = intimacyFreeGiftVo;
            put("giftid", Long.valueOf(intimacyFreeGiftVo.giftVo.itemId));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {
        public d() {
            put("target_uid", j30.this.o().getChatId());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {
        public e() {
            put("target_uid", j30.this.o().getChatId());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f extends u10 {
        public ImageView r;
        public TextView s;
        public TextView t;
        public ViewGroup u;

        public f(View view) {
            super(view);
            this.r = (ImageView) view.findViewById(R.id.icon);
            this.s = (TextView) view.findViewById(R.id.sys_notify_textview);
            this.t = (TextView) view.findViewById(R.id.tip_text);
            this.u = (ViewGroup) view.findViewById(R.id.mContainer);
        }

        @Override // defpackage.u10
        public boolean f() {
            return false;
        }
    }

    public final void A() {
        if (this.j) {
            return;
        }
        zn6.j("chatwindow_intimacy_gift", "view", new d());
        this.j = true;
    }

    public final void B(MessageVo messageVo) {
        IntimacyFreeGiftVo intimacyFreeGiftVoX = x(messageVo);
        if (intimacyFreeGiftVoX == null || intimacyFreeGiftVoX.giftVo == null || this.i.containsKey(Long.valueOf(messageVo._id))) {
            return;
        }
        zn6.j("chatwindow_notfrd_gift", "view", new c(intimacyFreeGiftVoX));
        this.i.put(Long.valueOf(messageVo._id), Boolean.TRUE);
    }

    @Override // defpackage.o40
    public int a() {
        return 45;
    }

    @Override // defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        if (200006 != messageVo.mimeType) {
            return null;
        }
        return this.e.inflate(R.layout.list_item_chat_intimacy_free_gift, (ViewGroup) null);
    }

    @Override // defpackage.o40
    public if6 c(View view) {
        return new f(view);
    }

    @Override // defpackage.o40
    public int getViewTypeCount() {
        return 1;
    }

    @Override // defpackage.o40
    public <T extends if6> void l(T t, MessageVo messageVo) {
        if (t instanceof f) {
            y(messageVo, (f) t);
        }
    }

    @Override // defpackage.o40
    public int m(boolean z, int i, MessageVo messageVo) {
        return i == 200006 ? 45 : -1;
    }

    @Override // com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter
    public ChatItem o() {
        return super.o();
    }

    public final IntimacyFreeGiftVo x(MessageVo messageVo) {
        IntimacyFreeGiftVo intimacyFreeGiftVo;
        if (TextUtils.isEmpty(messageVo.extention) || (intimacyFreeGiftVo = (IntimacyFreeGiftVo) az2.a(messageVo.extention, IntimacyFreeGiftVo.class)) == null) {
            return null;
        }
        return intimacyFreeGiftVo;
    }

    public void y(MessageVo messageVo, f fVar) {
        IntimacyFreeGiftVo intimacyFreeGiftVoX = x(messageVo);
        if (intimacyFreeGiftVoX == null || intimacyFreeGiftVoX.giftVo == null) {
            return;
        }
        fVar.u.setVisibility(8);
        int i = intimacyFreeGiftVoX.type;
        if (i == 0) {
            fVar.u.setVisibility(0);
            fVar.t.setVisibility(8);
            Glide.with(this.f).load2(intimacyFreeGiftVoX.giftVo.iconUrl).error(R.drawable.ic_intimacy_free_gift_default).into(fVar.r);
            fVar.s.setText(intimacyFreeGiftVoX.text);
            fVar.r.setOnClickListener(new a(intimacyFreeGiftVoX, messageVo));
            fVar.s.setOnClickListener(null);
            A();
            return;
        }
        if (i == 1) {
            ChatItem chatItemO = o();
            if (chatItemO.getChatType() != 0 || ((ContactInfoItem) chatItemO).getIsStranger()) {
                fVar.u.setVisibility(0);
                fVar.t.setVisibility(0);
                Glide.with(this.f).load2(intimacyFreeGiftVoX.giftVo.iconUrl).error(R.drawable.ic_intimacy_free_gift_default).into(fVar.r);
                fVar.s.setText(TextUtils.isEmpty(intimacyFreeGiftVoX.text) ? "点击立即送出" : intimacyFreeGiftVoX.text);
                fVar.t.setText(intimacyFreeGiftVoX.giftLabel);
                b bVar = new b(intimacyFreeGiftVoX, messageVo);
                fVar.r.setOnClickListener(bVar);
                fVar.s.setOnClickListener(bVar);
                B(messageVo);
            }
        }
    }

    public final void z() {
        zn6.j("chatwindow_intimacy_gift", "click", new e());
    }
}
