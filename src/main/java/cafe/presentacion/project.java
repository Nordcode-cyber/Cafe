package cafe.presentacion;

import java.util.Scanner;
import cafe.Datos.CafeDAO;
import cafe.Datos.IClienteDAO;
import cafe.Dominio.*;


public class project {
    public static void main(String[]args){
        proyectapp();
    }
    private static void proyectapp(){
        var salir = false;
        Scanner entra=new Scanner(System.in);
        //objeto de la clase cliente dao
        IClienteDAO cafeDao = new CafeDAO();
        while(!salir){
            try{
               var opcion = mostrarMenu(entra);
              salir = ejecutarOpciones(entra, opcion ,cafeDao);
           }catch(Exception e){
                System.out.println("error al ejecutar opciones: " + e.getMessage());
            }
            System.out.println();
        }
    }
    private static int mostrarMenu(Scanner entra){
        System.out.print("""
               ***productos (Cafe)
               1.- Listar productos
               2.- Buscar producto
               3.- Agregar producto
               4.- Modificar productos
               5.- Eliminar productos
               6.- Salir
               Elije una opcion:\s """);
        return Integer.parseInt(entra.nextLine());
    }
    private static boolean ejecutarOpciones(Scanner entra,int opcion, IClienteDAO cafeDao){
        var salir = false;
        switch (opcion) {
            case 1->{
                //listar cafe
                 System.out.println("listado de clientes");
                 var productos = cafeDao.listarProductos();
                 productos.forEach(System.out::println);
                 }
            case 2-> {
                //2.- buscar productos id 
                System.out.print("ingrese id de producto a buscar: ");
                var idCafe = Integer.parseInt(entra.nextLine());
                var cafe = new Cafe(idCafe);
                //Cafe id_Cafe;
                var encontrado = cafeDao.buscarCafePorId(cafe);
                if (encontrado)
                    System.out.println("producto encontrado "+ cafe);
                else
                    System.out.println("no se encontro el producto"+cafe);
            }
            /*
             *  int id_cafe;  
             * String tipo;
             * String marca;
             * String region;
             * float peso;
             * String tostado;
             * String presentacion;
             * String secado;
             * float cafeina;
             * String notas;
             */
            case 3->{
                //3 agregar producto
                System.out.println("---Agregar producto-----");
                System.out.print("tipo: ");
                var tipo = entra.nextLine();
                System.out.print("marca: ");
                var marca = entra.nextLine();
                System.out.print("region: ");
                var region = entra.nextLine();
                System.out.print("peso: ");
                var peso = Float.parseFloat(entra.nextLine());
                System.out.print("tostado: ");
                var tostado = entra.nextLine();
                System.out.print("presentacion: ");
                var presentacion = entra.nextLine();
                System.out.print("secado: ");
                var secado = entra.nextLine();
                System.out.print("cafeina:  ");
                var cafeina = Float.parseFloat(entra.nextLine());
                System.out.print("notas: ");
                final var notas = entra.nextLine();
                var cafe = new Cafe(tipo,marca,region,peso,tostado,presentacion,secado,cafeina,notas);
                var agregado = cafeDao.agregarCafe(cafe);
                if(agregado)
                    System.out.println("cliente agregado: "+cafe);
                else
                    System.out.println("cliente no agregado"+cafe);
            }
            case 4 ->{
                //modificar cliente
                System.out.println("---Modificar producto-----");
                System.out.print("id producto: ");
                var idCafe = Integer.parseInt(entra.nextLine());
                System.out.print("tipo: ");
                var tipo = entra.nextLine();
                System.out.print("marca: ");
                var marca = entra.nextLine();
                System.out.print("region: ");
                var region = entra.nextLine();
                System.out.print("peso: ");
                var peso = Integer.parseInt(entra.nextLine());
                System.out.print("tostado: ");
                var tostado = entra.nextLine();
                System.out.print("presentacion: ");
                var presentacion = entra.nextLine();
                System.out.print("secado: ");
                var secado = entra.nextLine();
                System.out.print("cafeina: ");
                var cafeina = Integer.parseInt(entra.nextLine());
                System.out.print("notas: ");
                var notas = entra.nextLine();
                //creamos el objeto
                var cafe = new Cafe(idCafe,tipo,marca,region,peso,tostado,presentacion,secado,cafeina,notas);
                
                var modificado = cafeDao.modificarCafe(cafe);
                if (modificado)
                    System.out.println("cliente modificado: "+ cafe);
                else
                    System.out.println("cliente no modificado: "+ cafe);
            }
            case 5->{
                //eliminar cliente
                System.out.println("---Eliminar producto-----");
                System.out.print("id Cafe: ");
                var idCafe= Integer.parseInt(entra.nextLine());
                var cafe = new Cafe(idCafe);
                var eliminado = cafeDao.eliminarCafe(cafe);
                if(eliminado)
                    System.out.println("producto eliminado: "+cafe);
                else
                    System.out.println("producto no eliminado: "+ cafe);  
            }
            case 6 ->{
                System.out.println("hasta pronto");
                salir = true;
            }
            default -> System.out.println("opcion no reconocida: "+opcion);
         }
         return salir;
        
        }

    }

  

    

