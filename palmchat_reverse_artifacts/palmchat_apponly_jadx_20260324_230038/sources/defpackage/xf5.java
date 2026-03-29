package defpackage;

import com.zenmen.palmchat.AppContext;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class xf5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<String, wf5> f21946a = new HashMap<>();

    public static wf5 a(String str) {
        wf5 wf5Var;
        if (str == null) {
            str = "";
        }
        synchronized (f21946a) {
            wf5Var = f21946a.get(str);
            if (wf5Var == null) {
                wf5Var = new wf5(AppContext.getContext(), str);
                f21946a.put(str, wf5Var);
            }
        }
        return wf5Var;
    }
}
