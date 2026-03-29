package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.Quaternionf;
import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.engine.video.IPanoramicVideo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class NativePanoramicVideo implements IPanoramicVideo {
    private static final String TAG = "NativePanoramicVideo}";
    private long mNaiveInstance;

    public NativePanoramicVideo(long j) {
        this.mNaiveInstance = j;
    }

    public static native int nativeUpdateQuaternionf(long j, float f, float f2, float f3, float f4);

    public void release() {
        this.mNaiveInstance = 0L;
    }

    @Override // com.ss.bytertc.engine.video.IPanoramicVideo
    public int updateQuaternionf(Quaternionf quaternionf) {
        long j = this.mNaiveInstance;
        if (j != 0) {
            return nativeUpdateQuaternionf(j, quaternionf.x, quaternionf.y, quaternionf.z, quaternionf.w);
        }
        LogUtil.e(TAG, "native Panoramic is invalid, updateQuaternionf failed.");
        return -1;
    }
}
