package com.zenmen.media.rtc;

import android.view.Surface;
import android.view.SurfaceView;
import com.zenmen.media.msgevent.MediaClientEvent;
import com.zenmen.media.rtc.CameraRecorder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IZMRtc {
    int accpet();

    void addRemoteView(int i, Surface surface);

    int busyRefuse(int i);

    int calltoFriend(long j, ZMRtcMediaType zMRtcMediaType);

    int cancel();

    int closePreviewOnView();

    int deleteRemoteView(int i);

    void enableLocalVideo(boolean z);

    int finish();

    int getDeviceInfoMessage();

    int getLiveMessage();

    int getMessageInfo(String str, ZMRtcSessionInfo zMRtcSessionInfo);

    long getRoomNumber();

    int getVideoHeight();

    int getVideoWidth();

    int hangup();

    int incomingMessage(String str);

    int init(long j, ZMRtcUserType zMRtcUserType, MediaClientEvent mediaClientEvent);

    void muteVoice(boolean z);

    int refuse();

    void release();

    void setAPMProperty(int i, int i2);

    void setNetworkArea(String str);

    int setParam(ZMRtcParamID zMRtcParamID, Object obj);

    int startPreviewOnView(SurfaceView surfaceView, int i, CameraRecorder.CAMERA_TYPE camera_type);

    void startVideoWxH(int i, int i2);

    int startVoip();

    void switchCamera();
}
