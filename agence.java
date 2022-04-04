
package tp_oop;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class agence {
   
    public ArrayList<employe> arrEmp = new ArrayList<>();
    public static ArrayList<client> arrCl = new ArrayList<>();
    public static ArrayList<compte> arrCmp = new ArrayList<>();
    public static int sumRetireParJour;
    public static int numCl;

    public static Calendar c = Calendar.getInstance();
    Scanner sc = new Scanner(System.in);
    
    // method consulter Employe
    public void afficheEmp()
    {
        System.out.println("==========================================");
        if(arrEmp.isEmpty())
        {
            System.out.println("aucune client a affiche");
            return;
        }
        arrEmp.forEach((emp) -> {
            System.out.println("Nom: "+emp.getNom()+"\nPrenom: "+emp.getPrenom()+
                    "\nFonction: "+emp.getFonction()+
                    "\nCode: "+emp.getCode());
        });
        System.out.println("==========================================");
    }
    public void afficheCl()
    {
        System.out.println("==========================================");
        if(arrCl.isEmpty())
        {
            System.out.println("aucune client a affiche");
            return;
        }
        arrCl.forEach((cl) ->{
            System.out.println("Nom: "+cl.getNom()+"\nPrenom: "+cl.getPrenom()+
                    "\nVille: "+cl.getVille()+
                    "\nCode: "+cl.getCode()+
                    "\nnobre de comte: "+cl.nbrCompte);
            System.out.println("==========================================");
        });
        //System.out.println("==========================================");
    }
    
    // method consulter compte
    public void afficheCmpt()
    {
        System.out.println("==========================================");
        if(arrCmp.isEmpty())
        {
            System.out.println("aucune client a affiche");
            return;
        }
        arrCmp.forEach((cmpt) ->{
            System.out.println("Type: "+cmpt.getType()+"\nNumere Compte: "+cmpt.getNum()+
                    "\nSolde: "+cmpt.getSolde()+"\nCode Client:"+cmpt.getCodeClient());
            System.out.println("==========================================");
        });
        
    }
    boolean tst= false;
    public void afficheCmpt(int codeClient)
    {
        System.out.println("==========================================");
        arrCmp.forEach((cmpt) -> {
            if(cmpt.getCodeClient() == codeClient)
            {   
                System.out.println("Type: "+cmpt.getType()+"\nNumere Compte: "+cmpt.getNum()+
                        "\nSolde: "+cmpt.getSolde()+"\nCode Client:"+cmpt.getCodeClient());
                System.out.println("==========================================");
            }
            else
                tst = true;
        });
        if(!tst)
            System.out.println(" aucun coupte pour ce client");
    }
    
    // method ajouter employe
    public void ajouterEmp()
    {
        int c = 0;
        boolean test;
        do{
            test = false;
            System.out.println("entrer le code:"); 
            String s = sc.nextLine();
            if(isNumber(s))
                c = Integer.parseInt(s);
            else
                test = true;
            for(int i=0; i<arrEmp.size(); i++)
            {
                if(arrEmp.get(i).code == c)
                    test=true;
            }
        }while(test);
        System.out.println("entrer le nom:");
        String n = sc.nextLine();
       
        System.out.println("entrer le prenom:");
        String p = sc.nextLine();
        
        System.out.println("entrer la ville:");
        String v = sc.nextLine();
       
      
        
        System.out.println("entrer la fonction :");
        String f = sc.nextLine();
        employe emp =  new employe(n, p, v, c, f);
        
       
        if(arrEmp.contains(emp))
            System.out.println("cette employe deja exist :)");
        else {
            arrEmp.add(emp);
        }
    }
    
    // method ajouter compte
   public void ajouterCmp()
    {
        int c = 0;
        int codeCl = 0;
        float s = 0;
        String n ="";
        boolean test;
        do{
            test = false;
            System.out.println("entrer le numero de compte:");
            String str =sc.nextLine();
            if(isNumber(str))
                c = Integer.parseInt(str);
            else
            {
                test = true;
                continue;
            }
            for(int i=0; i<arrCmp.size(); i++)
            {
                if(arrCmp.get(i).getNum() == c)
                    test=true;
            }
            do{
                System.out.println("entrer le Type de compte:");
                n = sc.nextLine();
            }while(!n.equals("courant") && !n.equals("epargne"));
        
        
            System.out.println("entrer solde:");
            str= sc.nextLine();
            if(isNumber(str)){
                s = Float.parseFloat(str);
            }
            else
            {
                test = true;
                continue;
            }
        
            System.out.println("entrer Code client:");
            str =sc.nextLine();
            if(isNumber(str))
            {
                codeCl = Integer.parseInt(str);
                for(client cl:agence.arrCl)
                {
                    if(cl.getCode() != codeCl || cl.nbrCompte == 3)
                        test=true;
                    else
                    {
                        test=false;
                        break;
                    }
                }
            }
            else
                test = true;  
        }while(test);
        
       
        compte cmp = new compte(n, c, s, codeCl);
        if(arrCmp.contains(cmp))
            System.out.println("cette employe deja exist :)");
        else {
            arrCmp.add(cmp);
        }
    }
   // methode ajouter Client
      public void ajouterCl()
    {
        int c = 0;
        boolean test = false;
        String str;
        String n ="",p="",v="";
        do{
            System.out.println("entrer code client:");
            str = sc.nextLine();
            if(isNumber(str))
                c = Integer.parseInt(str);
            else
            {
                test = true;
                continue;
            }
            for(int i=0; i<arrCl.size(); i++)
            {
                if(arrCl.get(i).getCode() == c)
                    test=true;
            }
            System.out.println("entrer le nom de client:");
            n = sc.nextLine();
            System.out.println("entrer le prenom:");
            p= sc.nextLine();
        
            System.out.println("entrer ville:");
            v = sc.nextLine();
        }while(test);

        client cl=new client(n, p, v, c);
        if(arrCl.contains(cl))
            System.out.println("cette employe deja exist :)");
        else {
            arrCl.add(cl);
        }
    }
    
    // method supprimer employe
    public void supprimerEmp(int c)
    {
        if(arrEmp.isEmpty())
        {
            System.out.println("no Employe pour supprimer");
            return;
        }
        for(int i=0;i<arrEmp.size();i++)
        {
            if(arrEmp.get(i).getCode() == c)
            {
                arrEmp.remove(i);
                return;
            }
        }
        System.out.println("employe n'exist pas");
    }
    
    // methode supprimer compte 
    public void supprimerCmp(int c)
    {
        if(arrCmp.isEmpty())
        {
            System.out.println("no compte pour supprimer");
            return;
        }
        for(int i=0;i<arrCmp.size();i++)
        {
            if(arrCmp.get(i).getNum() == c)
            {
                for(int j = 0;j<arrCl.size();j++)
                {
                    if(arrCl.get(j).getCode() == arrCmp.get(i).getCodeClient() && arrCl.get(j).getNbrCompte() == 1)
                        arrCl.remove(j);
                }//*/
                //System.out.println("hhhhh "+i);
                arrCmp.remove(i);
                return;
            }
        }
        System.out.println("compte n'exist pas");
    }
    
    // method supprimer client
     public void supprimerCl(int c)
    {
        if(arrCl.isEmpty())
        {
            System.out.println("no client pour supprimer");
            return;
        }
        for(int i=0;i<arrCl.size();i++)
        {
            if(arrCl.get(i).code == c)
            {
                for(int j=arrCmp.size()-1;j>=0;j--)
                {
                    if(arrCmp.get(j).getCodeClient() == c)
                        arrCmp.remove(j);
                }
                //System.out.println(arrCmp.size());
                arrCl.remove(i);
                return;
            }
        }
        System.out.println("client n'exist pas");
    }
    
    // method helper 
    public boolean isNumber(String s)
     {
         for(char c:s.toCharArray())
         {
             if(!Character.isDigit(c))
                 return false;
         }
         return true;
     }
}
