package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import java.util.ArrayList;
import java.util.List;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class os3 extends BaseAdapter implements fg1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f19860a;
    public List<MediaItem> b = new ArrayList();
    public List<MediaItem> c;
    public MediaItem d;
    public d e;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(new Rect(0, 0, view.getWidth(), view.getHeight()), a46.b(os3.this.f19860a, 4.0f));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f19862a;
        public final /* synthetic */ int b;

        public b(e eVar, int i) {
            this.f19862a = eVar;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            os3.this.m(this.f19862a.b.getContext(), this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f19863a;

        public c(int i) {
            this.f19863a = i;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            os3 os3Var = os3.this;
            os3Var.i((MediaItem) os3Var.b.get(this.f19863a));
            if (os3.this.e != null) {
                os3.this.e.a(this.f19863a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f19864a;
        public ImageView b;
        public ImageView c;
    }

    public os3(Context context, List<MediaItem> list) {
        this.f19860a = context;
        MediaItem mediaItem = new MediaItem();
        this.d = mediaItem;
        mediaItem.mimeType = 10;
        this.c = list;
        if (list != null) {
            this.b.addAll(list);
            if ((this.b.size() <= 0 || this.b.get(0).mimeType != 1) && list.size() < 9) {
                this.b.add(this.d);
            }
        }
    }

    public static int j(MediaItem mediaItem) {
        int i = a46.m(com.zenmen.palmchat.c.b()).x;
        if ((mediaItem.width == 0 || mediaItem.height == 0) && !TextUtils.isEmpty(mediaItem.localThumbPath)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(mediaItem.localThumbPath, options);
            mediaItem.width = options.outWidth;
            mediaItem.height = options.outHeight;
        }
        return mediaItem.width > mediaItem.height ? i / 2 : (i * 2) / 5;
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
        e eVar;
        MediaItem mediaItem = this.b.get(i);
        boolean z = mediaItem.mimeType == 1;
        if (view == null) {
            view = LayoutInflater.from(this.f19860a).inflate(R$layout.item_multi_publish_photo, (ViewGroup) null);
            eVar = new e();
            eVar.f19864a = (ImageView) view.findViewById(R$id.img_photo);
            eVar.b = (ImageView) view.findViewById(R$id.ic_del);
            eVar.c = (ImageView) view.findViewById(R$id.iv_play);
            view.setTag(eVar);
            eVar.f19864a.setOutlineProvider(new a());
            eVar.f19864a.setClipToOutline(true);
        } else {
            eVar = (e) view.getTag();
        }
        if (mediaItem.mimeType == 10) {
            gr2.j().c(eVar.f19864a);
            view.findViewById(R$id.ic_add).setVisibility(0);
            eVar.f19864a.setImageResource(R$drawable.bg_square_friend_msg_text_bg);
            eVar.b.setVisibility(8);
        } else {
            eVar.b.setVisibility(0);
            view.findViewById(R$id.ic_add).setVisibility(8);
            kc2<Bitmap> kc2VarDiskCacheStrategy = hc2.a(this.f19860a).asBitmap().load(k86.p(!z ? mediaItem.fileFullPath : mediaItem.localThumbPath)).diskCacheStrategy(DiskCacheStrategy.NONE);
            int i2 = R$drawable.ic_gallery_background;
            kc2VarDiskCacheStrategy.placeholder(i2).error(i2).transition(BitmapTransitionOptions.withCrossFade()).transform(new MultiTransformation(new CenterCrop(), new RoundedCornersTransformation(4, 0))).into(eVar.f19864a);
        }
        eVar.c.setVisibility(mediaItem.mimeType != 1 ? 8 : 0);
        eVar.b.setOnClickListener(new b(eVar, i));
        ViewGroup.LayoutParams layoutParams = eVar.f19864a.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (z) {
            int iJ = j(mediaItem);
            layoutParams.width = iJ;
            layoutParams.height = mediaItem.width > mediaItem.height ? (iJ * 3) / 4 : (iJ * 4) / 3;
        } else {
            layoutParams.width = me1.b(this.f19860a, 92);
            int iB = me1.b(this.f19860a, 92);
            layoutParams.height = iB;
            if (layoutParams2 != null) {
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = iB;
            }
        }
        eVar.f19864a.requestLayout();
        return view;
    }

    public final void i(MediaItem mediaItem) {
        this.c.remove(mediaItem);
        this.b.remove(mediaItem);
        if (this.b.size() < 9 && !this.b.contains(this.d)) {
            this.b.add(this.d);
        }
        notifyDataSetChanged();
    }

    public void l(d dVar) {
        this.e = dVar;
    }

    public final void m(Context context, int i) {
        new sd3(context).k(this.b.get(i).mimeType == 1 ? "要删除这个视频吗？" : "要删除这张照片吗？").n(GravityEnum.CENTER).P("删除").M(Color.parseColor("#FF463C")).L("取消").f(new c(i)).e().show();
    }
}
