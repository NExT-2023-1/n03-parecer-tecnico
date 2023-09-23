package CESAR.NExT.ParecerTecnicoAPI.dto;

import CESAR.NExT.ParecerTecnicoAPI.entities.Equipamento;
import CESAR.NExT.ParecerTecnicoAPI.enumerator.TipoEquipamento;
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
    private TipoEquipamento tipoEquipamento;

    public Equipamento toEntity() {
        return Equipamento.builder()
                .tipoEquipamento(this.tipoEquipamento)
                .build();
    }

    public Equipamento toEntityUpdate(Equipamento equipamento) {
        return Equipamento.builder()
                .id(equipamento.getId())
                .tipoEquipamento(this.tipoEquipamento)
                .build();
    }
}
