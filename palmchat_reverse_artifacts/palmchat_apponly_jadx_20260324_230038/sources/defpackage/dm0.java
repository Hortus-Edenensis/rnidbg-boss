package defpackage;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.loginnew.ConfirmGBBean;
import com.zenmen.palmchat.widget.picker.wheel.DateWheelPicker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class dm0 {
    public static boolean l = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f17075a;
    public View b;
    public MaterialDialog c;
    public View d;
    public View e;
    public View f;
    public DateWheelPicker g;
    public int h = 0;
    public String i;
    public String j;
    public int k;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            dm0.this.n(0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            dm0.this.n(1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            try {
                dm0 dm0Var = dm0.this;
                dm0Var.i = dm0Var.g.getBirthday();
                dm0.this.m();
                JSONObject jSONObject = new JSONObject();
                int i = 0;
                int i2 = (dm0.this.j == null || dm0.this.j.equals(dm0.this.i)) ? -1 : 0;
                if (dm0.this.h == dm0.this.k) {
                    i = -1;
                }
                jSONObject.put("sex", i);
                jSONObject.put("age", i2);
                zn6.d("profile_pop_click", null, jSONObject.toString());
                dm0.this.j();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends go2<LXBaseNetBean<ConfirmGBBean>> {
        public d() {
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("sex", dm0.this.h + "");
            map.put("birthday", dm0.this.i);
            return sw4.b(1, nl0.z + "/user.update.info", map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<ConfirmGBBean> lXBaseNetBean, Exception exc) {
            if (lXBaseNetBean == null || lXBaseNetBean.resultCode != 0) {
                return;
            }
            sy5.h(dm0.this.f17075a, "设置成功", 0);
        }
    }

    public dm0(Activity activity) {
        this.b = null;
        this.c = null;
        this.f17075a = activity;
        this.b = View.inflate(activity, R.layout.layout_login_brithday_gender_confirm, null);
        this.c = new sd3(this.f17075a).p(this.b, false).v(true).d(R.color.transparent).h(false).e();
    }

    public void j() {
        MaterialDialog materialDialog = this.c;
        if (materialDialog != null) {
            materialDialog.dismiss();
        }
    }

    public final void k() {
        ContactInfoItem contactInfoItemA;
        Date date;
        String strE = v4.e(AppContext.getContext());
        if (TextUtils.isEmpty(strE) || (contactInfoItemA = dn0.a(strE)) == null) {
            return;
        }
        n(contactInfoItemA.getGender());
        if (TextUtils.isEmpty(contactInfoItemA.getBirthday())) {
            return;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(contactInfoItemA.getBirthday());
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }
        gregorianCalendar.setTime(date);
        this.g.setDate(gregorianCalendar.get(1), gregorianCalendar.get(2) + 1, gregorianCalendar.get(5));
    }

    public final void l() {
        View viewFindViewById = this.b.findViewById(R.id.male_btn);
        this.d = viewFindViewById;
        viewFindViewById.setOnClickListener(new a());
        View viewFindViewById2 = this.b.findViewById(R.id.female_btn);
        this.e = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new b());
        this.f = this.b.findViewById(R.id.confirm_btn);
        this.g = (DateWheelPicker) this.b.findViewById(R.id.birthday_view);
        this.f.setOnClickListener(new c());
        n(0);
        this.g.reset();
        k();
        String birthday = this.g.getBirthday();
        this.i = birthday;
        this.k = this.h;
        this.j = birthday;
    }

    public final void m() {
        zw4.e(new d());
    }

    public final void n(int i) {
        this.h = i;
        this.d.setSelected(i == 0);
        this.e.setSelected(i == 1);
    }

    public void o() {
        MaterialDialog materialDialog = this.c;
        if (materialDialog != null) {
            materialDialog.show();
            zn6.d("profile_pop_show", null, new JSONObject().toString());
            l();
        }
    }
}
