package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import com.bytedance.adsdk.ugeno.fx.nr.b;
import com.bytedance.adsdk.ugeno.fx.sx;
import com.bytedance.adsdk.ugeno.pn.iz;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.t;
import com.huawei.openalliance.ad.constant.bq;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {
    public static void u() {
        com.bytedance.adsdk.ugeno.b.u().u(dw.getContext(), new com.bytedance.adsdk.ugeno.fx.fx() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1
            @Override // com.bytedance.adsdk.ugeno.fx.fx
            public List<com.bytedance.adsdk.ugeno.fx.nr> u() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("View") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.1
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.adsdk.ugeno.yoga.widget.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("CustomComponent") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.12
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.adsdk.ugeno.yoga.widget.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("Text") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.23
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.text.nr(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("Image") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.34
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.image.nr(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("UpieImage") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.35
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.fx.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("FlexLayout") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.36
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.adsdk.ugeno.flexbox.pn(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("FrameLayout") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.37
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.frame.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("InteractContainerView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.38
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.jk(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("ScrollLayout") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.39
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.scroll.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("RichText") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.2
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.text.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("Input") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.3
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.input.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("Dislike") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.4
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.dislike.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("RatingBar") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.5
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.ratingbar.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("RatingStar") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.6
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.ratingbar.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("UgenProgressView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.7
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.progressbar.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("ProgressButton") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.8
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.progressbar.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("Button") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.9
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.u.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("RecyclerLayout") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.10
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.nr.iz(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("Video") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.11
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.video.nr(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("Gif") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.13
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.gif.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("VideoPlaceholder") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.14
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.b.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("Lottie") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.15
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.nr(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("InterLottie") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.16
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("InteractionWebView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.17
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new t(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("WebView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.18
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.webview.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("Blur") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.19
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("Swiper") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.20
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.adsdk.ugeno.nr(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("FVCountdown") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.21
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("RVCountdown") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.22
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("CycleCountDownView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.24
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.nr(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("CycleSkip") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.25
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.skip.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("RewardClickCountdown") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.26
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.b(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("Icon") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.27
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.u.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("FVSkip") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.28
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.skip.nr(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("RVSkip") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.29
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.skip.nr(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("VideoV3") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.30
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.b.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("PlayableComponent") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.31
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.frame.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("CsjRefreshTip") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.32
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.fx(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.fx.nr("BrokenImage") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.1.33
                    @Override // com.bytedance.adsdk.ugeno.fx.nr
                    public com.bytedance.adsdk.ugeno.nr.fx u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.brokenimage.u(context);
                    }
                });
                return arrayList;
            }
        }, new b());
        com.bytedance.adsdk.ugeno.b.u().u(new com.bytedance.adsdk.ugeno.pn.n() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.2
            @Override // com.bytedance.adsdk.ugeno.pn.n
            public List<com.bytedance.adsdk.ugeno.pn.x> u() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.bytedance.adsdk.ugeno.pn.x("shake") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.2.1
                    @Override // com.bytedance.adsdk.ugeno.pn.x
                    public com.bytedance.adsdk.ugeno.pn.fx.nr u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.fx.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.pn.x(com.huawei.openalliance.ad.constant.x.cz) { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.2.2
                    @Override // com.bytedance.adsdk.ugeno.pn.x
                    public com.bytedance.adsdk.ugeno.pn.fx.nr u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.fx.nr(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.pn.x("videoProgress") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.2.3
                    @Override // com.bytedance.adsdk.ugeno.pn.x
                    public com.bytedance.adsdk.ugeno.pn.fx.nr u(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.fx.fx(context);
                    }
                });
                return arrayList;
            }
        });
        com.bytedance.adsdk.ugeno.b.u().u(new com.bytedance.adsdk.nr.fx());
        com.bytedance.adsdk.ugeno.b.u().u(new com.bytedance.adsdk.ugeno.fx.nr.b() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.3
            @Override // com.bytedance.adsdk.ugeno.fx.nr.b
            public b.u u(Context context, com.bytedance.adsdk.ugeno.nr.fx fxVar) {
                return new iz(context, fxVar);
            }
        });
        com.bytedance.adsdk.ugeno.b.u().u(new com.bytedance.adsdk.ugeno.fx.u.u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.4
            @Override // com.bytedance.adsdk.ugeno.fx.u.u
            public com.bytedance.adsdk.ugeno.fx.u.nr u(sx sxVar) {
                return new a(sxVar);
            }
        });
        com.bytedance.adsdk.ugeno.b.u().u(new com.bytedance.adsdk.ugeno.pn.fx() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.5
            @Override // com.bytedance.adsdk.ugeno.pn.fx
            public List<com.bytedance.adsdk.ugeno.pn.nr> u() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.bytedance.adsdk.ugeno.pn.nr("interactiveFinish") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.5.1
                    @Override // com.bytedance.adsdk.ugeno.pn.nr
                    public com.bytedance.adsdk.ugeno.pn.nr.u u(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, iz.u uVar) {
                        return new com.bytedance.adsdk.ugeno.pn.nr.fx(fxVar, str, uVar);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.pn.nr("nextVideoCancel") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.5.2
                    @Override // com.bytedance.adsdk.ugeno.pn.nr
                    public com.bytedance.adsdk.ugeno.pn.nr.u u(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, iz.u uVar) {
                        return new com.bytedance.adsdk.ugeno.pn.nr.fx(fxVar, str, uVar);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.pn.nr("haptic") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.5.3
                    @Override // com.bytedance.adsdk.ugeno.pn.nr
                    public com.bytedance.adsdk.ugeno.pn.nr.u u(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, iz.u uVar) {
                        return new com.bytedance.adsdk.ugeno.pn.nr.fx(fxVar, str, uVar);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.pn.nr("closeWidget") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.5.4
                    @Override // com.bytedance.adsdk.ugeno.pn.nr
                    public com.bytedance.adsdk.ugeno.pn.nr.u u(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, iz.u uVar) {
                        return new com.bytedance.adsdk.ugeno.pn.nr.fx(fxVar, str, uVar);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.pn.nr(bq.b.C) { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.5.5
                    @Override // com.bytedance.adsdk.ugeno.pn.nr
                    public com.bytedance.adsdk.ugeno.pn.nr.u u(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, iz.u uVar) {
                        return new com.bytedance.adsdk.ugeno.pn.nr.fx(fxVar, str, uVar);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.pn.nr("execEffect") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.pn.5.6
                    @Override // com.bytedance.adsdk.ugeno.pn.nr
                    public com.bytedance.adsdk.ugeno.pn.nr.u u(com.bytedance.adsdk.ugeno.nr.fx fxVar, String str, iz.u uVar) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.u.u(fxVar, str, uVar);
                    }
                });
                return arrayList;
            }
        });
    }
}
