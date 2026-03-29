package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import androidx.appcompat.widget.AppCompatEditText;
import com.afollestad.materialdialogs.R$attr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class sb3 {
    public static ColorStateList a(Context context, int i) {
        int i2 = R$attr.colorControlNormal;
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{-16842919, -16842908}, new int[0]}, new int[]{ed1.g(context, i2), ed1.g(context, i2), i});
    }

    public static void b(CheckBox checkBox, int i) {
        checkBox.setButtonTintList(new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{R.attr.state_checked}}, new int[]{ed1.g(checkBox.getContext(), R$attr.colorControlNormal), i}));
    }

    public static void c(EditText editText, int i) {
        ColorStateList colorStateListA = a(editText.getContext(), i);
        if (editText instanceof AppCompatEditText) {
            ((AppCompatEditText) editText).setSupportBackgroundTintList(colorStateListA);
        } else {
            editText.setBackgroundTintList(colorStateListA);
        }
    }

    public static void d(ProgressBar progressBar, int i) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        progressBar.setProgressTintList(colorStateListValueOf);
        progressBar.setSecondaryProgressTintList(colorStateListValueOf);
        progressBar.setIndeterminateTintList(colorStateListValueOf);
    }

    public static void e(RadioButton radioButton, int i) {
        radioButton.setButtonTintList(new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{R.attr.state_checked}}, new int[]{ed1.g(radioButton.getContext(), R$attr.colorControlNormal), i}));
    }
}
