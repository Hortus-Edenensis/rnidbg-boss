package com.zenmen.square.mvp.holder;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import com.bumptech.glide.Glide;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.listui.widget.LeftDrawableText;
import com.zenmen.palmchat.contacts.bean.Amulet;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.BlurringView;
import com.zenmen.palmchat.widget.LXPortraitView;
import com.zenmen.square.R$color;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.databinding.LayoutSquareNearbyItemBinding;
import com.zenmen.square.fragment.NearByFragment;
import com.zenmen.square.mvp.SquareDataBindingComponent;
import com.zenmen.square.mvp.model.bean.NearByBean;
import com.zenmen.square.ui.widget.NearByFeedContainer;
import defpackage.a46;
import defpackage.ai5;
import defpackage.ap3;
import defpackage.b05;
import defpackage.bj5;
import defpackage.fg6;
import defpackage.hs1;
import defpackage.iu3;
import defpackage.l36;
import defpackage.l50;
import defpackage.me1;
import defpackage.q33;
import defpackage.qj5;
import defpackage.sy5;
import defpackage.zn6;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NearByViewHolder extends BaseViewHolder<NearByBean, LayoutSquareNearbyItemBinding, iu3> implements View.OnClickListener, q33 {
    public static Handler i = new Handler(Looper.getMainLooper());
    public static HashSet<String> j = new HashSet<>();
    public BlurringView f;
    public TranslateAnimation g;
    public String h;

    /* JADX INFO: compiled from: SearchBox */
    public class NearByDataBindingComment extends SquareDataBindingComponent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NearByViewHolder f16436a;

        public NearByDataBindingComment(NearByViewHolder nearByViewHolder) {
            this.f16436a = nearByViewHolder;
        }

        @Override // com.zenmen.square.mvp.SquareDataBindingComponent, androidx.databinding.DataBindingComponent
        public NearByViewHolder getNearByViewHolder() {
            return this.f16436a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NearByBean f16437a;

        public a(NearByBean nearByBean) {
            this.f16437a = nearByBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            NearByViewHolder.j.add(this.f16437a.exid);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements LXPortraitView.c {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (NearByViewHolder.this.f.getVisibility() != 0) {
                    return;
                }
                NearByViewHolder.this.f.invalidate();
            }
        }

        public b() {
        }

        @Override // com.zenmen.palmchat.widget.LXPortraitView.c
        public void a() {
            b();
        }

        public final void b() {
            if (NearByViewHolder.this.f == null || NearByViewHolder.this.f.getVisibility() != 0) {
                return;
            }
            NearByViewHolder.i.postDelayed(new a(), com.igexin.push.config.c.j);
        }

        @Override // com.zenmen.palmchat.widget.LXPortraitView.c
        public void onFailed() {
            b();
        }

        @Override // com.zenmen.palmchat.widget.LXPortraitView.c
        public void onLoaded() {
            b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LeftDrawableText f16440a;

        public c(LeftDrawableText leftDrawableText) {
            this.f16440a = leftDrawableText;
        }

        @Override // java.lang.Runnable
        public void run() {
            NearByViewHolder.this.B(this.f16440a.getWidth());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f16441a;
        public final /* synthetic */ int b;

        public d(int i, int i2) {
            this.f16441a = i;
            this.b = i2;
            put("requestId", ((LayoutSquareNearbyItemBinding) NearByViewHolder.this.d).o().reqId);
            put(EventParams.KEY_CT_SDK_POSITION, Integer.valueOf(i));
            put("impr_id", ((LayoutSquareNearbyItemBinding) NearByViewHolder.this.d).o().imprId);
            put("useCache", 0);
            put("initialRequestId", "");
            put("show_position", Integer.valueOf(i2));
            put("realUserType", Integer.valueOf(((LayoutSquareNearbyItemBinding) NearByViewHolder.this.d).o().userType));
        }
    }

    public NearByViewHolder(View view) {
        super(view);
        this.f = null;
        this.g = null;
    }

    @BindingAdapter({"nearByFeedList"})
    public void A(NearByFeedContainer nearByFeedContainer, NearByBean nearByBean) {
        List<NearByBean.FeedSimpleInfo> list;
        NearByBean.Extra extra = nearByBean.extra;
        if (extra == null || (list = extra.feedList) == null || list.size() <= 0) {
            ((LayoutSquareNearbyItemBinding) this.d).k.setVisibility(0);
        } else {
            ((LayoutSquareNearbyItemBinding) this.d).k.setVisibility(8);
        }
        nearByFeedContainer.setFeedThumbnail(nearByBean);
    }

    public final void B(int i2) {
        Context context = this.itemView.getContext();
        int iB = (a46.m(context).x - a46.b(context, 115.0f)) - i2;
        ((LayoutSquareNearbyItemBinding) this.d).k.setMaxWidth(iB);
        ((LayoutSquareNearbyItemBinding) this.d).m.setMaxWidth(iB);
    }

    @BindingAdapter({"setNearByLabelIcon"})
    public void C(ImageView imageView, NearByBean nearByBean) {
        if (nearByBean == null || imageView == null) {
            return;
        }
        if (Amulet.buildFromUserExt(nearByBean.userExt) != null) {
            imageView.setVisibility(8);
            return;
        }
        List<String> list = nearByBean.userLabelImg;
        if (list == null || list.isEmpty() || TextUtils.isEmpty(list.get(0))) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            Glide.with(imageView.getContext()).load2(list.get(0)).into(imageView);
        }
    }

    @BindingAdapter({"setNearByName"})
    public void D(TextView textView, NearByBean nearByBean) {
        if (nearByBean == null || textView == null) {
            return;
        }
        if (nearByBean.official) {
            textView.setTextColor(this.itemView.getContext().getResources().getColor(R$color.Gg));
        } else {
            textView.setTextColor(fg6.n(this.itemView.getContext(), fg6.h(nearByBean.userExt)));
        }
        textView.setText(nearByBean.nickname);
    }

    @BindingAdapter({"setNearByVipIcon"})
    public void E(ImageView imageView, NearByBean nearByBean) {
        if (nearByBean == null || imageView == null) {
            return;
        }
        int iH = fg6.h(nearByBean.userExt);
        if (!fg6.q(iH)) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(fg6.e(iH));
            imageView.setVisibility(0);
        }
    }

    @BindingAdapter({"setSayHiText"})
    public void F(LeftDrawableText leftDrawableText, NearByBean nearByBean) {
        leftDrawableText.setText(ai5.k().g().getUserHomeChatText(leftDrawableText.getContext()));
        leftDrawableText.post(new c(leftDrawableText));
    }

    @BindingAdapter({"setUserProfile"})
    public void G(TextView textView, NearByBean nearByBean) {
        StringBuilder sb = new StringBuilder();
        int i2 = nearByBean.age;
        if (i2 > 0) {
            sb.append(i2);
            sb.append("岁");
        }
        if (!TextUtils.isEmpty(nearByBean.city)) {
            if (sb.length() > 0) {
                sb.append(" · ");
            }
            sb.append(nearByBean.city);
        }
        if (nearByBean.jobCode > 0) {
            String strH = hs1.e().h(nearByBean.jobCode);
            if (!TextUtils.isEmpty(strH) && !"请选择职业".equals(strH)) {
                if (sb.length() > 0) {
                    sb.append(" · ");
                }
                sb.append(strH);
            }
        }
        textView.setText(sb);
    }

    @BindingAdapter({"superExposeEnter"})
    public void H(RelativeLayout relativeLayout, NearByBean nearByBean) {
        boolean z;
        boolean z2 = false;
        if (relativeLayout != null && nearByBean != null) {
            if (nearByBean.userType == 17) {
                if (bj5.b().a().k()) {
                    View view = this.itemView;
                    view.setBackground(view.getContext().getDrawable(R$drawable.bg_nearby_view_holder_normal));
                    z = true;
                } else {
                    View view2 = this.itemView;
                    view2.setBackground(view2.getContext().getDrawable(R$drawable.bg_nearby_view_holder_super_expose));
                    z = false;
                }
                relativeLayout.setVisibility(0);
                if (this.g == null) {
                    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, -1.0f);
                    this.g = translateAnimation;
                    translateAnimation.setDuration(com.igexin.push.config.c.j);
                    this.g.setRepeatCount(-1);
                    this.g.setInterpolator(new LinearInterpolator());
                }
                this.g.cancel();
                ((LayoutSquareNearbyItemBinding) this.d).n.startAnimation(this.g);
                z2 = z;
            } else {
                View view3 = this.itemView;
                view3.setBackground(view3.getContext().getDrawable(R$drawable.bg_nearby_view_holder_normal));
                relativeLayout.setVisibility(8);
            }
        }
        if (z2) {
            ((LayoutSquareNearbyItemBinding) this.d).j.start();
        } else {
            ((LayoutSquareNearbyItemBinding) this.d).j.stop();
        }
    }

    @Override // defpackage.q33
    public void c() {
        DB db = this.d;
        if (db == 0 || ((LayoutSquareNearbyItemBinding) db).o() == null) {
            return;
        }
        ((LayoutSquareNearbyItemBinding) this.d).o().hasShow = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.q33
    public void e(int i2, HashSet hashSet, int i3) {
        DB db = this.d;
        if (db == 0 || ((LayoutSquareNearbyItemBinding) db).o() == null || ((LayoutSquareNearbyItemBinding) this.d).o().hasShow) {
            return;
        }
        bj5.b().a().v(((NearByFragment) ((iu3) this.e).p()).getActivity(), i3, i2);
        if (((LayoutSquareNearbyItemBinding) this.d).o().userType == 17) {
            HashMap map = new HashMap();
            map.put("from", Integer.valueOf(((iu3) this.e).o()));
            map.put("impr_id", ((LayoutSquareNearbyItemBinding) this.d).o().imprId);
            zn6.j("boost_label", "view", map);
            b05.d("显示超级曝光" + i2);
            String str = ((LayoutSquareNearbyItemBinding) this.d).o().reqId + "_" + ((LayoutSquareNearbyItemBinding) this.d).o().imprId + "_" + i2;
            if (!hashSet.contains(str)) {
                hashSet.add(str);
                b05.d("上传数据:" + str);
                int i4 = 48 == i3 ? 1 : 49 == i3 ? 2 : 0;
                if (i4 > 0) {
                    b05.d("boost_buyer_show_seen====>" + ((LayoutSquareNearbyItemBinding) this.d).o().imprId);
                    zn6.j("boost_buyer_show_seen", null, new d(i4, i2));
                }
            }
        }
        LogUtil.d("logreport", "show: " + ((LayoutSquareNearbyItemBinding) this.d).o().nickname);
        ((LayoutSquareNearbyItemBinding) this.d).o().hasShow = true;
        ((iu3) this.e).z(((LayoutSquareNearbyItemBinding) this.d).o());
    }

    @Override // defpackage.q33
    public View getView() {
        return this.itemView;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [DB extends androidx.databinding.ViewDataBinding, androidx.databinding.ViewDataBinding] */
    @Override // com.zenmen.listui.list.BaseViewHolder
    public void m() {
        ?? Inflate = DataBindingUtil.inflate(LayoutInflater.from(this.itemView.getContext()), R$layout.layout_square_nearby_item, (ViewGroup) this.itemView, false, new NearByDataBindingComment(this));
        this.d = Inflate;
        ((ViewGroup) this.itemView).addView(((LayoutSquareNearbyItemBinding) Inflate).getRoot());
        x();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (l50.a() || ((LayoutSquareNearbyItemBinding) this.d).o() == null) {
            return;
        }
        if (TextUtils.isEmpty(((LayoutSquareNearbyItemBinding) this.d).o().exid)) {
            sy5.f(view.getContext(), view.getContext().getString(R$string.get_user_info_failed), 0).g();
            return;
        }
        if (view.getId() == R$id.iv_nearby_avatar) {
            HashMap map = new HashMap();
            map.put("from", 14);
            map.put("toExid", ((LayoutSquareNearbyItemBinding) this.d).o().exid);
            zn6.j("pagediscover_feeds_userbutton", "click", map);
        }
        DB db = this.d;
        if (view == ((LayoutSquareNearbyItemBinding) db).c) {
            bj5.b().a().w(true);
            ((iu3) this.e).B(null, ((LayoutSquareNearbyItemBinding) this.d).o());
            qj5.S(((LayoutSquareNearbyItemBinding) this.d).o(), ((NearByFragment) ((iu3) this.e).p()).getSid(), ((iu3) this.e).o());
            return;
        }
        if (view == ((LayoutSquareNearbyItemBinding) db).o) {
            ((iu3) this.e).D();
            return;
        }
        if (view == ((LayoutSquareNearbyItemBinding) db).q) {
            HashMap map2 = new HashMap();
            map2.put("from", Integer.valueOf(((iu3) this.e).o()));
            map2.put("impr_id", ((LayoutSquareNearbyItemBinding) this.d).o().imprId);
            zn6.j("boost_label", "click", map2);
            ((iu3) this.e).J();
            return;
        }
        if (view == ((LayoutSquareNearbyItemBinding) db).i) {
            zn6.c("findtab_amulet", "click");
            ap3.a().b0().b(((NearByFragment) ((iu3) this.e).p()).getActivity());
        } else if (view == ((LayoutSquareNearbyItemBinding) db).f) {
            w();
        } else if (view == ((LayoutSquareNearbyItemBinding) db).l) {
            ((iu3) this.e).C();
        } else {
            ((iu3) this.e).G(getAdapterPosition(), ((LayoutSquareNearbyItemBinding) this.d).o());
            qj5.O(((LayoutSquareNearbyItemBinding) this.d).o(), ((NearByFragment) ((iu3) this.e).p()).getSid(), ((LayoutSquareNearbyItemBinding) this.d).o().userType == 17 ? 79 : ((iu3) this.e).o());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.zenmen.listui.list.BaseViewHolder
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void l(NearByBean nearByBean, int i2) {
        try {
            ((LayoutSquareNearbyItemBinding) this.d).p(nearByBean);
            ((LayoutSquareNearbyItemBinding) this.d).executePendingBindings();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        NearByFragment nearByFragment = (NearByFragment) ((iu3) this.e).p();
        int iG0 = nearByFragment == null ? -1 : nearByFragment.G0();
        if (iG0 == -1 || i2 <= iG0) {
            BlurringView blurringView = this.f;
            if (blurringView != null) {
                blurringView.setVisibility(8);
            }
        } else {
            if (this.f == null) {
                BlurringView blurringView2 = new BlurringView(this.itemView.getContext());
                this.f = blurringView2;
                blurringView2.setBlurRadius(4);
                this.f.setBlurredView(((LayoutSquareNearbyItemBinding) this.d).r);
                this.f.setClickable(true);
                this.f.setBackgroundColor(-1);
                ((LayoutSquareNearbyItemBinding) this.d).b.addView(this.f, new ViewGroup.LayoutParams(-1, -1));
            }
            this.f.setVisibility(0);
        }
        Pair<String, Boolean> pairA = ap3.a().b0().a(nearByBean.exid, Amulet.buildFromUserExt(nearByBean.userExt));
        if (TextUtils.isEmpty((CharSequence) pairA.first)) {
            ((LayoutSquareNearbyItemBinding) this.d).i.setVisibility(8);
        } else {
            ((LayoutSquareNearbyItemBinding) this.d).k.setVisibility(8);
            ((LayoutSquareNearbyItemBinding) this.d).d.setVisibility(8);
            ((LayoutSquareNearbyItemBinding) this.d).i.setVisibility(0);
            ((LayoutSquareNearbyItemBinding) this.d).i.setText((CharSequence) pairA.first);
            if (((Boolean) pairA.second).booleanValue()) {
                ((LayoutSquareNearbyItemBinding) this.d).i.setOnClickListener(new View.OnClickListener() { // from class: ku3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f18832a.onClick(view);
                    }
                });
                ((LayoutSquareNearbyItemBinding) this.d).i.setCompoundDrawables(null, null, l36.b().getDrawable(R$drawable.square_publish_right_arrow), null);
            } else {
                ((LayoutSquareNearbyItemBinding) this.d).i.setOnClickListener(null);
                ((LayoutSquareNearbyItemBinding) this.d).i.setCompoundDrawables(null, null, null, null);
            }
            ((LayoutSquareNearbyItemBinding) this.d).i.setCompoundDrawablePadding(me1.b(l36.a(), 2));
        }
        if (nearByBean.userType == NearByBean.TAG_TYPE_FEED_SEPARATION) {
            ((LayoutSquareNearbyItemBinding) this.d).f.setVisibility(0);
        } else {
            ((LayoutSquareNearbyItemBinding) this.d).f.setVisibility(8);
        }
        if (((LayoutSquareNearbyItemBinding) this.d).o().isAiChat()) {
            ((LayoutSquareNearbyItemBinding) this.d).e.setVisibility(0);
        } else {
            ((LayoutSquareNearbyItemBinding) this.d).e.setVisibility(8);
        }
        if (nearByBean.userType != NearByBean.TAG_TYPE_FEED_POLISH) {
            ((LayoutSquareNearbyItemBinding) this.d).l.setVisibility(8);
            return;
        }
        ((LayoutSquareNearbyItemBinding) this.d).i.setVisibility(8);
        ((LayoutSquareNearbyItemBinding) this.d).k.setVisibility(8);
        ((LayoutSquareNearbyItemBinding) this.d).d.setVisibility(8);
        String strU = ap3.a().U();
        if (!TextUtils.isEmpty(strU)) {
            ((LayoutSquareNearbyItemBinding) this.d).l.setText(strU);
        }
        ((LayoutSquareNearbyItemBinding) this.d).l.setVisibility(0);
        ((LayoutSquareNearbyItemBinding) this.d).l.setOnClickListener(new View.OnClickListener() { // from class: ku3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18832a.onClick(view);
            }
        });
        if (j.contains(nearByBean.exid)) {
            return;
        }
        ((LayoutSquareNearbyItemBinding) this.d).f16233a.startLightingAnimation(0, new a(nearByBean));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w() {
        P p = this.e;
        if (p == 0 || ((iu3) p).p() == 0 || ((NearByFragment) ((iu3) this.e).p()).getActivity() == null) {
            return;
        }
        try {
            HashMap map = new HashMap();
            map.put("from", Integer.valueOf(((iu3) this.e).o()));
            zn6.g("pagelffriend_recommend_avatarentry", new JSONObject(map));
        } catch (Exception unused) {
        }
        bj5.b().a().f0(((NearByFragment) ((iu3) this.e).p()).getActivity());
    }

    public final void x() {
        this.itemView.setOnClickListener(this);
        this.itemView.findViewById(R$id.iv_nearby_avatar).setOnClickListener(this);
        ((LayoutSquareNearbyItemBinding) this.d).o.setOnClickListener(this);
        ((LayoutSquareNearbyItemBinding) this.d).c.setOnClickListener(this);
        ((LayoutSquareNearbyItemBinding) this.d).j.setOnClickListener(this);
        ((LayoutSquareNearbyItemBinding) this.d).q.setOnClickListener(this);
        ((LayoutSquareNearbyItemBinding) this.d).f.setOnClickListener(this);
    }

    @BindingAdapter({"nearByAvatar"})
    public void y(LXPortraitView lXPortraitView, NearByBean nearByBean) {
        String str = nearByBean.avatar;
        if (TextUtils.equals(this.h, str)) {
            return;
        }
        this.h = str;
        lXPortraitView.setAvatarView(str, 0, com.zenmen.palmchat.framework.R$drawable.default_portrait_new, new b(), Amulet.buildFromUserExt(nearByBean.userExt));
    }

    @BindingAdapter({"nearbyDistance"})
    public void z(TextView textView, long j2) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) ((LayoutSquareNearbyItemBinding) this.d).c.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) ((LayoutSquareNearbyItemBinding) this.d).v.getLayoutParams();
        if (((iu3) this.e).o() == 48) {
            ((LayoutSquareNearbyItemBinding) this.d).s.setVisibility(8);
            ((LayoutSquareNearbyItemBinding) this.d).u.setVisibility(8);
            layoutParams.bottomToBottom = ((LayoutSquareNearbyItemBinding) this.d).j.getId();
            layoutParams.topToTop = ((LayoutSquareNearbyItemBinding) this.d).j.getId();
            layoutParams.topToBottom = -1;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
            layoutParams2.rightToLeft = ((LayoutSquareNearbyItemBinding) this.d).c.getId();
            layoutParams2.rightToRight = -1;
            return;
        }
        ((LayoutSquareNearbyItemBinding) this.d).s.setVisibility(0);
        ((LayoutSquareNearbyItemBinding) this.d).u.setVisibility(0);
        layoutParams.bottomToBottom = -1;
        layoutParams.topToTop = -1;
        layoutParams.topToBottom = ((LayoutSquareNearbyItemBinding) this.d).v.getId();
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = a46.b(textView.getContext(), 10.0f);
        layoutParams2.rightToLeft = -1;
        layoutParams2.rightToRight = 0;
        if (j2 >= 0) {
            double dFloor = j2 / 1000.0f;
            if (dFloor < 0.01d) {
                dFloor = 0.01d;
            }
            if (dFloor > 10.0d) {
                dFloor = Math.floor(dFloor);
            }
            String str = String.format("%.2f", Double.valueOf(dFloor));
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length > 1) {
                char[] charArray = strArrSplit[1].toCharArray();
                int length = charArray.length;
                for (int length2 = charArray.length - 1; length2 >= 0 && charArray[length2] == '0'; length2--) {
                    length--;
                }
                str = length > 0 ? strArrSplit[0] + "." + strArrSplit[1].substring(0, length) : strArrSplit[0];
            }
            textView.setText(str + "km · ");
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        if (((LayoutSquareNearbyItemBinding) this.d).o().userType != 18) {
            textView.setBackgroundResource(0);
            ((LayoutSquareNearbyItemBinding) this.d).u.setBackgroundResource(0);
        } else {
            textView.setTextColor(Color.parseColor("#333333"));
            textView.setBackgroundResource(R$drawable.bg_nearby_distance_left);
            ((LayoutSquareNearbyItemBinding) this.d).u.setBackgroundResource(R$drawable.bg_nearby_distance_right);
        }
    }
}
