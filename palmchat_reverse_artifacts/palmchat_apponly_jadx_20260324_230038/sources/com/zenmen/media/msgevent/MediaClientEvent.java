package com.zenmen.media.msgevent;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.zenmen.media.rtc.ZMRtcSDK;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class MediaClientEvent {
    public static final int MEDIA_CLIENT_EVENT_ACCEPTRESP = 3;
    public static final int MEDIA_CLIENT_EVENT_AUDIO_FRAME_LOW = 21;
    public static final int MEDIA_CLIENT_EVENT_CALLEEENTER = 8;
    public static final int MEDIA_CLIENT_EVENT_CALLEELEAVE = 9;
    public static final int MEDIA_CLIENT_EVENT_DISCONNETTED = 13;
    public static final int MEDIA_CLIENT_EVENT_EEACCEPTRESP = 4;
    public static final int MEDIA_CLIENT_EVENT_EEDISCONNETTED = 19;
    public static final int MEDIA_CLIENT_EVENT_EEFIRSTFRAME = 10;
    public static final int MEDIA_CLIENT_EVENT_EEHANGUPRESP = 6;
    public static final int MEDIA_CLIENT_EVENT_HANGUPRESP = 5;
    public static final int MEDIA_CLIENT_EVENT_JOINROOM = 11;
    public static final int MEDIA_CLIENT_EVENT_LEAVEROOM = 12;
    public static final int MEDIA_CLIENT_EVENT_NETSTATUS = 18;
    public static final int MEDIA_CLIENT_EVENT_ONCALL = 1;
    public static final int MEDIA_CLIENT_EVENT_ONRECEIVE = 2;
    public static final int MEDIA_CLIENT_EVENT_REMOTEVIDEOONOFF = 14;
    public static final int MEDIA_CLIENT_EVENT_ROOMDESTROY = 7;
    public static final int MEDIA_CLIENT_EVENT_ROOMMISSED = 22;
    public static final int MEDIA_CLIENT_EVENT_VIDEO_FRAME_LOW = 20;
    public static final int MEDIA_CLIENT_EVENT_VIDEO_FRAME_UPDATE = 29;
    public static final int MEDIA_CLIENT_EVENT_VOICEDEVERROR = 15;
    public static final int MEDIA_CLIENT_MSG_ACCEPT = 101;
    public static final int MEDIA_CLIENT_MSG_ACCEPTTIMEOUT = 107;
    public static final int MEDIA_CLIENT_MSG_BEASYREFUSE = 105;
    public static final int MEDIA_CLIENT_MSG_CALL = 100;
    public static final int MEDIA_CLIENT_MSG_CANCEL = 103;
    public static final int MEDIA_CLIENT_MSG_DEVICEINFO = 201;
    public static final int MEDIA_CLIENT_MSG_HANDUP = 104;
    public static final int MEDIA_CLIENT_MSG_HEARTBEAT = 200;
    public static final int MEDIA_CLIENT_MSG_REFUSE = 102;
    public static final int MEDIA_CLIENT_MSG_STATUS = 106;
    public static final int MEDIA_CLIENT_SDK_AUTORUNPERMISSIONGUIDE = 501;
    public static final int MEDIA_CLIENT_SDK_INCREASECAMERAEXPOSURE = 500;
    private static final String TAG = "MEDIA_ENGINE";
    private static MediaClientEvent mIntance;
    public static ZMRtcSDK mZMRtcSDK;
    private EventHandler mEventHandler = new EventHandler(this, Looper.myLooper());
    private Map<String, OnNotifyEventListener> mListenerArray;
    private OnNotifyEventListener mNotifyEventListener;

    /* JADX INFO: compiled from: SearchBox */
    public class EventHandler extends Handler {
        public EventHandler(MediaClientEvent mediaClientEvent, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                if (message.what == 500) {
                    ZMRtcSDK zMRtcSDK = MediaClientEvent.mZMRtcSDK;
                    boolean z = true;
                    if (message.arg1 != 1) {
                        z = false;
                    }
                    zMRtcSDK.increaseCameraExposure(z);
                }
                if (MediaClientEvent.this.mNotifyEventListener != null) {
                    MediaClientEvent.this.mNotifyEventListener.onEventNotify(message.what, message.arg1, message.arg2, message.obj);
                }
                if (MediaClientEvent.this.mListenerArray == null) {
                    return;
                }
                Iterator it = MediaClientEvent.this.mListenerArray.entrySet().iterator();
                while (it.hasNext()) {
                    ((OnNotifyEventListener) ((Map.Entry) it.next()).getValue()).onEventNotify(message.what, message.arg1, message.arg2, message.obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnNotifyEventListener {
        void onEventNotify(int i, int i2, int i3, Object obj);
    }

    public static MediaClientEvent getInstance() {
        if (mIntance == null) {
            mIntance = new MediaClientEvent();
        }
        return mIntance;
    }

    public static MediaClientEvent getNewInstance() {
        return new MediaClientEvent();
    }

    public void MessageEvent(int i, int i2, int i3, Object obj) {
        EventHandler eventHandler = this.mEventHandler;
        if (eventHandler != null) {
            this.mEventHandler.sendMessage(eventHandler.obtainMessage(i, i2, i3, obj));
        }
    }

    public EventHandler getEventHandler() {
        return this.mEventHandler;
    }

    public void registerNotifyEventListener(String str, OnNotifyEventListener onNotifyEventListener) {
        if (this.mListenerArray == null) {
            this.mListenerArray = new HashMap();
        }
        this.mListenerArray.put(str, onNotifyEventListener);
    }

    public void setOnNotifyEventListener(OnNotifyEventListener onNotifyEventListener) {
        this.mNotifyEventListener = onNotifyEventListener;
    }

    public void setZmRtcSDK(ZMRtcSDK zMRtcSDK) {
        mZMRtcSDK = zMRtcSDK;
    }
}
