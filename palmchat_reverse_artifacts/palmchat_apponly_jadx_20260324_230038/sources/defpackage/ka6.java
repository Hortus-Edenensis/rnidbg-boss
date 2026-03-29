package defpackage;

import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.oplus.tblplayer.processor.util.EffectConstants;
import com.zenmen.media.roomchat.VideoCallGroupChattingNativeSDK;
import com.zenmen.media.roomchatdemo.videocallgroup.VideoCallGroupChattingUIActivity;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ka6 implements Camera.PreviewCallback {
    public static String C = "RecorderCameraView";
    public Surface b = null;
    public SurfaceTexture c = null;
    public Camera d = null;
    public boolean e = false;
    public int f = 0;
    public boolean g = true;
    public int h = 90;
    public int i = 0;
    public int j = 0;
    public long k = 0;
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;
    public boolean o = true;
    public int p = 44100;
    public int q = 1;
    public int r = EffectConstants.ROTATION_DEGREES_180;
    public int s = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
    public int t = 1280;
    public int u = 720;
    public int v = 15;
    public int w = 30;
    public String x = null;
    public VideoCallGroupChattingNativeSDK y = null;
    public boolean z = true;
    public int[] A = null;
    public int[] B = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f18609a = new a(this);

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<ka6> f18610a;

        public a(ka6 ka6Var) {
            this.f18610a = new WeakReference<>(ka6Var);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Log.d(ka6.C, "CameraHandler [" + this + "]: what=" + i);
            ka6 ka6Var = this.f18610a.get();
            if (ka6Var == null) {
                Log.w(ka6.C, "CameraHandler.handleMessage: activity is null");
                return;
            }
            if (i == 0) {
                ka6Var.i((SurfaceTexture) message.obj);
            } else {
                if (i == 1) {
                    return;
                }
                throw new RuntimeException("unknown msg " + i);
            }
        }
    }

    public final void c(Camera.CameraInfo cameraInfo) {
        boolean z;
        Camera camera = this.d;
        if (camera == null) {
            return;
        }
        if (this.e) {
            camera.stopPreview();
            this.e = false;
        }
        int i = this.t;
        int i2 = this.u;
        List<Camera.Size> supportedPreviewSizes = this.d.getParameters().getSupportedPreviewSizes();
        if (supportedPreviewSizes.size() > 1) {
            z = false;
            for (Camera.Size size : supportedPreviewSizes) {
                Log.e(C, "cw = " + size.width + "ch = " + size.height);
                if (i == size.width && i2 == size.height) {
                    z = true;
                }
            }
        } else {
            z = false;
        }
        if (!z) {
            Camera.Size sizeH = h(supportedPreviewSizes, i, i2);
            int i3 = sizeH.width;
            i2 = sizeH.height;
            i = i3;
        }
        this.t = i;
        this.u = i2;
        this.r = (this.s * i2) / i;
        Log.i(C, "prevideoWidth = " + this.t + "  prevideoHeight：" + this.u);
        d(cameraInfo);
        Camera.Parameters parameters = this.d.getParameters();
        parameters.setPreviewSize(i, i2);
        parameters.setPreviewFormat(17);
        if (this.A == null) {
            int[] iArr = new int[2];
            this.A = iArr;
            parameters.getPreviewFpsRange(iArr);
        }
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        int[] iArr2 = new int[2];
        int i4 = 65535;
        for (int i5 = 0; i5 < supportedPreviewFpsRange.size(); i5++) {
            int[] iArr3 = supportedPreviewFpsRange.get(i5);
            Log.e(C, "< " + i5 + " > Min = " + iArr3[0] + "  Max = " + iArr3[1]);
            int i6 = iArr3[0];
            int i7 = this.w;
            int i8 = i6 - (i7 * 1000);
            if (i8 < 0) {
                i8 = -i8;
            }
            int i9 = i6 - (i7 * 1000);
            if (i9 < 0) {
                i9 = -i9;
            }
            int i10 = i8 + i9;
            if (i10 < i4) {
                iArr2[0] = i6;
                iArr2[1] = iArr3[1];
                i4 = i10;
            }
        }
        int i11 = iArr2[1];
        int i12 = i11 / 1000;
        this.w = i12;
        if (i12 > 30) {
            this.w = 30;
        }
        this.B = new int[]{iArr2[0], i11};
        this.n = parameters.isZoomSupported();
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes != null) {
            if (supportedFocusModes.contains("continuous-picture")) {
                parameters.setFocusMode("continuous-picture");
                this.m = true;
            } else if (supportedFocusModes.contains("auto")) {
                parameters.setFocusMode("auto");
                this.m = true;
            }
        }
        List<String> supportedWhiteBalance = parameters.getSupportedWhiteBalance();
        if (supportedWhiteBalance != null && supportedWhiteBalance.contains("auto")) {
            parameters.setWhiteBalance("auto");
        }
        parameters.setAutoExposureLock(false);
        this.d.setParameters(parameters);
        try {
            int maxExposureCompensation = (parameters.getMaxExposureCompensation() - parameters.getMinExposureCompensation()) / 3;
            this.d.setParameters(parameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.d.setDisplayOrientation(this.j);
        this.d.addCallbackBuffer(new byte[((i * i2) * 3) / 2]);
        this.d.setPreviewCallbackWithBuffer(this);
        this.g = true;
        qy4.b().w(this.t, this.u, this.r, this.s, this.h);
    }

    public final void d(Camera.CameraInfo cameraInfo) {
        int i = this.i;
        int i2 = 0;
        if (i != 0) {
            if (i == 1) {
                i2 = 90;
            } else if (i == 2) {
                i2 = EffectConstants.ROTATION_DEGREES_180;
            } else if (i == 3) {
                i2 = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            int i3 = (cameraInfo.orientation + i2) % 360;
            this.j = i3;
            this.j = (360 - i3) % 360;
        } else {
            this.j = ((cameraInfo.orientation - i2) + 360) % 360;
        }
        this.h = cameraInfo.orientation;
    }

    public final void e() {
        Camera camera = this.d;
        if (camera == null) {
            return;
        }
        try {
            if (this.m) {
                camera.cancelAutoFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void f() {
        Camera camera = this.d;
        if (camera != null) {
            if (this.g) {
                camera.setPreviewCallback(null);
                this.g = false;
            }
            this.d.stopPreview();
            this.e = false;
            this.d.release();
            this.d = null;
        }
    }

    public final boolean g() {
        if (this.d != null) {
            f();
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        if (Camera.getNumberOfCameras() == 1) {
            Camera.getCameraInfo(0, cameraInfo);
            this.f = cameraInfo.facing == 1 ? 0 : 1;
        }
        for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
            Camera.getCameraInfo(i, cameraInfo);
            int i2 = cameraInfo.facing;
            try {
                if (i2 == 1 && this.f == 0) {
                    Log.i("TAG", "open an front camera");
                    this.d = Camera.open(i);
                } else if (i2 == 0 && this.f == 1) {
                    Log.i("TAG", "open an back camera");
                    this.d = Camera.open(i);
                }
                break;
            } catch (Exception unused) {
            }
        }
        if (this.d == null) {
            Log.i("TAG", "could not open an camera");
            this.l = false;
            return false;
        }
        try {
            c(cameraInfo);
            this.l = true;
        } catch (Exception e) {
            this.l = false;
            e.printStackTrace();
        }
        return this.l;
    }

    public final Camera.Size h(List<Camera.Size> list, int i, int i2) {
        double d = ((double) i2) / ((double) i);
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        double dAbs = Double.MAX_VALUE;
        double dAbs2 = Double.MAX_VALUE;
        for (Camera.Size size2 : list) {
            if (Math.abs((((double) size2.width) / ((double) size2.height)) - d) <= 0.1d && Math.abs(size2.height - i2) < dAbs2) {
                dAbs2 = Math.abs(size2.height - i2);
                size = size2;
            }
        }
        if (size == null) {
            for (Camera.Size size3 : list) {
                if (Math.abs(size3.height - i2) < dAbs) {
                    dAbs = Math.abs(size3.height - i2);
                    size = size3;
                }
            }
        }
        return size;
    }

    public final void i(SurfaceTexture surfaceTexture) {
        this.c = surfaceTexture;
        l();
    }

    public int j() {
        if (!g()) {
            return -1;
        }
        l();
        return 0;
    }

    public void k(boolean z) {
        this.z = z;
    }

    public final void l() {
        Log.i(C, "CameraView startPreview");
        if (this.c == null && this.d != null && !this.e) {
            Log.w("TAG", "please check SurfaceTexture");
            this.c = new SurfaceTexture(401);
        }
        Camera camera = this.d;
        if (camera == null || this.e) {
            return;
        }
        try {
            camera.setPreviewTexture(this.c);
        } catch (Exception unused) {
        }
        this.d.startPreview();
        this.e = true;
        e();
    }

    public void m() {
        f();
    }

    public final void n() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        if (this.f == 0) {
            for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 0) {
                    Camera camera = this.d;
                    if (camera != null) {
                        camera.stopPreview();
                        this.d.release();
                        this.d = null;
                    }
                    try {
                        this.d = Camera.open(i);
                    } catch (Exception unused) {
                    }
                    if (this.d == null) {
                        Log.e(C, "Open camera fail");
                        return;
                    }
                    this.f = 1;
                    c(cameraInfo);
                    l();
                    return;
                }
            }
            return;
        }
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == 1) {
                Camera camera2 = this.d;
                if (camera2 != null) {
                    camera2.stopPreview();
                    this.d.release();
                    this.d = null;
                }
                try {
                    this.d = Camera.open(i2);
                } catch (Exception unused2) {
                }
                if (this.d == null) {
                    Log.e(C, "Open camera fail");
                    return;
                }
                this.f = 0;
                c(cameraInfo);
                l();
                return;
            }
        }
    }

    public void o() {
        n();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        try {
            if (bArr == null) {
                Camera.Parameters parameters = camera.getParameters();
                Camera.Size previewSize = parameters.getPreviewSize();
                int bitsPerPixel = ((previewSize.width * previewSize.height) * ImageFormat.getBitsPerPixel(parameters.getPreviewFormat())) / 8;
                camera.addCallbackBuffer(new byte[bitsPerPixel + (bitsPerPixel / 20)]);
            } else {
                if (this.z) {
                    qy4.b().r(VideoCallGroupChattingUIActivity.w2().s2(), bArr, camera.getParameters().getPreviewSize().width, camera.getParameters().getPreviewSize().height, this.h, this.f == 0, 0L);
                }
                camera.addCallbackBuffer(bArr);
            }
        } catch (Exception unused) {
        }
        this.k++;
    }
}
