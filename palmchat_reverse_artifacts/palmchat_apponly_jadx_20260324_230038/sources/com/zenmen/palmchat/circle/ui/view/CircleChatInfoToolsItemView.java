package com.zenmen.palmchat.circle.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.dating.bean.DatingGroupToolBeans;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.hc2;
import defpackage.me1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleChatInfoToolsItemView extends LinearLayoutCompat {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private EffectiveShapeView mToolsItemIcon;
    private TextView mToolsItemTitle;

    public CircleChatInfoToolsItemView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.mLayoutInflater = layoutInflaterFrom;
        View viewInflate = layoutInflaterFrom.inflate(R.layout.layout_circle_chat_info_tools_item, this);
        this.mToolsItemIcon = (EffectiveShapeView) viewInflate.findViewById(R.id.mToolsItemIcon);
        this.mToolsItemTitle = (TextView) viewInflate.findViewById(R.id.mToolsItemTitle);
    }

    public void bindData(DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean) {
        if (datingGroupToolBean == null) {
            setVisibility(8);
            return;
        }
        EffectiveShapeView effectiveShapeView = this.mToolsItemIcon;
        if (effectiveShapeView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = effectiveShapeView.getLayoutParams();
        if (datingGroupToolBean.getIsSystem() == 1) {
            layoutParams.width = me1.b(this.mContext, 42);
            layoutParams.height = me1.b(this.mContext, 42);
        } else {
            layoutParams.width = me1.b(this.mContext, 34);
            layoutParams.height = me1.b(this.mContext, 34);
        }
        setVisibility(0);
        hc2.a(this.mContext).load(datingGroupToolBean.getIcon()).error(R.drawable.icon_circle_tools_default).into(this.mToolsItemIcon);
        this.mToolsItemTitle.setText(datingGroupToolBean.getToolName());
    }

    public CircleChatInfoToolsItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleChatInfoToolsItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init(context);
    }
}
