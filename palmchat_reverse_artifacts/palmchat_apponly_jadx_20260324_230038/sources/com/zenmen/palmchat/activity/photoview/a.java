package com.zenmen.palmchat.activity.photoview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.k86;
import java.util.ConcurrentModificationException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12362a;
    public b b;
    public LinearLayout c;
    public View d;

    /* JADX INFO: renamed from: com.zenmen.palmchat.activity.photoview.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ViewOnClickListenerC0959a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f12363a;

        public ViewOnClickListenerC0959a(View view) {
            this.f12363a = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.b != null) {
                int i = 0;
                for (int i2 = 0; i2 < a.this.c.getChildCount(); i2++) {
                    View childAt = a.this.c.getChildAt(i2);
                    EffectiveShapeView effectiveShapeView = (EffectiveShapeView) childAt.findViewById(R.id.image_item);
                    a.this.d = childAt.findViewById(R.id.root);
                    a.this.d.setBackgroundColor(0);
                    effectiveShapeView.changeShapeType(3);
                    if (childAt.equals(view)) {
                        i = i2;
                    }
                }
                EffectiveShapeView effectiveShapeView2 = (EffectiveShapeView) this.f12363a.findViewById(R.id.image_item);
                a.this.d = this.f12363a.findViewById(R.id.root);
                a.this.d.setBackgroundResource(R.drawable.ic_picture_preview_border);
                effectiveShapeView2.changeShapeType(3);
                try {
                    a.this.b.J((c) view.getTag(), view, i, a.this.c.getChildCount());
                } catch (ConcurrentModificationException unused) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void J(c cVar, View view, int i, int i2);

        void V0(View view, int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MediaItem f12364a;
        public String b;

        public c(MediaItem mediaItem) {
            this.f12364a = mediaItem;
        }
    }

    public a(Context context, b bVar, LinearLayout linearLayout) {
        this.f12362a = context;
        this.b = bVar;
        this.c = linearLayout;
    }

    public void e(c cVar) {
        MediaItem mediaItem;
        for (int i = 0; i < this.c.getChildCount(); i++) {
            View childAt = this.c.getChildAt(i);
            c cVar2 = (c) childAt.getTag();
            if (cVar2 != null && (mediaItem = cVar2.f12364a) != null && mediaItem.fileFullPath.equals(cVar.f12364a.fileFullPath)) {
                EffectiveShapeView effectiveShapeView = (EffectiveShapeView) childAt.findViewById(R.id.image_item);
                this.d = childAt.findViewById(R.id.root);
                effectiveShapeView.changeShapeType(3);
                if (cVar.b == null) {
                    this.d.setBackgroundColor(0);
                    return;
                }
                f(cVar, effectiveShapeView);
                childAt.setTag(cVar);
                this.d.setBackgroundResource(R.drawable.ic_picture_preview_border);
                return;
            }
        }
        View viewInflate = LayoutInflater.from(this.f12362a).inflate(R.layout.photo_view_scroll_item, (ViewGroup) null, false);
        EffectiveShapeView effectiveShapeView2 = (EffectiveShapeView) viewInflate.findViewById(R.id.image_item);
        this.d = viewInflate.findViewById(R.id.root);
        viewInflate.setTag(cVar);
        this.c.addView(viewInflate);
        effectiveShapeView2.changeShapeType(3);
        f(cVar, effectiveShapeView2);
        viewInflate.setOnClickListener(new ViewOnClickListenerC0959a(viewInflate));
    }

    public void f(c cVar, ImageView imageView) {
        MediaItem mediaItem = cVar.f12364a;
        String strY2 = PhotoViewActivity.Y2(mediaItem.fileFullPath, mediaItem.localPath);
        boolean zJ = k86.J(strY2);
        String str = mediaItem.editedImagePath;
        if (str != null) {
            strY2 = str;
        }
        String str2 = cVar.b;
        if (str2 != null) {
            strY2 = str2;
        }
        gr2.j().i(k86.p(strY2), imageView, bq6.h(!zJ), null);
    }

    public void g(c cVar) {
        MediaItem mediaItem;
        for (int i = 0; i < this.c.getChildCount(); i++) {
            View childAt = this.c.getChildAt(i);
            c cVar2 = (c) childAt.getTag();
            if (cVar2 != null && (mediaItem = cVar2.f12364a) != null && mediaItem.fileFullPath.equals(cVar.f12364a.fileFullPath)) {
                this.c.removeView(childAt);
            }
        }
    }

    public void h(int i) {
        for (int i2 = 0; i2 < this.c.getChildCount(); i2++) {
            View childAt = this.c.getChildAt(i2);
            EffectiveShapeView effectiveShapeView = (EffectiveShapeView) childAt.findViewById(R.id.image_item);
            this.d = childAt.findViewById(R.id.root);
            effectiveShapeView.changeShapeType(3);
            this.d.setBackgroundColor(0);
            if (i2 == i) {
                this.d.setBackgroundResource(R.drawable.ic_picture_preview_border);
                b bVar = this.b;
                if (bVar != null) {
                    bVar.V0(childAt, i);
                }
            }
        }
    }

    public void i(MediaItem mediaItem) {
        if (mediaItem == null || mediaItem.fileFullPath == null) {
            return;
        }
        for (int i = 0; i < this.c.getChildCount(); i++) {
            View childAt = this.c.getChildAt(i);
            c cVar = (c) childAt.getTag();
            EffectiveShapeView effectiveShapeView = (EffectiveShapeView) childAt.findViewById(R.id.image_item);
            this.d = childAt.findViewById(R.id.root);
            effectiveShapeView.changeShapeType(3);
            this.d.setBackgroundColor(0);
            if (cVar.f12364a.fileFullPath.equals(mediaItem.fileFullPath)) {
                this.d.setBackgroundResource(R.drawable.ic_picture_preview_border);
                b bVar = this.b;
                if (bVar != null) {
                    bVar.V0(childAt, i);
                }
            }
        }
    }
}
