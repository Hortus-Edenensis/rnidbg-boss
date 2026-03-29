package com.ss.android.ttvecamera;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.camera2.CameraManager;
import android.media.Image;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.Range;
import android.util.Size;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.opos.sv.api.params.ErrorCode;
import com.lantern.auth.app.FunDC;
import com.oplus.tblplayer.processor.util.EffectConstants;
import com.ss.android.ttvecamera.TECameraBase;
import com.ss.android.ttvecamera.TECameraSettings;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TECameraUtils {
    public static final int CAPTURE_HQ_3X = 3264;
    private static final String TAG = "TECameraUtils";
    private static boolean isHighPerformanceCpu = false;
    private static boolean isInAbortCapturesBlockList = false;
    private static String sHardware = null;
    private static int sTakePickMaxSide = 1920;
    private static String[] highPerformanceCpuList = {"SDM632", "SDM636", "SDM638", "SDM660", "SDM670", "SDM710", "SDM720", "MSM8996", "MSM8998", "SDM845", "KIRIN980", "KIRIN970", "KIRIN710", "HI3660", "MT6771", "Exynos 9810", "Exynos 8895"};
    private static String[] abortCapturesBlockList = {"BAC-AL00", "ANE-AL00", "HWI-AL00"};
    private static Class mCameraMNClass = null;
    private static Field mCameraMNField = null;
    private static Method mCameraMNFinalizeMethod = null;
    public static byte mOptionFlags = 0;
    public static final int CAPTURE_NORMAL = 1920;
    public static final int CAPTURE_HQ_2X = 2560;
    static final ArrayList<TEFrameSizei> COMMON_RESOLUTIONS = new ArrayList<>(Arrays.asList(new TEFrameSizei(160, 120), new TEFrameSizei(240, 160), new TEFrameSizei(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, 240), new TEFrameSizei(400, 240), new TEFrameSizei(TECameraSettings.FPS_480, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME), new TEFrameSizei(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, 360), new TEFrameSizei(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, TECameraSettings.FPS_480), new TEFrameSizei(768, TECameraSettings.FPS_480), new TEFrameSizei(854, TECameraSettings.FPS_480), new TEFrameSizei(800, 600), new TEFrameSizei(960, 540), new TEFrameSizei(960, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK), new TEFrameSizei(1024, 576), new TEFrameSizei(1024, 600), new TEFrameSizei(1280, 720), new TEFrameSizei(1280, 1024), new TEFrameSizei(CAPTURE_NORMAL, FunDC.ID_AUTH_1080), new TEFrameSizei(CAPTURE_NORMAL, 1440), new TEFrameSizei(CAPTURE_HQ_2X, 1440), new TEFrameSizei(3840, 2160)));

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class ClosestComparator<T> implements Comparator<T> {
        private ClosestComparator() {
        }

        @Override // java.util.Comparator
        public int compare(T t, T t2) {
            return diff(t) - diff(t2);
        }

        public abstract int diff(T t);
    }

    static {
        int i = 0;
        isInAbortCapturesBlockList = false;
        String cPUHardware = getCPUHardware();
        if (!TextUtils.isEmpty(cPUHardware)) {
            cPUHardware = cPUHardware.toUpperCase();
            String[] strArr = highPerformanceCpuList;
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (cPUHardware.contains(strArr[i2])) {
                    isHighPerformanceCpu = true;
                    break;
                }
                i2++;
            }
        }
        String upperCase = Build.MODEL;
        if (!TextUtils.isEmpty(upperCase)) {
            upperCase = upperCase.toUpperCase();
            String[] strArr2 = abortCapturesBlockList;
            int length2 = strArr2.length;
            while (true) {
                if (i >= length2) {
                    break;
                }
                if (strArr2[i].equals(upperCase)) {
                    isInAbortCapturesBlockList = true;
                    break;
                }
                i++;
            }
        }
        TELogUtils.i(TAG, "cpuHardware: " + cPUHardware + ", isHighPerformanceCpu: " + isHighPerformanceCpu + "model: " + upperCase + ", isInAbortCapturesBlockList: " + isInAbortCapturesBlockList);
    }

    private static TEFrameSizei calcHighCpuPictureSize(@NonNull List<TEFrameSizei> list, TEFrameSizei tEFrameSizei) {
        TEFrameSizei tEFrameSizei2 = null;
        for (TEFrameSizei tEFrameSizei3 : list) {
            int i = tEFrameSizei3.width;
            if (i > tEFrameSizei.width && tEFrameSizei3.height > tEFrameSizei.height && (tEFrameSizei2 == null || i < tEFrameSizei2.width)) {
                tEFrameSizei2 = tEFrameSizei3;
            }
        }
        if (tEFrameSizei2 != null) {
            return tEFrameSizei2;
        }
        return null;
    }

    public static TEFrameSizei calcPreviewSize(@NonNull List<TEFrameSizei> list, TEFrameSizei tEFrameSizei) {
        int i;
        TEFrameSizei tEFrameSizei2 = null;
        if (list == null || list.size() <= 0) {
            return null;
        }
        int i2 = tEFrameSizei.width;
        int i3 = tEFrameSizei.height;
        float f = i2 / i3;
        ArrayList<TEFrameSizei> arrayList = new ArrayList();
        ArrayList<TEFrameSizei> arrayList2 = new ArrayList();
        for (TEFrameSizei tEFrameSizei3 : list) {
            if (Float.compare(f, tEFrameSizei3.width / tEFrameSizei3.height) == 0) {
                arrayList.add(tEFrameSizei3);
            } else {
                arrayList2.add(tEFrameSizei3);
            }
        }
        if (arrayList.isEmpty()) {
            Collections.sort(arrayList2, new Comparator<TEFrameSizei>() { // from class: com.ss.android.ttvecamera.TECameraUtils.9
                @Override // java.util.Comparator
                public int compare(TEFrameSizei tEFrameSizei4, TEFrameSizei tEFrameSizei5) {
                    return (tEFrameSizei5.width * tEFrameSizei5.height) - (tEFrameSizei4.width * tEFrameSizei4.height);
                }
            });
            for (TEFrameSizei tEFrameSizei4 : arrayList2) {
                if (tEFrameSizei2 == null || ((i = tEFrameSizei4.width) >= i2 && tEFrameSizei4.height >= i3)) {
                    tEFrameSizei2 = tEFrameSizei4;
                } else if (i < i2 && tEFrameSizei4.height < i3) {
                    return tEFrameSizei2;
                }
            }
            return tEFrameSizei2;
        }
        Collections.sort(arrayList, new Comparator<TEFrameSizei>() { // from class: com.ss.android.ttvecamera.TECameraUtils.8
            @Override // java.util.Comparator
            public int compare(TEFrameSizei tEFrameSizei5, TEFrameSizei tEFrameSizei6) {
                return (tEFrameSizei6.width * tEFrameSizei6.height) - (tEFrameSizei5.width * tEFrameSizei5.height);
            }
        });
        for (TEFrameSizei tEFrameSizei5 : arrayList) {
            if (tEFrameSizei2 != null) {
                int i4 = tEFrameSizei5.width;
                if (i4 == i2 && tEFrameSizei5.height == i3) {
                    return tEFrameSizei5;
                }
                if (i4 <= i2 || i4 >= tEFrameSizei2.width) {
                    if (i4 < i2) {
                        return tEFrameSizei2;
                    }
                }
            }
            tEFrameSizei2 = tEFrameSizei5;
        }
        return tEFrameSizei2;
    }

    public static TEFrameSizei calcPreviewSizeByRadio(List<TEFrameSizei> list, float f) {
        if (f <= 0.0f || list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (TEFrameSizei tEFrameSizei : list) {
            if (Float.compare(f, tEFrameSizei.width / tEFrameSizei.height) == 0) {
                arrayList.add(tEFrameSizei);
            } else {
                arrayList2.add(tEFrameSizei);
            }
        }
        if (arrayList.isEmpty()) {
            ArrayList<TEFrameSizei> arrayList3 = COMMON_RESOLUTIONS;
            if (arrayList2.contains(arrayList3.get(14))) {
                return arrayList3.get(14);
            }
            if (arrayList.contains(arrayList3.get(16))) {
                return arrayList3.get(16);
            }
            Collections.sort(arrayList2, new Comparator<TEFrameSizei>() { // from class: com.ss.android.ttvecamera.TECameraUtils.11
                @Override // java.util.Comparator
                public int compare(TEFrameSizei tEFrameSizei2, TEFrameSizei tEFrameSizei3) {
                    return (tEFrameSizei3.width * tEFrameSizei3.height) - (tEFrameSizei2.width * tEFrameSizei2.height);
                }
            });
            return (TEFrameSizei) arrayList.get(arrayList.size() / 2);
        }
        ArrayList<TEFrameSizei> arrayList4 = COMMON_RESOLUTIONS;
        if (arrayList.contains(arrayList4.get(14))) {
            return arrayList4.get(14);
        }
        if (arrayList.contains(arrayList4.get(16))) {
            return arrayList4.get(16);
        }
        Collections.sort(arrayList, new Comparator<TEFrameSizei>() { // from class: com.ss.android.ttvecamera.TECameraUtils.10
            @Override // java.util.Comparator
            public int compare(TEFrameSizei tEFrameSizei2, TEFrameSizei tEFrameSizei3) {
                return (tEFrameSizei3.width * tEFrameSizei3.height) - (tEFrameSizei2.width * tEFrameSizei2.height);
            }
        });
        return (TEFrameSizei) arrayList.get(0);
    }

    public static void checkIsOnCameraThread(Handler handler) {
        if (Thread.currentThread() != handler.getLooper().getThread()) {
            throw new IllegalStateException("Wrong thread");
        }
    }

    public static int clamp(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    public static boolean contains(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static List<TEFrameSizei> convertFromCameraSizes(List<Camera.Size> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Camera.Size size : list) {
            arrayList.add(new TEFrameSizei(size.width, size.height));
        }
        return arrayList;
    }

    @RequiresApi(api = 21)
    public static List<TEFrameRateRange> convertRanges(Range<Integer>[] rangeArr) {
        if (rangeArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(rangeArr.length);
        for (Range<Integer> range : rangeArr) {
            arrayList.add(new TEFrameRateRange(((Integer) range.getLower()).intValue(), ((Integer) range.getUpper()).intValue()));
        }
        return arrayList;
    }

    @RequiresApi(api = 21)
    public static List<TEFrameSizei> convertSizes(List<Size> list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Size size : list) {
            arrayList.add(new TEFrameSizei(size.getWidth(), size.getHeight()));
        }
        return arrayList;
    }

    @RequiresApi(api = 21)
    public static Object createCameraInstance(String str, @TECameraSettings.CameraType int i, Context context, TECameraBase.CameraEvents cameraEvents, Handler handler, TECameraBase.PictureSizeCallBack pictureSizeCallBack) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Object objInvoke = null;
        try {
            Method method = Class.forName(str).getMethod("create", Integer.TYPE, Context.class, TECameraBase.CameraEvents.class, Handler.class, TECameraBase.PictureSizeCallBack.class);
            method.setAccessible(true);
            objInvoke = method.invoke(null, Integer.valueOf(i), context, cameraEvents, handler, pictureSizeCallBack);
        } catch (Exception e) {
            Log.w("VESDK-TECameraUtils", "createCameraInstance for " + str + ", exception occurred.", e);
        }
        TELogUtils.i(TAG, "createCameraInstance for " + str + ", cost time = " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms, cameraInstance = " + objInvoke);
        return objInvoke;
    }

    public static boolean finalizeCameraResult(Object obj) {
        try {
            if (mCameraMNClass == null || mCameraMNField == null || mCameraMNFinalizeMethod == null) {
                mCameraMNClass = Class.forName("android.hardware.camera2.impl.CameraMetadataNative");
                mCameraMNField = obj.getClass().getSuperclass().getDeclaredField("mResults");
                Method declaredMethod = mCameraMNClass.getDeclaredMethod("finalize", new Class[0]);
                mCameraMNFinalizeMethod = declaredMethod;
                declaredMethod.setAccessible(true);
                mCameraMNField.setAccessible(true);
            }
            mCameraMNFinalizeMethod.invoke(mCameraMNField.get(obj), new Object[0]);
            return true;
        } catch (ClassNotFoundException unused) {
            TELogUtils.w(TAG, "CameraMetadataNative class not found");
            return false;
        } catch (IllegalAccessException unused2) {
            TELogUtils.w(TAG, "illegal access");
            return false;
        } catch (NoSuchFieldException unused3) {
            TELogUtils.w(TAG, "mResults field not found");
            return false;
        } catch (NoSuchMethodException unused4) {
            TELogUtils.w(TAG, "finalize method not found");
            return false;
        } catch (InvocationTargetException unused5) {
            TELogUtils.w(TAG, "method invoke error");
            return false;
        } catch (Exception unused6) {
            TELogUtils.w(TAG, ErrorCode.ERROR_MSG_UNKNOWN_ERROR);
            return false;
        }
    }

    @RequiresApi(api = 21)
    public static Object generateCamera2Key(String str, String str2, Class<?> cls) {
        try {
            Constructor<?> declaredConstructor = Class.forName(str).getDeclaredConstructor(String.class, Class.class);
            if (declaredConstructor == null) {
                return null;
            }
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(str2, cls);
        } catch (Exception e) {
            Log.w("VESDK-TECameraUtils", "generateCamera2Key for " + str + ", exception occurred.", e);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        r0 = r0[1].trim();
        com.ss.android.ttvecamera.TECameraUtils.sHardware = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003e, code lost:
    
        r1.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getCPUHardware() throws Throwable {
        String strTrim;
        if (!TextUtils.isEmpty(sHardware)) {
            return sHardware;
        }
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/cpuinfo"));
                    while (true) {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                bufferedReader2.close();
                                break;
                            }
                            if (line.startsWith("Hardware")) {
                                String[] strArrSplit = line.split(":");
                                if (strArrSplit.length > 1) {
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            String str = Build.HARDWARE;
                            sHardware = str;
                            return str;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        return strTrim;
    }

    public static int[] getClosestFpsRange(int[] iArr, List<int[]> list) {
        if (list == null || list.size() <= 0) {
            TELogUtils.d(TAG, "supported fpsRange is null,use [7,30]");
            return new int[]{7, 30};
        }
        ArrayList<int[]> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int[] iArr2 : list) {
            if (iArr[0] > 1000) {
                if (iArr2[1] == 30000) {
                    arrayList.add(iArr2);
                } else {
                    arrayList2.add(iArr2);
                }
            } else if (iArr2[1] == 30) {
                arrayList.add(iArr2);
            } else {
                arrayList2.add(iArr2);
            }
        }
        if (arrayList.isEmpty()) {
            closestFpsRangeFromRest = null;
        } else {
            Collections.sort(arrayList, new Comparator<int[]>() { // from class: com.ss.android.ttvecamera.TECameraUtils.1
                @Override // java.util.Comparator
                public int compare(int[] iArr3, int[] iArr4) {
                    return iArr4[0] - iArr3[0];
                }
            });
            for (int[] closestFpsRangeFromRest : arrayList) {
                if (closestFpsRangeFromRest[0] <= iArr[0]) {
                    break;
                }
            }
            closestFpsRangeFromRest = null;
        }
        if (closestFpsRangeFromRest == null) {
            closestFpsRangeFromRest = getClosestFpsRangeFromRest(iArr, list);
        }
        TELogUtils.d(TAG, "calculate fps range = [" + closestFpsRangeFromRest[0] + "," + closestFpsRangeFromRest[1] + "]");
        return closestFpsRangeFromRest;
    }

    public static int[] getClosestFpsRangeFromRest(final int[] iArr, List<int[]> list) {
        return (int[]) Collections.min(list, new Comparator<int[]>() { // from class: com.ss.android.ttvecamera.TECameraUtils.2
            private static final int MAX_FPS_HIGH_DIFF_WEIGHT = 1;
            private static final int MAX_FPS_LOW_DIFF_WEIGHT = 4;
            private static final int MIN_FPS_HIGH_DIFF_WEIGHT = 3;
            private static final int MIN_FPS_LOW_DIFF_WEIGHT = 2;

            private int diff(int[] iArr2) {
                int[] iArr3 = iArr;
                int i = iArr3[0];
                int i2 = iArr2[0];
                int i3 = i > i2 ? (i - i2) * 2 : (i2 - i) * 3;
                int i4 = iArr3[1];
                int i5 = iArr2[1];
                return i3 + (i4 > i5 ? (i4 - i5) * 4 : (i5 - i4) * 1);
            }

            @Override // java.util.Comparator
            public int compare(int[] iArr2, int[] iArr3) {
                return diff(iArr2) - diff(iArr3);
            }
        });
    }

    public static TEFrameSizei getClosestSupportedSize(@NonNull List<TEFrameSizei> list, final TEFrameSizei tEFrameSizei) {
        return (TEFrameSizei) Collections.min(list, new ClosestComparator<TEFrameSizei>() { // from class: com.ss.android.ttvecamera.TECameraUtils.4
            {
                super();
            }

            @Override // com.ss.android.ttvecamera.TECameraUtils.ClosestComparator
            public int diff(TEFrameSizei tEFrameSizei2) {
                return Math.abs(tEFrameSizei.width - tEFrameSizei2.width) + Math.abs(tEFrameSizei.height - tEFrameSizei2.height);
            }
        });
    }

    public static int getDeviceOrientation(Context context) {
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation != 1) {
            return rotation != 2 ? rotation != 3 ? 0 : 270 : EffectConstants.ROTATION_DEGREES_180;
        }
        return 90;
    }

    public static int[] getFixedFpsRange(int[] iArr, List<int[]> list) {
        if (list == null || list.size() <= 0) {
            TELogUtils.d(TAG, "supported fpsRange is null,use [30,30]");
            return new int[]{30, 30};
        }
        ArrayList<int[]> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int[] iArr2 : list) {
            if (iArr2[1] == iArr2[0]) {
                arrayList.add(iArr2);
            } else {
                arrayList2.add(iArr2);
            }
        }
        if (arrayList.isEmpty()) {
            closestFpsRangeFromRest = null;
        } else {
            Collections.sort(arrayList, new Comparator<int[]>() { // from class: com.ss.android.ttvecamera.TECameraUtils.3
                @Override // java.util.Comparator
                public int compare(int[] iArr3, int[] iArr4) {
                    return iArr4[1] - iArr3[1];
                }
            });
            for (int[] closestFpsRangeFromRest : arrayList) {
                int i = closestFpsRangeFromRest[0];
                if ((i >= 15 && i <= 30) || (i >= 15000 && closestFpsRangeFromRest[1] <= 30000)) {
                    if (iArr[1] == closestFpsRangeFromRest[1]) {
                        break;
                    }
                }
            }
            closestFpsRangeFromRest = null;
        }
        if (closestFpsRangeFromRest == null) {
            closestFpsRangeFromRest = getClosestFpsRangeFromRest(iArr, list);
        }
        TELogUtils.d(TAG, "calculate fps range = [" + closestFpsRangeFromRest[0] + "," + closestFpsRangeFromRest[1] + "]");
        return closestFpsRangeFromRest;
    }

    public static int[] getFpsRange(int i, int i2, int[] iArr, List<int[]> list) {
        int[] iArr2;
        TELogUtils.d(TAG, "requiredFpsRange : [" + iArr[0] + "," + iArr[1] + "]");
        if (i == 1) {
            TELogUtils.d(TAG, "fixed framerate for all cameras");
            return getFixedFpsRange(iArr, list);
        }
        if (i == 2) {
            if (i2 == 0) {
                TELogUtils.d(TAG, "fixed framerate for rear camera");
                return getFixedFpsRange(iArr, list);
            }
            TELogUtils.d(TAG, "dynamic framerate for front camera");
            return getClosestFpsRange(iArr, list);
        }
        if (i == 3) {
            TELogUtils.d(TAG, "dynamic framerate without select");
            return getClosestFpsRangeFromRest(iArr, list);
        }
        if (i != 4) {
            TELogUtils.d(TAG, "dynamic framerate");
            return getClosestFpsRange(iArr, list);
        }
        TELogUtils.d(TAG, "framerate by user");
        Iterator<int[]> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                iArr2 = null;
                break;
            }
            int[] next = it.next();
            if (next[0] == iArr[0] && next[1] == iArr[1]) {
                iArr2 = iArr;
                break;
            }
        }
        return iArr2 == null ? getClosestFpsRange(iArr, list) : iArr2;
    }

    public static List<TEFrameSizei> getSameFrameSize(List<TEFrameSizei> list, List<TEFrameSizei> list2) {
        list.retainAll(list2);
        return list;
    }

    public static int getTakePickMaxSide() {
        return sTakePickMaxSide;
    }

    @RequiresApi(api = 19)
    public static boolean imageToNV21(Image image, byte[] bArr) {
        if (image == null) {
            TELogUtils.e(TAG, "image is null");
            return false;
        }
        if (image.getFormat() != 35) {
            TELogUtils.e(TAG, "image format wrong: " + image.getFormat());
            return false;
        }
        if (bArr == null) {
            TELogUtils.e(TAG, "output buffer is null");
            return false;
        }
        int width = image.getWidth();
        int height = image.getHeight();
        if (bArr.length < ((width * height) * 3) / 2) {
            TELogUtils.e(TAG, "output buffer size invalid...");
            return false;
        }
        Image.Plane[] planes = image.getPlanes();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = 1;
            if (i >= planes.length) {
                return true;
            }
            Image.Plane plane = planes[i];
            ByteBuffer buffer = plane.getBuffer();
            if (buffer == null) {
                return false;
            }
            int rowStride = plane.getRowStride();
            if (rowStride <= 0) {
                TELogUtils.e(TAG, "imageToNV21, rowStride: " + width);
                rowStride = width;
            }
            int pixelStride = plane.getPixelStride();
            if (pixelStride <= 0) {
                TELogUtils.e(TAG, "imageToNV21, pixelStride: " + pixelStride);
            } else {
                i3 = pixelStride;
            }
            int i4 = height / i3;
            if (rowStride == width) {
                buffer.get(bArr, i2, buffer.remaining());
                i2 += rowStride * i4;
            } else {
                for (int i5 = 0; i5 < i4 - 1; i5++) {
                    buffer.get(bArr, i2, rowStride);
                    i2 += width;
                }
                buffer.get(bArr, i2, Math.min(width, buffer.remaining()));
                i2 += width;
            }
            i += 2;
        }
    }

    public static boolean isHighPerformanceCpu() {
        return isHighPerformanceCpu;
    }

    public static boolean isInAbortCapturesBlockList() {
        return isInAbortCapturesBlockList;
    }

    public static boolean isSupportCameraV2AutoFocus() {
        String str = Build.MANUFACTURER;
        return str.equalsIgnoreCase("samsung") || str.equalsIgnoreCase("huawei");
    }

    public static boolean isSupportsCamera2(Context context) {
        try {
            int i = Build.VERSION.SDK_INT;
            CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
            if (i < 28 && (i != 27 || Build.VERSION.PREVIEW_SDK_INT <= 0)) {
                Method declaredMethod = cameraManager.getClass().getDeclaredMethod("supportsCamera2ApiLocked", String.class);
                declaredMethod.setAccessible(true);
                return ((Boolean) declaredMethod.invoke(cameraManager, "0")).booleanValue();
            }
            Method method = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class).invoke(cameraManager.getClass(), "supportsCamera2ApiLocked", String.class);
            method.setAccessible(true);
            return ((Boolean) method.invoke(cameraManager, "0")).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public static boolean isValidRect(Rect rect) {
        return rect != null && !rect.isEmpty() && rect.left >= 0 && rect.right >= 0 && rect.top >= 0 && rect.bottom >= 0;
    }

    public static void rotateRectForOrientation(int i, Rect rect, Rect rect2) {
        Matrix matrix = new Matrix();
        matrix.setRotate(-i);
        RectF rectF = new RectF(rect);
        RectF rectF2 = new RectF(rect2);
        matrix.mapRect(rectF);
        matrix.mapRect(rectF2);
        matrix.reset();
        matrix.setTranslate(-rectF.left, -rectF.top);
        matrix.mapRect(rectF);
        matrix.mapRect(rectF2);
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        rect2.set((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom);
    }

    public static void saveJPEGToPath(byte[] bArr, String str) {
        FileOutputStream fileOutputStream;
        if (bArr == null) {
            TELogUtils.e(TAG, "Input null data, failed to save jpeg!");
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            fileOutputStream.write(bArr, 0, bArr.length);
            try {
                fileOutputStream.close();
            } catch (IOException e2) {
                TELogUtils.e(TAG, "close FileOutputStream failed!");
                e2.printStackTrace();
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            TELogUtils.e(TAG, "save jpeg failed！");
            e.printStackTrace();
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                    TELogUtils.e(TAG, "close FileOutputStream failed!");
                    e4.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                    TELogUtils.e(TAG, "close FileOutputStream failed!");
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    @RequiresApi(api = 19)
    public static void saveYUVToPath(Image.Plane[] planeArr, int i, int i2, String str) {
        FileOutputStream fileOutputStream;
        if (planeArr == null) {
            TELogUtils.e(TAG, "Input null plane, failed to save yuv!");
            return;
        }
        if (planeArr[0] == null) {
            TELogUtils.e(TAG, "save yuv failed, plane is null");
            return;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
        byteBufferAllocate.putInt(i).putInt(i2).putInt(planeArr[0].getPixelStride()).putInt(planeArr[0].getRowStride());
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            fileOutputStream.write(byteBufferAllocate.array());
            for (Image.Plane plane : planeArr) {
                ByteBuffer buffer = plane.getBuffer();
                byte[] bArr = new byte[buffer.remaining()];
                buffer.get(bArr);
                fileOutputStream.write(bArr);
                buffer.rewind();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e2) {
                TELogUtils.e(TAG, "close FileOutputStream failed!");
                e2.printStackTrace();
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            TELogUtils.e(TAG, "save yuv failed!");
            e.printStackTrace();
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                    TELogUtils.e(TAG, "close FileOutputStream failed!");
                    e4.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                    TELogUtils.e(TAG, "close FileOutputStream failed!");
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static void setTakePickMaxSide(int i) {
        sTakePickMaxSide = i;
    }

    public static int clamp(int i) {
        return clamp(i, -1000, 1000);
    }

    public static boolean contains(String[] strArr, String str) {
        if (strArr == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    @RequiresApi(api = 21)
    public static Size getClosestSupportedSize(@NonNull List<Size> list, final Size size) {
        return (Size) Collections.min(list, new ClosestComparator<Size>() { // from class: com.ss.android.ttvecamera.TECameraUtils.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.ss.android.ttvecamera.TECameraUtils.ClosestComparator
            public int diff(Size size2) {
                return Math.abs(size.getWidth() - size2.getWidth()) + Math.abs(size.getHeight() - size2.getHeight());
            }
        });
    }

    public static TEFrameSizei getClosestSupportedSize(@NonNull List<TEFrameSizei> list, TEFrameSizei tEFrameSizei, @NonNull TEFrameSizei tEFrameSizei2) {
        if (tEFrameSizei != null && tEFrameSizei.isValid()) {
            if (tEFrameSizei.equals(tEFrameSizei2) && list.contains(tEFrameSizei2)) {
                return tEFrameSizei2;
            }
            Iterator<TEFrameSizei> it = list.iterator();
            while (it.hasNext()) {
                TEFrameSizei next = it.next();
                if (next.width * tEFrameSizei.height != next.height * tEFrameSizei.width) {
                    it.remove();
                }
            }
        }
        Collections.sort(list, new Comparator<TEFrameSizei>() { // from class: com.ss.android.ttvecamera.TECameraUtils.6
            @Override // java.util.Comparator
            public int compare(TEFrameSizei tEFrameSizei3, TEFrameSizei tEFrameSizei4) {
                return (tEFrameSizei4.width * tEFrameSizei4.height) - (tEFrameSizei3.width * tEFrameSizei3.height);
            }
        });
        TEFrameSizei tEFrameSizei3 = null;
        for (TEFrameSizei tEFrameSizei4 : list) {
            if (tEFrameSizei3 != null) {
                if (tEFrameSizei4.width == tEFrameSizei2.width && tEFrameSizei4.height == tEFrameSizei2.height) {
                    return tEFrameSizei4;
                }
                int i = tEFrameSizei4.height;
                int i2 = tEFrameSizei2.height;
                if (i <= i2 || i >= tEFrameSizei3.height) {
                    if (i < i2) {
                        return tEFrameSizei3;
                    }
                }
            }
            tEFrameSizei3 = tEFrameSizei4;
        }
        return tEFrameSizei3;
    }

    @RequiresApi(api = 21)
    public static List<TEFrameSizei> convertSizes(Size[] sizeArr) {
        if (sizeArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(sizeArr.length);
        for (Size size : sizeArr) {
            arrayList.add(new TEFrameSizei(size.getWidth(), size.getHeight()));
        }
        return arrayList;
    }

    public static TEFrameSizei getClosestSupportedSize(@NonNull List<TEFrameSizei> list, TEFrameSizei tEFrameSizei, @NonNull int i, float f) {
        TEFrameSizei next;
        TEFrameSizei tEFrameSizeiCalcHighCpuPictureSize;
        if (tEFrameSizei != null && tEFrameSizei.isValid()) {
            Iterator<TEFrameSizei> it = list.iterator();
            float f2 = (tEFrameSizei.width * 1.0f) / tEFrameSizei.height;
            while (it.hasNext()) {
                TEFrameSizei next2 = it.next();
                if (Math.abs(f2 - ((next2.width * 1.0f) / next2.height)) > f) {
                    it.remove();
                }
            }
        }
        Collections.sort(list, new Comparator<TEFrameSizei>() { // from class: com.ss.android.ttvecamera.TECameraUtils.7
            @Override // java.util.Comparator
            public int compare(TEFrameSizei tEFrameSizei2, TEFrameSizei tEFrameSizei3) {
                return (tEFrameSizei3.width * tEFrameSizei3.height) - (tEFrameSizei2.width * tEFrameSizei2.height);
            }
        });
        Iterator<TEFrameSizei> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (next.width <= i) {
                break;
            }
        }
        if ((mOptionFlags & 8) == 0 ? (next == null || next.width < tEFrameSizei.width || next.height < tEFrameSizei.height) && (tEFrameSizeiCalcHighCpuPictureSize = calcHighCpuPictureSize(list, tEFrameSizei)) != null : (next == null || next.width <= tEFrameSizei.width || next.height <= tEFrameSizei.height) && (tEFrameSizeiCalcHighCpuPictureSize = calcHighCpuPictureSize(list, tEFrameSizei)) != null) {
            next = tEFrameSizeiCalcHighCpuPictureSize;
        }
        if (next == null) {
            TELogUtils.e(TAG, "getClosestSupportedSize failed, maxWidth: " + i + ", accuracy: " + f + ", previewSize: " + tEFrameSizei);
        }
        return next;
    }
}
