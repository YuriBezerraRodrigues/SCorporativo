package entidades;

import entidades.Palestras;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-11T12:16:00")
@StaticMetamodel(Apresentador.class)
public class Apresentador_ extends Entidade_ {

    public static volatile SingularAttribute<Apresentador, String> email;
    public static volatile SingularAttribute<Apresentador, String> nome;
    public static volatile SingularAttribute<Apresentador, String> especialidade;
    public static volatile CollectionAttribute<Apresentador, Palestras> palestrasCollection;

}