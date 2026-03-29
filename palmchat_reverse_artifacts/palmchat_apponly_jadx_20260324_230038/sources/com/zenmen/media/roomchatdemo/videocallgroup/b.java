package com.zenmen.media.roomchatdemo.videocallgroup;

import com.zenmen.media.roomchat.RTCParameters;
import com.zenmen.media.roomchat.ZMRtcParseRoomInfo;
import com.zenmen.media.roomchatdemo.videocallgroup.VideoCallGroupUserAttribute;
import defpackage.ct2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {
    public static b i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<VideoCallGroupUserAttribute> f12003a;
    public int b;
    public int c = 0;
    public int d = 0;
    public VideoCallGroupUserAttribute e = null;
    public VideoCallGroupUserAttribute f = null;
    public VideoCallGroupUserAttribute g = null;
    public int h = 9;

    public b() {
        this.f12003a = null;
        this.b = 0;
        this.f12003a = Collections.synchronizedList(new ArrayList());
        this.b = 0;
    }

    public static b e() {
        if (i == null) {
            i = new b();
        }
        return i;
    }

    public final void a() {
        synchronized (this.f12003a) {
            for (int i2 = this.d; i2 < this.h; i2++) {
                VideoCallGroupUserAttribute videoCallGroupUserAttribute = new VideoCallGroupUserAttribute();
                videoCallGroupUserAttribute.status = VideoCallGroupUserAttribute.a.disable_gone;
                videoCallGroupUserAttribute.iconId = 0;
                videoCallGroupUserAttribute.iconUrl = null;
                videoCallGroupUserAttribute.userId = 0L;
                videoCallGroupUserAttribute.cameraon = 0;
                videoCallGroupUserAttribute.userCId = 0L;
                videoCallGroupUserAttribute.mute = 0;
                videoCallGroupUserAttribute.usertype = VideoCallGroupUserAttribute.b.idle;
                this.f12003a.add(videoCallGroupUserAttribute);
            }
        }
    }

    public VideoCallGroupUserAttribute b(int i2) {
        VideoCallGroupUserAttribute videoCallGroupUserAttribute;
        synchronized (this.f12003a) {
            videoCallGroupUserAttribute = this.f12003a.get(i2);
        }
        return videoCallGroupUserAttribute;
    }

    public List<VideoCallGroupUserAttribute> c() {
        List<VideoCallGroupUserAttribute> list;
        synchronized (this.f12003a) {
            list = this.f12003a;
        }
        return list;
    }

    public int d() {
        int i2;
        synchronized (this.f12003a) {
            i2 = this.b;
        }
        return i2;
    }

    public VideoCallGroupUserAttribute f() {
        VideoCallGroupUserAttribute videoCallGroupUserAttribute;
        synchronized (this.f12003a) {
            videoCallGroupUserAttribute = this.e;
        }
        return videoCallGroupUserAttribute;
    }

    public int g() {
        int size;
        synchronized (this.f12003a) {
            size = this.f12003a.size();
        }
        return size;
    }

    public long h() {
        synchronized (this.f12003a) {
            VideoCallGroupUserAttribute videoCallGroupUserAttribute = this.g;
            if (videoCallGroupUserAttribute == null) {
                return 0L;
            }
            return videoCallGroupUserAttribute.userCId;
        }
    }

    public int i() {
        int i2;
        synchronized (this.f12003a) {
            i2 = this.d;
        }
        return i2;
    }

    public final void j() {
        synchronized (this.f12003a) {
            VideoCallGroupUserAttribute videoCallGroupUserAttribute = this.g;
            if (videoCallGroupUserAttribute == null) {
                return;
            }
            try {
                this.f12003a.remove(videoCallGroupUserAttribute);
                this.f12003a.add(this.g);
            } catch (Exception unused) {
            }
        }
    }

    public int k(ZMRtcParseRoomInfo zMRtcParseRoomInfo) {
        long j;
        int i2;
        synchronized (this.f12003a) {
            if (zMRtcParseRoomInfo != null) {
                this.d = zMRtcParseRoomInfo.mUserList.size();
                this.b = 0;
                this.c = 0;
                this.g = null;
                this.f = null;
                this.e = null;
                this.f12003a.clear();
                Iterator<ZMRtcParseRoomInfo.UserItem> it = zMRtcParseRoomInfo.mUserList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        j = 0;
                        break;
                    }
                    ZMRtcParseRoomInfo.UserItem next = it.next();
                    if (next.mUserID == RTCParameters.l()) {
                        j = next.mInviterID;
                        break;
                    }
                }
                for (ZMRtcParseRoomInfo.UserItem userItem : zMRtcParseRoomInfo.mUserList) {
                    VideoCallGroupUserAttribute videoCallGroupUserAttribute = new VideoCallGroupUserAttribute();
                    videoCallGroupUserAttribute.userCId = userItem.mUserCID;
                    long j2 = userItem.mUserID;
                    videoCallGroupUserAttribute.userId = j2;
                    videoCallGroupUserAttribute.mute = userItem.mMute;
                    videoCallGroupUserAttribute.cameraon = userItem.mCameraOn;
                    videoCallGroupUserAttribute.iconId = ct2.f(j2);
                    videoCallGroupUserAttribute.iconUrl = ct2.g(userItem.mUserID);
                    videoCallGroupUserAttribute.userName = ct2.h(userItem.mUserID);
                    int i3 = this.c;
                    videoCallGroupUserAttribute.ctrlId = i3;
                    if (userItem.mUserStatus == 0) {
                        videoCallGroupUserAttribute.status = VideoCallGroupUserAttribute.a.connecting;
                        this.c = i3 + 1;
                    } else {
                        videoCallGroupUserAttribute.status = VideoCallGroupUserAttribute.a.connected;
                        this.b++;
                        this.c = i3 + 1;
                    }
                    videoCallGroupUserAttribute.usertype = VideoCallGroupUserAttribute.b.others;
                    long jL = RTCParameters.l();
                    long j3 = userItem.mUserID;
                    if (jL == j3) {
                        videoCallGroupUserAttribute.usertype = VideoCallGroupUserAttribute.b.myself;
                        this.g = videoCallGroupUserAttribute;
                    } else if (j == j3) {
                        videoCallGroupUserAttribute.usertype = VideoCallGroupUserAttribute.b.myinviter;
                        this.e = videoCallGroupUserAttribute;
                    }
                    if (userItem.mIsInitator) {
                        this.f = videoCallGroupUserAttribute;
                    }
                    this.f12003a.add(videoCallGroupUserAttribute);
                }
                a();
                j();
                i2 = this.b;
            } else {
                i2 = this.b;
            }
        }
        return i2;
    }

    public void l(ArrayList<VideoCallGroupUserAttribute> arrayList) {
        synchronized (this.f12003a) {
            if (arrayList != null) {
                this.b = 0;
                this.c = 0;
                this.d = arrayList.size();
                this.g = null;
                this.f = null;
                this.e = null;
                this.f12003a.clear();
                for (VideoCallGroupUserAttribute videoCallGroupUserAttribute : arrayList) {
                    VideoCallGroupUserAttribute videoCallGroupUserAttribute2 = new VideoCallGroupUserAttribute();
                    videoCallGroupUserAttribute2.userId = videoCallGroupUserAttribute.userId;
                    videoCallGroupUserAttribute2.iconId = videoCallGroupUserAttribute.iconId;
                    String str = videoCallGroupUserAttribute.iconUrl;
                    if (str != null) {
                        videoCallGroupUserAttribute2.iconUrl = str;
                    } else {
                        videoCallGroupUserAttribute2.iconUrl = ct2.g(videoCallGroupUserAttribute.userId);
                    }
                    videoCallGroupUserAttribute2.status = videoCallGroupUserAttribute.status;
                    videoCallGroupUserAttribute2.userName = ct2.h(videoCallGroupUserAttribute.userId);
                    videoCallGroupUserAttribute2.usertype = videoCallGroupUserAttribute.usertype;
                    videoCallGroupUserAttribute2.ctrlId = this.c;
                    this.f12003a.add(videoCallGroupUserAttribute2);
                    int i2 = this.c;
                    videoCallGroupUserAttribute.ctrlId = i2;
                    this.c = i2 + 1;
                    if (videoCallGroupUserAttribute2.usertype == VideoCallGroupUserAttribute.b.myself) {
                        this.g = videoCallGroupUserAttribute2;
                    }
                }
                a();
                j();
            }
        }
    }
}
