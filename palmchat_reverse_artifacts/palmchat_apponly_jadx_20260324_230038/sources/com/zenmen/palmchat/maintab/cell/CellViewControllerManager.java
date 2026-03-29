package com.zenmen.palmchat.maintab.cell;

import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TurnInfo;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import defpackage.ac1;
import defpackage.bu3;
import defpackage.t66;
import defpackage.ve;
import defpackage.zz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class CellViewControllerManager {

    /* JADX INFO: compiled from: SearchBox */
    public enum BuildInType {
        SCAN("cell_scan"),
        INVITE("cell_invite_friends"),
        SEARCHNUMBER("cell_search"),
        SMALLVIDEO("cell_small_video"),
        NEWFRIENDS("cell_new_friend"),
        MAYKNOWN("cell_may_known"),
        PEOPLENEARBY("cell_people_nearby"),
        PEOPLEMATCH("cell_people_match"),
        HANDINHAND("cell_hand_in_hand"),
        HANDINHANDV3("cell_hand_in_hand_v3"),
        ADDPHONECONTACT("cell_add_phone_contact"),
        MOMENTS("cell_moment"),
        MORE("cell_more"),
        CIRCLE("cell_circle"),
        SETTINGS_HEAD("cell_setting_head"),
        SETTINGS_RECENT_USED(GroupItem.TAG_RECENT_USE),
        SETTINGS_SELFINFO("cell_settings_selfinfo"),
        CELL_AD("cell_ad"),
        SETTINGNS_PEOPLENEARBY("cell_people_nearby_settings"),
        SETTINGS_MYFRIENDS("cell_myfriends"),
        DEEPLINK("cell_deeplink_default"),
        MARRY_AND_FRIEND("cell_quiz_click"),
        VOICE_ROOM_FRIEND("cell_Chatroom"),
        VIP_CENTER("vip_center"),
        TASK_CENTER("cell_task_center"),
        SHOW_TIME_FEED("show_time_feed"),
        VIP_CONFIG("vip_config");

        public String key;

        BuildInType(String str) {
            this.key = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14607a;

        static {
            int[] iArr = new int[BuildInType.values().length];
            f14607a = iArr;
            try {
                iArr[BuildInType.SCAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14607a[BuildInType.INVITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14607a[BuildInType.SEARCHNUMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14607a[BuildInType.NEWFRIENDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14607a[BuildInType.MAYKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14607a[BuildInType.PEOPLENEARBY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14607a[BuildInType.ADDPHONECONTACT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f14607a[BuildInType.HANDINHAND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f14607a[BuildInType.HANDINHANDV3.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f14607a[BuildInType.DEEPLINK.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f14607a[BuildInType.MOMENTS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f14607a[BuildInType.MORE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f14607a[BuildInType.CIRCLE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f14607a[BuildInType.SETTINGS_HEAD.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f14607a[BuildInType.SETTINGS_SELFINFO.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f14607a[BuildInType.TASK_CENTER.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f14607a[BuildInType.SHOW_TIME_FEED.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f14607a[BuildInType.CELL_AD.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f14607a[BuildInType.SETTINGNS_PEOPLENEARBY.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f14607a[BuildInType.SETTINGS_MYFRIENDS.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f14607a[BuildInType.MARRY_AND_FRIEND.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f14607a[BuildInType.VOICE_ROOM_FRIEND.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f14607a[BuildInType.VIP_CONFIG.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f14607a[BuildInType.VIP_CENTER.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(GroupItem groupItem, CellItem cellItem) {
        boolean zD;
        if (cellItem == null) {
            return false;
        }
        BuildInType buildInTypeC = c(cellItem);
        if (buildInTypeC == null) {
            zD = false;
        } else if (groupItem.styleType == 8) {
            zD = d(buildInTypeC, cellItem);
        } else {
            if (buildInTypeC == BuildInType.SMALLVIDEO) {
                if (!TeenagersModeManager.a().d() || TeenagersModeManager.a().b() != TeenagersModeManager.SmallVideoMode.NOT_ACCESS) {
                }
            } else if (h(buildInTypeC, cellItem)) {
                zD = !TeenagersModeManager.a().d();
            }
            zD = true;
        }
        if (BuildInType.NEWFRIENDS.key.equals(cellItem.tag) || BuildInType.SETTINGS_MYFRIENDS.key.equals(cellItem.tag)) {
            return false;
        }
        return zD;
    }

    public static zz b(CellItem cellItem) {
        BuildInType buildInTypeC = c(cellItem);
        if (buildInTypeC == null) {
            return new DefaultCellViewController();
        }
        switch (a.f14607a[buildInTypeC.ordinal()]) {
        }
        return new DefaultCellViewController();
    }

    public static BuildInType c(CellItem cellItem) {
        String str;
        if (cellItem == null || cellItem.turnInfo == null || TextUtils.isEmpty(cellItem.tag)) {
            return null;
        }
        for (BuildInType buildInType : BuildInType.values()) {
            if (buildInType.key.equals(cellItem.tag)) {
                return buildInType;
            }
        }
        if (cellItem.turnInfo.type.equals(TurnInfo.TYPE_DEEP_LINK) && (str = cellItem.turnInfo.url) != null && e(str)) {
            return BuildInType.DEEPLINK;
        }
        return null;
    }

    public static boolean d(BuildInType buildInType, CellItem cellItem) {
        if (!(i(cellItem) && f(cellItem) && g(cellItem))) {
            return false;
        }
        if (h(buildInType, cellItem)) {
            return true ^ TeenagersModeManager.a().d();
        }
        return true;
    }

    public static boolean e(String str) {
        return ve.d(str) || bu3.g().e(AppContext.getContext(), str) != null;
    }

    public static boolean f(CellItem cellItem) {
        if (!TextUtils.isEmpty(cellItem.inChannel)) {
            return cellItem.inChannel.contains(ac1.m);
        }
        if (TextUtils.isEmpty(cellItem.notInChannel)) {
            return true;
        }
        return !cellItem.notInChannel.contains(ac1.m);
    }

    public static boolean g(CellItem cellItem) {
        String str = cellItem.exp;
        if (TextUtils.isEmpty(str) || str.equals("all")) {
            return true;
        }
        for (String str2 : str.split(",")) {
            String[] strArrSplit = str2.split("_");
            if (strArrSplit.length == 2) {
                if (strArrSplit[1].equals(t66.h().e(strArrSplit[0], ""))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean h(BuildInType buildInType, CellItem cellItem) {
        if (buildInType == BuildInType.PEOPLENEARBY || buildInType == BuildInType.PEOPLEMATCH) {
            return true;
        }
        String str = cellItem.invisibleModel;
        return str != null && str.contains("teenager");
    }

    public static boolean i(CellItem cellItem) {
        int i;
        try {
            i = Integer.parseInt(ac1.f);
        } catch (Exception unused) {
            i = Integer.MAX_VALUE;
        }
        return i >= cellItem.versionCode;
    }
}
