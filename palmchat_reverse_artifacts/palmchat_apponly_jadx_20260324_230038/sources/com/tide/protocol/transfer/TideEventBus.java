package com.tide.protocol.transfer;

import android.os.Build;
import com.tide.protocol.host.model.PluginEvent;
import com.tide.protocol.transfer.TideEventBus;
import com.tide.protocol.util.TdLogUtils;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.ConcurrentMap;
import j$.util.function.Consumer$CC;
import j$.util.function.Function$CC;
import j$.util.function.Predicate$CC;
import java.lang.Thread;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TideEventBus {
    private static final int corePoolSize;
    private static final ThreadPoolExecutor defaultExecutor;
    private static final long keepAliveTime = 30;
    private static final ConcurrentHashMap<Class<?>, CopyOnWriteArrayList<EventListener<?>>> listeners;
    private static final int maximumPoolSize;
    private static final ThreadPoolExecutor systemExecutor;
    private static final TimeUnit unit;

    /* JADX INFO: compiled from: SearchBox */
    public interface EventListener<T> {
        void onEvent(T t);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class TideThreadFactory implements ThreadFactory {
        private final ThreadFactory defaultFactory;

        private TideThreadFactory() {
            this.defaultFactory = Executors.defaultThreadFactory();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = this.defaultFactory.newThread(runnable);
            threadNewThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.tide.protocol.transfer.TideEventBus.TideThreadFactory.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    TdLogUtils.error("Uncaught exception in thread: " + thread.getName() + " error: " + th.getMessage());
                    th.printStackTrace();
                }
            });
            return threadNewThread;
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        corePoolSize = iAvailableProcessors;
        int i = (iAvailableProcessors * 2) + 1;
        maximumPoolSize = i;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        unit = timeUnit;
        defaultExecutor = new ThreadPoolExecutor(iAvailableProcessors, i, keepAliveTime, timeUnit, new LinkedBlockingQueue(), new TideThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        systemExecutor = new ThreadPoolExecutor(iAvailableProcessors, i, keepAliveTime, timeUnit, new LinkedBlockingQueue(), new TideThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        listeners = new ConcurrentHashMap<>();
    }

    private static <T> boolean isSystemEvent(T t) {
        return t instanceof PluginEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$publish$3(ThreadPoolExecutor threadPoolExecutor, final Object obj, final EventListener eventListener) {
        threadPoolExecutor.submit(new Runnable() { // from class: ix5
            @Override // java.lang.Runnable
            public final void run() {
                eventListener.onEvent(obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CopyOnWriteArrayList lambda$subscribe$0(Class cls) {
        return new CopyOnWriteArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$unsubscribe$1(EventListener eventListener, EventListener eventListener2) {
        return eventListener2 == null || eventListener2.equals(eventListener);
    }

    public static <T> void publish(final T t) {
        try {
            CopyOnWriteArrayList<EventListener<?>> copyOnWriteArrayList = listeners.get(t.getClass());
            final ThreadPoolExecutor threadPoolExecutor = isSystemEvent(t) ? systemExecutor : defaultExecutor;
            if (copyOnWriteArrayList != null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    Iterable.EL.forEach(copyOnWriteArrayList, new Consumer() { // from class: lx5
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            TideEventBus.lambda$publish$3(threadPoolExecutor, t, (TideEventBus.EventListener) obj);
                        }

                        public /* synthetic */ Consumer andThen(Consumer consumer) {
                            return Consumer$CC.$default$andThen(this, consumer);
                        }
                    });
                    return;
                }
                for (final EventListener<?> eventListener : copyOnWriteArrayList) {
                    threadPoolExecutor.submit(new Runnable() { // from class: com.tide.protocol.transfer.TideEventBus.1
                        @Override // java.lang.Runnable
                        public void run() {
                            eventListener.onEvent(t);
                        }
                    });
                }
            }
        } catch (Throwable th) {
            TdLogUtils.error("TideEventBus publish error " + th.getMessage());
        }
    }

    public static <T> void subscribe(Class<T> cls, EventListener<T> eventListener) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                ((CopyOnWriteArrayList) ConcurrentMap.EL.computeIfAbsent(listeners, cls, new Function() { // from class: jx5
                    @Override // java.util.function.Function
                    public /* synthetic */ Function andThen(Function function) {
                        return Function$CC.$default$andThen(this, function);
                    }

                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return TideEventBus.lambda$subscribe$0((Class) obj);
                    }

                    public /* synthetic */ Function compose(Function function) {
                        return Function$CC.$default$compose(this, function);
                    }
                })).add(eventListener);
                return;
            }
            ConcurrentHashMap<Class<?>, CopyOnWriteArrayList<EventListener<?>>> concurrentHashMap = listeners;
            CopyOnWriteArrayList<EventListener<?>> copyOnWriteArrayList = concurrentHashMap.get(cls);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                concurrentHashMap.put(cls, copyOnWriteArrayList);
            }
            copyOnWriteArrayList.add(eventListener);
        } catch (Throwable th) {
            TdLogUtils.error("TideEventBus subscribe error " + th.getMessage());
        }
    }

    public static <T> void unsubscribe(Class<T> cls, final EventListener<T> eventListener) {
        try {
            CopyOnWriteArrayList<EventListener<?>> copyOnWriteArrayList = listeners.get(cls);
            if (copyOnWriteArrayList != null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    Collection.EL.removeIf(copyOnWriteArrayList, new Predicate() { // from class: kx5
                        public /* synthetic */ Predicate and(Predicate predicate) {
                            return Predicate$CC.$default$and(this, predicate);
                        }

                        public /* synthetic */ Predicate negate() {
                            return Predicate$CC.$default$negate(this);
                        }

                        public /* synthetic */ Predicate or(Predicate predicate) {
                            return Predicate$CC.$default$or(this, predicate);
                        }

                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return TideEventBus.lambda$unsubscribe$1(eventListener, (TideEventBus.EventListener) obj);
                        }
                    });
                    return;
                }
                Iterator<EventListener<?>> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    EventListener<?> next = it.next();
                    if (next == null || next.equals(eventListener)) {
                        it.remove();
                    }
                }
            }
        } catch (Throwable th) {
            TdLogUtils.error("TideEventBus unsubscribe error " + th.getMessage());
        }
    }

    public static <T> void unsubscribeAll(Class<T> cls) {
        listeners.remove(cls);
    }
}
