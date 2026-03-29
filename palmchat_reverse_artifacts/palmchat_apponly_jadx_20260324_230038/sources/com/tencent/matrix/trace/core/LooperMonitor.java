package com.tencent.matrix.trace.core;

import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Log;
import android.util.Printer;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.tencent.matrix.util.MatrixLog;
import com.tencent.matrix.util.ReflectUtils;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LooperMonitor implements MessageQueue.IdleHandler {
    private static final long CHECK_TIME = 60000;
    private static final String TAG = "Matrix.LooperMonitor";
    private Looper looper;
    private LooperPrinter printer;
    private static final Map<Looper, LooperMonitor> sLooperMonitorMap = new ConcurrentHashMap();
    private static final LooperMonitor sMainMonitor = of(Looper.getMainLooper());
    private static boolean isReflectLoggingError = false;
    private final HashSet<LooperDispatchListener> listeners = new HashSet<>();
    private long lastCheckPrinterTime = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class LooperPrinter implements Printer {
        boolean isHasChecked = false;
        boolean isValid = false;
        public Printer origin;

        public LooperPrinter(Printer printer) {
            this.origin = printer;
        }

        @Override // android.util.Printer
        public void println(String str) {
            Printer printer = this.origin;
            if (printer != null) {
                printer.println(str);
                if (this.origin == this) {
                    throw new RuntimeException("Matrix.LooperMonitor origin == this");
                }
            }
            if (!this.isHasChecked) {
                boolean z = str.charAt(0) == '>' || str.charAt(0) == '<';
                this.isValid = z;
                this.isHasChecked = true;
                if (!z) {
                    MatrixLog.e(LooperMonitor.TAG, "[println] Printer is inValid! x:%s", str);
                }
            }
            if (this.isValid) {
                LooperMonitor.this.dispatch(str.charAt(0) == '>', str);
            }
        }
    }

    private LooperMonitor(Looper looper) {
        Objects.requireNonNull(looper);
        this.looper = looper;
        resetPrinter();
        addIdleHandler(looper);
    }

    private synchronized void addIdleHandler(Looper looper) {
        if (Build.VERSION.SDK_INT >= 23) {
            looper.getQueue().addIdleHandler(this);
        } else {
            try {
                ((MessageQueue) ReflectUtils.get(looper.getClass(), "mQueue", looper)).addIdleHandler(this);
            } catch (Exception e) {
                Log.e(TAG, "[removeIdleHandler] %s", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatch(boolean z, String str) {
        synchronized (this.listeners) {
            for (LooperDispatchListener looperDispatchListener : this.listeners) {
                if (looperDispatchListener.isValid()) {
                    if (z) {
                        if (!looperDispatchListener.isHasDispatchStart) {
                            looperDispatchListener.onDispatchStart(str);
                        }
                    } else if (looperDispatchListener.isHasDispatchStart) {
                        looperDispatchListener.onDispatchEnd(str);
                    }
                } else if (!z && looperDispatchListener.isHasDispatchStart) {
                    looperDispatchListener.dispatchEnd();
                }
            }
        }
    }

    public static LooperMonitor of(@NonNull Looper looper) {
        Map<Looper, LooperMonitor> map = sLooperMonitorMap;
        LooperMonitor looperMonitor = map.get(looper);
        if (looperMonitor != null) {
            return looperMonitor;
        }
        LooperMonitor looperMonitor2 = new LooperMonitor(looper);
        map.put(looper, looperMonitor2);
        return looperMonitor2;
    }

    public static void register(LooperDispatchListener looperDispatchListener) {
        sMainMonitor.addListener(looperDispatchListener);
    }

    private synchronized void removeIdleHandler(Looper looper) {
        if (Build.VERSION.SDK_INT >= 23) {
            looper.getQueue().removeIdleHandler(this);
        } else {
            try {
                ((MessageQueue) ReflectUtils.get(looper.getClass(), "mQueue", looper)).removeIdleHandler(this);
            } catch (Exception e) {
                Log.e(TAG, "[removeIdleHandler] %s", e);
            }
        }
    }

    private synchronized void resetPrinter() {
        Printer printer;
        Exception e;
        Printer printer2 = null;
        try {
        } catch (Exception e2) {
            printer = null;
            e = e2;
        }
        if (!isReflectLoggingError) {
            printer = (Printer) ReflectUtils.get(this.looper.getClass(), "mLogging", this.looper);
            try {
                LooperPrinter looperPrinter = this.printer;
                if (printer == looperPrinter && looperPrinter != null) {
                    return;
                }
                if (printer != null && looperPrinter != null && printer.getClass().getName().equals(this.printer.getClass().getName())) {
                    MatrixLog.w(TAG, "LooperPrinter might be loaded by different classloader, my = " + this.printer.getClass().getClassLoader() + ", other = " + printer.getClass().getClassLoader(), new Object[0]);
                    return;
                }
            } catch (Exception e3) {
                e = e3;
                isReflectLoggingError = true;
                Log.e(TAG, "[resetPrinter] %s", e);
            }
            printer2 = printer;
        }
        if (this.printer != null) {
            MatrixLog.w(TAG, "maybe thread:%s printer[%s] was replace other[%s]!", this.looper.getThread().getName(), this.printer, printer2);
        }
        Looper looper = this.looper;
        LooperPrinter looperPrinter2 = new LooperPrinter(printer2);
        this.printer = looperPrinter2;
        looper.setMessageLogging(looperPrinter2);
        if (printer2 != null) {
            MatrixLog.i(TAG, "reset printer, originPrinter[%s] in %s", printer2, this.looper.getThread().getName());
        }
    }

    public static void unregister(LooperDispatchListener looperDispatchListener) {
        sMainMonitor.removeListener(looperDispatchListener);
    }

    public void addListener(LooperDispatchListener looperDispatchListener) {
        synchronized (this.listeners) {
            this.listeners.add(looperDispatchListener);
        }
    }

    @Deprecated
    public HashSet<LooperDispatchListener> getListeners() {
        return this.listeners;
    }

    public Looper getLooper() {
        return this.looper;
    }

    public synchronized void onRelease() {
        if (this.printer != null) {
            synchronized (this.listeners) {
                this.listeners.clear();
            }
            MatrixLog.v(TAG, "[onRelease] %s, origin printer:%s", this.looper.getThread().getName(), this.printer.origin);
            this.looper.setMessageLogging(this.printer.origin);
            removeIdleHandler(this.looper);
            this.looper = null;
            this.printer = null;
        }
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (SystemClock.uptimeMillis() - this.lastCheckPrinterTime < 60000) {
            return true;
        }
        resetPrinter();
        this.lastCheckPrinterTime = SystemClock.uptimeMillis();
        return true;
    }

    public void removeListener(LooperDispatchListener looperDispatchListener) {
        synchronized (this.listeners) {
            this.listeners.remove(looperDispatchListener);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class LooperDispatchListener {
        boolean isHasDispatchStart = false;

        public boolean isValid() {
            return false;
        }

        @CallSuper
        public void onDispatchEnd(String str) {
            this.isHasDispatchStart = false;
            dispatchEnd();
        }

        @CallSuper
        public void onDispatchStart(String str) {
            this.isHasDispatchStart = true;
            dispatchStart();
        }

        public void dispatchEnd() {
        }

        public void dispatchStart() {
        }
    }
}
