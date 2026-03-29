package defpackage;

import com.cdadata.sdk.api.ZMDataSDKManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class u57 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f21141a;
    public final /* synthetic */ String b;
    public final /* synthetic */ z47 c;

    public u57(z47 z47Var, JSONObject jSONObject, String str) {
        this.c = z47Var;
        this.f21141a = jSONObject;
        this.b = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007d  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        try {
            try {
                byte b = 0;
                this.f21141a.put("isFlush", 0);
                JSONObject jSONObject = new JSONObject();
                String str = this.b;
                switch (str.hashCode()) {
                    case -1853223252:
                        b = !str.equals("AppNetChange") ? (byte) -1 : (byte) 7;
                        break;
                    case 788572250:
                        if (str.equals("AppInstall")) {
                            b = 2;
                            break;
                        }
                        break;
                    case 870380209:
                        if (str.equals("AppInit")) {
                            b = 4;
                            break;
                        }
                        break;
                    case 870465165:
                        if (str.equals("AppLive")) {
                            b = 1;
                            break;
                        }
                        break;
                    case 870560747:
                        if (str.equals("AppOpen")) {
                            b = 8;
                            break;
                        }
                        break;
                    case 870684067:
                        if (str.equals("AppStop")) {
                            b = 9;
                            break;
                        }
                        break;
                    case 1221389025:
                        if (str.equals("AppStart")) {
                            break;
                        }
                        break;
                    case 1967735578:
                        if (str.equals("AppEnd")) {
                            b = 3;
                            break;
                        }
                        break;
                    case 1999723618:
                        if (str.equals("AppScreenOff")) {
                            b = 6;
                            break;
                        }
                        break;
                    case 2004169868:
                        if (str.equals("AppScreenOn")) {
                            b = 5;
                            break;
                        }
                        break;
                }
                switch (b) {
                    case 0:
                        e67.s(this.c.j, jSONObject);
                        e67.e(this.c.j, jSONObject);
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        e67.s(this.c.j, jSONObject);
                        if (this.b.equals("AppInit") || this.b.equals("AppScreenOn") || this.b.equals("AppScreenOff") || this.b.equals("AppNetChange")) {
                            jSONObject.remove("sid");
                        }
                        if (this.b.equals("AppEnd")) {
                            try {
                                jSONObject.put("sid", this.f21141a.getString("sid"));
                            } catch (JSONException unused) {
                            }
                        }
                        break;
                }
                e67.h(jSONObject, this.f21141a);
                this.f21141a.put("eventType", "auto");
                c57.l().b(this.f21141a, true);
                ZMDataSDKManager.getInstance().getZmUploadEvent().a();
            } catch (JSONException e) {
                e = e;
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
        }
    }
}
