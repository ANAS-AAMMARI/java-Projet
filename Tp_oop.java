package tp_oop;

import java.util.Scanner;




public class Tp_oop {
    static agence ag=new agence();
    // factorise le code methods ajouter
    public static void add(String login, String who)
    {
        if(login.equals("directeur"))
        {
            switch(who)
            {
                case "client":
                    ag.ajouterCl();
                    break;
                case "employe":
                    ag.ajouterEmp();
                    break;
                case "compte":
                    ag.ajouterCmp();
                    break;
            }
        }else if(login.equals("employe"))
        {
             switch(who)
            {
                case "client":
                    ag.ajouterCl();
                    break;
                case "compte":
                    ag.ajouterCmp();
                    break;
            }
        }
    }
    // factorise le code methods affiche
    public static void affiche(String login, String who)
    {
        if(login.equals("directeur"))
        {
            switch(who)
            {
                case "client":
                    ag.afficheCl();
                    break;
                case "employe":
                    ag.afficheEmp();
                    break;
                case "compte":
                    ag.afficheCmpt();
                    break;
            }
        }else if(login.equals("employe"))
        {
            switch(who)
            {
                case "client":
                    ag.afficheCl();
                    break;
                case "compte":
                    ag.afficheCmpt();
                    break;
            }
        }
    }
    // factorise le code methods supprimer
    public static void delete(String login,String who,int c)
    {
        if(login.equals("directeur"))
        {    
            switch(who)
            {
                case "client":
                    ag.supprimerCl(c);
                    break;
                case "employe":
                    ag.supprimerEmp(c);
                    break;
                case "compte":
                    ag.supprimerCmp(c);
                    break;
            }
        }else if(login.equals("employe"))
        {
            switch(who)
            {
                case "client":
                    ag.supprimerCl(c);
                    break;
                case "compte":
                    ag.supprimerCmp(c);
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
       
      // menu
      //agence ag=new agence();
      client cl = new client("qq", "tt", "vv", 2);
      client cl1 = new client("bb", "cc", "vv", 1);
      agence.arrCl.add(cl);
      agence.arrCl.add(cl1);
      compte cmp = new compte("epargne", 5, 10000, 2);
      compte cmp1 = new compte("courant", 4, 0, 2);
      compte cmp2 = new compte("epargne", 7, 20, 2);
      compte cmp3 = new compte("epargne", 1, 20000, 1);
      agence.arrCmp.add(cmp);
      agence.arrCmp.add(cmp1);
      agence.arrCmp.add(cmp2);
      agence.arrCmp.add(cmp3);
      employe em=new employe("rr", "aa", "xx", 77, "E1");
      ag.arrEmp.add(em);//*/
      String login;
        login = "";
      String qui="";
      String exit="";
      int code = 0;
      boolean test = false;
      directeur dr= new directeur("AAMMARI", "ANAS", "BenGuerir", 123, "directeur");
      Scanner sc= new Scanner(System.in);
    
      System.out.println("================================");
      System.out.println(String.format("|%18s","bounjour")+String.format("%13s", "|"));
      System.out.println("================================");
      
      //================================================LOGIN==================
      do{
         
          do{
              if(test)
                System.out.println("login ou mot de pass incorrect");
              test = true;
              System.out.println("log in or quitter (Q)?");
              if(sc.next().toLowerCase().equals("q"))
                return;
              System.out.println("login(prenom):");
              login = sc.next();
              System.out.println("password(code | numrero):");
              String s =sc.next();
              if(ag.isNumber(s))
              {
                code = Integer.parseInt(s);
                if(dr.getCode() == code && dr.getPrenom().equals(login))
                {
                    qui = "directeur";
                    test = false;
                }
                else {
                    for(client c:agence.arrCl)
                    {
                        /*if(c.getCode() != code || !c.getPrenom().equals(login))
                            test = true;//*/
                        if(c.getCode() == code && c.getPrenom().equals(login))
                        {
                            System.out.println(code+" "+login);
                            qui = "client";
                            test = false;
                        }
                    }
                    for (employe e : ag.arrEmp)
                    {
                        /*if(e.getCode() != code || !e.getPrenom().equals(login))
                            test = true;//*/
                        if(e.getCode() == code && e.getPrenom().equals(login))
                        {
                            qui = "employe";
                            test =false;
                        }
                    }
                }
              }else
              {
                test = true;
              }
            if(!qui.equals("employe") && !qui.equals("client") && !qui.equals("directeur"))
                test=true;
            //System.out.println("jjjjjjjjjjjj "+test+"   "+qui);
          }while(test);
          switch(qui)
          { 
            //===================================Directeur====================  
            case "directeur":
                String ch;
                do{
                    System.out.println(String.format("%s", "choisir qu'est que vous avez faire:"));
                    System.out.println("            +Ajouter");
                    System.out.println("            +Consulter");
                    System.out.println("            +Supprimer");
                    System.out.println("            +Q exit");
                    ch=sc.next().toLowerCase();
                    switch(ch)
                    {
                        case "ajouter":
                            do{
                                
                                System.out.println("   ajouter Employe");
                                System.out.println("   ajouter Client");
                                System.out.println("   ajouter Compte");
                                System.out.println("   Q quitter");
                                exit = sc.next().toLowerCase();
                                add("directeur", exit);
                            }while(!exit.equals("q"));
                            continue;
                        case "consulter":
                            do{
                                System.out.println("  consulter Employe");
                                System.out.println("  consulter Client");
                                System.out.println("  consulter Compte");
                                System.out.println("  tapez Q pour quitter");
                                exit =sc.next().toLowerCase();
                                if(exit.equals("q"))
                                    break;
                                affiche("directeur", exit);
                               // break;
                            }while(true);
                            break;
                        case "supprimer":
                            int cd = 0;
                            do{
                                System.out.println("  supprimer Employe");
                                System.out.println("  supprimer Client");
                                System.out.println("  supprimer Compte");
                                System.out.println("  tapez Q pour quitter");
                                exit = sc.next().toLowerCase();
                                do{
                                    System.out.println("tapez le code:");
                                    String s = sc.next();
                                    if(ag.isNumber(s))
                                    {
                                        cd = Integer.parseInt(s);
                                        break;
                                    }
                                }while(true);
                                delete("directeur", exit, cd);
                            }while(!exit.equals("q"));
                            break;
                    }
                }while(!ch.equals("q"));     
                //test = false;
                break;
            //===================================Employe====================
            case "employe":
                String sh;
                do{
                    System.out.println(String.format("%s", "choisir qu'est que vous avez faire:"));
                    System.out.println("            +Ajouter");
                    System.out.println("            +Consulter");
                    System.out.println("            +Supprimer");
                    System.out.println("            +Q exit");
                    sh=sc.next().toLowerCase();
                    switch(sh)
                    {
                        case "ajouter":
                           do{ //System.out.println("ajouter Employe");
                                System.out.println("ajouter Client");
                                System.out.println("ajouter Compte");
                                System.out.println("Q quitter");
                                exit = sc.next().toLowerCase();
                                add("employe", exit);
                            }while(!exit.equals("q"));
                            continue;
                        case "consulter":
                            do{
                                //System.out.println("consulter Employe");
                                System.out.println("consulter Client");
                                System.out.println("consulter Compte");
                                System.out.println("Q quitter");
                                exit =sc.next().toLowerCase();
                                if(exit.equals("q"))
                                    break;
                                affiche("employe", exit);
                            }while(true);
                            break;
                        case "supprimer":
                            int cd = 0;
                            do{
                                //System.out.println("supprimer Employe");
                                System.out.println("supprimer Client");
                                System.out.println("supprimer Compte");
                                System.out.println("Q quitter");
                                exit = sc.next().toLowerCase();
                                if(exit.equals("q"))
                                    break;
                                System.out.println("tapez le code:");
                                String s = sc.next();
                                if(ag.isNumber(s))
                                    cd = Integer.parseInt(s);
                                else
                                    continue;
                                delete("employe", exit, cd);
                            }while(true);
                            break;
                    }
                }while(!sh.equals("q"));   
                //test = false;
                break;
            //===================================Client====================    
            case "client":
                do{
                    System.out.println("consulter");
                    System.out.println("retire");
                    System.out.println("verser");
                    System.out.println("Q quitter");
                    exit = sc.next().toLowerCase();
                    switch(exit)
                    {
                        case "retire":
                            int num;float mont;
                            
                            for(client c:agence.arrCl)
                            {
                                if(c.getCode()==code)
                                {
                                    System.out.println("entrer num compte:");
                                    num = sc.nextInt();
                                    System.out.println("entrer montant:");
                                    mont = sc.nextFloat();
                                    System.out.println(c.retire(num, mont));
                                    break;
                                }
                            }
                            break;
                        case "verser":
                             int numC;float montant;
                            
                            for(client c:agence.arrCl)
                            {
                                if(c.getCode()==code)
                                {
                                    System.out.println("entrer num compte:");
                                    numC = sc.nextInt();
                                    System.out.println("entrer montant:");
                                    montant = sc.nextFloat();
                                    c.verser(numC, montant);
                                    break;
                                }
                            }
                            break;
                        case "consulter":
                            ag.afficheCmpt(code);
                            break;
                    }
                }while(!exit.equals("q"));
                //test = false;
                break;
          }
      }while(!qui.equals("q"));// while root
  
    }//end main
    
}
