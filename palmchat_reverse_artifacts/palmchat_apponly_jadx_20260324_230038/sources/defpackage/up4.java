package defpackage;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.voiceroom.adapter.RcyHolder;
import com.zenmen.palmchat.voiceroom.adapter.RcySAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class up4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f21265a;
    public ChatItem b;
    public c e;
    public RcySAdapter<String, RcyHolder> c = null;
    public boolean d = false;
    public boolean f = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends RcySAdapter<String, RcyHolder> {

        /* JADX INFO: renamed from: up4$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1278a extends ArrayList<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f21266a;

            public C1278a(String str) {
                this.f21266a = str;
                add(str);
            }
        }

        public a(Context context, int i) {
            super(context, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(String str, View view) {
            if (up4.this.e == null || l50.a()) {
                return;
            }
            up4.this.f = true;
            up4.this.e.a(str);
            up4.this.h("click", new C1278a(str));
        }

        @Override // com.zenmen.palmchat.voiceroom.adapter.RcySAdapter
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void h(RcyHolder rcyHolder, final String str, int i) {
            ((TextView) rcyHolder.l(R.id.label)).setText(str);
            rcyHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: tp4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f21036a.k(str, view);
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f21267a;

        public b(List list) {
            this.f21267a = list;
            put("targetUid", up4.this.b.getChatId());
            put("txt", list);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(String str);
    }

    public up4(View view, ChatItem chatItem, c cVar) {
        this.f21265a = view;
        this.b = chatItem;
        this.e = cVar;
        e();
    }

    public final void e() {
        if (!vp4.a().g(this.b)) {
            this.f21265a.setVisibility(8);
            return;
        }
        List<String> listB = vp4.a().b(this.b);
        if (listB == null || listB.size() <= 0) {
            this.f21265a.setVisibility(8);
            return;
        }
        RecyclerView recyclerView = (RecyclerView) this.f21265a.findViewById(R.id.listView);
        a aVar = new a(this.f21265a.getContext(), R.layout.item_chat_quicksend);
        this.c = aVar;
        recyclerView.setAdapter(aVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f21265a.getContext(), 0, false));
        this.c.g(listB, true);
        this.f21265a.setVisibility(0);
        this.d = true;
        LogUtil.i("QuickChatHelper", "view init");
        h("view", listB);
    }

    public boolean f() {
        View view = this.f21265a;
        return view != null && view.getVisibility() == 0;
    }

    public boolean g() {
        boolean z = this.d;
        if (z) {
            this.d = false;
            vp4.a().h(this.b);
        }
        this.f21265a.setVisibility(8);
        return z;
    }

    public final void h(String str, List<String> list) {
        zn6.j("quick_greeting", str, new b(list));
    }
}
