package com.zenmen.palmchat.maintab.tab;

import com.zenmen.palmchat.R;
import com.zenmen.palmchat.maintab.cell.CellViewControllerManager;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class TabItemsManager {

    /* JADX INFO: compiled from: SearchBox */
    public enum BuildInType {
        TAB_MSG("tab_msg"),
        TAB_DISCOVER("tab_discover"),
        TAB_SMALL_VIDEO("tab_small_video"),
        TAB_DYNAMIC("tab_dynamic"),
        TAB_MINE("tab_mine"),
        TAB_SQUARE("tab_square"),
        TAB_PEOPLE_MATCH_JUMP("tab_people_match_jump"),
        TAB_PEOPLE_MATCH("tab_people_match"),
        TAB_TEST_JUMP("tab_square_publish"),
        TAB_FIND_FRIEND("tab_find_friend");

        public String key;

        BuildInType(String str) {
            this.key = str;
        }
    }

    public static boolean a(TabItem tabItem) {
        BuildInType buildInTypeD = d(tabItem);
        if (buildInTypeD == null) {
            return false;
        }
        if (buildInTypeD == BuildInType.TAB_DYNAMIC) {
            if (!b(tabItem) || !f(buildInTypeD, tabItem)) {
                return false;
            }
        } else if (buildInTypeD != BuildInType.TAB_MSG && buildInTypeD != BuildInType.TAB_MINE) {
            return f(buildInTypeD, tabItem);
        }
        return true;
    }

    public static boolean b(TabItem tabItem) {
        List<GroupItem> list;
        boolean z = false;
        if (tabItem != null && (list = tabItem.groups) != null) {
            for (GroupItem groupItem : list) {
                List<CellItem> list2 = groupItem.items;
                if (list2 != null) {
                    Iterator<CellItem> it = list2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (CellViewControllerManager.a(groupItem, it.next())) {
                            z = true;
                            break;
                        }
                    }
                }
            }
        }
        return z;
    }

    public static int c(TabItem tabItem) {
        return tabItem.tag.equals("tab_msg") ? R.drawable.tabbar_icon_msg : (tabItem.tag.equals("tab_dynamic_1") || tabItem.tag.equals("tab_discover")) ? R.drawable.tabbar_icon_discover : tabItem.tag.equals("tab_dynamic_2") ? R.drawable.tabbar_icon_square : tabItem.tag.equals("tab_people_match_jump") ? R.drawable.tabbar_icon_people_match : tabItem.tag.equals("tab_mine") ? R.drawable.tabbar_icon_mine : tabItem.tag.equals("tab_square") ? R.drawable.tabbar_icon_square : tabItem.tag.equals("tab_square_publish") ? R.drawable.ic_main_tab_square_publish : tabItem.tag.equals("tab_small_video") ? R.drawable.tabbar_icon_newvideo : tabItem.tag.equals("tab_find_friend") ? R.drawable.tabbar_icon_find_friend : tabItem.tag.equals("tab_people_match") ? R.drawable.tabbar_icon_people_match : R.drawable.tabbar_icon_default;
    }

    public static BuildInType d(TabItem tabItem) {
        if (e(tabItem.tag)) {
            return BuildInType.TAB_DYNAMIC;
        }
        for (BuildInType buildInType : BuildInType.values()) {
            if (buildInType.key.equals(tabItem.tag)) {
                return buildInType;
            }
        }
        return null;
    }

    public static boolean e(String str) {
        return str.startsWith("tab_dynamic");
    }

    public static boolean f(BuildInType buildInType, TabItem tabItem) {
        boolean zD;
        if (buildInType != BuildInType.TAB_SMALL_VIDEO) {
            if (buildInType == BuildInType.TAB_FIND_FRIEND) {
                zD = TeenagersModeManager.a().d();
            } else {
                if (tabItem.isIgnore) {
                    return false;
                }
                String str = tabItem.invisibleModel;
                if (str != null && str.contains("teenager")) {
                    zD = TeenagersModeManager.a().d();
                }
            }
            return !zD;
        }
        if (TeenagersModeManager.a().d() && TeenagersModeManager.a().b() == TeenagersModeManager.SmallVideoMode.NOT_ACCESS) {
            return false;
        }
        return true;
    }
}
