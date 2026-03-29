package defpackage;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ym {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f22224a;
    public LinearLayoutManager b;
    public RecyclerView.Adapter c;
    public HashMap<zm, String> d;
    public zm e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public Runnable j;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ym.this.t();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            ym.this.i = i;
            LogUtil.v("logvideo", "idleChanged");
            ym.this.t();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements RecyclerView.OnChildAttachStateChangeListener {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(View view) {
            LogUtil.v("logvideo", "attachedToWindow:" + view);
            ym.this.f22224a.removeCallbacks(ym.this.j);
            ym.this.f22224a.post(ym.this.j);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(View view) {
            LogUtil.v("logvideo", "detachedFromWindow:" + view);
            Object objFindContainingViewHolder = ym.this.f22224a.findContainingViewHolder(view);
            if (objFindContainingViewHolder instanceof zm) {
                LogUtil.d("logvideo", "helper: detached");
                ym.this.q((zm) objFindContainingViewHolder);
            }
            ym.this.f22224a.removeCallbacks(ym.this.j);
            ym.this.f22224a.post(ym.this.j);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements b5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ xm f22229a;

        public e(xm xmVar) {
            this.f22229a = xmVar;
        }

        @Override // defpackage.b5
        public void call() {
            zm zmVar;
            xm xmVar = this.f22229a;
            if (xmVar == null || xmVar.a() != 2) {
                xm xmVar2 = this.f22229a;
                if (xmVar2 == null || xmVar2.a() != 0) {
                    return;
                }
                ym.this.t();
                return;
            }
            LogUtil.v("logvideo", "releaseEvent");
            Iterator it = ym.this.d.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    zmVar = null;
                    break;
                }
                zmVar = (zm) it.next();
                if (zmVar != ym.this.e && zmVar.isZooming()) {
                    break;
                }
            }
            if (zmVar != null) {
                ym.this.q(zmVar);
            }
        }
    }

    public ym(RecyclerView recyclerView) {
        this.d = new HashMap<>();
        this.f = false;
        this.g = false;
        this.h = true;
        this.i = 0;
        this.j = new a();
        this.f22224a = recyclerView;
        this.b = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.c = recyclerView.getAdapter();
        i();
    }

    public final void g() {
        Iterator<zm> it = this.d.keySet().iterator();
        while (it.hasNext()) {
            zm next = it.next();
            if (next != this.e) {
                if (h(next)) {
                    LogUtil.d("logvideo", "helper: changed release=" + next + ", " + next.getPlayPath());
                    next.onPlayRelease();
                    it.remove();
                } else {
                    LogUtil.d("logvideo", "helper: not changed=" + next + ", " + next.getPlayPath());
                }
            }
        }
    }

    public final boolean h(zm zmVar) {
        if (zmVar == null) {
            return false;
        }
        return !TextUtils.equals(zmVar.getPlayPath(), this.d.get(zmVar));
    }

    public final void i() {
        ds0.a().c(this);
        this.f22224a.addOnScrollListener(new b());
        this.f22224a.addOnChildAttachStateChangeListener(new c());
        this.c.registerAdapterDataObserver(new d());
    }

    public final boolean j(zm zmVar) {
        return (zmVar == null || this.e != zmVar || h(zmVar)) ? false : true;
    }

    public void k() {
        LogUtil.v("logvideo", "onDestroy");
        p();
        ds0.a().d(this);
    }

    public void l() {
        LogUtil.v("logvideo", "onPause");
        this.f = false;
        t();
    }

    public void m() {
        LogUtil.v("logvideo", "onResume");
        this.f = true;
        t();
    }

    public void n(boolean z) {
        LogUtil.v("logvideo", "onUserVisible" + z);
        this.g = z;
        RecyclerView recyclerView = this.f22224a;
        if (recyclerView != null) {
            recyclerView.removeCallbacks(this.j);
            this.f22224a.post(this.j);
        }
    }

    public final void o() {
        LogUtil.d("logvideo", "helper: map=" + this.d.size());
        zm zmVar = this.e;
        if (zmVar != null) {
            if (h(zmVar)) {
                LogUtil.d("logvideo", "helper: release=" + this.e + ", " + this.e.getPlayPath());
                q(this.e);
            } else {
                LogUtil.d("logvideo", "helper: pause=" + this.e + ", " + this.e.getPlayPath());
                this.e.onPlayPause();
            }
            this.e = null;
        }
    }

    @qm5
    public void onAutoPlayEvent(xm xmVar) {
        wc.a().a().a(new e(xmVar));
    }

    public final void p() {
        LogUtil.d("logvideo", "helper: releaseAll");
        Iterator<zm> it = this.d.keySet().iterator();
        while (it.hasNext()) {
            it.next().onPlayRelease();
        }
        this.d.clear();
        this.e = null;
    }

    public final void q(zm zmVar) {
        if (zmVar != null) {
            LogUtil.d("logvideo", "helper: release=" + zmVar);
            zmVar.onPlayRelease();
            this.d.remove(zmVar);
        }
        if (this.e == zmVar) {
            this.e = null;
        }
    }

    public final void r() {
        ViewGroup containerView;
        LogUtil.d("logvideo", "helper: autoPlay");
        int i = 2;
        int[] iArr = new int[2];
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        this.f22224a.getGlobalVisibleRect(rect2);
        int iCenterY = rect2.centerY();
        int iFindFirstVisibleItemPosition = this.b.findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = this.b.findLastVisibleItemPosition();
        LogUtil.v("logvideo", "recyclerCenterY:" + iCenterY + ", rect:" + rect2 + ", " + iFindFirstVisibleItemPosition + ", " + iFindLastVisibleItemPosition);
        zm zmVar = null;
        int i2 = -1;
        while (iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition && iFindFirstVisibleItemPosition >= 0 && iFindFirstVisibleItemPosition < this.c.getItemCount()) {
            Object objFindViewHolderForAdapterPosition = this.f22224a.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition);
            if (objFindViewHolderForAdapterPosition instanceof zm) {
                zm zmVar2 = (zm) objFindViewHolderForAdapterPosition;
                if (zmVar2.canPlay() && (containerView = zmVar2.getContainerView()) != null) {
                    containerView.getGlobalVisibleRect(rect);
                    int height = containerView.getHeight();
                    LogUtil.v("logvideo", "hostVisibleHeight:" + rect.height() + ", hostHeight:" + height + ", rect:" + rect);
                    int i3 = height / i;
                    if (rect.height() >= i3) {
                        containerView.getLocationOnScreen(iArr);
                        int iAbs = Math.abs((iArr[1] + i3) - iCenterY);
                        LogUtil.v("logvideo", "hostCenterY:" + (iArr[1] + i3) + ", distanceToCenter:" + iAbs);
                        if (i2 < 0 || iAbs < i2) {
                            zmVar = zmVar2;
                            i2 = iAbs;
                        }
                    }
                }
            }
            iFindFirstVisibleItemPosition++;
            i = 2;
        }
        boolean z = true;
        if (!hx3.n() && (!this.h || !hx3.m(com.zenmen.palmchat.c.b()))) {
            z = false;
        }
        if (j(zmVar) && (z || com.zenmen.palmchat.friendcircle.video.a.c().b(zmVar.getPlayPath()))) {
            zmVar.onPlayResume();
            return;
        }
        o();
        if (zmVar == null || !z) {
            return;
        }
        s(zmVar);
    }

    public final void s(zm zmVar) {
        if (zmVar != null) {
            String playPath = zmVar.getPlayPath();
            String str = this.d.get(zmVar);
            if (str == null || !TextUtils.equals(str, playPath)) {
                LogUtil.d("logvideo", "helper: start=" + zmVar + ", " + zmVar.getPlayPath());
                zmVar.onPlayStart(playPath);
            } else {
                LogUtil.d("logvideo", "helper: resume=" + zmVar + ", " + zmVar.getPlayPath());
                zmVar.onPlayResume();
            }
            this.e = zmVar;
            this.d.put(zmVar, playPath);
        }
    }

    public void t() {
        g();
        if (this.i != 0) {
            return;
        }
        if (this.f && this.g) {
            r();
        } else {
            o();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends RecyclerView.AdapterDataObserver {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            LogUtil.v("logvideo", "dataChanged");
            ym.this.t();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            LogUtil.v("logvideo", "dataChanged");
            ym.this.t();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            LogUtil.v("logvideo", "dataChanged");
            ym.this.t();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            LogUtil.v("logvideo", "dataChanged");
            ym.this.t();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            LogUtil.v("logvideo", "dataChanged");
            ym.this.t();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            super.onItemRangeChanged(i, i2, obj);
            LogUtil.v("logvideo", "dataChanged");
            ym.this.t();
        }
    }

    public ym(RecyclerView recyclerView, boolean z) {
        this.d = new HashMap<>();
        this.f = false;
        this.g = false;
        this.h = true;
        this.i = 0;
        this.j = new a();
        this.f22224a = recyclerView;
        this.b = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.c = recyclerView.getAdapter();
        this.h = z;
        i();
    }
}
