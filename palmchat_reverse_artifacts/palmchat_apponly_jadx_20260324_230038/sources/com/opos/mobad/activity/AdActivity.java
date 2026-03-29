package com.opos.mobad.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.opos.mobad.activity.webview.WebDataHepler;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.opos.mobad.c.f;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.p.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class AdActivity extends AdBaseActivity {
    public static boolean b(Context context, ComplianceInfo complianceInfo, a.AbstractBinderC0760a abstractBinderC0760a) {
        return a(context, complianceInfo, 3, abstractBinderC0760a);
    }

    public static boolean c(Context context, ComplianceInfo complianceInfo, a.AbstractBinderC0760a abstractBinderC0760a) {
        return a(context, complianceInfo, 5, abstractBinderC0760a);
    }

    public com.opos.mobad.b a() {
        f fVarJ = com.opos.mobad.c.b.j();
        if (fVarJ == null || !fVarJ.a()) {
            return null;
        }
        return new com.opos.mobad.c(this, fVarJ.b(), fVarJ.c(), fVarJ.d(), fVarJ.e(), fVarJ.g(), new com.opos.mobad.e.b(getApplicationContext()));
    }

    public static void a(Context context, String str, String str2, AdItemData adItemData, String str3, com.opos.mobad.p.a aVar) {
        if (context != null) {
            Intent intent = new Intent(context, (Class<?>) AdActivity.class);
            intent.putExtra("webData", new WebDataHepler(adItemData, str, str3, str2, "", 1));
            Bundle bundle = new Bundle();
            if (aVar != null) {
                bundle.putBinder("webCallback", aVar.asBinder());
            }
            if (!bundle.isEmpty()) {
                intent.putExtras(bundle);
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static void a(Context context, String str, String str2, AdItemData adItemData, String str3, String str4, com.opos.mobad.p.a aVar, com.opos.mobad.p.c cVar) {
        if (context != null) {
            Intent intent = new Intent(context, (Class<?>) AdActivity.class);
            intent.putExtra("webData", new WebDataHepler(adItemData, str, str3, str2, str4, 2));
            Bundle bundle = new Bundle();
            if (aVar != null) {
                bundle.putBinder("webCallback", aVar.asBinder());
            }
            if (cVar != null) {
                bundle.putBinder("videoCallback", cVar.asBinder());
            }
            if (!bundle.isEmpty()) {
                intent.putExtras(bundle);
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    @Override // com.opos.mobad.activity.AdBaseActivity
    public void a(Intent intent) {
        a(a(), intent);
    }

    private static boolean a(Context context, ComplianceInfo complianceInfo, int i, a.AbstractBinderC0760a abstractBinderC0760a) {
        if (context == null) {
            return false;
        }
        try {
            Intent intent = new Intent(context, (Class<?>) AdActivity.class);
            intent.putExtra("webData", new WebDataHepler(complianceInfo, i));
            Bundle bundle = new Bundle();
            if (abstractBinderC0760a != null) {
                bundle.putBinder("webCallback", abstractBinderC0760a);
            }
            if (!bundle.isEmpty()) {
                intent.putExtras(bundle);
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("", "", (Throwable) e);
            return false;
        }
    }

    public static boolean a(Context context, ComplianceInfo complianceInfo, a.AbstractBinderC0760a abstractBinderC0760a) {
        return a(context, complianceInfo, 4, abstractBinderC0760a);
    }
}
