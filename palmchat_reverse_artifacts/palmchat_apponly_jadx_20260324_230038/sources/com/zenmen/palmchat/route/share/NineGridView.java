package com.zenmen.palmchat.route.share;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import defpackage.an;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.pu1;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class NineGridView extends LinearLayout {
    private static final int IMAGE_MARGIN = 9;
    private static final int IMAGE_SIZE = 318;
    private static final int IMAGE_SIZE_MAX = 990;
    private static final int VIEW_SIZE = 1008;
    private ImageView[] mImageViews;

    public NineGridView(Context context) {
        super(context);
        initViews();
    }

    private void initViews() {
        this.mImageViews = new ImageView[9];
        setOrientation(1);
        setGravity(GravityCompat.START);
        for (int i = 0; i < 3; i++) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            linearLayout.setGravity(GravityCompat.START);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(an.b(1008), -2));
            for (int i2 = 0; i2 < 3; i2++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setVisibility(8);
                this.mImageViews[(i * 3) + i2] = imageView;
                linearLayout.addView(imageView);
            }
            addView(linearLayout);
        }
    }

    public void display(ArrayList<Uri> arrayList) {
        if (arrayList.size() == 1) {
            Uri uri = arrayList.get(0);
            ImageView imageView = this.mImageViews[0];
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            int iB = an.b(IMAGE_SIZE_MAX);
            marginLayoutParams.height = iB;
            marginLayoutParams.width = iB;
            int iB2 = an.b(9);
            marginLayoutParams.setMargins(iB2, iB2, iB2, iB2);
            imageView.setLayoutParams(marginLayoutParams);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setVisibility(0);
            gr2.j().h(pu1.a(uri.toString()), imageView, bq6.j());
            return;
        }
        for (int i = 0; i < arrayList.size() && i != 9; i++) {
            Uri uri2 = arrayList.get(i);
            ImageView imageView2 = this.mImageViews[i];
            int iB3 = an.b(318);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) imageView2.getLayoutParams();
            marginLayoutParams2.height = iB3;
            marginLayoutParams2.width = iB3;
            int iB4 = an.b(9);
            marginLayoutParams2.setMargins(iB4, iB4, iB4, iB4);
            imageView2.setLayoutParams(marginLayoutParams2);
            imageView2.setVisibility(0);
            gr2.j().h(pu1.a(uri2.toString()), imageView2, bq6.j());
        }
    }

    public NineGridView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initViews();
    }

    public NineGridView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initViews();
    }

    public void display(Uri uri) {
        ArrayList<Uri> arrayList = new ArrayList<>();
        arrayList.add(uri);
        display(arrayList);
    }
}
