package com.zenmen.square.topic.guide;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.topic.bean.TopicListBean;
import defpackage.dn0;
import defpackage.gr2;
import defpackage.hr2;
import defpackage.je1;
import defpackage.l50;
import defpackage.me1;
import defpackage.v4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareTopicActivityDialog extends LXBottomSheetDialog {
    public TextView h;
    public ImageView i;
    public ImageView j;
    public EffectiveShapeView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public c o;
    public int p;
    public TopicListBean.ActivityInfo q;
    public je1 r;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            if (SquareTopicActivityDialog.this.o != null) {
                SquareTopicActivityDialog.this.o.a(SquareTopicActivityDialog.this.q.activityId);
                SquareTopicActivityDialog.this.o = null;
            }
            SquareTopicActivityDialog.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareTopicActivityDialog.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(long j);

        void onCancel();
    }

    public SquareTopicActivityDialog(@NonNull Context context, TopicListBean.ActivityInfo activityInfo, c cVar) {
        super(context);
        this.q = activityInfo;
        this.o = cVar;
        this.p = (me1.g() - me1.b(getContext(), 32)) / 2;
        t(me1.b(context, 250) + this.p);
        this.r = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).A(R$drawable.square_topic_activity_default_bg).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();
    }

    public static void D(Context context, TopicListBean.ActivityInfo activityInfo, c cVar) {
        if (activityInfo == null || cVar == null) {
            return;
        }
        SquareTopicActivityDialog squareTopicActivityDialog = new SquareTopicActivityDialog(context, activityInfo, cVar);
        squareTopicActivityDialog.w(false);
        squareTopicActivityDialog.show();
    }

    public final void C(View view) {
        this.h = (TextView) view.findViewById(R$id.tv_title);
        this.i = (ImageView) view.findViewById(R$id.img_close);
        ImageView imageView = (ImageView) view.findViewById(R$id.img_banner);
        this.j = imageView;
        imageView.getLayoutParams().height = this.p;
        this.k = (EffectiveShapeView) view.findViewById(R$id.img_portrait);
        this.l = (TextView) view.findViewById(R$id.tv_greet);
        this.m = (TextView) view.findViewById(R$id.tv_guide);
        this.n = (TextView) view.findViewById(R$id.btn_confirm);
        ContactInfoItem contactInfoItemA = dn0.a(v4.e(getContext()));
        if (contactInfoItemA != null && contactInfoItemA.getNickName() != null) {
            gr2.j().h(contactInfoItemA.getIconURL(), this.k, hr2.i());
            if (!TextUtils.isEmpty(this.q.activityGreeting)) {
                this.l.setText(this.q.activityGreeting.replace("%nickname%", contactInfoItemA.getNickName()));
            }
        }
        gr2.j().h(this.q.bgImage, this.j, this.r);
        this.h.setText("#" + this.q.topicName);
        this.m.setText(this.q.activityGuide);
        this.n.setText(this.q.activityParticipationText);
        this.n.setOnClickListener(new a());
        this.i.setOnClickListener(new b());
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        c cVar = this.o;
        if (cVar != null) {
            cVar.onCancel();
            this.o = null;
        }
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
    public View n() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.square_layout_dialog_topic_activity_guide, (ViewGroup) null);
        C(viewInflate);
        return viewInflate;
    }
}
