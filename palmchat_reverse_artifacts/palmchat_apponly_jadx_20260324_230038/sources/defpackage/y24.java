package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.conversations.threadnotifyguide.ExtraInfo;
import com.zenmen.palmchat.conversations.threadnotifyguide.IgnoreBatteryInfo;
import com.zenmen.palmchat.conversations.threadnotifyguide.ThreadNotificationGuideActivity;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class y24 {
    public static boolean g = false;
    public static ExtraInfo h = null;
    public static boolean i = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f22102a;
    public View b;
    public TextView c;
    public TextView d;
    public Activity e;
    public boolean f = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f22103a;

        public a(Activity activity) {
            this.f22103a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtil.uploadInfoImmediate("ntg2", null, null, y24.c(null, null));
            try {
                this.f22103a.startActivity(new Intent(this.f22103a, (Class<?>) ThreadNotificationGuideActivity.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f22104a;

        public b(Activity activity) {
            this.f22104a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            y24.this.b.setVisibility(8);
            qq2.m();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("bat2", null, null, jSONObject.toString());
            if (qq2.c(this.f22104a)) {
                LogUtil.uploadInfoImmediate("bat3", null, null, jSONObject.toString());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f22105a;

        public c(Activity activity) {
            this.f22105a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn6.b("pagemsg_up_remind-cli02");
            try {
                Intent intent = new Intent(this.f22105a, (Class<?>) ThreadNotificationGuideActivity.class);
                intent.putExtra("key_notify_style", true);
                this.f22105a.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f22106a;
        public final /* synthetic */ View b;

        public d(Activity activity, View view) {
            this.f22106a = activity;
            this.b = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn6.b("pagemsg_up_remind-cli01");
            com.zenmen.palmchat.utils.a.E().y0(this.f22106a);
            this.b.setVisibility(8);
            SPUtil.f14322a.t(SPUtil.SCENE.NOTIFY_GUIDE, "thread_home_notification_banner_should_show", Boolean.FALSE);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f22107a;

        public e(View view) {
            this.f22107a = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f22107a.setVisibility(8);
            SPUtil.f14322a.t(SPUtil.SCENE.NOTIFY_GUIDE, "thread_home_notification_banner_should_show", Boolean.FALSE);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f22108a;

        public f(Activity activity) {
            this.f22108a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            y24.this.b.setVisibility(8);
            qq2.m();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("bat2", null, null, jSONObject.toString());
            if (qq2.c(this.f22108a)) {
                LogUtil.uploadInfoImmediate("bat3", null, null, jSONObject.toString());
            }
        }
    }

    public y24(Activity activity, View view, View view2) {
        this.f22102a = view;
        this.b = view2;
        this.e = activity;
        view.setOnClickListener(new a(activity));
        view2.setOnClickListener(new b(activity));
    }

    public static long b(String str) {
        String str2 = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        try {
            long jAbs = (Math.abs(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime()) + 1000000) / 86400000;
            LogUtil.d("NotificationGuideEntranceHelper", "differDays  " + jAbs);
            return jAbs;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static String c(Integer num, Boolean bool) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (num != null) {
                jSONObject.put("time", num);
            } else {
                jSONObject.put("time", f() + 1);
            }
            if (bool != null) {
                jSONObject.put("result", bool);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static ExtraInfo d() {
        if (h == null || SPUtil.f14322a.a(SPUtil.SCENE.NOTIFY_GUIDE, "thread_notification_update_notify_config", false)) {
            SPUtil.f14322a.t(SPUtil.SCENE.NOTIFY_GUIDE, "thread_notification_update_notify_config", Boolean.FALSE);
            h = (ExtraInfo) rl0.h().d().getDynamicConfig(DynamicConfig.Type.NOTIFYGUIDEBANNER).parseExtra(ExtraInfo.class);
        }
        return h;
    }

    public static long e() {
        return SPUtil.f14322a.i(SPUtil.SCENE.NOTIFY_GUIDE, "thread_notification_guide_interval", 0L);
    }

    public static int f() {
        return SPUtil.f14322a.f(SPUtil.SCENE.NOTIFY_GUIDE, "thread_notification_guide_time", 0);
    }

    public static String g() {
        return SPUtil.f14322a.n(SPUtil.SCENE.NOTIFY_GUIDE, "thread_home_notification_guide_interval", "");
    }

    public static String h() {
        return SPUtil.f14322a.n(SPUtil.SCENE.NOTIFY_GUIDE, "thread_single_chat_notification_guide_interval", "");
    }

    public static boolean i(boolean z) {
        LogUtil.d("NotificationGuideEntranceHelper", "needNewShowNotify: isHomebanner " + z);
        boolean z2 = false;
        if (s34.c() == 1) {
            return false;
        }
        if (g && z) {
            LogUtil.d("NotificationGuideEntranceHelper", "needNewShowNotify: 1 " + g);
            return false;
        }
        if (!SPUtil.f14322a.a(SPUtil.SCENE.NOTIFY_GUIDE, "thread_notification_dialog_has_show", false) && z) {
            return false;
        }
        if (d() != null) {
            String strG = z ? g() : h();
            if (i) {
                strG = "";
            }
            if (TextUtils.isEmpty(strG) || (!z ? b(strG) >= r0.singleChatBannerInterval : b(strG) >= r0.homeBannerInterval)) {
                z2 = true;
            }
        }
        LogUtil.d("NotificationGuideEntranceHelper", "needNewShowNotify: " + z2);
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean j(boolean z) {
        boolean z2;
        ExtraInfo extraInfo;
        LogUtil.d("NotificationGuideEntranceHelper", "needShowNotify: " + z);
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NOTIFYGUIDEBANNER);
        if (i) {
            dynamicConfig.setEnable(true);
            dynamicConfig.setExtra(az2.c(new ExtraInfo()));
        }
        if (!dynamicConfig.isEnable() || (extraInfo = (ExtraInfo) dynamicConfig.parseExtra(ExtraInfo.class)) == null) {
            z2 = false;
        } else {
            int iF = f();
            long jE = e();
            if (i) {
                jE = 0;
            }
            if (iF < extraInfo.max && Math.abs(jE - ir5.b()) > ((long) (extraInfo.interval * 24 * 60 * 60)) * 1000 && s34.c() == 0) {
                z2 = true;
            }
        }
        return z2 && z;
    }

    public static void k() {
        int iF = f() + 1;
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.NOTIFY_GUIDE;
        sPUtil.t(scene, "thread_notification_guide_time", Integer.valueOf(iF));
        sPUtil.t(scene, "thread_notification_guide_interval", Long.valueOf(ir5.b()));
    }

    public static void l(boolean z) {
        String str = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        if (z) {
            SPUtil.f14322a.t(SPUtil.SCENE.NOTIFY_GUIDE, "thread_home_notification_guide_interval", str);
        } else {
            SPUtil.f14322a.t(SPUtil.SCENE.NOTIFY_GUIDE, "thread_single_chat_notification_guide_interval", str);
        }
    }

    public boolean m(boolean z, boolean z2) {
        if (z) {
            this.f22102a.setVisibility(8);
            this.b.setVisibility(8);
            SPUtil.f14322a.t(SPUtil.SCENE.NOTIFY_GUIDE, "thread_home_notification_banner_should_show", Boolean.FALSE);
        } else {
            boolean z3 = (this.f22102a.getVisibility() == 0 && s34.c() != 1) || (SPUtil.f14322a.a(SPUtil.SCENE.NOTIFY_GUIDE, "thread_home_notification_banner_should_show", false) && s34.c() != 1) || i(true);
            LogUtil.d("NotificationGuideEntranceHelper", "updateView: " + z3);
            if (z3) {
                zn6.b("pagemsg_up_remind-show");
                l(true);
                this.f22102a.setVisibility(0);
                ExtraInfo extraInfoD = d();
                if (extraInfoD != null) {
                    TextView textView = this.c;
                    if (textView != null && this.d != null) {
                        textView.setText(extraInfoD.homeBannerTitle);
                        this.d.setText(extraInfoD.homeBannerContent);
                    }
                    if (this.f22102a.findViewById(R.id.iv_notify_close) != null) {
                        if (extraInfoD.homeBannerShowCloseIcon) {
                            this.f22102a.findViewById(R.id.iv_notify_close).setVisibility(0);
                        } else {
                            this.f22102a.findViewById(R.id.iv_notify_close).setVisibility(4);
                        }
                    }
                }
                this.b.setVisibility(8);
                SPUtil.f14322a.t(SPUtil.SCENE.NOTIFY_GUIDE, "thread_home_notification_banner_should_show", Boolean.TRUE);
                if (z2) {
                    LogUtil.uploadInfoImmediate("ntg1", null, null, c(null, null));
                }
            } else {
                this.f22102a.setVisibility(8);
                IgnoreBatteryInfo ignoreBatteryInfoG = qq2.g(true);
                if (ignoreBatteryInfoG != null) {
                    this.b.setVisibility(0);
                    TextView textView2 = (TextView) this.b.findViewById(R.id.desTv);
                    if (!TextUtils.isEmpty(ignoreBatteryInfoG.texta)) {
                        textView2.setText(ignoreBatteryInfoG.texta);
                    }
                    if (z2) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", 1);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        LogUtil.uploadInfoImmediate("bat1", null, null, jSONObject.toString());
                    }
                } else {
                    this.b.setVisibility(8);
                }
            }
        }
        return this.f22102a.getVisibility() == 0 || this.b.getVisibility() == 0;
    }

    public y24(Activity activity, View view, View view2, boolean z) {
        this.f22102a = view;
        this.b = view2;
        this.e = activity;
        this.c = (TextView) view.findViewById(R.id.tv_title);
        this.d = (TextView) view.findViewById(R.id.tv_desc);
        ExtraInfo extraInfoD = d();
        if (extraInfoD != null) {
            this.c.setText(extraInfoD.homeBannerTitle);
            this.d.setText(extraInfoD.homeBannerContent);
        }
        view.findViewById(R.id.iv_notify_help).setOnClickListener(new c(activity));
        view.findViewById(R.id.tv_go_open).setOnClickListener(new d(activity, view));
        view.findViewById(R.id.iv_notify_close).setOnClickListener(new e(view));
        if (extraInfoD != null && extraInfoD.homeBannerShowCloseIcon) {
            view.findViewById(R.id.iv_notify_close).setVisibility(0);
        } else {
            view.findViewById(R.id.iv_notify_close).setVisibility(4);
        }
        view2.setOnClickListener(new f(activity));
    }
}
