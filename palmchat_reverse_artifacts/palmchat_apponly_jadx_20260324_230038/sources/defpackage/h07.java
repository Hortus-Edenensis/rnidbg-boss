package defpackage;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class h07 extends va7 {
    @Override // defpackage.va7
    public String h(ru6 ru6Var, HashMap<String, String> map, HashMap<String, String> map2) throws JSONException {
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        map2.putAll(uu6.b(ru6Var));
        w97.h("mspl", "cf " + map2);
        return super.h(ru6Var, map, map2);
    }

    @Override // defpackage.va7
    public JSONObject j() throws JSONException {
        return va7.k("sdkConfig", "obtain");
    }

    @Override // defpackage.va7
    public String n() {
        return "5.0.0";
    }

    @Override // defpackage.va7
    public boolean o() {
        return true;
    }
}
