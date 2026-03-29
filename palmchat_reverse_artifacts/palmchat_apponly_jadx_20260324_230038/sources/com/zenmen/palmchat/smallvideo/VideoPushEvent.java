package com.zenmen.palmchat.smallvideo;

import androidx.annotation.Keep;
import com.zenmen.palmchat.smallvideo.VideoSDKPushReceiver;
import defpackage.ds0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class VideoPushEvent implements ds0.a {
    public VideoSDKPushReceiver.PushMsg resp;

    private VideoPushEvent(VideoSDKPushReceiver.PushMsg pushMsg) {
        this.resp = pushMsg;
    }

    public static VideoPushEvent produceEvent(VideoSDKPushReceiver.PushMsg pushMsg) {
        return new VideoPushEvent(pushMsg);
    }
}
