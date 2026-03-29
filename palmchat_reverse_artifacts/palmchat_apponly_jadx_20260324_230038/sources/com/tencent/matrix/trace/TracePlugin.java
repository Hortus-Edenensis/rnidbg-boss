package com.tencent.matrix.trace;

import android.app.Application;
import android.os.Looper;
import com.tencent.matrix.plugin.Plugin;
import com.tencent.matrix.plugin.PluginListener;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.tencent.matrix.trace.config.TraceConfig;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.core.UIThreadMonitor;
import com.tencent.matrix.trace.tracer.EvilMethodTracer;
import com.tencent.matrix.trace.tracer.FrameTracer;
import com.tencent.matrix.trace.tracer.IdleHandlerLagTracer;
import com.tencent.matrix.trace.tracer.LooperAnrTracer;
import com.tencent.matrix.trace.tracer.SignalAnrTracer;
import com.tencent.matrix.trace.tracer.StartupTracer;
import com.tencent.matrix.trace.tracer.ThreadPriorityTracer;
import com.tencent.matrix.util.MatrixHandlerThread;
import com.tencent.matrix.util.MatrixLog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TracePlugin extends Plugin {
    private static final String TAG = "Matrix.TracePlugin";
    private EvilMethodTracer evilMethodTracer;
    private FrameTracer frameTracer;
    private IdleHandlerLagTracer idleHandlerLagTracer;
    private LooperAnrTracer looperAnrTracer;
    private SignalAnrTracer signalAnrTracer;
    private StartupTracer startupTracer;
    private ThreadPriorityTracer threadPriorityTracer;
    private final TraceConfig traceConfig;

    public TracePlugin(TraceConfig traceConfig) {
        this.traceConfig = traceConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean willUiThreadMonitorRunning(TraceConfig traceConfig) {
        return traceConfig.isEvilMethodTraceEnable() || traceConfig.isAnrTraceEnable() || traceConfig.isFPSEnable();
    }

    @Override // com.tencent.matrix.plugin.Plugin, com.tencent.matrix.plugin.IPlugin
    public void destroy() {
        super.destroy();
    }

    public AppMethodBeat getAppMethodBeat() {
        return AppMethodBeat.getInstance();
    }

    public EvilMethodTracer getEvilMethodTracer() {
        return this.evilMethodTracer;
    }

    public FrameTracer getFrameTracer() {
        return this.frameTracer;
    }

    public LooperAnrTracer getLooperAnrTracer() {
        return this.looperAnrTracer;
    }

    public StartupTracer getStartupTracer() {
        return this.startupTracer;
    }

    @Override // com.tencent.matrix.plugin.Plugin, com.tencent.matrix.plugin.IPlugin
    public String getTag() {
        return SharePluginInfo.TAG_PLUGIN;
    }

    public TraceConfig getTraceConfig() {
        return this.traceConfig;
    }

    public UIThreadMonitor getUIThreadMonitor() {
        if (UIThreadMonitor.getMonitor().isInit()) {
            return UIThreadMonitor.getMonitor();
        }
        return null;
    }

    @Override // com.tencent.matrix.plugin.Plugin, com.tencent.matrix.plugin.IPlugin
    public void init(Application application, PluginListener pluginListener) {
        super.init(application, pluginListener);
        MatrixLog.i(TAG, "trace plugin init, trace config: %s", this.traceConfig.toString());
        this.looperAnrTracer = new LooperAnrTracer(this.traceConfig);
        this.frameTracer = new FrameTracer(this.traceConfig);
        this.evilMethodTracer = new EvilMethodTracer(this.traceConfig);
        this.startupTracer = new StartupTracer(this.traceConfig);
    }

    @Override // com.tencent.matrix.plugin.Plugin, com.tencent.matrix.plugin.IPlugin, com.tencent.matrix.listeners.IAppForeground
    public void onForeground(boolean z) {
        super.onForeground(z);
        if (isSupported()) {
            FrameTracer frameTracer = this.frameTracer;
            if (frameTracer != null) {
                frameTracer.onForeground(z);
            }
            LooperAnrTracer looperAnrTracer = this.looperAnrTracer;
            if (looperAnrTracer != null) {
                looperAnrTracer.onForeground(z);
            }
            EvilMethodTracer evilMethodTracer = this.evilMethodTracer;
            if (evilMethodTracer != null) {
                evilMethodTracer.onForeground(z);
            }
            StartupTracer startupTracer = this.startupTracer;
            if (startupTracer != null) {
                startupTracer.onForeground(z);
            }
        }
    }

    @Override // com.tencent.matrix.plugin.Plugin, com.tencent.matrix.plugin.IPlugin
    public void start() {
        super.start();
        if (!isSupported()) {
            MatrixLog.w(TAG, "[start] Plugin is unSupported!", new Object[0]);
            return;
        }
        MatrixLog.w(TAG, "start!", new Object[0]);
        Runnable runnable = new Runnable() { // from class: com.tencent.matrix.trace.TracePlugin.1
            @Override // java.lang.Runnable
            public void run() {
                TracePlugin tracePlugin = TracePlugin.this;
                if (tracePlugin.willUiThreadMonitorRunning(tracePlugin.traceConfig) && !UIThreadMonitor.getMonitor().isInit()) {
                    try {
                        UIThreadMonitor.getMonitor().init(TracePlugin.this.traceConfig);
                    } catch (RuntimeException e) {
                        MatrixLog.e(TracePlugin.TAG, "[start] RuntimeException:%s", e);
                        return;
                    }
                }
                if (TracePlugin.this.traceConfig.isAppMethodBeatEnable()) {
                    AppMethodBeat.getInstance().onStart();
                } else {
                    AppMethodBeat.getInstance().forceStop();
                }
                UIThreadMonitor.getMonitor().onStart();
                if (TracePlugin.this.traceConfig.isAnrTraceEnable()) {
                    TracePlugin.this.looperAnrTracer.onStartTrace();
                }
                if (TracePlugin.this.traceConfig.isIdleHandlerEnable()) {
                    TracePlugin tracePlugin2 = TracePlugin.this;
                    tracePlugin2.idleHandlerLagTracer = new IdleHandlerLagTracer(tracePlugin2.traceConfig);
                    TracePlugin.this.idleHandlerLagTracer.onStartTrace();
                }
                if (TracePlugin.this.traceConfig.isSignalAnrTraceEnable() && !SignalAnrTracer.hasInstance) {
                    TracePlugin.this.signalAnrTracer = new SignalAnrTracer(TracePlugin.this.traceConfig);
                    TracePlugin.this.signalAnrTracer.onStartTrace();
                }
                if (TracePlugin.this.traceConfig.isMainThreadPriorityTraceEnable()) {
                    TracePlugin.this.threadPriorityTracer = new ThreadPriorityTracer();
                    TracePlugin.this.threadPriorityTracer.onStartTrace();
                }
                if (TracePlugin.this.traceConfig.isFPSEnable()) {
                    TracePlugin.this.frameTracer.onStartTrace();
                }
                if (TracePlugin.this.traceConfig.isEvilMethodTraceEnable()) {
                    TracePlugin.this.evilMethodTracer.onStartTrace();
                }
                if (TracePlugin.this.traceConfig.isStartupEnable()) {
                    TracePlugin.this.startupTracer.onStartTrace();
                }
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            MatrixLog.w(TAG, "start TracePlugin in Thread[%s] but not in mainThread!", Long.valueOf(Thread.currentThread().getId()));
            MatrixHandlerThread.getDefaultMainHandler().post(runnable);
        }
    }

    @Override // com.tencent.matrix.plugin.Plugin, com.tencent.matrix.plugin.IPlugin
    public void stop() {
        super.stop();
        if (!isSupported()) {
            MatrixLog.w(TAG, "[stop] Plugin is unSupported!", new Object[0]);
            return;
        }
        MatrixLog.w(TAG, "stop!", new Object[0]);
        Runnable runnable = new Runnable() { // from class: com.tencent.matrix.trace.TracePlugin.2
            @Override // java.lang.Runnable
            public void run() {
                AppMethodBeat.getInstance().onStop();
                UIThreadMonitor.getMonitor().onStop();
                TracePlugin.this.looperAnrTracer.onCloseTrace();
                TracePlugin.this.frameTracer.onCloseTrace();
                TracePlugin.this.evilMethodTracer.onCloseTrace();
                TracePlugin.this.startupTracer.onCloseTrace();
                if (TracePlugin.this.signalAnrTracer != null) {
                    TracePlugin.this.signalAnrTracer.onCloseTrace();
                }
                if (TracePlugin.this.idleHandlerLagTracer != null) {
                    TracePlugin.this.idleHandlerLagTracer.onCloseTrace();
                }
                if (TracePlugin.this.threadPriorityTracer != null) {
                    TracePlugin.this.threadPriorityTracer.onCloseTrace();
                }
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            MatrixLog.w(TAG, "stop TracePlugin in Thread[%s] but not in mainThread!", Long.valueOf(Thread.currentThread().getId()));
            MatrixHandlerThread.getDefaultMainHandler().post(runnable);
        }
    }
}
