package defpackage;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.zenmen.imageeditengine.BaseFragment;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class s22 {
    public static void a(AppCompatActivity appCompatActivity, int i, BaseFragment baseFragment) {
        Log.e("rxx", "add fragment " + baseFragment.toString());
        FragmentTransaction fragmentTransactionBeginTransaction = appCompatActivity.getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.add(i, baseFragment, baseFragment.getClass().getSimpleName());
        fragmentTransactionBeginTransaction.commit();
    }

    public static Fragment b(AppCompatActivity appCompatActivity, String str) {
        return appCompatActivity.getSupportFragmentManager().findFragmentByTag(str);
    }

    public static void c(AppCompatActivity appCompatActivity, BaseFragment baseFragment) {
        Log.e("rxx", "remove fragment " + baseFragment.toString());
        appCompatActivity.getSupportFragmentManager().beginTransaction().remove(baseFragment).commit();
    }
}
