import java.math.*;

public class intMohr{
    public Mohr myMohr;
    private int intMinSigmaA;
    private int intSigmaA;
    private int intMaxSigmaA;
    private int intMinSigmaB;
    private int intSigmaB;
    private int intMaxSigmaB;
    private int intMinTauA;
    private int intTauA;
    private int intMaxTauA;
    private int intTauB;
    private int intMinTheta0;
    private int intTheta0;
    private int intMaxTheta0;
    private int intMinTheta1;
    private int intTheta1;
    private int intMaxTheta1;
    private int intSigmaAve;
    private int intRadius;
    private int intSigma1;
    private int intSigma3;
    private int intSigmaP;
    private int intTauP;
    private int intSigmaAA;
    private int intTauAA;
    private int intSigmaBB;
    private int intTauBB;
    private int intMinCohesion;
    private int intCohesion;
    private int intMaxCohesion;
    private int intMinFrictionAngle;
    private int intFrictionAngle;
    private int intMaxFrictionAngle;
    public intMohr (Mohr myMohr){
        this.myMohr=myMohr;
        intSigmaA=(int) Math.round(myMohr.getSigmaA()*100)/1;
        intSigmaB=(int) Math.round(myMohr.getSigmaB()*100)/1;
        intTauA=(int) Math.round(myMohr.getTauA()*100)/1;
        intTauB=(int) Math.round(myMohr.getTauB()*100)/1;
        intTheta0=(int) Math.round(myMohr.getTheta0()*100)/1;
        intTheta1=(int) Math.round(myMohr.getTheta1()*100)/1;
        intSigmaAve=(int) Math.round(myMohr.getSigmaAve()*100)/1;
        intRadius=(int) Math.round(myMohr.getRadius()*100)/1;
        intSigma1=(int) Math.round(myMohr.getSigma1()*100)/1;
        intSigma3=(int) Math.round(myMohr.getSigma3()*100)/1;
        intSigmaP=(int) Math.round(myMohr.getSigmaP()*100)/1;
        intTauP=(int) Math.round(myMohr.getTauP()*100)/1;
        intSigmaAA=(int) Math.round(myMohr.getSigmaAA()*100)/1;
        intTauAA=(int) Math.round(myMohr.getTauAA()*100)/1;
        intSigmaBB=(int) Math.round(myMohr.getSigmaBB()*100)/1;
        intTauBB=(int) Math.round(myMohr.getTauBB()*100)/1;
        intCohesion=(int)Math.round(myMohr.getCohesion()*100)/1;
        intFrictionAngle=(int)Math.round(myMohr.getFrictionAngle()*100)/1;
        //=========================bounds=================================
        intMinSigmaA=(int) Math.round(myMohr.getMinSigmaA()*100)/1;
        intMaxSigmaA=(int) Math.round(myMohr.getMaxSigmaA()*100)/1;
        intMinSigmaB=(int) Math.round(myMohr.getMinSigmaB()*100)/1;
        intMaxSigmaB=(int) Math.round(myMohr.getMaxSigmaB()*100)/1;
        intMinTauA=(int) Math.round(myMohr.getMinTauA()*100)/1;
        intMaxTauA=(int) Math.round(myMohr.getMaxTauA()*100)/1;
        intMinTheta0=(int) Math.round(myMohr.getMinTheta0()*100)/1;
        intMaxTheta0=(int) Math.round(myMohr.getMaxTheta0()*100)/1;
        intMinTheta1=(int) Math.round(myMohr.getMinTheta1()*100)/1;
        intMaxTheta1=(int) Math.round(myMohr.getMaxTheta1()*100)/1;
        intMinCohesion=(int) Math.round(myMohr.getMinCohesion()*100)/1;
        intMaxCohesion=(int) Math.round(myMohr.getMaxCohesion()*100)/1; 
        intMinFrictionAngle=(int) Math.round(myMohr.getMinFrictionAngle()*100)/1; 
        intMaxFrictionAngle=(int) Math.round(myMohr.getMaxFrictionAngle()*100)/1;
    }
    //=========================================================================================================
    //========================================ACCESOR METHODS==================================================
    //=========================================================================================================
    public int getIntSigmaA(){
        return intSigmaA;
    }
    public int getIntSigmaB(){
        return intSigmaB;
    }
    public int getIntTauA(){
        return intTauA;
    }
    public int getIntTauB(){
        return intTauB;
    }
    public int getIntSigmaAve(){
        return intSigmaAve;
    }
    public int getIntRadius(){
        return intRadius;
    }
    public int getIntTheta0(){
        return intTheta0;
    }
    public int getIntTheta1(){
        return intTheta1;
    }
    public int getIntSigma1(){
        return intSigma1;
    }
    public int getIntSigma3(){
        return intSigma3;
    }
    public int getIntSigmaP(){
        return intSigmaP;
    }
    public int getIntSigmaAA(){
        return intSigmaAA;
    }
    public int getIntSigmaBB(){
        return intSigmaBB;
    }
    public int getIntTauP(){
        return intTauP;
    }
    public int getIntTauAA(){
        return intTauAA;
    }
    public int getIntTauBB(){
        return intTauBB;
    }
    public int getIntCohesion(){
        return intCohesion;
    }
    public int getIntFrictionAngle(){
        return intFrictionAngle;
    }
    //====================================ACCESOR METHODS FOR BOUNDS===========================================
    public int getIntMinSigmaA(){
        return intMinSigmaA;
    }
    public int getIntMaxSigmaA(){
        return intMaxSigmaA;
    }
    public int getIntMinSigmaB(){
        return intMinSigmaB;
    }
    public int getIntMaxSigmaB(){
        return intMaxSigmaB;
    }
    public int getIntMinTauA(){
        return intMinTauA;
    }
    public int getIntMaxTauA(){
        return intMaxTauA;
    }
    public int getIntMinTheta0(){
        return intMinTheta0;
    }
    public int getIntMaxTheta0(){
        return intMaxTheta0;
    }
    public int getIntMinTheta1(){
        return intMinTheta1;
    }
    public int getIntMaxTheta1(){
        return intMaxTheta1;
    }
    public int getIntMinCohesion(){
        return intMinCohesion;
    }
    public int getIntMaxCohesion(){
        return intMaxCohesion;
    }
    public int getIntMinFrictionAngle(){
        return intMinFrictionAngle;
    }
    public int getIntMaxFrictionAngle(){
        return intMaxFrictionAngle;
    }
    //=========================================================================================================
    //========================================MUTATOR METHODS==================================================
    //=========================================================================================================
    public void calculate(){
       
    }
    
    //=========================================================================================================
    //========================================PRIVATE METHODS==================================================
    //=========================================================================================================
}