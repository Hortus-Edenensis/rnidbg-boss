package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;
import com.zenmen.palmchat.widget.LXPortraitView;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class s10 extends SimpleChatViewAdapter {
    public boolean i;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f20646a;
        public final /* synthetic */ ArrayList b;

        public a(MessageVo messageVo, ArrayList arrayList) {
            this.f20646a = messageVo;
            this.b = arrayList;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s10.this.A("banned_card");
            if (this.f20646a == null || this.b.isEmpty() || il5.l((String) this.b.get(0)) || l50.a()) {
                return;
            }
            if (!hx3.m(s10.this.f)) {
                sy5.e(s10.this.f, R.string.net_status_unavailable, 1).g();
                return;
            }
            ChatterAdapter.h hVarX = s10.this.x();
            if (hVarX == null || s10.this.o() == null) {
                return;
            }
            hVarX.t(hp.f((String) this.b.get(0), s10.this.o()), this.f20646a.mid);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f20647a;
        public final /* synthetic */ ArrayList b;

        public b(MessageVo messageVo, ArrayList arrayList) {
            this.f20647a = messageVo;
            this.b = arrayList;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s10.this.A("banned_card");
            if (this.f20647a == null || this.b.isEmpty() || this.b.size() < 2 || il5.l((String) this.b.get(1)) || l50.a()) {
                return;
            }
            if (!hx3.m(s10.this.f)) {
                sy5.e(s10.this.f, R.string.net_status_unavailable, 1).g();
                return;
            }
            ChatterAdapter.h hVarX = s10.this.x();
            if (hVarX == null || s10.this.o() == null) {
                return;
            }
            hVarX.t(hp.f((String) this.b.get(1), s10.this.o()), this.f20647a.mid);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f20648a;
        public final /* synthetic */ ArrayList b;

        public c(MessageVo messageVo, ArrayList arrayList) {
            this.f20648a = messageVo;
            this.b = arrayList;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s10.this.A("banned_card");
            if (this.f20648a == null || this.b.isEmpty() || this.b.size() < 3 || il5.l((String) this.b.get(2)) || l50.a()) {
                return;
            }
            if (!hx3.m(s10.this.f)) {
                sy5.e(s10.this.f, R.string.net_status_unavailable, 1).g();
                return;
            }
            ChatterAdapter.h hVarX = s10.this.x();
            if (hVarX == null || s10.this.o() == null) {
                return;
            }
            hVarX.t(hp.f((String) this.b.get(2), s10.this.o()), this.f20648a.mid);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageVo f20649a;
        public final /* synthetic */ t10 b;

        public d(MessageVo messageVo, t10 t10Var) {
            this.f20649a = messageVo;
            this.b = t10Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s10.this.y(this.f20649a, this.b);
            s10.this.A("banned_cardchange");
        }
    }

    public final void A(String str) {
        HashMap map = new HashMap();
        ChatItem chatItemO = o();
        if (chatItemO != null) {
            map.put("targetUid", chatItemO.getChatId());
        }
        zn6.h(str, "click", map);
    }

    @Override // defpackage.o40
    public int a() {
        return 45;
    }

    @Override // defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        if (20002 != messageVo.mimeType) {
            return null;
        }
        return this.e.inflate(R.layout.list_item_chat_banned, (ViewGroup) null);
    }

    @Override // defpackage.o40
    public if6 c(View view) {
        return new t10(view);
    }

    @Override // defpackage.o40
    public int getViewTypeCount() {
        return 1;
    }

    @Override // defpackage.o40
    public <T extends if6> void l(T t, MessageVo messageVo) {
        y(messageVo, (t10) t);
    }

    @Override // defpackage.o40
    public int m(boolean z, int i, MessageVo messageVo) {
        return i == 20002 ? 45 : -1;
    }

    @Override // com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter
    public ChatItem o() {
        return super.o();
    }

    public ChatterAdapter.h x() {
        return r().o();
    }

    public void y(MessageVo messageVo, t10 t10Var) {
        View view = t10Var.g;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = t10Var.h;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        LXPortraitView lXPortraitView = t10Var.i;
        if (lXPortraitView != null) {
            lXPortraitView.setVisibility(8);
        }
        View view3 = t10Var.j;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        ImageView imageView = t10Var.k;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = t10Var.c;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = t10Var.d;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        t10Var.s.setVisibility(4);
        t10Var.v.setVisibility(4);
        t10Var.y.setVisibility(4);
        ArrayList<String> arrayListI = hp.i();
        if (arrayListI.isEmpty()) {
            t10Var.r.setVisibility(8);
        } else {
            t10Var.r.setVisibility(0);
            if (il5.l(arrayListI.get(0))) {
                t10Var.s.setVisibility(4);
            } else {
                t10Var.t.setText(arrayListI.get(0));
                t10Var.s.setVisibility(0);
            }
            if (arrayListI.size() < 2 || il5.l(arrayListI.get(1))) {
                t10Var.v.setVisibility(4);
            } else {
                t10Var.w.setText(arrayListI.get(1));
                t10Var.v.setVisibility(0);
            }
            if (arrayListI.size() < 3 || il5.l(arrayListI.get(2))) {
                t10Var.y.setVisibility(4);
            } else {
                t10Var.z.setText(arrayListI.get(2));
                t10Var.y.setVisibility(0);
            }
        }
        t10Var.u.setOnClickListener(new a(messageVo, arrayListI));
        t10Var.x.setOnClickListener(new b(messageVo, arrayListI));
        t10Var.A.setOnClickListener(new c(messageVo, arrayListI));
        t10Var.B.setOnClickListener(new d(messageVo, t10Var));
        z();
    }

    public final void z() {
        if (this.i) {
            return;
        }
        HashMap map = new HashMap();
        ChatItem chatItemO = o();
        if (chatItemO != null) {
            map.put("targetUid", chatItemO.getChatId());
        }
        zn6.h("banned_card", "view", map);
        this.i = true;
    }
}
