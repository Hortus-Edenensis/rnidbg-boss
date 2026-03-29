package com.zenmen.square.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.fragment.online.OnlineRecommend;
import com.zenmen.square.ui.widget.TabItemView;
import defpackage.a46;
import defpackage.cy5;
import defpackage.gi5;
import defpackage.l50;
import defpackage.ma3;
import defpackage.qs5;
import defpackage.rs5;
import defpackage.z64;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FindSelectTabView extends LxRelativeLayout implements TabItemView.b, View.OnClickListener {
    private int lastPosition;
    private d listener;
    private View mFilterIcon;
    private View mFilterText;
    private List<TabItemView> mItemViews;
    private List<qs5> mItems;
    private View mOnlineRefreshLayout;
    private View mRedDot;
    private View mSuperExposeTabEnter;
    private View mSuperExposeTipEnterContainer;
    private View mToolLayout;
    private LinearLayout redTextLayout;
    private Map<String, Boolean> redTextShowItem;
    private HorizontalScrollView scrollView;
    private LinearLayout tabLayout;
    private ValueAnimator tipValueAnimator;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            FindSelectTabView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            FindSelectTabView.this.intRedText();
            FindSelectTabView.this.setQfRedTextShow();
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Float) {
                float fFloatValue = ((Float) animatedValue).floatValue();
                if (FindSelectTabView.this.mSuperExposeTipEnterContainer == null || FindSelectTabView.this.mSuperExposeTipEnterContainer.getLayoutParams() == null) {
                    return;
                }
                float f = 1.0f - fFloatValue;
                ViewGroup.LayoutParams layoutParams = FindSelectTabView.this.mSuperExposeTipEnterContainer.getLayoutParams();
                layoutParams.height = (int) (a46.b(FindSelectTabView.this.getContext(), 35.0f) * f);
                FindSelectTabView.this.mSuperExposeTipEnterContainer.setLayoutParams(layoutParams);
                FindSelectTabView.this.mSuperExposeTipEnterContainer.setAlpha(f);
                if (fFloatValue == 1.0f) {
                    FindSelectTabView.this.mSuperExposeTipEnterContainer.setVisibility(8);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f16521a;

        public c(int i) {
            this.f16521a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Float) {
                float fFloatValue = ((Float) animatedValue).floatValue();
                if (FindSelectTabView.this.mSuperExposeTipEnterContainer == null || FindSelectTabView.this.mSuperExposeTipEnterContainer.getLayoutParams() == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = FindSelectTabView.this.mSuperExposeTipEnterContainer.getLayoutParams();
                layoutParams.height = (int) (this.f16521a * fFloatValue);
                FindSelectTabView.this.mSuperExposeTipEnterContainer.setLayoutParams(layoutParams);
                FindSelectTabView.this.mSuperExposeTipEnterContainer.setAlpha(fFloatValue);
                FindSelectTabView.this.mSuperExposeTipEnterContainer.setVisibility(0);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void d();

        int f();

        void onItemSelected(int i);

        void v();
    }

    public FindSelectTabView(Context context) {
        this(context, null);
    }

    private ValueAnimator getTipValueAnimator() {
        if (this.tipValueAnimator == null) {
            this.tipValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
        }
        return this.tipValueAnimator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void intRedText() {
        Iterator<TabItemView> it = this.mItemViews.iterator();
        boolean z = false;
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next().getTag()).intValue();
            if (iIntValue >= 0 && iIntValue < this.mItems.size()) {
                qs5 qs5Var = this.mItems.get(iIntValue);
                if (this.redTextLayout.getChildCount() != this.mItemViews.size()) {
                    if (!z) {
                        this.redTextLayout.removeAllViews();
                        z = true;
                    }
                    TextView textView = new TextView(getContext());
                    textView.setTextColor(-1);
                    textView.setTextSize(1, 9.0f);
                    textView.setGravity(17);
                    textView.setBackgroundResource(qs5Var.f);
                    textView.setText(qs5Var.e);
                    textView.setTag(qs5Var.d);
                    int iB = a46.b(getContext(), 6.0f);
                    textView.setPadding(iB, 0, iB, 0);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a46.b(getContext(), 16.0f));
                    layoutParams.leftMargin = this.mItemViews.get(iIntValue).getRight() - a46.b(getContext(), 8.0f);
                    this.redTextLayout.addView(textView, layoutParams);
                    textView.setVisibility((this.redTextShowItem.containsKey(qs5Var.d) && this.redTextShowItem.get(qs5Var.d).booleanValue()) ? 0 : 8);
                }
            }
        }
    }

    private void updateLineRedDot(TabItemView tabItemView) {
        if (z64.e()) {
            LogUtil.d("OnLineManagerTag", "OnLineManagerRed showLineRed updateLineRedDot ");
            tabItemView.updateDot(1);
            z64.G();
            z64.r();
        }
    }

    private void updateRedTextVisibility() {
        int childCount = this.redTextLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.redTextLayout.getChildAt(i);
            if (childAt != null) {
                if (childAt.getTag() != null) {
                    String str = (String) childAt.getTag();
                    childAt.setVisibility(this.redTextShowItem.containsKey(str) && this.redTextShowItem.get(str).booleanValue() ? 0 : 8);
                } else {
                    childAt.setVisibility(8);
                }
            }
        }
    }

    public void bindTableItems(List<qs5> list, String str) {
        if (list != null) {
            this.mItems = list;
            this.mItemViews.clear();
            this.tabLayout.removeAllViews();
            int i = 0;
            for (qs5 qs5Var : list) {
                TabItemView tabItemView = new TabItemView(getContext());
                tabItemView.setViewText(qs5Var.b);
                tabItemView.setFragmentClass(qs5Var.c);
                tabItemView.setTag(qs5Var);
                tabItemView.setTag(Integer.valueOf(i));
                tabItemView.setRedText(qs5Var.e);
                tabItemView.setHideFilter(qs5Var.g);
                tabItemView.setOnSelectedListener(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                if (i > 0) {
                    layoutParams.leftMargin = a46.b(getContext(), 12.0f);
                }
                this.tabLayout.addView(tabItemView, layoutParams);
                this.mItemViews.add(tabItemView);
                if (TextUtils.equals(qs5Var.c, str)) {
                    tabItemView.setCurrentSelected(true, false);
                    setFilterLayoutVisible(qs5Var.g ? 8 : 0);
                    if (qs5Var.g) {
                        hideSuperExposeTabEnter();
                        hideSuperExposeTipEnter();
                    }
                    if (!TextUtils.isEmpty(qs5Var.e)) {
                        setQfRedTextShow();
                    }
                }
                i++;
                if (OnlineRecommend.class.getName().equals(qs5Var.c)) {
                    LogUtil.d("OnLineManagerTag", "OnLineManagerRed showLineRed init ");
                    updateLineRedDot(tabItemView);
                }
            }
        }
    }

    public void checkLineItemRedDot() {
        List<TabItemView> list = this.mItemViews;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.mItemViews.size(); i++) {
            TabItemView tabItemView = this.mItemViews.get(i);
            if (OnlineRecommend.class.getName().equals(tabItemView.getFragmentClass())) {
                LogUtil.d("OnLineManagerTag", "OnLineManagerRed showLineRed init ");
                updateLineRedDot(tabItemView);
                return;
            }
        }
    }

    public void checkPzjyView() {
        if (this.mItemViews != null) {
            for (int i = 0; i < this.mItemViews.size(); i++) {
                TabItemView tabItemView = this.mItemViews.get(i);
                if (tabItemView.isHideFilter() && tabItemView.getVisibility() == 0) {
                    tabItemView.setVisibility(8);
                }
            }
        }
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View.inflate(context, R$layout.find_friend_select_tab_header, this);
        this.redTextLayout = (LinearLayout) findViewById(R$id.red_text_container);
        this.scrollView = (HorizontalScrollView) findViewById(R$id.scrollView_title);
        this.tabLayout = (LinearLayout) findViewById(R$id.square_tab_select_view);
        View viewFindViewById = findViewById(R$id.rl_tool_layout);
        this.mToolLayout = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        View viewFindViewById2 = findViewById(R$id.online_refresh_icon);
        this.mOnlineRefreshLayout = viewFindViewById2;
        viewFindViewById2.setOnClickListener(this);
        this.mFilterIcon = findViewById(R$id.btn_nearby_filter);
        this.mFilterText = findViewById(R$id.tv_filter_nearby);
        this.mRedDot = findViewById(R$id.v_red_dot);
        this.mSuperExposeTabEnter = findViewById(R$id.super_expose_tab_enter);
        getViewTreeObserver().addOnPreDrawListener(new a());
    }

    public int getCurPageType() {
        d dVar = this.listener;
        if (dVar != null) {
            return dVar.f();
        }
        return 0;
    }

    public int getCurrentIndex() {
        return this.lastPosition;
    }

    public int getRedDotVisible() {
        View view = this.mRedDot;
        if (view != null) {
            return view.getVisibility();
        }
        return 8;
    }

    public View getSuperExposeTabEnter() {
        return this.mSuperExposeTabEnter;
    }

    public View getSuperExposeTipEnterContainer() {
        return this.mSuperExposeTipEnterContainer;
    }

    public void hideLineRedDot() {
        List<TabItemView> list = this.mItemViews;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.mItemViews.size(); i++) {
            TabItemView tabItemView = this.mItemViews.get(i);
            if (OnlineRecommend.class.getName().equals(tabItemView.getFragmentClass())) {
                LogUtil.d("OnLineManagerTag", "OnLineManagerRed hideLineRedDot done ");
                tabItemView.updateDot(0);
                SPUtil.f14322a.v(SPUtil.SCENE.ONLINE, "KEY_ONLINE_RED_DOT_SHOW", Long.valueOf(System.currentTimeMillis()));
                return;
            }
        }
    }

    public void hideSuperExposeTabEnter() {
        View view = this.mSuperExposeTabEnter;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void hideSuperExposeTipEnter() {
        hideSuperExposeTipEnter(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (l50.a() || this.listener == null) {
            return;
        }
        int id = view.getId();
        if (id == R$id.rl_tool_layout) {
            this.listener.d();
        } else if (id == R$id.online_refresh_icon) {
            this.listener.v();
        }
    }

    @Override // com.zenmen.square.ui.widget.TabItemView.b
    public void onItemSelect(int i) {
        d dVar = this.listener;
        if (dVar != null) {
            dVar.onItemSelected(i);
        }
    }

    public void onSelect(int i) {
        selectedTargetItem(i, false);
    }

    public void reBindItems(List<qs5> list) {
        bindTableItems(list, "");
        selectedTargetItem(this.lastPosition, false);
    }

    public void selectedTargetItem(int i, boolean z) {
        View viewFindViewWithTag = findViewWithTag(Integer.valueOf(this.lastPosition));
        if (viewFindViewWithTag instanceof TabItemView) {
            ((TabItemView) viewFindViewWithTag).setCurrentSelected(false, z);
        }
        View viewFindViewWithTag2 = findViewWithTag(Integer.valueOf(i));
        if (viewFindViewWithTag2 instanceof TabItemView) {
            TabItemView tabItemView = (TabItemView) viewFindViewWithTag2;
            tabItemView.setCurrentSelected(true, z);
            setFilterLayoutVisible(tabItemView.isHideFilter() ? 8 : 0);
            if (tabItemView.isHideFilter()) {
                hideSuperExposeTabEnter();
                hideSuperExposeTipEnter();
            }
            if (!TextUtils.isEmpty(tabItemView.getRedText())) {
                setQfRedTextShow();
            }
        }
        this.lastPosition = i;
    }

    public void setCondIconEnable(boolean z) {
        this.mFilterIcon.setEnabled(z);
        this.mFilterText.setEnabled(z);
        this.mToolLayout.setEnabled(z);
    }

    public void setCondIconSelected(boolean z) {
        this.mFilterIcon.setSelected(z);
        this.mFilterText.setSelected(z);
        this.mToolLayout.setSelected(z);
    }

    public void setFilterLayoutVisible(int i) {
        View view = this.mToolLayout;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public void setHeaderViewEventListener(d dVar) {
        this.listener = dVar;
    }

    public void setItemRedTextShow(String str, boolean z) {
        this.redTextShowItem.put(str, Boolean.valueOf(z));
        updateRedTextVisibility();
    }

    public void setOnlineRefreshVisible(int i) {
        View view = this.mOnlineRefreshLayout;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public void setQfRedTextShow() {
        try {
            ma3.a("setQfRedTextShow run", new Object[0]);
            rs5 rs5VarB = gi5.b();
            if (rs5VarB == null || !rs5VarB.f20561a) {
                return;
            }
            ma3.a("setQfRedTextShow switch enabled", new Object[0]);
            long jM = cy5.m(rs5VarB.b, "yyyy-MM-dd HH:mm:ss");
            long jM2 = cy5.m(rs5VarB.c, "yyyy-MM-dd HH:mm:ss");
            long jCurrentTimeMillis = System.currentTimeMillis();
            setItemRedTextShow("qualityfriendship", jCurrentTimeMillis >= jM && jCurrentTimeMillis <= jM2);
            ma3.a("setQfRedTextShow redText show", new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRedDotVisible(int i) {
        View view = this.mRedDot;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public void setSuperExposeTipEnterContainer(View view) {
        this.mSuperExposeTipEnterContainer = view;
    }

    public void showImageBg(boolean z) {
        if (z) {
            findViewById(R$id.topBgView).setVisibility(0);
            setBackgroundColor(0);
        } else {
            findViewById(R$id.topBgView).setVisibility(8);
            setBackgroundColor(-1);
        }
    }

    public void showSuperExposeTipEnter(int i) {
        View view = this.mSuperExposeTipEnterContainer;
        if (view != null) {
            if (view.getHeight() == i && this.mSuperExposeTipEnterContainer.getVisibility() == 0) {
                return;
            }
            ValueAnimator tipValueAnimator = getTipValueAnimator();
            tipValueAnimator.removeAllUpdateListeners();
            tipValueAnimator.addUpdateListener(new c(i));
            tipValueAnimator.cancel();
            tipValueAnimator.start();
        }
    }

    public void showTabTitlePosition(int i, int i2) {
        if (this.mItemViews.size() > 3) {
            if (i < 2) {
                this.scrollView.scrollTo(0, 0);
                return;
            }
            int width = this.mItemViews.get(0).getWidth();
            LogUtil.d("", "showTabTitlePosition currentPosition " + i + " firstItemWidth " + width);
            if (width > 0) {
                this.scrollView.smoothScrollBy(width * 1, 0);
            }
        }
    }

    public FindSelectTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void hideSuperExposeTipEnter(boolean z) {
        if (this.mSuperExposeTipEnterContainer.getHeight() == 0 || this.mSuperExposeTipEnterContainer.getVisibility() == 8) {
            return;
        }
        ValueAnimator tipValueAnimator = getTipValueAnimator();
        tipValueAnimator.removeAllUpdateListeners();
        tipValueAnimator.addUpdateListener(new b());
        tipValueAnimator.cancel();
        tipValueAnimator.start();
    }

    public FindSelectTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mItems = new ArrayList();
        this.mItemViews = new ArrayList();
        this.redTextShowItem = new HashMap();
        this.tipValueAnimator = null;
        this.lastPosition = 0;
    }

    @RequiresApi(api = 21)
    public FindSelectTabView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mItems = new ArrayList();
        this.mItemViews = new ArrayList();
        this.redTextShowItem = new HashMap();
        this.tipValueAnimator = null;
        this.lastPosition = 0;
    }

    public void showSuperExposeTabEnter() {
    }

    public void showSuperExposeTabEnterWithAnim(boolean z) {
    }
}
