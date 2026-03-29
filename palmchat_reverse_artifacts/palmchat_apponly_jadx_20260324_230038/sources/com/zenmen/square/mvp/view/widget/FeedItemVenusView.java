package com.zenmen.square.mvp.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.mvp.model.bean.Media;
import defpackage.a46;
import defpackage.me1;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FeedItemVenusView extends LxRelativeLayout {
    private EffectiveShapeView[] avatarViews;
    private TextView btnView;
    private EffectiveShapeView mThumbView;
    private EffectiveShapeView maskView;
    private View rhythmView;
    private TextView subtitleView;
    private TextView titleView;

    public FeedItemVenusView(Context context) {
        this(context, null);
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        LayoutInflater.from(context).inflate(R$layout.layout_feed_item_venus, this);
        this.mThumbView = (EffectiveShapeView) findViewById(R$id.thumb);
        this.maskView = (EffectiveShapeView) findViewById(R$id.mask);
        this.rhythmView = findViewById(R$id.rhy_view);
        this.titleView = (TextView) findViewById(R$id.title);
        this.subtitleView = (TextView) findViewById(R$id.subtitle);
        this.btnView = (TextView) findViewById(R$id.btn);
        EffectiveShapeView[] effectiveShapeViewArr = new EffectiveShapeView[4];
        this.avatarViews = effectiveShapeViewArr;
        effectiveShapeViewArr[0] = (EffectiveShapeView) findViewById(R$id.avatar1);
        this.avatarViews[1] = (EffectiveShapeView) findViewById(R$id.avatar2);
        this.avatarViews[2] = (EffectiveShapeView) findViewById(R$id.avatar3);
        this.avatarViews[3] = (EffectiveShapeView) findViewById(R$id.avatar4);
    }

    public void setMediaList(List<Media> list, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Media media = list.get(0);
        a46.u(a46.h(this.mThumbView, media.thumbUrl), this.mThumbView, R$drawable.ic_room_theme_default);
        this.titleView.setText(media.channelTitle);
        if (z) {
            this.maskView.setVisibility(0);
            this.rhythmView.setVisibility(0);
            for (int i = 0; i < this.avatarViews.length; i++) {
                List<String> list2 = media.headIconList;
                if (list2 == null || list2.size() <= i) {
                    this.avatarViews[i].setVisibility(8);
                } else {
                    this.avatarViews[i].setVisibility(0);
                    a46.u(a46.h(this.avatarViews[i], media.headIconList.get(i)), this.avatarViews[i], R$drawable.default_portrait);
                }
            }
            this.subtitleView.setText(media.subTitle);
            List<String> list3 = media.headIconList;
            if (list3 == null || list3.size() <= 0) {
                this.subtitleView.setPadding(0, 0, 0, 0);
            } else {
                this.subtitleView.setPadding(me1.b(getContext(), 6), 0, 0, 0);
            }
            this.btnView.setText("加入房间");
            return;
        }
        this.maskView.setVisibility(8);
        this.rhythmView.setVisibility(8);
        int i2 = 0;
        while (true) {
            EffectiveShapeView[] effectiveShapeViewArr = this.avatarViews;
            if (i2 >= effectiveShapeViewArr.length) {
                this.subtitleView.setText("房间已关闭");
                this.subtitleView.setPadding(0, 0, 0, 0);
                this.btnView.setText("查看更多房间");
                return;
            }
            effectiveShapeViewArr[i2].setVisibility(8);
            i2++;
        }
    }

    public FeedItemVenusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FeedItemVenusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setBackgroundResource(R$drawable.bg_square_venus_share_room);
        int iB = me1.b(context, 20);
        setPadding(iB, iB, iB, iB);
    }
}
