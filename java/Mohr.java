import java.math.*;

public class Mohr{
    private double minSigmaA;
    private double sigmaA;
    private double maxSigmaA;
    private double minSigmaB;
    private double sigmaB;
    private double maxSigmaB;
    private double minTauA;
    private double tauA;
    private double maxTauA;
    private double tauB;
    private double minTheta0;
    private double theta0;
    private double maxTheta0;
    private double minTheta1;
    private double theta1;
    private double maxTheta1;
    private double sigmaAve;
    private double radius;
    private double sigma1;
    private double sigma3;
    private double sigmaP;
    private double tauP;
    private double sigmaAA;
    private double tauAA;
    private double sigmaBB;
    private double tauBB;
    private double minCohesion;
    private double cohesion;
    private double maxCohesion;    
    private double minFrictionAngle;
    private double frictionAngle;
    private double maxFrictionAngle;
    private boolean failed;
    private boolean onFailure;
    public Mohr (double sigmaA,double sigmaB,double tau){
        //=======================initialization===========================
        this.sigmaA=sigmaA;
        this.sigmaB=sigmaB;
        this.tauA=tau;
        this.theta0=0;
        this.theta1=0;
        onFailure=false;
        //======================initialization of bounds==================
        this.minSigmaA=0.5*sigmaA;
        this.maxSigmaA=1.5*sigmaA;
        this.minSigmaB=0.5*sigmaB;
        this.maxSigmaB=1.5*sigmaB;
        this.minTauA=-2*tauA;
        this.maxTauA=2*tauA;
        this.minTheta0=-180;
        this.maxTheta0=180;
        this.minTheta1=-180;
        this.maxTheta1=180;
        this.maxCohesion=50;
        this.cohesion=25;
        this.minCohesion=0;
        this.frictionAngle=22;
        this.minFrictionAngle=0;
        this.maxFrictionAngle=45;
        //======================calculations==============================
        this.sigmaAve=(sigmaA+sigmaB)/2;
        this.tauB=-1*tauA;
        this.radius=Math.sqrt((sigmaA-sigmaAve)*(sigmaA-sigmaAve)+tau*tau);
        this.sigma1=sigmaAve+radius;
        this.sigma3=sigmaAve-radius;
        this.sigmaP=this.findSigma(theta0,sigmaA,tauA);
        this.tauP=this.findTau(theta0,sigmaA,sigmaP,tauA);
        this.sigmaAA=this.findSigma(theta1+theta0,sigmaP,tauP);
        this.tauAA=this.findTau((theta1+theta0),sigmaP,sigmaAA,tauP);
        this.sigmaBB=2*sigmaAve-sigmaAA;
        this.tauBB=-1*tauAA;
        
        //==============calculate if material failed======================
        double quantity1=sigma1-sigma3;
        double quantity2=(sigma1+sigma3)*Math.sin(Math.toRadians(frictionAngle))+2*cohesion*Math.cos(Math.toRadians(frictionAngle));
        
        if(quantity1>quantity2){
            failed=true;
        }else{
            if(Math.abs(quantity1-quantity2)<0.03*radius){
                onFailure=true;
            }else{
                onFailure=false;
            }
            failed=false;
        }
    }
    //=========================================================================================================
    //========================================ACCESOR METHODS==================================================
    //=========================================================================================================
    public double getSigmaA(){
        return sigmaA;
    }
    public double getSigmaB(){
        return sigmaB;
    }
    public double getTauA(){
        return tauA;
    }
    public double getTauB(){
        return tauB;
    }
    public double getSigmaAve(){
        return sigmaAve;
    }
    public double getRadius(){
        return radius;
    }
    public double getTheta0(){
        return theta0;
    }
    public double getTheta1(){
        return theta1;
    }
    public double getSigma1(){
        return sigma1;
    }
    public double getSigma3(){
        return sigma3;
    }
    public double getSigmaP(){
        return sigmaP;
    }
    public double getSigmaAA(){
        return sigmaAA;
    }
    public double getSigmaBB(){
        return sigmaBB;
    }
    public double getTauP(){
        return tauP;
    }
    public double getTauAA(){
        return tauAA;
    }
    public double getTauBB(){
        return tauBB;
    }
    public double getCohesion(){
        return cohesion;
    }
    public double getFrictionAngle(){
        return frictionAngle;
    }
    public boolean getFailed(){
       return failed;
    }
    public boolean getOnFailure(){
       return onFailure;
    }
    //=========================================================================================================
    //========================================ACCESOR METHODS FOR BOUNDS=======================================
    //=========================================================================================================    
    
