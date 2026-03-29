package defpackage;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.openapi.R$layout;
import com.zenmen.palmchat.framework.R$anim;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$style;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class xn4 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Window f22013a;
    public Animation b;
    public TextView c;
    public ImageView d;

    public xn4(Context context) {
        super(context, R$style.custom_progress_dialog);
        this.f22013a = getWindow();
        a(context);
    }

    public void a(Context context) {
        WindowManager.LayoutParams attributes = this.f22013a.getAttributes();
        attributes.dimAmount = 0.5f;
        getWindow().setAttributes(attributes);
        getWindow().addFlags(2);
        this.f22013a.requestFeature(1);
        this.f22013a.setContentView(R$layout.lx_custom_progress_dialog);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        this.d = (ImageView) this.f22013a.findViewById(R$id.progress_img);
        this.c = (TextView) this.f22013a.findViewById(R$id.message_textview);
        this.b = AnimationUtils.loadAnimation(context, R$anim.custom_progress_dialog_rotate);
    }

    public void b(CharSequence charSequence) {
        this.c.setText(charSequence);
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        this.d.startAnimation(this.b);
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        this.d.clearAnimation();
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
