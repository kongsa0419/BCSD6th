package repository;

import dto.Product;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//@EnableAspectJAutoProxy //오토프록싱
@Repository
public class ProductRepositoryImpl implements ProductRepository {

// application.properties 쓰고싶었는데 못썼음...
    private String driverClassName = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/temp?characterEncoding=UTF-8&serverTimezone=UTC";
    private String username = "root";
    private String password = "PASS";

    private Connection conn = null; //자바와 데이터베이스를 연결
    private PreparedStatement pstmt = null; //쿼리문 대기 및 설정
    private ResultSet rs = null; //결과값 받아오기
    String sql= null;


    //기본 생성자
    //ProductRepositoryImpl 가 실행되면 자동으로 생성되는 부분
    //메소드마다 반복되는 코드를 이곳에 넣으면 코드가 간소화된다
    public ProductRepositoryImpl(){
        //need Exception throwing
        try {
            Class.forName(this.driverClassName);
            if(conn == null)//맞나..?
                conn = DriverManager.getConnection(this.url, this.username, this.password);
                //이제 쿼리별로 메서드 만들어서 pstmt(sql) 실행, ResultSet 으로 받기
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkConnectivity(){
        if(conn != null){return true;}
        else {return false;}
    }

    @Override
    public List<Product> getProducts() {
        List<Product> list = new ArrayList<>();

        try {
            sql = "select * from product";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Product pd = new Product();
                pd.setId(rs.getInt("id"));
                pd.setName(rs.getString("name"));
                pd.setPrice(rs.getFloat("price"));
                pd.setCountryCode(rs.getString("countryCode"));
                list.add(pd);
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public Product getProductById(int id) {
        Product pd = new Product();
        sql = "select * from product where id = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(id));
            rs = pstmt.executeQuery();
            while(rs.next()){
                pd.setId(rs.getInt("id"));
                pd.setName(rs.getString("name"));
                pd.setPrice(rs.getFloat("price"));
                pd.setCountryCode(rs.getString("countryCode"));
            }
            rs.close();
            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return pd;
    }

    @Override
    public void update(Product product) {
        sql = "update product set name=?, price =?, countryCode =? where id = ?";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,String.valueOf(product.getName()));
            pstmt.setString(2,String.valueOf(product.getPrice()));
            pstmt.setString(3,String.valueOf(product.getCountryCode()));
            pstmt.setString(4,String.valueOf(product.getId()));
            pstmt.executeUpdate();

            pstmt.close();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        sql = "delete from product where id = ?";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,String.valueOf(id));
            pstmt.executeUpdate();

            pstmt.close();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    @Override
    public void save(Product p) {
        sql = "insert into product (name, price, countryCode) values (?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, p.getName());
            pstmt.setString(2, String.valueOf(p.getPrice()));
            pstmt.setString(3, p.getCountryCode());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }




}
