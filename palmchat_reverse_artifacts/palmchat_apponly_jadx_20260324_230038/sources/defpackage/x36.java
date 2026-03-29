package defpackage;

import com.qq.gdt.action.ActionUtils;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.f;
import org.jsoup.nodes.g;
import org.jsoup.nodes.h;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class x36 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21870a;
    public Document b;

    public x36(String str) {
        this.f21870a = str;
    }

    public Map<String, y56> a() {
        g gVarL;
        try {
            this.b = cz2.a(this.f21870a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        HashMap map = new HashMap();
        Document document = this.b;
        if (document != null) {
            for (f fVar : document.H0("a[href]")) {
                y56 y56Var = new y56();
                y56Var.f(fVar.f("href"));
                y56Var.e(fVar.f("trigger"));
                y56Var.d(fVar.f(ActionUtils.METHOD));
                y56Var.c(fVar.f("compCode"));
                y56Var.n(fVar.f("fontcolor"));
                y56Var.q(fVar.f("paragraphspacing"));
                HashMap<String, String> mapE = zy4.e(y56Var.b());
                y56Var.p(mapE.get("page"));
                y56Var.r(mapE.get("zxAuthenticationed"));
                y56Var.l(mapE.get("bgColor"));
                y56Var.o(mapE.get("fontSize"));
                if (fVar.n() != null && fVar.n().size() == 1 && (gVarL = fVar.l(0)) != null && (gVarL instanceof h)) {
                    y56Var.m(((h) gVarL).Y());
                }
                map.put(y56Var.b(), y56Var);
            }
        }
        return map;
    }
}
