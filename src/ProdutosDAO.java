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
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        try{
        conn = new conectaDAO().connectDB();
        prep = conn.prepareStatement("Insert Into produtos (nome, valor, status) values (?, ?, ?)");
        prep.setString(1, produto.getNome());
        prep.setInt(2, produto.getValor());
        prep.setString(3, produto.getStatus());
        prep.execute();
        JOptionPane.showMessageDialog(null,"Valores Gravados com sucesso!");
        
        }catch(Exception e){}
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

