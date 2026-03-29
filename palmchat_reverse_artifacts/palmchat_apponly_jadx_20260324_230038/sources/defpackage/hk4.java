package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.userdetail.polish.vo.PolishSuccessVo;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class hk4 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f17982a;

        public a(MaterialDialog materialDialog) {
            this.f17982a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f17982a.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, String> {
        public c() {
            put(EventParams.KEY_GROUP, gk4.b());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f17983a;
        public final /* synthetic */ Runnable b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, String> {
            public a() {
                put("click_type", String.valueOf(1));
                put(EventParams.KEY_GROUP, gk4.b());
            }
        }

        public d(MaterialDialog materialDialog, Runnable runnable) {
            this.f17983a = materialDialog;
            this.b = runnable;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f17983a.cancel();
            this.b.run();
            zn6.h("sign_task_success", "click", new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f17985a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, String> {
            public a() {
                put("click_type", String.valueOf(2));
                put(EventParams.KEY_GROUP, gk4.b());
            }
        }

        public e(MaterialDialog materialDialog) {
            this.f17985a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f17985a.cancel();
            zn6.h("sign_task_success", "click", new a());
        }
    }

    public static void a(Context context, Runnable runnable) {
        zn6.h("sign_task_success", "view", new c());
        PolishSuccessVo polishSuccessVo = gk4.c().b;
        MaterialDialog materialDialogE = new sd3(context).h(false).v(true).c(0).o(R.layout.layout_dialog_polish_result, false).e();
        View viewJ = materialDialogE.j();
        if (viewJ != null) {
            TextView textView = (TextView) viewJ.findViewById(R.id.content);
            String str = polishSuccessVo.popText;
            if (!TextUtils.isEmpty(str)) {
                textView.setText(str);
            }
            TextView textView2 = (TextView) viewJ.findViewById(R.id.confirm);
            textView2.setText(gk4.c().a().successPop.b);
            textView2.setOnClickListener(new d(materialDialogE, runnable));
            ((TextView) viewJ.findViewById(R.id.cancel)).setOnClickListener(new e(materialDialogE));
        }
        materialDialogE.c(false);
        materialDialogE.setOnDismissListener(new f());
        materialDialogE.show();
    }

    public static void b(Context context) {
        MaterialDialog materialDialogE = new sd3(context).h(false).v(true).c(0).o(R.layout.layout_dialog_polish_rule, false).e();
        View viewJ = materialDialogE.j();
        if (viewJ != null) {
            TextView textView = (TextView) viewJ.findViewById(R.id.content);
            String str = gk4.c().a().rule;
            if (!TextUtils.isEmpty(str)) {
                textView.setText(str);
            }
            ((TextView) viewJ.findViewById(R.id.confirm)).setOnClickListener(new a(materialDialogE));
        }
        materialDialogE.c(false);
        materialDialogE.setOnDismissListener(new b());
        materialDialogE.show();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements DialogInterface.OnDismissListener {
        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements DialogInterface.OnDismissListener {
        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
        }
    }
}
