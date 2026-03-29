package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class mc1 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19193a;
    public a b;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(int i);
    }

    public mc1(@NonNull Context context, int i, a aVar) {
        super(context);
        this.b = aVar;
        this.f19193a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        h(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        h(0);
    }

    public final void d() {
        findViewById(R.id.layout_circle_name_permission_cancel).setOnClickListener(new View.OnClickListener() { // from class: jc1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18379a.e(view);
            }
        });
        findViewById(R.id.layout_circle_name_permission_admin).setOnClickListener(new View.OnClickListener() { // from class: kc1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18618a.f(view);
            }
        });
        findViewById(R.id.layout_circle_name_permission_member).setOnClickListener(new View.OnClickListener() { // from class: lc1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18956a.g(view);
            }
        });
        TextView textView = (TextView) findViewById(R.id.tv_circle_name_perm_all_member);
        TextView textView2 = (TextView) findViewById(R.id.tv_circle_name_perm_owner_admin);
        int i = this.f19193a;
        if (i == 0) {
            textView.setTypeface(Typeface.defaultFromStyle(1));
            textView2.setTypeface(Typeface.defaultFromStyle(0));
        } else if (i == 1) {
            textView.setTypeface(Typeface.defaultFromStyle(0));
            textView2.setTypeface(Typeface.defaultFromStyle(1));
        }
    }

    public final void h(int i) {
        dismiss();
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public final void i() {
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        WindowManager.LayoutParams attributes = window.getAttributes();
        setCanceledOnTouchOutside(true);
        attributes.gravity = 80;
        attributes.width = getContext().getResources().getDisplayMetrics().widthPixels;
        attributes.flags &= 2;
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_circle_name_modify_permission_layout);
        d();
        i();
    }
}
