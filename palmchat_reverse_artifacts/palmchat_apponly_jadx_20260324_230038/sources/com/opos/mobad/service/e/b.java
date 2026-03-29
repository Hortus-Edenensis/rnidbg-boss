package com.opos.mobad.service.e;

import android.content.Context;
import com.opos.cmn.biz.monitor.MonitorEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f9229a;
    private EnumC0772b b;
    private String c;
    private List<String> d;
    private int[] e;
    private long f = -1;
    private int g = 0;
    private int h = 0;
    private int[] i;

    /* JADX INFO: renamed from: com.opos.mobad.service.e.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9230a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC0772b.values().length];
            b = iArr;
            try {
                iArr[EnumC0772b.MARKET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[EnumC0772b.WEB_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[EnumC0772b.BROWSER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[EnumC0772b.INSTANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[EnumC0772b.APP_HOME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[EnumC0772b.DEEP_LINK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[EnumC0772b.DOWNLOADER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[EnumC0772b.MINI_PROGRAM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[a.values().length];
            f9230a = iArr2;
            try {
                iArr2[a.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f9230a[a.EXTRA.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f9230a[a.FLOATLAYER_EXTRA.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f9230a[a.BUTTON.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f9230a[a.FLOATLAYER_BUTTON.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f9230a[a.PENDANT.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f9230a[a.SHAKE.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f9230a[a.FORWARD.ordinal()] = 8;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f9230a[a.TILT.ordinal()] = 9;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        BUTTON,
        EXTRA,
        VIDEO,
        FLOATLAYER_BUTTON,
        FLOATLAYER_EXTRA,
        PENDANT,
        SHAKE,
        FORWARD,
        TILT
    }

    /* JADX INFO: renamed from: com.opos.mobad.service.e.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public enum EnumC0772b {
        APP_HOME,
        DEEP_LINK,
        WEB_VIEW,
        BROWSER,
        INSTANT,
        MARKET,
        DOWNLOADER,
        MINI_PROGRAM,
        WECHAT_NATIVE_PAGE
    }

    private MonitorEvent b() {
        MonitorEvent.d dVar;
        MonitorEvent.c cVar;
        MonitorEvent.b bVar = new MonitorEvent.b();
        a aVar = this.f9229a;
        if (aVar != null) {
            switch (AnonymousClass1.f9230a[aVar.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    bVar.a(MonitorEvent.a.EXTRA);
                    cVar = MonitorEvent.c.OTHER;
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    bVar.a(MonitorEvent.a.BTN);
                    cVar = MonitorEvent.c.CLICK_BUTTON;
                    break;
            }
            bVar.a(cVar);
        }
        EnumC0772b enumC0772b = this.b;
        if (enumC0772b != null) {
            switch (AnonymousClass1.b[enumC0772b.ordinal()]) {
                case 1:
                    dVar = MonitorEvent.d.APP_SHOP;
                    break;
                case 2:
                case 3:
                    dVar = MonitorEvent.d.WEB_URL;
                    break;
                case 4:
                    dVar = MonitorEvent.d.QA;
                    break;
                case 5:
                    dVar = MonitorEvent.d.APP_HOME;
                    break;
                case 6:
                    dVar = MonitorEvent.d.DEEP_LINK;
                    break;
                case 7:
                    dVar = MonitorEvent.d.DOWNLOADER;
                    break;
                case 8:
                    dVar = MonitorEvent.d.MINI_PROGRAM;
                    break;
            }
            bVar.a(dVar);
        }
        String str = this.c;
        if (str != null) {
            bVar.a(str);
        }
        int[] iArr = this.e;
        if (iArr != null && iArr.length > 0) {
            bVar.a(iArr[0], iArr[1], iArr[2], iArr[3]);
        }
        long j = this.f;
        if (j >= 0) {
            bVar.a((int) j);
        }
        return bVar.a();
    }

    public b a() {
        return new b().a(this.f9229a).a(this.b).a(this.d).a(this.c).a(this.e).a(this.g, this.h).b(this.i);
    }

    public b a(int i, int i2) {
        this.g = i;
        this.h = i2;
        return this;
    }

    public b b(int[] iArr) {
        this.i = iArr;
        return this;
    }

    private String b(String str) {
        a aVar = a.SHAKE;
        a aVar2 = this.f9229a;
        String strA = com.opos.mobad.service.e.a.a(str, "$itm$", aVar == aVar2 ? "2" : a.FORWARD == aVar2 ? "4" : a.TILT == aVar2 ? "6" : "1");
        int[] iArr = this.i;
        if (iArr != null && iArr.length == 3) {
            strA = com.opos.mobad.service.e.a.a(com.opos.mobad.service.e.a.a(com.opos.mobad.service.e.a.a(strA, "$xma$", String.valueOf(iArr[0])), "$yma$", String.valueOf(this.i[1])), "$zma$", String.valueOf(this.i[2]));
        }
        return com.opos.mobad.service.e.a.a(com.opos.mobad.service.e.a.a(strA, "$acw$", String.valueOf(this.g)), "$ach$", String.valueOf(this.h));
    }

    public b a(long j) {
        this.f = j;
        return this;
    }

    public b a(a aVar) {
        this.f9229a = aVar;
        return this;
    }

    public b a(EnumC0772b enumC0772b) {
        this.b = enumC0772b;
        return this;
    }

    public b a(String str) {
        this.c = str;
        return this;
    }

    public b a(List<String> list) {
        this.d = list;
        return this;
    }

    public b a(int[] iArr) {
        this.e = iArr;
        return this;
    }

    public String a(Context context, String str) {
        return com.opos.cmn.biz.monitor.a.a().b(context.getApplicationContext(), b(str), b());
    }

    public void a(Context context) {
        List<String> list = this.d;
        if (list == null || list.size() <= 0) {
            com.opos.cmn.an.f.a.a("", "report with url null or length 0");
            return;
        }
        MonitorEvent monitorEventB = b();
        ArrayList arrayList = new ArrayList(this.d.size());
        Iterator<String> it = this.d.iterator();
        while (it.hasNext()) {
            arrayList.add(b(it.next()));
        }
        c.a(context, arrayList, monitorEventB);
    }
}
