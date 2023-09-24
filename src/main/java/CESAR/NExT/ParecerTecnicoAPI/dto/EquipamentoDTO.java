package CESAR.NExT.ParecerTecnicoAPI.dto;

import CESAR.NExT.ParecerTecnicoAPI.entities.Equipamento;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipamentoDTO {
    
    @NotBlank
    private String tipo;

    public Equipamento toEntity() {
        return Equipamento.builder()
                .tipo(this.tipo)
                .build();
    }

    public Equipamento toEntityUpdate(Equipamento equipamento) {
        return Equipamento.builder()
                .id(equipamento.getId())
                .tipo(this.tipo)
                .build();
    }
}
