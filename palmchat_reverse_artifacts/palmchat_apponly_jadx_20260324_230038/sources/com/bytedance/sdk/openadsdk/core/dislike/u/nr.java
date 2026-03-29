package com.bytedance.sdk.openadsdk.core.dislike.u;

import android.app.Dialog;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bytedance.sdk.openadsdk.my.fx.nr.iz;
import java.lang.reflect.Field;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private final com.bytedance.sdk.openadsdk.core.dislike.fx.nr u;

    /* JADX INFO: compiled from: SearchBox */
    public static final class u implements AdapterView.OnItemClickListener {
        private final AdapterView.OnItemClickListener nr;
        private final nr u;

        private com.bytedance.sdk.openadsdk.core.dislike.fx.fx u(Object obj) {
            if (obj == null) {
                return null;
            }
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                try {
                    declaredFields[i].setAccessible(true);
                    Object obj2 = declaredFields[i].get(obj);
                    if (obj2 instanceof iz) {
                        return new com.bytedance.sdk.openadsdk.core.dislike.fx.fx(((iz) obj2).u(), ((iz) obj2).nr());
                    }
                    continue;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Adapter adapter = adapterView.getAdapter();
            if (adapter != null) {
                Object item = adapter.getItem(i);
                if (item instanceof Function) {
                    this.u.u(u(item));
                }
            }
            AdapterView.OnItemClickListener onItemClickListener = this.nr;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i, j);
            }
        }

        private u(AdapterView.OnItemClickListener onItemClickListener, nr nrVar) {
            this.u = nrVar;
            this.nr = onItemClickListener;
        }
    }

    public nr(com.bytedance.sdk.openadsdk.core.dislike.fx.nr nrVar) {
        this.u = nrVar;
    }

    public void u(iz izVar) {
        if (this.u == null || izVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.u.u.u().u(this.u, izVar);
    }

    public static final void u(com.bytedance.sdk.openadsdk.core.dislike.fx.nr nrVar, Dialog dialog, Integer[] numArr) {
        if (numArr == null || numArr.length <= 0) {
            return;
        }
        nr nrVar2 = new nr(nrVar);
        for (Integer num : numArr) {
            View viewFindViewById = dialog.findViewById(num.intValue());
            if (viewFindViewById instanceof ListView) {
                ListView listView = (ListView) viewFindViewById;
                listView.setOnItemClickListener(new u(listView.getOnItemClickListener(), nrVar2));
            }
        }
    }
}
