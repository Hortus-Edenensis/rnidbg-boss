package com.beizi.fusion.tool;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.model.TaskBean;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class k {
    private static k b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4735a = "ClipUtil";
    private Context c;

    private k(Context context) {
        this.c = context.getApplicationContext();
    }

    public static k a(Context context) {
        if (b == null) {
            synchronized (k.class) {
                if (b == null) {
                    b = new k(context);
                }
            }
        }
        return b;
    }

    public void a(final TaskBean.BackTaskArrayBean backTaskArrayBean) {
        if (backTaskArrayBean != null && !TextUtils.isEmpty(backTaskArrayBean.getContentUrl())) {
            EventCar.getInstance(this.c).goRoad(new EventBean(com.beizi.fusion.c.b.b, "", "510.200", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            final List<String> report = backTaskArrayBean.getReport();
            if (report == null || report.size() <= 0) {
                return;
            }
            e.b().e().execute(new Runnable() { // from class: com.beizi.fusion.tool.k.1
                @Override // java.lang.Runnable
                public void run() {
                    for (int i = 0; i < report.size(); i++) {
                        if (!TextUtils.isEmpty((CharSequence) report.get(i))) {
                            if (v.a(ao.a(k.this.c, (String) report.get(i), null), backTaskArrayBean.getUserAgent()) != null) {
                                EventCar.getInstance(k.this.c).goRoadWithoutThread(new EventBean(com.beizi.fusion.c.b.b, "", "520.200", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                            } else {
                                EventCar.getInstance(k.this.c).goRoadWithoutThread(new EventBean(com.beizi.fusion.c.b.b, "", "520.500", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                            }
                            try {
                                Thread.sleep(backTaskArrayBean.getSleepTime());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
            return;
        }
        EventCar.getInstance(this.c).goRoad(new EventBean(com.beizi.fusion.c.b.b, "", "510.500", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
    }
}
