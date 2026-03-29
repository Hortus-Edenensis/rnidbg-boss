package com.zenmen.square.fragment.online;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import defpackage.bj5;
import defpackage.hc2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OnLineItemHolder extends OnLineItemBaseHolder {
    public View k;
    public ImageView l;

    public OnLineItemHolder(@NonNull View view, Activity activity) {
        super(view, activity);
        this.k = view.findViewById(R$id.online_status_show_msg_layout);
        this.l = (ImageView) view.findViewById(R$id.online_sex);
    }

    public void l(OnLineItemData onLineItemData) {
        if (onLineItemData != null) {
            this.d = onLineItemData;
            if (TextUtils.isEmpty(onLineItemData.avatar)) {
                this.g.setImageResource(R$drawable.default_portrait);
            } else {
                hc2.a(this.e).load(this.d.avatar).error(R$drawable.default_portrait).into(this.g);
            }
            OnLineItemData onLineItemData2 = this.d;
            if (onLineItemData2.type == 1) {
                this.h.setImageResource(R$drawable.online_trip_map_tag);
                String strU = bj5.b().a().U(this.d.scheduleTag);
                if (TextUtils.isEmpty(strU)) {
                    this.i.setText("聊聊天");
                } else {
                    this.i.setText(strU);
                }
            } else {
                if (TextUtils.isEmpty(onLineItemData2.url)) {
                    this.h.setImageResource(R$drawable.online_status_msg_bg);
                } else {
                    hc2.a(this.e).load(this.d.url).error(R$drawable.online_status_msg_bg).into(this.h);
                }
                if (TextUtils.isEmpty(this.d.content)) {
                    this.i.setText("来个人陪我聊聊天");
                } else {
                    this.i.setText(this.d.content);
                }
            }
            if (this.d.gender == 1) {
                this.l.setImageResource(R$drawable.icon_sex_female);
            } else {
                this.l.setImageResource(R$drawable.icon_sex_male);
            }
            String str = !TextUtils.isEmpty(this.d.bgColor) ? this.d.bgColor : "#F1F8FF";
            Drawable background = this.k.getBackground();
            if (background instanceof GradientDrawable) {
                try {
                    ((GradientDrawable) background).setColor(Color.parseColor(str));
                } catch (Exception unused) {
                }
            }
        }
    }
}
