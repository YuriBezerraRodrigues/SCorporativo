/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Apresentador;
import entidades.Categoria;
import entidades.Palestras;
import entidades.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import services.ApresentadorService;
import services.PalestrasService;
import services.UsuarioService;

/**
 *
 * @author katllynneramannda
 */
@ManagedBean(name = "palestrasBean")
@ViewScoped
public class PalestrasBean {
    
    private Palestras palestra;
    
    @EJB(name = "PalestrasService")
    private PalestrasService palestrasService;
    
    @EJB(name = "ApresentadorService")
    private ApresentadorService apresentadorService;        
    
    List<Apresentador> apresentadores;
    
    public PalestrasBean() {
        iniciarCampos();
    }
    
    public Palestras getPalestras() {
        return this.palestra;
    }
    
    public void salvar() {
        palestrasService.salvar(palestra);
        iniciarCampos();
        Mensagens.adicionarMessagem("Cadastro da Palestra realizado com sucesso!");

    }
    
    public void iniciarCampos() {
        this.palestra = new Palestras();
    }
    
    public List<Apresentador> getApresentadores() {
        if (this.apresentadores == null) {
            this.apresentadores = apresentadorService.getApresentadores();
        }

        return this.apresentadores;
    }
    
}
