package com.zenmen.media.rtc;

import android.content.Context;
import android.hardware.Camera;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceView;
import com.ss.android.ttvecamera.TECameraSettings;
import com.zenmen.media.msgevent.MediaClientEvent;
import com.zenmen.media.rtc.CameraRecorder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ZMRtcSDK implements IZMRtc {
    public static int RtcCALL_SOURCE_CHATTING_ACTIVITY_RECORD = 0;
    public static int RtcCALL_SOURCE_CHATTING_ACTIVITY_TIPS = 0;
    public static int RtcCALL_SOURCE_DEFAULT = 0;
    public static int RtcCALL_SOURCE_DETAIL_PAGE = 0;
    public static int RtcNetStatus_Bad = 0;
    public static int RtcNetStatus_Good = 0;
    public static int RtcNetStatus_Maybe_Disconnected = 0;
    public static int RtcNetStatus_Normal = 0;
    public static int RtcNetStatus_Reconnected = 0;
    public static int RtcNetStatus_VeryBad = 0;
    private static final String TAG = "@@@Video ZMRtcSDK";
    private Context mContext;
    private MediaClientEvent mMediaClientEvent;
    private long mUseID = 0;
    private long mFriendID = 0;
    private ZMRtcUserType mUseType = ZMRtcUserType.RtcUser_Zhangxin;
    private ZMRtcMediaType mMediaType = ZMRtcMediaType.RtcMedia_Video;
    CameraRecorder mCameraRec = null;
    CameraView mCameraView = null;
    private int mWidth = 270;
    private int mHeight = TECameraSettings.FPS_480;

    static {
        try {
            System.loadLibrary("AudioSDK");
            System.loadLibrary("VideoCodec2");
            System.loadLibrary("MediaSDK");
            System.loadLibrary("Mediajni");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
        RtcNetStatus_Normal = 0;
        RtcNetStatus_Good = 1;
        RtcNetStatus_Bad = -1;
        RtcNetStatus_VeryBad = -2;
        RtcNetStatus_Maybe_Disconnected = -3;
        RtcNetStatus_Reconnected = -4;
        RtcCALL_SOURCE_DEFAULT = 0;
        RtcCALL_SOURCE_DETAIL_PAGE = 1;
        RtcCALL_SOURCE_CHATTING_ACTIVITY_RECORD = 2;
        RtcCALL_SOURCE_CHATTING_ACTIVITY_TIPS = 3;
    }

    public ZMRtcSDK() {
        nativeSetup(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        android.util.Log.i("TAG", "detect an front camera");
        android.hardware.Camera.open(r3).release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean detectCameraPermission() {
        try {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            if (Camera.getNumberOfCameras() == 1) {
                Camera.getCameraInfo(0, cameraInfo);
            }
            int i = 0;
            while (true) {
                if (i >= Camera.getNumberOfCameras()) {
                    break;
                }
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 1) {
                    try {
                        break;
                    } catch (Exception unused) {
                        Log.i("TAG", "detect an front camera Exception");
                        return false;
                    }
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public native int ProvideCameraFrame(byte[] bArr, int i, int i2, long j);

    @Override // com.zenmen.media.rtc.IZMRtc
    public int accpet() {
        return nativeaccept();
    }

    @Override // com.zenmen.media.rtc.IZMRtc
    public void addRemoteView(int i, Surface surface) {
        if (surface == null) {
            return;
        }
        addUserLayer(i, surface);
    }

    public native int addUserLayer(int i, Object obj);

    @Override // com.zenmen.media.rtc.IZMRtc
    public int busyRefuse(int i) {
        return nativebusyRefuse(i);
    }

    @Override // com.zenmen.media.rtc.IZMRtc
    public int calltoFriend(long j, ZMRtcMediaType zMRtcMediaType) {
        this.mFriendID = j;
        this.mMediaType = zMRtcMediaType;
        return nativecalltoFriend(j, zMRtcMediaType.ordinal());
    }

    @Override // com.zenmen.media.rtc.IZMRtc
    public int cancel() {
        return nativecancel();
    }

    @Override // com.zenmen.media.rtc.IZMRtc
    public int closePreviewOnView() {
        synchronized (this) {
            CameraRecorder cameraRecorder = this.mCameraRec;
            if (cameraRecorder != null) {
                cameraRecorder.stopCamera();
                this.mCameraRec.destroy();
                this.mCameraRec = null;
            }
        }
        return 0;
    }

    @Override // com.zenmen.media.rtc.IZMRtc
    public int deleteRemoteView(int i) {
        deleteUserLayer(i);
        return 0;
    }

    public native int deleteUserLayer(int i);

    @Override // com.zenmen.media.rtc.IZMRtc
    public native void enableLocalVideo(boolean z);

    @Override // com.zenmen.media.rtc.IZMRtc
    public int finish() {
        closePreviewOnView();
        stopVideoCapture();
        return nativefinish();
    }

    public String getCallNotifyMsg(int i, boolean z, int i2, int i3, String str) {
        return nativegetCallNotifyMsg(i, z, i2, i3, str);
    }

    @Override // com.zenmen.media.rtc.IZMRtc
    public int getDeviceInfoMessage() {
        return nativegetDeviceInfoMessage();
    }

    @Override // com.zenmen.media.rtc.IZMRtc
    public int getLiveMessage() {
        return nativegetLiveMessage();
    }

    @Override // com.zenmen.media.rtc.IZMRtc
    public int getMessageInfo(String str, ZMRtcSessionInfo zMRtcSessionInfo) {
        return nativegetMessageInfo(str, zMRtcSessionInfo);
    }

    @Override // com.zenmen.media.rtc.IZMRtc
    public long getRoomNumber() {
        return nativegetCurRoomNumber();
    }

    public int getSessionStatus() {
        return nativegetSessionStatus();
    }

    @Override // com.zenmen.media.rtc.IZMRtc
    public int getVideoHeight() {
        return this.mHeight;
    }

    @Override // com.zenmen.media.rtc.IZMRtc
    public int getVideoWidth() {
        return this.mWidth;
    }

    @Override // com.zenmen.media.rtc.IZMRtc
    public int hangup() {
        return nativehangup();
    }

    @Override // com.zenmen.media.rtc.IZMRtc
    public int incomingMessage(String str) {
        return nativeincomingMessage(str);
    }

    public void increaseCameraExposure(boolean z) {
        CameraRecorder cameraRecorder = this.mCameraRec;
        if (cameraRecorder != null) {
            cameraRecorder.increaseCameraExposure(z);
        }
    }

    @Override // com.zenmen.media.rtc.IZMRtc
    public int init(long j, ZMRtcUserType zMRtcUserType, MediaClientEvent mediaClientEvent) {
        this.mUseID = j;
        this.mUseType = zMRtcUserType;
        this.mMediaClientEvent = mediaClientEvent;
        mediaClientEvent.setZmRtcSDK(this);
        new AvcEncoder().getClassName();
        return nativeinit(j, this.mUseType.ordinal(), mediaClientEvent);
    }

    @Override // com.zenmen.media.rtc.IZMRtc
    public native void muteVoice(boolean z);

    public native int nativeManualRefuse();

    public native void nativeSetup(Object obj);

    public native int nativeaccept();

    public native int nativebusyRefuse(int i);

    public native int nativecalltoFriend(long j, int i);

    public native int nativecancel();

    public native int nativefinish();

    public native String nativegetCallNotifyMsg(int i, boolean z, int i2, int i3, String str);

    public native long nativegetCurRoomNumber();

    public native int nativegetDeviceInfoMessage();

    public native int nativegetLiveMessage();

    public native int nativegetMessageInfo(String str, Object obj);

    public native int nativegetSessionStatus();

    public native int nativehangup();

    public native int nativeincomingMessage(String str);

    public native int nativeinit(long j, int i, Object obj);

    public native int nativerefuse();

    public native void nativerelease();

    public native void nativesetAPMProperty(int i, int i2);

    public native int nativesetParam(int i, Object obj);

    public native void nativesetnetworkArea(String str);

    public native int nativestartVoip();

    @Override // com.zenmen.media.rtc.IZMRtc
    public int refuse() {
        return nativerefuse();
    }

    public int refuse_manual() {
        return nativeManualRefuse();
    }

    @Override // com.zenmen.media.rtc.IZMRtc
    public void release() {
        synchronized (this) {
            CameraRecorder cameraRecorder = this.mCameraRec;
            if (cameraRecorder != null) {
                cameraRecorder.stopCamera();
                this.mCameraRec.destroy();
                this.mCameraRec = null;
            }
        }
        nativerelease();
    }

    public native int resetVideoCapture(int i, int i2, int i3);

    @Override // com.zenmen.media.rtc.IZMRtc
    public void setAPMProperty(int i, int i2) {
        nativesetAPMProperty(i, i2);
    }

    @Override // com.zenmen.media.rtc.IZMRtc
    public void setNetworkArea(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        nativesetnetworkArea(str);
    }

    @Override // com.zenmen.media.rtc.IZMRtc
    public int setParam(ZMRtcParamID zMRtcParamID, Object obj) {
        return nativesetParam(zMRtcParamID.ordinal(), obj);
    }

    public native int setVideoCaptureInfo(int i, int i2, int i3, int i4, int i5);

    @Override // com.zenmen.media.rtc.IZMRtc
    public int startPreviewOnView(SurfaceView surfaceView, int i, CameraRecorder.CAMERA_TYPE camera_type) {
        int iOpenCamera;
        synchronized (this) {
            CameraRecorder cameraRecorder = this.mCameraRec;
            if (cameraRecorder != null) {
                cameraRecorder.stopCamera();
                this.mCameraRec.destroy();
                this.mCameraRec = null;
            }
            CameraRecorder cameraRecorder2 = new CameraRecorder(this, camera_type);
            this.mCameraRec = cameraRecorder2;
            CameraView cameraView = (CameraView) surfaceView;
            this.mCameraView = cameraView;
            cameraView.setGLSurfaceViewListener(cameraRecorder2.getCameraHandler());
            this.mCameraRec.init(this.mWidth, this.mHeight, this.mCameraView, i);
            this.mCameraRec.setSurfaceTexture(this.mCameraView.getSurfaceTexture());
            iOpenCamera = this.mCameraRec.openCamera();
            if (iOpenCamera == -1) {
                Log.e(TAG, "Open camera fail");
            } else if (iOpenCamera == -2) {
                Log.e(TAG, "Open audio record fail");
            }
            CameraRecorder cameraRecorder3 = this.mCameraRec;
            if (iOpenCamera == 0) {
                this.mWidth = cameraRecorder3.getVideoWidth();
                this.mHeight = this.mCameraRec.getVideoHight();
            }
        }
        return iOpenCamera;
    }

    public native int startVideoCapture(int i, int i2, int i3);

    @Override // com.zenmen.media.rtc.IZMRtc
    public void startVideoWxH(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    @Override // com.zenmen.media.rtc.IZMRtc
    public int startVoip() {
        return nativestartVoip();
    }

    public native int stopVideoCapture();

    @Override // com.zenmen.media.rtc.IZMRtc
    public void switchCamera() {
        CameraRecorder cameraRecorder = this.mCameraRec;
        if (cameraRecorder != null) {
            cameraRecorder.switchCamera();
        }
    }
}
