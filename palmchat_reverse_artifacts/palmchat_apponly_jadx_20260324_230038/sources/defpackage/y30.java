package defpackage;

import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.conversations.threadsnew.adapter.ConversationAdapter;
import com.zenmen.palmchat.conversations.threadsnew.chatone.vo.ChatOneVo;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class y30 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConversationAdapter f22110a;
    public ConversationAdapter.c b = null;
    public ChatOneVo c;
    public c d;
    public boolean e;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements b {
        public a() {
        }

        @Override // y30.b
        public void a(ChatOneVo chatOneVo) {
            LogUtil.i("ChatOneUIHelper", "onShow isDataLoaded =" + y30.this.f22110a.t() + " data=" + az2.c(chatOneVo));
            if (chatOneVo == null || chatOneVo.isChtEnd) {
                y30.this.c = null;
                return;
            }
            y30.this.c = chatOneVo;
            if (y30.this.f22110a.t()) {
                y30 y30Var = y30.this;
                y30Var.c(y30Var.f22110a.f(), false);
                y30.this.f22110a.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(ChatOneVo chatOneVo);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        boolean a();
    }

    public y30(c cVar) {
        this.e = false;
        this.d = cVar;
        this.e = w30.h();
    }

    public List<ConversationAdapter.c> c(List<ConversationAdapter.c> list, boolean z) {
        c cVar;
        ChatOneVo chatOneVo;
        int i;
        ThreadChatItem threadChatItem;
        if (!this.e) {
            return list;
        }
        LogUtil.i("ChatOneUIHelper", "fixData start size = " + list.size());
        int size = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= list.size()) {
                i2 = -1;
                break;
            }
            if (list.get(i2) instanceof ConversationAdapter.b) {
                break;
            }
            i2++;
        }
        if (i2 >= 0) {
            list.remove(i2);
            LogUtil.i("ChatOneUIHelper", "fixData remove old index=" + i2);
        }
        if (z || (cVar = this.d) == null || !cVar.a() || (chatOneVo = this.c) == null) {
            return list;
        }
        long jB = chatOneVo.time;
        if (jB == -1) {
            jB = ir5.b();
        }
        for (ConversationAdapter.c cVar2 : list) {
            if ((cVar2 instanceof ConversationAdapter.a) && (threadChatItem = ((ConversationAdapter.a) cVar2).f13812a) != null && threadChatItem.priority == 0 && threadChatItem.pinGiftMessage == 0 && threadChatItem.isSuperGreetings == 0) {
                long j = threadChatItem.draftDate;
                if (j != 0 && jB != j) {
                    if (jB > j) {
                        i = size;
                        break;
                    }
                } else {
                    if (jB >= threadChatItem.lastMessageDate) {
                        i = size;
                        break;
                    }
                }
            }
            size++;
        }
        i = -1;
        if (i != -1) {
            size = i;
        }
        if (size > list.size()) {
            size = list.size();
        }
        list.add(size, new ConversationAdapter.b());
        LogUtil.i("ChatOneUIHelper", "fixData add targetPosition=" + size + " size = " + list.size());
        return list;
    }

    public void d() {
        if (this.e) {
            w30.f().i();
            this.c = null;
            if (this.f22110a.t()) {
                c(this.f22110a.f(), true);
                this.f22110a.notifyDataSetChanged();
            }
        }
    }

    public void e() {
        if (this.e) {
            LogUtil.i("ChatOneUIHelper", "onShow start");
            w30.f().q(new a());
        }
    }

    public void f(ConversationAdapter conversationAdapter) {
        this.f22110a = conversationAdapter;
    }
}
