package defpackage;

import com.google.zxing.FormatException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class lb1 extends kb1 {
    public final boolean c;

    public lb1(ou ouVar, boolean z) {
        super(ouVar);
        this.c = z;
    }

    public int g(vp vpVar) {
        fe0[] fe0VarArrD = d();
        m();
        l(fe0VarArrD, vpVar);
        ou ouVarA = a();
        sx4 sx4VarI = this.c ? ouVarA.i() : ouVarA.j();
        sx4 sx4VarC = this.c ? ouVarA.c() : ouVarA.d();
        int iE = e((int) sx4VarI.d());
        int iE2 = e((int) sx4VarC.d());
        float fC = (iE2 - iE) / vpVar.c();
        int iC = -1;
        int i = 0;
        int iMax = 1;
        while (iE < iE2) {
            fe0 fe0Var = fe0VarArrD[iE];
            if (fe0Var != null) {
                int iC2 = fe0Var.c() - iC;
                if (iC2 == 0) {
                    i++;
                } else {
                    if (iC2 == 1) {
                        iMax = Math.max(iMax, i);
                        iC = fe0Var.c();
                    } else if (iC2 < 0 || fe0Var.c() >= vpVar.c() || iC2 > iE) {
                        fe0VarArrD[iE] = null;
                    } else {
                        if (iMax > 2) {
                            iC2 *= iMax - 2;
                        }
                        boolean z = iC2 >= iE;
                        for (int i2 = 1; i2 <= iC2 && !z; i2++) {
                            z = fe0VarArrD[iE - i2] != null;
                        }
                        if (z) {
                            fe0VarArrD[iE] = null;
                        } else {
                            iC = fe0Var.c();
                        }
                    }
                    i = 1;
                }
            }
            iE++;
        }
        return (int) (((double) fC) + 0.5d);
    }

    public int h(vp vpVar) {
        ou ouVarA = a();
        sx4 sx4VarI = this.c ? ouVarA.i() : ouVarA.j();
        sx4 sx4VarC = this.c ? ouVarA.c() : ouVarA.d();
        int iE = e((int) sx4VarI.d());
        int iE2 = e((int) sx4VarC.d());
        float fC = (iE2 - iE) / vpVar.c();
        fe0[] fe0VarArrD = d();
        int iC = -1;
        int i = 0;
        int iMax = 1;
        while (iE < iE2) {
            fe0 fe0Var = fe0VarArrD[iE];
            if (fe0Var != null) {
                fe0Var.j();
                int iC2 = fe0Var.c() - iC;
                if (iC2 == 0) {
                    i++;
                } else {
                    if (iC2 == 1) {
                        iMax = Math.max(iMax, i);
                        iC = fe0Var.c();
                    } else if (fe0Var.c() >= vpVar.c()) {
                        fe0VarArrD[iE] = null;
                    } else {
                        iC = fe0Var.c();
                    }
                    i = 1;
                }
            }
            iE++;
        }
        return (int) (((double) fC) + 0.5d);
    }

    public vp i() {
        fe0[] fe0VarArrD = d();
        xp xpVar = new xp();
        xp xpVar2 = new xp();
        xp xpVar3 = new xp();
        xp xpVar4 = new xp();
        for (fe0 fe0Var : fe0VarArrD) {
            if (fe0Var != null) {
                fe0Var.j();
                int iE = fe0Var.e() % 30;
                int iC = fe0Var.c();
                if (!this.c) {
                    iC += 2;
                }
                int i = iC % 3;
                if (i == 0) {
                    xpVar2.b((iE * 3) + 1);
                } else if (i == 1) {
                    xpVar4.b(iE / 3);
                    xpVar3.b(iE % 3);
                } else if (i == 2) {
                    xpVar.b(iE + 1);
                }
            }
        }
        if (xpVar.a().length == 0 || xpVar2.a().length == 0 || xpVar3.a().length == 0 || xpVar4.a().length == 0 || xpVar.a()[0] <= 0 || xpVar2.a()[0] + xpVar3.a()[0] < 3 || xpVar2.a()[0] + xpVar3.a()[0] > 90) {
            return null;
        }
        vp vpVar = new vp(xpVar.a()[0], xpVar2.a()[0], xpVar3.a()[0], xpVar4.a()[0]);
        l(fe0VarArrD, vpVar);
        return vpVar;
    }

    public int[] j() throws FormatException {
        int iC;
        vp vpVarI = i();
        if (vpVarI == null) {
            return null;
        }
        h(vpVarI);
        int iC2 = vpVarI.c();
        int[] iArr = new int[iC2];
        for (fe0 fe0Var : d()) {
            if (fe0Var != null && (iC = fe0Var.c()) < iC2) {
                iArr[iC] = iArr[iC] + 1;
            }
        }
        return iArr;
    }

    public boolean k() {
        return this.c;
    }

    public final void l(fe0[] fe0VarArr, vp vpVar) {
        for (int i = 0; i < fe0VarArr.length; i++) {
            fe0 fe0Var = fe0VarArr[i];
            if (fe0Var != null) {
                int iE = fe0Var.e() % 30;
                int iC = fe0Var.c();
                if (iC > vpVar.c()) {
                    fe0VarArr[i] = null;
                } else {
                    if (!this.c) {
                        iC += 2;
                    }
                    int i2 = iC % 3;
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 == 2 && iE + 1 != vpVar.a()) {
                                fe0VarArr[i] = null;
                            }
                        } else if (iE / 3 != vpVar.b() || iE % 3 != vpVar.d()) {
                            fe0VarArr[i] = null;
                        }
                    } else if ((iE * 3) + 1 != vpVar.e()) {
                        fe0VarArr[i] = null;
                    }
                }
            }
        }
    }

    public void m() {
        for (fe0 fe0Var : d()) {
            if (fe0Var != null) {
                fe0Var.j();
            }
        }
    }

    @Override // defpackage.kb1
    public String toString() {
        return "IsLeft: " + this.c + '\n' + super.toString();
    }
}
