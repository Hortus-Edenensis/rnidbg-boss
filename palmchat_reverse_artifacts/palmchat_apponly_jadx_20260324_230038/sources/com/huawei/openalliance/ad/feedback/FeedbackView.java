package com.huawei.openalliance.ad.feedback;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hms.ads.cn;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.utils.ac;
import com.huawei.openalliance.ad.utils.ag;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.bm;
import com.huawei.openalliance.ad.utils.t;
import com.huawei.openalliance.ad.utils.z;
import com.huawei.openalliance.ad.views.PPSBaseDialogContentView;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class FeedbackView extends PPSBaseDialogContentView implements d {
    private LinearLayout h;
    private LinearLayout i;
    private FlowLayoutView j;
    private FlowLayoutView k;
    private ViewStub l;
    private com.huawei.openalliance.ad.compliance.a m;
    private boolean n;
    private boolean o;
    private com.huawei.openalliance.ad.feedback.b p;
    private a q;
    private c r;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends b {
        private com.huawei.openalliance.ad.compliance.a I;

        public a(Context context) {
            super(context);
        }

        public void Code(com.huawei.openalliance.ad.compliance.a aVar) {
            this.I = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.huawei.openalliance.ad.feedback.b bVar = this.Code;
            if (bVar == null) {
                return;
            }
            boolean Z = bVar.Z();
            fh.Code("FeedbackView", "click to complain:%s", Boolean.valueOf(Z));
            if (!Z || this.I == null || z.b(view.getContext()).intValue() >= 30468100) {
                return;
            }
            this.I.Code(3, this.Code.I());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b implements View.OnClickListener {
        protected com.huawei.openalliance.ad.feedback.b Code;
        protected final Context V;

        public b(Context context) {
            this.V = context;
        }

        public void Code(com.huawei.openalliance.ad.feedback.b bVar) {
            this.Code = bVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends b {
        public c(Context context) {
            super(context);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.huawei.openalliance.ad.feedback.b bVar = this.Code;
            if (bVar == null) {
                return;
            }
            boolean zCode = bVar.Code(this.V);
            fh.Code("FeedbackView", "click to why this ad:%s", Boolean.valueOf(zCode));
            if (zCode) {
                Context context = this.V;
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }
            }
        }
    }

    public FeedbackView(Context context) {
        super(context);
        this.n = true;
        this.o = true;
    }

    private boolean I() {
        com.huawei.openalliance.ad.feedback.b bVar = this.p;
        return (bVar == null || !bVar.B() || bc.Code(this.p.C())) ? false : true;
    }

    private void setArrowBitMap(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = getResources().getDrawable(R.drawable.hiad_feedback_right_arrow);
            if (bg.I()) {
                imageView.setImageBitmap(ac.V(drawable));
            }
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void Code() {
        View view;
        try {
            this.o = cn.Code(getContext()).V();
            fh.V("FeedbackView", "adapterView mFeedbackViewPaddingLeft = %s, mFeedbackViewPaddingRight= %s", Integer.valueOf(this.b), Integer.valueOf(this.c));
            if (V() && (view = this.I) != null) {
                view.setPadding(this.b, 0, this.c, 0);
                com.huawei.openalliance.ad.feedback.b bVar = this.p;
                if (bVar != null) {
                    List<FeedbackInfo> listCode = bVar.Code();
                    List<FeedbackInfo> listV = this.p.V();
                    FeedbackInfo feedbackInfoI = this.p.I();
                    if (t.Code(listCode)) {
                        bm.Code((View) this.h, true);
                        Code(this.j, listCode, 2);
                    } else {
                        bm.Code((View) this.h, false);
                    }
                    if (t.Code(listV)) {
                        bm.Code((View) this.i, true);
                        Code(this.k, listV, 1);
                    } else {
                        bm.Code((View) this.i, false);
                    }
                    Code(feedbackInfoI);
                }
                this.I.requestLayout();
                this.I.getViewTreeObserver().addOnGlobalLayoutListener(this.e);
            }
        } catch (Throwable th) {
            fh.I("FeedbackView", "adapterView error, %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void V(Context context) {
        boolean zV = cn.Code(context).V();
        this.o = zV;
        fh.Code("FeedbackView", "isChinaRom = %s", Boolean.valueOf(zV));
        ViewStub viewStub = this.l;
        if (viewStub == null) {
            return;
        }
        viewStub.setLayoutResource(R.layout.hiad_feedback_viewstub);
        this.l.inflate();
        ImageView imageView = (ImageView) findViewById(R.id.right_arrow);
        ImageView imageView2 = (ImageView) this.V.findViewById(R.id.dsa_right_arrow);
        setArrowBitMap(imageView);
        setArrowBitMap(imageView2);
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void setAdContentData(AdContentData adContentData) {
        com.huawei.openalliance.ad.feedback.b bVar = this.p;
        if (bVar != null) {
            bVar.Code(getContext(), adContentData);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void setFeedbackListener(com.huawei.openalliance.ad.compliance.a aVar) {
        this.m = aVar;
        a aVar2 = this.q;
        if (aVar2 != null) {
            aVar2.Code(aVar);
        }
    }

    public FeedbackView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = true;
        this.o = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i, FeedbackInfo feedbackInfo) {
        com.huawei.openalliance.ad.compliance.a aVar = this.m;
        if (aVar != null) {
            aVar.Code(i, feedbackInfo);
        }
    }

    public FeedbackView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = true;
        this.o = true;
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void Code(Context context) {
        try {
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.hiad_feedback_view, this);
            this.V = viewInflate;
            this.h = (LinearLayout) viewInflate.findViewById(R.id.feedback_positive_ll);
            this.i = (LinearLayout) this.V.findViewById(R.id.feedback_negative_ll);
            this.I = this.V.findViewById(R.id.feedback_view_root);
            this.B = this.V.findViewById(R.id.feedback_scrollview);
            this.j = (FlowLayoutView) this.V.findViewById(R.id.feedback_positive_flv);
            this.k = (FlowLayoutView) this.V.findViewById(R.id.feedback_negative_flv);
            this.l = (ViewStub) this.V.findViewById(R.id.feedback_viewstub);
            this.p = new com.huawei.openalliance.ad.feedback.b(this);
            this.q = new a(getContext());
            this.r = new c(getContext());
            this.q.Code(this.p);
            this.r.Code(this.p);
        } catch (Throwable th) {
            fh.I("FeedbackView", "initView error, %s", th.getClass().getSimpleName());
        }
    }

    @SuppressLint({"NewApi"})
    public FeedbackView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.n = true;
        this.o = true;
    }

    private void Code(FlowLayoutView flowLayoutView, List<FeedbackInfo> list, final int i) {
        flowLayoutView.removeAllViews();
        if (ag.Code(list)) {
            fh.V("FeedbackView", "feedbackInfoList is null");
            return;
        }
        fh.V("FeedbackView", "initFlowLayout, feedType: %s, feedbackList.size: %s", Integer.valueOf(i), Integer.valueOf(list.size()));
        for (final FeedbackInfo feedbackInfo : list) {
            if (feedbackInfo != null && !TextUtils.isEmpty(feedbackInfo.Code())) {
                String strCode = feedbackInfo.Code();
                View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.hiad_feedback_unlike_label_item, (ViewGroup) flowLayoutView, false);
                if (viewInflate instanceof TextView) {
                    TextView textView = (TextView) viewInflate;
                    textView.setText(strCode);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.feedback.FeedbackView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            try {
                                if (FeedbackView.this.n) {
                                    FeedbackView.this.n = false;
                                    view.setSelected(!view.isSelected());
                                    view.postDelayed(new Runnable() { // from class: com.huawei.openalliance.ad.feedback.FeedbackView.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            FeedbackView.this.n = true;
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            FeedbackView.this.Code(i, feedbackInfo);
                                        }
                                    }, 200L);
                                }
                            } catch (Throwable th) {
                                fh.I("FeedbackView", "onClick error, %s", th.getClass().getSimpleName());
                            }
                        }
                    });
                    flowLayoutView.addView(textView);
                }
            }
        }
        flowLayoutView.setDefaultDisplayMode(bg.I() ? -1 : 1);
    }

    private void Code(FeedbackInfo feedbackInfo) {
        View viewFindViewById = this.V.findViewById(R.id.complain_extra_area);
        View viewFindViewById2 = this.V.findViewById(R.id.dsa_extra_area);
        if (this.o) {
            if (viewFindViewById != null) {
                if (feedbackInfo == null || !feedbackInfo.Z()) {
                    viewFindViewById.setVisibility(8);
                } else {
                    viewFindViewById.setVisibility(0);
                    ((TextView) this.V.findViewById(R.id.complain_tv)).setText(feedbackInfo.Code());
                    viewFindViewById.setOnClickListener(this.q);
                }
            }
            if (viewFindViewById2 == null) {
                return;
            }
            if (!I()) {
                viewFindViewById2.setVisibility(8);
                return;
            }
        } else {
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
            if (viewFindViewById2 == null) {
                return;
            }
        }
        viewFindViewById2.setVisibility(0);
        viewFindViewById2.setOnClickListener(this.r);
    }
}
