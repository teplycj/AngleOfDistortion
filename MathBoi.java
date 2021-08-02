import java.util.*;
import java.io.*;

public class MathBoi{

    public MathBoi(){}
    
    void findCenter(double[] ogX,double[] ogY, double[] ogZ,double[] bSite, double[] xSite, double[] ySite, double[] zSite){
        
        
        double[] tempX = new double[3];
        for(int i=0; i<3;i++){
            tempX[i]=xSite[i];
        }
        double[] tempY = new double[3];
        for(int i=0; i<3;i++){
            tempY[i]=ySite[i];
        }
        double[] tempZ = new double[3];
        for(int i=0; i<3;i++){
            tempZ[i]=zSite[i];
        }
        double[] newX = avgCenter(xSite,0);
        double[] newY = avgCenter(ySite,1);
        double[] newZ = avgCenter(zSite,2);
        
        //System.out.println(newX[0]+" "+newY[0]+" "+newZ[0]+" "+tempX[0]+" "+tempY[0]+" "+tempZ[0]);
        
        double xDirCenter = (newX[0]+newY[0]+newZ[0]+tempX[0]+tempY[0]+tempZ[0])/6;
        double yDirCenter = (newX[1]+newY[1]+newZ[1]+tempX[1]+tempY[1]+tempZ[1])/6;
        double zDirCenter = (newX[2]+newY[2]+newZ[2]+tempX[2]+tempY[2]+tempZ[2])/6;
        
        //System.out.println("X  center: "+xDirCenter);
        //System.out.println("Y center: "+yDirCenter);
        //System.out.println("Z center: "+zDirCenter);
        //System.out.println();
        
        overallCenter(ogX,ogY,ogZ,bSite,xDirCenter,yDirCenter,zDirCenter);
    
    }
    
    private double[] avgCenter(double[] ogVec, int axis){
    
        double tempVal=0;
        double[] toReturnVec = ogVec;
        
        if(ogVec[axis]>.5){
            tempVal = ogVec[axis]-1;
        }else{
            tempVal=1+ogVec[axis];
        }
        
        toReturnVec[axis]= tempVal;
        return toReturnVec;
    
    }
    
    private void overallCenter(double[] ogX,double[] ogY, double[] ogZ, double[] b, double x, double y, double z){
    
        double xOff = b[0]-x;
        double yOff = b[1]-y;
        double zOff = b[2]-z;
        
        //System.out.println("x off center by: "+xOff);
        //System.out.println("y off center by: "+yOff);
        //System.out.println("z off center by: "+zOff);
        //System.out.println();
        
        double[] newVec1 = new double[3];
        double[] newVec2 = new double[3];
        double[] newVec3 = new double[3];
        
        for(int i=0;i<3;i++){
            newVec1[i]=xOff*ogX[i];
        }
    
        
        for(int i=0;i<3;i++){
            newVec2[i]=yOff*ogY[i];
        }
        
        for(int i=0;i<3;i++){
            newVec3[i]=zOff*ogZ[i];
        }
        
        //System.out.println("new vec1: "+newVec1[0]+" "+newVec1[1]+" "+newVec1[2]);
        //System.out.println("new vec2: "+newVec2[0]+" "+newVec2[1]+" "+newVec2[2]);
        //System.out.println("new vec3: "+newVec3[0]+" "+newVec3[1]+" "+newVec3[2]);
        //System.out.println();
        
        double[] toReturnVec = new double[3];
        
        for(int i=0;i<3;i++){
            toReturnVec[i]=newVec1[i]+newVec2[i]+newVec3[i];
        }
        
        double inPlaneOppo = Math.sqrt(Math.pow(toReturnVec[0],2)+Math.pow(toReturnVec[1],2));
        double leAngle = Math.atan(inPlaneOppo/toReturnVec[2])*180/Math.PI;
        
        System.out.println("Dipole moment: ("+toReturnVec[0]+", "+toReturnVec[1]+", "+toReturnVec[2]+")");
        System.out.println("Angle off axis perpendicular to distortion: "+leAngle);
        System.out.println();
    
    }
    
}
