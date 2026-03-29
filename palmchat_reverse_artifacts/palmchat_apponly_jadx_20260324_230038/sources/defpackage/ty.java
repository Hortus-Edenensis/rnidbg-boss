package defpackage;

import android.content.Context;
import android.graphics.Matrix;
import android.view.WindowManager;
import com.bytedance.realx.video.TextureBufferImpl;
import com.bytedance.realx.video.VideoFrame;
import com.ss.bytertc.base.media.camera.CameraSession;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class ty {
    public static VideoFrame.TextureBuffer a(TextureBufferImpl textureBufferImpl, boolean z, int i) {
        Matrix matrix = new Matrix();
        matrix.preTranslate(0.5f, 0.5f);
        if (z) {
            matrix.preScale(-1.0f, 1.0f);
        }
        matrix.preRotate(i);
        matrix.preTranslate(-0.5f, -0.5f);
        return textureBufferImpl.applyTransformMatrix(matrix, textureBufferImpl.getWidth(), textureBufferImpl.getHeight());
    }

    public static int b(Context context) {
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        return rotation != 1 ? rotation != 2 ? rotation != 3 ? CameraSession.UIDeviceOrientation.Portrait.value() : CameraSession.UIDeviceOrientation.LandscapeLeft.value() : CameraSession.UIDeviceOrientation.PortraitUpsideDown.value() : CameraSession.UIDeviceOrientation.LandscapeRight.value();
    }
}
