package com.zm.fissionsdk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.zm.adxsdk.protocol.api.WfVideoOption;
import com.zm.adxsdk.protocol.api.interfaces.IWfAdvert;
import com.zm.adxsdk.protocol.api.interfaces.IWfNative;
import com.zm.adxsdk.protocol.api.interfaces.IWfShakeListener;
import com.zm.adxsdk.protocol.api.interfaces.NativeExpressInteractionListener;
import com.zm.adxsdk.protocol.api.interfaces.NativeInteractionListener;
import com.zm.adxsdk.protocol.api.interfaces.WfDislikeListener;
import com.zm.adxsdk.protocol.api.interfaces.WfVideoListener;
import com.zm.fissionsdk.api.FissionVideoOption;
import com.zm.fissionsdk.api.interfaces.IFission;
import com.zm.fissionsdk.api.interfaces.IFissionNative;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Z2V2W extends WVZZZ implements IFissionNative {
    public IWfNative b;

    /* JADX INFO: compiled from: SearchBox */
    public class ZV2Zz implements NativeExpressInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IFissionNative.NativeExpressInteractionListener f16748a;

        public ZV2Zz(IFissionNative.NativeExpressInteractionListener nativeExpressInteractionListener) {
            this.f16748a = nativeExpressInteractionListener;
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IInteractionListener
        public void onClick(View view) {
            IFissionNative.NativeExpressInteractionListener nativeExpressInteractionListener = this.f16748a;
            if (nativeExpressInteractionListener != null) {
                nativeExpressInteractionListener.onClick(view);
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.NativeExpressInteractionListener
        public void onClose() {
            IFissionNative.NativeExpressInteractionListener nativeExpressInteractionListener = this.f16748a;
            if (nativeExpressInteractionListener != null) {
                nativeExpressInteractionListener.onClose();
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.NativeInteractionListener
        public void onCreativeClick(View view) {
            IFissionNative.NativeExpressInteractionListener nativeExpressInteractionListener = this.f16748a;
            if (nativeExpressInteractionListener != null) {
                nativeExpressInteractionListener.onCreativeClick(view);
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IInteractionListener
        public void onShow() {
            IFissionNative.NativeExpressInteractionListener nativeExpressInteractionListener = this.f16748a;
            if (nativeExpressInteractionListener != null) {
                nativeExpressInteractionListener.onShow();
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IInteractionListener
        public void onShowFailed(int i, String str) {
            IFissionNative.NativeExpressInteractionListener nativeExpressInteractionListener = this.f16748a;
            if (nativeExpressInteractionListener != null) {
                nativeExpressInteractionListener.onShowFailed(i, str);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class ZV2zV implements WfVideoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IFission.VideoListener f16749a;

        public ZV2zV(IFission.VideoListener videoListener) {
            this.f16749a = videoListener;
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.WfVideoListener
        public void onVideoComplete() {
            IFission.VideoListener videoListener = this.f16749a;
            if (videoListener != null) {
                videoListener.onVideoComplete();
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.WfVideoListener
        public void onVideoContinuePlay() {
            IFission.VideoListener videoListener = this.f16749a;
            if (videoListener != null) {
                videoListener.onVideoContinuePlay();
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.WfVideoListener
        public void onVideoError(int i, String str) {
            IFission.VideoListener videoListener = this.f16749a;
            if (videoListener != null) {
                videoListener.onVideoError(i, str);
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.WfVideoListener
        public void onVideoPause() {
            IFission.VideoListener videoListener = this.f16749a;
            if (videoListener != null) {
                videoListener.onVideoPause();
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.WfVideoListener
        public void onVideoPlay() {
            IFission.VideoListener videoListener = this.f16749a;
            if (videoListener != null) {
                videoListener.onVideoPlay();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class zZZ2W implements NativeInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IFissionNative.NativeInteractionListener f16750a;

        public zZZ2W(IFissionNative.NativeInteractionListener nativeInteractionListener) {
            this.f16750a = nativeInteractionListener;
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IInteractionListener
        public void onClick(View view) {
            IFissionNative.NativeInteractionListener nativeInteractionListener = this.f16750a;
            if (nativeInteractionListener != null) {
                nativeInteractionListener.onClick(view);
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.NativeInteractionListener
        public void onCreativeClick(View view) {
            IFissionNative.NativeInteractionListener nativeInteractionListener = this.f16750a;
            if (nativeInteractionListener != null) {
                nativeInteractionListener.onCreativeClick(view);
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IInteractionListener
        public void onShow() {
            IFissionNative.NativeInteractionListener nativeInteractionListener = this.f16750a;
            if (nativeInteractionListener != null) {
                nativeInteractionListener.onShow();
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IInteractionListener
        public void onShowFailed(int i, String str) {
            IFissionNative.NativeInteractionListener nativeInteractionListener = this.f16750a;
            if (nativeInteractionListener != null) {
                nativeInteractionListener.onShowFailed(i, str);
            }
        }
    }

    public Z2V2W(IWfAdvert iWfAdvert) {
        super(iWfAdvert);
        if (iWfAdvert instanceof IWfNative) {
            this.b = (IWfNative) iWfAdvert;
        }
    }

    public final WfVideoOption a(FissionVideoOption fissionVideoOption) {
        WfVideoOption.Builder builder = new WfVideoOption.Builder();
        if (fissionVideoOption != null) {
            builder.setAutoPlayPolicy(fissionVideoOption.getAutoPlayPolicy()).setVideoMute(fissionVideoOption.getVideoMute()).setShowEndCard(fissionVideoOption.showEndCard()).setShowVideoCover(fissionVideoOption.showVideoCover()).setShowVideoProgress(fissionVideoOption.showVideoProgress()).setVideoReplay(fissionVideoOption.videoReplay()).setTheme(fissionVideoOption.getTheme()).setScaleType(fissionVideoOption.getScaleType());
        }
        return builder.build();
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public String getAppIcon() {
        IWfNative iWfNative = this.b;
        return iWfNative != null ? iWfNative.getAppIcon() : "";
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public String getAppName() {
        IWfNative iWfNative = this.b;
        return iWfNative != null ? iWfNative.getAppName() : "";
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public String getAppVersion() {
        IWfNative iWfNative = this.b;
        return iWfNative != null ? iWfNative.getAppVersion() : "";
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public String getBtnText() {
        IWfNative iWfNative = this.b;
        return iWfNative != null ? iWfNative.getButtonText() : "";
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public String getDesc() {
        IWfNative iWfNative = this.b;
        return iWfNative != null ? iWfNative.getDesc() : "";
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public String getDeveloperName() {
        IWfNative iWfNative = this.b;
        return iWfNative != null ? iWfNative.getDeveloperName() : "";
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public View getExpressView(Context context) {
        IWfNative iWfNative = this.b;
        if (iWfNative != null) {
            return iWfNative.getExpressView(context);
        }
        return null;
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public String getFunctionDescUrl() {
        IWfNative iWfNative = this.b;
        return iWfNative != null ? iWfNative.getFunctionDescUrl() : "";
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public List<String> getImageList() {
        IWfNative iWfNative = this.b;
        if (iWfNative != null) {
            return iWfNative.getImageList();
        }
        return null;
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public int getInteractionType() {
        IWfNative iWfNative = this.b;
        if (iWfNative != null) {
            return iWfNative.getInteractionType();
        }
        return -1;
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public int getMaterialHeight() {
        IWfNative iWfNative = this.b;
        if (iWfNative != null) {
            return iWfNative.getMaterialHeight();
        }
        return 0;
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public int getMaterialType() {
        IWfNative iWfNative = this.b;
        if (iWfNative != null) {
            return iWfNative.getMaterialType();
        }
        return 0;
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public int getMaterialWidth() {
        IWfNative iWfNative = this.b;
        if (iWfNative != null) {
            return iWfNative.getMaterialWidth();
        }
        return 0;
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public String getPackageName() {
        IWfNative iWfNative = this.b;
        return iWfNative != null ? iWfNative.getPackageName() : "";
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public String getPermissionUrl() {
        IWfNative iWfNative = this.b;
        return iWfNative != null ? iWfNative.getPermissionUrl() : "";
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public Map<String, String> getPermissionsMap() {
        IWfNative iWfNative = this.b;
        if (iWfNative != null) {
            return iWfNative.getPermissionsMap();
        }
        return null;
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public String getPrivacyUrl() {
        IWfNative iWfNative = this.b;
        return iWfNative != null ? iWfNative.getPrivacyUrl() : "";
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public String getTitle() {
        IWfNative iWfNative = this.b;
        return iWfNative != null ? iWfNative.getTitle() : "";
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public View getVideoView(Context context, FissionVideoOption fissionVideoOption) {
        IWfNative iWfNative = this.b;
        if (iWfNative != null) {
            return iWfNative.getVideoView(context, a(fissionVideoOption));
        }
        return null;
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public View renderShakeView(Context context, int i, int i2, IFissionNative.ShakeListener shakeListener) {
        IWfNative iWfNative = this.b;
        if (iWfNative != null) {
            return iWfNative.renderShakeView(context, i, i2, 3, new Z2WzW(shakeListener));
        }
        return null;
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public void setDislikeListener(IFissionNative.DislikeListener dislikeListener) {
        IWfNative iWfNative = this.b;
        if (iWfNative != null) {
            iWfNative.setDislikeListener(new Z2ZWz(dislikeListener));
        }
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public void setNativeExpressListener(IFissionNative.NativeExpressInteractionListener nativeExpressInteractionListener) {
        IWfNative iWfNative = this.b;
        if (iWfNative != null) {
            iWfNative.setNativeExpressListener(new ZV2Zz(nativeExpressInteractionListener));
        }
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public void setNativeInteractionListener(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, IFissionNative.NativeInteractionListener nativeInteractionListener) {
        IWfNative iWfNative = this.b;
        if (iWfNative != null) {
            iWfNative.setNativeInteractionListener(viewGroup, list, list2, list3, view, new zZZ2W(nativeInteractionListener));
        }
    }

    @Override // com.zm.fissionsdk.WVZZZ, com.zm.fissionsdk.api.interfaces.IFission
    public void setVideoListener(IFission.VideoListener videoListener) {
        IWfNative iWfNative = this.b;
        if (iWfNative != null) {
            iWfNative.setVideoListener(new ZV2zV(videoListener));
        }
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionNative
    public void setVideoMute(boolean z) {
        IWfNative iWfNative = this.b;
        if (iWfNative != null) {
            iWfNative.setVideoMute(z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class Z2WzW implements IWfShakeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IFissionNative.ShakeListener f16746a;

        public Z2WzW(IFissionNative.ShakeListener shakeListener) {
            this.f16746a = shakeListener;
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfShakeListener
        public void onShake() {
            IFissionNative.ShakeListener shakeListener = this.f16746a;
            if (shakeListener != null) {
                shakeListener.onShake();
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfShakeListener
        public void onShakeDismiss() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class Z2ZWz implements WfDislikeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IFissionNative.DislikeListener f16747a;

        public Z2ZWz(IFissionNative.DislikeListener dislikeListener) {
            this.f16747a = dislikeListener;
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.WfDislikeListener
        public void onDislike(int i, String str) {
            IFissionNative.DislikeListener dislikeListener = this.f16747a;
            if (dislikeListener != null) {
                dislikeListener.onDislike(i, str);
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.WfDislikeListener
        public void onCancel() {
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.WfDislikeListener
        public void onShow() {
        }
    }
}
