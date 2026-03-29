package com.zenmen.square.topic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.topic.bean.TopicListBean;
import com.zenmen.square.topic.view.TopicHeadView;
import defpackage.gr2;
import defpackage.hr2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class TopicHeadItemView extends LxRelativeLayout {
    private TopicHeadView.c mOnClickListener;
    private TopicListBean.Topic mTopic;
    private View rootView;
    private ImageView topicICon;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TopicHeadItemView.this.mOnClickListener != null) {
                TopicHeadItemView.this.mOnClickListener.a(TopicHeadItemView.this.mTopic);
            }
        }
    }

    public TopicHeadItemView(Context context) {
        super(context);
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.layout_topic_header_view_item, (ViewGroup) this, false);
        this.rootView = viewInflate;
        addView(viewInflate);
    }

    public void initData(TopicListBean.Topic topic) {
        this.mTopic = topic;
        this.topicICon = (ImageView) this.rootView.findViewById(R$id.ic_topic);
        ImageView imageView = (ImageView) this.rootView.findViewById(R$id.ic_redpacket);
        ((TextView) this.rootView.findViewById(R$id.tv_topic)).setText(topic.topicName);
        imageView.setVisibility(topic.topicActivityType == 1 ? 0 : 8);
        setOnClickListener(new a());
        gr2.j().h(topic.topicThumbnail, this.topicICon, hr2.g());
    }

    public void refresh() {
        gr2.j().h(this.mTopic.topicThumbnail, this.topicICon, hr2.g());
    }

    public void setTopicClickListener(TopicHeadView.c cVar) {
        this.mOnClickListener = cVar;
    }

    public TopicHeadItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TopicHeadItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public TopicHeadItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
