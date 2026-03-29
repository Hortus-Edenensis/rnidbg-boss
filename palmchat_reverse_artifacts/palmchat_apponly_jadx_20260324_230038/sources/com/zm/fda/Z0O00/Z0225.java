package com.zm.fda.Z0O00;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.zm.fda.Z0O00.Z0O00.OO22Z;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Z0225 {
    public static final String d = "event_backup_new_";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FilenameFilter f16662a = new OO22Z();
    public File b;
    public Context c;

    /* JADX INFO: compiled from: SearchBox */
    public class OO22Z implements FilenameFilter {
        public OO22Z() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(Z0225.d);
        }
    }

    public Z0225(Context context) {
        if (this.c == null) {
            this.c = context;
            File filesDir = context.getFilesDir();
            if (filesDir != null && filesDir.exists()) {
                this.b = new File(filesDir.getParentFile(), "shared_prefs");
                return;
            }
            this.b = new File("/data/data/" + this.c.getPackageName(), "shared_prefs");
        }
    }

    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        return com.zm.fda.O52OZ.ZZ00Z.b(context.getApplicationContext()).replace(".", "_").replace(":", "_") + "_" + d;
    }

    @Deprecated
    public void a(String str) {
        a(new OO22Z.ZZ00Z().a("new_event_exceptions").a(3).c(str).a());
    }

    public synchronized boolean a(com.zm.fda.Z0O00.Z0O00.OO22Z oo22z) {
        if (this.c == null) {
            return false;
        }
        JSONObject jSONObjectA = oo22z.a(false);
        if (jSONObjectA == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = this.c.getSharedPreferences(a(this.c) + oo22z.g(), 0).edit();
        editorEdit.putString(String.valueOf(oo22z.a()), jSONObjectA.toString());
        return editorEdit.commit();
    }

    @Deprecated
    public synchronized List<com.zm.fda.Z0O00.Z0O00.OO22Z> a(int i, int i2) {
        if (this.c == null) {
            return null;
        }
        String str = a(this.c) + i;
        ArrayList arrayList = new ArrayList();
        Map<String, ?> all = this.c.getSharedPreferences(str, 0).getAll();
        if (all != null && !all.isEmpty()) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    com.zm.fda.Z0O00.Z0O00.OO22Z oo22zA = new OO22Z.ZZ00Z().a(new JSONObject((String) it.next().getValue())).b(1).a();
                    if (oo22zA.k()) {
                        arrayList.add(oo22zA);
                    }
                } catch (Exception e) {
                    Log.i(com.zm.fda.Z0O00.OO22Z.h, e.toString());
                }
                if (arrayList.size() == i2) {
                    return arrayList;
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public synchronized boolean a(List<String> list, int i) {
        if (this.c == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = this.c.getSharedPreferences(a(this.c) + i, 0).edit();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            editorEdit.remove(it.next());
        }
        return editorEdit.commit();
    }

    public synchronized void a() {
        if (this.c == null) {
            return;
        }
        File[] fileArrListFiles = this.b.listFiles(this.f16662a);
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file : fileArrListFiles) {
                String name = file.getName();
                this.c.getSharedPreferences(name.substring(0, name.indexOf(".")), 0).edit().clear().apply();
                file.delete();
            }
        }
    }
}
