package com.getui.gtc.h;

import com.getui.gtc.base.http.Request;
import com.getui.gtc.base.http.Response;
import com.getui.gtc.e.c;
import com.getui.gtc.entity.a;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static void a(a.C0343a c0343a, String str) throws Exception {
        if (a(c0343a)) {
            throw new RuntimeException("The download request is unusual, too many times in a short time");
        }
        Response responseExecute = d.f5789a.newCall(new Request.Builder().url(c0343a.h).method("GET").logFlags(1).build()).execute();
        if (responseExecute.body() == null) {
            throw new RuntimeException("can not save file, body is null");
        }
        responseExecute.body().file(new File(str));
    }

    private static boolean a(a.C0343a c0343a) {
        int iC = c.a.f5766a.b.c(c0343a.f5770a);
        long jB = c.a.f5766a.b.b(c0343a.f5770a);
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        if (iC >= 10) {
            iC = -1;
            jB = jCurrentTimeMillis;
        } else {
            long j = jCurrentTimeMillis - jB;
            if (iC >= 0) {
                if (j > 3600000) {
                    jB = jCurrentTimeMillis;
                    iC = 0;
                } else {
                    iC++;
                }
                z = false;
            } else if (j > 3600000) {
                jB = jCurrentTimeMillis;
                iC = 0;
            }
        }
        c.a.f5766a.b.a(c0343a.f5770a, jB, iC);
        return z;
    }
}
