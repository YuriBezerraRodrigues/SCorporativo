package entidades;

import entidades.Apresentador;
import entidades.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-11T12:16:00")
@StaticMetamodel(Palestras.class)
public class Palestras_ extends Entidade_ {

    public static volatile SingularAttribute<Palestras, String> titulo;
    public static volatile SingularAttribute<Palestras, Date> horario;
    public static volatile SingularAttribute<Palestras, Double> valor;
    public static volatile SingularAttribute<Palestras, Apresentador> idpalestrasApresentador;
    public static volatile SingularAttribute<Palestras, Date> datapalestra;
    public static volatile SingularAttribute<Palestras, Usuario> idpalestrasUsuario;

}