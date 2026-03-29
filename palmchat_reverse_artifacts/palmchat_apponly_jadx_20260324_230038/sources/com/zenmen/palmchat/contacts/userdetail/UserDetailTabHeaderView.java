package com.zenmen.palmchat.contacts.userdetail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.palmchat.R;
import com.zenmen.square.moments.PersonalMomentsFragment;
import com.zenmen.square.ui.widget.NestDynamicLifeTabHeaderView;
import com.zenmen.square.ui.widget.NestDynamicLifeTabItemView;
import defpackage.me1;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class UserDetailTabHeaderView extends LxRelativeLayout implements NestDynamicLifeTabItemView.a, View.OnClickListener {
    private int lastPosition;
    private a listener;
    private boolean showTab;
    private LinearLayout tabLayout;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void onItemSelected(int i);
    }

    public UserDetailTabHeaderView(Context context) {
        this(context, null);
    }

    public void bindTableItems(boolean z, List<NestDynamicLifeTabHeaderView.b> list) {
        if (list != null) {
            this.tabLayout.removeAllViews();
            int i = 0;
            for (NestDynamicLifeTabHeaderView.b bVar : list) {
                if (z || !bVar.c.equals(PersonalMomentsFragment.class.getName())) {
                    NestDynamicLifeTabItemView nestDynamicLifeTabItemView = new NestDynamicLifeTabItemView(getContext());
                    nestDynamicLifeTabItemView.setViewText(bVar.b);
                    nestDynamicLifeTabItemView.setTag(bVar);
                    nestDynamicLifeTabItemView.setTag(Integer.valueOf(i));
                    nestDynamicLifeTabItemView.setOnSelectedListener(this);
                    nestDynamicLifeTabItemView.setGravity(17);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                    if (i == 0) {
                        layoutParams.leftMargin = me1.b(getContext(), 8);
                    } else {
                        layoutParams.leftMargin = me1.b(getContext(), 4);
                    }
                    layoutParams.rightMargin = me1.b(getContext(), 0);
                    layoutParams.gravity = 17;
                    this.tabLayout.addView(nestDynamicLifeTabItemView, layoutParams);
                    i++;
                }
            }
        }
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View.inflate(context, R.layout.user_detail_tab_header, this);
        this.tabLayout = (LinearLayout) findViewById(R.id.square_tab_select_view);
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
    }

    public void updateTabTitle(int i, NestDynamicLifeTabHeaderView.b bVar, String str, boolean z) {
        View viewFindViewWithTag = findViewWithTag(Integer.valueOf(i));
        if (viewFindViewWithTag instanceof NestDynamicLifeTabItemView) {
            NestDynamicLifeTabItemView nestDynamicLifeTabItemView = (NestDynamicLifeTabItemView) viewFindViewWithTag;
            nestDynamicLifeTabItemView.setViewText(str);
            if (z) {
                nestDynamicLifeTabItemView.showDot();
            }
        }
    }

    public UserDetailTabHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UserDetailTabHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lastPosition = 0;
    }

    @RequiresApi(api = 21)
    public UserDetailTabHeaderView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.lastPosition = 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
