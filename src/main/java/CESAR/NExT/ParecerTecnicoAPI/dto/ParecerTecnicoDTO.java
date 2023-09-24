package CESAR.NExT.ParecerTecnicoAPI.dto;

import CESAR.NExT.ParecerTecnicoAPI.entities.Cliente;
import CESAR.NExT.ParecerTecnicoAPI.entities.Equipamento;
import CESAR.NExT.ParecerTecnicoAPI.entities.ParecerTecnico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParecerTecnicoDTO {
    
    @NotBlank
    @Size(min = 2, max = 100)
    private String parecer;
    @NotBlank
    private String defeito;
    @NotNull
    private long cliente_id;
    @NotNull
    private long equipamento_id;

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
            .cliente(cliente)
            .equipamento(equipamento)
            .build();
    }
}