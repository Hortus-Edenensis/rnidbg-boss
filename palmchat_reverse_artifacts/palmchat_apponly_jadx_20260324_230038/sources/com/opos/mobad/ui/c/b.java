package com.opos.mobad.ui.c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.opos.mobad.ad.d.e;
import com.opos.mobad.d.a;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.template.a;
import com.opos.mobad.template.c.h;
import com.opos.mobad.template.c.i;
import com.opos.mobad.template.c.j;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f10244a;
    private final com.opos.mobad.d.a b;
    private com.opos.mobad.d.a c;
    private final j d;
    private com.opos.mobad.template.f e;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(int i);
    }

    /* JADX INFO: renamed from: com.opos.mobad.ui.c.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0806b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f10246a;
        private static final b b;

        static {
            f10246a = new b();
            b = new b();
        }
    }

    private b() {
        com.opos.mobad.d.a aVar = new com.opos.mobad.d.a() { // from class: com.opos.mobad.ui.c.b.1
            @Override // com.opos.mobad.d.a
            public void a(String str, String str2, int i, int i2, a.InterfaceC0732a interfaceC0732a) {
                com.opos.mobad.downloader.f.a().a(str, str2, i, i2, interfaceC0732a);
            }

            @Override // com.opos.mobad.d.a
            public void a(String str, String str2, a.InterfaceC0732a interfaceC0732a) {
                com.opos.mobad.downloader.f.a().a(str, str2, interfaceC0732a);
            }
        };
        this.b = aVar;
        this.c = aVar;
        this.d = a(-1).a();
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.opos.mobad.template.a a(Activity activity, AdItemData adItemData, MaterialData materialData, Bundle bundle, a.InterfaceC0778a interfaceC0778a) {
        int iB = materialData != null ? materialData.b() : 0;
        if (bundle != null && bundle.getInt("interstitial_scene") == e.b.INSTANT_EXIT.ordinal() && iB != 2155 && iB != 2154) {
            iB = materialData.a() ? 2154 : 2155;
        }
        com.opos.mobad.template.l.a aVarA = com.opos.mobad.mediaplayer.b.d.a(adItemData.W());
        com.opos.mobad.template.a aVarA2 = a(activity, iB, aVarA, interfaceC0778a);
        if (aVarA2 != null) {
            return aVarA2;
        }
        int iZ = materialData.Z();
        if (iZ != 1) {
            if (iZ != 2) {
                if (iZ == 3) {
                    iB = 2044;
                } else if (iZ == 5) {
                    iB = 48;
                } else if (iZ == 50) {
                    iB = materialData.a() ? 2071 : 2008;
                } else if (iZ == 60 || iZ == 63) {
                    iB = materialData.a() ? 2030 : 2029;
                } else if (iZ != 71) {
                    if (iZ != 20) {
                        if (iZ != 21) {
                            if (iZ != 30) {
                                if (iZ != 31) {
                                    if (iZ == 80 || iZ == 81) {
                                        if (materialData.a()) {
                                            iB = 2028;
                                        }
                                    }
                                } else if (!materialData.a()) {
                                    iB = 52;
                                }
                            } else if (!materialData.a()) {
                                iB = 50;
                            }
                            iB = 9;
                        } else {
                            iB = materialData.a() ? 8 : 51;
                        }
                    } else if (materialData.a()) {
                    }
                } else if (materialData.a()) {
                    iB = 5;
                }
            } else if (materialData.a()) {
                iB = 7;
            }
        } else if (materialData.a()) {
        }
        return a(activity, iB, aVarA, interfaceC0778a);
    }

    public com.opos.mobad.template.a b(Context context, MaterialData materialData, com.opos.mobad.template.l.a aVar, a.InterfaceC0778a interfaceC0778a) {
        com.opos.mobad.template.a aVarA = a(context, materialData.b(), aVar, interfaceC0778a);
        if (aVarA != null) {
            return aVarA;
        }
        int iZ = materialData.Z();
        return a(context, (iZ == 60 || iZ == 63) ? materialData.a() ? 2030 : 2029 : 0, aVar, interfaceC0778a);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.opos.mobad.template.a a(Context context, int i, int i2, int i3, a.InterfaceC0778a interfaceC0778a) {
        int i4;
        com.opos.mobad.template.l.a aVarA = com.opos.mobad.mediaplayer.b.d.a(i3);
        com.opos.mobad.template.a aVarA2 = a(context.getApplicationContext(), i, aVarA, interfaceC0778a);
        if (aVarA2 != null) {
            return aVarA2;
        }
        if (i2 != 1) {
            i4 = 3;
            if (i2 != 2) {
                if (i2 != 3) {
                    i4 = 4;
                    if (i2 == 4) {
                        i4 = 2032;
                    } else if (i2 == 5) {
                        i4 = 2;
                    } else if (i2 == 20) {
                        i4 = 2045;
                    } else if (i2 != 21) {
                        if (i2 == 30 || i2 == 31) {
                            i4 = 53;
                        } else if (i2 != 34) {
                            i4 = i2 != 71 ? 0 : 2047;
                        }
                    }
                }
            }
        } else {
            i4 = 2044;
        }
        return a(context.getApplicationContext(), i4, aVarA, interfaceC0778a);
    }

    public com.opos.mobad.template.a a(Context context, int i, int i2, com.opos.mobad.template.l.a aVar, a.InterfaceC0778a interfaceC0778a) {
        com.opos.mobad.template.a aVarA = a(context.getApplicationContext(), i, aVar, interfaceC0778a);
        if (aVarA == null) {
            return a(context.getApplicationContext(), i2 != 1 ? i2 != 2 ? i2 != 20 ? i2 != 21 ? i2 != 30 ? i2 != 31 ? i2 != 50 ? i2 != 60 ? i2 != 63 ? i2 != 71 ? 0 : 2124 : 2141 : 2129 : 2126 : 84 : 2094 : 2143 : 2132 : 2128 : 2127, aVar, interfaceC0778a);
        }
        return aVarA;
    }

    private com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.template.l.a aVar, a.InterfaceC0778a interfaceC0778a) {
        com.opos.mobad.template.a aVarA = this.e.a(context, i, aVar, interfaceC0778a);
        if (aVarA != null) {
            return new c(context, aVarA, interfaceC0778a);
        }
        com.opos.cmn.an.f.a.b("AdTemplateFactoryWrapper", "createTemplate but null", Integer.valueOf(i));
        a aVar2 = this.f10244a;
        if (aVar2 == null) {
            return null;
        }
        aVar2.a(i);
        return null;
    }

    public com.opos.mobad.template.a a(Context context, MaterialData materialData, com.opos.mobad.template.l.a aVar, a.InterfaceC0778a interfaceC0778a) {
        com.opos.mobad.template.a aVarA = a(context, materialData.b(), aVar, interfaceC0778a);
        if (aVarA != null) {
            return aVarA;
        }
        int iZ = materialData.Z();
        return a(context, (iZ == 60 || iZ == 63) ? materialData.a() ? 2030 : 2029 : iZ != 76 ? 0 : materialData.a() ? 2158 : 2159, aVar, interfaceC0778a);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.opos.mobad.template.a a(Context context, AdHelper.a aVar, a.InterfaceC0778a interfaceC0778a) {
        com.opos.mobad.template.l.a aVarA = com.opos.mobad.mediaplayer.b.d.a(aVar.c.W());
        com.opos.mobad.template.a aVarA2 = a(context.getApplicationContext(), aVar.d.b(), aVarA, interfaceC0778a);
        if (aVarA2 != null) {
            return aVarA2;
        }
        int iZ = aVar.d.Z();
        int i = 62;
        if (iZ == 3 || iZ == 4) {
            if (!aVar.d.a()) {
                i = 68;
            }
        } else if (iZ != 5) {
            if (iZ != 34) {
                if (iZ == 51) {
                    i = 2041;
                } else if (iZ == 63) {
                    i = 25;
                } else if (iZ == 71) {
                    i = aVar.d.a() ? 2058 : 2061;
                } else if (iZ == 60) {
                    i = 76;
                } else if (iZ != 61) {
                    i = 0;
                }
            } else if (!aVar.d.a()) {
                i = 2073;
            }
        } else if (aVar.d.a()) {
            i = 2026;
        }
        return a(context.getApplicationContext(), i, aVarA, interfaceC0778a);
    }

    private static j.a a(int i) {
        j.a aVar = new j.a();
        if (a(i, 1)) {
            aVar.a(new i());
        }
        if (a(i, 2)) {
            aVar.a(new com.opos.mobad.template.c.b());
        }
        if (a(i, 4)) {
            aVar.a(new com.opos.mobad.template.c.f());
        }
        if (a(i, 8)) {
            aVar.a(new h());
        }
        if (a(i, 16)) {
            aVar.a(new com.opos.mobad.template.c.g());
        }
        return aVar;
    }

    public static b a() {
        return C0806b.f10246a;
    }

    public void a(a aVar) {
        this.f10244a = aVar;
        if (this.e == null) {
            this.e = new com.opos.mobad.template.f(this.d, this.c);
        }
    }

    private static boolean a(int i, int i2) {
        return i == -1 || (i & i2) == i2;
    }
}
