package CESAR.NExT.ParecerTecnicoAPI.entities;

import CESAR.NExT.ParecerTecnicoAPI.enumerator.Defeito;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParecerTecnico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String parecer;
    @Column(nullable = false)
    private Defeito defeito;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "parecerTecnico")
    private Cliente cliente;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "parecerTecnico")
    private Equipamento equipamento;

    //git clone Repositório
    //git status
    //git fetch
    //git pull
    //git checkout nomeDaSuaBranch

    //Nome Do Projeto
    //Breve Descrição
    //O que precisa para fazer o projeto rodar
    //-Dependência
    //-Aplicativo de terceiro: Postman / Imsomnia
    //Explicação mais profunda
    //-Como Funciona
    //-Tabelas / Entidades
    //Exemplo

    //Google "Como fazer um bom ReadME"
}
