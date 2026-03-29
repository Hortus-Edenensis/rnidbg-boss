package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.widget.EffectiveShapeView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class jn0 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f18438a;
    public ContactInfoItem b;
    public String c;
    public String d;
    public String e;
    public a f;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(Context context, ContactInfoItem contactInfoItem);

        void onCancel();
    }

    public jn0(@NonNull Context context, ContactInfoItem contactInfoItem, String str, String str2, String str3) {
        super(context);
        this.f18438a = context;
        this.b = contactInfoItem;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        dismiss();
        a aVar = this.f;
        if (aVar != null) {
            aVar.a(this.f18438a, this.b);
            this.f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(DialogInterface dialogInterface) {
        a aVar = this.f;
        if (aVar != null) {
            aVar.onCancel();
        }
    }

    public final void d() {
        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: hn0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17998a.e(view);
            }
        });
        ((TextView) findViewById(R.id.title_text)).setText(this.c);
        ((TextView) findViewById(R.id.digest_text)).setText(this.d);
        TextView textView = (TextView) findViewById(R.id.btn_confirm);
        textView.setText(this.e);
        if (this.b != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: in0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f18206a.f(view);
                }
            });
            ((TextView) findViewById(R.id.name_text)).setText(this.b.getNickName());
            TextView textView2 = (TextView) findViewById(R.id.info_text);
            String cityName = this.b.getGender() == 0 ? "男" : this.b.getGender() == 1 ? "女" : "";
            if (!TextUtils.isEmpty(this.b.getCityName())) {
                if (TextUtils.isEmpty(cityName)) {
                    cityName = this.b.getCityName();
                } else {
                    cityName = cityName + " · " + this.b.getCityName();
                }
            }
            textView2.setText(cityName);
            EffectiveShapeView effectiveShapeView = (EffectiveShapeView) findViewById(R.id.portrait_icon);
            effectiveShapeView.setBorderWidth(me1.b(getContext(), 2));
            effectiveShapeView.setBorderColor(getContext().getResources().getColor(R.color.Aa));
            gr2.j().h(this.b.getBigIconURL(), effectiveShapeView, bq6.s());
        }
    }

    public void h(a aVar) {
        this.f = aVar;
    }

    public final void i() {
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
                window.setAttributes(attributes);
            }
        }
        setCanceledOnTouchOutside(false);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_dialog_contact_chat);
        d();
        i();
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: gn0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f17756a.g(dialogInterface);
            }
        });
    }
}
