
package tp_oop;

public class compte {
  
    // attributes compte
    private String type;
    private int num;
    private float solde;
    private int codeClient;
    // setter
    public final void setNum(int num)
    {
        this.num = num;
    }
    public final void setType(String t)
    {
        if(t.equals("courant") || t.equals("epargne"))
            this.type = t;
        else
            System.out.println("le type ecrite invalide");
    }
    public final void setSolde(float s)
    {
        if(s >= 0)
            this.solde = s;
        else
            System.out.println("solde entrer invalide!");
    }
    public final void setCodeClient(int codeC)
    {
        //agence ag=new agence();
        for(int i=0;i < agence.arrCl.size();i++)
        {
            
            if(agence.arrCl.get(i).getCode() == codeC)
            {
                this.codeClient = codeC;
                agence.arrCl.get(i).setNbrCopmpte(1);
                return;
            }  
        }
        System.out.println("donne incorrect");
    }
    
    // getter
    public String getType()
    {
        return this.type;
    }
    public int getNum()
    {
        return this.num;
    }
    public float getSolde()
    {
        return this.solde;
    }
    public int getCodeClient()
    {
        return this.codeClient;
    }
    
    //
    public compte(){}
    
    // constructor avec argument
    public compte(String t, int n, float s , int codeCl)
    {
        this.setNum(n);
        this.setType(t);
        this.setSolde(s);
        this.setCodeClient(codeCl);
    }
}
