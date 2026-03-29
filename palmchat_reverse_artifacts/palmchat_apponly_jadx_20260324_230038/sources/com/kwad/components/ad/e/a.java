package com.kwad.components.ad.e;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.config.item.s;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class a {
    public static s dd = new s("kwaiLogoUrl", null);

    /* JADX INFO: renamed from: de, reason: collision with root package name */
    public static s f7518de = new s("attentionTips", "去关注TA");
    public static s df = new s("viewHomeTips", "查看TA的主页");
    public static s dg = new s("buyNowTips", "立即抢购");

    @InvokeBy(invokerClass = e.class, methodId = "initConfigList")
    public static void init() {
    }
}
