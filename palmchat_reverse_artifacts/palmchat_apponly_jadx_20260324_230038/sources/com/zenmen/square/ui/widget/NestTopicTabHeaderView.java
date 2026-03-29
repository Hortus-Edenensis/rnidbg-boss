package com.zenmen.square.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.ui.widget.NestTopicTabItemView;
import defpackage.a46;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NestTopicTabHeaderView extends LxRelativeLayout implements NestTopicTabItemView.a, View.OnClickListener {
    private int lastPosition;
    private a listener;
    private List<b> mItems;
    private LinearLayout tabLayout;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void onItemSelected(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f16542a;
        public String b;
    }

    public NestTopicTabHeaderView(Context context) {
        this(context, null);
    }

    private void selectedTargetItem(int i) {
        View viewFindViewWithTag = findViewWithTag(Integer.valueOf(this.lastPosition));
        if (viewFindViewWithTag instanceof NestTopicTabItemView) {
            ((NestTopicTabItemView) viewFindViewWithTag).setCurrentSelected(false, false);
        }
        View viewFindViewWithTag2 = findViewWithTag(Integer.valueOf(i));
        if (viewFindViewWithTag2 instanceof NestTopicTabItemView) {
            ((NestTopicTabItemView) viewFindViewWithTag2).setCurrentSelected(true, false);
        }
        this.lastPosition = i;
    }

    public void bindTableItems(List<b> list, String str) {
        if (list != null) {
            this.mItems = list;
            this.tabLayout.removeAllViews();
            int i = 0;
            for (b bVar : list) {
                NestTopicTabItemView nestTopicTabItemView = new NestTopicTabItemView(getContext());
                nestTopicTabItemView.setViewText(bVar.f16542a);
                nestTopicTabItemView.setTag(bVar);
                nestTopicTabItemView.setTag(Integer.valueOf(i));
                nestTopicTabItemView.setOnSelectedListener(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                if (i > 0) {
                    layoutParams.leftMargin = a46.b(getContext(), 30.0f);
                }
                this.tabLayout.addView(nestTopicTabItemView, layoutParams);
                if (TextUtils.equals(bVar.b, str)) {
                    nestTopicTabItemView.setCurrentSelected(true, false);
                }
                i++;
            }
        }
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View.inflate(context, R$layout.nest_topic_layout_select_tab_header, this);
        this.tabLayout = (LinearLayout) findViewById(R$id.square_tab_select_view);
    }

    public int getCurrentIndex() {
        return this.lastPosition;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.zenmen.square.ui.widget.NestTopicTabItemView.a
    public void onSelect(int i) {
        selectedTargetItem(i);
        a aVar = this.listener;
        if (aVar != null) {
            aVar.onItemSelected(i);
        }
    }

    public void setHeaderViewEventListener(a aVar) {
        this.listener = aVar;
    }

    public NestTopicTabHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestTopicTabHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mItems = new ArrayList();
        this.lastPosition = 0;
    }

    @RequiresApi(api = 21)
    public NestTopicTabHeaderView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mItems = new ArrayList();
        this.lastPosition = 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
