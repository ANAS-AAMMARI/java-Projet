package tp_oop;

import java.util.Calendar;


public class client {
   // attributes
    
   protected String nom;
   protected String prenom;
   protected String ville;
   protected int code;
   protected int nbrCompte = 0;
   // =======================================
   // propriete set
   public final void setNbrCopmpte(int nbrCmpt)
   {
       this.nbrCompte += nbrCmpt;
   }
   public final void setNom(String nom)
   {
       this.nom = nom;
   }
   public final void setPrenom(String prenom)
   {
       this.prenom = prenom;
   }
   
   public final void setVille(String ville)
   {
       this.ville = ville;
   }
   public final void setCode(int code)
   {
       this.code = code;
   }
   
   // =======================================
   // propriete get
   
   public String getNom()
   {
       return this.nom;
   }
   public String getPrenom()
   {
       return this.prenom;
   }
   
   public String getVille()
   {
       return this.ville;
   }
   public int getCode()
   {
       return this.code;
   }
   public int getNbrCompte()
   {
       return this.nbrCompte;
   }
   // ===================================================
   public client(String n, String p, String v, int c)
   {
       this.setCode(c);
       this.setNom(n);
       this.setPrenom(p);
       this.setVille(v);
   }
   
   // method verser
   compte cmt;
   public void verser(int num, float montant)
   {   
       agence.arrCmp.forEach((com) -> {
           if(com.getNum() == num)
               cmt =com;
           else
               System.out.println("compte entrer incorrect");
       });
       if(montant > 0 && agence.arrCmp.contains(cmt))
       {
           cmt.setSolde(montant + cmt.getSolde());
           System.out.println("versement termine avec succes");
       }
        else
           System.out.println("impossible de verser cette montant!");
   }
   // method retire
   public String retire(int numCmp, float mont)
   {
       //compte cmt=new compte();
       boolean  tst = false;
       int i;
       for(i=0;i< agence.arrCmp.size();i++)
       {
            tst = false;
           if(agence.arrCmp.get(i).getNum() == numCmp)
               break;

           else
               tst = true;
       }
       if(tst)
           return "compte entrer incorrect";
       if(agence.arrCmp.get(i).getSolde() > 0 && mont > 0 && mont < agence.arrCmp.get(i).getSolde() && this.code == agence.arrCmp.get(i).getCodeClient())
       {
           if(agence.arrCmp.get(i).getType().equals("courant"))
           {
                agence.arrCmp.get(i).setSolde(agence.arrCmp.get(i).getSolde() - mont);
                return ""+ mont; 
           }
           else if(agence.arrCmp.get(i).getType().equals("epargne"))
           {   
               if((agence.c.get(Calendar.HOUR_OF_DAY) + 1) == 1 || (agence.numCl != agence.arrCmp.get(i).getCodeClient() && agence.numCl !=0))
                   agence.sumRetireParJour = 0;
               agence.sumRetireParJour += mont;
               agence.numCl = agence.arrCmp.get(i).getCodeClient();
               //Date dt = new Date();
               if(mont <= 4000 && agence.sumRetireParJour <= 4000 && (agence.c.get(Calendar.HOUR_OF_DAY) + 1) != 1)
               {
                   agence.arrCmp.get(i).setSolde(agence.arrCmp.get(i).getSolde() - mont);
                   return ""+ mont;
               }
               else
                   return "montant entrer depassi le solde authori par jour";
                
           }
       }
       return "montant donne invalide";
   }
}



