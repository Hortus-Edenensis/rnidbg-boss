package com.opos.mobad.template;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f9641a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f9642a = false;
    }

    public static void a(a aVar) {
        f9641a = aVar;
    }

    public static boolean a() {
        a aVar = f9641a;
        if (aVar != null) {
            com.opos.cmn.an.f.a.b("TemplateManager", "shouldCheckViewMockClick() viewMockClickInterceptSwitch=", Boolean.valueOf(aVar.f9642a));
            return f9641a.f9642a;
        }
        com.opos.cmn.an.f.a.b("TemplateManager", "shouldCheckViewMockClick() viewMockClickInterceptSwitch=false");
        return false;
    }
}
