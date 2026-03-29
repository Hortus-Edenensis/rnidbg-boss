package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.CircleRedPacketInfoBean;
import com.zenmen.palmchat.widget.EffectiveShapeView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class vb0 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EffectiveShapeView f21397a;
    public TextView b;
    public TextView c;
    public TextView d;
    public ImageView e;
    public TextView f;
    public ImageView g;
    public a h;
    public CircleRedPacketInfoBean i;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void b();
    }

    public vb0(@NonNull Context context) {
        super(context, R.style.custom_dialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        a aVar = this.h;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        a aVar = this.h;
        if (aVar != null) {
            aVar.b();
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        dismiss();
    }

    public final void d() {
        this.e.setOnClickListener(new View.OnClickListener() { // from class: sb0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20702a.f(view);
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() { // from class: tb0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20947a.g(view);
            }
        });
        this.g.setOnClickListener(new View.OnClickListener() { // from class: ub0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21182a.h(view);
            }
        });
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        k();
    }

    public final void e() {
        this.f21397a = (EffectiveShapeView) findViewById(R.id.circle_red_packet_avatar);
        this.b = (TextView) findViewById(R.id.circle_red_packet_nickname);
        this.c = (TextView) findViewById(R.id.circle_red_packet_subtitle);
        this.d = (TextView) findViewById(R.id.circle_red_packet_description);
        this.e = (ImageView) findViewById(R.id.circle_red_packet_open);
        this.f = (TextView) findViewById(R.id.circle_red_packet_go_detail);
        this.g = (ImageView) findViewById(R.id.circle_red_packet_close);
    }

    public void i(a aVar) {
        this.h = aVar;
    }

    public void j() {
        this.e.setImageResource(R.drawable.animation_red_packet_circle);
        Drawable drawable = this.e.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    public void k() {
        this.e.setImageResource(R.drawable.icon_circle_red_packet_open);
    }

    public void l(CircleRedPacketInfoBean circleRedPacketInfoBean) {
        if (circleRedPacketInfoBean == null) {
            return;
        }
        if (this.f21397a == null) {
            this.i = circleRedPacketInfoBean;
            return;
        }
        this.i = null;
        gr2.j().h(circleRedPacketInfoBean.getHeadIconUrl(), this.f21397a, bq6.s());
        this.b.setText(circleRedPacketInfoBean.getNickname());
        this.c.setText(circleRedPacketInfoBean.getCouponTypeTips());
        this.d.setText(circleRedPacketInfoBean.getReceiveContent());
        if (circleRedPacketInfoBean.isShowReceiveDisplay()) {
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
        if (circleRedPacketInfoBean.isShowDetailDisplay()) {
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
        k();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_red_packet_circle);
        e();
        d();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        CircleRedPacketInfoBean circleRedPacketInfoBean = this.i;
        if (circleRedPacketInfoBean != null) {
            l(circleRedPacketInfoBean);
        }
    }
}
