package com.zenmen.square.mvp.holder;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import com.afollestad.materialdialogs.MaterialDialog;
import com.amap.api.services.district.DistrictSearchQuery;
import com.bumptech.glide.Glide;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kuaishou.weapon.p0.g;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.palmchat.contacts.bean.Amulet;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.LXPortraitView;
import com.zenmen.square.R$anim;
import com.zenmen.square.R$color;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.databinding.FeedLayoutItemViewBinding;
import com.zenmen.square.dynamiclife.DynamicSuperExposeV1Config;
import com.zenmen.square.fragment.FeedsFragment;
import com.zenmen.square.mvp.SquareDataBindingComponent;
import com.zenmen.square.mvp.model.bean.Media;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.view.widget.FeedItemMultiPicView;
import com.zenmen.square.mvp.view.widget.FeedItemVenusView;
import com.zenmen.square.ui.widget.ExpandableTextView;
import com.zenmen.square.ui.widget.SquareItemVideoView;
import defpackage.a46;
import defpackage.bj5;
import defpackage.cy5;
import defpackage.d33;
import defpackage.dn0;
import defpackage.fg6;
import defpackage.gi5;
import defpackage.gr2;
import defpackage.je1;
import defpackage.k86;
import defpackage.kj1;
import defpackage.l50;
import defpackage.me1;
import defpackage.q05;
import defpackage.qj5;
import defpackage.tg4;
import defpackage.v4;
import defpackage.vi5;
import defpackage.wl1;
import defpackage.zn6;
import defpackage.zt1;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class FeedViewHolder extends BaseViewHolder<SquareFeed, FeedLayoutItemViewBinding, zt1> implements View.OnClickListener {
    public static je1 p = null;
    public static int q = 0;
    public static int r = 0;
    public static int s = 0;
    public static long t = 3000;
    public static long u = 3000;
    public int f;
    public int g;
    public TranslateAnimation h;
    public int i;
    public String j;
    public int[] k;
    public Runnable l;
    public Runnable m;
    public int n;
    public int o;

    /* JADX INFO: compiled from: SearchBox */
    public class FeedItemBindingComponent extends SquareDataBindingComponent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FeedViewHolder f16422a;

        public FeedItemBindingComponent(FeedViewHolder feedViewHolder) {
            this.f16422a = feedViewHolder;
        }

        @Override // com.zenmen.square.mvp.SquareDataBindingComponent, androidx.databinding.DataBindingComponent
        public FeedViewHolder getFeedViewHolder() {
            return this.f16422a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f16423a;
        public final /* synthetic */ SquareFeed b;

        /* JADX INFO: renamed from: com.zenmen.square.mvp.holder.FeedViewHolder$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class ViewOnClickListenerC1157a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MaterialDialog f16424a;

            /* JADX INFO: renamed from: com.zenmen.square.mvp.holder.FeedViewHolder$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1158a extends HashMap<String, Object> {
                public C1158a() {
                    put("showTab", Integer.valueOf(FeedViewHolder.this.g));
                    put("showPosition", Integer.valueOf(a.this.f16423a));
                    put("impr_id", a.this.b.imprId);
                    put("button", 1);
                }
            }

            public ViewOnClickListenerC1157a(MaterialDialog materialDialog) {
                this.f16424a = materialDialog;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q05.p()) {
                    return;
                }
                q05.a("postboost_postlist_label_pop", 2, new C1158a());
                bj5.b().a().K(FeedViewHolder.this.itemView.getContext(), MediaPlayer.MEDIA_PLAYER_OPTION_MAX_AV_POS_GAP, null);
                this.f16424a.dismiss();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MaterialDialog f16426a;

            /* JADX INFO: renamed from: com.zenmen.square.mvp.holder.FeedViewHolder$a$b$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1159a extends HashMap<String, Object> {
                public C1159a() {
                    put("showTab", Integer.valueOf(FeedViewHolder.this.g));
                    put("showPosition", Integer.valueOf(a.this.f16423a));
                    put("impr_id", a.this.b.imprId);
                    put("button", 2);
                }
            }

            public b(MaterialDialog materialDialog) {
                this.f16426a = materialDialog;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q05.p()) {
                    return;
                }
                q05.a("postboost_postlist_label_pop", 2, new C1159a());
                this.f16426a.dismiss();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c extends HashMap<String, Object> {
            public c() {
                put("showTab", Integer.valueOf(FeedViewHolder.this.g));
                put("showPosition", Integer.valueOf(a.this.f16423a));
                put("impr_id", a.this.b.imprId);
            }
        }

        public a(int i, SquareFeed squareFeed) {
            this.f16423a = i;
            this.b = squareFeed;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (kj1.b().c().booleanValue()) {
                MaterialDialog materialDialogD = q05.d(FeedViewHolder.this.itemView.getContext(), R$layout.dialog_dynamic_super_expose_showing);
                View viewFindViewById = materialDialogD.j().findViewById(R$id.close_layout);
                materialDialogD.j().findViewById(R$id.btn_submit).setOnClickListener(new ViewOnClickListenerC1157a(materialDialogD));
                viewFindViewById.setOnClickListener(new b(materialDialogD));
                q05.a("postboost_postlist_label_pop", 1, new c());
                materialDialogD.show();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements d33.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareFeed f16429a;

        public b(SquareFeed squareFeed) {
            this.f16429a = squareFeed;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d33.a
        public void a(String str) {
            qj5.Z(this.f16429a);
            bj5.b().a().c((FrameworkBaseActivity) ((FeedsFragment) ((zt1) FeedViewHolder.this.e).p()).getActivity(), str, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((FeedLayoutItemViewBinding) FeedViewHolder.this.d).A.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((FeedLayoutItemViewBinding) FeedViewHolder.this.d).C.setVisibility(8);
        }
    }

    public FeedViewHolder(View view, int i) {
        super(view);
        this.i = 0;
        this.k = new int[2];
        this.l = new c();
        this.m = new d();
        this.f = i;
        if (i == 1) {
            this.g = 1;
        } else if (i == 73) {
            this.g = 2;
        } else if (i == 74) {
            this.g = 3;
        }
    }

    public abstract void A(FeedItemMultiPicView feedItemMultiPicView, SquareFeed squareFeed);

    public abstract void B(FeedItemVenusView feedItemVenusView, SquareFeed squareFeed);

    @BindingAdapter({"contentVideoUrl"})
    public void C(SquareItemVideoView squareItemVideoView, SquareFeed squareFeed) {
        D(squareItemVideoView, squareFeed);
    }

    public abstract void D(SquareItemVideoView squareItemVideoView, SquareFeed squareFeed);

    public void E(TextView textView, long j) {
        textView.setText(cy5.f(j));
    }

    @BindingAdapter({"setFeedDesc"})
    public void F(ExpandableTextView expandableTextView, SquareFeed squareFeed) {
        List<Media> list = squareFeed.mediaList;
        Media media = (list == null || list.size() == 0 || squareFeed.mediaList.get(0) == null) ? null : squareFeed.mediaList.get(0);
        String str = !TextUtils.isEmpty(squareFeed.content) ? squareFeed.content : "";
        if (media != null) {
            ((FeedLayoutItemViewBinding) this.d).z.setVisibility(0);
        } else {
            ((FeedLayoutItemViewBinding) this.d).z.setVisibility(8);
        }
        if (!TextUtils.isEmpty(squareFeed.actionUrl)) {
            if (TextUtils.isEmpty(str)) {
                str = str + "  ";
            } else {
                str = str + "   ";
            }
        }
        SpannableString spannableString = new SpannableString(str);
        if (spannableString.length() <= 0) {
            expandableTextView.setVisibility(8);
            return;
        }
        expandableTextView.setVisibility(0);
        if (!TextUtils.isEmpty(squareFeed.actionUrl)) {
            int length = spannableString.length() - 2;
            int length2 = (spannableString.length() - 2) + 1;
            spannableString.setSpan(new wl1(expandableTextView.getContext(), R$drawable.icon_square_feed_content_official_link, 2), length, length2, 18);
            spannableString.setSpan(new d33(squareFeed.actionUrl, this.itemView.getContext().getResources().getColor(R$color.Aa), false, new b(squareFeed)), length, length2, 18);
        }
        if (this.i == 0) {
            this.i = a46.m(expandableTextView.getContext()).x - a46.b(expandableTextView.getContext(), 102.0f);
        }
        if (this.i < 0) {
            this.i = a46.b(expandableTextView.getContext(), 266.0f);
        }
        expandableTextView.setOriginText(spannableString, this.i, squareFeed.id);
    }

    @BindingAdapter({"setFeedNickName"})
    public void G(TextView textView, SquareFeed squareFeed) {
        if (squareFeed == null || textView == null) {
            return;
        }
        if (squareFeed.official) {
            textView.setTextColor(textView.getContext().getResources().getColor(R$color.Gg));
        } else {
            textView.setTextColor(fg6.n(textView.getContext(), fg6.h(squareFeed.userExt)));
        }
        textView.setText(squareFeed.nickname);
    }

    @BindingAdapter({"setLabelIcon"})
    public void H(ImageView imageView, SquareFeed squareFeed) {
        if (squareFeed == null || imageView == null) {
            return;
        }
        List<String> list = squareFeed.userLabelImg;
        if (list == null || list.isEmpty() || TextUtils.isEmpty(list.get(0))) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            Glide.with(imageView.getContext()).load2(list.get(0)).into(imageView);
        }
    }

    @BindingAdapter({"setLocationAndTime"})
    public void I(View view, SquareFeed squareFeed) {
        List<Media> list = squareFeed.mediaList;
        Media media = (list == null || list.size() == 0 || squareFeed.mediaList.get(0) == null) ? null : squareFeed.mediaList.get(0);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) ((FeedLayoutItemViewBinding) this.d).i.getLayoutParams();
        if (squareFeed.official || media == null) {
            ((FeedLayoutItemViewBinding) this.d).y.setVisibility(8);
            return;
        }
        if (media.getPicSource() == 0) {
            ((FeedLayoutItemViewBinding) this.d).y.setVisibility(0);
            ((FeedLayoutItemViewBinding) this.d).i.setImageResource(R$drawable.icon_square_remember);
            ((FeedLayoutItemViewBinding) this.d).i.setVisibility(0);
            if (media.shootingTime == 0) {
                ((FeedLayoutItemViewBinding) this.d).J.setVisibility(8);
            } else {
                ((FeedLayoutItemViewBinding) this.d).J.setVisibility(0);
                E(((FeedLayoutItemViewBinding) this.d).J, media.shootingTime);
            }
            ((FeedLayoutItemViewBinding) this.d).L.setText(R$string.square_gallery_remember);
            ((FeedLayoutItemViewBinding) this.d).L.setVisibility(0);
            layoutParams.topToTop = ((FeedLayoutItemViewBinding) this.d).L.getId();
            layoutParams.bottomToBottom = ((FeedLayoutItemViewBinding) this.d).L.getId();
            ((FeedLayoutItemViewBinding) this.d).i.setLayoutParams(layoutParams);
            return;
        }
        ((FeedLayoutItemViewBinding) this.d).y.setVisibility(0);
        E(((FeedLayoutItemViewBinding) this.d).J, squareFeed.createTime);
        if (TextUtils.isEmpty(squareFeed.location)) {
            ((FeedLayoutItemViewBinding) this.d).L.setVisibility(4);
            ((FeedLayoutItemViewBinding) this.d).i.setVisibility(8);
            return;
        }
        layoutParams.topToTop = ((FeedLayoutItemViewBinding) this.d).L.getId();
        layoutParams.bottomToBottom = ((FeedLayoutItemViewBinding) this.d).L.getId();
        ((FeedLayoutItemViewBinding) this.d).i.setLayoutParams(layoutParams);
        ((FeedLayoutItemViewBinding) this.d).i.setImageResource(R$drawable.icon_feed_location);
        ((FeedLayoutItemViewBinding) this.d).L.setText(squareFeed.location);
        ((FeedLayoutItemViewBinding) this.d).L.setVisibility(0);
        ((FeedLayoutItemViewBinding) this.d).i.setVisibility(0);
    }

    @BindingAdapter({"createTime", "distance", DistrictSearchQuery.KEYWORDS_CITY})
    public void J(TextView textView, long j, double d2, String str) {
        String str2;
        if (((FeedLayoutItemViewBinding) this.d).o() == null) {
            return;
        }
        String strH = cy5.h(j);
        if (!TextUtils.isEmpty(((FeedLayoutItemViewBinding) this.d).o().timeShow)) {
            strH = ((FeedLayoutItemViewBinding) this.d).o().timeShow;
        }
        if (TextUtils.isEmpty(((FeedLayoutItemViewBinding) this.d).o().location)) {
            textView.setText(strH);
            return;
        }
        if (TextUtils.equals(v4.b(textView.getContext()), ((FeedLayoutItemViewBinding) this.d).o().exid)) {
            textView.setText(strH);
            return;
        }
        if (d2 < 0.01d && d2 > 0.0d) {
            d2 = 0.01d;
        }
        if (d2 > 1.0d) {
            str2 = Math.round(d2) + "";
        } else {
            str2 = String.format("%.2f", Double.valueOf(d2));
        }
        if (str != null && str.length() > 5) {
            str = str.substring(0, 4) + "...";
        }
        StringBuilder sb = new StringBuilder(strH);
        if (d2 > 0.0d) {
            sb.append(" · ");
            sb.append(str2);
            sb.append("km");
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(" · ");
            sb.append(str);
        }
        textView.setText(sb);
    }

    @BindingAdapter({"setTopic"})
    public void K(TextView textView, String str) {
        tg4.b(textView.getContext(), g.g);
        vi5.b().g();
        SquareFeed squareFeedO = ((FeedLayoutItemViewBinding) this.d).o();
        ((FeedLayoutItemViewBinding) this.d).U.setVisibility(8);
        if (!squareFeedO.official && squareFeedO.feedType == 1) {
            if (TextUtils.isEmpty(squareFeedO.location) || 5 != ((zt1) this.e).o()) {
                ((FeedLayoutItemViewBinding) this.d).U.setVisibility(8);
            } else {
                ((FeedLayoutItemViewBinding) this.d).U.setVisibility(0);
                ((FeedLayoutItemViewBinding) this.d).U.setText(squareFeedO.location);
            }
        }
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
            textView.setVisibility(0);
        }
        if (this.n == 0 || this.o == 0) {
            this.n = a46.b(this.itemView.getContext(), 6.0f);
            this.o = a46.b(this.itemView.getContext(), 8.0f);
        }
        if (textView.getVisibility() == 8 && ((FeedLayoutItemViewBinding) this.d).U.getVisibility() == 8) {
            ((FeedLayoutItemViewBinding) this.d).w.setVisibility(8);
            DB db = this.d;
            ((FeedLayoutItemViewBinding) db).H.setPadding(((FeedLayoutItemViewBinding) db).H.getPaddingLeft(), ((FeedLayoutItemViewBinding) this.d).H.getPaddingTop(), ((FeedLayoutItemViewBinding) this.d).H.getPaddingRight(), this.o);
        } else {
            DB db2 = this.d;
            ((FeedLayoutItemViewBinding) db2).H.setPadding(((FeedLayoutItemViewBinding) db2).H.getPaddingLeft(), ((FeedLayoutItemViewBinding) this.d).H.getPaddingTop(), ((FeedLayoutItemViewBinding) this.d).H.getPaddingRight(), this.n);
            ((FeedLayoutItemViewBinding) this.d).w.setVisibility(0);
        }
    }

    @BindingAdapter({"setVipIconInfo"})
    public void L(ImageView imageView, SquareFeed squareFeed) {
        if (squareFeed == null || imageView == null) {
            return;
        }
        int iH = fg6.h(squareFeed.userExt);
        if (!fg6.q(iH)) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(fg6.e(iH));
            imageView.setVisibility(0);
        }
    }

    @BindingAdapter({"setWishes"})
    public void M(LinearLayout linearLayout, SquareFeed squareFeed) {
        if (squareFeed.aeId <= 0 || TextUtils.isEmpty(squareFeed.aeName)) {
            linearLayout.setVisibility(8);
        } else {
            ((FeedLayoutItemViewBinding) this.d).W.setText(squareFeed.aeName);
            if (TextUtils.isEmpty(squareFeed.aeIcon)) {
                ((FeedLayoutItemViewBinding) this.d).q.setVisibility(8);
            } else {
                ((FeedLayoutItemViewBinding) this.d).q.setVisibility(0);
                gr2.j().g(squareFeed.aeIcon, ((FeedLayoutItemViewBinding) this.d).q);
                ((FeedLayoutItemViewBinding) this.d).q.setColorFilter(Color.parseColor("#ffffff"));
            }
            linearLayout.setVisibility(0);
        }
        if (squareFeed.canDelete()) {
            linearLayout.setVisibility(8);
        }
    }

    public void N(View view) {
        int iB;
        Media media = ((FeedLayoutItemViewBinding) this.d).o().mediaList.get(0);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        boolean z = media.getHeight() >= media.getWidth();
        if (s == 0) {
            s = a46.b(this.itemView.getContext(), 20.0f);
        }
        if (z && q == 0) {
            q = a46.b(this.itemView.getContext(), 180.0f);
        }
        if (!z && r == 0) {
            r = a46.b(this.itemView.getContext(), 208.0f);
        }
        if (z) {
            if (((FeedLayoutItemViewBinding) this.d).o().feedType == 2) {
                layoutParams.width = q + s;
            } else {
                layoutParams.width = q;
            }
            iB = q - a46.b(view.getContext(), 12.0f);
            layoutParams.height = (q / 3) * 4;
        } else {
            if (((FeedLayoutItemViewBinding) this.d).o().feedType == 2) {
                layoutParams.width = r + s;
            } else {
                layoutParams.width = r;
            }
            iB = r - a46.b(view.getContext(), 12.0f);
            layoutParams.height = (r / 4) * 3;
        }
        ((FeedLayoutItemViewBinding) this.d).L.setMaxWidth(iB - a46.b(view.getContext(), 30.0f));
        view.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [DB extends androidx.databinding.ViewDataBinding, androidx.databinding.ViewDataBinding] */
    @Override // com.zenmen.listui.list.BaseViewHolder
    public void m() {
        ?? Inflate = DataBindingUtil.inflate(LayoutInflater.from(this.itemView.getContext()), R$layout.feed_layout_item_view, (ViewGroup) this.itemView, false, new FeedItemBindingComponent(this));
        this.d = Inflate;
        ((ViewGroup) this.itemView).addView(((FeedLayoutItemViewBinding) Inflate).getRoot());
        v();
    }

    public void onClick(View view) {
        if (l50.a()) {
            return;
        }
        SquareFeed squareFeedO = ((FeedLayoutItemViewBinding) this.d).o();
        DB db = this.d;
        if (view == ((FeedLayoutItemViewBinding) db).h) {
            ((zt1) this.e).J(squareFeedO);
            return;
        }
        if (view == ((FeedLayoutItemViewBinding) db).u) {
            a46.C(((FeedLayoutItemViewBinding) db).g, R$anim.square_click_like_anim);
            ((zt1) this.e).T(getAdapterPosition(), squareFeedO, ((FeedLayoutItemViewBinding) this.d).A.getVisibility() == 0 ? squareFeedO.praiseGuideType : 0);
            squareFeedO.lastGuideTime -= t;
            ((FeedLayoutItemViewBinding) this.d).A.removeCallbacks(this.l);
            ((FeedLayoutItemViewBinding) this.d).A.setVisibility(8);
            ((FeedLayoutItemViewBinding) this.d).A.clearAnimation();
            return;
        }
        if (view == ((FeedLayoutItemViewBinding) db).k || view == ((FeedLayoutItemViewBinding) db).n || view == ((FeedLayoutItemViewBinding) db).m) {
            if (8 == ((FeedLayoutItemViewBinding) db).o().feedType) {
                ((zt1) this.e).Q(squareFeedO, ((FeedLayoutItemViewBinding) this.d).m);
                return;
            } else if (2 == ((FeedLayoutItemViewBinding) this.d).o().feedType) {
                ((zt1) this.e).Q(squareFeedO, ((FeedLayoutItemViewBinding) this.d).k);
                return;
            } else {
                ((zt1) this.e).Q(squareFeedO, ((FeedLayoutItemViewBinding) this.d).n);
                return;
            }
        }
        if (view == ((FeedLayoutItemViewBinding) db).G) {
            ((zt1) this.e).N(getAdapterPosition(), squareFeedO);
            return;
        }
        if (view == ((FeedLayoutItemViewBinding) db).j) {
            ((zt1) this.e).S(getAdapterPosition(), squareFeedO);
            return;
        }
        if (view == ((FeedLayoutItemViewBinding) db).V) {
            ((zt1) this.e).D(squareFeedO);
            return;
        }
        if (view == ((FeedLayoutItemViewBinding) db).x) {
            qj5.w(this.f, squareFeedO);
            ((zt1) this.e).F(dn0.b(squareFeedO.exid), squareFeedO);
            return;
        }
        if (view == ((FeedLayoutItemViewBinding) db).r || view == ((FeedLayoutItemViewBinding) db).s) {
            ((zt1) this.e).K(getAdapterPosition(), squareFeedO);
            if (view == ((FeedLayoutItemViewBinding) this.d).r) {
                int i = this.f;
                qj5.l(squareFeedO, i, i);
            }
            if (view == ((FeedLayoutItemViewBinding) this.d).s) {
                qj5.p(squareFeedO, this.f);
                return;
            }
            return;
        }
        if (view == ((FeedLayoutItemViewBinding) db).p) {
            ((zt1) this.e).G();
            return;
        }
        if (view == ((FeedLayoutItemViewBinding) db).t) {
            ((zt1) this.e).R(getAdapterPosition(), squareFeedO);
            squareFeedO.sayHiGuideTime -= t;
            ((FeedLayoutItemViewBinding) this.d).C.removeCallbacks(this.m);
            ((FeedLayoutItemViewBinding) this.d).C.setVisibility(8);
            ((FeedLayoutItemViewBinding) this.d).C.clearAnimation();
            return;
        }
        if (view == ((FeedLayoutItemViewBinding) db).H) {
            ((zt1) this.e).L(squareFeedO);
        } else if (view == ((FeedLayoutItemViewBinding) db).v) {
            ((zt1) this.e).L(squareFeedO);
        }
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public void l(SquareFeed squareFeed, int i) {
        ((FeedLayoutItemViewBinding) this.d).p(squareFeed);
        ((FeedLayoutItemViewBinding) this.d).executePendingBindings();
        if (this.f == 5) {
            ((FeedLayoutItemViewBinding) this.d).c.setVisibility(8);
            ((FeedLayoutItemViewBinding) this.d).t.setVisibility(4);
        }
        if (((FeedLayoutItemViewBinding) this.d).o().canDelete()) {
            ((FeedLayoutItemViewBinding) this.d).j.setVisibility(4);
        } else {
            ((FeedLayoutItemViewBinding) this.d).j.setVisibility(0);
        }
        ((zt1) this.e).A(squareFeed);
        if (((zt1) this.e).o() == 1 || ((zt1) this.e).o() == 73 || ((zt1) this.e).o() == 74) {
            ((FeedLayoutItemViewBinding) this.d).s.setVisibility((!((FeedLayoutItemViewBinding) this.d).s.addComments(squareFeed.discussions, false) || squareFeed.hiddenDiscussion) ? 8 : 0);
        }
        if (squareFeed.superShowType == 0) {
            ((FeedLayoutItemViewBinding) this.d).E.setVisibility(8);
            return;
        }
        ((FeedLayoutItemViewBinding) this.d).E.setOnClickListener(new a(i, squareFeed));
        DynamicSuperExposeV1Config dynamicSuperExposeV1ConfigA = kj1.b().a();
        if (!(dynamicSuperExposeV1ConfigA != null ? dynamicSuperExposeV1ConfigA.boost_label : true)) {
            ((FeedLayoutItemViewBinding) this.d).E.setVisibility(8);
            return;
        }
        ((FeedLayoutItemViewBinding) this.d).E.setVisibility(0);
        if (this.h == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, -1.0f);
            this.h = translateAnimation;
            translateAnimation.setDuration(com.igexin.push.config.c.j);
            this.h.setRepeatCount(-1);
            this.h.setInterpolator(new LinearInterpolator());
        }
        this.h.cancel();
        ((FeedLayoutItemViewBinding) this.d).o.startAnimation(this.h);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void s() {
        String strL;
        long jCurrentTimeMillis;
        boolean z;
        RelativeLayout relativeLayout = ((FeedLayoutItemViewBinding) this.d).A;
        if (((zt1) this.e).o() != 1) {
            relativeLayout.setVisibility(8);
            relativeLayout.clearAnimation();
            return;
        }
        SquareFeed squareFeedO = ((FeedLayoutItemViewBinding) this.d).o();
        if (TextUtils.isEmpty(squareFeedO.firstToast) || squareFeedO.ifLike) {
            if (gi5.u() && squareFeedO.showPraiseGuide && !squareFeedO.ifLike) {
                if (gi5.f17735a < 0) {
                    gi5.f17735a = SPUtil.f14322a.i(SPUtil.SCENE.SQUARE, k86.a("key_square_praise_time"), 0L);
                }
                LogUtil.d("logsquare", "nick = " + squareFeedO.nickname + ", guide toast, time = " + gi5.f17735a);
                if (!cy5.j(gi5.f17735a)) {
                    strL = gi5.l();
                    jCurrentTimeMillis = u;
                    squareFeedO.praiseGuideType = 2;
                    LogUtil.d("logsquare", "nick = " + squareFeedO.nickname + ", guide toast, show");
                }
            }
            strL = "";
            jCurrentTimeMillis = 0;
            z = false;
            if (z) {
                relativeLayout.setVisibility(8);
                relativeLayout.clearAnimation();
                LogUtil.d("logsquare", "nick = " + squareFeedO.nickname + ", not show, return");
                return;
            }
            if (squareFeedO.lastGuideTime == 0) {
                RelativeLayout relativeLayout2 = ((FeedLayoutItemViewBinding) this.d).u;
                relativeLayout2.getLocationOnScreen(this.k);
                int height = relativeLayout2.getHeight();
                LogUtil.d("logsquare", "nick = " + squareFeedO.nickname + ", bottom = " + this.k[1] + ", screenHeight = " + me1.f());
                if (height <= 0 || this.k[1] + height > me1.f() - me1.b(relativeLayout2.getContext(), 56)) {
                    relativeLayout.setVisibility(8);
                    relativeLayout.clearAnimation();
                    LogUtil.d("logsquare", "nick = " + squareFeedO.nickname + ", not visible, return");
                    return;
                }
                squareFeedO.lastGuideTime = System.currentTimeMillis();
                relativeLayout.startAnimation(AnimationUtils.loadAnimation(relativeLayout.getContext(), R$anim.square_praise_guide));
                int i = this.f;
                qj5.f0(squareFeedO, i, i, squareFeedO.praiseGuideType);
            } else {
                if (System.currentTimeMillis() - squareFeedO.lastGuideTime >= jCurrentTimeMillis) {
                    relativeLayout.setVisibility(8);
                    relativeLayout.clearAnimation();
                    LogUtil.d("logsquare", "nick = " + squareFeedO.nickname + ", timeout, return");
                    return;
                }
                jCurrentTimeMillis -= System.currentTimeMillis() - squareFeedO.lastGuideTime;
            }
            relativeLayout.setVisibility(0);
            ((FeedLayoutItemViewBinding) this.d).S.setText(strL);
            relativeLayout.removeCallbacks(this.l);
            relativeLayout.postDelayed(this.l, jCurrentTimeMillis);
            return;
        }
        strL = squareFeedO.firstToast;
        jCurrentTimeMillis = t;
        squareFeedO.praiseGuideType = 1;
        LogUtil.d("logsquare", "nick = " + squareFeedO.nickname + ", first toast");
        z = true;
        if (z) {
        }
    }

    public void t() {
        long jU = u();
        if (jU < 0) {
            ((FeedLayoutItemViewBinding) this.d).C.setVisibility(8);
            ((FeedLayoutItemViewBinding) this.d).C.clearAnimation();
            return;
        }
        if (jU == 3000) {
            ((FeedLayoutItemViewBinding) this.d).o().sayHiGuideTime = System.currentTimeMillis();
            DB db = this.d;
            ((FeedLayoutItemViewBinding) db).C.startAnimation(AnimationUtils.loadAnimation(((FeedLayoutItemViewBinding) db).C.getContext(), R$anim.square_praise_guide));
            zn6.b("postfeed_greethint");
        }
        DB db2 = this.d;
        ((FeedLayoutItemViewBinding) db2).T.setText(((FeedLayoutItemViewBinding) db2).o().guideSayHiText);
        ((FeedLayoutItemViewBinding) this.d).C.setVisibility(0);
        ((FeedLayoutItemViewBinding) this.d).C.removeCallbacks(this.m);
        ((FeedLayoutItemViewBinding) this.d).C.postDelayed(this.m, jU);
    }

    public final long u() {
        SquareFeed squareFeedO = ((FeedLayoutItemViewBinding) this.d).o();
        if ((((zt1) this.e).o() != 1 && ((zt1) this.e).o() != 73) || TextUtils.isEmpty(squareFeedO.guideSayHiText)) {
            return -1L;
        }
        if (gi5.b < 0) {
            gi5.b = SPUtil.f14322a.i(SPUtil.SCENE.SQUARE, k86.a("key_square_sayhi_time"), 0L);
        }
        if (cy5.j(gi5.b)) {
            return -1L;
        }
        long jCurrentTimeMillis = 3000;
        if (squareFeedO.sayHiGuideTime != 0) {
            if (System.currentTimeMillis() - squareFeedO.sayHiGuideTime >= 3000) {
                return -1L;
            }
            jCurrentTimeMillis = 3000 - (System.currentTimeMillis() - squareFeedO.sayHiGuideTime);
        }
        ((FeedLayoutItemViewBinding) this.d).t.getLocationOnScreen(this.k);
        int height = ((FeedLayoutItemViewBinding) this.d).t.getHeight();
        if (height <= 0 || this.k[1] + height > me1.f() - me1.b(((FeedLayoutItemViewBinding) this.d).t.getContext(), 56)) {
            return -1L;
        }
        return jCurrentTimeMillis;
    }

    public void v() {
        ((FeedLayoutItemViewBinding) this.d).h.setOnClickListener(this);
        ((FeedLayoutItemViewBinding) this.d).u.setOnClickListener(this);
        ((FeedLayoutItemViewBinding) this.d).r.setOnClickListener(this);
        ((FeedLayoutItemViewBinding) this.d).k.setOnClickListener(this);
        ((FeedLayoutItemViewBinding) this.d).n.setOnClickListener(this);
        ((FeedLayoutItemViewBinding) this.d).m.setOnClickListener(this);
        ((FeedLayoutItemViewBinding) this.d).G.setOnClickListener(this);
        ((FeedLayoutItemViewBinding) this.d).j.setOnClickListener(this);
        ((FeedLayoutItemViewBinding) this.d).V.setOnClickListener(this);
        ((FeedLayoutItemViewBinding) this.d).x.setOnClickListener(this);
        ((FeedLayoutItemViewBinding) this.d).p.setOnClickListener(this);
        ((FeedLayoutItemViewBinding) this.d).s.setOnClickListener(this);
        ((FeedLayoutItemViewBinding) this.d).t.setOnClickListener(this);
        ((FeedLayoutItemViewBinding) this.d).v.setOnClickListener(this);
    }

    @BindingAdapter({"avatarUrl"})
    public void w(LXPortraitView lXPortraitView, SquareFeed squareFeed) {
        lXPortraitView.setVisibility(squareFeed.liveFlag ? 8 : 0);
        if (squareFeed.isNewUser()) {
            lXPortraitView.setLabelText("新人", -1, R$drawable.bg_green_btn_8);
        } else {
            lXPortraitView.setLabelText(null, 0, 0);
        }
        if (TextUtils.equals(this.j, squareFeed.headImgUrl)) {
            return;
        }
        this.j = squareFeed.headImgUrl;
        if (p == null) {
            p = a46.j(lXPortraitView.getContext(), 24.0f, R$drawable.default_portrait);
        }
        lXPortraitView.setAvatarView(k86.p(squareFeed.headImgUrl), Amulet.buildFromUserExt(squareFeed.userExt));
    }

    @BindingAdapter({"setBigDateShow"})
    public void x(ConstraintLayout constraintLayout, boolean z) {
        if (z && this.f == 5) {
            constraintLayout.setVisibility(0);
        } else {
            constraintLayout.setVisibility(8);
        }
    }

    @BindingAdapter({"contentUrl"})
    public void y(FeedItemVenusView feedItemVenusView, SquareFeed squareFeed) {
        B(feedItemVenusView, squareFeed);
    }

    @BindingAdapter({"contentImgUrl"})
    public void z(FeedItemMultiPicView feedItemMultiPicView, SquareFeed squareFeed) {
        A(feedItemMultiPicView, squareFeed);
    }
}
