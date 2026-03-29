package com.zenmen.square.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.SquareMessageActivity;
import com.zenmen.square.support.SquareSingleton;
import com.zenmen.square.ui.widget.MessageTabItemView;
import defpackage.a46;
import defpackage.d46;
import defpackage.e46;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class MessageTabHeaderView extends LxRelativeLayout implements MessageTabItemView.a {
    private SquareMessageActivity.Tab lastTab;
    private b listener;
    private List<MessageTabItemView> mItemViews;
    private LinearLayout tabLayout;
    private d46 unReadMessageChangeListener;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends e46 {
        public a() {
        }

        @Override // defpackage.e46, defpackage.d46
        public void c(int i) {
            MessageTabHeaderView.this.updateRedDot();
        }

        @Override // defpackage.d46
        public void e(int i) {
            MessageTabHeaderView.this.updateRedDot();
        }

        @Override // defpackage.d46
        public void f(int i) {
            MessageTabHeaderView.this.updateRedDot();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void T0(SquareMessageActivity.Tab tab);
    }

    public MessageTabHeaderView(Context context) {
        this(context, null);
    }

    private void selectedTargetItem(SquareMessageActivity.Tab tab) {
        View viewFindViewWithTag = findViewWithTag(this.lastTab);
        if (viewFindViewWithTag instanceof MessageTabItemView) {
            ((MessageTabItemView) viewFindViewWithTag).setCurrentSelected(false, false);
        }
        View viewFindViewWithTag2 = findViewWithTag(tab);
        if (viewFindViewWithTag2 instanceof MessageTabItemView) {
            ((MessageTabItemView) viewFindViewWithTag2).setCurrentSelected(true, false);
        }
        this.lastTab = tab;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRedDot() {
        for (MessageTabItemView messageTabItemView : this.mItemViews) {
            if (messageTabItemView.getTag() == SquareMessageActivity.Tab.SQUARE) {
                messageTabItemView.updateDot(SquareSingleton.getInstance().getLastPraiseUnReadCount() + SquareSingleton.getInstance().getLastCommentUnReadCount());
            } else if (messageTabItemView.getTag() == SquareMessageActivity.Tab.FRIEND) {
                messageTabItemView.updateDot(SquareSingleton.getInstance().getFriendMsgUnReadCount());
            }
        }
    }

    public void bindTabItems(SquareMessageActivity.Tab[] tabArr, SquareMessageActivity.Tab tab) {
        if (tabArr != null) {
            this.mItemViews.clear();
            this.tabLayout.removeAllViews();
            int i = 0;
            for (SquareMessageActivity.Tab tab2 : tabArr) {
                MessageTabItemView messageTabItemView = new MessageTabItemView(getContext());
                messageTabItemView.setViewText(tab2.getTitle());
                messageTabItemView.setTag(tab2);
                messageTabItemView.setOnSelectedListener(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                if (i > 0) {
                    layoutParams.leftMargin = a46.b(getContext(), 90.0f);
                }
                this.tabLayout.addView(messageTabItemView, layoutParams);
                this.mItemViews.add(messageTabItemView);
                if (tab2 == tab) {
                    messageTabItemView.setCurrentSelected(true, false);
                }
                i++;
            }
        }
        updateRedDot();
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View.inflate(context, R$layout.square_layout_message_tab_header, this);
        this.tabLayout = (LinearLayout) findViewById(R$id.square_tab_select_view);
    }

    public SquareMessageActivity.Tab getCurrentIndex() {
        return this.lastTab;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SquareSingleton.getInstance().registerCountChangeListener(this.unReadMessageChangeListener);
        updateRedDot();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SquareSingleton.getInstance().unRegisterCountChangeListener(this.unReadMessageChangeListener);
    }

    @Override // com.zenmen.square.ui.widget.MessageTabItemView.a
    public void onSelect(SquareMessageActivity.Tab tab) {
        selectedTargetItem(tab);
        b bVar = this.listener;
        if (bVar != null) {
            bVar.T0(tab);
        }
    }

    public void setHeaderViewEventListener(b bVar) {
        this.listener = bVar;
    }

    public MessageTabHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MessageTabHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mItemViews = new ArrayList();
        this.lastTab = null;
        this.unReadMessageChangeListener = new a();
    }

    @RequiresApi(api = 21)
    public MessageTabHeaderView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mItemViews = new ArrayList();
        this.lastTab = null;
        this.unReadMessageChangeListener = new a();
    }
}
