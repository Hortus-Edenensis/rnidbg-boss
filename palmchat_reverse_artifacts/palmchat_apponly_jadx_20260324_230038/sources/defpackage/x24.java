package defpackage;

import android.app.Notification;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.notification.group.NotificationGroupConfig;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class x24 {
    public static x24 c = new x24();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<String, Set<String>> f21862a = new HashMap<>();
    public NotificationGroupConfig b;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(Notification notification);
    }

    public static x24 d() {
        return c;
    }

    public static boolean g() {
        return t66.h().f("LX-73249", false);
    }

    public void a() {
        this.b = null;
        this.f21862a.clear();
    }

    public final NotificationGroupConfig b() {
        if (this.b == null) {
            boolean zG = g();
            JSONObject config = vs0.a().getConfig(zG ? "notificationGroup_new" : "notificationGroup");
            if (config != null) {
                try {
                    this.b = (NotificationGroupConfig) az2.a(config.toString(), NotificationGroupConfig.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            NotificationGroupConfig notificationGroupConfig = this.b;
            if (notificationGroupConfig != null) {
                notificationGroupConfig.newStyle = zG;
            }
        }
        if (this.b == null) {
            this.b = new NotificationGroupConfig();
        }
        return this.b;
    }

    public final int c(String str) {
        StatusBarNotification[] statusBarNotificationArrB = com.zenmen.palmchat.utils.a.E().B();
        if (statusBarNotificationArrB == null) {
            return -1;
        }
        int i = 0;
        for (StatusBarNotification statusBarNotification : statusBarNotificationArrB) {
            if (str.equals(statusBarNotification.getNotification().getGroup())) {
                i++;
            }
        }
        return i;
    }

    public boolean e() {
        return Build.VERSION.SDK_INT >= 24 && !dm1.d();
    }

    public boolean f() {
        return b().newStyle;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(int i, NotificationCompat.Builder builder, w24 w24Var, a aVar) {
        int size;
        int iC;
        NotificationGroupConfig notificationGroupConfigB = b();
        if (e() && notificationGroupConfigB.enable) {
            String groupName = notificationGroupConfigB.getGroupName(w24Var);
            LogUtil.i("NotificationGroupHelper", "groupName " + groupName);
            Set<String> hashSet = this.f21862a.get(groupName);
            if (!TextUtils.isEmpty(groupName)) {
                Notification notificationBuild = builder.build();
                if (notificationBuild.getGroup() == null) {
                    iC = c(groupName);
                    LogUtil.i("NotificationGroupHelper", "currentShowCount " + iC);
                    if (iC == -1) {
                        return;
                    }
                    if (iC == 0) {
                        hashSet = null;
                    }
                    builder.setGroup(groupName);
                    builder.setGroupSummary(false);
                    LogUtil.i("NotificationGroupHelper", "setGroup 1111 ");
                    if (hashSet == null) {
                        hashSet = new HashSet<>();
                        hashSet.add(String.valueOf(i));
                    } else {
                        hashSet.add(String.valueOf(i));
                    }
                    this.f21862a.put(groupName, hashSet);
                    size = hashSet.size();
                    z = size == notificationGroupConfigB.getGroupMaxCount(w24Var) + 1;
                    if (z) {
                        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(AppContext.getContext(), notificationBuild);
                        builder2.setGroup(groupName);
                        builder2.setGroupSummary(true);
                        LogUtil.i("NotificationGroupHelper", "setGroup 2222 ");
                        aVar.a(builder2.build());
                    }
                } else {
                    size = 0;
                    iC = 0;
                }
            }
            LogUtil.i("NotificationGroupHelper", "groupName=" + groupName + "groupSummary=" + z + " count=" + size + " currentShowCount=" + iC + " config=" + az2.c(b()));
        }
    }
}
