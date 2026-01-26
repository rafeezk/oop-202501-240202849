
package com.upb.agripos.dao;
import com.upb.agripos.model.Product;
import java.sql.*;import java.util.*;
public class ProductDAO {
    private Connection conn() throws Exception{
        return DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/agripos","postgres","postgres");
    }
    public List<Product> findAll(){
        List<Product> l=new ArrayList<>();
        try(Connection c=conn()){
            ResultSet r=c.createStatement().executeQuery("select * from products");
            while(r.next())
                l.add(new Product(r.getString(1),r.getString(2),r.getDouble(3),r.getInt(4)));
        }catch(Exception e){e.printStackTrace();}
        return l;
    }
    public void delete(String code){
        try(Connection c=conn()){
            PreparedStatement p=c.prepareStatement("delete from products where code=?");
            p.setString(1,code);p.executeUpdate();
        }catch(Exception e){e.printStackTrace();}
    }
}
