package defpackage;

import android.text.TextUtils;
import android.util.Log;
import android.view.TextureView;
import com.ss.bytertc.engine.RTCVideo;
import com.ss.bytertc.engine.VideoCanvas;
import com.ss.bytertc.engine.data.AudioRoute;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.type.AudioProfileType;
import com.volcengine.lxvertc.videocall.call.a;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ra6 {
    public static ra6 o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RTCVideo f20430a;
    public String i;
    public Map<String, TextureView> b = new HashMap();
    public boolean c = true;
    public boolean d = true;
    public boolean e = false;
    public boolean f = true;
    public boolean g = true;
    public boolean h = true;
    public AudioRoute j = null;
    public String k = "720*1280";
    public AudioProfileType l = um0.b;
    public final HashMap<String, Integer> m = new HashMap<>();
    public final HashMap<String, Boolean> n = new HashMap<>();

    public static ra6 e() {
        if (o == null) {
            o = new ra6();
        }
        return o;
    }

    public void a() {
        this.b.clear();
    }

    public final RTCVideo b() {
        RTCVideo rTCVideo = this.f20430a;
        return rTCVideo != null ? rTCVideo : a.t().x();
    }

    public TextureView c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        TextureView textureView = this.b.get(str);
        if (textureView != null) {
            return textureView;
        }
        TextureView textureView2 = new TextureView(fh.a());
        this.b.put(str, textureView2);
        return textureView2;
    }

    public final String d() {
        if (!TextUtils.isEmpty(this.i)) {
            return this.i;
        }
        rh6 rh6VarZ = a.t().z();
        if (rh6VarZ != null) {
            return rh6VarZ.c;
        }
        return null;
    }

    public void f(boolean z, TextureView textureView) {
        Log.d("LxVeRtcManager", String.format("setLocalVideoCanvas: %b", Boolean.valueOf(z)));
        RTCVideo rTCVideoB = b();
        if (rTCVideoB != null) {
            StreamIndex streamIndex = z ? StreamIndex.STREAM_INDEX_SCREEN : StreamIndex.STREAM_INDEX_MAIN;
            VideoCanvas videoCanvas = new VideoCanvas();
            videoCanvas.renderView = textureView;
            videoCanvas.renderMode = 1;
            rTCVideoB.setLocalVideoCanvas(streamIndex, videoCanvas);
        }
    }

    public void g(String str, boolean z, TextureView textureView) {
        Log.d("LxVeRtcManager", String.format("setRemoteVideCanvas: %s  %b", str, Boolean.valueOf(z)));
        RTCVideo rTCVideoB = b();
        String strD = d();
        if (rTCVideoB == null || TextUtils.isEmpty(strD)) {
            return;
        }
        StreamIndex streamIndex = z ? StreamIndex.STREAM_INDEX_SCREEN : StreamIndex.STREAM_INDEX_MAIN;
        VideoCanvas videoCanvas = new VideoCanvas(textureView, z ? 2 : 1);
        RemoteStreamKey remoteStreamKey = new RemoteStreamKey(strD, b46.b(Long.parseLong(str)), streamIndex);
        videoCanvas.renderView = textureView;
        rTCVideoB.setRemoteVideoCanvas(remoteStreamKey, videoCanvas);
    }
}
