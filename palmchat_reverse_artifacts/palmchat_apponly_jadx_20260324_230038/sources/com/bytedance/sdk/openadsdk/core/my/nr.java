package com.bytedance.sdk.openadsdk.core.my;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class nr {
    private static volatile long nr;
    private static volatile boolean u;
    private Handler b;
    private final Queue<u> fx = new LinkedList();

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private final String nr;
        private final long u;

        private u(long j, String str) {
            this.u = j;
            this.nr = str;
        }
    }

    private synchronized boolean nr(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iNr = nr();
        long jFx = fx();
        if (this.fx.size() <= 0 || this.fx.size() < iNr) {
            this.fx.offer(new u(jCurrentTimeMillis, str));
        } else {
            long jAbs = Math.abs(jCurrentTimeMillis - this.fx.peek().u);
            if (jAbs <= jFx) {
                nr(jFx - jAbs);
                return true;
            }
            this.fx.poll();
            this.fx.offer(new u(jCurrentTimeMillis, str));
        }
        return false;
    }

    public boolean b() {
        return u;
    }

    public abstract long fx();

    public abstract int nr();

    public synchronized String pn() {
        String str;
        HashMap map = new HashMap();
        for (u uVar : this.fx) {
            if (map.containsKey(uVar.nr)) {
                map.put(uVar.nr, Integer.valueOf(((Integer) map.get(uVar.nr)).intValue() + 1));
            } else {
                map.put(uVar.nr, 1);
            }
        }
        str = "";
        int i = Integer.MIN_VALUE;
        for (String str2 : map.keySet()) {
            int iIntValue = ((Integer) map.get(str2)).intValue();
            if (i < iIntValue) {
                str = str2;
                i = iIntValue;
            }
        }
        return str;
    }

    public synchronized boolean u(String str) {
        if (nr(str)) {
            u(true);
            u(nr);
        } else {
            u(false);
        }
        return u;
    }

    private void u(long j) {
        if (this.b == null) {
            this.b = new Handler(Looper.getMainLooper());
        }
        this.b.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.my.nr.1
            @Override // java.lang.Runnable
            public void run() {
                nr.this.u(false);
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(boolean z) {
        u = z;
    }

    private synchronized void nr(long j) {
        nr = j;
    }
}
