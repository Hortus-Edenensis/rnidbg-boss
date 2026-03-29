package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.zenmen.palmchat.R;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class gu1 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f17807a;
    public ArrayList<fu1> b;
    public LayoutInflater c;

    public gu1(Context context, ArrayList<fu1> arrayList) {
        this.f17807a = context;
        this.b = arrayList;
        this.c = LayoutInflater.from(context);
    }

    public void a(hu1 hu1Var, String str, String str2, String str3, String str4, int i) {
        hu1Var.d.setText(str);
        hu1Var.e.setText(str2);
        if (str3 != null) {
            hu1Var.c.setVisibility(0);
            int iH = o86.h(str);
            hu1Var.c.setBackgroundResource(iH);
            if (iH == R.drawable.file_blue_rectangle) {
                String upperCase = o86.e(str).toUpperCase();
                if (upperCase.length() > 3) {
                    hu1Var.c.setText(upperCase.substring(0, 3) + "...");
                    hu1Var.c.setTextSize(0, (float) this.f17807a.getResources().getDimensionPixelSize(R.dimen.file_list_smail_text_size));
                } else {
                    hu1Var.c.setTextSize(0, this.f17807a.getResources().getDimensionPixelSize(R.dimen.file_list_big_text_size));
                    hu1Var.c.setText(upperCase);
                }
            } else {
                hu1Var.c.setText("");
            }
        } else {
            hu1Var.c.setVisibility(8);
        }
        if (str4 == null && i == 0) {
            hu1Var.f18053a.setVisibility(8);
            return;
        }
        if (str4 != null) {
            gr2.j().h(str4, hu1Var.f18053a, bq6.m());
            hu1Var.c.setVisibility(8);
        } else {
            hu1Var.f18053a.setImageResource(i);
        }
        hu1Var.f18053a.setVisibility(0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return this.b.get(i).c.length() > 0 ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        hu1 hu1VarA;
        if (view == null) {
            view = this.c.inflate(R.layout.layout_list_item_file_select, (ViewGroup) null, false);
            hu1VarA = hu1.a(view);
            view.setTag(hu1VarA);
        } else {
            hu1VarA = (hu1) view.getTag();
        }
        hu1 hu1Var = hu1VarA;
        fu1 fu1Var = this.b.get(i);
        int i2 = fu1Var.f17598a;
        if (i2 != 0) {
            a(hu1Var, fu1Var.b, fu1Var.c, null, null, i2);
        } else {
            a(hu1Var, fu1Var.b, fu1Var.c, fu1Var.d.toUpperCase().substring(0, Math.min(fu1Var.d.length(), 4)), fu1Var.e, 0);
        }
        File file = fu1Var.f;
        if (file == null || file.isDirectory()) {
            hu1Var.b.setVisibility(8);
        } else {
            hu1Var.b.setVisibility(0);
        }
        if (fu1Var.g) {
            hu1Var.b.setBackgroundResource(R.drawable.ic_checkbox_green_check);
        } else {
            hu1Var.b.setBackgroundResource(R.drawable.ic_checkbox_uncheck);
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
