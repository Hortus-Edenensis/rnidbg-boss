package com.zm.fissionsdk;

import android.content.Context;
import android.view.View;
import com.zm.adxsdk.protocol.api.interfaces.IWfAdvert;
import com.zm.adxsdk.protocol.api.interfaces.IWfInterstitial;
import com.zm.adxsdk.protocol.api.interfaces.InterstitialInteractionListener;
import com.zm.fissionsdk.api.interfaces.IFissionInterstitial;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZVWz2 extends WVZZZ implements IFissionInterstitial {
    public IWfInterstitial b;

    /* JADX INFO: compiled from: SearchBox */
    public class zZZ2W implements InterstitialInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IFissionInterstitial.InterstitialInteractionListener f16751a;

        public zZZ2W(IFissionInterstitial.InterstitialInteractionListener interstitialInteractionListener) {
            this.f16751a = interstitialInteractionListener;
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IInteractionListener
        public void onClick(View view) {
            IFissionInterstitial.InterstitialInteractionListener interstitialInteractionListener = this.f16751a;
            if (interstitialInteractionListener != null) {
                interstitialInteractionListener.onClick(view);
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.InterstitialInteractionListener
        public void onClose() {
            IFissionInterstitial.InterstitialInteractionListener interstitialInteractionListener = this.f16751a;
            if (interstitialInteractionListener != null) {
                interstitialInteractionListener.onClose();
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IInteractionListener
        public void onShow() {
            IFissionInterstitial.InterstitialInteractionListener interstitialInteractionListener = this.f16751a;
            if (interstitialInteractionListener != null) {
                interstitialInteractionListener.onShow();
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IInteractionListener
        public void onShowFailed(int i, String str) {
            IFissionInterstitial.InterstitialInteractionListener interstitialInteractionListener = this.f16751a;
            if (interstitialInteractionListener != null) {
                interstitialInteractionListener.onShowFailed(i, str);
            }
        }
    }

    public ZVWz2(IWfAdvert iWfAdvert) {
        super(iWfAdvert);
        if (iWfAdvert instanceof IWfInterstitial) {
            this.b = (IWfInterstitial) iWfAdvert;
        }
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionInterstitial
    public void setInterstitialInteractionListener(IFissionInterstitial.InterstitialInteractionListener interstitialInteractionListener) {
        IWfInterstitial iWfInterstitial = this.b;
        if (iWfInterstitial != null) {
            iWfInterstitial.setInterstitialInteractionListener(new zZZ2W(interstitialInteractionListener));
        }
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionInterstitial
    public void showInterstitial(Context context) {
        IWfInterstitial iWfInterstitial = this.b;
        if (iWfInterstitial != null) {
            iWfInterstitial.showInterstitial(context);
        }
    }
}
