package com.baidu.mapsdkplatform.comapi.favrite;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comjni.map.favorite.NAFavorite;
import com.cdo.oaps.ad.OapsKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f3969a;
    private NAFavorite b = null;
    private boolean c = false;
    private boolean d = false;
    private Vector<String> e = null;
    private Vector<String> f = null;
    private boolean g = false;
    private d h;
    private c i;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Comparator<String> {
        public b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str2.compareTo(str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f3971a;
        private long b;

        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            return this.b - this.f3971a > 1000;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.b = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            this.f3971a = System.currentTimeMillis();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f3972a;
        private long b;
        private long c;

        private d() {
            this.b = 5000L;
            this.c = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            return TextUtils.isEmpty(this.f3972a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            this.f3972a = str;
            this.c = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a() {
            return this.f3972a;
        }
    }

    private a() {
        this.h = new d();
        this.i = new c();
    }

    public static a f() {
        if (f3969a == null) {
            synchronized (a.class) {
                if (f3969a == null) {
                    a aVar = new a();
                    f3969a = aVar;
                    aVar.g();
                }
            }
        }
        return f3969a;
    }

    private boolean g() {
        if (this.b == null) {
            NAFavorite nAFavorite = new NAFavorite();
            this.b = nAFavorite;
            if (nAFavorite.b() == 0) {
                this.b = null;
                return false;
            }
            h();
            i();
        }
        return true;
    }

    private void h() {
        this.c = false;
        this.d = false;
    }

    private boolean i() {
        if (this.b == null) {
            return false;
        }
        String str = SysOSUtil.getModuleFileName() + "/";
        this.b.a(1);
        return this.b.a(str, "fav_poi", "fifo", 10, 501, -1);
    }

    public static boolean j() {
        NAFavorite nAFavorite;
        a aVar = f3969a;
        return (aVar == null || (nAFavorite = aVar.b) == null || !nAFavorite.d()) ? false : true;
    }

    public synchronized int a(String str, FavSyncPoi favSyncPoi) {
        if (this.b == null) {
            return 0;
        }
        if (str != null && !str.equals("") && favSyncPoi != null) {
            h();
            ArrayList<String> arrayListD = d();
            if ((arrayListD != null ? arrayListD.size() : 0) + 1 > 500) {
                return -2;
            }
            if (arrayListD != null && arrayListD.size() > 0) {
                Iterator<String> it = arrayListD.iterator();
                while (it.hasNext()) {
                    FavSyncPoi favSyncPoiB = b(it.next());
                    if (favSyncPoiB != null && str.equals(favSyncPoiB.b)) {
                        return -1;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                favSyncPoi.b = str;
                String strValueOf = String.valueOf(System.currentTimeMillis());
                String str2 = strValueOf + "_" + favSyncPoi.hashCode();
                favSyncPoi.h = strValueOf;
                favSyncPoi.f3968a = str2;
                jSONObject.put("bdetail", favSyncPoi.i);
                jSONObject.put("uspoiname", favSyncPoi.b);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("x", favSyncPoi.c.getDoubleX());
                jSONObject2.put("y", favSyncPoi.c.getDoubleY());
                jSONObject.put(OapsKey.KEY_PAGE_TYPE, jSONObject2);
                jSONObject.put("ncityid", favSyncPoi.e);
                jSONObject.put("npoitype", favSyncPoi.g);
                jSONObject.put("uspoiuid", favSyncPoi.f);
                jSONObject.put("addr", favSyncPoi.d);
                jSONObject.put("addtimesec", favSyncPoi.h);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("Fav_Sync", jSONObject);
                jSONObject3.put("Fav_Content", favSyncPoi.j);
                if (!this.b.a(str2, jSONObject3.toString())) {
                    return 0;
                }
                h();
                return 1;
            } catch (JSONException unused) {
                return 0;
            } finally {
                j();
            }
        }
        return -1;
    }

    public void b() {
        a aVar = f3969a;
        if (aVar != null) {
            NAFavorite nAFavorite = aVar.b;
            if (nAFavorite != null) {
                nAFavorite.c();
                f3969a.b = null;
            }
            f3969a = null;
        }
    }

    public boolean c(String str) {
        return (this.b == null || str == null || str.equals("") || !this.b.b(str)) ? false : true;
    }

    public ArrayList<String> d() {
        if (this.b == null) {
            return null;
        }
        if (this.c && this.e != null) {
            return new ArrayList<>(this.e);
        }
        try {
            Bundle bundle = new Bundle();
            this.b.a(bundle);
            String[] stringArray = bundle.getStringArray("rstString");
            if (stringArray != null) {
                Vector<String> vector = this.e;
                if (vector == null) {
                    this.e = new Vector<>();
                } else {
                    vector.clear();
                }
                for (String str : stringArray) {
                    if (!str.equals("data_version")) {
                        this.e.add(str);
                    }
                }
                if (this.e.size() > 0) {
                    try {
                        Collections.sort(this.e, new b());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.c = true;
                }
            } else {
                Vector<String> vector2 = this.e;
                if (vector2 != null) {
                    vector2.clear();
                    this.e = null;
                }
            }
            Vector<String> vector3 = this.e;
            if (vector3 == null || vector3.size() == 0) {
                return null;
            }
            return new ArrayList<>(this.e);
        } catch (Exception unused) {
            return null;
        }
    }

    public ArrayList<String> e() {
        String strA;
        if (this.b == null) {
            return null;
        }
        if (this.d && this.f != null) {
            return new ArrayList<>(this.f);
        }
        try {
            Bundle bundle = new Bundle();
            this.b.a(bundle);
            String[] stringArray = bundle.getStringArray("rstString");
            if (stringArray != null) {
                Vector<String> vector = this.f;
                if (vector == null) {
                    this.f = new Vector<>();
                } else {
                    vector.clear();
                }
                for (int i = 0; i < stringArray.length; i++) {
                    if (!stringArray[i].equals("data_version") && (strA = this.b.a(stringArray[i])) != null && !strA.equals("")) {
                        this.f.add(stringArray[i]);
                    }
                }
                if (this.f.size() > 0) {
                    try {
                        Collections.sort(this.f, new b());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.d = true;
                }
            } else {
                Vector<String> vector2 = this.f;
                if (vector2 != null) {
                    vector2.clear();
                    this.f = null;
                }
            }
            Vector<String> vector3 = this.f;
            if (vector3 != null && !vector3.isEmpty()) {
                return new ArrayList<>(this.f);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public String c() {
        String strA;
        if (this.i.a() && !this.h.c() && !this.h.b()) {
            return this.h.a();
        }
        this.i.c();
        if (this.b == null) {
            return null;
        }
        ArrayList<String> arrayListE = e();
        JSONObject jSONObject = new JSONObject();
        if (arrayListE != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                int i = 0;
                for (String str : arrayListE) {
                    if (str != null && !str.equals("data_version") && (strA = this.b.a(str)) != null && !strA.equals("")) {
                        JSONObject jSONObjectOptJSONObject = new JSONObject(strA).optJSONObject("Fav_Sync");
                        jSONObjectOptJSONObject.put("key", str);
                        jSONArray.put(i, jSONObjectOptJSONObject);
                        i++;
                    }
                }
                if (i > 0) {
                    jSONObject.put("favcontents", jSONArray);
                    jSONObject.put("favpoinum", i);
                }
            } catch (JSONException unused) {
                return null;
            }
        }
        this.i.b();
        this.h.a(jSONObject.toString());
        return this.h.a();
    }

    public FavSyncPoi b(String str) {
        if (this.b != null && str != null && !str.equals("")) {
            try {
                if (!c(str)) {
                    return null;
                }
                FavSyncPoi favSyncPoi = new FavSyncPoi();
                String strA = this.b.a(str);
                if (strA != null && !strA.equals("")) {
                    JSONObject jSONObject = new JSONObject(strA);
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("Fav_Sync");
                    String strOptString = jSONObject.optString("Fav_Content");
                    favSyncPoi.b = jSONObjectOptJSONObject.optString("uspoiname");
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(OapsKey.KEY_PAGE_TYPE);
                    favSyncPoi.c = new Point(jSONObjectOptJSONObject2.optInt("x"), jSONObjectOptJSONObject2.optInt("y"));
                    favSyncPoi.e = jSONObjectOptJSONObject.optString("ncityid");
                    favSyncPoi.f = jSONObjectOptJSONObject.optString("uspoiuid");
                    favSyncPoi.g = jSONObjectOptJSONObject.optInt("npoitype");
                    favSyncPoi.d = jSONObjectOptJSONObject.optString("addr");
                    favSyncPoi.h = jSONObjectOptJSONObject.optString("addtimesec");
                    favSyncPoi.i = jSONObjectOptJSONObject.optBoolean("bdetail");
                    favSyncPoi.j = strOptString;
                    favSyncPoi.f3968a = str;
                    return favSyncPoi;
                }
                return null;
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public synchronized boolean b(String str, FavSyncPoi favSyncPoi) {
        boolean z = false;
        if (this.b != null && str != null && !str.equals("") && favSyncPoi != null) {
            if (!c(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uspoiname", favSyncPoi.b);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("x", favSyncPoi.c.getDoubleX());
                jSONObject2.put("y", favSyncPoi.c.getDoubleY());
                jSONObject.put(OapsKey.KEY_PAGE_TYPE, jSONObject2);
                jSONObject.put("ncityid", favSyncPoi.e);
                jSONObject.put("npoitype", favSyncPoi.g);
                jSONObject.put("uspoiuid", favSyncPoi.f);
                jSONObject.put("addr", favSyncPoi.d);
                String strValueOf = String.valueOf(System.currentTimeMillis());
                favSyncPoi.h = strValueOf;
                jSONObject.put("addtimesec", strValueOf);
                jSONObject.put("bdetail", false);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("Fav_Sync", jSONObject);
                jSONObject3.put("Fav_Content", favSyncPoi.j);
                h();
                NAFavorite nAFavorite = this.b;
                if (nAFavorite != null) {
                    if (nAFavorite.b(str, jSONObject3.toString())) {
                        z = true;
                    }
                }
                return z;
            } catch (JSONException unused) {
                return false;
            }
        }
        return false;
    }

    public synchronized boolean a(String str) {
        if (this.b == null) {
            return false;
        }
        if (str != null && !str.equals("")) {
            if (!c(str)) {
                return false;
            }
            h();
            return this.b.c(str);
        }
        return false;
    }

    public synchronized boolean a() {
        if (this.b == null) {
            return false;
        }
        h();
        boolean zA = this.b.a();
        j();
        return zA;
    }
}
