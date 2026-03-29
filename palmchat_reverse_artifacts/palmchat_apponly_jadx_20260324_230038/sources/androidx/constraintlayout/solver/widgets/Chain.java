package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class Chain {
    private static final boolean DEBUG = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        int i2;
        ChainHead[] chainHeadArr;
        int i3;
        if (i == 0) {
            i2 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i3 = 0;
        } else {
            i2 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i3 = 2;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            ChainHead chainHead = chainHeadArr[i4];
            chainHead.define();
            applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003e A[PHI: r8 r15
      0x003e: PHI (r8v3 boolean) = (r8v1 boolean), (r8v45 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]
      0x003e: PHI (r15v3 boolean) = (r15v1 boolean), (r15v35 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0040 A[PHI: r8 r15
      0x0040: PHI (r8v43 boolean) = (r8v1 boolean), (r8v45 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]
      0x0040: PHI (r15v33 boolean) = (r15v1 boolean), (r15v35 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0163  */
    /* JADX WARN: Type inference failed for: r38v0, types: [androidx.constraintlayout.solver.LinearSystem] */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28, types: [androidx.constraintlayout.solver.SolverVariable] */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r8v41 */
    /* JADX WARN: Type inference failed for: r8v42 */
    /* JADX WARN: Type inference failed for: r8v47 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z;
        boolean z2;
        boolean z3;
        int i3;
        ConstraintWidget constraintWidget;
        int i4;
        ConstraintAnchor constraintAnchor;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintWidget constraintWidget2;
        ConstraintAnchor constraintAnchor2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        ConstraintWidget constraintWidget3;
        float f;
        int size;
        ArrayList<ConstraintWidget> arrayList;
        boolean z4;
        boolean z5;
        boolean z6;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        int i5;
        ConstraintWidget constraintWidget6 = chainHead.mFirst;
        ConstraintWidget constraintWidget7 = chainHead.mLast;
        ConstraintWidget constraintWidget8 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget9 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget10 = chainHead.mHead;
        float f2 = chainHead.mTotalWeight;
        boolean z7 = constraintWidgetContainer.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i == 0) {
            int i6 = constraintWidget10.mHorizontalChainStyle;
            z = i6 == 0;
            z2 = i6 == 1;
            z3 = i6 == 2;
        } else {
            int i7 = constraintWidget10.mVerticalChainStyle;
            z = i7 == 0;
            z2 = i7 == 1;
            if (i7 == 2) {
            }
        }
        boolean z8 = z2;
        boolean z9 = false;
        boolean z10 = z;
        ?? r8 = constraintWidget6;
        while (true) {
            if (z9) {
                break;
            }
            ConstraintAnchor constraintAnchor3 = r8.mListAnchors[i2];
            int i8 = z3 ? 1 : 4;
            int margin = constraintAnchor3.getMargin();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = r8.mListDimensionBehaviors[i];
            float f3 = f2;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour == dimensionBehaviour2 && r8.mResolvedMatchConstraintDefault[i] == 0) {
                z4 = z9;
                z5 = true;
            } else {
                z4 = z9;
                z5 = false;
            }
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 != null && r8 != constraintWidget6) {
                margin += constraintAnchor4.getMargin();
            }
            int i9 = margin;
            if (!z3 || r8 == constraintWidget6 || r8 == constraintWidget8) {
                z6 = z10;
            } else {
                z6 = z10;
                i8 = 5;
            }
            ConstraintAnchor constraintAnchor5 = constraintAnchor3.mTarget;
            if (constraintAnchor5 != null) {
                if (r8 == constraintWidget8) {
                    constraintWidget4 = constraintWidget10;
                    constraintWidget5 = constraintWidget6;
                    linearSystem.addGreaterThan(constraintAnchor3.mSolverVariable, constraintAnchor5.mSolverVariable, i9, 6);
                } else {
                    constraintWidget4 = constraintWidget10;
                    constraintWidget5 = constraintWidget6;
                    linearSystem.addGreaterThan(constraintAnchor3.mSolverVariable, constraintAnchor5.mSolverVariable, i9, 8);
                }
                linearSystem.addEquality(constraintAnchor3.mSolverVariable, constraintAnchor3.mTarget.mSolverVariable, i9, (!z5 || z3) ? i8 : 5);
            } else {
                constraintWidget4 = constraintWidget10;
                constraintWidget5 = constraintWidget6;
            }
            if (z7) {
                if (r8.getVisibility() == 8 || r8.mListDimensionBehaviors[i] != dimensionBehaviour2) {
                    i5 = 0;
                } else {
                    ConstraintAnchor[] constraintAnchorArr = r8.mListAnchors;
                    i5 = 0;
                    linearSystem.addGreaterThan(constraintAnchorArr[i2 + 1].mSolverVariable, constraintAnchorArr[i2].mSolverVariable, 0, 5);
                }
                linearSystem.addGreaterThan(r8.mListAnchors[i2].mSolverVariable, constraintWidgetContainer.mListAnchors[i2].mSolverVariable, i5, 8);
            }
            ConstraintAnchor constraintAnchor6 = r8.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor6 != null) {
                ConstraintWidget constraintWidget11 = constraintAnchor6.mOwner;
                ConstraintAnchor constraintAnchor7 = constraintWidget11.mListAnchors[i2].mTarget;
                if (constraintAnchor7 != null && constraintAnchor7.mOwner == r8) {
                    obj = constraintWidget11;
                }
            }
            if (obj != null) {
                r8 = obj;
                z9 = z4;
            } else {
                z9 = true;
            }
            z10 = z6;
            f2 = f3;
            constraintWidget10 = constraintWidget4;
            constraintWidget6 = constraintWidget5;
            r8 = r8;
        }
        ConstraintWidget constraintWidget12 = constraintWidget10;
        float f4 = f2;
        ConstraintWidget constraintWidget13 = constraintWidget6;
        boolean z11 = z10;
        if (constraintWidget9 != null) {
            int i10 = i2 + 1;
            if (constraintWidget7.mListAnchors[i10].mTarget != null) {
                ConstraintAnchor constraintAnchor8 = constraintWidget9.mListAnchors[i10];
                if ((constraintWidget9.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget9.mResolvedMatchConstraintDefault[i] == 0) && !z3) {
                    ConstraintAnchor constraintAnchor9 = constraintAnchor8.mTarget;
                    if (constraintAnchor9.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor8.mSolverVariable, constraintAnchor9.mSolverVariable, -constraintAnchor8.getMargin(), 5);
                    }
                    linearSystem.addLowerThan(constraintAnchor8.mSolverVariable, constraintWidget7.mListAnchors[i10].mTarget.mSolverVariable, -constraintAnchor8.getMargin(), 6);
                } else {
                    if (z3) {
                        ConstraintAnchor constraintAnchor10 = constraintAnchor8.mTarget;
                        if (constraintAnchor10.mOwner == constraintWidgetContainer) {
                            linearSystem.addEquality(constraintAnchor8.mSolverVariable, constraintAnchor10.mSolverVariable, -constraintAnchor8.getMargin(), 4);
                        }
                    }
                    linearSystem.addLowerThan(constraintAnchor8.mSolverVariable, constraintWidget7.mListAnchors[i10].mTarget.mSolverVariable, -constraintAnchor8.getMargin(), 6);
                }
            }
        }
        if (z7) {
            int i11 = i2 + 1;
            SolverVariable solverVariable5 = constraintWidgetContainer.mListAnchors[i11].mSolverVariable;
            ConstraintAnchor constraintAnchor11 = constraintWidget7.mListAnchors[i11];
            linearSystem.addGreaterThan(solverVariable5, constraintAnchor11.mSolverVariable, constraintAnchor11.getMargin(), 8);
        }
        ArrayList<ConstraintWidget> arrayList2 = chainHead.mWeightedMatchConstraintsWidgets;
        if (arrayList2 != null && (size = arrayList2.size()) > 1) {
            float f5 = (!chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f4 : chainHead.mWidgetsMatchCount;
            float f6 = 0.0f;
            ConstraintWidget constraintWidget14 = null;
            int i12 = 0;
            float f7 = 0.0f;
            while (i12 < size) {
                ConstraintWidget constraintWidget15 = arrayList2.get(i12);
                float f8 = constraintWidget15.mWeight[i];
                if (f8 < f6) {
                    if (chainHead.mHasComplexMatchWeights) {
                        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget15.mListAnchors;
                        linearSystem.addEquality(constraintAnchorArr2[i2 + 1].mSolverVariable, constraintAnchorArr2[i2].mSolverVariable, 0, 4);
                        arrayList = arrayList2;
                        i12++;
                        arrayList2 = arrayList;
                        f6 = 0.0f;
                    } else {
                        f8 = 1.0f;
                    }
                }
                if (f8 == f6) {
                    ConstraintAnchor[] constraintAnchorArr3 = constraintWidget15.mListAnchors;
                    linearSystem.addEquality(constraintAnchorArr3[i2 + 1].mSolverVariable, constraintAnchorArr3[i2].mSolverVariable, 0, 8);
                    arrayList = arrayList2;
                    i12++;
                    arrayList2 = arrayList;
                    f6 = 0.0f;
                } else {
                    if (constraintWidget14 != null) {
                        ConstraintAnchor[] constraintAnchorArr4 = constraintWidget14.mListAnchors;
                        SolverVariable solverVariable6 = constraintAnchorArr4[i2].mSolverVariable;
                        int i13 = i2 + 1;
                        SolverVariable solverVariable7 = constraintAnchorArr4[i13].mSolverVariable;
                        ConstraintAnchor[] constraintAnchorArr5 = constraintWidget15.mListAnchors;
                        SolverVariable solverVariable8 = constraintAnchorArr5[i2].mSolverVariable;
                        SolverVariable solverVariable9 = constraintAnchorArr5[i13].mSolverVariable;
                        arrayList = arrayList2;
                        ArrayRow arrayRowCreateRow = linearSystem.createRow();
                        arrayRowCreateRow.createRowEqualMatchDimensions(f7, f5, f8, solverVariable6, solverVariable7, solverVariable8, solverVariable9);
                        linearSystem.addConstraint(arrayRowCreateRow);
                    } else {
                        arrayList = arrayList2;
                    }
                    constraintWidget14 = constraintWidget15;
                    f7 = f8;
                    i12++;
                    arrayList2 = arrayList;
                    f6 = 0.0f;
                }
            }
        }
        if (constraintWidget8 != null && (constraintWidget8 == constraintWidget9 || z3)) {
            ConstraintAnchor constraintAnchor12 = constraintWidget13.mListAnchors[i2];
            int i14 = i2 + 1;
            ConstraintAnchor constraintAnchor13 = constraintWidget7.mListAnchors[i14];
            ConstraintAnchor constraintAnchor14 = constraintAnchor12.mTarget;
            SolverVariable solverVariable10 = constraintAnchor14 != null ? constraintAnchor14.mSolverVariable : null;
            ConstraintAnchor constraintAnchor15 = constraintAnchor13.mTarget;
            SolverVariable solverVariable11 = constraintAnchor15 != null ? constraintAnchor15.mSolverVariable : null;
            ConstraintAnchor constraintAnchor16 = constraintWidget8.mListAnchors[i2];
            ConstraintAnchor constraintAnchor17 = constraintWidget9.mListAnchors[i14];
            if (solverVariable10 != null && solverVariable11 != null) {
                if (i == 0) {
                    f = constraintWidget12.mHorizontalBiasPercent;
                } else {
                    f = constraintWidget12.mVerticalBiasPercent;
                }
                linearSystem.addCentering(constraintAnchor16.mSolverVariable, solverVariable10, constraintAnchor16.getMargin(), f, solverVariable11, constraintAnchor17.mSolverVariable, constraintAnchor17.getMargin(), 7);
            }
        } else if (!z11 || constraintWidget8 == null) {
            int i15 = 8;
            if (z8 && constraintWidget8 != null) {
                int i16 = chainHead.mWidgetsMatchCount;
                boolean z12 = i16 > 0 && chainHead.mWidgetsCount == i16;
                ConstraintWidget constraintWidget16 = constraintWidget8;
                ConstraintWidget constraintWidget17 = constraintWidget16;
                while (constraintWidget16 != null) {
                    ConstraintWidget constraintWidget18 = constraintWidget16.mNextChainWidget[i];
                    while (constraintWidget18 != null && constraintWidget18.getVisibility() == i15) {
                        constraintWidget18 = constraintWidget18.mNextChainWidget[i];
                    }
                    if (constraintWidget16 == constraintWidget8 || constraintWidget16 == constraintWidget9 || constraintWidget18 == null) {
                        constraintWidget = constraintWidget17;
                        i4 = 8;
                    } else {
                        ConstraintWidget constraintWidget19 = constraintWidget18 == constraintWidget9 ? null : constraintWidget18;
                        ConstraintAnchor constraintAnchor18 = constraintWidget16.mListAnchors[i2];
                        SolverVariable solverVariable12 = constraintAnchor18.mSolverVariable;
                        ConstraintAnchor constraintAnchor19 = constraintAnchor18.mTarget;
                        if (constraintAnchor19 != null) {
                            SolverVariable solverVariable13 = constraintAnchor19.mSolverVariable;
                        }
                        int i17 = i2 + 1;
                        SolverVariable solverVariable14 = constraintWidget17.mListAnchors[i17].mSolverVariable;
                        int margin2 = constraintAnchor18.getMargin();
                        int margin3 = constraintWidget16.mListAnchors[i17].getMargin();
                        if (constraintWidget19 != null) {
                            constraintAnchor = constraintWidget19.mListAnchors[i2];
                            solverVariable = constraintAnchor.mSolverVariable;
                            ConstraintAnchor constraintAnchor20 = constraintAnchor.mTarget;
                            solverVariable2 = constraintAnchor20 != null ? constraintAnchor20.mSolverVariable : null;
                        } else {
                            constraintAnchor = constraintWidget9.mListAnchors[i2];
                            solverVariable = constraintAnchor != null ? constraintAnchor.mSolverVariable : null;
                            solverVariable2 = constraintWidget16.mListAnchors[i17].mSolverVariable;
                        }
                        if (constraintAnchor != null) {
                            margin3 += constraintAnchor.getMargin();
                        }
                        int i18 = margin3;
                        int margin4 = constraintWidget17.mListAnchors[i17].getMargin() + margin2;
                        int i19 = z12 ? 8 : 4;
                        if (solverVariable12 == null || solverVariable14 == null || solverVariable == null || solverVariable2 == null) {
                            constraintWidget2 = constraintWidget19;
                            constraintWidget = constraintWidget17;
                            i4 = 8;
                        } else {
                            constraintWidget2 = constraintWidget19;
                            constraintWidget = constraintWidget17;
                            i4 = 8;
                            linearSystem.addCentering(solverVariable12, solverVariable14, margin4, 0.5f, solverVariable, solverVariable2, i18, i19);
                        }
                        constraintWidget18 = constraintWidget2;
                    }
                    if (constraintWidget16.getVisibility() == i4) {
                        constraintWidget16 = constraintWidget;
                    }
                    constraintWidget17 = constraintWidget16;
                    i15 = 8;
                    constraintWidget16 = constraintWidget18;
                }
                ConstraintAnchor constraintAnchor21 = constraintWidget8.mListAnchors[i2];
                ConstraintAnchor constraintAnchor22 = constraintWidget13.mListAnchors[i2].mTarget;
                int i20 = i2 + 1;
                ConstraintAnchor constraintAnchor23 = constraintWidget9.mListAnchors[i20];
                ConstraintAnchor constraintAnchor24 = constraintWidget7.mListAnchors[i20].mTarget;
                if (constraintAnchor22 == null) {
                    i3 = 5;
                } else if (constraintWidget8 != constraintWidget9) {
                    i3 = 5;
                    linearSystem.addEquality(constraintAnchor21.mSolverVariable, constraintAnchor22.mSolverVariable, constraintAnchor21.getMargin(), 5);
                } else {
                    i3 = 5;
                    if (constraintAnchor24 != null) {
                        linearSystem.addCentering(constraintAnchor21.mSolverVariable, constraintAnchor22.mSolverVariable, constraintAnchor21.getMargin(), 0.5f, constraintAnchor23.mSolverVariable, constraintAnchor24.mSolverVariable, constraintAnchor23.getMargin(), 5);
                    }
                }
                if (constraintAnchor24 != null && constraintWidget8 != constraintWidget9) {
                    linearSystem.addEquality(constraintAnchor23.mSolverVariable, constraintAnchor24.mSolverVariable, -constraintAnchor23.getMargin(), i3);
                }
            }
        } else {
            int i21 = chainHead.mWidgetsMatchCount;
            boolean z13 = i21 > 0 && chainHead.mWidgetsCount == i21;
            ConstraintWidget constraintWidget20 = constraintWidget8;
            ConstraintWidget constraintWidget21 = constraintWidget20;
            while (constraintWidget20 != null) {
                ConstraintWidget constraintWidget22 = constraintWidget20.mNextChainWidget[i];
                while (constraintWidget22 != null && constraintWidget22.getVisibility() == 8) {
                    constraintWidget22 = constraintWidget22.mNextChainWidget[i];
                }
                if (constraintWidget22 != null || constraintWidget20 == constraintWidget9) {
                    ConstraintAnchor constraintAnchor25 = constraintWidget20.mListAnchors[i2];
                    SolverVariable solverVariable15 = constraintAnchor25.mSolverVariable;
                    ConstraintAnchor constraintAnchor26 = constraintAnchor25.mTarget;
                    SolverVariable solverVariable16 = constraintAnchor26 != null ? constraintAnchor26.mSolverVariable : null;
                    if (constraintWidget21 != constraintWidget20) {
                        solverVariable16 = constraintWidget21.mListAnchors[i2 + 1].mSolverVariable;
                    } else if (constraintWidget20 == constraintWidget8 && constraintWidget21 == constraintWidget20) {
                        ConstraintAnchor constraintAnchor27 = constraintWidget13.mListAnchors[i2].mTarget;
                        solverVariable16 = constraintAnchor27 != null ? constraintAnchor27.mSolverVariable : null;
                    }
                    int margin5 = constraintAnchor25.getMargin();
                    int i22 = i2 + 1;
                    int margin6 = constraintWidget20.mListAnchors[i22].getMargin();
                    if (constraintWidget22 != null) {
                        constraintAnchor2 = constraintWidget22.mListAnchors[i2];
                        SolverVariable solverVariable17 = constraintAnchor2.mSolverVariable;
                        solverVariable4 = constraintWidget20.mListAnchors[i22].mSolverVariable;
                        solverVariable3 = solverVariable17;
                    } else {
                        constraintAnchor2 = constraintWidget7.mListAnchors[i22].mTarget;
                        solverVariable3 = constraintAnchor2 != null ? constraintAnchor2.mSolverVariable : null;
                        solverVariable4 = constraintWidget20.mListAnchors[i22].mSolverVariable;
                    }
                    if (constraintAnchor2 != null) {
                        margin6 += constraintAnchor2.getMargin();
                    }
                    if (constraintWidget21 != null) {
                        margin5 += constraintWidget21.mListAnchors[i22].getMargin();
                    }
                    if (solverVariable15 == null || solverVariable16 == null || solverVariable3 == null || solverVariable4 == null) {
                        constraintWidget3 = constraintWidget22;
                    } else {
                        if (constraintWidget20 == constraintWidget8) {
                            margin5 = constraintWidget8.mListAnchors[i2].getMargin();
                        }
                        int i23 = margin5;
                        constraintWidget3 = constraintWidget22;
                        linearSystem.addCentering(solverVariable15, solverVariable16, i23, 0.5f, solverVariable3, solverVariable4, constraintWidget20 == constraintWidget9 ? constraintWidget9.mListAnchors[i22].getMargin() : margin6, z13 ? 8 : 5);
                    }
                }
                if (constraintWidget20.getVisibility() != 8) {
                    constraintWidget21 = constraintWidget20;
                }
                constraintWidget20 = constraintWidget3;
            }
        }
        if ((!z11 && !z8) || constraintWidget8 == null || constraintWidget8 == constraintWidget9) {
            return;
        }
        ConstraintAnchor[] constraintAnchorArr6 = constraintWidget8.mListAnchors;
        ConstraintAnchor constraintAnchor28 = constraintAnchorArr6[i2];
        int i24 = i2 + 1;
        ConstraintAnchor constraintAnchor29 = constraintWidget9.mListAnchors[i24];
        ConstraintAnchor constraintAnchor30 = constraintAnchor28.mTarget;
        SolverVariable solverVariable18 = constraintAnchor30 != null ? constraintAnchor30.mSolverVariable : null;
        ConstraintAnchor constraintAnchor31 = constraintAnchor29.mTarget;
        ?? r5 = constraintAnchor31 != null ? constraintAnchor31.mSolverVariable : 0;
        if (constraintWidget7 != constraintWidget9) {
            ConstraintAnchor constraintAnchor32 = constraintWidget7.mListAnchors[i24].mTarget;
            r5 = constraintAnchor32 != null ? constraintAnchor32.mSolverVariable : null;
        }
        if (constraintWidget8 == constraintWidget9) {
            constraintAnchor29 = constraintAnchorArr6[i24];
        }
        if (solverVariable18 == null || r5 == 0) {
            return;
        }
        linearSystem.addCentering(constraintAnchor28.mSolverVariable, solverVariable18, constraintAnchor28.getMargin(), 0.5f, r5, constraintAnchor29.mSolverVariable, constraintWidget9.mListAnchors[i24].getMargin(), 5);
    }
}
