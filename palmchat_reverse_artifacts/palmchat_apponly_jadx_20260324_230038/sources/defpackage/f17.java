package defpackage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class f17 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f17412a;
    public bu6 b;

    public f17(String str, bu6 bu6Var) {
        this.f17412a = null;
        this.b = null;
        this.f17412a = new File(str);
        this.b = bu6Var;
    }

    public static String a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "id");
            jSONObject.put("error", str);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public final void b() {
        new Thread(new q47(this)).start();
    }

    public final synchronized void d() {
        File file = this.f17412a;
        if (file == null) {
            return;
        }
        if (file.exists() && this.f17412a.isDirectory() && this.f17412a.list().length != 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.f17412a.list()) {
                arrayList.add(str);
            }
            Collections.sort(arrayList);
            String str2 = (String) arrayList.get(arrayList.size() - 1);
            int size = arrayList.size();
            if (str2.equals(new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log")) {
                if (arrayList.size() < 2) {
                    return;
                }
                str2 = (String) arrayList.get(arrayList.size() - 2);
                size--;
            }
            if (!this.b.logCollect(a(m07.a(this.f17412a.getAbsolutePath(), str2)))) {
                size--;
            }
            for (int i = 0; i < size; i++) {
                new File(this.f17412a, (String) arrayList.get(i)).delete();
            }
        }
    }
}
