package com.zenmen.square.mvp.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zenmen.listui.list.BaseBean;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.topic.view.TopicHeadView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FeedTopicHeaderHolder extends BaseViewHolder {
    public TopicHeadView f;

    public FeedTopicHeaderHolder(View view) {
        super(view);
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    public void l(BaseBean baseBean, int i) {
        TopicHeadView topicHeadView = this.f;
        if (topicHeadView != null) {
            topicHeadView.updateUI();
        }
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    public void m() {
        View viewInflate = LayoutInflater.from(this.itemView.getContext()).inflate(R$layout.layout_square_topic_header, (ViewGroup) this.itemView, false);
        this.f = (TopicHeadView) viewInflate.findViewById(R$id.topic_head);
        ((ViewGroup) this.itemView).addView(viewInflate);
    }
}
