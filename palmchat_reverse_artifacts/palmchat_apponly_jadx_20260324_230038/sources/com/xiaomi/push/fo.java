package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import j$.util.DesugarTimeZone;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public abstract class fo {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final DateFormat f465a;
    private static long b;
    private static String c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f467a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private fs f468a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<fl> f469a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Map<String, Object> f470a;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final String f11577a = Locale.getDefault().getLanguage().toLowerCase();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static String f466b = null;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f465a = simpleDateFormat;
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        c = fx.a(5) + "-";
        b = 0L;
    }

    public fo() {
        this.d = f466b;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f469a = new CopyOnWriteArrayList();
        this.f470a = new HashMap();
        this.f468a = null;
    }

    public static synchronized String i() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(c);
        long j = b;
        b = 1 + j;
        sb.append(Long.toString(j));
        return sb.toString();
    }

    public static String q() {
        return f11577a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public fs m456a() {
        return this.f468a;
    }

    /* JADX INFO: renamed from: a */
    public abstract String mo455a();

    public synchronized Collection<String> b() {
        if (this.f470a == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.f470a.keySet()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        fo foVar = (fo) obj;
        fs fsVar = this.f468a;
        if (fsVar == null ? foVar.f468a != null : !fsVar.equals(foVar.f468a)) {
            return false;
        }
        String str = this.g;
        if (str == null ? foVar.g != null : !str.equals(foVar.g)) {
            return false;
        }
        if (!this.f469a.equals(foVar.f469a)) {
            return false;
        }
        String str2 = this.e;
        if (str2 == null ? foVar.e != null : !str2.equals(foVar.e)) {
            return false;
        }
        String str3 = this.h;
        if (str3 == null ? foVar.h != null : !str3.equals(foVar.h)) {
            return false;
        }
        Map<String, Object> map = this.f470a;
        if (map == null ? foVar.f470a != null : !map.equals(foVar.f470a)) {
            return false;
        }
        String str4 = this.f;
        if (str4 == null ? foVar.f != null : !str4.equals(foVar.f)) {
            return false;
        }
        String str5 = this.d;
        String str6 = foVar.d;
        if (str5 != null) {
            if (str5.equals(str6)) {
                return true;
            }
        } else if (str6 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.d;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.e;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.g;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.h;
        int iHashCode5 = (((((iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f469a.hashCode()) * 31) + this.f470a.hashCode()) * 31;
        fs fsVar = this.f468a;
        return iHashCode5 + (fsVar != null ? fsVar.hashCode() : 0);
    }

    public String j() {
        if ("ID_NOT_AVAILABLE".equals(this.e)) {
            return null;
        }
        if (this.e == null) {
            this.e = i();
        }
        return this.e;
    }

    public void k(String str) {
        this.e = str;
    }

    public void l(String str) {
        this.h = str;
    }

    public void m(String str) {
        this.f = str;
    }

    public void n(String str) {
        this.g = str;
    }

    public void o(String str) {
        this.i = str;
    }

    public String p() {
        return this.d;
    }

    public void a(fs fsVar) {
        this.f468a = fsVar;
    }

    public String k() {
        return this.h;
    }

    public String l() {
        return this.f;
    }

    public String m() {
        return this.g;
    }

    public String n() {
        return this.i;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0123 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x011b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String o() {
        StringBuilder sb;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        Exception e;
        sb = new StringBuilder();
        Iterator<fl> it = m458a().iterator();
        while (it.hasNext()) {
            sb.append(it.next().d());
        }
        Map<String, Object> map = this.f470a;
        if (map != null && !map.isEmpty()) {
            sb.append(ay.b("PHByb3BlcnRpZXMgeG1sbnM9Imh0dHA6Ly93d3cuaml2ZXNvZnR3YXJlLmNvbS94bWxucy94bXBwL3Byb3BlcnRpZXMiPg=="));
            for (String str : b()) {
                Object objM457a = m457a(str);
                sb.append("<property>");
                sb.append("<name>");
                sb.append(fx.a(str));
                sb.append("</name>");
                sb.append("<value type=\"");
                if (objM457a instanceof Integer) {
                    sb.append("integer\">");
                    sb.append(objM457a);
                    sb.append("</value>");
                } else if (objM457a instanceof Long) {
                    sb.append("long\">");
                    sb.append(objM457a);
                    sb.append("</value>");
                } else if (objM457a instanceof Float) {
                    sb.append("float\">");
                    sb.append(objM457a);
                    sb.append("</value>");
                } else if (objM457a instanceof Double) {
                    sb.append("double\">");
                    sb.append(objM457a);
                    sb.append("</value>");
                } else if (objM457a instanceof Boolean) {
                    sb.append("boolean\">");
                    sb.append(objM457a);
                    sb.append("</value>");
                } else if (objM457a instanceof String) {
                    sb.append("string\">");
                    sb.append(fx.a((String) objM457a));
                    sb.append("</value>");
                } else {
                    ObjectOutputStream objectOutputStream2 = null;
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                            try {
                                try {
                                    objectOutputStream.writeObject(objM457a);
                                    sb.append("java-object\">");
                                    sb.append(fx.a(byteArrayOutputStream.toByteArray()));
                                    sb.append("</value>");
                                    try {
                                        objectOutputStream.close();
                                    } catch (Exception unused) {
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    if (objectOutputStream != null) {
                                        try {
                                            objectOutputStream.close();
                                        } catch (Exception unused2) {
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    sb.append("</property>");
                                }
                            } catch (Throwable th) {
                                th = th;
                                objectOutputStream2 = objectOutputStream;
                                if (objectOutputStream2 != null) {
                                    try {
                                        objectOutputStream2.close();
                                    } catch (Exception unused3) {
                                    }
                                }
                                if (byteArrayOutputStream == null) {
                                    throw th;
                                }
                                try {
                                    byteArrayOutputStream.close();
                                    throw th;
                                } catch (Exception unused4) {
                                    throw th;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            objectOutputStream = null;
                            e = e;
                            e.printStackTrace();
                            if (objectOutputStream != null) {
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            sb.append("</property>");
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        byteArrayOutputStream = null;
                        objectOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayOutputStream = null;
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused5) {
                    }
                }
                sb.append("</property>");
            }
            sb.append("</properties>");
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized Collection<fl> m458a() {
        if (this.f469a == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.f469a));
    }

    public fl a(String str) {
        return a(str, null);
    }

    public fl a(String str, String str2) {
        for (fl flVar : this.f469a) {
            if (str2 == null || str2.equals(flVar.b())) {
                if (str.equals(flVar.m452a())) {
                    return flVar;
                }
            }
        }
        return null;
    }

    public void a(fl flVar) {
        this.f469a.add(flVar);
    }

    public fo(Bundle bundle) {
        this.d = f466b;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f469a = new CopyOnWriteArrayList();
        this.f470a = new HashMap();
        this.f468a = null;
        this.f = bundle.getString("ext_to");
        this.g = bundle.getString("ext_from");
        this.h = bundle.getString("ext_chid");
        this.e = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f469a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                fl flVarA = fl.a((Bundle) parcelable);
                if (flVarA != null) {
                    this.f469a.add(flVarA);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f468a = new fs(bundle2);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized Object m457a(String str) {
        Map<String, Object> map = this.f470a;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.d)) {
            bundle.putString("ext_ns", this.d);
        }
        if (!TextUtils.isEmpty(this.g)) {
            bundle.putString("ext_from", this.g);
        }
        if (!TextUtils.isEmpty(this.f)) {
            bundle.putString("ext_to", this.f);
        }
        if (!TextUtils.isEmpty(this.e)) {
            bundle.putString("ext_pkt_id", this.e);
        }
        if (!TextUtils.isEmpty(this.h)) {
            bundle.putString("ext_chid", this.h);
        }
        fs fsVar = this.f468a;
        if (fsVar != null) {
            bundle.putBundle("ext_ERROR", fsVar.a());
        }
        List<fl> list = this.f469a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            Iterator<fl> it = this.f469a.iterator();
            int i = 0;
            while (it.hasNext()) {
                Bundle bundleA = it.next().a();
                if (bundleA != null) {
                    bundleArr[i] = bundleA;
                    i++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }
}
