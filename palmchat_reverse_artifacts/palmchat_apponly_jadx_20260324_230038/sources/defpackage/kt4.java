package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import com.zenmen.palmchat.paidservices.readstate.guide.ReadStateGuideManager;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class kt4 extends SimpleChatViewAdapter {
    public HashMap<Long, Boolean> i = new HashMap<>();
    public boolean j;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f18827a;

        public a(MessageVo messageVo) {
            this.f18827a = messageVo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zD = fg6.d(AppContext.getContext());
            HashMap map = new HashMap();
            map.put("vipstatus", String.valueOf(fg6.l(AppContext.getContext())));
            map.put("scene", this.f18827a.data2);
            zn6.h("pagechat_msgstatus_sysmsg", "click", map);
            ReadStateGuideManager.Scene scene = ReadStateGuideManager.Scene.getScene(this.f18827a.data2);
            if (zD) {
                ry5.a("尊贵的超级会员，消息已读状态持续为您更新中~");
            } else {
                ap3.a().V(kt4.this.r().getActivity(), String.valueOf(scene.from), "1", true);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends u10 {
        public TextView r;
        public View s;

        public b(View view) {
            super(view);
            this.r = (TextView) view.findViewById(R.id.text);
            this.s = view.findViewById(R.id.contentLayout);
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
        if (12346 != messageVo.mimeType) {
            return null;
        }
        return this.e.inflate(R.layout.list_item_chat_read_state_guide, (ViewGroup) null);
    }

    @Override // defpackage.o40
    public if6 c(View view) {
        return new b(view);
    }

    @Override // defpackage.o40
    public int getViewTypeCount() {
        return 1;
    }

    @Override // defpackage.o40
    public <T extends if6> void l(T t, MessageVo messageVo) {
        if (t instanceof b) {
            w(messageVo, (b) t);
        }
    }

    @Override // defpackage.o40
    public int m(boolean z, int i, MessageVo messageVo) {
        return i == 12346 ? 45 : -1;
    }

    public void w(MessageVo messageVo, b bVar) {
        bVar.r.setText(messageVo.text);
        bVar.s.setOnClickListener(new a(messageVo));
        x(messageVo);
    }

    public final void x(MessageVo messageVo) {
        if (this.j) {
            return;
        }
        HashMap map = new HashMap();
        map.put("vipstatus", String.valueOf(fg6.l(AppContext.getContext())));
        map.put("scene", messageVo.data2);
        zn6.h("pagechat_msgstatus_sysmsg", "view", map);
        this.j = true;
    }
}
