package com.heytap.msp.ipc.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.heytap.msp.ipc.annotation.IPCType;
import com.heytap.msp.ipc.common.exception.IPCBridgeException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<l> f6369a;
    private m b;
    protected Context h;
    protected com.heytap.msp.ipc.c.a i;
    protected Bundle j;
    protected List<com.heytap.msp.ipc.b.a> k = new ArrayList();

    /* JADX INFO: renamed from: com.heytap.msp.ipc.a.g$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6370a;

        static {
            int[] iArr = new int[IPCType.values().length];
            f6370a = iArr;
            try {
                iArr[IPCType.ACTIVITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6370a[IPCType.SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6370a[IPCType.PROVIDER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public g(List<l> list) {
        this.f6369a = list;
    }

    public Intent a(String str, String str2, String str3, Bundle bundle) {
        j.b("BaseActivityClient", "getActivityIntent --- packageName:" + str + ", targetComponentClass:" + str2 + ", action:" + str3 + ", bundle:" + bundle);
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                intent.setPackage(str);
            } else {
                intent.setComponent(new ComponentName(str, str2));
            }
        }
        if (!TextUtils.isEmpty(str3) && !"NoAction".equals(str3)) {
            intent.setAction(str3);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        return intent;
    }

    public abstract String a();

    public Intent b(String str, String str2, String str3, Bundle bundle) {
        j.b("BaseActivityClient", "getServiceIntent --- packageName:" + str + ", targetClass:" + str2 + ", action" + str3 + ", bundle:" + bundle);
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            intent.setComponent(new ComponentName(str, str2));
        }
        intent.setPackage(str);
        intent.setAction(str3);
        intent.putExtra("callingPackage", this.h.getPackageName());
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        return intent;
    }

    public abstract String b();

    public abstract IPCType c();

    public l a(Context context) throws IPCBridgeException {
        List<l> listA = a(context, this.h.getPackageManager());
        j.a("BaseActivityClient", "get targets:" + k.a(listA));
        if (listA.isEmpty()) {
            j.c("BaseActivityClient", "No target found for targets");
            throw new IPCBridgeException("No target found for all targets", 101001);
        }
        if (this.i == null) {
            l lVar = listA.get(0);
            j.a("BaseActivityClient", "select first package:" + lVar);
            return lVar;
        }
        j.a("BaseActivityClient", "serverFilter:" + this.i.getClass().getName());
        l lVarA = this.i.a(context, a(listA));
        if (lVarA == null || !listA.contains(lVarA)) {
            throw new IPCBridgeException("serverFilter block all app package", 101003);
        }
        j.a("BaseActivityClient", "filterr result" + lVarA);
        if (lVarA.d()) {
            return lVarA;
        }
        throw new IPCBridgeException("serverFilter return unknown package", 101003);
    }

    private List<l> a(Context context, PackageManager packageManager) {
        ProviderInfo providerInfoResolveContentProvider;
        ArrayList arrayList = new ArrayList();
        m mVar = this.b;
        for (l lVarA : mVar != null ? mVar.a_(context, this.f6369a) : this.f6369a) {
            m mVar2 = this.b;
            if (mVar2 != null) {
                lVarA = mVar2.a(context, lVarA);
            }
            if (lVarA == null || !lVarA.d()) {
                j.a("BaseActivityClient", "originTarget is not valid" + lVarA);
            } else {
                int i = AnonymousClass1.f6370a[c().ordinal()];
                if (i == 1) {
                    for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(a(lVarA.b, a(), lVarA.d, null), 128)) {
                        ActivityInfo activityInfo = resolveInfo.activityInfo;
                        if (activityInfo != null && !TextUtils.isEmpty(activityInfo.packageName)) {
                            ActivityInfo activityInfo2 = resolveInfo.activityInfo;
                            l lVarB = l.b(activityInfo2.packageName, activityInfo2.processName, lVarA.d, activityInfo2.name);
                            if (lVarB != null) {
                                arrayList.add(lVarB);
                            }
                        }
                    }
                } else if (i == 2) {
                    for (ResolveInfo resolveInfo2 : packageManager.queryIntentServices(b(lVarA.b, a(), lVarA.d, null), 128)) {
                        ServiceInfo serviceInfo = resolveInfo2.serviceInfo;
                        if (serviceInfo != null && !TextUtils.isEmpty(serviceInfo.packageName)) {
                            ServiceInfo serviceInfo2 = resolveInfo2.serviceInfo;
                            l lVarB2 = l.b(serviceInfo2.packageName, serviceInfo2.processName, lVarA.d, serviceInfo2.name);
                            if (lVarB2 != null) {
                                arrayList.add(lVarB2);
                            }
                        }
                    }
                } else if (i == 3 && (providerInfoResolveContentProvider = packageManager.resolveContentProvider(lVarA.c, 128)) != null && !TextUtils.isEmpty(providerInfoResolveContentProvider.packageName) && (TextUtils.isEmpty(a()) || providerInfoResolveContentProvider.name.equals(a()))) {
                    l lVarA2 = l.a(providerInfoResolveContentProvider.packageName, providerInfoResolveContentProvider.processName, lVarA.c, providerInfoResolveContentProvider.name);
                    if (lVarA2 != null) {
                        arrayList.add(lVarA2);
                    }
                }
            }
        }
        return arrayList;
    }

    public List<l> a(List<l> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<l> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new l(it.next()));
        }
        return arrayList;
    }

    public void a(m mVar) {
        this.b = mVar;
    }
}
