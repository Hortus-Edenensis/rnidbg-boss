package com.tencent.matrix.trace.tracer;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.report.Issue;
import com.tencent.matrix.trace.TracePlugin;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.tencent.matrix.trace.config.TraceConfig;
import com.tencent.matrix.trace.constants.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.core.UIThreadMonitor;
import com.tencent.matrix.trace.items.MethodItem;
import com.tencent.matrix.trace.util.TraceDataUtils;
import com.tencent.matrix.trace.util.Utils;
import com.tencent.matrix.util.DeviceUtil;
import com.tencent.matrix.util.MatrixHandlerThread;
import com.tencent.matrix.util.MatrixLog;
import java.lang.Thread;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LooperAnrTracer extends Tracer {
    private static final String TAG = "Matrix.AnrTracer";
    private Handler anrHandler;
    private boolean isAnrTraceEnable;
    private Handler lagHandler;
    private final TraceConfig traceConfig;
    private volatile AnrHandleTask anrTask = new AnrHandleTask();
    private volatile LagHandleTask lagTask = new LagHandleTask();

    /* JADX INFO: compiled from: SearchBox */
    public class AnrHandleTask implements Runnable {
        AppMethodBeat.IndexRecord beginRecord;
        long token;

        public AnrHandleTask() {
        }

        private String printAnr(String str, int[] iArr, long[] jArr, Thread.State state, StringBuilder sb, boolean z, long j, String str2, String str3, long j2, long j3, long j4, long j5) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(String.format("-\n>>>>>>>>>>>>>>>>>>>>>>> maybe happens ANR(%s ms)! <<<<<<<<<<<<<<<<<<<<<<<\n", Long.valueOf(j5)));
            sb2.append("|* [Status]");
            sb2.append("\n");
            sb2.append("|*\t\tScene: ");
            sb2.append(str);
            sb2.append("\n");
            sb2.append("|*\t\tForeground: ");
            sb2.append(z);
            sb2.append("\n");
            sb2.append("|*\t\tPriority: ");
            sb2.append(iArr[0]);
            sb2.append("\tNice: ");
            sb2.append(iArr[1]);
            sb2.append("\n");
            sb2.append("|*\t\tis64BitRuntime: ");
            sb2.append(DeviceUtil.is64BitRuntime());
            sb2.append("\n");
            sb2.append("|* [Memory]");
            sb2.append("\n");
            sb2.append("|*\t\tDalvikHeap: ");
            sb2.append(jArr[0]);
            sb2.append("kb\n");
            sb2.append("|*\t\tNativeHeap: ");
            sb2.append(jArr[1]);
            sb2.append("kb\n");
            sb2.append("|*\t\tVmSize: ");
            sb2.append(jArr[2]);
            sb2.append("kb\n");
            sb2.append("|* [doFrame]");
            sb2.append("\n");
            sb2.append("|*\t\tinputCost:animationCost:traversalCost");
            sb2.append("\n");
            sb2.append("|*\t\t");
            sb2.append(j2);
            sb2.append(":");
            sb2.append(j3);
            sb2.append(":");
            sb2.append(j4);
            sb2.append("\n");
            sb2.append("|* [Thread]");
            sb2.append("\n");
            sb2.append(String.format("|*\t\tStack(%s): ", state));
            sb2.append(str3);
            sb2.append("|* [Trace]");
            sb2.append("\n");
            if (j > 0) {
                sb2.append("|*\t\tStackKey: ");
                sb2.append(str2);
                sb2.append("\n");
                sb2.append(sb.toString());
            } else {
                sb2.append(String.format("AppMethodBeat is close[%s].", Boolean.valueOf(AppMethodBeat.getInstance().isAlive())));
                sb2.append("\n");
            }
            sb2.append("=========================================================================");
            return sb2.toString();
        }

        public AppMethodBeat.IndexRecord getBeginRecord() {
            return this.beginRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jUptimeMillis = SystemClock.uptimeMillis();
            boolean zIsForeground = LooperAnrTracer.this.isForeground();
            int[] processPriority = Utils.getProcessPriority(Process.myPid());
            long[] jArrCopyData = AppMethodBeat.getInstance().copyData(this.beginRecord);
            this.beginRecord.release();
            String visibleScene = AppMethodBeat.getVisibleScene();
            long[] jArrDumpMemory = LooperAnrTracer.this.dumpMemory();
            Thread.State state = Looper.getMainLooper().getThread().getState();
            StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
            String stack = Utils.getStack(stackTrace, "|*\t\t", 12);
            UIThreadMonitor monitor = UIThreadMonitor.getMonitor();
            long queueCost = monitor.getQueueCost(0, this.token);
            long queueCost2 = monitor.getQueueCost(1, this.token);
            long queueCost3 = monitor.getQueueCost(2, this.token);
            LinkedList linkedList = new LinkedList();
            if (jArrCopyData.length > 0) {
                TraceDataUtils.structuredDataToStack(jArrCopyData, linkedList, true, jUptimeMillis);
                TraceDataUtils.trimStack(linkedList, 30, new TraceDataUtils.IStructuredDataFilter() { // from class: com.tencent.matrix.trace.tracer.LooperAnrTracer.AnrHandleTask.1
                    @Override // com.tencent.matrix.trace.util.TraceDataUtils.IStructuredDataFilter
                    public void fallback(List<MethodItem> list, int i) {
                        MatrixLog.w(LooperAnrTracer.TAG, "[fallback] size:%s targetSize:%s stack:%s", Integer.valueOf(i), 30, list);
                        ListIterator<MethodItem> listIterator = list.listIterator(Math.min(i, 30));
                        while (listIterator.hasNext()) {
                            listIterator.next();
                            listIterator.remove();
                        }
                    }

                    @Override // com.tencent.matrix.trace.util.TraceDataUtils.IStructuredDataFilter
                    public int getFilterMaxCount() {
                        return 60;
                    }

                    @Override // com.tencent.matrix.trace.util.TraceDataUtils.IStructuredDataFilter
                    public boolean isFilter(long j, int i) {
                        return j < ((long) (i * 5));
                    }
                });
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            long jMax = Math.max(5000L, TraceDataUtils.stackToString(linkedList, sb, sb2));
            String treeKey = TraceDataUtils.getTreeKey(linkedList, jMax);
            MatrixLog.w(LooperAnrTracer.TAG, "%s \npostTime:%s curTime:%s", printAnr(visibleScene, processPriority, jArrDumpMemory, state, sb2, zIsForeground, linkedList.size(), treeKey, stack, queueCost, queueCost2, queueCost3, jMax), Long.valueOf(this.token / 1000000), Long.valueOf(jUptimeMillis));
            if (jMax >= 6000) {
                MatrixLog.w(LooperAnrTracer.TAG, "The checked anr task was not executed on time. The possible reason is that the current process has a low priority. just pass this report", new Object[0]);
                return;
            }
            try {
                TracePlugin tracePlugin = (TracePlugin) Matrix.with().getPluginByClass(TracePlugin.class);
                if (tracePlugin == null) {
                    return;
                }
                JSONObject deviceInfo = DeviceUtil.getDeviceInfo(new JSONObject(), Matrix.with().getApplication());
                deviceInfo.put("detail", Constants.Type.ANR);
                deviceInfo.put(SharePluginInfo.ISSUE_COST, jMax);
                deviceInfo.put(SharePluginInfo.ISSUE_STACK_KEY, treeKey);
                deviceInfo.put("scene", visibleScene);
                deviceInfo.put(SharePluginInfo.ISSUE_TRACE_STACK, sb.toString());
                deviceInfo.put(SharePluginInfo.ISSUE_THREAD_STACK, Utils.getStack(stackTrace));
                deviceInfo.put(SharePluginInfo.ISSUE_PROCESS_PRIORITY, processPriority[0]);
                deviceInfo.put(SharePluginInfo.ISSUE_PROCESS_NICE, processPriority[1]);
                deviceInfo.put(SharePluginInfo.ISSUE_PROCESS_FOREGROUND, zIsForeground);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(SharePluginInfo.ISSUE_MEMORY_DALVIK, jArrDumpMemory[0]);
                jSONObject.put(SharePluginInfo.ISSUE_MEMORY_NATIVE, jArrDumpMemory[1]);
                jSONObject.put(SharePluginInfo.ISSUE_MEMORY_VM_SIZE, jArrDumpMemory[2]);
                deviceInfo.put(SharePluginInfo.ISSUE_MEMORY, jSONObject);
                Issue issue = new Issue();
                issue.setKey(this.token + "");
                issue.setTag(SharePluginInfo.TAG_PLUGIN_EVIL_METHOD);
                issue.setContent(deviceInfo);
                tracePlugin.onDetectIssue(issue);
            } catch (JSONException e) {
                MatrixLog.e(LooperAnrTracer.TAG, "[JSONException error: %s", e);
            }
        }

        public AnrHandleTask(AppMethodBeat.IndexRecord indexRecord, long j) {
            this.beginRecord = indexRecord;
            this.token = j;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class LagHandleTask implements Runnable {
        public LagHandleTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String visibleScene = AppMethodBeat.getVisibleScene();
            boolean zIsForeground = LooperAnrTracer.this.isForeground();
            try {
                TracePlugin tracePlugin = (TracePlugin) Matrix.with().getPluginByClass(TracePlugin.class);
                if (tracePlugin == null) {
                    return;
                }
                StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
                JSONObject deviceInfo = DeviceUtil.getDeviceInfo(new JSONObject(), Matrix.with().getApplication());
                deviceInfo.put("detail", Constants.Type.LAG);
                deviceInfo.put("scene", visibleScene);
                deviceInfo.put(SharePluginInfo.ISSUE_THREAD_STACK, Utils.getStack(stackTrace));
                deviceInfo.put(SharePluginInfo.ISSUE_PROCESS_FOREGROUND, zIsForeground);
                Issue issue = new Issue();
                issue.setTag(SharePluginInfo.TAG_PLUGIN_EVIL_METHOD);
                issue.setContent(deviceInfo);
                tracePlugin.onDetectIssue(issue);
                MatrixLog.e(LooperAnrTracer.TAG, "happens lag : %s ", deviceInfo.toString());
            } catch (JSONException e) {
                MatrixLog.e(LooperAnrTracer.TAG, "[JSONException error: %s", e);
            }
        }
    }

    public LooperAnrTracer(TraceConfig traceConfig) {
        this.traceConfig = traceConfig;
        this.isAnrTraceEnable = traceConfig.isAnrTraceEnable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long[] dumpMemory() {
        return new long[]{DeviceUtil.getDalvikHeap(), DeviceUtil.getNativeHeap(), DeviceUtil.getVmSize()};
    }

    private String printInputExpired(long j) {
        StringBuilder sb = new StringBuilder();
        String visibleScene = AppMethodBeat.getVisibleScene();
        boolean zIsForeground = isForeground();
        long[] jArrDumpMemory = dumpMemory();
        int[] processPriority = Utils.getProcessPriority(Process.myPid());
        sb.append(String.format("-\n>>>>>>>>>>>>>>>>>>>>>>> maybe happens Input ANR(%s ms)! <<<<<<<<<<<<<<<<<<<<<<<\n", Long.valueOf(j)));
        sb.append("|* [Status]");
        sb.append("\n");
        sb.append("|*\t\tScene: ");
        sb.append(visibleScene);
        sb.append("\n");
        sb.append("|*\t\tForeground: ");
        sb.append(zIsForeground);
        sb.append("\n");
        sb.append("|*\t\tPriority: ");
        sb.append(processPriority[0]);
        sb.append("\tNice: ");
        sb.append(processPriority[1]);
        sb.append("\n");
        sb.append("|*\t\tis64BitRuntime: ");
        sb.append(DeviceUtil.is64BitRuntime());
        sb.append("\n");
        sb.append("|* [Memory]");
        sb.append("\n");
        sb.append("|*\t\tDalvikHeap: ");
        sb.append(jArrDumpMemory[0]);
        sb.append("kb\n");
        sb.append("|*\t\tNativeHeap: ");
        sb.append(jArrDumpMemory[1]);
        sb.append("kb\n");
        sb.append("|*\t\tVmSize: ");
        sb.append(jArrDumpMemory[2]);
        sb.append("kb\n");
        sb.append("=========================================================================");
        return sb.toString();
    }

    @Override // com.tencent.matrix.trace.listeners.LooperObserver
    public void dispatchBegin(long j, long j2, long j3) {
        super.dispatchBegin(j, j2, j3);
        this.anrTask.beginRecord = AppMethodBeat.getInstance().maskIndex("AnrTracer#dispatchBegin");
        this.anrTask.token = j3;
        if (this.traceConfig.isDevEnv()) {
            MatrixLog.v(TAG, "* [dispatchBegin] token:%s index:%s", Long.valueOf(j3), Integer.valueOf(this.anrTask.beginRecord.index));
        }
        long jNanoTime = (System.nanoTime() - j3) / 1000000;
        this.anrHandler.postDelayed(this.anrTask, 5000 - jNanoTime);
        this.lagHandler.postDelayed(this.lagTask, 2000 - jNanoTime);
    }

    @Override // com.tencent.matrix.trace.listeners.LooperObserver
    public void dispatchEnd(long j, long j2, long j3, long j4, long j5, boolean z) {
        super.dispatchEnd(j, j2, j3, j4, j5, z);
        if (this.traceConfig.isDevEnv()) {
            long j6 = (j3 - j) / 1000000;
            long j7 = j4 - j2;
            MatrixLog.v(TAG, "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s", Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Utils.calculateCpuUsage(j7, j6));
        }
        if (this.anrTask != null) {
            this.anrTask.getBeginRecord().release();
            this.anrHandler.removeCallbacks(this.anrTask);
        }
        if (this.lagTask != null) {
            this.lagHandler.removeCallbacks(this.lagTask);
        }
    }

    @Override // com.tencent.matrix.trace.tracer.Tracer
    public void onAlive() {
        super.onAlive();
        if (this.isAnrTraceEnable) {
            UIThreadMonitor.getMonitor().addObserver(this);
            this.anrHandler = new Handler(MatrixHandlerThread.getDefaultHandler().getLooper());
            this.lagHandler = new Handler(MatrixHandlerThread.getDefaultHandler().getLooper());
        }
    }

    @Override // com.tencent.matrix.trace.tracer.Tracer
    public void onDead() {
        super.onDead();
        if (this.isAnrTraceEnable) {
            UIThreadMonitor.getMonitor().removeObserver(this);
            if (this.anrTask != null) {
                this.anrTask.getBeginRecord().release();
            }
            this.anrHandler.removeCallbacksAndMessages(null);
            this.lagHandler.removeCallbacksAndMessages(null);
        }
    }
}
