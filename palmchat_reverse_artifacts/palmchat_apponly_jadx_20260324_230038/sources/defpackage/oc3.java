package defpackage;

import android.app.Activity;
import android.content.Intent;
import com.zenmen.find.ConditionHelper;
import com.zenmen.palmchat.activity.find.FindNearByMapActivity;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class oc3 {
    public static void a(String str, int i, String str2, int i2, String str3) {
        try {
            HashMap map = new HashMap();
            map.put("report_type", str);
            map.put("page_type", Integer.valueOf(i));
            map.put("tuid", str2);
            map.put("gender", Integer.valueOf(i2));
            map.put("age", str3);
            zn6.g("pageprofil_avatarentry", new JSONObject(map));
        } catch (Exception unused) {
        }
    }

    public static void b(Activity activity, int i) {
        LogUtil.d("MapSeparationManager", "MapFindStartManager startFindMap activity " + activity + " from " + i);
        if (a46.o()) {
            if (a46.q()) {
                FindNearByMapActivity.I3(activity, ConditionHelper.getInstance().getDriftInfo().location, false, false, 0, 0, i);
                return;
            } else {
                BaseActivityPermissionDispatcher.b((FrameworkBaseActivity) activity, BaseActivityPermissionDispatcher.PermissionType.FIND_FRIEND_FEED_USER_MAP_LOCATION, BaseActivityPermissionDispatcher.PermissionUsage.FIND_FRIEND_GET_LOCATION);
                return;
            }
        }
        ry5.a("请打开位置服务");
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        try {
            activity.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
