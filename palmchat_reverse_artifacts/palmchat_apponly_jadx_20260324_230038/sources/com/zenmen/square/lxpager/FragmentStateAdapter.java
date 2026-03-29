package com.zenmen.square.lxpager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.StatefulAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.zenmen.square.lxpager.PagerFragment;
import defpackage.ma3;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class FragmentStateAdapter<T extends PagerFragment> extends RecyclerView.Adapter<LxFragmentViewHolder> implements StatefulAdapter {
    public final Lifecycle e;
    public final FragmentManager f;
    public final LongSparseArray<T> g;
    public final LongSparseArray<Integer> h;
    public FragmentStateAdapter<T>.FragmentMaxLifecycleEnforcer i;
    public Bundle j;
    public boolean k;
    public boolean l;

    /* JADX INFO: compiled from: SearchBox */
    public class FragmentMaxLifecycleEnforcer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ViewPager2.OnPageChangeCallback f16402a;
        public RecyclerView.AdapterDataObserver b;
        public LifecycleEventObserver c;
        public ViewPager2 d;
        public long e = -1;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends ViewPager2.OnPageChangeCallback {
            public a() {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i) {
                FragmentMaxLifecycleEnforcer.this.d(false);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                FragmentMaxLifecycleEnforcer.this.d(false);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends d {
            public b() {
                super(null);
            }

            @Override // com.zenmen.square.lxpager.FragmentStateAdapter.d, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                FragmentMaxLifecycleEnforcer.this.d(true);
            }
        }

        public FragmentMaxLifecycleEnforcer() {
        }

        @NonNull
        public final ViewPager2 a(@NonNull RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        public void b(@NonNull RecyclerView recyclerView) {
            this.d = a(recyclerView);
            a aVar = new a();
            this.f16402a = aVar;
            this.d.registerOnPageChangeCallback(aVar);
            b bVar = new b();
            this.b = bVar;
            FragmentStateAdapter.this.registerAdapterDataObserver(bVar);
            LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.zenmen.square.lxpager.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.3
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    FragmentMaxLifecycleEnforcer.this.d(false);
                }
            };
            this.c = lifecycleEventObserver;
            FragmentStateAdapter.this.e.addObserver(lifecycleEventObserver);
        }

        public void c(@NonNull RecyclerView recyclerView) {
            a(recyclerView).unregisterOnPageChangeCallback(this.f16402a);
            FragmentStateAdapter.this.unregisterAdapterDataObserver(this.b);
            FragmentStateAdapter.this.e.removeObserver(this.c);
            this.d = null;
        }

        public void d(boolean z) {
            int currentItem;
            T t;
            if (FragmentStateAdapter.this.shouldDelayFragmentTransactions() || this.d.getScrollState() != 0 || FragmentStateAdapter.this.g.isEmpty() || FragmentStateAdapter.this.getItemCount() == 0 || (currentItem = this.d.getCurrentItem()) >= FragmentStateAdapter.this.getItemCount()) {
                return;
            }
            long itemId = FragmentStateAdapter.this.getItemId(currentItem);
            if ((itemId != this.e || z) && (t = FragmentStateAdapter.this.g.get(itemId)) != null && t.isAdded()) {
                this.e = itemId;
                FragmentTransaction fragmentTransactionBeginTransaction = FragmentStateAdapter.this.f.beginTransaction();
                T t2 = null;
                for (int i = 0; i < FragmentStateAdapter.this.g.size(); i++) {
                    long jKeyAt = FragmentStateAdapter.this.g.keyAt(i);
                    T tValueAt = FragmentStateAdapter.this.g.valueAt(i);
                    if (tValueAt.isAdded()) {
                        if (jKeyAt != this.e) {
                            fragmentTransactionBeginTransaction.setMaxLifecycle(tValueAt, Lifecycle.State.STARTED);
                        } else {
                            t2 = tValueAt;
                        }
                        tValueAt.setMenuVisibility(jKeyAt == this.e);
                    }
                }
                if (t2 != null) {
                    fragmentTransactionBeginTransaction.setMaxLifecycle(t2, Lifecycle.State.RESUMED);
                }
                if (fragmentTransactionBeginTransaction.isEmpty()) {
                    return;
                }
                fragmentTransactionBeginTransaction.commitNow();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f16406a;
        public final /* synthetic */ LxFragmentViewHolder b;

        public a(FrameLayout frameLayout, LxFragmentViewHolder lxFragmentViewHolder) {
            this.f16406a = frameLayout;
            this.b = lxFragmentViewHolder;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.f16406a.getParent() != null) {
                this.f16406a.removeOnLayoutChangeListener(this);
                FragmentStateAdapter.this.i(this.b, false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends FragmentManager.FragmentLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PagerFragment f16407a;
        public final /* synthetic */ FrameLayout b;

        public b(PagerFragment pagerFragment, FrameLayout frameLayout) {
            this.f16407a = pagerFragment;
            this.b = frameLayout;
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle) {
            if (fragment == this.f16407a) {
                fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                FragmentStateAdapter.this.addViewToContainer(view, this.b);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
            fragmentStateAdapter.k = false;
            fragmentStateAdapter.gcFragments();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class d extends RecyclerView.AdapterDataObserver {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        public /* synthetic */ d(a aVar) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
            onChanged();
        }
    }

    public FragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        this(fragmentActivity.getSupportFragmentManager(), fragmentActivity.getLifecycle());
    }

    @NonNull
    public abstract T a(int i);

    public void addViewToContainer(@NonNull View view, @NonNull FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }

    public T b(int i) {
        ma3.a("mFragments " + this.g.size(), new Object[0]);
        return this.g.get(getItemId(i));
    }

    public Bundle c() {
        return this.j != null ? new Bundle(this.j) : new Bundle();
    }

    public boolean containsItem(long j) {
        return j >= 0 && j < ((long) getItemCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull LxFragmentViewHolder lxFragmentViewHolder, int i) {
        ma3.a("onBindViewHolder " + i, new Object[0]);
        long itemId = lxFragmentViewHolder.getItemId();
        int id = lxFragmentViewHolder.getContainer().getId();
        Long lItemForViewHolder = itemForViewHolder(id);
        if (lItemForViewHolder != null && lItemForViewHolder.longValue() != itemId) {
            removeFragment(lItemForViewHolder.longValue());
            this.h.remove(lItemForViewHolder.longValue());
        }
        this.h.put(itemId, Integer.valueOf(id));
        ensureFragment(i);
        FrameLayout container = lxFragmentViewHolder.getContainer();
        if (ViewCompat.isAttachedToWindow(container)) {
            if (container.getParent() != null) {
                throw new IllegalStateException("Design assumption violated.");
            }
            container.addOnLayoutChangeListener(new a(container, lxFragmentViewHolder));
        }
        gcFragments();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public LxFragmentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return LxFragmentViewHolder.l(viewGroup);
    }

    public final void ensureFragment(int i) {
        long itemId = getItemId(i);
        if (this.g.containsKey(itemId)) {
            return;
        }
        this.g.put(itemId, a(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final boolean onFailedToRecycleView(@NonNull LxFragmentViewHolder lxFragmentViewHolder) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final void onViewAttachedToWindow(@NonNull LxFragmentViewHolder lxFragmentViewHolder) {
        i(lxFragmentViewHolder, true);
        gcFragments();
    }

    public void gcFragments() {
        if (!this.l || shouldDelayFragmentTransactions()) {
            return;
        }
        ArraySet arraySet = new ArraySet();
        for (int i = 0; i < this.g.size(); i++) {
            long jKeyAt = this.g.keyAt(i);
            if (!containsItem(jKeyAt)) {
                arraySet.add(Long.valueOf(jKeyAt));
                this.h.remove(jKeyAt);
            }
        }
        if (!this.k) {
            this.l = false;
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                long jKeyAt2 = this.g.keyAt(i2);
                if (!isFragmentViewBound(jKeyAt2)) {
                    arraySet.add(Long.valueOf(jKeyAt2));
                }
            }
        }
        Iterator<E> it = arraySet.iterator();
        while (it.hasNext()) {
            removeFragment(((Long) it.next()).longValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void onViewRecycled(@NonNull LxFragmentViewHolder lxFragmentViewHolder) {
        Long lItemForViewHolder = itemForViewHolder(lxFragmentViewHolder.getContainer().getId());
        if (lItemForViewHolder != null) {
            removeFragment(lItemForViewHolder.longValue());
            this.h.remove(lItemForViewHolder.longValue());
        }
    }

    public void i(@NonNull final LxFragmentViewHolder lxFragmentViewHolder, boolean z) {
        T t = this.g.get(lxFragmentViewHolder.getItemId());
        if (t == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        FrameLayout container = lxFragmentViewHolder.getContainer();
        View view = t.getView();
        if (!t.isAdded() && view != null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        t.I(lxFragmentViewHolder);
        if (t.isAdded() && view == null) {
            j(t, container);
            return;
        }
        if (t.isAdded() && view.getParent() != null) {
            if (view.getParent() != container) {
                addViewToContainer(view, container);
            }
            if (z) {
                t.F();
                return;
            }
            return;
        }
        if (t.isAdded()) {
            addViewToContainer(view, container);
            return;
        }
        if (shouldDelayFragmentTransactions()) {
            if (this.f.isDestroyed()) {
                return;
            }
            this.e.addObserver(new LifecycleEventObserver() { // from class: com.zenmen.square.lxpager.FragmentStateAdapter.2
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    if (FragmentStateAdapter.this.shouldDelayFragmentTransactions()) {
                        return;
                    }
                    lifecycleOwner.getLifecycle().removeObserver(this);
                    if (ViewCompat.isAttachedToWindow(lxFragmentViewHolder.getContainer())) {
                        FragmentStateAdapter.this.i(lxFragmentViewHolder, true);
                    }
                }
            });
            return;
        }
        j(t, container);
        this.f.beginTransaction().add(t, "f" + lxFragmentViewHolder.getItemId()).setMaxLifecycle(t, Lifecycle.State.STARTED).commitNow();
        this.i.d(false);
    }

    public final boolean isFragmentViewBound(long j) {
        View view;
        if (this.h.containsKey(j)) {
            return true;
        }
        T t = this.g.get(j);
        return (t == null || (view = t.getView()) == null || view.getParent() == null) ? false : true;
    }

    public final Long itemForViewHolder(int i) {
        Long lValueOf = null;
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            if (this.h.valueAt(i2).intValue() == i) {
                if (lValueOf != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                lValueOf = Long.valueOf(this.h.keyAt(i2));
            }
        }
        return lValueOf;
    }

    public final void j(T t, @NonNull FrameLayout frameLayout) {
        this.f.registerFragmentLifecycleCallbacks(new b(t, frameLayout), false);
    }

    public void k(Bundle bundle) {
        this.j = bundle;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        if (this.i != null) {
            throw new IllegalArgumentException();
        }
        FragmentStateAdapter<T>.FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.i = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.b(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        this.i.c(recyclerView);
        this.i = null;
    }

    public final void removeFragment(long j) {
        ViewParent parent;
        T t = this.g.get(j);
        if (t == null) {
            return;
        }
        if (t.getView() != null && (parent = t.getView().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!t.isAdded()) {
            this.g.remove(j);
        } else if (shouldDelayFragmentTransactions()) {
            this.l = true;
        } else {
            this.f.beginTransaction().remove(t).commitNow();
            this.g.remove(j);
        }
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final void restoreState(@NonNull Parcelable parcelable) {
        if (!this.g.isEmpty()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        if (this.g.isEmpty()) {
            return;
        }
        this.l = true;
        this.k = true;
        gcFragments();
        scheduleGracePeriodEnd();
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    @NonNull
    public final Parcelable saveState() {
        return new Bundle();
    }

    public final void scheduleGracePeriodEnd() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final c cVar = new c();
        this.e.addObserver(new LifecycleEventObserver() { // from class: com.zenmen.square.lxpager.FragmentStateAdapter.5
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    handler.removeCallbacks(cVar);
                    lifecycleOwner.getLifecycle().removeObserver(this);
                }
            }
        });
        handler.postDelayed(cVar, 10000L);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean z) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    public boolean shouldDelayFragmentTransactions() {
        return this.f.isStateSaved();
    }

    public FragmentStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        this.g = new LongSparseArray<>();
        this.h = new LongSparseArray<>();
        this.k = false;
        this.l = false;
        this.f = fragmentManager;
        this.e = lifecycle;
        super.setHasStableIds(true);
    }
}
