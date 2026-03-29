package com.zenmen.palmchat.chat.mate;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.conversations.threadsnew.adapter.ConversationAdapter;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.by5;
import defpackage.hc2;
import defpackage.o30;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MsgChatMateListHolder extends BaseRecyclerViewHolder<ConversationAdapter.a> {
    public ImageView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public boolean j;

    public MsgChatMateListHolder(Context context) {
        super(context, R.layout.list_item_threads_msg_mate_list);
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.f = (ImageView) this.itemView.findViewById(R.id.icon);
        this.g = (TextView) this.itemView.findViewById(R.id.main_text);
        this.h = (TextView) this.itemView.findViewById(R.id.desc);
        this.i = (TextView) this.itemView.findViewById(R.id.date);
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(ConversationAdapter.a aVar, int i) {
        ThreadChatItem threadChatItem;
        LogUtil.d("ChatMateGiftManagerTAG", "MsgChatMateListHolder onBindData position " + i);
        if (aVar == null || (threadChatItem = aVar.f13812a) == null) {
            return;
        }
        if (!TextUtils.isEmpty(threadChatItem.iconUrl)) {
            hc2.a(m()).load(aVar.f13812a.iconUrl).error(R.drawable.default_portrait).into(this.f);
        }
        if (!TextUtils.isEmpty(aVar.f13812a.title)) {
            this.g.setText(aVar.f13812a.title);
        }
        if (!TextUtils.isEmpty(aVar.f13812a.lastMsg)) {
            this.h.setText(aVar.f13812a.lastMsg);
        }
        if (aVar.f13812a.lastMessageDate > 0) {
            this.i.setVisibility(0);
            this.i.setText(by5.e(aVar.f13812a.lastMessageDate, m()));
        } else {
            this.i.setVisibility(8);
        }
        if (this.j) {
            return;
        }
        this.j = true;
        o30.h("view", aVar.f13812a.relativeContact);
    }
}
