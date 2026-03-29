package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.igexin.push.f.b.d;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class xi7 {
    public static xi7 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f21971a;
    public File b;
    public File c;
    public Context d;
    public b e = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21972a;

        public a(String str) {
            this.f21972a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(this.f21972a) && Pattern.compile("^\\d{1,13}-\\d{1,13}.*").matcher(str).matches();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f21973a;
        public long b;
        public File c;
        public JSONObject d;

        public b(File file) {
            long j;
            this.d = null;
            this.c = file;
            String[] strArrSplit = file.getName().split("-|\\.");
            if (strArrSplit.length >= 2) {
                this.f21973a = Long.parseLong(strArrSplit[0]);
                j = Long.parseLong(strArrSplit[1]);
            } else {
                String name = file.getName();
                if (TextUtils.isEmpty(name) || name.length() < 13) {
                    return;
                }
                String strSubstring = name.substring(0, 13);
                if (!TextUtils.isDigitsOnly(strSubstring)) {
                    return;
                }
                j = Long.parseLong(strSubstring);
                this.f21973a = j;
            }
            this.b = j;
        }

        public final String a() {
            return this.f21973a + "-" + this.b + ".ctx";
        }

        public final void c(long j) {
            this.b = j;
            this.c.renameTo(new File(this.c.getParent(), a()));
        }

        public final JSONObject f() {
            if (this.d == null) {
                try {
                    this.d = new JSONObject(re7.z(this.c.getAbsolutePath()));
                } catch (Throwable unused) {
                }
                if (this.d == null) {
                    this.d = new JSONObject();
                }
            }
            return this.d;
        }

        public final boolean g(long j) {
            long j2 = this.f21973a;
            if (j2 > j && j2 - j > d.b) {
                return true;
            }
            long j3 = this.b;
            if (j3 >= j || j - j3 <= d.b) {
                return this.c.lastModified() < j && j - this.c.lastModified() > d.b;
            }
            return true;
        }

        public final void j() {
            this.c.delete();
        }

        public /* synthetic */ b(File file, a aVar) {
            this(file);
        }
    }

    public xi7(Context context) {
        File fileL = wi7.l(context);
        if (!fileL.exists() || (!fileL.isDirectory() && fileL.delete())) {
            fileL.mkdirs();
            nz6.i();
        }
        this.f21971a = fileL;
        this.b = new File(fileL, "did");
        this.c = new File(fileL, "device_uuid");
        this.d = context;
    }

    public static int a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (q37.p(jSONObject)) {
            return 2;
        }
        if (q37.p(jSONObject2)) {
            return 0;
        }
        return (String.valueOf(jSONObject2.opt("update_version_code")).equals(String.valueOf(jSONObject.opt("update_version_code"))) && q37.r(jSONObject)) ? 1 : 2;
    }

    public static xi7 d() {
        if (f == null) {
            f = new xi7(x97.m());
        }
        return f;
    }

    public String b(String str) {
        try {
            return re7.z(this.c.getAbsolutePath());
        } catch (Throwable unused) {
            return str;
        }
    }

    public JSONObject c(long j) {
        boolean z;
        String strZ;
        File fileM = m(j);
        if (fileM == null) {
            fileM = p(j);
            z = true;
        } else {
            z = false;
        }
        JSONObject jSONObject = null;
        if (fileM != null) {
            try {
                strZ = re7.z(fileM.getAbsolutePath());
                try {
                    jSONObject = new JSONObject(strZ);
                } catch (Throwable th) {
                    th = th;
                    n37.a();
                    n37.b("NPTH_CATCH", new IOException("content :" + strZ, th));
                }
            } catch (Throwable th2) {
                th = th2;
                strZ = null;
            }
        }
        if (jSONObject != null && z) {
            try {
                jSONObject.put("unauthentic_version", 1);
            } catch (JSONException e) {
                n37.a();
                n37.b("NPTH_CATCH", e);
            }
        }
        return jSONObject;
    }

    public final void e(long j, long j2, JSONObject jSONObject, JSONArray jSONArray) {
        File file = new File(this.f21971a, "" + j + "-" + j2 + ".ctx");
        File file2 = new File(this.f21971a, "" + j + "-" + j2 + ".allData");
        try {
            re7.m(file, jSONObject, false);
            re7.l(file2, jSONArray, false);
            this.e = new b(file, null);
        } catch (IOException e) {
            n37.a();
            n37.b("NPTH_CATCH", e);
        }
    }

    public void f(Map<String, Object> map, JSONArray jSONArray) {
        JSONObject jSONObjectD = q37.a(this.d).d(map);
        if (q37.p(jSONObjectD)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        b bVarJ = j();
        if (bVarJ == null) {
            e(jCurrentTimeMillis, jCurrentTimeMillis, jSONObjectD, jSONArray);
            return;
        }
        int iA = a(bVarJ.f(), jSONObjectD);
        if (iA == 1) {
            e(bVarJ.f21973a, jCurrentTimeMillis, jSONObjectD, jSONArray);
            re7.r(bVarJ.c);
        } else if (iA == 2) {
            e(jCurrentTimeMillis, jCurrentTimeMillis, jSONObjectD, jSONArray);
        } else if (iA == 3) {
            bVarJ.c(jCurrentTimeMillis);
        }
        k(jCurrentTimeMillis);
    }

    public String g() {
        try {
            return re7.z(this.b.getAbsolutePath());
        } catch (Throwable unused) {
            return "0";
        }
    }

    public JSONArray h(long j) {
        String strZ;
        File fileO = o(j);
        if (fileO == null) {
            fileO = q(j);
        }
        if (fileO == null) {
            return null;
        }
        try {
            strZ = re7.z(fileO.getAbsolutePath());
            try {
                return new JSONArray(strZ);
            } catch (Throwable th) {
                th = th;
                n37.a();
                n37.b("NPTH_CATCH", new IOException("content :" + strZ, th));
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            strZ = null;
        }
    }

    public void i(String str) {
        try {
            re7.j(this.b, str, false);
        } catch (Throwable unused) {
        }
    }

    public final b j() {
        if (this.e == null) {
            n(".ctx");
        }
        return this.e;
    }

    public final void k(long j) {
        try {
            ArrayList<b> arrayListN = n("");
            if (arrayListN.size() <= 6) {
                return;
            }
            for (b bVar : arrayListN) {
                if (bVar.g(j)) {
                    bVar.j();
                }
            }
        } catch (Throwable th) {
            n37.a();
            n37.b("NPTH_CATCH", th);
        }
    }

    public void l(String str) {
        try {
            re7.j(this.c, str, false);
        } catch (Throwable unused) {
        }
    }

    public final File m(long j) {
        for (b bVar : n(".ctx")) {
            if (j >= bVar.f21973a && j <= bVar.b) {
                return bVar.c;
            }
        }
        return null;
    }

    public final ArrayList<b> n(String str) {
        File[] fileArrListFiles = this.f21971a.listFiles(new a(str));
        ArrayList<b> arrayList = new ArrayList<>();
        if (fileArrListFiles == null) {
            return arrayList;
        }
        kj7.a("foundRuntimeContextFiles " + fileArrListFiles.length);
        a aVar = null;
        b bVar = null;
        for (File file : fileArrListFiles) {
            try {
                b bVar2 = new b(file, aVar);
                arrayList.add(bVar2);
                if (this.e == null && ".ctx".equals(str) && (bVar == null || bVar2.b >= bVar.b)) {
                    bVar = bVar2;
                }
            } catch (Throwable th) {
                n37.a();
                n37.b("NPTH_CATCH", th);
            }
        }
        if (this.e == null && bVar != null) {
            this.e = bVar;
        }
        return arrayList;
    }

    public final File o(long j) {
        for (b bVar : n(".allData")) {
            if (j >= bVar.f21973a && j <= bVar.b) {
                return bVar.c;
            }
        }
        return null;
    }

    public final File p(long j) {
        b bVar = null;
        for (b bVar2 : n(".ctx")) {
            if (bVar == null || Math.abs(bVar.b - j) > Math.abs(bVar2.b - j)) {
                bVar = bVar2;
            }
        }
        if (bVar == null) {
            return null;
        }
        return bVar.c;
    }

    public final File q(long j) {
        b bVar = null;
        for (b bVar2 : n(".allData")) {
            if (bVar == null || Math.abs(bVar.b - j) > Math.abs(bVar2.b - j)) {
                bVar = bVar2;
            }
        }
        if (bVar == null) {
            return null;
        }
        return bVar.c;
    }
}
