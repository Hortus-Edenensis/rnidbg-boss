package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class mj1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SpannableString f19233a;
    public MaterialDialog b;
    public int c;
    public String d;
    public String e;
    public int g;
    public Handler h = new Handler(new a());
    public long f = System.currentTimeMillis();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            mj1 mj1Var = mj1.this;
            long j = (jCurrentTimeMillis - mj1Var.f) / 1000;
            if (!mj1Var.b.p()) {
                mj1 mj1Var2 = mj1.this;
                if (((long) mj1Var2.g) - j >= 0) {
                    mj1Var2.h.sendEmptyMessageDelayed(0, 1000L);
                    if (message.what == 0) {
                        mj1.this.d();
                    }
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements DialogInterface.OnDismissListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            mj1.this.h.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements DialogInterface.OnCancelListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            mj1.this.h.removeCallbacksAndMessages(null);
        }
    }

    public mj1(Context context, String str, String str2, String str3, int i, int i2) {
        this.c = 0;
        this.e = str3;
        this.g = i;
        this.d = str2;
        this.c = i2;
        MaterialDialog materialDialogE = new sd3(context).U(str).O(R.string.alert_dialog_all_right).e();
        this.b = materialDialogE;
        materialDialogE.setOnDismissListener(new b());
        this.b.setOnCancelListener(new c());
    }

    public static void c(Context context, String str, String str2, String str3, int i) {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        long jI = sPUtil.i(scene, k86.a("key_accept_limit_daily_date"), 0L);
        Date date = new Date();
        date.setTime(jI);
        Date date2 = new Date();
        if (jI <= 0) {
            new mj1(context, str, str2, str3, i, 0).b();
            sPUtil.t(scene, k86.a("key_accept_limit_daily_date"), Long.valueOf(System.currentTimeMillis()));
        } else if (date2.getDate() == date.getDate()) {
            new mj1(context, str, str2, str3, i, 1).b();
        } else {
            new mj1(context, str, str2, str3, i, 0).b();
            sPUtil.t(scene, k86.a("key_accept_limit_daily_date"), Long.valueOf(System.currentTimeMillis()));
        }
    }

    public String a() {
        long jCurrentTimeMillis = ((long) this.g) - ((System.currentTimeMillis() - this.f) / 1000);
        long j = jCurrentTimeMillis / 60;
        long j2 = (j / 60) % 60;
        long j3 = j % 60;
        long j4 = jCurrentTimeMillis % 60;
        return j2 > 0 ? String.format("%d小时%d分%d秒", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)) : j3 > 0 ? String.format("%d分%d秒", Long.valueOf(j3), Long.valueOf(j4)) : String.format("%d秒", Long.valueOf(j4));
    }

    public void b() {
        d();
        this.b.show();
        this.h.sendEmptyMessageDelayed(0, 1000L);
    }

    public void d() {
        if (this.c != 0) {
            String strReplaceAll = this.e.replaceAll("time", a());
            int length = strReplaceAll.length();
            this.f19233a = new SpannableString(strReplaceAll);
            this.f19233a.setSpan(new ForegroundColorSpan(Color.parseColor("#a0a0a0")), 0, length, 17);
            this.b.s(this.f19233a);
            return;
        }
        int length2 = this.d.length();
        String strReplaceAll2 = this.e.replaceAll("time", a());
        int length3 = strReplaceAll2.length();
        this.f19233a = new SpannableString(this.d + "\n\n" + strReplaceAll2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#000000"));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(Color.parseColor("#a0a0a0"));
        this.f19233a.setSpan(foregroundColorSpan, 0, length2, 17);
        int i = length2 + 2;
        this.f19233a.setSpan(new RelativeSizeSpan(0.6f), length2, i, 17);
        int i2 = length3 + i;
        this.f19233a.setSpan(foregroundColorSpan2, i, i2, 17);
        this.f19233a.setSpan(new RelativeSizeSpan(0.95f), length2, i2, 17);
        this.b.s(this.f19233a);
    }
}
