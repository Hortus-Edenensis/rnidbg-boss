package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.R;
import defpackage.bn2;
import defpackage.je1;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ug3 extends BaseAdapter {
    public Context b;
    public List<bn2.c> c;
    public int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public je1 f21207a = new je1.a().s(true).t(false).u(true).q(Bitmap.Config.RGB_565).B(R.drawable.media_pick_grid_item_background).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f21208a;
        public TextView b;
        public TextView c;
        public ImageView d;

        public a() {
        }
    }

    public ug3(Context context, List<bn2.c> list) {
        this.b = context;
        this.c = list;
    }

    public void a(int i) {
        this.d = i;
        notifyDataSetChanged();
    }

    public void b(List<bn2.c> list) {
        this.c = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<bn2.c> list = this.c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<bn2.c> list = this.c;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.b).inflate(R.layout.list_item_media_folder, (ViewGroup) null);
            aVar = new a();
            aVar.f21208a = (ImageView) view.findViewById(R.id.folder_image);
            aVar.b = (TextView) view.findViewById(R.id.folder_name_text);
            aVar.c = (TextView) view.findViewById(R.id.folder_item_count_text);
            aVar.d = (ImageView) view.findViewById(R.id.folder_picked_image);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        bn2.c cVar = this.c.get(i);
        gr2.j().h(k86.p(cVar.d), aVar.f21208a, this.f21207a);
        aVar.b.setText(cVar.c);
        int i2 = cVar.e;
        if (i2 > 0) {
            aVar.c.setText(this.b.getString(R.string.media_folder_item_count, Integer.valueOf(i2)));
            aVar.c.setVisibility(0);
        } else {
            aVar.c.setVisibility(8);
        }
        if (i == this.d) {
            aVar.d.setVisibility(0);
        } else {
            aVar.d.setVisibility(8);
        }
        return view;
    }
}
