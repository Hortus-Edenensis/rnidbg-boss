package com.tencent.matrix.trace.tracer;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue;
import androidx.annotation.Nullable;
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
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class IdleHandlerLagTracer extends Tracer {
    private static final String TAG = "Matrix.AnrTracer";
    private static Handler idleHandlerLagHandler;
    private static HandlerThread idleHandlerLagHandlerThread;
    private static Runnable idleHanlderLagRunnable;
    private final TraceConfig traceConfig;

    /* JADX INFO: compiled from: SearchBox */
    public static class IdleHandlerLagRunable implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                TracePlugin tracePlugin = (TracePlugin) Matrix.with().getPluginByClass(TracePlugin.class);
                if (tracePlugin == null) {
                    return;
                }
                String mainThreadJavaStackTrace = Utils.getMainThreadJavaStackTrace();
                boolean zIsInterestingToUser = AppForegroundUtil.isInterestingToUser();
                String visibleScene = AppMethodBeat.getVisibleScene();
                JSONObject deviceInfo = DeviceUtil.getDeviceInfo(new JSONObject(), Matrix.with().getApplication());
                deviceInfo.put("detail", Constants.Type.LAG_IDLE_HANDLER);
                deviceInfo.put("scene", visibleScene);
                deviceInfo.put(SharePluginInfo.ISSUE_THREAD_STACK, mainThreadJavaStackTrace);
                deviceInfo.put(SharePluginInfo.ISSUE_PROCESS_FOREGROUND, zIsInterestingToUser);
                Issue issue = new Issue();
                issue.setTag(SharePluginInfo.TAG_PLUGIN_EVIL_METHOD);
                issue.setContent(deviceInfo);
                tracePlugin.onDetectIssue(issue);
                MatrixLog.e(IdleHandlerLagTracer.TAG, "happens idle handler Lag : %s ", deviceInfo.toString());
            } catch (Throwable th) {
                MatrixLog.e(IdleHandlerLagTracer.TAG, "Matrix error, error = " + th.getMessage(), new Object[0]);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class MyArrayList<T> extends ArrayList {
        Map<MessageQueue.IdleHandler, MyIdleHandler> map = new HashMap();

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(Object obj) {
            if (!(obj instanceof MessageQueue.IdleHandler)) {
                return super.add(obj);
            }
            MessageQueue.IdleHandler idleHandler = (MessageQueue.IdleHandler) obj;
            MyIdleHandler myIdleHandler = new MyIdleHandler(idleHandler);
            this.map.put(idleHandler, myIdleHandler);
            return super.add(myIdleHandler);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(@Nullable Object obj) {
            if (obj instanceof MyIdleHandler) {
                this.map.remove(((MyIdleHandler) obj).idleHandler);
                return super.remove(obj);
            }
            MyIdleHandler myIdleHandlerRemove = this.map.remove(obj);
            return myIdleHandlerRemove != null ? super.remove(myIdleHandlerRemove) : super.remove(obj);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class MyIdleHandler implements MessageQueue.IdleHandler {
        private MessageQueue.IdleHandler idleHandler;

        public MyIdleHandler(MessageQueue.IdleHandler idleHandler) {
            this.idleHandler = idleHandler;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            IdleHandlerLagTracer.idleHandlerLagHandler.postDelayed(IdleHandlerLagTracer.idleHanlderLagRunnable, 2000L);
            boolean zQueueIdle = this.idleHandler.queueIdle();
            IdleHandlerLagTracer.idleHandlerLagHandler.removeCallbacks(IdleHandlerLagTracer.idleHanlderLagRunnable);
            return zQueueIdle;
        }
    }

    public IdleHandlerLagTracer(TraceConfig traceConfig) {
        this.traceConfig = traceConfig;
    }

    private static void detectIdleHandler() {
        try {
            if (Build.VERSION.SDK_INT < 23) {
                return;
            }
            MessageQueue queue = Looper.getMainLooper().getQueue();
            Field declaredField = MessageQueue.class.getDeclaredField("mIdleHandlers");
            declaredField.setAccessible(true);
            declaredField.set(queue, new MyArrayList());
            idleHandlerLagHandlerThread.start();
            idleHandlerLagHandler = new Handler(idleHandlerLagHandlerThread.getLooper());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.tencent.matrix.trace.tracer.Tracer
    public void onAlive() {
        super.onAlive();
        if (this.traceConfig.isIdleHandlerEnable()) {
            idleHandlerLagHandlerThread = new HandlerThread("IdleHandlerLagThread");
            idleHanlderLagRunnable = new IdleHandlerLagRunable();
            detectIdleHandler();
        }
    }

    @Override // com.tencent.matrix.trace.tracer.Tracer
    public void onDead() {
        super.onDead();
        if (this.traceConfig.isIdleHandlerEnable()) {
            idleHandlerLagHandler.removeCallbacksAndMessages(null);
        }
    }
}
