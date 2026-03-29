package com.zenmen.square.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.InteractMessageActivity;
import com.zenmen.square.R$drawable;
import com.zenmen.square.mvp.model.bean.SquareInteractBean;
import com.zenmen.square.mvp.model.bean.SquareInteractDetail;
import defpackage.a46;
import defpackage.gr2;
import defpackage.k86;
import defpackage.z66;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class InteractNestImageContainer extends LinearLayout implements View.OnClickListener {
    private SquareInteractBean mBean;
    private EffectiveShapeView moreView;
    private List<EffectiveShapeView> subViewList;

    public InteractNestImageContainer(Context context) {
        this(context, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.moreView) {
            SquareInteractBean squareInteractBean = this.mBean;
            int i = squareInteractBean.aggregationNoticeType;
            InteractMessageActivity.A1((i == 3 || i == 1) ? squareInteractBean.singleInteract.toDiscussionId : squareInteractBean.singleInteract.feedId, i, getContext());
        } else {
            Object tag = view.getTag();
            if (tag instanceof SquareInteractDetail) {
                SquareInteractDetail squareInteractDetail = (SquareInteractDetail) tag;
                z66.d(squareInteractDetail.exFromUid, squareInteractDetail.sex, getContext(), 17, squareInteractDetail.feedId, null, null);
            }
        }
    }

    public void setInteractInfo(SquareInteractBean squareInteractBean) {
        if (squareInteractBean == null || !squareInteractBean.ifAggregation) {
            setVisibility(8);
            return;
        }
        this.mBean = squareInteractBean;
        int i = 0;
        setVisibility(0);
        int size = (squareInteractBean.singleNoticeList.size() - 1) - this.subViewList.size();
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                EffectiveShapeView effectiveShapeView = new EffectiveShapeView(getContext());
                int iB = a46.b(getContext(), 30.0f);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iB, iB);
                if (this.subViewList.size() > 0) {
                    layoutParams.leftMargin = a46.b(getContext(), 6.0f);
                }
                addView(effectiveShapeView, layoutParams);
                this.subViewList.add(effectiveShapeView);
            }
        } else if (size < 0) {
            for (int i3 = 0; i3 > size; i3--) {
                List<EffectiveShapeView> list = this.subViewList;
                removeView(list.remove(list.size() - 1));
            }
        }
        while (i < this.subViewList.size()) {
            EffectiveShapeView effectiveShapeView2 = this.subViewList.get(i);
            i++;
            SquareInteractDetail squareInteractDetail = squareInteractBean.singleNoticeList.get(i);
            gr2.j().h(k86.p(squareInteractDetail.headImgUrl), effectiveShapeView2, a46.l());
            effectiveShapeView2.changeShapeType(1);
            effectiveShapeView2.setTag(squareInteractDetail);
            effectiveShapeView2.setOnClickListener(this);
        }
        View view = this.moreView;
        if (view == null) {
            EffectiveShapeView effectiveShapeView3 = new EffectiveShapeView(getContext());
            this.moreView = effectiveShapeView3;
            effectiveShapeView3.setImageResource(R$drawable.icon_interact_more);
            this.moreView.changeShapeType(1);
        } else {
            removeView(view);
        }
        this.moreView.setOnClickListener(this);
        int iB2 = a46.b(getContext(), 30.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iB2, iB2);
        layoutParams2.leftMargin = a46.b(getContext(), 6.0f);
        addView(this.moreView, layoutParams2);
    }

    public InteractNestImageContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InteractNestImageContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public InteractNestImageContainer(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.subViewList = new ArrayList();
    }
}
