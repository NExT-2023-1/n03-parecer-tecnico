package CESAR.NExT.ParecerTecnicoAPI.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import CESAR.NExT.ParecerTecnicoAPI.enumerator.TipoEquipamento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Equipamento {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private TipoEquipamento tipoEquipamento;
    @JoinColumn(name = "parecerTecnico_id", nullable = false)
    @JsonBackReference
    private ParecerTecnico parecerTecnico;
}
