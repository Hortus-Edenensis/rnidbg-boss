package com.zenmen.imageeditengine;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zenmen.imageeditengine.views.cropimage.CropImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class CropFragment extends BaseFragment implements View.OnClickListener, CropImageView.e {
    public a d;
    public CropImageView e;
    public TextView f;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void E0(Bitmap bitmap);

        void w(Bitmap bitmap, Rect rect, int i);
    }

    public static CropFragment F(Bitmap bitmap, Rect rect, int i) {
        CropFragment cropFragment = new CropFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("EXTRA_ORIGINAL", bitmap);
        bundle.putParcelable("EXTRA_CROP_RECT", rect);
        bundle.putInt("EXTRA_CROP_ROTATION", i);
        cropFragment.setArguments(bundle);
        return cropFragment;
    }

    @Override // com.zenmen.imageeditengine.BaseFragment
    public void D(View view) {
        Bitmap bitmap;
        this.e = (CropImageView) view.findViewById(R$id.image_iv);
        TextView textView = (TextView) view.findViewById(R$id.cancel_tv);
        this.f = textView;
        textView.setOnClickListener(this);
        this.f.setVisibility(4);
        int i = R$id.send_btn;
        view.findViewById(i).setOnClickListener(this);
        view.findViewById(R$id.rotate_iv).setOnClickListener(this);
        view.findViewById(R$id.done_btn).setOnClickListener(this);
        if (getArguments() != null && (bitmap = (Bitmap) getArguments().getParcelable("EXTRA_ORIGINAL")) != null) {
            this.e.setImageBitmap(bitmap);
            Rect rect = (Rect) getArguments().getParcelable("EXTRA_CROP_RECT");
            if (rect != null) {
                this.e.setCropRect(rect);
            }
            int i2 = getArguments().getInt("EXTRA_CROP_ROTATION", 0);
            this.e.setRotatedDegrees(i2);
            this.e.setMultiTouchEnabled(true);
            this.e.setGuidelines(CropImageView.Guidelines.OFF);
            this.e.setOnCropWindowChangedListener(this);
            if ((rect != null && (rect.width() != 0 || rect.height() != 0)) || i2 != 0) {
                this.f.setVisibility(0);
            }
        }
        E(view.findViewById(i), getActivity().getIntent().getBooleanExtra("EXTRA_SHOW_SEND_BUTTON", false));
    }

    @Override // com.zenmen.imageeditengine.views.cropimage.CropImageView.e
    public void k() {
        this.f.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof a) {
            this.d = (a) activity;
            return;
        }
        throw new RuntimeException(activity.toString() + " must implement OnFragmentInteractionListener");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.rotate_iv) {
            this.e.rotateImage(-90);
            this.f.setVisibility(0);
            return;
        }
        if (view.getId() == R$id.cancel_tv) {
            this.e.resetCropRect();
            this.f.setVisibility(4);
        } else if (view.getId() != R$id.done_btn) {
            if (view.getId() == R$id.send_btn) {
                this.d.E0(this.e.getCroppedImage());
            }
        } else {
            Bitmap croppedImage = this.e.getCroppedImage();
            if (croppedImage == null) {
                return;
            }
            this.d.w(croppedImage, this.e.getCropRect(), this.e.getRotatedDegrees());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_crop, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.d = null;
    }
}
