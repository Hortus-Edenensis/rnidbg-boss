package com.tencent.matrix.trace.listeners;

import androidx.annotation.CallSuper;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class IDoFrameListener {
    private static final LinkedList<FrameReplay> sPool = new LinkedList<>();
    private Executor executor;
    private int intervalFrame;
    private final List<FrameReplay> list;
    public long time;

    /* JADX INFO: compiled from: SearchBox */
    public static final class FrameReplay {
        public long animationCostNs;
        public int dropFrame;
        public long endNs;
        public String focusedActivity;
        public long inputCostNs;
        public long intendedFrameTimeNs;
        public boolean isVsyncFrame;
        public long startNs;
        public long traversalCostNs;

        public static FrameReplay create() {
            FrameReplay frameReplay;
            synchronized (IDoFrameListener.sPool) {
                frameReplay = (FrameReplay) IDoFrameListener.sPool.poll();
            }
            return frameReplay == null ? new FrameReplay() : frameReplay;
        }

        public void recycle() {
            if (IDoFrameListener.sPool.size() <= 1000) {
                this.focusedActivity = "";
                this.startNs = 0L;
                this.endNs = 0L;
                this.dropFrame = 0;
                this.isVsyncFrame = false;
                this.intendedFrameTimeNs = 0L;
                this.inputCostNs = 0L;
                this.animationCostNs = 0L;
                this.traversalCostNs = 0L;
                synchronized (IDoFrameListener.sPool) {
                    IDoFrameListener.sPool.add(this);
                }
            }
        }
    }

    public IDoFrameListener() {
        this.intervalFrame = 0;
        this.list = new LinkedList();
        this.intervalFrame = getIntervalFrameReplay();
    }

    @CallSuper
    public void collect(String str, long j, long j2, int i, boolean z, long j3, long j4, long j5, long j6) {
        FrameReplay frameReplayCreate = FrameReplay.create();
        frameReplayCreate.focusedActivity = str;
        frameReplayCreate.startNs = j;
        frameReplayCreate.endNs = j2;
        frameReplayCreate.dropFrame = i;
        frameReplayCreate.isVsyncFrame = z;
        frameReplayCreate.intendedFrameTimeNs = j3;
        frameReplayCreate.inputCostNs = j4;
        frameReplayCreate.animationCostNs = j5;
        frameReplayCreate.traversalCostNs = j6;
        this.list.add(frameReplayCreate);
        if (this.list.size() < this.intervalFrame || getExecutor() == null) {
            return;
        }
        final LinkedList linkedList = new LinkedList(this.list);
        this.list.clear();
        getExecutor().execute(new Runnable() { // from class: com.tencent.matrix.trace.listeners.IDoFrameListener.1
            @Override // java.lang.Runnable
            public void run() {
                IDoFrameListener.this.doReplay(linkedList);
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((FrameReplay) it.next()).recycle();
                }
            }
        });
    }

    @Deprecated
    public void doFrameAsync(String str, long j, long j2, int i, boolean z) {
    }

    @Deprecated
    public void doFrameSync(String str, long j, long j2, int i, boolean z) {
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public int getIntervalFrameReplay() {
        return 0;
    }

    @CallSuper
    public void doFrameAsync(String str, long j, long j2, int i, boolean z, long j3, long j4, long j5, long j6) {
        long j7 = (j2 - j3) / 1000000;
        doFrameAsync(str, j7, j7, i, z);
    }

    @CallSuper
    public void doFrameSync(String str, long j, long j2, int i, boolean z, long j3, long j4, long j5, long j6) {
        long j7 = (j2 - j3) / 1000000;
        doFrameSync(str, j7, j7, i, z);
    }

    public IDoFrameListener(Executor executor) {
        this.intervalFrame = 0;
        this.list = new LinkedList();
        this.executor = executor;
    }

    public void doReplay(List<FrameReplay> list) {
    }
}
