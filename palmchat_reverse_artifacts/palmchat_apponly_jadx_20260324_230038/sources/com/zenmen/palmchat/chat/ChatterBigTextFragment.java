package com.zenmen.palmchat.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.BaseFragment;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import defpackage.a65;
import defpackage.vl1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ChatterBigTextFragment extends BaseFragment implements View.OnClickListener {
    public static final String g = "ChatterBigTextFragment";
    public TextView f;

    public final String R(MessageVo messageVo) {
        return messageVo != null ? (a65.f(messageVo.contactRelate) || messageVo.mimeType == 10002) ? a65.b(messageVo.text) : messageVo.text : "";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getActivity() != null) {
            ((ChatterActivity) getActivity()).C4();
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_fragment_big_text, (ViewGroup) null);
        viewInflate.findViewById(R.id.toolbar).setVisibility(8);
        this.f = (TextView) viewInflate.findViewById(R.id.text);
        this.f.setText(vl1.c(R((MessageVo) getArguments().getParcelable("arg")), getActivity(), vl1.g));
        viewInflate.findViewById(R.id.container).setOnClickListener(this);
        viewInflate.setOnClickListener(this);
        return viewInflate;
    }
}
