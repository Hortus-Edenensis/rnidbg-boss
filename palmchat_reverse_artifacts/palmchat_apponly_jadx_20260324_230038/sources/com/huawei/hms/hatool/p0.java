package com.huawei.hms.hatool;

import java.util.Calendar;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f6783a = 1800000;
    private volatile boolean b = false;
    private a c = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f6784a = UUID.randomUUID().toString().replace("-", "");
        boolean b;
        private long c;

        public a(long j) {
            this.f6784a += "_" + j;
            this.c = j;
            this.b = true;
            p0.this.b = false;
        }

        private void b(long j) {
            v.c("hmsSdk", "getNewSession() session is flush!");
            String string = UUID.randomUUID().toString();
            this.f6784a = string;
            this.f6784a = string.replace("-", "");
            this.f6784a += "_" + j;
            this.c = j;
            this.b = true;
        }

        public void a(long j) {
            if (p0.this.b) {
                p0.this.b = false;
                b(j);
            } else if (b(this.c, j) || a(this.c, j)) {
                b(j);
            } else {
                this.c = j;
                this.b = false;
            }
        }

        private boolean a(long j, long j2) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j2);
            return (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) ? false : true;
        }

        private boolean b(long j, long j2) {
            return j2 - j >= p0.this.f6783a;
        }
    }

    public String a() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.f6784a;
        }
        v.f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
        return "";
    }

    public void a(long j) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(j);
        } else {
            v.c("hmsSdk", "Session is first flush");
            this.c = new a(j);
        }
    }

    public boolean b() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.b;
        }
        v.f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
        return false;
    }
}
