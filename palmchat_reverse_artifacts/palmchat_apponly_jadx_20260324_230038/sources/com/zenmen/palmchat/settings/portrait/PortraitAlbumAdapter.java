package com.zenmen.palmchat.settings.portrait;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import defpackage.a46;
import defpackage.fg1;
import defpackage.hc2;
import defpackage.k86;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class PortraitAlbumAdapter extends BaseAdapter implements fg1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f15320a;
    public List<Item> c;
    public b f;
    public List<Item> b = new ArrayList();
    public String[] d = {"我最好看的照片", "我的旅行照片", "最近吃的美食", "我的有趣自拍", "我的日常生活", "独一无二的才艺"};
    public String[] e = {"人气+15%", "人气+8%", "人气+10%", "人气+15%", "人气+8%", "人气+5%"};

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class Item {
        public MediaItem mediaItem;
        public ContactInfoItem.Portrait portrait;
        public boolean selected = false;
        public boolean isAdd = false;
        public String addItemString = "";
        public String addItemStringPersent = "";
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15321a;

        public a(int i) {
            this.f15321a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PortraitAlbumAdapter.this.e(this.f15321a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void onSelect(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f15322a;
        public TextView b;
        public View c;
        public TextView d;
        public TextView e;
    }

    public PortraitAlbumAdapter(Context context, List<Item> list) {
        this.c = new ArrayList();
        this.f15320a = context;
        if (list != null) {
            this.c = list;
            this.b.addAll(list);
            while (this.b.size() < 6) {
                Item item = new Item();
                item.isAdd = true;
                item.addItemString = this.d[this.b.size()];
                item.addItemStringPersent = this.e[this.b.size()];
                this.b.add(item);
            }
        }
    }

    @Override // defpackage.fg1
    public void a(int i, int i2) {
        if (i2 < this.b.size()) {
            this.b.add(i2, this.b.remove(i));
            notifyDataSetChanged();
            this.c.clear();
            for (Item item : this.b) {
                if (!item.isAdd) {
                    this.c.add(item);
                }
            }
        }
    }

    @Override // defpackage.fg1
    public int b() {
        for (int i = 0; i < this.b.size(); i++) {
            if (this.b.get(i).isAdd) {
                return i;
            }
        }
        return -1;
    }

    public List<Item> c() {
        return this.c;
    }

    public void e(int i) {
        int i2 = 0;
        while (i2 < this.b.size()) {
            this.b.get(i2).selected = i2 == i;
            i2++;
        }
        b bVar = this.f;
        if (bVar != null) {
            bVar.onSelect(i);
        }
        notifyDataSetChanged();
    }

    public void f(b bVar) {
        this.f = bVar;
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
        String str;
        Item item = this.b.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.f15320a).inflate(R.layout.item_portrait_album, (ViewGroup) null);
            cVar = new c();
            cVar.f15322a = (ImageView) view.findViewById(R.id.img_photo);
            cVar.c = view.findViewById(R.id.ic_add_layout);
            cVar.d = (TextView) view.findViewById(R.id.ic_add_name);
            cVar.e = (TextView) view.findViewById(R.id.ic_add_name_persent);
            cVar.b = (TextView) view.findViewById(R.id.select);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        if (item.isAdd) {
            cVar.c.setVisibility(0);
            cVar.f15322a.setVisibility(8);
            cVar.b.setVisibility(8);
            cVar.d.setText(item.addItemString);
            cVar.e.setText(item.addItemStringPersent);
        } else {
            cVar.c.setVisibility(8);
            cVar.f15322a.setVisibility(0);
            cVar.b.setVisibility(0);
            if (item.selected) {
                cVar.b.setCompoundDrawablesWithIntrinsicBounds(R.drawable.portrait_album_share_selected, 0, 0, 0);
            } else {
                cVar.b.setCompoundDrawablesWithIntrinsicBounds(R.drawable.portrait_album_share_unselected_white, 0, 0, 0);
            }
            MediaItem mediaItem = item.mediaItem;
            if (mediaItem != null) {
                str = mediaItem.fileFullPath;
            } else {
                ContactInfoItem.Portrait portrait = item.portrait;
                if (portrait != null) {
                    String str2 = portrait.headIcon;
                    str = TextUtils.isEmpty(str2) ? item.portrait.headImg : str2;
                } else {
                    str = "";
                }
            }
            hc2.a(this.f15320a).asBitmap().load(a46.h(cVar.f15322a, k86.p(str))).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(R.drawable.default_portrait).error(R.drawable.default_portrait).into(cVar.f15322a);
        }
        cVar.b.setOnClickListener(new a(i));
        return view;
    }
}
