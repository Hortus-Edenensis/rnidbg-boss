package com.zenmen.palmchat.giftkit.widgit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.zenmen.giftkit.R$id;
import com.zenmen.giftkit.R$layout;
import com.zenmen.giftkit.R$styleable;
import com.zenmen.palmchat.chat.ChatGiftConfig;
import com.zenmen.palmchat.giftkit.widgit.GiftTabItemView;
import defpackage.me1;
import defpackage.yw1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class GiftTabHeaderView extends RelativeLayout implements GiftTabItemView.a, View.OnClickListener {
    private TextView amountView;
    private int lastPosition;
    private b listener;
    private boolean mIsNewUI;
    private GiftTabItemView packGiftTabItemView;
    private LinearLayout tabLayout;
    private int uiType;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GiftTabHeaderView.this.listener != null) {
                GiftTabHeaderView.this.listener.a();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a();

        void onItemSelected(int i);
    }

    public GiftTabHeaderView(Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mIsNewUI = com.zenmen.palmchat.giftkit.a.a().c() && ChatGiftConfig.getChatGiftConfig().gift_newpanel;
        int i = context.obtainStyledAttributes(attributeSet, R$styleable.GiftPanel).getInt(R$styleable.GiftPanel_ui_type, 0);
        this.uiType = i;
        View.inflate(context, i == 0 ? R$layout.layout_gift_tab_header_light : R$layout.layout_gift_tab_header_dark, this);
        this.tabLayout = (LinearLayout) findViewById(R$id.tab_select_view);
        View viewFindViewById = findViewById(R$id.rl_tool_layout);
        if (this.mIsNewUI && this.uiType == 0) {
            viewFindViewById.setVisibility(8);
        }
        this.amountView = (TextView) findViewById(R$id.tv_amount);
        findViewById(R$id.ll_recharge).setOnClickListener(new a());
        initItems(0);
    }

    public int getCurrentIndex() {
        return this.lastPosition;
    }

    public void initItems(int i) {
        this.tabLayout.removeAllViews();
        GiftTabItemView giftTabItemView = new GiftTabItemView(getContext(), this.uiType);
        giftTabItemView.setViewText("礼物");
        giftTabItemView.setTag(0);
        giftTabItemView.setOnSelectedListener(this);
        this.tabLayout.addView(giftTabItemView, new LinearLayout.LayoutParams(-2, -1));
        giftTabItemView.setCurrentSelected(true, false);
        if (i != 801) {
            GiftTabItemView giftTabItemView2 = new GiftTabItemView(getContext(), this.uiType);
            giftTabItemView2.setViewText("背包");
            giftTabItemView2.setTag(1);
            giftTabItemView2.setOnSelectedListener(this);
            this.tabLayout.addView(giftTabItemView2, new LinearLayout.LayoutParams(-2, -1));
            this.packGiftTabItemView = giftTabItemView2;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i = this.mIsNewUI ? 50 : 46;
        if (getLayoutParams() != null) {
            getLayoutParams().height = me1.b(getContext(), i);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.zenmen.palmchat.giftkit.widgit.GiftTabItemView.a
    public void onSelect(int i) {
        selectedTargetItem(i, false);
        b bVar = this.listener;
        if (bVar != null) {
            bVar.onItemSelected(i);
        }
    }

    public void selectedTargetItem(int i, boolean z) {
        View viewFindViewWithTag = findViewWithTag(Integer.valueOf(this.lastPosition));
        if (viewFindViewWithTag instanceof GiftTabItemView) {
            ((GiftTabItemView) viewFindViewWithTag).setCurrentSelected(false, z);
        }
        View viewFindViewWithTag2 = findViewWithTag(Integer.valueOf(i));
        if (viewFindViewWithTag2 instanceof GiftTabItemView) {
            ((GiftTabItemView) viewFindViewWithTag2).setCurrentSelected(true, z);
        }
        this.lastPosition = i;
    }

    public void setHeaderViewEventListener(b bVar) {
        this.listener = bVar;
    }

    public void updateBalance(long j) {
        this.amountView.setText(j + "");
    }

    public void updateFirstChargeGuideInfo(yw1 yw1Var) {
        View viewFindViewById = findViewById(R$id.room_first_charge);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
            this.amountView.setMaxWidth(me1.b(getContext(), 200));
        }
    }

    public void updatePackStatus(boolean z) {
        this.packGiftTabItemView.setRedDot(z);
    }

    public GiftTabHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GiftTabHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsNewUI = false;
        this.lastPosition = 0;
        init(context, attributeSet);
    }

    @RequiresApi(api = 21)
    public GiftTabHeaderView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mIsNewUI = false;
        this.lastPosition = 0;
        init(context, attributeSet);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
