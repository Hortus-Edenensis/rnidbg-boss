package com.zenmen.palmchat.conversations.threadsnew.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.chat.mate.ChatMateGuideMsgData;
import com.zenmen.palmchat.chat.mate.MsgChatMateGuideHolder;
import com.zenmen.palmchat.chat.mate.MsgChatMateListHolder;
import com.zenmen.palmchat.conversations.threadsnew.ChatOneViewHolder;
import com.zenmen.palmchat.conversations.threadsnew.SeeMeViewHolder;
import com.zenmen.palmchat.database.ThreadBizExtHelper;
import com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.az2;
import defpackage.t45;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ConversationAdapter extends BaseRecyclerViewAdapter<c> {
    public List<String> j;
    public int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public boolean q;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ThreadChatItem f13812a;

        public a(ThreadChatItem threadChatItem) {
            this.f13812a = threadChatItem;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends c {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class c implements BaseRecyclerViewAdapter.c {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChatMateGuideMsgData f13813a;

        public d(ChatMateGuideMsgData chatMateGuideMsgData) {
            this.f13813a = chatMateGuideMsgData;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public t45 f13814a;
        public com.zenmen.palmchat.conversations.threadsnew.a b;
        public long c = -1;

        public e(t45 t45Var, com.zenmen.palmchat.conversations.threadsnew.a aVar) {
            this.f13814a = t45Var;
            this.b = aVar;
        }

        public void a(t45 t45Var, com.zenmen.palmchat.conversations.threadsnew.a aVar) {
            this.f13814a = t45Var;
            this.b = aVar;
        }
    }

    public ConversationAdapter(@NonNull Context context, @NonNull List<c> list) {
        super(context, list);
        this.k = 0;
        this.l = 0;
        this.m = 1;
        this.n = 2;
        this.o = 3;
        this.p = 4;
        this.q = false;
        this.j = new ArrayList();
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    public int g(int i) {
        return 0;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    public BaseRecyclerViewHolder h(ViewGroup viewGroup, View view, int i) {
        BaseRecyclerViewHolder conversationViewHolder = i == 0 ? new ConversationViewHolder(this.e, viewGroup, R.layout.list_item_threads_list) : i == 1 ? new SeeMeViewHolder(this.e) : i == 2 ? new MsgChatMateGuideHolder(this.e) : i == 3 ? new MsgChatMateListHolder(this.e) : i == 4 ? new ChatOneViewHolder(this.e) : null;
        if (conversationViewHolder != null) {
            p(conversationViewHolder);
        }
        return conversationViewHolder;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int r(int i, boolean z) {
        boolean z2;
        int iMax = Math.max(i, this.k);
        int i2 = 0;
        try {
            List<c> listF = f();
            if (listF != null) {
                int i3 = iMax + 1;
                if (i3 < listF.size()) {
                    while (i3 < listF.size()) {
                        c cVar = listF.get(i3);
                        if (cVar instanceof a) {
                            ThreadChatItem threadChatItem = ((a) cVar).f13812a;
                            int i4 = threadChatItem.unReadCount;
                            boolean z3 = threadChatItem.isNoDisturb;
                            if (i4 > 0 && (z || !z3)) {
                                z2 = true;
                                break;
                            }
                        }
                        i3++;
                    }
                    i3 = 0;
                    z2 = false;
                    if (z2) {
                        try {
                            if (iMax < listF.size()) {
                                while (i2 < iMax) {
                                    c cVar2 = listF.get(i2);
                                    if (cVar2 instanceof a) {
                                        ThreadChatItem threadChatItem2 = ((a) cVar2).f13812a;
                                        int i5 = threadChatItem2.unReadCount;
                                        boolean z4 = threadChatItem2.isNoDisturb;
                                        if (i5 > 0 && (z || !z4)) {
                                            break;
                                        }
                                    }
                                    i2++;
                                }
                                i2 = i3;
                            } else {
                                i2 = i3;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            i2 = i3;
                            LogUtil.e("ConversationAdapter", e);
                        }
                    }
                } else {
                    i3 = 0;
                    z2 = false;
                    if (z2) {
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
        this.k = i2;
        return i2;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public int i(int i, @NonNull c cVar) {
        if (cVar instanceof a) {
            ThreadChatItem threadChatItem = ((a) cVar).f13812a;
            return (threadChatItem == null || !threadChatItem.isChatMateMsgListItem) ? 0 : 3;
        }
        if (cVar instanceof e) {
            return 1;
        }
        if (cVar instanceof d) {
            return 2;
        }
        return cVar instanceof b ? 4 : 99;
    }

    public boolean t() {
        return this.q;
    }

    public final void u(a aVar) {
        ThreadChatItem threadChatItem;
        if (aVar == null || (threadChatItem = aVar.f13812a) == null) {
            return;
        }
        String str = threadChatItem.lastMsgMid;
        if (TextUtils.isEmpty(str) || this.j.contains(str)) {
            return;
        }
        ThreadChatItem threadChatItem2 = aVar.f13812a;
        ThreadBizExtHelper.BizExt bizExtW = w(threadChatItem2.bizType, threadChatItem2.lastMsgType, threadChatItem2.relativeContact, threadChatItem2.bizExtension);
        if (bizExtW == null || bizExtW.getRichMessage() == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mid", str);
            jSONObject.put("showType", bizExtW.getRichMessage().getShowType());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("M122", null, null, jSONObject.toString());
        this.j.add(str);
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void k(BaseRecyclerViewHolder<c> baseRecyclerViewHolder, c cVar, int i) {
        super.k(baseRecyclerViewHolder, cVar, i);
        if (cVar instanceof a) {
            u((a) cVar);
        }
    }

    public final ThreadBizExtHelper.BizExt w(int i, int i2, String str, String str2) {
        ThreadBizExtHelper.BizExt bizExt;
        if (i != 0 || i2 != 28 || "88888003".equals(str) || TextUtils.isEmpty(str2) || (bizExt = (ThreadBizExtHelper.BizExt) az2.a(str2, ThreadBizExtHelper.BizExt.class)) == null || bizExt.getRichMessage() == null) {
            return null;
        }
        if (bizExt.getRichMessage().getShowType() == 9 || bizExt.getRichMessage().getShowType() == 8) {
            return bizExt;
        }
        return null;
    }

    public void x(boolean z) {
        this.q = z;
    }
}
