package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.widget.UpgradeCharmView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class d10 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f16958a;
    public int b;
    public int c;

    public d10(@NonNull Context context, int i, int i2) {
        super(context);
        this.f16958a = context;
        this.b = i;
        this.c = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        dismiss();
    }

    public final void b() {
        findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() { // from class: c10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1867a.c(view);
            }
        });
        ((TextView) findViewById(R.id.text_level)).setText(this.c + "");
        ((UpgradeCharmView) findViewById(R.id.last_level)).setLevel(this.b);
        ((UpgradeCharmView) findViewById(R.id.current_level)).setLevel(this.c);
    }

    public final void d() {
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.height = -2;
                attributes.width = -1;
                attributes.gravity = 17;
                attributes.flags &= 2;
                attributes.dimAmount = 0.6f;
                window.setAttributes(attributes);
            }
        }
        setCanceledOnTouchOutside(false);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_dialog_charmlevel_upgrade);
        b();
        d();
    }
}
