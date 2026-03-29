package com.zenmen.palmchat.login.countrycode;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.openalliance.ad.constant.w;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.login.BaseActivityWithoutCheckAccount;
import com.zenmen.palmchat.login.countrycode.b;
import com.zenmen.palmchat.widget.CharIndexView;
import com.zenmen.palmchat.zx.compat.Keyboard$SHOW_FLAG;
import com.zenmen.palmchat.zx.compat.KeyboardKt;
import defpackage.eo0;
import defpackage.gl0;
import defpackage.pn5;
import defpackage.z31;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class CountryCodeListActivity extends BaseActivityWithoutCheckAccount implements AdapterView.OnItemClickListener, AbsListView.OnScrollListener, CharIndexView.a {
    public EditText A;
    public TextView B;
    public HashMap<Character, Integer> E;
    public ArrayList<b.a> F;
    public InputMethodManager u;
    public Handler v;
    public TextView w;
    public CharIndexView x;
    public TextView y;
    public ImageView z;
    public ListView q = null;
    public com.zenmen.palmchat.login.countrycode.a r = null;
    public com.zenmen.palmchat.login.countrycode.a s = null;
    public ArrayList<b.a> t = null;
    public boolean C = false;
    public pn5<Integer> G = new gl0(new z31());
    public TextWatcher H = new e();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Comparator<b.a> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b.a aVar, b.a aVar2) {
            return aVar.a().compareTo(aVar2.a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends AsyncTask<Void, Void, Void> {
        public b() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            for (int i = 0; i < CountryCodeListActivity.this.F.size(); i++) {
                try {
                    b.a aVar = (b.a) CountryCodeListActivity.this.F.get(i);
                    if (AppContext.getContext().getResources().getConfiguration().locale.getCountry().equals("CN")) {
                        CountryCodeListActivity.this.G.a(aVar.f14464a, Integer.valueOf(i));
                    } else {
                        CountryCodeListActivity.this.G.a(aVar.c.toLowerCase(), Integer.valueOf(i));
                    }
                    CountryCodeListActivity.this.G.a(aVar.b, Integer.valueOf(i));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CountryCodeListActivity.this.I1(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CountryCodeListActivity.this.I1(false);
        }
    }

    @Override // com.zenmen.palmchat.widget.CharIndexView.a
    public void F0() {
        this.w.setVisibility(8);
    }

    public final void G1(ArrayList<b.a> arrayList) {
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            char cA = AppContext.getContext().getResources().getConfiguration().locale.getCountry().equals("CN") ? eo0.a(arrayList.get(i2).d.charAt(0)) : eo0.a(arrayList.get(i2).c.charAt(0));
            if (this.E.get(Character.valueOf(cA)) == null) {
                this.E.put(Character.valueOf(cA), Integer.valueOf(i2));
            }
        }
        char c2 = 0;
        while (true) {
            char[] cArr = CharIndexView.charArray;
            if (i >= cArr.length) {
                return;
            }
            char c3 = cArr[i];
            if (this.E.get(Character.valueOf(c3)) != null) {
                c2 = c3;
            } else if (c2 != 0) {
                this.E.put(Character.valueOf(c3), this.E.get(Character.valueOf(c2)));
            }
            i++;
        }
    }

    public final void H1() {
        new b().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void I1(boolean z) {
        if (z) {
            this.y.setVisibility(8);
            this.z.setVisibility(8);
            this.A.setVisibility(0);
            this.B.setVisibility(0);
            KeyboardKt.d(this.A, this.u, Keyboard$SHOW_FLAG.FORCE, 0L);
        } else {
            this.y.setVisibility(0);
            this.z.setVisibility(0);
            this.A.setVisibility(8);
            this.B.setVisibility(8);
            this.A.setText((CharSequence) null);
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.A.getWindowToken(), 0);
            this.q.setAdapter((ListAdapter) this.r);
        }
        this.C = z;
    }

    @Override // com.zenmen.palmchat.widget.CharIndexView.a
    public void P0(char c2) {
        int iIntValue;
        this.w.setText(Character.toString(c2));
        if (this.E.get(Character.valueOf(c2)) == null || (iIntValue = this.E.get(Character.valueOf(c2)).intValue()) < 0) {
            return;
        }
        this.q.setSelection(iIntValue);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        if (this.C) {
            I1(false);
        } else {
            super.finish();
        }
    }

    public final void initActionBar() {
        initToolbar(-1);
        TextView textView = (TextView) findViewById(R.id.title);
        this.y = textView;
        textView.setText(R.string.select_country_code);
        ImageView imageView = (ImageView) findViewById(R.id.searchIcon);
        this.z = imageView;
        imageView.setOnClickListener(new c());
        EditText editText = (EditText) findViewById(R.id.searchInput);
        this.A = editText;
        editText.addTextChangedListener(this.H);
        TextView textView2 = (TextView) findViewById(R.id.cancel_search);
        this.B = textView2;
        textView2.setOnClickListener(new d());
    }

    @Override // com.zenmen.palmchat.login.BaseActivityWithoutCheckAccount, com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_countrycodelist);
        getWindow().setSoftInputMode(2);
        this.u = (InputMethodManager) getSystemService("input_method");
        initActionBar();
        this.q = (ListView) findViewById(R.id.list);
        this.x = (CharIndexView) findViewById(R.id.index_view);
        this.w = (TextView) findViewById(R.id.char_indicator);
        this.E = new HashMap<>();
        this.x.setOnCharacterTouchedListener(this);
        this.t = new ArrayList<>();
        this.F = com.zenmen.palmchat.login.countrycode.b.b().a();
        if (!AppContext.getContext().getResources().getConfiguration().locale.getCountry().equals("CN")) {
            Collections.sort(this.F, new a());
        }
        this.r = new com.zenmen.palmchat.login.countrycode.a(this.F);
        this.s = new com.zenmen.palmchat.login.countrycode.a(this.t);
        this.q.setAdapter((ListAdapter) this.r);
        this.q.setOnItemClickListener(this);
        this.q.setOnScrollListener(this);
        G1(this.F);
        this.v = new Handler();
        H1();
        I1(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        b.a aVar = (b.a) adapterView.getAdapter().getItem(i);
        Intent intent = new Intent();
        intent.putExtra(w.v, aVar.b);
        if (AppContext.getContext().getResources().getConfiguration().locale.getCountry().equals("CN")) {
            intent.putExtra("country_name", aVar.f14464a);
        } else {
            intent.putExtra("country_name", aVar.c);
        }
        setResult(-1, intent);
        super.finish();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.u.hideSoftInputFromWindow(this.A.getWindowToken(), 0);
    }

    @Override // com.zenmen.palmchat.widget.CharIndexView.a
    public void r() {
        this.w.setVisibility(0);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements TextWatcher {
        public e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String lowerCase = editable.toString().toLowerCase();
            if (TextUtils.isEmpty(lowerCase)) {
                CountryCodeListActivity.this.q.setAdapter((ListAdapter) CountryCodeListActivity.this.r);
                return;
            }
            CountryCodeListActivity.this.t.clear();
            Iterator<Integer> it = CountryCodeListActivity.this.G.b(lowerCase).iterator();
            while (it.hasNext()) {
                CountryCodeListActivity.this.t.add((b.a) CountryCodeListActivity.this.F.get(it.next().intValue()));
            }
            CountryCodeListActivity.this.q.setAdapter((ListAdapter) CountryCodeListActivity.this.s);
            CountryCodeListActivity.this.s.notifyDataSetChanged();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
