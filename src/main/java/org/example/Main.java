package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        CursosDAO cursosDAO = new CursosDAO();

        // -------- CONSULTA ------------------------------
        //List<Cursos> cursos = cursosDAO.list();

        //cursos.stream().forEach(System.out::println);

        //---------- CONSULTA COM FILTRO ------------------

        Cursos cursoPConsulta = cursosDAO.getById(2);
        System.out.println(cursoPConsulta);
    }
}