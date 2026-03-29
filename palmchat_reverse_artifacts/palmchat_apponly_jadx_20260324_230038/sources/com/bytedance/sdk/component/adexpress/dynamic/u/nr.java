package com.bytedance.sdk.component.adexpress.dynamic.u;

import android.content.Context;
import com.bytedance.sdk.component.adexpress.b;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseScrollWidgetImp;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicClose;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicDislike;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicDislikeFeedBack;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicLeisureWidget;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicLogoAd;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicLogoUnion;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicLottie;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicMutedView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicPrivacyView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRoot;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicSkipCountDown;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicSkipCountDownBtn;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicSkipCountDownContainer;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicSplitLineView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicStarView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTextView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTimeOuter;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTimeOuterContainerWidgetImp;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTimeOuterRewardFullSkip;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTimeOuterSkip;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicUnKnowView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVideoView;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;
import com.bytedance.sdk.component.adexpress.nr.mv;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DynamicBaseWidget u(Context context, DynamicRootView dynamicRootView, n nVar) {
        DynamicBaseWidget dynamicUnKnowView = null;
        if (context != null && dynamicRootView != null && nVar != null && nVar.jk() != null) {
            switch (nVar.jk().u()) {
                case -1:
                    dynamicUnKnowView = new DynamicUnKnowView(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null && dynamicRootView.getRenderRequest() != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().a());
                        dynamicUnKnowView.setUseNewShakeManager(dynamicRootView.getRenderRequest().rh());
                    }
                    break;
                case 0:
                    dynamicUnKnowView = new DynamicTextView(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().a());
                        dynamicUnKnowView.setUseNewShakeManager(dynamicRootView.getRenderRequest().rh());
                    }
                    break;
                case 1:
                    dynamicUnKnowView = new DynamicImageView(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 2:
                    dynamicUnKnowView = new DynamicButton(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 3:
                    dynamicUnKnowView = new DynamicDislike(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 4:
                    dynamicUnKnowView = new DynamicLogoAd(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 5:
                    dynamicUnKnowView = new DynamicLogoUnion(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 6:
                case 9:
                case 17:
                    dynamicUnKnowView = new DynamicBaseWidgetImp(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 7:
                    dynamicUnKnowView = new DynamicVideoView(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 8:
                    dynamicUnKnowView = new DynamicRoot(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 10:
                    dynamicUnKnowView = new DynamicMutedView(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 11:
                    dynamicUnKnowView = new DynamicStarView(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 12:
                    dynamicUnKnowView = new DynamicDislikeFeedBack(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 13:
                    dynamicUnKnowView = new DynamicTimeOuter(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 14:
                    dynamicUnKnowView = new DynamicTimeOuterContainerWidgetImp(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 15:
                    dynamicUnKnowView = b.u() ? new DynamicTimeOuterRewardFullSkip(context, dynamicRootView, nVar) : new DynamicTimeOuterSkip(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 16:
                    dynamicUnKnowView = new DynamicImageView(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 18:
                    dynamicUnKnowView = new DynamicSplitLineView(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 19:
                    dynamicUnKnowView = new DynamicSkipCountDownContainer(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 20:
                    dynamicUnKnowView = new DynamicSkipCountDown(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 21:
                    dynamicUnKnowView = new DynamicSkipCountDownBtn(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 22:
                    dynamicUnKnowView = new DynamicClose(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 23:
                    dynamicUnKnowView = new DynamicPrivacyView(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 24:
                    dynamicUnKnowView = new DynamicBaseScrollWidgetImp(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 25:
                    dynamicUnKnowView = new DynamicLeisureWidget(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 26:
                    dynamicUnKnowView = "vertical".equals(nVar.jk().pn().dc()) ? new DynamicVerticalScrollWidgetImp(context, dynamicRootView, nVar) : new DynamicBaseInternalScrollWidgetImp(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 27:
                    dynamicUnKnowView = new DynamicTimeOuterSkip(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 28:
                    if (b.u()) {
                        mv renderRequest = dynamicRootView.getRenderRequest();
                        if (renderRequest == null) {
                            return null;
                        }
                        dynamicUnKnowView = new DynamicLottie(context, dynamicRootView, nVar, renderRequest.gi());
                    }
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                case 29:
                    dynamicUnKnowView = new DynamicImageFlipSlide(context, dynamicRootView, nVar);
                    if (dynamicUnKnowView != null) {
                    }
                    break;
                default:
                    if (dynamicUnKnowView != null) {
                    }
                    break;
            }
        }
        return dynamicUnKnowView;
    }
}
