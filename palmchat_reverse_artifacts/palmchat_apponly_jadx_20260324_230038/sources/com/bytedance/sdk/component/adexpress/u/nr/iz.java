package com.bytedance.sdk.component.adexpress.u.nr;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz {
    private static volatile iz nr = null;
    public static int u = 2000;
    private volatile ConcurrentHashMap<String, com.bytedance.sdk.component.adexpress.u.fx.fx> pn;
    private final Object b = new Object();
    private AtomicBoolean iz = new AtomicBoolean(false);
    private LruCache<String, com.bytedance.sdk.component.adexpress.u.fx.nr> x = new LruCache<String, com.bytedance.sdk.component.adexpress.u.fx.nr>(u) { // from class: com.bytedance.sdk.component.adexpress.u.nr.iz.1
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, com.bytedance.sdk.component.adexpress.u.fx.nr nrVar) {
            return 1;
        }
    };
    private Set<String> fx = Collections.synchronizedSet(new HashSet());

    private iz() {
    }

    private void b(String str) {
        LruCache<String, com.bytedance.sdk.component.adexpress.u.fx.nr> lruCache;
        if (TextUtils.isEmpty(str) || (lruCache = this.x) == null || lruCache.size() <= 0) {
            return;
        }
        synchronized (this.b) {
            this.x.remove(str);
        }
    }

    public static iz u() {
        if (nr == null) {
            synchronized (iz.class) {
                if (nr == null) {
                    nr = new iz();
                }
            }
        }
        return nr;
    }

    public void fx(String str) {
        com.bytedance.sdk.component.adexpress.u.fx.fx fxVar;
        try {
            if (this.pn == null || this.pn.isEmpty() || (fxVar = this.pn.get(str)) == null) {
                return;
            }
            String strU = fxVar.u();
            if (!TextUtils.isEmpty(strU) && com.bytedance.sdk.component.adexpress.u.u.u.u().iz() != null) {
                com.bytedance.sdk.component.adexpress.u.u.u.u().iz().delete(strU, str);
            }
            this.pn.remove(str);
        } catch (Throwable unused) {
        }
    }

    public Set<com.bytedance.sdk.component.adexpress.u.fx.nr> nr(String str) {
        com.bytedance.sdk.component.adexpress.u.fx.nr nrVar;
        if (TextUtils.isEmpty(str) || com.bytedance.sdk.component.adexpress.u.u.u.u().nr() == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Cursor cursorQuery = com.bytedance.sdk.component.adexpress.u.u.u.u().nr().query("template_diff_new", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        if (!TextUtils.isEmpty(string)) {
                            synchronized (this.b) {
                                nrVar = this.x.get(string);
                            }
                            if (nrVar != null) {
                                hashSet.add(nrVar);
                            } else {
                                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("md5"));
                                String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                                String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("data"));
                                String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("version"));
                                com.bytedance.sdk.component.adexpress.u.fx.nr nrVarU = new com.bytedance.sdk.component.adexpress.u.fx.nr().u(str).nr(string).fx(string2).b(string3).pn(string4).iz(string5).u(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("update_time"))));
                                hashSet.add(nrVarU);
                                synchronized (this.b) {
                                    this.x.put(string, nrVarU);
                                }
                                this.fx.add(string);
                            }
                        }
                    } while (cursorQuery.moveToNext());
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
            cursorQuery.close();
        }
        return hashSet;
    }

    public static String fx() {
        return new StringBuilder("CREATE TABLE IF NOT EXISTS template_diff_new (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , version TEXT , update_time TEXT)").toString();
    }

    public com.bytedance.sdk.component.adexpress.u.fx.nr u(String str) {
        com.bytedance.sdk.component.adexpress.u.fx.nr nrVar;
        com.bytedance.sdk.component.adexpress.u.fx.nr nrVarU;
        if (TextUtils.isEmpty(str) || com.bytedance.sdk.component.adexpress.u.u.u.u().nr() == null) {
            return null;
        }
        synchronized (this.b) {
            nrVar = this.x.get(String.valueOf(str));
        }
        if (nrVar != null) {
            return nrVar;
        }
        Cursor cursorQuery = com.bytedance.sdk.component.adexpress.u.u.u.u().nr().query("template_diff_new", null, "id=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("rit"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("md5"));
                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                        String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("data"));
                        String string6 = cursorQuery.getString(cursorQuery.getColumnIndex("version"));
                        nrVarU = new com.bytedance.sdk.component.adexpress.u.fx.nr().u(string).nr(string2).fx(string3).b(string4).pn(string5).iz(string6).u(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("update_time"))));
                        synchronized (this.b) {
                            this.x.put(string2, nrVarU);
                        }
                        this.fx.add(string2);
                    } while (cursorQuery.moveToNext());
                    return nrVarU;
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public List<com.bytedance.sdk.component.adexpress.u.fx.nr> nr() {
        if (com.bytedance.sdk.component.adexpress.u.u.u.u().nr() == null) {
            return null;
        }
        boolean z = this.iz.get();
        this.iz.set(true);
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = com.bytedance.sdk.component.adexpress.u.u.u.u().nr().query("template_diff_new", null, null, null, null, null, null);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("rit"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("md5"));
                    String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                    String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("data"));
                    String string6 = cursorQuery.getString(cursorQuery.getColumnIndex("version"));
                    arrayList.add(new com.bytedance.sdk.component.adexpress.u.fx.nr().u(string).nr(string2).fx(string3).b(string4).pn(string5).iz(string6).u(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("update_time")))));
                    synchronized (this.b) {
                        this.x.put(string2, arrayList.get(arrayList.size() - 1));
                    }
                    this.fx.add(string2);
                    if (!z && com.bytedance.sdk.component.adexpress.u.u.u.u().iz() != null) {
                        if (this.pn == null) {
                            this.pn = new ConcurrentHashMap<>();
                        }
                        if (string2 != null && !this.pn.contains(string2)) {
                            this.pn.put(string2, new com.bytedance.sdk.component.adexpress.u.fx.fx(string, string2, string3));
                        }
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }
        return arrayList;
    }

    public void u(com.bytedance.sdk.component.adexpress.u.fx.nr nrVar, boolean z) {
        if (nrVar == null || com.bytedance.sdk.component.adexpress.u.u.u.u().nr() == null || TextUtils.isEmpty(nrVar.nr())) {
            return;
        }
        Cursor cursorQuery = com.bytedance.sdk.component.adexpress.u.u.u.u().nr().query("template_diff_new", null, "id=?", new String[]{nrVar.nr()}, null, null, null);
        boolean z2 = cursorQuery != null && cursorQuery.getCount() > 0;
        if (cursorQuery != null) {
            try {
                string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("rit")) : null;
                cursorQuery.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", nrVar.u());
        contentValues.put("id", nrVar.nr());
        contentValues.put("md5", nrVar.fx());
        contentValues.put("url", nrVar.b());
        contentValues.put("data", nrVar.pn());
        contentValues.put("version", nrVar.iz());
        contentValues.put("update_time", nrVar.x());
        if (z2) {
            com.bytedance.sdk.component.adexpress.u.u.u.u().nr().update("template_diff_new", contentValues, "id=?", new String[]{nrVar.nr()});
        } else {
            com.bytedance.sdk.component.adexpress.u.u.u.u().nr().insert("template_diff_new", contentValues);
        }
        synchronized (this.b) {
            this.x.put(nrVar.nr(), nrVar);
        }
        this.fx.add(nrVar.nr());
        if (z) {
            return;
        }
        try {
            if (com.bytedance.sdk.component.adexpress.u.u.u.u().iz() == null) {
                return;
            }
            if (this.pn == null) {
                this.pn = new ConcurrentHashMap<>();
            }
            com.bytedance.sdk.component.adexpress.u.fx.fx fxVar = new com.bytedance.sdk.component.adexpress.u.fx.fx(nrVar.u(), nrVar.nr(), nrVar.fx());
            this.pn.put(nrVar.nr(), fxVar);
            if (string != null) {
                com.bytedance.sdk.component.adexpress.u.u.u.u().iz().delete(string, fxVar.nr());
            }
            com.bytedance.sdk.component.adexpress.u.u.u.u().iz().update(nrVar.u(), fxVar);
        } catch (Throwable unused2) {
        }
    }

    public void u(Set<String> set) {
        if (set == null || set.isEmpty() || com.bytedance.sdk.component.adexpress.u.u.u.u().nr() == null) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                b(strArr[i]);
                com.bytedance.sdk.component.adexpress.u.u.u.u().nr().delete("template_diff_new", "id=?", new String[]{strArr[i]});
                fx(strArr[i]);
            }
        }
    }
}
