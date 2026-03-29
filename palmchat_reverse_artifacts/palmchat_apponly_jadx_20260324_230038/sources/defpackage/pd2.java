package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.ExpandSecondLevelData;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class pd2 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<ExpandSecondLevelData> f19995a;
    public Context b;
    public String c;
    public String d;

    public pd2(Context context) {
        this.b = context;
    }

    public void a() {
        this.f19995a = null;
    }

    public List<ExpandSecondLevelData> b() {
        return this.f19995a;
    }

    public int c() {
        List<ExpandSecondLevelData> list = this.f19995a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void e(List<ExpandSecondLevelData> list) {
        this.f19995a = list;
    }

    public void f(String str, String str2) {
        this.c = str;
        this.d = str2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<ExpandSecondLevelData> list = this.f19995a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<ExpandSecondLevelData> list = this.f19995a;
        if (list != null) {
            return list.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = View.inflate(this.b, R.layout.second_level_item_view, null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_second_item);
        List<ExpandSecondLevelData> list = this.f19995a;
        if (list != null && list.size() != 0) {
            ExpandSecondLevelData expandSecondLevelData = this.f19995a.get(i);
            textView.setText(expandSecondLevelData.cateName);
            viewInflate.setTag(expandSecondLevelData);
            if (expandSecondLevelData.isSelected) {
                textView.setBackgroundResource(R.drawable.shape_react_secondlevel_select_gay);
                if (!TextUtils.isEmpty(this.c)) {
                    textView.setTextColor(Color.parseColor(this.c));
                }
            } else {
                textView.setBackgroundResource(R.drawable.shape_react_secondlevel_gay);
                if (!TextUtils.isEmpty(this.d)) {
                    textView.setTextColor(Color.parseColor(this.d));
                }
            }
        }
        return viewInflate;
    }
}
