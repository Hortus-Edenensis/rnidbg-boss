package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class it4 extends SimpleChatViewAdapter {
    public HashMap<Long, Boolean> i = new HashMap<>();
    public boolean j;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (fg6.d(AppContext.getContext())) {
                return;
            }
            HashMap map = new HashMap();
            map.put("vipstatus", String.valueOf(fg6.l(AppContext.getContext())));
            zn6.i("pagechat_msgstatus_click", map);
            ap3.a().V(it4.this.r().getActivity(), "68", "1", true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends u10 {
        public ImageView r;
        public TextView s;
        public View t;
        public View u;

        public b(View view) {
            super(view);
            this.r = (ImageView) view.findViewById(R.id.icon);
            this.s = (TextView) view.findViewById(R.id.text);
            this.t = view.findViewById(R.id.selectView);
            this.u = view.findViewById(R.id.contentLayout);
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
        if (12345 != messageVo.mimeType) {
            return null;
        }
        return this.e.inflate(R.layout.list_item_chat_read_state, (ViewGroup) null);
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
        return i == 12345 ? 45 : -1;
    }

    public void w(MessageVo messageVo, b bVar) {
        bVar.u.setOnClickListener(new a());
        if (fg6.d(AppContext.getContext())) {
            bVar.s.setVisibility(0);
            if (lt4.d().f(o(), messageVo.versionId)) {
                bVar.r.setImageResource(R.drawable.ic_read_state_read);
                bVar.s.setText("已读");
            } else {
                bVar.r.setImageResource(R.drawable.ic_read_state_unread);
                bVar.s.setText("送达");
            }
        } else {
            bVar.r.setImageResource(R.drawable.ic_read_state_unread);
            bVar.s.setVisibility(8);
        }
        if (r().o().i0()) {
            bVar.t.setVisibility(0);
        } else {
            bVar.t.setVisibility(8);
        }
        x();
    }

    public final void x() {
        if (this.j) {
            return;
        }
        HashMap map = new HashMap();
        map.put("vipstatus", String.valueOf(fg6.l(AppContext.getContext())));
        zn6.i("pagechat_msgstatus", map);
        this.j = true;
    }
}
