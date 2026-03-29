package defpackage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class ps0 extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentManager f20089a;
    public final int b;
    public FragmentTransaction c = null;
    public ArrayList<Fragment.SavedState> d = new ArrayList<>();
    public ArrayList<Fragment> e = new ArrayList<>();
    public Fragment f = null;
    public boolean g;

    public ps0(@NonNull FragmentManager fragmentManager, int i) {
        this.f20089a = fragmentManager;
        this.b = i;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @SuppressLint({"LongLogTag"})
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.c == null) {
            this.c = this.f20089a.beginTransaction();
        }
        while (this.d.size() <= i) {
            this.d.add(null);
        }
        this.d.set(i, fragment.isAdded() ? this.f20089a.saveFragmentInstanceState(fragment) : null);
        this.e.set(i, null);
        this.c.remove(fragment);
        if (fragment.equals(this.f)) {
            this.f = null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(@NonNull ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.c;
        if (fragmentTransaction != null) {
            if (!this.g) {
                try {
                    this.g = true;
                    fragmentTransaction.commitNowAllowingStateLoss();
                } finally {
                    this.g = false;
                }
            }
            this.c = null;
        }
    }

    @NonNull
    public abstract Fragment getItem(int i);

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    @SuppressLint({"LongLogTag"})
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        Fragment.SavedState savedState;
        if (this.c == null) {
            this.c = this.f20089a.beginTransaction();
        }
        Fragment item = getItem(i);
        if (this.d.size() > i && (savedState = this.d.get(i)) != null) {
            item.setInitialSavedState(savedState);
        }
        while (this.e.size() <= i) {
            this.e.add(null);
        }
        item.setMenuVisibility(false);
        if (this.b == 0) {
            item.setUserVisibleHint(false);
        }
        this.e.set(i, item);
        this.c.add(viewGroup.getId(), item);
        return item;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @SuppressLint({"LongLogTag"})
    public void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.d.clear();
            this.e.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.d.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int i = Integer.parseInt(str.substring(1));
                    Fragment fragment = this.f20089a.getFragment(bundle, str);
                    if (fragment != null) {
                        while (this.e.size() <= i) {
                            this.e.add(null);
                        }
                        fragment.setMenuVisibility(false);
                        this.e.set(i, fragment);
                    } else {
                        Log.w("CyFragStatePageAdapterVp", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public Parcelable saveState() {
        Bundle bundle;
        if (this.d.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.d.size()];
            this.d.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i = 0; i < this.e.size(); i++) {
            Fragment fragment = this.e.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f20089a.putFragment(bundle, "f" + i, fragment);
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.b != 1) {
                    this.f.setUserVisibleHint(false);
                } else if (this.c == null) {
                    this.c = this.f20089a.beginTransaction();
                }
            }
            fragment.setMenuVisibility(true);
            if (this.b != 1) {
                fragment.setUserVisibleHint(true);
            } else if (this.c == null) {
                this.c = this.f20089a.beginTransaction();
            }
            this.f = fragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(@NonNull ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
}
