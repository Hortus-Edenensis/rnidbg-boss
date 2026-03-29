package com.zenmen.palmchat.chat;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.huawei.openalliance.ad.constant.bh;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.h;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import defpackage.hc2;
import defpackage.je1;
import defpackage.k86;
import defpackage.rk3;
import defpackage.sd3;
import defpackage.sk3;
import defpackage.sy5;
import defpackage.u92;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class e extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f12760a;
    public ArrayList<MediaItem> b;
    public ArrayList<MediaItem> c;
    public String d;
    public LayoutInflater e;
    public sk3 g;
    public int h;
    public int i;
    public int j;
    public boolean l;
    public String m;
    public int n;
    public int o;
    public boolean p;
    public long q;
    public long r;
    public ArrayList<MediaItem> k = new ArrayList<>();
    public je1 f = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).B(R.drawable.media_pick_grid_item_background).A(R.drawable.media_pick_grid_item_background).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int size = e.this.k.size();
            e eVar = e.this;
            if (size >= eVar.h) {
                sy5.f(e.this.f12760a, eVar.f12760a.getResources().getString(R.string.media_pick_reach_limit, Integer.valueOf(e.this.h)), 1).g();
            } else {
                eVar.g.r0();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaItem f12762a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements h.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ rk3 f12763a;

            public a(rk3 rk3Var) {
                this.f12763a = rk3Var;
            }

            @Override // com.zenmen.palmchat.chat.h.f
            public void a(int i) {
                if (i == 0) {
                    e.this.g.h1(e.this.getItem(this.f12763a.g));
                } else if (i == -3) {
                    new sd3(e.this.f12760a).k("不能分享小于5秒的视频").O(R.string.alert_dialog_ok).e().show();
                } else {
                    e.this.g.Z(i);
                }
            }
        }

        /* JADX INFO: renamed from: com.zenmen.palmchat.chat.e$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0979b implements h.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ rk3 f12764a;

            public C0979b(rk3 rk3Var) {
                this.f12764a = rk3Var;
            }

            @Override // com.zenmen.palmchat.chat.h.f
            public void a(int i) {
                if (i != 0) {
                    e.this.g.Z(i);
                } else {
                    e.this.g.h1(e.this.getItem(this.f12764a.g));
                }
            }
        }

        public b(MediaItem mediaItem) {
            this.f12762a = mediaItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.j != 0) {
                e.this.g.i1(this.f12762a);
                return;
            }
            rk3 rk3Var = (rk3) view.getTag();
            if (rk3Var != null) {
                if (e.this.getItem(rk3Var.g) == null || e.this.getItem(rk3Var.g).mimeType != 1 || !"from_moment".equals(e.this.m)) {
                    int iA = u92.a(this.f12762a);
                    if (iA == 0 || !"from_chat".equals(e.this.m)) {
                        e.this.g.h1(e.this.getItem(rk3Var.g));
                        return;
                    } else {
                        e.this.g.I0(iA);
                        return;
                    }
                }
                if (e.this.k.size() != 0) {
                    sy5.e(e.this.f12760a, R.string.can_not_pick_video, 0).g();
                } else if (e.this.p) {
                    h.b((Activity) e.this.f12760a, this.f12762a, e.this.q, e.this.r, new a(rk3Var));
                } else {
                    h.c((Activity) e.this.f12760a, this.f12762a, new C0979b(rk3Var));
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaItem f12765a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements h.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ rk3 f12766a;

            public a(rk3 rk3Var) {
                this.f12766a = rk3Var;
            }

            @Override // com.zenmen.palmchat.chat.h.f
            public void a(int i) {
                if (i != 0) {
                    e.this.g.Z(i);
                } else {
                    int iA = u92.a(c.this.f12765a);
                    if (iA == 0 || !"from_chat".equals(e.this.m)) {
                        this.f12766a.e.setBackgroundColor(e.this.o);
                        if ("from_moment".equals(e.this.m)) {
                            this.f12766a.f20497a.setImageResource(R.drawable.ic_album_select_chose);
                        } else {
                            this.f12766a.f20497a.setImageResource(R.drawable.ic_album_select_chose);
                        }
                        c cVar = c.this;
                        e.this.t(cVar.f12765a, true);
                    } else {
                        e.this.g.I0(iA);
                    }
                }
                e.this.g.i1(c.this.f12765a);
            }
        }

        public c(MediaItem mediaItem) {
            this.f12765a = mediaItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            rk3 rk3Var = (rk3) ((View) view.getParent()).getTag();
            if (rk3Var == null || e.this.getItem(rk3Var.g) == null) {
                return;
            }
            if (e.this.getItem(rk3Var.g).mimeType == 1 && "from_moment".equals(e.this.m)) {
                return;
            }
            if (e.this.j == 0) {
                if (e.this.q(this.f12765a) != -1) {
                    rk3Var.e.setBackgroundColor(e.this.n);
                    if ("from_moment".equals(e.this.m)) {
                        rk3Var.f20497a.setImageResource(R.drawable.icon_white_uncheck);
                    } else {
                        rk3Var.f20497a.setImageResource(R.drawable.icon_white_uncheck);
                    }
                    e.this.t(this.f12765a, false);
                } else {
                    int size = e.this.k.size();
                    e eVar = e.this;
                    if (size >= eVar.h) {
                        sy5.f(e.this.f12760a, eVar.f12760a.getResources().getString(R.string.media_pick_reach_limit, Integer.valueOf(e.this.h)), 1).g();
                    } else {
                        h.c((Activity) eVar.f12760a, this.f12765a, new a(rk3Var));
                    }
                }
            }
            e.this.g.i1(this.f12765a);
        }
    }

    public e(Context context, sk3 sk3Var, int i, int i2, String str, boolean z, long j, long j2) {
        this.h = 9;
        this.i = 0;
        this.l = true;
        this.m = "";
        this.n = 0;
        this.o = 0;
        this.p = false;
        this.f12760a = context;
        this.e = LayoutInflater.from(context);
        this.j = i;
        this.g = sk3Var;
        this.h = i2;
        if (i2 < 9) {
            this.l = false;
        }
        this.m = str;
        if (i == 1) {
            this.i = 1;
        } else {
            this.i = 0;
            if ("from_moment".equals(str)) {
                this.i = 1;
            }
        }
        this.p = z;
        this.q = j;
        this.r = j2;
        this.n = this.f12760a.getResources().getColor(R.color.media_pick_bg_normal);
        this.o = this.f12760a.getResources().getColor(R.color.media_pick_bg_select);
    }

    public static String r(int i) {
        int i2 = i / 1000;
        int i3 = i2 / 3600;
        int i4 = (i2 % 3600) / 60;
        int i5 = i2 % 60;
        String strValueOf = String.valueOf(i3);
        if (i3 < 10) {
            strValueOf = "0" + strValueOf;
        }
        String strValueOf2 = String.valueOf(i4);
        if (i4 < 10) {
            strValueOf2 = "0" + strValueOf2;
        }
        String strValueOf3 = String.valueOf(i5);
        if (i5 < 10) {
            strValueOf3 = "0" + strValueOf3;
        }
        if (i3 == 0) {
            return strValueOf2 + ":" + strValueOf3;
        }
        return strValueOf + ":" + strValueOf2 + ":" + strValueOf3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MediaItem> arrayList = this.b;
        if (arrayList == null) {
            return this.i;
        }
        ArrayList<MediaItem> arrayList2 = this.c;
        return arrayList2 == null ? arrayList.size() + this.i : arrayList2.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        rk3 rk3Var;
        if (view == null) {
            view = "from_moment".equals(this.m) ? this.e.inflate(R.layout.grid_item_media_pick_b, (ViewGroup) null, false) : this.e.inflate(R.layout.grid_item_media_pick, (ViewGroup) null, false);
        }
        if (view.getTag() == null) {
            rk3Var = new rk3();
            rk3Var.f20497a = (ImageView) view.findViewById(R.id.check_image);
            rk3Var.e = view.findViewById(R.id.global_background);
            rk3Var.b = (MediaPickSquareImageView) view.findViewById(R.id.image);
            rk3Var.c = (LinearLayout) view.findViewById(R.id.ll_camera);
            rk3Var.f = (RelativeLayout) view.findViewById(R.id.check_image_area);
            rk3Var.d = (ImageView) view.findViewById(R.id.file_type_indicator_image);
            rk3Var.h = (TextView) view.findViewById(R.id.video_duration);
            rk3Var.g = i;
            view.setTag(rk3Var);
        } else {
            rk3Var = (rk3) view.getTag();
            rk3Var.g = i;
            view.setTag(rk3Var);
        }
        MediaItem item = getItem(i);
        if (this.c == null && i <= this.i - 1) {
            hc2.a(this.f12760a).clear(rk3Var.b);
            rk3Var.b.setVisibility(8);
            rk3Var.c.setVisibility(0);
            view.setOnClickListener(new a());
            rk3Var.e.setBackgroundColor(this.n);
            rk3Var.f20497a.setVisibility(8);
            rk3Var.b.setScaleType(ImageView.ScaleType.CENTER);
            rk3Var.h.setVisibility(8);
            rk3Var.d.setVisibility(8);
            return view;
        }
        rk3Var.b.setVisibility(0);
        rk3Var.c.setVisibility(8);
        rk3Var.b.setBackground(null);
        int i2 = item.mimeType;
        if (i2 == 0) {
            if (item.fileFullPath.toLowerCase().endsWith(bh.V) && "from_chat".equals(this.m)) {
                rk3Var.d.setVisibility(0);
                rk3Var.d.setImageResource(R.drawable.ic_gif);
            } else {
                rk3Var.d.setVisibility(8);
            }
            rk3Var.h.setVisibility(8);
            rk3Var.f20497a.setVisibility(0);
            rk3Var.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            hc2.a(this.f12760a).load(k86.p(item.fileFullPath)).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(R.drawable.media_pick_grid_item_background).error(R.drawable.media_pick_grid_item_background).transition(DrawableTransitionOptions.withCrossFade()).into(rk3Var.b);
        } else if (i2 == 1) {
            rk3Var.d.setVisibility(0);
            rk3Var.d.setImageResource(R.drawable.ic_video);
            rk3Var.h.setVisibility(0);
            rk3Var.h.setText(r(new Long(item.playLength).intValue()));
            if ("from_moment".equals(this.m)) {
                rk3Var.f20497a.setVisibility(8);
            } else {
                rk3Var.f20497a.setVisibility(0);
            }
            rk3Var.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            hc2.a(this.f12760a).load(k86.p(item.localThumbPath)).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(R.drawable.media_pick_grid_item_background).error(R.drawable.media_pick_grid_item_background).transition(DrawableTransitionOptions.withCrossFade()).into(rk3Var.b);
        }
        view.setOnClickListener(new b(item));
        rk3Var.f.setOnClickListener(new c(item));
        if (getItem(rk3Var.g).mimeType == 1 && "from_moment".equals(this.m)) {
            return view;
        }
        int i3 = this.j;
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4) {
            rk3Var.e.setBackgroundColor(this.n);
            rk3Var.f20497a.setVisibility(8);
        } else if (i3 == 0) {
            rk3Var.e.setBackgroundColor(this.n);
            rk3Var.f20497a.setVisibility(0);
            if (q(item) != -1) {
                rk3Var.e.setBackgroundColor(this.o);
                if ("from_moment".equals(this.m)) {
                    rk3Var.f20497a.setImageResource(R.drawable.ic_album_select_chose);
                } else {
                    rk3Var.f20497a.setImageResource(R.drawable.ic_album_select_chose);
                }
            } else {
                rk3Var.e.setBackgroundColor(this.n);
                if ("from_moment".equals(this.m)) {
                    rk3Var.f20497a.setImageResource(R.drawable.icon_white_uncheck);
                } else {
                    rk3Var.f20497a.setImageResource(R.drawable.icon_white_uncheck);
                }
            }
        }
        return view;
    }

    public String m() {
        return this.d;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public MediaItem getItem(int i) {
        ArrayList<MediaItem> arrayList = this.b;
        if (arrayList == null) {
            return null;
        }
        ArrayList<MediaItem> arrayList2 = this.c;
        if (arrayList2 != null) {
            return arrayList2.get(i);
        }
        if (i >= this.i) {
            int size = arrayList.size();
            int i2 = this.i;
            if (size > i - i2) {
                return this.b.get(i - i2);
            }
        }
        return null;
    }

    public ArrayList<MediaItem> p() {
        ArrayList<MediaItem> arrayList = this.c;
        return arrayList != null ? arrayList : this.b;
    }

    public final int q(MediaItem mediaItem) {
        if (mediaItem != null) {
            for (int i = 0; i < this.k.size(); i++) {
                if (this.k.get(i).fileID == mediaItem.fileID) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void s(String str, ArrayList<MediaItem> arrayList) {
        this.d = str;
        this.c = arrayList;
        notifyDataSetChanged();
    }

    public final void t(MediaItem mediaItem, boolean z) {
        if (mediaItem != null) {
            if (z) {
                this.k.add(mediaItem);
                mediaItem.setSelectTime(System.currentTimeMillis());
            } else {
                int iQ = q(mediaItem);
                if (iQ != -1) {
                    this.k.remove(iQ);
                }
            }
        }
    }

    public void u(ArrayList<MediaItem> arrayList) {
        this.b = arrayList;
        notifyDataSetChanged();
    }
}
