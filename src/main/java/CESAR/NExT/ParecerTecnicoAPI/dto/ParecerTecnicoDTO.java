package CESAR.NExT.ParecerTecnicoAPI.dto;

import CESAR.NExT.ParecerTecnicoAPI.entities.Cliente;
import CESAR.NExT.ParecerTecnicoAPI.entities.Equipamento;
import CESAR.NExT.ParecerTecnicoAPI.entities.ParecerTecnico;
import CESAR.NExT.ParecerTecnicoAPI.enumerator.Defeito;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParecerTecnicoDTO {
    
    @NotBlank
    @Size(min = 2, max = 100)
    private String parecer;
    @NotBlank
    private Defeito defeito;

    public ParecerTecnico toEntity(Cliente cliente, Equipamento equipamento) {
        return ParecerTecnico.builder()
            .parecer(this.parecer)
            .defeito(this.defeito)
            .cliente(cliente)
            .equipamento(equipamento)
            .build();
        }
    
    public ParecerTecnico toEntityUpdate(ParecerTecnico parecerTecnico, Cliente cliente, Equipamento equipamento) {
        return ParecerTecnico.builder()
            .id(parecerTecnico.getId())
            .parecer(this.parecer)
            .defeito(this.defeito)
            .cliente(parecerTecnico.getCliente())
            .equipamento(parecerTecnico.getEquipamento())
            .build();
    }
}