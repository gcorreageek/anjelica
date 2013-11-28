package gnu.chu.anjelica.sql;
// Generated 26-oct-2011 10:11:38 by Hibernate Tools 3.2.1.GA



/**
 * DesorilinId generated by hbm2java
 */
public class DesorilinId  implements java.io.Serializable {


     private int ejeNume;
     private int deoCodi;
     private int delNumlin;

    public DesorilinId() {
    }

    public DesorilinId(int ejeNume, int deoCodi, int delNumlin) {
       this.ejeNume = ejeNume;
       this.deoCodi = deoCodi;
       this.delNumlin = delNumlin;
    }
   
    public int getEjeNume() {
        return this.ejeNume;
    }
    
    public void setEjeNume(int ejeNume) {
        this.ejeNume = ejeNume;
    }
    public int getDeoCodi() {
        return this.deoCodi;
    }
    
    public void setDeoCodi(int deoCodi) {
        this.deoCodi = deoCodi;
    }
    public int getDelNumlin() {
        return this.delNumlin;
    }
    
    public void setDelNumlin(int delNumlin) {
        this.delNumlin = delNumlin;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DesorilinId) ) return false;
		 DesorilinId castOther = ( DesorilinId ) other; 
         
		 return (this.getEjeNume()==castOther.getEjeNume())
 && (this.getDeoCodi()==castOther.getDeoCodi())
 && (this.getDelNumlin()==castOther.getDelNumlin());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getEjeNume();
         result = 37 * result + this.getDeoCodi();
         result = 37 * result + this.getDelNumlin();
         return result;
   }   


}


