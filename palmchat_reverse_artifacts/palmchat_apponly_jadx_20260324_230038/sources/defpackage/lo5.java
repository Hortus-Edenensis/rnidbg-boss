package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.paidservices.superexpose.bean.StyleConfig;
import com.zenmen.palmchat.paidservices.superexpose.bean.SuperExposeInfo;
import com.zenmen.palmchat.paidservices.superexpose.bean.Template;
import com.zenmen.palmchat.paidservices.superexpose.view.SuperExposeLoopAllLayout;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class lo5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f19046a;
    public RelativeLayout b = null;
    public ImageView c = null;
    public SuperExposeLoopAllLayout d = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yn5 f19047a;

        public a(yn5 yn5Var) {
            this.f19047a = yn5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtil.d("SuperExpose", "onClick SuperExposeTypeBLayout mAllLayout ");
            this.f19047a.a(1);
        }
    }

    public lo5(Context context, yn5 yn5Var) {
        this.f19046a = context.getApplicationContext();
        b(yn5Var);
    }

    public RelativeLayout a() {
        return this.b;
    }

    public final void b(yn5 yn5Var) {
        b05.d("SuperExposeTypeDLayout");
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f19046a).inflate(R.layout.super_expose_d_type_layout, (ViewGroup) null);
        this.b = relativeLayout;
        this.c = (ImageView) relativeLayout.findViewById(R.id.bg_img);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.b.findViewById(R.id.loop_layout);
        SuperExposeLoopAllLayout superExposeLoopAllLayout = new SuperExposeLoopAllLayout(this.f19046a, 11.0f, false, null);
        this.d = superExposeLoopAllLayout;
        relativeLayout2.addView(superExposeLoopAllLayout, new ViewGroup.LayoutParams(-1, -2));
        this.d.setTextStillTime(5000L);
        this.d.setAnimTime(300L);
        this.d.startAutoScroll();
        this.b.setOnClickListener(new a(yn5Var));
    }

    public void c(SuperExposeInfo superExposeInfo) {
        StyleConfig styleConfig;
        SuperExposeLoopAllLayout superExposeLoopAllLayout;
        if (superExposeInfo == null || (styleConfig = superExposeInfo.styleConfig) == null) {
            return;
        }
        ArrayList<Template> arrayList = styleConfig.template;
        if (arrayList != null && (superExposeLoopAllLayout = this.d) != null) {
            superExposeLoopAllLayout.setDataList(arrayList);
        }
        if (this.c == null || TextUtils.isEmpty(styleConfig.bgImg)) {
            return;
        }
        hc2.a(this.f19046a).load(styleConfig.bgImg).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.super_expose_b_bg).error(R.drawable.super_expose_b_bg).transition(DrawableTransitionOptions.with(new DrawableCrossFadeFactory.Builder(300).setCrossFadeEnabled(true).build())).into(this.c);
    }
}
