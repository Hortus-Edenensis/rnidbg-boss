package defpackage;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class oq3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f19811a = "moments" + File.separator + "cache";

    /* JADX INFO: compiled from: SearchBox */
    public class a extends TypeToken<ArrayList<Feed>> {
        public a() {
        }
    }

    public String a() {
        return "timeline_2";
    }

    public String b() {
        return c() + File.separator + a();
    }

    public String c() {
        String strE = v4.e(c.b());
        StringBuilder sb = new StringBuilder();
        sb.append(c.b().getFilesDir().getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append(f19811a);
        sb.append(str);
        sb.append(strE);
        return sb.toString();
    }

    public List<Feed> d() {
        String strF = ga3.f(new File(b()), "UTF-8");
        LogUtil.json("logmoments", strF, "moments loadCache");
        try {
            return (List) az2.b(strF, new a().getType());
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void e(List<Feed> list) {
        File file = new File(b());
        try {
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file2 = new File(c());
        if (!file2.exists()) {
            file2.mkdirs();
        }
        String string = list == null ? new JsonObject().toString() : az2.c(list);
        LogUtil.json("logmoments", string, "moments saveCache");
        ga3.g(file.getAbsolutePath(), string, "UTF-8");
    }
}
