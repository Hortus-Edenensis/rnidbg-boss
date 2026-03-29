package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.aigreeting.AiGreetingContentItemView;
import com.zenmen.palmchat.chat.aigreeting.AiLoadingTextView;
import com.zenmen.palmchat.chat.aigreeting.vo.AiGreetingChatCardInfo;
import com.zenmen.palmchat.chat.aigreeting.vo.AiGreetingConfig;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class m10 extends SimpleChatViewAdapter {
    public boolean i;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            m10.this.r().o().l();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            m10.this.r().o().p();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn6.i("AiChat_quick_clickclose", b9.b(m10.this.o()));
            m10.this.r().o().w();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19120a;

        public d(String str) {
            this.f19120a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn6.i("AiChat_quick_clicksend", b9.b(m10.this.o()));
            m10.this.r().o().a(this.f19120a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends u10 {
        public View r;
        public View s;
        public TextView t;
        public View u;
        public AiLoadingTextView v;
        public View w;
        public View x;
        public TextView y;
        public ArrayList<AiGreetingContentItemView> z;

        public e(View view) {
            super(view);
            this.z = new ArrayList<>();
            this.r = view.findViewById(R.id.root);
            this.s = view.findViewById(R.id.close);
            this.v = (AiLoadingTextView) view.findViewById(R.id.state_content);
            this.u = view.findViewById(R.id.contentLayout);
            this.t = (TextView) view.findViewById(R.id.contentType);
            this.w = view.findViewById(R.id.refresh);
            this.y = (TextView) view.findViewById(R.id.remainTv);
            this.x = view.findViewById(R.id.remainLayout);
            this.z.add((AiGreetingContentItemView) view.findViewById(R.id.tv1));
            this.z.add((AiGreetingContentItemView) view.findViewById(R.id.tv2));
            this.z.add((AiGreetingContentItemView) view.findViewById(R.id.tv3));
        }

        @Override // defpackage.u10
        public boolean f() {
            return false;
        }
    }

    @Override // defpackage.o40
    public int a() {
        return 45;
    }

    @Override // defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        if (200010 != messageVo.mimeType) {
            return null;
        }
        return this.e.inflate(R.layout.list_item_chat_ai_greeting, (ViewGroup) null);
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
            w(messageVo, (e) t);
        }
    }

    @Override // defpackage.o40
    public int m(boolean z, int i, MessageVo messageVo) {
        return i == 200010 ? 45 : -1;
    }

    @Override // com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter
    public ChatItem o() {
        return super.o();
    }

    public void w(MessageVo messageVo, e eVar) {
        String str;
        if (r() == null || r().c() == null) {
            return;
        }
        AiGreetingChatCardInfo aiGreetingChatCardInfoC = r().c();
        eVar.r.setVisibility(0);
        AiGreetingConfig aiGreetingConfigC = b9.d().c();
        int iE = b9.d().e();
        if (aiGreetingConfigC.isNew && (str = aiGreetingConfigC.title) != null && str.contains(AiGreetingConfig.COUNT_FLAG)) {
            eVar.t.setVisibility(8);
            eVar.x.setVisibility(0);
            String strValueOf = String.valueOf(iE);
            if (iE == -999) {
                strValueOf = "无限";
            }
            eVar.y.setText(aiGreetingConfigC.title.replace(AiGreetingConfig.COUNT_FLAG, strValueOf));
        } else {
            eVar.t.setVisibility(0);
            eVar.x.setVisibility(8);
        }
        eVar.w.setVisibility(aiGreetingConfigC.update_button ? 0 : 8);
        eVar.w.setOnClickListener(new a());
        eVar.x.setOnClickListener(new b());
        eVar.s.setOnClickListener(new c());
        AiGreetingChatCardInfo.State state = aiGreetingChatCardInfoC.state;
        if (state == AiGreetingChatCardInfo.State.LOADING) {
            eVar.v.setVisibility(0);
            eVar.v.startLoading("生成中", null);
            eVar.u.setVisibility(8);
        } else if (state != AiGreetingChatCardInfo.State.SUCCESS || aiGreetingChatCardInfoC.textList == null) {
            eVar.v.setVisibility(0);
            eVar.v.stopLoading();
            eVar.v.setText("生成失败，刷新重试");
            eVar.u.setVisibility(8);
        } else {
            eVar.v.setVisibility(8);
            eVar.v.stopLoading();
            eVar.u.setVisibility(0);
            for (int i = 0; i < eVar.z.size(); i++) {
                AiGreetingContentItemView aiGreetingContentItemView = eVar.z.get(i);
                if (aiGreetingChatCardInfoC.textList.size() > i) {
                    String str2 = aiGreetingChatCardInfoC.textList.get(i);
                    aiGreetingContentItemView.setVisibility(0);
                    aiGreetingContentItemView.update(str2);
                    aiGreetingContentItemView.setOnClickListener(new d(str2));
                } else {
                    aiGreetingContentItemView.setVisibility(8);
                }
            }
        }
        x();
    }

    public final void x() {
        if (this.i) {
            return;
        }
        zn6.i("AiChat_quick_show", b9.b(o()));
        this.i = true;
    }
}
