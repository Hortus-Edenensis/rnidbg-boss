package com.zenmen.find.holder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.palmchat.widget.DecorAvatarView;
import com.zenmen.palmchat.widget.VenusPortraitView;
import com.zenmen.square.R$layout;
import com.zenmen.square.databinding.LayoutSquareMapFinderGuideBinding;
import com.zenmen.square.mvp.SquareDataBindingComponent;
import com.zenmen.square.mvp.model.bean.NearByBean;
import com.zenmen.square.util.conf.MapFinderConfig;
import defpackage.a46;
import defpackage.gi5;
import defpackage.iu3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class NearbyMapFinderGuideViewHolder extends BaseViewHolder<NearByBean, LayoutSquareMapFinderGuideBinding, iu3> {
    public String f;

    /* JADX INFO: compiled from: SearchBox */
    public class NearByMapFinderDataBindingComment extends SquareDataBindingComponent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NearbyMapFinderGuideViewHolder f11815a;

        public NearByMapFinderDataBindingComment(NearbyMapFinderGuideViewHolder nearbyMapFinderGuideViewHolder) {
            this.f11815a = nearbyMapFinderGuideViewHolder;
        }

        @Override // com.zenmen.square.mvp.SquareDataBindingComponent, androidx.databinding.DataBindingComponent
        public NearbyMapFinderGuideViewHolder getNearbyMapFinderGuideViewHolder() {
            return this.f11815a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((iu3) NearbyMapFinderGuideViewHolder.this.e).L();
        }
    }

    public NearbyMapFinderGuideViewHolder(View view) {
        super(view);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [DB extends androidx.databinding.ViewDataBinding, androidx.databinding.ViewDataBinding] */
    @Override // com.zenmen.listui.list.BaseViewHolder
    public void m() {
        ?? Inflate = DataBindingUtil.inflate(LayoutInflater.from(this.itemView.getContext()), R$layout.layout_square_map_finder_guide, (ViewGroup) this.itemView, false, new NearByMapFinderDataBindingComment(this));
        this.d = Inflate;
        ((ViewGroup) this.itemView).addView(((LayoutSquareMapFinderGuideBinding) Inflate).getRoot());
        ((LayoutSquareMapFinderGuideBinding) this.d).b.setAvatarRadius(a46.b(this.itemView.getContext(), 33.0f));
        ((LayoutSquareMapFinderGuideBinding) this.d).b.setDecorRadius(a46.b(this.itemView.getContext(), 33.0f));
        q();
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(NearByBean nearByBean, int i) {
        MapFinderConfig.RecommendEntry recommendEntry = gi5.g().pagelffriend_recommend_cardentry;
        if (recommendEntry != null) {
            ((LayoutSquareMapFinderGuideBinding) this.d).b(recommendEntry);
            ((LayoutSquareMapFinderGuideBinding) this.d).executePendingBindings();
        }
    }

    public final void q() {
        this.itemView.setOnClickListener(new a());
    }

    @BindingAdapter({"mapFinderAvatar"})
    public void r(VenusPortraitView venusPortraitView, String str) {
        if (TextUtils.equals(this.f, str)) {
            return;
        }
        this.f = str;
        venusPortraitView.setGender(0);
        venusPortraitView.setUrl(str, "", new b());
        venusPortraitView.stop();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements DecorAvatarView.c {
        public b() {
        }

        @Override // com.zenmen.palmchat.widget.DecorAvatarView.c
        public void a() {
            b();
        }

        @Override // com.zenmen.palmchat.widget.DecorAvatarView.c
        public void onFailed() {
            b();
        }

        @Override // com.zenmen.palmchat.widget.DecorAvatarView.c
        public void onLoaded() {
            b();
        }

        public final void b() {
        }
    }
}
