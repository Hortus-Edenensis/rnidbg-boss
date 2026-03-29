package com.tencent.matrix.trace.tracer;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.report.Issue;
import com.tencent.matrix.trace.TracePlugin;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.tencent.matrix.trace.config.TraceConfig;
import com.tencent.matrix.trace.constants.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.hacker.ActivityThreadHacker;
import com.tencent.matrix.trace.items.MethodItem;
import com.tencent.matrix.trace.listeners.IAppMethodBeatListener;
import com.tencent.matrix.trace.util.TraceDataUtils;
import com.tencent.matrix.util.DeviceUtil;
import com.tencent.matrix.util.MatrixHandlerThread;
import com.tencent.matrix.util.MatrixLog;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class StartupTracer extends Tracer implements IAppMethodBeatListener, ActivityThreadHacker.IApplicationCreateListener, Application.ActivityLifecycleCallbacks {
    private static final String TAG = "Matrix.StartupTracer";
    private int activeActivityCount;
    private long coldStartupThresholdMs;
    private final TraceConfig config;
    private boolean hasShowSplashActivity;
    private boolean isHasActivity;
    private boolean isStartupEnable;
    private boolean isWarmStartUp;
    private Set<String> splashActivities;
    private long warmStartupThresholdMs;
    private long firstScreenCost = 0;
    private long coldCost = 0;
    private long lastCreateActivity = 0;
    private HashMap<String, Long> createdTimeMap = new HashMap<>();
    private boolean isShouldRecordCreateTime = true;

    /* JADX INFO: compiled from: SearchBox */
    public class AnalyseTask implements Runnable {
        long allCost;
        long applicationCost;
        long[] data;
        long firstScreenCost;
        boolean isWarmStartUp;
        int scene;

        public AnalyseTask(long[] jArr, long j, long j2, long j3, boolean z, int i) {
            this.data = jArr;
            this.scene = i;
            this.applicationCost = j;
            this.firstScreenCost = j2;
            this.allCost = j3;
            this.isWarmStartUp = z;
        }

        private void report(long j, long j2, StringBuilder sb, String str, long j3, boolean z, int i) {
            TracePlugin tracePlugin = (TracePlugin) Matrix.with().getPluginByClass(TracePlugin.class);
            if (tracePlugin == null) {
                return;
            }
            try {
                JSONObject deviceInfo = DeviceUtil.getDeviceInfo(new JSONObject(), Matrix.with().getApplication());
                deviceInfo.put(SharePluginInfo.STAGE_APPLICATION_CREATE, j);
                deviceInfo.put(SharePluginInfo.STAGE_APPLICATION_CREATE_SCENE, i);
                deviceInfo.put(SharePluginInfo.STAGE_FIRST_ACTIVITY_CREATE, j2);
                deviceInfo.put(SharePluginInfo.STAGE_STARTUP_DURATION, j3);
                deviceInfo.put(SharePluginInfo.ISSUE_IS_WARM_START_UP, z);
                Issue issue = new Issue();
                issue.setTag(SharePluginInfo.TAG_PLUGIN_STARTUP);
                issue.setContent(deviceInfo);
                tracePlugin.onDetectIssue(issue);
            } catch (JSONException e) {
                MatrixLog.e(StartupTracer.TAG, "[JSONException for StartUpReportTask error: %s", e);
            }
            if ((j3 <= StartupTracer.this.coldStartupThresholdMs || z) && (j3 <= StartupTracer.this.warmStartupThresholdMs || !z)) {
                return;
            }
            try {
                JSONObject deviceInfo2 = DeviceUtil.getDeviceInfo(new JSONObject(), Matrix.with().getApplication());
                deviceInfo2.put("detail", Constants.Type.STARTUP);
                deviceInfo2.put(SharePluginInfo.ISSUE_COST, j3);
                deviceInfo2.put(SharePluginInfo.ISSUE_TRACE_STACK, sb.toString());
                deviceInfo2.put(SharePluginInfo.ISSUE_STACK_KEY, str);
                deviceInfo2.put(SharePluginInfo.ISSUE_SUB_TYPE, z ? 2 : 1);
                Issue issue2 = new Issue();
                issue2.setTag(SharePluginInfo.TAG_PLUGIN_EVIL_METHOD);
                issue2.setContent(deviceInfo2);
                tracePlugin.onDetectIssue(issue2);
            } catch (JSONException e2) {
                MatrixLog.e(StartupTracer.TAG, "[JSONException error: %s", e2);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            LinkedList linkedList = new LinkedList();
            long[] jArr = this.data;
            if (jArr.length > 0) {
                TraceDataUtils.structuredDataToStack(jArr, linkedList, false, -1L);
                TraceDataUtils.trimStack(linkedList, 30, new TraceDataUtils.IStructuredDataFilter() { // from class: com.tencent.matrix.trace.tracer.StartupTracer.AnalyseTask.1
                    @Override // com.tencent.matrix.trace.util.TraceDataUtils.IStructuredDataFilter
                    public void fallback(List<MethodItem> list, int i) {
                        MatrixLog.w(StartupTracer.TAG, "[fallback] size:%s targetSize:%s stack:%s", Integer.valueOf(i), 30, list);
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
            long jMax = Math.max(this.allCost, TraceDataUtils.stackToString(linkedList, sb, sb2));
            String treeKey = TraceDataUtils.getTreeKey(linkedList, jMax);
            if ((this.allCost > StartupTracer.this.coldStartupThresholdMs && !this.isWarmStartUp) || (this.allCost > StartupTracer.this.warmStartupThresholdMs && this.isWarmStartUp)) {
                MatrixLog.w(StartupTracer.TAG, "stackKey:%s \n%s", treeKey, sb2.toString());
            }
            report(this.applicationCost, this.firstScreenCost, sb, treeKey, jMax, this.isWarmStartUp, this.scene);
        }
    }

    public StartupTracer(TraceConfig traceConfig) {
        this.config = traceConfig;
        this.isStartupEnable = traceConfig.isStartupEnable();
        this.splashActivities = traceConfig.getSplashActivities();
        this.coldStartupThresholdMs = traceConfig.getColdStartupThresholdMs();
        this.warmStartupThresholdMs = traceConfig.getWarmStartupThresholdMs();
        this.isHasActivity = traceConfig.isHasActivity();
        ActivityThreadHacker.addListener(this);
    }

    private void analyse(long j, long j2, long j3, boolean z) {
        MatrixLog.i(TAG, "[report] applicationCost:%s firstScreenCost:%s allCost:%s isWarmStartUp:%s, createScene:%d", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), Integer.valueOf(ActivityThreadHacker.sApplicationCreateScene));
        long[] jArrCopyData = new long[0];
        if (!z && j3 >= this.coldStartupThresholdMs) {
            jArrCopyData = AppMethodBeat.getInstance().copyData(ActivityThreadHacker.sApplicationCreateBeginMethodIndex);
            ActivityThreadHacker.sApplicationCreateBeginMethodIndex.release();
        } else if (z && j3 >= this.warmStartupThresholdMs) {
            jArrCopyData = AppMethodBeat.getInstance().copyData(ActivityThreadHacker.sLastLaunchActivityMethodIndex);
            ActivityThreadHacker.sLastLaunchActivityMethodIndex.release();
        }
        MatrixHandlerThread.getDefaultHandler().post(new AnalyseTask(jArrCopyData, j, j2, j3, z, ActivityThreadHacker.sApplicationCreateScene));
    }

    private static void checkActivityThread_mCallback() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Field declaredField = cls.getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(cls);
            Field declaredField2 = cls.getDeclaredField("mH");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Field declaredField3 = obj2.getClass().getSuperclass().getDeclaredField("mCallback");
            declaredField3.setAccessible(true);
            MatrixLog.i(TAG, "callback %s", (Handler.Callback) declaredField3.get(obj2));
        } catch (Exception unused) {
        }
    }

    private boolean isColdStartup() {
        return this.coldCost == 0;
    }

    private boolean isWarmStartUp() {
        return this.isWarmStartUp;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        MatrixLog.i(TAG, "activeActivityCount:%d, coldCost:%d", Integer.valueOf(this.activeActivityCount), Long.valueOf(this.coldCost));
        if (this.activeActivityCount == 0 && this.coldCost > 0) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            this.lastCreateActivity = jUptimeMillis;
            MatrixLog.i(TAG, "lastCreateActivity:%d, activity:%s", Long.valueOf(jUptimeMillis), activity.getClass().getName());
            this.isWarmStartUp = true;
        }
        this.activeActivityCount++;
        if (this.isShouldRecordCreateTime) {
            this.createdTimeMap.put(activity.getClass().getName() + "@" + activity.hashCode(), Long.valueOf(SystemClock.uptimeMillis()));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        MatrixLog.i(TAG, "activeActivityCount:%d", Integer.valueOf(this.activeActivityCount));
        this.activeActivityCount--;
    }

    @Override // com.tencent.matrix.trace.listeners.IAppMethodBeatListener
    public void onActivityFocused(Activity activity) {
        if (ActivityThreadHacker.sApplicationCreateScene == Integer.MIN_VALUE) {
            Log.w(TAG, "start up from unknown scene");
            return;
        }
        String name = activity.getClass().getName();
        if (!isColdStartup()) {
            if (isWarmStartUp()) {
                this.isWarmStartUp = false;
                long jUptimeMillis = SystemClock.uptimeMillis() - this.lastCreateActivity;
                MatrixLog.i(TAG, "#WarmStartup# activity:%s, warmCost:%d, now:%d, lastCreateActivity:%d", name, Long.valueOf(jUptimeMillis), Long.valueOf(SystemClock.uptimeMillis()), Long.valueOf(this.lastCreateActivity));
                if (jUptimeMillis > 0) {
                    analyse(0L, 0L, jUptimeMillis, true);
                    return;
                }
                return;
            }
            return;
        }
        boolean zIsCreatedByLaunchActivity = ActivityThreadHacker.isCreatedByLaunchActivity();
        Set<String> set = this.splashActivities;
        MatrixLog.i(TAG, "#ColdStartup# activity:%s, splashActivities:%s, empty:%b, isCreatedByLaunchActivity:%b, hasShowSplashActivity:%b, firstScreenCost:%d, now:%d, application_create_begin_time:%d, app_cost:%d", name, set, Boolean.valueOf(set.isEmpty()), Boolean.valueOf(zIsCreatedByLaunchActivity), Boolean.valueOf(this.hasShowSplashActivity), Long.valueOf(this.firstScreenCost), Long.valueOf(SystemClock.uptimeMillis()), Long.valueOf(ActivityThreadHacker.getEggBrokenTime()), Long.valueOf(ActivityThreadHacker.getApplicationCost()));
        String str = name + "@" + activity.hashCode();
        Long l = this.createdTimeMap.get(str);
        if (l == null) {
            l = 0L;
        }
        this.createdTimeMap.put(str, Long.valueOf(SystemClock.uptimeMillis() - l.longValue()));
        if (this.firstScreenCost == 0) {
            this.firstScreenCost = SystemClock.uptimeMillis() - ActivityThreadHacker.getEggBrokenTime();
        }
        if (this.hasShowSplashActivity) {
            this.coldCost = SystemClock.uptimeMillis() - ActivityThreadHacker.getEggBrokenTime();
        } else if (this.splashActivities.contains(name)) {
            this.hasShowSplashActivity = true;
        } else if (this.splashActivities.isEmpty()) {
            if (zIsCreatedByLaunchActivity) {
                this.coldCost = this.firstScreenCost;
            } else {
                this.firstScreenCost = 0L;
                this.coldCost = ActivityThreadHacker.getApplicationCost();
            }
        } else if (zIsCreatedByLaunchActivity) {
            this.coldCost = this.firstScreenCost;
        } else {
            this.firstScreenCost = 0L;
            this.coldCost = ActivityThreadHacker.getApplicationCost();
        }
        if (this.coldCost > 0) {
            Long l2 = this.createdTimeMap.get(str);
            if (l2 == null || l2.longValue() < 30000) {
                analyse(ActivityThreadHacker.getApplicationCost(), this.firstScreenCost, this.coldCost, false);
            } else {
                MatrixLog.e(TAG, "%s cost too much time[%s] between activity create and onActivityFocused, just throw it.(createTime:%s) ", str, Long.valueOf(SystemClock.uptimeMillis() - l.longValue()), l);
            }
        }
    }

    @Override // com.tencent.matrix.trace.tracer.Tracer
    public void onAlive() {
        super.onAlive();
        MatrixLog.i(TAG, "[onAlive] isStartupEnable:%s", Boolean.valueOf(this.isStartupEnable));
        if (this.isStartupEnable) {
            AppMethodBeat.getInstance().addListener(this);
            Matrix.with().getApplication().registerActivityLifecycleCallbacks(this);
        }
    }

    @Override // com.tencent.matrix.trace.hacker.ActivityThreadHacker.IApplicationCreateListener
    public void onApplicationCreateEnd() {
        if (this.isHasActivity) {
            return;
        }
        long applicationCost = ActivityThreadHacker.getApplicationCost();
        MatrixLog.i(TAG, "onApplicationCreateEnd, applicationCost:%d", Long.valueOf(applicationCost));
        analyse(applicationCost, 0L, applicationCost, false);
    }

    @Override // com.tencent.matrix.trace.tracer.Tracer
    public void onDead() {
        super.onDead();
        if (this.isStartupEnable) {
            AppMethodBeat.getInstance().removeListener(this);
            Matrix.with().getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override // com.tencent.matrix.trace.tracer.Tracer, com.tencent.matrix.listeners.IAppForeground
    public void onForeground(boolean z) {
        super.onForeground(z);
        if (z) {
            return;
        }
        checkActivityThread_mCallback();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
