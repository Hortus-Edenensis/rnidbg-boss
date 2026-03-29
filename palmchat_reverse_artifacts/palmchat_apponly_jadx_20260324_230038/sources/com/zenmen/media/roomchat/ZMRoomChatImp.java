package com.zenmen.media.roomchat;

import android.view.Surface;
import com.zenmen.media.msgevent.MediaClientEvent;
import defpackage.nl0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ZMRoomChatImp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f11968a = true;

    static {
        try {
            System.loadLibrary("AudioSDK");
            System.loadLibrary("VideoCodec2");
            System.loadLibrary("MediaSDK");
            System.loadLibrary("RenderEngine");
            System.loadLibrary("NetworkEngine");
            System.loadLibrary("RoomChatJni");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            f11968a = false;
        }
    }

    public ZMRoomChatImp() {
        boolean z = (nl0.g() && nl0.c().equals("release")) ? false : true;
        if (f11968a) {
            nativeSetup(this, z);
        }
    }

    private native int nativeGetRoomlist();

    private native int nativeNetConnected();

    private native int nativeNetDisconnected();

    private native int nativeSetVideoCaptureInfo(int i, int i2, int i3, int i4, int i5);

    private native int nativeStartVoip();

    public void a(long j, long j2, long j3, boolean z) {
        if (f11968a) {
            nativeJoinRoomFromGroup(j, j2, j3, z);
        }
    }

    public void b(int i, long j) {
        if (f11968a) {
            nativeBusy(i, j);
        }
    }

    public void c(boolean z) {
        if (f11968a) {
            nativeCameraOn(z);
        }
    }

    public int d(long j, long[] jArr, int i) {
        if (f11968a) {
            return nativeCreateRoom(j, jArr, i);
        }
        return -1;
    }

    public void e() {
        if (f11968a) {
            nativeDestroyRoom();
        }
    }

    public void f() {
        if (f11968a) {
            nativefinish();
        }
    }

    public void g(String str) {
        if (f11968a) {
            nativeIncomingMessage(str);
        }
    }

    public int h(long j, String str, MediaClientEvent mediaClientEvent) {
        if (!f11968a) {
            return -1;
        }
        nativeRenderInit(9);
        return nativeInit(j, str, mediaClientEvent);
    }

    public void i(long[] jArr) {
        if (f11968a) {
            nativeInviteUsers(jArr);
        }
    }

    public void j(long j) {
        if (f11968a) {
            nativeJoinRoom(j);
        }
    }

    public void k(long j, long j2) {
        if (f11968a) {
            nativeLeaveRoom(j, j2);
        }
    }

    public int l() {
        if (f11968a) {
            return nativeLoginToVoipCmdChannel();
        }
        return -1;
    }

    public int m() {
        if (f11968a) {
            return nativeLoginToVoipNotifyChannel();
        }
        return -1;
    }

    public void n(boolean z) {
        if (f11968a) {
            nativeMute(z);
        }
    }

    public native void nativeBusy(int i, long j);

    public native void nativeCameraOn(boolean z);

    public native int nativeCreateRoom(long j, long[] jArr, int i);

    public native int nativeCreateRoom2(long j, long[] jArr, int i, String str);

    public native void nativeDestroyRoom();

    public native void nativeIncomingMessage(String str);

    public native int nativeInit(long j, String str, Object obj);

    public native void nativeInviteUsers(long[] jArr);

    public native int nativeJoinRoom(long j);

    public native void nativeJoinRoomFromGroup(long j, long j2, long j3, boolean z);

    public native void nativeLeaveRoom(long j, long j2);

    public native int nativeLoginToVoipCmdChannel();

    public native int nativeLoginToVoipNotifyChannel();

    public native void nativeMute(boolean z);

    public native int nativeParseIncomingMessage(String str);

    public native void nativeRefuse(long j);

    public native void nativeRelease();

    public native int nativeRenderInit(int i);

    public native int nativeRenderProvideCameraFrame(long j, byte[] bArr, int i, int i2, int i3, boolean z, long j2);

    public native int nativeRenderUninit();

    public native int nativeRenderUpdateVideoSurface(int i, long j, Object obj);

    public native int nativeSendMessageDirectly(String str);

    public native int nativeSetCMDConfig(String str, int i);

    public native void nativeSetNetworkArea(String str);

    public native int nativeSetNotifyConfig(String str, int i);

    public native int nativeSetNotifyConfigWithJson(String str);

    public native void nativeSetup(Object obj, boolean z);

    public native void nativeTimeout(long j);

    public native int nativeUnloginToVoipCmdChannel();

    public native int nativeUnloginToVoipNotifyChannel();

    public native void nativeUpdateUserList(long[] jArr, long[] jArr2, boolean z);

    public native void nativefinish();

    public native void nativegetLiveMessage();

    public int o() {
        if (f11968a) {
            return nativeNetConnected();
        }
        return -1;
    }

    public int p() {
        if (f11968a) {
            return nativeNetDisconnected();
        }
        return -1;
    }

    public void q(long j) {
        if (f11968a) {
            nativeRefuse(j);
        }
    }

    public int r(long j, byte[] bArr, int i, int i2, int i3, boolean z, long j2) {
        if (f11968a) {
            return nativeRenderProvideCameraFrame(j, bArr, i, i2, i3, z, j2);
        }
        return -1;
    }

    public int s(int i, long j, Surface surface) {
        if (f11968a) {
            return nativeRenderUpdateVideoSurface(i, j, surface);
        }
        return -1;
    }

    public void t(String str, int i) {
        if (f11968a) {
            nativeSetCMDConfig(str, i);
        }
    }

    public void u(String str) {
        if (f11968a) {
            nativeSetNetworkArea(str);
        }
    }

    public void v(String str, int i) {
        if (f11968a) {
            nativeSetNotifyConfig(str, i);
        }
    }

    public int w(int i, int i2, int i3, int i4, int i5) {
        if (f11968a) {
            return nativeSetVideoCaptureInfo(i, i2, i3, i4, i5);
        }
        return -1;
    }

    public void x(long j) {
        if (f11968a) {
            nativeTimeout(j);
        }
    }

    public int y() {
        if (f11968a) {
            return nativeUnloginToVoipCmdChannel();
        }
        return -1;
    }

    public int z() {
        if (f11968a) {
            return nativeUnloginToVoipNotifyChannel();
        }
        return -1;
    }
}
