package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.u.nr.x.nr;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class hl7 {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile hl7 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Context f17992a;

    public hl7(@NonNull Context context) {
        this.f17992a = context;
    }

    public static hl7 c() {
        if (b == null) {
            b = new hl7(uh7.b());
        }
        return b;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        try {
            String strJ = nr.j(uh7.j().e());
            String strD = z07.d(vh7.d(this.f17992a), vh7.c(), strJ, jSONObject, nr.c());
            jSONObject.put("upload_scene", "direct");
            if (nr.f(strJ, jSONObject.toString()).a()) {
                z07.i(strD);
            }
        } catch (Throwable unused) {
        }
    }

    @Nullable
    public String b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                return z07.d(vh7.d(this.f17992a), vh7.e(), nr.j(uh7.j().e()), jSONObject, nr.k());
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
