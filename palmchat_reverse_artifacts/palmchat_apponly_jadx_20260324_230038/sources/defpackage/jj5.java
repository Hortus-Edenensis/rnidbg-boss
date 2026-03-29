package defpackage;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class jj5 extends JSONObject {
    public jj5() {
    }

    public int a() {
        return optInt("maxtext", 200);
    }

    public int b() {
        return optInt("mintext", 5);
    }

    public jj5(@NonNull String str) throws JSONException {
        super(str);
    }
}
