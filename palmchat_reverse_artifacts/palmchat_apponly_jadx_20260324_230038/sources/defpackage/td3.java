package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.zenmen.palmchat.framework.R$color;
import com.zenmen.palmchat.framework.R$dimen;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class td3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MaterialDialog f20963a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f20964a;

        public a(c cVar) {
            this.f20964a = cVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e eVar = this.f20964a.i;
            if (eVar != null) {
                eVar.a(td3.this);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements MaterialDialog.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f20965a;

        public b(c cVar) {
            this.f20965a = cVar;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.g
        public void a(MaterialDialog materialDialog, View view, int i, CharSequence charSequence) {
            materialDialog.cancel();
            f fVar = this.f20965a.h;
            if (fVar != null) {
                fVar.a(td3.this, i, charSequence);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f20966a;
        public CharSequence b;
        public String[] c;
        public String[] d;
        public int[] e;
        public int f = -1;
        public int g = 0;
        public f h;
        public e i;

        public c(Context context) {
            this.f20966a = context;
        }

        public td3 a() {
            return new td3(this.f20966a, this);
        }

        public c b(e eVar) {
            this.i = eVar;
            return this;
        }

        public c c(String[] strArr) {
            this.c = strArr;
            return this;
        }

        public c d(f fVar) {
            this.h = fVar;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f20967a;
        public String[] b;
        public String[] c;
        public int[] d;
        public int e;
        public int f;

        /* JADX INFO: compiled from: SearchBox */
        public final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public TextView f20968a;
            public TextView b;
            public ImageView c;
            public View d;

            public a() {
            }
        }

        public d(Context context, String[] strArr, String[] strArr2, int[] iArr, int i, int i2) {
            this.f20967a = context;
            this.b = strArr;
            this.c = strArr2;
            this.d = iArr;
            this.e = i;
            this.f = i2;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            String[] strArr = this.b;
            if (strArr != null) {
                return strArr.length;
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            String[] strArr = this.b;
            if (strArr == null || i < 0 || i >= strArr.length) {
                return null;
            }
            return strArr[i];
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewInflate;
            a aVar;
            int i2;
            if (view == null) {
                aVar = new a();
                viewInflate = LayoutInflater.from(this.f20967a).inflate(R$layout.material_menu_item, (ViewGroup) null);
                aVar.f20968a = (TextView) viewInflate.findViewById(R$id.text);
                aVar.b = (TextView) viewInflate.findViewById(R$id.sub_text);
                aVar.c = (ImageView) viewInflate.findViewById(R$id.divider);
                aVar.d = viewInflate.findViewById(R$id.menu_item_content);
                viewInflate.setTag(aVar);
            } else {
                viewInflate = view;
                aVar = (a) view.getTag();
            }
            aVar.f20968a.setText(this.b[i]);
            if (this.c != null) {
                aVar.b.setVisibility(0);
                aVar.b.setText(this.c[i]);
            } else {
                aVar.b.setVisibility(8);
            }
            int[] iArr = this.d;
            if (iArr == null || i >= iArr.length) {
                aVar.f20968a.setMinHeight(this.f20967a.getResources().getDimensionPixelSize(R$dimen.md_listitem_height));
                i2 = 0;
            } else {
                i2 = iArr[i];
                int dimensionPixelSize = this.f20967a.getResources().getDimensionPixelSize(R$dimen.material_icon_menu_padding_top);
                aVar.f20968a.setPadding(0, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            }
            aVar.f20968a.setCompoundDrawablesWithIntrinsicBounds(i2, 0, this.e == i ? this.f : 0, 0);
            if (i == this.b.length - 1) {
                aVar.c.setVisibility(8);
            }
            return viewInflate;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void a(td3 td3Var);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void a(td3 td3Var, int i, CharSequence charSequence);
    }

    public td3(Context context, c cVar) {
        this.f20963a = new MaterialDialog.d(context).S(Theme.LIGHT).U(cVar.b).F(cVar.c).d(R$color.white).E(R$color.big_text_color).a(new d(context, cVar.c, cVar.d, cVar.e, cVar.f, cVar.g), new b(cVar)).h(true).g(new a(cVar)).e();
        int[] iArr = cVar.e;
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.material_icon_menu_list_padding);
        this.f20963a.m().setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
    }

    public void a() {
        this.f20963a.cancel();
    }

    public void b() {
        this.f20963a.show();
    }
}
