/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eventspace.json;

import com.mycompany.eventspace.entities.Espacio;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author adria
 */
@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class EspacioReader implements MessageBodyReader<Espacio> {

    @Override
    public boolean isReadable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return Espacio.class.isAssignableFrom(type);
    }

    @Override
    public Espacio readFrom(Class<Espacio> type,
            Type genericType,
            Annotation[] annotations,
            MediaType mediaType,
            MultivaluedMap<String, String> httpHeaders,
            InputStream entityStream)
            throws IOException, WebApplicationException {
        Espacio espacio = new Espacio();
        JsonParser parser = Json.createParser(entityStream);
        while (parser.hasNext()) {
            switch (parser.next()) {
                case KEY_NAME:
                    String key = parser.getString();
                    parser.next();
                    switch (key) {
                        case "ciudad":
                            espacio.setCiudad(parser.getString());
                            break;
                        case "direccion":
                            espacio.setDireccion(parser.getString());
                            break;
                        case "nombre":
                            espacio.setNombre(parser.getString());
                            break;
                        case "horarioini":
                            espacio.setHorarioini(parser.getString());
                            break;
                        case "horariofin":
                            espacio.setHorariofin(parser.getString());
                            break;
                        case "precio":
                            espacio.setPrecio((parser.getBigDecimal()));
                            break;
                        case "salones":
                            espacio.setSalones(parser.getInt());
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
        return espacio;
    }
    
}
