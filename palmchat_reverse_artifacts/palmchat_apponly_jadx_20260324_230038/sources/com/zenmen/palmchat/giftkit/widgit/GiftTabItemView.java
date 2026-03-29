package com.zenmen.palmchat.giftkit.widgit;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.zenmen.giftkit.R$drawable;
import com.zenmen.giftkit.R$id;
import com.zenmen.giftkit.R$layout;
import com.zenmen.palmchat.chat.ChatGiftConfig;
import defpackage.q05;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class GiftTabItemView extends RelativeLayout implements View.OnClickListener {
    private View btmView;
    private int index;
    private boolean isSelected;
    private boolean mIsNewUI;
    private View redDot;
    private a selectedListener;
    private TextView tvTitle;
    private int uiType;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void onSelect(int i);
    }

    public GiftTabItemView(Context context, int i) {
        super(context);
        this.isSelected = false;
        this.mIsNewUI = false;
        this.uiType = i;
        initUI(context);
    }

    public int getIndex() {
        return this.index;
    }

    public void initUI(Context context) {
        this.mIsNewUI = com.zenmen.palmchat.giftkit.a.a().c() && ChatGiftConfig.getChatGiftConfig().gift_newpanel;
        View.inflate(context, R$layout.layout_gift_view_tab, this);
        this.tvTitle = (TextView) findViewById(R$id.tab_item_text);
        this.redDot = findViewById(R$id.red_dot);
        View viewFindViewById = findViewById(R$id.tab_item_bottom);
        this.btmView = viewFindViewById;
        if (this.mIsNewUI) {
            viewFindViewById.setBackgroundResource(R$drawable.bg_gift_view_tab_light_new);
        } else {
            viewFindViewById.setBackgroundResource(this.uiType == 0 ? R$drawable.bg_gift_view_tab_light : R$drawable.bg_gift_view_tab_dark);
        }
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        setCurrentSelected(true, true);
    }

    public void setCurrentSelected(boolean z, boolean z2) {
        if (this.isSelected == z) {
            return;
        }
        if (z) {
            this.btmView.setVisibility(0);
            this.tvTitle.setTextColor(Color.parseColor(this.uiType == 0 ? "#222222" : "#FFFFFF"));
            q05.C(this.tvTitle, this.mIsNewUI ? 16.0f : 15.0f);
            this.tvTitle.getPaint().setFakeBoldText(true);
            a aVar = this.selectedListener;
            if (aVar != null && z2) {
                aVar.onSelect(((Integer) getTag()).intValue());
            }
        } else {
            this.btmView.setVisibility(4);
            this.tvTitle.setTextColor(Color.parseColor(this.uiType == 0 ? "#999999" : "#7FFFFFFF"));
            this.tvTitle.getPaint().setFakeBoldText(false);
            q05.C(this.tvTitle, this.mIsNewUI ? 14.0f : 15.0f);
        }
        this.isSelected = z;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setOnSelectedListener(a aVar) {
        this.selectedListener = aVar;
    }

    public void setRedDot(boolean z) {
        this.redDot.setVisibility(z ? 0 : 8);
    }

    public void setViewText(String str) {
        TextView textView = this.tvTitle;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public GiftTabItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isSelected = false;
        this.mIsNewUI = false;
        initUI(context);
    }

    public GiftTabItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isSelected = false;
        this.mIsNewUI = false;
        initUI(context);
    }

    @RequiresApi(api = 21)
    public GiftTabItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.isSelected = false;
        this.mIsNewUI = false;
        initUI(context);
    }
}
