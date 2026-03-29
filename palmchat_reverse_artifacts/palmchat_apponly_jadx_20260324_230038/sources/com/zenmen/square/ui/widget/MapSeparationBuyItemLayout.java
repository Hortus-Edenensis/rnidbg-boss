package com.zenmen.square.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import defpackage.yc3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class MapSeparationBuyItemLayout extends FrameLayout {
    private String costGreen;
    private String costWhite;
    private View greenLayout;
    private TextView itemCost;
    private TextView itemRange;
    private TextView itemResult;
    private yc3 productBean;
    private String rangeGreen;
    private String rangeWhite;
    private TextView redBg;
    private String resultGreen;
    private String resultWhite;

    public MapSeparationBuyItemLayout(@NonNull Context context) {
        super(context);
        this.itemRange = null;
        this.itemCost = null;
        this.itemResult = null;
        this.greenLayout = null;
        this.redBg = null;
        this.rangeGreen = "#FFA016";
        this.rangeWhite = "#999999";
        this.costGreen = "#FFA016";
        this.costWhite = "#222222";
        this.resultGreen = "#FFFFFF";
        this.resultWhite = "#999999";
    }

    private void initView() {
        this.itemRange = (TextView) findViewById(R$id.separation_item_range);
        this.itemCost = (TextView) findViewById(R$id.separation_item_cost);
        this.itemResult = (TextView) findViewById(R$id.separation_item_result);
        this.greenLayout = findViewById(R$id.separation_buy_green_layout);
        this.redBg = (TextView) findViewById(R$id.separation_item_red);
        this.greenLayout.setVisibility(8);
    }

    public void greenClick() {
        if (getVisibility() == 0) {
            this.greenLayout.setVisibility(0);
            this.itemRange.setTextColor(Color.parseColor(this.rangeGreen));
            this.itemCost.setTextColor(Color.parseColor(this.costGreen));
            this.itemResult.setTextColor(Color.parseColor(this.resultGreen));
            this.itemResult.setBackgroundResource(R$drawable.map_separation_item_result_green_bg);
        }
    }

    public void setData(yc3 yc3Var) {
        initView();
    }

    public void setRedBgShow(String str) {
        this.redBg.setVisibility(0);
        this.redBg.setText(str);
    }

    public void whiteClick() {
        if (getVisibility() == 0) {
            this.greenLayout.setVisibility(8);
            this.itemRange.setTextColor(Color.parseColor(this.rangeWhite));
            this.itemCost.setTextColor(Color.parseColor(this.costWhite));
            this.itemResult.setTextColor(Color.parseColor(this.resultWhite));
            this.itemResult.setBackgroundResource(R$drawable.map_separation_item_result_white_bg);
        }
    }

    public MapSeparationBuyItemLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.itemRange = null;
        this.itemCost = null;
        this.itemResult = null;
        this.greenLayout = null;
        this.redBg = null;
        this.rangeGreen = "#FFA016";
        this.rangeWhite = "#999999";
        this.costGreen = "#FFA016";
        this.costWhite = "#222222";
        this.resultGreen = "#FFFFFF";
        this.resultWhite = "#999999";
    }

    public MapSeparationBuyItemLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.itemRange = null;
        this.itemCost = null;
        this.itemResult = null;
        this.greenLayout = null;
        this.redBg = null;
        this.rangeGreen = "#FFA016";
        this.rangeWhite = "#999999";
        this.costGreen = "#FFA016";
        this.costWhite = "#222222";
        this.resultGreen = "#FFFFFF";
        this.resultWhite = "#999999";
    }
}
