package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class dg6 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f17048a;
        public final /* synthetic */ DialogInterface.OnCancelListener b;

        public a(MaterialDialog materialDialog, DialogInterface.OnCancelListener onCancelListener) {
            this.f17048a = materialDialog;
            this.b = onCancelListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f17048a.dismiss();
            this.b.onCancel(this.f17048a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f17049a;
        public final /* synthetic */ DialogInterface.OnClickListener b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;

        public b(MaterialDialog materialDialog, DialogInterface.OnClickListener onClickListener, Context context, String str) {
            this.f17049a = materialDialog;
            this.b = onClickListener;
            this.c = context;
            this.d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f17049a.dismiss();
            this.b.onClick(this.f17049a, 0);
            ap3.x(this.c, this.d);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnCancelListener f17050a;

        public c(DialogInterface.OnCancelListener onCancelListener) {
            this.f17050a = onCancelListener;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.f17050a.onCancel(dialogInterface);
        }
    }

    public static void a(Context context, DialogInterface.OnCancelListener onCancelListener, DialogInterface.OnClickListener onClickListener, String str) {
        View viewInflate = View.inflate(context, R$layout.layout_dialog_find_vip_guide, null);
        MaterialDialog materialDialogE = new sd3(context).c(0).p(viewInflate, false).h(true).e();
        materialDialogE.show();
        a aVar = new a(materialDialogE, onCancelListener);
        View viewFindViewById = viewInflate.findViewById(R$id.tv_vip_invalid_dialog_confirm);
        viewInflate.findViewById(R$id.tv_vip_invalid_dialog_cancel).setOnClickListener(aVar);
        viewInflate.findViewById(R$id.iv_close).setOnClickListener(aVar);
        viewFindViewById.setOnClickListener(new b(materialDialogE, onClickListener, context, str));
        materialDialogE.setOnCancelListener(new c(onCancelListener));
    }
}
