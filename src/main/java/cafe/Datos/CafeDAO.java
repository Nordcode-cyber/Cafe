package cafe.Datos;

import cafe.conexion.Conexion;
import cafe.Dominio.Cafe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import static cafe.conexion.Conexion.getConexion;

public class CafeDAO implements IClienteDAO{
    
    public List<Cafe> listarProductos() {
        List<Cafe> cafes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        var sql = "SELECT * FROM cafe ORDER BY id_cafe";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                var cafe = new Cafe();
                cafe.setId_cafe(rs.getInt("id_cafe"));
                cafe.setTipo(rs.getString("tipo"));
                cafe.setMarca(rs.getString("marca"));
                cafe.setRegion(rs.getString("region"));
                cafe.setPeso(rs.getFloat("peso"));
                cafe.setTostado(rs.getString("tostado"));
                cafe.setPresentacion(rs.getString("presentacion"));
                cafe.setSecado(rs.getString("secado"));
                cafe.setCafeina(rs.getFloat("cafeina"));
                cafe.setNotas(rs.getString("notas"));
                cafes.add(cafe);
            }
        }catch (Exception e){
            System.out.println("Error al listar cafes: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return cafes;
    }

    @Override
    public boolean buscarCafePorId(Cafe cafe) {
        PreparedStatement ps;
        ResultSet rs;
        var con =getConexion();
        /*
         * filtrado por primary key
         * 
         * "SELECT * FROM cafe WHERE id_cafe= ?"
         */
        var sql ="SELECT * FROM cafe WHERE id_cafe= ?";
        try{
            ps= con.prepareStatement(sql);
            ps.setInt(1, cafe.getId_cafe());
            rs = ps.executeQuery();
            if(rs.next()){
                cafe.setTipo(rs.getString("tipo"));
                cafe.setMarca(rs.getString("marca"));
                cafe.setRegion(rs.getString("region"));
                cafe.setPeso(rs.getFloat("peso"));
                cafe.setTostado(rs.getString("tostado"));
                cafe.setPresentacion(rs.getString("presentacion"));
                cafe.setSecado(rs.getString("secado"));
                cafe.setCafeina(rs.getFloat("cafeina"));
                cafe.setNotas(rs.getString("notas"));
                return true;
            }
        }catch (Exception e){
            System.out.println("error al recuperar cafe por id: "+e.getMessage());
        }
        finally{
            try{
                con.close();
            }catch (Exception e){
                System.out.println("error al cerrar conexion");
            }
        }
        return false;
    }//fin metodo busquedacafePorId

    @Override
    public boolean agregarCafe(Cafe cafe) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "INSERT INTO cafe(tipo,marca,region,peso,tostado,presentacion,secado,cafeina,notas) " + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        //la cantidad de columnas debe ser la misma de VALUES(?)
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cafe.getTipo());
            ps.setString(2, cafe.getMarca());
            ps.setString(3, cafe.getRegion());
            ps.setFloat(4, cafe.getPeso());
            ps.setString(5, cafe.getTostado());
            ps.setString(6, cafe.getPresentacion());    
            ps.setString(7, cafe.getSecado());
            ps.setFloat(8, cafe.getCafeina());
            ps.setString(9, cafe.getNotas());
            ps.execute();
            return true;      
        } catch (Exception e) {
            //error al agregar cafe
            System.out.println("Error al agregar cafe");
        }
        finally{
            try {
                con.close();                
            } catch (Exception e) {
                 System.out.println("error al cerrar conexion");
            }
        }

        return false;
    }

    @Override
    public boolean modificarCafe(Cafe cafe) {
        PreparedStatement ps;
        Connection con = getConexion();
        var sql = "UPDATE cafe SET tipo=?, marca=?, region=?, peso=?, tostado=?, presentacion=?, secado=?, cafeina=?, notas=?  "+ " WHERE id_cafe= ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cafe.getTipo());
            ps.setString(2,cafe.getMarca());
            ps.setString(3, cafe.getRegion());
            ps.setFloat(4,cafe.getPeso());
            ps.setString(5, cafe.getTostado());
            ps.setString(6, cafe.getPresentacion());
            ps.setString(7, cafe.getSecado());
            ps.setFloat(8, cafe.getCafeina());
            ps.setString(9, cafe.getNotas());
            ps.setInt(10, cafe.getId_cafe());
            ps.execute();
            return true;
            
        } catch (Exception e) {
            System.out.println("Error al modificar cafe"+e.getMessage());
        }
        finally{
            try{
                con.close();
            }catch(Exception e){
                System.out.println("error al cerrar conexion" + e.getMessage());
            }

        }
        return false;
    }

   // @SuppressWarnings("rawtypes")
    //@Override
    public boolean eliminarCafe(Cafe cafe) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "DELETE FROM cafe WHERE id_cafe = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, cafe.getId_cafe());
            ps.execute();
            return true;
        }catch(Exception e){
            System.out.println("error al eliminar cafe"+ e.getMessage());
        }
        finally{
            try{
                con.close();
            }catch (Exception e){
                System.out.println("error al cerrar conexion"+ e.getMessage());
            }
        }

        return false;
    }
    //public static void main(String[] args) {
      //  IClienteDAO clienteDao = new ClienteDAO();
       //buscar por id
       //System.out.println("busqueda por id: ");
       //var cafe1 = new Cafe(19);
       //System.out.println("cliente antes de la busqueda: "+cliente1);
       // var encontrado = clienteDao.buscarClientePorId(cliente1);
       // if (encontrado)
         // System.out.println("cliente encontrado"+cliente1);
        //else
        // System.out.println("no se encontro cliente"+cliente1.getId());
      //agregar clientes 
      //System.out.println("agregar clientes");
        //var nuevocliente = new Cliente("guillermo","taskman",40143334,"pviaia",250,"marechal");
        //var agregado = clienteDao.agregarCliente(nuevocliente);
         //if(agregado)
        //System.out.println("Cliente agregado: "+nuevocliente);
        //else
       // System.out.println("no se agrego al cliente: "+nuevocliente);
        //listar clientes
      // System.out.println("****listar clientes****");
      // var clientes = clienteDao.listarClientes();
       //clientes.forEach(System.out::println);
        //modificar cliente
       // System.out.println("modificar cliente");
        //var modificarCliente = new Cliente(1, "luis","saporiti",2045712191, "mash", 140,"ceres");
        //var modificado = clienteDao.modificarCliente(modificarCliente);
      // if(modificado)
        //    System.out.println("Cliente modificado : " + modificarCliente);
       //else
         //   System.out.println("No se modifico cliente: " + modificarCliente);
       //eliminar cliente
     //  var clienteeliminar = new Cafe(19);
       //var eliminado = clienteDao.eliminarCliente(clienteeliminar);
       //if(eliminado)
         //   System.out.println("cliente eliminado: "+ clienteeliminar);
       //else
         // System.out.println("no se elimino el cliente"+clienteeliminar);
         // Listar clientes
        //System.out.println("*** Listar Clientes ***");
        //clientes.forEach(System.out::println);

    
    }



    

