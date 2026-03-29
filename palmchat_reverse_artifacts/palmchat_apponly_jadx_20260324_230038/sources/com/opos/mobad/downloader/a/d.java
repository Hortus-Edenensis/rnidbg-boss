package com.opos.mobad.downloader.a;

import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f8767a = 800;
    private long b = 0;
    private ArrayList<h> c;

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        INIT_STATUS(0),
        PROGRESS_STATUS(1),
        PAUSED_STATUS(2),
        FAILED_STATUS(3),
        END_STATUS(4);

        private int f;

        a(int i) {
            this.f = i;
        }

        public int a() {
            return this.f;
        }
    }

    public d() {
        ArrayList<h> arrayList = new ArrayList<>(5);
        this.c = arrayList;
        arrayList.add(new h(a.INIT_STATUS));
        this.c.add(new h(a.PROGRESS_STATUS));
        this.c.add(new h(a.PAUSED_STATUS));
        this.c.add(new h(a.FAILED_STATUS));
        this.c.add(new h(a.END_STATUS));
    }

    public void a(Runnable runnable, a aVar) {
        h hVar = this.c.get(aVar.a());
        if (System.currentTimeMillis() > this.b + ((long) f8767a)) {
            hVar.a(runnable);
            this.b = System.currentTimeMillis();
            com.opos.cmn.an.f.a.b("LevelController", "meet interval and start");
            return;
        }
        if (aVar.a() == a.PROGRESS_STATUS.a()) {
            return;
        }
        for (h hVar2 : this.c) {
            if (hVar2.b() >= aVar.a() && hVar2.a()) {
                com.opos.cmn.an.f.a.b("LevelController", "is high level running");
                return;
            }
            if (hVar2.b() < aVar.a() && hVar2.a()) {
                com.opos.cmn.an.f.a.b("LevelController", "level cancel = " + aVar.a());
                hVar2.c();
                hVar2.d();
            }
        }
        com.opos.cmn.an.f.a.b("LevelController", "needToPost level = " + aVar.a());
        hVar.a(runnable, (long) f8767a);
        this.b = System.currentTimeMillis() + ((long) f8767a);
    }
}
