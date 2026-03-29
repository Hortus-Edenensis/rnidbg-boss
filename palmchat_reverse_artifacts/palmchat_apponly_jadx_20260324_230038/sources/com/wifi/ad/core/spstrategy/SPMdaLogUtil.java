package com.wifi.ad.core.spstrategy;

import com.wifi.ad.core.p001const.WifiNestConst;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R6\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u0015j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f`\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/wifi/ad/core/spstrategy/SPMdaLogUtil;", "", "()V", "allConfigEvents", "", "", "getAllConfigEvents", "()[Ljava/lang/String;", "setAllConfigEvents", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "allMdaEvents", "getAllMdaEvents", "setAllMdaEvents", "configMdaSwitch", "", "getConfigMdaSwitch", "()I", "setConfigMdaSwitch", "(I)V", "mdaLodSp", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getMdaLodSp", "()Ljava/util/HashMap;", "setMdaLodSp", "(Ljava/util/HashMap;)V", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SPMdaLogUtil {
    private static int configMdaSwitch;
    public static final SPMdaLogUtil INSTANCE = new SPMdaLogUtil();
    private static HashMap<String, Integer> mdaLodSp = new HashMap<>();
    private static String[] allMdaEvents = {WifiNestConst.EventKey.NEST_AD_PARSE_REQUEST_FAIL, WifiNestConst.EventKey.NEST_AD_CHECK_CACHE, WifiNestConst.EventKey.NEST_AD_UPDATE_CACHE, WifiNestConst.EventKey.NEST_AD_PK_UPDATE_CACHE};
    private static String[] allConfigEvents = {WifiNestConst.EventKey.NEST_AD_PARSE_REQUEST_FAIL, WifiNestConst.EventKey.NEST_AD_CHECK_CACHE, WifiNestConst.EventKey.NEST_AD_UPDATE_CACHE, WifiNestConst.EventKey.NEST_AD_PK_UPDATE_CACHE};

    private SPMdaLogUtil() {
    }

    public final String[] getAllConfigEvents() {
        return allConfigEvents;
    }

    public final String[] getAllMdaEvents() {
        return allMdaEvents;
    }

    public final int getConfigMdaSwitch() {
        return configMdaSwitch;
    }

    public final HashMap<String, Integer> getMdaLodSp() {
        return mdaLodSp;
    }

    public final void setAllConfigEvents(String[] strArr) {
        allConfigEvents = strArr;
    }

    public final void setAllMdaEvents(String[] strArr) {
        allMdaEvents = strArr;
    }

    public final void setConfigMdaSwitch(int i) {
        configMdaSwitch = i;
    }

    public final void setMdaLodSp(HashMap<String, Integer> map) {
        mdaLodSp = map;
    }
}
