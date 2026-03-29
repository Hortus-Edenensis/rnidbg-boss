package com.bykv.vk.openvk.component.video.u.nr.iz;

import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.fx.iz;
import com.bykv.vk.openvk.component.video.api.iz.fx;
import com.bykv.vk.openvk.component.video.u.nr.b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u {
    public static final boolean u = fx.nr();
    private C0158u fx;
    private HashMap<String, Boolean> nr;

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        private static final u u = new u();
    }

    private static com.bykv.vk.openvk.component.video.u.nr.u.fx fx() {
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.nr.nr(com.bykv.vk.openvk.component.video.api.fx.getContext()), "proxy_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            com.bykv.vk.openvk.component.video.u.nr.u.fx fxVar = new com.bykv.vk.openvk.component.video.u.nr.u.fx(file);
            try {
                fxVar.u(104857600L);
                return fxVar;
            } catch (IOException unused) {
                return fxVar;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    public static u u() {
        return nr.u;
    }

    public boolean nr() {
        if (this.fx != null) {
            return true;
        }
        com.bykv.vk.openvk.component.video.u.nr.u.fx fxVarFx = fx();
        if (fxVarFx == null) {
            return false;
        }
        b.u(true);
        b.u(1);
        try {
            C0158u c0158u = new C0158u();
            this.fx = c0158u;
            c0158u.setName("csj_video_cache_preloader");
            this.fx.start();
            b.u(fxVarFx, com.bykv.vk.openvk.component.video.api.fx.getContext());
            com.bykv.vk.openvk.component.video.u.nr.fx.u();
            com.bykv.vk.openvk.component.video.u.nr.fx.u().u(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private u() {
        this.nr = new HashMap<>();
        nr();
    }

    public boolean u(iz izVar) {
        if (!nr()) {
            return false;
        }
        this.fx.u(izVar);
        return true;
    }

    /* JADX INFO: renamed from: com.bykv.vk.openvk.component.video.u.nr.iz.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0158u extends com.bytedance.sdk.component.jk.b.fx {
        private final Queue<C0159u> b;
        private boolean fx;
        private Queue<C0159u> nr;
        private Queue<C0159u> pn;

        /* JADX INFO: renamed from: com.bykv.vk.openvk.component.video.u.nr.iz.u$u$u, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0159u {
            public int b;
            public String[] fx;
            public iz iz;
            public String nr;
            public String pn;
            public int u;

            public C0159u() {
            }
        }

        public C0158u() {
            super("VideoCachePreloader$PreLoadThread");
            this.b = new ArrayBlockingQueue(10);
            this.nr = new LinkedBlockingQueue();
            this.fx = true;
            this.pn = new LinkedBlockingQueue();
        }

        private void fx(C0159u c0159u) {
            if (c0159u == null) {
                return;
            }
            this.nr.offer(c0159u);
            notify();
        }

        private synchronized void nr(C0159u c0159u) {
            this.pn.add(c0159u);
            notify();
        }

        private C0159u u(int i, iz izVar) {
            this.b.size();
            C0159u c0159uPoll = this.b.poll();
            if (c0159uPoll == null) {
                c0159uPoll = new C0159u();
            }
            c0159uPoll.u = i;
            c0159uPoll.iz = izVar;
            return c0159uPoll;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.fx) {
                synchronized (this) {
                    if (!this.pn.isEmpty()) {
                        u();
                    }
                    while (!this.nr.isEmpty()) {
                        C0159u c0159uPoll = this.nr.poll();
                        if (c0159uPoll != null) {
                            int i = c0159uPoll.u;
                            if (i == 0) {
                                String[] strArr = c0159uPoll.fx;
                                if (strArr != null && strArr.length > 0) {
                                    ArrayList arrayList = new ArrayList();
                                    for (String str : c0159uPoll.fx) {
                                        if (com.bykv.vk.openvk.component.video.u.fx.u.u(str)) {
                                            arrayList.add(str);
                                        }
                                    }
                                    com.bykv.vk.openvk.component.video.u.nr.fx.u().u(false, !TextUtils.isEmpty(c0159uPoll.pn), c0159uPoll.b, c0159uPoll.nr, (String[]) arrayList.toArray(new String[arrayList.size()]));
                                }
                            } else if (i == 1) {
                                com.bykv.vk.openvk.component.video.u.nr.fx.u().u(c0159uPoll.nr);
                            } else if (i == 2) {
                                com.bykv.vk.openvk.component.video.u.nr.fx.u().nr();
                            } else if (i == 3) {
                                com.bykv.vk.openvk.component.video.u.nr.fx.u().nr();
                                if (b.nr() != null) {
                                    b.nr().u();
                                }
                                if (b.u() != null) {
                                    b.u().u();
                                }
                            } else if (i == 4) {
                                com.bykv.vk.openvk.component.video.u.nr.fx.u().nr();
                                this.fx = false;
                            }
                            u(c0159uPoll);
                        }
                    }
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }

        private void u(C0159u c0159u) {
            c0159u.fx = null;
            c0159u.nr = null;
            c0159u.u = -1;
            c0159u.iz = null;
            this.b.offer(c0159u);
        }

        private void u() {
            while (true) {
                C0159u c0159uPoll = this.pn.poll();
                if (c0159uPoll == null) {
                    return;
                }
                c0159uPoll.nr = c0159uPoll.iz.my();
                c0159uPoll.fx = new String[]{c0159uPoll.iz.my()};
                int iNr = c0159uPoll.iz.nr();
                if (iNr <= 0) {
                    iNr = c0159uPoll.iz.iz();
                }
                c0159uPoll.b = iNr;
                c0159uPoll.pn = c0159uPoll.iz.o();
                if (!TextUtils.isEmpty(c0159uPoll.iz.o())) {
                    c0159uPoll.nr = c0159uPoll.iz.o();
                }
                c0159uPoll.iz = null;
                fx(c0159uPoll);
            }
        }

        public void u(iz izVar) {
            nr(u(0, izVar));
        }
    }
}
