package com.zenmen.palmchat.publish;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.R$layout;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.an;
import defpackage.fg1;
import defpackage.gr2;
import defpackage.hr2;
import defpackage.k86;
import defpackage.me1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a extends BaseAdapter implements fg1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f15058a;
    public List<MediaItem> b = new ArrayList();
    public List<MediaItem> c;
    public MediaItem d;
    public b e;

    /* JADX INFO: renamed from: com.zenmen.palmchat.publish.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ViewOnClickListenerC1097a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaItem f15059a;
        public final /* synthetic */ int b;

        public ViewOnClickListenerC1097a(MediaItem mediaItem, int i) {
            this.f15059a = mediaItem;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f(this.f15059a);
            if (a.this.e != null) {
                a.this.e.a(this.b);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f15060a;
        public ImageView b;
    }

    public a(Context context, List<MediaItem> list) {
        this.f15058a = context;
        MediaItem mediaItem = new MediaItem();
        this.d = mediaItem;
        mediaItem.mimeType = 10;
        this.c = list;
        if (list != null) {
            this.b.addAll(list);
            if (list.size() < 9) {
                this.b.add(this.d);
            }
        }
    }

    @Override // defpackage.fg1
    public void a(int i, int i2) {
        if (i2 < this.b.size()) {
            this.b.add(i2, this.b.remove(i));
            notifyDataSetChanged();
            this.c.clear();
            for (MediaItem mediaItem : this.b) {
                if (mediaItem.mimeType != 10) {
                    this.c.add(mediaItem);
                }
            }
        }
    }

    @Override // defpackage.fg1
    public int b() {
        for (int i = 0; i < this.b.size(); i++) {
            if (this.b.get(i).mimeType == 10) {
                return i;
            }
        }
        return -1;
    }

    public final void f(MediaItem mediaItem) {
        this.c.remove(mediaItem);
        this.b.remove(mediaItem);
        if (this.b.size() < 9 && !this.b.contains(this.d)) {
            this.b.add(this.d);
        }
        notifyDataSetChanged();
    }

    public void g() {
        if (this.b.contains(this.d)) {
            this.b.remove(this.d);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.b.get(i).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        MediaItem mediaItem = this.b.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.f15058a).inflate(R$layout.item_publish_photo_b, (ViewGroup) null);
            cVar = new c();
            EffectiveShapeView effectiveShapeView = (EffectiveShapeView) view.findViewById(R$id.img_photo);
            effectiveShapeView.changeShapeType(3);
            effectiveShapeView.setDegreeForRoundRectangle(me1.a(com.zenmen.palmchat.c.b(), 7.0f), me1.a(com.zenmen.palmchat.c.b(), 7.0f));
            cVar.f15060a = effectiveShapeView;
            ViewGroup.LayoutParams layoutParams = effectiveShapeView.getLayoutParams();
            layoutParams.width = an.b(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR);
            layoutParams.height = an.b(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR);
            cVar.b = (ImageView) view.findViewById(R$id.ic_del);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        if (mediaItem.mimeType == 10) {
            gr2.j().c(cVar.f15060a);
            view.findViewById(R$id.ic_add).setVisibility(0);
            cVar.f15060a.setImageDrawable(new ColorDrawable(Color.parseColor("#F0F0F0")));
            cVar.b.setVisibility(8);
        } else {
            cVar.b.setVisibility(0);
            view.findViewById(R$id.ic_add).setVisibility(8);
            gr2.j().h(k86.p(this.b.get(i).fileFullPath), cVar.f15060a, hr2.i());
        }
        cVar.b.setOnClickListener(new ViewOnClickListenerC1097a(mediaItem, i));
        return view;
    }

    public void h(b bVar) {
        this.e = bVar;
    }
}
