package defpackage;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.zenmen.palmchat.framework.R$anim;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.framework.R$style;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class kd5 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Window f18668a;
    public Animation b;
    public ImageView c;

    public kd5(Context context) {
        super(context, R$style.custom_progress_dialog);
        this.f18668a = getWindow();
        a(context);
    }

    public static kd5 b(Activity activity) {
        if (activity.isFinishing()) {
            return null;
        }
        kd5 kd5Var = new kd5(activity);
        kd5Var.setCancelable(true);
        kd5Var.show();
        return kd5Var;
    }

    public void a(Context context) {
        WindowManager.LayoutParams attributes = this.f18668a.getAttributes();
        attributes.dimAmount = 0.5f;
        getWindow().setAttributes(attributes);
        getWindow().addFlags(2);
        this.f18668a.requestFeature(1);
        this.f18668a.setContentView(R$layout.layout_custom_progress_dialog_simple);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        this.c = (ImageView) this.f18668a.findViewById(R$id.progress_img);
        this.b = AnimationUtils.loadAnimation(context, R$anim.custom_progress_dialog_rotate);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        this.c.startAnimation(this.b);
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        this.c.clearAnimation();
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
