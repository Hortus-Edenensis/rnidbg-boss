package com.tencent.matrix.trace.tracer;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.matrix.AppActiveMatrixDelegate;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.report.Issue;
import com.tencent.matrix.trace.TracePlugin;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.tencent.matrix.trace.config.TraceConfig;
import com.tencent.matrix.trace.core.UIThreadMonitor;
import com.tencent.matrix.trace.listeners.IDoFrameListener;
import com.tencent.matrix.trace.util.Utils;
import com.tencent.matrix.util.DeviceUtil;
import com.tencent.matrix.util.MatrixHandlerThread;
import com.tencent.matrix.util.MatrixLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class FrameTracer extends Tracer implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "Matrix.FrameTracer";
    private final TraceConfig config;
    private DropFrameListener dropFrameListener;
    private final long frameIntervalNs;
    private long frozenThreshold;
    private long highThreshold;
    private boolean isFPSEnable;
    private long middleThreshold;
    private long normalThreshold;
    private long timeSliceMs;
    private final HashSet<IDoFrameListener> listeners = new HashSet<>();
    private int dropFrameListenerThreshold = 0;
    private int droppedSum = 0;
    private long durationSum = 0;
    private Map<String, Long> lastResumeTimeMap = new HashMap();

    /* JADX INFO: compiled from: SearchBox */
    public interface DropFrameListener {
        void dropFrame(int i, String str, long j);
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum DropStatus {
        DROPPED_FROZEN(4),
        DROPPED_HIGH(3),
        DROPPED_MIDDLE(2),
        DROPPED_NORMAL(1),
        DROPPED_BEST(0);

        public int index;

        DropStatus(int i) {
            this.index = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class FPSCollector extends IDoFrameListener {
        Executor executor;
        private Handler frameHandler;
        private HashMap<String, FrameCollectItem> map;

        private FPSCollector() {
            this.frameHandler = new Handler(MatrixHandlerThread.getDefaultHandlerThread().getLooper());
            this.executor = new Executor() { // from class: com.tencent.matrix.trace.tracer.FrameTracer.FPSCollector.1
                @Override // java.util.concurrent.Executor
                public void execute(Runnable runnable) {
                    FPSCollector.this.frameHandler.post(runnable);
                }
            };
            this.map = new HashMap<>();
        }

        @Override // com.tencent.matrix.trace.listeners.IDoFrameListener
        public void doReplay(List<IDoFrameListener.FrameReplay> list) {
            super.doReplay(list);
            for (IDoFrameListener.FrameReplay frameReplay : list) {
                doReplayInner(frameReplay.focusedActivity, frameReplay.startNs, frameReplay.endNs, frameReplay.dropFrame, frameReplay.isVsyncFrame, frameReplay.intendedFrameTimeNs, frameReplay.inputCostNs, frameReplay.animationCostNs, frameReplay.traversalCostNs);
            }
        }

        public void doReplayInner(String str, long j, long j2, int i, boolean z, long j3, long j4, long j5, long j6) {
            if (!Utils.isEmpty(str) && z) {
                FrameCollectItem frameCollectItem = this.map.get(str);
                if (frameCollectItem == null) {
                    frameCollectItem = FrameTracer.this.new FrameCollectItem(str);
                    this.map.put(str, frameCollectItem);
                }
                frameCollectItem.collect(i);
                if (frameCollectItem.sumFrameCost >= FrameTracer.this.timeSliceMs) {
                    this.map.remove(str);
                    frameCollectItem.report();
                }
            }
        }

        @Override // com.tencent.matrix.trace.listeners.IDoFrameListener
        public Executor getExecutor() {
            return this.executor;
        }

        @Override // com.tencent.matrix.trace.listeners.IDoFrameListener
        public int getIntervalFrameReplay() {
            return 300;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class FrameCollectItem {
        int sumDroppedFrames;
        long sumFrameCost;
        String visibleScene;
        int sumFrame = 0;
        int[] dropLevel = new int[DropStatus.values().length];
        int[] dropSum = new int[DropStatus.values().length];

        public FrameCollectItem(String str) {
            this.visibleScene = str;
        }

        public void collect(int i) {
            this.sumFrameCost = (long) (this.sumFrameCost + ((i + 1) * ((UIThreadMonitor.getMonitor().getFrameIntervalNanos() * 1.0f) / 1000000.0f)));
            this.sumDroppedFrames += i;
            this.sumFrame++;
            long j = i;
            if (j >= FrameTracer.this.frozenThreshold) {
                int[] iArr = this.dropLevel;
                int i2 = DropStatus.DROPPED_FROZEN.index;
                iArr[i2] = iArr[i2] + 1;
                int[] iArr2 = this.dropSum;
                iArr2[i2] = iArr2[i2] + i;
                return;
            }
            if (j >= FrameTracer.this.highThreshold) {
                int[] iArr3 = this.dropLevel;
                int i3 = DropStatus.DROPPED_HIGH.index;
                iArr3[i3] = iArr3[i3] + 1;
                int[] iArr4 = this.dropSum;
                iArr4[i3] = iArr4[i3] + i;
                return;
            }
            if (j >= FrameTracer.this.middleThreshold) {
                int[] iArr5 = this.dropLevel;
                int i4 = DropStatus.DROPPED_MIDDLE.index;
                iArr5[i4] = iArr5[i4] + 1;
                int[] iArr6 = this.dropSum;
                iArr6[i4] = iArr6[i4] + i;
                return;
            }
            if (j >= FrameTracer.this.normalThreshold) {
                int[] iArr7 = this.dropLevel;
                int i5 = DropStatus.DROPPED_NORMAL.index;
                iArr7[i5] = iArr7[i5] + 1;
                int[] iArr8 = this.dropSum;
                iArr8[i5] = iArr8[i5] + i;
                return;
            }
            int[] iArr9 = this.dropLevel;
            int i6 = DropStatus.DROPPED_BEST.index;
            iArr9[i6] = iArr9[i6] + 1;
            int[] iArr10 = this.dropSum;
            iArr10[i6] = iArr10[i6] + Math.max(i, 0);
        }

        public void report() {
            TracePlugin tracePlugin;
            float fMin = Math.min(60.0f, (this.sumFrame * 1000.0f) / this.sumFrameCost);
            MatrixLog.i(FrameTracer.TAG, "[report] FPS:%s %s", Float.valueOf(fMin), toString());
            try {
                try {
                    tracePlugin = (TracePlugin) Matrix.with().getPluginByClass(TracePlugin.class);
                } catch (JSONException e) {
                    MatrixLog.e(FrameTracer.TAG, "json error", e);
                }
                if (tracePlugin == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                DropStatus dropStatus = DropStatus.DROPPED_FROZEN;
                jSONObject.put(dropStatus.name(), this.dropLevel[dropStatus.index]);
                DropStatus dropStatus2 = DropStatus.DROPPED_HIGH;
                jSONObject.put(dropStatus2.name(), this.dropLevel[dropStatus2.index]);
                DropStatus dropStatus3 = DropStatus.DROPPED_MIDDLE;
                jSONObject.put(dropStatus3.name(), this.dropLevel[dropStatus3.index]);
                DropStatus dropStatus4 = DropStatus.DROPPED_NORMAL;
                jSONObject.put(dropStatus4.name(), this.dropLevel[dropStatus4.index]);
                DropStatus dropStatus5 = DropStatus.DROPPED_BEST;
                jSONObject.put(dropStatus5.name(), this.dropLevel[dropStatus5.index]);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(dropStatus.name(), this.dropSum[dropStatus.index]);
                jSONObject2.put(dropStatus2.name(), this.dropSum[dropStatus2.index]);
                jSONObject2.put(dropStatus3.name(), this.dropSum[dropStatus3.index]);
                jSONObject2.put(dropStatus4.name(), this.dropSum[dropStatus4.index]);
                jSONObject2.put(dropStatus5.name(), this.dropSum[dropStatus5.index]);
                JSONObject deviceInfo = DeviceUtil.getDeviceInfo(new JSONObject(), tracePlugin.getApplication());
                deviceInfo.put("scene", this.visibleScene);
                deviceInfo.put(SharePluginInfo.ISSUE_DROP_LEVEL, jSONObject);
                deviceInfo.put(SharePluginInfo.ISSUE_DROP_SUM, jSONObject2);
                deviceInfo.put(SharePluginInfo.ISSUE_FPS, fMin);
                Issue issue = new Issue();
                issue.setTag(SharePluginInfo.TAG_PLUGIN_FPS);
                issue.setContent(deviceInfo);
                tracePlugin.onDetectIssue(issue);
            } finally {
                this.sumFrame = 0;
                this.sumDroppedFrames = 0;
                this.sumFrameCost = 0L;
            }
        }

        public String toString() {
            return "visibleScene=" + this.visibleScene + ", sumFrame=" + this.sumFrame + ", sumDroppedFrames=" + this.sumDroppedFrames + ", sumFrameCost=" + this.sumFrameCost + ", dropLevel=" + Arrays.toString(this.dropLevel);
        }
    }

    public FrameTracer(TraceConfig traceConfig) {
        this.config = traceConfig;
        long frameIntervalNanos = UIThreadMonitor.getMonitor().getFrameIntervalNanos();
        this.frameIntervalNs = frameIntervalNanos;
        this.timeSliceMs = traceConfig.getTimeSliceMs();
        this.isFPSEnable = traceConfig.isFPSEnable();
        this.frozenThreshold = traceConfig.getFrozenThreshold();
        this.highThreshold = traceConfig.getHighThreshold();
        this.normalThreshold = traceConfig.getNormalThreshold();
        this.middleThreshold = traceConfig.getMiddleThreshold();
        MatrixLog.i(TAG, "[init] frameIntervalMs:%s isFPSEnable:%s", Long.valueOf(frameIntervalNanos), Boolean.valueOf(this.isFPSEnable));
        if (this.isFPSEnable) {
            addListener(new FPSCollector());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011c A[Catch: all -> 0x0146, TRY_LEAVE, TryCatch #3 {all -> 0x0146, blocks: (B:35:0x0114, B:37:0x011c), top: B:75:0x0114 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x013a  */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.tencent.matrix.trace.tracer.FrameTracer] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [com.tencent.matrix.trace.tracer.FrameTracer] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r1v0, types: [long] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16, types: [com.tencent.matrix.trace.tracer.FrameTracer] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.tencent.matrix.trace.tracer.FrameTracer] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.tencent.matrix.trace.tracer.FrameTracer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void notifyListener(final String str, final long j, final long j2, final boolean z, final long j3, final long j4, final long j5, final long j6) throws Throwable {
        int i;
        char c;
        HashSet<IDoFrameListener> hashSet;
        Iterator<IDoFrameListener> it;
        IDoFrameListener iDoFrameListener;
        int i2;
        ?? r15 = this;
        long jCurrentTimeMillis = System.currentTimeMillis();
        ?? r1 = j2 - j3;
        try {
            int i3 = (int) (r1 / r15.frameIntervalNs);
            if (r15.dropFrameListener != null && i3 > r15.dropFrameListenerThreshold) {
                try {
                    if (AppActiveMatrixDelegate.getTopActivityName() != null) {
                        r15.dropFrameListener.dropFrame(i3, AppActiveMatrixDelegate.getTopActivityName(), r15.lastResumeTimeMap.get(AppActiveMatrixDelegate.getTopActivityName()).longValue());
                    }
                } catch (Exception e) {
                    MatrixLog.e(TAG, "dropFrameListener error e:" + e.getMessage(), new Object[0]);
                }
            }
            r15.droppedSum += i3;
            r15.durationSum += Math.max((long) r1, r15.frameIntervalNs);
            HashSet<IDoFrameListener> hashSet2 = r15.listeners;
            try {
                synchronized (hashSet2) {
                    try {
                        Iterator<IDoFrameListener> it2 = r15.listeners.iterator();
                        r15 = r15;
                        while (it2.hasNext()) {
                            final IDoFrameListener next = it2.next();
                            if (r15.config.isDevEnv()) {
                                next.time = SystemClock.uptimeMillis();
                            }
                            try {
                                if (next.getExecutor() != null) {
                                    try {
                                        if (next.getIntervalFrameReplay() > 0) {
                                            next.collect(str, j, j2, i3, z, j3, j4, j5, j6);
                                            it = it2;
                                            iDoFrameListener = next;
                                            i2 = i3;
                                            hashSet = hashSet2;
                                            r1 = r15;
                                            c = 0;
                                            if (!r1.config.isDevEnv()) {
                                                IDoFrameListener iDoFrameListener2 = iDoFrameListener;
                                                long jUptimeMillis = SystemClock.uptimeMillis() - iDoFrameListener2.time;
                                                iDoFrameListener2.time = jUptimeMillis;
                                                Object[] objArr = new Object[2];
                                                objArr[c] = Long.valueOf(jUptimeMillis);
                                                objArr[1] = iDoFrameListener2;
                                                MatrixLog.d(TAG, "[notifyListener] cost:%sms listener:%s", objArr);
                                            }
                                            r15 = r1;
                                            it2 = it;
                                            i3 = i2;
                                            hashSet2 = hashSet;
                                        } else {
                                            it = it2;
                                            final int i4 = i3;
                                            iDoFrameListener = next;
                                            i2 = i3;
                                            hashSet = hashSet2;
                                            c = 0;
                                            try {
                                                next.getExecutor().execute(new Runnable() { // from class: com.tencent.matrix.trace.tracer.FrameTracer.1
                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        next.doFrameAsync(str, j, j2, i4, z, j3, j4, j5, j6);
                                                    }
                                                });
                                            } catch (Throwable th) {
                                                th = th;
                                                i = 2;
                                                r1 = this;
                                                try {
                                                    throw th;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                                                    if (r1.config.isDebug() && jCurrentTimeMillis2 > r1.frameIntervalNs) {
                                                        Object[] objArr2 = new Object[i];
                                                        objArr2[c] = Integer.valueOf(r1.listeners.size());
                                                        objArr2[1] = Long.valueOf(jCurrentTimeMillis2);
                                                        MatrixLog.w(TAG, "[notifyListener] warm! maybe do heavy work in doFrameSync! size:%s cost:%sms", objArr2);
                                                    }
                                                    throw th;
                                                }
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        hashSet = hashSet2;
                                        c = 0;
                                    }
                                } else {
                                    it = it2;
                                    iDoFrameListener = next;
                                    i2 = i3;
                                    hashSet = hashSet2;
                                    c = 0;
                                    iDoFrameListener.doFrameSync(str, j, j2, i2, z, j3, j4, j5, j6);
                                }
                                if (!r1.config.isDevEnv()) {
                                }
                                r15 = r1;
                                it2 = it;
                                i3 = i2;
                                hashSet2 = hashSet;
                            } catch (Throwable th4) {
                                th = th4;
                                i = 2;
                                throw th;
                            }
                            r1 = this;
                        }
                        ?? r12 = r15;
                        long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                        if (!r12.config.isDebug() || jCurrentTimeMillis3 <= r12.frameIntervalNs) {
                            return;
                        }
                        MatrixLog.w(TAG, "[notifyListener] warm! maybe do heavy work in doFrameSync! size:%s cost:%sms", Integer.valueOf(r12.listeners.size()), Long.valueOf(jCurrentTimeMillis3));
                    } catch (Throwable th5) {
                        th = th5;
                        hashSet = hashSet2;
                        r1 = r15;
                        i = 2;
                        c = 0;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
            r1 = r15;
            i = 2;
            c = 0;
        }
    }

    public void addDropFrameListener(int i, DropFrameListener dropFrameListener) {
        this.dropFrameListener = dropFrameListener;
        this.dropFrameListenerThreshold = i;
    }

    public void addListener(IDoFrameListener iDoFrameListener) {
        synchronized (this.listeners) {
            this.listeners.add(iDoFrameListener);
        }
    }

    @Override // com.tencent.matrix.trace.listeners.LooperObserver
    public void doFrame(String str, long j, long j2, boolean z, long j3, long j4, long j5, long j6) throws Throwable {
        if (isForeground()) {
            notifyListener(str, j, j2, z, j3, j4, j5, j6);
        }
    }

    public int getDroppedSum() {
        return this.droppedSum;
    }

    public long getDurationSum() {
        return this.durationSum;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.lastResumeTimeMap.put(activity.getClass().getName(), Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.tencent.matrix.trace.tracer.Tracer
    public void onAlive() {
        super.onAlive();
        if (this.isFPSEnable) {
            UIThreadMonitor.getMonitor().addObserver(this);
            Matrix.with().getApplication().registerActivityLifecycleCallbacks(this);
        }
    }

    @Override // com.tencent.matrix.trace.tracer.Tracer
    public void onDead() {
        super.onDead();
        removeDropFrameListener();
        if (this.isFPSEnable) {
            UIThreadMonitor.getMonitor().removeObserver(this);
            Matrix.with().getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    public void removeDropFrameListener() {
        this.dropFrameListener = null;
    }

    public void removeListener(IDoFrameListener iDoFrameListener) {
        synchronized (this.listeners) {
            this.listeners.remove(iDoFrameListener);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
