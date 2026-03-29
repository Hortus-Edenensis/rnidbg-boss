package com.zenmen.square.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.dynamiclife.PersonalDynamicLifeFragment;
import com.zenmen.square.ui.widget.NestDynamicLifeTabItemView;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NestDynamicLifeTabHeaderView extends LxRelativeLayout implements NestDynamicLifeTabItemView.a, View.OnClickListener {
    private int lastPosition;
    private a listener;
    private boolean showTab;
    private TextView singleText;
    private LinearLayout tabLayout;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void onItemSelected(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements Comparable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16541a;
        public String b;
        public String c;

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NonNull b bVar) {
            return this.f16541a > bVar.f16541a ? 1 : -1;
        }
    }

    public NestDynamicLifeTabHeaderView(Context context) {
        this(context, null);
    }

    public void bindTableItems(List<b> list) {
        if (list != null) {
            this.tabLayout.removeAllViews();
            int i = 0;
            for (b bVar : list) {
                NestDynamicLifeTabItemView nestDynamicLifeTabItemView = new NestDynamicLifeTabItemView(getContext());
                nestDynamicLifeTabItemView.setViewText(bVar.b);
                nestDynamicLifeTabItemView.setTag(bVar);
                nestDynamicLifeTabItemView.setTag(Integer.valueOf(i));
                nestDynamicLifeTabItemView.setOnSelectedListener(this);
                nestDynamicLifeTabItemView.setGravity(17);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
                layoutParams.weight = 1.0f;
                layoutParams.gravity = 17;
                this.tabLayout.addView(nestDynamicLifeTabItemView, layoutParams);
                if (bVar.c.equals(PersonalDynamicLifeFragment.class.getName())) {
                    this.singleText.setText(bVar.b);
                }
                i++;
            }
        }
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View.inflate(context, R$layout.nest_dynamic_life_layout_select_tab_header, this);
        this.tabLayout = (LinearLayout) findViewById(R$id.square_tab_select_view);
        this.singleText = (TextView) findViewById(R$id.single_text);
    }

    public int getCurrentIndex() {
        return this.lastPosition;
    }

    public boolean isShowTab() {
        return this.showTab;
    }

    @Override // com.zenmen.square.ui.widget.NestDynamicLifeTabItemView.a
    public void onSelect(int i) {
        selectedTargetItem(i);
        a aVar = this.listener;
        if (aVar != null) {
            aVar.onItemSelected(i);
        }
    }

    public void selectedTargetItem(int i) {
        View viewFindViewWithTag = findViewWithTag(Integer.valueOf(this.lastPosition));
        if (viewFindViewWithTag instanceof NestDynamicLifeTabItemView) {
            ((NestDynamicLifeTabItemView) viewFindViewWithTag).setCurrentSelected(false, false);
        }
        View viewFindViewWithTag2 = findViewWithTag(Integer.valueOf(i));
        if (viewFindViewWithTag2 instanceof NestDynamicLifeTabItemView) {
            ((NestDynamicLifeTabItemView) viewFindViewWithTag2).setCurrentSelected(true, false);
        }
        this.lastPosition = i;
    }

    public void setHeaderViewEventListener(a aVar) {
        this.listener = aVar;
    }

    public void showTabLayout(boolean z) {
        this.showTab = z;
        this.tabLayout.setVisibility(z ? 0 : 8);
        this.singleText.setVisibility(z ? 8 : 0);
    }

    public void updateTabTitle(int i, b bVar, String str) {
        if (!this.showTab && PersonalDynamicLifeFragment.class.getName().equals(bVar.c)) {
            this.singleText.setText(str);
            return;
        }
        View viewFindViewWithTag = findViewWithTag(Integer.valueOf(i));
        if (viewFindViewWithTag == null || !(viewFindViewWithTag instanceof NestDynamicLifeTabItemView)) {
            return;
        }
        ((NestDynamicLifeTabItemView) viewFindViewWithTag).setViewText(str);
    }

    public NestDynamicLifeTabHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestDynamicLifeTabHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lastPosition = 0;
    }

    @RequiresApi(api = 21)
    public NestDynamicLifeTabHeaderView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.lastPosition = 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
