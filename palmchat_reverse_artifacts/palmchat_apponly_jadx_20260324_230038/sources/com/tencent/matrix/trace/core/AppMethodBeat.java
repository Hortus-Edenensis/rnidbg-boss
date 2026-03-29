package com.tencent.matrix.trace.core;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.media3.common.C;
import com.tencent.matrix.AppActiveMatrixDelegate;
import com.tencent.matrix.trace.core.LooperMonitor;
import com.tencent.matrix.trace.hacker.ActivityThreadHacker;
import com.tencent.matrix.trace.listeners.IAppMethodBeatListener;
import com.tencent.matrix.trace.util.Utils;
import com.tencent.matrix.util.MatrixHandlerThread;
import com.tencent.matrix.util.MatrixLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AppMethodBeat implements BeatLifecycle {
    public static final int METHOD_ID_DISPATCH = 1048574;
    private static final int METHOD_ID_MAX = 1048575;
    private static final int STATUS_DEFAULT = Integer.MAX_VALUE;
    private static final int STATUS_EXPIRED_START = -2;
    private static final int STATUS_OUT_RELEASE = -3;
    private static final int STATUS_READY = 1;
    private static final int STATUS_STARTED = 2;
    private static final int STATUS_STOPPED = -1;
    private static final String TAG = "Matrix.AppMethodBeat";
    public static boolean isDev = false;
    private static IndexRecord sIndexRecordHead;
    public static MethodEnterListener sMethodEnterListener;
    private static Runnable sUpdateDiffTimeRunnable;
    private static AppMethodBeat sInstance = new AppMethodBeat();
    private static volatile int status = Integer.MAX_VALUE;
    private static final Object statusLock = new Object();
    private static long[] sBuffer = new long[1000000];
    private static int sIndex = 0;
    private static int sLastIndex = -1;
    private static boolean assertIn = false;
    private static volatile long sCurrentDiffTime = SystemClock.uptimeMillis();
    private static volatile long sDiffTime = sCurrentDiffTime;
    private static long sMainThreadId = Looper.getMainLooper().getThread().getId();
    private static HandlerThread sTimerUpdateThread = MatrixHandlerThread.getNewHandlerThread("matrix_time_update_thread", 3);
    private static Handler sHandler = new Handler(sTimerUpdateThread.getLooper());
    private static Set<String> sFocusActivitySet = new HashSet();
    private static final HashSet<IAppMethodBeatListener> listeners = new HashSet<>();
    private static final Object updateTimeLock = new Object();
    private static volatile boolean isPauseUpdateTime = false;
    private static Runnable checkStartExpiredRunnable = null;
    private static LooperMonitor.LooperDispatchListener looperMonitorListener = new LooperMonitor.LooperDispatchListener() { // from class: com.tencent.matrix.trace.core.AppMethodBeat.1
        @Override // com.tencent.matrix.trace.core.LooperMonitor.LooperDispatchListener
        public void dispatchEnd() {
            super.dispatchEnd();
            AppMethodBeat.dispatchEnd();
        }

        @Override // com.tencent.matrix.trace.core.LooperMonitor.LooperDispatchListener
        public void dispatchStart() {
            super.dispatchStart();
            AppMethodBeat.dispatchBegin();
        }

        @Override // com.tencent.matrix.trace.core.LooperMonitor.LooperDispatchListener
        public boolean isValid() {
            return AppMethodBeat.status >= 1;
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public interface MethodEnterListener {
        void enter(int i, long j);
    }

    static {
        sHandler.postDelayed(new Runnable() { // from class: com.tencent.matrix.trace.core.AppMethodBeat.2
            @Override // java.lang.Runnable
            public void run() {
                AppMethodBeat.realRelease();
            }
        }, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
        sUpdateDiffTimeRunnable = new Runnable() { // from class: com.tencent.matrix.trace.core.AppMethodBeat.3
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        if (AppMethodBeat.isPauseUpdateTime || AppMethodBeat.status <= -1) {
                            synchronized (AppMethodBeat.updateTimeLock) {
                                AppMethodBeat.updateTimeLock.wait();
                            }
                        } else {
                            long unused = AppMethodBeat.sCurrentDiffTime = SystemClock.uptimeMillis() - AppMethodBeat.sDiffTime;
                            SystemClock.sleep(5L);
                        }
                    } catch (Exception e) {
                        MatrixLog.e(AppMethodBeat.TAG, "" + e.toString(), new Object[0]);
                        return;
                    }
                }
            }
        };
        sIndexRecordHead = null;
    }

    public static void at(Activity activity, boolean z) {
        String name = activity.getClass().getName();
        if (!z) {
            if (sFocusActivitySet.remove(name)) {
                MatrixLog.i(TAG, "[at] visibleScene[%s] has %s focus!", getVisibleScene(), "detach");
            }
        } else if (sFocusActivitySet.add(name)) {
            HashSet<IAppMethodBeatListener> hashSet = listeners;
            synchronized (hashSet) {
                Iterator<IAppMethodBeatListener> it = hashSet.iterator();
                while (it.hasNext()) {
                    it.next().onActivityFocused(activity);
                }
            }
            MatrixLog.i(TAG, "[at] visibleScene[%s] has %s focus!", getVisibleScene(), "attach");
        }
    }

    private static void checkPileup(int i) {
        IndexRecord indexRecord = sIndexRecordHead;
        while (indexRecord != null) {
            int i2 = indexRecord.index;
            if (i2 != i && (i2 != -1 || sLastIndex != 999999)) {
                return;
            }
            indexRecord.isValid = false;
            MatrixLog.w(TAG, "[checkPileup] %s", indexRecord.toString());
            indexRecord = indexRecord.next;
            sIndexRecordHead = indexRecord;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dispatchBegin() {
        sCurrentDiffTime = SystemClock.uptimeMillis() - sDiffTime;
        isPauseUpdateTime = false;
        Object obj = updateTimeLock;
        synchronized (obj) {
            obj.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dispatchEnd() {
        isPauseUpdateTime = true;
    }

    public static long getDiffTime() {
        return sDiffTime;
    }

    public static AppMethodBeat getInstance() {
        return sInstance;
    }

    public static String getVisibleScene() {
        return AppActiveMatrixDelegate.INSTANCE.getVisibleScene();
    }

    public static void i(int i) {
        if (status > -1 && i < METHOD_ID_MAX) {
            if (status == Integer.MAX_VALUE) {
                synchronized (statusLock) {
                    if (status == Integer.MAX_VALUE) {
                        realExecute();
                        status = 1;
                    }
                }
            }
            long id = Thread.currentThread().getId();
            MethodEnterListener methodEnterListener = sMethodEnterListener;
            if (methodEnterListener != null) {
                methodEnterListener.enter(i, id);
            }
            if (id == sMainThreadId) {
                if (assertIn) {
                    Log.e(TAG, "ERROR!!! AppMethodBeat.i Recursive calls!!!");
                    return;
                }
                assertIn = true;
                int i2 = sIndex;
                if (i2 < 1000000) {
                    mergeData(i, i2, true);
                } else {
                    sIndex = 0;
                    mergeData(i, 0, true);
                }
                sIndex++;
                assertIn = false;
            }
        }
    }

    public static boolean isRealTrace() {
        return status >= 1;
    }

    private static void mergeData(int i, int i2, boolean z) {
        if (i == 1048574) {
            sCurrentDiffTime = SystemClock.uptimeMillis() - sDiffTime;
        }
        sBuffer[i2] = (z ? Long.MIN_VALUE : 0L) | (((long) i) << 43) | (sCurrentDiffTime & 8796093022207L);
        checkPileup(i2);
        sLastIndex = i2;
    }

    public static void o(int i) {
        if (status > -1 && i < METHOD_ID_MAX && Thread.currentThread().getId() == sMainThreadId) {
            int i2 = sIndex;
            if (i2 < 1000000) {
                mergeData(i, i2, false);
            } else {
                sIndex = 0;
                mergeData(i, 0, false);
            }
            sIndex++;
        }
    }

    private static void realExecute() {
        MatrixLog.i(TAG, "[realExecute] timestamp:%s", Long.valueOf(System.currentTimeMillis()));
        sCurrentDiffTime = SystemClock.uptimeMillis() - sDiffTime;
        sHandler.removeCallbacksAndMessages(null);
        sHandler.postDelayed(sUpdateDiffTimeRunnable, 5L);
        Handler handler = sHandler;
        Runnable runnable = new Runnable() { // from class: com.tencent.matrix.trace.core.AppMethodBeat.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (AppMethodBeat.statusLock) {
                    MatrixLog.i(AppMethodBeat.TAG, "[startExpired] timestamp:%s status:%s", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(AppMethodBeat.status));
                    if (AppMethodBeat.status == Integer.MAX_VALUE || AppMethodBeat.status == 1) {
                        int unused = AppMethodBeat.status = -2;
                    }
                }
            }
        };
        checkStartExpiredRunnable = runnable;
        handler.postDelayed(runnable, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
        ActivityThreadHacker.hackSysHandlerCallback();
        LooperMonitor.register(looperMonitorListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void realRelease() {
        synchronized (statusLock) {
            if (status == Integer.MAX_VALUE) {
                MatrixLog.i(TAG, "[realRelease] timestamp:%s", Long.valueOf(System.currentTimeMillis()));
                sHandler.removeCallbacksAndMessages(null);
                LooperMonitor.unregister(looperMonitorListener);
                sTimerUpdateThread.quit();
                sBuffer = null;
                status = -3;
            }
        }
    }

    public void addListener(IAppMethodBeatListener iAppMethodBeatListener) {
        HashSet<IAppMethodBeatListener> hashSet = listeners;
        synchronized (hashSet) {
            hashSet.add(iAppMethodBeatListener);
        }
    }

    public long[] copyData(IndexRecord indexRecord) {
        return copyData(indexRecord, new IndexRecord(sIndex - 1));
    }

    public void forceStop() {
        synchronized (statusLock) {
            status = -1;
        }
    }

    @Override // com.tencent.matrix.trace.core.BeatLifecycle
    public boolean isAlive() {
        return status >= 2;
    }

    public IndexRecord maskIndex(String str) {
        if (sIndexRecordHead == null) {
            IndexRecord indexRecord = new IndexRecord(sIndex - 1);
            sIndexRecordHead = indexRecord;
            indexRecord.source = str;
            return indexRecord;
        }
        IndexRecord indexRecord2 = new IndexRecord(sIndex - 1);
        indexRecord2.source = str;
        IndexRecord indexRecord3 = null;
        for (IndexRecord indexRecord4 = sIndexRecordHead; indexRecord4 != null; indexRecord4 = indexRecord4.next) {
            if (indexRecord2.index <= indexRecord4.index) {
                if (indexRecord3 == null) {
                    IndexRecord indexRecord5 = sIndexRecordHead;
                    sIndexRecordHead = indexRecord2;
                    indexRecord2.next = indexRecord5;
                } else {
                    IndexRecord indexRecord6 = indexRecord3.next;
                    indexRecord3.next = indexRecord2;
                    indexRecord2.next = indexRecord6;
                }
                return indexRecord2;
            }
            indexRecord3 = indexRecord4;
        }
        indexRecord3.next = indexRecord2;
        return indexRecord2;
    }

    @Override // com.tencent.matrix.trace.core.BeatLifecycle
    public void onStart() {
        synchronized (statusLock) {
            if (status >= 2 || status < -2) {
                MatrixLog.w(TAG, "[onStart] current status:%s", Integer.valueOf(status));
            } else {
                sHandler.removeCallbacks(checkStartExpiredRunnable);
                if (sBuffer == null) {
                    throw new RuntimeException("Matrix.AppMethodBeat sBuffer == null");
                }
                MatrixLog.i(TAG, "[onStart] preStatus:%s", Integer.valueOf(status), Utils.getStack());
                status = 2;
            }
        }
    }

    @Override // com.tencent.matrix.trace.core.BeatLifecycle
    public void onStop() {
        synchronized (statusLock) {
            if (status == 2) {
                MatrixLog.i(TAG, "[onStop] %s", Utils.getStack());
                status = -1;
            } else {
                MatrixLog.w(TAG, "[onStop] current status:%s", Integer.valueOf(status));
            }
        }
    }

    public void printIndexRecord() {
        StringBuilder sb = new StringBuilder(" \n");
        for (IndexRecord indexRecord = sIndexRecordHead; indexRecord != null; indexRecord = indexRecord.next) {
            sb.append(indexRecord);
            sb.append("\n");
        }
        MatrixLog.i(TAG, "[printIndexRecord] %s", sb.toString());
    }

    public void removeListener(IAppMethodBeatListener iAppMethodBeatListener) {
        HashSet<IAppMethodBeatListener> hashSet = listeners;
        synchronized (hashSet) {
            hashSet.remove(iAppMethodBeatListener);
        }
    }

    private long[] copyData(IndexRecord indexRecord, IndexRecord indexRecord2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long[] jArr = new long[0];
        try {
            try {
                if (!indexRecord.isValid || !indexRecord2.isValid) {
                    MatrixLog.i(TAG, "[copyData] [%s:%s] length:%s cost:%sms", Integer.valueOf(Math.max(0, indexRecord.index)), Integer.valueOf(indexRecord2.index), 0, Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                    return jArr;
                }
                int iMax = Math.max(0, indexRecord.index);
                int iMax2 = Math.max(0, indexRecord2.index);
                if (iMax2 > iMax) {
                    int i = (iMax2 - iMax) + 1;
                    jArr = new long[i];
                    System.arraycopy(sBuffer, iMax, jArr, 0, i);
                } else if (iMax2 < iMax) {
                    int i2 = iMax2 + 1;
                    long[] jArr2 = sBuffer;
                    jArr = new long[(jArr2.length - iMax) + i2];
                    System.arraycopy(jArr2, iMax, jArr, 0, jArr2.length - iMax);
                    long[] jArr3 = sBuffer;
                    System.arraycopy(jArr3, 0, jArr, jArr3.length - iMax, i2);
                }
                MatrixLog.i(TAG, "[copyData] [%s:%s] length:%s cost:%sms", Integer.valueOf(Math.max(0, indexRecord.index)), Integer.valueOf(indexRecord2.index), Integer.valueOf(jArr.length), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                return jArr;
            } catch (OutOfMemoryError e) {
                MatrixLog.e(TAG, e.toString(), new Object[0]);
                MatrixLog.i(TAG, "[copyData] [%s:%s] length:%s cost:%sms", Integer.valueOf(Math.max(0, indexRecord.index)), Integer.valueOf(indexRecord2.index), Integer.valueOf(jArr.length), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                return jArr;
            }
        } catch (Throwable th) {
            MatrixLog.i(TAG, "[copyData] [%s:%s] length:%s cost:%sms", Integer.valueOf(Math.max(0, indexRecord.index)), Integer.valueOf(indexRecord2.index), Integer.valueOf(jArr.length), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            throw th;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class IndexRecord {
        public int index;
        public boolean isValid = false;
        private IndexRecord next;
        public String source;

        public IndexRecord(int i) {
            this.index = i;
        }

        public void release() {
            this.isValid = false;
            IndexRecord indexRecord = null;
            for (IndexRecord indexRecord2 = AppMethodBeat.sIndexRecordHead; indexRecord2 != null; indexRecord2 = indexRecord2.next) {
                if (indexRecord2 == this) {
                    if (indexRecord != null) {
                        indexRecord.next = indexRecord2.next;
                    } else {
                        IndexRecord unused = AppMethodBeat.sIndexRecordHead = indexRecord2.next;
                    }
                    indexRecord2.next = null;
                    return;
                }
                indexRecord = indexRecord2;
            }
        }

        public String toString() {
            return "index:" + this.index + ",\tisValid:" + this.isValid + " source:" + this.source;
        }

        public IndexRecord() {
        }
    }
}
