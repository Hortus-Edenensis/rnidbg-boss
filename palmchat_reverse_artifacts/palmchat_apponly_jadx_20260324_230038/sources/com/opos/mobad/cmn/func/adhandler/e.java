package com.opos.mobad.cmn.func.adhandler;

import android.text.TextUtils;
import android.view.View;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.opos.mobad.cmn.func.adhandler.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.service.e.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.b f8676a;
    private String b;
    private AdItemData c;
    private MaterialData d;
    private int[] g;
    private boolean h;
    private long i = -1;
    private Map<String, String> e = new HashMap();
    private com.opos.mobad.service.e.b f = com.opos.mobad.service.e.c.a();

    public e(com.opos.mobad.b bVar, String str, AdItemData adItemData) {
        this.f8676a = bVar;
        this.b = str;
        this.c = adItemData;
        this.d = adItemData.i().get(0);
    }

    private e b() {
        String strR = this.d.r();
        if (TextUtils.isEmpty(strR)) {
            return this;
        }
        this.e.put("dlChannel", strR);
        return this;
    }

    private e c() {
        this.e.put("jumpRet", "1");
        return this;
    }

    private e d() {
        this.e.put("jumpRet", "0");
        return this;
    }

    private e e() {
        this.e.put("jumpRet", "2");
        return this;
    }

    private e f() {
        com.opos.mobad.cmn.func.b.e.b(this.e);
        return this;
    }

    private e g() {
        com.opos.mobad.cmn.func.b.e.d(this.e);
        return this;
    }

    private e h() {
        com.opos.mobad.cmn.func.b.e.a(this.e);
        return this;
    }

    private e i() {
        com.opos.mobad.cmn.func.b.e.c(this.e);
        return this;
    }

    private e j() {
        com.opos.mobad.cmn.func.b.e.a(this.e, this.d);
        return this;
    }

    public e a(float f) {
        com.opos.mobad.cmn.func.b.a.a.a(this.e, f);
        return this;
    }

    private e d(int i) {
        d();
        this.e.put("rsCode", String.valueOf(i));
        return this;
    }

    private boolean e(int i) {
        return i == 11 || i == 2 || i == 5 || i == 9 || i == 10 || i == 1 || i == 4;
    }

    public e a(int i) {
        com.opos.mobad.cmn.func.b.a.a.a(this.e, "viewVisibility", String.valueOf(i));
        return this;
    }

    public e b(float f) {
        com.opos.mobad.cmn.func.b.a.a.b(this.e, f);
        return this;
    }

    public e c(int i) {
        this.e.put("endTmType", String.valueOf(i));
        return this;
    }

    private e d(boolean z) {
        this.f.a(z ? "1" : "0");
        return this;
    }

    public e a(long j) {
        if (j <= 0) {
            return this;
        }
        com.opos.mobad.cmn.func.b.e.a(this.e, j, this.d.s());
        this.f.a(j);
        this.i = j;
        return this;
    }

    public e b(int i) {
        this.e.put("clientTemplateId", String.valueOf(i));
        return this;
    }

    public e c(boolean z) {
        Map<String, String> map;
        String str;
        if (z) {
            map = this.e;
            str = "2";
        } else {
            map = this.e;
            str = "1";
        }
        map.put("clickState", str);
        return this;
    }

    public e a(View view) {
        if (view == null) {
            return this;
        }
        com.opos.mobad.cmn.func.b.e.a(view, this.e);
        this.f.a(com.opos.cmn.an.h.f.a.b(this.f8676a.b(), view.getWidth()), com.opos.cmn.an.h.f.a.b(this.f8676a.b(), view.getHeight()));
        return this;
    }

    public e b(Map<String, String> map) {
        if (map.containsKey("nativeCoordinate")) {
            com.opos.mobad.cmn.func.b.a.a.a(this.e, "nativeCoordinate", map.get("nativeCoordinate"));
        }
        return this;
    }

    public e a(com.opos.mobad.cmn.func.b.a aVar, int[] iArr) {
        Map<String, String> map;
        String strValueOf;
        String str;
        if (aVar == com.opos.mobad.cmn.func.b.a.SHAKE || aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_SHAKE) {
            this.f.a(b.a.SHAKE);
            this.f.b(iArr);
            com.opos.mobad.cmn.func.b.e.a(this.e, String.valueOf(this.d.d()), iArr);
            iArr = null;
        } else {
            if (aVar == com.opos.mobad.cmn.func.b.a.CLICK_BT || aVar == com.opos.mobad.cmn.func.b.a.LIGHT_INTERACTIVE || aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_INTERSTITIAL_RETAIN || aVar == com.opos.mobad.cmn.func.b.a.OUT_COUPONS || aVar == com.opos.mobad.cmn.func.b.a.E_COMMERCE_DIALOG_BTN) {
                this.f.a(b.a.BUTTON).a(iArr);
                if (aVar == com.opos.mobad.cmn.func.b.a.LIGHT_INTERACTIVE) {
                    map = this.e;
                    strValueOf = String.valueOf(this.d.d());
                    str = "8";
                } else if (aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_INTERSTITIAL_RETAIN) {
                    map = this.e;
                    strValueOf = String.valueOf(this.d.d());
                    str = "11";
                } else if (aVar == com.opos.mobad.cmn.func.b.a.OUT_COUPONS) {
                    map = this.e;
                    strValueOf = String.valueOf(this.d.d());
                    str = BaseWrapper.ENTER_ID_MARKET;
                } else if (aVar == com.opos.mobad.cmn.func.b.a.E_COMMERCE_DIALOG_BTN) {
                    map = this.e;
                    strValueOf = String.valueOf(this.d.d());
                    str = BaseWrapper.ENTER_ID_GAME_CENTER;
                } else {
                    map = this.e;
                    strValueOf = String.valueOf(this.d.d());
                    str = "1";
                }
            } else if (aVar == com.opos.mobad.cmn.func.b.a.NON_CLICK_BT) {
                this.f.a(b.a.EXTRA).a(iArr);
                map = this.e;
                strValueOf = String.valueOf(this.d.G());
                str = "2";
            } else {
                str = "4";
                if (aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_CLICK_BT) {
                    this.f.a(b.a.FLOATLAYER_BUTTON).a(iArr);
                    map = this.e;
                    strValueOf = String.valueOf(this.d.S());
                } else if (aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_NON_CLICK_BT) {
                    this.f.a(b.a.FLOATLAYER_EXTRA).a(iArr);
                    com.opos.mobad.cmn.func.b.e.a(this.e, "5", String.valueOf(this.d.T()));
                } else if (aVar == com.opos.mobad.cmn.func.b.a.VIDEO) {
                    this.f.a(b.a.VIDEO).a(iArr);
                    map = this.e;
                    strValueOf = String.valueOf(this.d.H());
                    str = "3";
                } else if (aVar == com.opos.mobad.cmn.func.b.a.FORWARD) {
                    this.f.a(b.a.FORWARD);
                    com.opos.mobad.cmn.func.b.e.a(this.e, "9", String.valueOf(this.d.d()), "4");
                } else if (aVar == com.opos.mobad.cmn.func.b.a.TILT) {
                    this.f.a(b.a.TILT);
                    com.opos.mobad.cmn.func.b.e.a(this.e, "10", String.valueOf(this.d.d()), "5");
                }
            }
            com.opos.mobad.cmn.func.b.e.a(map, str, strValueOf);
        }
        this.g = iArr;
        return this;
    }

    public e b(boolean z) {
        com.opos.mobad.cmn.func.b.e.b(this.e, z ? "1" : "2");
        return this;
    }

    private e a(b.EnumC0772b enumC0772b) {
        this.f.a(enumC0772b);
        return this;
    }

    private void b(b.e eVar) {
        MaterialData materialData = this.d;
        if (materialData != null && !TextUtils.isEmpty(materialData.ag())) {
            com.opos.mobad.cmn.func.b.a.a.a(this.e, "dpToken", this.d.ag());
            com.opos.mobad.cmn.func.adhandler.a.e eVar2 = eVar.f8669a.f;
            String str = eVar2 instanceof com.opos.mobad.cmn.func.adhandler.a.a.a ? ((com.opos.mobad.cmn.func.adhandler.a.a.a) eVar2).c : "";
            if (!TextUtils.isEmpty(str)) {
                com.opos.mobad.cmn.func.b.a.a.a(this.e, "dpRequestId", str);
            }
        }
        a(this, eVar);
        a(this, eVar.c);
        if (e(eVar.c.f8668a)) {
            a(eVar.f8669a.a());
        }
        this.f.a(this.f8676a.b());
        this.e.put("progress", String.valueOf(this.i));
        String str2 = this.e.get("evtType");
        com.opos.cmn.an.f.a.b("AdHandler_HandlerReporter", "report adClick " + eVar + ",evtType:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        str2.hashCode();
        switch (str2) {
            case "1":
                com.opos.mobad.cmn.func.b.e.a(this.f8676a, this.b, this.c, this.d, this.h, this.g, this.e);
                break;
            case "4":
                com.opos.mobad.cmn.func.b.e.b(this.f8676a, this.b, this.c, this.d, this.h, this.g, this.e);
                break;
            case "5":
                com.opos.mobad.cmn.func.b.e.c(this.f8676a, this.b, this.c, this.d, this.h, this.g, this.e);
                break;
            case "7":
                com.opos.mobad.cmn.func.b.e.a(this.f8676a, this.c, this.d, this.h, this.g, this.e);
                break;
            case "9":
                com.opos.mobad.cmn.func.b.e.d(this.f8676a, this.b, this.c, this.d, this.h, this.g, this.e);
                break;
            default:
                com.opos.cmn.an.f.a.a("", "report but error :" + str2);
                break;
        }
    }

    public e a(String str) {
        com.opos.mobad.cmn.func.b.a.a.b(this.e, str);
        return this;
    }

    public e a(List<String> list) {
        if (list != null && list.size() > 0) {
            this.f.a(list);
        }
        return this;
    }

    public e a(Map<String, String> map) {
        if (map.containsKey("template_interactive_mode")) {
            this.e.put("aInteractiveMode", map.get("template_interactive_mode"));
        }
        return this;
    }

    public e a(boolean z) {
        this.h = z;
        return this;
    }

    public com.opos.mobad.service.e.b a() {
        return this.f.a();
    }

    public void a(int i, String str) {
        com.opos.mobad.service.e.b bVarA;
        List<String> listL;
        if (i == 101) {
            com.opos.mobad.cmn.func.b.e.b(this.f8676a, this.c, this.d);
            if (this.d.L() == null || this.d.L().size() <= 0) {
                return;
            }
            bVarA = com.opos.mobad.service.e.c.a();
            listL = this.d.L();
        } else if (i != 200) {
            if (i != 105) {
                if (i != 106) {
                    return;
                }
                com.opos.mobad.cmn.func.b.e.a(this.f8676a, this.c, this.d, str);
                return;
            } else {
                com.opos.mobad.cmn.func.b.e.c(this.f8676a, this.c, this.d);
                if (this.d.M() == null || this.d.M().size() <= 0) {
                    return;
                }
                bVarA = com.opos.mobad.service.e.c.a();
                listL = this.d.M();
            }
        } else {
            if (this.d.N() == null || this.d.N().size() <= 0) {
                return;
            }
            bVarA = com.opos.mobad.service.e.c.a();
            listL = this.d.N();
        }
        bVarA.a(listL).a(this.f8676a.b());
    }

    public void a(b.e eVar) {
        b.c cVar;
        if (eVar == null || (cVar = eVar.b) == null) {
            com.opos.cmn.an.f.a.b("", "report but null");
        } else if (b.a(cVar.f8668a)) {
            b(eVar);
        } else {
            if (eVar.b.f8668a != 16) {
                return;
            }
            com.opos.mobad.cmn.func.b.e.a(this.f8676a, this.b, (eVar.c.b == 2 || this.c.M() == null) ? null : this.c.M().f9073a, eVar.c.b);
        }
    }

    private static void a(e eVar, b.c cVar) {
        b.EnumC0772b enumC0772b;
        int i = cVar.f8668a;
        if (i == 4 || i == 10) {
            enumC0772b = b.EnumC0772b.APP_HOME;
        } else if (i == 2 || i == 12) {
            enumC0772b = b.EnumC0772b.BROWSER;
        } else if (i == 3 || i == 13) {
            enumC0772b = b.EnumC0772b.WEB_VIEW;
        } else if (i == 5 || i == 9 || i == 20 || i == 11) {
            enumC0772b = b.EnumC0772b.DEEP_LINK;
        } else if (i == 7) {
            enumC0772b = b.EnumC0772b.DOWNLOADER;
        } else if (i == 1) {
            enumC0772b = b.EnumC0772b.MARKET;
        } else if (i == 6) {
            enumC0772b = b.EnumC0772b.INSTANT;
        } else {
            if (i != 8) {
                if (i == 19) {
                    enumC0772b = b.EnumC0772b.WECHAT_NATIVE_PAGE;
                }
                eVar.d(cVar.a());
            }
            enumC0772b = b.EnumC0772b.MINI_PROGRAM;
        }
        eVar.a(enumC0772b);
        eVar.d(cVar.a());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0098, code lost:
    
        if (r0.a() != false) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(e eVar, b.e eVar2) {
        if (eVar2 == null || eVar2.b == null) {
            com.opos.cmn.an.f.a.b("AdHandler_HandlerReporter", "fillClickReportResult:" + eVar2);
            return;
        }
        com.opos.cmn.an.f.a.b("AdHandler_HandlerReporter", "fillSTReportResult :" + eVar2.b);
        b.c cVar = eVar2.b;
        int i = cVar.f8668a;
        if (i == 19) {
            eVar.g();
        } else if (i != 20) {
            switch (i) {
                case 1:
                    eVar.b().g();
                    break;
                case 4:
                case 10:
                    eVar.j();
                    break;
                case 5:
                case 11:
                    if (eVar2.a()) {
                        eVar.f();
                        break;
                    }
                    break;
                case 7:
                    if (!eVar2.b()) {
                        eVar.h();
                        break;
                    }
                    break;
                case 9:
                    if (!cVar.a() && eVar2.c.f8668a == 10) {
                    }
                    break;
                case 12:
                case 13:
                    eVar.b().i();
                    break;
            }
        }
        if (!eVar2.a()) {
            b.c cVar2 = eVar2.b;
            int i2 = cVar2.f8668a;
            if (i2 == 6 && cVar2.b == -3) {
                eVar.d(cVar2.c);
                return;
            }
            if (i2 == 9 || i2 == 20) {
                b.c cVar3 = eVar2.c;
                if (cVar3.f8668a == 10) {
                }
            }
            if (eVar2.b.b == -4) {
                eVar.e();
                return;
            } else {
                eVar.d();
                return;
            }
        }
        eVar.c();
    }
}
