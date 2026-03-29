package com.zm.adxsdk.protocol.api.interfaces;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.zm.adxsdk.protocol.api.WfVideoOption;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IWfNative extends IWfAdvert {
    String getAppIcon();

    String getAppName();

    String getAppVersion();

    String getDesc();

    String getDeveloperName();

    View getExpressView(Context context);

    String getFunctionDescUrl();

    List<String> getImageList();

    @Override // com.zm.adxsdk.protocol.api.interfaces.IWfAdvert
    int getInteractionType();

    int getMaterialType();

    String getPermissionUrl();

    Map<String, String> getPermissionsMap();

    String getPrivacyUrl();

    String getTitle();

    View getVideoView(Context context, WfVideoOption wfVideoOption);

    boolean isDownload();

    boolean isSlideOpen();

    boolean isVideo();

    View renderShakeView(Context context, int i, int i2, int i3, IWfShakeListener iWfShakeListener);

    void setDislikeListener(WfDislikeListener wfDislikeListener);

    void setNativeExpressListener(NativeExpressInteractionListener nativeExpressInteractionListener);

    void setNativeInteractionListener(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, NativeInteractionListener nativeInteractionListener);

    void setVideoMute(boolean z);
}
