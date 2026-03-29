package com.zenmen.square.mvp.holder;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.listui.widget.LeftDrawableText;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.FlowLayout;
import com.zenmen.square.R$color;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.databinding.LayoutQualityFriendshipItemBinding;
import com.zenmen.square.fragment.NearByFragment;
import com.zenmen.square.mvp.SquareDataBindingComponent;
import com.zenmen.square.mvp.model.bean.NearByBean;
import defpackage.a46;
import defpackage.ai5;
import defpackage.hc2;
import defpackage.hs1;
import defpackage.iu3;
import defpackage.k86;
import defpackage.kc2;
import defpackage.l50;
import defpackage.q33;
import defpackage.qj5;
import defpackage.sy5;
import defpackage.zn6;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class QualityFriendShipViewHolder extends BaseViewHolder<NearByBean, LayoutQualityFriendshipItemBinding, iu3> implements View.OnClickListener, q33 {

    /* JADX INFO: compiled from: SearchBox */
    public class QualityFriendShipDataBindingComment extends SquareDataBindingComponent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public QualityFriendShipViewHolder f16445a;

        public QualityFriendShipDataBindingComment(QualityFriendShipViewHolder qualityFriendShipViewHolder) {
            this.f16445a = qualityFriendShipViewHolder;
        }

        @Override // com.zenmen.square.mvp.SquareDataBindingComponent, androidx.databinding.DataBindingComponent
        public QualityFriendShipViewHolder getQualityFriendShipViewHolder() {
            return this.f16445a;
        }
    }

    public QualityFriendShipViewHolder(View view) {
        super(view);
    }

    @Override // defpackage.q33
    public void c() {
        DB db = this.d;
        if (db == 0 || ((LayoutQualityFriendshipItemBinding) db).o() == null) {
            return;
        }
        ((LayoutQualityFriendshipItemBinding) this.d).o().hasShow = false;
    }

    @Override // defpackage.q33
    public void e(int i, HashSet hashSet, int i2) {
        DB db = this.d;
        if (db == 0 || ((LayoutQualityFriendshipItemBinding) db).o() == null || ((LayoutQualityFriendshipItemBinding) this.d).o().hasShow) {
            return;
        }
        LogUtil.d("logreport", "show: " + ((LayoutQualityFriendshipItemBinding) this.d).o().nickname);
        ((LayoutQualityFriendshipItemBinding) this.d).o().hasShow = true;
        ((iu3) this.e).z(((LayoutQualityFriendshipItemBinding) this.d).o());
    }

    @Override // defpackage.q33
    public View getView() {
        return this.itemView;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [DB extends androidx.databinding.ViewDataBinding, androidx.databinding.ViewDataBinding] */
    @Override // com.zenmen.listui.list.BaseViewHolder
    public void m() {
        ?? Inflate = DataBindingUtil.inflate(LayoutInflater.from(this.itemView.getContext()), R$layout.layout_quality_friendship_item, (ViewGroup) this.itemView, false, new QualityFriendShipDataBindingComment(this));
        this.d = Inflate;
        ((ViewGroup) this.itemView).addView(((LayoutQualityFriendshipItemBinding) Inflate).getRoot());
        q();
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void l(NearByBean nearByBean, int i) {
        try {
            ((LayoutQualityFriendshipItemBinding) this.d).p(nearByBean);
            ((LayoutQualityFriendshipItemBinding) this.d).executePendingBindings();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (l50.a() || ((LayoutQualityFriendshipItemBinding) this.d).o() == null) {
            return;
        }
        if (TextUtils.isEmpty(((LayoutQualityFriendshipItemBinding) this.d).o().exid)) {
            sy5.f(view.getContext(), view.getContext().getString(R$string.get_user_info_failed), 0).g();
            return;
        }
        if (view.getId() == R$id.iv_qf_avatar) {
            HashMap map = new HashMap();
            map.put("from", 75);
            map.put("toExid", ((LayoutQualityFriendshipItemBinding) this.d).o().exid);
            zn6.j("pagediscover_feeds_userbutton", "click", map);
        }
        DB db = this.d;
        if (view == ((LayoutQualityFriendshipItemBinding) db).f16225a) {
            ((iu3) this.e).B(null, ((LayoutQualityFriendshipItemBinding) db).o());
            qj5.S(((LayoutQualityFriendshipItemBinding) this.d).o(), ((NearByFragment) ((iu3) this.e).p()).getSid(), 75);
        } else {
            ((iu3) this.e).G(getAdapterPosition(), ((LayoutQualityFriendshipItemBinding) this.d).o());
            qj5.O(((LayoutQualityFriendshipItemBinding) this.d).o(), ((NearByFragment) ((iu3) this.e).p()).getSid(), 75);
        }
    }

    @BindingAdapter({"qfAudioVideo"})
    public void p(TextView textView, NearByBean nearByBean) {
        if (nearByBean == null || TextUtils.isEmpty(nearByBean.communicationType)) {
            textView.setVisibility(8);
        } else {
            textView.setText(nearByBean.communicationType);
            textView.setVisibility(0);
        }
    }

    public final void q() {
        this.itemView.setOnClickListener(this);
        this.itemView.findViewById(R$id.iv_qf_avatar).setOnClickListener(this);
        ((LayoutQualityFriendshipItemBinding) this.d).f16225a.setOnClickListener(this);
        ((LayoutQualityFriendshipItemBinding) this.d).c.setOnClickListener(this);
    }

    @BindingAdapter({"qfAge"})
    public void r(LeftDrawableText leftDrawableText, int i) {
        if (leftDrawableText != null) {
            leftDrawableText.setText(i > 0 ? String.valueOf(i) : "");
        }
    }

    @BindingAdapter({"qfAvatar"})
    public void s(ImageView imageView, String str) {
        kc2<Drawable> kc2VarLoad = hc2.a(this.itemView.getContext()).load(k86.p(str));
        int i = R$drawable.default_portrait;
        kc2VarLoad.placeholder(i).error(i).transform(new RoundedCornersTransformation(a46.b(this.itemView.getContext(), 6.0f), 0)).into(imageView);
    }

    @BindingAdapter({"qfDistance"})
    public void t(TextView textView, NearByBean nearByBean) {
        if (nearByBean == null) {
            textView.setVisibility(8);
            return;
        }
        long j = nearByBean.distance;
        boolean z = nearByBean.sameCity;
        if (j < 0) {
            textView.setVisibility(8);
            return;
        }
        double dFloor = j / 1000.0f;
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
        if (z) {
            textView.setText(textView.getContext().getString(R$string.same_city) + "·" + str + "km");
        } else {
            textView.setText(str + "km");
        }
        textView.setVisibility(0);
    }

    @BindingAdapter({"qfSignature"})
    public void u(TextView textView, NearByBean nearByBean) {
        NearByBean.Extra extra;
        if (textView == null || nearByBean == null || (extra = nearByBean.extra) == null) {
            return;
        }
        textView.setText(extra == null ? "" : extra.desc);
    }

    @BindingAdapter({"qfTag"})
    public void v(FlowLayout flowLayout, NearByBean nearByBean) {
        List<String> list;
        try {
            ((LayoutQualityFriendshipItemBinding) this.d).f.setVisibility(8);
            flowLayout.removeAllViews();
            if (nearByBean == null || (list = nearByBean.tags) == null || list.isEmpty()) {
                ((LayoutQualityFriendshipItemBinding) this.d).f.setVisibility(8);
                return;
            }
            for (int i = 0; i < nearByBean.tags.size(); i++) {
                String strSubstring = nearByBean.tags.get(i);
                if (!TextUtils.isEmpty(strSubstring)) {
                    TextView textView = new TextView(flowLayout.getContext());
                    textView.setTextColor(flowLayout.getContext().getResources().getColor(R$color.square_color_ff222222));
                    textView.setTextSize(1, 10.0f);
                    textView.setGravity(17);
                    textView.setBackgroundResource(R$drawable.bg_quality_friendship_tag);
                    textView.setPadding(a46.b(flowLayout.getContext(), 4.0f), 0, a46.b(flowLayout.getContext(), 4.0f), 0);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a46.b(flowLayout.getContext(), 16.0f));
                    if (i > 0) {
                        layoutParams.leftMargin = a46.b(flowLayout.getContext(), 6.0f);
                    }
                    if (strSubstring.startsWith("jobCode_")) {
                        strSubstring = hs1.e().h(Integer.parseInt(strSubstring.substring(8)));
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    } else if (strSubstring.startsWith("operation_")) {
                        strSubstring = strSubstring.substring(10);
                        textView.setCompoundDrawablesWithIntrinsicBounds(R$drawable.ic_qf_sharp, 0, 0, 0);
                    } else {
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (!TextUtils.isEmpty(strSubstring)) {
                        textView.setText(strSubstring);
                        flowLayout.addView(textView, layoutParams);
                    }
                }
            }
            ((LayoutQualityFriendshipItemBinding) this.d).f.setVisibility(0);
        } catch (Exception e) {
            e.printStackTrace();
            ((LayoutQualityFriendshipItemBinding) this.d).f.setVisibility(8);
        }
    }

    @BindingAdapter({"setBtnSayHiText"})
    public void w(LeftDrawableText leftDrawableText, NearByBean nearByBean) {
        leftDrawableText.setText(ai5.k().g().getUserHomeChatText(leftDrawableText.getContext()));
    }
}
