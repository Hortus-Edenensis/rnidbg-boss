package com.zenmen.palmchat.contacts.service;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.RichMsgExItemVo;
import com.zenmen.palmchat.Vo.RichMsgExVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.chat.g;
import com.zenmen.palmchat.chat.gift.quicksend.QuickSendVo;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.smallvideo.SmallVideoEntranceController;
import defpackage.af6;
import defpackage.b65;
import defpackage.bu3;
import defpackage.by5;
import defpackage.c65;
import defpackage.h13;
import defpackage.h50;
import defpackage.io3;
import defpackage.k86;
import defpackage.mb4;
import defpackage.q03;
import defpackage.ve;
import defpackage.y56;
import defpackage.z53;
import defpackage.zy4;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MessageAdapter extends RecyclerView.Adapter<io3> {
    public final Context e;
    public final ChatItem f;
    public final Map<Integer, Integer> i;
    public View j;
    public c l;
    public LoadMoreStatus k = LoadMoreStatus.COMPLETE;
    public ChatterAdapter.h m = new b();
    public final List<MessageVo> g = new LinkedList();
    public final Handler h = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: SearchBox */
    public enum LoadMoreStatus {
        COMPLETE,
        LOADING,
        FAIL,
        END
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MessageAdapter.this.l.a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a();
    }

    public MessageAdapter(Context context, ChatItem chatItem) {
        this.e = context;
        this.f = chatItem;
        HashMap map = new HashMap();
        this.i = map;
        map.put(2, Integer.valueOf(R.layout.list_item_service_msg_empty));
        map.put(3, Integer.valueOf(R.layout.list_item_chat_left_link));
        map.put(4, Integer.valueOf(R.layout.list_item_service_msg_end));
    }

    public void e(List<MessageVo> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.g.addAll(list);
    }

    public final void f(int i) {
        LoadMoreStatus loadMoreStatus;
        LoadMoreStatus loadMoreStatus2;
        if (this.l == null || (loadMoreStatus = this.k) == (loadMoreStatus2 = LoadMoreStatus.LOADING) || loadMoreStatus == LoadMoreStatus.END || i < this.g.size() - 3) {
            return;
        }
        this.k = loadMoreStatus2;
        this.h.post(new a());
    }

    public final boolean g() {
        return this.k == LoadMoreStatus.END && this.g.size() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return (this.j != null ? 1 : 0) + (g() ? 1 : h() ? 1 + this.g.size() : this.g.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i == 0 && this.j != null) {
            return 1;
        }
        int i2 = this.j == null ? 0 : 1;
        if (i == i2 && g()) {
            return 2;
        }
        return (i == i2 + this.g.size() && h()) ? 4 : 3;
    }

    public final boolean h() {
        return this.k == LoadMoreStatus.END && this.g.size() > 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(io3 io3Var, int i) {
        if (io3Var.getItemViewType() == 3) {
            int i2 = this.j == null ? 0 : 1;
            h50 h50Var = io3Var.d;
            MessageVo messageVo = this.g.get(i - i2);
            g.c(this.e, messageVo, h50Var, this.m, null, 2);
            h50Var.c.setVisibility(8);
            h50Var.e.setText(by5.d(messageVo.time, this.e));
            f(i);
            k("account_p_a01", messageVo.mid);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public io3 onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new io3(this.j);
        }
        View viewInflate = LayoutInflater.from(this.e).inflate(this.i.get(Integer.valueOf(i)).intValue(), viewGroup, false);
        io3 io3Var = new io3(viewInflate);
        if (i == 3) {
            io3Var.d = h50.g(viewInflate);
        }
        return io3Var;
    }

    public final void k(String str, String str2) {
        HashMap map = new HashMap();
        map.put("msg_id", str2);
        c65.b(str, map);
    }

    public void l(View view) {
        this.j = view;
    }

    public void m(LoadMoreStatus loadMoreStatus) {
        this.k = loadMoreStatus;
    }

    public void n(c cVar) {
        this.l = cVar;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ChatterAdapter.h {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements af6.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ChatItem f13668a;
            public final /* synthetic */ MessageVo b;
            public final /* synthetic */ RichMsgExItemVo c;

            public a(ChatItem chatItem, MessageVo messageVo, RichMsgExItemVo richMsgExItemVo) {
                this.f13668a = chatItem;
                this.b = messageVo;
                this.c = richMsgExItemVo;
            }

            @Override // af6.b
            public void onFinish(boolean z) {
                if (z) {
                    SmallVideoEntranceController.n(MessageAdapter.this.e, this.f13668a, this.b, this.c);
                } else {
                    b65.c();
                }
            }
        }

        public b() {
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
        public void H(MessageVo messageVo, Object obj) {
            ArrayList<RichMsgExItemVo> arrayList;
            MessageAdapter.this.k("account_p_a02", messageVo.mid);
            z53.a("MessageAdapter", "onMessageItemClick, type=" + messageVo.mimeType);
            if (obj == null) {
                return;
            }
            Integer num = (Integer) obj;
            RichMsgExVo richMsgExVoH = g.h(messageVo);
            if (richMsgExVoH == null || (arrayList = richMsgExVoH.items) == null || arrayList.size() <= num.intValue()) {
                z53.a("MessageAdapter", "invalid data");
                return;
            }
            RichMsgExItemVo richMsgExItemVo = richMsgExVoH.items.get(num.intValue());
            if (richMsgExItemVo == null) {
                z53.a("MessageAdapter", "richVo is null");
                return;
            }
            String strE = q03.e(messageVo.data1);
            if (TextUtils.isEmpty(strE)) {
                z53.a("MessageAdapter", "openLink is null");
            } else {
                Intent intentE = bu3.g().e(MessageAdapter.this.e, strE);
                if (intentE != null) {
                    MessageAdapter.this.e.startActivity(intentE);
                    return;
                }
            }
            d(messageVo, richMsgExVoH, richMsgExItemVo);
        }

        public final void b(RichMsgExItemVo richMsgExItemVo, ContentValues contentValues, String str) {
            if (MessageAdapter.this.e instanceof FrameworkBaseActivity) {
                ve.k((FrameworkBaseActivity) MessageAdapter.this.e, richMsgExItemVo, contentValues, str, MessageAdapter.this.f);
            }
        }

        public final void c(ChatItem chatItem, MessageVo messageVo, RichMsgExItemVo richMsgExItemVo) {
            Context context = MessageAdapter.this.e;
            RichMsgExItemVo.WinEx winEx = richMsgExItemVo.wineEx;
            af6.e(context, winEx != null ? winEx.wineFeedId : null, winEx != null ? winEx.wid : null, new a(chatItem, messageVo, richMsgExItemVo));
        }

        public final void d(MessageVo messageVo, RichMsgExVo richMsgExVo, RichMsgExItemVo richMsgExItemVo) {
            String str = richMsgExItemVo.url;
            if (TextUtils.isEmpty(str)) {
                z53.a("MessageAdapter", "url is null");
                return;
            }
            Pair<Integer, ContentValues> pairG = mb4.g(str);
            if (pairG == null) {
                z53.a("MessageAdapter", "action is null");
                return;
            }
            if (b65.a().b(messageVo.contactRelate)) {
                b65.c();
                return;
            }
            int iIntValue = ((Integer) pairG.first).intValue();
            ContentValues contentValues = (ContentValues) pairG.second;
            contentValues.put("extra_key_from_uid", messageVo.contactRelate);
            String str2 = messageVo.mid;
            z53.a("MessageAdapter", "actionType=" + iIntValue);
            if (iIntValue == -1) {
                if (SmallVideoEntranceController.h(richMsgExItemVo)) {
                    c(MessageAdapter.this.f, messageVo, richMsgExItemVo);
                    return;
                } else {
                    e(contentValues, null, str, richMsgExItemVo, richMsgExVo.forwardable == 0, str2);
                    return;
                }
            }
            if (iIntValue == 3) {
                b(richMsgExItemVo, contentValues, str2);
            } else if (iIntValue == 10 && (MessageAdapter.this.e instanceof FrameworkBaseActivity)) {
                ve.s((FrameworkBaseActivity) MessageAdapter.this.e, str, false);
            }
        }

        public final void e(ContentValues contentValues, y56 y56Var, String str, RichMsgExItemVo richMsgExItemVo, boolean z, String str2) {
            String str3;
            String asString = contentValues.getAsString("extra_key_from_uid");
            if (y56Var == null || "1".equals(y56Var.a())) {
                str3 = str;
            } else {
                String strB = y56Var.b();
                if ("1".equals(y56Var.k())) {
                    try {
                        strB = k86.Z(strB);
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
                str3 = strB;
            }
            zy4.o(MessageAdapter.this.e, str3, richMsgExItemVo, z, false, asString, 601, MessageAdapter.this.f.getBizType(), str2, h13.s);
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
        public boolean i0() {
            return false;
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
        public void D0(String str) {
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
        public void N(MessageVo messageVo) {
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
        public void Q(MessageVo messageVo) {
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
        public void S(MessageVo messageVo) {
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
        public void X(ContactInfoItem contactInfoItem) {
        }

        @Override // defpackage.w8
        public void a(String str) {
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
        public void o0(MessageVo messageVo) {
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
        public void o1(MessageVo messageVo) {
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
        public void q0(ContactInfoItem contactInfoItem) {
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
        public void q1(String str) {
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
        public void f0() {
        }

        @Override // defpackage.w8
        public void l() {
        }

        @Override // defpackage.w8
        public void p() {
        }

        @Override // defpackage.w8
        public void w() {
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
        public void J0(ChatterAdapter.OtherViewType otherViewType, MessageVo messageVo) {
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
        public void b0(MessageVo messageVo, boolean z) {
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
        public void m(MessageVo messageVo, Object obj) {
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
        public void t(MessageVo messageVo, String str) {
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
        public void v0(MessageVo messageVo, String str) {
        }

        @Override // com.zenmen.palmchat.chat.ChatterAdapter.h
        public void g0(MessageVo messageVo, String str, QuickSendVo quickSendVo) {
        }

        @Override // com.zenmen.palmchat.utils.urlspan.MyUrlSpan.a
        public void F(int i, String str, Uri uri, View view) {
        }
    }
}