    public double getMinSigmaA(){
        return minSigmaA;
    }
    public double getMaxSigmaA(){
        return maxSigmaA;
    }
    public double getMinSigmaB(){
        return minSigmaB;
    }
    public double getMaxSigmaB(){
        return maxSigmaB;
    }
    public double getMinTauA(){
        return minTauA;
    }
    public double getMaxTauA(){
        return maxTauA;
    }
    public double getMinTheta0(){
        return minTheta0;
    }
    public double getMaxTheta0(){
        return maxTheta0;
    }
    public double getMinTheta1(){
        return minTheta1;
    }
    public double getMaxTheta1(){
        return maxTheta1;
    }
    public double getMinCohesion(){
        return minCohesion;
    }
    public double getMaxCohesion(){
        return maxCohesion;
    }
    public double getMinFrictionAngle(){
        return minFrictionAngle;
    }
    public double getMaxFrictionAngle(){
        return maxFrictionAngle;
    }
    /*Accesor methods for Rounded Numbers cause we dont want the numbers shown like this
     * 4.4534565676783456 we want this 4.453
       */
     public double getRndSigmaA(){
        double rndSigmaA=(Math.round(sigmaA*100))/(100d);
        return rndSigmaA;
    }
    public double getRndSigmaB(){
        double rndSigmaB=(Math.round(sigmaB*100))/(100d);
        return rndSigmaB;
    }
    public double getRndTauA(){
        double rndTauA=(Math.round(tauA*100))/(100d);
        return rndTauA;
    }
    public double getRndTauB(){
        double rndTauB=(Math.round(tauB*100))/(100d);
        return rndTauB;
    }
    public double getRndSigmaAve(){
        double rndSigmaAve=(Math.round(sigmaAve*100))/(100d);
        return rndSigmaAve;
    }
    public double getRndRadius(){
        double rndRadius=(Math.round(radius*100))/(100d);
        return rndRadius;
    }
    public double getRndTheta0(){
        double rndTheta0=(Math.round(theta0*100))/(100d);
        return rndTheta0;
    }
    public double getRndTheta1(){
        double rndTheta1=(Math.round((theta1+theta0)*100))/(100d);
        return rndTheta1;
    }
    public double getRndSigma1(){
        double rndSigma1=(Math.round(sigma1*100))/(100d);
        return rndSigma1;
    }
    public double getRndSigma3(){
        double rndSigma3=(Math.round(sigma3*100))/(100d);
        return rndSigma3;
    }
    public double getRndSigmaP(){
        double rndSigmaP=(Math.round(sigmaP*100))/(100d);
        return rndSigmaP;
    }
    public double getRndSigmaAA(){
        double rndSigmaAA=(Math.round(sigmaAA*100))/(100d);
        return rndSigmaAA;
    }
    public double getRndSigmaBB(){
        double rndSigmaBB=(Math.round(sigmaBB*100))/(100d);
        return rndSigmaBB;
    }
    public double getRndTauP(){
        double rndTauP=(Math.round(tauP*100))/(100d);
        return rndTauP;
    }
    public double getRndTauAA(){
        double rndTauAA=(Math.round(tauAA*100))/(100d);
        return rndTauAA;
    }
    public double getRndTauBB(){
        double rndTauBB=(Math.round(tauBB*100))/(100d);
        return rndTauBB;
    } 
    public double getRndCohesion(){
        double rndCohesion=(Math.round(cohesion*100))/(100d);
        return rndCohesion;
    }
    public double getRndFrictionAngle(){
        double rndFrictionAngle=(Math.round(frictionAngle*100))/(100d);
        return rndFrictionAngle;
    }
    //=========================================================================================================
    //============================================ROUNDED BOUNDS===============================================
    //=========================================================================================================
     public double getRndMinSigmaA(){
        double rndSigmaA=(Math.round(minSigmaA*100))/(100d);
        return rndSigmaA;
    }
     public double getRndMaxSigmaA(){
        double rndSigmaA=(Math.round(maxSigmaA*100))/(100d);
        return rndSigmaA;
    }
    public double getRndMinSigmaB(){
        double rndSigmaB=(Math.round(minSigmaB*100))/(100d);
        return rndSigmaB;
    }
    public double getRndMaxSigmaB(){
        double rndSigmaB=(Math.round(maxSigmaB*100))/(100d);
        return rndSigmaB;
    }
    public double getRndMinTauA(){
        double rndTauA=(Math.round(minTauA*100))/(100d);
        return rndTauA;
    }
    public double getRndMaxTauA(){
        double rndTauA=(Math.round(maxTauA*100))/(100d);
        return rndTauA;
    }
    public double getRndMinTheta0(){
        double rndTheta0=(Math.round(minTheta0*100))/(100d);
        return rndTheta0;
    }
    public double getRndMaxTheta0(){
        double rndTheta0=(Math.round(maxTheta0*100))/(100d);
        return rndTheta0;
    }
     public double getRndMinTheta1(){
        double rndTheta1=(Math.round(minTheta1*100))/(100d);
        return rndTheta1;
    }
     public double getRndMaxTheta1(){
        double rndTheta1=(Math.round(maxTheta1*100))/(100d);
        return rndTheta1;
    }
    public double getRndMaxCohesion(){
        double rndMaxCohesion=(Math.round(maxCohesion*100))/(100d);
        return rndMaxCohesion;
    }
    public double getRndMinCohesion(){
        double rndMinCohesion=(Math.round(minCohesion*100))/(100d);
        return rndMinCohesion;
    }
    public double getRndMinFrictionAngle(){
        double rndMinFrictionAngle=(Math.round(minFrictionAngle*100))/(100d);
        return rndMinFrictionAngle;
    }
    public double getRndMaxFrictionAngle(){
        double rndMaxFrictionAngle=(Math.round(maxFrictionAngle*100))/(100d);
        return rndMaxFrictionAngle;
    }
    //=========================================================================================================
    //========================================MUTATOR METHODS==================================================
    //=========================================================================================================
    public void calculate(){
        this.sigmaAve=(sigmaA+sigmaB)/2;
        this.tauB=-1*tauA;
        this.radius=Math.sqrt((sigmaA-sigmaAve)*(sigmaA-sigmaAve)+tauA*tauA);
        this.sigma1=sigmaAve+radius;
        this.sigma3=sigmaAve-radius;
        this.sigmaP=this.findSigma(theta0,sigmaA,tauA);
        this.tauP=this.findTau(theta0,sigmaA,sigmaP,tauA);
        
        this.sigmaAA=this.findSigma(theta1+theta0,sigmaP,tauP);
        this.tauAA=this.findTau((theta1+theta0),sigmaP,sigmaAA,tauP);
        this.sigmaBB=2*sigmaAve-sigmaAA;
        this.tauBB=-1*tauAA;
        //==============calculate if material failed======================
        double quantity1=sigma1-sigma3;
        double quantity2=(sigma1+sigma3)*Math.sin(Math.toRadians(frictionAngle))+2*cohesion*Math.cos(Math.toRadians(frictionAngle));
        
        if(quantity1>quantity2){
            failed=true;
        }else{
            if(Math.abs(quantity1-quantity2)<0.03*radius){
                onFailure=true;
            }else{
                onFailure=false;
            }
            failed=false;
        }
    }
    public void setSigmaA(double value){
        sigmaA=value;
    }
    public void setSigmaB(double value){
        sigmaB=value;
    }
    public void setTau(double value){
        tauA=value;
    }
    public void setTheta0(double value){
        theta0=value;
    }
    public void setTheta1(double value){
        theta1=value;
    }
    public void setCohesion(double value){
        cohesion=value;
    }
    public void setFrictionAngle(double value){
        frictionAngle=value;
    }
    //==================================CONSTRUCTOR METHODS FOR BOUNDS=========================================
    public void setMinSigmaA(double value){
        minSigmaA=value;
    }
    public void setMaxSigmaA(double value){
        maxSigmaA=value;
    }
    public void setMinSigmaB(double value){
        minSigmaB=value;
    }
    public void setMaxSigmaB(double value){
        maxSigmaB=value;
    }
     public void setMinTau(double value){
        minTauA=value;
    }
     public void setMaxTau(double value){
        maxTauA=value;
    }
    public void setMinTheta0(double value){
        minTheta0=value;
    }
    public void setMaxTheta0(double value){
        maxTheta0=value;
    }
    public void setMinTheta1(double value){
        minTheta1=value;
    }
    public void setMaxTheta1(double value){
        maxTheta1=value;
    }
    public void setMinCohesion(double value){
        minCohesion=value;
    }
    public void setMaxCohesion(double value){
        maxCohesion=value;
    }
    public void setMinFrictionAngle(double value){
        minFrictionAngle=value;
    }
    public void setMaxFrictionAngle(double value){
        maxFrictionAngle=value;
    }
    //=========================================================================================================
    //========================================PRIVATE METHODS==================================================
    //=========================================================================================================
   private double findSigma(double angle,double sigma,double tau1){
       double sig_ave=this.getSigmaAve();
       
       double rad=radius;
       double tan=Math.tan(Math.toRadians(angle));
       
       double A=1+tan*tan;
       double B=2*tau1*tan-2*tan*tan*sigma-2*sig_ave;
       double G=tau1*tau1-rad*rad-2*sigma*tau1*tan+tan*tan*sigma*sigma+sig_ave*sig_ave;
       double d=B*B-4*A*G;
       double sigma1=((-1)*B-Math.sqrt(d))/(2*A);
       //System.out.println(sigma1);
       double sigma2=((-1)*B+Math.sqrt(d))/(2*A);
       double value=sigma;
       if(Math.abs(sigma-sigma1)<=0.005){
           value=sigma2;
       }
       if(Math.abs(sigma-sigma2)<=0.005){
           value=sigma1;
       }
       return value;
   }
   private double findTau(double angle,double sigma0,double sigma1,double tau0){
       double tan=Math.tan(Math.toRadians(angle));
       //System.out.println(tan);
       double tau1;
       if(angle==90.0 || angle==-90.0){
           tau1=-1*tau0;
       }else{
           tau1=tau0+((sigma1-sigma0))*tan;
       }
       return tau1;
   }
}