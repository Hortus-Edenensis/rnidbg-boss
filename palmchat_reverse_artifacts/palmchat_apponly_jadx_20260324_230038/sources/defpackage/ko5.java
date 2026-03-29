package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.paidservices.superexpose.bean.StyleConfig;
import com.zenmen.palmchat.paidservices.superexpose.bean.SuperExposeInfo;
import com.zenmen.palmchat.paidservices.superexpose.bean.Template;
import com.zenmen.palmchat.paidservices.superexpose.view.SuperExposeLoopAllLayout;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ko5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f18791a;
    public RelativeLayout b = null;
    public ImageView c = null;
    public TextView d = null;
    public TextView e = null;
    public SuperExposeLoopAllLayout f = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yn5 f18792a;

        public a(yn5 yn5Var) {
            this.f18792a = yn5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtil.d("SuperExpose", "onClick SuperExposeTypeBLayout mAllLayout ");
            this.f18792a.a(1);
        }
    }

    public ko5(Context context, yn5 yn5Var) {
        this.f18791a = context.getApplicationContext();
        b(yn5Var);
    }

    public RelativeLayout a() {
        return this.b;
    }

    public final void b(yn5 yn5Var) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f18791a).inflate(R.layout.super_expose_b_type_layout, (ViewGroup) null);
        this.b = relativeLayout;
        this.c = (ImageView) relativeLayout.findViewById(R.id.bg_img);
        this.d = (TextView) this.b.findViewById(R.id.title_text);
        this.e = (TextView) this.b.findViewById(R.id.button_click);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.b.findViewById(R.id.loop_layout);
        SuperExposeLoopAllLayout superExposeLoopAllLayout = new SuperExposeLoopAllLayout(this.f18791a, 11.0f, false, null);
        this.f = superExposeLoopAllLayout;
        relativeLayout2.addView(superExposeLoopAllLayout, new ViewGroup.LayoutParams(-1, -2));
        this.f.setTextStillTime(5000L);
        this.f.setAnimTime(300L);
        this.f.startAutoScroll();
        this.b.setOnClickListener(new a(yn5Var));
    }

    public void c(SuperExposeInfo superExposeInfo) {
        StyleConfig styleConfig;
        SuperExposeLoopAllLayout superExposeLoopAllLayout;
        if (superExposeInfo == null || (styleConfig = superExposeInfo.styleConfig) == null) {
            return;
        }
        ArrayList<Template> arrayList = styleConfig.template;
        if (arrayList != null && (superExposeLoopAllLayout = this.f) != null) {
            superExposeLoopAllLayout.setDataList(arrayList);
        }
        if (this.d != null) {
            if (!TextUtils.isEmpty(styleConfig.title)) {
                this.d.setText(styleConfig.title);
            }
            if (!TextUtils.isEmpty(styleConfig.titleTextColor)) {
                try {
                    this.d.setTextColor(Color.parseColor(styleConfig.titleTextColor));
                } catch (Exception unused) {
                }
            }
        }
        if (this.e != null) {
            if (!TextUtils.isEmpty(styleConfig.btnText)) {
                this.e.setText(styleConfig.btnText);
            }
            if (!TextUtils.isEmpty(styleConfig.btnTextColor)) {
                try {
                    this.e.setTextColor(Color.parseColor(styleConfig.btnTextColor));
                } catch (Exception unused2) {
                }
            }
            if (!TextUtils.isEmpty(styleConfig.btnBgColor)) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                try {
                    gradientDrawable.setCornerRadius(a46.b(this.f18791a, 8.0f));
                    gradientDrawable.setColor(Color.parseColor(styleConfig.btnBgColor));
                    this.e.setBackground(gradientDrawable);
                } catch (Exception unused3) {
                }
            }
        }
        if (this.c == null || TextUtils.isEmpty(styleConfig.bgImg)) {
            return;
        }
        hc2.a(this.f18791a).load(styleConfig.bgImg).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.super_expose_b_bg).error(R.drawable.super_expose_b_bg).transition(DrawableTransitionOptions.withCrossFade()).into(this.c);
    }

    public void d() {
        SuperExposeLoopAllLayout superExposeLoopAllLayout = this.f;
        if (superExposeLoopAllLayout != null) {
            superExposeLoopAllLayout.startAutoScroll();
        }
    }

    public void e() {
        SuperExposeLoopAllLayout superExposeLoopAllLayout = this.f;
        if (superExposeLoopAllLayout != null) {
            superExposeLoopAllLayout.stopAutoScroll();
        }
    }
}
