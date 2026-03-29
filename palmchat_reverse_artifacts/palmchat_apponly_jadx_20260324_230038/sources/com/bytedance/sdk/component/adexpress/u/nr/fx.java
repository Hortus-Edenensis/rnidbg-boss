package com.bytedance.sdk.component.adexpress.u.nr;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.adexpress.u.fx.u;
import com.bytedance.sdk.component.utils.bf;
import com.bytedance.sdk.component.utils.k;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class fx {
    public void fx(List<u.C0206u> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<u.C0206u> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(u(), com.bytedance.sdk.component.utils.x.nr(it.next().u()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public List<u.C0206u> nr(com.bytedance.sdk.component.adexpress.u.fx.u uVar, com.bytedance.sdk.component.adexpress.u.fx.u uVar2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (uVar2 == null || uVar2.getResources().isEmpty()) {
            arrayList2.addAll(uVar.getResources());
        } else if (uVar.getResources().isEmpty()) {
            arrayList.addAll(uVar2.getResources());
        } else {
            for (u.C0206u c0206u : uVar.getResources()) {
                if (!uVar2.getResources().contains(c0206u) && c0206u != null && c0206u.u() != null && c0206u.nr() != null) {
                    arrayList2.add(c0206u);
                }
            }
            for (u.C0206u c0206u2 : uVar2.getResources()) {
                if (!uVar.getResources().contains(c0206u2)) {
                    arrayList.add(c0206u2);
                }
            }
        }
        if (u(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    public abstract File u();

    public boolean u(Map<String, com.bytedance.sdk.component.adexpress.u.fx.u> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.component.adexpress.u.fx.u uVar = map.get(it.next());
            if (uVar != null && !u(uVar.getResources())) {
                return false;
            }
        }
        return true;
    }

    public boolean u(List<u.C0206u> list) {
        if (list == null || list.size() <= 0 || u() == null) {
            return false;
        }
        for (u.C0206u c0206u : list) {
            String strNr = com.bytedance.sdk.component.utils.x.nr(c0206u.u());
            if (TextUtils.isEmpty(strNr)) {
                return false;
            }
            File file = new File(u(), strNr);
            String strU = com.bytedance.sdk.component.utils.x.u(file);
            if (!file.exists() || !file.isFile() || c0206u.nr() == null || !c0206u.nr().equals(strU)) {
                return false;
            }
        }
        return true;
    }

    public static boolean fx(com.bytedance.sdk.component.adexpress.u.fx.u uVar, com.bytedance.sdk.component.adexpress.u.fx.u uVar2) {
        if (uVar != null) {
            try {
                if (!TextUtils.isEmpty(uVar.fx())) {
                    if (uVar2 == null) {
                        return false;
                    }
                    if (u(uVar.fx(), uVar2.fx())) {
                        return true;
                    }
                    Map<String, com.bytedance.sdk.component.adexpress.u.fx.u> mapU = uVar.u();
                    Map<String, com.bytedance.sdk.component.adexpress.u.fx.u> mapU2 = uVar2.u();
                    if (mapU.isEmpty()) {
                        return !mapU2.isEmpty();
                    }
                    if (mapU2.isEmpty()) {
                        return false;
                    }
                    return u(mapU, mapU2);
                }
            } catch (Throwable th) {
                th.getMessage();
                return false;
            }
        }
        return true;
    }

    public boolean u(u.nr nrVar) {
        if (nrVar == null || u() == null) {
            return false;
        }
        List<Pair<String, String>> listNr = nrVar.nr();
        if (listNr == null || listNr.size() <= 0) {
            return true;
        }
        Iterator<Pair<String, String>> it = listNr.iterator();
        while (it.hasNext()) {
            File file = new File(u(), (String) it.next().first);
            if (!file.exists() || !file.isFile()) {
                return false;
            }
        }
        return true;
    }

    public void nr(List<u.C0206u> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<u.C0206u> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(u(), com.bytedance.sdk.component.utils.x.nr(it.next().u()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public List<u.C0206u> u(com.bytedance.sdk.component.adexpress.u.fx.u uVar, com.bytedance.sdk.component.adexpress.u.fx.u uVar2) {
        Map<String, com.bytedance.sdk.component.adexpress.u.fx.u> mapU = uVar.u();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (mapU.size() == 0) {
            if (uVar2 != null && uVar2.u().size() != 0) {
                Map<String, com.bytedance.sdk.component.adexpress.u.fx.u> mapU2 = uVar2.u();
                Iterator<String> it = mapU2.keySet().iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.adexpress.u.fx.u uVar3 = mapU2.get(it.next());
                    if (uVar3 != null) {
                        arrayList.addAll(uVar3.getResources());
                    }
                }
            }
        } else if (uVar2 != null && uVar2.u().size() != 0) {
            Map<String, com.bytedance.sdk.component.adexpress.u.fx.u> mapU3 = uVar2.u();
            for (String str : mapU.keySet()) {
                com.bytedance.sdk.component.adexpress.u.fx.u uVar4 = mapU.get(str);
                com.bytedance.sdk.component.adexpress.u.fx.u uVar5 = mapU3.get(str);
                if (uVar5 == null && uVar4 != null) {
                    arrayList2.addAll(uVar4.getResources());
                } else if (uVar4 == null && uVar5 != null) {
                    arrayList.addAll(uVar5.getResources());
                } else if (uVar4 != null) {
                    for (u.C0206u c0206u : uVar4.getResources()) {
                        if (c0206u != null && !uVar5.getResources().contains(c0206u) && c0206u.nr() != null && c0206u.u() != null) {
                            arrayList2.add(c0206u);
                        }
                    }
                    for (u.C0206u c0206u2 : uVar5.getResources()) {
                        if (c0206u2 != null && !uVar4.getResources().contains(c0206u2)) {
                            arrayList.add(c0206u2);
                        }
                    }
                }
            }
        } else if (mapU.size() != 0) {
            Iterator<String> it2 = mapU.keySet().iterator();
            while (it2.hasNext()) {
                com.bytedance.sdk.component.adexpress.u.fx.u uVar6 = mapU.get(it2.next());
                if (uVar6 != null) {
                    arrayList2.addAll(uVar6.getResources());
                }
            }
        }
        if (u(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    public static void nr(File file, com.bytedance.sdk.component.adexpress.u.fx.u uVar, String str) {
        if (uVar == null || file == null) {
            return;
        }
        try {
            new File(file, str).delete();
        } catch (Throwable unused) {
        }
        if (uVar.getResources() != null) {
            Iterator<u.C0206u> it = uVar.getResources().iterator();
            while (it.hasNext()) {
                try {
                    new File(file, com.bytedance.sdk.component.utils.x.nr(it.next().u())).delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    private boolean u(List<u.C0206u> list, List<u.C0206u> list2) {
        for (u.C0206u c0206u : list) {
            String strU = c0206u.u();
            String strNr = com.bytedance.sdk.component.utils.x.nr(strU);
            File file = new File(u(), strNr);
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
            com.bytedance.sdk.component.a.nr.nr nrVarB = com.bytedance.sdk.component.adexpress.u.u.u.u().fx().b();
            nrVarB.u(strU);
            nrVarB.u(u().getAbsolutePath(), strNr);
            com.bytedance.sdk.component.a.nr nrVarU = nrVarB.u();
            list2.add(c0206u);
            if (nrVarU == null || !nrVarU.a() || nrVarU.n() == null || !nrVarU.n().exists()) {
                fx(list2);
                return false;
            }
        }
        return true;
    }

    public boolean u(String str) {
        String strNr = com.bytedance.sdk.component.utils.x.nr(str);
        File file = new File(u().getAbsoluteFile(), strNr + ".zip");
        com.bytedance.sdk.component.a.nr.nr nrVarB = com.bytedance.sdk.component.adexpress.u.u.u.u().fx().b();
        nrVarB.u(str);
        nrVarB.u(file.getParent(), file.getName());
        com.bytedance.sdk.component.a.nr nrVarU = nrVarB.u();
        if (nrVarU.a() && nrVarU.n() != null && nrVarU.n().exists()) {
            File fileN = nrVarU.n();
            try {
                bf.u(fileN.getAbsolutePath(), file.getParent());
                if (!fileN.exists()) {
                    return true;
                }
                fileN.delete();
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public void u(int i) {
        if (com.bytedance.sdk.component.adexpress.u.u.u.u().b() != null) {
            com.bytedance.sdk.component.adexpress.u.u.u.u().b().u(i);
        }
    }

    public static void u(File file, com.bytedance.sdk.component.adexpress.u.fx.u uVar, String str) {
        if (uVar == null) {
            return;
        }
        String strN = uVar.n();
        if (TextUtils.isEmpty(strN)) {
            return;
        }
        File file2 = new File(file, str);
        File file3 = new File(file2 + ".tmp");
        if (file3.exists()) {
            file3.delete();
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
            try {
                fileOutputStream2.write(strN.getBytes("utf-8"));
                if (file2.exists()) {
                    file2.delete();
                }
                file3.renameTo(file2);
                try {
                    fileOutputStream2.close();
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    k.u("PlayComponentEngineCacheManager", "version save error3", th);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (Throwable th2) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static boolean u(Map<String, com.bytedance.sdk.component.adexpress.u.fx.u> map, Map<String, com.bytedance.sdk.component.adexpress.u.fx.u> map2) {
        if (map.size() != map2.size()) {
            return true;
        }
        for (String str : map2.keySet()) {
            com.bytedance.sdk.component.adexpress.u.fx.u uVar = map.get(str);
            if (uVar == null) {
                return true;
            }
            com.bytedance.sdk.component.adexpress.u.fx.u uVar2 = map2.get(str);
            if (uVar2 == null) {
                return false;
            }
            if (u(uVar.fx(), uVar2.fx())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean u(String str, String str2) {
        String[] strArrSplit = str2.split("\\.");
        String[] strArrSplit2 = str.split("\\.");
        int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
        int i = 0;
        while (true) {
            if (i >= iMin) {
                break;
            }
            int length = strArrSplit[i].length() - strArrSplit2[i].length();
            if (length == 0) {
                int iCompareTo = strArrSplit[i].compareTo(strArrSplit2[i]);
                if (iCompareTo > 0) {
                    return true;
                }
                if (iCompareTo < 0) {
                    return false;
                }
                if (i == iMin - 1) {
                    return strArrSplit.length > strArrSplit2.length;
                }
                i++;
            } else if (length > 0) {
                return true;
            }
        }
    }

    @Deprecated
    public static boolean u(com.bytedance.sdk.component.adexpress.u.fx.u uVar, String str) {
        if (uVar == null) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(uVar.fx())) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return u(uVar.fx(), str);
        } catch (Throwable unused) {
            return false;
        }
    }
}
