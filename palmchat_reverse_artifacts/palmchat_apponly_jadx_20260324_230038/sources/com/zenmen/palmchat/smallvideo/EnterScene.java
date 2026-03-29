package com.zenmen.palmchat.smallvideo;

import android.text.TextUtils;
import defpackage.zk5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public enum EnterScene {
    SHARE_POP_COPYLINK("share", SCENE_FROM_COPYLINK),
    SHARE_POP_CODE("share", "code"),
    SHARE_POP_IMA("share", SCENE_FROM_IMA),
    H5("share", "h5"),
    LX_FRIEND("share", "lx_friend"),
    LX_FRIEND_H("share", "lx_friend_h"),
    LX_FRIEND_H1("share", "lx_friend_h1"),
    LX_FRIEND_S("share", "lx_friend_s"),
    LX_CHAT("share", "lx_chat"),
    FIND_FRIEND("find_friend", "find_friend", true),
    LX_JUE("lx_jue"),
    PUSH("push"),
    TAB("tab", "tab"),
    TAB_POPCLI("tab", "tab_popcli"),
    TAB_POP("tab", "tab_pop"),
    HOME("home", "home"),
    LX_INFO("lx_other", "lx_info"),
    LX_INFO_MEDIA("lx_other", "info_media"),
    LX_INFO_FOLLOW("lx_other", "info_follow"),
    LX_INFO_FOOTPRINT("lx_other", "info_footprint"),
    LX_PUB("lx_other", "lx_pub"),
    LX_SECOND("life", "life", true),
    LX_TASK_1("task", "lxtask_new1"),
    LX_TASK_2("task", "lxtask_new2"),
    LX_TASK_3("task", "lxtask_new3"),
    LX_TASK_DAILY("task", "lxtask_daily");

    public static final String SCENE_FROM_CODE = "code";
    public static final String SCENE_FROM_COPYLINK = "copylink";
    public static final String SCENE_FROM_DAILY_NOTICE = "daily_notice";
    public static final String SCENE_FROM_FOLLOW_NOTICE = "follow_notice";
    public static final String SCENE_FROM_FRIEND_NOTICE = "friend_notice";
    public static final String SCENE_FROM_IMA = "ima";
    public static final String SCENE_FROM_INTERACT_NOTICE = "interact_notice";
    public static final String SCENE_FROM_LOP_LX = "lop_lx";
    public static final String SCENE_FROM_SDKPUSH_NOTICE = "sdkpush_notice";
    public static final String SCENE_FROM_SHARE = "share";
    private String scene;
    private String sceneFrom;
    private boolean uniqueScene;

    EnterScene(String str) {
        this.scene = str;
    }

    public static EnterScene fromScene(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (EnterScene enterScene : values()) {
            if (zk5.d(str, enterScene.getScene())) {
                return enterScene;
            }
        }
        return null;
    }

    public String getScene() {
        return this.scene;
    }

    public String getSceneFrom() {
        return this.sceneFrom;
    }

    public boolean hasUniqueScene() {
        return this.uniqueScene;
    }

    EnterScene(String str, String str2) {
        this(str, str2, false);
    }

    EnterScene(String str, String str2, boolean z) {
        this.scene = str;
        this.uniqueScene = z;
        this.sceneFrom = str2;
    }
}
