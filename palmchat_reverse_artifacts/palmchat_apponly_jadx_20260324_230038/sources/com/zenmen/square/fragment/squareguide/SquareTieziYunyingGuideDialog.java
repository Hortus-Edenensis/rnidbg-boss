package com.zenmen.square.fragment.squareguide;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.topic.bean.TopicListBean;
import defpackage.bj5;
import defpackage.hc2;
import defpackage.kc2;
import defpackage.lj5;
import defpackage.q05;
import defpackage.qj5;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareTieziYunyingGuideDialog extends LXBottomSheetDialog {
    public QueryGuidePopupResult h;
    public Context i;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: com.zenmen.square.fragment.squareguide.SquareTieziYunyingGuideDialog$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1156a extends HashMap<String, Object> {
            public C1156a() {
                put("postguide_ID", Long.valueOf(SquareTieziYunyingGuideDialog.this.h.id));
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            q05.a("postguide_halfpopup_close", 2, new C1156a());
            SquareTieziYunyingGuideDialog.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("postguide_ID", Long.valueOf(SquareTieziYunyingGuideDialog.this.h.id));
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            q05.a("postguide_halfpopup_share", 2, new a());
            SquareTieziYunyingGuideDialog.this.A();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {
        public c() {
            put("postguide_ID", Long.valueOf(SquareTieziYunyingGuideDialog.this.h.id));
        }
    }

    public SquareTieziYunyingGuideDialog(@NonNull Context context, QueryGuidePopupResult queryGuidePopupResult) {
        super(context);
        this.h = queryGuidePopupResult;
        this.i = context;
    }

    public final void A() {
        TopicListBean.Topic topic;
        if (lj5.c().g == null || lj5.c().g.bindTopicId == null) {
            topic = null;
        } else {
            topic = new TopicListBean.Topic();
            topic.topicId = lj5.c().g.bindTopicId.longValue();
            topic.topicName = lj5.c().g.bindTopicName;
        }
        qj5.h(1);
        bj5.b().a().c0((Activity) this.i, 102, null, topic, null, true);
        dismiss();
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
    public View n() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R$layout.dialog_square_tiezi_yunying_guide, (ViewGroup) null);
        TextView textView = (TextView) viewGroup.findViewById(R$id.title);
        ImageView imageView = (ImageView) viewGroup.findViewById(R$id.image);
        TextView textView2 = (TextView) viewGroup.findViewById(R$id.content);
        ImageView imageView2 = (ImageView) viewGroup.findViewById(R$id.publish_btn);
        if (!TextUtils.isEmpty(this.h.titleText)) {
            textView.setText(this.h.titleText);
        }
        if (!TextUtils.isEmpty(this.h.bodyText)) {
            textView2.setText(this.h.bodyText);
        }
        kc2<Drawable> kc2VarLoad = hc2.a(this.i).load(this.h.imageUrl);
        int i = R$drawable.dialog_square_tiezi_yunying_guide_image_bg;
        kc2VarLoad.placeholder(i).error(i).into(imageView);
        kc2<Drawable> kc2VarLoad2 = hc2.a(this.i).load(this.h.btnImageUrl);
        int i2 = R$drawable.dialog_square_tiezi_yunying_guide_btn_bg;
        kc2VarLoad2.placeholder(i2).error(i2).into(imageView2);
        viewGroup.findViewById(R$id.close).setOnClickListener(new a());
        imageView2.setOnClickListener(new b());
        lj5.c().b();
        q05.a("postguide_halfpopup", 1, new c());
        return viewGroup;
    }
}
