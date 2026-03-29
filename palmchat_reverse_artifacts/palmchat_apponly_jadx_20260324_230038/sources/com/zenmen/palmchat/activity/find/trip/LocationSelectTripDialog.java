package com.zenmen.palmchat.activity.find.trip;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationScene;
import com.zenmen.palmchat.widget.ClearEditText;
import com.zenmen.palmchat.zx.compat.Keyboard$SHOW_FLAG;
import com.zenmen.palmchat.zx.compat.KeyboardKt;
import defpackage.dw1;
import defpackage.i53;
import defpackage.k36;
import defpackage.k86;
import defpackage.l50;
import defpackage.me1;
import defpackage.n53;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LocationSelectTripDialog extends BottomSheetDialog implements i53, AdapterView.OnItemClickListener, AbsListView.OnScrollListener {
    public static String y = "010100|010400|010800|010900|011000|020000|030000|040000|050000|060000|070000|080000|090000|100000|110000|120000|130000|140000|150100|150201|150202|150203|150210|150301|150302|150303|150304|150401|150500|150600|150700|150800|150904|150905|150906|151100|151200|151300|160100|160400|160500|160600|170000|190100|190200|190500|190600|190700|220100";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ListView f12274a;
    public k b;
    public ProgressBar c;
    public View d;
    public View e;
    public View f;
    public View g;
    public ClearEditText h;
    public View i;
    public View j;
    public BottomSheetBehavior<FrameLayout> k;
    public boolean l;
    public com.zenmen.palmchat.location.b m;
    public LocationEx n;
    public int o;
    public int p;
    public boolean q;
    public m r;
    public View s;
    public int t;
    public View u;
    public int v;
    public boolean w;
    public Runnable x;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LocationSelectTripDialog.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LocationSelectTripDialog.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            zn6.b("page_mapfinder_postitinerary_location_search");
            LocationSelectTripDialog.this.K(2);
            if (LocationSelectTripDialog.this.k != null) {
                LocationSelectTripDialog.this.k.setState(3);
            }
            LocationSelectTripDialog.this.N();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LocationSelectTripDialog.this.K(1);
            LocationSelectTripDialog.this.J();
            LocationSelectTripDialog.this.h.setText("");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends BottomSheetBehavior.BottomSheetCallback {
        public f() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View view, float f) {
            LocationSelectTripDialog.this.O(f);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View view, int i) {
            if (i == 5) {
                LocationSelectTripDialog.this.cancel();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LocationSelectTripDialog.this.t != 2) {
                return;
            }
            LocationSelectTripDialog.this.c.setVisibility(8);
            LocationSelectTripDialog.this.e.setVisibility(8);
            if (TextUtils.isEmpty(LocationSelectTripDialog.this.I()) || LocationSelectTripDialog.this.n == null) {
                LocationSelectTripDialog.this.f12274a.setAdapter((ListAdapter) null);
                LocationSelectTripDialog.this.b = null;
                return;
            }
            if (LocationSelectTripDialog.this.f12274a != null && LocationSelectTripDialog.this.f12274a.getCount() < 1) {
                LocationSelectTripDialog.this.c.setVisibility(0);
            }
            LocationSelectTripDialog.this.b = null;
            com.zenmen.palmchat.location.b bVar = LocationSelectTripDialog.this.m;
            String strI = LocationSelectTripDialog.this.I();
            LocationEx locationEx = LocationSelectTripDialog.this.n;
            LocationSelectTripDialog.this.p = 0;
            bVar.k(100, strI, locationEx, 0, LocationSelectTripDialog.this.v, LocationSelectTripDialog.y);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LocationSelectTripDialog.this.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class j {
        public static l a(String str) {
            return new l(str, true);
        }

        public static List<l> b(List<LocationEx> list) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                Iterator<LocationEx> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new l(it.next()));
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class k extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LocationSelectTripDialog f12284a;
        public List<l> b;
        public int c = -1;

        /* JADX INFO: compiled from: SearchBox */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public TextView f12285a;
            public TextView b;
            public ImageView c;

            public a() {
            }
        }

        public k(LocationSelectTripDialog locationSelectTripDialog, List<l> list) {
            this.f12284a = locationSelectTripDialog;
            this.b = list;
        }

        public void a(List<LocationEx> list) {
            this.b.addAll(j.b(list));
            notifyDataSetChanged();
        }

        public void b(int i) {
            this.c = i;
            notifyDataSetChanged();
        }

        public final CharSequence c(Context context, String str) {
            if (TextUtils.isEmpty(str) || this.f12284a.t == 1 || TextUtils.isEmpty(this.f12284a.I())) {
                return str;
            }
            SpannableString spannableString = new SpannableString(str);
            Matcher matcher = Pattern.compile(Pattern.quote(this.f12284a.I())).matcher(spannableString);
            while (matcher.find()) {
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#14CD64")), matcher.start(), matcher.end(), 33);
            }
            return spannableString;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<l> list = this.b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.b.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            l lVar = this.b.get(i);
            LocationEx locationEx = lVar.f12286a;
            a aVar = new a();
            if (view == null) {
                view = LayoutInflater.from(this.f12284a.getContext()).inflate(R.layout.square_layout_item_poi, (ViewGroup) null);
                aVar.f12285a = (TextView) view.findViewById(R.id.name);
                aVar.b = (TextView) view.findViewById(R.id.address);
                aVar.c = (ImageView) view.findViewById(R.id.check_image);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            if (lVar.d) {
                aVar.f12285a.setTextColor(Color.parseColor("#666666"));
                aVar.f12285a.setTextSize(14.0f);
                aVar.f12285a.setText(lVar.c);
                aVar.b.setVisibility(8);
                aVar.c.setVisibility(8);
                if (i == 2) {
                    view.setPadding(k36.b(20.0f), k36.b(9.0f), k36.b(20.0f), 0);
                } else {
                    view.setPadding(k36.b(20.0f), k36.b(12.0f), k36.b(20.0f), 0);
                }
            } else {
                view.setPadding(k36.b(20.0f), k36.b(9.0f), k36.b(20.0f), k36.b(9.0f));
                aVar.f12285a.setTextColor(Color.parseColor("#222222"));
                aVar.f12285a.setTextSize(15.0f);
                aVar.b.setVisibility(0);
                aVar.c.setVisibility(0);
                if (locationEx == null) {
                    aVar.f12285a.setText("");
                    aVar.b.setText("");
                } else if (lVar.b == 1) {
                    String strH = LocationSelectTripDialog.H(locationEx);
                    if (TextUtils.isEmpty(strH)) {
                        aVar.f12285a.setText(c(view.getContext(), locationEx.getAddress()));
                    } else {
                        aVar.f12285a.setText(strH);
                        aVar.b.setVisibility(8);
                    }
                } else {
                    aVar.b.setVisibility(0);
                    if (TextUtils.isEmpty(locationEx.getName())) {
                        aVar.f12285a.setText(c(view.getContext(), locationEx.getAddress()));
                        if (this.f12284a.l) {
                            aVar.b.setText("");
                        } else {
                            aVar.b.setVisibility(8);
                        }
                    } else {
                        aVar.f12285a.setText(c(view.getContext(), locationEx.getName()));
                        aVar.b.setText(c(view.getContext(), locationEx.getAddress()));
                    }
                }
                if (i == this.c) {
                    aVar.c.setImageResource(R.drawable.square_location_selected);
                } else {
                    aVar.c.setImageResource(R.drawable.square_location_unselected);
                }
            }
            return view;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface m {
        void a(l lVar);

        void b();
    }

    public LocationSelectTripDialog(Context context, boolean z, LocationEx locationEx, m mVar) {
        super(context, R.style.SquareBottomDialog);
        this.l = true;
        this.o = 0;
        this.p = 0;
        this.q = false;
        this.s = null;
        this.t = 1;
        this.u = null;
        this.v = 1000;
        this.w = true;
        this.x = new g();
        setCanceledOnTouchOutside(false);
        View viewInflate = getLayoutInflater().inflate(R.layout.trip_layout_dialog_location_select, (ViewGroup) null);
        ListView listView = (ListView) viewInflate.findViewById(R.id.location_list);
        this.f12274a = listView;
        listView.setOnItemClickListener(this);
        this.f12274a.setOnScrollListener(this);
        this.u = viewInflate.findViewById(R.id.trip_location_title_layout);
        this.c = (ProgressBar) viewInflate.findViewById(R.id.progress_loading);
        this.d = viewInflate.findViewById(R.id.error);
        this.e = viewInflate.findViewById(R.id.empty);
        this.f = LayoutInflater.from(getContext()).inflate(R.layout.square_layout_list_loading_footer, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(R.id.arrowIcon);
        this.j = viewFindViewById;
        viewFindViewById.setOnClickListener(new a());
        this.g = viewInflate.findViewById(R.id.search_place);
        this.h = (ClearEditText) viewInflate.findViewById(R.id.search);
        this.i = viewInflate.findViewById(R.id.cancel_search);
        View viewFindViewById2 = viewInflate.findViewById(R.id.trip_release_info_close);
        this.s = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new b());
        if (viewInflate.findViewById(R.id.list_layout).getLayoutParams() != null) {
            viewInflate.findViewById(R.id.list_layout).getLayoutParams().height = (int) (((double) me1.f()) * 0.7d);
        }
        this.g.setOnClickListener(new c());
        this.i.setOnClickListener(new d());
        this.h.setClearDrawable(R.drawable.location_search_clear, R.drawable.location_search_clear);
        this.h.addTextChangedListener(new e());
        setContentView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.design_bottom_sheet);
        if (frameLayout != null) {
            try {
                BottomSheetBehavior<FrameLayout> bottomSheetBehaviorFrom = BottomSheetBehavior.from(frameLayout);
                this.k = bottomSheetBehaviorFrom;
                bottomSheetBehaviorFrom.setSkipCollapsed(true);
                this.k.setBottomSheetCallback(new f());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        O(0.0f);
        com.zenmen.palmchat.location.b bVarA = com.zenmen.palmchat.location.b.a(getContext(), null, LocationScene.FIND_MAP);
        this.m = bVarA;
        bVarA.i(this);
        this.n = locationEx;
        this.r = mVar;
    }

    public static String H(LocationEx locationEx) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(locationEx.getCity()) && !TextUtils.isEmpty(locationEx.getAdName())) {
            sb.append(locationEx.getCity());
            sb.append("·");
            sb.append(locationEx.getAdName());
        } else if (!TextUtils.isEmpty(locationEx.getCity())) {
            sb.append(locationEx.getCity());
        } else if (!TextUtils.isEmpty(locationEx.getAdName())) {
            sb.append(locationEx.getAdName());
        }
        return sb.toString();
    }

    public final List<l> F(List<LocationEx> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(j.a("附近地点"));
        arrayList.addAll(j.b(list));
        return arrayList;
    }

    public final void G(LocationEx locationEx) {
        if (locationEx != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(locationEx);
            k kVar = new k(this, F(arrayList));
            this.b = kVar;
            this.f12274a.setAdapter((ListAdapter) kVar);
            this.c.setVisibility(8);
        }
    }

    public final String I() {
        Editable text = this.h.getText();
        return text == null ? "" : text.toString().trim();
    }

    public final void J() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.h.getWindowToken(), 0);
        }
    }

    public final void K(int i2) {
        if (this.t == i2) {
            return;
        }
        this.t = i2;
        if (i2 == 1) {
            this.g.setVisibility(0);
            this.h.setVisibility(8);
            this.i.setVisibility(8);
            this.u.setVisibility(0);
            if (!this.l) {
                M();
                return;
            }
            this.f12274a.setAdapter((ListAdapter) null);
            this.b = null;
            if (this.n != null) {
                this.c.setVisibility(0);
                this.e.setVisibility(8);
                com.zenmen.palmchat.location.b bVar = this.m;
                LocationEx locationEx = this.n;
                this.p = 0;
                bVar.m(locationEx, 0, 5000, y);
                return;
            }
            return;
        }
        if (i2 != 2) {
            return;
        }
        this.g.setVisibility(8);
        this.h.setVisibility(0);
        this.i.setVisibility(0);
        this.u.setVisibility(8);
        this.f12274a.setAdapter((ListAdapter) null);
        this.b = null;
        if (TextUtils.isEmpty(I()) || this.n == null) {
            return;
        }
        this.c.setVisibility(0);
        this.e.setVisibility(8);
        com.zenmen.palmchat.location.b bVar2 = this.m;
        String strI = I();
        LocationEx locationEx2 = this.n;
        this.p = 0;
        bVar2.k(100, strI, locationEx2, 0, this.v, y);
    }

    public void L(boolean z) {
        this.l = z;
    }

    public final void M() {
        dw1.F("TripLocation showCurLocation", getContext(), new h(), this.n);
    }

    public final void N() {
        KeyboardKt.b(this.h, this, Keyboard$SHOW_FLAG.DEFAULT, 0L);
    }

    public final void O(float f2) {
        this.j.setTranslationY((1.0f - f2) * me1.b(getContext(), 32));
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        J();
        super.cancel();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        m mVar = this.r;
        if (mVar != null) {
            mVar.b();
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(67108864);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        k kVar = this.b;
        if (kVar == null || i2 >= kVar.getCount()) {
            return;
        }
        this.b.b(i2);
        l lVar = (l) this.b.getItem(i2);
        if (lVar == null || lVar.f12286a == null || lVar.d) {
            return;
        }
        m mVar = this.r;
        if (mVar != null) {
            mVar.a(lVar);
        }
        this.f12274a.postDelayed(new i(), 200L);
    }

    @Override // defpackage.i53
    public void onLocationReceived(LocationEx locationEx, int i2, String str) {
        if (k86.L(this.n) || !k86.L(locationEx)) {
            if (k86.L(this.n)) {
                return;
            }
            this.c.setVisibility(8);
            this.d.setVisibility(0);
            return;
        }
        LocationEx locationEx2 = new LocationEx(locationEx.getLatitude(), locationEx.getLongitude(), locationEx.getCoorType(), locationEx.getName(), locationEx.getAddress());
        this.n = locationEx2;
        if (this.t == 1) {
            com.zenmen.palmchat.location.b bVar = this.m;
            this.p = 0;
            bVar.m(locationEx2, 0, 5000, y);
        }
    }

    @Override // defpackage.i53
    public void onLocationSearchResultGot(int i2, List<LocationEx> list, n53 n53Var) {
        boolean z;
        if (list != null) {
            this.o = i2;
            if (this.t == 2 && n53Var != null && n53Var.b() == 1 && this.p == 0 && TextUtils.isEmpty(n53Var.a()) && !TextUtils.isEmpty(n53Var.c()) && list.isEmpty()) {
                LocationEx locationExI = com.zenmen.palmchat.location.d.g().i(864000000L);
                String city = locationExI != null ? locationExI.getCity() : null;
                if (TextUtils.isEmpty(city)) {
                    city = n53Var.d();
                }
                if (!TextUtils.isEmpty(city)) {
                    this.m.n(n53Var.c(), this.p, city);
                    return;
                }
            }
            k kVar = this.b;
            if (kVar == null) {
                if (this.n != null) {
                    Iterator<LocationEx> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        LocationEx next = it.next();
                        if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(this.n.getName()) && next.getName().equals(this.n.getName())) {
                            z = true;
                            break;
                        }
                    }
                    if (this.t == 1 && !z) {
                        list.add(0, this.n);
                    }
                }
                k kVar2 = new k(this, this.t == 1 ? F(list) : j.b(list));
                this.b = kVar2;
                this.f12274a.setAdapter((ListAdapter) kVar2);
                this.c.setVisibility(8);
            } else {
                kVar.a(list);
                this.f12274a.removeFooterView(this.f);
            }
        }
        if (this.t != 2) {
            this.e.setVisibility(8);
        } else if (list != null) {
            k kVar3 = this.b;
            if (!(kVar3 != null && kVar3.getCount() > 0) && !TextUtils.isEmpty(I())) {
                this.e.setVisibility(0);
            }
        } else {
            this.e.setVisibility(0);
        }
        if (this.c.getVisibility() == 0) {
            this.c.setVisibility(8);
        }
        this.q = false;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (i2 != 0) {
            J();
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, android.app.Dialog
    public void onStart() {
        super.onStart();
        this.f12274a.setAdapter((ListAdapter) null);
        this.b = null;
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        if (!this.l) {
            M();
            return;
        }
        if (!k86.L(this.n)) {
            com.zenmen.palmchat.location.d.g().k(LocationScene.FIND_MAP, this);
            return;
        }
        com.zenmen.palmchat.location.b bVar = this.m;
        LocationEx locationEx = this.n;
        this.p = 0;
        bVar.m(locationEx, 0, 5000, y);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onStop() {
        super.onStop();
        this.m.r(this);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LocationEx f12286a;
        public int b;
        public String c;
        public boolean d;

        public l(String str, boolean z) {
            this.c = str;
            this.d = z;
        }

        public l(LocationEx locationEx) {
            this.d = false;
            this.f12286a = locationEx;
            this.b = 2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements TextWatcher {
        public e() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            LocationSelectTripDialog.this.h.removeCallbacks(LocationSelectTripDialog.this.x);
            LocationSelectTripDialog.this.h.postDelayed(LocationSelectTripDialog.this.x, 500L);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    @Override // defpackage.i53
    public void onRegeocodeSearched(String str) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements i53 {
        public h() {
        }

        @Override // defpackage.i53
        public void onRegeocodeSearched(String str) {
            LocationSelectTripDialog.this.n.setAddress(str);
            LocationSelectTripDialog locationSelectTripDialog = LocationSelectTripDialog.this;
            locationSelectTripDialog.G(locationSelectTripDialog.n);
        }

        @Override // defpackage.i53
        public void onLocationReceived(LocationEx locationEx, int i, String str) {
        }

        @Override // defpackage.i53
        public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
    }
}
