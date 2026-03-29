package com.zenmen.square.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.zx.compat.Keyboard$SHOW_FLAG;
import com.zenmen.palmchat.zx.compat.KeyboardKt;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import defpackage.a46;
import defpackage.c74;
import defpackage.fa3;
import defpackage.i53;
import defpackage.ma3;
import defpackage.n53;
import defpackage.xo;
import defpackage.xu4;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class LocationSearchView extends LxRelativeLayout implements View.OnClickListener, i53, c74 {
    public static final int EVENTID_CANCEL = 1;
    public static final int STATE_EMPTY = 3;
    public static final int STATE_LOADING = 2;
    public static final int STATE_NORMAL = 1;
    private e adapter;
    private View cancelBtn;
    private int currentPage;
    private View emptyView;
    boolean isSearching;
    private com.zenmen.palmchat.location.b locationClient;
    private f proxy;
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private EditText searchBox;
    private String searchCity;
    private Runnable searchRunnable;
    private TextView searchTitle;
    private LocationEx selfLocation;
    private boolean surroundingSearch;
    private int totalPage;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LocationSearchView.this.searchLocation(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d extends RecyclerView.ViewHolder {
        public LocationSearchView d;
        public TextView e;
        public TextView f;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LocationEx f16527a;

            public a(LocationEx locationEx) {
                this.f16527a = locationEx;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.d.onLocationSelected(this.f16527a);
            }
        }

        public d(@NonNull View view, LocationSearchView locationSearchView) {
            super(view);
            this.d = locationSearchView;
            this.e = (TextView) view.findViewById(R$id.location_name);
            this.f = (TextView) view.findViewById(R$id.location_address);
        }

        public final void n(int i, LocationEx locationEx) {
            String searchKey = this.d.getSearchKey();
            int color = Color.parseColor("#14CD64");
            this.e.setText(a46.d(locationEx.getName(), searchKey, color));
            this.f.setText(a46.d(locationEx.getAddress(), searchKey, color));
            this.itemView.setOnClickListener(new a(locationEx));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e extends RecyclerView.Adapter<d> {
        public LocationSearchView e;
        public List<LocationEx> f;

        public /* synthetic */ e(LocationSearchView locationSearchView, a aVar) {
            this(locationSearchView);
        }

        public final void c(List<LocationEx> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            this.f.addAll(list);
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull d dVar, int i) {
            if (i < this.f.size()) {
                dVar.n(i, this.f.get(i));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public d onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.layout_findmap_item_poi, viewGroup, false), this.e);
        }

        public final void f(List<LocationEx> list) {
            if (list == null) {
                list = new ArrayList<>();
            }
            this.f = list;
            this.e.updateRecyclerViewState(list.isEmpty() ? 3 : 1);
            notifyDataSetChanged();
            this.e.getRecyclerView().scrollToPosition(0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f.size();
        }

        public e(LocationSearchView locationSearchView) {
            this.f = new ArrayList();
            this.e = locationSearchView;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f extends fa3 {
        void onLocationSelected(LocationEx locationEx);
    }

    public LocationSearchView(Context context) {
        super(context);
        this.surroundingSearch = true;
        this.currentPage = 0;
        this.totalPage = 0;
        this.searchCity = "";
        this.searchRunnable = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    private xu4 getRefreshLayout() {
        return this.refreshLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSearchKey() {
        if (this.searchBox.getText() == null) {
            return null;
        }
        return this.searchBox.getText().toString();
    }

    private boolean match(String str, String str2) {
        if (str2 != null) {
            str2 = str2.trim();
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains(str2.toLowerCase());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLocationSelected(LocationEx locationEx) {
        f fVar = this.proxy;
        if (fVar != null) {
            fVar.onLocationSelected(locationEx);
        }
        if (TextUtils.isEmpty(getSearchKey())) {
            zn6.b("page_mapfinder_search_nearbyposition");
        } else {
            zn6.b("page_mapfinder_search_resultposition");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchLocation(boolean z) {
        int i;
        if ((!this.surroundingSearch && getVisibility() == 8) || this.isSearching || this.selfLocation == null) {
            return;
        }
        this.isSearching = true;
        int i2 = this.currentPage + 1;
        if (z) {
            this.currentPage = 0;
            this.totalPage = 0;
            this.refreshLayout.setEnableLoadMore(false);
            i = 0;
        } else {
            i = i2;
        }
        String string = this.searchBox.getText() == null ? null : this.searchBox.getText().toString();
        if (TextUtils.isEmpty(string)) {
            if (this.surroundingSearch) {
                this.locationClient.m(this.selfLocation, this.currentPage, 1000, "010000|020000|030000|040000|050000|060000|070100|070200|070300|070400|070500|070600|070700|070800|070900|071000|071100|071200|071300|071400|071500|071600|071700|071800|071900|072000|080000|090000|100000|110000|120000|130000|140000|150100|150201|150202|150203|150210|150301|150302|150303|150304|150401|150500|150600|150700|150800|150900|151000|151100|151200|151300|151400|160100|160200|160400|160500|160600|170000|180103|180200|180300|180500|190000|200400|220100|220201|220202|220203|991001|991400");
                return;
            } else {
                this.isSearching = false;
                return;
            }
        }
        com.zenmen.palmchat.location.b bVar = this.locationClient;
        if (bVar instanceof xo) {
            ((xo) bVar).k(100, string, this.selfLocation, i, 1000, "010000|020000|030000|040000|050000|060000|070100|070200|070300|070400|070500|070600|070700|070800|070900|071000|071100|071200|071300|071400|071500|071600|071700|071800|071900|072000|080000|090000|100000|110000|120000|130000|140000|150100|150201|150202|150203|150210|150301|150302|150303|150304|150401|150500|150600|150700|150800|150900|151000|151100|151200|151300|151400|160100|160200|160400|160500|160600|170000|180103|180200|180300|180500|190000|200400|220100|220201|220202|220203|991001|991400");
        } else {
            bVar.k(100, string, this.selfLocation, i, 1000, "010000|020000|030000|040000|050000|060000|070100|070200|070300|070400|070500|070600|070700|070800|070900|071000|071100|071200|071300|071400|071500|071600|071700|071800|071900|072000|080000|090000|100000|110000|120000|130000|140000|150100|150201|150202|150203|150210|150301|150302|150303|150304|150401|150500|150600|150700|150800|150900|151000|151100|151200|151300|151400|160100|160200|160400|160500|160600|170000|180103|180200|180300|180500|190000|200400|220100|220201|220202|220203|991001|991400");
        }
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        LayoutInflater.from(context).inflate(R$layout.layout_location_search_view, (ViewGroup) this, true);
        View viewFindViewById = findViewById(R$id.tv_cancel_search);
        this.cancelBtn = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        this.recyclerView = (RecyclerView) findViewById(R$id.recycler_view);
        this.refreshLayout = (SmartRefreshLayout) findViewById(R$id.refresh_layout);
        this.emptyView = findViewById(R$id.rl_empty);
        this.searchTitle = (TextView) findViewById(R$id.tv_search_title);
        this.searchBox = (EditText) findViewById(R$id.et_search);
        e eVar = new e(this, null);
        this.adapter = eVar;
        this.recyclerView.setAdapter(eVar);
        this.refreshLayout.setEnableRefresh(false);
        this.refreshLayout.setEnableLoadMore(false);
        if (!this.surroundingSearch) {
            this.searchTitle.setText("搜索结果");
        }
        this.refreshLayout.setOnLoadMoreListener(this);
        this.refreshLayout.setRefreshFooter(new ClassicsFooter(context));
        findViewById(R$id.v_spend_touch_sub).setOnTouchListener(new b());
        this.searchBox.addTextChangedListener(new c());
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.searchBox.getWindowToken(), 0);
        }
    }

    public void init(com.zenmen.palmchat.location.b bVar) {
        this.locationClient = bVar;
        bVar.i(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cancelBtn) {
            disPatchEvent(1, null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.zenmen.palmchat.location.b bVar = this.locationClient;
        if (bVar != null) {
            bVar.r(this);
        }
        removeCallbacks(this.searchRunnable);
    }

    @Override // defpackage.c74
    public void onLoadMore(@NonNull xu4 xu4Var) {
        searchLocation(false);
    }

    @Override // defpackage.i53
    public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
        ma3.a("totalPage " + i + " currentPage " + this.currentPage, new Object[0]);
        this.refreshLayout.finishLoadMore();
        if (n53Var != null && n53Var.b() == 1 && this.currentPage == 0 && TextUtils.isEmpty(n53Var.a()) && !TextUtils.isEmpty(n53Var.c()) && list != null && list.isEmpty()) {
            LocationEx locationExI = com.zenmen.palmchat.location.d.g().i(864000000L);
            String city = locationExI != null ? locationExI.getCity() : null;
            if (TextUtils.isEmpty(city)) {
                city = n53Var.d();
            }
            if (!TextUtils.isEmpty(city)) {
                this.searchCity = city;
                this.locationClient.n(n53Var.c(), this.currentPage, this.searchCity);
                return;
            }
        }
        this.isSearching = false;
        if (list == null) {
            return;
        }
        this.totalPage = i;
        if (!TextUtils.isEmpty(getSearchKey())) {
            String searchKey = getSearchKey();
            Iterator<LocationEx> it = list.iterator();
            while (it.hasNext()) {
                LocationEx next = it.next();
                String name = next.getName();
                String address = next.getAddress();
                if (!match(name, searchKey) && !match(address, searchKey)) {
                    it.remove();
                }
            }
        }
        if (this.currentPage == 0) {
            this.adapter.f(list);
        } else {
            this.adapter.c(list);
        }
        int i2 = this.currentPage + 1;
        this.currentPage = i2;
        if (i2 >= this.totalPage - 1) {
            this.refreshLayout.setEnableLoadMore(false);
        }
    }

    public void resetSearchList() {
        e eVar;
        this.searchBox.setText("");
        if (!this.surroundingSearch && (eVar = this.adapter) != null) {
            eVar.f(null);
        }
        searchLocation(true);
    }

    public void setProxy(f fVar) {
        this.proxy = fVar;
        setEventCallback(fVar);
    }

    public void setSurroundingSearch(boolean z) {
        this.surroundingSearch = z;
    }

    public void showKeyboard() {
        KeyboardKt.c(this.searchBox, this, Keyboard$SHOW_FLAG.IMPLICIT, 0L);
    }

    public void updateRecyclerViewState(int i) {
        if (i == 2 || i == 1) {
            this.emptyView.setVisibility(8);
        } else if (i == 3) {
            this.emptyView.setVisibility(0);
            if (!this.surroundingSearch && TextUtils.isEmpty(getSearchKey())) {
                this.emptyView.setVisibility(8);
            }
        }
        this.searchTitle.setText(this.surroundingSearch ? TextUtils.isEmpty(getSearchKey()) ? "附近地点" : "搜索结果" : "搜索结果");
    }

    public void updateSelfLocation(LocationEx locationEx) {
        this.selfLocation = locationEx;
    }

    public LocationSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.surroundingSearch = true;
        this.currentPage = 0;
        this.totalPage = 0;
        this.searchCity = "";
        this.searchRunnable = new a();
    }

    public LocationSearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.surroundingSearch = true;
        this.currentPage = 0;
        this.totalPage = 0;
        this.searchCity = "";
        this.searchRunnable = new a();
    }

    public LocationSearchView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.surroundingSearch = true;
        this.currentPage = 0;
        this.totalPage = 0;
        this.searchCity = "";
        this.searchRunnable = new a();
    }

    @Override // defpackage.i53
    public void onRegeocodeSearched(String str) {
    }

    @Override // defpackage.i53
    public void onLocationReceived(LocationEx locationEx, int i, String str) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (!LocationSearchView.this.surroundingSearch && TextUtils.isEmpty(editable.toString())) {
                if (LocationSearchView.this.adapter != null) {
                    LocationSearchView.this.adapter.f(null);
                }
            } else {
                LocationSearchView locationSearchView = LocationSearchView.this;
                locationSearchView.removeCallbacks(locationSearchView.searchRunnable);
                LocationSearchView locationSearchView2 = LocationSearchView.this;
                locationSearchView2.postDelayed(locationSearchView2.searchRunnable, 500L);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
