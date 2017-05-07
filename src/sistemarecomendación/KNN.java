/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarecomendación;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author usuario
 */
public class KNN {
    
    public ArrayList<Movie> GenerarSugerencias(ArrayList<Integer> Gustados) throws SQLException
    {
        SQLConnection con = new SQLConnection();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Distancia distaux;
        ArrayList<Distancia> distancias = new ArrayList<Distancia>();
        //Iremos a traer los Ids de películas
        ArrayList<String> Ids = con.GetMovieIds(Gustados);
        //Por cada objeto en la lista de gustados vamos a sacar distancias
        for (int i = 0; i < Gustados.size(); i++) {
            Movie gustada = con.GenerarMovie(Gustados.get(i).toString());
            for (int j = 0; j < Ids.size(); j++) {
                //Si no es la película actual con la que se va a comparar
                if (!Ids.get(j).equals(Gustados.get(i).toString())) {
                    Movie sugerencia = con.GenerarMovie(Ids.get(j));
                    distaux = new Distancia();
                    distaux.IdOrigen = gustada.Id;
                    distaux.IdDestino = sugerencia.Id;
                    distaux.Distancia = Comparar(sugerencia, gustada);
                    //Criterio de desempate será a partir de la ponderación del destino
                    distaux.Ponderacion = sugerencia.Ponderacion;
                    distancias.add(distaux);
                }
            }
        }
        Collections.sort(distancias,(t, t1) -> {
            if (t.Distancia>t1.Distancia) {
                return 1;
            }
            else if(t.Distancia<t1.Distancia)
            {
                return -1;
            }
            else
            {
                if (t.Ponderacion>=t1.Ponderacion) {
                    return 1;
                }
            }
            return -1; //To change body of generated lambdas, choose Tools | Templates.
        });
        int i = 0;
        ArrayList<Integer> IdSugerencias = new ArrayList<Integer>();
        for (Distancia dis: distancias) {
            
            if (i<20) {
                if (!IdSugerencias.contains(dis.IdDestino)) {
                    IdSugerencias.add(dis.IdDestino);
                    movies.add(con.GenerarMovie(dis.IdDestino.toString()));
                    i++;
                }//Si es una que ya vio la agregamos pero la mostraríamos en otra tabla
                else if (Gustados.contains(dis.IdDestino)){
                    IdSugerencias.add(dis.IdDestino);
                    movies.add(con.GenerarMovie(dis.IdDestino.toString()));
                }    
            }
            else
            {
                break;
            }
        }
        return movies;
    }
    
    
    
    //Compara dos películas, una como sugerencia y otra que ya sabemos que le gustó
    public double Comparar(Movie sugerencia, Movie Gustado)
    {
        double Distancia = 0;
        double AuxDistancia;
        //Director
        String aux1 = sugerencia.Director.toLowerCase();
        String aux2 = Gustado.Director.toLowerCase();
        if (!(aux1.contains(aux2) || aux2.contains(aux1))) {
            AuxDistancia = Math.pow(1, 2);
            Distancia = Distancia + AuxDistancia;
        }
        //Año
        AuxDistancia = Math.abs(sugerencia.Anio - Gustado.Anio)/5;
        Distancia = Distancia + Math.pow(AuxDistancia,2);
        //Pais
        if (!sugerencia.Pais.equals(Gustado.Pais)) {
            AuxDistancia = Math.pow(1, 2);
            Distancia = Distancia + AuxDistancia;
        }
        //Idioma
        if (!sugerencia.Idioma.equals(Gustado.Idioma)) {
            AuxDistancia = Math.pow(1, 2);
            Distancia = Distancia + AuxDistancia;
        }
        //Clasificacion
        if (!sugerencia.Clasificacion.equals(Gustado.Clasificacion)) {
            AuxDistancia = Math.pow(1, 2);
            Distancia = Distancia + AuxDistancia;
        }
        //Actor
        for (int i = 0; i < sugerencia.Actores.size(); i++) {
            if (!Gustado.Actores.contains(sugerencia.Actores.get(i))) {
                AuxDistancia = Math.pow(1, 2);
                Distancia = Distancia + AuxDistancia;
            }
        }
        //Generos
        for (int i = 0; i < sugerencia.Generos.size(); i++) {
            if (!Gustado.Generos.contains(sugerencia.Generos.get(i))) {
                AuxDistancia = Math.pow(1, 2);
                Distancia = Distancia + AuxDistancia;
            }
        }
        return Math.sqrt(Distancia);
    }
}
