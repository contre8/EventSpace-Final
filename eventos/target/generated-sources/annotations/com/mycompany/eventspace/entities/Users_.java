package com.mycompany.eventspace.entities;

import com.mycompany.eventspace.entities.Espacio;
import com.mycompany.eventspace.entities.ReservarEspacio;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-04-28T01:38:09")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> apellidos;
    public static volatile SingularAttribute<Users, String> espacio;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> domicilio;
    public static volatile CollectionAttribute<Users, Espacio> espacioCollection;
    public static volatile SingularAttribute<Users, Boolean> autorizado;
    public static volatile CollectionAttribute<Users, ReservarEspacio> reservarEspacioCollection;
    public static volatile SingularAttribute<Users, Integer> telefono;
    public static volatile SingularAttribute<Users, String> nombre;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> dni;
    public static volatile SingularAttribute<Users, Date> nacimiento;

}