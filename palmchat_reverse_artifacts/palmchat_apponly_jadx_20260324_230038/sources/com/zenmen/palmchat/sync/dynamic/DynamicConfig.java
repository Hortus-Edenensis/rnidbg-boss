package com.zenmen.palmchat.sync.dynamic;

import android.content.Intent;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.wifi.ad.core.compliance.AdDownViVoConfig;
import com.wifi.ad.core.spstrategy.SPMdaLogUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.conversations.threadsnew.SeeMeManager;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.peoplenearby.ad.d;
import com.zenmen.palmchat.peoplenearby.ad.e;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a7;
import defpackage.a92;
import defpackage.b6;
import defpackage.db1;
import defpackage.dc1;
import defpackage.ds0;
import defpackage.du3;
import defpackage.dw3;
import defpackage.eb1;
import defpackage.f6;
import defpackage.fo5;
import defpackage.gp3;
import defpackage.hu;
import defpackage.i6;
import defpackage.is2;
import defpackage.js2;
import defpackage.ju3;
import defpackage.kt3;
import defpackage.l6;
import defpackage.m6;
import defpackage.mo3;
import defpackage.mp3;
import defpackage.mq3;
import defpackage.nl0;
import defpackage.np3;
import defpackage.ns5;
import defpackage.o6;
import defpackage.p66;
import defpackage.p93;
import defpackage.st1;
import defpackage.tu3;
import defpackage.u6;
import defpackage.uv3;
import defpackage.v8;
import defpackage.vq3;
import defpackage.vu3;
import defpackage.w50;
import defpackage.wh5;
import defpackage.wv3;
import defpackage.y66;
import defpackage.zt4;
import defpackage.zv3;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class DynamicConfig {
    public static final String JSON_KEY = "dyConfig";
    public static final String TAG = "DynamicConfig";
    private final ConcurrentHashMap<String, DynamicItem> dyConfig = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public enum Type {
        PSTORE("pstore"),
        VOIP("voip"),
        VOIP_MEETING("voip-meeting"),
        BONUSTASK("wallet"),
        WALLET2("wallet2"),
        FREECARD("mastersim"),
        FREEWALLET("freewallet"),
        INTERNET("internet"),
        MOMENTS(MediationConstant.RIT_TYPE_FEED),
        CONTACTCARD("contactCard"),
        REDPACKET("red"),
        TRANSFER("transfer"),
        SHAKE("shake"),
        PEOPLE_MATCH("peopleMatch"),
        NEW_PEOPLE_MATCH("newPeopleMatch"),
        NEW_PM_SAY_HI_MSY("new_kdy_SayHiText"),
        COUPLE_FACE("coupleFace"),
        PEOPLE_MATCH_AD_TIMING("kdyAdTiming"),
        NEWSONEKFTOP("newsOneKFTop"),
        NEWSONEKFBOTTOM("newsOneKFBottom"),
        AUDIONEWUI("audioNewUi"),
        MINI_PROGRAMS("miniApp"),
        SAVELX("savelx"),
        BIGTEXT("bigText"),
        LINKREAD("LinkSureRead"),
        NEARBYGROUP("nearbyGroup"),
        REDAGREE("red_agree"),
        INFONOTIFY("infoNotify"),
        CDNMONITOR("cdnMonitor"),
        SQUARE_BUBBLE("square_bubble"),
        KEEPALIVE("keepAlive"),
        MYTABGUIDE("myTabGuide"),
        PAYGUIDE("payGuide"),
        KEEPALIVEWM("keepAliveWM"),
        NOTIFICATION_REPUSH("notifyRePush"),
        KEEPALIVEFL("keepAliveFL"),
        REDACTBUBBLE("redActBubble"),
        REDACTBANNER("redActBanner"),
        DAEMON("daemon"),
        SVCONTACTREQUEST("svContactRequest"),
        VIDEOTAB("videoTab"),
        VIDEOTABSNEW("videoTabsNew"),
        RECOMMENDCARD("recommendCard"),
        BISREC("2dgrrec"),
        GOASTSHOW("goastshow"),
        NEARBY("nearby"),
        NEARBY_TV("nearby_tv"),
        NEARBY_NESTAD_MORE("nearby_nestad_more"),
        KDY_NESTAD_LIKEME("kdy_nestad_likeme"),
        KDY_NESTAD_SAYHI("kdy_nestad_sayhi"),
        KDY_NESTAD_CONFIG("kdy_rewardAd_config"),
        NEARBY_NESTAD_CONFIG("nest_adsdk_reward_config"),
        THIRDWAKEUP("thirdWakeUp"),
        NOTIFYGUIDE("notifyGuide"),
        NOTIFYGUIDEBANNER("notifyGuideBanner"),
        NEWMYTAB("newmytab"),
        BATTERYSAVEMODE("batterySaveMode"),
        IGNOREBATTERY("ignoreBattery"),
        IGNOREBATTERY_THREAD("daily_selfalive_alertwin_new"),
        IGNOREBATTERY_MSG("msg_selfalive_msgbutton_new"),
        LINKLOAD("linkLoad"),
        MSGBACKOFF("msgbackoff"),
        CONTACTREQUESTDISPLAY("contactRequestDisplay"),
        NEWLISTICON("newlisticon"),
        WEBURLLIST("feedsLinkIcon"),
        WALLETNOTIFY("walletNotify"),
        MOMENTS_EDIT_TIPS("feeds_edit_video_tips"),
        QUANAD("quanAd"),
        METABAD("metabAd"),
        PMAD("kdyAdShow"),
        ADSHOW("adShow"),
        ADSPEED("adSpeed"),
        CSJAD("csjAd"),
        NESTSDK("nest_adsdk"),
        NESTSDKNEWTYPE("nest_adsdk_newtype"),
        NESTSDKQUAN("nest_adsdk_quanVideo"),
        NEST_ADSDK_VPERSON("nest_adsdk_vperson"),
        NEST_ADSDK_VIDEO_TAB_AD_REQ("video_tab_ad_req"),
        NEST_ADSDK_PUSHVIDEO_A("nest_adsdk_pushVideoA"),
        NEST_ADSDK_PUSHVIDEO_B("nest_adsdk_pushVideoB"),
        NESTSDKSCRN("nest_adsdk_scrn"),
        QUANNESTAD("quan_nestad"),
        PMNESTAD("kdy_nestad"),
        ADSWITCH("ad_cloud_control"),
        MINENESTAD("nest_adsdk_mine"),
        ADJUMPTEST("adjumpTest"),
        ONEKEYSWITCH("oneKeySwitch"),
        ONEKEYSKIP("oneKeySkip"),
        COMPLETE_PHOTO("SupplementaryImage"),
        PAYMENTTEST("paymentTest"),
        CALLLOGANDSMSUPLOADWHITELIST("callLogSmsUploadWhiteList"),
        WIFIGUIDE("wifiGuide"),
        SCAN_ALBUM_BATTERY("android_scanalbumbattery"),
        SCAN_WHITE_LIST("scanWhiteList"),
        TEENGAERSMODE("teenagersMode"),
        AUTHORITYMANAGEMENT("authoritymanagement_android"),
        ENHANCEDCONTACT("enhancedContact"),
        HANDINHAND("handInHand"),
        HANDINHANDV3("handInHandV3"),
        TEMPORARYCHATADDCONTACT("temporaryChatAddContact"),
        HIGHNODEINVITE("highNodeInvite"),
        INVITEFRIENDS("inviteFriends"),
        CONTACTPERMISSIONGUIDE("contactPermissionGuide"),
        ALERTNEWUSER("alert_newuser"),
        DISABLE_CERT_CHECK("disableCertCheck"),
        OPENAPI_PAY("openapiPay"),
        OPENAPI_WEBAPP("openapiWebApp"),
        PARTNER_READ("partner-read"),
        ADX_REQ_LINK("adx_req_link"),
        NEWTASK("newTask"),
        QUICKGREETING("quick_greeting"),
        SERVICE_ACCOUNT_CFG("Service_number_cfg"),
        ADCLEARCONFIG("nest_ad_clear_config"),
        ADPOPNEST("nest_pop_ad_config"),
        ADPOPTYPE("nest_pop_type_config_new"),
        ADTABBANNERTYPE("BannerAd_type_config"),
        ADTABBANNERNEST("BannerAd_Strategy_config"),
        ADMINEBANNERTYPE("Mine_adType_config_new_0621"),
        ADMINEBANNERNEST("Mine_adStrategy_config"),
        USERDETAIL_ADTYPE_CONFIG("UserDetail_adType_config"),
        USERDETAIL_ADSTRATEGY_CONFIG("UserDetail_adStrategy_config"),
        ADEXITPOPNEST("nest_exit_pop_ad_config"),
        ADTAICHI("nest_adsdk_user_group_tag"),
        DHREDDOT("dh_red_dot_config"),
        GROUP_VERSION("groupversion"),
        AD_NEST_SPLASH_CONFIG("nest_splash_ad_config"),
        PMREQUESTINIT("pm_request_init_config"),
        NEST_SPLASH_JSON_CONFIG("nest_splash_json_value"),
        AD_DEVICE_LOG_CONFIG("nest_ad_device_log_config"),
        AD_DISCOUNT_INFO_SWITCH("ad_discount_info_switch"),
        SUPER_EXPOSE_MSG_TAB_CONFIG("boost_No4_config"),
        KDY_FLOWCONTROL("kdy_flowcontrol"),
        CIRCLE_CONFIG("circleConfig"),
        WBL_AD_CONFIG("wblsdk_ad"),
        FQL_NESTAD_UNLOCK("fql_nestad_unlock"),
        AD_SDK_DELAY_INIT_CONFIG("ad_sdk_init_app_activity240924"),
        SDK_ANDROID_AD_MDA_LOG("android_adsdk_cache_log"),
        SDK_ANDROID_AD_REPORT_RATIO("android_ad_report_ratio"),
        MINE_SEEME_STYLE_HEADIMG_CONFIG("wseemPortalHeadImg"),
        SDK_PRICE_EVENT_SCENE_CONFIG("nest_sdk_price_event_scenes"),
        SDK_VIVO_COM_CONFIG("NativeAd_compliance_config231011"),
        OAID_SDK_INIT_CONFIG("oaid_sdk_init"),
        NATIVE_COM_CONFIG("adtype_switch_sdk_config_ad_test"),
        SDK_PRIVILEGE_CONTROLLER("sdk_privilege_controller"),
        SQUARE_ADTYPE_CONFIG("Square_adType_config"),
        SQUARE_NEWFRIEND_ADTYPE_CONFIG("Square_friend_adType_config"),
        SQUARE_NEARBY_ADTYPE_CONFIG("Square_nearby_adType_config"),
        SQUARE_ADSTRATEGY_CONFIG("Square_adStrategy_config"),
        AI_CHAT_UIDS_CONFIG("special_uids"),
        AI_CHAT_PEOPLE_CONFIG("AIchat_No1"),
        ADALL_SDK_CONFIG_JSON("ad_all_config_json"),
        NEW_FRIEND_ADTYPE_CONFIG("new_friend_adType_config"),
        NEW_FRIEND_ADSTRATEGY_CONFIG("new_friend_adStrategy_config"),
        NEW_FRIEND_NEARBY_ADTYPE_CONFIG("new_friend_nearby_adType_config"),
        NEW_FRIEND_NEARBY_ADSTRATEGY_CONFIG("new_friend_nearby_adStrategy_config"),
        USERINFO_ADTYPE_CONFIG("UserInfo_adType_config"),
        USERINFO_ADSTRATEGY_CONFIG("UserInfo_adStrategy_config"),
        HEARTBEAT_MATCH("heartbeat_match"),
        SEEME_REQUEST_TIME_ALLOW("seeme_request_time_allow"),
        PUBLIC_ADTYPE_CONFIG("Public_adType_config"),
        PUBLIC_NATIVE_ADSTRATEGY_CONFIG("Public_native_adStrategy_config"),
        PUBLIC_NATIVE_ADSTRATEGY_CONFIG_2("Public_native_adStrategy_config_02"),
        PUBLIC_TEMPLATE_ADSTRATEGY_CONFIG("Public_template_adStrategy_config"),
        USERDETAIL_FEED_ADTYPE_CONFIG("UserDetail_feed_adtype_config"),
        USERDETAIL_FEED_ADTYPE_CONFIGV2("UserDetail_feed_adtype_config_V2"),
        NEARBY_REWARD_ADTYPE("nearby_reward_adtype"),
        POP_AD_VIP("pop_ad_vip"),
        SIGN_TASK("sign_task"),
        MINE_MY_FRIEND_UP("mine_my_friend_up"),
        PM_NEW_STYLE_PIC_AD("pm_new_style_pic_ad_config"),
        INCOME_TASK_CONFIG("income_task_config"),
        MINE_PROFIT("mine_profit"),
        PM_NEW_SEND_MSG_BTN_TITLE("new_kdy_SayHi_ButtonText"),
        RISK_USER("risk_user"),
        NEST_AD_PRELOAD("nest_ad_preload_config"),
        NEST_ADSDK_VIDEO_TAB_ENTER("video_tab_ad_enter"),
        NEST_ADSDK_VIDEO_TAB_PAUSE("video_tab_ad_pause"),
        AUDIOMATCH("audiomatch"),
        VIDEOMATCH("videoMatch"),
        MSG_BANNER("msg_banner");

        public String value;

        Type(String str) {
            this.value = str;
        }
    }

    public DynamicConfig() {
        init();
    }

    private HashMap<String, Boolean> getMainFeatureEntranceStatus() {
        HashMap<String, Boolean> map = new HashMap<>();
        map.put(Type.BONUSTASK.value, Boolean.valueOf(hu.a()));
        return map;
    }

    private void init() {
        DynamicItem dynamicItem = new DynamicItem();
        dynamicItem.setEnable(!nl0.g());
        this.dyConfig.put(Type.VOIP.value, dynamicItem);
        DynamicItem dynamicItem2 = new DynamicItem();
        dynamicItem2.setEnable(false);
        this.dyConfig.put(Type.VOIP_MEETING.value, dynamicItem2);
        DynamicItem dynamicItem3 = new DynamicItem();
        dynamicItem3.setEnable(true);
        this.dyConfig.put(Type.MOMENTS.value, dynamicItem3);
        DynamicItem dynamicItem4 = new DynamicItem();
        dynamicItem4.setEnable(false);
        this.dyConfig.put(Type.BONUSTASK.value, dynamicItem4);
        DynamicItem dynamicItem5 = new DynamicItem();
        dynamicItem5.setEnable(true);
        this.dyConfig.put(Type.WALLET2.value, dynamicItem5);
        DynamicItem dynamicItem6 = new DynamicItem();
        dynamicItem6.setEnable(false);
        this.dyConfig.put(Type.FREECARD.value, dynamicItem6);
        DynamicItem dynamicItem7 = new DynamicItem();
        dynamicItem7.setEnable(true);
        this.dyConfig.put(Type.FREEWALLET.value, dynamicItem7);
        DynamicItem dynamicItem8 = new DynamicItem();
        dynamicItem8.setEnable(false);
        this.dyConfig.put(Type.MINI_PROGRAMS.value, dynamicItem8);
        DynamicItem dynamicItem9 = new DynamicItem();
        dynamicItem9.setEnable(false);
        this.dyConfig.put(Type.NOTIFYGUIDEBANNER.value, dynamicItem9);
        DynamicItem dynamicItem10 = new DynamicItem();
        dynamicItem10.setEnable(true);
        this.dyConfig.put(Type.NEWMYTAB.value, dynamicItem10);
        DynamicItem dynamicItem11 = new DynamicItem();
        dynamicItem11.setEnable(false);
        this.dyConfig.put(Type.SAVELX.value, dynamicItem11);
        DynamicItem dynamicItem12 = new DynamicItem();
        dynamicItem12.setEnable(false);
        this.dyConfig.put(Type.CONTACTCARD.value, dynamicItem12);
        DynamicItem dynamicItem13 = new DynamicItem();
        dynamicItem13.setEnable(false);
        this.dyConfig.put(Type.REDPACKET.value, dynamicItem13);
        DynamicItem dynamicItem14 = new DynamicItem();
        dynamicItem14.setEnable(true);
        this.dyConfig.put(Type.NEARBYGROUP.value, dynamicItem14);
        DynamicItem dynamicItem15 = new DynamicItem();
        dynamicItem15.setEnable(false);
        this.dyConfig.put(Type.TRANSFER.value, dynamicItem15);
        DynamicItem dynamicItem16 = new DynamicItem();
        dynamicItem16.setEnable(false);
        this.dyConfig.put(Type.LINKLOAD.value, dynamicItem16);
        DynamicItem dynamicItem17 = new DynamicItem();
        dynamicItem17.setEnable(false);
        this.dyConfig.put(Type.NEWSONEKFTOP.value, dynamicItem17);
        DynamicItem dynamicItem18 = new DynamicItem();
        dynamicItem18.setEnable(false);
        this.dyConfig.put(Type.NEWSONEKFBOTTOM.value, dynamicItem18);
        DynamicItem dynamicItem19 = new DynamicItem();
        dynamicItem19.setEnable(false);
        this.dyConfig.put(Type.IGNOREBATTERY.value, dynamicItem19);
        DynamicItem dynamicItem20 = new DynamicItem();
        dynamicItem20.setEnable(false);
        this.dyConfig.put(Type.BATTERYSAVEMODE.value, dynamicItem20);
        DynamicItem dynamicItem21 = new DynamicItem();
        dynamicItem21.setEnable(false);
        this.dyConfig.put(Type.NOTIFICATION_REPUSH.value, dynamicItem21);
        DynamicItem dynamicItem22 = new DynamicItem();
        dynamicItem22.setEnable(false);
        this.dyConfig.put(Type.PSTORE.value, dynamicItem22);
        DynamicItem dynamicItem23 = new DynamicItem();
        dynamicItem23.setEnable(false);
        this.dyConfig.put(Type.AUDIONEWUI.value, dynamicItem23);
        DynamicItem dynamicItem24 = new DynamicItem();
        dynamicItem24.setEnable(false);
        this.dyConfig.put(Type.REDAGREE.value, dynamicItem24);
        DynamicItem dynamicItem25 = new DynamicItem();
        dynamicItem25.setEnable(false);
        this.dyConfig.put(Type.BIGTEXT.value, dynamicItem25);
        DynamicItem dynamicItem26 = new DynamicItem();
        dynamicItem26.setEnable(false);
        this.dyConfig.put(Type.METABAD.value, dynamicItem26);
        DynamicItem dynamicItem27 = new DynamicItem();
        dynamicItem27.setEnable(false);
        this.dyConfig.put(Type.PMAD.value, dynamicItem27);
        DynamicItem dynamicItem28 = new DynamicItem();
        dynamicItem28.setEnable(false);
        this.dyConfig.put(Type.MOMENTS_EDIT_TIPS.value, dynamicItem28);
        DynamicItem dynamicItem29 = new DynamicItem();
        dynamicItem29.setEnable(false);
        this.dyConfig.put(Type.QUANAD.value, dynamicItem29);
        DynamicItem dynamicItem30 = new DynamicItem();
        dynamicItem30.setEnable(false);
        this.dyConfig.put(Type.MYTABGUIDE.value, dynamicItem30);
        DynamicItem dynamicItem31 = new DynamicItem();
        dynamicItem31.setEnable(false);
        this.dyConfig.put(Type.PAYGUIDE.value, dynamicItem31);
        DynamicItem dynamicItem32 = new DynamicItem();
        dynamicItem32.setEnable(false);
        this.dyConfig.put(Type.ADSHOW.value, dynamicItem32);
        DynamicItem dynamicItem33 = new DynamicItem();
        dynamicItem33.setEnable(false);
        this.dyConfig.put(Type.ADSPEED.value, dynamicItem33);
        DynamicItem dynamicItem34 = new DynamicItem();
        dynamicItem34.setEnable(false);
        this.dyConfig.put(Type.CSJAD.value, dynamicItem34);
        DynamicItem dynamicItem35 = new DynamicItem();
        dynamicItem35.setEnable(false);
        this.dyConfig.put(Type.NESTSDK.value, dynamicItem35);
        DynamicItem dynamicItem36 = new DynamicItem();
        dynamicItem36.setEnable(false);
        this.dyConfig.put(Type.NESTSDKNEWTYPE.value, dynamicItem36);
        DynamicItem dynamicItem37 = new DynamicItem();
        dynamicItem37.setEnable(false);
        this.dyConfig.put(Type.NESTSDKQUAN.value, dynamicItem37);
        DynamicItem dynamicItem38 = new DynamicItem();
        dynamicItem38.setEnable(false);
        this.dyConfig.put(Type.NEST_ADSDK_PUSHVIDEO_A.value, dynamicItem38);
        DynamicItem dynamicItem39 = new DynamicItem();
        dynamicItem39.setEnable(false);
        this.dyConfig.put(Type.NEST_ADSDK_PUSHVIDEO_B.value, dynamicItem39);
        DynamicItem dynamicItem40 = new DynamicItem();
        dynamicItem40.setEnable(false);
        this.dyConfig.put(Type.NESTSDKSCRN.value, dynamicItem40);
        DynamicItem dynamicItem41 = new DynamicItem();
        dynamicItem41.setEnable(false);
        this.dyConfig.put(Type.NEST_ADSDK_VPERSON.value, dynamicItem41);
        DynamicItem dynamicItem42 = new DynamicItem();
        dynamicItem42.setEnable(false);
        this.dyConfig.put(Type.NEST_ADSDK_VIDEO_TAB_AD_REQ.value, dynamicItem42);
        DynamicItem dynamicItem43 = new DynamicItem();
        dynamicItem43.setEnable(false);
        this.dyConfig.put(Type.QUANNESTAD.value, dynamicItem43);
        DynamicItem dynamicItem44 = new DynamicItem();
        dynamicItem44.setEnable(false);
        this.dyConfig.put(Type.PMNESTAD.value, dynamicItem44);
        DynamicItem dynamicItem45 = new DynamicItem();
        dynamicItem45.setEnable(false);
        this.dyConfig.put(Type.MINENESTAD.value, dynamicItem45);
        DynamicItem dynamicItem46 = new DynamicItem();
        dynamicItem46.setEnable(false);
        this.dyConfig.put(Type.ADSWITCH.value, dynamicItem46);
        DynamicItem dynamicItem47 = new DynamicItem();
        dynamicItem47.setEnable(false);
        this.dyConfig.put(Type.ADJUMPTEST.value, dynamicItem47);
        DynamicItem dynamicItem48 = new DynamicItem();
        dynamicItem48.setEnable(false);
        this.dyConfig.put(Type.REDACTBUBBLE.value, dynamicItem48);
        DynamicItem dynamicItem49 = new DynamicItem();
        dynamicItem49.setEnable(false);
        this.dyConfig.put(Type.REDACTBANNER.value, dynamicItem49);
        DynamicItem dynamicItem50 = new DynamicItem();
        dynamicItem50.setEnable(true);
        this.dyConfig.put(Type.DAEMON.value, dynamicItem50);
        DynamicItem dynamicItem51 = new DynamicItem();
        dynamicItem7.setEnable(true);
        this.dyConfig.put(Type.SHAKE.value, dynamicItem51);
        DynamicItem dynamicItem52 = new DynamicItem();
        dynamicItem52.setEnable(false);
        this.dyConfig.put(Type.PEOPLE_MATCH.value, dynamicItem52);
        DynamicItem dynamicItem53 = new DynamicItem();
        dynamicItem53.setEnable(false);
        this.dyConfig.put(Type.PEOPLE_MATCH_AD_TIMING.value, dynamicItem53);
        DynamicItem dynamicItem54 = new DynamicItem();
        dynamicItem54.setEnable(false);
        this.dyConfig.put(Type.BISREC.value, dynamicItem54);
        DynamicItem dynamicItem55 = new DynamicItem();
        dynamicItem55.setEnable(false);
        this.dyConfig.put(Type.GOASTSHOW.value, dynamicItem55);
        DynamicItem dynamicItem56 = new DynamicItem();
        dynamicItem56.setEnable(false);
        this.dyConfig.put(Type.NEARBY.value, dynamicItem56);
        DynamicItem dynamicItem57 = new DynamicItem();
        dynamicItem57.setEnable(false);
        this.dyConfig.put(Type.KDY_NESTAD_CONFIG.value, dynamicItem57);
        DynamicItem dynamicItem58 = new DynamicItem();
        dynamicItem58.setEnable(false);
        this.dyConfig.put(Type.MSGBACKOFF.value, dynamicItem58);
        DynamicItem dynamicItem59 = new DynamicItem();
        dynamicItem59.setEnable(false);
        this.dyConfig.put(Type.CONTACTREQUESTDISPLAY.value, dynamicItem59);
        DynamicItem dynamicItem60 = new DynamicItem();
        dynamicItem60.setEnable(false);
        this.dyConfig.put(Type.NEWLISTICON.value, dynamicItem60);
        DynamicItem dynamicItem61 = new DynamicItem();
        dynamicItem61.setEnable(false);
        this.dyConfig.put(Type.WEBURLLIST.value, dynamicItem61);
        DynamicItem dynamicItem62 = new DynamicItem();
        dynamicItem62.setEnable(false);
        this.dyConfig.put(Type.NOTIFYGUIDE.value, dynamicItem62);
        DynamicItem dynamicItem63 = new DynamicItem();
        dynamicItem63.setEnable(false);
        this.dyConfig.put(Type.INFONOTIFY.value, dynamicItem63);
        DynamicItem dynamicItem64 = new DynamicItem();
        dynamicItem64.setEnable(false);
        this.dyConfig.put(Type.THIRDWAKEUP.value, dynamicItem64);
        DynamicItem dynamicItem65 = new DynamicItem();
        dynamicItem65.setEnable(false);
        this.dyConfig.put(Type.KEEPALIVE.value, dynamicItem65);
        DynamicItem dynamicItem66 = new DynamicItem();
        dynamicItem66.setEnable(false);
        this.dyConfig.put(Type.KEEPALIVEWM.value, dynamicItem66);
        DynamicItem dynamicItem67 = new DynamicItem();
        dynamicItem67.setEnable(false);
        this.dyConfig.put(Type.KEEPALIVEFL.value, dynamicItem67);
        DynamicItem dynamicItem68 = new DynamicItem();
        dynamicItem68.setEnable(false);
        this.dyConfig.put(Type.ONEKEYSWITCH.value, dynamicItem68);
        DynamicItem dynamicItem69 = new DynamicItem();
        dynamicItem69.setEnable(false);
        this.dyConfig.put(Type.ONEKEYSKIP.value, dynamicItem69);
        DynamicItem dynamicItem70 = new DynamicItem();
        dynamicItem70.setEnable(true);
        this.dyConfig.put(Type.COMPLETE_PHOTO.value, dynamicItem70);
        DynamicItem dynamicItem71 = new DynamicItem();
        dynamicItem71.setEnable(false);
        this.dyConfig.put(Type.VIDEOTAB.value, dynamicItem71);
        DynamicItem dynamicItem72 = new DynamicItem();
        dynamicItem72.setEnable(false);
        this.dyConfig.put(Type.VIDEOTABSNEW.value, dynamicItem72);
        DynamicItem dynamicItem73 = new DynamicItem();
        dynamicItem73.setEnable(false);
        this.dyConfig.put(Type.SVCONTACTREQUEST.value, dynamicItem73);
        DynamicItem dynamicItem74 = new DynamicItem();
        dynamicItem74.setEnable(false);
        this.dyConfig.put(Type.WIFIGUIDE.value, dynamicItem74);
        DynamicItem dynamicItem75 = new DynamicItem();
        dynamicItem75.setEnable(false);
        this.dyConfig.put(Type.WALLETNOTIFY.value, dynamicItem75);
        DynamicItem dynamicItem76 = new DynamicItem();
        dynamicItem76.setEnable(false);
        this.dyConfig.put(Type.PAYMENTTEST.value, dynamicItem76);
        DynamicItem dynamicItem77 = new DynamicItem();
        dynamicItem77.setEnable(false);
        this.dyConfig.put(Type.CALLLOGANDSMSUPLOADWHITELIST.value, dynamicItem77);
        DynamicItem dynamicItem78 = new DynamicItem();
        dynamicItem78.setEnable(false);
        this.dyConfig.put(Type.SCAN_ALBUM_BATTERY.value, dynamicItem78);
        DynamicItem dynamicItem79 = new DynamicItem();
        dynamicItem79.setEnable(false);
        this.dyConfig.put(Type.SCAN_WHITE_LIST.value, dynamicItem79);
        DynamicItem dynamicItem80 = new DynamicItem();
        dynamicItem80.setEnable(false);
        this.dyConfig.put(Type.TEENGAERSMODE.value, dynamicItem80);
        DynamicItem dynamicItem81 = new DynamicItem();
        dynamicItem81.setEnable(false);
        this.dyConfig.put(Type.AUTHORITYMANAGEMENT.value, dynamicItem81);
        DynamicItem dynamicItem82 = new DynamicItem();
        dynamicItem82.setEnable(false);
        this.dyConfig.put(Type.ENHANCEDCONTACT.value, dynamicItem82);
        DynamicItem dynamicItem83 = new DynamicItem();
        dynamicItem83.setEnable(false);
        this.dyConfig.put(Type.HANDINHAND.value, dynamicItem83);
        DynamicItem dynamicItem84 = new DynamicItem();
        dynamicItem84.setEnable(false);
        this.dyConfig.put(Type.HANDINHANDV3.value, dynamicItem84);
        DynamicItem dynamicItem85 = new DynamicItem();
        dynamicItem85.setEnable(false);
        this.dyConfig.put(Type.HIGHNODEINVITE.value, dynamicItem85);
        DynamicItem dynamicItem86 = new DynamicItem();
        dynamicItem86.setEnable(false);
        this.dyConfig.put(Type.INVITEFRIENDS.value, dynamicItem86);
        DynamicItem dynamicItem87 = new DynamicItem();
        dynamicItem87.setEnable(false);
        this.dyConfig.put(Type.CONTACTPERMISSIONGUIDE.value, dynamicItem87);
        DynamicItem dynamicItem88 = new DynamicItem();
        dynamicItem88.setEnable(false);
        this.dyConfig.put(Type.ALERTNEWUSER.value, dynamicItem88);
        DynamicItem dynamicItem89 = new DynamicItem();
        dynamicItem89.setEnable(false);
        this.dyConfig.put(Type.DISABLE_CERT_CHECK.value, dynamicItem89);
        DynamicItem dynamicItem90 = new DynamicItem();
        dynamicItem89.setEnable(false);
        this.dyConfig.put(Type.CIRCLE_CONFIG.value, dynamicItem90);
        DynamicItem dynamicItem91 = new DynamicItem();
        dynamicItem91.setEnable(false);
        this.dyConfig.put(Type.GROUP_VERSION.value, dynamicItem91);
        DynamicItem dynamicItem92 = new DynamicItem();
        dynamicItem92.setEnable(false);
        this.dyConfig.put(Type.OPENAPI_PAY.value, dynamicItem92);
        DynamicItem dynamicItem93 = new DynamicItem();
        dynamicItem93.setEnable(false);
        this.dyConfig.put(Type.OPENAPI_WEBAPP.value, dynamicItem93);
        DynamicItem dynamicItem94 = new DynamicItem();
        dynamicItem94.setEnable(false);
        this.dyConfig.put(Type.ADX_REQ_LINK.value, dynamicItem94);
        DynamicItem dynamicItem95 = new DynamicItem();
        dynamicItem95.setEnable(false);
        this.dyConfig.put(Type.TEMPORARYCHATADDCONTACT.value, dynamicItem95);
        DynamicItem dynamicItem96 = new DynamicItem();
        dynamicItem95.setEnable(false);
        this.dyConfig.put(Type.RISK_USER.value, dynamicItem96);
        DynamicItem dynamicItem97 = new DynamicItem();
        dynamicItem97.setEnable(false);
        this.dyConfig.put(Type.SERVICE_ACCOUNT_CFG.value, dynamicItem97);
        DynamicItem dynamicItem98 = new DynamicItem();
        dynamicItem98.setEnable(false);
        this.dyConfig.put(Type.ADPOPTYPE.value, dynamicItem98);
        DynamicItem dynamicItem99 = new DynamicItem();
        dynamicItem99.setEnable(false);
        this.dyConfig.put(Type.ADCLEARCONFIG.value, dynamicItem99);
        DynamicItem dynamicItem100 = new DynamicItem();
        dynamicItem100.setEnable(false);
        this.dyConfig.put(Type.ADPOPNEST.value, dynamicItem100);
        DynamicItem dynamicItem101 = new DynamicItem();
        dynamicItem101.setEnable(false);
        this.dyConfig.put(Type.ADTABBANNERTYPE.value, dynamicItem101);
        DynamicItem dynamicItem102 = new DynamicItem();
        dynamicItem102.setEnable(false);
        this.dyConfig.put(Type.ADTABBANNERNEST.value, dynamicItem102);
        DynamicItem dynamicItem103 = new DynamicItem();
        dynamicItem103.setEnable(false);
        this.dyConfig.put(Type.ADMINEBANNERTYPE.value, dynamicItem103);
        DynamicItem dynamicItem104 = new DynamicItem();
        dynamicItem104.setEnable(false);
        this.dyConfig.put(Type.ADMINEBANNERNEST.value, dynamicItem104);
        DynamicItem dynamicItem105 = new DynamicItem();
        dynamicItem89.setEnable(false);
        this.dyConfig.put(Type.ADTAICHI.value, dynamicItem105);
        new DynamicItem().setEnable(false);
        this.dyConfig.put(Type.WBL_AD_CONFIG.value, dynamicItem105);
        DynamicItem dynamicItem106 = new DynamicItem();
        dynamicItem106.setEnable(false);
        this.dyConfig.put(Type.AD_DEVICE_LOG_CONFIG.value, dynamicItem106);
        DynamicItem dynamicItem107 = new DynamicItem();
        dynamicItem107.setEnable(false);
        this.dyConfig.put(Type.AD_NEST_SPLASH_CONFIG.value, dynamicItem107);
        DynamicItem dynamicItem108 = new DynamicItem();
        dynamicItem108.setEnable(false);
        this.dyConfig.put(Type.AD_SDK_DELAY_INIT_CONFIG.value, dynamicItem108);
        DynamicItem dynamicItem109 = new DynamicItem();
        dynamicItem109.setEnable(false);
        this.dyConfig.put(Type.SEEME_REQUEST_TIME_ALLOW.value, dynamicItem109);
        DynamicItem dynamicItem110 = new DynamicItem();
        dynamicItem110.setEnable(false);
        this.dyConfig.put(Type.NEST_SPLASH_JSON_CONFIG.value, dynamicItem110);
        DynamicItem dynamicItem111 = new DynamicItem();
        dynamicItem111.setEnable(false);
        this.dyConfig.put(Type.PMREQUESTINIT.value, dynamicItem111);
        DynamicItem dynamicItem112 = new DynamicItem();
        dynamicItem112.setEnable(false);
        this.dyConfig.put(Type.NEST_ADSDK_VIDEO_TAB_ENTER.value, dynamicItem112);
        DynamicItem dynamicItem113 = new DynamicItem();
        dynamicItem113.setEnable(false);
        this.dyConfig.put(Type.NEST_ADSDK_VIDEO_TAB_PAUSE.value, dynamicItem113);
    }

    public static boolean isContainDyConfig(JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.optJSONObject(JSON_KEY) == null) ? false : true;
    }

    private HashMap<String, DynamicItem> parseFromJson(JSONObject jSONObject, boolean z) {
        JSONObject jSONObjectOptJSONObject;
        HashMap<String, DynamicItem> map = new HashMap<>();
        if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject(JSON_KEY)) != null) {
            LogUtil.i(TAG, "updateDynamicConfig, json = " + jSONObjectOptJSONObject.toString());
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(next);
                map.put(next, DynamicItem.parseFromJson(jSONObjectOptJSONObject2));
                LogUtil.d(TAG, "key = " + next + ", value = " + jSONObjectOptJSONObject2.toString());
                if (TextUtils.equals(next, Type.NOTIFYGUIDEBANNER.value)) {
                    LogUtil.d(TAG, "parseFromJson: ----------" + next);
                    SPUtil.f14322a.t(SPUtil.SCENE.NOTIFY_GUIDE, "thread_notification_update_notify_config", Boolean.TRUE);
                }
            }
        }
        return map;
    }

    private void updateAdConfig() {
        DynamicItem dynamicConfig = getDynamicConfig(Type.ADSPEED);
        if (dynamicConfig != null && dynamicConfig.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig ADSPEED extra = " + dynamicConfig.getExtra());
            a7.i(dynamicConfig.getExtra());
        }
        DynamicItem dynamicConfig2 = getDynamicConfig(Type.PMAD);
        if (dynamicConfig2 != null && dynamicConfig2.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig PMAD extra = " + dynamicConfig2.getExtra());
            a7.h(dynamicConfig2.getExtra());
        }
        DynamicItem dynamicConfig3 = getDynamicConfig(Type.CSJAD);
        if (dynamicConfig3 != null && dynamicConfig3.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig CSJAD extra = " + dynamicConfig3.getExtra());
            w50.E(dynamicConfig3.getExtra());
            vq3.t(dynamicConfig3.getExtra());
        }
        DynamicItem dynamicConfig4 = getDynamicConfig(Type.QUANAD);
        if (dynamicConfig4 != null) {
            LogUtil.d(TAG, "updateAdConfig quanAd isEnable = " + dynamicConfig4.isEnable());
            ds0.a().b(new mq3(dynamicConfig4.isEnable()));
            if (dynamicConfig4.isEnable()) {
                st1.f().m(dynamicConfig4.getExtra());
            }
            st1.f().n(dynamicConfig4.isEnable());
        }
        DynamicItem dynamicConfig5 = getDynamicConfig(Type.QUANNESTAD);
        if (dynamicConfig5 != null && dynamicConfig5.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig quanNestAd  = " + dynamicConfig5.getExtra());
            vq3.r(dynamicConfig5.getExtra());
        }
        DynamicItem dynamicConfig6 = getDynamicConfig(Type.AD_DISCOUNT_INFO_SWITCH);
        if (dynamicConfig6 != null && dynamicConfig6.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig adInfoConfig  = " + dynamicConfig6.getExtra());
            f6.c(dynamicConfig6.getExtra());
        }
        DynamicItem dynamicConfig7 = getDynamicConfig(Type.SUPER_EXPOSE_MSG_TAB_CONFIG);
        if (dynamicConfig7 != null && dynamicConfig7.isEnable()) {
            fo5.k(dynamicConfig7.getExtra());
        }
        DynamicItem dynamicConfig8 = getDynamicConfig(Type.ADCLEARCONFIG);
        if (dynamicConfig8 != null && dynamicConfig8.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig adClearConfig  = " + dynamicConfig8.getExtra());
            b6.f(dynamicConfig8.getExtra());
        }
        DynamicItem dynamicConfig9 = getDynamicConfig(Type.ADPOPNEST);
        if (dynamicConfig9 != null && dynamicConfig9.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig popConfig  = " + dynamicConfig9.getExtra());
            uv3.G(dynamicConfig9.getExtra());
        }
        DynamicItem dynamicConfig10 = getDynamicConfig(Type.ADEXITPOPNEST);
        if (dynamicConfig10 != null && dynamicConfig10.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig exitPopConfig  = " + dynamicConfig10.getExtra());
            vu3.q(dynamicConfig10.getExtra());
        }
        DynamicItem dynamicConfig11 = getDynamicConfig(Type.ADPOPTYPE);
        if (dynamicConfig11 != null && dynamicConfig11.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig popType  = " + dynamicConfig11.getExtra());
            uv3.H(dynamicConfig11.getExtra());
            vu3.r(dynamicConfig11.getExtra());
        }
        DynamicItem dynamicConfig12 = getDynamicConfig(Type.ADTABBANNERNEST);
        if (dynamicConfig12 != null && dynamicConfig12.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig tabBannerNest  = " + dynamicConfig12.getExtra());
            ns5.j(dynamicConfig12.getExtra());
        }
        DynamicItem dynamicConfig13 = getDynamicConfig(Type.ADTABBANNERTYPE);
        if (dynamicConfig13 != null && dynamicConfig13.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig tabBannerConfig  = " + dynamicConfig13.getExtra());
            ns5.k(dynamicConfig13.getExtra());
        }
        DynamicItem dynamicConfig14 = getDynamicConfig(Type.ADMINEBANNERNEST);
        if (dynamicConfig14 != null && dynamicConfig14.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig mineBannerNest  = " + dynamicConfig14.getExtra());
            gp3.l(dynamicConfig14.getExtra());
        }
        DynamicItem dynamicConfig15 = getDynamicConfig(Type.ADMINEBANNERTYPE);
        if (dynamicConfig15 != null && dynamicConfig15.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig mineBannerConfig  = " + dynamicConfig15.getExtra());
            gp3.m(dynamicConfig15.getExtra());
        }
        DynamicItem dynamicConfig16 = getDynamicConfig(Type.DHREDDOT);
        if (dynamicConfig16 != null && dynamicConfig16.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig dhRedDotConfig  = " + dynamicConfig16.getExtra());
            dc1.c(dynamicConfig16.getExtra());
        }
        DynamicItem dynamicConfig17 = getDynamicConfig(Type.SQUARE_ADSTRATEGY_CONFIG);
        if (dynamicConfig17 != null && dynamicConfig17.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig squareJson  = " + dynamicConfig17.getExtra());
            wh5.a0(dynamicConfig17.getExtra());
        }
        DynamicItem dynamicConfig18 = getDynamicConfig(Type.AD_SDK_DELAY_INIT_CONFIG);
        if (dynamicConfig18 != null && dynamicConfig18.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig initAd adInitConfig  = " + dynamicConfig18.getExtra());
            tu3.E(dynamicConfig18.getExtra());
        }
        DynamicItem dynamicConfig19 = getDynamicConfig(Type.SQUARE_ADTYPE_CONFIG);
        if (dynamicConfig19 != null && dynamicConfig19.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig squareConfig  = " + dynamicConfig19.getExtra());
            wh5.Z(dynamicConfig19.getExtra());
        }
        DynamicItem dynamicConfig20 = getDynamicConfig(Type.SQUARE_NEWFRIEND_ADTYPE_CONFIG);
        if (dynamicConfig20 != null && dynamicConfig20.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig squareNewFriendConfig  = " + dynamicConfig20.getExtra());
            wh5.c0(dynamicConfig20.getExtra());
        }
        DynamicItem dynamicConfig21 = getDynamicConfig(Type.SQUARE_NEARBY_ADTYPE_CONFIG);
        if (dynamicConfig21 != null && dynamicConfig21.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig squareNearByConfig  = " + dynamicConfig21.getExtra());
            wh5.b0(dynamicConfig21.getExtra());
        }
        DynamicItem dynamicConfig22 = getDynamicConfig(Type.AI_CHAT_UIDS_CONFIG);
        if (dynamicConfig22 != null && dynamicConfig22.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig sUidsConfig  = " + dynamicConfig22.getExtra());
            v8.B(dynamicConfig22.getExtra());
        }
        DynamicItem dynamicConfig23 = getDynamicConfig(Type.AI_CHAT_PEOPLE_CONFIG);
        if (dynamicConfig23 != null && dynamicConfig23.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig aiChatConfig  = " + dynamicConfig23.getExtra());
            v8.A(dynamicConfig23.getExtra());
        }
        DynamicItem dynamicConfig24 = getDynamicConfig(Type.NEW_FRIEND_ADSTRATEGY_CONFIG);
        if (dynamicConfig24 != null && dynamicConfig24.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig newFriendJson  = " + dynamicConfig24.getExtra());
            zt4.y().x(dynamicConfig24.getExtra());
        }
        DynamicItem dynamicConfig25 = getDynamicConfig(Type.NEW_FRIEND_ADTYPE_CONFIG);
        if (dynamicConfig25 != null && dynamicConfig25.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig newFriendConfig  = " + dynamicConfig25.getExtra());
            zt4.y().w(dynamicConfig25.getExtra(), false);
        }
        DynamicItem dynamicConfig26 = getDynamicConfig(Type.SDK_ANDROID_AD_REPORT_RATIO);
        if (dynamicConfig26 != null && dynamicConfig26.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig adEventConfig  = " + dynamicConfig26.getExtra());
            i6.b(dynamicConfig26.getExtra());
        }
        DynamicItem dynamicConfig27 = getDynamicConfig(Type.MINE_SEEME_STYLE_HEADIMG_CONFIG);
        if (dynamicConfig27 != null && dynamicConfig27.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig mineSeemeConfig  = " + dynamicConfig27.getExtra());
            np3.j(dynamicConfig27.getExtra());
        }
        DynamicItem dynamicConfig28 = getDynamicConfig(Type.SDK_ANDROID_AD_MDA_LOG);
        if (dynamicConfig28 != null && dynamicConfig28.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig adMdaConfig  = " + dynamicConfig28.getExtra());
            if (!TextUtils.isEmpty(dynamicConfig28.getExtra())) {
                try {
                    SPMdaLogUtil.INSTANCE.setConfigMdaSwitch(new JSONObject(dynamicConfig28.getExtra()).optInt("debug_report", 1));
                } catch (Exception unused) {
                }
            }
        }
        DynamicItem dynamicConfig29 = getDynamicConfig(Type.SDK_VIVO_COM_CONFIG);
        if (dynamicConfig29 != null && dynamicConfig29.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig adViVoConfig  = " + dynamicConfig29.getExtra());
            AdDownViVoConfig.initAllConfig(dynamicConfig29.getExtra());
        }
        DynamicItem dynamicConfig30 = getDynamicConfig(Type.NATIVE_COM_CONFIG);
        if (dynamicConfig30 != null && dynamicConfig30.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig sdkNativeConfigItem  = " + dynamicConfig30.getExtra());
            m6.b(dynamicConfig30.getExtra());
        }
        DynamicItem dynamicConfig31 = getDynamicConfig(Type.NEW_FRIEND_NEARBY_ADSTRATEGY_CONFIG);
        if (dynamicConfig31 != null && dynamicConfig31.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig newFriendNearByJson  = " + dynamicConfig31.getExtra());
            du3.y().x(dynamicConfig31.getExtra());
        }
        DynamicItem dynamicConfig32 = getDynamicConfig(Type.NEW_FRIEND_NEARBY_ADTYPE_CONFIG);
        if (dynamicConfig32 != null && dynamicConfig32.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig newFriendNearByConfig  = " + dynamicConfig32.getExtra());
            du3.y().w(dynamicConfig32.getExtra(), false);
        }
        DynamicItem dynamicConfig33 = getDynamicConfig(Type.INCOME_TASK_CONFIG);
        if (dynamicConfig33 != null && dynamicConfig33.isEnable()) {
            LogUtil.d(TAG, "updateConfig incomeTaskConfig  = " + dynamicConfig33.getExtra());
            js2.r(dynamicConfig33.getExtra());
        }
        DynamicItem dynamicConfig34 = getDynamicConfig(Type.MINE_PROFIT);
        if (dynamicConfig34 != null && dynamicConfig34.isEnable()) {
            LogUtil.d(TAG, "updateConfig mineProfit  = " + dynamicConfig34.getExtra());
            is2.b(dynamicConfig34.getExtra());
        }
        DynamicItem dynamicConfig35 = getDynamicConfig(Type.USERDETAIL_FEED_ADTYPE_CONFIGV2);
        if (dynamicConfig35 != null && dynamicConfig35.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig adTypeConfigV2  = " + dynamicConfig35.getExtra());
            p66.k(dynamicConfig35.getExtra());
        }
        DynamicItem dynamicConfig36 = getDynamicConfig(Type.USERDETAIL_FEED_ADTYPE_CONFIG);
        if (dynamicConfig36 != null && dynamicConfig36.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig adTypeConfig  = " + dynamicConfig36.getExtra());
            p66.j(dynamicConfig36.getExtra());
        }
        DynamicItem dynamicConfig37 = getDynamicConfig(Type.NEARBY_REWARD_ADTYPE);
        if (dynamicConfig37 != null && dynamicConfig37.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig nearByRdConfig  = " + dynamicConfig37.getExtra());
            ju3.v(dynamicConfig37.getExtra());
        }
        DynamicItem dynamicConfig38 = getDynamicConfig(Type.POP_AD_VIP);
        if (dynamicConfig38 != null && dynamicConfig38.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig popAdVipConfig  = " + dynamicConfig38.getExtra());
            a92.d(dynamicConfig38.getExtra());
        }
        DynamicItem dynamicConfig39 = getDynamicConfig(Type.USERINFO_ADSTRATEGY_CONFIG);
        if (dynamicConfig39 != null && dynamicConfig39.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig userInfoJson  = " + dynamicConfig39.getExtra());
            db1.m(dynamicConfig39.getExtra());
            eb1.m(dynamicConfig39.getExtra());
        }
        DynamicItem dynamicConfig40 = getDynamicConfig(Type.USERINFO_ADTYPE_CONFIG);
        if (dynamicConfig40 != null && dynamicConfig40.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig userInfoConfig  = " + dynamicConfig40.getExtra());
            db1.l(dynamicConfig40.getExtra());
            eb1.l(dynamicConfig40.getExtra());
        }
        DynamicItem dynamicConfig41 = getDynamicConfig(Type.ADSHOW);
        if (dynamicConfig41 != null && dynamicConfig41.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig  ADSHOW extra = " + dynamicConfig41.getExtra());
            u6.u(dynamicConfig41.getExtra());
        }
        DynamicItem dynamicConfig42 = getDynamicConfig(Type.MINENESTAD);
        if (dynamicConfig42 != null && dynamicConfig42.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig mineNestSdk  = " + dynamicConfig42.getExtra());
            mp3.c(dynamicConfig42.getExtra());
        }
        DynamicItem dynamicConfig43 = getDynamicConfig(Type.NEST_SPLASH_JSON_CONFIG);
        if (dynamicConfig43 != null && dynamicConfig43.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig splashNestSdk  = " + dynamicConfig43.getExtra());
            dw3.J(dynamicConfig43.getExtra());
        }
        DynamicItem dynamicConfig44 = getDynamicConfig(Type.SEEME_REQUEST_TIME_ALLOW);
        if (dynamicConfig44 != null && dynamicConfig44.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig seeMeTimeConfig  = " + dynamicConfig44.getExtra());
            SeeMeManager.o(dynamicConfig44.getExtra());
        }
        DynamicItem dynamicConfig45 = getDynamicConfig(Type.AD_NEST_SPLASH_CONFIG);
        if (dynamicConfig45 != null && dynamicConfig45.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig initAd splashConfig  = " + dynamicConfig45.getExtra());
            dw3.K(dynamicConfig45.getExtra());
        }
        DynamicItem dynamicConfig46 = getDynamicConfig(Type.MINE_MY_FRIEND_UP);
        if (dynamicConfig46 != null && dynamicConfig46.isEnable()) {
            LogUtil.d(TAG, "mineMyFriendUp  = " + dynamicConfig46.getExtra());
            kt3.b(dynamicConfig46.getExtra());
        }
        DynamicItem dynamicConfig47 = getDynamicConfig(Type.RISK_USER);
        if (dynamicConfig47 != null && dynamicConfig47.isEnable()) {
            LogUtil.d(TAG, "riskUserConfig  = " + dynamicConfig47.getExtra());
            if (y66.g()) {
                y66.b().i(dynamicConfig47.getExtra());
            }
        }
        DynamicItem dynamicConfig48 = getDynamicConfig(Type.ADSWITCH);
        if (dynamicConfig48 != null && dynamicConfig48.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig adSwitch = " + dynamicConfig48.getExtra());
            l6.h(dynamicConfig48.getExtra(), TeenagersModeManager.a().d());
        }
        DynamicItem dynamicConfig49 = getDynamicConfig(Type.ADX_REQ_LINK);
        if (dynamicConfig49 != null && dynamicConfig49.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig adxReqLink = " + dynamicConfig49.getExtra());
            o6.b(dynamicConfig49.getExtra());
        }
        DynamicItem dynamicConfig50 = getDynamicConfig(Type.NEARBY_NESTAD_MORE);
        if (dynamicConfig50 != null && dynamicConfig50.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig nearbyNestAdMore  = " + dynamicConfig50.getExtra());
            d.o(dynamicConfig50.getExtra());
        }
        DynamicItem dynamicConfig51 = getDynamicConfig(Type.NEARBY_NESTAD_CONFIG);
        if (dynamicConfig51 != null) {
            LogUtil.d(TAG, "updateAdConfig nearbyNestAdConfig  = " + dynamicConfig51.getExtra());
            e.J(dynamicConfig51.getExtra());
        }
        DynamicItem dynamicConfig52 = getDynamicConfig(Type.NEST_AD_PRELOAD);
        if (dynamicConfig52 != null && dynamicConfig52.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig preloadAdConfig  = " + dynamicConfig52.getExtra());
            wv3.h(dynamicConfig52.getExtra());
        }
        DynamicItem dynamicConfig53 = getDynamicConfig(Type.PUBLIC_ADTYPE_CONFIG);
        if (dynamicConfig53 != null && dynamicConfig53.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig publicAdTypeConfig  = " + dynamicConfig53.getExtra());
            zv3.y(dynamicConfig53.getExtra());
        }
        DynamicItem dynamicConfig54 = getDynamicConfig(Type.PUBLIC_NATIVE_ADSTRATEGY_CONFIG);
        if (dynamicConfig54 != null && dynamicConfig54.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig publicVideoAdConfig  = " + dynamicConfig54.getExtra());
            zv3.z(dynamicConfig54.getExtra());
        }
        DynamicItem dynamicConfig55 = getDynamicConfig(Type.PUBLIC_NATIVE_ADSTRATEGY_CONFIG_2);
        if (dynamicConfig55 != null && dynamicConfig55.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig publicVideoAdConfig  = " + dynamicConfig55.getExtra());
            zv3.A(dynamicConfig55.getExtra());
        }
        DynamicItem dynamicConfig56 = getDynamicConfig(Type.PUBLIC_TEMPLATE_ADSTRATEGY_CONFIG);
        if (dynamicConfig56 != null && dynamicConfig56.isEnable()) {
            LogUtil.d(TAG, "updateAdConfig publicFeedAdConfig  = " + dynamicConfig56.getExtra());
            zv3.x(dynamicConfig56.getExtra());
        }
        DynamicItem dynamicConfig57 = getDynamicConfig(Type.HEARTBEAT_MATCH);
        if (dynamicConfig57 == null || !dynamicConfig57.isEnable()) {
            return;
        }
        LogUtil.d(TAG, "updateAdConfig heartBeatConfig  = " + dynamicConfig57.getExtra());
        p93.v(dynamicConfig57.getExtra());
    }

    public ConcurrentHashMap<String, DynamicItem> getConfigMap() {
        return this.dyConfig;
    }

    public DynamicItem getDynamicConfig(Type type) {
        return this.dyConfig.get(type.value);
    }

    public void update(JSONObject jSONObject) {
        if (jSONObject != null) {
            HashMap<String, Boolean> mainFeatureEntranceStatus = getMainFeatureEntranceStatus();
            LogUtil.i(TAG, "preMainFeatureEntranceStatus " + mainFeatureEntranceStatus);
            updateInfo(jSONObject, true);
            Intent intent = new Intent();
            intent.setAction(mo3.i);
            intent.putExtra("key_dynamic_pre_status", mainFeatureEntranceStatus);
            LocalBroadcastManager.getInstance(AppContext.getContext()).sendBroadcast(intent);
        }
    }

    public void updateInfo(JSONObject jSONObject, boolean z) {
        this.dyConfig.putAll(parseFromJson(jSONObject, z));
        updateAdConfig();
    }

    public DynamicItem getDynamicConfig(String str) {
        return this.dyConfig.get(str);
    }
}
