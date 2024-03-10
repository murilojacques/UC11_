/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class ProdutosDAO {
   
    Connection conn;
    PreparedStatement prep;
    ResultSet rs;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        try{
        conn = new conectaDAO().connectDB();
        prep = conn.prepareStatement("Insert Into produtos (nome, valor, status) values (?, ?, ?)");
        prep.setString(1, produto.getNome());
        prep.setInt(2, produto.getValor());
        prep.setString(3, produto.getStatus());
        prep.execute();
        JOptionPane.showMessageDialog(null,"Valores Gravados com Sucesso!");
        
        }catch(Exception e){}
    }
    
    public ArrayList<ProdutosDTO> listarProdutos() throws SQLException{
        try{
        String q = "SELECT id, nome, valor, status FROM produtos";
        conn = new conectaDAO().connectDB();
        prep = conn.prepareStatement(q);
        rs = prep.executeQuery();
        while (rs.next()){
            ProdutosDTO p = new ProdutosDTO();
             p.setId( rs.getInt("id"));
             p.setNome(rs.getString("nome"));
             p.setValor(rs.getInt("valor"));
             p.setStatus(rs.getString("status"));
             System.out.println(p);
             listagem.add(p);
  
        }
        }catch(SQLException e){
            throw e;
        }
       
        return listagem;
    }

    void venderProduto(int parseInt) throws SQLException {
        try{
        conn = new conectaDAO().connectDB();
        prep = conn.prepareStatement("UPDATE produtos SET status = 'Vendido' WHERE id = ?");
        prep.setInt(1, parseInt);
        prep.execute();
        JOptionPane.showMessageDialog(null,"Objeto Vendido com Sucesso!");
        }catch(SQLException e){
            throw e;
        }
    }
    
    
<<<<<<< HEAD
    public ArrayList<ProdutosDTO> listarProdutosVendidos() throws SQLException{
        try{
        String q = "SELECT id, nome, valor, status FROM produtos WHERE status = 'Vendido'";
        conn = new conectaDAO().connectDB();
        prep = conn.prepareStatement(q);
        rs = prep.executeQuery();
        while (rs.next()){
            ProdutosDTO p = new ProdutosDTO();
             p.setId( rs.getInt("id"));
             p.setNome(rs.getString("nome"));
             p.setValor(rs.getInt("valor"));
             p.setStatus(rs.getString("status"));
             System.out.println(p);
             listagem.add(p);
  
        }
        }catch(SQLException e){
            throw e;
        }
       
        return listagem;
    }
=======
   
>>>>>>> 84c3a369811a9087356ae30e0bcaab73d64b9c5d
        
}

