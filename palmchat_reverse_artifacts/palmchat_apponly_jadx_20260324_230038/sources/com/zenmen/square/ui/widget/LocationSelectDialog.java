package com.zenmen.square.ui.widget;

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
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationScene;
import com.zenmen.palmchat.widget.ClearEditText;
import com.zenmen.palmchat.zx.compat.Keyboard$SHOW_FLAG;
import com.zenmen.palmchat.zx.compat.KeyboardKt;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$style;
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
/* JADX INFO: loaded from: classes4.dex */
public class LocationSelectDialog extends BottomSheetDialog implements i53, AdapterView.OnItemClickListener, AbsListView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ListView f16528a;
    public j b;
    public ProgressBar c;
    public View d;
    public View e;
    public View f;
    public View g;
    public ClearEditText h;
    public View i;
    public View j;
    public BottomSheetBehavior<FrameLayout> k;
    public com.zenmen.palmchat.location.b l;
    public LocationEx m;
    public int n;
    public int o;
    public boolean p;
    public h q;
    public int r;
    public boolean s;
    public LocationScene t;
    public Runnable u;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            if (LocationSelectDialog.this.s) {
                LocationSelectDialog.this.s = false;
                zn6.c("pagephotoedit_locationlist_search", "click");
            }
            LocationSelectDialog.this.J(2);
            if (LocationSelectDialog.this.k != null) {
                LocationSelectDialog.this.k.setState(3);
            }
            LocationSelectDialog.this.L();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LocationSelectDialog.this.J(1);
            LocationSelectDialog.this.H();
            LocationSelectDialog.this.h.setText("");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LocationSelectDialog.this.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends BottomSheetBehavior.BottomSheetCallback {
        public e() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View view, float f) {
            LocationSelectDialog.this.M(f);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View view, int i) {
            if (i == 5) {
                LocationSelectDialog.this.cancel();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LocationSelectDialog.this.r != 2) {
                return;
            }
            LocationSelectDialog.this.c.setVisibility(8);
            LocationSelectDialog.this.e.setVisibility(8);
            if (TextUtils.isEmpty(LocationSelectDialog.this.G()) || LocationSelectDialog.this.m == null) {
                LocationSelectDialog.this.f16528a.setAdapter((ListAdapter) null);
                LocationSelectDialog.this.b = null;
                return;
            }
            if (LocationSelectDialog.this.f16528a != null && LocationSelectDialog.this.f16528a.getCount() < 1) {
                LocationSelectDialog.this.c.setVisibility(0);
            }
            LocationSelectDialog.this.b = null;
            LocationSelectDialog.this.l.j(LocationSelectDialog.this.G(), LocationSelectDialog.this.m, LocationSelectDialog.this.o = 0, 10000, "010000|020000|030000|040000|050000|060000|070100|070200|070300|070400|070500|070600|070700|070800|070900|071000|071100|071200|071300|071400|071500|071600|071700|071800|071900|072000|080000|090000|100000|110000|120000|130000|140000|150100|150201|150202|150203|150210|150301|150302|150303|150304|150401|150500|150600|150700|150800|150900|151000|151100|151200|151300|151400|160100|160200|160400|160500|160600|170000|180103|180200|180300|180500|190000|200400|220100|220201|220202|220203|991001|991400");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LocationSelectDialog.this.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface h {
        void a(k kVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class i {
        public static k a(LocationEx locationEx) {
            new LocationEx();
            return new k(locationEx, 1);
        }

        public static k b(String str) {
            return new k(str, true);
        }

        public static List<k> c(List<LocationEx> list) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                Iterator<LocationEx> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new k(it.next()));
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class j extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LocationSelectDialog f16536a;
        public List<k> b;
        public int c = -1;

        /* JADX INFO: compiled from: SearchBox */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public TextView f16537a;
            public TextView b;
            public ImageView c;

            public a() {
            }

            public /* synthetic */ a(a aVar) {
                this();
            }
        }

        public j(LocationSelectDialog locationSelectDialog, List<k> list) {
            this.f16536a = locationSelectDialog;
            this.b = list;
        }

        public void a(List<LocationEx> list) {
            this.b.addAll(i.c(list));
            notifyDataSetChanged();
        }

        public void b(int i) {
            this.c = i;
            notifyDataSetChanged();
        }

        public final CharSequence c(Context context, String str) {
            if (TextUtils.isEmpty(str) || this.f16536a.r == 1 || TextUtils.isEmpty(this.f16536a.G())) {
                return str;
            }
            SpannableString spannableString = new SpannableString(str);
            Matcher matcher = Pattern.compile(Pattern.quote(this.f16536a.G())).matcher(spannableString);
            while (matcher.find()) {
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#14CD64")), matcher.start(), matcher.end(), 33);
            }
            return spannableString;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<k> list = this.b;
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
            k kVar = this.b.get(i);
            LocationEx locationEx = kVar.f16538a;
            a aVar = new a(null);
            if (view == null) {
                view = LayoutInflater.from(this.f16536a.getContext()).inflate(R$layout.square_layout_item_poi, (ViewGroup) null);
                aVar.f16537a = (TextView) view.findViewById(R$id.name);
                aVar.b = (TextView) view.findViewById(R$id.address);
                aVar.c = (ImageView) view.findViewById(R$id.check_image);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            if (kVar.d) {
                aVar.f16537a.setTextColor(Color.parseColor("#666666"));
                aVar.f16537a.setTextSize(14.0f);
                aVar.f16537a.setText(kVar.c);
                aVar.b.setVisibility(8);
                aVar.c.setVisibility(8);
                if (i == 2) {
                    view.setPadding(k36.b(20.0f), k36.b(9.0f), k36.b(20.0f), 0);
                } else {
                    view.setPadding(k36.b(20.0f), k36.b(12.0f), k36.b(20.0f), 0);
                }
            } else {
                view.setPadding(k36.b(20.0f), k36.b(9.0f), k36.b(20.0f), k36.b(9.0f));
                aVar.f16537a.setTextColor(Color.parseColor("#222222"));
                aVar.f16537a.setTextSize(15.0f);
                aVar.b.setVisibility(0);
                aVar.c.setVisibility(0);
                if (locationEx == null) {
                    aVar.f16537a.setText("");
                    aVar.b.setText("");
                } else if (kVar.b == 1) {
                    String strF = LocationSelectDialog.F(locationEx);
                    if (TextUtils.isEmpty(strF)) {
                        aVar.f16537a.setText(c(view.getContext(), locationEx.getAddress()));
                    } else {
                        aVar.f16537a.setText(strF);
                        aVar.b.setVisibility(8);
                    }
                } else if (TextUtils.isEmpty(locationEx.getName())) {
                    aVar.f16537a.setText(c(view.getContext(), locationEx.getAddress()));
                    aVar.b.setText("");
                } else {
                    aVar.f16537a.setText(c(view.getContext(), locationEx.getName()));
                    aVar.b.setText(c(view.getContext(), locationEx.getAddress()));
                }
                if (i == this.c) {
                    aVar.c.setImageResource(R$drawable.square_location_selected);
                } else {
                    aVar.c.setImageResource(R$drawable.square_location_unselected);
                }
            }
            return view;
        }
    }

    public LocationSelectDialog(Context context, boolean z, LocationEx locationEx, h hVar, LocationScene locationScene) {
        super(context, R$style.SquareBottomDialog);
        this.n = 0;
        this.o = 0;
        this.p = false;
        this.r = 1;
        this.s = true;
        this.t = LocationScene.PUBLISH_SQUARE;
        this.u = new f();
        View viewInflate = getLayoutInflater().inflate(R$layout.square_layout_dialog_location_select, (ViewGroup) null);
        ListView listView = (ListView) viewInflate.findViewById(R$id.location_list);
        this.f16528a = listView;
        listView.setOnItemClickListener(this);
        this.f16528a.setOnScrollListener(this);
        this.c = (ProgressBar) viewInflate.findViewById(R$id.progress_loading);
        this.d = viewInflate.findViewById(R$id.error);
        this.e = viewInflate.findViewById(R$id.empty);
        this.f = LayoutInflater.from(getContext()).inflate(R$layout.square_layout_list_loading_footer, (ViewGroup) null);
        this.j = viewInflate.findViewById(R$id.arrowIcon);
        this.g = viewInflate.findViewById(R$id.search_place);
        this.h = (ClearEditText) viewInflate.findViewById(R$id.search);
        this.i = viewInflate.findViewById(R$id.cancel_search);
        int i2 = R$id.list_layout;
        if (viewInflate.findViewById(i2).getLayoutParams() != null) {
            viewInflate.findViewById(i2).getLayoutParams().height = (int) (((double) me1.f()) * 0.7d);
        }
        this.g.setOnClickListener(new a());
        this.i.setOnClickListener(new b());
        viewInflate.setOnClickListener(new c());
        ClearEditText clearEditText = this.h;
        int i3 = R$drawable.location_search_clear;
        clearEditText.setClearDrawable(i3, i3);
        this.h.addTextChangedListener(new d());
        setContentView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.design_bottom_sheet);
        if (frameLayout != null) {
            try {
                BottomSheetBehavior<FrameLayout> bottomSheetBehaviorFrom = BottomSheetBehavior.from(frameLayout);
                this.k = bottomSheetBehaviorFrom;
                bottomSheetBehaviorFrom.setSkipCollapsed(true);
                this.k.setBottomSheetCallback(new e());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        M(0.0f);
        com.zenmen.palmchat.location.b bVarA = com.zenmen.palmchat.location.b.a(getContext(), null, locationScene);
        this.l = bVarA;
        bVarA.i(this);
        this.t = locationScene;
        this.m = locationEx;
        this.q = hVar;
    }

    public static String F(LocationEx locationEx) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(locationEx.getCity()) && !TextUtils.isEmpty(locationEx.getAdName())) {
            sb.append(locationEx.getCity());
            sb.append("·");
            sb.append(locationEx.getAdName());
        } else if (!TextUtils.isEmpty(locationEx.getCity())) {
            sb.append(locationEx.getCity());
        } else if (!TextUtils.isEmpty(locationEx.getAdName())) {
            sb.append(locationEx.getAdName());
        } else if (!TextUtils.isEmpty(locationEx.getName())) {
            sb.append(locationEx.getName());
        }
        return sb.toString();
    }

    public final List<k> E(List<LocationEx> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(i.b("地区定位"));
        if (list != null && !list.isEmpty()) {
            arrayList.add(i.a(list.get(0)));
        }
        if (list != null && list.size() > 1) {
            arrayList.add(i.b("更多位置"));
            arrayList.addAll(i.c(list));
        }
        return arrayList;
    }

    public final String G() {
        Editable text = this.h.getText();
        return text == null ? "" : text.toString().trim();
    }

    public final void H() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.h.getWindowToken(), 0);
        }
    }

    public final boolean I(String str, String str2) {
        if (str2 != null) {
            str2 = str2.trim();
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains(str2.toLowerCase());
    }

    public final void J(int i2) {
        if (this.r == i2) {
            return;
        }
        this.r = i2;
        if (i2 == 1) {
            this.g.setVisibility(0);
            this.h.setVisibility(8);
            this.i.setVisibility(8);
            this.f16528a.setAdapter((ListAdapter) null);
            this.b = null;
            if (this.m != null) {
                if (!com.zenmen.palmchat.location.c.b().pageMultipleEditSurrounding) {
                    K();
                    return;
                }
                this.c.setVisibility(0);
                this.e.setVisibility(8);
                com.zenmen.palmchat.location.b bVar = this.l;
                LocationEx locationEx = this.m;
                this.o = 0;
                bVar.m(locationEx, 0, 500, "010000|020000|030000|040000|050000|060000|070100|070200|070300|070400|070500|070600|070700|070800|070900|071000|071100|071200|071300|071400|071500|071600|071700|071800|071900|072000|080000|090000|100000|110000|120000|130000|140000|150100|150201|150202|150203|150210|150301|150302|150303|150304|150401|150500|150600|150700|150800|150900|151000|151100|151200|151300|151400|160100|160200|160400|160500|160600|170000|180103|180200|180300|180500|190000|200400|220100|220201|220202|220203|991001|991400");
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
        this.f16528a.setAdapter((ListAdapter) null);
        this.b = null;
        if (TextUtils.isEmpty(G()) || this.m == null) {
            return;
        }
        this.c.setVisibility(0);
        this.e.setVisibility(8);
        com.zenmen.palmchat.location.b bVar2 = this.l;
        String strG = G();
        LocationEx locationEx2 = this.m;
        this.o = 0;
        bVar2.j(strG, locationEx2, 0, 1000, "010000|020000|030000|040000|050000|060000|070100|070200|070300|070400|070500|070600|070700|070800|070900|071000|071100|071200|071300|071400|071500|071600|071700|071800|071900|072000|080000|090000|100000|110000|120000|130000|140000|150100|150201|150202|150203|150210|150301|150302|150303|150304|150401|150500|150600|150700|150800|150900|151000|151100|151200|151300|151400|160100|160200|160400|160500|160600|170000|180103|180200|180300|180500|190000|200400|220100|220201|220202|220203|991001|991400");
    }

    public final void K() {
        ArrayList arrayList = new ArrayList();
        LocationEx locationEx = this.m;
        if (locationEx != null) {
            arrayList.add(0, locationEx);
        }
        j jVar = new j(this, E(arrayList));
        this.b = jVar;
        this.f16528a.setAdapter((ListAdapter) jVar);
        this.c.setVisibility(8);
    }

    public final void L() {
        KeyboardKt.b(this.h, this, Keyboard$SHOW_FLAG.DEFAULT, 0L);
    }

    public final void M(float f2) {
        this.j.setTranslationY((1.0f - f2) * me1.b(getContext(), 32));
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        H();
        super.cancel();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(67108864);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        j jVar = this.b;
        if (jVar == null || i2 >= jVar.getCount()) {
            return;
        }
        this.b.b(i2);
        k kVar = (k) this.b.getItem(i2);
        if (kVar == null || kVar.f16538a == null || kVar.d) {
            return;
        }
        h hVar = this.q;
        if (hVar != null) {
            hVar.a(kVar);
        }
        this.f16528a.postDelayed(new g(), 200L);
    }

    @Override // defpackage.i53
    public void onLocationReceived(LocationEx locationEx, int i2, String str) {
        if (k86.L(this.m) || !k86.L(locationEx)) {
            if (k86.L(this.m)) {
                return;
            }
            this.c.setVisibility(8);
            this.d.setVisibility(0);
            return;
        }
        LocationEx locationEx2 = new LocationEx(locationEx.getLatitude(), locationEx.getLongitude(), locationEx.getCoorType(), locationEx.getName(), locationEx.getAddress());
        this.m = locationEx2;
        if (this.r == 1) {
            com.zenmen.palmchat.location.b bVar = this.l;
            this.o = 0;
            bVar.m(locationEx2, 0, 500, "010000|020000|030000|040000|050000|060000|070100|070200|070300|070400|070500|070600|070700|070800|070900|071000|071100|071200|071300|071400|071500|071600|071700|071800|071900|072000|080000|090000|100000|110000|120000|130000|140000|150100|150201|150202|150203|150210|150301|150302|150303|150304|150401|150500|150600|150700|150800|150900|151000|151100|151200|151300|151400|160100|160200|160400|160500|160600|170000|180103|180200|180300|180500|190000|200400|220100|220201|220202|220203|991001|991400");
        }
    }

    @Override // defpackage.i53
    public void onLocationSearchResultGot(int i2, List<LocationEx> list, n53 n53Var) {
        boolean z;
        if (list != null) {
            this.n = i2;
            if (this.r == 2) {
                String strG = G();
                Iterator<LocationEx> it = list.iterator();
                while (it.hasNext()) {
                    LocationEx next = it.next();
                    String name = next.getName();
                    String address = next.getAddress();
                    if (!I(name, strG) && !I(address, strG)) {
                        it.remove();
                    }
                }
                if (this.o < this.n - 1 && list.isEmpty() && !TextUtils.isEmpty(G()) && this.m != null) {
                    com.zenmen.palmchat.location.b bVar = this.l;
                    String strG2 = G();
                    LocationEx locationEx = this.m;
                    int i3 = this.o + 1;
                    this.o = i3;
                    bVar.j(strG2, locationEx, i3, 1000, "010000|020000|030000|040000|050000|060000|070100|070200|070300|070400|070500|070600|070700|070800|070900|071000|071100|071200|071300|071400|071500|071600|071700|071800|071900|072000|080000|090000|100000|110000|120000|130000|140000|150100|150201|150202|150203|150210|150301|150302|150303|150304|150401|150500|150600|150700|150800|150900|151000|151100|151200|151300|151400|160100|160200|160400|160500|160600|170000|180103|180200|180300|180500|190000|200400|220100|220201|220202|220203|991001|991400");
                    return;
                }
            }
            j jVar = this.b;
            if (jVar == null) {
                if (this.m != null) {
                    Iterator<LocationEx> it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = false;
                            break;
                        }
                        LocationEx next2 = it2.next();
                        if (!TextUtils.isEmpty(next2.getName()) && !TextUtils.isEmpty(this.m.getName()) && next2.getName().equals(this.m.getName())) {
                            z = true;
                            break;
                        }
                    }
                    if (this.r == 1 && !z) {
                        list.add(0, this.m);
                    }
                }
                j jVar2 = new j(this, this.r == 1 ? E(list) : i.c(list));
                this.b = jVar2;
                this.f16528a.setAdapter((ListAdapter) jVar2);
                this.c.setVisibility(8);
            } else {
                jVar.a(list);
                this.f16528a.removeFooterView(this.f);
            }
        }
        if (this.r != 2) {
            this.e.setVisibility(8);
        } else if (list != null) {
            j jVar3 = this.b;
            if (!(jVar3 != null && jVar3.getCount() > 0) && !TextUtils.isEmpty(G())) {
                this.e.setVisibility(0);
            }
        } else {
            this.e.setVisibility(0);
        }
        if (this.c.getVisibility() == 0) {
            this.c.setVisibility(8);
        }
        this.p = false;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (i2 != 0) {
            H();
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, android.app.Dialog
    public void onStart() {
        super.onStart();
        this.f16528a.setAdapter((ListAdapter) null);
        this.b = null;
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        if (!k86.L(this.m)) {
            com.zenmen.palmchat.location.d.g().k(this.t, this);
            return;
        }
        if (!com.zenmen.palmchat.location.c.b().pageMultipleEditSurrounding) {
            K();
            return;
        }
        com.zenmen.palmchat.location.b bVar = this.l;
        LocationEx locationEx = this.m;
        this.o = 0;
        bVar.m(locationEx, 0, 500, "010000|020000|030000|040000|050000|060000|070100|070200|070300|070400|070500|070600|070700|070800|070900|071000|071100|071200|071300|071400|071500|071600|071700|071800|071900|072000|080000|090000|100000|110000|120000|130000|140000|150100|150201|150202|150203|150210|150301|150302|150303|150304|150401|150500|150600|150700|150800|150900|151000|151100|151200|151300|151400|160100|160200|160400|160500|160600|170000|180103|180200|180300|180500|190000|200400|220100|220201|220202|220203|991001|991400");
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onStop() {
        super.onStop();
        this.l.r(this);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LocationEx f16538a;
        public int b;
        public String c;
        public boolean d;

        public k(String str, boolean z) {
            this.c = str;
            this.d = z;
        }

        public k(LocationEx locationEx, int i) {
            this.d = false;
            this.f16538a = locationEx;
            this.b = i;
        }

        public k(LocationEx locationEx) {
            this.d = false;
            this.f16538a = locationEx;
            this.b = 2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements TextWatcher {
        public d() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            LocationSelectDialog.this.h.removeCallbacks(LocationSelectDialog.this.u);
            LocationSelectDialog.this.h.postDelayed(LocationSelectDialog.this.u, 500L);
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

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
    }
}
