package cn.fly.verify;

import android.text.TextUtils;
import cn.fly.verify.fq;
import com.wifi.adsdk.utils.LxAdMiuiDevice;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class gg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static gg f2391a;

    /* JADX INFO: renamed from: cn.fly.verify.gg$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2392a;

        static {
            int[] iArr = new int[a.values().length];
            f2392a = iArr;
            try {
                iArr[a.MIUI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2392a[a.EMUI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2392a[a.AMIGO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2392a[a.FLYME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2392a[a.LENOVO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2392a[a.ONEUI.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2392a[a.COLOR_OS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2392a[a.FUNTOUCH_OS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2392a[a.EUI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2392a[a.SENSE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f2392a[a.GOOGLE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f2392a[a.SMARTISAN.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f2392a[a.ONEPLUS.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f2392a[a.YUNOS.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f2392a[a.QIHOO.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f2392a[a.NUBIA.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f2392a[a.LGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        MIUI(ed.a("006Gecdi)d;eddfdi")),
        EMUI(ed.a("006h(dg d ff;fZdi")),
        FLYME(ed.a("005RdfFf digcdg")),
        ONEUI(ed.a("007?fhRdFdffhdg9e3ee")),
        COLOR_OS(ed.a("004Ved^jjIed")),
        FUNTOUCH_OS(ed.a("004.dddidded")),
        EUI(ed.a("004gfi4dd")),
        SENSE(ed.a("003hic")),
        GOOGLE(ed.a("006!eeededeeHgf")),
        LENOVO(ed.a("006gfeSeddded")),
        SMARTISAN(ed.a("006ch$dgdigcdi")),
        ONEPLUS(ed.a("0073edLefjgNdgfh")),
        YUNOS(ed.a("005QdkdgDe@edfh")),
        QIHOO(ed.a("005Udedi5h]eded")),
        NUBIA(ed.a("005e^dgfedi6d")),
        LGE(ed.a("002g9ee")),
        AMIGO(ed.a("005Khgdi5egMdi")),
        OTHER("");

        private String s;

        a(String str) {
            this.s = str;
        }

        public String a() {
            return this.s;
        }
    }

    private gg() {
    }

    public static gg a() {
        if (f2391a == null) {
            synchronized (gg.class) {
                if (f2391a == null) {
                    f2391a = new gg();
                }
            }
        }
        return f2391a;
    }

    private a c() {
        if (!TextUtils.isEmpty(a(LxAdMiuiDevice.PROP_VERSION)) || !TextUtils.isEmpty(a(ed.a("023@djedfddfdidgdifddgdifddd$f*djfhdied.eBfd1ed2df$f"))) || !TextUtils.isEmpty(a("ro.miui.internal.storage"))) {
            return a.MIUI;
        }
        if (!TextUtils.isEmpty(a(ed.a("021+djedfdfedgdi*gMdcfdddOf6djfhdied]eVfdAfYdfdgdi"))) || !TextUtils.isEmpty(a("ro.build.hw_emui_api_level")) || !TextUtils.isEmpty(a("ro.confg.hw_systemversion"))) {
            return a.EMUI;
        }
        if (!TextUtils.isEmpty(a(ed.a("026jf3djfhdifh^i%fdfhdkfhfddgfh_f-fdefDgIdkdf?f4fddiOc*edOe"))) || !TextUtils.isEmpty(a(ed.a("026XdjedfddfCf-digcdgfdfhZfi_dg.jZffdigcMd<djdcfdefMg,dkdfKf"))) || !TextUtils.isEmpty(a(ed.a("0182djedfdef@g?dkdfOf=fd.jIdgfeZg difh.hf'dc")))) {
            return a.FLYME;
        }
        if (!TextUtils.isEmpty(a(ed.a("024c>eddffdfhPdXdffhdg e4eefdfhDjf'eefddcdifhRdRfe.gf"))) || !TextUtils.isEmpty(a("init.svc.health-hal-2-1-samsung"))) {
            return a.ONEUI;
        }
        if (!TextUtils.isEmpty(a(ed.a("024Edjedfdfedgdi2g3dcfddd;f7djfhdied8e,fded0jjOeddjeddf")))) {
            return a.COLOR_OS;
        }
        if (!TextUtils.isEmpty(a(ed.a("027LdjedfddddiddedfdedfhfdfedgdiZg dcfddcdifhGjgd$dkfddidc"))) || !TextUtils.isEmpty(a(ed.a("018>djedfddddiddedfdedfhfddd,fJdjfhdiedEe")))) {
            return a.FUNTOUCH_OS;
        }
        if (!TextUtils.isEmpty(a(ed.a("023Wdjedfd1gfi2ddfddjYfgfd-fhFf@fdddKfPdjfhdiedOe")))) {
            return a.EUI;
        }
        if (!TextUtils.isEmpty(a(ed.a("0228djedfdfedgdi,gQdcfdfh5fe!fhWf:fddd9f;djfhdied%e")))) {
            return a.SENSE;
        }
        if (ed.a("014deZdcdjeddidchkeeededee?gf").equals(a(ed.a("026*djedfdAcGeddffdeeededeeHgf'fd?cgQdi^feiBdidcfeMd fh%f")))) {
            return a.GOOGLE;
        }
        if (!TextUtils.isEmpty(a(ed.a("020WdjedfdfhdfFd+djSi$difh'deBfddd1fYdjfhdied8e")))) {
            return a.SMARTISAN;
        }
        if (!TextUtils.isEmpty(a(ed.a("014%djedfddjeddffddd1fMdjfhdied7e")))) {
            return a.ONEPLUS;
        }
        if (!TextUtils.isEmpty(a(ed.a("020Qdjedfd1cidIfddkdg e8edfhfdddXf7djfhdied.e")))) {
            return a.YUNOS;
        }
        if (!TextUtils.isEmpty(a(ed.a("018.djedfdfedgdi:gSdcfddgdidd%f8djfhdied0e")))) {
            return a.QIHOO;
        }
        if (!TextUtils.isEmpty(a(ed.a("023HdjedfdfedgdiOg1dcfd@e(dgfedi_d=fddjeddffd cLeddc-f"))) || !TextUtils.isEmpty(a(ed.a("015$djedfdfedgdiPg!dcfddjeddffddidc")))) {
            return a.NUBIA;
        }
        if (!TextUtils.isEmpty(a(ed.a("021Qfhdkfhfd6g6ee<fAfdEg9eedfdcdfdhdd5fKdjfhdiedXe")))) {
            return a.LGE;
        }
        if (!TextUtils.isEmpty(a(ed.a("019Mdjedfdfedgdi*gLdcfddcdifhMjgd9dkfddidc"))) && a(ed.a("019+djedfdfedgdi?g!dcfddcdifhYjgd%dkfddidc")).matches("amigo([\\d.]+)[a-zA-Z]*")) {
            return a.AMIGO;
        }
        for (a aVar : a.values()) {
            if (aVar.a().equalsIgnoreCase(fq.d.k())) {
                return aVar;
            }
        }
        return a.OTHER;
    }

    public String b() {
        String str;
        String strA;
        switch (AnonymousClass1.f2392a[c().ordinal()]) {
            case 1:
                str = "023@djedfddfdidgdifddgdifddd?fCdjfhdied!e)fd)edCdfDf";
                strA = a(ed.a(str));
                break;
            case 2:
                str = "021Zdjedfdfedgdi(g[dcfdddCfTdjfhdiedFe'fdWfBdfdgdi";
                strA = a(ed.a(str));
                break;
            case 3:
            case 4:
                str = "019KdjedfdfedgdiGgOdcfddcdifh%jgd@dkfddidc";
                strA = a(ed.a(str));
                break;
            case 5:
            case 6:
                str = "028ZdjedfdfedgdiHgIdcfddd!f$djfhdiedFeYfddiVec)dj0f6df?feidg";
                strA = a(ed.a(str));
                break;
            case 7:
                str = "0245djedfdfedgdiIg-dcfdddTf>djfhdiedGe fded*jj<eddjeddf";
                strA = a(ed.a(str));
                break;
            case 8:
                strA = a(ed.a("027Kdjedfddddiddedfdedfhfdfedgdi+gPdcfddcdifhCjgd%dkfddidc"));
                if (TextUtils.isEmpty(strA)) {
                    str = "018GdjedfddddiddedfdedfhfdddTfGdjfhdied8e";
                    strA = a(ed.a(str));
                }
                break;
            case 9:
                str = "023%djedfdKgfi+ddfddj?fgfd2fh_f?fdddWfIdjfhdied3e";
                strA = a(ed.a(str));
                break;
            case 10:
                str = "022=djedfdfedgdiIg2dcfdfh-feEfhAf!fdddLf!djfhdied>e";
                strA = a(ed.a(str));
                break;
            case 11:
                str = "024Sdjedfdfedgdi8g8dcfdddHfNdjfhdiedGeWfddj!fgfd5fhZf";
                strA = a(ed.a(str));
                break;
            case 12:
                str = "0201djedfdfhdf$dYdj:i=difhWde%fddd8f,djfhdiedGe";
                strA = a(ed.a(str));
                break;
            case 13:
                str = "014Ydjedfddjeddffddd!fDdjfhdiedQe";
                strA = a(ed.a(str));
                break;
            case 14:
                str = "020Ydjedfd^cid?fddkdgBe6edfhfddd3fWdjfhdied=e";
                strA = a(ed.a(str));
                break;
            case 15:
                str = "018,djedfdfedgdiPg2dcfddgdidd<fJdjfhdied+e";
                strA = a(ed.a(str));
                break;
            case 16:
                strA = a(ed.a("023'djedfdfedgdi gNdcfd>eIdgfedi2d;fddjeddffd7cUeddc f"));
                if (TextUtils.isEmpty(strA)) {
                    str = "015KdjedfdfedgdiGgNdcfddjeddffddidc";
                    strA = a(ed.a(str));
                }
                break;
            case 17:
                str = "021.fhdkfhfdTgDeeHfCfdWg4eedfdcdfdhddTf^djfhdiedFe";
                strA = a(ed.a(str));
                break;
            default:
                str = "019WdjedfdfedgdiVg-dcfddcdifh8jgd]dkfddidc";
                strA = a(ed.a(str));
                break;
        }
        return TextUtils.isEmpty(strA) ? a(ed.a("019Sdjedfdfedgdi[gTdcfddcdifh.jgdVdkfddidc")) : strA;
    }

    private String a(String str) {
        return fq.d.c(str);
    }
}
