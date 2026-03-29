package defpackage;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.igexin.push.config.c;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import defpackage.cg6;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class eg6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f17297a;
    public View b;
    public View c;
    public View d;
    public cg6 e;
    public boolean f = true;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            eg6.this.d();
        }
    }

    public eg6(Activity activity, View view) {
        this.f17297a = activity;
        this.b = view;
        this.c = view.findViewById(R.id.vipKefu);
        this.d = view.findViewById(R.id.vip_flash);
        cg6 cg6Var = new cg6(activity, view, this.c, new a(activity));
        this.e = cg6Var;
        this.c.setOnTouchListener(cg6Var);
    }

    public static boolean a() {
        JSONObject config = vs0.a().getConfig("customerServiceInfo");
        return config != null && config.optInt("enableMineVipEntrance", 0) == 1;
    }

    public static boolean b() {
        if (t66.h().f("LX-59187", false)) {
            return (fg6.j(AppContext.getContext()) || fg6.d(AppContext.getContext())) && a();
        }
        return false;
    }

    public void c() {
        if (!b()) {
            this.c.setVisibility(8);
            return;
        }
        if (this.c.getVisibility() == 8) {
            zn6.c("mine_vip_service", "view");
        }
        this.c.setVisibility(0);
        this.d.postDelayed(new b(), this.f ? c.j : 0L);
        this.f = false;
    }

    public void d() {
        this.d.setVisibility(0);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.d, "translationX", 0.0f, me1.b(AppContext.getContext(), 100)).setDuration(c.j);
        duration.setInterpolator(new LinearInterpolator());
        duration.start();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements cg6.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f17298a;

        public a(Activity activity) {
            this.f17298a = activity;
        }

        @Override // cg6.b
        public void onClick() {
            if (l50.a() || this.f17298a == null) {
                return;
            }
            zn6.c("mine_vip_service", "click");
            ve.s(this.f17298a, "zenxin://activity?page=a0520&uid=" + a65.a(), false);
        }

        @Override // cg6.b
        public void a(int i, int i2) {
        }
    }
}
