package defpackage;

import com.zenmen.palmchat.widget.TabsBarItem;
import com.zenmen.palmchat.widget.TabsBarLayout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class os5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TabsBarItem f19865a;

    public os5(TabsBarItem tabsBarItem) {
        this.f19865a = tabsBarItem;
    }

    public static os5 a(TabsBarLayout tabsBarLayout, String str) {
        return new os5(tabsBarLayout.getTabsBarItemView(str));
    }

    public void b(int i) {
        TabsBarItem tabsBarItem = this.f19865a;
        if (tabsBarItem != null) {
            tabsBarItem.setBadgeCount(i);
        }
    }

    public void c(boolean z) {
        TabsBarItem tabsBarItem = this.f19865a;
        if (tabsBarItem != null) {
            tabsBarItem.setBadgeShow(z);
        }
    }

    public void d(boolean z) {
        TabsBarItem tabsBarItem = this.f19865a;
        if (tabsBarItem != null) {
            tabsBarItem.setRedDotShow(z);
        }
    }

    public void e(String str) {
        TabsBarItem tabsBarItem = this.f19865a;
        if (tabsBarItem != null) {
            tabsBarItem.showDynamicIcon(str);
        }
    }
}
