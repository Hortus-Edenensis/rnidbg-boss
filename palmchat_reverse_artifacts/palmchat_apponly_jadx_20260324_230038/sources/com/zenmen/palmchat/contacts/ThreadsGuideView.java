package com.zenmen.palmchat.contacts;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.zenmen.palmchat.R;
import defpackage.k36;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ThreadsGuideView extends RelativeLayout {
    private ImageView arrowView;
    private ImageView backgroudView;
    private ImageView contactMenuView;
    private d listener;
    private View rootView;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadsGuideView.c(ThreadsGuideView.this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadsGuideView.c(ThreadsGuideView.this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f13470a;

        public c(View view) {
            this.f13470a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ThreadsGuideView.this.contactMenuView.getLayoutParams();
            int[] iArr = {100, 100};
            this.f13470a.getLocationOnScreen(iArr);
            marginLayoutParams.leftMargin = iArr[0] + k36.b(5.0f);
            marginLayoutParams.topMargin = iArr[1] + k36.b(5.0f);
            ThreadsGuideView.this.contactMenuView.setLayoutParams(marginLayoutParams);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) ThreadsGuideView.this.arrowView.getLayoutParams();
            marginLayoutParams2.leftMargin = (iArr[0] - marginLayoutParams2.width) + k36.b(5.0f);
            marginLayoutParams2.topMargin = marginLayoutParams.topMargin + ThreadsGuideView.this.contactMenuView.getHeight() + k36.b(12.0f);
            ThreadsGuideView.this.arrowView.setLayoutParams(marginLayoutParams2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
    }

    public ThreadsGuideView(Context context) {
        this(context, null);
    }

    public static /* bridge */ /* synthetic */ d c(ThreadsGuideView threadsGuideView) {
        threadsGuideView.getClass();
        return null;
    }

    private void initViews(Context context) {
        View viewInflate = View.inflate(context, R.layout.threads_guide_view, this);
        this.rootView = viewInflate;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.backgroud);
        this.backgroudView = imageView;
        imageView.setOnClickListener(new a());
        ImageView imageView2 = (ImageView) this.rootView.findViewById(R.id.contact_menu);
        this.contactMenuView = imageView2;
        imageView2.setOnClickListener(new b());
        this.arrowView = (ImageView) this.rootView.findViewById(R.id.arrow);
    }

    public void adjustPosition(Context context, View view) {
        if (view != null) {
            view.post(new c(view));
        }
    }

    public ThreadsGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadsGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initViews(context);
    }

    public void setListener(d dVar) {
    }
}
