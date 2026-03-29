package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.zenmen.palmchat.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a03 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1129a;
    public ArrayList<tu> b;
    public int c;
    public boolean d = true;

    /* JADX INFO: compiled from: SearchBox */
    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f1130a;
        public RelativeLayout b;
        public RelativeLayout c;

        public a() {
        }
    }

    public a03(Context context, ArrayList<tu> arrayList, int i) {
        this.f1129a = context;
        this.b = arrayList;
        this.c = i;
    }

    public void a(boolean z) {
        this.d = z;
        notifyDataSetChanged();
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
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.f1129a, R.layout.grid_item_virtual_keyboard, null);
            aVar = new a();
            aVar.f1130a = (TextView) view.findViewById(R.id.btn_keys);
            aVar.c = (RelativeLayout) view.findViewById(R.id.imgDelete);
            aVar.b = (RelativeLayout) view.findViewById(R.id.ll_keyboard);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.f1130a.setTextColor(this.c);
        Drawable drawableWrap = DrawableCompat.wrap(ContextCompat.getDrawable(this.f1129a, R.mipmap.keyboard_delete_img));
        DrawableCompat.setTint(drawableWrap, this.c);
        if (i == 9) {
            aVar.c.setVisibility(4);
            aVar.f1130a.setText(this.b.get(i).a());
            if (this.d) {
                aVar.f1130a.setVisibility(0);
                aVar.f1130a.setEnabled(true);
            } else {
                aVar.f1130a.setVisibility(8);
                aVar.f1130a.setEnabled(false);
            }
        } else if (i == 11) {
            aVar.f1130a.setBackgroundDrawable(drawableWrap);
            aVar.c.setVisibility(0);
            aVar.f1130a.setVisibility(4);
        } else {
            aVar.c.setVisibility(4);
            aVar.f1130a.setVisibility(0);
            aVar.f1130a.setText(this.b.get(i).a());
        }
        return view;
    }
}
