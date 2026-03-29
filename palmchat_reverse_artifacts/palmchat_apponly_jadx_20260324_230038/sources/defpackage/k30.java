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
import com.zenmen.palmchat.chat.intimacy.vo.IntimacyChatTextGuideVo;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import com.zenmen.palmchat.widget.LXPortraitView;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class k30 extends SimpleChatViewAdapter {
    public boolean i;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntimacyChatTextGuideVo f18562a;
        public final /* synthetic */ MessageVo b;

        public a(IntimacyChatTextGuideVo intimacyChatTextGuideVo, MessageVo messageVo) {
            this.f18562a = intimacyChatTextGuideVo;
            this.b = messageVo;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            QuickSendVo quickSendVo;
            String str;
            ChatterAdapter.h hVarO;
            if (l50.a()) {
                return;
            }
            String str2 = null;
            if (view.getId() == R.id.send1) {
                str = this.f18562a.list.get(0);
            } else if (view.getId() == R.id.send2) {
                str = this.f18562a.list.get(1);
            } else {
                if (view.getId() != R.id.send3) {
                    quickSendVo = view.getId() == R.id.giftSend1 ? this.f18562a.giftList.get(0) : view.getId() == R.id.giftSend2 ? this.f18562a.giftList.get(1) : view.getId() == R.id.giftSend3 ? this.f18562a.giftList.get(2) : null;
                    k30.this.C(str2, quickSendVo);
                    hVarO = k30.this.r().o();
                    if (hVarO == null) {
                        hVarO.g0(this.b, str2, quickSendVo);
                        return;
                    }
                    return;
                }
                str = this.f18562a.list.get(2);
            }
            str2 = str;
            quickSendVo = null;
            k30.this.C(str2, quickSendVo);
            hVarO = k30.this.r().o();
            if (hVarO == null) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {
        public b() {
            put("target_uid", k30.this.o().getChatId());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18564a;

        public c(boolean z) {
            this.f18564a = z;
            put("target_uid", k30.this.o().getChatId());
            put("type", Integer.valueOf(z ? 2 : 1));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18565a;
        public final /* synthetic */ QuickSendVo b;
        public final /* synthetic */ String c;

        public d(int i, QuickSendVo quickSendVo, String str) {
            this.f18565a = i;
            this.b = quickSendVo;
            this.c = str;
            put("target_uid", k30.this.o().getChatId());
            put("type", Integer.valueOf(i));
            put("content", i == 1 ? Long.valueOf(quickSendVo.itemId) : str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e extends u10 {
        public a A;
        public a B;
        public a C;
        public TextView D;
        public TextView E;
        public TextView F;
        public View r;
        public TextView s;
        public TextView t;
        public TextView u;
        public TextView v;
        public TextView w;
        public TextView x;
        public TextView y;
        public View z;

        /* JADX INFO: compiled from: SearchBox */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public ImageView f18566a;
            public TextView b;
            public TextView c;
            public TextView d;

            public a(ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
                this.f18566a = imageView;
                this.b = textView;
                this.c = textView2;
                this.d = textView3;
            }
        }

        public e(View view) {
            super(view);
            this.r = view.findViewById(R.id.textLayout);
            this.y = (TextView) view.findViewById(R.id.sys_notify_textview_intimacy);
            this.s = (TextView) view.findViewById(R.id.tv1);
            this.t = (TextView) view.findViewById(R.id.tv2);
            this.u = (TextView) view.findViewById(R.id.tv3);
            this.v = (TextView) view.findViewById(R.id.send1);
            this.w = (TextView) view.findViewById(R.id.send2);
            this.x = (TextView) view.findViewById(R.id.send3);
            this.z = view.findViewById(R.id.giftLayout);
            this.A = new a((ImageView) view.findViewById(R.id.giftIcon1), (TextView) view.findViewById(R.id.giftPrice1), (TextView) view.findViewById(R.id.giftTitle1), (TextView) view.findViewById(R.id.giftScore1));
            this.B = new a((ImageView) view.findViewById(R.id.giftIcon2), (TextView) view.findViewById(R.id.giftPrice2), (TextView) view.findViewById(R.id.giftTitle2), (TextView) view.findViewById(R.id.giftScore2));
            this.C = new a((ImageView) view.findViewById(R.id.giftIcon3), (TextView) view.findViewById(R.id.giftPrice3), (TextView) view.findViewById(R.id.giftTitle3), (TextView) view.findViewById(R.id.giftScore3));
            this.D = (TextView) view.findViewById(R.id.giftSend1);
            this.E = (TextView) view.findViewById(R.id.giftSend2);
            this.F = (TextView) view.findViewById(R.id.giftSend3);
        }

        @Override // defpackage.u10
        public boolean f() {
            return true;
        }
    }

    public final IntimacyChatTextGuideVo A(MessageVo messageVo) {
        IntimacyChatTextGuideVo intimacyChatTextGuideVo;
        if (TextUtils.isEmpty(messageVo.extention) || (intimacyChatTextGuideVo = (IntimacyChatTextGuideVo) az2.a(messageVo.extention, IntimacyChatTextGuideVo.class)) == null) {
            return null;
        }
        return intimacyChatTextGuideVo;
    }

    public void B(MessageVo messageVo, e eVar) {
        int i;
        List<QuickSendVo> list;
        List<String> list2;
        View view = eVar.g;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = eVar.h;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        LXPortraitView lXPortraitView = eVar.i;
        if (lXPortraitView != null) {
            lXPortraitView.setVisibility(8);
        }
        View view3 = eVar.j;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        ImageView imageView = eVar.k;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = eVar.c;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = eVar.d;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        t(messageVo, eVar.y);
        IntimacyChatTextGuideVo intimacyChatTextGuideVoA = A(messageVo);
        if (intimacyChatTextGuideVoA == null || (i = intimacyChatTextGuideVoA.type) == IntimacyChatTextGuideVo.TYPE_NONE || ((i == IntimacyChatTextGuideVo.TYPE_TEXT && ((list2 = intimacyChatTextGuideVoA.list) == null || list2.size() < 3)) || (intimacyChatTextGuideVoA.type == IntimacyChatTextGuideVo.TYPE_GIFT && ((list = intimacyChatTextGuideVoA.giftList) == null || list.size() < 3)))) {
            eVar.r.setVisibility(8);
            eVar.z.setVisibility(8);
            D(eVar);
            return;
        }
        a aVar = new a(intimacyChatTextGuideVoA, messageVo);
        int i2 = intimacyChatTextGuideVoA.type;
        if (i2 == IntimacyChatTextGuideVo.TYPE_TEXT) {
            eVar.r.setVisibility(0);
            eVar.z.setVisibility(8);
            z(eVar, intimacyChatTextGuideVoA);
            eVar.v.setOnClickListener(aVar);
            eVar.w.setOnClickListener(aVar);
            eVar.x.setOnClickListener(aVar);
        } else if (i2 == IntimacyChatTextGuideVo.TYPE_GIFT) {
            eVar.r.setVisibility(8);
            eVar.z.setVisibility(0);
            x(eVar, intimacyChatTextGuideVoA);
            eVar.D.setOnClickListener(aVar);
            eVar.E.setOnClickListener(aVar);
            eVar.F.setOnClickListener(aVar);
        }
        D(eVar);
    }

    public final void C(String str, QuickSendVo quickSendVo) {
        zn6.j("chatwindow_intimacy_card", "click", new d(TextUtils.isEmpty(str) ? 1 : 2, quickSendVo, str));
    }

    public final void D(e eVar) {
        if (this.i) {
            return;
        }
        zn6.j("chatwindow_intimacy_txt", "view", new b());
        boolean z = eVar.r.getVisibility() == 0;
        boolean z2 = eVar.z.getVisibility() == 0;
        if (z || z2) {
            zn6.j("chatwindow_intimacy_card", "view", new c(z));
        }
        this.i = true;
    }

    @Override // defpackage.o40
    public int a() {
        return 45;
    }

    @Override // defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        if (200005 != messageVo.mimeType) {
            return null;
        }
        return this.e.inflate(R.layout.list_item_chat_intimacy_text_guide, (ViewGroup) null);
    }

    @Override // defpackage.o40
    public if6 c(View view) {
        return new e(view);
    }

    @Override // defpackage.o40
    public int getViewTypeCount() {
        return 1;
    }

    @Override // defpackage.o40
    public <T extends if6> void l(T t, MessageVo messageVo) {
        if (t instanceof e) {
            B(messageVo, (e) t);
        }
    }

    @Override // defpackage.o40
    public int m(boolean z, int i, MessageVo messageVo) {
        return i == 200005 ? 45 : -1;
    }

    @Override // com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter
    public ChatItem o() {
        return super.o();
    }

    public void x(e eVar, IntimacyChatTextGuideVo intimacyChatTextGuideVo) {
        y(eVar.A, intimacyChatTextGuideVo.giftList.get(0));
        y(eVar.B, intimacyChatTextGuideVo.giftList.get(1));
        y(eVar.C, intimacyChatTextGuideVo.giftList.get(2));
    }

    public final void y(e.a aVar, QuickSendVo quickSendVo) {
        Glide.with(this.f).load2(quickSendVo.iconUrl).error(R.drawable.ic_chat_input_header_panel_gift).into(aVar.f18566a);
        aVar.b.setText(String.valueOf(quickSendVo.realPrice));
        aVar.c.setText(quickSendVo.itemName);
        aVar.d.setText(quickSendVo.supportTitle);
    }

    public final void z(e eVar, IntimacyChatTextGuideVo intimacyChatTextGuideVo) {
        eVar.s.setText(intimacyChatTextGuideVo.list.get(0));
        eVar.t.setText(intimacyChatTextGuideVo.list.get(1));
        eVar.u.setText(intimacyChatTextGuideVo.list.get(2));
    }
}
