package com.zenmen.palmchat.contacts.userdetail.polish;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.github.mikephil.charting.charts.LineChart;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.userdetail.polish.vo.PolishStateVo;
import com.zenmen.palmchat.contacts.userdetail.polish.vo.PolishSuccessVo;
import com.zenmen.palmchat.paidservices.superexpose.SuperExposeHomeActivity;
import com.zenmen.palmchat.widget.LightingAnimationView;
import defpackage.fk4;
import defpackage.gk4;
import defpackage.hk4;
import defpackage.k10;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class PolishView extends FrameLayout implements View.OnClickListener {
    public static final String TAG = "PolishView";
    private TextView action;
    private TextView bubbleTv;
    private LineChart chart;
    private View contentLayout;
    private ImageView description;
    private View loadingIv;
    private View loadingLayout;
    private TextView polishTv;
    private LightingAnimationView polish_anim_view;
    private View retryView;

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13729a;

        public b(int i) {
            this.f13729a = i;
            put("click_type", String.valueOf(i));
            put(EventParams.KEY_GROUP, gk4.b());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PolishView.this.polish_anim_view.startLightingAnimation(0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f13731a;

        public d(boolean z) {
            this.f13731a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            PolishStateVo polishStateVo = gk4.c().c;
            if (polishStateVo == null) {
                PolishView.this.showErrorLayout();
                return;
            }
            PolishView.this.updateUiOnDataSuccess(polishStateVo);
            if (polishStateVo.todayLight || !this.f13731a) {
                return;
            }
            PolishView.this.logClick(1);
            PolishView.this.polish(true);
        }
    }

    public PolishView(@NonNull Context context) {
        this(context, null);
    }

    private void initView(int i) {
        View viewInflate = View.inflate(getContext(), i == 0 ? R.layout.lx_polish_main_view : R.layout.lx_polish_main_view2, this);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.description);
        this.description = imageView;
        imageView.setOnClickListener(this);
        viewInflate.findViewById(R.id.add).setOnClickListener(this);
        this.polishTv = (TextView) viewInflate.findViewById(R.id.polishTv);
        this.chart = (LineChart) viewInflate.findViewById(R.id.chart);
        TextView textView = (TextView) viewInflate.findViewById(R.id.action);
        this.action = textView;
        textView.setOnClickListener(this);
        this.bubbleTv = (TextView) viewInflate.findViewById(R.id.bubbleTv);
        this.retryView = viewInflate.findViewById(R.id.retryView);
        ((TextView) viewInflate.findViewById(R.id.retryTv)).setText(Html.fromHtml(getContext().getResources().getString(R.string.captcha_error_text)));
        this.retryView.setOnClickListener(this);
        this.contentLayout = viewInflate.findViewById(R.id.contentLayout);
        this.loadingLayout = viewInflate.findViewById(R.id.loadingLayout);
        this.loadingIv = viewInflate.findViewById(R.id.loadingIv);
        this.polish_anim_view = (LightingAnimationView) viewInflate.findViewById(R.id.polish_anim_view);
        k10.b(this.chart);
        if (gk4.e) {
            k10.c(getContext(), this.chart, k10.a(7, 1000), true);
            testPolish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpSuperExpose(boolean z) {
        SuperExposeHomeActivity.C1(getContext(), z ? SuperExposeHomeActivity.FROM.POLISH_ADD : SuperExposeHomeActivity.FROM.POLISH_SUCCESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logClick(int i) {
        zn6.h("sign_task", "click", new b(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void polish(boolean z) {
        fk4.a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorLayout() {
        this.retryView.setVisibility(0);
        this.contentLayout.setVisibility(8);
        this.loadingLayout.setVisibility(8);
        this.loadingIv.clearAnimation();
    }

    private void testPolish() {
        SpannableString spannableString = new SpannableString("昨日曝光5次\n最近7天数据不错哦~");
        spannableString.setSpan(new RelativeSizeSpan(2.0f), 4, 5, 33);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#222222")), 4, 5, 33);
        this.polishTv.setText(spannableString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUIOnPolishSuccess(PolishSuccessVo polishSuccessVo) {
        this.action.setEnabled(false);
        this.bubbleTv.setVisibility(8);
        this.action.setText("已擦亮，明天再来");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUiOnDataSuccess(PolishStateVo polishStateVo) {
        String str;
        this.retryView.setVisibility(8);
        this.contentLayout.setVisibility(0);
        this.loadingLayout.setVisibility(8);
        this.loadingIv.clearAnimation();
        if (polishStateVo != null) {
            ArrayList arrayList = new ArrayList();
            List<Integer> list = polishStateVo.showCountArray;
            if (list == null || list.size() == 0) {
                for (int i = 0; i < 7; i++) {
                    arrayList.add(0);
                }
            } else {
                arrayList.addAll(polishStateVo.showCountArray);
            }
            k10.c(getContext(), this.chart, arrayList, true);
            if (polishStateVo.todayLight) {
                updateUIOnPolishSuccess(null);
            } else {
                this.action.setEnabled(true);
                if (TextUtils.isEmpty(polishStateVo.popText)) {
                    this.bubbleTv.setVisibility(8);
                } else {
                    this.bubbleTv.setText(polishStateVo.popText);
                    this.bubbleTv.setVisibility(0);
                }
                this.polish_anim_view.postDelayed(new c(), 0L);
            }
            this.action.setText(polishStateVo.buttonText);
            String strValueOf = String.valueOf(arrayList.get(arrayList.size() - 1));
            Iterator it = arrayList.iterator();
            int iIntValue = 0;
            while (it.hasNext()) {
                iIntValue += ((Integer) it.next()).intValue();
            }
            if (iIntValue == 0) {
                str = "曝光有点少，擦亮主页加曝光~";
            } else {
                List<String> list2 = gk4.c().a().texts;
                if (list2 == null || list2.size() <= 0) {
                    str = "最近7天数据不错哦~";
                } else {
                    Collections.shuffle(list2);
                    str = list2.get(0);
                }
            }
            SpannableString spannableString = new SpannableString(("昨日曝光s次\n" + str).replace("s", strValueOf));
            spannableString.setSpan(new RelativeSizeSpan(2.0f), 4, strValueOf.length() + 4, 33);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#222222")), 4, strValueOf.length() + 4, 33);
            this.polishTv.setText(spannableString);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.description) {
            logClick(4);
            hk4.b(getContext());
            return;
        }
        if (view.getId() == R.id.add) {
            logClick(3);
            jumpSuperExpose(true);
        } else if (view.getId() == R.id.action) {
            logClick(2);
            polish(false);
        } else if (view.getId() == R.id.retryView) {
            update(false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.loadingIv.clearAnimation();
    }

    public void update(boolean z) {
        this.retryView.setVisibility(8);
        this.contentLayout.setVisibility(8);
        this.loadingLayout.setVisibility(0);
        this.loadingIv.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.custom_progress_dialog_rotate));
        fk4.c(new d(z));
    }

    public PolishView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PolishView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2 = 0;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PolishView);
            i2 = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
        initView(i2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: com.zenmen.palmchat.contacts.userdetail.polish.PolishView$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC1035a implements Runnable {
            public RunnableC1035a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PolishView.this.jumpSuperExpose(false);
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PolishView.this.updateUIOnPolishSuccess(gk4.c().b);
            hk4.a(PolishView.this.getContext(), new RunnableC1035a());
            fk4.b(new b());
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }
    }
}
