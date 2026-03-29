package com.bytedance.sdk.openadsdk.my.u;

import android.util.Pair;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.bq.u.u.u.b;
import com.bytedance.sdk.openadsdk.bq.u.u.u.fx;
import com.bytedance.sdk.openadsdk.bq.u.u.u.iz;
import com.bytedance.sdk.openadsdk.bq.u.u.u.pn;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader;
import defpackage.wc7;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.my.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0314u implements TTAdNative {
        private final u u;

        public C0314u(u uVar) {
            this.u = uVar;
        }

        private ValueSet u(AdSlot adSlot) {
            wc7 wc7VarK = wc7.k(com.bytedance.sdk.openadsdk.my.u.fx.nr.u(adSlot));
            wc7VarK.h(8302, MediationAdClassLoader.getInstance());
            return wc7VarK.a();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.u.a(u(adSlot), new pn(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> pairU = this.u.u(e);
                    nativeExpressAdListener.onError(((Integer) pairU.first).intValue(), (String) pairU.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            try {
                this.u.fx(u(adSlot), new com.bytedance.sdk.openadsdk.bq.u.u.u.u(drawFeedAdListener));
            } catch (Exception e) {
                if (drawFeedAdListener != null) {
                    Pair<Integer, String> pairU = this.u.u(e);
                    drawFeedAdListener.onError(((Integer) pairU.first).intValue(), (String) pairU.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.u.n(u(adSlot), new pn(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> pairU = this.u.u(e);
                    nativeExpressAdListener.onError(((Integer) pairU.first).intValue(), (String) pairU.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.u.u(u(adSlot), new com.bytedance.sdk.openadsdk.bq.u.u.u.nr(feedAdListener));
            } catch (Exception e) {
                if (feedAdListener != null) {
                    Pair<Integer, String> pairU = this.u.u(e);
                    feedAdListener.onError(((Integer) pairU.first).intValue(), (String) pairU.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            try {
                this.u.iz(u(adSlot), new fx(fullScreenVideoAdListener));
            } catch (Exception e) {
                if (fullScreenVideoAdListener != null) {
                    Pair<Integer, String> pairU = this.u.u(e);
                    fullScreenVideoAdListener.onError(((Integer) pairU.first).intValue(), (String) pairU.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(AdSlot adSlot, TTAdNative.NativeAdListener nativeAdListener) {
            try {
                this.u.b(u(adSlot), new b(nativeAdListener));
            } catch (Exception e) {
                if (nativeAdListener != null) {
                    Pair<Integer, String> pairU = this.u.u(e);
                    nativeAdListener.onError(((Integer) pairU.first).intValue(), (String) pairU.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.u.x(u(adSlot), new pn(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> pairU = this.u.u(e);
                    nativeExpressAdListener.onError(((Integer) pairU.first).intValue(), (String) pairU.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            try {
                this.u.pn(u(adSlot), new iz(rewardVideoAdListener));
            } catch (Exception e) {
                if (rewardVideoAdListener != null) {
                    Pair<Integer, String> pairU = this.u.u(e);
                    rewardVideoAdListener.onError(((Integer) pairU.first).intValue(), (String) pairU.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.CSJSplashAdListener cSJSplashAdListener, int i) {
            try {
                this.u.u(u(adSlot), new nr(cSJSplashAdListener), i);
            } catch (Exception e) {
                if (cSJSplashAdListener != null) {
                    final Pair<Integer, String> pairU = this.u.u(e);
                    cSJSplashAdListener.onSplashLoadFail(new CSJAdError() { // from class: com.bytedance.sdk.openadsdk.my.u.u.u.1
                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public int getCode() {
                            return ((Integer) pairU.first).intValue();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public String getMsg() {
                            return (String) pairU.second;
                        }
                    });
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.u.nr(u(adSlot), new com.bytedance.sdk.openadsdk.bq.u.u.u.nr(feedAdListener));
            } catch (Exception e) {
                if (feedAdListener != null) {
                    Pair<Integer, String> pairU = this.u.u(e);
                    feedAdListener.onError(((Integer) pairU.first).intValue(), (String) pairU.second);
                }
            }
        }
    }

    public abstract void a(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void b(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void fx(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void iz(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void n(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void nr(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void pn(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract Pair<Integer, String> u(Exception exc);

    public TTAdNative u() {
        return new C0314u(this);
    }

    public abstract void u(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void u(ValueSet valueSet, Function<SparseArray<Object>, Object> function, int i);

    public abstract void x(ValueSet valueSet, Function<SparseArray<Object>, Object> function);
}
