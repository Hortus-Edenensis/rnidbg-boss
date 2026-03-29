package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.beizi.fusion.BeiZiBiddingConstant;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class k27 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, gc7> f18561a = new ConcurrentHashMap();
    public String b;

    public HashMap<String, String> a(Context context, List<String> list) {
        String str;
        String str2;
        gc7 gc7Var;
        HashMap<String, String> mapE = e(context, list);
        if (list.isEmpty()) {
            str = "2040";
        } else {
            ArrayList arrayList = new ArrayList();
            if (this.f18561a.isEmpty()) {
                lx6.e(context, this.f18561a);
            }
            for (String str3 : list) {
                String str4 = null;
                if (this.f18561a.containsKey(str3) && (gc7Var = this.f18561a.get(str3)) != null) {
                    try {
                        if (!gc7Var.a(str3)) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(str3);
                            be7.a("1025");
                            lx6.f19099a.execute(new jx6(this, context, arrayList2));
                        }
                        str4 = gc7Var.f17711a;
                    } catch (Exception e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("1095: ");
                        sb.append(e.getMessage() != null ? e.getMessage() : e.getLocalizedMessage());
                        Log.e("IDHelper", sb.toString());
                    }
                }
                if (str4 == null) {
                    arrayList.add(str3);
                }
            }
            if (!arrayList.isEmpty()) {
                be7.a("1026");
                c(context, arrayList, false);
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String next = it.next();
                gc7 gc7Var2 = this.f18561a.get(next);
                if (gc7Var2 == null) {
                    str2 = next == "OUID_STATUS" ? "FALSE" : "";
                } else {
                    if (next.equals("OUID") || next.equals("OUID_STATUS")) {
                        this.f18561a.remove(next);
                    }
                    str2 = gc7Var2.f17711a;
                }
                mapE.put(next, str2);
            }
            str = "2025";
        }
        be7.a(str);
        return mapE;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(Context context, String str, String str2) {
        gc7 gc7Var;
        String str3;
        String str4;
        long j;
        if (str2 == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() + lx6.j(str);
        if (str.equals("GUID") || str.equals("APID") || !"".equals(str2)) {
            if (!this.f18561a.containsKey(str) || (gc7Var = this.f18561a.get(str)) == null) {
                gc7Var = new gc7(str2, jCurrentTimeMillis);
                this.f18561a.put(str, gc7Var);
            } else {
                gc7Var.f17711a = str2;
                gc7Var.b = jCurrentTimeMillis;
            }
            if (str.equals("OUID") || str.equals("OUID_STATUS")) {
                return;
            }
            try {
                byte b = 0;
                SharedPreferences.Editor editorEdit = context.getSharedPreferences("cache", 0).edit();
                int iHashCode = str.hashCode();
                if (iHashCode != 2015626) {
                    if (iHashCode != 2020431) {
                        if (iHashCode != 2109804) {
                            b = (iHashCode == 2199177 && str.equals("GUID")) ? (byte) 1 : (byte) -1;
                        } else if (str.equals("DUID")) {
                            b = 3;
                        }
                    } else if (str.equals("AUID")) {
                        b = 2;
                    }
                } else if (!str.equals("APID")) {
                }
                if (b == 0) {
                    lx6.f(editorEdit, gc7Var, "APID", "APID_TIME", "APID_IV");
                } else if (b != 1) {
                    if (b == 2) {
                        str4 = "AUID_TIME";
                        editorEdit.putString("AUID", gc7Var.f17711a);
                        j = gc7Var.b;
                    } else if (b == 3) {
                        str4 = "DUID_TIME";
                        editorEdit.putString("DUID", gc7Var.f17711a);
                        j = gc7Var.b;
                    }
                    editorEdit.putLong(str4, j);
                } else {
                    lx6.f(editorEdit, gc7Var, "GUID", "GUID_TIME", "GUID_IV");
                }
                editorEdit.apply();
            } catch (IllegalStateException e) {
                e = e;
                str3 = BeiZiBiddingConstant.Adn.ADN_KS;
                be7.b(str3, e);
            } catch (Exception e2) {
                e = e2;
                str3 = "1063";
                be7.b(str3, e);
            }
        }
    }

    public void c(Context context, List<String> list, boolean z) {
        throw null;
    }

    public boolean d(String str) {
        return !this.f18561a.isEmpty() && this.f18561a.containsKey(str);
    }

    public HashMap<String, String> e(Context context, List<String> list) {
        return new HashMap<>();
    }

    public boolean f(String str) {
        if (!this.f18561a.isEmpty() && this.f18561a.containsKey(str)) {
            try {
                gc7 gc7Var = this.f18561a.get(str);
                if (gc7Var != null) {
                    if (gc7Var.a(str)) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("1094: ");
                sb.append(e.getMessage() != null ? e.getMessage() : e.getLocalizedMessage());
                Log.e("IDHelper", sb.toString());
            }
        }
        return false;
    }
}
