package com.volcengine.lxvertc.videocall.call;

import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.ss.bytertc.engine.RTCVideo;
import com.ss.bytertc.engine.UserInfo;
import com.ss.bytertc.engine.data.AudioPropertiesConfig;
import com.ss.bytertc.engine.data.AudioRoute;
import com.ss.bytertc.engine.data.LocalAudioPropertiesInfo;
import com.ss.bytertc.engine.data.RemoteAudioPropertiesInfo;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.data.VideoFrameInfo;
import com.ss.bytertc.engine.handler.IRTCRoomEventHandler;
import com.ss.bytertc.engine.handler.IRTCVideoEventHandler;
import com.ss.bytertc.engine.type.AudioScenarioType;
import com.ss.bytertc.engine.type.MediaStreamType;
import com.ss.bytertc.engine.type.NetworkQualityStats;
import com.ss.bytertc.engine.type.RemoteAudioStats;
import com.ss.bytertc.engine.type.RemoteStreamStats;
import com.ss.bytertc.engine.type.StreamRemoveReason;
import com.volcengine.lxvertc.videocall.call.CallCmd;
import com.volcengine.lxvertc.videocall.call.state.VoipState;
import com.volcengine.lxvertc.videocall.call.view.CallActivity;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.palmchat.rtc.bean.RoomSDKInfo;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.af2;
import defpackage.ap3;
import defpackage.az2;
import defpackage.b46;
import defpackage.dh;
import defpackage.dr4;
import defpackage.eg5;
import defpackage.er4;
import defpackage.ex;
import defpackage.fg5;
import defpackage.fh;
import defpackage.gy;
import defpackage.ir5;
import defpackage.iv4;
import defpackage.ja6;
import defpackage.jk;
import defpackage.jy;
import defpackage.kk1;
import defpackage.np2;
import defpackage.o0;
import defpackage.pm5;
import defpackage.qx;
import defpackage.rg;
import defpackage.rh6;
import defpackage.sa6;
import defpackage.sh6;
import defpackage.ti6;
import defpackage.u93;
import defpackage.v4;
import defpackage.va6;
import defpackage.vz4;
import defpackage.zn6;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11318a;
    public final qx b;
    public RTCVideo c;
    public kk1 d;
    public sa6 e;
    public gy f;
    public dr4 g;
    public final HashMap<String, Integer> h;
    public final HashMap<String, Boolean> i;
    public final IRTCVideoEventHandler j;
    public final IRTCRoomEventHandler k;
    public boolean l;
    public jy m;
    public long n;
    public final ex o;
    public long p;
    public final ti6.a q;
    public final ti6 r;

    /* JADX INFO: renamed from: com.volcengine.lxvertc.videocall.call.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0916a extends IRTCVideoEventHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f11319a = false;

        public C0916a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(AudioRoute audioRoute) {
            if (a.this.g != null) {
                a.this.g.h(audioRoute);
            }
        }

        @Override // com.ss.bytertc.engine.handler.IRTCVideoEventHandler
        public void onAudioRouteChanged(final AudioRoute audioRoute) {
            LogUtil.i("RTC", "IRTCVideoEventHandler onAudioRouteChanged");
            rg.a(new Runnable() { // from class: zw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22530a.b(audioRoute);
                }
            });
        }

        @Override // com.ss.bytertc.engine.handler.IRTCVideoEventHandler
        public void onFirstLocalVideoFrameCaptured(StreamIndex streamIndex, VideoFrameInfo videoFrameInfo) {
            LogUtil.i("RTC", "IRTCVideoEventHandler onFirstLocalVideoFrameCaptured");
            a.this.b.i();
        }

        @Override // com.ss.bytertc.engine.handler.IRTCVideoEventHandler
        public void onFirstRemoteVideoFrameDecoded(RemoteStreamKey remoteStreamKey, VideoFrameInfo videoFrameInfo) {
            LogUtil.i("RTC", "IRTCVideoEventHandler onFirstRemoteVideoFrameDecoded");
            a.this.b.a(remoteStreamKey.getRoomId(), String.valueOf(b46.a(remoteStreamKey.getUserId())));
        }

        @Override // com.ss.bytertc.engine.handler.IRTCVideoEventHandler
        public void onLocalAudioPropertiesReport(LocalAudioPropertiesInfo[] localAudioPropertiesInfoArr) {
            super.onLocalAudioPropertiesReport(localAudioPropertiesInfoArr);
            if (localAudioPropertiesInfoArr == null || localAudioPropertiesInfoArr.length == 0) {
                return;
            }
            boolean z = false;
            LocalAudioPropertiesInfo localAudioPropertiesInfo = localAudioPropertiesInfoArr[0];
            if (localAudioPropertiesInfo.audioPropertiesInfo.linearVolume > 6 && a.this.w() != null && !a.this.w().f()) {
                z = true;
            }
            if (z != this.f11319a) {
                fg5.a(new jk(localAudioPropertiesInfo.streamIndex, eg5.c().a(), z));
                this.f11319a = z;
            }
        }

        @Override // com.ss.bytertc.engine.handler.IRTCVideoEventHandler
        public void onRemoteAudioPropertiesReport(RemoteAudioPropertiesInfo[] remoteAudioPropertiesInfoArr, int i) {
            super.onRemoteAudioPropertiesReport(remoteAudioPropertiesInfoArr, i);
            Log.d("CallEngine", String.format("onRemoteAudioPropertiesReport: %s", af2.a().toJson(remoteAudioPropertiesInfoArr)));
            for (RemoteAudioPropertiesInfo remoteAudioPropertiesInfo : remoteAudioPropertiesInfoArr) {
                boolean z = remoteAudioPropertiesInfo.audioPropertiesInfo.linearVolume > 6;
                String strValueOf = String.valueOf(b46.a(remoteAudioPropertiesInfo.streamKey.getUserId()));
                Object obj = a.this.i.get(strValueOf);
                Boolean bool = Boolean.TRUE;
                if ((obj == bool) != z) {
                    fg5.a(new jk(remoteAudioPropertiesInfo.streamKey.getStreamIndex(), strValueOf, z));
                    if (z) {
                        a.this.i.put(strValueOf, bool);
                    } else {
                        a.this.i.remove(strValueOf);
                    }
                }
            }
        }

        @Override // com.ss.bytertc.engine.handler.IRTCVideoEventHandler
        public void onUserStartAudioCapture(String str, String str2) {
            String strValueOf = String.valueOf(b46.a(str2));
            LogUtil.i("RTC", "IRTCVideoEventHandler onUserStartAudioCapture");
            a.this.b.h(strValueOf, true);
        }

        @Override // com.ss.bytertc.engine.handler.IRTCVideoEventHandler
        public void onUserStartVideoCapture(String str, String str2) {
            String strValueOf = String.valueOf(b46.a(str2));
            LogUtil.i("RTC", "IRTCVideoEventHandler onUserStartVideoCapture");
            a.this.b.d(strValueOf, true);
            ja6.f().k(strValueOf, true);
        }

        @Override // com.ss.bytertc.engine.handler.IRTCVideoEventHandler
        public void onUserStopAudioCapture(String str, String str2) {
            String strValueOf = String.valueOf(b46.a(str2));
            LogUtil.i("RTC", "IRTCVideoEventHandler onUserStopAudioCapture");
            a.this.b.h(strValueOf, false);
        }

        @Override // com.ss.bytertc.engine.handler.IRTCVideoEventHandler
        public void onUserStopVideoCapture(String str, String str2) {
            String strValueOf = String.valueOf(b46.a(str2));
            LogUtil.i("RTC", "IRTCVideoEventHandler onUserStopVideoCapture");
            a.this.b.d(strValueOf, false);
            ja6.f().k(strValueOf, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends IRTCRoomEventHandler {

        /* JADX INFO: renamed from: com.volcengine.lxvertc.videocall.call.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC0917a implements Runnable {
            public RunnableC0917a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.A(null);
            }
        }

        /* JADX INFO: renamed from: com.volcengine.lxvertc.videocall.call.a$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC0918b implements Runnable {
            public RunnableC0918b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.A(null);
            }
        }

        public b() {
        }

        public final boolean a(int i) {
            return (i == 2 || i == 1 || i == 0) ? false : true;
        }

        public boolean b(int i, String str) {
            return d(str) == 0 && i == 0;
        }

        public boolean c(int i, String str) {
            return d(str) == 1 && i == 0;
        }

        public int d(String str) {
            try {
                return new JSONObject(str).getInt("join_type");
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }

        @Override // com.ss.bytertc.engine.handler.IRTCRoomEventHandler
        public void onNetworkQuality(NetworkQualityStats networkQualityStats, NetworkQualityStats[] networkQualityStatsArr) {
            LogUtil.i("RTC", "IRTCRoomEventHandler onNetworkQuality" + networkQualityStats.txQuality);
            String strA = eg5.c().a();
            HashMap<String, Boolean> map = new HashMap<>(2);
            map.put(strA, Boolean.valueOf(a(networkQualityStats.txQuality)));
            for (NetworkQualityStats networkQualityStats2 : networkQualityStatsArr) {
                map.put(String.valueOf(b46.a(networkQualityStats2.uid)), Boolean.valueOf(a(networkQualityStats.rxQuality)));
            }
            a.this.b.f(map);
            for (NetworkQualityStats networkQualityStats3 : networkQualityStatsArr) {
                a.this.h.put(String.valueOf(b46.a(networkQualityStats3.uid)), Integer.valueOf(networkQualityStats3.rxQuality));
            }
        }

        @Override // com.ss.bytertc.engine.handler.IRTCRoomEventHandler
        public void onRemoteStreamStats(RemoteStreamStats remoteStreamStats) {
            super.onRemoteStreamStats(remoteStreamStats);
            remoteStreamStats.uid = String.valueOf(b46.a(remoteStreamStats.uid));
            Log.d("CallEngine", String.format("onRemoteStreamStats: %s", remoteStreamStats));
            Integer num = (Integer) a.this.h.get(remoteStreamStats.uid);
            int iIntValue = num != null ? num.intValue() : 0;
            remoteStreamStats.rxQuality = iIntValue;
            RemoteAudioStats remoteAudioStats = remoteStreamStats.audioStats;
            if (remoteAudioStats != null) {
                remoteAudioStats.quality = iIntValue;
            }
            fg5.a(new iv4(remoteStreamStats));
        }

        @Override // com.ss.bytertc.engine.handler.IRTCRoomEventHandler
        public void onRoomStateChanged(String str, String str2, int i, String str3) {
            super.onRoomStateChanged(str, str2, i, str3);
            String strValueOf = String.valueOf(b46.a(str2));
            Log.d("CallEngine", String.format("onRoomStateChanged: %s %s %d %s", str, strValueOf, Integer.valueOf(i), str3));
            if (i == -1011) {
                u93.b(50, new RunnableC0917a());
                return;
            }
            if (i == -1000) {
                u93.b(2000, new RunnableC0918b());
            }
            if (!b(i, str3)) {
                if (c(i, str3)) {
                    fg5.a(new vz4(str));
                    return;
                }
                return;
            }
            va6 va6Var = new va6();
            va6Var.b = strValueOf;
            va6Var.f21394a = eg5.c().b();
            va6Var.c = v4.f() != null ? v4.f().getIconURL() : null;
            va6Var.f = TextUtils.isEmpty(a.this.z().h);
            va6Var.e = true;
            va6Var.g = false;
            ja6.f().a(va6Var);
        }

        @Override // com.ss.bytertc.engine.handler.IRTCRoomEventHandler
        public void onUserJoined(UserInfo userInfo, int i) {
            userInfo.uid = String.valueOf(b46.a(userInfo.uid));
            a.this.b.b(userInfo.getUid());
            LogUtil.i("RTC", "IRTCRoomEventHandler onUserJoined" + az2.c(userInfo));
            a.this.N(null);
            ja6.f().a(a.this.Q(userInfo));
        }

        @Override // com.ss.bytertc.engine.handler.IRTCRoomEventHandler
        public void onUserLeave(String str, int i) {
            String strValueOf = String.valueOf(b46.a(str));
            LogUtil.i("RTC", "IRTCRoomEventHandler onUserLeave" + strValueOf);
            String strA = eg5.c().a();
            er4.h();
            if (!TextUtils.equals(strValueOf, strA) && a.this.f != null) {
                if (a.this.z() != null) {
                    er4.i(a.this.z().c, true);
                }
                if (a.this.z() == null || TextUtils.isEmpty(a.this.z().h)) {
                    a.this.A(null);
                } else {
                    rh6 rh6VarZ = a.this.z();
                    if (ja6.f().d() == 2 && (!rh6VarZ.j.uid.equals(eg5.c().a()) || Math.abs(rh6VarZ.k - ir5.b()) > 30000)) {
                        a.this.A(null);
                    }
                }
            }
            er4.g();
            ja6.f().i(strValueOf);
            a.this.h.remove(strValueOf);
            a.this.i.remove(strValueOf);
        }

        @Override // com.ss.bytertc.engine.handler.IRTCRoomEventHandler
        public void onUserPublishStream(String str, MediaStreamType mediaStreamType) {
            super.onUserPublishStream(str, mediaStreamType);
            String strValueOf = String.valueOf(b46.a(str));
            Log.d("CallEngine", String.format("onUserPublishStream: %s %s", strValueOf, mediaStreamType.toString()));
            if (mediaStreamType == MediaStreamType.RTC_MEDIA_STREAM_TYPE_BOTH) {
                ja6.f().j(strValueOf, true);
                ja6.f().k(strValueOf, true);
            } else if (mediaStreamType == MediaStreamType.RTC_MEDIA_STREAM_TYPE_AUDIO) {
                ja6.f().j(strValueOf, true);
            } else if (mediaStreamType == MediaStreamType.RTC_MEDIA_STREAM_TYPE_VIDEO) {
                ja6.f().k(strValueOf, true);
            }
        }

        @Override // com.ss.bytertc.engine.handler.IRTCRoomEventHandler
        public void onUserUnpublishStream(String str, MediaStreamType mediaStreamType, StreamRemoveReason streamRemoveReason) {
            super.onUserUnpublishStream(str, mediaStreamType, streamRemoveReason);
            String strValueOf = String.valueOf(b46.a(str));
            Log.d("CallEngine", String.format("onUserUnPublishStream: %s, %s, %s", strValueOf, mediaStreamType.toString(), streamRemoveReason.toString()));
            if (mediaStreamType == MediaStreamType.RTC_MEDIA_STREAM_TYPE_BOTH) {
                ja6.f().j(strValueOf, false);
                ja6.f().k(strValueOf, false);
            } else if (mediaStreamType == MediaStreamType.RTC_MEDIA_STREAM_TYPE_AUDIO) {
                ja6.f().j(strValueOf, false);
            } else if (mediaStreamType == MediaStreamType.RTC_MEDIA_STREAM_TYPE_VIDEO) {
                ja6.f().k(strValueOf, false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends o0 {
        public c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k() {
            Log.d("CallEngine", "CallEngine initCallDurationTimer 2:" + a.this.p);
            a.this.T();
        }

        @Override // gy.b
        public void g(VoipState voipState, VoipState voipState2, rh6 rh6Var) {
            if (voipState2 == VoipState.IDLE) {
                Log.d("CallEngine", "CallEngine onCallStateChange restore idle");
                a.this.R();
                a.this.p = 0L;
                a.this.r.removeMessages(10001);
                a.this.l = false;
                return;
            }
            if (voipState2 == VoipState.ONTHECALL) {
                long jB = ir5.b();
                rh6 rh6VarZ = a.this.z();
                if (rh6VarZ != null) {
                    long j = rh6VarZ.m;
                    if (j > 0) {
                        jB = Math.min(jB, j);
                    }
                }
                a.this.p = jB;
                Log.d("CallEngine", "CallEngine initCallDurationTimer 1:" + a.this.p);
                a.this.r.post(new Runnable() { // from class: ax
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1595a.k();
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11324a = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void L(jy.a aVar) {
        gy gyVar;
        T t = aVar.f18531a;
        if (!(t instanceof sh6) || (gyVar = this.f) == null) {
            return;
        }
        gyVar.G((sh6) t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(Message message) {
        if (message.what == 10001) {
            T();
        }
    }

    public static a t() {
        return d.f11324a;
    }

    public void A(jy jyVar) {
        B(jyVar, true);
    }

    public void B(jy jyVar, boolean z) {
        gy gyVar = this.f;
        if (gyVar == null) {
            if (jyVar != null) {
                jyVar.a(new jy.a(false, "CallStateMachine is null!"));
                return;
            }
            return;
        }
        VoipState status = gyVar.b().getStatus();
        if (status == VoipState.IDLE) {
            return;
        }
        CallCmd callCmd = CallCmd.HANGUP;
        if (status == VoipState.CALLING) {
            callCmd = CallCmd.CANCEL;
        } else if (status == VoipState.RINGING || status == VoipState.ACCEPTED) {
            callCmd = CallCmd.REFUSE;
        }
        CallCmd.a aVar = new CallCmd.a(jyVar);
        aVar.f = z;
        this.f.r(callCmd, aVar);
        if (z) {
            ap3.a().v(0);
        }
    }

    public void C(String str, String str2) {
        Log.d("CallEngine", "init start " + str2);
        this.f11318a = str2;
        if (str2 != null && !str2.equals("audioMatch") && !this.f11318a.equals("videoMatch")) {
            np2 np2VarT = ap3.a().T();
            if (np2VarT.t()) {
                np2VarT.F();
                CallActivity callActivityJ1 = CallActivity.J1();
                if (callActivityJ1 != null) {
                    callActivityJ1.B = true;
                    callActivityJ1.finish();
                }
            }
        }
        if (this.c != null) {
            return;
        }
        Log.d("CallEngine", "init enter  bid=" + str2);
        RTCVideo rTCVideoCreateRTCVideo = RTCVideo.createRTCVideo(fh.a(), str, this.j, null, null);
        this.c = rTCVideoCreateRTCVideo;
        rTCVideoCreateRTCVideo.setAudioScenario(AudioScenarioType.AUDIO_SCENARIO_COMMUNICATION);
        this.c.enableAudioPropertiesReport(new AudioPropertiesConfig(2000, true, false));
        G();
        F(str2);
        E();
        H();
        D();
        fg5.b(this);
        HashMap map = new HashMap();
        map.put(EventParams.KEY_PARAM_SDKVER, "3.58.1.2700");
        zn6.i("ByteRTC_sdk_init", map);
    }

    public final void D() {
        this.b.u(this.o);
    }

    public final void E() {
        this.d = new kk1();
        String str = this.f11318a;
        if (str != null) {
            if (str.equals("videoMatch") || this.f11318a.equals("audioMatch")) {
                this.d.a(this.c);
            }
        }
    }

    public final void F(String str) {
        this.g = new dr4(this.c, this.b, this.k);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.g.l(str);
    }

    public void G() {
        this.e = new sa6();
    }

    public final void H() {
        gy gyVar = new gy();
        this.f = gyVar;
        gyVar.q(this.b);
    }

    public boolean I() {
        Log.d("CallEngine", "CallEngine isInFloatWindow:" + this.l);
        return this.l;
    }

    public boolean J() {
        return this.c != null;
    }

    public void K(RoomSDKInfo roomSDKInfo, CallType callType, jy jyVar) {
        if (this.f == null) {
            jyVar.a(new jy.a(false, "CallStateMachine is null!"));
            return;
        }
        CallCmd.a aVar = new CallCmd.a();
        aVar.c = roomSDKInfo.userList;
        aVar.b = eg5.c().a();
        aVar.f11317a = callType;
        aVar.d = jyVar;
        aVar.e = roomSDKInfo;
        this.f.r(CallCmd.JOIN, aVar);
    }

    public void N(jy jyVar) {
        gy gyVar = this.f;
        if (gyVar == null) {
            jyVar.a(new jy.a(false, "CallStateMachine is null!"));
        } else {
            gyVar.r(CallCmd.ONRTCROOMSTATECHANGED, new CallCmd.a(jyVar));
        }
    }

    public void O(sh6 sh6Var) {
        gy gyVar = this.f;
        if (gyVar == null) {
            return;
        }
        gyVar.G(sh6Var);
    }

    public void P(ex exVar) {
        if (exVar == null) {
            return;
        }
        this.b.I(exVar);
    }

    public va6 Q(UserInfo userInfo) {
        String extraInfo = userInfo.getExtraInfo();
        if (TextUtils.isEmpty(extraInfo)) {
            return new va6(userInfo.getUid());
        }
        va6 va6Var = (va6) af2.a().fromJson(extraInfo, va6.class);
        va6Var.b = userInfo.getUid();
        return va6Var;
    }

    public final void R() {
        if (this.p != 0) {
            this.n = s();
        }
    }

    public void S(boolean z) {
        Log.d("CallEngine", "CallEngine setInFloatWindow:" + z);
        this.l = z;
    }

    public final void T() {
        this.r.removeMessages(10001);
        this.r.sendEmptyMessageDelayed(10001, TimeUnit.SECONDS.toMillis(1L));
        this.b.e((int) (s() / 1000));
    }

    public void n(jy jyVar) {
        gy gyVar = this.f;
        if (gyVar == null) {
            jyVar.a(new jy.a(false, "CallStateMachine is null!"));
        } else {
            gyVar.r(CallCmd.ACCEPT, new CallCmd.a(jyVar));
        }
    }

    public void o(ex exVar) {
        if (exVar == null) {
            return;
        }
        this.b.u(exVar);
    }

    @pm5(threadMode = ThreadMode.MAIN)
    public void onAppTokenExpired(dh dhVar) {
        Log.d("CallEngine", "CallEngine onLogout");
        A(null);
    }

    public void p() {
        Log.d("CallEngine", "CallEngine destroy");
        this.b.I(this.o);
        gy gyVar = this.f;
        if (gyVar != null) {
            gyVar.H(this.b);
            this.f = null;
        }
        dr4 dr4Var = this.g;
        if (dr4Var != null) {
            dr4Var.c();
            this.g = null;
        }
        fg5.c(this);
        this.e = null;
        this.d = null;
        this.c = null;
    }

    public void q(RoomSDKInfo roomSDKInfo, CallType callType, jy jyVar) {
        if (this.f == null) {
            jyVar.a(new jy.a(false, "CallStateMachine is null!"));
            return;
        }
        CallCmd.a aVar = new CallCmd.a();
        aVar.c = roomSDKInfo.userList;
        aVar.b = eg5.c().a();
        aVar.f11317a = callType;
        aVar.d = jyVar;
        aVar.e = roomSDKInfo;
        this.f.r(CallCmd.DIAL, aVar);
    }

    public VoipState r() {
        gy gyVar = this.f;
        if (gyVar == null) {
            return null;
        }
        return gyVar.b().getStatus();
    }

    public long s() {
        if (this.p != 0) {
            return ir5.b() - this.p;
        }
        return 0L;
    }

    public int u() {
        return (int) (this.n / 1000);
    }

    public long v() {
        return this.n;
    }

    public dr4 w() {
        return this.g;
    }

    public RTCVideo x() {
        return this.c;
    }

    public sa6 y() {
        return this.e;
    }

    public rh6 z() {
        gy gyVar = this.f;
        if (gyVar == null) {
            return null;
        }
        return gyVar.d();
    }

    public a() {
        this.f11318a = null;
        this.b = new qx();
        this.h = new HashMap<>();
        this.i = new HashMap<>();
        this.j = new C0916a();
        this.k = new b();
        this.m = new jy() { // from class: xw
            @Override // defpackage.jy
            public final void a(jy.a aVar) {
                this.f22063a.L(aVar);
            }
        };
        this.n = 0L;
        this.o = new c();
        this.p = 0L;
        ti6.a aVar = new ti6.a() { // from class: yw
            @Override // ti6.a
            public final void a(Message message) {
                this.f22291a.M(message);
            }
        };
        this.q = aVar;
        this.r = new ti6(aVar);
    }
}
