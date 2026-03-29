package com.zenmen.square.mvp.holder;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.databinding.LayoutNestTagHeaderViewBinding;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.tag.bean.SquareTagBean;
import com.zenmen.square.ui.widget.NestTagInfoView;
import defpackage.ai5;
import defpackage.bj5;
import defpackage.gr2;
import defpackage.je1;
import defpackage.qj5;
import defpackage.z66;
import defpackage.zt1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NestTagHeaderViewHolder extends BaseViewHolder<SquareFeed, LayoutNestTagHeaderViewBinding, zt1> implements View.OnClickListener {
    public static je1 f;
    public static je1 g;

    static {
        je1.a aVarQ = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565);
        ImageScaleType imageScaleType = ImageScaleType.IN_SAMPLE_POWER_OF_2;
        f = aVarQ.w(imageScaleType).r();
        je1.a aVarQ2 = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565);
        int i = R$drawable.default_portrait;
        g = aVarQ2.B(i).A(i).w(imageScaleType).z(i).r();
    }

    public NestTagHeaderViewHolder(View view, int i) {
        super(view);
    }

    @BindingAdapter({"setAge"})
    public static void r(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
            return;
        }
        textView.setText(str + "岁");
    }

    @BindingAdapter({"setHeaderAvatar"})
    public static void s(EffectiveShapeView effectiveShapeView, ContactInfoItem contactInfoItem) {
        gr2.j().h(z66.b(contactInfoItem), effectiveShapeView, g);
        effectiveShapeView.setBorderColor(Color.parseColor("#ffffff"));
    }

    @BindingAdapter({"setHeaderDistict"})
    public static void t(TextView textView, ContactInfoItem contactInfoItem) {
        String strX = bj5.b().a().x(textView.getContext(), contactInfoItem.getCountry(), contactInfoItem.getProvince(), contactInfoItem.getCity(), false);
        if (TextUtils.isEmpty(strX)) {
            textView.setVisibility(4);
        } else {
            textView.setVisibility(0);
            textView.setText(strX);
        }
    }

    @BindingAdapter({"setHeaderSign"})
    public static void u(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        textView.setText(str);
    }

    @BindingAdapter({"setTagInfo"})
    public static void v(NestTagInfoView nestTagInfoView, SquareTagBean squareTagBean) {
        nestTagInfoView.setSquareTag(squareTagBean);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [DB extends androidx.databinding.ViewDataBinding, androidx.databinding.ViewDataBinding] */
    @Override // com.zenmen.listui.list.BaseViewHolder
    public void m() {
        ?? Inflate = DataBindingUtil.inflate(LayoutInflater.from(this.itemView.getContext()), R$layout.layout_nest_tag_header_view, (ViewGroup) this.itemView, false);
        this.d = Inflate;
        ((ViewGroup) this.itemView).addView(((LayoutNestTagHeaderViewBinding) Inflate).getRoot());
        q();
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void l(SquareFeed squareFeed, int i) {
        ((LayoutNestTagHeaderViewBinding) this.d).p(squareFeed);
        ((LayoutNestTagHeaderViewBinding) this.d).executePendingBindings();
        if (((LayoutNestTagHeaderViewBinding) this.d).o() == null || ((LayoutNestTagHeaderViewBinding) this.d).o().contactInfoItem == null) {
            return;
        }
        if (((LayoutNestTagHeaderViewBinding) this.d).o().contactInfoItem.getIsStranger()) {
            ((LayoutNestTagHeaderViewBinding) this.d).b.setText(ai5.k().g().getUserHomeChatText(((LayoutNestTagHeaderViewBinding) this.d).b.getContext()));
        } else {
            ((LayoutNestTagHeaderViewBinding) this.d).b.setText(R$string.square_btn_go_normal_chat);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ContactInfoItem contactInfoItem = ((LayoutNestTagHeaderViewBinding) this.d).o().contactInfoItem;
        DB db = this.d;
        if (view == ((LayoutNestTagHeaderViewBinding) db).f) {
            bj5.b().a().O(view.getContext(), contactInfoItem);
        } else if (view == ((LayoutNestTagHeaderViewBinding) db).b) {
            qj5.T(contactInfoItem.getExid(), !contactInfoItem.getIsStranger() ? 1 : 0);
            ((zt1) this.e).F(contactInfoItem, ((LayoutNestTagHeaderViewBinding) this.d).o());
        }
    }

    public LayoutNestTagHeaderViewBinding p() {
        return (LayoutNestTagHeaderViewBinding) this.d;
    }

    public final void q() {
        ((LayoutNestTagHeaderViewBinding) this.d).f.setOnClickListener(this);
        ((LayoutNestTagHeaderViewBinding) this.d).b.setOnClickListener(this);
    }
}
