package defpackage;

import com.bytedance.realx.base.CalledByNative;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.video.VideoFrame;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ob6 {
    @CalledByNative("Buffer")
    public static VideoFrame.NV12Buffer a(VideoFrame.Buffer buffer) {
        RXLogging.e("VideoFrame", "toNV12 has not been implemented, default return null");
        return null;
    }
}
