package com.zenmen.palmchat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.maintab.config.TabItem;
import com.zenmen.palmchat.maintab.tab.TabItemsManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.me1;
import defpackage.pe5;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class TabsBarLayout extends RelativeLayout implements View.OnClickListener, View.OnLongClickListener {
    public LinearLayout contentLayout;
    private boolean isTabSelectable;
    public ArrayList<TabsBarItem> items;
    private a mOnTabLongClickListener;
    private b mOnTabSelectListener;
    public TabsBarItem mTabVideo;
    public ArrayList<TabItem> mTabs;
    public View tabSep;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        boolean a(TabItem tabItem, int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(TabItem tabItem, int i);
    }

    public TabsBarLayout(Context context) {
        this(context, null);
    }

    private int getIndexByTab(TabItem tabItem) {
        int i = -1;
        for (int i2 = 0; i2 < this.mTabs.size(); i2++) {
            TabItem tabItem2 = this.mTabs.get(i2);
            if (!tabItem2.isAdditionalTab()) {
                i++;
                if (tabItem == tabItem2) {
                    break;
                }
            }
        }
        return i;
    }

    private TabItem getTabByIndex(int i) {
        TabItem tabItem = null;
        int i2 = -1;
        for (int i3 = 0; i3 < this.mTabs.size(); i3++) {
            TabItem tabItem2 = this.mTabs.get(i3);
            if (!tabItem2.isAdditionalTab() && (i2 = i2 + 1) == i) {
                tabItem = tabItem2;
            }
        }
        return tabItem;
    }

    private TabsBarItem initItem(TabItem tabItem) {
        TabsBarItem tabsBarItem = new TabsBarItem(getContext());
        tabsBarItem.setRedDotShow(false);
        tabsBarItem.setBadgeShow(false);
        tabsBarItem.setTag(tabItem);
        tabsBarItem.setTitle(tabItem.getNameForShow());
        tabsBarItem.setIcon(null, null, Integer.valueOf(TabItemsManager.c(tabItem)));
        Pair<String, String> pairC = pe5.a().c(tabItem);
        if (pairC != null) {
            tabsBarItem.setIcon((String) pairC.first, (String) pairC.second, null);
        } else if (!TextUtils.isEmpty(tabItem.icon) && !TextUtils.isEmpty(tabItem.selectedIcon)) {
            tabsBarItem.setIcon(tabItem.icon, tabItem.selectedIcon, null);
        }
        tabsBarItem.setSelectable(this.isTabSelectable);
        tabsBarItem.onSelected(false);
        tabsBarItem.setOnClickListener(this);
        tabsBarItem.setOnLongClickListener(this);
        if (tabItem.isVideoTab()) {
            if (!com.zenmen.palmchat.smallvideo.a.b()) {
                tabsBarItem.setIconStyle();
            }
            this.mTabVideo = tabsBarItem;
        }
        return tabsBarItem;
    }

    private void initViews() {
        View viewInflate = View.inflate(getContext(), R.layout.layout_dynamic_tabs_bar, this);
        setBackgroundColor(getResources().getColor(R.color.lx_tab_bar_bg));
        this.contentLayout = (LinearLayout) viewInflate.findViewById(R.id.contentLayout);
        this.tabSep = viewInflate.findViewById(R.id.tabSep);
    }

    private void set(TabItem tabItem) {
        if (tabItem.isAdditionalTab()) {
            return;
        }
        int childCount = this.contentLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            TabsBarItem tabsBarItem = (TabsBarItem) this.contentLayout.getChildAt(i);
            if (tabItem == tabsBarItem.getTag()) {
                tabsBarItem.onSelected(true);
            } else {
                tabsBarItem.onSelected(false);
            }
        }
    }

    public void addItem(TabItem tabItem, int i) {
        this.mTabs.add(i, tabItem);
        this.contentLayout.addView(initItem(tabItem), i, new LinearLayout.LayoutParams(me1.b(getContext(), 78), -1));
    }

    public TabsBarItem getTabsBarItemByTag(String str) {
        int childCount = this.contentLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.contentLayout.getChildAt(i);
            TabItem tabItem = (TabItem) childAt.getTag();
            if (tabItem != null && tabItem.tag.equals(str)) {
                return (TabsBarItem) childAt;
            }
        }
        return null;
    }

    public TabsBarItem getTabsBarItemView(TabItem tabItem) {
        int childCount = this.contentLayout.getChildCount();
        TabsBarItem tabsBarItem = null;
        for (int i = 0; i < childCount; i++) {
            TabsBarItem tabsBarItem2 = (TabsBarItem) this.contentLayout.getChildAt(i);
            if (tabItem == tabsBarItem2.getTag()) {
                tabsBarItem = tabsBarItem2;
            }
        }
        return tabsBarItem;
    }

    public void logViewStatus(String str) {
        int childCount = this.contentLayout.getChildCount();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < childCount; i++) {
                TabsBarItem tabsBarItem = (TabsBarItem) this.contentLayout.getChildAt(i);
                TabItem tabItem = (TabItem) tabsBarItem.getTag();
                if (tabItem != null && tabItem.isEnable()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", tabItem.kitCode);
                    jSONObject2.put("type", tabsBarItem.getViewStatus());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("tabs", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.uploadInfoImmediate(str, null, null, jSONObject.toString());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TabItem tabItem = (TabItem) view.getTag();
        set(tabItem);
        b bVar = this.mOnTabSelectListener;
        if (bVar != null) {
            bVar.a(tabItem, getIndexByTab(tabItem));
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        TabItem tabItem = (TabItem) view.getTag();
        set(tabItem);
        a aVar = this.mOnTabLongClickListener;
        if (aVar != null) {
            return aVar.a(tabItem, getIndexByTab(tabItem));
        }
        return false;
    }

    public void removeItem(TabItem tabItem) {
        this.mTabs.remove(tabItem);
        int i = -1;
        for (int i2 = 0; i2 < this.contentLayout.getChildCount(); i2++) {
            if (((TabItem) ((TabsBarItem) this.contentLayout.getChildAt(i2)).getTag()) == tabItem) {
                i = i2;
            }
        }
        if (i != -1) {
            this.contentLayout.removeViewAt(i);
        }
    }

    public void setIndex(int i) {
        set(getTabByIndex(i));
    }

    public void setOnTabLongClickListener(a aVar) {
        this.mOnTabLongClickListener = aVar;
    }

    public void setOnTabSelectListener(b bVar) {
        this.mOnTabSelectListener = bVar;
    }

    public void setTabItemSelectable(boolean z) {
        this.isTabSelectable = z;
        int childCount = this.contentLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((TabsBarItem) this.contentLayout.getChildAt(i)).setSelectable(z);
        }
        setIndex(0);
    }

    public void updateItemWidth() {
        int childCount = this.contentLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.contentLayout.getChildAt(i);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            childAt.setLayoutParams(layoutParams);
        }
    }

    public void updateItems(List<TabItem> list) {
        this.contentLayout.removeAllViews();
        if (list != null) {
            this.mTabs.clear();
            this.mTabs.addAll(list);
            int i = 0;
            while (i < list.size()) {
                TabItem tabItem = list.get(i);
                TabsBarItem tabsBarItemInitItem = initItem(tabItem);
                tabsBarItemInitItem.onSelected(i == 0);
                int i2 = !"tab_small_video".equals(tabItem.tag) ? 1 : 0;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
                layoutParams.weight = i2;
                this.contentLayout.addView(tabsBarItemInitItem, layoutParams);
                i++;
            }
        }
    }

    public TabsBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabsBarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTabs = new ArrayList<>();
        this.items = new ArrayList<>();
        this.isTabSelectable = true;
        initViews();
    }

    public TabsBarItem getTabsBarItemView(String str) {
        int childCount = this.contentLayout.getChildCount();
        TabsBarItem tabsBarItem = null;
        for (int i = 0; i < childCount; i++) {
            TabsBarItem tabsBarItem2 = (TabsBarItem) this.contentLayout.getChildAt(i);
            TabItem tabItem = (TabItem) tabsBarItem2.getTag();
            if (tabItem != null && tabItem.tag.equals(str)) {
                tabsBarItem = tabsBarItem2;
            }
        }
        return tabsBarItem;
    }

    public void updateItemWidth(boolean z, int i) {
        int childCount = this.contentLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.contentLayout.getChildAt(i2);
            TabItem tabItem = (TabItem) childAt.getTag();
            boolean z2 = tabItem != null && tabItem.isVideoTab();
            if (z) {
                if (z2) {
                    childAt.setLayoutParams(new LinearLayout.LayoutParams(i, -1));
                }
            } else if (!z2) {
                childAt.setLayoutParams(new LinearLayout.LayoutParams(i, -1));
            }
        }
    }
}
