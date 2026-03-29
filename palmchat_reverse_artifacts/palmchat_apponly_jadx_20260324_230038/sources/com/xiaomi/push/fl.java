package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class fl implements fp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11573a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<fl> f459a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String[] f460a;
    private String b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private String[] f461b;
    private String c;

    public fl(String str, String str2, String[] strArr, String[] strArr2) {
        this.f459a = null;
        this.f11573a = str;
        this.b = str2;
        this.f460a = strArr;
        this.f461b = strArr2;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m452a() {
        return this.f11573a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return !TextUtils.isEmpty(this.c) ? fx.b(this.c) : this.c;
    }

    @Override // com.xiaomi.push.fp
    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(this.f11573a);
        if (!TextUtils.isEmpty(this.b)) {
            sb.append(" ");
            sb.append("xmlns=");
            sb.append("\"");
            sb.append(this.b);
            sb.append("\"");
        }
        String[] strArr = this.f460a;
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < this.f460a.length; i++) {
                if (!TextUtils.isEmpty(this.f461b[i])) {
                    sb.append(" ");
                    sb.append(this.f460a[i]);
                    sb.append("=\"");
                    sb.append(fx.a(this.f461b[i]));
                    sb.append("\"");
                }
            }
        }
        if (TextUtils.isEmpty(this.c)) {
            List<fl> list = this.f459a;
            if (list == null || list.size() <= 0) {
                sb.append("/>");
            } else {
                sb.append(">");
                Iterator<fl> it = this.f459a.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().d());
                }
                sb.append("</");
                sb.append(this.f11573a);
                sb.append(">");
            }
        } else {
            sb.append(">");
            sb.append(this.c);
            sb.append("</");
            sb.append(this.f11573a);
            sb.append(">");
        }
        return sb.toString();
    }

    public String toString() {
        return d();
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.f11573a);
        bundle.putString("ext_ns", this.b);
        bundle.putString("ext_text", this.c);
        Bundle bundle2 = new Bundle();
        String[] strArr = this.f460a;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                String[] strArr2 = this.f460a;
                if (i >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i], this.f461b[i]);
                i++;
            }
        }
        bundle.putBundle("attributes", bundle2);
        List<fl> list = this.f459a;
        if (list != null && list.size() > 0) {
            bundle.putParcelableArray("children", a(this.f459a));
        }
        return bundle;
    }

    public fl(String str, String str2, String[] strArr, String[] strArr2, String str3, List<fl> list) {
        this.f11573a = str;
        this.b = str2;
        this.f460a = strArr;
        this.f461b = strArr2;
        this.c = str3;
        this.f459a = list;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Parcelable m451a() {
        return a();
    }

    public static Parcelable[] a(fl[] flVarArr) {
        if (flVarArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[flVarArr.length];
        for (int i = 0; i < flVarArr.length; i++) {
            parcelableArr[i] = flVarArr[i].m451a();
        }
        return parcelableArr;
    }

    public static Parcelable[] a(List<fl> list) {
        return a((fl[]) list.toArray(new fl[list.size()]));
    }

    public static fl a(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> setKeySet = bundle2.keySet();
        String[] strArr = new String[setKeySet.size()];
        String[] strArr2 = new String[setKeySet.size()];
        int i = 0;
        for (String str : setKeySet) {
            strArr[i] = str;
            strArr2[i] = bundle2.getString(str);
            i++;
        }
        if (bundle.containsKey("children")) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("children");
            ArrayList arrayList2 = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList2.add(a((Bundle) parcelable));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new fl(string, string2, strArr, strArr2, string3, arrayList);
    }

    public String a(String str) {
        if (str != null) {
            if (this.f460a == null) {
                return null;
            }
            int i = 0;
            while (true) {
                String[] strArr = this.f460a;
                if (i >= strArr.length) {
                    return null;
                }
                if (str.equals(strArr[i])) {
                    return this.f461b[i];
                }
                i++;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void a(fl flVar) {
        if (this.f459a == null) {
            this.f459a = new ArrayList();
        }
        if (this.f459a.contains(flVar)) {
            return;
        }
        this.f459a.add(flVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m453a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.c = fx.a(str);
        } else {
            this.c = str;
        }
    }
}
