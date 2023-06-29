/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.AdministradorDAO;
import dominio.Administrador;
import java.util.Scanner;

/**
 *
 * @author emma5
 */
public class prueba {
    public static void main(String[] args) {
        MenuPrincipal();
    }
    
    public static void MenuPrincipal(){
        Scanner sc = new Scanner(System.in);
        int us1;
        
        System.out.println("Bien-venido a WASK-E");
        System.out.println("-----------------------");
        System.out.println("¿A donde quieres ingresar? \n 1-Menu Admin ");
        while(!sc.hasNextInt())sc.next();
        us1 = sc.nextInt();        
        switch (us1) {
            case 1:
                MenuAdmin();
                break;

        }
    }
     public static void MenuAdmin(){
        Scanner sc = new Scanner(System.in);
        AdministradorDAO cd = new AdministradorDAO();
        Administrador cl = new Administrador();
        
        int us2;
        System.out.println("¿Que quieres hacer? \n 1-listar cliente \n 2-Actualizar un cliente \n 3-Eliminar a un cliente \n 4-Ver la lista de los clientes \n 5-Volver al menu principal");
        while(!sc.hasNextInt())sc.next();
        us2 = sc.nextInt();        
                switch (us2){
                    case 1: 
                        for(int j = 0; j < cd.listar().size(); j++){
                            System.out.println("ID: ");
                            System.out.println(cd.listar().get(j).getID_Administrador());
                            System.out.println("Nombre: ");
                            System.out.println(cd.listar().get(j).getNombre_Administrador());
                            System.out.println("Primer Apellido: ");
                            System.out.println(cd.listar().get(j).getApellidoPaterno_Administrador());
                            System.out.println("Segundo Apellido: ");
                            System.out.println(cd.listar().get(j).getApellidoMaterno_Administrador());
                            System.out.println("--------------------------------------------");
                        }
                        
                        System.out.println("¿Quieres volver al menu cliente?  \n1-si  \n2-no");
                        while(!sc.hasNextInt()) sc.next();
                        int us6 = sc.nextInt();
                        if(us6 == 1){
                            MenuAdmin();
                        }else{
                            System.exit(0);
                        }
                        break;
                    case 5:
                        MenuPrincipal();
                        break;
                }
    }
    
}

