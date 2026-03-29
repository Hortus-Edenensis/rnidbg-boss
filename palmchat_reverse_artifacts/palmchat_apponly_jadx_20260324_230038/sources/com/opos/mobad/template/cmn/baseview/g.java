package com.opos.mobad.template.cmn.baseview;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class g {
    public static boolean a(View view, h hVar, MotionEvent motionEvent, f fVar) {
        if (view == null || hVar == null) {
            return true;
        }
        com.opos.cmn.an.f.a.b("InterceptViewTool", "checkTouchEventEnable:" + view.getClass().getName());
        boolean zA = hVar.a(motionEvent);
        com.opos.cmn.an.f.a.b("InterceptViewTool", "checkTouchEnable:" + zA);
        if (!zA && fVar != null) {
            boolean zA2 = com.opos.mobad.template.g.a();
            com.opos.cmn.an.f.a.b("InterceptViewTool", "shouldCheckViewMockClick:" + zA2);
            fVar.a(view, 3, zA2);
        }
        if (com.opos.mobad.template.g.a()) {
            return zA;
        }
        return true;
    }

    public static boolean b(View view, h hVar, f fVar) {
        if (view == null || hVar == null) {
            return true;
        }
        com.opos.cmn.an.f.a.b("InterceptViewTool", "checkPerformClickEnable:" + view.getClass().getName());
        boolean zA = hVar.a();
        com.opos.cmn.an.f.a.b("InterceptViewTool", "checkClickEnable:" + zA);
        if (!zA && fVar != null) {
            boolean zA2 = com.opos.mobad.template.g.a();
            com.opos.cmn.an.f.a.b("InterceptViewTool", "shouldCheckViewMockClick:" + zA2);
            fVar.a(view, 2, zA2);
        }
        if (!com.opos.mobad.template.g.a()) {
            return true;
        }
        com.opos.cmn.an.f.a.b("InterceptViewTool", "checkPerformClickEnable:" + view.getClass().getName());
        return zA;
    }

    public static boolean a(View view, h hVar, f fVar) {
        if (view == null || hVar == null) {
            return true;
        }
        com.opos.cmn.an.f.a.b("InterceptViewTool", "checkCallOnClickEnable:" + view.getClass().getName());
        boolean zA = hVar.a();
        com.opos.cmn.an.f.a.b("InterceptViewTool", "checkClickEnable:" + zA);
        if (!zA && fVar != null) {
            boolean zA2 = com.opos.mobad.template.g.a();
            com.opos.cmn.an.f.a.b("InterceptViewTool", "shouldCheckViewMockClick:" + zA2);
            fVar.a(view, 1, zA2);
        }
        if (!com.opos.mobad.template.g.a()) {
            return true;
        }
        com.opos.cmn.an.f.a.b("InterceptViewTool", "checkCallOnClickEnable:" + zA);
        return zA;
    }
}
