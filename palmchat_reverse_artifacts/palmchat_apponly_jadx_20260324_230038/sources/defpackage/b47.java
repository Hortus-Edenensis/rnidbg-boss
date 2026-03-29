package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.huawei.agconnect.core.ServiceDiscovery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b47 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1648a;

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements Serializable, Comparator<Map.Entry<String, Integer>> {
        public b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
            return entry.getValue().intValue() - entry2.getValue().intValue();
        }
    }

    public b47(Context context) {
        this.f1648a = context;
    }

    public final <T extends g65> T a(String str) {
        StringBuilder sb;
        String string;
        try {
            Class<?> cls = Class.forName(str);
            if (g65.class.isAssignableFrom(cls)) {
                return (T) Class.forName(str).newInstance();
            }
            Log.e("AGC_Registrar", cls + " must extends from ServiceRegistrar.");
            return null;
        } catch (ClassNotFoundException e) {
            string = "Can not found service class, " + e.getMessage();
            Log.e("AGC_Registrar", string);
            return null;
        } catch (IllegalAccessException e2) {
            e = e2;
            sb = new StringBuilder();
            sb.append("instantiate service class exception ");
            sb.append(e.getLocalizedMessage());
            string = sb.toString();
            Log.e("AGC_Registrar", string);
            return null;
        } catch (InstantiationException e3) {
            e = e3;
            sb = new StringBuilder();
            sb.append("instantiate service class exception ");
            sb.append(e.getLocalizedMessage());
            string = sb.toString();
            Log.e("AGC_Registrar", string);
            return null;
        }
    }

    public List<z55> b() {
        Log.i("AGC_Registrar", "getServices");
        List<String> listC = c();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = listC.iterator();
        while (it.hasNext()) {
            g65 g65VarA = a(it.next());
            if (g65VarA != null) {
                g65VarA.b(this.f1648a);
                List<z55> listA = g65VarA.a(this.f1648a);
                if (listA != null) {
                    arrayList.addAll(listA);
                }
            }
        }
        Log.i("AGC_Registrar", "services:" + arrayList.size());
        return arrayList;
    }

    public final List<String> c() {
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        Bundle bundleD = d();
        if (bundleD == null) {
            return arrayList;
        }
        HashMap map = new HashMap(10);
        for (String message : bundleD.keySet()) {
            if ("com.huawei.agconnect.core.ServiceRegistrar".equals(bundleD.getString(message))) {
                String[] strArrSplit = message.split(":");
                if (strArrSplit.length == 2) {
                    try {
                        map.put(strArrSplit[0], Integer.valueOf(strArrSplit[1]));
                    } catch (NumberFormatException e) {
                        sb = new StringBuilder();
                        sb.append("registrar configuration format error:");
                        message = e.getMessage();
                        sb.append(message);
                        Log.e("AGC_Registrar", sb.toString());
                    }
                } else if (strArrSplit.length == 1) {
                    map.put(strArrSplit[0], 1000);
                } else {
                    sb = new StringBuilder();
                    sb.append("registrar configuration error, ");
                    sb.append(message);
                    Log.e("AGC_Registrar", sb.toString());
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(map.entrySet());
        Collections.sort(arrayList2, new b());
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Map.Entry) it.next()).getKey());
        }
        return arrayList;
    }

    public final Bundle d() {
        ServiceInfo serviceInfo;
        PackageManager packageManager = this.f1648a.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            serviceInfo = packageManager.getServiceInfo(new ComponentName(this.f1648a, (Class<?>) ServiceDiscovery.class), 128);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("AGC_Registrar", "get ServiceDiscovery exception." + e.getLocalizedMessage());
        }
        if (serviceInfo != null) {
            return serviceInfo.metaData;
        }
        Log.e("AGC_Registrar", "Can not found ServiceDiscovery service.");
        return null;
    }
}
