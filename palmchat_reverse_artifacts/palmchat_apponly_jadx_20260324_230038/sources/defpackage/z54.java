package defpackage;

import android.text.TextUtils;
import com.zenmen.openapi.OpenApiManager;
import com.zenmen.openapi.offline.OfflineResDownTask;
import com.zenmen.openapi.offline.request.FetchPkgInfo;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class z54 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22354a;
    public String b;
    public String c;
    public String d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements e84 {
        public a() {
        }

        @Override // defpackage.e84
        public void onCallback(int i, String str, Object obj) throws Throwable {
            if (i == 1) {
                ma3.a("offline res  down succ", new Object[0]);
                z54 z54Var = z54.this;
                z54Var.r("wp_download_res", 1, z54Var.l());
                z54.this.o();
                return;
            }
            ma3.a("offline res  down fail.retmsg:" + str, new Object[0]);
            z54.this.e();
            z54.this.r("wp_download_res", 0, str);
        }
    }

    public z54(FetchPkgInfo fetchPkgInfo) {
        this.f22354a = "0";
        this.f22354a = String.valueOf(fetchPkgInfo.getVerCode());
        this.b = fetchPkgInfo.getDownloadUrl();
        this.c = fetchPkgInfo.getExtId();
        this.d = fetchPkgInfo.getMd5();
    }

    public boolean c() {
        ex4 ex4VarA = a64.a(this.c);
        if (ex4VarA != null && ex4VarA.d()) {
            ma3.a("offline res force url", new Object[0]);
            r("wp_download_res", 0, "offline res force url");
            return false;
        }
        if (TextUtils.isEmpty(h()) || TextUtils.isEmpty(i())) {
            ma3.a("offline res down url is null or md5 is null", new Object[0]);
            r("wp_download_res", 0, "offline res down url is null or md5 is null");
            return false;
        }
        String strL = l();
        String strD = b64.b().d(g());
        ma3.a("offline res ver_config:" + strL + " res_ver_local:" + strD, new Object[0]);
        return b64.a(strL, strD) > 0;
    }

    public boolean d() {
        return true;
    }

    public final void e() {
        File file = new File(n());
        if (file.exists()) {
            file.delete();
        }
        ma3.a("offline res  delZip", new Object[0]);
    }

    public void f() {
        if (!c()) {
            ma3.a("offline res  cannot download", new Object[0]);
            return;
        }
        File file = new File(b64.f1656a);
        if (!file.exists()) {
            file.mkdir();
        }
        ma3.a("offline res  down start", new Object[0]);
        q("wp_download_st");
        com.zenmen.openapi.offline.a.d().a(new OfflineResDownTask(g(), h(), n(), new a()));
    }

    public String g() {
        return this.c;
    }

    public String h() {
        return this.b;
    }

    public String i() {
        return this.d;
    }

    public String j() {
        String strB = ja5.b(g() + "@" + l());
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        return strB.toLowerCase().substring(8, 24);
    }

    public String k() {
        return b64.f1656a + File.separator + g();
    }

    public String l() {
        return this.f22354a;
    }

    public final String m() {
        return g() + "_" + l() + ".zip";
    }

    public String n() {
        return b64.f1656a + File.separator + m();
    }

    public final void o() throws Throwable {
        File file = new File(n());
        if (!file.exists()) {
            ma3.a("offline res  zip file not exist", new Object[0]);
            r("wp_unzip_res", 0, "offline res zip file not exist");
            return;
        }
        String strA = ja5.a(file);
        String strI = i();
        if (TextUtils.isEmpty(strI) || !strI.equalsIgnoreCase(strA)) {
            ma3.a("offline res  md5 not equal, and del zip", new Object[0]);
            r("wp_unzip_res", 0, "offline res zip file md5 not equal");
            e();
        } else if (d()) {
            u();
        } else {
            r("wp_unzip_res", 0, "offline res the user is in page playing");
        }
    }

    public void p(String str, String str2) {
        if (str2 == null) {
            zn6.d(str, null, "");
        } else {
            zn6.d(str, null, str2);
        }
    }

    public void q(String str) {
        HashMap map = new HashMap();
        map.put("verCode", l());
        map.put("appId", g());
        p(str, new JSONObject(map).toString());
    }

    public void r(String str, int i, String str2) {
        HashMap map = new HashMap();
        map.put("ver", l());
        map.put("appid", g());
        map.put("code", Integer.valueOf(i));
        map.put("msg", b64.e(str2));
        p(str, new JSONObject(map).toString());
    }

    public final void s(String str, String str2) {
        ya3.d(OpenApiManager.getContext(), "offline_res", "offline_res_ver" + str, str2);
    }

    public final void t() {
        String strN = n();
        String strK = k();
        if (TextUtils.isEmpty(strN) || TextUtils.isEmpty(strK) || !new File(strN).exists()) {
            ma3.a("offline res  zipPath not exists", new Object[0]);
            return;
        }
        try {
            ma3.a("offline res  unzip ing", new Object[0]);
            cr6 cr6Var = new cr6(strN);
            if (cr6Var.h()) {
                cr6Var.k(j().toCharArray());
            }
            File file = new File(strK);
            if (file.isDirectory() && !file.exists()) {
                file.mkdirs();
            }
            if (cr6Var.i()) {
                cr6Var.d(strK);
                s(g(), l());
                r("wp_unzip_res", 1, "");
            }
        } catch (Throwable th) {
            ma3.a("offline res  unzip exception " + th.toString(), new Object[0]);
            r("wp_unzip_res", 0, "offline res unzip exception " + th.toString());
        }
        e();
    }

    public void u() {
        t();
    }
}
