package com.zenmen.palmchat.maintab.config;

import androidx.annotation.Keep;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.gson.reflect.TypeToken;
import com.zenmen.palmchat.maintab.cell.CellViewControllerManager;
import com.zenmen.palmchat.maintab.skin.vo.SkinConfig;
import com.zenmen.palmchat.maintab.tab.TabItemsManager;
import defpackage.az2;
import defpackage.ec3;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class ConfigInfo {
    public List<TabItem> content;
    public SkinConfig skinConfig;
    public String updateInfo;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends TypeToken<List<TabItem>> {
        public a() {
        }
    }

    public ConfigInfo(boolean z) {
        if (z) {
            init();
        }
    }

    public static void addVoiceRoomTest(TabItem tabItem) {
        tabItem.groups.get(0).items.add(0, new CellItem("语聊房", "quiz", "", CellViewControllerManager.BuildInType.MARRY_AND_FRIEND.key, "", "", "cell_voice_room", "", new TurnInfo(TurnInfo.TYPE_DEEP_LINK, "zenxin://activity?page=a0460")));
    }

    public static TabItem genFindFriendTabItem() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new CellItem("看对眼", "First Sight", "", CellViewControllerManager.BuildInType.PEOPLEMATCH.key, "", "", "First_Sight", "", new TurnInfo(TurnInfo.TYPE_NATIVE, null)));
        arrayList2.add(new CellItem("非诚勿扰", "quiz", "", CellViewControllerManager.BuildInType.MARRY_AND_FRIEND.key, "", "", "cell_quiz_view", "", new TurnInfo(TurnInfo.TYPE_DEEP_LINK, "zenxin://activity?page=a0052&pkgId=fcwr")));
        arrayList2.add(new CellItem("精彩社群", "Circle", "", CellViewControllerManager.BuildInType.CIRCLE.key, "", "", TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE, "", new TurnInfo(TurnInfo.TYPE_NATIVE, null)));
        GroupItem groupItem = new GroupItem(4, "top1", "top1_en", "", arrayList2);
        groupItem.ignorePadding = true;
        arrayList.add(groupItem);
        return new TabItem("找朋友", "FindFriend", "9", TabItemsManager.BuildInType.TAB_FIND_FRIEND.key, arrayList);
    }

    private GroupItem genGroupItem(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(new CellItem("scan", "scan_en", "", CellViewControllerManager.BuildInType.SCAN.key, "", "", "", "", new TurnInfo(TurnInfo.TYPE_NATIVE, null)));
        }
        return new GroupItem(i, "top1", "top1_en", "", arrayList);
    }

    public static TabItem genMineTabItem() {
        return new TabItem("我", "Me", "4", TabItemsManager.BuildInType.TAB_MINE.key, null);
    }

    public static TabItem genMsgTabItem() {
        return new TabItem("消息", "Chats", "1", TabItemsManager.BuildInType.TAB_MSG.key, null);
    }

    public static TabItem genVideoTabItem() {
        TabItem tabItem = new TabItem("角视频", "Video", "5", TabItemsManager.BuildInType.TAB_SMALL_VIDEO.key, null);
        tabItem.isDisabled = true;
        return tabItem;
    }

    public static TabItem getPeopleMatchItem() {
        return new TabItem("看对眼", "match", "11", TabItemsManager.BuildInType.TAB_PEOPLE_MATCH.key, null);
    }

    public static TabItem getPeopleMatchTabItem() {
        return new TabItem("看对眼", "看对眼", "10", TabItemsManager.BuildInType.TAB_PEOPLE_MATCH_JUMP.key, null);
    }

    public static TabItem getSquarePublishTabItem() {
        return new TabItem("发现", "Square", "8", TabItemsManager.BuildInType.TAB_TEST_JUMP.key, null);
    }

    public static TabItem getSquareTabItem() {
        return new TabItem("发现", "Square", "6", TabItemsManager.BuildInType.TAB_SQUARE.key, null);
    }

    private void init() {
        this.content = new ArrayList();
        List<TabItem> listInitFromJson = initFromJson();
        if (listInitFromJson != null && !ec3.f) {
            this.content = listInitFromJson;
            return;
        }
        this.content.add(genMsgTabItem());
        this.content.add(initDY1());
        this.content.add(genVideoTabItem());
        this.content.add(new TabItem("jump", "jump_en", "", TabItemsManager.BuildInType.TAB_TEST_JUMP.key, null));
        this.content.add(genMineTabItem());
    }

    private TabItem initDY1() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new CellItem("邀请朋友", "Invite friends", "", CellViewControllerManager.BuildInType.INVITE.key, "", "", "Invite_friends", "", new TurnInfo(TurnInfo.TYPE_NATIVE, null)));
        arrayList2.add(new CellItem("扫一扫", "Scan", "", CellViewControllerManager.BuildInType.SCAN.key, "", "", "Scan_new", "", new TurnInfo(TurnInfo.TYPE_NATIVE, null)));
        arrayList2.add(new CellItem("按号码查找", "Search by number", "", CellViewControllerManager.BuildInType.SEARCHNUMBER.key, "", "", "Search_number_new", "", new TurnInfo(TurnInfo.TYPE_NATIVE, null)));
        arrayList.add(new GroupItem(0, "top1", "top1_en", "", arrayList2));
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new CellItem("新的朋友", "New friends", "", CellViewControllerManager.BuildInType.NEWFRIENDS.key, "", "", "New_friend_new", "", new TurnInfo(TurnInfo.TYPE_NATIVE, null)));
        arrayList.add(new GroupItem(2, "top1", "top1_en", "", arrayList3));
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new CellItem("可能认识的人", "People might know", "", CellViewControllerManager.BuildInType.MAYKNOWN.key, "", "", "May_friend_new", "", new TurnInfo(TurnInfo.TYPE_NATIVE, null)));
        arrayList4.add(new CellItem("添加手机联系人", "Mobile contacts", "", CellViewControllerManager.BuildInType.ADDPHONECONTACT.key, "", "", "Mobile_contacts_new", "", new TurnInfo(TurnInfo.TYPE_NATIVE, null)));
        arrayList.add(new GroupItem(2, "top1", "top1_en", "", arrayList4));
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(new CellItem("附近的人", "People Nearby", "", CellViewControllerManager.BuildInType.PEOPLENEARBY.key, "", "", "near_friend_new", "", new TurnInfo(TurnInfo.TYPE_NATIVE, null)));
        arrayList5.add(new CellItem("看对眼", "First Sight", "", CellViewControllerManager.BuildInType.PEOPLEMATCH.key, "", "", "pm101", "", new TurnInfo(TurnInfo.TYPE_NATIVE, null)));
        arrayList5.add(new CellItem("精彩社群", "Circle", "", CellViewControllerManager.BuildInType.CIRCLE.key, "", "", TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE, "", new TurnInfo(TurnInfo.TYPE_NATIVE, null)));
        arrayList.add(new GroupItem(2, "top1", "top1_en", "", arrayList5));
        return new TabItem("找朋友", "Discover", "3", "tab_dynamic_1", arrayList);
    }

    private TabItem initDY2() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new CellItem("好友圈", "Moments", "", CellViewControllerManager.BuildInType.MOMENTS.key, "", "", "moment_new", "", new TurnInfo(TurnInfo.TYPE_NATIVE, null)));
        arrayList.add(new GroupItem(2, "top1", "top1_en", "", arrayList2));
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new CellItem("角视频", "Video", "", CellViewControllerManager.BuildInType.SMALLVIDEO.key, "", "", "dou_enter_tablx2", "", new TurnInfo(TurnInfo.TYPE_NATIVE, null)));
        arrayList.add(new GroupItem(2, "top1", "top1_en", "", arrayList3));
        return new TabItem("生活", "Life", "6", "tab_dynamic_2", arrayList);
    }

    private List<TabItem> initFromJson() {
        try {
            return (List) az2.b("[{\"groups\":[],\"icon\":\"\",\"id\":6,\"invisibleModel\":\"\",\"isIgnore\":false,\"kitCode\":\"1\",\"name\":\"消息\",\"nameEn\":\"Chats\",\"order\":1,\"selectedColor\":\"00AC9A\",\"selectedIcon\":\"\",\"tag\":\"tab_msg\"},{\"appId\":\"lx52540057e2ac0d67\",\"groups\":[],\"icon\":\"\",\"id\":14,\"invisibleModel\":\"teenager\",\"isIgnore\":false,\"kitCode\":\"dou_enter_tablx\",\"name\":\"看视频\",\"isDisabled\":true,\"nameEn\":\"Video\",\"order\":2,\"selectedColor\":\"00AC9A\",\"selectedIcon\":\"\",\"tag\":\"tab_small_video\"},{\"appId\":\"\",\"groups\":[{\"id\":51,\"items\":[{\"appId\":\"\",\"desc\":\"\",\"descEn\":\"\",\"icon\":\"\",\"id\":205,\"invisibleModel\":\"\",\"kitCode\":\"cell_people_match_findfriend\",\"name\":\"看对眼\",\"nameEn\":\"\",\"noticeType\":\"\",\"order\":1,\"strikeType\":\"\",\"tag\":\"cell_people_match\",\"turnInfo\":{\"showMenu\":\"false\",\"type\":\"native\",\"iosUrl\":\"\"}},{\"appId\":\"\",\"desc\":\"\",\"descEn\":\"\",\"icon\":\"\",\"id\":204,\"invisibleModel\":\"\",\"kitCode\":\"cell_quiz_click_findfriend\",\"name\":\"非诚勿扰\",\"nameEn\":\"\",\"noticeType\":\"\",\"order\":2,\"strikeType\":\"\",\"tag\":\"cell_quiz_click\",\"turnInfo\":{\"showMenu\":\"false\",\"type\":\"deeplink\",\"iosUrl\":\"\",\"url\":\"zenxin://activity?page=a0052&pkgId=fcwr\"}},{\"appId\":\"lxa2b298210f654d1d\",\"desc\":\"\",\"descEn\":\"\",\"icon\":\"\",\"id\":206,\"invisibleModel\":\"\",\"kitCode\":\"cell_topic_findfriend\",\"name\":\"热门讨论\",\"nameEn\":\"\",\"noticeType\":\"\",\"order\":3,\"strikeType\":\"\",\"tag\":\"cell_topic\",\"turnInfo\":{\"showMenu\":\"false\",\"type\":\"deeplink\",\"iosUrl\":\"\",\"url\":\"zenxin://activity?page=a0052&pkgId=discuss-a-topic\"}},{\"appId\":\"\",\"desc\":\"\",\"descEn\":\"\",\"icon\":\"\",\"id\":207,\"invisibleModel\":\"\",\"kitCode\":\"cell_circle_findfriend\",\"name\":\"精彩社群\",\"nameEn\":\"\",\"noticeType\":\"\",\"order\":4,\"strikeType\":\"\",\"tag\":\"cell_circle\",\"turnInfo\":{\"showMenu\":\"false\",\"type\":\"native\",\"iosUrl\":\"\"}},{\"appId\":\"\",\"desc\":\"\",\"descEn\":\"\",\"icon\":\"\",\"id\":208,\"invisibleModel\":\"\",\"kitCode\":\"cell_couple_findfriend\",\"name\":\"夫妻脸\",\"nameEn\":\"\",\"noticeType\":\"\",\"order\":5,\"strikeType\":\"\",\"tag\":\"cell_couple\",\"turnInfo\":{\"showMenu\":\"false\",\"type\":\"native\",\"iosUrl\":\"\"}}],\"kitCode\":\"\",\"name\":\"组1\",\"nameEn\":\"\",\"order\":1,\"styleType\":4,\"tag\":\"\"}],\"icon\":\"\",\"id\":29,\"invisibleModel\":\"\",\"isIgnore\":false,\"kitCode\":\"9\",\"name\":\"找朋友\",\"nameEn\":\"\",\"order\":3,\"selectedColor\":\"\",\"selectedIcon\":\"\",\"tag\":\"tab_find_friend\"},{\"appId\":\"\",\"groups\":[],\"icon\":\"\",\"id\":13,\"invisibleModel\":\"\",\"isIgnore\":false,\"kitCode\":\"7\",\"name\":\"发现\",\"nameEn\":\"Find\",\"order\":4,\"selectedColor\":\"00AC9A\",\"selectedIcon\":\"\",\"tag\":\"tab_square\"},{\"appId\":\"\",\"groups\":[{\"id\":48,\"items\":[{\"appId\":\"\",\"desc\":\"\",\"descEn\":\"\",\"icon\":\"https://palmchat.cdn.lianxinapp.com/static/resource/imgs/friend.png\",\"id\":103,\"invisibleModel\":\"\",\"kitCode\":\"myfriends_1\",\"name\":\"我的朋友\",\"nameEn\":\"Myfriends\",\"noticeType\":\"label|reddot|badge\",\"order\":1,\"strikeType\":\"badge|reddot\",\"tag\":\"cell_myfriends\",\"turnInfo\":{\"showMenu\":\"false\",\"type\":\"native\",\"iosUrl\":\"\",\"url\":\"\"}},{\"appId\":\"lx2b21f79c1167478a\",\"desc\":\"\",\"descEn\":\"\",\"icon\":\"https://palmchat.cdn.lianxinapp.com/static/resource/imgs/nearby0321.png\",\"id\":104,\"invisibleModel\":\"teenager\",\"kitCode\":\"near_friend_new\",\"name\":\"附近的人\",\"nameEn\":\"People Nearby\",\"noticeType\":\"label|reddot|badge\",\"order\":2,\"strikeType\":\"reddot|badge\",\"tag\":\"cell_people_nearby\",\"turnInfo\":{\"showMenu\":\"false\",\"type\":\"native\",\"iosUrl\":\"\",\"url\":\"\"}}],\"kitCode\":\"\",\"name\":\"社交工具\",\"nameEn\":\"\",\"order\":1,\"styleType\":3},{\"id\":49,\"items\":[{\"appId\":\"\",\"desc\":\"\",\"descEn\":\"\",\"icon\":\"https://palmchat.cdn.lianxinapp.com/static/resource/imgs/fuqi.png\",\"id\":106,\"invisibleModel\":\"teenager\",\"kitCode\":\"LX_APP_COUPLE\",\"name\":\"夫妻脸\",\"nameEn\":\"Couple\",\"noticeType\":\"label|new|reddot\",\"order\":2,\"strikeType\":\"\",\"tag\":\"cell_couple\",\"turnInfo\":{\"showMenu\":\"false\",\"type\":\"native\",\"iosUrl\":\"\",\"url\":\"zenxin://activity?page=a0260\"}}],\"kitCode\":\"\",\"name\":\"社交应用\",\"nameEn\":\"\",\"order\":2,\"styleType\":3}],\"icon\":\"\",\"id\":16,\"invisibleModel\":\"\",\"isIgnore\":false,\"kitCode\":\"4\",\"name\":\"我\",\"nameEn\":\"Me\",\"order\":5,\"selectedColor\":\"00AC9A\",\"selectedIcon\":\"\",\"tag\":\"tab_mine\"}]", new a().getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ConfigInfo newConfigInfo() {
        ConfigInfo configInfo = new ConfigInfo(false);
        configInfo.content = this.content;
        configInfo.skinConfig = this.skinConfig;
        configInfo.updateInfo = this.updateInfo;
        return configInfo;
    }

    public ConfigInfo() {
        this(true);
    }
}
