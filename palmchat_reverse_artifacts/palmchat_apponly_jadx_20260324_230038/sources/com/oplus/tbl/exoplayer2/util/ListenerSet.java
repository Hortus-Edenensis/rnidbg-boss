package com.oplus.tbl.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.util.ListenerSet;
import com.oplus.tbl.exoplayer2.util.MutableFlags;
import defpackage.qo5;
import java.util.ArrayDeque;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ListenerSet<T, E extends MutableFlags> {
    private static final int MSG_ITERATION_FINISHED = 0;
    private static final int MSG_LAZY_RELEASE = 1;
    private static String TAG = "ListenerSet";
    private final Clock clock;
    private final qo5<E> eventFlagsSupplier;
    private final ArrayDeque<Runnable> flushingEvents;
    private final HandlerWrapper handler;
    private final IterationFinishedEvent<T, E> iterationFinishedEvent;
    private final CopyOnWriteArraySet<ListenerHolder<T, E>> listeners;
    private final ArrayDeque<Runnable> queuedEvents;
    private boolean released;

    /* JADX INFO: compiled from: SearchBox */
    public interface Event<T> {
        void invoke(T t);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface IterationFinishedEvent<T, E extends MutableFlags> {
        void invoke(T t, E e);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class ListenerHolder<T, E extends MutableFlags> {
        private E eventsFlags;
        public final T listener;
        private boolean needsIterationFinishedEvent;
        private boolean released;

        public ListenerHolder(T t, qo5<E> qo5Var) {
            this.listener = t;
            this.eventsFlags = qo5Var.get();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ListenerHolder.class != obj.getClass()) {
                return false;
            }
            return this.listener.equals(((ListenerHolder) obj).listener);
        }

        public int hashCode() {
            return this.listener.hashCode();
        }

        public void invoke(int i, Event<T> event) {
            if (this.released) {
                return;
            }
            if (i != -1) {
                this.eventsFlags.add(i);
            }
            this.needsIterationFinishedEvent = true;
            event.invoke(this.listener);
        }

        public void iterationFinished(qo5<E> qo5Var, IterationFinishedEvent<T, E> iterationFinishedEvent) {
            if (this.released || !this.needsIterationFinishedEvent) {
                return;
            }
            E e = this.eventsFlags;
            this.eventsFlags = qo5Var.get();
            this.needsIterationFinishedEvent = false;
            iterationFinishedEvent.invoke(this.listener, e);
        }

        public void release(IterationFinishedEvent<T, E> iterationFinishedEvent) {
            this.released = true;
            if (this.needsIterationFinishedEvent) {
                iterationFinishedEvent.invoke(this.listener, this.eventsFlags);
            }
        }
    }

    public ListenerSet(Looper looper, Clock clock, qo5<E> qo5Var, IterationFinishedEvent<T, E> iterationFinishedEvent) {
        this(new CopyOnWriteArraySet(), looper, clock, qo5Var, iterationFinishedEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            Iterator<ListenerHolder<T, E>> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().iterationFinished(this.eventFlagsSupplier, this.iterationFinishedEvent);
                if (this.handler.hasMessages(0)) {
                    break;
                }
            }
        } else if (i == 1) {
            sendEvent(message.arg1, (Event) message.obj);
            release();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$queueEvent$0(CopyOnWriteArraySet copyOnWriteArraySet, int i, Event event) {
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((ListenerHolder) it.next()).invoke(i, event);
        }
    }

    public void add(T t) {
        if (this.released) {
            return;
        }
        Assertions.checkNotNull(t);
        this.listeners.add(new ListenerHolder<>(t, this.eventFlagsSupplier));
    }

    @CheckResult
    public ListenerSet<T, E> copy(Looper looper, IterationFinishedEvent<T, E> iterationFinishedEvent) {
        return new ListenerSet<>(this.listeners, looper, this.clock, this.eventFlagsSupplier, iterationFinishedEvent);
    }

    public void flushEvents() {
        String str;
        StringBuilder sb;
        String str2;
        String str3;
        StringBuilder sb2;
        String str4;
        if (this.queuedEvents.isEmpty()) {
            return;
        }
        if (!this.handler.hasMessages(0)) {
            this.handler.obtainMessage(0).sendToTarget();
        }
        boolean z = !this.flushingEvents.isEmpty();
        try {
            this.flushingEvents.addAll(this.queuedEvents);
        } catch (NullPointerException e) {
            e = e;
            str = TAG;
            sb = new StringBuilder();
            str2 = "Multi-Thread called when add flush events , may cause player null pointer exception: ";
            sb.append(str2);
            sb.append(e.getMessage());
            Log.e(str, sb.toString());
        } catch (ConcurrentModificationException e2) {
            e = e2;
            str = TAG;
            sb = new StringBuilder();
            str2 = "Multi-Thread called when add flush events , may cause player concurrent modification exception: ";
            sb.append(str2);
            sb.append(e.getMessage());
            Log.e(str, sb.toString());
        }
        this.queuedEvents.clear();
        if (z) {
            return;
        }
        while (!this.flushingEvents.isEmpty()) {
            try {
                this.flushingEvents.peekFirst().run();
            } catch (NullPointerException e3) {
                e = e3;
                str3 = TAG;
                sb2 = new StringBuilder();
                str4 = "Multi-Thread called when peek flush events , may cause player null pointer exception: ";
                sb2.append(str4);
                sb2.append(e.getMessage());
                Log.e(str3, sb2.toString());
            } catch (NoSuchElementException e4) {
                e = e4;
                str3 = TAG;
                sb2 = new StringBuilder();
                str4 = "Multi-Thread called when peek flush events , may cause player no such element exception: ";
                sb2.append(str4);
                sb2.append(e.getMessage());
                Log.e(str3, sb2.toString());
            }
            try {
                this.flushingEvents.removeFirst();
            } catch (NoSuchElementException e5) {
                Log.e(TAG, "Multi-Thread called when remove flush events , may cause player no such element exception: " + e5.getMessage());
            }
        }
    }

    public void lazyRelease(int i, Event<T> event) {
        this.handler.obtainMessage(1, i, 0, event).sendToTarget();
    }

    public void queueEvent(final int i, final Event<T> event) {
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.listeners);
        this.queuedEvents.add(new Runnable() { // from class: x33
            @Override // java.lang.Runnable
            public final void run() {
                ListenerSet.lambda$queueEvent$0(copyOnWriteArraySet, i, event);
            }
        });
    }

    public void release() {
        Iterator<ListenerHolder<T, E>> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().release(this.iterationFinishedEvent);
        }
        this.listeners.clear();
        this.released = true;
    }

    public void remove(T t) {
        for (ListenerHolder<T, E> listenerHolder : this.listeners) {
            if (listenerHolder.listener.equals(t)) {
                listenerHolder.release(this.iterationFinishedEvent);
                this.listeners.remove(listenerHolder);
            }
        }
    }

    public void sendEvent(int i, Event<T> event) {
        queueEvent(i, event);
        flushEvents();
    }

    private ListenerSet(CopyOnWriteArraySet<ListenerHolder<T, E>> copyOnWriteArraySet, Looper looper, Clock clock, qo5<E> qo5Var, IterationFinishedEvent<T, E> iterationFinishedEvent) {
        this.clock = clock;
        this.listeners = copyOnWriteArraySet;
        this.eventFlagsSupplier = qo5Var;
        this.iterationFinishedEvent = iterationFinishedEvent;
        this.flushingEvents = new ArrayDeque<>();
        this.queuedEvents = new ArrayDeque<>();
        this.handler = clock.createHandler(looper, new Handler.Callback() { // from class: u33
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f21119a.handleMessage(message);
            }
        });
    }
}
