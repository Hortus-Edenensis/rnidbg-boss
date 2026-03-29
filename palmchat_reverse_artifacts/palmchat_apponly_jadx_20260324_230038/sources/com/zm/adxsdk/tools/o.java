package com.zm.adxsdk.tools;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hms.ads.ex;
import com.zm.fission.fataar.R$color;
import com.zm.fission.fataar.R$drawable;
import com.zm.fission.fataar.R$id;
import com.zm.fission.fataar.R$layout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class o extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f16609a;
    public final LayoutInflater b;
    public final Context c;

    public o(Context context, ArrayList arrayList) {
        this.c = context;
        this.f16609a = arrayList;
        this.b = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List list = this.f16609a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        List list = this.f16609a;
        if (list == null || i >= list.size()) {
            return null;
        }
        return this.f16609a.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        List list = this.f16609a;
        if (list == null || i >= list.size() || this.f16609a.get(i) == null) {
            return -1;
        }
        return ((l) this.f16609a.get(i)).a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x0146, code lost:
    
        if (r10 != null) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01ad  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        n nVar;
        Context context;
        TextView textView;
        Resources resources;
        int i2;
        Context context2;
        TextView textView2;
        Resources resources2;
        int i3;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = this.b.inflate(itemViewType != 0 ? itemViewType != 1 ? itemViewType != 2 ? itemViewType != 3 ? itemViewType != 4 ? 0 : R$layout.wf_shell_df_item_privacy : R$layout.wf_shell_df_item_basic_dependency : R$layout.wf_shell_df_item_common_params : R$layout.wf_shell_df_item_app_info : R$layout.wf_shell_df_item_title, viewGroup, false);
            nVar = new n();
            if (view != null) {
                nVar.f16608a = (TextView) view.findViewById(R$id.wf_sdk_df_item_title);
                nVar.b = (TextView) view.findViewById(R$id.wf_sdk_df_item_txt);
                nVar.c = (TextView) view.findViewById(R$id.wf_sdk_df_item_extra);
                nVar.d = (ImageView) view.findViewById(R$id.wf_sdk_df_item_image_dependency);
            }
            if (view != null) {
                view.setTag(nVar);
            }
        } else {
            nVar = (n) view.getTag();
        }
        List list = this.f16609a;
        if (list != null && nVar != null && i < list.size()) {
            l lVar = (l) this.f16609a.get(i);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    if (itemViewType != 2) {
                        if (itemViewType != 3) {
                            if (itemViewType == 4 && (lVar instanceof p)) {
                                p pVar = (p) lVar;
                                TextView textView3 = nVar.f16608a;
                                if (textView3 != null) {
                                    textView3.setText(pVar.f16607a);
                                }
                                if (pVar.c) {
                                    TextView textView4 = nVar.b;
                                    if (textView4 != null) {
                                        textView4.setText("");
                                    }
                                    TextView textView5 = nVar.c;
                                    if (textView5 != null) {
                                        textView5.setText("YES");
                                        Context context3 = this.c;
                                        if (context3 != null) {
                                            textView2 = nVar.c;
                                            resources2 = context3.getResources();
                                            i3 = R$color.wf_shell_df_success_warn;
                                            textView2.setTextColor(resources2.getColor(i3));
                                        }
                                    }
                                } else {
                                    TextView textView6 = nVar.b;
                                    if (textView6 != null) {
                                        textView6.setText(pVar.b);
                                    }
                                    TextView textView7 = nVar.c;
                                    if (textView7 != null) {
                                        textView7.setText("NO");
                                        context2 = this.c;
                                        if (context2 != null) {
                                            textView2 = nVar.c;
                                            resources2 = context2.getResources();
                                            i3 = R$color.wf_shell_df_error_warn;
                                            textView2.setTextColor(resources2.getColor(i3));
                                        }
                                    }
                                }
                            }
                        } else if (lVar instanceof h) {
                            h hVar = (h) lVar;
                            TextView textView8 = nVar.f16608a;
                            if (textView8 != null) {
                                textView8.setText(hVar.f16607a);
                            }
                            if (nVar.c != null) {
                                if (TextUtils.isEmpty(hVar.d)) {
                                    nVar.c.setVisibility(8);
                                } else {
                                    nVar.c.setVisibility(0);
                                    nVar.c.setText(hVar.d);
                                }
                            }
                            TextView textView9 = nVar.b;
                            if (textView9 != null) {
                                textView9.setText(hVar.c);
                            }
                            if (hVar.b) {
                                ImageView imageView = nVar.d;
                                if (imageView != null) {
                                    imageView.setImageResource(R$drawable.wf_shell_df_icon_right);
                                }
                                Context context4 = this.c;
                                if (context4 != null && (textView2 = nVar.b) != null) {
                                    resources2 = context4.getResources();
                                    i3 = R$color.wf_shell_df_title_8;
                                    textView2.setTextColor(resources2.getColor(i3));
                                }
                            } else {
                                ImageView imageView2 = nVar.d;
                                if (imageView2 != null) {
                                    imageView2.setImageResource(R$drawable.wf_shell_df_icon_wrong);
                                }
                                context2 = this.c;
                                if (context2 != null) {
                                    textView2 = nVar.b;
                                }
                            }
                        }
                    } else if (lVar instanceof e) {
                        e eVar = (e) lVar;
                        TextView textView10 = nVar.f16608a;
                        if (textView10 != null) {
                            textView10.setText(eVar.f16607a);
                        }
                        TextView textView11 = nVar.b;
                        if (textView11 != null) {
                            Context context5 = this.c;
                            if (context5 != null) {
                                textView11.setTextColor(context5.getResources().getColor(R$color.wf_shell_df_title_8));
                            }
                            String str = eVar.b;
                            if (TextUtils.isEmpty(str)) {
                                nVar.b.setText("未传递");
                                Context context6 = this.c;
                                if (context6 != null) {
                                    nVar.b.setTextColor(context6.getResources().getColor(R$color.wf_shell_df_advice));
                                }
                            } else if (!TextUtils.isEmpty(str)) {
                                HashSet hashSet = f.c;
                                if (!hashSet.isEmpty() && hashSet.contains(str)) {
                                    Context context7 = this.c;
                                    if (context7 != null) {
                                        nVar.b.setTextColor(context7.getResources().getColor(R$color.wf_shell_df_error_warn));
                                    }
                                    str = str + "(测试ID)";
                                } else if (eVar.f16607a.equals("UserAgent") && (TextUtils.isEmpty(str) || !str.startsWith("Mozilla"))) {
                                    Context context8 = this.c;
                                    if (context8 != null) {
                                        nVar.b.setTextColor(context8.getResources().getColor(R$color.wf_shell_df_error_warn));
                                    }
                                    str = str + "(错误格式)";
                                }
                                nVar.b.setText(str);
                            }
                        }
                    }
                } else if (lVar instanceof b) {
                    b bVar = (b) lVar;
                    TextView textView12 = nVar.f16608a;
                    if (textView12 != null) {
                        textView12.setText(bVar.f16607a);
                    }
                    TextView textView13 = nVar.b;
                    if (textView13 != null) {
                        String str2 = bVar.b;
                        Context context9 = this.c;
                        if (context9 != null) {
                            textView13.setTextColor(context9.getResources().getColor(R$color.wf_shell_df_title_8));
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            HashSet hashSet2 = f.c;
                            if (!hashSet2.isEmpty() && hashSet2.contains(str2)) {
                                str2 = str2 + "(测试ID)";
                                Context context10 = this.c;
                                if (context10 != null) {
                                    nVar.b.setTextColor(context10.getResources().getColor(R$color.wf_shell_df_error_warn));
                                }
                            }
                        }
                        nVar.b.setText(str2);
                        if (ex.V.equals(str2)) {
                            Context context11 = this.c;
                            if (context11 != null) {
                                textView = nVar.b;
                                resources = context11.getResources();
                                i2 = R$color.wf_shell_df_error_warn;
                                textView.setTextColor(resources.getColor(i2));
                            }
                        } else if (ex.Code.equals(str2) && (context = this.c) != null) {
                            textView = nVar.b;
                            resources = context.getResources();
                            i2 = R$color.wf_shell_df_success_warn;
                            textView.setTextColor(resources.getColor(i2));
                        }
                    }
                }
            } else if (lVar instanceof m) {
                m mVar = (m) lVar;
                TextView textView14 = nVar.f16608a;
                if (textView14 != null) {
                    textView14.setText(mVar.f16607a);
                }
            }
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 5;
    }
}
