package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.maintab.cell.CellViewControllerManager;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.ConfigInfo;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;
import com.zenmen.palmchat.maintab.config.TurnInfo;
import com.zenmen.palmchat.maintab.skin.vo.SkinConfig;
import com.zenmen.palmchat.maintab.tab.TabItemsManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.show.ShowMainActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ec3 {
    public static ec3 d;
    public static final String e = nl0.z + "/menu.get.v1";
    public static boolean f = false;
    public static boolean g = false;
    public static boolean h = false;
    public static boolean i = false;
    public static boolean j = false;
    public static boolean k = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConfigInfo f17268a = null;
    public long b = 0;
    public ConfigInfo c = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17269a;

        /* JADX INFO: renamed from: ec3$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1189a extends HashMap<String, Object> {
            public C1189a() {
                put("status", 1);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ yy2 f17271a;

            public b(yy2 yy2Var) {
                this.f17271a = yy2Var;
                put("status", 2);
                if (yy2Var != null) {
                    put("code", Integer.valueOf(yy2Var.b));
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c extends HashMap<String, Object> {
            public c() {
                put("status", 3);
            }
        }

        public a(String str) {
            this.f17269a = str;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            exc.printStackTrace();
            LogUtil.i("MainTabConfigManger", "onFail" + exc);
            LogUtil.uploadInfoImmediateWithRateCheck("cfg_new", new c());
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            LogUtil.i("MainTabConfigManger", "onSuccess" + jSONObject);
            if (yy2Var == null || !yy2Var.f22300a || yy2Var.d == null || ec3.g) {
                LogUtil.uploadInfoImmediateWithRateCheck("cfg_new", new b(yy2Var));
                return;
            }
            SPUtil.f14322a.t(SPUtil.SCENE.MAINTAB_CONFIG, "key_main_tabconfig_update_time_V2", Long.valueOf(ec3.this.b));
            ConfigInfo configInfo = (ConfigInfo) az2.a(yy2Var.d.toString(), ConfigInfo.class);
            LogUtil.i("MainTabConfigManger", "ConfigInfo" + configInfo);
            ec3.this.x(configInfo, this.f17269a);
            LogUtil.uploadInfoImmediateWithRateCheck("cfg_new", new C1189a());
        }
    }

    public ec3() {
        o();
    }

    public static ec3 j() {
        if (d == null) {
            synchronized (ec3.class) {
                if (d == null) {
                    d = new ec3();
                }
            }
        }
        return d;
    }

    public List<TabItem> c(boolean z, boolean z2) {
        ConfigInfo configInfo = this.f17268a;
        ConfigInfo configInfo2 = this.c;
        List<TabItem> listM = null;
        if (configInfo != configInfo2 || z) {
            if (!z2 || z) {
                listM = m();
            } else if (configInfo != null && configInfo2 != null && w(g(configInfo)).equals(w(g(this.c)))) {
                listM = m();
            }
        }
        LogUtil.i("MainTabConfigManger", "checkConfigIfChanged" + listM);
        return listM;
    }

    public TabItem d(String str) {
        ConfigInfo configInfoI = i();
        if (configInfoI == null) {
            return null;
        }
        for (TabItem tabItem : configInfoI.content) {
            if (tabItem.tag.equals(str)) {
                return tabItem;
            }
        }
        return null;
    }

    public TabItem e(List<TabItem> list, String str) {
        if (list == null) {
            return null;
        }
        for (TabItem tabItem : list) {
            if (tabItem.tag.equals(str)) {
                return tabItem;
            }
        }
        return null;
    }

    public TabItem f(TabItem tabItem) {
        LogUtil.i("MainTabConfigManger", "fixConfig...");
        TabItem tabItemM793clone = tabItem.m793clone();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(tabItem.groups);
        if ("tab_mine".equals(tabItem.tag)) {
            arrayList.add(0, r());
            if (com.zenmen.palmchat.sync.a.e()) {
                arrayList.add(1, q());
            }
            if (ShowMainActivity.C) {
                arrayList.add(s());
            }
        }
        if ("tab_mine".equals(tabItem.tag)) {
            int iE = gp3.e();
            LogUtil.i("MainTabConfigManger", "fixConfig mine position: " + iE);
            if (iE < 0 || iE > arrayList.size()) {
                arrayList.add(p());
            } else {
                arrayList.add(iE, p());
            }
        } else {
            Integer numC = ns5.c(tabItem.tag);
            LogUtil.i("MainTabConfigManger", "fixConfig tab position: " + numC);
            if (numC != null) {
                if (numC.intValue() < 0 || numC.intValue() > arrayList.size()) {
                    arrayList.add(p());
                } else {
                    arrayList.add(numC.intValue(), p());
                }
            }
        }
        tabItemM793clone.groups = arrayList;
        return tabItemM793clone;
    }

    public final ArrayList<TabItem> g(ConfigInfo configInfo) {
        ArrayList<TabItem> arrayList = new ArrayList<>();
        HashSet hashSet = new HashSet();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        for (TabItem tabItem : configInfo.content) {
            if (!hashSet.contains(tabItem.tag) && TabItemsManager.a(tabItem)) {
                hashSet.add(tabItem.tag);
                arrayList.add(tabItem);
                if ("tab_small_video".equals(tabItem.tag)) {
                    z3 = true;
                } else if ("tab_msg".equals(tabItem.tag)) {
                    z = true;
                } else if ("tab_mine".equals(tabItem.tag)) {
                    z2 = true;
                } else if ("tab_square".equals(tabItem.tag)) {
                    z4 = true;
                } else if ("tab_people_match".equals(tabItem.tag)) {
                    z5 = true;
                }
            }
        }
        if (!z) {
            arrayList.add(0, ConfigInfo.genMsgTabItem());
        }
        if (!z2) {
            arrayList.add(arrayList.size() - 1, ConfigInfo.genMineTabItem());
        }
        if (!z3) {
            arrayList.add(arrayList.size() / 2, ConfigInfo.genVideoTabItem());
        }
        if (!z4 && h) {
            arrayList.add((arrayList.size() / 2) + 1, ConfigInfo.getSquareTabItem());
        }
        if (j) {
            arrayList.add(arrayList.size() / 2, ConfigInfo.getSquarePublishTabItem());
        }
        if (k) {
            arrayList.add(arrayList.size() / 2, ConfigInfo.getPeopleMatchTabItem());
        }
        if (!z5 && i) {
            arrayList.add(arrayList.size() / 2, ConfigInfo.getPeopleMatchItem());
        }
        if (LogUtil.isLogEnable()) {
            w(arrayList);
        }
        z(arrayList);
        return arrayList;
    }

    public final ConfigInfo h() {
        return this.c;
    }

    public final ConfigInfo i() {
        ConfigInfo configInfo = this.f17268a;
        if (configInfo != null) {
            return configInfo;
        }
        ConfigInfo configInfo2 = this.c;
        if (configInfo2 != null) {
            return configInfo2;
        }
        return null;
    }

    public SkinConfig k() {
        ConfigInfo configInfo = this.c;
        if (configInfo != null) {
            return configInfo.skinConfig;
        }
        return null;
    }

    public int l(String str) {
        List<TabItem> list;
        ConfigInfo configInfo = this.c;
        if (configInfo != null && (list = configInfo.content) != null && list.size() > 0 && str != null) {
            for (TabItem tabItem : this.c.content) {
                if (tabItem.tag.equals(str)) {
                    try {
                        return Integer.parseInt(tabItem.kitCode);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return -1;
    }

    public List<TabItem> m() {
        ConfigInfo configInfoH = h();
        ArrayList<TabItem> arrayListG = g(configInfoH);
        this.f17268a = configInfoH;
        return arrayListG;
    }

    public final long n() {
        JSONObject jSONObjectJ = ts0.o().j();
        if (jSONObjectJ != null) {
            return ((long) jSONObjectJ.optInt("updateInterval", 300)) * 1000;
        }
        return 300000L;
    }

    public final void o() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.MAINTAB_CONFIG;
        this.b = sPUtil.i(scene, "key_main_tabconfig_update_time_V2", 0L);
        String strN = sPUtil.n(scene, "key_main_tabconfig_config_V2", "");
        this.c = new ConfigInfo();
        LogUtil.i("MainTabConfigManger", "init   configstr=" + strN);
        if (TextUtils.isEmpty(strN)) {
            return;
        }
        ConfigInfo configInfo = (ConfigInfo) az2.a(strN, ConfigInfo.class);
        if (!t(configInfo, true, false) || f) {
            return;
        }
        this.c = configInfo;
    }

    public final GroupItem p() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CellItem("", "", "", CellViewControllerManager.BuildInType.CELL_AD.key, "", "", "", "", new TurnInfo(TurnInfo.TYPE_NATIVE, null)));
        GroupItem groupItem = new GroupItem(2, "", "", "", arrayList);
        groupItem.ignorePadding = false;
        return groupItem;
    }

    public final GroupItem q() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CellItem("", "", "", CellViewControllerManager.BuildInType.VIP_CENTER.key, "", "", "", "", new TurnInfo(TurnInfo.TYPE_NATIVE, null)));
        GroupItem groupItem = new GroupItem(2, "", "", "", arrayList);
        groupItem.tag = GroupItem.TAG_VIP;
        return groupItem;
    }

    public final GroupItem r() {
        ArrayList arrayList = new ArrayList();
        CellItem cellItem = new CellItem("", "", "", CellViewControllerManager.BuildInType.SETTINGS_HEAD.key, "", "", "", "", new TurnInfo(TurnInfo.TYPE_NATIVE, null));
        cellItem.strikeType = "reddot|badge";
        arrayList.add(cellItem);
        CellItem cellItem2 = new CellItem("", "", "", CellViewControllerManager.BuildInType.SETTINGS_SELFINFO.key, "", "", "", "", new TurnInfo(TurnInfo.TYPE_NATIVE, null));
        cellItem2.strikeType = "reddot|badge";
        arrayList.add(cellItem2);
        return new GroupItem(2, "", "", "", arrayList);
    }

    public final GroupItem s() {
        ArrayList arrayList = new ArrayList();
        CellItem cellItem = new CellItem("Show场", "", "", CellViewControllerManager.BuildInType.SHOW_TIME_FEED.key, "des", "", "", "label|reddot", new TurnInfo(TurnInfo.TYPE_NATIVE, null));
        cellItem.strikeType = "reddot|badge";
        arrayList.add(cellItem);
        return new GroupItem(5, "", "", "", arrayList);
    }

    public final boolean t(ConfigInfo configInfo, boolean z, boolean z2) {
        return v(configInfo, z) || (u(configInfo) && z2);
    }

    public final boolean u(ConfigInfo configInfo) {
        SkinConfig skinConfig;
        return (configInfo == null || (skinConfig = configInfo.skinConfig) == null || skinConfig.endDate == 0) ? false : true;
    }

    public final boolean v(ConfigInfo configInfo, boolean z) {
        List<TabItem> list;
        if (configInfo == null || (list = configInfo.content) == null || list.size() <= 0) {
            return false;
        }
        if (z && !h) {
            Iterator<TabItem> it = configInfo.content.iterator();
            while (it.hasNext()) {
                if ("tab_find_friend".equals(it.next().tag)) {
                }
            }
            return false;
        }
        return true;
    }

    public final String w(ArrayList<TabItem> arrayList) {
        StringBuilder sb = new StringBuilder("tags ");
        if (arrayList != null) {
            Iterator<TabItem> it = arrayList.iterator();
            while (it.hasNext()) {
                sb.append(it.next().tag);
                sb.append(" ");
            }
        }
        LogUtil.i("MainTabConfigManger", "getTabItemsForShow " + sb.toString());
        return sb.toString();
    }

    public final void x(ConfigInfo configInfo, String str) {
        if (!t(configInfo, false, true) || f) {
            return;
        }
        this.c.updateInfo = configInfo.updateInfo;
        if (u(configInfo)) {
            this.c.skinConfig = configInfo.skinConfig;
        }
        ConfigInfo configInfoNewConfigInfo = this.c.newConfigInfo();
        if (v(configInfo, false)) {
            configInfoNewConfigInfo.content = configInfo.content;
        }
        SPUtil.f14322a.t(SPUtil.SCENE.MAINTAB_CONFIG, "key_main_tabconfig_config_V2", az2.c(configInfoNewConfigInfo));
        if (v(configInfo, true)) {
            this.c = configInfoNewConfigInfo;
            if ("update_type_maintab_select".equals(str)) {
                ch.s().O();
            }
        }
    }

    public void y(Context context, String str) {
        LogUtil.i("MainTabConfigManger", "update start " + str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - this.b) <= n() || !ap3.a().i()) {
            return;
        }
        LogUtil.i("MainTabConfigManger", "update start1");
        this.b = jCurrentTimeMillis;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("updateInfo", this.c.updateInfo);
            LogUtil.i("MainTabConfigManger", "update  params=" + jSONObject);
            zw4.a().c(e, 1, jSONObject, new a(str), true, false);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void z(ArrayList<TabItem> arrayList) {
        if (arrayList != null) {
            for (TabItem tabItem : arrayList) {
                if ("tab_mine".equals(tabItem.tag)) {
                    List<GroupItem> list = tabItem.groups;
                    if (list != null) {
                        for (GroupItem groupItem : list) {
                            if (GroupItem.TAG_RECENT_USE.equals(groupItem.tag)) {
                                groupItem.items = ax4.i();
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
            }
        }
    }
}
