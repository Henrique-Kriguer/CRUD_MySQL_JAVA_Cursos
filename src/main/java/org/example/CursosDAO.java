package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursosDAO {
    public List<Cursos>list(){

        List<Cursos> cursos = new ArrayList<>();

        try(Connection connection = ConnectionFactory.getConnection()){

            String sql = "SELECT * FROM cursos";

            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int duracao = rs.getInt("duracao");

                cursos.add(new Cursos(id,nome,duracao));
            }
        }catch(SQLException | IOException e){
            System.out.println("Erro ao listar os cursos");
            e.printStackTrace();
        }
    return cursos;
    }

    public Cursos getById(int id){

        Cursos curso = new Cursos();

        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "SELECT * FROM cursos WHERE ID = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setDuracao(rs.getInt("duracao"));
            }
        }catch (SQLException | IOException e){
            System.out.println("Falha ao listar cursos");
            e.printStackTrace();
        }
        return curso;
    }
}

