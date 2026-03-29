package com.tencent.matrix.trace.tracer;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.report.Issue;
import com.tencent.matrix.trace.TracePlugin;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.tencent.matrix.trace.config.TraceConfig;
import com.tencent.matrix.trace.constants.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.util.AppForegroundUtil;
import com.tencent.matrix.trace.util.Utils;
import com.tencent.matrix.util.DeviceUtil;
import com.tencent.matrix.util.MatrixLog;
import com.tencent.matrix.util.MatrixUtil;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class SignalAnrTracer extends Tracer {
    private static final int ANR_DUMP_MAX_TIME = 20000;
    private static final long BACKGROUND_MSG_THRESHOLD = -10000;
    private static final String CHECK_ANR_STATE_THREAD_NAME = "Check-ANR-State-Thread";
    private static final int CHECK_ERROR_STATE_COUNT = 40;
    private static final int CHECK_ERROR_STATE_INTERVAL = 500;
    private static final long FOREGROUND_MSG_THRESHOLD = -2000;
    private static final String TAG = "SignalAnrTracer";
    private static String anrMessageString = "";
    private static long anrMessageWhen = 0;
    private static boolean currentForeground = false;
    private static boolean hasInit = false;
    public static boolean hasInstance = false;
    private static String sAnrTraceFilePath = "";
    private static Application sApplication = null;
    private static String sPrintTraceFilePath = "";
    private static SignalAnrDetectedListener sSignalAnrDetectedListener;

    /* JADX INFO: compiled from: SearchBox */
    public interface SignalAnrDetectedListener {
        void onAnrDetected(String str, String str2, long j, boolean z);
    }

    static {
        System.loadLibrary("trace-canary");
    }

    public SignalAnrTracer(TraceConfig traceConfig) {
        hasInstance = true;
        sAnrTraceFilePath = traceConfig.anrTraceFilePath;
        sPrintTraceFilePath = traceConfig.printTraceFilePath;
    }

    private static boolean checkErrorState() {
        try {
            Application application = sApplication;
            if (application == null) {
                application = Matrix.with().getApplication();
            }
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = ((ActivityManager) application.getSystemService("activity")).getProcessesInErrorState();
            if (processesInErrorState == null) {
                return false;
            }
            for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                MatrixLog.i(TAG, "[checkErrorState] found Error State proccessName = %s, proc.condition = %d", processErrorStateInfo.processName, Integer.valueOf(processErrorStateInfo.condition));
                if (processErrorStateInfo.uid != Process.myUid() && processErrorStateInfo.condition == 2) {
                    MatrixLog.i(TAG, "maybe received other apps ANR signal", new Object[0]);
                }
                if (processErrorStateInfo.pid == Process.myPid() && processErrorStateInfo.condition == 2) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            MatrixLog.e(TAG, "[checkErrorState] error : %s", th.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkErrorStateCycle() {
        int i = 0;
        while (i < 40) {
            i++;
            try {
                if (checkErrorState()) {
                    report(true);
                    return;
                }
                Thread.sleep(500L);
            } catch (Throwable th) {
                MatrixLog.e(TAG, "checkErrorStateCycle error, e : " + th.getMessage(), new Object[0]);
                return;
            }
        }
    }

    @RequiresApi(api = 23)
    private static boolean isMainThreadBlocked() {
        try {
            MessageQueue queue = Looper.getMainLooper().getQueue();
            Field declaredField = queue.getClass().getDeclaredField("mMessages");
            declaredField.setAccessible(true);
            Message message = (Message) declaredField.get(queue);
            if (message == null) {
                return false;
            }
            anrMessageString = message.toString();
            long when = message.getWhen();
            if (when == 0) {
                return false;
            }
            long jUptimeMillis = when - SystemClock.uptimeMillis();
            anrMessageWhen = jUptimeMillis;
            return jUptimeMillis < (currentForeground ? FOREGROUND_MSG_THRESHOLD : BACKGROUND_MSG_THRESHOLD);
        } catch (Exception unused) {
            return false;
        }
    }

    private static native void nativeFreeSignalAnrDetective();

    private static native void nativeInitSignalAnrDetective(String str, String str2);

    private static native void nativePrintTrace();

    @Keep
    private static void onANRDumpTrace() {
        try {
            MatrixUtil.printFileByLine(TAG, sAnrTraceFilePath);
        } catch (Throwable th) {
            MatrixLog.e(TAG, "onANRDumpTrace error: %s", th.getMessage());
        }
    }

    @Keep
    @RequiresApi(api = 23)
    private static void onANRDumped() {
        currentForeground = AppForegroundUtil.isInterestingToUser();
        if (isMainThreadBlocked()) {
            report(false);
        } else {
            new Thread(new Runnable() { // from class: com.tencent.matrix.trace.tracer.SignalAnrTracer.1
                @Override // java.lang.Runnable
                public void run() {
                    SignalAnrTracer.checkErrorStateCycle();
                }
            }, CHECK_ANR_STATE_THREAD_NAME).start();
        }
    }

    @Keep
    private static void onPrintTrace() {
        try {
            MatrixUtil.printFileByLine(TAG, sPrintTraceFilePath);
        } catch (Throwable th) {
            MatrixLog.e(TAG, "onPrintTrace error: %s", th.getMessage());
        }
    }

    public static void printTrace() {
        if (!hasInstance) {
            MatrixLog.e(TAG, "SignalAnrTracer has not been initialize", new Object[0]);
        } else if (sPrintTraceFilePath.equals("")) {
            MatrixLog.e(TAG, "PrintTraceFilePath has not been set", new Object[0]);
        } else {
            nativePrintTrace();
        }
    }

    private static void report(boolean z) {
        try {
            String mainThreadJavaStackTrace = Utils.getMainThreadJavaStackTrace();
            SignalAnrDetectedListener signalAnrDetectedListener = sSignalAnrDetectedListener;
            if (signalAnrDetectedListener != null) {
                signalAnrDetectedListener.onAnrDetected(mainThreadJavaStackTrace, anrMessageString, anrMessageWhen, z);
                return;
            }
            TracePlugin tracePlugin = (TracePlugin) Matrix.with().getPluginByClass(TracePlugin.class);
            if (tracePlugin == null) {
                return;
            }
            String visibleScene = AppMethodBeat.getVisibleScene();
            JSONObject deviceInfo = DeviceUtil.getDeviceInfo(new JSONObject(), Matrix.with().getApplication());
            deviceInfo.put("detail", Constants.Type.SIGNAL_ANR);
            deviceInfo.put("scene", visibleScene);
            deviceInfo.put(SharePluginInfo.ISSUE_THREAD_STACK, mainThreadJavaStackTrace);
            deviceInfo.put(SharePluginInfo.ISSUE_PROCESS_FOREGROUND, currentForeground);
            Issue issue = new Issue();
            issue.setTag(SharePluginInfo.TAG_PLUGIN_EVIL_METHOD);
            issue.setContent(deviceInfo);
            tracePlugin.onDetectIssue(issue);
            MatrixLog.e(TAG, "happens real ANR : %s ", deviceInfo.toString());
        } catch (JSONException e) {
            MatrixLog.e(TAG, "[JSONException error: %s", e);
        }
    }

    @Override // com.tencent.matrix.trace.tracer.Tracer
    public void onAlive() {
        super.onAlive();
        if (hasInit) {
            return;
        }
        nativeInitSignalAnrDetective(sAnrTraceFilePath, sPrintTraceFilePath);
        AppForegroundUtil.INSTANCE.init();
        hasInit = true;
    }

    @Override // com.tencent.matrix.trace.tracer.Tracer
    public void onDead() {
        super.onDead();
        nativeFreeSignalAnrDetective();
    }

    public void setSignalAnrDetectedListener(SignalAnrDetectedListener signalAnrDetectedListener) {
        sSignalAnrDetectedListener = signalAnrDetectedListener;
    }

    public SignalAnrTracer(Application application) {
        hasInstance = true;
        sApplication = application;
    }

    public SignalAnrTracer(Application application, String str, String str2) {
        hasInstance = true;
        sAnrTraceFilePath = str;
        sPrintTraceFilePath = str2;
        sApplication = application;
    }
}
