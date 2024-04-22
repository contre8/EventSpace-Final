package com.mycompany.entities;

import com.mycompany.entities.Espacio;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-04-22T21:03:31")
@StaticMetamodel(Propietario.class)
public class Propietario_ { 

    public static volatile SingularAttribute<Propietario, String> cif;
    public static volatile SingularAttribute<Propietario, String> password;
    public static volatile CollectionAttribute<Propietario, Espacio> espacioCollection;
    public static volatile SingularAttribute<Propietario, Boolean> autorizado;
    public static volatile SingularAttribute<Propietario, String> nombreespacio;
    public static volatile SingularAttribute<Propietario, Integer> telefono;
    public static volatile SingularAttribute<Propietario, String> email;
    public static volatile SingularAttribute<Propietario, String> domiciliosocial;

}