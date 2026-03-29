package com.zenmen.palmchat.conversations.threadsnew.headerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.conversations.threadsnew.headerview.ThreadHeaderViewV5;
import com.zenmen.palmchat.maintab.config.TurnInfo;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.hc2;
import defpackage.hw5;
import defpackage.k86;
import defpackage.l50;
import defpackage.x56;
import defpackage.zn6;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ThreadCardNoticeView extends LinearLayout implements View.OnClickListener {
    private static final String TAG = "ThreadCardNoticeView";
    private ThreadHeaderViewV5.d mListener;
    private int noticeId;
    private LinearLayout rootView;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends SimpleTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EffectiveShapeView f13827a;

        public a(EffectiveShapeView effectiveShapeView) {
            this.f13827a = effectiveShapeView;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
            if (bitmap != null) {
                ViewGroup.LayoutParams layoutParams = this.f13827a.getLayoutParams();
                layoutParams.height = ((k86.z(ThreadCardNoticeView.this.getContext()) - k86.e(ThreadCardNoticeView.this.getContext(), 32.0f)) * bitmap.getHeight()) / bitmap.getWidth();
                this.f13827a.setLayoutParams(layoutParams);
                this.f13827a.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ hw5 f13828a;

        public b(hw5 hw5Var) {
            this.f13828a = hw5Var;
            put("style", Integer.valueOf(hw5Var.h()));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ hw5 f13829a;

        public c(hw5 hw5Var) {
            this.f13829a = hw5Var;
            put("style", Integer.valueOf(hw5Var.h()));
            put("mid", hw5Var.g());
            put(TurnInfo.TYPE_DEEP_LINK, hw5Var.d());
            put("type", 53);
        }
    }

    public ThreadCardNoticeView(Context context) {
        this(context, null);
    }

    private void initViews(Context context) {
        this.rootView = (LinearLayout) View.inflate(context, R.layout.layout_thread_notice_view, this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (l50.a()) {
            return;
        }
        this.mListener.a();
    }

    public void setClickListener(ThreadHeaderViewV5.d dVar) {
        this.mListener = dVar;
    }

    public boolean showNotice(hw5 hw5Var) {
        if (hw5Var == null) {
            this.rootView.removeAllViews();
            this.noticeId = -1;
            setVisibility(8);
        } else if (this.noticeId != hw5Var.f()) {
            this.rootView.removeAllViews();
            View viewInflate = null;
            if (hw5Var.h() == 1) {
                viewInflate = View.inflate(getContext(), R.layout.layout_thread_card_style1, null);
                EffectiveShapeView effectiveShapeView = (EffectiveShapeView) viewInflate.findViewById(R.id.img_icon);
                effectiveShapeView.changeShapeType(1);
                effectiveShapeView.setDegreeForRoundRectangle(13, 13);
                TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_desc);
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_btn);
                gr2.j().h(hw5Var.e(), effectiveShapeView, bq6.x());
                textView.setText(hw5Var.i());
                textView2.setText(hw5Var.b());
                textView3.setText(hw5Var.c());
                textView3.setOnClickListener(this);
            } else if (hw5Var.h() == 2) {
                viewInflate = View.inflate(getContext(), R.layout.layout_thread_card_style2, null);
                EffectiveShapeView effectiveShapeView2 = (EffectiveShapeView) viewInflate.findViewById(R.id.img_icon);
                effectiveShapeView2.changeShapeType(1);
                effectiveShapeView2.setDegreeForRoundRectangle(13, 13);
                TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_title);
                TextView textView5 = (TextView) viewInflate.findViewById(R.id.tv_desc);
                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_right_ic);
                gr2.j().h(hw5Var.e(), effectiveShapeView2, bq6.x());
                textView4.setText(hw5Var.i());
                textView5.setText(hw5Var.b());
                imageView.setVisibility(TextUtils.isEmpty(hw5Var.d()) ? 8 : 0);
                viewInflate.setOnClickListener(this);
            } else if (hw5Var.h() == 3) {
                viewInflate = View.inflate(getContext(), R.layout.layout_thread_card_style3, null);
                TextView textView6 = (TextView) viewInflate.findViewById(R.id.tv_desc);
                ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.img_right_ic);
                x56 x56Var = new x56(getContext(), textView6, hw5Var.e(), R.drawable.ic_thread_card_notice);
                SpannableString spannableString = new SpannableString("[image]  " + hw5Var.b());
                spannableString.setSpan(x56Var, 0, 8, 1);
                textView6.setText(spannableString);
                imageView2.setVisibility(TextUtils.isEmpty(hw5Var.d()) ? 8 : 0);
                viewInflate.setOnClickListener(this);
            } else if (hw5Var.h() == 4) {
                viewInflate = View.inflate(getContext(), R.layout.layout_thread_card_style4, null);
                hc2.a(com.zenmen.palmchat.c.b()).asBitmap().load(hw5Var.a()).into(new a((EffectiveShapeView) viewInflate.findViewById(R.id.img_banner)));
                viewInflate.setOnClickListener(this);
            }
            if (viewInflate == null) {
                this.noticeId = -1;
                setVisibility(8);
                return false;
            }
            this.rootView.addView(viewInflate, new ViewGroup.LayoutParams(-1, -2));
            this.noticeId = hw5Var.f();
            setVisibility(0);
            LogUtil.uploadInfoImmediate("notice_new", new b(hw5Var));
            zn6.j("pagemsg_noticenew", "view", new c(hw5Var));
            return true;
        }
        return true;
    }

    public ThreadCardNoticeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadCardNoticeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.noticeId = -1;
        initViews(context);
    }
}
