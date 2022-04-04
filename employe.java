
package tp_oop;

public class employe extends client{
    
    protected String fonction;
    
    // set attributes
 
    public final void setFoction(String fonction)
    {
        this.fonction = fonction;
    }
  
    //===================================================
    
    // get attribute
    
   
    public String getFonction()
    {
        return this.fonction;
    }
    
    public employe(String n, String p, String v, int c , String f)
    {
        super(n, p, f, c);
        this.setFoction(v);
        
    }
}







