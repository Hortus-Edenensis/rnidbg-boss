package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.bumptech.glide.Glide;
import com.wifi.ad.core.data.NestAdData;
import com.zenmen.palmchat.ad.nest.nativead.ui.square.NestSquareAdPager;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class mv3 extends jv3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Float[][] f19373a;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends PagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f19374a;
        public final /* synthetic */ NestAdData b;

        public a(Context context, NestAdData nestAdData) {
            this.f19374a = context;
            this.b = nestAdData;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (isViewFromObject(childAt, obj)) {
                    viewGroup.removeView(childAt);
                    return;
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View viewInflate = LayoutInflater.from(this.f19374a).inflate(R$layout.nest_square_generic_list_item_ad_group_item, (ViewGroup) null, false);
            List<String> imageList = this.b.getImageList();
            String str = imageList.get(i % imageList.size());
            gr2 gr2VarJ = gr2.j();
            if (str == null) {
                str = "";
            }
            gr2VarJ.g(str, (ImageView) viewInflate.findViewById(R$id.ad_img));
            viewGroup.addView(viewInflate);
            return viewInflate;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    static {
        Float fValueOf = Float.valueOf(208.0f);
        Float[] fArr = {fValueOf, Float.valueOf(117.0f)};
        Float fValueOf2 = Float.valueOf(138.0f);
        f19373a = new Float[][]{fArr, new Float[]{fValueOf, fValueOf2}, new Float[]{Float.valueOf(78.0f), fValueOf2}};
    }

    public static void m(ViewGroup viewGroup, iv3 iv3Var, Context context) {
        NestAdData nestAdDataA;
        try {
            LogUtil.d("", "NativeType NestNativeUiFind bindAdView adViewGroup " + viewGroup);
            if (viewGroup == null || iv3Var == null || context == null || (nestAdDataA = iv3Var.a()) == null) {
                return;
            }
            bv3 bv3VarB = iv3Var.b();
            if (bv3VarB instanceof ev3) {
                ev3 ev3Var = (ev3) bv3VarB;
                boolean zE = iv3Var.e();
                LogUtil.d("", "NativeType NestNativeUiFind bindAdView isGroupMode " + zE);
                if (zE) {
                    o(viewGroup, nestAdDataA, context, ev3Var, iv3Var);
                } else {
                    n(viewGroup, nestAdDataA, context, ev3Var, iv3Var);
                }
                LogUtil.d("", "NativeType NestNativeUiFind bindAdView end ");
            }
        } catch (Exception e) {
            LogUtil.d("", "NativeType NestNativeUiFind bindAdView Exception " + e.toString());
        }
    }

    public static void n(ViewGroup viewGroup, NestAdData nestAdData, Context context, ev3 ev3Var, iv3 iv3Var) {
        LogUtil.d("", "NativeType NestNativeUiFind bindBigPic start ");
        sv3 sv3VarC = jv3.c(viewGroup, iv3Var, f19373a, context);
        jv3.f(viewGroup.findViewById(R$id.ad_discount_info_layout), (TextView) viewGroup.findViewById(R$id.ad_discount_info_textview), nestAdData);
        jv3.i(sv3VarC, nestAdData);
        if (nestAdData.getZhiboAd().booleanValue()) {
            View viewFindViewById = viewGroup.findViewById(R$id.ad_main);
            if (viewFindViewById != null) {
                ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = me1.b(context, 170);
                viewFindViewById.setLayoutParams(layoutParams);
            }
            View viewFindViewById2 = viewGroup.findViewById(R$id.zhibo_layout);
            View viewFindViewById3 = viewGroup.findViewById(R$id.ad_down_yaoyiyao_layout);
            if (viewFindViewById2 != null && viewFindViewById3 != null) {
                viewFindViewById2.setVisibility(0);
                viewFindViewById3.setVisibility(8);
            }
            try {
                Glide.with(viewGroup.getContext()).asGif().load2(Integer.valueOf(R$drawable.zhibo_gif_img_bg)).into((ImageView) viewGroup.findViewById(R$id.zhibo_gif_img));
            } catch (Exception unused) {
            }
        }
        LogUtil.d("", "NativeType NestNativeUiFind bindBigPic end ");
    }

    public static void o(ViewGroup viewGroup, NestAdData nestAdData, Context context, ev3 ev3Var, iv3 iv3Var) {
        LogUtil.d("", "NativeType NestNativeUiFind bindMultiPic start ");
        sv3 sv3VarC = jv3.c(viewGroup, iv3Var, f19373a, context);
        NestSquareAdPager nestSquareAdPager = (NestSquareAdPager) viewGroup.findViewById(R$id.ad_pager);
        sv3VarC.Q(nestSquareAdPager);
        nestSquareAdPager.setAdapter(new a(context, nestAdData));
        nestSquareAdPager.setCurrentItem(0);
        nestSquareAdPager.beginAutoScroll();
        jv3.i(sv3VarC, nestAdData);
        LogUtil.d("", "NativeType NestNativeUiFind bindMultiPic end ");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static View p(iv3 iv3Var, Context context) {
        NestAdData nestAdDataA;
        boolean z;
        if (iv3Var == null || context == null || (nestAdDataA = iv3Var.a()) == null) {
            return null;
        }
        List<String> imageList = nestAdDataA.getImageList();
        if (imageList != null) {
            z = imageList.size() > 1;
        }
        View viewInflate = z ? LayoutInflater.from(context).inflate(R$layout.nest_find_nearby_ad_list_item_multipic, (ViewGroup) null, false) : LayoutInflater.from(context).inflate(R$layout.nest_find_nearby_ad_list_item_bigpic, (ViewGroup) null, false);
        iv3Var.h(z);
        LogUtil.d("", "NativeType NestNativeUiFind createAdView adView " + viewInflate + " isGroupMode " + z);
        return viewInflate;
    }
}
