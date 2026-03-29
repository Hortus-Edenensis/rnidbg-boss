package com.zenmen.palmchat.chat.mate;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.conversations.threadsnew.adapter.ConversationAdapter;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import com.zenmen.palmchat.mine.view.LoopTextView;
import defpackage.o30;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MsgChatMateGuideHolder extends BaseRecyclerViewHolder<ConversationAdapter.d> {
    public LoopTextView f;
    public TextView g;
    public ImageView h;

    public MsgChatMateGuideHolder(Context context) {
        super(context, R.layout.list_item_threads_msg_mate_guide);
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.g = (TextView) this.itemView.findViewById(R.id.desc);
        this.f = (LoopTextView) this.itemView.findViewById(R.id.main_text);
        this.h = (ImageView) this.itemView.findViewById(R.id.chate_mate_msg_item_icon_img);
        this.f.setText(17.0f, 0, Color.parseColor("#222222"), 8388627);
        this.f.setTextStillTime(10000L);
        this.f.setAnimTime(300L);
        this.f.setAutoRemove(false);
        this.f.fixAnimConflict(true);
        o30.B = this.f;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(ConversationAdapter.d dVar, int i) {
        ChatMateGuideMsgData chatMateGuideMsgData;
        if (dVar == null || (chatMateGuideMsgData = dVar.f13813a) == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(chatMateGuideMsgData.iconUrl)) {
                Glide.with(m()).load2(dVar.f13813a.iconUrl).error(R.drawable.chate_mate_msg_item_icon).into(this.h);
            }
            if (!TextUtils.isEmpty(dVar.f13813a.subTitle)) {
                this.g.setText(dVar.f13813a.subTitle);
            }
            ArrayList<String> arrayList = dVar.f13813a.titleList;
            if (arrayList != null && arrayList.size() > 0) {
                ChatMateGuideMsgData chatMateGuideMsgData2 = dVar.f13813a;
                if (!chatMateGuideMsgData2.titleAnimDone) {
                    chatMateGuideMsgData2.titleAnimDone = true;
                    if (chatMateGuideMsgData2.titleList.size() == 1) {
                        this.f.setTextList(new ArrayList<>());
                        this.f.setCurrentText(dVar.f13813a.titleList.get(0));
                    } else {
                        this.f.setTextList(dVar.f13813a.titleList);
                        this.f.setCurrentText(dVar.f13813a.titleList.get(0));
                        this.f.startAutoScroll();
                    }
                }
            }
            ChatMateGuideMsgData chatMateGuideMsgData3 = dVar.f13813a;
            if (chatMateGuideMsgData3.showEvent) {
                return;
            }
            chatMateGuideMsgData3.showEvent = true;
            o30.i("view", 9);
        } catch (Exception unused) {
        }
    }
}
