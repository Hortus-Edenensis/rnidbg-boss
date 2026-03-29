package com.opos.mobad.video.player.h.b;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.downloader.f;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.FloatLayerData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.utils.e;
import com.opos.mobad.template.a;
import com.opos.mobad.template.h.o;
import com.opos.mobad.template.h.r;
import com.opos.mobad.template.h.t;
import com.opos.mobad.video.player.h.a.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f10373a;
    private com.opos.mobad.d.a b = new com.opos.mobad.downloader.a();

    private a() {
    }

    public static int a(Context context, AdItemData adItemData) {
        if (context != null && adItemData != null && adItemData.i() != null) {
            MaterialData materialDataA = com.opos.mobad.model.utils.a.a(adItemData);
            boolean zA = e.a(adItemData, materialDataA);
            if (materialDataA != null) {
                FloatLayerData floatLayerDataR = materialDataA.R();
                if (!zA && floatLayerDataR == null) {
                    return 0;
                }
                int iAa = materialDataA.aa();
                if (!a(floatLayerDataR, iAa) && !b(floatLayerDataR, iAa)) {
                    return materialDataA.aa();
                }
                return a(context, adItemData, iAa);
            }
        }
        return 0;
    }

    private static final boolean b(FloatLayerData floatLayerData) {
        if (floatLayerData.d() != null && floatLayerData.d().size() > 0 && floatLayerData.d().get(0) != null && !TextUtils.isEmpty(floatLayerData.d().get(0).a())) {
            try {
                return !f.a().a(floatLayerData.d().get(0).a());
            } catch (Exception unused) {
            }
        }
        return true;
    }

    private static int a(Context context, AdItemData adItemData, int i) {
        int iL = adItemData.L();
        boolean zA = iL != 0 ? iL != 1 : a(context);
        com.opos.cmn.an.f.a.b("FloatLayerTemplateFactory", "check float endPage but material unused " + i);
        return zA ? 1 : 2;
    }

    private static boolean b(FloatLayerData floatLayerData, int i) {
        return i == 5 && a(floatLayerData);
    }

    public com.opos.mobad.template.a a(Context context, int i, a.InterfaceC0778a interfaceC0778a) {
        com.opos.mobad.template.a dVar;
        com.opos.mobad.template.a aVarA;
        switch (i) {
            case 3:
                dVar = new d(context, i, interfaceC0778a, this.b);
                aVarA = dVar;
                break;
            case 4:
                dVar = new com.opos.mobad.video.player.h.a.c(context, i, interfaceC0778a, this.b);
                aVarA = dVar;
                break;
            case 5:
                aVarA = null;
                break;
            case 6:
                aVarA = r.a(context, this.b, i);
                aVarA.a(interfaceC0778a);
                break;
            case 7:
                aVarA = o.a(context, this.b, i);
                aVarA.a(interfaceC0778a);
                break;
            case 8:
                aVarA = o.b(context, this.b, i);
                aVarA.a(interfaceC0778a);
                break;
            case 9:
                aVarA = t.a(context, this.b, i);
                aVarA.a(interfaceC0778a);
                break;
            case 10:
                aVarA = t.b(context, this.b, i);
                aVarA.a(interfaceC0778a);
                break;
            default:
                dVar = new com.opos.mobad.video.player.h.a.b(context, i, interfaceC0778a, this.b);
                aVarA = dVar;
                break;
        }
        com.opos.cmn.an.f.a.b("FloatLayerTemplateFactory", "createTemplate()", "templateId=" + com.opos.mobad.video.player.g.d.a(aVarA));
        return aVarA;
    }

    public com.opos.mobad.template.a a(Context context, AdItemData adItemData, a.InterfaceC0778a interfaceC0778a) {
        int iA = a(context, adItemData);
        com.opos.cmn.an.f.a.b("FloatLayerTemplateFactory", "createTemplateCheckMaterial()", "templateId=", Integer.valueOf(iA));
        return a(context, iA, interfaceC0778a);
    }

    public static final a a() {
        a aVar;
        a aVar2 = f10373a;
        if (aVar2 != null) {
            return aVar2;
        }
        synchronized (a.class) {
            aVar = f10373a;
            if (aVar == null) {
                aVar = new a();
                f10373a = aVar;
            }
        }
        return aVar;
    }

    public static boolean a(Context context) {
        int i;
        return context == null || (i = com.opos.cmn.an.h.f.a.i(context)) == 0 || i == 180;
    }

    public static final boolean a(FloatLayerData floatLayerData) {
        if (floatLayerData.e() != null && floatLayerData.e().size() > 0 && floatLayerData.e().get(0) != null && !TextUtils.isEmpty(floatLayerData.e().get(0).a())) {
            try {
                return !f.a().a(floatLayerData.e().get(0).a());
            } catch (Exception unused) {
            }
        }
        return true;
    }

    private static boolean a(FloatLayerData floatLayerData, int i) {
        return (i == 4 || i == 3) && b(floatLayerData);
    }
}
