package com.zenmen.palmchat.QRCodeScan;

import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.palmchat.widget.SocialPortraitView;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.il5;
import defpackage.me1;
import defpackage.n43;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public final class QRCodeDialog extends DialogFragment {
    public ImageView d;
    public EffectiveShapeView e;
    public String f;

    public static QRCodeDialog D(String str) {
        QRCodeDialog qRCodeDialog = new QRCodeDialog();
        qRCodeDialog.f = str;
        qRCodeDialog.setArguments(new Bundle());
        return qRCodeDialog;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        ContactInfoItem contactInfoItemL;
        Dialog dialog = new Dialog(getActivity(), R.style.empty_dialog);
        dialog.setContentView(R.layout.layout_qrcode_dialog);
        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
        attributes.dimAmount = 0.5f;
        dialog.getWindow().setAttributes(attributes);
        dialog.getWindow().addFlags(2);
        dialog.setCanceledOnTouchOutside(true);
        this.d = (ImageView) dialog.findViewById(R.id.qrcode_image);
        EffectiveShapeView effectiveShapeView = (EffectiveShapeView) dialog.findViewById(R.id.qrcode_logo);
        this.e = effectiveShapeView;
        effectiveShapeView.changeShapeType(3);
        this.e.setDegreeForRoundRectangle(13, 13);
        this.e.setBorderWidth(me1.a(getActivity(), 3.0f));
        this.e.setBorderColor(-1);
        TextView textView = (TextView) dialog.findViewById(R.id.nickname_textview);
        TextView textView2 = (TextView) dialog.findViewById(R.id.uid_textview);
        SocialPortraitView socialPortraitView = (SocialPortraitView) dialog.findViewById(R.id.portrait);
        socialPortraitView.changeShapeType(3);
        socialPortraitView.setDegreeForRoundRectangle(19, 19);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.img_gender);
        String strP = AccountUtils.p(AppContext.getContext());
        if (!TextUtils.isEmpty(strP) && (contactInfoItemL = bo0.r().l(strP)) != null) {
            textView.setText(contactInfoItemL.getNickName());
            if (contactInfoItemL.getGender() == 0) {
                imageView.setImageResource(R.drawable.nearby_gender_male);
            } else if (contactInfoItemL.getGender() == 1) {
                imageView.setImageResource(R.drawable.nearby_gender_female);
            } else {
                imageView.setVisibility(8);
            }
            textView2.setText(il5.i(AppContext.getContext(), contactInfoItemL.getCountry(), contactInfoItemL.getProvince(), contactInfoItemL.getCity()));
            if (!TextUtils.isEmpty(contactInfoItemL.getIconURL())) {
                gr2.j().h(contactInfoItemL.getIconURL(), socialPortraitView, bq6.s());
            }
        }
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        new n43(this.d, this.e, "QRCodeDialog", this.f).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }
}
