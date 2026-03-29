package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ql1 extends ArrayAdapter<String> {
    public ql1(Context context, int i, List<String> list) {
        super(context, i, list);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(getContext(), R$layout.square_emoji_image_row_expression, null);
        }
        ImageView imageView = (ImageView) view.findViewById(R$id.iv_expression);
        String str = (String) getItem(i);
        if ("square_emoji_delete".equals(str)) {
            imageView.setImageResource(getContext().getResources().getIdentifier(str, "drawable", getContext().getPackageName()));
        } else {
            imageView.setImageResource(xl1.c(str));
        }
        return view;
    }
}
