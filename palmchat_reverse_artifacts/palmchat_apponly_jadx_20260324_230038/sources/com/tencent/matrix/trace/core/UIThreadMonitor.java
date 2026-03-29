package com.tencent.matrix.trace.core;

import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import com.tencent.matrix.trace.config.TraceConfig;
import com.tencent.matrix.trace.constants.Constants;
import com.tencent.matrix.trace.core.LooperMonitor;
import com.tencent.matrix.trace.listeners.LooperObserver;
import com.tencent.matrix.trace.util.Utils;
import com.tencent.matrix.util.MatrixLog;
import com.tencent.matrix.util.ReflectUtils;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class UIThreadMonitor implements BeatLifecycle, Runnable {
    private static final String ADD_CALLBACK = "addCallbackLocked";
    public static final int CALLBACK_ANIMATION = 1;
    public static final int CALLBACK_INPUT = 0;
    private static final int CALLBACK_LAST = 2;
    public static final int CALLBACK_TRAVERSAL = 2;
    private static final int DO_QUEUE_BEGIN = 1;
    private static final int DO_QUEUE_DEFAULT = 0;
    private static final int DO_QUEUE_END = 2;
    public static final int DO_QUEUE_END_ERROR = -100;
    private static final int NEWEST_INPUT_EVENT = 4;
    private static final int OLDEST_INPUT_EVENT = 3;
    private static final String TAG = "Matrix.UIThreadMonitor";
    private static final UIThreadMonitor sInstance = new UIThreadMonitor();
    private Method addAnimationQueue;
    private Method addInputQueue;
    private Method addTraversalQueue;
    private Object callbackQueueLock;
    private Object[] callbackQueues;
    private Choreographer choreographer;
    private TraceConfig config;
    private Object vsyncReceiver;
    private volatile boolean isAlive = false;
    private long[] dispatchTimeMs = new long[4];
    private final HashSet<LooperObserver> observers = new HashSet<>();
    private volatile long token = 0;
    private boolean isVsyncFrame = false;
    private long frameIntervalNanos = 16666666;
    private int[] queueStatus = new int[3];
    private boolean[] callbackExist = new boolean[3];
    private long[] queueCost = new long[3];
    private boolean isInit = false;
    private long[] frameInfo = null;

    private synchronized void addFrameCallback(int i, Runnable runnable, boolean z) {
        if (this.callbackExist[i]) {
            MatrixLog.w(TAG, "[addFrameCallback] this type %s callback has exist! isAddHeader:%s", Integer.valueOf(i), Boolean.valueOf(z));
            return;
        }
        if (!this.isAlive && i == 0) {
            MatrixLog.w(TAG, "[addFrameCallback] UIThreadMonitor is not alive!", new Object[0]);
            return;
        }
        try {
            synchronized (this.callbackQueueLock) {
                Method method = i != 0 ? i != 1 ? i != 2 ? null : this.addTraversalQueue : this.addAnimationQueue : this.addInputQueue;
                if (method != null) {
                    Object obj = this.callbackQueues[i];
                    Object[] objArr = new Object[3];
                    objArr[0] = Long.valueOf(!z ? SystemClock.uptimeMillis() : -1L);
                    objArr[1] = runnable;
                    objArr[2] = null;
                    method.invoke(obj, objArr);
                    this.callbackExist[i] = true;
                }
            }
        } catch (Exception e) {
            MatrixLog.e(TAG, e.toString(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchBegin() {
        long[] jArr = this.dispatchTimeMs;
        long jNanoTime = System.nanoTime();
        jArr[0] = jNanoTime;
        this.token = jNanoTime;
        this.dispatchTimeMs[2] = SystemClock.currentThreadTimeMillis();
        AppMethodBeat.i(AppMethodBeat.METHOD_ID_DISPATCH);
        synchronized (this.observers) {
            for (LooperObserver looperObserver : this.observers) {
                if (!looperObserver.isDispatchBegin()) {
                    long[] jArr2 = this.dispatchTimeMs;
                    looperObserver.dispatchBegin(jArr2[0], jArr2[2], this.token);
                }
            }
        }
        if (this.config.isDevEnv()) {
            MatrixLog.d(TAG, "[dispatchBegin#run] inner cost:%sns", Long.valueOf(System.nanoTime() - this.token));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchEnd() throws Throwable {
        long intendedFrameTimeNs;
        HashSet<LooperObserver> hashSet;
        char c;
        long j;
        long jNanoTime = this.config.isDevEnv() ? System.nanoTime() : 0L;
        long j2 = this.token;
        if (this.isVsyncFrame) {
            doFrameEnd(this.token);
            intendedFrameTimeNs = getIntendedFrameTimeNs(j2);
        } else {
            intendedFrameTimeNs = j2;
        }
        long jNanoTime2 = System.nanoTime();
        HashSet<LooperObserver> hashSet2 = this.observers;
        synchronized (hashSet2) {
            try {
                Iterator<LooperObserver> it = this.observers.iterator();
                while (true) {
                    c = 2;
                    if (!it.hasNext()) {
                        break;
                    }
                    LooperObserver next = it.next();
                    if (next.isDispatchBegin()) {
                        String visibleScene = AppMethodBeat.getVisibleScene();
                        boolean z = this.isVsyncFrame;
                        long[] jArr = this.queueCost;
                        j = j2;
                        hashSet = hashSet2;
                        try {
                            next.doFrame(visibleScene, j2, jNanoTime2, z, intendedFrameTimeNs, jArr[0], jArr[1], jArr[2]);
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    } else {
                        j = j2;
                        hashSet = hashSet2;
                    }
                    j2 = j;
                    hashSet2 = hashSet;
                }
                char c2 = 3;
                this.dispatchTimeMs[3] = SystemClock.currentThreadTimeMillis();
                this.dispatchTimeMs[1] = System.nanoTime();
                AppMethodBeat.o(AppMethodBeat.METHOD_ID_DISPATCH);
                synchronized (this.observers) {
                    for (LooperObserver looperObserver : this.observers) {
                        if (looperObserver.isDispatchBegin()) {
                            long[] jArr2 = this.dispatchTimeMs;
                            looperObserver.dispatchEnd(jArr2[0], jArr2[c], jArr2[1], jArr2[c2], this.token, this.isVsyncFrame);
                        }
                        c2 = 3;
                        c = 2;
                    }
                }
                this.isVsyncFrame = false;
                if (this.config.isDevEnv()) {
                    MatrixLog.d(TAG, "[dispatchEnd#run] inner cost:%sns", Long.valueOf(System.nanoTime() - jNanoTime));
                }
            } catch (Throwable th2) {
                th = th2;
                hashSet = hashSet2;
            }
        }
    }

    private void doFrameBegin(long j) {
        this.isVsyncFrame = true;
    }

    private void doFrameEnd(long j) {
        doQueueEnd(2);
        for (int i : this.queueStatus) {
            if (i != 2) {
                this.queueCost[i] = -100;
                if (this.config.isDevEnv) {
                    throw new RuntimeException(String.format("UIThreadMonitor happens type[%s] != DO_QUEUE_END", Integer.valueOf(i)));
                }
            }
        }
        this.queueStatus = new int[3];
        addFrameCallback(0, this, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doQueueBegin(int i) {
        this.queueStatus[i] = 1;
        this.queueCost[i] = System.nanoTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doQueueEnd(int i) {
        this.queueStatus[i] = 2;
        this.queueCost[i] = System.nanoTime() - this.queueCost[i];
        synchronized (this) {
            this.callbackExist[i] = false;
        }
    }

    private long getIntendedFrameTimeNs(long j) {
        try {
            return ((Long) ReflectUtils.reflectObject(this.vsyncReceiver, "mTimestampNanos", Long.valueOf(j))).longValue();
        } catch (Exception e) {
            e.printStackTrace();
            MatrixLog.e(TAG, e.toString(), new Object[0]);
            return j;
        }
    }

    public static UIThreadMonitor getMonitor() {
        return sInstance;
    }

    public void addObserver(LooperObserver looperObserver) {
        if (!this.isAlive) {
            onStart();
        }
        synchronized (this.observers) {
            this.observers.add(looperObserver);
        }
    }

    public long getFrameIntervalNanos() {
        return this.frameIntervalNanos;
    }

    public long getInputEventCost() {
        if (Build.VERSION.SDK_INT < 23) {
            return 0L;
        }
        Object objReflectObject = ReflectUtils.reflectObject(this.choreographer, "mFrameInfo", null);
        if (this.frameInfo == null) {
            long[] jArr = (long[]) ReflectUtils.reflectObject(objReflectObject, "frameInfo", null);
            this.frameInfo = jArr;
            if (jArr == null) {
                this.frameInfo = (long[]) ReflectUtils.reflectObject(objReflectObject, "mFrameInfo", new long[9]);
            }
        }
        long[] jArr2 = this.frameInfo;
        return jArr2[4] - jArr2[3];
    }

    public long getQueueCost(int i, long j) {
        if (j != this.token) {
            return -1L;
        }
        if (this.queueStatus[i] == 2) {
            return this.queueCost[i];
        }
        return 0L;
    }

    public void init(TraceConfig traceConfig) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new AssertionError("must be init in main thread!");
        }
        this.config = traceConfig;
        Choreographer choreographer = Choreographer.getInstance();
        this.choreographer = choreographer;
        this.callbackQueueLock = ReflectUtils.reflectObject(choreographer, "mLock", new Object());
        Object[] objArr = (Object[]) ReflectUtils.reflectObject(this.choreographer, "mCallbackQueues", null);
        this.callbackQueues = objArr;
        if (objArr != null) {
            Object obj = objArr[0];
            Class cls = Long.TYPE;
            this.addInputQueue = ReflectUtils.reflectMethod(obj, ADD_CALLBACK, cls, Object.class, Object.class);
            this.addAnimationQueue = ReflectUtils.reflectMethod(this.callbackQueues[1], ADD_CALLBACK, cls, Object.class, Object.class);
            this.addTraversalQueue = ReflectUtils.reflectMethod(this.callbackQueues[2], ADD_CALLBACK, cls, Object.class, Object.class);
        }
        this.vsyncReceiver = ReflectUtils.reflectObject(this.choreographer, "mDisplayEventReceiver", null);
        this.frameIntervalNanos = ((Long) ReflectUtils.reflectObject(this.choreographer, "mFrameIntervalNanos", Long.valueOf(Constants.DEFAULT_FRAME_DURATION))).longValue();
        LooperMonitor.register(new LooperMonitor.LooperDispatchListener() { // from class: com.tencent.matrix.trace.core.UIThreadMonitor.1
            @Override // com.tencent.matrix.trace.core.LooperMonitor.LooperDispatchListener
            public void dispatchEnd() throws Throwable {
                super.dispatchEnd();
                UIThreadMonitor.this.dispatchEnd();
            }

            @Override // com.tencent.matrix.trace.core.LooperMonitor.LooperDispatchListener
            public void dispatchStart() {
                super.dispatchStart();
                UIThreadMonitor.this.dispatchBegin();
            }

            @Override // com.tencent.matrix.trace.core.LooperMonitor.LooperDispatchListener
            public boolean isValid() {
                return UIThreadMonitor.this.isAlive;
            }
        });
        this.isInit = true;
        Object[] objArr2 = new Object[7];
        objArr2[0] = Boolean.valueOf(this.callbackQueueLock == null);
        objArr2[1] = Boolean.valueOf(this.callbackQueues == null);
        objArr2[2] = Boolean.valueOf(this.addInputQueue == null);
        objArr2[3] = Boolean.valueOf(this.addTraversalQueue == null);
        objArr2[4] = Boolean.valueOf(this.addAnimationQueue == null);
        objArr2[5] = Boolean.valueOf(this.vsyncReceiver == null);
        objArr2[6] = Long.valueOf(this.frameIntervalNanos);
        MatrixLog.i(TAG, "[UIThreadMonitor] %s %s %s %s %s %s frameIntervalNanos:%s", objArr2);
        if (traceConfig.isDevEnv()) {
            addObserver(new LooperObserver() { // from class: com.tencent.matrix.trace.core.UIThreadMonitor.2
                @Override // com.tencent.matrix.trace.listeners.LooperObserver
                public void doFrame(String str, long j, long j2, boolean z, long j3, long j4, long j5, long j6) {
                    MatrixLog.i(UIThreadMonitor.TAG, "focusedActivity[%s] frame cost:%sms isVsyncFrame=%s intendedFrameTimeNs=%s [%s|%s|%s]ns", str, Long.valueOf((j2 - j) / 1000000), Boolean.valueOf(z), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6));
                }
            });
        }
    }

    @Override // com.tencent.matrix.trace.core.BeatLifecycle
    public boolean isAlive() {
        return this.isAlive;
    }

    public boolean isInit() {
        return this.isInit;
    }

    @Override // com.tencent.matrix.trace.core.BeatLifecycle
    public synchronized void onStart() {
        if (!this.isInit) {
            MatrixLog.e(TAG, "[onStart] is never init.", new Object[0]);
            return;
        }
        if (!this.isAlive) {
            this.isAlive = true;
            synchronized (this) {
                MatrixLog.i(TAG, "[onStart] callbackExist:%s %s", Arrays.toString(this.callbackExist), Utils.getStack());
                this.callbackExist = new boolean[3];
                this.queueStatus = new int[3];
                this.queueCost = new long[3];
                addFrameCallback(0, this, true);
            }
        }
    }

    @Override // com.tencent.matrix.trace.core.BeatLifecycle
    public synchronized void onStop() {
        if (!this.isInit) {
            MatrixLog.e(TAG, "[onStart] is never init.", new Object[0]);
            return;
        }
        if (this.isAlive) {
            this.isAlive = false;
            MatrixLog.i(TAG, "[onStop] callbackExist:%s %s", Arrays.toString(this.callbackExist), Utils.getStack());
        }
    }

    public void removeObserver(LooperObserver looperObserver) {
        synchronized (this.observers) {
            this.observers.remove(looperObserver);
            if (this.observers.isEmpty()) {
                onStop();
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        long jNanoTime = System.nanoTime();
        try {
            doFrameBegin(this.token);
            doQueueBegin(0);
            addFrameCallback(1, new Runnable() { // from class: com.tencent.matrix.trace.core.UIThreadMonitor.3
                @Override // java.lang.Runnable
                public void run() {
                    UIThreadMonitor.this.doQueueEnd(0);
                    UIThreadMonitor.this.doQueueBegin(1);
                }
            }, true);
            addFrameCallback(2, new Runnable() { // from class: com.tencent.matrix.trace.core.UIThreadMonitor.4
                @Override // java.lang.Runnable
                public void run() {
                    UIThreadMonitor.this.doQueueEnd(1);
                    UIThreadMonitor.this.doQueueBegin(2);
                }
            }, true);
            if (this.config.isDevEnv()) {
                MatrixLog.d(TAG, "[UIThreadMonitor#run] inner cost:%sns", Long.valueOf(System.nanoTime() - jNanoTime));
            }
        } catch (Throwable th) {
            if (this.config.isDevEnv()) {
                MatrixLog.d(TAG, "[UIThreadMonitor#run] inner cost:%sns", Long.valueOf(System.nanoTime() - jNanoTime));
            }
            throw th;
        }
    }
}
