package defpackage;

import android.content.Context;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public interface ko2 {
    void a(String str, String str2, String str3, yw4 yw4Var) throws Exception;

    void b(String str, String str2, String str3, String str4, String str5, yw4 yw4Var) throws Exception;

    void c(String str, int i, JSONObject jSONObject, yw4 yw4Var, boolean z, boolean z2);

    JSONObject d(String str, int i, JSONObject jSONObject, boolean z, aw awVar) throws Exception;

    LXBaseNetBean e(go2 go2Var) throws Exception;

    void f(go2 go2Var);

    void g(JSONObject jSONObject);

    String getUserAgent();

    JSONObject h(String str, HashMap<String, Object> map, boolean z) throws Exception;

    void init(Context context);
}
