package com.bytedance.sdk.openadsdk.core.nativeexpress.u;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.openadsdk.core.dw;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private static volatile fx nr = null;
    public static int u = 20;
    private volatile ConcurrentHashMap<String, com.bytedance.sdk.component.adexpress.u.fx.fx> pn;
    private final Object fx = new Object();
    private final LruCache<String, u> b = new LruCache<String, u>(u) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.u.fx.1
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, u uVar) {
            return 1;
        }
    };
    private AtomicBoolean iz = new AtomicBoolean(false);

    private fx() {
    }

    private void fx(String str) {
        if (!TextUtils.isEmpty(str) && this.b.size() > 0) {
            synchronized (this.fx) {
                this.b.remove(str);
            }
        }
    }

    public static fx u() {
        if (nr == null) {
            synchronized (fx.class) {
                if (nr == null) {
                    nr = new fx();
                }
            }
        }
        return nr;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<u> nr() {
        boolean z = this.iz.get();
        this.iz.set(true);
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), "ugen_template", null, null, null, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        int columnIndex = cursorQuery.getColumnIndex("id");
                        int columnIndex2 = cursorQuery.getColumnIndex("md5");
                        int columnIndex3 = cursorQuery.getColumnIndex("url");
                        int columnIndex4 = cursorQuery.getColumnIndex("data");
                        int columnIndex5 = cursorQuery.getColumnIndex("update_time");
                        if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                            int columnIndex6 = cursorQuery.getColumnIndex("rit");
                            String string = columnIndex6 != -1 ? cursorQuery.getString(columnIndex6) : null;
                            String string2 = cursorQuery.getString(columnIndex);
                            String string3 = cursorQuery.getString(columnIndex2);
                            String string4 = cursorQuery.getString(columnIndex3);
                            u uVarU = new u().u(string2).nr(string3).fx(string4).b(cursorQuery.getString(columnIndex4)).pn(string).u(Long.valueOf(cursorQuery.getLong(columnIndex5)));
                            arrayList.add(uVarU);
                            synchronized (this.fx) {
                                this.b.put(string2, uVarU);
                            }
                            if (!z) {
                                if (this.pn == null) {
                                    this.pn = new ConcurrentHashMap<>();
                                }
                                if (string2 != null && !this.pn.contains(string2)) {
                                    this.pn.put(string2, new com.bytedance.sdk.component.adexpress.u.fx.fx(string, string2, string3));
                                }
                            }
                        }
                    } while (cursorQuery.moveToNext());
                }
            } finally {
                try {
                } finally {
                }
            }
            if (cursorQuery != null) {
            }
        } else if (cursorQuery != null) {
        }
        return arrayList;
    }

    public static String fx() {
        return new StringBuilder("CREATE TABLE IF NOT EXISTS ugen_template (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , rit TEXT , update_time TEXT)").toString();
    }

    public u u(String str, String str2) {
        u uVar;
        u uVarU;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.fx) {
            uVar = this.b.get(str);
        }
        if (uVar != null) {
            if (TextUtils.equals(str2, uVar.nr())) {
                return uVar;
            }
            fx(str2);
            return null;
        }
        Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), "ugen_template", null, "id=? AND md5=?", new String[]{str, str2}, null, null, null);
        if (cursorQuery == null) {
            return null;
        }
        try {
            if (cursorQuery.moveToFirst()) {
                do {
                    int columnIndex = cursorQuery.getColumnIndex("id");
                    int columnIndex2 = cursorQuery.getColumnIndex("md5");
                    int columnIndex3 = cursorQuery.getColumnIndex("url");
                    int columnIndex4 = cursorQuery.getColumnIndex("data");
                    int columnIndex5 = cursorQuery.getColumnIndex("update_time");
                    if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                        int columnIndex6 = cursorQuery.getColumnIndex("rit");
                        String string = cursorQuery.getString(columnIndex);
                        String string2 = cursorQuery.getString(columnIndex2);
                        String string3 = cursorQuery.getString(columnIndex3);
                        String string4 = cursorQuery.getString(columnIndex4);
                        uVarU = new u().u(string).nr(string2).b(string4).fx(string3).pn(columnIndex6 != -1 ? cursorQuery.getString(columnIndex6) : null).u(Long.valueOf(cursorQuery.getLong(columnIndex5)));
                        synchronized (this.fx) {
                            this.b.put(string, uVarU);
                        }
                    }
                    return null;
                } while (cursorQuery.moveToNext());
                return uVarU;
            }
        } finally {
            try {
                return null;
            } finally {
            }
        }
        return null;
    }

    public void nr(String str) {
        com.bytedance.sdk.component.adexpress.u.fx.fx fxVar;
        try {
            if (this.pn == null || this.pn.isEmpty() || (fxVar = this.pn.get(str)) == null) {
                return;
            }
            String strU = fxVar.u();
            if (!TextUtils.isEmpty(strU)) {
                com.bytedance.sdk.openadsdk.core.fx.nr.u().delete(strU, str, true);
            }
            this.pn.remove(str);
        } catch (Throwable unused) {
        }
    }

    public void u(u uVar, boolean z) {
        if (uVar == null || TextUtils.isEmpty(uVar.u())) {
            return;
        }
        Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), "ugen_template", null, "id=?", new String[]{uVar.u()}, null, null, null);
        boolean z2 = cursorQuery != null && cursorQuery.getCount() > 0;
        if (z2) {
            try {
                string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("rit")) : null;
                cursorQuery.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", uVar.u());
        contentValues.put("md5", uVar.nr());
        contentValues.put("url", uVar.fx());
        contentValues.put("data", uVar.pn());
        contentValues.put("rit", uVar.iz());
        contentValues.put("update_time", uVar.b());
        if (z2) {
            com.bytedance.sdk.openadsdk.core.multipro.u.u.update(dw.getContext(), "ugen_template", contentValues, "id=?", new String[]{uVar.u()});
        } else {
            com.bytedance.sdk.openadsdk.core.multipro.u.u.insert(dw.getContext(), "ugen_template", contentValues);
        }
        synchronized (this.fx) {
            this.b.put(uVar.u(), uVar);
        }
        if (z) {
            return;
        }
        try {
            if (this.pn == null) {
                this.pn = new ConcurrentHashMap<>();
            }
            com.bytedance.sdk.component.adexpress.u.fx.fx fxVar = new com.bytedance.sdk.component.adexpress.u.fx.fx(uVar.iz(), uVar.u(), uVar.nr());
            this.pn.put(uVar.u(), fxVar);
            if (string != null) {
                com.bytedance.sdk.openadsdk.core.fx.nr.u().delete(string, fxVar.nr(), true);
            }
            com.bytedance.sdk.openadsdk.core.fx.nr.u().update(uVar.iz(), fxVar, true);
        } catch (Throwable unused2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00c9 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Set<u> u(String str) {
        u uVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), "ugen_template", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        int columnIndex = cursorQuery.getColumnIndex("id");
                        if (columnIndex != -1) {
                            String string = cursorQuery.getString(columnIndex);
                            if (!TextUtils.isEmpty(string)) {
                                synchronized (this.fx) {
                                    uVar = this.b.get(string);
                                }
                                if (uVar != null) {
                                    hashSet.add(uVar);
                                } else {
                                    u uVar2 = new u();
                                    int columnIndex2 = cursorQuery.getColumnIndex("data");
                                    if (columnIndex2 != -1) {
                                        String string2 = cursorQuery.getString(columnIndex2);
                                        if (!TextUtils.isEmpty(string2)) {
                                            uVar2.b(string2);
                                            uVar2.u(string);
                                            uVar2.pn(str);
                                            int columnIndex3 = cursorQuery.getColumnIndex("md5");
                                            int columnIndex4 = cursorQuery.getColumnIndex("url");
                                            int columnIndex5 = cursorQuery.getColumnIndex("update_time");
                                            if (columnIndex3 != -1) {
                                                uVar2.nr(cursorQuery.getString(columnIndex3));
                                            }
                                            if (columnIndex4 != -1) {
                                                uVar2.fx(cursorQuery.getString(columnIndex4));
                                            }
                                            if (columnIndex5 != -1) {
                                                uVar2.u(Long.valueOf(cursorQuery.getLong(columnIndex5)));
                                            }
                                            hashSet.add(uVar2);
                                            synchronized (this.fx) {
                                                this.b.put(string, uVar2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } while (cursorQuery.moveToNext());
                }
            } finally {
                try {
                } finally {
                }
            }
            if (cursorQuery != null) {
            }
        } else if (cursorQuery != null) {
        }
        return hashSet;
    }

    public void u(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                fx(strArr[i]);
                com.bytedance.sdk.openadsdk.core.multipro.u.u.delete(dw.getContext(), "ugen_template", "id=?", new String[]{strArr[i]});
                nr(strArr[i]);
            }
        }
    }
}
