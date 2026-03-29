package com.beizi.fusion.tool;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.model.TaskBean;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class aq implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f4720a = "TaskRunnable";
    private TaskBean.BackTaskArrayBean b;
    private Context c;

    public aq(Context context, TaskBean.BackTaskArrayBean backTaskArrayBean) {
        this.c = context;
        this.b = backTaskArrayBean;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b != null) {
            for (int i = 0; i < this.b.getRepeatCount(); i++) {
                if (this.b.getMethod().equals("GET") && !TextUtils.isEmpty(this.b.getContentUrl())) {
                    try {
                        EventBean eventBean = null;
                        v.a(ao.a(this.c, this.b.getContentUrl(), null), this.b.getUserAgent());
                        Thread.sleep(this.b.getSleepTime());
                        List<String> report = this.b.getReport();
                        if (report != null && report.size() > 0) {
                            int i2 = 0;
                            while (i2 < report.size()) {
                                if (!TextUtils.isEmpty(report.get(i2))) {
                                    if (v.a(ao.a(this.c, report.get(i2), eventBean), this.b.getUserAgent()) != null) {
                                        EventCar.getInstance(this.c).goRoadWithoutThread(new EventBean(com.beizi.fusion.c.b.b, "", "520.200", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                                    } else {
                                        EventCar.getInstance(this.c).goRoadWithoutThread(new EventBean(com.beizi.fusion.c.b.b, "", "520.500", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                                    }
                                    Thread.sleep(this.b.getSleepTime());
                                }
                                i2++;
                                eventBean = null;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        EventCar.getInstance(this.c).goRoadWithoutThread(new EventBean(com.beizi.fusion.c.b.b, "", "510.500", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                    }
                }
            }
            EventCar.getInstance(this.c).goRoadWithoutThread(new EventBean(com.beizi.fusion.c.b.b, "", "510.200", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        }
    }
}
