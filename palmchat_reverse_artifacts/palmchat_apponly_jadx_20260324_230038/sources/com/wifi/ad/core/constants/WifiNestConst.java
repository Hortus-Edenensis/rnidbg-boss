package com.wifi.ad.core.constants;

import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wifi/ad/core/constants/WifiNestConst;", "", "()V", "EventKey", "core_release"}, k = 1, mv = {1, 1, 16})
public final class WifiNestConst {
    public static final WifiNestConst INSTANCE = new WifiNestConst();

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/wifi/ad/core/constants/WifiNestConst$EventKey;", "", "()V", "NEST_SDK_AD_PARSE_WHITELIST_FAIL", "", "NEST_SDK_AD_WHITELIST_FAIL", "NEST_SDK_CANCEL_CLICK", "UNIFIEDAD_SDK_DOWNLOAD_CONTINUE", "UNIFIEDAD_SDK_DOWNLOAD_PAUSE", "core_release"}, k = 1, mv = {1, 1, 16})
    public static final class EventKey {
        public static final EventKey INSTANCE = new EventKey();
        public static final String NEST_SDK_AD_PARSE_WHITELIST_FAIL = "nest_sdk_parse_whitelist_fail";
        public static final String NEST_SDK_AD_WHITELIST_FAIL = "nest_sdk_whitelist_fail";
        public static final String NEST_SDK_CANCEL_CLICK = "nest_sdk_cancle_click";
        public static final String UNIFIEDAD_SDK_DOWNLOAD_CONTINUE = "nest_sdk_ad_download_continue";
        public static final String UNIFIEDAD_SDK_DOWNLOAD_PAUSE = "nest_sdk_ad_download_pause";

        private EventKey() {
        }
    }

    private WifiNestConst() {
    }
}
