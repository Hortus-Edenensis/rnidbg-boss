package com.ss.android.ttvecamera;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.DngCreator;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.util.Rational;
import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.TimeZone;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TECameraFrame {
    public static final int FRAME_TYPE_BUFFER = 2;
    public static final int FRAME_TYPE_DEFAULT = 0;
    public static final int FRAME_TYPE_RAW = 4;
    public static final int FRAME_TYPE_TEXTURE = 1;
    public static final int FRAME_TYPE_YUV_PLANS = 3;
    public static final String TAG = "TECameraFrame";
    private CameraFrameBase mCameraFrameBase;
    private int mHeight;
    private Metadata mMetadata;
    private int mWidth;
    public long mfTimestampNS;

    /* JADX INFO: renamed from: com.ss.android.ttvecamera.TECameraFrame$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat;

        static {
            int[] iArr = new int[ETEPixelFormat.values().length];
            $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat = iArr;
            try {
                iArr[ETEPixelFormat.PIXEL_FORMAT_YUV420.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_YUV420P.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_NV21.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_YUV422P.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_YUYV422.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_UYVY422.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_RGB8.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_RGBA8.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_JPEG.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_GRAY8.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_BGR8.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_NV12.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_OpenGL_GRAY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_OpenGL_RGB8.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_OpenGL_RGBA8.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_OpenGL_OES.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[ETEPixelFormat.PIXEL_FORMAT_Count.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class BufferFrame extends CameraFrameBase {
        private byte[] mBufferData;
        private int mSize;

        public BufferFrame(int i, int i2, long j, byte[] bArr, int i3, ETEPixelFormat eTEPixelFormat, int i4) {
            super(i, i2, j, i4);
            this.mType = 2;
            this.mRotationRad = i3;
            this.mPixelFormat = eTEPixelFormat;
            this.mBufferData = bArr;
            this.mSize = i * i2 * 4;
        }

        public byte[] getBufferData() {
            return this.mBufferData;
        }

        public int getBufferSize() {
            return this.mSize;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum ETEPixelFormat {
        PIXEL_FORMAT_YUV420,
        PIXEL_FORMAT_YUV420P,
        PIXEL_FORMAT_NV12,
        PIXEL_FORMAT_NV21,
        PIXEL_FORMAT_YUYV422,
        PIXEL_FORMAT_YUV422P,
        PIXEL_FORMAT_UYVY422,
        PIXEL_FORMAT_GRAY8,
        PIXEL_FORMAT_RGB8,
        PIXEL_FORMAT_BGR8,
        PIXEL_FORMAT_ARGB8,
        PIXEL_FORMAT_RGBA8,
        PIXEL_FORMAT_BGRA8,
        PIXEL_FORMAT_OpenGL_GRAY,
        PIXEL_FORMAT_OpenGL_RGB8,
        PIXEL_FORMAT_OpenGL_RGBA8,
        PIXEL_FORMAT_OpenGL_OES,
        PIXEL_FORMAT_JPEG,
        PIXEL_FORMAT_BUFFER,
        PIXEL_FORMAT_Count,
        PIXEL_FORMAT_Recorder,
        PIXEL_FORMAT_RAW_SENSOR
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Metadata {
        public int width = -1;
        public int height = -1;
        public long timestamp = -1;
        public TotalCaptureResult captureResult = null;
        public int maxIso = 0;
        public int minIso = 0;

        public HashMap<String, String> flatten() {
            HashMap<String, String> map = new HashMap<>();
            if (this.timestamp != -1) {
                TimeZone timeZone = TimeZone.getDefault();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd kk:mm:ss");
                simpleDateFormat.setTimeZone(timeZone);
                String str = simpleDateFormat.format(Long.valueOf(this.timestamp));
                if (str != null) {
                    map.put(ExifInterface.TAG_DATETIME, str);
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 23) {
                        map.put(ExifInterface.TAG_DATETIME_DIGITIZED, str);
                    }
                    if (i >= 24) {
                        map.put(ExifInterface.TAG_DATETIME_ORIGINAL, str);
                    }
                }
            }
            int i2 = this.width;
            if (i2 != -1) {
                map.put(ExifInterface.TAG_IMAGE_WIDTH, String.valueOf(i2));
                if (Build.VERSION.SDK_INT >= 24) {
                    map.put(ExifInterface.TAG_PIXEL_X_DIMENSION, String.valueOf(this.width));
                }
            }
            int i3 = this.height;
            if (i3 != -1) {
                map.put(ExifInterface.TAG_IMAGE_LENGTH, String.valueOf(i3));
                if (Build.VERSION.SDK_INT >= 24) {
                    map.put(ExifInterface.TAG_PIXEL_Y_DIMENSION, String.valueOf(this.height));
                }
            }
            String str2 = Build.MANUFACTURER;
            if (str2 != null) {
                map.put(ExifInterface.TAG_MAKE, str2);
            }
            String str3 = Build.MODEL;
            if (str3 != null) {
                map.put(ExifInterface.TAG_MODEL, str3);
            }
            TotalCaptureResult totalCaptureResult = this.captureResult;
            if (totalCaptureResult != null) {
                int i4 = Build.VERSION.SDK_INT;
                Long l = (Long) totalCaptureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
                if (l != null) {
                    map.put(ExifInterface.TAG_EXPOSURE_TIME, String.valueOf(new Rational((int) (l.longValue() / 1000000), 1000).floatValue()));
                }
                Integer num = (Integer) this.captureResult.get(CaptureResult.CONTROL_AWB_MODE);
                if (num != null) {
                    if (num.intValue() == 1) {
                        map.put(ExifInterface.TAG_WHITE_BALANCE, String.valueOf(0));
                    } else {
                        map.put(ExifInterface.TAG_WHITE_BALANCE, String.valueOf(1));
                    }
                }
                if (i4 >= 24) {
                    Float f = (Float) this.captureResult.get(CaptureResult.LENS_FOCAL_LENGTH);
                    if (f != null) {
                        map.put(ExifInterface.TAG_FOCAL_LENGTH, new Rational((int) (f.floatValue() * 1000.0f), 1000).toString());
                    }
                    Integer num2 = (Integer) this.captureResult.get(CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST);
                    Integer num3 = (Integer) this.captureResult.get(CaptureResult.SENSOR_SENSITIVITY);
                    if (num3 != null && num2 != null) {
                        map.put(ExifInterface.TAG_ISO_SPEED_RATINGS, String.valueOf((num3.intValue() * num2.intValue()) / 100));
                    }
                    Float f2 = (Float) this.captureResult.get(CaptureResult.LENS_APERTURE);
                    if (f2 != null) {
                        map.put(ExifInterface.TAG_F_NUMBER, String.valueOf(f2));
                    }
                }
            }
            return map;
        }

        public HashMap<String, Integer> flattenForTitan() {
            HashMap<String, Integer> map = new HashMap<>();
            TotalCaptureResult totalCaptureResult = this.captureResult;
            if (totalCaptureResult != null) {
                int i = Build.VERSION.SDK_INT;
                Long l = (Long) totalCaptureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
                if (l != null) {
                    map.put("exposuretime", Integer.valueOf(new Rational((int) (l.longValue() / 1000000), 1000).intValue()));
                }
                if (i >= 24) {
                    Integer num = (Integer) this.captureResult.get(CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST);
                    Integer num2 = (Integer) this.captureResult.get(CaptureResult.SENSOR_SENSITIVITY);
                    if (num2 != null && num != null) {
                        map.put("iso", Integer.valueOf((num2.intValue() * num.intValue()) / 100));
                    }
                    int i2 = this.maxIso;
                    if (i2 != -1) {
                        map.put("maxiso", Integer.valueOf(i2));
                    }
                    int i3 = this.minIso;
                    if (i3 != -1) {
                        map.put("minIso", Integer.valueOf(i3));
                    }
                }
            }
            return map;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class RawFrame extends CameraFrameBase {
        DngCreator mDngCreator;
        TEPlane mPlane;

        public RawFrame(int i, int i2, long j, TEPlane tEPlane, int i3, ETEPixelFormat eTEPixelFormat, int i4, DngCreator dngCreator) {
            super(i, i2, j, i4);
            this.mType = 4;
            this.mRotationRad = i3;
            this.mPixelFormat = eTEPixelFormat;
            this.mPlane = tEPlane;
            this.mDngCreator = dngCreator;
        }

        public DngCreator getDngCreator() {
            return this.mDngCreator;
        }

        public TEPlane getPlane() {
            return this.mPlane;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class TextureFrame extends CameraFrameBase {
        float[] mMVPMatrix;
        private int mTextureID;

        public TextureFrame(int i, int i2, long j, int i3, int i4, float[] fArr, ETEPixelFormat eTEPixelFormat, int i5) {
            super(i, i2, j, i5);
            this.mType = 1;
            this.mTextureID = i3;
            this.mRotationRad = i4;
            this.mMVPMatrix = fArr;
            this.mPixelFormat = eTEPixelFormat;
        }

        public float[] getMVPMatrix() {
            return this.mMVPMatrix;
        }

        public int getTextureID() {
            return this.mTextureID;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class YUVBytesFrame extends CameraFrameBase {
        byte[] mBytes;

        public YUVBytesFrame(int i, int i2, long j, byte[] bArr, int i3, ETEPixelFormat eTEPixelFormat, int i4) {
            super(i, i2, j, i4);
            this.mType = 3;
            this.mRotationRad = i3;
            this.mPixelFormat = eTEPixelFormat;
            this.mBytes = bArr;
        }

        public byte[] getBytes() {
            return this.mBytes;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class YUVPlansFrame extends CameraFrameBase {
        TEPlane mPlane;

        public YUVPlansFrame(int i, int i2, long j, TEPlane tEPlane, int i3, ETEPixelFormat eTEPixelFormat, int i4) {
            super(i, i2, j, i4);
            this.mType = 3;
            this.mRotationRad = i3;
            this.mPixelFormat = eTEPixelFormat;
            this.mPlane = tEPlane;
        }

        public TEPlane getPlane() {
            return this.mPlane;
        }
    }

    public TECameraFrame(int i, int i2, long j) {
        this.mCameraFrameBase = new CameraFrameBase(0, 0, 0L);
        this.mWidth = i;
        this.mHeight = i2;
        this.mfTimestampNS = j;
    }

    public static ETEPixelFormat imageFormat2PixelFormat(int i, int i2) {
        return i2 == 2 ? ETEPixelFormat.PIXEL_FORMAT_OpenGL_OES : i2 == 1 ? i == 41 ? ETEPixelFormat.PIXEL_FORMAT_OpenGL_RGB8 : i == 42 ? ETEPixelFormat.PIXEL_FORMAT_OpenGL_RGBA8 : ETEPixelFormat.PIXEL_FORMAT_Count : i2 == 0 ? i != 17 ? i != 35 ? i != 39 ? i != 256 ? i != 41 ? i != 42 ? ETEPixelFormat.PIXEL_FORMAT_Count : ETEPixelFormat.PIXEL_FORMAT_RGBA8 : ETEPixelFormat.PIXEL_FORMAT_RGB8 : ETEPixelFormat.PIXEL_FORMAT_JPEG : ETEPixelFormat.PIXEL_FORMAT_YUV422P : ETEPixelFormat.PIXEL_FORMAT_YUV420P : ETEPixelFormat.PIXEL_FORMAT_NV21 : ETEPixelFormat.PIXEL_FORMAT_Count;
    }

    public static int pixelFormat2ImageFormat(ETEPixelFormat eTEPixelFormat) {
        switch (AnonymousClass1.$SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[eTEPixelFormat.ordinal()]) {
            case 1:
                return 35;
            case 2:
                return 842094169;
            case 3:
                return 17;
            case 4:
                return 16;
            case 5:
            case 6:
                return 39;
            case 7:
                return 41;
            case 8:
                return 42;
            case 9:
                return 256;
            default:
                return 0;
        }
    }

    public void dumpImageToPath(String str) {
        if (this.mCameraFrameBase == null) {
            TELogUtils.e(TAG, "frame is null, dump failed!");
            return;
        }
        String str2 = str + "_TECameraFrame" + ("_" + getSize().width + "x" + getSize().height) + ("_" + System.currentTimeMillis());
        int i = AnonymousClass1.$SwitchMap$com$ss$android$ttvecamera$TECameraFrame$ETEPixelFormat[getPixelFormat().ordinal()];
        if (i == 1) {
            String str3 = str2 + "_YUV420.yuv";
            TELogUtils.i(TAG, "Start to dump TECameraFrame to " + str3);
            if (getPlans() != null) {
                TECameraUtils.saveYUVToPath(getPlans().getPlanes(), getSize().width, getSize().height, str3);
                return;
            } else {
                TELogUtils.e(TAG, "plane is null, dump failed!");
                return;
            }
        }
        if (i != 9) {
            TELogUtils.e(TAG, "unexpected dump image format: " + getPixelFormat());
            return;
        }
        String str4 = str2 + "_JPEG.jpeg";
        TELogUtils.i(TAG, "Start to dump TECameraFrame to " + str4);
        TECameraUtils.saveJPEGToPath(getJpegData(), str4);
    }

    public byte[] getBufferData() {
        CameraFrameBase cameraFrameBase = this.mCameraFrameBase;
        if (cameraFrameBase instanceof BufferFrame) {
            return ((BufferFrame) cameraFrameBase).getBufferData();
        }
        return null;
    }

    public int getBufferSize() {
        CameraFrameBase cameraFrameBase = this.mCameraFrameBase;
        if (cameraFrameBase instanceof BufferFrame) {
            return ((BufferFrame) cameraFrameBase).getBufferSize();
        }
        return 0;
    }

    public int getFacing() {
        return this.mCameraFrameBase.mFacing;
    }

    public byte[] getJpegData() {
        if (getPixelFormat() != ETEPixelFormat.PIXEL_FORMAT_JPEG) {
            TELogUtils.e(TAG, "Current format is " + getPixelFormat() + ", could not get jpeg data!");
            return null;
        }
        CameraFrameBase cameraFrameBase = this.mCameraFrameBase;
        if (cameraFrameBase instanceof BufferFrame) {
            return ((BufferFrame) cameraFrameBase).getBufferData();
        }
        if (!(cameraFrameBase instanceof YUVPlansFrame)) {
            TELogUtils.e(TAG, "Unexpected frame instance! Failed to get jpeg data.");
            return null;
        }
        ByteBuffer planeBuffer = ((YUVPlansFrame) cameraFrameBase).getPlane().getPlaneBuffer(0);
        planeBuffer.rewind();
        byte[] bArr = new byte[planeBuffer.remaining()];
        planeBuffer.get(bArr);
        return bArr;
    }

    public float[] getMVPMatrix() {
        CameraFrameBase cameraFrameBase = this.mCameraFrameBase;
        if (cameraFrameBase instanceof TextureFrame) {
            return ((TextureFrame) cameraFrameBase).getMVPMatrix();
        }
        return null;
    }

    public Metadata getMetadata() {
        return this.mMetadata;
    }

    public ETEPixelFormat getPixelFormat() {
        return this.mCameraFrameBase.mPixelFormat;
    }

    public TEPlane getPlans() {
        CameraFrameBase cameraFrameBase = this.mCameraFrameBase;
        if (cameraFrameBase instanceof YUVPlansFrame) {
            return ((YUVPlansFrame) cameraFrameBase).getPlane();
        }
        return null;
    }

    public int getRotation() {
        return this.mCameraFrameBase.mRotationRad;
    }

    public TEFrameSizei getSize() {
        return this.mCameraFrameBase.mFrameSizei;
    }

    public int getTextureID() {
        CameraFrameBase cameraFrameBase = this.mCameraFrameBase;
        if (cameraFrameBase instanceof TextureFrame) {
            return ((TextureFrame) cameraFrameBase).getTextureID();
        }
        return 0;
    }

    public long getTimeStampNS() {
        return this.mfTimestampNS;
    }

    public int getType() {
        return this.mCameraFrameBase.mType;
    }

    public void initBufferFrame(byte[] bArr, int i, ETEPixelFormat eTEPixelFormat, int i2) {
        this.mCameraFrameBase = new BufferFrame(this.mWidth, this.mHeight, this.mfTimestampNS, bArr, i, eTEPixelFormat, i2);
    }

    public void initRawPlans(TEPlane tEPlane, int i, ETEPixelFormat eTEPixelFormat, int i2, DngCreator dngCreator) {
        this.mCameraFrameBase = new RawFrame(this.mWidth, this.mHeight, this.mfTimestampNS, tEPlane, i, eTEPixelFormat, i2, dngCreator);
    }

    public void initTextureFrame(int i, int i2, float[] fArr, ETEPixelFormat eTEPixelFormat, int i3) {
        this.mCameraFrameBase = new TextureFrame(this.mWidth, this.mHeight, this.mfTimestampNS, i, i2, fArr, eTEPixelFormat, i3);
    }

    public void initYUVBytesPlans(byte[] bArr, int i, ETEPixelFormat eTEPixelFormat, int i2) {
        this.mCameraFrameBase = new YUVBytesFrame(this.mWidth, this.mHeight, this.mfTimestampNS, bArr, i, eTEPixelFormat, i2);
    }

    public void initYUVPlans(TEPlane tEPlane, int i, ETEPixelFormat eTEPixelFormat, int i2) {
        this.mCameraFrameBase = new YUVPlansFrame(this.mWidth, this.mHeight, this.mfTimestampNS, tEPlane, i, eTEPixelFormat, i2);
    }

    public void setMetadata(Metadata metadata) {
        this.mMetadata = metadata;
    }

    public void setTextureID(int i) {
        CameraFrameBase cameraFrameBase = this.mCameraFrameBase;
        if (cameraFrameBase instanceof TextureFrame) {
            ((TextureFrame) cameraFrameBase).mTextureID = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class CameraFrameBase {
        public int mFacing;
        public TEFrameSizei mFrameSizei;
        public ETEPixelFormat mPixelFormat;
        public int mRotationRad;
        public int mType;
        public long mfTimestampNs;

        public CameraFrameBase(int i, int i2, long j, int i3) {
            this.mType = 0;
            this.mFrameSizei = new TEFrameSizei(i, i2);
            this.mfTimestampNs = j;
            this.mFacing = i3;
        }

        public CameraFrameBase(int i, int i2, long j) {
            this(i, i2, j, 0);
        }
    }

    public TECameraFrame(byte[] bArr, ETEPixelFormat eTEPixelFormat, int i, int i2, int i3) {
        this(i, i2, 0L);
        initBufferFrame(bArr, i3, eTEPixelFormat, 0);
    }

    public TECameraFrame(TEPlane tEPlane, ETEPixelFormat eTEPixelFormat, int i, int i2, int i3) {
        this(i, i2, 0L);
        initYUVPlans(tEPlane, i3, eTEPixelFormat, 0);
    }

    public TECameraFrame(TEPlane tEPlane, ETEPixelFormat eTEPixelFormat, int i, int i2, int i3, DngCreator dngCreator) {
        this(i, i2, 0L);
        initRawPlans(tEPlane, i3, eTEPixelFormat, 0, dngCreator);
    }
}
