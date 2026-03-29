package com.zenmen.square.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.bean.SquareContactBean;
import com.zenmen.square.bean.SquareShareFeedBean;
import defpackage.gr2;
import defpackage.hr2;
import defpackage.k86;
import defpackage.mj5;
import defpackage.sy5;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class PostBar extends LxRelativeLayout implements View.OnClickListener {
    private static final String TAG = "PostBar";
    private ImageView closeView;
    private f onPostListener;
    private TextView percentView;
    private ImageView picView;
    private ProgressBar progressBar;
    private TextView retryBtnView;
    private boolean scrollOut;
    private ImageView shadowView;
    private int shareTarget;
    private TextView statusView;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {
        public a() {
            put("scen", Integer.valueOf(PostBar.this.shareTarget));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {
        public b() {
            put("scen", Integer.valueOf(PostBar.this.shareTarget));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {
        public c() {
            put("scen", Integer.valueOf(PostBar.this.shareTarget));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {
        public d() {
            put("scen", Integer.valueOf(PostBar.this.shareTarget));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void a(int i);
    }

    public PostBar(Context context) {
        this(context, null);
    }

    private void rest() {
        this.shadowView.setVisibility(8);
        this.statusView.setText(R$string.square_post_bar_uploading);
        this.percentView.setVisibility(0);
        this.percentView.setText("0%");
        this.retryBtnView.setVisibility(8);
        this.closeView.setVisibility(8);
        this.progressBar.setProgress(0);
        this.shareTarget = 2;
    }

    private void scrollOut() {
        if (getVisibility() != 0) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "translationY", getTranslationY(), getTranslationY() - getHeight());
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.addListener(new e());
        objectAnimatorOfFloat.start();
        this.scrollOut = true;
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View.inflate(context, R$layout.square_layout_post_bar, this);
        this.statusView = (TextView) findViewById(R$id.tv_status);
        this.percentView = (TextView) findViewById(R$id.tv_percent);
        this.retryBtnView = (TextView) findViewById(R$id.btn_retry);
        this.picView = (ImageView) findViewById(R$id.img_picture);
        this.shadowView = (ImageView) findViewById(R$id.img_shadow);
        this.closeView = (ImageView) findViewById(R$id.img_close);
        this.progressBar = (ProgressBar) findViewById(R$id.pb_progress);
        this.retryBtnView.setOnClickListener(this);
        this.closeView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.btn_retry) {
            if (!mj5.r().A()) {
                setVisibility(8);
                return;
            } else {
                rest();
                zn6.j("postbar_retry", "click", new a());
                return;
            }
        }
        if (view.getId() == R$id.img_close) {
            scrollOut();
            mj5.r().z();
            zn6.j("postbar_close", "click", new b());
        }
    }

    public void setOnPostListener(f fVar) {
        this.onPostListener = fVar;
    }

    public void updateStatus(SquareShareFeedBean squareShareFeedBean) {
        int i;
        if (squareShareFeedBean == null || !((i = squareShareFeedBean.visibleType) == 0 || i == 2)) {
            if (this.scrollOut) {
                return;
            }
            setVisibility(8);
            return;
        }
        LogUtil.d(TAG, "updateStatus：" + squareShareFeedBean.publicStatus);
        this.shareTarget = squareShareFeedBean.visibleType;
        int i2 = squareShareFeedBean.publicStatus;
        if (i2 == -1) {
            setVisibility(0);
            this.shadowView.setVisibility(0);
            this.statusView.setText(R$string.square_post_bar_fail);
            this.percentView.setVisibility(8);
            this.retryBtnView.setVisibility(0);
            this.closeView.setVisibility(0);
            this.progressBar.setProgress(0);
            if (!TextUtils.isEmpty(squareShareFeedBean.errorMsg)) {
                sy5.f(com.zenmen.palmchat.c.b(), squareShareFeedBean.errorMsg, 1).g();
            }
            zn6.j("postbar_fail", "view", new d());
            return;
        }
        if (i2 == 1) {
            if (getVisibility() != 0) {
                zn6.j("postbar", "view", new c());
            }
            setVisibility(0);
            setTranslationY(0.0f);
            if (!TextUtils.isEmpty(squareShareFeedBean.publicProgressImage)) {
                gr2.j().h(k86.p(squareShareFeedBean.publicProgressImage), this.picView, hr2.g());
            }
            this.shadowView.setVisibility(8);
            this.statusView.setText(R$string.square_post_bar_uploading);
            this.percentView.setVisibility(0);
            this.percentView.setText(squareShareFeedBean.percent + "%");
            this.retryBtnView.setVisibility(8);
            this.closeView.setVisibility(8);
            this.progressBar.setProgress(squareShareFeedBean.percent);
            return;
        }
        if (i2 == 2) {
            this.percentView.setText("100%");
            this.progressBar.setProgress(100);
            sy5.e(com.zenmen.palmchat.c.b(), R$string.square_post_bar_success, 1).g();
            f fVar = this.onPostListener;
            if (fVar != null) {
                fVar.a(this.shareTarget);
            }
            scrollOut();
            return;
        }
        if (i2 != 4) {
            if (i2 != 5) {
                return;
            }
            mj5.r().G(getContext());
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<SquareContactBean> it = squareShareFeedBean.contactLists.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().number);
            }
            k86.W(getContext(), squareShareFeedBean.shareSmsBean.msgContent, arrayList);
        }
    }

    public PostBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PostBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.shareTarget = 0;
        init(context, attributeSet);
    }

    @RequiresApi(api = 21)
    public PostBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.shareTarget = 0;
        init(context, attributeSet);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends AnimatorListenerAdapter {
        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PostBar.this.setVisibility(8);
            PostBar.this.scrollOut = false;
            PostBar.this.clearAnimation();
            PostBar.this.setTranslationY(0.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
    }
}
