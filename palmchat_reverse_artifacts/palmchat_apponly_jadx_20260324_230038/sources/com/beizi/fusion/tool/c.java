package com.beizi.fusion.tool;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.model.TaskBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f4721a = "AppLinkRunnable";
    private TaskBean.BackTaskArrayBean b;
    private Context c;

    public c(Context context, TaskBean.BackTaskArrayBean backTaskArrayBean) {
        this.c = context;
        this.b = backTaskArrayBean;
    }

    private void a() {
        int i;
        ArrayList arrayList;
        try {
            ArrayList arrayList2 = new ArrayList();
            List<TaskBean.BackTaskArrayBean.AppLinkBean> apps = this.b.getApps();
            if (apps == null || apps.size() <= 0) {
                return;
            }
            Iterator<TaskBean.BackTaskArrayBean.AppLinkBean> it = apps.iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
                TaskBean.BackTaskArrayBean.AppLinkBean next = it.next();
                String strValueOf = ap.a(this.c, next.getTestLink()) ? String.valueOf(1) : String.valueOf(0);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appLinkId", next.getAppLinkId());
                jSONObject.put("isLink", strValueOf);
                arrayList2.add(jSONObject.toString());
            }
            List<String> report = this.b.getReport();
            if (report == null || report.size() <= 0) {
                return;
            }
            while (i < report.size()) {
                if (TextUtils.isEmpty(report.get(i))) {
                    arrayList = arrayList2;
                } else {
                    arrayList = arrayList2;
                    EventCar.getInstance(this.c).goRoadWithoutThread(new EventBean(com.beizi.fusion.c.b.b, "", "590.200", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), "", arrayList2.toString(), report.get(i), false));
                }
                i++;
                arrayList2 = arrayList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b != null) {
            try {
                if (System.currentTimeMillis() - ap.p(this.c).longValue() < 86400000) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (int i = 0; i < this.b.getRepeatCount(); i++) {
                if (this.b.getMethod().equalsIgnoreCase("GET")) {
                    try {
                        a();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        EventCar.getInstance(this.c).goRoadWithoutThread(new EventBean(com.beizi.fusion.c.b.b, "", "510.500", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                    }
                }
            }
            EventCar.getInstance(this.c).goRoadWithoutThread(new EventBean(com.beizi.fusion.c.b.b, "", "510.200", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        }
    }
}
