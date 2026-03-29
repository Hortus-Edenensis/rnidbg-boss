package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.SuperExposeNumActivity;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.SuperExposeNumItem;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.SuperExposeTabData;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.recycler.ItemAdapter;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class ao5 implements xo2 {
    public ItemAdapter f;
    public Context g;
    public SuperExposeNumActivity h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1537a = 1;
    public int b = 0;
    public RecyclerView c = null;
    public View d = null;
    public View e = null;
    public boolean i = false;
    public boolean j = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ao5 ao5Var = ao5.this;
            hs3.c(ao5Var, ao5Var.f1537a, ao5Var.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends GridLayoutManager.SpanSizeLookup {
        public b() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            return ao5.this.f.f().get(i).isFooter ? 2 : 1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends RecyclerView.ItemDecoration {
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        public c(int i, int i2, int i3) {
            this.b = i;
            this.c = i2;
            this.d = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            if (recyclerView.getChildAdapterPosition(view) % 2 == 0) {
                rect.left = this.b;
                rect.right = this.c / 2;
            } else {
                rect.left = this.c / 2;
                rect.right = this.b;
            }
            int i = this.d;
            rect.top = i / 2;
            rect.bottom = i / 2;
        }
    }

    public ao5(ViewGroup viewGroup, SuperExposeNumActivity superExposeNumActivity) {
        this.g = null;
        this.h = superExposeNumActivity;
        this.g = superExposeNumActivity.getApplicationContext();
        f(viewGroup);
        g();
    }

    @Override // defpackage.xo2
    public int a() {
        return this.b;
    }

    @Override // defpackage.xo2
    public void b(SuperExposeTabData superExposeTabData) {
        int itemCount;
        if (superExposeTabData != null) {
            SuperExposeNumActivity superExposeNumActivity = this.h;
            if (superExposeNumActivity != null) {
                superExposeNumActivity.G1(superExposeTabData);
            }
            List<SuperExposeNumItem> list = superExposeTabData.superShowList;
            if (list != null && list.size() > 0) {
                hs3.h(superExposeTabData.superShowList, this.f1537a);
                this.j = true;
                LogUtil.d("", "MsgTabTaijiModelManager dataSuccess tabData.superShowList size " + superExposeTabData.superShowList.size());
                i(superExposeTabData.superShowList, this.b == 0);
                return;
            }
            if (!this.j || (itemCount = this.f.getItemCount()) <= 0) {
                return;
            }
            SuperExposeNumItem superExposeNumItem = this.f.f().get(itemCount - 1);
            if (superExposeNumItem.isFooter) {
                superExposeNumItem.footerStatus = SuperExposeNumItem.FooterStatus.LOADED_ALL;
                this.f.notifyDataSetChanged();
            }
        }
    }

    public abstract void f(ViewGroup viewGroup);

    public final void g() {
        this.d.setOnClickListener(new a());
        this.f = new ItemAdapter(this.g, this, this.f1537a);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.g, 2);
        gridLayoutManager.setSpanSizeLookup(new b());
        this.c.setLayoutManager(gridLayoutManager);
        int iB = a46.b(this.g, 7.6f);
        int iB2 = a46.b(this.g, 6.7f);
        this.c.addItemDecoration(new c(a46.b(this.g, 6.7f), iB, iB2));
        this.c.setAdapter(this.f);
        this.c.addOnScrollListener(new d(gridLayoutManager));
    }

    public void h(int i) {
        this.e.setVisibility(i);
        if (i == 0) {
            this.b = 0;
            hs3.c(this, this.f1537a, 0);
        }
    }

    public final void i(List<SuperExposeNumItem> list, boolean z) {
        LogUtil.d("", "MsgTabTaijiModelManager updateItemViewContents firstPage " + z);
        if (list.size() > 0) {
            SuperExposeNumItem superExposeNumItem = new SuperExposeNumItem();
            superExposeNumItem.isFooter = true;
            superExposeNumItem.footerStatus = SuperExposeNumItem.FooterStatus.LOADED;
            list.add(superExposeNumItem);
        }
        if (!z) {
            int itemCount = this.f.getItemCount();
            if (itemCount > 0) {
                int i = itemCount - 1;
                if (this.f.f().get(i).isFooter) {
                    this.f.d(i);
                }
            }
            this.f.c(list);
            return;
        }
        this.f.q(list);
        if (list.size() > 0) {
            this.c.setVisibility(0);
            this.d.setVisibility(8);
        } else {
            this.c.setVisibility(8);
            this.d.setVisibility(0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GridLayoutManager f1540a;

        public d(GridLayoutManager gridLayoutManager) {
            this.f1540a = gridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            int iFindLastVisibleItemPosition;
            SuperExposeNumItem.FooterStatus footerStatus;
            super.onScrollStateChanged(recyclerView, i);
            if (i != 0 || (iFindLastVisibleItemPosition = this.f1540a.findLastVisibleItemPosition()) < 0 || iFindLastVisibleItemPosition >= ao5.this.f.getItemCount()) {
                return;
            }
            SuperExposeNumItem superExposeNumItem = ao5.this.f.f().get(iFindLastVisibleItemPosition);
            if (!superExposeNumItem.isFooter || (footerStatus = superExposeNumItem.footerStatus) == SuperExposeNumItem.FooterStatus.LOADED_ALL || footerStatus == SuperExposeNumItem.FooterStatus.ERROR || hs3.f18042a) {
                return;
            }
            ao5.this.b++;
            LogUtil.d("", "MsgTabTaijiModelManager onScrollStateChanged MsgTabTaijiModelManager.getAllTabData " + i);
            int itemCount = ao5.this.f.getItemCount();
            if (itemCount > 0) {
                SuperExposeNumItem superExposeNumItem2 = ao5.this.f.f().get(itemCount - 1);
                if (superExposeNumItem2.isFooter) {
                    superExposeNumItem2.footerStatus = SuperExposeNumItem.FooterStatus.LOADING;
                    ao5.this.f.notifyDataSetChanged();
                }
            }
            ao5 ao5Var = ao5.this;
            hs3.c(ao5Var, ao5Var.f1537a, ao5Var.b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
        }
    }
}
