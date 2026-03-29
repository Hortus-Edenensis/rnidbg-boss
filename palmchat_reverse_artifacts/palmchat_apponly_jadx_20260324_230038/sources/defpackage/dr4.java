package defpackage;

import android.text.TextUtils;
import android.view.TextureView;
import com.ss.bytertc.engine.RTCRoom;
import com.ss.bytertc.engine.RTCRoomConfig;
import com.ss.bytertc.engine.RTCVideo;
import com.ss.bytertc.engine.VideoCanvas;
import com.ss.bytertc.engine.VideoEncoderConfig;
import com.ss.bytertc.engine.audio.IAudioMixingManager;
import com.ss.bytertc.engine.data.AudioMixingConfig;
import com.ss.bytertc.engine.data.AudioMixingType;
import com.ss.bytertc.engine.data.AudioRoute;
import com.ss.bytertc.engine.data.CameraId;
import com.ss.bytertc.engine.data.MirrorType;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.data.VideoOrientation;
import com.ss.bytertc.engine.handler.IRTCRoomEventHandler;
import com.ss.bytertc.engine.type.AudioScenarioType;
import com.ss.bytertc.engine.type.ChannelProfile;
import com.ss.bytertc.engine.type.MediaStreamType;
import com.volcengine.lxvertc.videocall.call.a;
import com.volcengine.lxvertc.videocall.call.state.VoipState;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class dr4 {
    public boolean b;
    public boolean c;
    public RTCRoom d;
    public final qx e;
    public final RTCVideo f;
    public final IRTCRoomEventHandler g;
    public boolean h;
    public IAudioMixingManager j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CameraId f17128a = CameraId.CAMERA_ID_FRONT;
    public boolean i = false;
    public final AtomicBoolean k = new AtomicBoolean();

    public dr4(RTCVideo rTCVideo, qx qxVar, IRTCRoomEventHandler iRTCRoomEventHandler) {
        this.f = rTCVideo;
        this.e = qxVar;
        this.g = iRTCRoomEventHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(String str, File file) {
        boolean zA = iv1.a(fh.a(), str, file.getAbsolutePath());
        LogUtil.i("RTC", "playRing 2" + zA);
        if (zA) {
            q(file);
        }
    }

    public void A() {
        RTCRoom rTCRoom = this.d;
        if (rTCRoom == null) {
            return;
        }
        rTCRoom.unpublishStream(MediaStreamType.RTC_MEDIA_STREAM_TYPE_AUDIO);
    }

    public void B() {
        if (this.f == null) {
            return;
        }
        AudioRoute audioRouteD = d();
        AudioRoute audioRoute = AudioRoute.AUDIO_ROUTE_SPEAKERPHONE;
        AudioRoute audioRoute2 = audioRouteD == audioRoute ? AudioRoute.AUDIO_ROUTE_EARPIECE : audioRoute;
        this.f.setDefaultAudioRoute(audioRoute2);
        h(audioRoute2);
        a.t().r();
        if (audioRoute2 == audioRoute) {
            VoipState voipState = VoipState.IDLE;
        }
    }

    public void C() {
        RTCVideo rTCVideo = this.f;
        if (rTCVideo == null) {
            return;
        }
        CameraId cameraId = this.f17128a;
        CameraId cameraId2 = CameraId.CAMERA_ID_FRONT;
        if (cameraId == cameraId2) {
            cameraId2 = CameraId.CAMERA_ID_BACK;
        }
        rTCVideo.switchCamera(cameraId2);
        o(cameraId2);
        this.f17128a = cameraId2;
    }

    public void D() {
        j();
        try {
            RTCRoom rTCRoom = this.d;
            if (rTCRoom != null) {
                rTCRoom.unpublishStream(MediaStreamType.RTC_MEDIA_STREAM_TYPE_BOTH);
                this.d.leaveRoom();
                this.d.destroy();
                this.d = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void E() {
        boolean z = !this.c;
        this.c = z;
        if (z) {
            y();
            z();
        } else {
            t();
            u();
        }
        qx qxVar = this.e;
        if (qxVar != null) {
            qxVar.d(eg5.c().a(), !this.c);
        }
        ja6.f().k(eg5.c().a(), !this.c);
    }

    public void F() {
        boolean z = !this.b;
        this.b = z;
        if (z) {
            w();
            A();
        } else {
            p();
            v();
        }
        qx qxVar = this.e;
        if (qxVar != null) {
            qxVar.h(eg5.c().a(), !this.b);
        }
        ja6.f().j(eg5.c().a(), !this.b);
    }

    public int b(String str, String str2, boolean z) {
        RTCRoom rTCRoomCreateRTCRoom = this.f.createRTCRoom(str2);
        this.d = rTCRoomCreateRTCRoom;
        IRTCRoomEventHandler iRTCRoomEventHandler = this.g;
        if (iRTCRoomEventHandler != null) {
            rTCRoomCreateRTCRoom.setRTCRoomEventHandler(iRTCRoomEventHandler);
        }
        int iJoinRoom = this.d.joinRoom(str, ja6.c(v4.f()), new RTCRoomConfig(ChannelProfile.CHANNEL_PROFILE_CHAT, z, true, true));
        LogUtil.i("RTC", "creteAndJoinRTCRoom " + iJoinRoom + " mRoomEventHandler=" + this.g);
        return iJoinRoom;
    }

    public void c() {
        w();
        y();
        A();
        z();
        D();
        if (this.f != null) {
            RTCVideo.destroyRTCVideo();
        }
        ja6.f().h();
        ra6.e().a();
    }

    public AudioRoute d() {
        return this.f.getAudioRoute();
    }

    public boolean e() {
        return this.c;
    }

    public boolean f() {
        return this.b;
    }

    public void h(AudioRoute audioRoute) {
        qx qxVar = this.e;
        if (qxVar != null) {
            qxVar.c(audioRoute);
        }
    }

    public void i() {
        RTCVideo rTCVideo = this.f;
        IAudioMixingManager audioMixingManager = rTCVideo == null ? null : rTCVideo.getAudioMixingManager();
        this.j = audioMixingManager;
        if (audioMixingManager == null || this.k.get()) {
            return;
        }
        k(true);
        String str = fh.a().getExternalFilesDir("assets").getAbsolutePath() + "/resource/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        final File file2 = new File(str, "voip_ringtone.mp3");
        if (file2.exists()) {
            LogUtil.i("RTC", "playRing 1");
            q(file2);
        } else {
            final String str2 = "sound/voip_ringtone.mp3";
            rg.c().execute(new Runnable() { // from class: cr4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16903a.g(str2, file2);
                }
            });
        }
    }

    public final void j() {
        this.c = false;
        this.b = false;
        if (this.f17128a == CameraId.CAMERA_ID_BACK) {
            RTCVideo rTCVideo = this.f;
            CameraId cameraId = CameraId.CAMERA_ID_FRONT;
            rTCVideo.switchCamera(cameraId);
            this.f17128a = cameraId;
        }
        AudioRoute audioRouteD = d();
        AudioRoute audioRoute = AudioRoute.AUDIO_ROUTE_SPEAKERPHONE;
        if (audioRouteD != audioRoute) {
            this.f.setDefaultAudioRoute(audioRoute);
        }
    }

    public void k(boolean z) {
        RTCVideo rTCVideo = this.f;
        if (rTCVideo == null) {
            return;
        }
        rTCVideo.setAudioScenario(z ? AudioScenarioType.AUDIO_SCENARIO_MEDIA : AudioScenarioType.AUDIO_SCENARIO_HIGHQUALITY_CHAT);
    }

    public void l(String str) {
        RTCVideo rTCVideo = this.f;
        if (rTCVideo == null || str == null) {
            return;
        }
        rTCVideo.setBusinessId(str);
    }

    public void m(boolean z) {
        this.c = z;
        qx qxVar = this.e;
        if (qxVar != null) {
            qxVar.d(eg5.c().a(), !this.c);
        }
    }

    public void n() {
        if (this.i) {
            return;
        }
        this.i = true;
        this.c = true;
    }

    public final void o(CameraId cameraId) {
        RTCVideo rTCVideo = this.f;
        if (rTCVideo == null) {
            return;
        }
        rTCVideo.setLocalVideoMirrorType(cameraId == CameraId.CAMERA_ID_FRONT ? MirrorType.MIRROR_TYPE_RENDER_AND_ENCODER : MirrorType.MIRROR_TYPE_NONE);
    }

    public void p() {
        if (this.f == null || this.b) {
            return;
        }
        LogUtil.i("RTC", "startAudioCapture");
        this.f.startAudioCapture();
    }

    public final void q(File file) {
        this.j.startAudioMixing(19, file.getAbsolutePath(), new AudioMixingConfig(AudioMixingType.AUDIO_MIXING_TYPE_PLAYOUT, -1));
        this.k.set(true);
    }

    public void r(TextureView textureView) {
        if (this.f == null) {
            return;
        }
        this.f.setLocalVideoCanvas(StreamIndex.STREAM_INDEX_MAIN, new VideoCanvas(textureView, 1));
    }

    public void s(String str, String str2, TextureView textureView) {
        if (this.f == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f.setRemoteVideoCanvas(new RemoteStreamKey(str2, b46.b(Long.parseLong(str)), StreamIndex.STREAM_INDEX_MAIN), new VideoCanvas(textureView, 1));
    }

    public void t() {
        LogUtil.i("RTCController", "startVideoCapture 1");
        if (this.f == null || this.c) {
            return;
        }
        if (!this.h) {
            this.f.setVideoEncoderConfig(new VideoEncoderConfig(720, 1280, 15, -1, 0));
            this.f.setVideoOrientation(VideoOrientation.PORTRAIT);
            this.h = true;
        }
        o(this.f17128a);
        this.f.startVideoCapture();
        LogUtil.i("RTCController", "startVideoCapture 2");
    }

    public void u() {
        LogUtil.i("RTCController", "startVideoPublish 1");
        RTCRoom rTCRoom = this.d;
        if (rTCRoom == null || this.c) {
            return;
        }
        rTCRoom.publishStream(MediaStreamType.RTC_MEDIA_STREAM_TYPE_VIDEO);
        LogUtil.i("RTCController", "startVideoPublish 2");
    }

    public void v() {
        RTCRoom rTCRoom = this.d;
        if (rTCRoom == null || this.b) {
            return;
        }
        rTCRoom.publishStream(MediaStreamType.RTC_MEDIA_STREAM_TYPE_AUDIO);
    }

    public void w() {
        if (this.f == null) {
            return;
        }
        LogUtil.i("RTC", "stopAudioCapture");
        this.f.stopAudioCapture();
    }

    public void x() {
        if (this.j == null || !this.k.get()) {
            return;
        }
        this.j.stopAudioMixing(19);
        this.k.set(false);
    }

    public void y() {
        LogUtil.i("RTCController", "stopVideoCapture 1");
        RTCVideo rTCVideo = this.f;
        if (rTCVideo == null) {
            return;
        }
        rTCVideo.stopVideoCapture();
        LogUtil.i("RTCController", "stopVideoCapture 2");
    }

    public void z() {
        LogUtil.i("RTCController", "stopVideoPublish 1");
        RTCRoom rTCRoom = this.d;
        if (rTCRoom == null) {
            return;
        }
        rTCRoom.unpublishStream(MediaStreamType.RTC_MEDIA_STREAM_TYPE_VIDEO);
        LogUtil.i("RTCController", "stopVideoPublish 2");
    }
}
