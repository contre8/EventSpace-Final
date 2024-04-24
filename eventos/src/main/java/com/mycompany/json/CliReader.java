/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.json;

import com.mycompany.entities.Cliente;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class CliReader implements MessageBodyReader<Cliente> {

    @Override
    public boolean isReadable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return Cliente.class.isAssignableFrom(type);
    }

    @Override
    public Cliente readFrom(Class<Cliente> type,
            Type genericType,
            Annotation[] annotations,
            MediaType mediaType,
            MultivaluedMap<String, String> httpHeaders,
            InputStream entityStream)
            throws IOException, WebApplicationException {
        Cliente cliente = new Cliente();
        JsonParser parser = Json.createParser(entityStream);
        while (parser.hasNext()) {
            switch (parser.next()) {
                case KEY_NAME:
                    String key = parser.getString();
                    parser.next();
                    switch (key) {
                        case "nombre":
                            cliente.setNombre(parser.getString());
                            break;
                        case "apellido":
                            cliente.setApellidos(parser.getString());
                            break;
                        case "email":
                            cliente.setEmail(parser.getString());
                            break;
                        case "password":
                            cliente.setPassword(parser.getString());
                            break;
                        case "dni":
                            cliente.setDni(parser.getString());
                            break;
                        case "fechanacimiento":
                            cliente.setFechanacimiento(parser.getString());
                            break;
                        case "telefono":
                            cliente.setTelefono(parser.getInt());
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
        return cliente;
    }

}
