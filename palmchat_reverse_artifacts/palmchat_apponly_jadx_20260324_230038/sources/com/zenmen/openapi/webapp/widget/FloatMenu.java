package com.zenmen.openapi.webapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class FloatMenu extends RelativeLayout {
    private ImageView closeBtn;
    private View dividerLine;
    private ImageView moreBtn;

    public FloatMenu(Context context) {
        this(context, null);
    }

    private void createView(Context context) {
        View.inflate(context, R.layout.webapp_float_menu, this);
        this.moreBtn = (ImageView) findViewById(R.id.iv_webapp_btn_more);
        this.closeBtn = (ImageView) findViewById(R.id.iv_webapp_btn_close);
        this.dividerLine = findViewById(R.id.v_webapp_float_menu_divider);
        setBlackStyle(true);
    }

    public void setBlackStyle(boolean z) {
        if (z) {
            setBackgroundResource(R.drawable.lx_webapp_home_menu_bg_black);
            this.moreBtn.setImageResource(R.drawable.webapp_btn_more_black_selector);
            this.closeBtn.setImageResource(R.drawable.webapp_btn_close_black_selector);
            this.dividerLine.setBackgroundResource(R.color.webapp_action_bar_menu_divider_black);
            return;
        }
        setBackgroundResource(R.drawable.lx_webapp_home_menu_bg_white);
        this.moreBtn.setImageResource(R.drawable.webapp_btn_more_white_selector);
        this.closeBtn.setImageResource(R.drawable.webapp_btn_close_white_selector);
        this.dividerLine.setBackgroundResource(R.color.webapp_action_bar_menu_divider_white);
    }

    public FloatMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        createView(context);
    }

    @RequiresApi(api = 21)
    public FloatMenu(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        createView(context);
    }
}
