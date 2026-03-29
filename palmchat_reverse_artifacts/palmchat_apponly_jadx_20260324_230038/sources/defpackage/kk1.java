package defpackage;

import com.ss.bytertc.engine.RTCVideo;
import com.ss.bytertc.engine.data.EffectBeautyMode;
import com.ss.bytertc.engine.video.IVideoEffect;
import com.wifi.ad.core.config.EventParams;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class kk1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IVideoEffect f18709a;
    public RTCVideo b;

    public void a(RTCVideo rTCVideo) {
        HashMap map = new HashMap();
        map.put(EventParams.KEY_PARAM_SDKVER, "4.4.3Lite");
        zn6.i("ByteBeauty_sdk_init", map);
        this.b = rTCVideo;
        b(true);
        this.f18709a = rTCVideo == null ? null : rTCVideo.getVideoEffectInterface();
    }

    public void b(boolean z) {
        if (!z) {
            this.b.enableEffectBeauty(false);
            return;
        }
        this.b.enableEffectBeauty(true);
        this.b.setBeautyIntensity(EffectBeautyMode.CLEAR, 0.7f);
        this.b.setBeautyIntensity(EffectBeautyMode.WHITE, 0.7f);
        this.b.setBeautyIntensity(EffectBeautyMode.SMOOTH, 0.8f);
        this.b.setBeautyIntensity(EffectBeautyMode.SHARPEN, 0.5f);
    }
}
