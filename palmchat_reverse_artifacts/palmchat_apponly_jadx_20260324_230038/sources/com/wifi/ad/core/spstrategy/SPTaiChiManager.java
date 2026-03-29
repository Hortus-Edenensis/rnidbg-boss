package com.wifi.ad.core.spstrategy;

import android.content.Context;
import android.text.TextUtils;
import com.igexin.push.core.b;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.WifiConstConfig;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.reporter.AbstractReporter;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import com.wifi.ad.core.utils.WifiLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\u0004\u0018\u00010\u001a2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/wifi/ad/core/spstrategy/SPTaiChiManager;", "", "()V", "SCENE_TAG_FQL_REFRESH", "", "SCENE_TAG_FQL_UNLOCK", "SCENE_TAG_FRIEND_FEED", "SCENE_TAG_FU_JIN_REW", "SCENE_TAG_GLOBAL_EXITPOP_VIDEO", "SCENE_TAG_GLOBAL_POP_VIDEO", "SCENE_TAG_KANDY_FEED", "SCENE_TAG_KANDY_SAYHI_REW", "SCENE_TAG_KANDY_XIHUAN_REW", "SCENE_TAG_MY_TAB_FEED", "SCENE_TAG_NEARBY_BANNER", "SCENE_TAG_POP_VIDEO_INIT", "SCENE_TAG_POP_VIDEO_PAUSE", "SCENE_TAG_SPLASH", "SCENE_TAG_VIDEO_FRIEND", "SCENE_TAG_VIDEO_MINE", "SCENE_TAG_VIDEO_PUSH", "SCENE_TAG_VIDEO_TAB_1", "SCENE_TAG_VIDEO_TAB_2", "SP_KEY_MATERIAL_CONTROL_TAICHI", "SP_KEY_TAICHI", "createDftConfig", "Lcom/wifi/ad/core/spstrategy/SPModel;", "adParams", "Lcom/wifi/ad/core/config/AdParams;", "requestId", "scene", "", "isAllSPStrategyAd", "context", "Landroid/content/Context;", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SPTaiChiManager {
    public static final SPTaiChiManager INSTANCE = new SPTaiChiManager();
    private static final String SCENE_TAG_FQL_REFRESH = "LX-31937";
    private static final String SCENE_TAG_FQL_UNLOCK = "LX-31938";
    private static final String SCENE_TAG_FRIEND_FEED = "LX-24412";
    private static final String SCENE_TAG_FU_JIN_REW = "LX-28916";
    private static final String SCENE_TAG_GLOBAL_EXITPOP_VIDEO = "LX-33206";
    private static final String SCENE_TAG_GLOBAL_POP_VIDEO = "LX-31425";
    private static final String SCENE_TAG_KANDY_FEED = "LX-24115";
    private static final String SCENE_TAG_KANDY_SAYHI_REW = "LX-28472";
    private static final String SCENE_TAG_KANDY_XIHUAN_REW = "LX-28913";
    private static final String SCENE_TAG_MY_TAB_FEED = "LX-24769";
    private static final String SCENE_TAG_NEARBY_BANNER = "LX-29497";
    private static final String SCENE_TAG_POP_VIDEO_INIT = "LX-30418";
    private static final String SCENE_TAG_POP_VIDEO_PAUSE = "LX-30499";
    private static final String SCENE_TAG_SPLASH = "LX-31249";
    private static final String SCENE_TAG_VIDEO_FRIEND = "LX-22375";
    private static final String SCENE_TAG_VIDEO_MINE = "LX-25458";
    private static final String SCENE_TAG_VIDEO_PUSH = "LX-23555";
    private static final String SCENE_TAG_VIDEO_TAB_1 = "LX-24415";
    private static final String SCENE_TAG_VIDEO_TAB_2 = "LX-21684";
    public static final String SP_KEY_MATERIAL_CONTROL_TAICHI = "LX-32386";
    private static final String SP_KEY_TAICHI = "LX-29267";

    private SPTaiChiManager() {
    }

    private final SPModel createDftConfig(AdParams adParams, String requestId, int scene) {
        String str;
        NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
        String dftConfig = nestInfoTaker.getDftConfig(scene);
        if (TextUtils.isEmpty(dftConfig)) {
            dftConfig = DftNativeConfig.INSTANCE.getConfig(scene);
            if (TextUtils.isEmpty(dftConfig)) {
                dftConfig = nestInfoTaker.getNativeConfig(scene);
                WifiLog.d("createDftConfig: use the native2 json: " + dftConfig);
                str = "[native2]";
            } else {
                WifiLog.d("createDftConfig: use the native1 json: " + dftConfig);
                str = "[native1]";
            }
        } else {
            WifiLog.d("createDftConfig: use the default json: " + dftConfig);
            str = "[default]";
        }
        if (dftConfig == null) {
            dftConfig = "";
        }
        SPModel spModel = SPAdConfigMg.createAdModel(dftConfig, requestId);
        if (!TextUtils.isEmpty(spModel.getParError())) {
            AbstractReporter reporter = WifiNestAd.INSTANCE.getReporter();
            EventParams eventParamsBuild = new EventParams.Builder().setErrorCode(str + spModel.getParError()).setNestType(adParams.getNestType()).build();
            Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild, "EventParams.Builder()\n  …                 .build()");
            reporter.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY_FAIL, eventParamsBuild, adParams.getExt());
        }
        Intrinsics.checkExpressionValueIsNotNull(spModel, "spModel");
        return spModel;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0175  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SPModel isAllSPStrategyAd(Context context, AdParams adParams) {
        String str;
        String strValueOf;
        String str2 = null;
        if (adParams.getExt() == null) {
            str = null;
        } else {
            Map<String, String> ext = adParams.getExt();
            if (ext == null) {
                Intrinsics.throwNpe();
            }
            if (ext.containsKey("taichi")) {
                Map<String, String> ext2 = adParams.getExt();
                if (ext2 == null) {
                    Intrinsics.throwNpe();
                }
                str = ext2.get("taichi");
            } else {
                Map<String, String> ext3 = adParams.getExt();
                if (ext3 == null) {
                    Intrinsics.throwNpe();
                }
                if (ext3.containsKey("taiChiKey")) {
                    Map<String, String> ext4 = adParams.getExt();
                    if (ext4 == null) {
                        Intrinsics.throwNpe();
                    }
                    str = ext4.get("taiChiKey");
                }
            }
        }
        int scene = adParams.getScene();
        String adUnitId = adParams.getAdUnitId();
        if (str != null) {
            switch (str.hashCode()) {
                case 1436513170:
                    if (!str.equals(SCENE_TAG_VIDEO_TAB_2)) {
                        str2 = adUnitId;
                    } else {
                        str2 = WifiConstConfig.ADUNITID_VIDEO_TAB;
                        scene = 9;
                    }
                    break;
                case 1436540048:
                    if (!str.equals(SCENE_TAG_VIDEO_FRIEND)) {
                        str2 = adUnitId;
                    } else {
                        scene = 11;
                        str2 = WifiConstConfig.ADUNITID_VIDEO_FRIEND;
                    }
                    break;
                case 1436571699:
                    if (!str.equals(SCENE_TAG_VIDEO_PUSH)) {
                        str2 = adUnitId;
                    } else {
                        scene = 10;
                        str2 = WifiConstConfig.ADUNITID_VIDEO_PUSH;
                    }
                    break;
                case 1436597522:
                    if (!str.equals(SCENE_TAG_KANDY_FEED)) {
                        str2 = adUnitId;
                    } else {
                        scene = 6;
                        str2 = WifiConstConfig.ADUNITID_KANDY_FEED;
                    }
                    break;
                case 1436600402:
                    if (!str.equals(SCENE_TAG_FRIEND_FEED)) {
                        str2 = adUnitId;
                    } else {
                        scene = 7;
                        str2 = WifiConstConfig.ADUNITID_FRIEND_FEED;
                    }
                    break;
                case 1436600405:
                    if (!str.equals(SCENE_TAG_VIDEO_TAB_1)) {
                        str2 = adUnitId;
                        break;
                    }
                    break;
                case 1436603447:
                    if (!str.equals(SCENE_TAG_MY_TAB_FEED)) {
                        str2 = adUnitId;
                    } else {
                        scene = 5;
                        str2 = WifiConstConfig.ADUNITID_MYTAB;
                    }
                    break;
                case 1436630323:
                    if (!str.equals(SCENE_TAG_VIDEO_MINE)) {
                        str2 = adUnitId;
                    } else {
                        scene = 12;
                        str2 = WifiConstConfig.ADUNITID_VIDEO_MINE;
                    }
                    break;
                case 1436719752:
                    if (!str.equals(SCENE_TAG_KANDY_SAYHI_REW)) {
                        str2 = adUnitId;
                    } else {
                        scene = 14;
                        str2 = WifiConstConfig.ADUNITID_KANDY_SAYHI_REWARD;
                    }
                    break;
                case 1436724372:
                    if (!str.equals(SCENE_TAG_KANDY_XIHUAN_REW)) {
                        str2 = adUnitId;
                    } else {
                        scene = 15;
                        str2 = WifiConstConfig.ADUNITID_KANDY_XIHUAN_REWARD;
                    }
                    break;
                case 1436724375:
                    if (!str.equals(SCENE_TAG_FU_JIN_REW)) {
                        str2 = adUnitId;
                    } else {
                        scene = 8;
                        str2 = WifiConstConfig.ADUNITID_FUJIN_RAW;
                    }
                    break;
                case 1436749610:
                    if (!str.equals(SCENE_TAG_NEARBY_BANNER)) {
                        str2 = adUnitId;
                    } else {
                        scene = 16;
                        str2 = WifiConstConfig.ADUNITID_NEARBY_BANNER;
                    }
                    break;
                case 1437404765:
                    if (!str.equals(SCENE_TAG_POP_VIDEO_INIT)) {
                        str2 = adUnitId;
                    } else {
                        scene = 25;
                    }
                    break;
                case 1437405014:
                    if (!str.equals(SCENE_TAG_POP_VIDEO_PAUSE)) {
                        str2 = adUnitId;
                    } else {
                        scene = 26;
                    }
                    break;
                case 1437432728:
                    if (!str.equals(SCENE_TAG_SPLASH)) {
                        str2 = adUnitId;
                    } else {
                        scene = 27;
                        str2 = WifiConstConfig.ADUNITID_SPLASH;
                    }
                    break;
                case 1437439422:
                    if (!str.equals(SCENE_TAG_FQL_REFRESH)) {
                        str2 = adUnitId;
                    } else {
                        scene = 29;
                        str2 = WifiConstConfig.ADUNITID_FQL_REFRESH;
                    }
                    break;
                case 1437439423:
                    if (!str.equals(SCENE_TAG_FQL_UNLOCK)) {
                        str2 = adUnitId;
                    } else {
                        scene = 30;
                        str2 = WifiConstConfig.ADUNITID_FQL_UNLOCK;
                    }
                    break;
                case 1437492183:
                    if (!str.equals(SCENE_TAG_GLOBAL_EXITPOP_VIDEO)) {
                        str2 = adUnitId;
                    } else {
                        scene = 32;
                        str2 = WifiConstConfig.ADUNITID_GLOBAL_EXITPOP_VIDEO;
                    }
                    break;
                default:
                    str2 = adUnitId;
                    break;
            }
        } else {
            str2 = adUnitId;
        }
        if (adParams.getExt() == null) {
            strValueOf = "";
        } else {
            Map<String, String> ext5 = adParams.getExt();
            if (ext5 == null) {
                Intrinsics.throwNpe();
            }
            if (ext5.containsKey("requestId")) {
                Map<String, String> ext6 = adParams.getExt();
                if (ext6 == null) {
                    Intrinsics.throwNpe();
                }
                strValueOf = String.valueOf(ext6.get("requestId"));
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(strValueOf);
        sb.append(" scene:");
        sb.append(scene);
        sb.append(" SPAD isAllSPStrategyAd extTaiChi ");
        sb.append(str);
        sb.append("  WifiNestAd.taiChikeys ");
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        sb.append(wifiNestAd.getTaiChikeys$core_release());
        sb.append(" adUnitId ");
        sb.append(str2);
        WifiLog.d(sb.toString());
        adParams.setScene(scene);
        if (!TextUtils.isEmpty(str2)) {
            adParams.setAdUnitId(str2);
        }
        WifiLog.d(strValueOf + " scene:" + scene + " SPAD MDA 策略开始解析打点 nest_ad_parse_strategy");
        AbstractReporter reporter = wifiNestAd.getReporter();
        EventParams eventParamsBuild = new EventParams.Builder().setNestType(adParams.getNestType()).build();
        Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild, "EventParams.Builder()\n  …dParams.nestType).build()");
        reporter.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY, eventParamsBuild, adParams.getExt());
        SPModel adSdkConfig = new SPAdConfigMg(context).getAdSdkConfig(adParams.getScene(), adParams.getAppId(), strValueOf, wifiNestAd.getAdConfigTais(), adParams);
        String parError = adSdkConfig == null ? "Sp is error" : adSdkConfig.getParError();
        if (parError == null || parError.length() == 0) {
            WifiLog.d(strValueOf + " scene:" + scene + " SPAD MDA 策略解析成功打点 nest_ad_parse_strategy_success");
            AbstractReporter reporter2 = wifiNestAd.getReporter();
            EventParams eventParamsBuild2 = new EventParams.Builder().setErrorCode(parError).setNestType(adParams.getNestType()).setUserType(adSdkConfig.getUserType()).build();
            Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild2, "EventParams.Builder()\n  …                 .build()");
            reporter2.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY_SUCCESS, eventParamsBuild2, adParams.getExt());
        } else {
            WifiLog.d(strValueOf + " scene:" + scene + " SPAD MDA 策略解析失败打点 nest_ad_parse_strategy_fail");
            AbstractReporter reporter3 = wifiNestAd.getReporter();
            EventParams eventParamsBuild3 = new EventParams.Builder().setErrorCode(parError).setNestType(adParams.getNestType()).build();
            Intrinsics.checkExpressionValueIsNotNull(eventParamsBuild3, "EventParams.Builder()\n  …                 .build()");
            reporter3.onEvent(WifiNestConst.EventKey.NEST_AD_PARSE_STRATEGY_FAIL, eventParamsBuild3, adParams.getExt());
        }
        if (adSdkConfig != null && adSdkConfig.getAllNewSP() == 1) {
            WifiLog.d(strValueOf + " scene:" + scene + " SPAD isAllSPStrategyAd 走新配置");
            return adSdkConfig;
        }
        if (adParams.getExt() != null) {
            Map<String, String> ext7 = adParams.getExt();
            if (ext7 == null) {
                Intrinsics.throwNpe();
            }
            ext7.put("adsyType", b.Y);
        }
        WifiLog.d(strValueOf + " scene:" + scene + " SPAD isAllSPStrategyAd 配置不允许，走老配置");
        return createDftConfig(adParams, strValueOf, scene);
    }
}
