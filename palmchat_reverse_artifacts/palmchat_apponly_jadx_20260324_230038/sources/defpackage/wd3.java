package defpackage;

import android.R;
import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class wd3 extends ArrayAdapter<xd3> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MaterialDialog f21679a;

    @TargetApi(17)
    public final boolean a() {
        return getContext().getResources().getConfiguration().getLayoutDirection() == 1;
    }

    public void b(MaterialDialog materialDialog, boolean z) {
        this.f21679a = materialDialog;
        if (z) {
            notifyDataSetChanged();
        }
    }

    @TargetApi(17)
    public final void c(ViewGroup viewGroup) {
        GravityEnum gravityEnumY = this.f21679a.g().y();
        ((LinearLayout) viewGroup).setGravity(gravityEnumY.getGravityInt() | 16);
        if (viewGroup.getChildCount() == 2) {
            if (this.f21679a.g().y() == GravityEnum.END && !a() && (viewGroup.getChildAt(0) instanceof ImageView)) {
                View view = (CompoundButton) viewGroup.getChildAt(0);
                viewGroup.removeView(view);
                TextView textView = (TextView) viewGroup.getChildAt(0);
                viewGroup.removeView(textView);
                textView.setPadding(textView.getPaddingRight(), textView.getPaddingTop(), textView.getPaddingLeft(), textView.getPaddingBottom());
                viewGroup.addView(textView);
                viewGroup.addView(view);
                return;
            }
            if (gravityEnumY == GravityEnum.START && a() && (viewGroup.getChildAt(1) instanceof ImageView)) {
                View view2 = (CompoundButton) viewGroup.getChildAt(1);
                viewGroup.removeView(view2);
                TextView textView2 = (TextView) viewGroup.getChildAt(0);
                viewGroup.removeView(textView2);
                textView2.setPadding(textView2.getPaddingRight(), textView2.getPaddingTop(), textView2.getPaddingRight(), textView2.getPaddingBottom());
                viewGroup.addView(view2);
                viewGroup.addView(textView2);
            }
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (this.f21679a != null) {
            xd3 xd3Var = (xd3) getItem(i);
            ImageView imageView = (ImageView) view2.findViewById(R.id.icon);
            if (xd3Var.b() != null) {
                imageView.setImageDrawable(xd3Var.b());
            } else {
                imageView.setVisibility(8);
            }
            TextView textView = (TextView) view2.findViewById(R.id.title);
            textView.setTextColor(this.f21679a.g().x());
            textView.setText(xd3Var.a());
            MaterialDialog materialDialog = this.f21679a;
            materialDialog.v(textView, materialDialog.g().z());
            c((ViewGroup) view2);
        }
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
