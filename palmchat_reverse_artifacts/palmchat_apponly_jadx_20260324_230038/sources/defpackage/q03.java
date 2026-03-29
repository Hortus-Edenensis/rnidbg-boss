package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.zenmen.palmchat.greendao.model.Media;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class q03 {
    public static void a(int i, String str) {
        if ((i == 12 || i == 13 || i == 15 || i == 14) && !TextUtils.isEmpty(str)) {
            try {
                String string = new JSONObject(str).getString("appId");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                f84.e(ah.c(string, "message"), "click");
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String queryParameter = Uri.parse(str).getQueryParameter("appId");
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        f84.e(ah.c(queryParameter, "seviceAccount"), "click");
    }

    public static Intent c(Intent intent, z03 z03Var) {
        Media media;
        if (z03Var != null && (media = (Media) intent.getParcelableExtra("key_publish_share_media")) != null) {
            media.wid = z03Var.t();
            intent.putExtra("key_publish_share_media", media);
        }
        return intent;
    }

    public static Intent d(Intent intent, d13 d13Var) {
        if (d13Var == null) {
            return intent;
        }
        intent.putExtra("key_publish_wid", d13Var.x());
        intent.putExtra("key_publish_wineFeedId", d13Var.y());
        intent.putExtra("key_publish_wineid", d13Var.y());
        intent.putExtra("key_publish_mediaid", d13Var.x());
        intent.putExtra("key_publish_sv_channelid", d13Var.w());
        return intent;
    }

    public static String e(String str) {
        try {
            return new JSONObject(new JSONObject(str).getJSONObject("openInfo").getString("content")).getString("openLink");
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
