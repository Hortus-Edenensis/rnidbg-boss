package com.zenmen.palmchat.chat.aigreeting;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.aigreeting.vo.SkuItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AiGreetingSkuItemView extends FrameLayout {
    private View contentLayout;
    private TextView count;
    private TextView des;
    private TextView price;

    public AiGreetingSkuItemView(@NonNull Context context) {
        this(context, null);
    }

    private void initViews() {
        View.inflate(getContext(), R.layout.layout_ai_greeting_sku_item, this);
        this.contentLayout = findViewById(R.id.contentLayout);
        this.count = (TextView) findViewById(R.id.count);
        this.price = (TextView) findViewById(R.id.price);
        this.des = (TextView) findViewById(R.id.des);
    }

    public void setSelect(boolean z) {
        if (z) {
            this.contentLayout.setBackgroundResource(R.drawable.shape_ai_greeting_item_sku_bg);
            this.count.setTextColor(Color.parseColor("#14CD64"));
            this.price.setTextColor(Color.parseColor("#AA14CD64"));
            this.des.setTextColor(-1);
            this.des.setBackgroundResource(R.drawable.shape_ai_greeting_item_sku_des_bg);
            return;
        }
        this.contentLayout.setBackgroundResource(R.drawable.shape_ai_greeting_item_sku_bg_unselect);
        this.count.setTextColor(Color.parseColor("#222222"));
        this.price.setTextColor(Color.parseColor("#999999"));
        this.des.setTextColor(Color.parseColor("#999999"));
        this.des.setBackgroundResource(R.drawable.shape_ai_greeting_item_sku_des_bg_unselect);
    }

    public void update(SkuItem skuItem) {
        this.des.setText(skuItem.text);
        int i = skuItem.packageDealType;
        if (i != 1) {
            if (i == 2) {
                this.count.setText("无限次");
                this.price.setText(skuItem.singleLxBeanNum + "/月");
                return;
            }
            return;
        }
        this.count.setText(skuItem.num + "次");
        this.price.setText(skuItem.singleLxBeanNum + "/次");
    }

    public AiGreetingSkuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AiGreetingSkuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initViews();
    }
}
