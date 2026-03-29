package com.zenmen.square.vip;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zenmen.listui.list.BaseBean;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.ap3;
import defpackage.hc2;
import defpackage.kc2;
import defpackage.zn6;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FeedVipEnterHolder extends BaseViewHolder {
    public ImageView f;
    public Context g;
    public FrameworkBaseActivity h;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareFeed f16592a;

        public a(SquareFeed squareFeed) {
            this.f16592a = squareFeed;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareFeed squareFeed = this.f16592a;
            if (squareFeed != null && !TextUtils.isEmpty(squareFeed.vipBannerUrl)) {
                int i = this.f16592a.urlType;
                if (i == 2 || i == 3) {
                    ap3.v(FeedVipEnterHolder.this.h, this.f16592a.vipBannerUrl);
                } else {
                    ap3.t(FeedVipEnterHolder.this.g, this.f16592a.vipBannerUrl);
                }
            }
            FeedVipEnterHolder feedVipEnterHolder = FeedVipEnterHolder.this;
            feedVipEnterHolder.r(feedVipEnterHolder.g, "discover_campaign", "click");
        }
    }

    public FeedVipEnterHolder(FrameworkBaseActivity frameworkBaseActivity, View view) {
        super(view);
        this.h = frameworkBaseActivity;
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    public void l(BaseBean baseBean, int i) {
        if (!(baseBean instanceof SquareFeed) || this.f == null) {
            return;
        }
        SquareFeed squareFeed = (SquareFeed) baseBean;
        kc2<Drawable> kc2VarTransform = hc2.a(this.g).load(squareFeed.vipBannerBg).diskCacheStrategy(DiskCacheStrategy.NONE).transform(new RoundedCornersTransformation(8, 0));
        int i2 = R$drawable.ic_details_pic;
        kc2VarTransform.placeholder(i2).error(i2).into(this.f);
        this.f.setOnClickListener(new a(squareFeed));
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    public void m() {
        this.g = this.itemView.getContext();
        View viewInflate = LayoutInflater.from(this.itemView.getContext()).inflate(R$layout.layout_square_header_vip_enter, (ViewGroup) this.itemView, false);
        this.f = (ImageView) viewInflate.findViewById(R$id.vip_banner);
        ((ViewGroup) this.itemView).addView(viewInflate);
        r(this.g, "discover_campaign", "view");
    }

    public final void r(Context context, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vip_status", ap3.i(context));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.f(str, str2, jSONObject);
    }
}
