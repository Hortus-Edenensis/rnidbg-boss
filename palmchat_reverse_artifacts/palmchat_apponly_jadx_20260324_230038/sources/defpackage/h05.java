package defpackage;

import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.zenmen.palmchat.Vo.MomentsConfig;
import com.zenmen.palmchat.browser.SRobotCompModel;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.Media;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class h05 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f17846a = "SRobotUtils";
    public static boolean b = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SharedPreferences f17847a;

        public a(SharedPreferences sharedPreferences) {
            this.f17847a = sharedPreferences;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            boolean unused = h05.b = false;
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            boolean unused = h05.b = false;
            try {
                if (jSONObject.getInt("resultCode") == 0) {
                    this.f17847a.edit().putLong(k86.v(), System.currentTimeMillis()).apply();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static SRobotCompModel b(Feed feed) {
        Media media;
        if (!d(feed) || feed == null || feed.getMediaList() == null || (media = feed.getMediaList().get(0)) == null || media.getExtensionData() == null) {
            return null;
        }
        SRobotCompModel sRobotCompModel = new SRobotCompModel();
        sRobotCompModel.uType = media.getExtensionData().uType;
        sRobotCompModel.feedId = feed.getFeedId();
        sRobotCompModel.newsId = media.getExtensionData().newsId;
        for (String str : media.getExtensionData().exit) {
            if (!TextUtils.isEmpty(str)) {
                sRobotCompModel.exitUrl.add(str);
            }
        }
        return sRobotCompModel;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^(1)(\\d{11})$").matcher(str).matches();
    }

    public static boolean d(Feed feed) {
        Media media;
        if (feed != null) {
            return (feed.getMediaList() == null || feed.getMediaList().size() <= 0 || (media = feed.getMediaList().get(0)) == null || media.getExtensionData() == null) ? e(feed.getUid()) : media.getExtensionData().uType == 3;
        }
        return false;
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^(2)(\\d{11})$").matcher(str).matches();
    }

    public static void f() {
        Log.d(f17846a, "notifyAppBackground");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(c.b());
        if (Math.abs(defaultSharedPreferences.getLong(k86.v(), 0L) - System.currentTimeMillis()) >= MomentsConfig.c().d() * 60 * 1000 && !b) {
            a aVar = new a(defaultSharedPreferences);
            b = true;
            g05.a(aVar);
        }
    }

    public static void g(Feed feed) {
        Media media;
        Log.d(f17846a, "onSRobotContentClick");
        if (!d(feed) || feed == null || feed.getMediaList() == null || (media = feed.getMediaList().get(0)) == null || media.getExtensionData() == null || media.getExtensionData().click == null) {
            return;
        }
        for (String str : media.getExtensionData().click) {
            if (!TextUtils.isEmpty(str)) {
                Log.d(f17846a, "onSRobotContentClick GET ： " + str);
                zw4.i(str, 0, null, null, false);
            }
        }
    }

    public static void h(String str, int i, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int iMin = Math.min(100, Math.max(0, i));
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        builderBuildUpon.appendQueryParameter("percent", String.valueOf(iMin));
        builderBuildUpon.appendQueryParameter("remain", String.valueOf(j));
        Log.d(f17846a, "onSRobotContentExit GET ： " + builderBuildUpon.build().toString());
        LogUtil.d("logrobot", "onSRobotContentExit: percent=" + iMin + ", remain=" + j);
        zw4.i(builderBuildUpon.build().toString(), 0, null, null, false);
    }

    public static void i(Feed feed) {
        Media media;
        Log.d(f17846a, "onSRobotContentShow");
        if (!d(feed) || feed == null || feed.getMediaList() == null || (media = feed.getMediaList().get(0)) == null || media.getExtensionData() == null || media.getExtensionData().inview == null) {
            return;
        }
        for (String str : media.getExtensionData().inview) {
            if (!TextUtils.isEmpty(str)) {
                Log.d(f17846a, "onSRobotContentShow GET ： " + str);
                zw4.i(str, 0, null, null, false);
            }
        }
    }
}
