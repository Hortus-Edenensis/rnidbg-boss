package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class dd1 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f17026a;

        public a(MaterialDialog materialDialog) {
            this.f17026a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f17026a.dismiss();
        }
    }

    public static void a(Context context, String str, int i) {
        View viewInflate = View.inflate(context, R$layout.layout_find_unlock_dialog, null);
        MaterialDialog materialDialogE = new sd3(context).p(viewInflate, false).h(true).e();
        materialDialogE.show();
        TextView textView = (TextView) viewInflate.findViewById(R$id.tv_msg);
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.tv_remain_count_info);
        View viewFindViewById = viewInflate.findViewById(R$id.tv_confirm_btn);
        textView.setText(str);
        if (i < 0) {
            textView2.setAlpha(0.0f);
            ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
            layoutParams.height = a46.b(context, 20.0f);
            textView2.setLayoutParams(layoutParams);
        } else {
            textView2.setAlpha(1.0f);
            textView2.setHeight(a46.b(context, 42.0f));
            textView2.setText(context.getString(R$string.find_remain_count, Integer.valueOf(i)));
        }
        viewFindViewById.setOnClickListener(new a(materialDialogE));
    }
}
