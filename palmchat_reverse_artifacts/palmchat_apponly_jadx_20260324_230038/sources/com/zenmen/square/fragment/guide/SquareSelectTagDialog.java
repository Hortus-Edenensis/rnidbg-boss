package com.zenmen.square.fragment.guide;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.activity.SquareFirstPublicActivity;
import com.zenmen.square.tag.adapter.SquareTagAdapter;
import com.zenmen.square.tag.bean.CommonResponse;
import com.zenmen.square.tag.bean.SquareTagBean;
import com.zenmen.square.tag.widget.SquareTagSelectHelper;
import com.zenmen.square.ui.widget.TagSubmitButton;
import defpackage.ai5;
import defpackage.bj5;
import defpackage.ds0;
import defpackage.k86;
import defpackage.l50;
import defpackage.me1;
import defpackage.ro2;
import defpackage.sy5;
import defpackage.tj5;
import defpackage.tw4;
import defpackage.uo2;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareSelectTagDialog extends LXBottomSheetDialog {
    public SquareTagSelectHelper h;
    public TextView i;
    public TagSubmitButton j;
    public int k;
    public uo2 l;
    public ro2.a m;
    public boolean n;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ArrayList<SquareTagBean> selectedBeans = SquareSelectTagDialog.this.h.getSelectedBeans();
            if (selectedBeans != null && !selectedBeans.isEmpty()) {
                SquareSelectTagDialog.this.I(selectedBeans);
            }
            zn6.c("pagediscover_pageleadtag_next", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends tw4<CommonResponse<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f16359a;

        public c(ArrayList arrayList) {
            this.f16359a = arrayList;
        }

        @Override // defpackage.tw4
        public void a(CommonResponse<String> commonResponse) {
            SquareSelectTagDialog.this.q();
            if (commonResponse.getResultCode() == 0) {
                SquareSelectTagDialog.this.G(this.f16359a);
                SquareSelectTagDialog.this.J(true);
                SquareSelectTagDialog.this.dismiss();
            } else {
                sy5.f(SquareSelectTagDialog.this.getContext(), SquareSelectTagDialog.this.getContext().getString(R$string.square_operation_fail), 1).g();
            }
            ds0.a().b(new tj5());
        }

        @Override // defpackage.tw4
        public void b(int i, String str) {
            super.b(i, str);
            SquareSelectTagDialog.this.q();
            sy5.f(SquareSelectTagDialog.this.getContext(), SquareSelectTagDialog.this.getContext().getString(R$string.square_operation_fail), 1).g();
        }
    }

    public SquareSelectTagDialog(@NonNull Context context, boolean z, ro2.a aVar) {
        super(context);
        this.m = aVar;
        this.n = z;
    }

    public static void K(Context context, boolean z, ro2.a aVar) {
        SquareSelectTagDialog squareSelectTagDialog = new SquareSelectTagDialog(context, z, aVar);
        squareSelectTagDialog.t(me1.b(context, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME));
        squareSelectTagDialog.show();
    }

    public final void E() {
        ArrayList<SquareTagBean> selectedBeans = this.h.getSelectedBeans();
        this.j.setSelectTagCount((selectedBeans == null || selectedBeans.isEmpty()) ? 0 : selectedBeans.size());
    }

    public final void F(View view) {
        this.i = (TextView) view.findViewById(R$id.sub_title);
        String pagetagintro = ai5.k().j().getGuideInfo().getPagetagintro();
        if (!TextUtils.isEmpty(pagetagintro)) {
            this.i.setText(pagetagintro);
        }
        this.h = (SquareTagSelectHelper) view.findViewById(R$id.tag);
        TagSubmitButton tagSubmitButton = (TagSubmitButton) view.findViewById(R$id.confirm);
        this.j = tagSubmitButton;
        tagSubmitButton.setMinTagCount(this.k);
        this.h.bind(new a());
        this.j.setOnClickListener(new b());
        E();
        zn6.c("pagediscover_pageleadtag", "view");
    }

    public final void G(ArrayList<SquareTagBean> arrayList) {
        Intent intent = new Intent(getContext(), (Class<?>) SquareFirstPublicActivity.class);
        k86.X(intent);
        intent.putParcelableArrayListExtra("extra_tag", arrayList);
        intent.putExtra("key_goto_square", this.n);
        getContext().startActivity(intent);
    }

    public final void H() {
        this.h.load();
    }

    public final void I(ArrayList<SquareTagBean> arrayList) {
        JSONArray jSONArray = new JSONArray();
        Iterator<SquareTagBean> it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().getId());
        }
        this.l.a(jSONArray, false, new c(arrayList));
        y();
    }

    public final void J(boolean z) {
        ro2.a aVar = this.m;
        if (aVar != null) {
            if (z) {
                aVar.onSuccess();
            } else {
                aVar.onCancel();
            }
            this.m = null;
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (this.m != null) {
            zn6.c("pagediscover_pageleadtag_close", "click");
        }
        J(false);
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
    public View n() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.square_layout_dialog_first_select_tag, (ViewGroup) null);
        this.k = ai5.k().j().getMinSelectTagCount();
        this.l = bj5.b().c();
        F(viewInflate);
        H();
        return viewInflate;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements SquareTagSelectHelper.f {
        public a() {
        }

        @Override // com.zenmen.square.tag.widget.SquareTagSelectHelper.f
        public void a() {
            SquareSelectTagDialog.this.E();
        }

        @Override // com.zenmen.square.tag.widget.SquareTagSelectHelper.f
        public void b(SquareTagAdapter.a aVar) {
            SquareSelectTagDialog.this.E();
        }

        @Override // com.zenmen.square.tag.widget.SquareTagSelectHelper.f
        public SquareTagSelectHelper.Scene getScene() {
            return SquareTagSelectHelper.Scene.REGISTER;
        }

        @Override // com.zenmen.square.tag.widget.SquareTagSelectHelper.f
        public void c() {
        }
    }
}
