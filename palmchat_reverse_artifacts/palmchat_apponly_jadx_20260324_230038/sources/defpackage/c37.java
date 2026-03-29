package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.oplus.instant.router.callback.Callback;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c37 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Callback {
        @Override // com.oplus.instant.router.callback.Callback
        public void onResponse(Callback.Response response) {
            h87.b("GameUtil", "wrapCallback onResponse=" + response);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends Callback {
        public Callback c;
        public Context d;
        public String e;

        public b(Context context, String str, Callback callback) {
            this.c = callback;
            this.d = context;
            this.e = str;
        }

        @Override // com.oplus.instant.router.callback.Callback
        public void onResponse(Callback.Response response) {
            if (response != null && response.getCode() == 1) {
                try {
                    h87.f("GameUtil", "wrapper onResponse " + response);
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(ie7.j(this.d), bw6.a("Y29tLm5lYXJtZS5pbnN0YW50LnF1aWNrZ2FtZS5hY3Rpdml0eS5HYW1lVHJhbnNmZXJBY3Rpdml0eQ==")));
                    intent.putExtra("req_uri", this.e);
                    this.d.startActivity(intent);
                } catch (Exception e) {
                    h87.f("GameUtil", "wrapper onResponse ex:" + e.getMessage());
                    response = new Callback.Response();
                    response.setCode(-4);
                    response.setMsg("start transform page failed");
                }
            }
            Callback callback = this.c;
            if (callback != null) {
                callback.onResponse(response);
            }
        }
    }

    public static Callback a(Context context, String str, Callback callback) {
        if (callback == null) {
            callback = new a();
        }
        return new b(context, str, callback);
    }

    public static boolean b(Context context, String str, Map<String, String> map) {
        if (str == null || !str.startsWith("hap://game") || ie7.h(context) < 3100) {
            return false;
        }
        try {
            if ("1".equals(Uri.parse(str).getQueryParameter("in_one_task"))) {
                return true;
            }
        } catch (Exception e) {
            h87.d("GameUtil", e);
        }
        return map != null && "1".equals(map.get("in_one_task"));
    }
}
