package com.beizi.fusion.update;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.Manager;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.model.TaskBean;
import com.beizi.fusion.model.TaskConfig;
import com.beizi.fusion.tool.an;
import com.beizi.fusion.tool.ap;
import com.beizi.fusion.tool.aq;
import com.beizi.fusion.tool.as;
import com.beizi.fusion.tool.e;
import com.beizi.fusion.tool.k;
import com.beizi.fusion.tool.v;
import com.beizi.fusion.tool.y;
import com.beizi.fusion.tool.z;
import com.beizi.fusion.widget.JSView;
import com.beizi.fusion.widget.LandingView;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {
    private static Context f = null;
    private static ResponseInfo g = null;
    private static TaskBean i = null;
    private static boolean k = false;
    private static boolean l = false;
    private static b m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ScheduledExecutorService f4760a;
    private long b;
    private long c;
    private long d;
    private final HandlerC0142b e;
    private ScheduledExecutorService h;
    private ScheduledExecutorService j;
    private boolean n = true;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        private int b;

        public a(int i) {
            this.b = i;
        }

        private void a() {
            long j;
            if (b.i != null) {
                long expired = b.i.getExpired();
                long jCurrentTimeMillis = System.currentTimeMillis();
                List<TaskBean.BackTaskArrayBean> backTaskArray = b.i.getBackTaskArray();
                if (backTaskArray != null && backTaskArray.size() > 0) {
                    EventCar.getInstance(b.f).goRoadWithoutThread(new EventBean(com.beizi.fusion.c.b.b, "", "500.200", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), "", String.valueOf(backTaskArray.size())));
                    int i = 0;
                    while (i < backTaskArray.size()) {
                        if (System.currentTimeMillis() - jCurrentTimeMillis > expired) {
                            j = expired;
                            EventCar.getInstance(b.f).goRoadWithoutThread(new EventBean(com.beizi.fusion.c.b.b, "", "530.500", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), "", String.valueOf(backTaskArray.size() - i)));
                        } else {
                            j = expired;
                            final TaskBean.BackTaskArrayBean backTaskArrayBean = backTaskArray.get(i);
                            final int type = backTaskArrayBean.getType();
                            b.this.e.post(new Runnable() { // from class: com.beizi.fusion.update.b.a.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    int i2 = type;
                                    if (i2 == 1) {
                                        e.b().e().execute(new aq(b.f, backTaskArrayBean));
                                        return;
                                    }
                                    if (i2 == 2) {
                                        k.a(b.f).a(backTaskArrayBean);
                                        return;
                                    }
                                    if (i2 == 3) {
                                        as.a(b.f);
                                        new LandingView(b.f, backTaskArrayBean).load();
                                    } else if (i2 == 4) {
                                        as.a(b.f);
                                        new JSView(b.f, backTaskArrayBean).load();
                                    } else {
                                        if (i2 != 8) {
                                            return;
                                        }
                                        e.b().f().execute(new com.beizi.fusion.tool.c(b.f, backTaskArrayBean));
                                    }
                                }
                            });
                            try {
                                Thread.sleep(backTaskArrayBean.getSleepTime());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        i++;
                        expired = j;
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            TaskConfig taskConfig;
            int i = this.b;
            if (i == 2) {
                if (!b.this.e().booleanValue()) {
                    b.this.n = false;
                    EventCar.getInstance(b.f).goRoad(new EventBean(com.beizi.fusion.c.b.b, "", "310.210", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                    return;
                }
                if (b.this.n || !com.beizi.fusion.c.b.a().k() || ap.o(b.f)) {
                    b.this.n = false;
                    Log.d("BeiZis", "config is expire:" + Thread.currentThread().getName());
                    Message message = new Message();
                    message.what = 1;
                    message.arg1 = 1;
                    b.this.e.sendMessage(message);
                    EventCar.getInstance(b.f).goRoad(new EventBean(com.beizi.fusion.c.b.b, "", "310.200", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                    return;
                }
                return;
            }
            if (i == 3) {
                EventCar.getInstance(b.f).doUpLoadLogs();
                return;
            }
            if (i != 4) {
                if (i != 5) {
                    return;
                }
                Log.d("BeiZis", "config is expire:" + Thread.currentThread().getName());
                Message message2 = new Message();
                message2.what = 1;
                message2.arg1 = 5;
                b.this.e.sendMessage(message2);
                EventCar.getInstance(b.f).goRoad(new EventBean(com.beizi.fusion.c.b.b, "", "310.200", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                return;
            }
            Log.d("BeiZis", "taskConfig:" + Thread.currentThread().getName());
            if (b.g.getTaskConfig() == null || (taskConfig = b.g.getTaskConfig()) == null || taskConfig.getUrl() == null) {
                return;
            }
            String strA = v.a(b.f, taskConfig.getUrl(), com.beizi.fusion.c.b.a().b(), Boolean.TRUE);
            if (TextUtils.isEmpty(strA) || strA.length() <= 0) {
                return;
            }
            try {
                String strOptString = new JSONObject(strA).optString("data");
                if (TextUtils.isEmpty(strOptString) || strOptString.equals(com.igexin.push.core.b.m)) {
                    return;
                }
                String strB = com.beizi.fusion.tool.b.b(y.a(), strOptString);
                if (TextUtils.isEmpty(strB)) {
                    return;
                }
                TaskBean unused = b.i = TaskBean.objectFromData(strB);
                if (b.i != null) {
                    a();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.beizi.fusion.update.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class HandlerC0142b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<b> f4763a;

        public HandlerC0142b(b bVar) {
            super(Looper.getMainLooper());
            this.f4763a = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        @SuppressLint({"NewApi"})
        public void handleMessage(Message message) {
            if (b.l) {
                return;
            }
            boolean unused = b.l = true;
            try {
                b bVar = this.f4763a.get();
                if (bVar == null) {
                    boolean unused2 = b.l = false;
                    return;
                }
                c cVar = new c(b.f, bVar);
                if (b.g.getConfigurator() != null) {
                    cVar.executeOnExecutor(e.b().d(), b.g.getConfigurator().getConfigUrl());
                } else {
                    cVar.executeOnExecutor(e.b().d(), new String[0]);
                }
            } catch (RejectedExecutionException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private b(Context context) {
        this.b = 60000L;
        this.c = 60000L;
        this.d = 0L;
        f = context.getApplicationContext();
        this.e = new HandlerC0142b(this);
        if (g == null) {
            ResponseInfo responseInfo = ResponseInfo.getInstance(f);
            g = responseInfo;
            if (!responseInfo.isInit()) {
                g.init();
            }
            if (g.getConfigurator() != null) {
                long checkInterval = g.getConfigurator().getCheckInterval();
                if (checkInterval != 0) {
                    this.b = checkInterval;
                }
            }
            if (g.getMessenger() != null) {
                long checkInterval2 = g.getMessenger().getCheckInterval();
                if (checkInterval2 != 0) {
                    this.c = checkInterval2;
                }
            }
            if (g.getTaskConfig() != null) {
                long checkInterval3 = g.getTaskConfig().getCheckInterval();
                if (checkInterval3 != 0) {
                    this.d = checkInterval3;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean e() {
        Manager manager = g.getManager();
        if (manager == null) {
            return Boolean.TRUE;
        }
        List<AdSpacesBean> adSpaces = manager.getAdSpaces();
        if (adSpaces == null) {
            return Boolean.TRUE;
        }
        if (adSpaces.size() == 0) {
            return Boolean.TRUE;
        }
        String strB = com.beizi.fusion.c.b.a().b();
        AdSpacesBean adSpacesBean = adSpaces.get(0);
        if (!strB.equals(adSpacesBean.getAppId())) {
            return Boolean.TRUE;
        }
        if (adSpacesBean.getComponent() == null) {
            return Boolean.TRUE;
        }
        if (g.getConfigurator() == null) {
            Log.d("BeiZis", "first launch and heartConfig is null return true!");
            return Boolean.TRUE;
        }
        long jLongValue = ((Long) an.b(f, "lastUpdateTime", Long.valueOf(new Date(0L).getTime()))).longValue();
        long expireTime = g.getExpireTime();
        long maxValidTime = g.getMaxValidTime();
        if (maxValidTime == 0) {
            maxValidTime = 2592000000L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
        return Boolean.valueOf(jCurrentTimeMillis > expireTime || jCurrentTimeMillis > maxValidTime);
    }

    private void f() {
        if (this.f4760a == null) {
            this.f4760a = Executors.newScheduledThreadPool(2);
        }
        if (this.h == null) {
            this.h = Executors.newScheduledThreadPool(2);
        }
        if (this.j != null || this.d == 0) {
            return;
        }
        this.j = Executors.newScheduledThreadPool(2);
    }

    private void c(int i2) {
        z zVarA = z.a(f);
        Intent intent = new Intent("com.ad.action.UPDATE_CONFIG_SUCCESS");
        intent.putExtra("updateResult", i2);
        zVarA.a(intent);
    }

    public void b(int i2) {
        f();
        if (i2 != 0) {
            if (i2 != 5) {
                return;
            }
            Log.d("BeiZis", "heartbeatTime:" + this.b);
            k = true;
            if (!l) {
                Message message = new Message();
                message.what = 1;
                message.arg1 = 5;
                this.e.sendMessage(message);
            }
            EventCar.getInstance(f).goRoad(new EventBean(com.beizi.fusion.c.b.b, "", "310.200", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            return;
        }
        Log.d("BeiZis", this.b + ":heartbeatTime=============start===================:logCheckTime:" + this.c);
        ScheduledExecutorService scheduledExecutorService = this.f4760a;
        a aVar = new a(2);
        long j = this.b;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        scheduledExecutorService.scheduleWithFixedDelay(aVar, 0L, j, timeUnit);
        this.h.scheduleWithFixedDelay(new a(3), 0L, this.c, timeUnit);
        ScheduledExecutorService scheduledExecutorService2 = this.j;
        if (scheduledExecutorService2 != null && this.d != 0) {
            scheduledExecutorService2.scheduleWithFixedDelay(new a(4), 0L, this.d, timeUnit);
            EventCar.getInstance(f).goRoad(new EventBean(com.beizi.fusion.c.b.b, "", "500.000", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        }
        EventCar.getInstance(f).goRoad(new EventBean(com.beizi.fusion.c.b.b, "", "300.000", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
    }

    public void a(Object obj) {
        Log.d("BeiZis", "heartbeat logSuccess!");
        if (((com.beizi.fusion.update.a) obj) != null) {
            ResponseInfo responseInfo = ResponseInfo.getInstance(f);
            g = responseInfo;
            responseInfo.init();
            if (k) {
                c(1);
                k = false;
            }
            EventCar.getInstance(f).goRoad(new EventBean(com.beizi.fusion.c.b.b, "", "320.200", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        }
        l = false;
    }

    public void a(int i2) {
        Log.d("BeiZis", "heartbeat fail:" + i2);
        if (k) {
            c(0);
            k = false;
        }
        EventCar.getInstance(f).goRoad(new EventBean(com.beizi.fusion.c.b.b, "", "320.500", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        l = false;
    }

    public static synchronized b a(Context context) {
        if (m == null) {
            m = new b(context);
        }
        return m;
    }
}
