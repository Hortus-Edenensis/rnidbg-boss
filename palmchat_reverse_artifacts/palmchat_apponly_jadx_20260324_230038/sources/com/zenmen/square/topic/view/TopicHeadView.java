package com.zenmen.square.topic.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.NestTopicFeedsActivity;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.topic.bean.TopicListBean;
import com.zenmen.square.ui.widget.BouncyHScrollView;
import defpackage.gr2;
import defpackage.hr2;
import defpackage.me1;
import defpackage.xj5;
import defpackage.zn6;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class TopicHeadView extends LxRelativeLayout implements Observer {
    public final String TAG;
    private BouncyHScrollView hsTopic;
    private c mOnTopicClickListener;
    private View rootView;
    private ImageView topicBanner;
    private LinearLayout topicListView;
    private TextView topicTitleView;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements c {

        /* JADX INFO: renamed from: com.zenmen.square.topic.view.TopicHeadView$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1161a extends HashMap<String, String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TopicListBean.Topic f16506a;

            public C1161a(TopicListBean.Topic topic) {
                this.f16506a = topic;
                put("topicId", String.valueOf(topic.topicId));
                put("type", topic.topicType == 1 ? "3" : topic.topicActivityType == 0 ? "2" : "1");
            }
        }

        public a() {
        }

        @Override // com.zenmen.square.topic.view.TopicHeadView.c
        public void a(TopicListBean.Topic topic) {
            zn6.h("pagediscove_top_talklistcil", "click", new C1161a(topic));
            NestTopicFeedsActivity.G1(TopicHeadView.this.getContext(), topic.topicId, 9);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TopicListBean.Topic f16508a;

            public a(TopicListBean.Topic topic) {
                this.f16508a = topic;
                put("topicId", String.valueOf(topic.topicId));
                put("type", topic.topicType == 1 ? "3" : topic.topicActivityType == 0 ? "2" : "1");
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TopicListBean.Topic topic = (TopicListBean.Topic) view.getTag();
            if (topic != null) {
                zn6.h("pagediscove_top_talklistcil", "click", new a(topic));
                NestTopicFeedsActivity.G1(TopicHeadView.this.getContext(), topic.topicId, 9);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(TopicListBean.Topic topic);
    }

    public TopicHeadView(Context context) {
        super(context);
        this.TAG = "TopicHeadView";
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.layout_topic_header_view, (ViewGroup) this, false);
        this.rootView = viewInflate;
        this.topicTitleView = (TextView) viewInflate.findViewById(R$id.topic_title);
        this.hsTopic = (BouncyHScrollView) this.rootView.findViewById(R$id.hs_topic);
        this.topicListView = (LinearLayout) this.rootView.findViewById(R$id.topic_list);
        this.mOnTopicClickListener = new a();
        ImageView imageView = (ImageView) this.rootView.findViewById(R$id.topic_banner);
        this.topicBanner = imageView;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int iG = me1.g() - me1.b(getContext(), 36);
        layoutParams.width = iG;
        layoutParams.height = (iG * 86) / MediaPlayer.MEDIA_PLAYER_OPTION_NEED_CHECK_DROP_AUDIO;
        this.topicBanner.setLayoutParams(layoutParams);
        this.topicBanner.setOnClickListener(new b());
        addView(this.rootView);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        LogUtil.i("TopicHeadView", "onAttachedToWindow");
        super.onAttachedToWindow();
        xj5.h().addObserver(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        LogUtil.i("TopicHeadView", "onDetachedFromWindow");
        super.onDetachedFromWindow();
        xj5.h().deleteObserver(this);
    }

    public void reload() {
        List<TopicListBean.Topic> listJ = xj5.h().j();
        if (listJ == null || listJ.size() <= 0) {
            this.rootView.setVisibility(8);
            return;
        }
        this.rootView.setVisibility(0);
        this.topicTitleView.setText(xj5.h().k());
        if (listJ.size() != 1 || TextUtils.isEmpty(listJ.get(0).bannerUrl)) {
            this.hsTopic.setVisibility(0);
            this.topicBanner.setVisibility(8);
            this.topicListView.removeAllViews();
            for (TopicListBean.Topic topic : listJ) {
                TopicHeadItemView topicHeadItemView = new TopicHeadItemView(getContext());
                topicHeadItemView.initData(topic);
                topicHeadItemView.setTopicClickListener(this.mOnTopicClickListener);
                this.topicListView.addView(topicHeadItemView);
            }
        } else {
            this.hsTopic.setVisibility(8);
            this.topicBanner.setVisibility(0);
            this.topicBanner.setTag(listJ.get(0));
            gr2.j().h(listJ.get(0).bannerUrl, this.topicBanner, hr2.k());
        }
        zn6.c("pagediscove_top_talklist", "view");
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        LogUtil.i("TopicHeadView", "update");
        reload();
    }

    public void updateUI() {
        for (int i = 0; i < this.topicListView.getChildCount(); i++) {
            View childAt = this.topicListView.getChildAt(i);
            if (childAt instanceof TopicHeadItemView) {
                ((TopicHeadItemView) childAt).refresh();
            }
        }
    }

    public TopicHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "TopicHeadView";
    }

    public TopicHeadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "TopicHeadView";
    }

    @RequiresApi(api = 21)
    public TopicHeadView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.TAG = "TopicHeadView";
    }
}
