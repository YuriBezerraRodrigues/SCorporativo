/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Palestras;
import entidades.Usuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import services.PalestrasService;
import services.UsuarioService;

/**
 *
 * @author katllynneramannda
 */
@ManagedBean(name = "palestrasBean")
@ViewScoped
public class PalestrasBean implements Serializable{
    
    private Palestras palestra;
    
    @EJB(name = "PalestrasService")
    private PalestrasService palestrasService;
    
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
    
}
