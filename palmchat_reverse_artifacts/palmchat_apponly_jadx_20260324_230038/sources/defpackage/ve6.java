package defpackage;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.framework.R$style;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ve6 extends Dialog {
    public static long l = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f21425a;
    public Handler b;
    public LinearLayout c;
    public TextView d;
    public TextView e;
    public TextView f;
    public boolean g;
    public boolean h;
    public float i;
    public float j;
    public float k;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ve6.this.dismiss();
            ve6.this.h = true;
            LogUtil.onEvent("wig2", "1", null, null);
            zn6.d("lx_client_wfguide_wig2", null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                ve6.this.i = motionEvent.getX();
                ve6.this.j = motionEvent.getY();
                return false;
            }
            if (motionEvent.getAction() != 1) {
                return false;
            }
            ve6.this.k = motionEvent.getY();
            if ((ve6.this.k - ve6.this.j > 0.0f && Math.abs(ve6.this.k - ve6.this.j) > 25.0f) || ve6.this.k - ve6.this.j >= 0.0f || Math.abs(ve6.this.k - ve6.this.j) <= 25.0f) {
                return false;
            }
            ve6.this.dismiss();
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            try {
                ve6.this.b.removeCallbacksAndMessages(null);
                if (ve6.this.h) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", ve6.this.g ? 1 : 2);
                LogUtil.onEvent("wig3", "1", null, jSONObject.toString());
                zn6.d("lx_client_wfguide_wig3", null, jSONObject.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ve6.this.isShowing()) {
                ve6.this.dismiss();
                ve6.this.g = true;
            }
        }
    }

    public ve6(Context context) {
        super(context, R$style.video_top_wifikey_guide_dialog);
        this.f21425a = 5000L;
        this.b = new Handler(Looper.getMainLooper());
        this.g = false;
        this.h = false;
        k(context);
    }

    public static ve6 p(Activity activity, String str, String str2, String str3, int i) {
        ve6 ve6Var = new ve6(activity);
        ve6Var.m(i);
        ve6Var.o(str);
        ve6Var.n(str2);
        ve6Var.l(str3);
        ve6Var.setCancelable(true);
        ve6Var.show();
        return ve6Var;
    }

    public void k(Context context) {
        setContentView(R$layout.layout_dialog_video_top_wifi_guide);
        this.d = (TextView) findViewById(R$id.prompt_title);
        this.e = (TextView) findViewById(R$id.prompt_subtitle);
        this.f = (TextView) findViewById(R$id.btn_confirm);
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.prompt_dialog);
        this.c = linearLayout;
        linearLayout.setOnClickListener(new a());
        this.c.setOnTouchListener(new b());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.dimAmount = 0.0f;
        getWindow().setAttributes(attributes);
        getWindow().addFlags(2);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        getWindow().setFlags(1024, 1024);
        WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
        if (attributes2 != null) {
            attributes2.height = -2;
            attributes2.width = -1;
            attributes2.gravity = 48;
            getWindow().setAttributes(attributes2);
        }
        setCanceledOnTouchOutside(true);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        getWindow().setWindowAnimations(R$style.ideo_top_wifikey_guide_dialog_animation);
        setOnDismissListener(new c());
    }

    public void l(String str) {
        TextView textView;
        if (TextUtils.isEmpty(str) || (textView = this.f) == null) {
            return;
        }
        textView.setText(str);
    }

    public void m(int i) {
        if (i > 0) {
            this.f21425a = ((long) i) * 1000;
        }
    }

    public void n(String str) {
        TextView textView;
        if (TextUtils.isEmpty(str) || (textView = this.e) == null) {
            return;
        }
        textView.setText(str);
    }

    public void o(String str) {
        TextView textView;
        if (TextUtils.isEmpty(str) || (textView = this.d) == null) {
            return;
        }
        textView.setText(str);
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            LogUtil.onEvent("wig1", null, null, null);
            zn6.d("lx_client_wfguide_wig1", null, null);
            this.b.postDelayed(new d(), this.f21425a + l);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
