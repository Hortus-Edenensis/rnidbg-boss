package com.zm.fissionsdk.api.interfaces;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.zm.fissionsdk.api.FissionVideoOption;
import com.zm.fissionsdk.api.interfaces.IFission;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IFissionNative extends IFission {

    /* JADX INFO: compiled from: SearchBox */
    public interface DislikeListener {
        void onDislike(int i, String str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface NativeExpressInteractionListener extends NativeInteractionListener {
        void onClose();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface NativeInteractionListener extends IFissionInteractionListener {
        void onCreativeClick(View view);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface ShakeListener {
        void onShake();
    }

    String getAppIcon();

    String getAppName();

    String getAppVersion();

    String getBtnText();

    String getDesc();

    String getDeveloperName();

    View getExpressView(Context context);

    String getFunctionDescUrl();

    List<String> getImageList();

    int getInteractionType();

    int getMaterialHeight();

    int getMaterialType();

    int getMaterialWidth();

    String getPackageName();

    String getPermissionUrl();

    Map<String, String> getPermissionsMap();

    String getPrivacyUrl();

    String getTitle();

    View getVideoView(Context context, FissionVideoOption fissionVideoOption);

    View renderShakeView(Context context, int i, int i2, ShakeListener shakeListener);

    void setDislikeListener(DislikeListener dislikeListener);

    void setNativeExpressListener(NativeExpressInteractionListener nativeExpressInteractionListener);

    void setNativeInteractionListener(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, NativeInteractionListener nativeInteractionListener);

    @Override // com.zm.fissionsdk.api.interfaces.IFission
    void setVideoListener(IFission.VideoListener videoListener);

    void setVideoMute(boolean z);
}
