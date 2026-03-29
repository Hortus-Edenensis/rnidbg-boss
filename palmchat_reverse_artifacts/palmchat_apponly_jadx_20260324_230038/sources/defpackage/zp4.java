package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.gift.quicksend.QuickSendVo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class zp4 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f22476a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f22477a;

        public a(b bVar) {
            this.f22477a = bVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            b bVar = this.f22477a;
            if (bVar != null) {
                bVar.onCancel();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(boolean z);

        void onCancel();
    }

    public zp4(@NonNull Context context) {
        super(context, R.style.CustomDialog);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_dialog_gift_quick_send, (ViewGroup) null, false);
        this.f22476a = viewInflate;
        setContentView(viewInflate);
        this.b = (TextView) this.f22476a.findViewById(R.id.tv_title);
        this.d = (TextView) this.f22476a.findViewById(R.id.button1);
        this.e = (TextView) this.f22476a.findViewById(R.id.button2);
        this.c = (TextView) this.f22476a.findViewById(R.id.button3);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = (me1.g() * 3) / 4;
        onWindowAttributesChanged(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(b bVar, View view) {
        if (bVar != null) {
            bVar.a(true);
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(b bVar, View view) {
        if (bVar != null) {
            bVar.a(false);
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(b bVar, View view) {
        dismiss();
        if (bVar != null) {
            bVar.onCancel();
        }
    }

    public zp4 g(QuickSendVo quickSendVo) {
        this.b.setText("赠送" + quickSendVo.itemName + "将花费" + quickSendVo.realPrice + "连信豆");
        return this;
    }

    public void h(final b bVar) {
        this.d.setOnClickListener(new View.OnClickListener() { // from class: wp4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21771a.d(bVar, view);
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: xp4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f22031a.e(bVar, view);
            }
        });
        this.c.setOnClickListener(new View.OnClickListener() { // from class: yp4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f22249a.f(bVar, view);
            }
        });
        setOnCancelListener(new a(bVar));
        show();
    }
}
