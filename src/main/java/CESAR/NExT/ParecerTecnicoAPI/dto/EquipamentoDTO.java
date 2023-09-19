package CESAR.NExT.ParecerTecnicoAPI.dto;
import CESAR.NExT.ParecerTecnicoAPI.entities.Equipamento;
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

public class EquipamentoDTO {

    @NotBlank
    @Size(min = 2, max = 100)
    private long id;
    @NotBlank
    @Size(min = 2, max = 100)
    private String tipo;
    @NotBlank
    @Size(min = 2, max = 100)
    private String defeito;
    @NotBlank
    @Size(min = 2, max = 100)
    private String parecer;

    public Equipamento toEntity() {
        return Equipamento.builder()
                .id(this.id)
                .tipo(this.tipo)
                .defeito(this.defeito)
                .parecer(this.parecer)
                .build();
    }

    public Equipamento toEntityUpdate(Equipamento equipamento) {
        return Equipamento.builder()
                .id(equipamento.getId())
                .tipo(this.tipo)
                .defeito(this.defeito)
                .parecer(this.parecer)
                .build();
    
}
}

//olá