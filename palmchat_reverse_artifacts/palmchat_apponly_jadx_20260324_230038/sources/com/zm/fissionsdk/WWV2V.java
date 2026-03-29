package com.zm.fissionsdk;

import android.view.View;
import android.view.ViewGroup;
import com.zm.adxsdk.protocol.api.interfaces.IWfAdvert;
import com.zm.adxsdk.protocol.api.interfaces.IWfSplash;
import com.zm.adxsdk.protocol.api.interfaces.SplashInteractionListener;
import com.zm.fissionsdk.api.interfaces.IFissionSplash;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class WWV2V extends WVZZZ implements IFissionSplash {
    public IWfSplash b;

    /* JADX INFO: compiled from: SearchBox */
    public class zZZ2W implements SplashInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IFissionSplash.SplashInteractionListener f16738a;

        public zZZ2W(IFissionSplash.SplashInteractionListener splashInteractionListener) {
            this.f16738a = splashInteractionListener;
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IInteractionListener
        public void onClick(View view) {
            IFissionSplash.SplashInteractionListener splashInteractionListener = this.f16738a;
            if (splashInteractionListener != null) {
                splashInteractionListener.onClick(view);
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.SplashInteractionListener
        public void onClose() {
            IFissionSplash.SplashInteractionListener splashInteractionListener = this.f16738a;
            if (splashInteractionListener != null) {
                splashInteractionListener.onClose();
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.SplashInteractionListener
        public void onPresent() {
            IFissionSplash.SplashInteractionListener splashInteractionListener = this.f16738a;
            if (splashInteractionListener != null) {
                splashInteractionListener.onPresent();
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IInteractionListener
        public void onShow() {
            IFissionSplash.SplashInteractionListener splashInteractionListener = this.f16738a;
            if (splashInteractionListener != null) {
                splashInteractionListener.onShow();
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IInteractionListener
        public void onShowFailed(int i, String str) {
            IFissionSplash.SplashInteractionListener splashInteractionListener = this.f16738a;
            if (splashInteractionListener != null) {
                splashInteractionListener.onShowFailed(i, str);
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.SplashInteractionListener
        public void onSkip() {
            IFissionSplash.SplashInteractionListener splashInteractionListener = this.f16738a;
            if (splashInteractionListener != null) {
                splashInteractionListener.onSkip();
            }
        }
    }

    public WWV2V(IWfAdvert iWfAdvert) {
        super(iWfAdvert);
        if (iWfAdvert instanceof IWfSplash) {
            this.b = (IWfSplash) iWfAdvert;
        }
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionSplash
    public boolean isReady() {
        IWfSplash iWfSplash = this.b;
        if (iWfSplash != null) {
            return iWfSplash.isReady();
        }
        return false;
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionSplash
    public void setSplashInteractionListener(IFissionSplash.SplashInteractionListener splashInteractionListener) {
        IWfSplash iWfSplash = this.b;
        if (iWfSplash != null) {
            iWfSplash.setSplashInteractionListener(new zZZ2W(splashInteractionListener));
        }
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionSplash
    public void showSplash(ViewGroup viewGroup) {
        IWfSplash iWfSplash = this.b;
        if (iWfSplash != null) {
            iWfSplash.showSplash(viewGroup);
        }
    }
}
