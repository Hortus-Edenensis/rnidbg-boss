package com.zenmen.imageeditengine;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.imageeditengine.views.imagezoom.ImageViewTouch;
import com.zenmen.imageeditengine.views.imagezoom.ImageViewTouchBase;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class PhotoEditorFragment extends BaseFragment implements View.OnClickListener {
    public ImageViewTouch d;
    public ImageView e;
    public View f;
    public TextView g;
    public TextView h;
    public boolean i = false;
    public Bitmap j;
    public Bitmap k;
    public Bitmap l;
    public b m;
    public int n;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11821a;
        public final /* synthetic */ String b;

        public a(String str, String str2) {
            this.f11821a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmapCreateScaledBitmap;
            Bitmap bitmap = null;
            if (PhotoEditorFragment.this.l != null && !PhotoEditorFragment.this.l.isRecycled()) {
                PhotoEditorFragment.this.l.recycle();
                PhotoEditorFragment.this.l = null;
            }
            if (PhotoEditorFragment.this.k != null && !PhotoEditorFragment.this.l.isRecycled()) {
                PhotoEditorFragment.this.k.recycle();
                PhotoEditorFragment.this.k = null;
            }
            PhotoEditorFragment.this.k = BitmapFactory.decodeFile(this.f11821a);
            File file = this.b == null ? null : new File(this.b);
            if (file == null || !file.exists()) {
                PhotoEditorFragment.this.l = BitmapFactory.decodeFile(this.f11821a);
            } else {
                PhotoEditorFragment.this.l = BitmapFactory.decodeFile(this.b);
            }
            if (PhotoEditorFragment.this.l == null) {
                return;
            }
            int width = PhotoEditorFragment.this.l.getWidth();
            int height = PhotoEditorFragment.this.l.getHeight();
            Log.e("rxx", "load image " + this.f11821a);
            int width2 = PhotoEditorFragment.this.d.getWidth();
            int iFloor = (int) Math.floor(((double) height) * (((double) width2) / ((double) width)));
            Log.e("rxx", "bit map :" + width + "x" + height + " ivWidth :" + width2 + " newHeight:" + iFloor);
            PhotoEditorFragment.this.O(null);
            try {
                if (height / width > 16 || iFloor > 5000) {
                    int height2 = PhotoEditorFragment.this.d.getHeight();
                    int i = (width * height2) / height;
                    if (i == 0) {
                        i = 1;
                    }
                    bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(PhotoEditorFragment.this.l, i, height2, true);
                } else {
                    bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(PhotoEditorFragment.this.l, width2, iFloor, true);
                }
                bitmap = bitmapCreateScaledBitmap;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            PhotoEditorFragment.this.l = bitmap;
            PhotoEditorFragment photoEditorFragment = PhotoEditorFragment.this;
            photoEditorFragment.j = photoEditorFragment.l;
            PhotoEditorFragment photoEditorFragment2 = PhotoEditorFragment.this;
            photoEditorFragment2.O(photoEditorFragment2.l);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void f1(Bitmap bitmap);

        void n1(Bitmap bitmap);

        void s0(Bitmap bitmap);
    }

    public static PhotoEditorFragment L(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("EXTRA_IMAGE_PATH", str);
        bundle.putString("EXTRA_EDITED_PATH", str2);
        PhotoEditorFragment photoEditorFragment = new PhotoEditorFragment();
        photoEditorFragment.setArguments(bundle);
        return photoEditorFragment;
    }

    @Override // com.zenmen.imageeditengine.BaseFragment
    public void D(View view) {
        this.d = (ImageViewTouch) view.findViewById(R$id.image_iv);
        this.e = (ImageView) view.findViewById(R$id.crop_btn);
        this.f = view.findViewById(R$id.toolbar_layout);
        int i = R$id.send_btn;
        this.g = (TextView) view.findViewById(i);
        this.h = (TextView) view.findViewById(R$id.done_btn);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (getActivity() != null) {
                this.d.post(new a(arguments.getString("EXTRA_IMAGE_PATH"), arguments.getString("EXTRA_EDITED_PATH")));
            }
            Intent intent = getActivity().getIntent();
            E(this.e, intent.getBooleanExtra("EXTRA_IS_CROP_MODE", true));
            E(view.findViewById(i), intent.getBooleanExtra("EXTRA_SHOW_SEND_BUTTON", false));
            this.e.setOnClickListener(this);
            this.g.setOnClickListener(this);
            this.h.setOnClickListener(this);
            view.findViewById(R$id.back_iv).setOnClickListener(this);
            this.d.setScaleEnabled(true);
            this.d.setDoubleTapEnabled(true);
            this.d.setDisplayType(ImageViewTouchBase.DisplayType.FIT_IF_BIGGER);
        }
    }

    public void O(Bitmap bitmap) {
        this.j = bitmap;
        this.d.setImageBitmap(bitmap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof b) {
            this.m = (b) activity;
            return;
        }
        throw new RuntimeException(activity.toString() + " must implement OnFragmentInteractionListener");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        Bitmap bitmap = this.k;
        if (bitmap == null) {
            return;
        }
        if (id == R$id.crop_btn) {
            this.m.n1(bitmap);
        } else if (id == R$id.back_iv) {
            getActivity().onBackPressed();
        } else if (id == R$id.send_btn) {
            this.m.f1(this.j);
        } else if (id == R$id.done_btn) {
            this.m.s0(this.j);
        }
        if (this.n != 0) {
            this.d.animate().scaleX(1.0f);
            this.d.animate().scaleY(1.0f);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_photo_editor, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.m = null;
    }

    public void M() {
    }
}
