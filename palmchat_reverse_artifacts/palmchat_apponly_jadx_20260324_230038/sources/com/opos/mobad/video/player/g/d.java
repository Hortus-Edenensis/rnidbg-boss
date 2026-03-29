package com.opos.mobad.video.player.g;

import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class d {
    public static int a(com.opos.mobad.template.a aVar) {
        if (aVar == null) {
            return 0;
        }
        try {
            return aVar.e();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("IAdTemplateUtils", "getTemplateId() fail", e);
            return 0;
        }
    }

    public static void b(final com.opos.mobad.template.a aVar) {
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.video.player.g.d.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.opos.mobad.template.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("IAdTemplateUtils", "stop() fail", e);
                }
            }
        });
    }

    public static void c(final com.opos.mobad.template.a aVar) {
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.video.player.g.d.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.opos.mobad.template.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.b();
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("IAdTemplateUtils", "start() fail", e);
                }
            }
        });
    }

    public static boolean d(com.opos.mobad.template.a aVar) {
        return g(aVar) == 0;
    }

    public static void e(com.opos.mobad.template.a aVar) {
        a(aVar, 0);
    }

    public static void f(com.opos.mobad.template.a aVar) {
        a(aVar, 8);
    }

    private static int g(com.opos.mobad.template.a aVar) {
        if (aVar == null) {
            return 8;
        }
        try {
            View viewC = aVar.c();
            if (viewC != null) {
                return viewC.getVisibility();
            }
            return 8;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("IAdTemplateUtils", "getVisibility() fail", e);
            return 8;
        }
    }

    private static void a(final com.opos.mobad.template.a aVar, final int i) {
        com.opos.cmn.an.f.a.b("IAdTemplateUtils", "setVisibility()", "iAdTemplate=", aVar, "visibility=", Integer.valueOf(i));
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.video.player.g.d.4
            @Override // java.lang.Runnable
            public void run() {
                View viewC;
                try {
                    com.opos.mobad.template.a aVar2 = aVar;
                    if (aVar2 == null || (viewC = aVar2.c()) == null) {
                        return;
                    }
                    viewC.setVisibility(i);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("IAdTemplateUtils", "setVisibility() fail", e);
                }
            }
        });
    }

    public static void a(final com.opos.mobad.template.a aVar, final com.opos.mobad.template.d.f fVar) {
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.video.player.g.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.opos.mobad.template.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(fVar);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("IAdTemplateUtils", "render() fail", e);
                }
            }
        });
    }
}
