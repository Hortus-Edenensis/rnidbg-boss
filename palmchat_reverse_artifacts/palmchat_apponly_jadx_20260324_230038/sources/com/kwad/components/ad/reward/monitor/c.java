package com.kwad.components.ad.reward.monitor;

import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class c {
    public static void a(boolean z, AdTemplate adTemplate) {
        a(z, z ? "ad_sdk_neo_video_cache_monitor" : "ad_sdk_fullscreen_video_cache_monitor", adTemplate, z ? 102001 : 103001);
    }

    public static void b(boolean z, AdTemplate adTemplate) {
        a(z, z ? "ad_sdk_neo_page_enter_monitor" : "ad_sdk_fullscreen_page_enter_monitor", adTemplate, z ? 102002 : 103002);
    }

    public static void c(boolean z, int i) {
        a(z, z ? "ad_sdk_neo_request_monitor" : "ad_sdk_fullscreen_request_monitor", null, i);
    }

    public static void a(AdTemplate adTemplate, TKRenderFailReason tKRenderFailReason) {
        boolean z = com.kwad.sdk.core.response.b.e.el(adTemplate) == 2;
        a(z, z ? "ad_sdk_neo_page_native_monitor" : "ad_sdk_fullscreen_page_native_monitor", adTemplate, TKRenderFailReason.SWITCH_CLOSE.equals(tKRenderFailReason) ? z ? 102003 : 103003 : TKRenderFailReason.TK_FILE_LOAD_ERROR.equals(tKRenderFailReason) ? z ? 102004 : 103004 : 102005);
    }

    public static void c(boolean z, AdTemplate adTemplate) {
        a(z, z ? "ad_sdk_neo_video_play_monitor" : "ad_sdk_fullscreen_video_play_monitor", adTemplate, z ? 102007 : 103007);
    }

    private static void a(boolean z, String str, AdTemplate adTemplate, int i) {
        AdInfo adInfoEr;
        com.kwad.sdk.commercial.c.a(z, str, new RewardMonitorInfo().setErrorCode(i).setCreativeId((adTemplate == null || (adInfoEr = com.kwad.sdk.core.response.b.e.er(adTemplate)) == null) ? 0L : com.kwad.sdk.core.response.b.a.K(adInfoEr)).setAdTemplate(adTemplate));
    }
}
