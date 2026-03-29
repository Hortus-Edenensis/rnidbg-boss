package defpackage;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.maintab.dialog.PopCardItem;
import com.zenmen.palmchat.utils.dialogmanager.DialogScene;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.LXPortraitView;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class gc3 implements Observer, View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MainTabsActivity f17700a;
    public FrameLayout b;
    public PopCardItem c;

    /* JADX INFO: compiled from: SearchBox */
    public class c extends SimpleTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f17703a;

        public c(View view) {
            this.f17703a = view;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
            if (bitmap != null) {
                this.f17703a.setBackground(new BitmapDrawable(bitmap));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends SimpleTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f17704a;

        public d(View view) {
            this.f17704a = view;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
            if (bitmap != null) {
                this.f17704a.setBackground(new BitmapDrawable(bitmap));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends SimpleTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f17705a;

        public e(TextView textView) {
            this.f17705a = textView;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
            if (bitmap != null) {
                this.f17705a.setBackground(new BitmapDrawable(bitmap));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends SimpleTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f17706a;

        public f(View view) {
            this.f17706a = view;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
            if (bitmap != null) {
                this.f17706a.setBackground(new BitmapDrawable(bitmap));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends SimpleTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f17707a;

        public g(TextView textView) {
            this.f17707a = textView;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
            if (bitmap != null) {
                this.f17707a.setBackground(new BitmapDrawable(bitmap));
            }
        }
    }

    public final View b(PopCardItem popCardItem) {
        int i = popCardItem.style;
        View viewInflate = null;
        if (i == 1) {
            if (popCardItem.subtype == 1) {
                viewInflate = LayoutInflater.from(this.f17700a).inflate(R.layout.maintab_pop_card_view_voice, (ViewGroup) null);
                View viewFindViewById = viewInflate.findViewById(R.id.contentLayout);
                viewFindViewById.setOnClickListener(this);
                hc2.a(com.zenmen.palmchat.c.b()).asBitmap().load(popCardItem.backImage).into(new c(viewFindViewById));
                TextView textView = (TextView) viewInflate.findViewById(R.id.desTitle);
                textView.setText(popCardItem.title);
                k(textView, popCardItem.titleColor);
                try {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(0);
                    gradientDrawable.setCornerRadius(me1.b(this.f17700a, 8));
                    gradientDrawable.setColor(Color.parseColor(popCardItem.backgroup));
                    textView.setBackground(gradientDrawable);
                } catch (Exception unused) {
                }
                LXPortraitView lXPortraitView = (LXPortraitView) viewInflate.findViewById(R.id.headIcon);
                lXPortraitView.setPortraitBorder(-1, me1.b(this.f17700a, 1));
                lXPortraitView.setOnClickListener(this);
                lXPortraitView.setAvatarView(popCardItem.icon, 0, R.drawable.default_portrait_new, null, null, popCardItem.iconMask);
                if (d(popCardItem.effectColor) != -1) {
                    lXPortraitView.setWaveColor(Color.parseColor(popCardItem.effectColor));
                }
                if (popCardItem.dynamicEffect) {
                    lXPortraitView.start();
                }
                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.gender);
                if (popCardItem.sex >= 0) {
                    imageView.setVisibility(0);
                    if (popCardItem.sex == 1) {
                        imageView.setBackgroundResource(R.drawable.ic_main_pop_gender_female_bg);
                        imageView.setImageResource(R.drawable.ic_main_pop_gender_female);
                    } else {
                        imageView.setBackgroundResource(R.drawable.ic_main_pop_gender_male_bg);
                        imageView.setImageResource(R.drawable.ic_main_pop_gender_male);
                    }
                } else {
                    imageView.setVisibility(8);
                }
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.subTitle);
                textView2.setText(popCardItem.subTitle);
                k(textView2, popCardItem.subTitleColor);
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.text);
                textView3.setText(popCardItem.text);
                k(textView3, popCardItem.textColor);
                ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.ok);
                hc2.a(com.zenmen.palmchat.c.b()).load(popCardItem.answerBtnImage).into(imageView2);
                imageView2.setOnClickListener(this);
                ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.cancel);
                hc2.a(com.zenmen.palmchat.c.b()).load(popCardItem.refuseBtnImage).into(imageView3);
                imageView3.setOnClickListener(this);
            } else {
                viewInflate = LayoutInflater.from(this.f17700a).inflate(R.layout.maintab_pop_card_view, (ViewGroup) null);
                View viewFindViewById2 = viewInflate.findViewById(R.id.contentLayout);
                viewFindViewById2.setOnClickListener(this);
                hc2.a(com.zenmen.palmchat.c.b()).asBitmap().load(popCardItem.backImage).into(new d(viewFindViewById2));
                TextView textView4 = (TextView) viewInflate.findViewById(R.id.desTitle);
                textView4.setText(popCardItem.title);
                k(textView4, popCardItem.titleColor);
                try {
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    gradientDrawable2.setShape(0);
                    gradientDrawable2.setCornerRadius(me1.b(this.f17700a, 8));
                    gradientDrawable2.setColor(Color.parseColor(popCardItem.backgroup));
                    textView4.setBackground(gradientDrawable2);
                } catch (Exception unused2) {
                }
                LXPortraitView lXPortraitView2 = (LXPortraitView) viewInflate.findViewById(R.id.headIcon);
                lXPortraitView2.setPortraitBorder(-1, me1.b(this.f17700a, 1));
                lXPortraitView2.setOnClickListener(this);
                lXPortraitView2.setAvatarView(popCardItem.icon, 0, R.drawable.default_portrait_new, null, null, popCardItem.iconMask);
                if (d(popCardItem.effectColor) != -1) {
                    lXPortraitView2.setWaveColor(Color.parseColor(popCardItem.effectColor));
                }
                if (popCardItem.dynamicEffect) {
                    lXPortraitView2.start();
                }
                ((TextView) viewInflate.findViewById(R.id.title)).setText(popCardItem.body);
                TextView textView5 = (TextView) viewInflate.findViewById(R.id.genderAge);
                ImageView imageView4 = (ImageView) viewInflate.findViewById(R.id.gender);
                int i2 = popCardItem.sex;
                if (i2 >= 0 && popCardItem.age > 0) {
                    imageView4.setVisibility(8);
                    textView5.setText(popCardItem.age + "");
                    if (popCardItem.sex == 1) {
                        textView5.setBackgroundResource(R.drawable.ic_main_pop_gender_female_bg);
                        textView5.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_main_pop_gender_female, 0, 0, 0);
                    } else {
                        textView5.setBackgroundResource(R.drawable.ic_main_pop_gender_male_bg);
                        textView5.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_main_pop_gender_male, 0, 0, 0);
                    }
                } else if (i2 >= 0) {
                    textView5.setVisibility(8);
                    imageView4.setVisibility(0);
                    if (popCardItem.sex == 1) {
                        imageView4.setBackgroundResource(R.drawable.ic_main_pop_gender_female_bg);
                        imageView4.setImageResource(R.drawable.ic_main_pop_gender_female);
                    } else {
                        imageView4.setBackgroundResource(R.drawable.ic_main_pop_gender_male_bg);
                        imageView4.setImageResource(R.drawable.ic_main_pop_gender_male);
                    }
                } else {
                    textView5.setVisibility(8);
                    imageView4.setVisibility(8);
                }
                TextView textView6 = (TextView) viewInflate.findViewById(R.id.btn);
                textView6.setOnClickListener(this);
                textView6.setText(popCardItem.btnText);
                k(textView6, popCardItem.btnColor);
                hc2.a(com.zenmen.palmchat.c.b()).asBitmap().load(popCardItem.btnImage).into(new e(textView6));
                viewInflate.findViewById(R.id.close).setOnClickListener(this);
            }
        } else if (i == 2) {
            viewInflate = LayoutInflater.from(this.f17700a).inflate(R.layout.maintab_pop_card_view2, (ViewGroup) null);
            View viewFindViewById3 = viewInflate.findViewById(R.id.contentLayout);
            viewFindViewById3.setOnClickListener(this);
            hc2.a(com.zenmen.palmchat.c.b()).asBitmap().load(popCardItem.backImage).into(new f(viewFindViewById3));
            TextView textView7 = (TextView) viewInflate.findViewById(R.id.title);
            textView7.setText(popCardItem.title);
            k(textView7, popCardItem.titleColor);
            TextView textView8 = (TextView) viewInflate.findViewById(R.id.subTitle);
            textView8.setText(popCardItem.subTitle);
            k(textView8, popCardItem.subTitleColor);
            TextView textView9 = (TextView) viewInflate.findViewById(R.id.btn);
            textView9.setOnClickListener(this);
            textView9.setText(popCardItem.btnText);
            k(textView9, popCardItem.btnColor);
            hc2.a(com.zenmen.palmchat.c.b()).asBitmap().load(popCardItem.btnImage).into(new g(textView9));
            ImageView imageView5 = (ImageView) viewInflate.findViewById(R.id.contentImg);
            if (!TextUtils.isEmpty(popCardItem.icon)) {
                hc2.a(com.zenmen.palmchat.c.b()).asBitmap().load(popCardItem.icon).into(imageView5);
            }
            viewInflate.findViewById(R.id.close).setOnClickListener(this);
        }
        return viewInflate;
    }

    public final PopCardItem c(boolean z) {
        if (this.b.getChildCount() > 0) {
            if (z) {
                j(this.b.getChildAt(0));
            } else {
                this.b.removeAllViews();
            }
        }
        PopCardItem popCardItem = this.c;
        this.c = null;
        return popCardItem;
    }

    public final int d(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Color.parseColor(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public final void e(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -2.0f, 1, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        view.startAnimation(translateAnimation);
    }

    public void f(MainTabsActivity mainTabsActivity) {
        this.f17700a = mainTabsActivity;
        this.b = (FrameLayout) mainTabsActivity.findViewById(R.id.popupLayout);
        fc3.l().addObserver(this);
    }

    public void g() {
        fc3.l().deleteObserver(this);
    }

    public void h() {
        l(null);
    }

    public void i() {
        l(null);
    }

    public final void j(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -2.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        translateAnimation.setAnimationListener(new b());
        view.startAnimation(translateAnimation);
    }

    public final void k(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            textView.setTextColor(Color.parseColor(str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void l(Object obj) {
        MainTabsActivity mainTabsActivity;
        int i;
        MainTabsActivity mainTabsActivity2 = this.f17700a;
        if (mainTabsActivity2 == null || this.b == null || mainTabsActivity2.isPaused()) {
            return;
        }
        PopCardItem popCardItemN = fc3.l().n();
        LogUtil.i("MainTabTopViewManager", "updateView getPopCardItem=" + az2.c(popCardItemN) + " currentitem =" + this.c + "    arg=" + obj);
        boolean z = false;
        if (popCardItemN != null) {
            DialogScene dialogScene = "2".equals(popCardItemN.scene) ? DialogScene.MATCH_AUDIO : "3".equals(popCardItemN.scene) ? DialogScene.MATCH_VIDEO : null;
            boolean zA = dialogScene != null ? da3.b().a(dialogScene) : true;
            if (this.c != popCardItemN && zA) {
                this.b.removeAllViews();
                View viewB = b(popCardItemN);
                if (viewB != null) {
                    if (popCardItemN.shakeSwitch == 1) {
                        try {
                            ((Vibrator) AppContext.getContext().getSystemService("vibrator")).vibrate(new long[]{0, 50, 200, 50}, -1);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    HashMap map = new HashMap();
                    map.put("type", popCardItemN.style + "");
                    map.put("fuid", popCardItemN.fuid);
                    map.put("scene", popCardItemN.scene);
                    map.put("subtype", String.valueOf(popCardItemN.subtype));
                    zn6.i("tab_chatpop", map);
                    if (popCardItemN.popupSeq > 0) {
                        zw4.e(new a(popCardItemN));
                    }
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    if (popCardItemN.style == 1 && popCardItemN.subtype == 1) {
                        z = true;
                    }
                    layoutParams.topMargin = a46.n(this.f17700a) + me1.b(this.f17700a, z ? -10 : 8);
                    if (z) {
                        mainTabsActivity = this.f17700a;
                        i = 2;
                    } else {
                        mainTabsActivity = this.f17700a;
                        i = 16;
                    }
                    int iB = me1.b(mainTabsActivity, i);
                    layoutParams.leftMargin = iB;
                    layoutParams.rightMargin = iB;
                    this.b.addView(viewB, layoutParams);
                    e(viewB);
                }
            }
        } else if (this.c == null || obj == null) {
            this.b.removeAllViews();
        } else {
            LogUtil.i("MainTabTopViewManager", "getChildCount=" + this.b.getChildCount());
            if (this.b.getChildCount() > 0) {
                j(this.b.getChildAt(0));
            }
        }
        this.c = popCardItemN;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0044  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        String str;
        PopCardItem popCardItem = this.c;
        LogUtil.i("MainTabTopViewManager", "onClick " + az2.c(popCardItem));
        int i = 0;
        if (popCardItem == null) {
            c(false);
            return;
        }
        HashMap map = new HashMap();
        if (this.c != null) {
            map.put("fuid", popCardItem.fuid);
            map.put("scene", popCardItem.scene);
            str = this.c.style == 2 ? "tab_chatpop_bannerclick" : "tab_chatpop_singleclick";
        }
        if (view.getId() == R.id.close || view.getId() == R.id.cancel) {
            c(true);
            fc3.l().p(this.f17700a);
            i = 3;
        } else if (view.getId() == R.id.btn || view.getId() == R.id.ok) {
            if (!TextUtils.isEmpty(popCardItem.btnUrl)) {
                c(false);
                fc3.l().p(this.f17700a);
                String str2 = popCardItem.btnUrl;
                if (fc3.i) {
                    str2 = "zenxin://activity?page=a00010&url=https%3A%2F%2Fshort1.lx-qa.com%2Fmapps%2Fchat%2F%23%2F&fullwindow=1&cacheKey=nochat";
                }
                ve.t(this.f17700a, str2, false, az2.c(popCardItem.ext));
            }
            i = 1;
        } else if (view.getId() == R.id.headIcon) {
            if (!TextUtils.isEmpty(popCardItem.iconUrl)) {
                c(false);
                fc3.l().p(this.f17700a);
                ve.t(this.f17700a, popCardItem.iconUrl, false, az2.c(popCardItem.ext));
            }
            i = 4;
        } else if (view.getId() == R.id.contentLayout) {
            if (!TextUtils.isEmpty(popCardItem.regionUrl)) {
                c(false);
                fc3.l().p(this.f17700a);
                ve.t(this.f17700a, popCardItem.regionUrl, false, az2.c(popCardItem.ext));
            }
            i = 2;
        }
        map.put("clicktype", i + "");
        map.put("subtype", String.valueOf(popCardItem.subtype));
        zn6.i(str, map);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (observable instanceof fc3) {
            l(obj);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            gc3.this.b.removeAllViews();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2<LXBaseNetBean<Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PopCardItem f17701a;

        public a(PopCardItem popCardItem) {
            this.f17701a = popCardItem;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("popupSeq", Integer.valueOf(this.f17701a.popupSeq));
            return sw4.b(1, nl0.z + "/noChat.push.popup.show.v1", map);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<Object> lXBaseNetBean, Exception exc) {
        }
    }
}
