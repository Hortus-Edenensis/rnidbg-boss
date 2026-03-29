package com.zenmen.square.fragment.online;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.square.R$id;
import defpackage.z64;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OnLineItemBaseHolder extends RecyclerView.ViewHolder {
    public OnLineItemData d;
    public Context e;
    public Activity f;
    public ImageView g;
    public ImageView h;
    public TextView i;
    public View j;

    public OnLineItemBaseHolder(@NonNull View view, Activity activity) {
        super(view);
        this.e = view.getContext();
        this.f = activity;
        this.g = (ImageView) view.findViewById(R$id.portrait_icon);
        this.h = (ImageView) view.findViewById(R$id.online_status_show_msg_img);
        this.i = (TextView) view.findViewById(R$id.online_status_show_msg_text);
        View viewFindViewById = view.findViewById(R$id.online_status_item_root);
        this.j = viewFindViewById;
        viewFindViewById.addOnAttachStateChangeListener(new a());
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NonNull View view) {
            OnLineItemData onLineItemData = OnLineItemBaseHolder.this.d;
            if (onLineItemData == null || onLineItemData.hasShowEvent) {
                return;
            }
            onLineItemData.hasShowEvent = true;
            z64.p(onLineItemData.id, onLineItemData.content);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NonNull View view) {
        }
    }
}
